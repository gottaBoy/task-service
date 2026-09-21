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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppLocalDEDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppLocalDEDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppLocalDEServiceBase
extends PSCoreSysServiceBase<PSAppLocalDE> {
    private static final Log log = LogFactory.getLog(PSAppLocalDEServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_REBUILDALL = "RebuildAll";
    private PSAppLocalDEDEModel pSAppLocalDEDEModel;
    private PSAppLocalDEDAO pSAppLocalDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService";
    }

    public PSAppLocalDEDEModel getPSAppLocalDEDEModel() {
        if (this.pSAppLocalDEDEModel == null) {
            try {
                this.pSAppLocalDEDEModel = (PSAppLocalDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppLocalDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppLocalDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppLocalDEDEModel();
    }

    public PSAppLocalDEDAO getPSAppLocalDEDAO() {
        if (this.pSAppLocalDEDAO == null) {
            try {
                this.pSAppLocalDEDAO = (PSAppLocalDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppLocalDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppLocalDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppLocalDEDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_REBUILDALL, (boolean)true) == 0) {
            this.rebuildAll((PSAppLocalDE)iEntity);
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

    public void rebuildAll(PSAppLocalDE pSAppLocalDE) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDALL, 0, (IEntity)pSAppLocalDE, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSAppLocalDE, ACTION_REBUILDALL);
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppLocalDEServiceBase.this.getService(), PSAppLocalDEServiceBase.ACTION_REBUILDALL, 40, (IEntity)pSAppLocalDE2, null).getResult() != 1) {
                    PSAppLocalDEServiceBase.this.onRebuildAll(pSAppLocalDE2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REBUILDALL, 99, (IEntity)pSAppLocalDE, null);
        }
    }

    protected void onRebuildAll(PSAppLocalDE pSAppLocalDE) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RebuildAll]");
    }

    protected void onFillParentInfo(PSAppLocalDE pSAppLocalDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSAPPLOCALDE_PPSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE2.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppLocalDE2);
            } else {
                iService.get((IEntity)pSAppLocalDE2);
            }
            this.onFillParentInfo_PPSAppLocalDE(pSAppLocalDE, pSAppLocalDE2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory());
            PSAppModule pSAppModule = (PSAppModule)iService.getDEModel().createEntity();
            pSAppModule.set("PSAPPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppModule);
            } else {
                iService.get((IEntity)pSAppModule);
            }
            this.onFillParentInfo_PSAppModule(pSAppLocalDE, pSAppModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSAppLocalDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSAppLocalDE, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_PSDER(pSAppLocalDE, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEServiceAPI);
            } else {
                iService.get((IEntity)pSDEServiceAPI);
            }
            this.onFillParentInfo_PSDEServiceAPI(pSAppLocalDE, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSAppLocalDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDEVIEWBASE_MDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MDPSDEView(pSAppLocalDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSDEVIEWBASE_SDPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_SDPSDEView(pSAppLocalDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSAppLocalDE, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppLocalDE, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSAppLocalDE, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSAppLocalDE, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysServiceAPI);
            } else {
                iService.get((IEntity)pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSAppLocalDE, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSAppLocalDE, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPLOCALDE_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSAppLocalDE, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppLocalDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSAppLocalDE(PSAppLocalDE pSAppLocalDE, PSAppLocalDE pSAppLocalDE2) throws Exception {
        pSAppLocalDE.setPPSAppLocalDEId(pSAppLocalDE2.getPSAppLocalDEId());
        pSAppLocalDE.setPPSAppLocalDEName(pSAppLocalDE2.getPSAppLocalDEName());
    }

    protected void onFillParentInfo_PSAppModule(PSAppLocalDE pSAppLocalDE, PSAppModule pSAppModule) throws Exception {
        pSAppLocalDE.setPSAppModuleId(pSAppModule.getPSAppModuleId());
        pSAppLocalDE.setPSAppModuleName(pSAppModule.getPSAppModuleName());
    }

    protected void onFillParentInfo_PSDE(PSAppLocalDE pSAppLocalDE, PSDataEntity pSDataEntity) throws Exception {
        pSAppLocalDE.setDECodeName(pSDataEntity.getCodeName());
        pSAppLocalDE.setDELogicName(pSDataEntity.getLogicName());
        pSAppLocalDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSAppLocalDE.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSAppLocalDE.setPSModuleId(pSDataEntity.getPSModuleId());
    }

    protected void onFillParentInfo_PSDEFGroup(PSAppLocalDE pSAppLocalDE, PSDEFGroup pSDEFGroup) throws Exception {
        pSAppLocalDE.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSAppLocalDE.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSDER(PSAppLocalDE pSAppLocalDE, PSDER pSDER) throws Exception {
        pSAppLocalDE.setPSDERId(pSDER.getPSDERId());
        pSAppLocalDE.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEServiceAPI(PSAppLocalDE pSAppLocalDE, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSAppLocalDE.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSAppLocalDE.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSAppLocalDE pSAppLocalDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSAppLocalDE.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSAppLocalDE.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MDPSDEView(PSAppLocalDE pSAppLocalDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSAppLocalDE.setMDPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSAppLocalDE.setMDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_SDPSDEView(PSAppLocalDE pSAppLocalDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSAppLocalDE.setSDPSDEViewID(pSDEViewBase.getPSDEViewBaseId());
        pSAppLocalDE.setSDPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_LNPSLanRes(PSAppLocalDE pSAppLocalDE, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppLocalDE.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppLocalDE.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppLocalDE pSAppLocalDE, PSSysApp pSSysApp) throws Exception {
        pSAppLocalDE.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppLocalDE.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSAppLocalDE pSAppLocalDE, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSAppLocalDE.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSAppLocalDE.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSAppLocalDE pSAppLocalDE, PSSysReqItem pSSysReqItem) throws Exception {
        pSAppLocalDE.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSAppLocalDE.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSAppLocalDE pSAppLocalDE, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSAppLocalDE.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSAppLocalDE.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSAppLocalDE pSAppLocalDE, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSAppLocalDE.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSAppLocalDE.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSAppLocalDE pSAppLocalDE, PSSysUniRes pSSysUniRes) throws Exception {
        pSAppLocalDE.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSAppLocalDE.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected boolean onFillEntityKeyValue(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSAppLocalDE.get("PSSYSAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSAppLocalDE.get("PSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSAppLocalDE.set(this.getPSAppLocalDEDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        if (bl) {
            if (pSAppLocalDE.getDefaultFlag() == null) {
                pSAppLocalDE.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSAppLocalDE.getEnableStorage() == null) {
                pSAppLocalDE.setEnableStorage((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppLocalDE.getMajorFlag() == null) {
                pSAppLocalDE.setMajorFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "2", 9));
            }
            if (pSAppLocalDE.getPSAppLocalDEName() == null) {
                pSAppLocalDE.setPSAppLocalDEName((String)this.getDefaultValue(this.getWebContext(), "", "\u5b9e\u4f53\u540d\u79f0", 25));
            }
            if (pSAppLocalDE.getValidFlag() == null) {
                pSAppLocalDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PPSAppLocalDE(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSAppModule(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSDE(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSDER(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSDEServiceAPI(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_MDPSDEView(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_SDPSDEView(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSAppLocalDE, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSAppLocalDE, bl);
    }

    protected void onFillEntityFullInfo_PPSAppLocalDE(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppModule(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEServiceAPI(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSDEView(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SDPSDEView(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        if (pSAppLocalDE.isLNPSLanResIdDirty()) {
            if (pSAppLocalDE.getLNPSLanResId() != null) {
                if (pSAppLocalDE.getLNPSLanResId() == null || pSAppLocalDE.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppLocalDE.getLNPSLanRes();
                    pSAppLocalDE.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppLocalDE.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppLocalDE, bl);
    }

    public ArrayList<PSAppLocalDE> selectByPPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPLOCALDEID", (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSAppLocalDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSAppLocalDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSAppModule(PSAppModuleBase pSAppModuleBase) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMODULEID", (Object)pSAppModuleBase.getPSAppModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppLocalDE> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESERVICEAPIID", (Object)pSDEServiceAPIBase.getPSDEServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByMDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectBySDPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectBySDPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectBySDPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SDPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySDPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySDPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppLocalDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppLocalDE> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppLocalDE> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSERVICEAPIID", (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppLocalDE> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSAppLocalDE> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPPSAppLocalDE(pSAppLocalDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPLOCALDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppLocalDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSAPPLOCALDE_PPSAPPLOCALDEID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSAppLocalDE), arrayList.get(0)));
        }
    }

    public void resetPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPPSAppLocalDE(pSAppLocalDE);
        for (PSAppLocalDE pSAppLocalDE2 : arrayList) {
            PSAppLocalDE pSAppLocalDE3 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE3.setPSAppLocalDEId(pSAppLocalDE2.getPSAppLocalDEId());
            pSAppLocalDE3.setPPSAppLocalDEId(null);
            this.update(pSAppLocalDE3);
        }
    }

    public void removeByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPPSAppLocalDE(pSAppLocalDE2);
                PSAppLocalDEServiceBase.this.internalRemoveByPPSAppLocalDE(pSAppLocalDE2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPPSAppLocalDE(pSAppLocalDE, arrayList);
        for (PSAppLocalDE pSAppLocalDE2 : arrayList) {
            this.remove((IEntity)pSAppLocalDE2);
        }
        this.onAfterRemoveByPPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSAppModule(pSAppModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSAppModule), arrayList.get(0)));
        }
    }

    public void resetPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSAppModule(pSAppModule);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSAppModuleId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSAppModule(PSAppModule pSAppModule) throws Exception {
        final PSAppModule pSAppModule2 = pSAppModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSAppModule(pSAppModule2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSAppModule(pSAppModule2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSAppModule(pSAppModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void internalRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSAppModule(pSAppModule);
        this.onBeforeRemoveByPSAppModule(pSAppModule, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSAppModule(pSAppModule, arrayList);
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSDEId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSDEFGroupId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDER(pSDER);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSDERId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDESERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDESERVICEAPI_PSDESERVICEAPIID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDEServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSDEServiceAPIId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setLinkPSDEViewId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByMDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDEVIEWBASE_MDPSDEVIEWID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByMDPSDEView(pSDEViewBase);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setMDPSDEViewId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByMDPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.internalRemoveByMDPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByMDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByMDPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMDPSDEView(pSDEViewBase, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByMDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectBySDPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSDEVIEWBASE_SDPSDEVIEWID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetSDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectBySDPSDEView(pSDEViewBase);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setSDPSDEViewID(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveBySDPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.internalRemoveBySDPSDEView(pSDEViewBase2);
                PSAppLocalDEServiceBase.this.onAfterRemoveBySDPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectBySDPSDEView(pSDEViewBase);
        this.onBeforeRemoveBySDPSDEView(pSDEViewBase, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveBySDPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveBySDPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveBySDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySDPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setLNPSLanResId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSAppLocalDEServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysAppId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysDynaModelId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysReqItemId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysServiceAPIId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysSFPluginId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPLOCALDE_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSAPPLOCALDE", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            PSAppLocalDE pSAppLocalDE2 = (PSAppLocalDE)this.getDEModel().createEntity();
            pSAppLocalDE2.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
            pSAppLocalDE2.setPSSysUniResId(null);
            this.update(pSAppLocalDE2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppLocalDEServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppLocalDEServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppLocalDEServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSAppLocalDE> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSAppLocalDE pSAppLocalDE : arrayList) {
            this.remove((IEntity)pSAppLocalDE);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSAppLocalDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppLocalDE pSAppLocalDE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDERSServiceBase)pSCoreSysServiceBase).testRemoveByCPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDERSServiceBase)pSCoreSysServiceBase).testRemoveByPPSAppLocalDE(pSAppLocalDE);
        ((PSAppDERSServiceBase)pSCoreSysServiceBase).removeByPPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSAppDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppLocalDE(pSAppLocalDE);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSAppLocalDE(pSAppLocalDE);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSAppLocalDE(pSAppLocalDE);
        super.onBeforeRemove(pSAppLocalDE);
    }

    protected void replaceParentInfo(PSAppLocalDE pSAppLocalDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppLocalDE, cloneSession);
        if (pSAppLocalDE.getPPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)pSAppLocalDE.getPPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PPSAppLocalDE(pSAppLocalDE, (PSAppLocalDE)iEntity);
        }
        if (pSAppLocalDE.getPSAppModuleId() != null && (iEntity = cloneSession.getEntity("PSAPPMODULE", (Object)pSAppLocalDE.getPSAppModuleId())) != null) {
            this.onFillParentInfo_PSAppModule(pSAppLocalDE, (PSAppModule)iEntity);
        }
        if (pSAppLocalDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSAppLocalDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSAppLocalDE, (PSDataEntity)iEntity);
        }
        if (pSAppLocalDE.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSAppLocalDE.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSAppLocalDE, (PSDEFGroup)iEntity);
        }
        if (pSAppLocalDE.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSAppLocalDE.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSAppLocalDE, (PSDER)iEntity);
        }
        if (pSAppLocalDE.getPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSAppLocalDE.getPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PSDEServiceAPI(pSAppLocalDE, (PSDEServiceAPI)iEntity);
        }
        if (pSAppLocalDE.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSAppLocalDE.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSAppLocalDE, (PSDEViewBase)iEntity);
        }
        if (pSAppLocalDE.getMDPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSAppLocalDE.getMDPSDEViewId())) != null) {
            this.onFillParentInfo_MDPSDEView(pSAppLocalDE, (PSDEViewBase)iEntity);
        }
        if (pSAppLocalDE.getSDPSDEViewID() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSAppLocalDE.getSDPSDEViewID())) != null) {
            this.onFillParentInfo_SDPSDEView(pSAppLocalDE, (PSDEViewBase)iEntity);
        }
        if (pSAppLocalDE.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppLocalDE.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSAppLocalDE, (PSLanguageRes)iEntity);
        }
        if (pSAppLocalDE.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppLocalDE.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppLocalDE, (PSSysApp)iEntity);
        }
        if (pSAppLocalDE.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSAppLocalDE.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSAppLocalDE, (PSSysDynaModel)iEntity);
        }
        if (pSAppLocalDE.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSAppLocalDE.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSAppLocalDE, (PSSysReqItem)iEntity);
        }
        if (pSAppLocalDE.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSAppLocalDE.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSAppLocalDE, (PSSysServiceAPI)iEntity);
        }
        if (pSAppLocalDE.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSAppLocalDE.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSAppLocalDE, (PSSysSFPlugin)iEntity);
        }
        if (pSAppLocalDE.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSAppLocalDE.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSAppLocalDE, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppLocalDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccCtrlArch(bl, pSAppLocalDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoAddMethodMode(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoAddViewMode(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BaseClsParams(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomUserAction(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataAccMode(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFGroupMode(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableStorage(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorFlag(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEViewId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSAppLocalDEId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEName(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDPSDEViewID(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserAction(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppLocalDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppLocalDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccCtrlArch(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isAccCtrlArchDirty() : !pSAppLocalDE.isAccCtrlArchDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getAccCtrlArch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AccCtrlArch_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCCTRLARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoAddMethodMode(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isAutoAddMethodModeDirty() : !pSAppLocalDE.isAutoAddMethodModeDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getAutoAddMethodMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoAddMethodMode_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTOADDMETHODMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoAddViewMode(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isAutoAddViewModeDirty() : !pSAppLocalDE.isAutoAddViewModeDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getAutoAddViewMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoAddViewMode_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTOADDVIEWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BaseClsParams(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isBaseClsParamsDirty() : !pSAppLocalDE.isBaseClsParamsDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getBaseClsParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BaseClsParams_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isCodeNameDirty() : !pSAppLocalDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSAppLocalDE, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSAppLocalDEDEModel(), "CODENAME", string3, pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isCodeName2Dirty() : !pSAppLocalDE.isCodeName2Dirty()) {
            return null;
        }
        String string = pSAppLocalDE.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomUserAction(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isCustomUserActionDirty() : !pSAppLocalDE.isCustomUserActionDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getCustomUserAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomUserAction_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMUSERACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataAccMode(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isDataAccModeDirty() : !pSAppLocalDE.isDataAccModeDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getDataAccMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DataAccMode_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAACCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isDefaultFlagDirty() : !pSAppLocalDE.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSAppLocalDE, bl2, bl3);
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
                string = string + ";";
                string = string + "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSAppLocalDEDEModel(), "DEFAULTFLAG", string, pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEFGroupMode(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isDEFGroupModeDirty() : !pSAppLocalDE.isDEFGroupModeDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getDEFGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFGroupMode_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFGROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableStorage(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isEnableStorageDirty() : !pSAppLocalDE.isEnableStorageDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getEnableStorage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableStorage_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESTORAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isLinkPSDEViewIdDirty() : !pSAppLocalDE.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isLNPSLanResIdDirty() : !pSAppLocalDE.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isLNPSLanResNameDirty() : !pSAppLocalDE.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isLogicNameDirty() : !pSAppLocalDE.isLogicNameDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorFlag(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isMajorFlagDirty() : !pSAppLocalDE.isMajorFlagDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getMajorFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MajorFlag_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEViewId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isMDPSDEViewIdDirty() : !pSAppLocalDE.isMDPSDEViewIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getMDPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEViewId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isMemoDirty() : !pSAppLocalDE.isMemoDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSAppLocalDEId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPPSAppLocalDEIdDirty() : !pSAppLocalDE.isPPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSAppLocalDEId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSAPPLOCALDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSAppLocalDEIdDirty() && !bl2 : !pSAppLocalDE.isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSAppLocalDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppLocalDEName(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSAppLocalDENameDirty() && !bl2 : !pSAppLocalDE.isPSAppLocalDENameDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSAppLocalDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEName_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSAppLocalDEDEModel(), "PSAPPLOCALDENAME", string3, pSAppLocalDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPLOCALDENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModuleId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSAppModuleIdDirty() : !pSAppLocalDE.isPSAppModuleIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSAppModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSDEFGroupIdDirty() : !pSAppLocalDE.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSDEIdDirty() && !bl2 : !pSAppLocalDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSDERIdDirty() : !pSAppLocalDE.isPSDERIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSDEServiceAPIIdDirty() : !pSAppLocalDE.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSDEServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysAppIdDirty() && !bl2 : !pSAppLocalDE.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysDynaModelIdDirty() : !pSAppLocalDE.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysReqItemIdDirty() : !pSAppLocalDE.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysServiceAPIIdDirty() : !pSAppLocalDE.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysSFPluginIdDirty() : !pSAppLocalDE.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isPSSysUniResIdDirty() : !pSAppLocalDE.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_SDPSDEViewID(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isSDPSDEViewIDDirty() : !pSAppLocalDE.isSDPSDEViewIDDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getSDPSDEViewID();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDPSDEViewID_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserAction(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserActionDirty() : !pSAppLocalDE.isUserActionDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getUserAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserAction_Default((IEntity)pSAppLocalDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserCatDirty() : !pSAppLocalDE.isUserCatDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserTagDirty() : !pSAppLocalDE.isUserTagDirty()) {
            return null;
        }
        String string = pSAppLocalDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserTag2Dirty() : !pSAppLocalDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppLocalDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserTag3Dirty() : !pSAppLocalDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppLocalDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isUserTag4Dirty() : !pSAppLocalDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppLocalDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppLocalDE pSAppLocalDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppLocalDE.isValidFlagDirty() && !bl2 : !pSAppLocalDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppLocalDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSAppLocalDE, bl2, bl3);
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

    protected void onSyncEntity(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppLocalDE, bl);
    }

    protected void onSyncIndexEntities(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppLocalDE, bl);
    }

    public Object getDataContextValue(PSAppLocalDE pSAppLocalDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppLocalDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSAppLocalDE.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSysApp pSSysApp = pSAppLocalDE.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppLocalDE pSAppLocalDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSAppLocalDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCCTRLARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccCtrlArch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTOADDMETHODMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoAddMethodMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTOADDVIEWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoAddViewMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BASECLSPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BaseClsParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMUSERACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomUserAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAACCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataAccMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DECodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFGROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFGroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESTORAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableStorage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDPSDEViewID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserAction_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AccCtrlArch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoAddMethodMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoAddViewMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BaseClsParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BASECLSPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
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

    protected String onTestValueRule_CustomUserAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DataAccMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DECodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_DEFGroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFGROUPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DELOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableStorage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MDPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PPSAppLocalDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPLOCALDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSAppLocalDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRecursionRule("PPSAPPLOCALDENAME", "PSAPPLOCALDE", iEntity, bl2, "")) {
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
            if (this.checkFieldStringLengthRule("PSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSAPPLOCALDENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SDPSDEViewID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppLocalDE pSAppLocalDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppLocalDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppLocalDE pSAppLocalDE) throws Exception {
        super.onUpdateParent((IEntity)pSAppLocalDE);
    }

    @Override
    protected void exportCurXmlModel(PSAppLocalDE pSAppLocalDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPLOCALDE");
        if (!bl) {
            pSAppLocalDE.setCreateDate(null);
            pSAppLocalDE.setCreateMan(null);
            pSAppLocalDE.setPSAppLocalDEId(null);
            pSAppLocalDE.setUpdateDate(null);
            pSAppLocalDE.setUpdateMan(null);
            super.exportCurXmlModel(pSAppLocalDE, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSAppLocalDE pSAppLocalDE, PSSystem pSSystem) throws Exception {
        PSAppLocalDE pSAppLocalDE2 = new PSAppLocalDE();
        pSAppLocalDE2.setPSSysAppId(pSAppLocalDE.getPSSysAppId());
        pSAppLocalDE2.setPSDEId(pSAppLocalDE.getPSDEId());
        if (this.selectOne((IEntity)pSAppLocalDE2, true)) {
            return pSAppLocalDE2.getPSAppLocalDEId();
        }
        return super.getEntityFolderKeyValue(pSAppLocalDE, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppLocalDE pSAppLocalDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppLocalDE, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPLOCALDE_PSAPPMODULE_PSAPPMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPMODULE", (boolean)true) == 0) {
            iEntity.set("PSAPPMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSAPPMODULEID", "PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppLocalDE pSAppLocalDE) {
        if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSAppLocalDEName())) {
            return pSAppLocalDE.getPSAppLocalDEName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEId())) {
            return pSAppLocalDE.getPSDEId();
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getCodeName())) {
            return pSAppLocalDE.getCodeName();
        }
        return super.getModelV2Tag(pSAppLocalDE);
    }

    @Override
    public boolean setModelV2Tag(PSAppLocalDE pSAppLocalDE, String string) {
        pSAppLocalDE.setPSAppLocalDEName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPLOCALDENAME", "");
        map.put("PSDEID", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSAPPLOCALDENAME", "");
        map.put("PSAPPMODULEID", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppLocalDE pSAppLocalDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppLocalDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppLocalDE, true);
        pSAppLocalDE.set("PSAPPLOCALDENAME", string);
        if (this.select(pSAppLocalDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppLocalDE, true);
        return super.getModelV2Entity(pSAppLocalDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppLocalDE pSAppLocalDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppLocalDE, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u89c6\u56fe>", "DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", "PSAPPLOCALDEID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSAppLocalDEServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u89c6\u56fe>");
            } else if (PSAppLocalDEServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappviews");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID|PSAPPLOCALDEID");
            pSMOSFile2.setFileTag3("PSAPPVIEW");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", "PSAPPLOCALDEID", pSMOSFile.getPSModelId(), "", "")) {
                PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSAppViewService, "DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", "PSAPPLOCALDEID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSAppViewService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSAppLocalDEServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSAppLocalDEServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u89c6\u56fe>", (boolean)false) == 0 || PSAppLocalDEServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psappviews", (boolean)true) == 0) {
            PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSAppViewService, "DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", "PSAPPLOCALDEID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSAppViewService.selectEx((ISelectContext)selectContext);
            for (PSAppView pSAppView : arrayList2) {
                PSMOSFile pSMOSFile2 = pSAppViewService.getFile(pSMOSFile, (IEntity)pSAppView, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)false) == 0) {
            if (PSAppLocalDEServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u89c6\u56fe>";
            }
            if (PSAppLocalDEServiceBase.getMOSVer() == 2) {
                return "psappviews";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

