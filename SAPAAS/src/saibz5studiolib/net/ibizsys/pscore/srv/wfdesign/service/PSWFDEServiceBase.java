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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFDEDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFDEDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCat;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFCatBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFDEServiceBase
extends PSCoreSysServiceBase<PSWFDE> {
    private static final Log log = LogFactory.getLog(PSWFDEServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURWF = "CurWF";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDEWFVIEWS = "InitDEWFViews";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSWFDEDEModel pSWFDEDEModel;
    private PSWFDEDAO pSWFDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService";
    }

    public PSWFDEDEModel getPSWFDEDEModel() {
        if (this.pSWFDEDEModel == null) {
            try {
                this.pSWFDEDEModel = (PSWFDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFDEDEModel();
    }

    public PSWFDEDAO getPSWFDEDAO() {
        if (this.pSWFDEDAO == null) {
            try {
                this.pSWFDEDAO = (PSWFDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFDEDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF, (boolean)true) == 0) {
            return this.fetchCurWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDEWFVIEWS, (boolean)true) == 0) {
            this.initDEWFViews((PSWFDE)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void initDEWFViews(PSWFDE pSWFDE) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDEWFVIEWS, 0, pSWFDE, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSWFDE, ACTION_INITDEWFVIEWS);
        final PSWFDE pSWFDE2 = pSWFDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFDEServiceBase.this.getService(), PSWFDEServiceBase.ACTION_INITDEWFVIEWS, 40, pSWFDE2, null).getResult() != 1) {
                    PSWFDEServiceBase.this.onInitDEWFViews(pSWFDE2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDEWFVIEWS, 99, pSWFDE, null);
        }
    }

    protected void onInitDEWFViews(PSWFDE pSWFDE) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDEWFViews]");
    }

    protected void onFillParentInfo(PSWFDE pSWFDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSWFDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEACTION_FINISHPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_FinishPSDEAction(pSWFDE, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEACTION_INITPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_InitPSDEAction(pSWFDE, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_PROXYDATAPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ProxyDataPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_PROXYMODULEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ProxyModulePSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_PROXYWFPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_ProxyWFPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_PWFINSTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PWFInstPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_STATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_StatePSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFACTORPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFActorPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFIDPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFIdPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFINSTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFInstPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFRETPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFRetPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFSTATEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFStatePSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFSTEPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFStepPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEFIELD_WFVERPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_WFVerPSDEF(pSWFDE, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_ACTIONMOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_ActionMobPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_ACTIONPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_ActionPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_MOBPROXYDATA2PSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_MobProxyData2PSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_MOBPROXYDATAPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_MobProxyDataPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_PROXYDATA2PSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_ProxyData2PSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_PROXYDATAPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_ProxyDataPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_STARTMOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_StartMobPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSDEVIEWBASE_STARTPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_StartPSDEView(pSWFDE, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSLANGUAGERES_MYWFDATAPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_MyWFDataPSLanRes(pSWFDE, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSLANGUAGERES_MYWFWORKPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_MyWFWorkPSLanRes(pSWFDE, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPlugin);
            } else {
                iService.get(pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSWFDE, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSSYSWFCAT_PSSYSWFCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFCatService", (SessionFactory)this.getSessionFactory());
            PSSysWFCat pSSysWFCat = (PSSysWFCat)iService.getDEModel().createEntity();
            pSSysWFCat.set("PSSYSWFCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysWFCat);
            } else {
                iService.get(pSSysWFCat);
            }
            this.onFillParentInfo_PSSysWFCat(pSWFDE, pSSysWFCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFDE_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkflow);
            } else {
                iService.get(pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSWFDE, pSWorkflow);
            return;
        }
        super.onFillParentInfo(pSWFDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSWFDE pSWFDE, PSDataEntity pSDataEntity) throws Exception {
        pSWFDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSWFDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_FinishPSDEAction(PSWFDE pSWFDE, PSDEAction pSDEAction) throws Exception {
        pSWFDE.setFinishPSDEActionId(pSDEAction.getPSDEActionId());
        pSWFDE.setFinishPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_InitPSDEAction(PSWFDE pSWFDE, PSDEAction pSDEAction) throws Exception {
        pSWFDE.setInitPSDEActionId(pSDEAction.getPSDEActionId());
        pSWFDE.setInitPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_ProxyDataPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setProxyDataPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setProxyDataPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ProxyModulePSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setProxyModulePSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setProxyModulePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ProxyWFPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setProxyWFPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setProxyWFPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PWFInstPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setPWFInstPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setPWFInstPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_StatePSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setStatePSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFActorPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFActorPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFActorPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFIdPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFIdPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFIdPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFInstPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFInstPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFInstPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFRetPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFRetPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFRetPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFStatePSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFStatePSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFStatePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFStepPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFStepPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFStepPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_WFVerPSDEF(PSWFDE pSWFDE, PSDEField pSDEField) throws Exception {
        pSWFDE.setWFVerPSDEFId(pSDEField.getPSDEFieldId());
        pSWFDE.setWFVerPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_ActionMobPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setActionMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setActionMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_ActionPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setActionPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setActionPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MobProxyData2PSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setMobProxyData2PSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setMobProxyData2PSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MobProxyDataPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setMobProxyDataPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setMobProxyDataPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_ProxyData2PSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setProxyData2PSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setProxyData2PSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_ProxyDataPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setProxyDataPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setProxyDataPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_StartMobPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setStartMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setStartMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_StartPSDEView(PSWFDE pSWFDE, PSDEViewBase pSDEViewBase) throws Exception {
        pSWFDE.setStartPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSWFDE.setStartPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_MyWFDataPSLanRes(PSWFDE pSWFDE, PSLanguageRes pSLanguageRes) throws Exception {
        pSWFDE.setMyWFDataPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWFDE.setMyWFDataPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_MyWFWorkPSLanRes(PSWFDE pSWFDE, PSLanguageRes pSLanguageRes) throws Exception {
        pSWFDE.setMyWFWorkPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSWFDE.setMyWFWorkPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSWFDE pSWFDE, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSWFDE.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSWFDE.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysWFCat(PSWFDE pSWFDE, PSSysWFCat pSSysWFCat) throws Exception {
        pSWFDE.setPSSysWFCatId(pSSysWFCat.getPSSysWFCatId());
        pSWFDE.setPSSysWFCatName(pSSysWFCat.getPSSysWFCatName());
        pSWFDE.setWFCatCode(pSSysWFCat.getCatCode());
    }

    protected void onFillParentInfo_PSWF(PSWFDE pSWFDE, PSWorkflow pSWorkflow) throws Exception {
        pSWFDE.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFDE.setPSWFName(pSWorkflow.getPSWorkflowName());
        pSWFDE.setWFCodeName(pSWorkflow.getCodeName());
    }

    protected void onFillEntityFullInfo(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (bl) {
            if (pSWFDE.getCodeName() == null) {
                pSWFDE.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "WF", 25));
            }
            if (pSWFDE.getEnable() == null) {
                pSWFDE.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSWFDE.getPSDEViewBasesCnt() == null) {
                pSWFDE.setPSDEViewBasesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFDE.getValidFlag() == null) {
                pSWFDE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSWFDE, bl);
        this.onFillEntityFullInfo_PSDE(pSWFDE, bl);
        this.onFillEntityFullInfo_FinishPSDEAction(pSWFDE, bl);
        this.onFillEntityFullInfo_InitPSDEAction(pSWFDE, bl);
        this.onFillEntityFullInfo_ProxyDataPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_ProxyModulePSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_ProxyWFPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_PWFInstPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_StatePSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFActorPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFIdPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFInstPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFRetPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFStatePSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFStepPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_WFVerPSDEF(pSWFDE, bl);
        this.onFillEntityFullInfo_ActionMobPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_ActionPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_MobProxyData2PSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_MobProxyDataPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_ProxyData2PSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_ProxyDataPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_StartMobPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_StartPSDEView(pSWFDE, bl);
        this.onFillEntityFullInfo_MyWFDataPSLanRes(pSWFDE, bl);
        this.onFillEntityFullInfo_MyWFWorkPSLanRes(pSWFDE, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSWFDE, bl);
        this.onFillEntityFullInfo_PSSysWFCat(pSWFDE, bl);
        this.onFillEntityFullInfo_PSWF(pSWFDE, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isPSDEIdDirty()) {
            if (pSWFDE.getPSDEId() != null) {
                if (pSWFDE.getPSDEId() == null || pSWFDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSWFDE.getPSDE();
                    pSWFDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSWFDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_FinishPSDEAction(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_InitPSDEAction(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ProxyDataPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isProxyDataPSDEFIdDirty()) {
            if (pSWFDE.getProxyDataPSDEFId() != null) {
                if (pSWFDE.getProxyDataPSDEFId() == null || pSWFDE.getProxyDataPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getProxyDataPSDEF();
                    pSWFDE.setProxyDataPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setProxyDataPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ProxyModulePSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isProxyModulePSDEFIdDirty()) {
            if (pSWFDE.getProxyModulePSDEFId() != null) {
                if (pSWFDE.getProxyModulePSDEFId() == null || pSWFDE.getProxyModulePSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getProxyModulePSDEF();
                    pSWFDE.setProxyModulePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setProxyModulePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ProxyWFPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isProxyWFPSDEFIdDirty()) {
            if (pSWFDE.getProxyWFPSDEFId() != null) {
                if (pSWFDE.getProxyWFPSDEFId() == null || pSWFDE.getProxyWFPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getProxyWFPSDEF();
                    pSWFDE.setProxyWFPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setProxyWFPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PWFInstPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isPWFInstPSDEFIdDirty()) {
            if (pSWFDE.getPWFInstPSDEFId() != null) {
                if (pSWFDE.getPWFInstPSDEFId() == null || pSWFDE.getPWFInstPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getPWFInstPSDEF();
                    pSWFDE.setPWFInstPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setPWFInstPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_StatePSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isStatePSDEFIdDirty()) {
            if (pSWFDE.getStatePSDEFId() != null) {
                if (pSWFDE.getStatePSDEFId() == null || pSWFDE.getStatePSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getStatePSDEF();
                    pSWFDE.setStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFActorPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFActorPSDEFIdDirty()) {
            if (pSWFDE.getWFActorPSDEFId() != null) {
                if (pSWFDE.getWFActorPSDEFId() == null || pSWFDE.getWFActorPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFActorPSDEF();
                    pSWFDE.setWFActorPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFActorPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFIdPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFIdPSDEFIdDirty()) {
            if (pSWFDE.getWFIdPSDEFId() != null) {
                if (pSWFDE.getWFIdPSDEFId() == null || pSWFDE.getWFIdPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFIdPSDEF();
                    pSWFDE.setWFIdPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFIdPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFInstPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFInstPSDEFIdDirty()) {
            if (pSWFDE.getWFInstPSDEFId() != null) {
                if (pSWFDE.getWFInstPSDEFId() == null || pSWFDE.getWFInstPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFInstPSDEF();
                    pSWFDE.setWFInstPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFInstPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFRetPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFRetPSDEFIdDirty()) {
            if (pSWFDE.getWFRetPSDEFId() != null) {
                if (pSWFDE.getWFRetPSDEFId() == null || pSWFDE.getWFRetPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFRetPSDEF();
                    pSWFDE.setWFRetPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFRetPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFStatePSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFStatePSDEFIdDirty()) {
            if (pSWFDE.getWFStatePSDEFId() != null) {
                if (pSWFDE.getWFStatePSDEFId() == null || pSWFDE.getWFStatePSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFStatePSDEF();
                    pSWFDE.setWFStatePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFStatePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFStepPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFStepPSDEFIdDirty()) {
            if (pSWFDE.getWFStepPSDEFId() != null) {
                if (pSWFDE.getWFStepPSDEFId() == null || pSWFDE.getWFStepPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFStepPSDEF();
                    pSWFDE.setWFStepPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFStepPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFVerPSDEF(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isWFVerPSDEFIdDirty()) {
            if (pSWFDE.getWFVerPSDEFId() != null) {
                if (pSWFDE.getWFVerPSDEFId() == null || pSWFDE.getWFVerPSDEFName() == null) {
                    PSDEField pSDEField = pSWFDE.getWFVerPSDEF();
                    pSWFDE.setWFVerPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSWFDE.setWFVerPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ActionMobPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ActionPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobProxyData2PSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobProxyDataPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ProxyData2PSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ProxyDataPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_StartMobPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_StartPSDEView(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MyWFDataPSLanRes(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isMyWFDataPSLanResIdDirty()) {
            if (pSWFDE.getMyWFDataPSLanResId() != null) {
                if (pSWFDE.getMyWFDataPSLanResId() == null || pSWFDE.getMyWFDataPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWFDE.getMyWFDataPSLanRes();
                    pSWFDE.setMyWFDataPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWFDE.setMyWFDataPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MyWFWorkPSLanRes(PSWFDE pSWFDE, boolean bl) throws Exception {
        if (pSWFDE.isMyWFWorkPSLanResIdDirty()) {
            if (pSWFDE.getMyWFWorkPSLanResId() != null) {
                if (pSWFDE.getMyWFWorkPSLanResId() == null || pSWFDE.getMyWFWorkPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSWFDE.getMyWFWorkPSLanRes();
                    pSWFDE.setMyWFWorkPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSWFDE.setMyWFWorkPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysWFCat(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSWFDE pSWFDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWFDE pSWFDE, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFDE, bl);
    }

    public ArrayList<PSWFDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFDE> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByFinishPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByFinishPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FINISHPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFinishPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFinishPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByInitPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INITPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInitPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInitPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByProxyDataPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByProxyDataPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYDATAPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyDataPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyDataPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByProxyModulePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByProxyModulePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByProxyModulePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByProxyModulePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByProxyModulePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYMODULEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyModulePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyModulePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByProxyWFPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByProxyWFPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByProxyWFPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByProxyWFPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByProxyWFPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYWFPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyWFPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyWFPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByPWFInstPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPWFInstPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByPWFInstPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPWFInstPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByPWFInstPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PWFINSTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPWFInstPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPWFInstPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFActorPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFActorPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFActorPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFActorPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFActorPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFACTORPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFActorPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFActorPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFIdPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFIdPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFIdPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFIdPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFIdPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFIDPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFIdPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFIdPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFInstPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFInstPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFInstPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFInstPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFInstPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFINSTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFInstPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFInstPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFRetPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFRetPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFRetPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFRetPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFRetPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFRETPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFRetPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFRetPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFStatePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFStatePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFStatePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFStatePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFStatePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTATEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFStatePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFStatePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFStepPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFStepPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFStepPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFStepPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFStepPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFStepPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFStepPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByWFVerPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByWFVerPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByWFVerPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByWFVerPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByWFVerPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFVERPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFVerPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFVerPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByActionMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByActionMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByActionMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACTIONMOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByActionMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByActionMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByActionPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByActionPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByActionPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ACTIONPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByActionPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByActionPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByMobProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobProxyData2PSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByMobProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobProxyData2PSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByMobProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPROXYDATA2PSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobProxyData2PSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobProxyData2PSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByMobProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobProxyDataPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByMobProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobProxyDataPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByMobProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPROXYDATAPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobProxyDataPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobProxyDataPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByProxyData2PSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByProxyData2PSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByProxyData2PSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYDATA2PSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyData2PSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyData2PSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByProxyDataPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByProxyDataPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByProxyDataPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYDATAPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyDataPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyDataPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByStartMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByStartMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByStartMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STARTMOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStartMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStartMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByStartPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByStartPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByStartPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("STARTPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByStartPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByStartPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByMyWFDataPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByMyWFDataPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByMyWFDataPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByMyWFDataPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByMyWFDataPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MYWFDATAPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMyWFDataPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMyWFDataPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByMyWFWorkPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByMyWFWorkPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByMyWFWorkPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByMyWFWorkPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByMyWFWorkPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MYWFWORKPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMyWFWorkPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMyWFWorkPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFDE> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase) throws Exception {
        return this.selectByPSSysWFCat(pSSysWFCatBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase, String string) throws Exception {
        return this.selectByPSSysWFCat(pSSysWFCatBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByPSSysWFCat(PSSysWFCatBase pSSysWFCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSWFCATID", (Object)pSSysWFCatBase.getPSSysWFCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysWFCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysWFCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFDE> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFDE> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFDE> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setPSDEId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSWFDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSWFDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByFinishPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEACTION_FINISHPSDEACTIONID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setFinishPSDEActionId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByFinishPSDEAction(pSDEAction2);
                PSWFDEServiceBase.this.internalRemoveByFinishPSDEAction(pSDEAction2);
                PSWFDEServiceBase.this.onAfterRemoveByFinishPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByFinishPSDEAction(pSDEAction);
        this.onBeforeRemoveByFinishPSDEAction(pSDEAction, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByFinishPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFinishPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByInitPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEACTION_INITPSDEACTIONID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByInitPSDEAction(pSDEAction);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setInitPSDEActionId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByInitPSDEAction(pSDEAction2);
                PSWFDEServiceBase.this.internalRemoveByInitPSDEAction(pSDEAction2);
                PSWFDEServiceBase.this.onAfterRemoveByInitPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByInitPSDEAction(pSDEAction);
        this.onBeforeRemoveByInitPSDEAction(pSDEAction, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByInitPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByProxyDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_PROXYDATAPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetProxyDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setProxyDataPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByProxyDataPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByProxyDataPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByProxyDataPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByProxyDataPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByProxyDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByProxyDataPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEF(pSDEField);
        this.onBeforeRemoveByProxyDataPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByProxyDataPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByProxyDataPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByProxyDataPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyDataPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByProxyModulePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyModulePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_PROXYMODULEPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetProxyModulePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyModulePSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setProxyModulePSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByProxyModulePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByProxyModulePSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByProxyModulePSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByProxyModulePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByProxyModulePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByProxyModulePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyModulePSDEF(pSDEField);
        this.onBeforeRemoveByProxyModulePSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByProxyModulePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByProxyModulePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByProxyModulePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyModulePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByProxyWFPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyWFPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_PROXYWFPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetProxyWFPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyWFPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setProxyWFPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByProxyWFPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByProxyWFPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByProxyWFPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByProxyWFPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByProxyWFPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByProxyWFPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyWFPSDEF(pSDEField);
        this.onBeforeRemoveByProxyWFPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByProxyWFPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByProxyWFPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByProxyWFPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyWFPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByPWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPWFInstPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_PWFINSTPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPWFInstPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setPWFInstPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByPWFInstPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByPWFInstPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByPWFInstPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByPWFInstPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPWFInstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPWFInstPSDEF(pSDEField);
        this.onBeforeRemoveByPWFInstPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByPWFInstPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPWFInstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPWFInstPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPWFInstPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_STATEPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStatePSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setStatePSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByStatePSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByStatePSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStatePSDEF(pSDEField);
        this.onBeforeRemoveByStatePSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStatePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFActorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFActorPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFACTORPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFActorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFActorPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFActorPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFActorPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFActorPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFActorPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFActorPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFActorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFActorPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFActorPSDEF(pSDEField);
        this.onBeforeRemoveByWFActorPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFActorPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFActorPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFActorPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFActorPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFIdPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFIDPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFIdPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFIdPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFIdPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFIdPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFIdPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFIdPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFIdPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFIdPSDEF(pSDEField);
        this.onBeforeRemoveByWFIdPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFIdPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFIdPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFIdPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFIdPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFInstPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFINSTPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFInstPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFInstPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFInstPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFInstPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFInstPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFInstPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFInstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFInstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFInstPSDEF(pSDEField);
        this.onBeforeRemoveByWFInstPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFInstPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFInstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFInstPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFInstPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFRetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFRetPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFRETPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFRetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFRetPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFRetPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFRetPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFRetPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFRetPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFRetPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFRetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFRetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFRetPSDEF(pSDEField);
        this.onBeforeRemoveByWFRetPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFRetPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFRetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFRetPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFRetPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStatePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFSTATEPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStatePSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFStatePSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFStatePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFStatePSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFStatePSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFStatePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFStatePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStatePSDEF(pSDEField);
        this.onBeforeRemoveByWFStatePSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFStatePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFStatePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFStatePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFStatePSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFStepPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStepPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFSTEPPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFStepPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStepPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFStepPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFStepPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFStepPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFStepPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFStepPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFStepPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFStepPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFStepPSDEF(pSDEField);
        this.onBeforeRemoveByWFStepPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFStepPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFStepPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFStepPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFStepPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByWFVerPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFVerPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEFIELD_WFVERPSDEFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetWFVerPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFVerPSDEF(pSDEField);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setWFVerPSDEFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByWFVerPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByWFVerPSDEF(pSDEField2);
                PSWFDEServiceBase.this.internalRemoveByWFVerPSDEF(pSDEField2);
                PSWFDEServiceBase.this.onAfterRemoveByWFVerPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByWFVerPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByWFVerPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByWFVerPSDEF(pSDEField);
        this.onBeforeRemoveByWFVerPSDEF(pSDEField, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByWFVerPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByWFVerPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByWFVerPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFVerPSDEF(PSDEField pSDEField, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_ACTIONMOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionMobPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setActionMobPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByActionMobPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByActionMobPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByActionMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByActionMobPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByActionMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByActionMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_ACTIONPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setActionPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByActionPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByActionPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByActionPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByActionPSDEView(pSDEViewBase);
        this.onBeforeRemoveByActionPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByActionPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByActionPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByActionPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByActionPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyData2PSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_MOBPROXYDATA2PSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyData2PSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setMobProxyData2PSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByMobProxyData2PSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByMobProxyData2PSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByMobProxyData2PSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyData2PSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobProxyData2PSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByMobProxyData2PSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobProxyData2PSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyDataPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_MOBPROXYDATAPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyDataPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setMobProxyDataPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByMobProxyDataPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByMobProxyDataPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByMobProxyDataPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMobProxyDataPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobProxyDataPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByMobProxyDataPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobProxyDataPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyData2PSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_PROXYDATA2PSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyData2PSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setProxyData2PSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByProxyData2PSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByProxyData2PSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByProxyData2PSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyData2PSDEView(pSDEViewBase);
        this.onBeforeRemoveByProxyData2PSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByProxyData2PSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyData2PSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_PROXYDATAPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setProxyDataPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByProxyDataPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByProxyDataPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByProxyDataPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByProxyDataPSDEView(pSDEViewBase);
        this.onBeforeRemoveByProxyDataPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByProxyDataPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyDataPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_STARTMOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartMobPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setStartMobPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByStartMobPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByStartMobPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByStartMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByStartMobPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByStartMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStartMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSDEVIEWBASE_STARTPSDEVIEWID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartPSDEView(pSDEViewBase);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setStartPSDEViewId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByStartPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.internalRemoveByStartPSDEView(pSDEViewBase2);
                PSWFDEServiceBase.this.onAfterRemoveByStartPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByStartPSDEView(pSDEViewBase);
        this.onBeforeRemoveByStartPSDEView(pSDEViewBase, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByStartPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByStartPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByStartPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByStartPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFDataPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSLANGUAGERES_MYWFDATAPSLANRESID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFDataPSLanRes(pSLanguageRes);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setMyWFDataPSLanResId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByMyWFDataPSLanRes(pSLanguageRes2);
                PSWFDEServiceBase.this.internalRemoveByMyWFDataPSLanRes(pSLanguageRes2);
                PSWFDEServiceBase.this.onAfterRemoveByMyWFDataPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFDataPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByMyWFDataPSLanRes(pSLanguageRes, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByMyWFDataPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMyWFDataPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFWorkPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSLANGUAGERES_MYWFWORKPSLANRESID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFWorkPSLanRes(pSLanguageRes);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setMyWFWorkPSLanResId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByMyWFWorkPSLanRes(pSLanguageRes2);
                PSWFDEServiceBase.this.internalRemoveByMyWFWorkPSLanRes(pSLanguageRes2);
                PSWFDEServiceBase.this.onAfterRemoveByMyWFWorkPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByMyWFWorkPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByMyWFWorkPSLanRes(pSLanguageRes, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByMyWFWorkPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMyWFWorkPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setPSSysSFPluginId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWFDEServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSWFDEServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysWFCat(pSSysWFCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSWFCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysWFCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSSYSWFCAT_PSSYSWFCATID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSSysWFCat), arrayList.get(0)));
        }
    }

    public void resetPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysWFCat(pSSysWFCat);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setPSSysWFCatId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        final PSSysWFCat pSSysWFCat2 = pSSysWFCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByPSSysWFCat(pSSysWFCat2);
                PSWFDEServiceBase.this.internalRemoveByPSSysWFCat(pSSysWFCat2);
                PSWFDEServiceBase.this.onAfterRemoveByPSSysWFCat(pSSysWFCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
    }

    protected void internalRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSSysWFCat(pSSysWFCat);
        this.onBeforeRemoveByPSSysWFCat(pSSysWFCat, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByPSSysWFCat(pSSysWFCat, arrayList);
    }

    protected void onAfterRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysWFCat(PSSysWFCat pSSysWFCat, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFDE_PSWORKFLOW_PSWFID", "", iDataEntityModel.getName(), "PSWFDE", iDataEntityModel.getDataInfo(pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSWFDE pSWFDE : arrayList) {
            PSWFDE pSWFDE2 = (PSWFDE)this.getDEModel().createEntity();
            pSWFDE2.setPSWFDEId(pSWFDE.getPSWFDEId());
            pSWFDE2.setPSWFId(null);
            this.update(pSWFDE2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFDEServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSWFDEServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSWFDEServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFDE> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSWFDE pSWFDE : arrayList) {
            this.remove(pSWFDE);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFDE pSWFDE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataRelationServiceBase)pSCoreSysServiceBase).testRemoveByPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSWF(pSWFDE);
        pSCoreSysServiceBase = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSWFDE(pSWFDE);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSWFDE(pSWFDE);
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).removeByPSWFDE(pSWFDE);
        super.onBeforeRemove(pSWFDE);
    }

    protected void replaceParentInfo(PSWFDE pSWFDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFDE, cloneSession);
        if (pSWFDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSWFDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSWFDE, (PSDataEntity)iEntity);
        }
        if (pSWFDE.getFinishPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSWFDE.getFinishPSDEActionId())) != null) {
            this.onFillParentInfo_FinishPSDEAction(pSWFDE, (PSDEAction)iEntity);
        }
        if (pSWFDE.getInitPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSWFDE.getInitPSDEActionId())) != null) {
            this.onFillParentInfo_InitPSDEAction(pSWFDE, (PSDEAction)iEntity);
        }
        if (pSWFDE.getProxyDataPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getProxyDataPSDEFId())) != null) {
            this.onFillParentInfo_ProxyDataPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getProxyModulePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getProxyModulePSDEFId())) != null) {
            this.onFillParentInfo_ProxyModulePSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getProxyWFPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getProxyWFPSDEFId())) != null) {
            this.onFillParentInfo_ProxyWFPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getPWFInstPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getPWFInstPSDEFId())) != null) {
            this.onFillParentInfo_PWFInstPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getStatePSDEFId())) != null) {
            this.onFillParentInfo_StatePSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFActorPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFActorPSDEFId())) != null) {
            this.onFillParentInfo_WFActorPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFIdPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFIdPSDEFId())) != null) {
            this.onFillParentInfo_WFIdPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFInstPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFInstPSDEFId())) != null) {
            this.onFillParentInfo_WFInstPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFRetPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFRetPSDEFId())) != null) {
            this.onFillParentInfo_WFRetPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFStatePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFStatePSDEFId())) != null) {
            this.onFillParentInfo_WFStatePSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFStepPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFStepPSDEFId())) != null) {
            this.onFillParentInfo_WFStepPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getWFVerPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSWFDE.getWFVerPSDEFId())) != null) {
            this.onFillParentInfo_WFVerPSDEF(pSWFDE, (PSDEField)iEntity);
        }
        if (pSWFDE.getActionMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getActionMobPSDEViewId())) != null) {
            this.onFillParentInfo_ActionMobPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getActionPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getActionPSDEViewId())) != null) {
            this.onFillParentInfo_ActionPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getMobProxyData2PSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getMobProxyData2PSDEViewId())) != null) {
            this.onFillParentInfo_MobProxyData2PSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getMobProxyDataPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getMobProxyDataPSDEViewId())) != null) {
            this.onFillParentInfo_MobProxyDataPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getProxyData2PSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getProxyData2PSDEViewId())) != null) {
            this.onFillParentInfo_ProxyData2PSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getProxyDataPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getProxyDataPSDEViewId())) != null) {
            this.onFillParentInfo_ProxyDataPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getStartMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getStartMobPSDEViewId())) != null) {
            this.onFillParentInfo_StartMobPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getStartPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSWFDE.getStartPSDEViewId())) != null) {
            this.onFillParentInfo_StartPSDEView(pSWFDE, (PSDEViewBase)iEntity);
        }
        if (pSWFDE.getMyWFDataPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWFDE.getMyWFDataPSLanResId())) != null) {
            this.onFillParentInfo_MyWFDataPSLanRes(pSWFDE, (PSLanguageRes)iEntity);
        }
        if (pSWFDE.getMyWFWorkPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSWFDE.getMyWFWorkPSLanResId())) != null) {
            this.onFillParentInfo_MyWFWorkPSLanRes(pSWFDE, (PSLanguageRes)iEntity);
        }
        if (pSWFDE.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSWFDE.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSWFDE, (PSSysSFPlugin)iEntity);
        }
        if (pSWFDE.getPSSysWFCatId() != null && (iEntity = cloneSession.getEntity("PSSYSWFCAT", (Object)pSWFDE.getPSSysWFCatId())) != null) {
            this.onFillParentInfo_PSSysWFCat(pSWFDE, (PSSysWFCat)iEntity);
        }
        if (pSWFDE.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFDE.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSWFDE, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFDE pSWFDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionMobPSDEViewId(bl, pSWFDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionPSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditableWFStep(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditViewUri(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtCntStates(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FinishPSDEActionId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPSDEActionId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobEditViewUri(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobProxyData2PSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobProxyDataPSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFData(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFDataPSLanResId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFDataPSLanResName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFWork(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFWorkPSLanResId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MyWFWorkPSLanResName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyData2PSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyDataPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyDataPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyDataPSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyModulePSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyModulePSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyWFPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyWFPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBasesCnt(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFCatId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFDEName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PWFInstPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PWFInstPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartMobPSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartPSDEViewId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StatePSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserStart(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFActorPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFActorPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFIdPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFIdPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFInstPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFInstPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFMode(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFProxyMode(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFRetPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFRetPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStatePSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStatePSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVerPSDEFId(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVerPSDEFName(bl, pSWFDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionMobPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isActionMobPSDEViewIdDirty() : !pSWFDE.isActionMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getActionMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionMobPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONMOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isActionPSDEViewIdDirty() : !pSWFDE.isActionPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getActionPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isCodeNameDirty() && !bl2 : !pSWFDE.isCodeNameDirty()) {
            return null;
        }
        String string = pSWFDE.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSWFDEDEModel(), "CODENAME", string3, pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isCustomCodeDirty() : !pSWFDE.isCustomCodeDirty()) {
            return null;
        }
        String string = pSWFDE.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isCustomModeDirty() : !pSWFDE.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSWFDE.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isDefaultModeDirty() : !pSWFDE.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSWFDE.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSWFDEDEModel(), "DEFAULTMODE", string, pSWFDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isDynaModelFlagDirty() : !pSWFDE.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFDE.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditableWFStep(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isEditableWFStepDirty() : !pSWFDE.isEditableWFStepDirty()) {
            return null;
        }
        String string = pSWFDE.getEditableWFStep();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditableWFStep_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITABLEWFSTEP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditViewUri(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isEditViewUriDirty() : !pSWFDE.isEditViewUriDirty()) {
            return null;
        }
        String string = pSWFDE.getEditViewUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditViewUri_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITVIEWURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isEnableDirty() && !bl2 : !pSWFDE.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFDE.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtCntStates(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isExtCntStatesDirty() : !pSWFDE.isExtCntStatesDirty()) {
            return null;
        }
        String string = pSWFDE.getExtCntStates();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExtCntStates_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTCNTSTATES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FinishPSDEActionId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isFinishPSDEActionIdDirty() : !pSWFDE.isFinishPSDEActionIdDirty()) {
            return null;
        }
        String string = pSWFDE.getFinishPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FinishPSDEActionId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINISHPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitPSDEActionId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isInitPSDEActionIdDirty() : !pSWFDE.isInitPSDEActionIdDirty()) {
            return null;
        }
        String string = pSWFDE.getInitPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitPSDEActionId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isLockFlagDirty() : !pSWFDE.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSWFDE.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMemoDirty() : !pSWFDE.isMemoDirty()) {
            return null;
        }
        String string = pSWFDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobEditViewUri(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMobEditViewUriDirty() : !pSWFDE.isMobEditViewUriDirty()) {
            return null;
        }
        String string = pSWFDE.getMobEditViewUri();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobEditViewUri_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBEDITVIEWURI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobProxyData2PSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMobProxyData2PSDEViewIdDirty() : !pSWFDE.isMobProxyData2PSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getMobProxyData2PSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobProxyData2PSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPROXYDATA2PSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobProxyDataPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMobProxyDataPSDEViewIdDirty() : !pSWFDE.isMobProxyDataPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getMobProxyDataPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobProxyDataPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPROXYDATAPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFData(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFDataDirty() : !pSWFDE.isMyWFDataDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFData_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFDataPSLanResId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFDataPSLanResIdDirty() : !pSWFDE.isMyWFDataPSLanResIdDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFDataPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFDataPSLanResId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFDATAPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFDataPSLanResName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFDataPSLanResNameDirty() : !pSWFDE.isMyWFDataPSLanResNameDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFDataPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFDataPSLanResName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFDATAPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFWork(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFWorkDirty() : !pSWFDE.isMyWFWorkDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFWork();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFWork_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFWORK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFWorkPSLanResId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFWorkPSLanResIdDirty() : !pSWFDE.isMyWFWorkPSLanResIdDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFWorkPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFWorkPSLanResId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFWORKPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MyWFWorkPSLanResName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isMyWFWorkPSLanResNameDirty() : !pSWFDE.isMyWFWorkPSLanResNameDirty()) {
            return null;
        }
        String string = pSWFDE.getMyWFWorkPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MyWFWorkPSLanResName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYWFWORKPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyData2PSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyData2PSDEViewIdDirty() : !pSWFDE.isProxyData2PSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyData2PSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyData2PSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYDATA2PSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyDataPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyDataPSDEFIdDirty() : !pSWFDE.isProxyDataPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyDataPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyDataPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYDATAPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyDataPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyDataPSDEFNameDirty() : !pSWFDE.isProxyDataPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyDataPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyDataPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYDATAPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyDataPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyDataPSDEViewIdDirty() : !pSWFDE.isProxyDataPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyDataPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyDataPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYDATAPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyModulePSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyModulePSDEFIdDirty() : !pSWFDE.isProxyModulePSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyModulePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyModulePSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYMODULEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyModulePSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyModulePSDEFNameDirty() : !pSWFDE.isProxyModulePSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyModulePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyModulePSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYMODULEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyWFPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyWFPSDEFIdDirty() : !pSWFDE.isProxyWFPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyWFPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyWFPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYWFPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyWFPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isProxyWFPSDEFNameDirty() : !pSWFDE.isProxyWFPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getProxyWFPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyWFPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYWFPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSDEIdDirty() && !bl2 : !pSWFDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSWFDE, bl2, bl3);
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
                string3 = "PSWFID";
                String string4 = this.checkFieldDupRule(this.getPSWFDEDEModel(), "PSDEID", string3, pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSDENameDirty() && !bl2 : !pSWFDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSWFDE.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBasesCnt(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSDEViewBasesCntDirty() : !pSWFDE.isPSDEViewBasesCntDirty()) {
            return null;
        }
        Integer n = pSWFDE.getPSDEViewBasesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEViewBasesCnt_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSDynaInstIdDirty() : !pSWFDE.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSSysSFPluginIdDirty() : !pSWFDE.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSSystemIdDirty() : !pSWFDE.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysWFCatId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSSysWFCatIdDirty() : !pSWFDE.isPSSysWFCatIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSSysWFCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFCatId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSWFDEIdDirty() && !bl2 : !pSWFDE.isPSWFDEIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSWFDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFDEName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSWFDENameDirty() : !pSWFDE.isPSWFDENameDirty()) {
            return null;
        }
        String string = pSWFDE.getPSWFDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFDEName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPSWFIdDirty() : !pSWFDE.isPSWFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PWFInstPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPWFInstPSDEFIdDirty() : !pSWFDE.isPWFInstPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getPWFInstPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PWFInstPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PWFINSTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PWFInstPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isPWFInstPSDEFNameDirty() : !pSWFDE.isPWFInstPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getPWFInstPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PWFInstPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PWFINSTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartMobPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isStartMobPSDEViewIdDirty() : !pSWFDE.isStartMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getStartMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartMobPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTMOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartPSDEViewId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isStartPSDEViewIdDirty() : !pSWFDE.isStartPSDEViewIdDirty()) {
            return null;
        }
        String string = pSWFDE.getStartPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartPSDEViewId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isStatePSDEFIdDirty() && !bl2 : !pSWFDE.isStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getStatePSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StatePSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isStatePSDEFNameDirty() && !bl2 : !pSWFDE.isStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getStatePSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StatePSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserCatDirty() : !pSWFDE.isUserCatDirty()) {
            return null;
        }
        String string = pSWFDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserStart(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserStartDirty() : !pSWFDE.isUserStartDirty()) {
            return null;
        }
        Integer n = pSWFDE.getUserStart();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserStart_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERSTART");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserTagDirty() : !pSWFDE.isUserTagDirty()) {
            return null;
        }
        String string = pSWFDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserTag2Dirty() : !pSWFDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserTag3Dirty() : !pSWFDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isUserTag4Dirty() : !pSWFDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isValidFlagDirty() && !bl2 : !pSWFDE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWFDE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSWFDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_WFActorPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFActorPSDEFIdDirty() : !pSWFDE.isWFActorPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFActorPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFActorPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFACTORPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFActorPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFActorPSDEFNameDirty() : !pSWFDE.isWFActorPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFActorPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFActorPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFACTORPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFIdPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFIdPSDEFIdDirty() : !pSWFDE.isWFIdPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFIdPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFIdPSDEFId_WFIdPSDEF(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_WFIdPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIDPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFIdPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFIdPSDEFNameDirty() : !pSWFDE.isWFIdPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFIdPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFIdPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFIDPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFInstPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFInstPSDEFIdDirty() : !pSWFDE.isWFInstPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFInstPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFInstPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFInstPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFInstPSDEFNameDirty() : !pSWFDE.isWFInstPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFInstPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFInstPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFMode(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFModeDirty() : !pSWFDE.isWFModeDirty()) {
            return null;
        }
        String string = pSWFDE.getWFMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFMode_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFProxyMode(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFProxyModeDirty() : !pSWFDE.isWFProxyModeDirty()) {
            return null;
        }
        Integer n = pSWFDE.getWFProxyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFProxyMode_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFPROXYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFRetPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFRetPSDEFIdDirty() : !pSWFDE.isWFRetPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFRetPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFRetPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFRETPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFRetPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFRetPSDEFNameDirty() : !pSWFDE.isWFRetPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFRetPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFRetPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFRETPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStatePSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFStatePSDEFIdDirty() : !pSWFDE.isWFStatePSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFStatePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStatePSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTATEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStatePSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFStatePSDEFNameDirty() : !pSWFDE.isWFStatePSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFStatePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStatePSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTATEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFStepPSDEFIdDirty() : !pSWFDE.isWFStepPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFStepPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFStepPSDEFNameDirty() : !pSWFDE.isWFStepPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFStepPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFVerPSDEFId(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFVerPSDEFIdDirty() : !pSWFDE.isWFVerPSDEFIdDirty()) {
            return null;
        }
        String string = pSWFDE.getWFVerPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFVerPSDEFId_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFVerPSDEFName(boolean bl, PSWFDE pSWFDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFDE.isWFVerPSDEFNameDirty() : !pSWFDE.isWFVerPSDEFNameDirty()) {
            return null;
        }
        String string = pSWFDE.getWFVerPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFVerPSDEFName_Default(pSWFDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFDE pSWFDE, boolean bl) throws Exception {
        super.onSyncEntity(pSWFDE, bl);
    }

    protected void onSyncIndexEntities(PSWFDE pSWFDE, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFDE, bl);
    }

    public Object getDataContextValue(PSWFDE pSWFDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSWFDE.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSWorkflow pSWorkflow = pSWFDE.getPSWF();
        if (pSWorkflow != null && pSWorkflow.contains(string)) {
            return pSWorkflow.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWFDE pSWFDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_MyWFDataPSLanRes(pSWFDE, arrayList, n);
        this.onExportMajorModel_MyWFWorkPSLanRes(pSWFDE, arrayList, n);
        super.onExportMajorModel(pSWFDE, arrayList, n);
    }

    protected void onExportMajorModel_MyWFDataPSLanRes(PSWFDE pSWFDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWFDE.getMyWFDataPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSWFDE.getMyWFDataPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_MyWFWorkPSLanRes(PSWFDE pSWFDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSWFDE.getMyWFWorkPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSWFDE.getMyWFWorkPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONMOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionMobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONMOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionMobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionPSDEViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITABLEWFSTEP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditableWFStep_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITVIEWURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditViewUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTCNTSTATES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtCntStates_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINISHPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FinishPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBEDITVIEWURI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobEditViewUri_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPROXYDATA2PSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobProxyData2PSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPROXYDATA2PSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobProxyData2PSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPROXYDATAPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobProxyDataPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPROXYDATAPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobProxyDataPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFDATAPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFDataPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFDATAPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFDataPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFWORK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFWork_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFWORKPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFWorkPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYWFWORKPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MyWFWorkPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATA2PSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyData2PSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATA2PSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyData2PSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATAPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyDataPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATAPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyDataPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATAPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyDataPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYDATAPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyDataPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYMODULEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyModulePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYMODULEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyModulePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYWFPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyWFPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYWFPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyWFPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBasesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PWFINSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PWFInstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PWFINSTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PWFInstPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTMOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartMobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTMOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartMobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StatePSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERSTART", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserStart_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WFACTORPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFActorPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFACTORPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFActorPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFCATCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFCatCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"WFIDPSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_WFIdPSDEFId_WFIdPSDEF(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFIDPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFIdPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFIDPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFIdPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFINSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFInstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFINSTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFInstPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFPROXYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFProxyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFRETPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFRetPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFRETPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFRetPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTATEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStatePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTATEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStatePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVERPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFVerPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVERPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFVerPSDEFName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionMobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONMOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionMobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONMOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ActionPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditableWFStep_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITABLEWFSTEP", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditViewUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITVIEWURI", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtCntStates_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTCNTSTATES", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FinishPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FINISHPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MobEditViewUri_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBEDITVIEWURI", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobProxyData2PSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPROXYDATA2PSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobProxyData2PSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPROXYDATA2PSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobProxyDataPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPROXYDATAPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobProxyDataPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPROXYDATAPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFDataPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFDATAPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFDataPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFDATAPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFWork_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFWORK", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFWorkPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFWORKPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MyWFWorkPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYWFWORKPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyData2PSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATA2PSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyData2PSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATA2PSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyDataPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATAPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyDataPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATAPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyDataPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATAPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyDataPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYDATAPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyModulePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYMODULEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyModulePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYMODULEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyWFPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYWFPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyWFPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYWFPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEViewBasesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysWFCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PWFInstPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PWFINSTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PWFInstPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PWFINSTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartMobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTMOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartMobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTMOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserStart_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_WFActorPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFACTORPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFActorPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFACTORPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFCatCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFCATCODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFIdPSDEFId_WFIdPSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("WFIDPSDEFID", "PSDEFIELD", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6d41\u7a0b\u6807\u8bc6\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFIdPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFIDPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFIdPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFIDPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFInstPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFINSTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFInstPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFINSTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFProxyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFRetPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFRETPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFRetPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFRETPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStatePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTATEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStatePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTATEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFVerPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVERPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFVerPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVERPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFDE pSWFDE) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID", (boolean)true) == 0) && this.onMergeChild_PSDEViewBases(pSWFDE)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, pSWFDE)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDEViewBases(PSWFDE pSWFDE) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEVIEWBASESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWFDE.getPSWFDEId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWFDEID", (Object)pSWFDE.getPSWFDEId());
        ArrayList<IEntity> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWFDE, false);
        return true;
    }

    protected void onUpdateParent(PSWFDE pSWFDE) throws Exception {
        IService iService;
        Object object = pSWFDE.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWFDE_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSWFDE.get("PSWFID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWFDE_PSWORKFLOW_PSWFID", object);
        }
        super.onUpdateParent(pSWFDE);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSWFDE pSWFDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFDE");
        if (!bl) {
            pSWFDE.setPSDEViewBasesCnt(null);
            super.exportCurXmlModel(pSWFDE, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFDE pSWFDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFDE, string);
        objectNode.remove("psdeviewbasescnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFDE_PSWORKFLOW_PSWFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFID"};
    }

    @Override
    public String getModelV2Tag(PSWFDE pSWFDE) {
        if (!StringHelper.isNullOrEmpty((String)pSWFDE.getPSDEName())) {
            return pSWFDE.getPSDEName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFDE.getCodeName())) {
            return pSWFDE.getCodeName();
        }
        return super.getModelV2Tag(pSWFDE);
    }

    @Override
    public boolean setModelV2Tag(PSWFDE pSWFDE, String string) {
        pSWFDE.setPSDEName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        map.put("PSWFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFDE pSWFDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFDE, true);
        pSWFDE.set("PSDENAME", string);
        if (this.select(pSWFDE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFDE, true);
        return super.getModelV2Entity(pSWFDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFDE pSWFDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFDE, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSWFDE pSWFDE, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "WF");
    }
}

