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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPortlet;
import net.ibizsys.pscore.srv.config.entity.PSPortletBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysPortletDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysPortletDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPortletServiceBase
extends PSCoreSysServiceBase<PSSysPortlet> {
    private static final Log log = LogFactory.getLog(PSSysPortletServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysPortletDEModel pSSysPortletDEModel;
    private PSSysPortletDAO pSSysPortletDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService";
    }

    public PSSysPortletDEModel getPSSysPortletDEModel() {
        if (this.pSSysPortletDEModel == null) {
            try {
                this.pSSysPortletDEModel = (PSSysPortletDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysPortletDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPortletDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysPortletDEModel();
    }

    public PSSysPortletDAO getPSSysPortletDAO() {
        if (this.pSSysPortletDAO == null) {
            try {
                this.pSSysPortletDAO = (PSSysPortletDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysPortletDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPortletDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysPortletDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
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

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysPortlet pSSysPortlet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSSysPortlet, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppMenu);
            } else {
                iService.get(pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSSysPortlet, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSSysPortlet, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysPortlet, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEChart);
            } else {
                iService.get(pSDEChart);
            }
            this.onFillParentInfo_PSDEChart(pSSysPortlet, pSDEChart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEDATASET_FILTERPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_FilterPSDEDS(pSSysPortlet, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSSysPortlet, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEDATAVIEW_PSDEDATAVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService", (SessionFactory)this.getSessionFactory());
            PSDEDataView pSDEDataView = (PSDEDataView)iService.getDEModel().createEntity();
            pSDEDataView.set("PSDEDATAVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataView);
            } else {
                iService.get(pSDEDataView);
            }
            this.onFillParentInfo_PSDEDataView(pSSysPortlet, pSDEDataView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSSysPortlet, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDELIST_PSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEList);
            } else {
                iService.get(pSDEList);
            }
            this.onFillParentInfo_PSDEList(pSSysPortlet, pSDEList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_ADPSDElogic(pSSysPortlet, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEREPORT_PSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEReport);
            } else {
                iService.get(pSDEReport);
            }
            this.onFillParentInfo_PSDEReport(pSSysPortlet, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSSysPortlet, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSSysPortlet, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSDEVIEWBASE_PSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEView(pSSysPortlet, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSSysPortlet, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(pSSysPortlet, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysPortlet, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSPORTLET_PSPORTLETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPortletService", (SessionFactory)this.getSessionFactory());
            PSPortlet pSPortlet = (PSPortlet)iService.getDEModel().createEntity();
            pSPortlet.set("PSPORTLETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPortlet);
            } else {
                iService.get(pSPortlet);
            }
            this.onFillParentInfo_PSPortlet(pSSysPortlet, pSPortlet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysPortlet, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCalendar);
            } else {
                iService.get(pSSysCalendar);
            }
            this.onFillParentInfo_PSSysCalendar(pSSysPortlet, pSSysCalendar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysPortlet, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysPortlet, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSMAPVIEW_PSSYSMAPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService", (SessionFactory)this.getSessionFactory());
            PSSysMapView pSSysMapView = (PSSysMapView)iService.getDEModel().createEntity();
            pSSysMapView.set("PSSYSMAPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMapView);
            } else {
                iService.get(pSSysMapView);
            }
            this.onFillParentInfo_PSSysMapView(pSSysPortlet, pSSysMapView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysPortlet, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSPFPLUGIN_TITLEPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_TitlePSSysPFPlugin(pSSysPortlet, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSPORTLETCAT_PSSYSPORTLETCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService", (SessionFactory)this.getSessionFactory());
            PSSysPortletCat pSSysPortletCat = (PSSysPortletCat)iService.getDEModel().createEntity();
            pSSysPortletCat.set("PSSYSPORTLETCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPortletCat);
            } else {
                iService.get(pSSysPortletCat);
            }
            this.onFillParentInfo_PSSysPortletCat(pSSysPortlet, pSSysPortletCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysPortlet, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysPortlet, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSSysPortlet, pSSysUniRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPORTLET_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysPortlet, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSSysPortlet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSSysPortlet pSSysPortlet, PSACHandler pSACHandler) throws Exception {
        pSSysPortlet.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSSysPortlet.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSAppMenu(PSSysPortlet pSSysPortlet, PSAppMenu pSAppMenu) throws Exception {
        pSSysPortlet.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSSysPortlet.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_PSAppView(PSSysPortlet pSSysPortlet, PSAppView pSAppView) throws Exception {
        pSSysPortlet.setPSAppViewId(pSAppView.getPSAppViewId());
        pSSysPortlet.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSDE(PSSysPortlet pSSysPortlet, PSDataEntity pSDataEntity) throws Exception {
        pSSysPortlet.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysPortlet.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSModule() != null) {
            this.onFillParentInfo_PSModule(pSSysPortlet, pSDataEntity.getPSModule());
        }
    }

    protected void onFillParentInfo_PSDEChart(PSSysPortlet pSSysPortlet, PSDEChart pSDEChart) throws Exception {
        pSSysPortlet.setPSDEChartId(pSDEChart.getPSDEChartId());
        pSSysPortlet.setPSDEChartName(pSDEChart.getPSDEChartName());
    }

    protected void onFillParentInfo_FilterPSDEDS(PSSysPortlet pSSysPortlet, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysPortlet.setFilterPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysPortlet.setFilterPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDS(PSSysPortlet pSSysPortlet, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysPortlet.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSSysPortlet.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataView(PSSysPortlet pSSysPortlet, PSDEDataView pSDEDataView) throws Exception {
        pSSysPortlet.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
        pSSysPortlet.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
    }

    protected void onFillParentInfo_PSDEForm(PSSysPortlet pSSysPortlet, PSDEForm pSDEForm) throws Exception {
        pSSysPortlet.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSSysPortlet.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEList(PSSysPortlet pSSysPortlet, PSDEList pSDEList) throws Exception {
        pSSysPortlet.setPSDEListId(pSDEList.getPSDEListId());
        pSSysPortlet.setPSDEListName(pSDEList.getPSDEListName());
    }

    protected void onFillParentInfo_ADPSDElogic(PSSysPortlet pSSysPortlet, PSDELogic pSDELogic) throws Exception {
        pSSysPortlet.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysPortlet.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEReport(PSSysPortlet pSSysPortlet, PSDEReport pSDEReport) throws Exception {
        pSSysPortlet.setPSDEReportId(pSDEReport.getPSDEReportId());
        pSSysPortlet.setPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSSysPortlet pSSysPortlet, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysPortlet.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysPortlet.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSSysPortlet pSSysPortlet, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSSysPortlet.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSSysPortlet.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEView(PSSysPortlet pSSysPortlet, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysPortlet.setPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysPortlet.setPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSSysPortlet pSSysPortlet, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysPortlet.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysPortlet.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TitlePSLanRes(PSSysPortlet pSSysPortlet, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysPortlet.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysPortlet.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysPortlet pSSysPortlet, PSModule pSModule) throws Exception {
        pSSysPortlet.setPSModuleId(pSModule.getPSModuleId());
        pSSysPortlet.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSPortlet(PSSysPortlet pSSysPortlet, PSPortlet pSPortlet) throws Exception {
        pSSysPortlet.setPSPortletId(pSPortlet.getPSPortletId());
        pSSysPortlet.setPSPortletName(pSPortlet.getPSPortletName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysPortlet pSSysPortlet, PSSysApp pSSysApp) throws Exception {
        pSSysPortlet.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysPortlet.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysCalendar(PSSysPortlet pSSysPortlet, PSSysCalendar pSSysCalendar) throws Exception {
        pSSysPortlet.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
        pSSysPortlet.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysPortlet pSSysPortlet, PSSysCss pSSysCss) throws Exception {
        pSSysPortlet.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysPortlet.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysPortlet pSSysPortlet, PSSysImage pSSysImage) throws Exception {
        pSSysPortlet.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysPortlet.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysMapView(PSSysPortlet pSSysPortlet, PSSysMapView pSSysMapView) throws Exception {
        pSSysPortlet.setPSSysMapViewId(pSSysMapView.getPSSysMapViewId());
        pSSysPortlet.setPSSysMapViewName(pSSysMapView.getPSSysMapViewName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysPortlet pSSysPortlet, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysPortlet.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysPortlet.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_TitlePSSysPFPlugin(PSSysPortlet pSSysPortlet, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysPortlet.setTitlePSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysPortlet.setTitlePSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPortletCat(PSSysPortlet pSSysPortlet, PSSysPortletCat pSSysPortletCat) throws Exception {
        pSSysPortlet.setPSSysPortletCatId(pSSysPortletCat.getPSSysPortletCatId());
        pSSysPortlet.setPSSysPortletCatName(pSSysPortletCat.getPSSysPortletCatName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysPortlet pSSysPortlet, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysPortlet.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysPortlet.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSSysPortlet pSSysPortlet, PSSystem pSSystem) throws Exception {
        pSSysPortlet.setPSSystemId(pSSystem.getPSSystemId());
        pSSysPortlet.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSSysPortlet pSSysPortlet, PSSysUniRes pSSysUniRes) throws Exception {
        pSSysPortlet.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSSysPortlet.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysPortlet pSSysPortlet, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysPortlet.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysPortlet.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (bl && pSSysPortlet.getTemplEngine() == null) {
            pSSysPortlet.setTemplEngine((String)this.getDefaultValue(this.getWebContext(), "", "V2", 25));
        }
        super.onFillEntityFullInfo(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSACHandler(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSAppView(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDE(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEChart(pSSysPortlet, bl);
        this.onFillEntityFullInfo_FilterPSDEDS(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEDS(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEDataView(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEForm(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEList(pSSysPortlet, bl);
        this.onFillEntityFullInfo_ADPSDElogic(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEReport(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSDEView(pSSysPortlet, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSSysPortlet, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSModule(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSPortlet(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysCalendar(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysMapView(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysPortlet, bl);
        this.onFillEntityFullInfo_TitlePSSysPFPlugin(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysPortletCat(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSSysPortlet, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysPortlet, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppView(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (pSSysPortlet.isPSDEIdDirty()) {
            if (pSSysPortlet.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSSysPortlet.getPSDEId() == null || pSSysPortlet.getPSDEName() == null) {
                    pSDataEntity = pSSysPortlet.getPSDE();
                    pSSysPortlet.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSSysPortlet.getPSDE()).getPSModuleId(), (Object)pSSysPortlet.getPSModuleId()) != 0L) {
                    pSSysPortlet.setPSModuleId(pSDataEntity.getPSModuleId());
                    this.onFillEntityFullInfo_PSModule(pSSysPortlet, bl);
                }
            } else {
                pSSysPortlet.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEChart(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FilterPSDEDS(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDS(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataView(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (pSSysPortlet.isPSDEDataViewIdDirty()) {
            if (pSSysPortlet.getPSDEDataViewId() != null) {
                if (pSSysPortlet.getPSDEDataViewId() == null || pSSysPortlet.getPSDEDataViewName() == null) {
                    PSDEDataView pSDEDataView = pSSysPortlet.getPSDEDataView();
                    pSSysPortlet.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                }
            } else {
                pSSysPortlet.setPSDEDataViewName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEForm(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEList(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ADPSDElogic(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEReport(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEView(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (pSSysPortlet.isEmptyTextPSLanResIdDirty()) {
            if (pSSysPortlet.getEmptyTextPSLanResId() != null) {
                if (pSSysPortlet.getEmptyTextPSLanResId() == null || pSSysPortlet.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysPortlet.getEmptyTextPSLanRes();
                    pSSysPortlet.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysPortlet.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (pSSysPortlet.isTitlePSLanResIdDirty()) {
            if (pSSysPortlet.getTitlePSLanResId() != null) {
                if (pSSysPortlet.getTitlePSLanResId() == null || pSSysPortlet.getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysPortlet.getTitlePSLanRes();
                    pSSysPortlet.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysPortlet.setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPortlet(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCalendar(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMapView(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TitlePSSysPFPlugin(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPortletCat(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        if (pSSysPortlet.isPSSystemIdDirty()) {
            if (pSSysPortlet.getPSSystemId() != null) {
                if (pSSysPortlet.getPSSystemId() == null || pSSysPortlet.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysPortlet.getPSSystem();
                    pSSysPortlet.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysPortlet.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysPortlet, bl);
    }

    public ArrayList<PSSysPortlet> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByFilterPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByFilterPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByFilterPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FILTERPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFilterPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFilterPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectByPSDEList(pSDEListBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        return this.selectByPSDEList(pSDEListBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEList(PSDEListBase pSDEListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByADPSDElogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDElogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByADPSDElogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDElogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByADPSDElogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByADPSDElogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByADPSDElogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSPortlet(PSPortletBase pSPortletBase) throws Exception {
        return this.selectByPSPortlet(pSPortletBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSPortlet(PSPortletBase pSPortletBase, String string) throws Exception {
        return this.selectByPSPortlet(pSPortletBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSPortlet(PSPortletBase pSPortletBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPORTLETID", (Object)pSPortletBase.getPSPortletId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPortletCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPortletCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByTitlePSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByTitlePSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByTitlePSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByTitlePSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByTitlePSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSSysPortletCat(PSSysPortletCatBase pSSysPortletCatBase) throws Exception {
        return this.selectByPSSysPortletCat(pSSysPortletCatBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysPortletCat(PSSysPortletCatBase pSSysPortletCatBase, String string) throws Exception {
        return this.selectByPSSysPortletCat(pSSysPortletCatBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysPortletCat(PSSysPortletCatBase pSSysPortletCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPORTLETCATID", (Object)pSSysPortletCatBase.getPSSysPortletCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPortletCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPortletCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysPortlet> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysPortlet> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysPortlet> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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
        ArrayList<PSSysPortlet> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSACHandlerId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSSysPortletServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSAPPMENU_PSAPPMENUID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSAppMenuId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSSysPortletServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSAPPVIEW_PSAPPVIEWID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSAppView), arrayList.get(0)));
        }
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppView(pSAppView);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSAppViewId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSSysPortletServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysPortletServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEChart(pSDEChart, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDECHART");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEChart);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDECHART_PSDECHARTID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEChart), arrayList.get(0)));
        }
    }

    public void resetPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEChart(pSDEChart);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEChartId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEChart(pSDEChart2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEChart(pSDEChart2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEChart(pSDEChart);
        this.onBeforeRemoveByPSDEChart(pSDEChart, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByFilterPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEDATASET_FILTERPSDEDSID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByFilterPSDEDS(pSDEDataSet);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setFilterPSDEDSId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByFilterPSDEDS(pSDEDataSet2);
                PSSysPortletServiceBase.this.internalRemoveByFilterPSDEDS(pSDEDataSet2);
                PSSysPortletServiceBase.this.onAfterRemoveByFilterPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByFilterPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByFilterPSDEDS(pSDEDataSet, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByFilterPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFilterPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEDSId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDataView(pSDEDataView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEDATAVIEW_PSDEDATAVIEWID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEDataView), arrayList.get(0)));
        }
    }

    public void resetPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDataView(pSDEDataView);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEDataViewId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEDataView(pSDEDataView2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEDataView(pSDEDataView2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEDataView(pSDEDataView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void internalRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEDataView(pSDEDataView);
        this.onBeforeRemoveByPSDEDataView(pSDEDataView, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEDataView(pSDEDataView, arrayList);
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEFormId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEList(pSDEList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDELIST_PSDELISTID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEList), arrayList.get(0)));
        }
    }

    public void resetPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEList(pSDEList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEListId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEList(pSDEList2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEList(pSDEList2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEList(pSDEList);
        this.onBeforeRemoveByPSDEList(pSDEList, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByADPSDElogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByADPSDElogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDElogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByADPSDElogic(pSDELogic);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setADPSDELogicId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByADPSDElogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByADPSDElogic(pSDELogic2);
                PSSysPortletServiceBase.this.internalRemoveByADPSDElogic(pSDELogic2);
                PSSysPortletServiceBase.this.onAfterRemoveByADPSDElogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDElogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDElogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByADPSDElogic(pSDELogic);
        this.onBeforeRemoveByADPSDElogic(pSDELogic, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByADPSDElogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDElogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDElogic(PSDELogic pSDELogic, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDElogic(PSDELogic pSDELogic, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEREPORT_PSDEREPORTID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEReport), arrayList.get(0)));
        }
    }

    public void resetPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEReport(pSDEReport);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEReportId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEReport(pSDEReport2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEReport(pSDEReport2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEReport(pSDEReport);
        this.onBeforeRemoveByPSDEReport(pSDEReport, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEToolbarId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEUAGroupId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSDEVIEWBASE_PSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEView(pSDEViewBase);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSDEViewId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSDEView(pSDEViewBase2);
                PSSysPortletServiceBase.this.internalRemoveByPSDEView(pSDEViewBase2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPSDEView(pSDEViewBase, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setEmptyTextPSLanResId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSSysPortletServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSSysPortletServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setTitlePSLanResId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSSysPortletServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSSysPortletServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSModule(pSModule);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSModuleId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysPortletServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSPortlet(PSPortlet pSPortlet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSPortlet(pSPortlet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPORTLET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPortlet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSPORTLET_PSPORTLETID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSPortlet), arrayList.get(0)));
        }
    }

    public void resetPSPortlet(PSPortlet pSPortlet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSPortlet(pSPortlet);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSPortletId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSPortlet(PSPortlet pSPortlet) throws Exception {
        final PSPortlet pSPortlet2 = pSPortlet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSPortlet(pSPortlet2);
                PSSysPortletServiceBase.this.internalRemoveByPSPortlet(pSPortlet2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSPortlet(pSPortlet2);
            }
        });
    }

    protected void onBeforeRemoveByPSPortlet(PSPortlet pSPortlet) throws Exception {
    }

    protected void internalRemoveByPSPortlet(PSPortlet pSPortlet) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSPortlet(pSPortlet);
        this.onBeforeRemoveByPSPortlet(pSPortlet, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSPortlet(pSPortlet, arrayList);
    }

    protected void onAfterRemoveByPSPortlet(PSPortlet pSPortlet) throws Exception {
    }

    protected void onBeforeRemoveByPSPortlet(PSPortlet pSPortlet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPortlet(PSPortlet pSPortlet, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysAppId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCalendar(pSSysCalendar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCALENDAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCalendar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSCALENDAR_PSSYSCALENDARID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysCalendar), arrayList.get(0)));
        }
    }

    public void resetPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysCalendarId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysCssId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysImageId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysMapView(pSSysMapView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMAPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMapView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSMAPVIEW_PSSYSMAPVIEWID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysMapView), arrayList.get(0)));
        }
    }

    public void resetPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysMapView(pSSysMapView);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysMapViewId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        final PSSysMapView pSSysMapView2 = pSSysMapView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysMapView(pSSysMapView2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysMapView(pSSysMapView2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysMapView(pSSysMapView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void internalRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysMapView(pSSysMapView);
        this.onBeforeRemoveByPSSysMapView(pSSysMapView, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysMapView(pSSysMapView, arrayList);
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysPFPluginId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSPFPLUGIN_TITLEPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSSysPFPlugin(pSSysPFPlugin);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setTitlePSSysPFPluginId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByTitlePSSysPFPlugin(pSSysPFPlugin2);
                PSSysPortletServiceBase.this.internalRemoveByTitlePSSysPFPlugin(pSSysPFPlugin2);
                PSSysPortletServiceBase.this.onAfterRemoveByTitlePSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByTitlePSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByTitlePSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByTitlePSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPortletCat(pSSysPortletCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPORTLETCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPortletCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSPORTLETCAT_PSSYSPORTLETCATID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysPortletCat), arrayList.get(0)));
        }
    }

    public void resetPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPortletCat(pSSysPortletCat);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysPortletCatId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
        final PSSysPortletCat pSSysPortletCat2 = pSSysPortletCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysPortletCat(pSSysPortletCat2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysPortletCat(pSSysPortletCat2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysPortletCat(pSSysPortletCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
    }

    protected void internalRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysPortletCat(pSSysPortletCat);
        this.onBeforeRemoveByPSSysPortletCat(pSSysPortletCat, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysPortletCat(pSSysPortletCat, arrayList);
    }

    protected void onAfterRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPortletCat(PSSysPortletCat pSSysPortletCat, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysReqItemId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSystemId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysPortletServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysUniResId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSPORTLET_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSSYSPORTLET", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            PSSysPortlet pSSysPortlet2 = (PSSysPortlet)this.getDEModel().createEntity();
            pSSysPortlet2.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            pSSysPortlet2.setPSSysViewPanelId(null);
            this.update(pSSysPortlet2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPortletServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysPortletServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysPortletServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysPortlet> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysPortlet pSSysPortlet : arrayList) {
            this.remove(pSSysPortlet);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysPortlet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysPortlet pSSysPortlet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPortlet(pSSysPortlet);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPortlet(pSSysPortlet);
        pSCoreSysServiceBase = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysPortlet(pSSysPortlet);
        super.onBeforeRemove(pSSysPortlet);
    }

    protected void replaceParentInfo(PSSysPortlet pSSysPortlet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysPortlet, cloneSession);
        if (pSSysPortlet.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSSysPortlet.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSSysPortlet, (PSACHandler)iEntity);
        }
        if (pSSysPortlet.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSSysPortlet.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSSysPortlet, (PSAppMenu)iEntity);
        }
        if (pSSysPortlet.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSSysPortlet.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSSysPortlet, (PSAppView)iEntity);
        }
        if (pSSysPortlet.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysPortlet.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysPortlet, (PSDataEntity)iEntity);
        }
        if (pSSysPortlet.getPSDEChartId() != null && (iEntity = cloneSession.getEntity("PSDECHART", (Object)pSSysPortlet.getPSDEChartId())) != null) {
            this.onFillParentInfo_PSDEChart(pSSysPortlet, (PSDEChart)iEntity);
        }
        if (pSSysPortlet.getFilterPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysPortlet.getFilterPSDEDSId())) != null) {
            this.onFillParentInfo_FilterPSDEDS(pSSysPortlet, (PSDEDataSet)iEntity);
        }
        if (pSSysPortlet.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysPortlet.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSSysPortlet, (PSDEDataSet)iEntity);
        }
        if (pSSysPortlet.getPSDEDataViewId() != null && (iEntity = cloneSession.getEntity("PSDEDATAVIEW", (Object)pSSysPortlet.getPSDEDataViewId())) != null) {
            this.onFillParentInfo_PSDEDataView(pSSysPortlet, (PSDEDataView)iEntity);
        }
        if (pSSysPortlet.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSSysPortlet.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSSysPortlet, (PSDEForm)iEntity);
        }
        if (pSSysPortlet.getPSDEListId() != null && (iEntity = cloneSession.getEntity("PSDELIST", (Object)pSSysPortlet.getPSDEListId())) != null) {
            this.onFillParentInfo_PSDEList(pSSysPortlet, (PSDEList)iEntity);
        }
        if (pSSysPortlet.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysPortlet.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDElogic(pSSysPortlet, (PSDELogic)iEntity);
        }
        if (pSSysPortlet.getPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSSysPortlet.getPSDEReportId())) != null) {
            this.onFillParentInfo_PSDEReport(pSSysPortlet, (PSDEReport)iEntity);
        }
        if (pSSysPortlet.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysPortlet.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSSysPortlet, (PSDEToolbar)iEntity);
        }
        if (pSSysPortlet.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSSysPortlet.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSSysPortlet, (PSDEUAGroup)iEntity);
        }
        if (pSSysPortlet.getPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysPortlet.getPSDEViewId())) != null) {
            this.onFillParentInfo_PSDEView(pSSysPortlet, (PSDEViewBase)iEntity);
        }
        if (pSSysPortlet.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysPortlet.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSSysPortlet, (PSLanguageRes)iEntity);
        }
        if (pSSysPortlet.getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysPortlet.getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(pSSysPortlet, (PSLanguageRes)iEntity);
        }
        if (pSSysPortlet.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysPortlet.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysPortlet, (PSModule)iEntity);
        }
        if (pSSysPortlet.getPSPortletId() != null && (iEntity = cloneSession.getEntity("PSPORTLET", (Object)pSSysPortlet.getPSPortletId())) != null) {
            this.onFillParentInfo_PSPortlet(pSSysPortlet, (PSPortlet)iEntity);
        }
        if (pSSysPortlet.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysPortlet.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysPortlet, (PSSysApp)iEntity);
        }
        if (pSSysPortlet.getPSSysCalendarId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDAR", (Object)pSSysPortlet.getPSSysCalendarId())) != null) {
            this.onFillParentInfo_PSSysCalendar(pSSysPortlet, (PSSysCalendar)iEntity);
        }
        if (pSSysPortlet.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysPortlet.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysPortlet, (PSSysCss)iEntity);
        }
        if (pSSysPortlet.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysPortlet.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysPortlet, (PSSysImage)iEntity);
        }
        if (pSSysPortlet.getPSSysMapViewId() != null && (iEntity = cloneSession.getEntity("PSSYSMAPVIEW", (Object)pSSysPortlet.getPSSysMapViewId())) != null) {
            this.onFillParentInfo_PSSysMapView(pSSysPortlet, (PSSysMapView)iEntity);
        }
        if (pSSysPortlet.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysPortlet.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysPortlet, (PSSysPFPlugin)iEntity);
        }
        if (pSSysPortlet.getTitlePSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysPortlet.getTitlePSSysPFPluginId())) != null) {
            this.onFillParentInfo_TitlePSSysPFPlugin(pSSysPortlet, (PSSysPFPlugin)iEntity);
        }
        if (pSSysPortlet.getPSSysPortletCatId() != null && (iEntity = cloneSession.getEntity("PSSYSPORTLETCAT", (Object)pSSysPortlet.getPSSysPortletCatId())) != null) {
            this.onFillParentInfo_PSSysPortletCat(pSSysPortlet, (PSSysPortletCat)iEntity);
        }
        if (pSSysPortlet.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysPortlet.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysPortlet, (PSSysReqItem)iEntity);
        }
        if (pSSysPortlet.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysPortlet.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysPortlet, (PSSystem)iEntity);
        }
        if (pSSysPortlet.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSSysPortlet.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSSysPortlet, (PSSysUniRes)iEntity);
        }
        if (pSSysPortlet.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysPortlet.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysPortlet, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysPortlet, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSSysPortlet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DashboardScope(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterPSDEDSId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupExtractMode(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlShowMode(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlUrl(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortletParams(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortletStyle(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortletType(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEReportId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPortletId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapViewId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletCatId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReloadTimer(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowTitleBar(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAppFlag(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplEngine(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSSysPFPluginId(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysPortlet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isADPSDELogicIdDirty() : !pSSysPortlet.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isBaseClsParamsDirty() : !pSSysPortlet.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSSysPortlet.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BASECLSPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isCodeNameDirty() && !bl2 : !pSSysPortlet.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysPortlet, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysPortletDEModel(), "CODENAME", string3, pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_DashboardScope(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isDashboardScopeDirty() : !pSSysPortlet.isDashboardScopeDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getDashboardScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DashboardScope_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DASHBOARDSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isEmptyTextDirty() : !pSSysPortlet.isEmptyTextDirty()) {
            return null;
        }
        String string = pSSysPortlet.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isEmptyTextPSLanResIdDirty() : !pSSysPortlet.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isEmptyTextPSLanResNameDirty() : !pSSysPortlet.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_FilterPSDEDSId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isFilterPSDEDSIdDirty() : !pSSysPortlet.isFilterPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getFilterPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterPSDEDSId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupExtractMode(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isGroupExtractModeDirty() : !pSSysPortlet.isGroupExtractModeDirty()) {
            return null;
        }
        String string = pSSysPortlet.getGroupExtractMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupExtractMode_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPEXTRACTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isHeightDirty() : !pSSysPortlet.isHeightDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_HtmlShowMode(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isHtmlShowModeDirty() : !pSSysPortlet.isHtmlShowModeDirty()) {
            return null;
        }
        String string = pSSysPortlet.getHtmlShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlShowMode_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLSHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlUrl(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isHtmlUrlDirty() : !pSSysPortlet.isHtmlUrlDirty()) {
            return null;
        }
        String string = pSSysPortlet.getHtmlUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlUrl_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isLockFlagDirty() : !pSSysPortlet.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isLogicNameDirty() : !pSSysPortlet.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isMemoDirty() : !pSSysPortlet.isMemoDirty()) {
            return null;
        }
        String string = pSSysPortlet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PortletParams(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPortletParamsDirty() : !pSSysPortlet.isPortletParamsDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPortletParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PortletParams_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PortletStyle(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPortletStyleDirty() : !pSSysPortlet.isPortletStyleDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPortletStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PortletStyle_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PortletType(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPortletTypeDirty() && !bl2 : !pSSysPortlet.isPortletTypeDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPortletType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PortletType_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTLETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSACHandlerIdDirty() : !pSSysPortlet.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSAppMenuIdDirty() : !pSSysPortlet.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSAppViewIdDirty() : !pSSysPortlet.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEChartIdDirty() : !pSSysPortlet.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEChartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEDataViewIdDirty() : !pSSysPortlet.isPSDEDataViewIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEDataViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEDataViewNameDirty() : !pSSysPortlet.isPSDEDataViewNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEDataViewName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewName_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEDSIdDirty() : !pSSysPortlet.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEFormIdDirty() : !pSSysPortlet.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEIdDirty() : !pSSysPortlet.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEListId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEListIdDirty() : !pSSysPortlet.isPSDEListIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDENameDirty() : !pSSysPortlet.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEReportId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEReportIdDirty() : !pSSysPortlet.isPSDEReportIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEReportId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEToolbarIdDirty() : !pSSysPortlet.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEUAGroupIdDirty() : !pSSysPortlet.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSDEViewIdDirty() : !pSSysPortlet.isPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSModuleIdDirty() : !pSSysPortlet.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPortletId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSPortletIdDirty() : !pSSysPortlet.isPSPortletIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSPortletId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPortletId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPORTLETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysAppIdDirty() : !pSSysPortlet.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysCalendarIdDirty() : !pSSysPortlet.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysCalendarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysCssIdDirty() : !pSSysPortlet.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysImageIdDirty() : !pSSysPortlet.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMapViewId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysMapViewIdDirty() : !pSSysPortlet.isPSSysMapViewIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysMapViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapViewId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysPFPluginIdDirty() : !pSSysPortlet.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPortletCatId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysPortletCatIdDirty() : !pSSysPortlet.isPSSysPortletCatIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysPortletCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletCatId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPortletId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysPortletIdDirty() && !bl2 : !pSSysPortlet.isPSSysPortletIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysPortletId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPortletName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysPortletNameDirty() && !bl2 : !pSSysPortlet.isPSSysPortletNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysPortletName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletName_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysPortletDEModel(), "PSSYSPORTLETNAME", string3, pSSysPortlet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSPORTLETNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysReqItemIdDirty() : !pSSysPortlet.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSystemIdDirty() : !pSSysPortlet.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSystemNameDirty() && !bl2 : !pSSysPortlet.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysUniResIdDirty() : !pSSysPortlet.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isPSSysViewPanelIdDirty() : !pSSysPortlet.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReloadTimer(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isReloadTimerDirty() : !pSSysPortlet.isReloadTimerDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getReloadTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReloadTimer_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RELOADTIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowTitleBar(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isShowTitleBarDirty() : !pSSysPortlet.isShowTitleBarDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getShowTitleBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowTitleBar_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWTITLEBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysAppFlag(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isSysAppFlagDirty() : !pSSysPortlet.isSysAppFlagDirty()) {
            return null;
        }
        Integer n = pSSysPortlet.getSysAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAppFlag_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplEngine(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isTemplEngineDirty() : !pSSysPortlet.isTemplEngineDirty()) {
            return null;
        }
        String string = pSSysPortlet.getTemplEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplEngine_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isTitlePSLanResIdDirty() : !pSSysPortlet.isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isTitlePSLanResNameDirty() : !pSSysPortlet.isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSSysPortlet.getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSSysPFPluginId(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isTitlePSSysPFPluginIdDirty() : !pSSysPortlet.isTitlePSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysPortlet.getTitlePSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSSysPFPluginId_Default(pSSysPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isToDoTaskDirty() : !pSSysPortlet.isToDoTaskDirty()) {
            return null;
        }
        String string = pSSysPortlet.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isUserTagDirty() : !pSSysPortlet.isUserTagDirty()) {
            return null;
        }
        String string = pSSysPortlet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysPortlet pSSysPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPortlet.isUserTag2Dirty() : !pSSysPortlet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysPortlet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysPortlet, bl2, bl3);
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

    protected void onSyncEntity(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        super.onSyncEntity(pSSysPortlet, bl);
    }

    protected void onSyncIndexEntities(PSSysPortlet pSSysPortlet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysPortlet, bl);
    }

    public Object getDataContextValue(PSSysPortlet pSSysPortlet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysPortlet, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSSysPortlet.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSSysPortlet.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysPortlet pSSysPortlet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSSysPortlet, arrayList, n);
        this.onExportMajorModel_TitlePSLanRes(pSSysPortlet, arrayList, n);
        super.onExportMajorModel(pSSysPortlet, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSSysPortlet pSSysPortlet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysPortlet.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysPortlet.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TitlePSLanRes(PSSysPortlet pSSysPortlet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysPortlet.getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysPortlet.getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DASHBOARDSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DashboardScope_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"FILTERPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPEXTRACTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupExtractMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLSHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlUrl_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PORTLETPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORTLETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PortletType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPortletName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RELOADTIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReloadTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWTITLEBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowTitleBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAppFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSSysPFPluginName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DashboardScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FilterPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FilterPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupExtractMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPEXTRACTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HtmlShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLSHOWMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PortletParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PortletStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PortletType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTLETTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSSYSMAPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysPortletCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ReloadTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowTitleBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLENGINE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysPortlet pSSysPortlet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysPortlet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysPortlet pSSysPortlet) throws Exception {
        super.onUpdateParent(pSSysPortlet);
    }

    @Override
    protected void exportCurXmlModel(PSSysPortlet pSSysPortlet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSPORTLET");
        if (!bl) {
            pSSysPortlet.setPSAppMenuName(null);
            pSSysPortlet.setPSAppViewName(null);
            pSSysPortlet.setPSPortletId(null);
            pSSysPortlet.setPSPortletName(null);
            super.exportCurXmlModel(pSSysPortlet, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysPortlet pSSysPortlet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysPortlet, string);
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
            return "DER1N_PSSYSPORTLET_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSPORTLET_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSPORTLET_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysPortlet pSSysPortlet) {
        if (!StringHelper.isNullOrEmpty((String)pSSysPortlet.getPSSysPortletName())) {
            return pSSysPortlet.getPSSysPortletName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysPortlet.getCodeName())) {
            return pSSysPortlet.getCodeName();
        }
        return super.getModelV2Tag(pSSysPortlet);
    }

    @Override
    public boolean setModelV2Tag(PSSysPortlet pSSysPortlet, String string) {
        pSSysPortlet.setPSSysPortletName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSPORTLETNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSPORTLETNAME", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysPortlet pSSysPortlet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysPortlet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysPortlet, true);
        pSSysPortlet.set("PSSYSPORTLETNAME", string);
        if (this.select(pSSysPortlet, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysPortlet, true);
        return super.getModelV2Entity(pSSysPortlet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysPortlet pSSysPortlet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysPortlet, objectNode, string, string2, n);
    }
}

