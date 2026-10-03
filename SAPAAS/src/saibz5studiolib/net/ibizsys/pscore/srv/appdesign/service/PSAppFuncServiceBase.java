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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppFuncDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppFuncDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSubApp;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSubAppBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFunc;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubAppBase;
import net.ibizsys.pscore.srv.config.entity.PSSubAppView;
import net.ibizsys.pscore.srv.config.entity.PSSubAppViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppFuncServiceBase
extends PSCoreSysServiceBase<PSAppFunc> {
    private static final Log log = LogFactory.getLog(PSAppFuncServiceBase.class);
    public static final String DATASET_APPFUNCTYPE = "AppFuncType";
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCPSDEID = "CalcPSDEId";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSAppFuncDEModel pSAppFuncDEModel;
    private PSAppFuncDAO pSAppFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService";
    }

    public PSAppFuncDEModel getPSAppFuncDEModel() {
        if (this.pSAppFuncDEModel == null) {
            try {
                this.pSAppFuncDEModel = (PSAppFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppFuncDEModel();
    }

    public PSAppFuncDAO getPSAppFuncDAO() {
        if (this.pSAppFuncDAO == null) {
            try {
                this.pSAppFuncDAO = (PSAppFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppFuncDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_APPFUNCTYPE, (boolean)true) == 0) {
            return this.fetchAppFuncType(iDEDataSetFetchContext);
        }
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
        if (StringHelper.compare((String)string, (String)ACTION_CALCPSDEID, (boolean)true) == 0) {
            this.calcPSDEId((PSAppFunc)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchAppFuncType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_APPFUNCTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcPSDEId(PSAppFunc pSAppFunc) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCPSDEID, 0, pSAppFunc, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSAppFunc, ACTION_CALCPSDEID);
        final PSAppFunc pSAppFunc2 = pSAppFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppFuncServiceBase.this.getService(), PSAppFuncServiceBase.ACTION_CALCPSDEID, 40, pSAppFunc2, null).getResult() != 1) {
                    PSAppFuncServiceBase.this.onCalcPSDEId(pSAppFunc2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCPSDEID, 99, pSAppFunc, null);
        }
    }

    protected void onCalcPSDEId(PSAppFunc pSAppFunc) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcPSDEId]");
    }

    protected void onFillParentInfo(PSAppFunc pSAppFunc, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppLocalDE);
            } else {
                iService.get(pSAppLocalDE);
            }
            this.onFillParentInfo_PSAppLocalDE(pSAppFunc, pSAppLocalDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSAPPSUBAPP_PSAPPSUBAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService", (SessionFactory)this.getSessionFactory());
            PSAppSubApp pSAppSubApp = (PSAppSubApp)iService.getDEModel().createEntity();
            pSAppSubApp.set("PSAPPSUBAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppSubApp);
            } else {
                iService.get(pSAppSubApp);
            }
            this.onFillParentInfo_PSAppSubApp(pSAppFunc, pSAppSubApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSAppFunc, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSDEACMODE_PSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEACMode);
            } else {
                iService.get(pSDEACMode);
            }
            this.onFillParentInfo_PSDEACMode(pSAppFunc, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSAppFunc, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSDYNAAPP_PSDYNAAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService", (SessionFactory)this.getSessionFactory());
            PSDynaApp pSDynaApp = (PSDynaApp)iService.getDEModel().createEntity();
            pSDynaApp.set("PSDYNAAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaApp);
            } else {
                iService.get(pSDynaApp);
            }
            this.onFillParentInfo_PSDynaApp(pSAppFunc, pSDynaApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSLANGUAGERES_NAMEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_NamePSLanRes(pSAppFunc, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSAppFunc, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSPDTAPPFUNC_PSPDTAPPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService", (SessionFactory)this.getSessionFactory());
            PSPDTAppFunc pSPDTAppFunc = (PSPDTAppFunc)iService.getDEModel().createEntity();
            pSPDTAppFunc.set("PSPDTAPPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPDTAppFunc);
            } else {
                iService.get(pSPDTAppFunc);
            }
            this.onFillParentInfo_PSPDTAppFunc(pSAppFunc, pSPDTAppFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSSUBAPPVIEW_PSSUBAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppViewService", (SessionFactory)this.getSessionFactory());
            PSSubAppView pSSubAppView = (PSSubAppView)iService.getDEModel().createEntity();
            pSSubAppView.set("PSSUBAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubAppView);
            } else {
                iService.get(pSSubAppView);
            }
            this.onFillParentInfo_PSSubAppView(pSAppFunc, pSSubAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSSUBAPP_PSSUBAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppService", (SessionFactory)this.getSessionFactory());
            PSSubApp pSSubApp = (PSSubApp)iService.getDEModel().createEntity();
            pSSubApp.set("PSSUBAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubApp);
            } else {
                iService.get(pSSubApp);
            }
            this.onFillParentInfo_PSSubApp(pSAppFunc, pSSubApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppFunc, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSAppFunc, pSSysReqItem);
            return;
        }
        super.onFillParentInfo(pSAppFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppLocalDE(PSAppFunc pSAppFunc, PSAppLocalDE pSAppLocalDE) throws Exception {
        pSAppFunc.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
        pSAppFunc.setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
        pSAppFunc.setPSDEId(pSAppLocalDE.getPSDEId());
    }

    protected void onFillParentInfo_PSAppSubApp(PSAppFunc pSAppFunc, PSAppSubApp pSAppSubApp) throws Exception {
        pSAppFunc.setPSAppSubAppId(pSAppSubApp.getPSAppSubAppId());
        pSAppFunc.setPSAppSubAppName(pSAppSubApp.getPSAppSubAppName());
    }

    protected void onFillParentInfo_PSAppView(PSAppFunc pSAppFunc, PSAppView pSAppView) throws Exception {
        pSAppFunc.setPSAppViewId(pSAppView.getPSAppViewId());
        pSAppFunc.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSDEACMode(PSAppFunc pSAppFunc, PSDEACMode pSDEACMode) throws Exception {
        pSAppFunc.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSAppFunc.setPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSAppFunc pSAppFunc, PSDEUIAction pSDEUIAction) throws Exception {
        pSAppFunc.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSAppFunc.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_PSDynaApp(PSAppFunc pSAppFunc, PSDynaApp pSDynaApp) throws Exception {
        pSAppFunc.setPSDynaAppId(pSDynaApp.getPSDynaAppId());
        pSAppFunc.setPSDynaAppName(pSDynaApp.getPSDynaAppName());
    }

    protected void onFillParentInfo_NamePSLanRes(PSAppFunc pSAppFunc, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppFunc.setNamePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppFunc.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSAppFunc pSAppFunc, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppFunc.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppFunc.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSPDTAppFunc(PSAppFunc pSAppFunc, PSPDTAppFunc pSPDTAppFunc) throws Exception {
        pSAppFunc.setPSPDTAppFuncId(pSPDTAppFunc.getPSPDTAppFuncId());
        pSAppFunc.setPSPDTAppFuncName(pSPDTAppFunc.getPSPDTAppFuncName());
    }

    protected void onFillParentInfo_PSSubAppView(PSAppFunc pSAppFunc, PSSubAppView pSSubAppView) throws Exception {
        pSAppFunc.setPSSubAppViewId(pSSubAppView.getPSSubAppViewId());
        pSAppFunc.setPSSubAppViewName(pSSubAppView.getPSSubAppViewName());
    }

    protected void onFillParentInfo_PSSubApp(PSAppFunc pSAppFunc, PSSubApp pSSubApp) throws Exception {
        pSAppFunc.setPSSubAppId(pSSubApp.getPSSubAppId());
        pSAppFunc.setPSSubAppName(pSSubApp.getPSSubAppName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppFunc pSAppFunc, PSSysApp pSSysApp) throws Exception {
        pSAppFunc.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppFunc.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSAppFunc pSAppFunc, PSSysReqItem pSSysReqItem) throws Exception {
        pSAppFunc.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSAppFunc.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillEntityFullInfo(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        if (bl) {
            if (pSAppFunc.getCodeName() == null) {
                pSAppFunc.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "AppFunc", 25));
            }
            if (pSAppFunc.getSystemFlag() == null) {
                pSAppFunc.setSystemFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSAppLocalDE(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSAppSubApp(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSAppView(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSDEACMode(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSDynaApp(pSAppFunc, bl);
        this.onFillEntityFullInfo_NamePSLanRes(pSAppFunc, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSPDTAppFunc(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSSubAppView(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSSubApp(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppFunc, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSAppFunc, bl);
    }

    protected void onFillEntityFullInfo_PSAppLocalDE(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppSubApp(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppView(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEACMode(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaApp(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NamePSLanRes(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        if (pSAppFunc.isNamePSLanResIdDirty()) {
            if (pSAppFunc.getNamePSLanResId() != null) {
                if (pSAppFunc.getNamePSLanResId() == null || pSAppFunc.getNamePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppFunc.getNamePSLanRes();
                    pSAppFunc.setNamePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppFunc.setNamePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        if (pSAppFunc.isTipPSLanResIdDirty()) {
            if (pSAppFunc.getTipPSLanResId() != null) {
                if (pSAppFunc.getTipPSLanResId() == null || pSAppFunc.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppFunc.getTipPSLanRes();
                    pSAppFunc.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppFunc.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPDTAppFunc(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubAppView(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubApp(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSAppFunc pSAppFunc, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppFunc, bl);
    }

    public ArrayList<PSAppFunc> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPLOCALDEID", (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppLocalDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppLocalDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSAppSubApp(PSAppSubAppBase pSAppSubAppBase) throws Exception {
        return this.selectByPSAppSubApp(pSAppSubAppBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppSubApp(PSAppSubAppBase pSAppSubAppBase, String string) throws Exception {
        return this.selectByPSAppSubApp(pSAppSubAppBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppSubApp(PSAppSubAppBase pSAppSubAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPSUBAPPID", (Object)pSAppSubAppBase.getPSAppSubAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppSubAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppSubAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppFunc> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppFunc> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string) throws Exception {
        return this.selectByPSDynaApp(pSDynaAppBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSDynaApp(PSDynaAppBase pSDynaAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPID", (Object)pSDynaAppBase.getPSDynaAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByNamePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByNamePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAMEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNamePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNamePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppFunc> selectByPSPDTAppFunc(PSPDTAppFuncBase pSPDTAppFuncBase) throws Exception {
        return this.selectByPSPDTAppFunc(pSPDTAppFuncBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSPDTAppFunc(PSPDTAppFuncBase pSPDTAppFuncBase, String string) throws Exception {
        return this.selectByPSPDTAppFunc(pSPDTAppFuncBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSPDTAppFunc(PSPDTAppFuncBase pSPDTAppFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPDTAPPFUNCID", (Object)pSPDTAppFuncBase.getPSPDTAppFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPDTAppFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPDTAppFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSSubAppView(PSSubAppViewBase pSSubAppViewBase) throws Exception {
        return this.selectByPSSubAppView(pSSubAppViewBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSSubAppView(PSSubAppViewBase pSSubAppViewBase, String string) throws Exception {
        return this.selectByPSSubAppView(pSSubAppViewBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSSubAppView(PSSubAppViewBase pSSubAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBAPPVIEWID", (Object)pSSubAppViewBase.getPSSubAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSSubApp(PSSubAppBase pSSubAppBase) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string) throws Exception {
        return this.selectByPSSubApp(pSSubAppBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSSubApp(PSSubAppBase pSSubAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBAPPID", (Object)pSSubAppBase.getPSSubAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppFunc> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppFunc> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSAppFunc> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSAppFunc> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPLOCALDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppLocalDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSAPPLOCALDE_PSAPPLOCALDEID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSAppLocalDE), arrayList.get(0)));
        }
    }

    public void resetPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSAppLocalDEId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppFuncServiceBase.this.internalRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppSubApp(pSAppSubApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPSUBAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppSubApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSAPPSUBAPP_PSAPPSUBAPPID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSAppSubApp), arrayList.get(0)));
        }
    }

    public void resetPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppSubApp(pSAppSubApp);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSAppSubAppId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
        final PSAppSubApp pSAppSubApp2 = pSAppSubApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSAppSubApp(pSAppSubApp2);
                PSAppFuncServiceBase.this.internalRemoveByPSAppSubApp(pSAppSubApp2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSAppSubApp(pSAppSubApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
    }

    protected void internalRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppSubApp(pSAppSubApp);
        this.onBeforeRemoveByPSAppSubApp(pSAppSubApp, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSAppSubApp(pSAppSubApp, arrayList);
    }

    protected void onAfterRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp) throws Exception {
    }

    protected void onBeforeRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppSubApp(PSAppSubApp pSAppSubApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSAPPVIEW_PSAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSAppView), arrayList.get(0)));
        }
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppView(pSAppView);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSAppViewId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSAppFuncServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSDEACMODE_PSDEACMODEID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEACMode(pSDEACMode);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSDEACModeId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSDEACMode(pSDEACMode2);
                PSAppFuncServiceBase.this.internalRemoveByPSDEACMode(pSDEACMode2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByPSDEACMode(pSDEACMode, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSDEUIActionId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSAppFuncServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDynaApp(pSDynaApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSDYNAAPP_PSDYNAAPPID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSDynaApp), arrayList.get(0)));
        }
    }

    public void resetPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDynaApp(pSDynaApp);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSDynaAppId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        final PSDynaApp pSDynaApp2 = pSDynaApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSDynaApp(pSDynaApp2);
                PSAppFuncServiceBase.this.internalRemoveByPSDynaApp(pSDynaApp2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSDynaApp(pSDynaApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void internalRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSDynaApp(pSDynaApp);
        this.onBeforeRemoveByPSDynaApp(pSDynaApp, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSDynaApp(pSDynaApp, arrayList);
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaApp(PSDynaApp pSDynaApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByNamePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSLANGUAGERES_NAMEPSLANRESID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setNamePSLanResId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByNamePSLanRes(pSLanguageRes2);
                PSAppFuncServiceBase.this.internalRemoveByNamePSLanRes(pSLanguageRes2);
                PSAppFuncServiceBase.this.onAfterRemoveByNamePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByNamePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByNamePSLanRes(pSLanguageRes, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByNamePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNamePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setTipPSLanResId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSAppFuncServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSAppFuncServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSPDTAppFunc(pSPDTAppFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPDTAPPFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPDTAppFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSPDTAPPFUNC_PSPDTAPPFUNCID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSPDTAppFunc), arrayList.get(0)));
        }
    }

    public void resetPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSPDTAppFunc(pSPDTAppFunc);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSPDTAppFuncId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        final PSPDTAppFunc pSPDTAppFunc2 = pSPDTAppFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSPDTAppFunc(pSPDTAppFunc2);
                PSAppFuncServiceBase.this.internalRemoveByPSPDTAppFunc(pSPDTAppFunc2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSPDTAppFunc(pSPDTAppFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
    }

    protected void internalRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSPDTAppFunc(pSPDTAppFunc);
        this.onBeforeRemoveByPSPDTAppFunc(pSPDTAppFunc, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSPDTAppFunc(pSPDTAppFunc, arrayList);
    }

    protected void onAfterRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPDTAppFunc(PSPDTAppFunc pSPDTAppFunc, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubAppView(pSSubAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSSUBAPPVIEW_PSSUBAPPVIEWID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSSubAppView), arrayList.get(0)));
        }
    }

    public void resetPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubAppView(pSSubAppView);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSSubAppViewId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
        final PSSubAppView pSSubAppView2 = pSSubAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSSubAppView(pSSubAppView2);
                PSAppFuncServiceBase.this.internalRemoveByPSSubAppView(pSSubAppView2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSSubAppView(pSSubAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
    }

    protected void internalRemoveByPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubAppView(pSSubAppView);
        this.onBeforeRemoveByPSSubAppView(pSSubAppView, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSSubAppView(pSSubAppView, arrayList);
    }

    protected void onAfterRemoveByPSSubAppView(PSSubAppView pSSubAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSSubAppView(PSSubAppView pSSubAppView, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubAppView(PSSubAppView pSSubAppView, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubApp(pSSubApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSSUBAPP_PSSUBAPPID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSSubApp), arrayList.get(0)));
        }
    }

    public void resetPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubApp(pSSubApp);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSSubAppId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSSubApp(PSSubApp pSSubApp) throws Exception {
        final PSSubApp pSSubApp2 = pSSubApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSSubApp(pSSubApp2);
                PSAppFuncServiceBase.this.internalRemoveByPSSubApp(pSSubApp2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSSubApp(pSSubApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void internalRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSubApp(pSSubApp);
        this.onBeforeRemoveByPSSubApp(pSSubApp, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSSubApp(pSSubApp, arrayList);
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubApp(PSSubApp pSSubApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSSysAppId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppFuncServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPFUNC_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSAPPFUNC", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSAppFunc pSAppFunc : arrayList) {
            PSAppFunc pSAppFunc2 = (PSAppFunc)this.getDEModel().createEntity();
            pSAppFunc2.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
            pSAppFunc2.setPSSysReqItemId(null);
            this.update(pSAppFunc2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppFuncServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppFuncServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppFuncServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppFunc> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSAppFunc pSAppFunc : arrayList) {
            this.remove(pSAppFunc);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppFunc> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppFunc pSAppFunc) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppFunc(pSAppFunc);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSAppFunc(pSAppFunc);
        super.onBeforeRemove(pSAppFunc);
    }

    protected void replaceParentInfo(PSAppFunc pSAppFunc, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppFunc, cloneSession);
        if (pSAppFunc.getPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)pSAppFunc.getPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PSAppLocalDE(pSAppFunc, (PSAppLocalDE)iEntity);
        }
        if (pSAppFunc.getPSAppSubAppId() != null && (iEntity = cloneSession.getEntity("PSAPPSUBAPP", (Object)pSAppFunc.getPSAppSubAppId())) != null) {
            this.onFillParentInfo_PSAppSubApp(pSAppFunc, (PSAppSubApp)iEntity);
        }
        if (pSAppFunc.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppFunc.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSAppFunc, (PSAppView)iEntity);
        }
        if (pSAppFunc.getPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSAppFunc.getPSDEACModeId())) != null) {
            this.onFillParentInfo_PSDEACMode(pSAppFunc, (PSDEACMode)iEntity);
        }
        if (pSAppFunc.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSAppFunc.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSAppFunc, (PSDEUIAction)iEntity);
        }
        if (pSAppFunc.getPSDynaAppId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPP", (Object)pSAppFunc.getPSDynaAppId())) != null) {
            this.onFillParentInfo_PSDynaApp(pSAppFunc, (PSDynaApp)iEntity);
        }
        if (pSAppFunc.getNamePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppFunc.getNamePSLanResId())) != null) {
            this.onFillParentInfo_NamePSLanRes(pSAppFunc, (PSLanguageRes)iEntity);
        }
        if (pSAppFunc.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppFunc.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSAppFunc, (PSLanguageRes)iEntity);
        }
        if (pSAppFunc.getPSPDTAppFuncId() != null && (iEntity = cloneSession.getEntity("PSPDTAPPFUNC", (Object)pSAppFunc.getPSPDTAppFuncId())) != null) {
            this.onFillParentInfo_PSPDTAppFunc(pSAppFunc, (PSPDTAppFunc)iEntity);
        }
        if (pSAppFunc.getPSSubAppViewId() != null && (iEntity = cloneSession.getEntity("PSSUBAPPVIEW", (Object)pSAppFunc.getPSSubAppViewId())) != null) {
            this.onFillParentInfo_PSSubAppView(pSAppFunc, (PSSubAppView)iEntity);
        }
        if (pSAppFunc.getPSSubAppId() != null && (iEntity = cloneSession.getEntity("PSSUBAPP", (Object)pSAppFunc.getPSSubAppId())) != null) {
            this.onFillParentInfo_PSSubApp(pSAppFunc, (PSSubApp)iEntity);
        }
        if (pSAppFunc.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppFunc.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppFunc, (PSSysApp)iEntity);
        }
        if (pSAppFunc.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSAppFunc.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSAppFunc, (PSSysReqItem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppFunc, bl);
        pSAppFunc.resetCodeName();
        pSAppFunc.resetFromObjId();
    }

    protected void onCheckEntity(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppFuncType(bl, pSAppFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstTag(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaInstTag2(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromObjId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FuncSN(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSCode(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NamePSLanResName(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenMode(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenViewParam(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageUrl(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedTypeParam(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppFuncId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppFuncName(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSubAppId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEACModeId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPDTAppFuncId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubAppViewId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SystemFlag(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppFuncType(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isAppFuncTypeDirty() && !bl2 : !pSAppFunc.isAppFuncTypeDirty()) {
            return null;
        }
        String string = pSAppFunc.getAppFuncType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPFUNCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppFuncType_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPFUNCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isCodeNameDirty() : !pSAppFunc.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppFunc.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppFunc, bl2, bl3);
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppFuncDEModel(), "CODENAME", string3, pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaInstTag(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isDynaInstTagDirty() : !pSAppFunc.isDynaInstTagDirty()) {
            return null;
        }
        String string = pSAppFunc.getDynaInstTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaInstTag_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaInstTag2(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isDynaInstTag2Dirty() : !pSAppFunc.isDynaInstTag2Dirty()) {
            return null;
        }
        String string = pSAppFunc.getDynaInstTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaInstTag2_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAINSTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isDynaModelFlagDirty() : !pSAppFunc.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSAppFunc.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_FromObjId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isFromObjIdDirty() : !pSAppFunc.isFromObjIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getFromObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromObjId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_FuncSN(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isFuncSNDirty() : !pSAppFunc.isFuncSNDirty()) {
            return null;
        }
        String string = pSAppFunc.getFuncSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FuncSN_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSCode(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isJSCodeDirty() : !pSAppFunc.isJSCodeDirty()) {
            return null;
        }
        String string = pSAppFunc.getJSCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSCode_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isMemoDirty() : !pSAppFunc.isMemoDirty()) {
            return null;
        }
        String string = pSAppFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_NamePSLanResId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isNamePSLanResIdDirty() : !pSAppFunc.isNamePSLanResIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getNamePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NamePSLanResName(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isNamePSLanResNameDirty() : !pSAppFunc.isNamePSLanResNameDirty()) {
            return null;
        }
        String string = pSAppFunc.getNamePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NamePSLanResName_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAMEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenMode(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isOpenModeDirty() : !pSAppFunc.isOpenModeDirty()) {
            return null;
        }
        String string = pSAppFunc.getOpenMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenMode_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenViewParam(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isOpenViewParamDirty() : !pSAppFunc.isOpenViewParamDirty()) {
            return null;
        }
        String string = pSAppFunc.getOpenViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenViewParam_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageUrl(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPageUrlDirty() : !pSAppFunc.isPageUrlDirty()) {
            return null;
        }
        String string = pSAppFunc.getPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PageUrl_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPredefinedTypeDirty() : !pSAppFunc.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSAppFunc.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedTypeParam(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPredefinedTypeParamDirty() : !pSAppFunc.isPredefinedTypeParamDirty()) {
            return null;
        }
        String string = pSAppFunc.getPredefinedTypeParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedTypeParam_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppFuncId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSAppFuncIdDirty() && !bl2 : !pSAppFunc.isPSAppFuncIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSAppFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppFuncId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppFuncName(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSAppFuncNameDirty() && !bl2 : !pSAppFunc.isPSAppFuncNameDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSAppFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppFuncName_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSAppLocalDEIdDirty() : !pSAppFunc.isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSubAppId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSAppSubAppIdDirty() : !pSAppFunc.isPSAppSubAppIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSAppSubAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSubAppId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSAppViewIdDirty() : !pSAppFunc.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_PSAppView(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSAppViewId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEACModeId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSDEACModeIdDirty() : !pSAppFunc.isPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEACModeId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSDEUIActionIdDirty() : !pSAppFunc.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaAppId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSDynaAppIdDirty() : !pSAppFunc.isPSDynaAppIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSDynaAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPDTAppFuncId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSPDTAppFuncIdDirty() : !pSAppFunc.isPSPDTAppFuncIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSPDTAppFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPDTAppFuncId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPDTAPPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSSubAppIdDirty() : !pSAppFunc.isPSSubAppIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSSubAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppId_PSSubApp(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSSubAppId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubAppViewId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSSubAppViewIdDirty() : !pSAppFunc.isPSSubAppViewIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSSubAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubAppViewId_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSSysAppIdDirty() && !bl2 : !pSAppFunc.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isPSSysReqItemIdDirty() : !pSAppFunc.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_SystemFlag(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isSystemFlagDirty() : !pSAppFunc.isSystemFlagDirty()) {
            return null;
        }
        Integer n = pSAppFunc.getSystemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SystemFlag_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isTipPSLanResIdDirty() : !pSAppFunc.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSAppFunc.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isTipPSLanResNameDirty() : !pSAppFunc.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSAppFunc.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isTooltipInfoDirty() : !pSAppFunc.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSAppFunc.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserCatDirty() : !pSAppFunc.isUserCatDirty()) {
            return null;
        }
        String string = pSAppFunc.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserDataDirty() : !pSAppFunc.isUserDataDirty()) {
            return null;
        }
        String string = pSAppFunc.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserData2Dirty() : !pSAppFunc.isUserData2Dirty()) {
            return null;
        }
        String string = pSAppFunc.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserParamsDirty() : !pSAppFunc.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppFunc.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserTagDirty() : !pSAppFunc.isUserTagDirty()) {
            return null;
        }
        String string = pSAppFunc.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserTag2Dirty() : !pSAppFunc.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppFunc.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserTag3Dirty() : !pSAppFunc.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppFunc.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppFunc pSAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppFunc.isUserTag4Dirty() : !pSAppFunc.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppFunc.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppFunc, bl2, bl3);
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

    protected void onSyncEntity(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSAppFunc, bl);
    }

    protected void onSyncIndexEntities(PSAppFunc pSAppFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppFunc, bl);
    }

    public Object getDataContextValue(PSAppFunc pSAppFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppFunc, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppFunc.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppFunc pSAppFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_NamePSLanRes(pSAppFunc, arrayList, n);
        this.onExportMajorModel_TipPSLanRes(pSAppFunc, arrayList, n);
        super.onExportMajorModel(pSAppFunc, arrayList, n);
    }

    protected void onExportMajorModel_NamePSLanRes(PSAppFunc pSAppFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppFunc.getNamePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSAppFunc.getNamePSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TipPSLanRes(PSAppFunc pSAppFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppFunc.getTipPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSAppFunc.getTipPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPFUNCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppFuncType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAINSTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAINSTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaInstTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FuncSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAMEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NamePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSubAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSUBAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSubAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSAPPVIEW", (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_PSAppView(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPDTAPPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPDTAppFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPDTAPPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPDTAppFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSSUBAPP", (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppId_PSSubApp(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SystemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AppFuncType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPFUNCTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_DynaInstTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAINSTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaInstTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAINSTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FuncSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JSCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_NamePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NamePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAMEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENMODE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENVIEWPARAM", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PAGEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_PredefinedTypeParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPEPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSubAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSUBAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSubAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSUBAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_PSAppView(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSAPPVIEWID", "PSAPPVIEW", DATASET_CURAPP, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5e94\u7528\u89c6\u56fe\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSDynaAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPDTAppFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPDTAPPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPDTAppFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPDTAPPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppId_PSSubApp(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSSUBAPPID", "PSSUBAPP", DATASET_CURAPP, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b50\u7cfb\u7edf\u5e94\u7528\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBAPPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SystemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSAppFunc pSAppFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppFunc pSAppFunc) throws Exception {
        Object object = pSAppFunc.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppFunc);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppFunc pSAppFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPFUNC");
        if (!bl) {
            pSAppFunc.setCreateDate(null);
            pSAppFunc.setCreateMan(null);
            pSAppFunc.setPSAppFuncId(null);
            pSAppFunc.setUpdateDate(null);
            pSAppFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSAppFunc, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppFunc pSAppFunc, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppFunc, string);
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
            return "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID";
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
    public String getModelV2Tag(PSAppFunc pSAppFunc) {
        if (!StringHelper.isNullOrEmpty((String)pSAppFunc.getCodeName())) {
            return pSAppFunc.getCodeName();
        }
        return super.getModelV2Tag(pSAppFunc);
    }

    @Override
    public boolean setModelV2Tag(PSAppFunc pSAppFunc, String string) {
        pSAppFunc.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppFunc pSAppFunc, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppFunc.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppFunc, true);
        pSAppFunc.set("CODENAME", string);
        if (this.select(pSAppFunc, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppFunc, true);
        return super.getModelV2Entity(pSAppFunc, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppFunc pSAppFunc, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppFunc, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSAppFunc pSAppFunc, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "AppFunc");
    }
}

