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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDocBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysERMapNodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysERMapNodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTableBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysERMapNodeServiceBase
extends PSCoreSysServiceBase<PSSysERMapNode> {
    private static final Log log = LogFactory.getLog(PSSysERMapNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysERMapNodeDEModel pSSysERMapNodeDEModel;
    private PSSysERMapNodeDAO pSSysERMapNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService";
    }

    public PSSysERMapNodeDEModel getPSSysERMapNodeDEModel() {
        if (this.pSSysERMapNodeDEModel == null) {
            try {
                this.pSSysERMapNodeDEModel = (PSSysERMapNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysERMapNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysERMapNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysERMapNodeDEModel();
    }

    public PSSysERMapNodeDAO getPSSysERMapNodeDAO() {
        if (this.pSSysERMapNodeDAO == null) {
            try {
                this.pSSysERMapNodeDAO = (PSSysERMapNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysERMapNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysERMapNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysERMapNodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysERMapNode pSSysERMapNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppLocalDE);
            } else {
                iService.get(pSAppLocalDE);
            }
            this.onFillParentInfo_PSAppLocalDE(pSSysERMapNode, pSAppLocalDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysERMapNode, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSDESERVICEAPI_PSDESERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)iService.getDEModel().createEntity();
            pSDEServiceAPI.set("PSDESERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEServiceAPI);
            } else {
                iService.get(pSDEServiceAPI);
            }
            this.onFillParentInfo_PSDEServiceAPI(pSSysERMapNode, pSDEServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSUBSYSSADE_PSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysSADE);
            } else {
                iService.get(pSSubSysSADE);
            }
            this.onFillParentInfo_PSSubSysSADE(pSSysERMapNode, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSUBSYSSERVICEAPI_PSSUBSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSubSysServiceAPI pSSubSysServiceAPI = (PSSubSysServiceAPI)iService.getDEModel().createEntity();
            pSSubSysServiceAPI.set("PSSUBSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSysServiceAPI);
            } else {
                iService.get(pSSubSysServiceAPI);
            }
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysERMapNode, pSSubSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysERMapNode, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = (PSSysBDScheme)iService.getDEModel().createEntity();
            pSSysBDScheme.set("PSSYSBDSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDScheme);
            } else {
                iService.get(pSSysBDScheme);
            }
            this.onFillParentInfo_PSSysBDScheme(pSSysERMapNode, pSSysBDScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSSysERMapNode, pSSysBDTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSDBSCHEME_PSSYSDBSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)iService.getDEModel().createEntity();
            pSSysDBScheme.set("PSSYSDBSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBScheme);
            } else {
                iService.get(pSSysDBScheme);
            }
            this.onFillParentInfo_PSSysDBScheme(pSSysERMapNode, pSSysDBScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSDBTABLE_PSSYSDBTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService", (SessionFactory)this.getSessionFactory());
            PSSysDBTable pSSysDBTable = (PSSysDBTable)iService.getDEModel().createEntity();
            pSSysDBTable.set("PSSYSDBTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBTable);
            } else {
                iService.get(pSSysDBTable);
            }
            this.onFillParentInfo_PSSysDBTable(pSSysERMapNode, pSSysDBTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_RefPSSysDynaModel(pSSysERMapNode, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService", (SessionFactory)this.getSessionFactory());
            PSSysERMap pSSysERMap = (PSSysERMap)iService.getDEModel().createEntity();
            pSSysERMap.set("PSSYSERMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysERMap);
            } else {
                iService.get(pSSysERMap);
            }
            this.onFillParentInfo_PSSysERMap(pSSysERMapNode, pSSysERMap);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDocService", (SessionFactory)this.getSessionFactory());
            PSSysSearchDoc pSSysSearchDoc = (PSSysSearchDoc)iService.getDEModel().createEntity();
            pSSysSearchDoc.set("PSSYSSEARCHDOCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchDoc);
            } else {
                iService.get(pSSysSearchDoc);
            }
            this.onFillParentInfo_PSSysSearchDoc(pSSysERMapNode, pSSysSearchDoc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSSEARCHSCHEME_PSSYSSEARCHSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysSearchScheme pSSysSearchScheme = (PSSysSearchScheme)iService.getDEModel().createEntity();
            pSSysSearchScheme.set("PSSYSSEARCHSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchScheme);
            } else {
                iService.get(pSSysSearchScheme);
            }
            this.onFillParentInfo_PSSysSearchScheme(pSSysERMapNode, pSSysSearchScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSERMAPNODE_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysServiceAPI);
            } else {
                iService.get(pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysSerrviceAPI(pSSysERMapNode, pSSysServiceAPI);
            return;
        }
        super.onFillParentInfo(pSSysERMapNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppLocalDE(PSSysERMapNode pSSysERMapNode, PSAppLocalDE pSAppLocalDE) throws Exception {
        pSSysERMapNode.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
        pSSysERMapNode.setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
    }

    protected void onFillParentInfo_PSDE(PSSysERMapNode pSSysERMapNode, PSDataEntity pSDataEntity) throws Exception {
        pSSysERMapNode.setColor(pSDataEntity.getColor());
        pSSysERMapNode.setLogicName(pSDataEntity.getLogicName());
        pSSysERMapNode.setModColor(pSDataEntity.getModColor());
        pSSysERMapNode.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysERMapNode.setPSDEName(pSDataEntity.getPSDataEntityName());
        pSSysERMapNode.setPSModuleId(pSDataEntity.getPSModuleId());
        pSSysERMapNode.setPSModuleName(pSDataEntity.getPSModuleName());
    }

    protected void onFillParentInfo_PSDEServiceAPI(PSSysERMapNode pSSysERMapNode, PSDEServiceAPI pSDEServiceAPI) throws Exception {
        pSSysERMapNode.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
        pSSysERMapNode.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
    }

    protected void onFillParentInfo_PSSubSysSADE(PSSysERMapNode pSSysERMapNode, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSysERMapNode.setPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSysERMapNode.setPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PSSubSysServiceAPI(PSSysERMapNode pSSysERMapNode, PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        pSSysERMapNode.setPSSubSysServiceAPIId(pSSubSysServiceAPI.getPSSubSysServiceAPIId());
        pSSysERMapNode.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysERMapNode pSSysERMapNode, PSSysApp pSSysApp) throws Exception {
        pSSysERMapNode.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysERMapNode.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysBDScheme(PSSysERMapNode pSSysERMapNode, PSSysBDScheme pSSysBDScheme) throws Exception {
        pSSysERMapNode.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
        pSSysERMapNode.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
    }

    protected void onFillParentInfo_PSSysBDTable(PSSysERMapNode pSSysERMapNode, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysERMapNode.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysERMapNode.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected void onFillParentInfo_PSSysDBScheme(PSSysERMapNode pSSysERMapNode, PSSysDBScheme pSSysDBScheme) throws Exception {
        pSSysERMapNode.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
        pSSysERMapNode.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
    }

    protected void onFillParentInfo_PSSysDBTable(PSSysERMapNode pSSysERMapNode, PSSysDBTable pSSysDBTable) throws Exception {
        pSSysERMapNode.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
        pSSysERMapNode.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
    }

    protected void onFillParentInfo_RefPSSysDynaModel(PSSysERMapNode pSSysERMapNode, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysERMapNode.setRefPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysERMapNode.setRefPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysERMap(PSSysERMapNode pSSysERMapNode, PSSysERMap pSSysERMap) throws Exception {
        pSSysERMapNode.setPSSysERMapId(pSSysERMap.getPSSysERMapId());
        pSSysERMapNode.setPSSysERMapName(pSSysERMap.getPSSysERMapName());
    }

    protected void onFillParentInfo_PSSysSearchDoc(PSSysERMapNode pSSysERMapNode, PSSysSearchDoc pSSysSearchDoc) throws Exception {
        pSSysERMapNode.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
        pSSysERMapNode.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
    }

    protected void onFillParentInfo_PSSysSearchScheme(PSSysERMapNode pSSysERMapNode, PSSysSearchScheme pSSysSearchScheme) throws Exception {
        pSSysERMapNode.setPSSysSearchSchemeId(pSSysSearchScheme.getPSSysSearchSchemeId());
        pSSysERMapNode.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
    }

    protected void onFillParentInfo_PSSysSerrviceAPI(PSSysERMapNode pSSysERMapNode, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysERMapNode.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSysERMapNode.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillEntityFullInfo(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (bl) {
            if (pSSysERMapNode.getLeftPos() == null) {
                pSSysERMapNode.setLeftPos((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
            if (pSSysERMapNode.getTopPos() == null) {
                pSSysERMapNode.setTopPos((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSAppLocalDE(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSDE(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSDEServiceAPI(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSubSysSADE(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSubSysServiceAPI(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysBDScheme(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysDBScheme(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysDBTable(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_RefPSSysDynaModel(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysERMap(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysSearchDoc(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysSearchScheme(pSSysERMapNode, bl);
        this.onFillEntityFullInfo_PSSysSerrviceAPI(pSSysERMapNode, bl);
    }

    protected void onFillEntityFullInfo_PSAppLocalDE(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSAppLocalDEIdDirty()) {
            if (pSSysERMapNode.getPSAppLocalDEId() != null) {
                if (pSSysERMapNode.getPSAppLocalDEId() == null || pSSysERMapNode.getPSAppLocalDEName() == null) {
                    PSAppLocalDE pSAppLocalDE = pSSysERMapNode.getPSAppLocalDE();
                    pSSysERMapNode.setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
                }
            } else {
                pSSysERMapNode.setPSAppLocalDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSDEIdDirty()) {
            if (pSSysERMapNode.getPSDEId() != null) {
                if (pSSysERMapNode.getPSDEId() == null || pSSysERMapNode.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysERMapNode.getPSDE();
                    pSSysERMapNode.setColor(pSDataEntity.getColor());
                    pSSysERMapNode.setLogicName(pSDataEntity.getLogicName());
                    pSSysERMapNode.setModColor(pSDataEntity.getModColor());
                    pSSysERMapNode.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSSysERMapNode.setPSModuleId(pSDataEntity.getPSModuleId());
                    pSSysERMapNode.setPSModuleName(pSDataEntity.getPSModuleName());
                }
            } else {
                pSSysERMapNode.setColor(null);
                pSSysERMapNode.setLogicName(null);
                pSSysERMapNode.setModColor(null);
                pSSysERMapNode.setPSDEName(null);
                pSSysERMapNode.setPSModuleId(null);
                pSSysERMapNode.setPSModuleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEServiceAPI(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSDEServiceAPIIdDirty()) {
            if (pSSysERMapNode.getPSDEServiceAPIId() != null) {
                if (pSSysERMapNode.getPSDEServiceAPIId() == null || pSSysERMapNode.getPSDEServiceAPIName() == null) {
                    PSDEServiceAPI pSDEServiceAPI = pSSysERMapNode.getPSDEServiceAPI();
                    pSSysERMapNode.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
                }
            } else {
                pSSysERMapNode.setPSDEServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysSADE(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSubSysSADEIdDirty()) {
            if (pSSysERMapNode.getPSSubSysSADEId() != null) {
                if (pSSysERMapNode.getPSSubSysSADEId() == null || pSSysERMapNode.getPSSubSysSADEName() == null) {
                    PSSubSysSADE pSSubSysSADE = pSSysERMapNode.getPSSubSysSADE();
                    pSSysERMapNode.setPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
                }
            } else {
                pSSysERMapNode.setPSSubSysSADEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysServiceAPI(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSubSysServiceAPIIdDirty()) {
            if (pSSysERMapNode.getPSSubSysServiceAPIId() != null) {
                if (pSSysERMapNode.getPSSubSysServiceAPIId() == null || pSSysERMapNode.getPSSubSysServiceAPIName() == null) {
                    PSSubSysServiceAPI pSSubSysServiceAPI = pSSysERMapNode.getPSSubSysServiceAPI();
                    pSSysERMapNode.setPSSubSysServiceAPIName(pSSubSysServiceAPI.getPSSubSysServiceAPIName());
                }
            } else {
                pSSysERMapNode.setPSSubSysServiceAPIName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysAppIdDirty()) {
            if (pSSysERMapNode.getPSSysAppId() != null) {
                if (pSSysERMapNode.getPSSysAppId() == null || pSSysERMapNode.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSSysERMapNode.getPSSysApp();
                    pSSysERMapNode.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSSysERMapNode.setPSSysAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBDScheme(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysBDSchemeIdDirty()) {
            if (pSSysERMapNode.getPSSysBDSchemeId() != null) {
                if (pSSysERMapNode.getPSSysBDSchemeId() == null || pSSysERMapNode.getPSSysBDSchemeName() == null) {
                    PSSysBDScheme pSSysBDScheme = pSSysERMapNode.getPSSysBDScheme();
                    pSSysERMapNode.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
                }
            } else {
                pSSysERMapNode.setPSSysBDSchemeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysBDTableIdDirty()) {
            if (pSSysERMapNode.getPSSysBDTableId() != null) {
                if (pSSysERMapNode.getPSSysBDTableId() == null || pSSysERMapNode.getPSSysBDTableName() == null) {
                    PSSysBDTable pSSysBDTable = pSSysERMapNode.getPSSysBDTable();
                    pSSysERMapNode.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                }
            } else {
                pSSysERMapNode.setPSSysBDTableName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDBScheme(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysDBSchemeIdDirty()) {
            if (pSSysERMapNode.getPSSysDBSchemeId() != null) {
                if (pSSysERMapNode.getPSSysDBSchemeId() == null || pSSysERMapNode.getPSSysDBSchemeName() == null) {
                    PSSysDBScheme pSSysDBScheme = pSSysERMapNode.getPSSysDBScheme();
                    pSSysERMapNode.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
                }
            } else {
                pSSysERMapNode.setPSSysDBSchemeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDBTable(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysDBTableIdDirty()) {
            if (pSSysERMapNode.getPSSysDBTableId() != null) {
                if (pSSysERMapNode.getPSSysDBTableId() == null || pSSysERMapNode.getPSSysDBTableName() == null) {
                    PSSysDBTable pSSysDBTable = pSSysERMapNode.getPSSysDBTable();
                    pSSysERMapNode.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                }
            } else {
                pSSysERMapNode.setPSSysDBTableName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSSysDynaModel(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysERMap(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchDoc(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysSearchDocIdDirty()) {
            if (pSSysERMapNode.getPSSysSearchDocId() != null) {
                if (pSSysERMapNode.getPSSysSearchDocId() == null || pSSysERMapNode.getPSSysSearchDocName() == null) {
                    PSSysSearchDoc pSSysSearchDoc = pSSysERMapNode.getPSSysSearchDoc();
                    pSSysERMapNode.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
                }
            } else {
                pSSysERMapNode.setPSSysSearchDocName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSearchScheme(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysSearchSchemeIdDirty()) {
            if (pSSysERMapNode.getPSSysSearchSchemeId() != null) {
                if (pSSysERMapNode.getPSSysSearchSchemeId() == null || pSSysERMapNode.getPSSysSearchSchemeName() == null) {
                    PSSysSearchScheme pSSysSearchScheme = pSSysERMapNode.getPSSysSearchScheme();
                    pSSysERMapNode.setPSSysSearchSchemeName(pSSysSearchScheme.getPSSysSearchSchemeName());
                }
            } else {
                pSSysERMapNode.setPSSysSearchSchemeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSerrviceAPI(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        if (pSSysERMapNode.isPSSysServiceAPIIdDirty()) {
            if (pSSysERMapNode.getPSSysServiceAPIId() != null) {
                if (pSSysERMapNode.getPSSysServiceAPIId() == null || pSSysERMapNode.getPSSysServiceAPIName() == null) {
                    PSSysServiceAPI pSSysServiceAPI = pSSysERMapNode.getPSSysSerrviceAPI();
                    pSSysERMapNode.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                }
            } else {
                pSSysERMapNode.setPSSysServiceAPIName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysERMapNode, bl);
    }

    public ArrayList<PSSysERMapNode> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysERMapNode> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysERMapNode> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string) throws Exception {
        return this.selectByPSDEServiceAPI(pSDEServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSDEServiceAPI(PSDEServiceAPIBase pSDEServiceAPIBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysERMapNode> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSubSysServiceAPI(pSSubSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSubSysServiceAPI(PSSubSysServiceAPIBase pSSubSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSERVICEAPIID", (Object)pSSubSysServiceAPIBase.getPSSubSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysERMapNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDSCHEMEID", (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDTABLEID", (Object)pSSysBDTableBase.getPSSysBDTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBSCHEMEID", (Object)pSSysDBSchemeBase.getPSSysDBSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBTABLEID", (Object)pSSysDBTableBase.getPSSysDBTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysERMap(PSSysERMapBase pSSysERMapBase) throws Exception {
        return this.selectByPSSysERMap(pSSysERMapBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysERMap(PSSysERMapBase pSSysERMapBase, String string) throws Exception {
        return this.selectByPSSysERMap(pSSysERMapBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysERMap(PSSysERMapBase pSSysERMapBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSERMAPID", (Object)pSSysERMapBase.getPSSysERMapId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysERMapCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysERMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectTempByPSSysERMap(PSSysERMapBase pSSysERMapBase) throws Exception {
        return this.selectTempByPSSysERMap(pSSysERMapBase, "");
    }

    public ArrayList<PSSysERMapNode> selectTempByPSSysERMap(PSSysERMapBase pSSysERMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSERMAPID", (Object)pSSysERMapBase.getPSSysERMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysERMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysERMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHDOCID", (Object)pSSysSearchDocBase.getPSSysSearchDocId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchDocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchDocCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string) throws Exception {
        return this.selectByPSSysSearchScheme(pSSysSearchSchemeBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSearchScheme(PSSysSearchSchemeBase pSSysSearchSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHSCHEMEID", (Object)pSSysSearchSchemeBase.getPSSysSearchSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSerrviceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysSerrviceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSerrviceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysSerrviceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysERMapNode> selectByPSSysSerrviceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSERVICEAPIID", (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSerrviceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSerrviceAPICond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    public void resetPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSAppLocalDEId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSDEId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    public void resetPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSDEServiceAPIId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        final PSDEServiceAPI pSDEServiceAPI2 = pSDEServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSDEServiceAPI(pSDEServiceAPI2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSDEServiceAPI(pSDEServiceAPI);
        this.onBeforeRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSDEServiceAPI(pSDEServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEServiceAPI(PSDEServiceAPI pSDEServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    public void resetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSubSysSADEId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    public void resetPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSubSysServiceAPIId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        final PSSubSysServiceAPI pSSubSysServiceAPI2 = pSSubSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSubSysServiceAPI(pSSubSysServiceAPI);
        this.onBeforeRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSubSysServiceAPI(pSSubSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysServiceAPI(PSSubSysServiceAPI pSSubSysServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysAppId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    public void resetPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysBDSchemeId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        final PSSysBDScheme pSSysBDScheme2 = pSSysBDScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysBDTableId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    public void resetPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysDBSchemeId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        final PSSysDBScheme pSSysDBScheme2 = pSSysDBScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void internalRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    public void resetPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysDBTableId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        final PSSysDBTable pSSysDBTable2 = pSSysDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysDBTable(pSSysDBTable2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysDBTable(pSSysDBTable2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysDBTable(pSSysDBTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void internalRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        this.onBeforeRemoveByPSSysDBTable(pSSysDBTable, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysDBTable(pSSysDBTable, arrayList);
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSERMAPNODE_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSERMAPNODE", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setRefPSSysDynaModelId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSSysERMapNodeServiceBase.this.internalRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
    }

    public void resetPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysERMap(pSSysERMap);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysERMapId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void resetTempPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectTempByPSSysERMap(pSSysERMap);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysERMapId(null);
            this.updateTemp(pSSysERMapNode2);
        }
    }

    public void removeByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysERMap(pSSysERMap2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysERMap(pSSysERMap2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysERMap(pSSysERMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
    }

    protected void internalRemoveByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysERMap(pSSysERMap);
        this.onBeforeRemoveByPSSysERMap(pSSysERMap, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysERMap(pSSysERMap, arrayList);
    }

    protected void onAfterRemoveByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
    }

    protected void onBeforeRemoveByPSSysERMap(PSSysERMap pSSysERMap, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysERMap(PSSysERMap pSSysERMap, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    public void resetPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysSearchDocId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        final PSSysSearchDoc pSSysSearchDoc2 = pSSysSearchDoc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void internalRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    public void resetPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysSearchSchemeId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        final PSSysSearchScheme pSSysSearchScheme2 = pSSysSearchScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysSearchScheme(pSSysSearchScheme2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void internalRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSearchScheme(pSSysSearchScheme);
        this.onBeforeRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysSearchScheme(pSSysSearchScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchScheme(PSSysSearchScheme pSSysSearchScheme, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    public void resetPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSerrviceAPI(pSSysServiceAPI);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            PSSysERMapNode pSSysERMapNode2 = (PSSysERMapNode)this.getDEModel().createEntity();
            pSSysERMapNode2.setPSSysERMapNodeId(pSSysERMapNode.getPSSysERMapNodeId());
            pSSysERMapNode2.setPSSysServiceAPIId(null);
            this.update(pSSysERMapNode2);
        }
    }

    public void removeByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveByPSSysSerrviceAPI(pSSysServiceAPI2);
                PSSysERMapNodeServiceBase.this.internalRemoveByPSSysSerrviceAPI(pSSysServiceAPI2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveByPSSysSerrviceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectByPSSysSerrviceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysSerrviceAPI(pSSysServiceAPI, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.remove(pSSysERMapNode);
        }
        this.onAfterRemoveByPSSysSerrviceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSerrviceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysERMapNode pSSysERMapNode) throws Exception {
        super.onBeforeRemove(pSSysERMapNode);
    }

    public void removeTempByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        final PSSysERMap pSSysERMap2 = pSSysERMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysERMapNodeServiceBase.this.onBeforeRemoveTempByPSSysERMap(pSSysERMap2);
                PSSysERMapNodeServiceBase.this.internalRemoveTempByPSSysERMap(pSSysERMap2);
                PSSysERMapNodeServiceBase.this.onAfterRemoveTempByPSSysERMap(pSSysERMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
    }

    protected void internalRemoveTempByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
        ArrayList<PSSysERMapNode> arrayList = this.selectTempByPSSysERMap(pSSysERMap);
        this.onBeforeRemoveTempByPSSysERMap(pSSysERMap, arrayList);
        for (PSSysERMapNode pSSysERMapNode : arrayList) {
            this.removeTemp(pSSysERMapNode);
        }
        this.onAfterRemoveTempByPSSysERMap(pSSysERMap, arrayList);
    }

    protected void onAfterRemoveTempByPSSysERMap(PSSysERMap pSSysERMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysERMap(PSSysERMap pSSysERMap, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysERMap(PSSysERMap pSSysERMap, ArrayList<PSSysERMapNode> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysERMapNode pSSysERMapNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysERMapNode, cloneSession);
        if (pSSysERMapNode.getPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)pSSysERMapNode.getPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PSAppLocalDE(pSSysERMapNode, (PSAppLocalDE)iEntity);
        }
        if (pSSysERMapNode.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysERMapNode.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysERMapNode, (PSDataEntity)iEntity);
        }
        if (pSSysERMapNode.getPSDEServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSDESERVICEAPI", (Object)pSSysERMapNode.getPSDEServiceAPIId())) != null) {
            this.onFillParentInfo_PSDEServiceAPI(pSSysERMapNode, (PSDEServiceAPI)iEntity);
        }
        if (pSSysERMapNode.getPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSysERMapNode.getPSSubSysSADEId())) != null) {
            this.onFillParentInfo_PSSubSysSADE(pSSysERMapNode, (PSSubSysSADE)iEntity);
        }
        if (pSSysERMapNode.getPSSubSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSERVICEAPI", (Object)pSSysERMapNode.getPSSubSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSubSysServiceAPI(pSSysERMapNode, (PSSubSysServiceAPI)iEntity);
        }
        if (pSSysERMapNode.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysERMapNode.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysERMapNode, (PSSysApp)iEntity);
        }
        if (pSSysERMapNode.getPSSysBDSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBDSCHEME", (Object)pSSysERMapNode.getPSSysBDSchemeId())) != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysERMapNode, (PSSysBDScheme)iEntity);
        }
        if (pSSysERMapNode.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysERMapNode.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSSysERMapNode, (PSSysBDTable)iEntity);
        }
        if (pSSysERMapNode.getPSSysDBSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSDBSCHEME", (Object)pSSysERMapNode.getPSSysDBSchemeId())) != null) {
            this.onFillParentInfo_PSSysDBScheme(pSSysERMapNode, (PSSysDBScheme)iEntity);
        }
        if (pSSysERMapNode.getPSSysDBTableId() != null && (iEntity = cloneSession.getEntity("PSSYSDBTABLE", (Object)pSSysERMapNode.getPSSysDBTableId())) != null) {
            this.onFillParentInfo_PSSysDBTable(pSSysERMapNode, (PSSysDBTable)iEntity);
        }
        if (pSSysERMapNode.getRefPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysERMapNode.getRefPSSysDynaModelId())) != null) {
            this.onFillParentInfo_RefPSSysDynaModel(pSSysERMapNode, (PSSysDynaModel)iEntity);
        }
        if (pSSysERMapNode.getPSSysERMapId() != null && (iEntity = cloneSession.getEntity("PSSYSERMAP", (Object)pSSysERMapNode.getPSSysERMapId())) != null) {
            this.onFillParentInfo_PSSysERMap(pSSysERMapNode, (PSSysERMap)iEntity);
        }
        if (pSSysERMapNode.getPSSysSearchDocId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHDOC", (Object)pSSysERMapNode.getPSSysSearchDocId())) != null) {
            this.onFillParentInfo_PSSysSearchDoc(pSSysERMapNode, (PSSysSearchDoc)iEntity);
        }
        if (pSSysERMapNode.getPSSysSearchSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHSCHEME", (Object)pSSysERMapNode.getPSSysSearchSchemeId())) != null) {
            this.onFillParentInfo_PSSysSearchScheme(pSSysERMapNode, (PSSysSearchScheme)iEntity);
        }
        if (pSSysERMapNode.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSysERMapNode.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysSerrviceAPI(pSSysERMapNode, (PSSysServiceAPI)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysERMapNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DetailMode(bl, pSSysERMapNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeTag(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeTag2(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NodeType(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEServiceAPIName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysServiceAPIName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBSchemeId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBSchemeName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysERMapId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysERMapNodeId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysERMapNodeName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchSchemeName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIName(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysDynaModelId(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShapeParams(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowDEFields(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysERMapNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysERMapNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DetailMode(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isDetailModeDirty() : !pSSysERMapNode.isDetailModeDirty()) {
            return null;
        }
        Integer n = pSSysERMapNode.getDetailMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DetailMode_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isLeftPosDirty() : !pSSysERMapNode.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSSysERMapNode.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isMemoDirty() : !pSSysERMapNode.isMemoDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_NodeTag(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isNodeTagDirty() : !pSSysERMapNode.isNodeTagDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getNodeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeTag_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeTag2(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isNodeTag2Dirty() : !pSSysERMapNode.isNodeTag2Dirty()) {
            return null;
        }
        String string = pSSysERMapNode.getNodeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeTag2_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NodeType(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isNodeTypeDirty() : !pSSysERMapNode.isNodeTypeDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getNodeType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NodeType_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSAppLocalDEIdDirty() : !pSSysERMapNode.isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
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
                string3 = "PSSYSERMAPID";
                String string4 = this.checkFieldDupRule(this.getPSSysERMapNodeDEModel(), "PSAPPLOCALDEID", string3, pSSysERMapNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPLOCALDEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSAppLocalDENameDirty() : !pSSysERMapNode.isPSAppLocalDENameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSAppLocalDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSDEIdDirty() : !pSSysERMapNode.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
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
                string3 = "PSSYSERMAPID";
                String string4 = this.checkFieldDupRule(this.getPSSysERMapNodeDEModel(), "PSDEID", string3, pSSysERMapNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSDENameDirty() : !pSSysERMapNode.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEServiceAPIId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSDEServiceAPIIdDirty() : !pSSysERMapNode.isPSDEServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSDEServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPIID");
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
                string3 = "PSSYSERMAPID";
                String string4 = this.checkFieldDupRule(this.getPSSysERMapNodeDEModel(), "PSDESERVICEAPIID", string3, pSSysERMapNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDESERVICEAPIID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEServiceAPIName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSDEServiceAPINameDirty() : !pSSysERMapNode.isPSDEServiceAPINameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSDEServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEServiceAPIName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADEId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSubSysSADEIdDirty() : !pSSysERMapNode.isPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEID");
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
                string3 = "PSSYSERMAPID";
                String string4 = this.checkFieldDupRule(this.getPSSysERMapNodeDEModel(), "PSSUBSYSSADEID", string3, pSSysERMapNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBSYSSADEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADEName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSubSysSADENameDirty() : !pSSysERMapNode.isPSSubSysSADENameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSubSysSADEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSubSysServiceAPIIdDirty() : !pSSysERMapNode.isPSSubSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSubSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysServiceAPIName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSubSysServiceAPINameDirty() : !pSSysERMapNode.isPSSubSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSubSysServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysServiceAPIName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSERVICEAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysAppIdDirty() : !pSSysERMapNode.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysAppNameDirty() : !pSSysERMapNode.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysBDSchemeIdDirty() : !pSSysERMapNode.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysBDSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDSchemeName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysBDSchemeNameDirty() : !pSSysERMapNode.isPSSysBDSchemeNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysBDSchemeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysBDTableIdDirty() : !pSSysERMapNode.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysBDTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysBDTableNameDirty() : !pSSysERMapNode.isPSSysBDTableNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysBDTableName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBSchemeId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysDBSchemeIdDirty() : !pSSysERMapNode.isPSSysDBSchemeIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysDBSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBSchemeId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBSchemeName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysDBSchemeNameDirty() : !pSSysERMapNode.isPSSysDBSchemeNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysDBSchemeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBSchemeName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysDBTableIdDirty() : !pSSysERMapNode.isPSSysDBTableIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysDBTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLEID");
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
                string3 = "PSSYSERMAPID";
                String string4 = this.checkFieldDupRule(this.getPSSysERMapNodeDEModel(), "PSSYSDBTABLEID", string3, pSSysERMapNode, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBTABLEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysDBTableNameDirty() : !pSSysERMapNode.isPSSysDBTableNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysDBTableName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysERMapId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysERMapIdDirty() : !pSSysERMapNode.isPSSysERMapIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysERMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysERMapId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysERMapNodeId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysERMapNodeIdDirty() && !bl2 : !pSSysERMapNode.isPSSysERMapNodeIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysERMapNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysERMapNodeId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysERMapNodeName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysERMapNodeNameDirty() && !bl2 : !pSSysERMapNode.isPSSysERMapNodeNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysERMapNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysERMapNodeName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSERMAPNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysSearchDocIdDirty() : !pSSysERMapNode.isPSSysSearchDocIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysSearchDocId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysSearchDocNameDirty() : !pSSysERMapNode.isPSSysSearchDocNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysSearchDocName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysSearchSchemeIdDirty() : !pSSysERMapNode.isPSSysSearchSchemeIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysSearchSchemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchSchemeName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysSearchSchemeNameDirty() : !pSSysERMapNode.isPSSysSearchSchemeNameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysSearchSchemeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchSchemeName_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHSCHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysServiceAPIIdDirty() : !pSSysERMapNode.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysServiceAPIName(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isPSSysServiceAPINameDirty() : !pSSysERMapNode.isPSSysServiceAPINameDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getPSSysServiceAPIName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIName_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSSysDynaModelId(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isRefPSSysDynaModelIdDirty() : !pSSysERMapNode.isRefPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getRefPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysDynaModelId_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShapeParams(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isShapeParamsDirty() : !pSSysERMapNode.isShapeParamsDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getShapeParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShapeParams_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAPEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowDEFields(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isShowDEFieldsDirty() : !pSSysERMapNode.isShowDEFieldsDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getShowDEFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShowDEFields_Default(pSSysERMapNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWDEFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isTopPosDirty() : !pSSysERMapNode.isTopPosDirty()) {
            return null;
        }
        Integer n = pSSysERMapNode.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isUserCatDirty() : !pSSysERMapNode.isUserCatDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isUserTagDirty() : !pSSysERMapNode.isUserTagDirty()) {
            return null;
        }
        String string = pSSysERMapNode.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isUserTag2Dirty() : !pSSysERMapNode.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysERMapNode.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isUserTag3Dirty() : !pSSysERMapNode.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysERMapNode.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysERMapNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysERMapNode pSSysERMapNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysERMapNode.isUserTag4Dirty() : !pSSysERMapNode.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysERMapNode.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysERMapNode, bl2, bl3);
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

    protected void onSyncEntity(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        super.onSyncEntity(pSSysERMapNode, bl);
    }

    protected void onSyncIndexEntities(PSSysERMapNode pSSysERMapNode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysERMapNode, bl);
    }

    public Object getDataContextValue(PSSysERMapNode pSSysERMapNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysERMapNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysERMap pSSysERMap = pSSysERMapNode.getPSSysERMap();
        if (pSSysERMap != null && pSSysERMap.contains(string)) {
            return pSSysERMap.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysERMapNode pSSysERMapNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysERMapNode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MODCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSERMAPNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysERMapNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAPEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShapeParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWDEFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowDEFields_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_DetailMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_ModColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NODETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysERMapNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSERMAPNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShapeParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHAPEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowDEFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHOWDEFIELDS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysERMapNode pSSysERMapNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysERMapNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysERMapNode pSSysERMapNode) throws Exception {
        super.onUpdateParent(pSSysERMapNode);
    }

    @Override
    protected void exportCurXmlModel(PSSysERMapNode pSSysERMapNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSERMAPNODE");
        if (!bl) {
            pSSysERMapNode.setCreateDate(null);
            pSSysERMapNode.setCreateMan(null);
            pSSysERMapNode.setPSSysERMapName(null);
            pSSysERMapNode.setPSSysERMapNodeId(null);
            pSSysERMapNode.setUpdateDate(null);
            pSSysERMapNode.setUpdateMan(null);
            pSSysERMapNode.setPSSysERMapId(null);
            pSSysERMapNode.setPSSysERMapName(null);
            super.exportCurXmlModel(pSSysERMapNode, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysERMapNode pSSysERMapNode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysERMapNode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSERMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSERMAP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSERMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSERMAPNODE_PSSYSERMAP_PSSYSERMAPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSERMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSERMAPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSERMAP", (boolean)true) == 0) {
            iEntity.set("PSSYSERMAPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSERMAPID"};
    }

    @Override
    public String getModelV2Tag(PSSysERMapNode pSSysERMapNode) {
        return super.getModelV2Tag(pSSysERMapNode);
    }

    @Override
    public boolean setModelV2Tag(PSSysERMapNode pSSysERMapNode, String string) {
        return super.setModelV2Tag(pSSysERMapNode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSERMAPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysERMapNode pSSysERMapNode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysERMapNode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysERMapNode, true);
        return super.getModelV2Entity(pSSysERMapNode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysERMapNode pSSysERMapNode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysERMapNode, objectNode, string, string2, n);
    }
}

