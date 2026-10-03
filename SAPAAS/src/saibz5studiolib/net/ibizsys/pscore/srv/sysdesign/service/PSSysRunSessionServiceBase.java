/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfgBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysRunSessionDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunSessionDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemASBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRunSessionServiceBase
extends PSCoreSysServiceBase<PSSysRunSession> {
    private static final Log log = LogFactory.getLog(PSSysRunSessionServiceBase.class);
    public static final String DATASET_CURSYSACTIVE = "CurSysActive";
    public static final String DATASET_CURSYSFINISHED = "CurSysFinished";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_STARTEX = "X_STARTEX";
    private PSSysRunSessionDEModel pSSysRunSessionDEModel;
    private PSSysRunSessionDAO pSSysRunSessionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService";
    }

    public PSSysRunSessionDEModel getPSSysRunSessionDEModel() {
        if (this.pSSysRunSessionDEModel == null) {
            try {
                this.pSSysRunSessionDEModel = (PSSysRunSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRunSessionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysRunSessionDEModel();
    }

    public PSSysRunSessionDAO getPSSysRunSessionDAO() {
        if (this.pSSysRunSessionDAO == null) {
            try {
                this.pSSysRunSessionDAO = (PSSysRunSessionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysRunSessionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRunSessionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysRunSessionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSACTIVE, (boolean)true) == 0) {
            return this.fetchCurSysActive(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSFINISHED, (boolean)true) == 0) {
            return this.fetchCurSysFinished(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_STARTEX, (boolean)true) == 0) {
            this.startEx((PSSysRunSession)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSysActive(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSACTIVE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysFinished(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSFINISHED, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void startEx(PSSysRunSession pSSysRunSession) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTEX, 0, pSSysRunSession, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysRunSession, ACTION_X_STARTEX);
        final PSSysRunSession pSSysRunSession2 = pSSysRunSession;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysRunSessionServiceBase.this.getService(), PSSysRunSessionServiceBase.ACTION_X_STARTEX, 40, pSSysRunSession2, null).getResult() != 1) {
                    PSSysRunSessionServiceBase.this.onStartEx(pSSysRunSession2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTEX, 99, pSSysRunSession, null);
        }
    }

    protected void onStartEx(PSSysRunSession pSSysRunSession) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_STARTEX]");
    }

    protected void onFillParentInfo(PSSysRunSession pSSysRunSession, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSDEVSLNMSDEPAPI_PSDEVSLNMSDEPAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI = (PSDevSlnMSDepAPI)iService.getDEModel().createEntity();
            pSDevSlnMSDepAPI.set("PSDEVSLNMSDEPAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDepAPI);
            } else {
                iService.get(pSDevSlnMSDepAPI);
            }
            this.onFillParentInfo_PSDevSlnMSDepAPI(pSSysRunSession, pSDevSlnMSDepAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSDEVSLNMSDEPAPP_PSDEVSLNMSDEPAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepApp pSDevSlnMSDepApp = (PSDevSlnMSDepApp)iService.getDEModel().createEntity();
            pSDevSlnMSDepApp.set("PSDEVSLNMSDEPAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDepApp);
            } else {
                iService.get(pSDevSlnMSDepApp);
            }
            this.onFillParentInfo_PSDevSlnMSDepApp(pSSysRunSession, pSDevSlnMSDepApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService", (SessionFactory)this.getSessionFactory());
            PSDevSlnMSDepFunc pSDevSlnMSDepFunc = (PSDevSlnMSDepFunc)iService.getDEModel().createEntity();
            pSDevSlnMSDepFunc.set("PSDEVSLNMSDEPFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnMSDepFunc);
            } else {
                iService.get(pSDevSlnMSDepFunc);
            }
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSSysRunSession, pSDevSlnMSDepFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSMOBAPPPACK_PSMOBAPPPACKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService", (SessionFactory)this.getSessionFactory());
            PSMobAppPack pSMobAppPack = (PSMobAppPack)iService.getDEModel().createEntity();
            pSMobAppPack.set("PSMOBAPPPACKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMobAppPack);
            } else {
                iService.get(pSMobAppPack);
            }
            this.onFillParentInfo_PSMobAppPack(pSSysRunSession, pSMobAppPack);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysRunSession, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSAPP_PSSYSAPPID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp2(pSSysRunSession, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSBDINSTCFG_PSSYSBDINSTCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService", (SessionFactory)this.getSessionFactory());
            PSSysBDInstCfg pSSysBDInstCfg = (PSSysBDInstCfg)iService.getDEModel().createEntity();
            pSSysBDInstCfg.set("PSSYSBDINSTCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDInstCfg);
            } else {
                iService.get(pSSysBDInstCfg);
            }
            this.onFillParentInfo_PSSysBDInstCfg(pSSysRunSession, pSSysBDInstCfg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSDMVER_SRCPSSYSDMVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService", (SessionFactory)this.getSessionFactory());
            PSSysDMVer pSSysDMVer = (PSSysDMVer)iService.getDEModel().createEntity();
            pSSysDMVer.set("PSSYSDMVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDMVer);
            } else {
                iService.get(pSSysDMVer);
            }
            this.onFillParentInfo_SrcPSSysDMVer(pSSysRunSession, pSSysDMVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSDYNAMODEL_RUNPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_RunPSSysDynaModel(pSSysRunSession, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSSysRunSession, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPub);
            } else {
                iService.get(pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSysRunSession, pSSysSFPub);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSTEMAS_PSSYSTEMASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService", (SessionFactory)this.getSessionFactory());
            PSSystemAS pSSystemAS = (PSSystemAS)iService.getDEModel().createEntity();
            pSSystemAS.set("PSSYSTEMASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystemAS);
            } else {
                iService.get(pSSystemAS);
            }
            this.onFillParentInfo_PSSystemAS(pSSysRunSession, pSSystemAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystemDBCfg);
            } else {
                iService.get(pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSysRunSession, pSSystemDBCfg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNSESSION_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysRunSession, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysRunSession, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevSlnMSDepAPI(PSSysRunSession pSSysRunSession, PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        pSSysRunSession.setPSDevSlnMSDepAPIId(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId());
        pSSysRunSession.setPSDevSlnMSDepAPIName(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIName());
    }

    protected void onFillParentInfo_PSDevSlnMSDepApp(PSSysRunSession pSSysRunSession, PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        pSSysRunSession.setPSDevSlnMSDepAppId(pSDevSlnMSDepApp.getPSDevSlnMSDepAppId());
        pSSysRunSession.setPSDevSlnMSDepAppName(pSDevSlnMSDepApp.getPSDevSlnMSDepAppName());
    }

    protected void onFillParentInfo_PSDevSlnMSDepFunc(PSSysRunSession pSSysRunSession, PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        pSSysRunSession.setPSDevSlnMSDepFuncId(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId());
        pSSysRunSession.setPSDevSlnMSDepFuncName(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName());
    }

    protected void onFillParentInfo_PSMobAppPack(PSSysRunSession pSSysRunSession, PSMobAppPack pSMobAppPack) throws Exception {
        pSSysRunSession.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
        pSSysRunSession.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysRunSession pSSysRunSession, PSSysApp pSSysApp) throws Exception {
        pSSysRunSession.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysRunSession.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysApp2(PSSysRunSession pSSysRunSession, PSSysApp pSSysApp) throws Exception {
        pSSysRunSession.setPSSysAppId2(pSSysApp.getPSSysAppId());
        pSSysRunSession.setPSSysAppName2(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysBDInstCfg(PSSysRunSession pSSysRunSession, PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        pSSysRunSession.setPSSysBDInstCfgId(pSSysBDInstCfg.getPSSysBDInstCfgId());
        pSSysRunSession.setPSSysBDInstCfgName(pSSysBDInstCfg.getPSSysBDInstCfgName());
    }

    protected void onFillParentInfo_SrcPSSysDMVer(PSSysRunSession pSSysRunSession, PSSysDMVer pSSysDMVer) throws Exception {
        pSSysRunSession.setSrcPSSysDMVerId(pSSysDMVer.getPSSysDMVerId());
        pSSysRunSession.setSrcPSSysDMVerName(pSSysDMVer.getPSSysDMVerName());
    }

    protected void onFillParentInfo_RunPSSysDynaModel(PSSysRunSession pSSysRunSession, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysRunSession.setRunPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysRunSession.setRunPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSSysRunSession pSSysRunSession, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysRunSession.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSysRunSession.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysSFPub(PSSysRunSession pSSysRunSession, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysRunSession.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysRunSession.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillParentInfo_PSSystemAS(PSSysRunSession pSSysRunSession, PSSystemAS pSSystemAS) throws Exception {
        pSSysRunSession.setPSSystemASId(pSSystemAS.getPSSystemASId());
        pSSysRunSession.setPSSystemASName(pSSystemAS.getPSSystemASName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSysRunSession pSSysRunSession, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSysRunSession.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSysRunSession.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected void onFillParentInfo_PSSystem(PSSysRunSession pSSysRunSession, PSSystem pSSystem) throws Exception {
        pSSysRunSession.setPSSystemId(pSSystem.getPSSystemId());
        pSSysRunSession.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (bl) {
            if (pSSysRunSession.getDebugMode() == null) {
                pSSysRunSession.setDebugMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysRunSession.getRunState() == null) {
                pSSysRunSession.setRunState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepAPI(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepApp(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSDevSlnMSDepFunc(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSMobAppPack(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSysApp2(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSysBDInstCfg(pSSysRunSession, bl);
        this.onFillEntityFullInfo_SrcPSSysDMVer(pSSysRunSession, bl);
        this.onFillEntityFullInfo_RunPSSysDynaModel(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSystemAS(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSysRunSession, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysRunSession, bl);
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepAPI(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSDevSlnMSDepAPIIdDirty()) {
            if (pSSysRunSession.getPSDevSlnMSDepAPIId() != null) {
                if (pSSysRunSession.getPSDevSlnMSDepAPIId() == null || pSSysRunSession.getPSDevSlnMSDepAPIName() == null) {
                    PSDevSlnMSDepAPI pSDevSlnMSDepAPI = pSSysRunSession.getPSDevSlnMSDepAPI();
                    pSSysRunSession.setPSDevSlnMSDepAPIName(pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIName());
                }
            } else {
                pSSysRunSession.setPSDevSlnMSDepAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepApp(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSDevSlnMSDepAppIdDirty()) {
            if (pSSysRunSession.getPSDevSlnMSDepAppId() != null) {
                if (pSSysRunSession.getPSDevSlnMSDepAppId() == null || pSSysRunSession.getPSDevSlnMSDepAppName() == null) {
                    PSDevSlnMSDepApp pSDevSlnMSDepApp = pSSysRunSession.getPSDevSlnMSDepApp();
                    pSSysRunSession.setPSDevSlnMSDepAppName(pSDevSlnMSDepApp.getPSDevSlnMSDepAppName());
                }
            } else {
                pSSysRunSession.setPSDevSlnMSDepAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnMSDepFunc(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSDevSlnMSDepFuncIdDirty()) {
            if (pSSysRunSession.getPSDevSlnMSDepFuncId() != null) {
                if (pSSysRunSession.getPSDevSlnMSDepFuncId() == null || pSSysRunSession.getPSDevSlnMSDepFuncName() == null) {
                    PSDevSlnMSDepFunc pSDevSlnMSDepFunc = pSSysRunSession.getPSDevSlnMSDepFunc();
                    pSSysRunSession.setPSDevSlnMSDepFuncName(pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName());
                }
            } else {
                pSSysRunSession.setPSDevSlnMSDepFuncName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSMobAppPack(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSMobAppPackIdDirty()) {
            if (pSSysRunSession.getPSMobAppPackId() != null) {
                if (pSSysRunSession.getPSMobAppPackId() == null || pSSysRunSession.getPSMobAppPackName() == null) {
                    PSMobAppPack pSMobAppPack = pSSysRunSession.getPSMobAppPack();
                    pSSysRunSession.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
                }
            } else {
                pSSysRunSession.setPSMobAppPackName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSysAppIdDirty()) {
            if (pSSysRunSession.getPSSysAppId() != null) {
                if (pSSysRunSession.getPSSysAppId() == null || pSSysRunSession.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSSysRunSession.getPSSysApp();
                    pSSysRunSession.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSSysRunSession.setPSSysAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp2(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSysAppId2Dirty()) {
            if (pSSysRunSession.getPSSysAppId2() != null) {
                if (pSSysRunSession.getPSSysAppId2() == null || pSSysRunSession.getPSSysAppName2() == null) {
                    PSSysApp pSSysApp = pSSysRunSession.getPSSysApp2();
                    pSSysRunSession.setPSSysAppName2(pSSysApp.getPSSysAppName());
                }
            } else {
                pSSysRunSession.setPSSysAppName2(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBDInstCfg(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSysBDInstCfgIdDirty()) {
            if (pSSysRunSession.getPSSysBDInstCfgId() != null) {
                if (pSSysRunSession.getPSSysBDInstCfgId() == null || pSSysRunSession.getPSSysBDInstCfgName() == null) {
                    PSSysBDInstCfg pSSysBDInstCfg = pSSysRunSession.getPSSysBDInstCfg();
                    pSSysRunSession.setPSSysBDInstCfgName(pSSysBDInstCfg.getPSSysBDInstCfgName());
                }
            } else {
                pSSysRunSession.setPSSysBDInstCfgName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSSysDMVer(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isSrcPSSysDMVerIdDirty()) {
            if (pSSysRunSession.getSrcPSSysDMVerId() != null) {
                if (pSSysRunSession.getSrcPSSysDMVerId() == null || pSSysRunSession.getSrcPSSysDMVerName() == null) {
                    PSSysDMVer pSSysDMVer = pSSysRunSession.getSrcPSSysDMVer();
                    pSSysRunSession.setSrcPSSysDMVerName(pSSysDMVer.getPSSysDMVerName());
                }
            } else {
                pSSysRunSession.setSrcPSSysDMVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RunPSSysDynaModel(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isRunPSSysDynaModelIdDirty()) {
            if (pSSysRunSession.getRunPSSysDynaModelId() != null) {
                if (pSSysRunSession.getRunPSSysDynaModelId() == null || pSSysRunSession.getRunPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSSysRunSession.getRunPSSysDynaModel();
                    pSSysRunSession.setRunPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSSysRunSession.setRunPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSysServiceAPIIdDirty()) {
            if (pSSysRunSession.getPSSysServiceAPIId() != null) {
                if (pSSysRunSession.getPSSysServiceAPIId() == null || pSSysRunSession.getPSSysServiceAPIName() == null) {
                    PSSysServiceAPI pSSysServiceAPI = pSSysRunSession.getPSSysServiceAPI();
                    pSSysRunSession.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                }
            } else {
                pSSysRunSession.setPSSysServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSysSFPubIdDirty()) {
            if (pSSysRunSession.getPSSysSFPubId() != null) {
                if (pSSysRunSession.getPSSysSFPubId() == null || pSSysRunSession.getPSSysSFPubName() == null) {
                    PSSysSFPub pSSysSFPub = pSSysRunSession.getPSSysSFPub();
                    pSSysRunSession.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                }
            } else {
                pSSysRunSession.setPSSysSFPubName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystemAS(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSystemASIdDirty()) {
            if (pSSysRunSession.getPSSystemASId() != null) {
                if (pSSysRunSession.getPSSystemASId() == null || pSSysRunSession.getPSSystemASName() == null) {
                    PSSystemAS pSSystemAS = pSSysRunSession.getPSSystemAS();
                    pSSysRunSession.setPSSystemASName(pSSystemAS.getPSSystemASName());
                }
            } else {
                pSSysRunSession.setPSSystemASName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSystemDBCfgIdDirty()) {
            if (pSSysRunSession.getPSSystemDBCfgId() != null) {
                if (pSSysRunSession.getPSSystemDBCfgId() == null || pSSysRunSession.getPSSystemDBCfgName() == null) {
                    PSSystemDBCfg pSSystemDBCfg = pSSysRunSession.getPSSystemDBCfg();
                    pSSysRunSession.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                }
            } else {
                pSSysRunSession.setPSSystemDBCfgName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        if (pSSysRunSession.isPSSystemIdDirty()) {
            if (pSSysRunSession.getPSSystemId() != null) {
                if (pSSysRunSession.getPSSystemId() == null || pSSysRunSession.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysRunSession.getPSSystem();
                    pSSysRunSession.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysRunSession.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysRunSession, bl);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase) throws Exception {
        return this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPIBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPIBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepAPI(PSDevSlnMSDepAPIBase pSDevSlnMSDepAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPAPIID", (Object)pSDevSlnMSDepAPIBase.getPSDevSlnMSDepAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase) throws Exception {
        return this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepAppBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepAppBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepApp(PSDevSlnMSDepAppBase pSDevSlnMSDepAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPAPPID", (Object)pSDevSlnMSDepAppBase.getPSDevSlnMSDepAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string) throws Exception {
        return this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFuncBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSDevSlnMSDepFunc(PSDevSlnMSDepFuncBase pSDevSlnMSDepFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNMSDEPFUNCID", (Object)pSDevSlnMSDepFuncBase.getPSDevSlnMSDepFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnMSDepFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnMSDepFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMOBAPPPACKID", (Object)pSMobAppPackBase.getPSMobAppPackId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMobAppPackCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMobAppPackCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysRunSession> selectByPSSysApp2(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp2(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysApp2(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp2(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysApp2(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID2", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysApp2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysApp2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase) throws Exception {
        return this.selectByPSSysBDInstCfg(pSSysBDInstCfgBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase, String string) throws Exception {
        return this.selectByPSSysBDInstCfg(pSSysBDInstCfgBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysBDInstCfg(PSSysBDInstCfgBase pSSysBDInstCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDINSTCFGID", (Object)pSSysBDInstCfgBase.getPSSysBDInstCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDInstCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDInstCfgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectBySrcPSSysDMVer(PSSysDMVerBase pSSysDMVerBase) throws Exception {
        return this.selectBySrcPSSysDMVer(pSSysDMVerBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectBySrcPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string) throws Exception {
        return this.selectBySrcPSSysDMVer(pSSysDMVerBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectBySrcPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSSYSDMVERID", (Object)pSSysDMVerBase.getPSSysDMVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSSysDMVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSSysDMVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByRunPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByRunPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByRunPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RUNPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRunPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRunPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysRunSession> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSystemAS(PSSystemASBase pSSystemASBase) throws Exception {
        return this.selectByPSSystemAS(pSSystemASBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystemAS(PSSystemASBase pSSystemASBase, String string) throws Exception {
        return this.selectByPSSystemAS(pSSystemASBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystemAS(PSSystemASBase pSSystemASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMASID", (Object)pSSystemASBase.getPSSystemASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMDBCFGID", (Object)pSSystemDBCfgBase.getPSSystemDBCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemDBCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemDBCfgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunSession> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysRunSession> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
    }

    public void resetPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSDevSlnMSDepAPIId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        final PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = pSDevSlnMSDepAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI);
        this.onBeforeRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSDevSlnMSDepAPI(pSDevSlnMSDepAPI, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepAPI(PSDevSlnMSDepAPI pSDevSlnMSDepAPI, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
    }

    public void resetPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepApp);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSDevSlnMSDepAppId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        final PSDevSlnMSDepApp pSDevSlnMSDepApp2 = pSDevSlnMSDepApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepApp(pSDevSlnMSDepApp);
        this.onBeforeRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSDevSlnMSDepApp(pSDevSlnMSDepApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepApp(PSDevSlnMSDepApp pSDevSlnMSDepApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    public void resetPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSDevSlnMSDepFuncId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        final PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = pSDevSlnMSDepFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void internalRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc);
        this.onBeforeRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSDevSlnMSDepFunc(pSDevSlnMSDepFunc, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnMSDepFunc(PSDevSlnMSDepFunc pSDevSlnMSDepFunc, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    public void resetPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSMobAppPackId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        final PSMobAppPack pSMobAppPack2 = pSMobAppPack;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSMobAppPack(pSMobAppPack2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSMobAppPack(pSMobAppPack2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSMobAppPack(pSMobAppPack2);
            }
        });
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void internalRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        this.onBeforeRemoveByPSMobAppPack(pSMobAppPack, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSMobAppPack(pSMobAppPack, arrayList);
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSysAppId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp2(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysApp2(pSSysApp);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSysAppId2(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSysApp2(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSysApp2(pSSysApp2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSysApp2(pSSysApp2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSysApp2(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysApp2(pSSysApp);
        this.onBeforeRemoveByPSSysApp2(pSSysApp, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSysApp2(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp2(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp2(PSSysApp pSSysApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp2(PSSysApp pSSysApp, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
    }

    public void resetPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysBDInstCfg(pSSysBDInstCfg);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSysBDInstCfgId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        final PSSysBDInstCfg pSSysBDInstCfg2 = pSSysBDInstCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSysBDInstCfg(pSSysBDInstCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
    }

    protected void internalRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysBDInstCfg(pSSysBDInstCfg);
        this.onBeforeRemoveByPSSysBDInstCfg(pSSysBDInstCfg, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSysBDInstCfg(pSSysBDInstCfg, arrayList);
    }

    protected void onAfterRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDInstCfg(PSSysBDInstCfg pSSysBDInstCfg, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    public void resetSrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectBySrcPSSysDMVer(pSSysDMVer);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setSrcPSSysDMVerId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeBySrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        final PSSysDMVer pSSysDMVer2 = pSSysDMVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveBySrcPSSysDMVer(pSSysDMVer2);
                PSSysRunSessionServiceBase.this.internalRemoveBySrcPSSysDMVer(pSSysDMVer2);
                PSSysRunSessionServiceBase.this.onAfterRemoveBySrcPSSysDMVer(pSSysDMVer2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void internalRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectBySrcPSSysDMVer(pSSysDMVer);
        this.onBeforeRemoveBySrcPSSysDMVer(pSSysDMVer, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveBySrcPSSysDMVer(pSSysDMVer, arrayList);
    }

    protected void onAfterRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSRUNSESSION_PSSYSDYNAMODEL_RUNPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSRUNSESSION", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setRunPSSysDynaModelId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByRunPSSysDynaModel(pSSysDynaModel2);
                PSSysRunSessionServiceBase.this.internalRemoveByRunPSSysDynaModel(pSSysDynaModel2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByRunPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByRunPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByRunPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByRunPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRunPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSysServiceAPIId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSysSFPubId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
    }

    public void resetPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystemAS(pSSystemAS);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSystemASId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        final PSSystemAS pSSystemAS2 = pSSystemAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSystemAS(pSSystemAS2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSystemAS(pSSystemAS2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSystemAS(pSSystemAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
    }

    protected void internalRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystemAS(pSSystemAS);
        this.onBeforeRemoveByPSSystemAS(pSSystemAS, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSystemAS(pSSystemAS, arrayList);
    }

    protected void onAfterRemoveByPSSystemAS(PSSystemAS pSSystemAS) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemAS(PSSystemAS pSSystemAS, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemAS(PSSystemAS pSSystemAS, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSystemDBCfgId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            PSSysRunSession pSSysRunSession2 = (PSSysRunSession)this.getDEModel().createEntity();
            pSSysRunSession2.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
            pSSysRunSession2.setPSSystemId(null);
            this.update(pSSysRunSession2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunSessionServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysRunSessionServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysRunSessionServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysRunSession> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysRunSession pSSysRunSession : arrayList) {
            this.remove(pSSysRunSession);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysRunSession> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysRunSession pSSysRunSession) throws Exception {
        PSSysRunLogService pSSysRunLogService = (PSSysRunLogService)ServiceGlobal.getService(PSSysRunLogService.class, (SessionFactory)this.getSessionFactory());
        pSSysRunLogService.testRemoveByPSSysRunSession(pSSysRunSession);
        pSSysRunLogService.removeByPSSysRunSession(pSSysRunSession);
        super.onBeforeRemove(pSSysRunSession);
    }

    protected void replaceParentInfo(PSSysRunSession pSSysRunSession, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysRunSession, cloneSession);
        if (pSSysRunSession.getPSDevSlnMSDepAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPAPI", (Object)pSSysRunSession.getPSDevSlnMSDepAPIId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepAPI(pSSysRunSession, (PSDevSlnMSDepAPI)iEntity);
        }
        if (pSSysRunSession.getPSDevSlnMSDepAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPAPP", (Object)pSSysRunSession.getPSDevSlnMSDepAppId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepApp(pSSysRunSession, (PSDevSlnMSDepApp)iEntity);
        }
        if (pSSysRunSession.getPSDevSlnMSDepFuncId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNMSDEPFUNC", (Object)pSSysRunSession.getPSDevSlnMSDepFuncId())) != null) {
            this.onFillParentInfo_PSDevSlnMSDepFunc(pSSysRunSession, (PSDevSlnMSDepFunc)iEntity);
        }
        if (pSSysRunSession.getPSMobAppPackId() != null && (iEntity = cloneSession.getEntity("PSMOBAPPPACK", (Object)pSSysRunSession.getPSMobAppPackId())) != null) {
            this.onFillParentInfo_PSMobAppPack(pSSysRunSession, (PSMobAppPack)iEntity);
        }
        if (pSSysRunSession.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysRunSession.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysRunSession, (PSSysApp)iEntity);
        }
        if (pSSysRunSession.getPSSysAppId2() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysRunSession.getPSSysAppId2())) != null) {
            this.onFillParentInfo_PSSysApp2(pSSysRunSession, (PSSysApp)iEntity);
        }
        if (pSSysRunSession.getPSSysBDInstCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSBDINSTCFG", (Object)pSSysRunSession.getPSSysBDInstCfgId())) != null) {
            this.onFillParentInfo_PSSysBDInstCfg(pSSysRunSession, (PSSysBDInstCfg)iEntity);
        }
        if (pSSysRunSession.getSrcPSSysDMVerId() != null && (iEntity = cloneSession.getEntity("PSSYSDMVER", (Object)pSSysRunSession.getSrcPSSysDMVerId())) != null) {
            this.onFillParentInfo_SrcPSSysDMVer(pSSysRunSession, (PSSysDMVer)iEntity);
        }
        if (pSSysRunSession.getRunPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysRunSession.getRunPSSysDynaModelId())) != null) {
            this.onFillParentInfo_RunPSSysDynaModel(pSSysRunSession, (PSSysDynaModel)iEntity);
        }
        if (pSSysRunSession.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSysRunSession.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSSysRunSession, (PSSysServiceAPI)iEntity);
        }
        if (pSSysRunSession.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysRunSession.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSysRunSession, (PSSysSFPub)iEntity);
        }
        if (pSSysRunSession.getPSSystemASId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMAS", (Object)pSSysRunSession.getPSSystemASId())) != null) {
            this.onFillParentInfo_PSSystemAS(pSSysRunSession, (PSSystemAS)iEntity);
        }
        if (pSSysRunSession.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSysRunSession.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSysRunSession, (PSSystemDBCfg)iEntity);
        }
        if (pSSysRunSession.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysRunSession.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysRunSession, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysRunSession, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DebugMode(bl, pSSysRunSession, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableVC(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FixDBModel(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackMode(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAPIName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepAppName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnMSDepFuncName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId2(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName2(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDInstCfgId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDInstCfgName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunSessionId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunSessionName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemASId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemASName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickMode(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RebuildMode(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunMode(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam10(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam11(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam12(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam2(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam3(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam4(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam5(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam6(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam7(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam8(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunParam9(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunPSSysDynaModelId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunPSSysDynaModelName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunState(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSSysDMVerId(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSSysDMVerName(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartTime(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StopWhenTemplError(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysRunSession, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysRunSession, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DebugMode(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isDebugModeDirty() : !pSSysRunSession.isDebugModeDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getDebugMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DebugMode_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEBUGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableVC(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isEnableVCDirty() : !pSSysRunSession.isEnableVCDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getEnableVC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableVC_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isEndTimeDirty() : !pSSysRunSession.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysRunSession.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FixDBModel(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isFixDBModelDirty() : !pSSysRunSession.isFixDBModelDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getFixDBModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FixDBModel_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIXDBMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isMemoDirty() : !pSSysRunSession.isMemoDirty()) {
            return null;
        }
        String string = pSSysRunSession.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PackMode(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPackModeDirty() : !pSSysRunSession.isPackModeDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPackMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PackMode_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepAPIIdDirty() : !pSSysRunSession.isPSDevSlnMSDepAPIIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAPIId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAPIName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepAPINameDirty() : !pSSysRunSession.isPSDevSlnMSDepAPINameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAPIName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepAppIdDirty() : !pSSysRunSession.isPSDevSlnMSDepAppIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAppId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepAppName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepAppNameDirty() : !pSSysRunSession.isPSDevSlnMSDepAppNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepAppName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepFuncIdDirty() : !pSSysRunSession.isPSDevSlnMSDepFuncIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnMSDepFuncName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDevSlnMSDepFuncNameDirty() : !pSSysRunSession.isPSDevSlnMSDepFuncNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDevSlnMSDepFuncName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnMSDepFuncName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNMSDEPFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDSConsoleIdDirty() : !pSSysRunSession.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSDynaInstIdDirty() : !pSSysRunSession.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSMobAppPackId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSMobAppPackIdDirty() : !pSSysRunSession.isPSMobAppPackIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSMobAppPackId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSMobAppPackNameDirty() : !pSSysRunSession.isPSMobAppPackNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSMobAppPackName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysAppIdDirty() : !pSSysRunSession.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId2(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysAppId2Dirty() : !pSSysRunSession.isPSSysAppId2Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysAppId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId2_Rule1(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSSysAppId2_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysAppNameDirty() : !pSSysRunSession.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppName2(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysAppName2Dirty() : !pSSysRunSession.isPSSysAppName2Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysAppName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName2_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDInstCfgId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysBDInstCfgIdDirty() : !pSSysRunSession.isPSSysBDInstCfgIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysBDInstCfgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDInstCfgId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDInstCfgName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysBDInstCfgNameDirty() : !pSSysRunSession.isPSSysBDInstCfgNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysBDInstCfgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDInstCfgName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDINSTCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRunSessionId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysRunSessionIdDirty() && !bl2 : !pSSysRunSession.isPSSysRunSessionIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysRunSessionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunSessionId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRunSessionName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysRunSessionNameDirty() && !bl2 : !pSSysRunSession.isPSSysRunSessionNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysRunSessionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunSessionName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysServiceAPIIdDirty() : !pSSysRunSession.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysServiceAPINameDirty() : !pSSysRunSession.isPSSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysSFPubIdDirty() : !pSSysRunSession.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysSFPubId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSysSFPubNameDirty() : !pSSysRunSession.isPSSysSFPubNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSysSFPubName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemASId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemASIdDirty() : !pSSysRunSession.isPSSystemASIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemASId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemASName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemASNameDirty() : !pSSysRunSession.isPSSystemASNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemASName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemASName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemDBCfgIdDirty() : !pSSysRunSession.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemDBCfgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemDBCfgNameDirty() : !pSSysRunSession.isPSSystemDBCfgNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemDBCfgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemIdDirty() && !bl2 : !pSSysRunSession.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isPSSystemNameDirty() && !bl2 : !pSSysRunSession.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_QuickMode(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isQuickModeDirty() : !pSSysRunSession.isQuickModeDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getQuickMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QuickMode_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RebuildMode(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRebuildModeDirty() : !pSSysRunSession.isRebuildModeDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getRebuildMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RebuildMode_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REBUILDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunMode(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunModeDirty() : !pSSysRunSession.isRunModeDirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunMode_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParamDirty() : !pSSysRunSession.isRunParamDirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam10(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam10Dirty() : !pSSysRunSession.isRunParam10Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam10_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam11(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam11Dirty() : !pSSysRunSession.isRunParam11Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam11_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam12(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam12Dirty() : !pSSysRunSession.isRunParam12Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam12_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam2(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam2Dirty() : !pSSysRunSession.isRunParam2Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam2_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam3(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam3Dirty() : !pSSysRunSession.isRunParam3Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam3_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam4(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam4Dirty() : !pSSysRunSession.isRunParam4Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam4_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam5(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam5Dirty() : !pSSysRunSession.isRunParam5Dirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getRunParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RunParam5_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam6(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam6Dirty() : !pSSysRunSession.isRunParam6Dirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getRunParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RunParam6_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam7(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam7Dirty() : !pSSysRunSession.isRunParam7Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam7_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam8(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam8Dirty() : !pSSysRunSession.isRunParam8Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam8_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunParam9(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunParam9Dirty() : !pSSysRunSession.isRunParam9Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunParam9_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunPSSysDynaModelId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunPSSysDynaModelIdDirty() : !pSSysRunSession.isRunPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunPSSysDynaModelId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunPSSysDynaModelName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunPSSysDynaModelNameDirty() : !pSSysRunSession.isRunPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getRunPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunPSSysDynaModelName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNPSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunState(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isRunStateDirty() && !bl2 : !pSSysRunSession.isRunStateDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getRunState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RunState_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSSysDMVerId(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isSrcPSSysDMVerIdDirty() : !pSSysRunSession.isSrcPSSysDMVerIdDirty()) {
            return null;
        }
        String string = pSSysRunSession.getSrcPSSysDMVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSSysDMVerId_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSSYSDMVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSSysDMVerName(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isSrcPSSysDMVerNameDirty() : !pSSysRunSession.isSrcPSSysDMVerNameDirty()) {
            return null;
        }
        String string = pSSysRunSession.getSrcPSSysDMVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSSysDMVerName_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSSYSDMVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartTime(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isStartTimeDirty() : !pSSysRunSession.isStartTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysRunSession.getStartTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StartTime_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StopWhenTemplError(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isStopWhenTemplErrorDirty() : !pSSysRunSession.isStopWhenTemplErrorDirty()) {
            return null;
        }
        Integer n = pSSysRunSession.getStopWhenTemplError();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StopWhenTemplError_Default(pSSysRunSession, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOPWHENTEMPLERROR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isUserTagDirty() : !pSSysRunSession.isUserTagDirty()) {
            return null;
        }
        String string = pSSysRunSession.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysRunSession, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysRunSession pSSysRunSession, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunSession.isUserTag2Dirty() : !pSSysRunSession.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysRunSession.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysRunSession, bl2, bl3);
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

    protected void onSyncEntity(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        super.onSyncEntity(pSSysRunSession, bl);
    }

    protected void onSyncIndexEntities(PSSysRunSession pSSysRunSession, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysRunSession, bl);
    }

    public Object getDataContextValue(PSSysRunSession pSSysRunSession, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysRunSession, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysRunSession.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysRunSession pSSysRunSession, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysRunSession, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEBUGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DebugMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableVC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIXDBMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FixDBModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PACKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNMSDEPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnMSDepFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"RULE1", (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId2_Rule1(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDINSTCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDInstCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNSESSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunSessionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNSESSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunSessionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REBUILDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RebuildMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSSYSDMVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSSysDMVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSSYSDMVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSSysDMVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STOPWHENTEMPLERROR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StopWhenTemplError_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DebugMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableVC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FixDBModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PackMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PACKMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnMSDepFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNMSDEPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSConsoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSCONSOLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysAppId2_Rule1(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("PSSYSAPPID2", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("PSSYSAPPID2", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSSYSAPPID", "", true)) {
                return null;
            }
            return "\u4e91\u5e94\u75282\u4e0d\u80fd\u4e0e\u4e91\u5e94\u7528\u76f8\u540c";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_PSSysAppName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDInstCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDINSTCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRunSessionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNSESSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRunSessionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNSESSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_QuickMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RebuildMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RunMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM10", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM11", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM12", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RunParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RunParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM7", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM8", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPARAM9", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcPSSysDMVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSSYSDMVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSSysDMVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSSYSDMVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StopWhenTemplError_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysRunSession pSSysRunSession) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysRunSession)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysRunSession pSSysRunSession) throws Exception {
        super.onUpdateParent(pSSysRunSession);
    }

    @Override
    protected void exportCurXmlModel(PSSysRunSession pSSysRunSession, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSRUNSESSION");
        if (!bl) {
            super.exportCurXmlModel(pSSysRunSession, xmlNode, bl);
        }
    }
}

