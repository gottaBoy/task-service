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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppModuleDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppModuleDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWFBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppModuleServiceBase
extends PSCoreSysServiceBase<PSAppModule> {
    private static final Log log = LogFactory.getLog(PSAppModuleServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDEFAULT = "InitDefault";
    private PSAppModuleDEModel pSAppModuleDEModel;
    private PSAppModuleDAO pSAppModuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService";
    }

    public PSAppModuleDEModel getPSAppModuleDEModel() {
        if (this.pSAppModuleDEModel == null) {
            try {
                this.pSAppModuleDEModel = (PSAppModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppModuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppModuleDEModel();
    }

    public PSAppModuleDAO getPSAppModuleDAO() {
        if (this.pSAppModuleDAO == null) {
            try {
                this.pSAppModuleDAO = (PSAppModuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppModuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppModuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppModuleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDEFAULT, (boolean)true) == 0) {
            this.initDefault((PSAppModule)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void initDefault(PSAppModule pSAppModule) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDEFAULT, 0, pSAppModule, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppModule, ACTION_INITDEFAULT);
        final PSAppModule pSAppModule2 = pSAppModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppModuleServiceBase.this.getService(), PSAppModuleServiceBase.ACTION_INITDEFAULT, 40, pSAppModule2, null).getResult() != 1) {
                    PSAppModuleServiceBase.this.onInitDefault(pSAppModule2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDEFAULT, 99, pSAppModule, null);
        }
    }

    protected void onInitDefault(PSAppModule pSAppModule) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDefault]");
    }

    protected void onFillParentInfo(PSAppModule pSAppModule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMODULE_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppMenu);
            } else {
                iService.get(pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSAppModule, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMODULE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSAppModule, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppModule, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSAppModule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppMenu(PSAppModule pSAppModule, PSAppMenu pSAppMenu) throws Exception {
        pSAppModule.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppModule.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_PSModule(PSAppModule pSAppModule, PSModule pSModule) throws Exception {
        pSAppModule.setPSModuleId(pSModule.getPSModuleId());
        pSAppModule.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppModule pSAppModule, PSSysApp pSSysApp) throws Exception {
        pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppModule.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSAppModule pSAppModule, boolean bl) throws Exception {
        if (bl && pSAppModule.getOrderValue() == null) {
            pSAppModule.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
        }
        super.onFillEntityFullInfo(pSAppModule, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSAppModule, bl);
        this.onFillEntityFullInfo_PSModule(pSAppModule, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppModule, bl);
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSAppModule pSAppModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSAppModule pSAppModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppModule pSAppModule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppModule pSAppModule, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppModule, bl);
    }

    public ArrayList<PSAppModule> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppModule> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppModule> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppModule> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSAppModule> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSAppModule> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppModule> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppModule> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppModule> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMODULE_PSAPPMENU_PSAPPMENUID", "", iDataEntityModel.getName(), "PSAPPMODULE", iDataEntityModel.getDataInfo(pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSAppModule pSAppModule : arrayList) {
            PSAppModule pSAppModule2 = (PSAppModule)this.getDEModel().createEntity();
            pSAppModule2.setPSAppModuleId(pSAppModule.getPSAppModuleId());
            pSAppModule2.setPSAppMenuId(null);
            this.update(pSAppModule2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppModuleServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSAppModuleServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSAppModuleServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSAppModule pSAppModule : arrayList) {
            this.remove(pSAppModule);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPMODULE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSAPPMODULE", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSModule(pSModule);
        for (PSAppModule pSAppModule : arrayList) {
            PSAppModule pSAppModule2 = (PSAppModule)this.getDEModel().createEntity();
            pSAppModule2.setPSAppModuleId(pSAppModule.getPSAppModuleId());
            pSAppModule2.setPSModuleId(null);
            this.update(pSAppModule2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppModuleServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSAppModuleServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSAppModuleServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSAppModule pSAppModule : arrayList) {
            this.remove(pSAppModule);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppModule pSAppModule : arrayList) {
            PSAppModule pSAppModule2 = (PSAppModule)this.getDEModel().createEntity();
            pSAppModule2.setPSAppModuleId(pSAppModule.getPSAppModuleId());
            pSAppModule2.setPSSysAppId(null);
            this.update(pSAppModule2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppModuleServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppModuleServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppModuleServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppModule> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppModule pSAppModule : arrayList) {
            this.remove(pSAppModule);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppModule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppModule pSAppModule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSAppModule(pSAppModule);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppModule(pSAppModule);
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppWFServiceBase)pSCoreSysServiceBase).testRemoveByPSAppModule(pSAppModule);
        pSCoreSysServiceBase = (PSDEUAWizardService)ServiceGlobal.getService(PSDEUAWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSAppModule(pSAppModule);
        ((PSDEUAWizardServiceBase)pSCoreSysServiceBase).resetPSAppModule(pSAppModule);
        super.onBeforeRemove(pSAppModule);
    }

    protected void replaceParentInfo(PSAppModule pSAppModule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppModule, cloneSession);
        if (pSAppModule.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppModule.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSAppModule, (PSAppMenu)iEntity);
        }
        if (pSAppModule.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSAppModule.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSAppModule, (PSModule)iEntity);
        }
        if (pSAppModule.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppModule.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppModule, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppModule pSAppModule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppModule, bl);
        pSAppModule.resetFromObjId();
    }

    protected void onCheckEntity(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppModule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableModuleStyle(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromObjId(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainMenuSide(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleSN(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleId(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleName(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppModule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isCodeNameDirty() && !bl2 : !pSAppModule.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppModule.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Color(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isColorDirty() : !pSAppModule.isColorDirty()) {
            return null;
        }
        String string = pSAppModule.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isDefaultFlagDirty() : !pSAppModule.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSAppModule.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSAPPID";
                String string2 = this.checkFieldDupRule(this.getPSAppModuleDEModel(), "DEFAULTFLAG", string, pSAppModule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableModuleStyle(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isEnableModuleStyleDirty() : !pSAppModule.isEnableModuleStyleDirty()) {
            return null;
        }
        Integer n = pSAppModule.getEnableModuleStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableModuleStyle_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODULESTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromObjId(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isFromObjIdDirty() : !pSAppModule.isFromObjIdDirty()) {
            return null;
        }
        String string = pSAppModule.getFromObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromObjId_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainMenuSide(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isMainMenuSideDirty() : !pSAppModule.isMainMenuSideDirty()) {
            return null;
        }
        String string = pSAppModule.getMainMenuSide();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainMenuSide_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINMENUSIDE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isMemoDirty() : !pSAppModule.isMemoDirty()) {
            return null;
        }
        String string = pSAppModule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModuleSN(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isModuleSNDirty() : !pSAppModule.isModuleSNDirty()) {
            return null;
        }
        String string = pSAppModule.getModuleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleSN_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isOrderValueDirty() && !bl2 : !pSAppModule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSAppModule.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isPSAppMenuIdDirty() : !pSAppModule.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppModule.getPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppModuleId(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isPSAppModuleIdDirty() && !bl2 : !pSAppModule.isPSAppModuleIdDirty()) {
            return null;
        }
        String string = pSAppModule.getPSAppModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleId_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModuleName(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isPSAppModuleNameDirty() && !bl2 : !pSAppModule.isPSAppModuleNameDirty()) {
            return null;
        }
        String string = pSAppModule.getPSAppModuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleName_Default(pSAppModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isPSModuleIdDirty() : !pSAppModule.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSAppModule.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isPSSysAppIdDirty() && !bl2 : !pSAppModule.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppModule.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserCatDirty() : !pSAppModule.isUserCatDirty()) {
            return null;
        }
        String string = pSAppModule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserParamsDirty() : !pSAppModule.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppModule.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserTagDirty() : !pSAppModule.isUserTagDirty()) {
            return null;
        }
        String string = pSAppModule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserTag2Dirty() : !pSAppModule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppModule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserTag3Dirty() : !pSAppModule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppModule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppModule pSAppModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppModule.isUserTag4Dirty() : !pSAppModule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppModule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppModule, bl2, bl3);
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

    protected void onSyncEntity(PSAppModule pSAppModule, boolean bl) throws Exception {
        super.onSyncEntity(pSAppModule, bl);
    }

    protected void onSyncIndexEntities(PSAppModule pSAppModule, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppModule, bl);
    }

    public Object getDataContextValue(PSAppModule pSAppModule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppModule, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppModule.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppModule pSAppModule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppModule, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODULESTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableModuleStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINMENUSIDE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainMenuSide_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableModuleStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FromObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainMenuSide_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINMENUSIDE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_ModuleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSAppModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppModule pSAppModule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppModule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppModule pSAppModule) throws Exception {
        Object object = pSAppModule.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppModule);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppModule pSAppModule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPMODULE");
        if (!bl) {
            pSAppModule.setCreateDate(null);
            pSAppModule.setCreateMan(null);
            pSAppModule.setPSAppModuleId(null);
            pSAppModule.setUpdateDate(null);
            pSAppModule.setUpdateMan(null);
            super.exportCurXmlModel(pSAppModule, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppModule pSAppModule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppModule, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppModule pSAppModule) {
        return super.getModelV2Tag(pSAppModule);
    }

    @Override
    public boolean setModelV2Tag(PSAppModule pSAppModule, String string) {
        return super.setModelV2Tag(pSAppModule, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppModule pSAppModule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppModule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppModule, true);
        return super.getModelV2Entity(pSAppModule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppModule pSAppModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppModule, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSAppModule pSAppModule, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPLOCALDE", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppLocalDE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppLocalDE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPLOCALDE", (Object)((PSAppLocalDE)entityBase).getPSAppLocalDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID")) {
            file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPDEVIEW", (Object)pSAppModule.getPSAppModuleId()));
            if (file2.exists()) {
                pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPDEVIEW", (Object)((PSAppDEView)entityBase).getPSAppDEViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPDYNADEVIEW", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
                pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppDynaDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPDYNADEVIEW", (Object)((PSAppDynaDEView)entityBase).getPSAppDynaDEViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPINDEXVIEW", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
                pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppIndexView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPINDEXVIEW", (Object)((PSAppIndexView)entityBase).getPSAppIndexViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPANELVIEW", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
                pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppPanelView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPANELVIEW", (Object)((PSAppPanelView)entityBase).getPSAppPanelViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPORTALVIEW", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
                pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppPortalView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPORTALVIEW", (Object)((PSAppPortalView)entityBase).getPSAppPortalViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUTILVIEW", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
                pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppUtilView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUTILVIEW", (Object)((PSAppUtilView)entityBase).getPSAppUtilViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPWF", (Object)pSAppModule.getPSAppModuleId()))).exists()) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppWF();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppWFServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppWF)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPWF", (Object)((PSAppWF)entityBase).getPSAppWFId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSAppModule, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSAppModule pSAppModule, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID")) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPLOCALDE", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                object4 = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppLocalDE)((java.util.Iterator)object2).next();
                    object = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psapplocaldename")) {
                            string = objectNode.get("psapplocaldename").asText();
                        }
                        if (objectNode2.has("psapplocaldename")) {
                            string2 = objectNode2.get("psapplocaldename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppLocalDE();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID")) {
            pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPDEVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppDEView)((Object)((java.util.Iterator)object2).next());
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psappdeviewname")) {
                            string = objectNode.get("psappdeviewname").asText();
                        }
                        if (objectNode2.has("psappdeviewname")) {
                            string2 = objectNode2.get("psappdeviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
            pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPDYNADEVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppDynaDEView)((java.util.Iterator)object2).next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psappdynadeviewname")) {
                            string = objectNode.get("psappdynadeviewname").asText();
                        }
                        if (objectNode2.has("psappdynadeviewname")) {
                            string2 = objectNode2.get("psappdynadeviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppDynaDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
            pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPINDEXVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppIndexView)((java.util.Iterator)object2).next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psappindexviewname")) {
                            string = objectNode.get("psappindexviewname").asText();
                        }
                        if (objectNode2.has("psappindexviewname")) {
                            string2 = objectNode2.get("psappindexviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppIndexView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
            pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPANELVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppPanelView)((java.util.Iterator)object2).next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psapppanelviewname")) {
                            string = objectNode.get("psapppanelviewname").asText();
                        }
                        if (objectNode2.has("psapppanelviewname")) {
                            string2 = objectNode2.get("psapppanelviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppPanelView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
            pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPORTALVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppPortalView)((java.util.Iterator)object2).next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psappportalviewname")) {
                            string = objectNode.get("psappportalviewname").asText();
                        }
                        if (objectNode2.has("psappportalviewname")) {
                            string2 = objectNode2.get("psappportalviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppPortalView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
            pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUTILVIEW", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppUtilView)((java.util.Iterator)object2).next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psapputilviewname")) {
                            string = objectNode.get("psapputilviewname").asText();
                        }
                        if (objectNode2.has("psapputilviewname")) {
                            string2 = objectNode2.get("psapputilviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppUtilView();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID")) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPWF", (Object)pSAppModule.getPSAppModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (((java.util.Iterator)object3).hasNext()) {
                        object2 = (String)((java.util.Iterator)object3).next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppWFServiceBase)pSCoreSysServiceBase).selectByPSAppModule(pSAppModule);
                object3 = StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)pSAppModule.getPSAppModuleId());
                object2 = ((ArrayList)object4).iterator();
                while (((java.util.Iterator)object2).hasNext()) {
                    entityBase2 = (PSAppWF)((java.util.Iterator)object2).next();
                    object = ((PSAppWFServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entityBase2, false));
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
                        if (objectNode.has("psappwfname")) {
                            string = objectNode.get("psappwfname").asText();
                        }
                        if (objectNode2.has("psappwfname")) {
                            string2 = objectNode2.get("psappwfname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    EntityBase model = new PSAppWF();
                    PSModelV2Helper.fromJSONObject((IDataObject)model, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSAppModule, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSAppModule pSAppModule) throws Exception {
        super.onEmptyModelV2(pSAppModule);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSAppModule pSAppModule, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSAppLocalDE();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppDEView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppDynaDEView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppIndexView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPanelView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPortalView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUtilView();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppWF();
        entityBase.set("PSAPPMODULEID", pSAppModule.getPSAppModuleId());
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSAppModule, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSAppModule pSAppModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"psappdataentities");
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSAppLocalDE model = new PSAppLocalDE();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    model.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (!((File)object2).exists()) {
                    string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSAPPDATAENTITIES");
                    object2 = new File(string4);
                }
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppLocalDE model = new PSAppLocalDE();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        model.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    PSAppDEView model = new PSAppDEView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppDEView model = new PSAppDEView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppDynaDEView model = new PSAppDynaDEView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppDynaDEView model = new PSAppDynaDEView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppIndexView model = new PSAppIndexView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppIndexView model = new PSAppIndexView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppPanelView model = new PSAppPanelView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string8);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppPanelView model = new PSAppPanelView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppPortalView model = new PSAppPortalView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string9 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string9);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppPortalView model = new PSAppPortalView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppUtilView model = new PSAppUtilView();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string10 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string10);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppUtilView model = new PSAppUtilView();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSAppModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    PSAppWF model = new PSAppWF();
                    model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                    model.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                    pSCoreSysServiceBase.compileModelV2(model, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string11 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string11);
                if (((File)object2).exists()) {
                    for (File folder : ((File)object2).listFiles()) {
                        if (!folder.isDirectory()) continue;
                        PSAppWF model = new PSAppWF();
                        model.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        model.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, folder.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSAppModule, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSAppModule pSAppModule, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppWFs(pSAppModule, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSAppModule, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppWFs(PSAppModule pSAppModule, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPWF", true), (boolean)false) == 0) {
            PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            PSAppWF pSAppWF = new PSAppWF();
            pSAppWF.setPSAppWFId(pSMOSFile.getPSModelId());
            if (!pSAppWFService.get(pSAppWF, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppWF.getPSAppModuleId(), (String)pSAppModule.getPSAppModuleId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppWFService.exportModelV2(pSAppWF);
            pSAppWF.reset();
            if (!pSAppWFService.setModelV2ResScope(pSAppWF, "PSAPPMODULE", pSAppModule.getPSAppModuleId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppWFService.importModelV2(pSAppWF, objectNode);
            SessionFactoryManager.commit();
            return pSAppWFService.getFile(pSAppWF);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWORKFLOW", true), (boolean)false) == 0) {
            PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = new PSWorkflow();
            pSWorkflow.setPSWorkflowId(pSMOSFile.getPSModelId());
            if (!pSWorkflowService.get(pSWorkflow, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            PSAppWF pSAppWF = new PSAppWF();
            pSAppWF.setPSAppModuleId(pSAppModule.getPSAppModuleId());
            pSAppWF.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            this.fillPasteEntity(pSAppWF, "PASTETAG");
            pSAppWFService.create(pSAppWF);
            SessionFactoryManager.commit();
            return pSAppWFService.getFile(pSAppWF);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSAppModule pSAppModule, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppWFs(pSAppModule, list);
        super.onFillPasteHelps(pSAppModule, list);
    }

    protected void onFillPasteHelps_PSAppWFs(PSAppModule pSAppModule, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWF");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u6a21\u5757]\u7684[\u5e94\u7528\u5de5\u4f5c\u6d41]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWF");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWF_PSAPPMODULE_PSAPPMODULEID");
        pSHelpSection.setUserTag("DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u5de5\u4f5c\u6d41\u7684[\u7cfb\u7edf\u5de5\u4f5c\u6d41]\u6784\u5efa[\u5e94\u7528\u5de5\u4f5c\u6d41]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSMOSFile pSMOSFile2;
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u89c6\u56fe>", "DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSAppModuleServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u89c6\u56fe>");
            } else if (PSAppModuleServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappviews");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID|PSAPPMODULEID");
            pSMOSFile2.setFileTag3("PSAPPVIEW");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSAppModuleServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u5b9e\u4f53>", "DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSAppModuleServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u5b9e\u4f53>");
            } else if (PSAppModuleServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapplocaldes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID|PSAPPMODULEID");
            pSMOSFile2.setFileTag3("PSAPPLOCALDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSAppModuleServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile pSMOSFile2;
        ArrayList<? extends IEntity> arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSAppModuleServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u89c6\u56fe>", (boolean)false) == 0 || PSAppModuleServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psappviews", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSAppModuleServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u5b9e\u4f53>", (boolean)false) == 0 || PSAppModuleServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psapplocaldes", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", "PSAPPMODULEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (IEntity entity : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, entity, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (arrayList2.size() > 0) {
            return PSMOSFileUtil.append(arrayList2.toArray(new PSMOSFile[arrayList2.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", (boolean)false) == 0) {
            if (PSAppModuleServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u89c6\u56fe>";
            }
            if (PSAppModuleServiceBase.getMOSVer() == 2) {
                return "psappviews";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", (boolean)false) == 0) {
            if (PSAppModuleServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u5b9e\u4f53>";
            }
            if (PSAppModuleServiceBase.getMOSVer() == 2) {
                return "psapplocaldes";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}
