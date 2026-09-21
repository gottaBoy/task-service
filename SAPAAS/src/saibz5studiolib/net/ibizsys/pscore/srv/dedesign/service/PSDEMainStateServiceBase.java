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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMainStateDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMSOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateRSBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSFieldServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMainStateServiceBase
extends PSCoreSysServiceBase<PSDEMainState> {
    private static final Log log = LogFactory.getLog(PSDEMainStateServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDEMSVIEWS = "InitDEMSViews";
    private PSDEMainStateDEModel pSDEMainStateDEModel;
    private PSDEMainStateDAO pSDEMainStateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService";
    }

    public PSDEMainStateDEModel getPSDEMainStateDEModel() {
        if (this.pSDEMainStateDEModel == null) {
            try {
                this.pSDEMainStateDEModel = (PSDEMainStateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMainStateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMainStateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMainStateDEModel();
    }

    public PSDEMainStateDAO getPSDEMainStateDAO() {
        if (this.pSDEMainStateDAO == null) {
            try {
                this.pSDEMainStateDAO = (PSDEMainStateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMainStateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMainStateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMainStateDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDEMSVIEWS, (boolean)true) == 0) {
            this.initDEMSViews((PSDEMainState)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    public void initDEMSViews(PSDEMainState pSDEMainState) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDEMSVIEWS, 0, (IEntity)pSDEMainState, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEMainState, ACTION_INITDEMSVIEWS);
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEMainStateServiceBase.this.getService(), PSDEMainStateServiceBase.ACTION_INITDEMSVIEWS, 40, (IEntity)pSDEMainState2, null).getResult() != 1) {
                    PSDEMainStateServiceBase.this.onInitDEMSViews(pSDEMainState2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDEMSVIEWS, 99, (IEntity)pSDEMainState, null);
        }
    }

    protected void onInitDEMSViews(PSDEMainState pSDEMainState) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDEMSViews]");
    }

    protected void onFillParentInfo(PSDEMainState pSDEMainState, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEMainState, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEACTION_ENTERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_EnterPSDEAction(pSDEMainState, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEMainState, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_MOBPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_MobPSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_MOBQUICKPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_MobQuickPSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_MOBUTILPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_MobUtilPSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_QUICKPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_QuickPSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSDEFORM_UTILPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_UtilPSDEForm(pSDEMainState, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSLANGUAGERES_DEACTIONDMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_DEActionDMPSLanRes(pSDEMainState, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSLANGUAGERES_DEOPPRIVDMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_DEOPPrivDMPSLanRes(pSDEMainState, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSLANGUAGERES_TEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TextPSLanRes(pSDEMainState, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEMainState, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEMainState, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEMainState, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAINSTATE_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEMainState, pSSysImage);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEMainState, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEMainState pSDEMainState, PSDataEntity pSDataEntity) throws Exception {
        pSDEMainState.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEMainState.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_EnterPSDEAction(PSDEMainState pSDEMainState, PSDEAction pSDEAction) throws Exception {
        pSDEMainState.setEnterPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEMainState.setEnterPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDEMainState pSDEMainState, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEMainState.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEMainState.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_MobPSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setMobFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setMobPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setMobPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobQuickPSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setMobQuickFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setMobQuickPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setMobQuickPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_MobUtilPSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setMobUtilFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setMobUtilPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setMobUtilPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_QuickPSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setQuickFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setQuickPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setQuickPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_UtilPSDEForm(PSDEMainState pSDEMainState, PSDEForm pSDEForm) throws Exception {
        pSDEMainState.setUtilFormCodeName(pSDEForm.getCodeName());
        pSDEMainState.setUtilPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEMainState.setUtilPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_DEActionDMPSLanRes(PSDEMainState pSDEMainState, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEMainState.setDEActionDMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEMainState.setDEActionDMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_DEOPPrivDMPSLanRes(PSDEMainState pSDEMainState, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEMainState.setDEOPPrivDMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEMainState.setDEOPPrivDMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TextPSLanRes(PSDEMainState pSDEMainState, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEMainState.setTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEMainState.setTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEMainState pSDEMainState, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEMainState.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEMainState.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEMainState pSDEMainState, PSSysCss pSSysCss) throws Exception {
        pSDEMainState.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEMainState.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEMainState pSDEMainState, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEMainState.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEMainState.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEMainState pSDEMainState, PSSysImage pSSysImage) throws Exception {
        pSDEMainState.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEMainState.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillEntityFullInfo(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (bl) {
            if (pSDEMainState.getFieldAllowMode() == null) {
                pSDEMainState.setFieldAllowMode((String)this.getDefaultValue(this.getWebContext(), "", "DENY", 25));
            }
            if (pSDEMainState.getOPPrivAllowMode() == null) {
                pSDEMainState.setOPPrivAllowMode((String)this.getDefaultValue(this.getWebContext(), "", "DENY", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEMainState, bl);
        this.onFillEntityFullInfo_PSDE(pSDEMainState, bl);
        this.onFillEntityFullInfo_EnterPSDEAction(pSDEMainState, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEMainState, bl);
        this.onFillEntityFullInfo_MobPSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_MobQuickPSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_MobUtilPSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_QuickPSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_UtilPSDEForm(pSDEMainState, bl);
        this.onFillEntityFullInfo_DEActionDMPSLanRes(pSDEMainState, bl);
        this.onFillEntityFullInfo_DEOPPrivDMPSLanRes(pSDEMainState, bl);
        this.onFillEntityFullInfo_TextPSLanRes(pSDEMainState, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEMainState, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEMainState, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEMainState, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEMainState, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isPSDEIdDirty()) {
            if (pSDEMainState.getPSDEId() != null) {
                if (pSDEMainState.getPSDEId() == null || pSDEMainState.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEMainState.getPSDE();
                    pSDEMainState.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEMainState.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_EnterPSDEAction(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobQuickPSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobUtilPSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_QuickPSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UtilPSDEForm(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEActionDMPSLanRes(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isDEActionDMPSLanResIdDirty()) {
            if (pSDEMainState.getDEActionDMPSLanResId() != null) {
                if (pSDEMainState.getDEActionDMPSLanResId() == null || pSDEMainState.getDEActionDMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEMainState.getDEActionDMPSLanRes();
                    pSDEMainState.setDEActionDMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEMainState.setDEActionDMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DEOPPrivDMPSLanRes(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isDEOPPrivDMPSLanResIdDirty()) {
            if (pSDEMainState.getDEOPPrivDMPSLanResId() != null) {
                if (pSDEMainState.getDEOPPrivDMPSLanResId() == null || pSDEMainState.getDEOPPrivDMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEMainState.getDEOPPrivDMPSLanRes();
                    pSDEMainState.setDEOPPrivDMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEMainState.setDEOPPrivDMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TextPSLanRes(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isTextPSLanResIdDirty()) {
            if (pSDEMainState.getTextPSLanResId() != null) {
                if (pSDEMainState.getTextPSLanResId() == null || pSDEMainState.getTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEMainState.getTextPSLanRes();
                    pSDEMainState.setTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEMainState.setTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isTipPSLanResIdDirty()) {
            if (pSDEMainState.getTipPSLanResId() != null) {
                if (pSDEMainState.getTipPSLanResId() == null || pSDEMainState.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEMainState.getTipPSLanRes();
                    pSDEMainState.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEMainState.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        if (pSDEMainState.isPSSysCssIdDirty()) {
            if (pSDEMainState.getPSSysCssId() != null) {
                if (pSDEMainState.getPSSysCssId() == null || pSDEMainState.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSDEMainState.getPSSysCss();
                    pSDEMainState.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSDEMainState.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEMainState pSDEMainState, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEMainState, bl);
    }

    public ArrayList<PSDEMainState> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainState> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByEnterPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByEnterPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByEnterPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ENTERPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEnterPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEnterPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByMobPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByMobPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByMobQuickPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobQuickPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByMobQuickPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobQuickPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByMobQuickPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBQUICKPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobQuickPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobQuickPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMobUtilPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMobUtilPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByMobUtilPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBUTILPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobUtilPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobUtilPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainState> selectByQuickPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByQuickPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByQuickPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByQuickPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByQuickPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("QUICKPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByQuickPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByQuickPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByUtilPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByUtilPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByUtilPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UTILPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUtilPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUtilPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByDEActionDMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByDEActionDMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByDEActionDMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByDEActionDMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByDEActionDMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEACTIONDMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEActionDMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEActionDMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByDEOPPrivDMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByDEOPPrivDMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByDEOPPrivDMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByDEOPPrivDMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByDEOPPrivDMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEOPPRIVDMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEOPPrivDMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEOPPrivDMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMainState> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainState> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainState> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEMainState> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEMainState> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSDEId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEMainStateServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByEnterPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEACTION_ENTERPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByEnterPSDEAction(pSDEAction);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setEnterPSDEActionId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByEnterPSDEAction(pSDEAction2);
                PSDEMainStateServiceBase.this.internalRemoveByEnterPSDEAction(pSDEAction2);
                PSDEMainStateServiceBase.this.onAfterRemoveByEnterPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByEnterPSDEAction(pSDEAction);
        this.onBeforeRemoveByEnterPSDEAction(pSDEAction, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByEnterPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByEnterPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByEnterPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEnterPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSDEDQId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEMainStateServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_MOBPSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setMobPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByMobPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByMobPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByMobPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByMobPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobQuickPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_MOBQUICKPSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobQuickPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setMobQuickPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByMobQuickPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByMobQuickPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByMobQuickPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobQuickPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobQuickPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByMobQuickPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobQuickPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobQuickPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobUtilPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_MOBUTILPSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobUtilPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setMobUtilPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByMobUtilPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByMobUtilPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByMobUtilPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByMobUtilPSDEForm(pSDEForm);
        this.onBeforeRemoveByMobUtilPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByMobUtilPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMobUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMobUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByQuickPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_QUICKPSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByQuickPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setQuickPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByQuickPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByQuickPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByQuickPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByQuickPSDEForm(pSDEForm);
        this.onBeforeRemoveByQuickPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByQuickPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByQuickPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByQuickPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByQuickPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByUtilPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSDEFORM_UTILPSDEFORMID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByUtilPSDEForm(pSDEForm);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setUtilPSDEFormId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByUtilPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.internalRemoveByUtilPSDEForm(pSDEForm2);
                PSDEMainStateServiceBase.this.onAfterRemoveByUtilPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByUtilPSDEForm(pSDEForm);
        this.onBeforeRemoveByUtilPSDEForm(pSDEForm, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByUtilPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByUtilPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUtilPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEActionDMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSLANGUAGERES_DEACTIONDMPSLANRESID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEActionDMPSLanRes(pSLanguageRes);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setDEActionDMPSLanResId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByDEActionDMPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.internalRemoveByDEActionDMPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.onAfterRemoveByDEActionDMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEActionDMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByDEActionDMPSLanRes(pSLanguageRes, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByDEActionDMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEActionDMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEOPPrivDMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSLANGUAGERES_DEOPPRIVDMPSLANRESID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEOPPrivDMPSLanRes(pSLanguageRes);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setDEOPPrivDMPSLanResId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByDEOPPrivDMPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.internalRemoveByDEOPPrivDMPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.onAfterRemoveByDEOPPrivDMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByDEOPPrivDMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByDEOPPrivDMPSLanRes(pSLanguageRes, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByDEOPPrivDMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEOPPrivDMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSLANGUAGERES_TEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTextPSLanRes(pSLanguageRes);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setTextPSLanResId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByTextPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.internalRemoveByTextPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.onAfterRemoveByTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setTipPSLanResId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEMainStateServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSSysCssId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEMainStateServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSSysDynaModelId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEMainStateServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAINSTATE_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEMAINSTATE", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEMainState pSDEMainState : arrayList) {
            PSDEMainState pSDEMainState2 = (PSDEMainState)this.getDEModel().createEntity();
            pSDEMainState2.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMainState2.setPSSysImageId(null);
            this.update(pSDEMainState2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMainStateServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEMainStateServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEMainStateServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEMainState> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEMainState pSDEMainState : arrayList) {
            this.remove((IEntity)pSDEMainState);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEMainState> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMainState pSDEMainState) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataQueryServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).testRemoveByNextPSDEMS(pSDEMainState);
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).removeByNextPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).testRemoveByPrevPSDEMS(pSDEMainState);
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).removeByPrevPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMS(pSDEMainState);
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).removeByPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMS(pSDEMainState);
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).removeByPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).removeByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESampleDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDEMainState(pSDEMainState);
        super.onBeforeRemove(pSDEMainState);
    }

    protected void onBeforeRemoveTemp(PSDEMainState pSDEMainState) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).removeTempByNextPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).removeTempByPSDEMainState(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).removeTempByPSDEMS(pSDEMainState);
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).removeTempByPSDEMS(pSDEMainState);
        super.onBeforeRemoveTemp((IEntity)pSDEMainState);
    }

    protected void getRelatedDataTempMajor(PSDEMainState pSDEMainState) throws Exception {
        this.getRelatedDataTempMajor_PSDEMSAction(pSDEMainState);
        this.getRelatedDataTempMajor_PSDEMSField(pSDEMainState);
        this.getRelatedDataTempMajor_PSDEMSOPPriv(pSDEMainState);
        this.getRelatedDataTempMajor_PSDEMainStateRS(pSDEMainState);
        super.getRelatedDataTempMajor((IEntity)pSDEMainState);
    }

    protected void getRelatedDataTempMajor_PSDEMSAction(PSDEMainState pSDEMainState) throws Exception {
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSAction> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSActionService.selectByPSDEMS(pSDEMainState) : pSDEMSActionService.selectTempByPSDEMS(pSDEMainState);
        for (PSDEMSAction pSDEMSAction : arrayList) {
            pSDEMSActionService.getTempMajor(pSDEMSAction);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMSField(PSDEMainState pSDEMainState) throws Exception {
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSField> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSFieldService.selectByPSDEMS(pSDEMainState) : pSDEMSFieldService.selectTempByPSDEMS(pSDEMainState);
        for (PSDEMSField pSDEMSField : arrayList) {
            pSDEMSFieldService.getTempMajor(pSDEMSField);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMSOPPriv(PSDEMainState pSDEMainState) throws Exception {
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSOPPriv> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSOPPrivService.selectByPSDEMainState(pSDEMainState) : pSDEMSOPPrivService.selectTempByPSDEMainState(pSDEMainState);
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            pSDEMSOPPrivService.getTempMajor(pSDEMSOPPriv);
        }
    }

    protected void getRelatedDataTempMajor_PSDEMainStateRS(PSDEMainState pSDEMainState) throws Exception {
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMainStateRS> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMainStateRSService.selectByNextPSDEMS(pSDEMainState) : pSDEMainStateRSService.selectTempByNextPSDEMS(pSDEMainState);
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            pSDEMainStateRSService.getTempMajor(pSDEMainStateRS);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2) throws Exception {
        ArrayList<PSDEMainStateRS> arrayList = this.updateRelatedDataTempMajor_removePSDEMainStateRS(pSDEMainState, pSDEMainState2);
        ArrayList<PSDEMSOPPriv> arrayList2 = this.updateRelatedDataTempMajor_removePSDEMSOPPriv(pSDEMainState, pSDEMainState2);
        ArrayList<PSDEMSField> arrayList3 = this.updateRelatedDataTempMajor_removePSDEMSField(pSDEMainState, pSDEMainState2);
        ArrayList<PSDEMSAction> arrayList4 = this.updateRelatedDataTempMajor_removePSDEMSAction(pSDEMainState, pSDEMainState2);
        this.updateRelatedDataTempMajor_updatePSDEMSAction(pSDEMainState, pSDEMainState2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDEMSField(pSDEMainState, pSDEMainState2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEMSOPPriv(pSDEMainState, pSDEMainState2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEMainStateRS(pSDEMainState, pSDEMainState2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEMainState, (IEntity)pSDEMainState2);
    }

    protected ArrayList<PSDEMSAction> updateRelatedDataTempMajor_removePSDEMSAction(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2) throws Exception {
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSAction> arrayList = pSDEMSActionService.selectTempByPSDEMS(pSDEMainState);
        ArrayList<PSDEMSAction> arrayList2 = pSDEMSActionService.selectByPSDEMS(pSDEMainState2);
        HashMap<String, PSDEMSAction> hashMap = new HashMap<String, PSDEMSAction>();
        for (PSDEMSAction pSDEMSAction : arrayList2) {
            hashMap.put(pSDEMSAction.getPSDEMSActionId(), pSDEMSAction);
        }
        for (PSDEMSAction pSDEMSAction : arrayList) {
            Object object = pSDEMSAction.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMSAction pSDEMSAction : hashMap.values()) {
            pSDEMSActionService.remove((IEntity)pSDEMSAction);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMSAction(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2, ArrayList<PSDEMSAction> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMSAction pSDEMSAction : arrayList) {
            pSDEMSActionService.updateTempMajor(pSDEMSAction);
        }
    }

    protected ArrayList<PSDEMSField> updateRelatedDataTempMajor_removePSDEMSField(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2) throws Exception {
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSField> arrayList = pSDEMSFieldService.selectTempByPSDEMS(pSDEMainState);
        ArrayList<PSDEMSField> arrayList2 = pSDEMSFieldService.selectByPSDEMS(pSDEMainState2);
        HashMap<String, PSDEMSField> hashMap = new HashMap<String, PSDEMSField>();
        for (PSDEMSField pSDEMSField : arrayList2) {
            hashMap.put(pSDEMSField.getPSDEMSFieldId(), pSDEMSField);
        }
        for (PSDEMSField pSDEMSField : arrayList) {
            Object object = pSDEMSField.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMSField pSDEMSField : hashMap.values()) {
            pSDEMSFieldService.remove((IEntity)pSDEMSField);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMSField(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2, ArrayList<PSDEMSField> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMSField pSDEMSField : arrayList) {
            pSDEMSFieldService.updateTempMajor(pSDEMSField);
        }
    }

    protected ArrayList<PSDEMSOPPriv> updateRelatedDataTempMajor_removePSDEMSOPPriv(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2) throws Exception {
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSOPPriv> arrayList = pSDEMSOPPrivService.selectTempByPSDEMainState(pSDEMainState);
        ArrayList<PSDEMSOPPriv> arrayList2 = pSDEMSOPPrivService.selectByPSDEMainState(pSDEMainState2);
        HashMap<String, PSDEMSOPPriv> hashMap = new HashMap<String, PSDEMSOPPriv>();
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList2) {
            hashMap.put(pSDEMSOPPriv.getPSDEMSOPPrivId(), pSDEMSOPPriv);
        }
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            Object object = pSDEMSOPPriv.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMSOPPriv pSDEMSOPPriv : hashMap.values()) {
            pSDEMSOPPrivService.remove((IEntity)pSDEMSOPPriv);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMSOPPriv(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2, ArrayList<PSDEMSOPPriv> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            pSDEMSOPPrivService.updateTempMajor(pSDEMSOPPriv);
        }
    }

    protected ArrayList<PSDEMainStateRS> updateRelatedDataTempMajor_removePSDEMainStateRS(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2) throws Exception {
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMainStateRS> arrayList = pSDEMainStateRSService.selectTempByNextPSDEMS(pSDEMainState);
        ArrayList<PSDEMainStateRS> arrayList2 = pSDEMainStateRSService.selectByNextPSDEMS(pSDEMainState2);
        HashMap<String, PSDEMainStateRS> hashMap = new HashMap<String, PSDEMainStateRS>();
        for (PSDEMainStateRS pSDEMainStateRS : arrayList2) {
            hashMap.put(pSDEMainStateRS.getPSDEMainStateRSId(), pSDEMainStateRS);
        }
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            Object object = pSDEMainStateRS.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEMainStateRS pSDEMainStateRS : hashMap.values()) {
            pSDEMainStateRSService.remove((IEntity)pSDEMainStateRS);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEMainStateRS(PSDEMainState pSDEMainState, PSDEMainState pSDEMainState2, ArrayList<PSDEMainStateRS> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            pSDEMainStateRSService.updateTempMajor(pSDEMainStateRS);
        }
    }

    protected void replaceParentInfo(PSDEMainState pSDEMainState, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEMainState, cloneSession);
        if (pSDEMainState.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEMainState.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEMainState, (PSDataEntity)iEntity);
        }
        if (pSDEMainState.getEnterPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEMainState.getEnterPSDEActionId())) != null) {
            this.onFillParentInfo_EnterPSDEAction(pSDEMainState, (PSDEAction)iEntity);
        }
        if (pSDEMainState.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEMainState.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEMainState, (PSDEDataQuery)iEntity);
        }
        if (pSDEMainState.getMobPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getMobPSDEFormId())) != null) {
            this.onFillParentInfo_MobPSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getMobQuickPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getMobQuickPSDEFormId())) != null) {
            this.onFillParentInfo_MobQuickPSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getMobUtilPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getMobUtilPSDEFormId())) != null) {
            this.onFillParentInfo_MobUtilPSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getQuickPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getQuickPSDEFormId())) != null) {
            this.onFillParentInfo_QuickPSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getUtilPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEMainState.getUtilPSDEFormId())) != null) {
            this.onFillParentInfo_UtilPSDEForm(pSDEMainState, (PSDEForm)iEntity);
        }
        if (pSDEMainState.getDEActionDMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEMainState.getDEActionDMPSLanResId())) != null) {
            this.onFillParentInfo_DEActionDMPSLanRes(pSDEMainState, (PSLanguageRes)iEntity);
        }
        if (pSDEMainState.getDEOPPrivDMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEMainState.getDEOPPrivDMPSLanResId())) != null) {
            this.onFillParentInfo_DEOPPrivDMPSLanRes(pSDEMainState, (PSLanguageRes)iEntity);
        }
        if (pSDEMainState.getTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEMainState.getTextPSLanResId())) != null) {
            this.onFillParentInfo_TextPSLanRes(pSDEMainState, (PSLanguageRes)iEntity);
        }
        if (pSDEMainState.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEMainState.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEMainState, (PSLanguageRes)iEntity);
        }
        if (pSDEMainState.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEMainState.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEMainState, (PSSysCss)iEntity);
        }
        if (pSDEMainState.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEMainState.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEMainState, (PSSysDynaModel)iEntity);
        }
        if (pSDEMainState.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEMainState.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEMainState, (PSSysImage)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEMainState, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowMode(bl, pSDEMainState, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEActionDenyMsg(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEActionDMPSLanResId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEActionDMPSLanResName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOPPrivDenyMsg(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOPPrivDMPSLanResId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOPPrivDMPSLanResName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditViewType(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnterPSDEActionId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnterStateMode(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldAllowMode(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobEditViewType(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobQuickPSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobUtilPSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSTag(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValue(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValue2(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValue2Text(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValue3(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValue3Text(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSValueText(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OPPrivAllowMode(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickPSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSLanResId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSLanResName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilPSDEFormId(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStateMode(bl, pSDEMainState, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEMainState, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isAllowModeDirty() && !bl2 : !pSDEMainState.isAllowModeDirty()) {
            return null;
        }
        String string = pSDEMainState.getAllowMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AllowMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isCodeNameDirty() && !bl2 : !pSDEMainState.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEMainState, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEMainStateDEModel(), "CODENAME", string3, pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_Color(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isColorDirty() : !pSDEMainState.isColorDirty()) {
            return null;
        }
        String string = pSDEMainState.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEActionDenyMsg(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEActionDenyMsgDirty() : !pSDEMainState.isDEActionDenyMsgDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEActionDenyMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEActionDenyMsg_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEACTIONDENYMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEActionDMPSLanResId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEActionDMPSLanResIdDirty() : !pSDEMainState.isDEActionDMPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEActionDMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEActionDMPSLanResId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEACTIONDMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEActionDMPSLanResName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEActionDMPSLanResNameDirty() : !pSDEMainState.isDEActionDMPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEActionDMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEActionDMPSLanResName_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEACTIONDMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDefaultModeDirty() : !pSDEMainState.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEMainStateDEModel(), "DEFAULTMODE", string, pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEOPPrivDenyMsg(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEOPPrivDenyMsgDirty() : !pSDEMainState.isDEOPPrivDenyMsgDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEOPPrivDenyMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEOPPrivDenyMsg_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIVDENYMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEOPPrivDMPSLanResId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEOPPrivDMPSLanResIdDirty() : !pSDEMainState.isDEOPPrivDMPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEOPPrivDMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEOPPrivDMPSLanResId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIVDMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEOPPrivDMPSLanResName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isDEOPPrivDMPSLanResNameDirty() : !pSDEMainState.isDEOPPrivDMPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getDEOPPrivDMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEOPPrivDMPSLanResName_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIVDMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditViewType(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isEditViewTypeDirty() : !pSDEMainState.isEditViewTypeDirty()) {
            return null;
        }
        String string = pSDEMainState.getEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditViewType_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isEnableViewActionsDirty() : !pSDEMainState.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnterPSDEActionId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isEnterPSDEActionIdDirty() : !pSDEMainState.isEnterPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getEnterPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnterPSDEActionId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENTERPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnterStateMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isEnterStateModeDirty() : !pSDEMainState.isEnterStateModeDirty()) {
            return null;
        }
        String string = pSDEMainState.getEnterStateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnterStateMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENTERSTATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldAllowMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isFieldAllowModeDirty() : !pSDEMainState.isFieldAllowModeDirty()) {
            return null;
        }
        String string = pSDEMainState.getFieldAllowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldAllowMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDALLOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isLockFlagDirty() : !pSDEMainState.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMemoDirty() : !pSDEMainState.isMemoDirty()) {
            return null;
        }
        String string = pSDEMainState.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobEditViewType(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMobEditViewTypeDirty() : !pSDEMainState.isMobEditViewTypeDirty()) {
            return null;
        }
        String string = pSDEMainState.getMobEditViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobEditViewType_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBEDITVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobPSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMobPSDEFormIdDirty() : !pSDEMainState.isMobPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getMobPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobQuickPSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMobQuickPSDEFormIdDirty() : !pSDEMainState.isMobQuickPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getMobQuickPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobQuickPSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBQUICKPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MobUtilPSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMobUtilPSDEFormIdDirty() : !pSDEMainState.isMobUtilPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getMobUtilPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobUtilPSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBUTILPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSTag(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSTagDirty() : !pSDEMainState.isMSTagDirty()) {
            return null;
        }
        String string = pSDEMainState.getMSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSTag_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSTAG");
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
                String string4 = this.checkFieldDupRule(this.getPSDEMainStateDEModel(), "MSTAG", string3, pSDEMainState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MSTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValue(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValueDirty() : !pSDEMainState.isMSValueDirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValue_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValue2(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValue2Dirty() : !pSDEMainState.isMSValue2Dirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValue2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValue2_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValue2Text(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValue2TextDirty() : !pSDEMainState.isMSValue2TextDirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValue2Text();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValue2Text_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUE2TEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValue3(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValue3Dirty() : !pSDEMainState.isMSValue3Dirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValue3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValue3_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValue3Text(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValue3TextDirty() : !pSDEMainState.isMSValue3TextDirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValue3Text();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValue3Text_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUE3TEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSValueText(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isMSValueTextDirty() : !pSDEMainState.isMSValueTextDirty()) {
            return null;
        }
        String string = pSDEMainState.getMSValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSValueText_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OPPrivAllowMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isOPPrivAllowModeDirty() : !pSDEMainState.isOPPrivAllowModeDirty()) {
            return null;
        }
        String string = pSDEMainState.getOPPrivAllowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OPPrivAllowMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPPRIVALLOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isOrderValueDirty() : !pSDEMainState.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDEDQIdDirty() : !pSDEMainState.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEDQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_PSDEDQ((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDEFormIdDirty() : !pSDEMainState.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDEIdDirty() && !bl2 : !pSDEMainState.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDEMainStateIdDirty() && !bl2 : !pSDEMainState.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEMainStateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMainStateName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDEMainStateNameDirty() && !bl2 : !pSDEMainState.isPSDEMainStateNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEMainStateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateName_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEMainStateDEModel(), "PSDEMAINSTATENAME", string3, pSDEMainState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEMAINSTATENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSDENameDirty() && !bl2 : !pSDEMainState.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSSysCssIdDirty() : !pSDEMainState.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSSysCssNameDirty() : !pSDEMainState.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSSysDynaModelIdDirty() : !pSDEMainState.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isPSSysImageIdDirty() : !pSDEMainState.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_QuickPSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isQuickPSDEFormIdDirty() : !pSDEMainState.isQuickPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getQuickPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QuickPSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSLanResId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isTextPSLanResIdDirty() : !pSDEMainState.isTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSLanResId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSLanResName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isTextPSLanResNameDirty() : !pSDEMainState.isTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSLanResName_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isTipPSLanResIdDirty() : !pSDEMainState.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isTipPSLanResNameDirty() : !pSDEMainState.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEMainState.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isToDoTaskDirty() : !pSDEMainState.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEMainState.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isTooltipInfoDirty() : !pSDEMainState.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEMainState.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUserCatDirty() : !pSDEMainState.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMainState.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUserTagDirty() : !pSDEMainState.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMainState.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUserTag2Dirty() : !pSDEMainState.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMainState.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUserTag3Dirty() : !pSDEMainState.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMainState.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUserTag4Dirty() : !pSDEMainState.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMainState.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEMainState, bl2, bl3);
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

    protected EntityFieldError onCheckField_UtilPSDEFormId(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isUtilPSDEFormIdDirty() : !pSDEMainState.isUtilPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEMainState.getUtilPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilPSDEFormId_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isViewActionsDirty() : !pSDEMainState.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStateMode(boolean bl, PSDEMainState pSDEMainState, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMainState.isWFStateModeDirty() : !pSDEMainState.isWFStateModeDirty()) {
            return null;
        }
        Integer n = pSDEMainState.getWFStateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFStateMode_Default((IEntity)pSDEMainState, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"3") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEMainStateDEModel(), "WFSTATEMODE", string, pSDEMainState, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("WFSTATEMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEMainState, bl);
    }

    protected void onSyncIndexEntities(PSDEMainState pSDEMainState, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEMainState, bl);
    }

    public Object getDataContextValue(PSDEMainState pSDEMainState, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEMainState, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEMainState.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMainState pSDEMainState, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_DEActionDMPSLanRes(pSDEMainState, arrayList, n);
        this.onExportMajorModel_DEOPPrivDMPSLanRes(pSDEMainState, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEMainState, arrayList, n);
    }

    protected void onExportMajorModel_DEActionDMPSLanRes(PSDEMainState pSDEMainState, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEMainState.getDEActionDMPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEMainState.getDEActionDMPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_DEOPPrivDMPSLanRes(PSDEMainState pSDEMainState, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEMainState.getDEOPPrivDMPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEMainState.getDEOPPrivDMPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowMode_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"DEACTIONDENYMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEActionDenyMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEACTIONDMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEActionDMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEACTIONDMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEActionDMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIVDENYMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOPPrivDenyMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIVDMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOPPrivDMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIVDMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOPPrivDMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnterPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnterPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTERSTATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnterStateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDALLOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldAllowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBEDITVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobEditViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBQUICKFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobQuickFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBQUICKPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobQuickPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBQUICKPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobQuickPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBUTILPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobUtilPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValue2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUE2TEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValue2Text_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValue3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUE3TEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValue3Text_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPPRIVALLOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OPPrivAllowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEDQ", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_PSDEDQ(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"QUICKFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"UTILFORMCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilFormCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStateMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALLOWMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_DEActionDenyMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEACTIONDENYMSG", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEActionDMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEACTIONDMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEActionDMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEACTIONDMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("DEFAULTMODE", iEntity, bl2, "NOTEQ", null, "1", "", true) || this.checkFieldQueryCountRule2("DEFAULTMODE", "DQ0001", iEntity, bl2, 0, true, 0, true, "\u5f53\u524d\u5b9e\u4f53\u5df2\u5b58\u5728\u9ed8\u8ba4\u4e3b\u72b6\u6001", false, true)) {
                return null;
            }
            return "\u5b9e\u4f53\u53ea\u80fd\u7531\u4e00\u4e2a\u9ed8\u8ba4\u4e3b\u72b6\u6001";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEOPPrivDenyMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEOPPRIVDENYMSG", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEOPPrivDMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEOPPRIVDMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEOPPrivDMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEOPPRIVDMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnterPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENTERPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnterPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENTERPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnterStateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENTERSTATEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldAllowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDALLOWMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_MobEditViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBEDITVIEWTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobQuickFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBQUICKFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobQuickPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBQUICKPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobQuickPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBQUICKPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobUtilPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBUTILPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValue2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUE2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValue2Text_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUE2TEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValue3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUE3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValue3Text_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUE3TEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSVALUETEXT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OPPrivAllowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPPRIVALLOWMODE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDQId_PSDEDQ(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEDQID", "PSDEDATAQUERY", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u6570\u636e\u67e5\u8be2\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_QuickFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UtilFormCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILFORMCODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UtilPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WFStateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEMainState pSDEMainState) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEMainState)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMainState pSDEMainState) throws Exception {
        Object object = pSDEMainState.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEMAINSTATE_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEMainState);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEMainState pSDEMainState, Object object) throws Exception {
        PSDEMainState pSDEMainState2 = new PSDEMainState();
        pSDEMainState2.set("PSDEMAINSTATEID", object);
        String string = DataObject.getStringValue((Object)pSDEMainState.get("PSDEMAINSTATEID"));
        super.onCopyDetails((IEntity)pSDEMainState, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEMainState pSDEMainState, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAINSTATE");
        if (!bl) {
            pSDEMainState.setMSTag(null);
            super.exportCurXmlModel(pSDEMainState, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEMSAction(pSDEMainState, xmlNode);
        this.exportRelatedXmlModel_PSDEMSField(pSDEMainState, xmlNode);
        this.exportRelatedXmlModel_PSDEMSOPPriv(pSDEMainState, xmlNode);
        this.exportRelatedXmlModel_PSDEMainStateRS(pSDEMainState, xmlNode);
        super.onExportRelatedXmlModel(pSDEMainState, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEMSAction(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSAction> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSActionService.selectByPSDEMS(pSDEMainState) : pSDEMSActionService.selectTempByPSDEMS(pSDEMainState);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMSACTIONS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMSAction pSDEMSAction : arrayList) {
                pSDEMSActionService.exportXmlModel(pSDEMSAction, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEMSField(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSField> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSFieldService.selectByPSDEMS(pSDEMainState) : pSDEMSFieldService.selectTempByPSDEMS(pSDEMainState);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMSFIELDS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMSField pSDEMSField : arrayList) {
                pSDEMSFieldService.exportXmlModel(pSDEMSField, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEMSOPPriv(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMSOPPriv> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMSOPPrivService.selectByPSDEMainState(pSDEMainState) : pSDEMSOPPrivService.selectTempByPSDEMainState(pSDEMainState);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMSOPPRIVS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
                pSDEMSOPPrivService.exportXmlModel(pSDEMSOPPriv, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEMainStateRS(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEMainStateRS> arrayList = null;
        String string = pSDEMainState.getPSDEMainStateId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEMainStateRSService.selectByNextPSDEMS(pSDEMainState, "ORDER BY ORDERVALUE ASC") : pSDEMainStateRSService.selectTempByNextPSDEMS(pSDEMainState, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEMAINSTATERSS");
            xmlNode.addNode(xmlNode2);
            for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
                pSDEMainStateRS.set("ORDERVALUE", null);
                pSDEMainStateRSService.exportXmlModel(pSDEMainStateRS, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEMSACTIONS");
        this.importRelatedXmlModel_PSDEMSAction(pSDEMainState, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEMSFIELDS");
        this.importRelatedXmlModel_PSDEMSField(pSDEMainState, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDEMSOPPRIVS");
        this.importRelatedXmlModel_PSDEMSOPPriv(pSDEMainState, xmlNode4);
        XmlNode xmlNode5 = xmlNode.getChildNodeByNodeName("PSDEMAINSTATERSS");
        this.importRelatedXmlModel_PSDEMainStateRS(pSDEMainState, xmlNode5);
        super.onImportRelatedXmlModel(pSDEMainState, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEMSAction(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMainState.getPSDEMainStateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMSActionService.removeByPSDEMS(pSDEMainState);
        } else {
            pSDEMSActionService.removeTempByPSDEMS(pSDEMainState);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMSAction pSDEMSAction = new PSDEMSAction();
                pSDEMSActionService.fillParentInfo((IEntity)pSDEMSAction, "DER1N", "DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", pSDEMainState.getPSDEMainStateId());
                pSDEMSActionService.importXmlModel(pSDEMSAction, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEMSField(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMainState.getPSDEMainStateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMSFieldService.removeByPSDEMS(pSDEMainState);
        } else {
            pSDEMSFieldService.removeTempByPSDEMS(pSDEMainState);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMSField pSDEMSField = new PSDEMSField();
                pSDEMSFieldService.fillParentInfo((IEntity)pSDEMSField, "DER1N", "DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID", pSDEMainState.getPSDEMainStateId());
                pSDEMSFieldService.importXmlModel(pSDEMSField, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEMSOPPriv(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMainState.getPSDEMainStateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMSOPPrivService.removeByPSDEMainState(pSDEMainState);
        } else {
            pSDEMSOPPrivService.removeTempByPSDEMainState(pSDEMainState);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMSOPPriv pSDEMSOPPriv = new PSDEMSOPPriv();
                pSDEMSOPPrivService.fillParentInfo((IEntity)pSDEMSOPPriv, "DER1N", "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", pSDEMainState.getPSDEMainStateId());
                pSDEMSOPPrivService.importXmlModel(pSDEMSOPPriv, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEMainStateRS(PSDEMainState pSDEMainState, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEMainState.getPSDEMainStateId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEMainStateRSService.removeByNextPSDEMS(pSDEMainState);
        } else {
            pSDEMainStateRSService.removeTempByNextPSDEMS(pSDEMainState);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEMainStateRS pSDEMainStateRS = new PSDEMainStateRS();
                pSDEMainStateRS.setOrderValue(n);
                n += 100;
                pSDEMainStateRSService.fillParentInfo((IEntity)pSDEMainStateRS, "DER1N", "DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID", pSDEMainState.getPSDEMainStateId());
                pSDEMainStateRSService.importXmlModel(pSDEMainStateRS, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMainState pSDEMainState, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMainState, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEMAINSTATE_PSDATAENTITY_PSDEID";
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
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEMainState pSDEMainState) {
        if (!StringHelper.isNullOrEmpty((String)pSDEMainState.getPSDEMainStateName())) {
            return pSDEMainState.getPSDEMainStateName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEMainState.getCodeName())) {
            return pSDEMainState.getCodeName();
        }
        return super.getModelV2Tag(pSDEMainState);
    }

    @Override
    public boolean setModelV2Tag(PSDEMainState pSDEMainState, String string) {
        pSDEMainState.setPSDEMainStateName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEMAINSTATENAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("MSTAG", "");
        map.put("PSDEMAINSTATENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMainState pSDEMainState, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMainState.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMainState, true);
        pSDEMainState.set("PSDEMAINSTATENAME", string);
        if (this.select(pSDEMainState, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEMainState, true);
        return super.getModelV2Entity(pSDEMainState, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMainState pSDEMainState, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEMainState, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEMainState pSDEMainState, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEMainState, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEMainState pSDEMainState, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEMSField> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID")) {
            pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAINSTATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMSFIELD", (Object)pSDEMainState.getPSDEMainStateId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMSField)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEMSField>();
                object4 = ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).selectByPSDEMS(pSDEMainState);
                object3 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMSField)object2.next();
                    object = ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMSField)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdemsfieldname")) {
                            string = objectNode.get("psdemsfieldname").asText();
                        }
                        if (objectNode2.has("psdemsfieldname")) {
                            string2 = objectNode2.get("psdemsfieldname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMSField();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID")) {
            pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAINSTATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMSOPPRIV", (Object)pSDEMainState.getPSDEMainStateId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMSField)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).selectByPSDEMainState(pSDEMainState);
                object3 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMSOPPriv)object2.next();
                    object = ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMSField)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdeopprivname")) {
                            string = objectNode.get("psdeopprivname").asText();
                        }
                        if (objectNode2.has("psdeopprivname")) {
                            string2 = objectNode2.get("psdeopprivname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMSOPPriv();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID")) {
            pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAINSTATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMSACTION", (Object)pSDEMainState.getPSDEMainStateId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMSField)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMSActionServiceBase)pSCoreSysServiceBase).selectByPSDEMS(pSDEMainState);
                object3 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMSAction)object2.next();
                    object = ((PSDEMSActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMSField)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdeactionname")) {
                            string = objectNode.get("psdeactionname").asText();
                        }
                        if (objectNode2.has("psdeactionname")) {
                            string2 = objectNode2.get("psdeactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMSAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID")) {
            pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEMAINSTATE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEMAINSTATERS", (Object)pSDEMainState.getPSDEMainStateId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEMSField)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).selectByNextPSDEMS(pSDEMainState);
                object3 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEMainStateRS)object2.next();
                    object = ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEMSField)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdemainstatersname")) {
                            string = objectNode.get("psdemainstatersname").asText();
                        }
                        if (objectNode2.has("psdemainstatersname")) {
                            string2 = objectNode2.get("psdemainstatersname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEMainStateRS();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEMainState, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEMainState pSDEMainState) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).selectByPSDEMS(pSDEMainState);
        String string2 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
        for (PSDEMSField entityBase : arrayList) {
            string = ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEMainState.getPSDEMainStateId());
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMSFieldServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMSFIELD WHERE PSDEMSID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).selectByPSDEMainState(pSDEMainState);
        string2 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
        for (PSDEMSOPPriv pSDEMSOPPriv : arrayList) {
            string = ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMSOPPriv);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMSOPPriv);
        }
        object = new SqlParamList();
        object.addString(pSDEMainState.getPSDEMainStateId());
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMSOPPRIV WHERE PSDEMAINSTATEID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMSActionServiceBase)pSCoreSysServiceBase).selectByPSDEMS(pSDEMainState);
        string2 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
        for (PSDEMSAction pSDEMSAction : arrayList) {
            string = ((PSDEMSActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMSAction);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMSAction);
        }
        object = new SqlParamList();
        object.addString(pSDEMainState.getPSDEMainStateId());
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMSActionServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMSACTION WHERE PSDEMSID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).selectByNextPSDEMS(pSDEMainState);
        string2 = StringHelper.format((String)"PSDEMAINSTATE#%1$s", (Object)pSDEMainState.getPSDEMainStateId());
        for (PSDEMainStateRS pSDEMainStateRS : arrayList) {
            string = ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEMainStateRS);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEMainStateRS);
        }
        object = new SqlParamList();
        object.addString(pSDEMainState.getPSDEMainStateId());
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEMainStateRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEMAINSTATERS WHERE NEXTPSDEMSID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEMainState);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEMainState pSDEMainState, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEMSField();
        entityBase.set("PSDEMSID", pSDEMainState.getPSDEMainStateId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMSOPPriv();
        entityBase.set("PSDEMAINSTATEID", pSDEMainState.getPSDEMainStateId());
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMSAction();
        entityBase.set("PSDEMSID", pSDEMainState.getPSDEMainStateId());
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEMainStateRS();
        entityBase.set("NEXTPSDEMSID", pSDEMainState.getPSDEMainStateId());
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEMainState, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEMainState pSDEMainState, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEMSField();
                ((PSDEMSFieldBase)object).setPSDEId(pSDEMainState.getPSDEId());
                ((PSDEMSFieldBase)object).setPSDEMSId(pSDEMainState.getPSDEMainStateId());
                ((PSDEMSFieldBase)object).setPSDEMSName(pSDEMainState.getPSDEMainStateName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMSField();
                    entityBase.setPSDEId(pSDEMainState.getPSDEId());
                    entityBase.setPSDEMSId(pSDEMainState.getPSDEMainStateId());
                    entityBase.setPSDEMSName(pSDEMainState.getPSDEMainStateName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEMSOPPriv();
                ((PSDEMSOPPrivBase)object).setPSDEId(pSDEMainState.getPSDEId());
                ((PSDEMSOPPrivBase)object).setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
                ((PSDEMSOPPrivBase)object).setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMSOPPriv();
                    entityBase.setPSDEId(pSDEMainState.getPSDEId());
                    entityBase.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
                    entityBase.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEMSAction();
                ((PSDEMSActionBase)object).setAllowMode(pSDEMainState.getAllowMode());
                ((PSDEMSActionBase)object).setPSDEId(pSDEMainState.getPSDEId());
                ((PSDEMSActionBase)object).setPSDEMSId(pSDEMainState.getPSDEMainStateId());
                ((PSDEMSActionBase)object).setPSDEMSName(pSDEMainState.getPSDEMainStateName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string6);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMSAction();
                    entityBase.setAllowMode(pSDEMainState.getAllowMode());
                    entityBase.setPSDEId(pSDEMainState.getPSDEId());
                    entityBase.setPSDEMSId(pSDEMainState.getPSDEMainStateId());
                    entityBase.setPSDEMSName(pSDEMainState.getPSDEMainStateName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                object = new PSDEMainStateRS();
                ((PSDEMainStateRSBase)object).setNextPSDEMSId(pSDEMainState.getPSDEMainStateId());
                ((PSDEMainStateRSBase)object).setNextPSDEMSName(pSDEMainState.getPSDEMainStateName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string7);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEMainStateRS();
                    entityBase.setNextPSDEMSId(pSDEMainState.getPSDEMainStateId());
                    entityBase.setNextPSDEMSName(pSDEMainState.getPSDEMainStateName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEMainState, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEMainState pSDEMainState, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMSFields(pSDEMainState, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMSOPPrivs(pSDEMainState, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMSActions(pSDEMainState, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEMainStateRSs(pSDEMainState, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEMainState, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEMSFields(PSDEMainState pSDEMainState, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMSFIELD", true), (boolean)false) == 0) {
            PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSField pSDEMSField = new PSDEMSField();
            pSDEMSField.setPSDEMSFieldId(pSMOSFile.getPSModelId());
            if (!pSDEMSFieldService.get((IEntity)pSDEMSField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMSField.getPSDEMSId(), (String)pSDEMainState.getPSDEMainStateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMSFieldService.exportModelV2(pSDEMSField);
            pSDEMSField.reset();
            if (!pSDEMSFieldService.setModelV2ResScope((IEntity)pSDEMSField, "PSDEMAINSTATE", pSDEMainState.getPSDEMainStateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMSFieldService.importModelV2(pSDEMSField, objectNode);
            SessionFactoryManager.commit();
            return pSDEMSFieldService.getFile((IEntity)pSDEMSField);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFIELD", true), (boolean)false) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEFieldId(pSMOSFile.getPSModelId());
            if (!pSDEFieldService.get((IEntity)pSDEField, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMSFieldService pSDEMSFieldService = (PSDEMSFieldService)ServiceGlobal.getService(PSDEMSFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSField pSDEMSField = new PSDEMSField();
            pSDEMSField.setPSDEMSId(pSDEMainState.getPSDEMainStateId());
            pSDEMSField.setPSDEFId(pSDEField.getPSDEFieldId());
            this.fillPasteEntity((IEntity)pSDEMSField, "PASTETAG");
            pSDEMSFieldService.create(pSDEMSField);
            if (StringHelper.compare((String)pSDEField.getPSDEId(), (String)pSDEMSField.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEMSFieldService.getFile((IEntity)pSDEMSField);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEMSOPPrivs(PSDEMainState pSDEMainState, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMSOPPRIV", true), (boolean)false) == 0) {
            PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSOPPriv pSDEMSOPPriv = new PSDEMSOPPriv();
            pSDEMSOPPriv.setPSDEMSOPPrivId(pSMOSFile.getPSModelId());
            if (!pSDEMSOPPrivService.get((IEntity)pSDEMSOPPriv, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMSOPPriv.getPSDEMainStateId(), (String)pSDEMainState.getPSDEMainStateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMSOPPrivService.exportModelV2(pSDEMSOPPriv);
            pSDEMSOPPriv.reset();
            if (!pSDEMSOPPrivService.setModelV2ResScope((IEntity)pSDEMSOPPriv, "PSDEMAINSTATE", pSDEMainState.getPSDEMainStateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMSOPPrivService.importModelV2(pSDEMSOPPriv, objectNode);
            SessionFactoryManager.commit();
            return pSDEMSOPPrivService.getFile((IEntity)pSDEMSOPPriv);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEOPPRIV", true), (boolean)false) == 0) {
            PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSDEOPPrivId(pSMOSFile.getPSModelId());
            if (!pSDEOPPrivService.get((IEntity)pSDEOPPriv, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMSOPPrivService pSDEMSOPPrivService = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSOPPriv pSDEMSOPPriv = new PSDEMSOPPriv();
            pSDEMSOPPriv.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
            pSDEMSOPPriv.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            this.fillPasteEntity((IEntity)pSDEMSOPPriv, "PASTETAG");
            pSDEMSOPPrivService.create(pSDEMSOPPriv);
            SessionFactoryManager.commit();
            return pSDEMSOPPrivService.getFile((IEntity)pSDEMSOPPriv);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEMSActions(PSDEMainState pSDEMainState, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMSACTION", true), (boolean)false) == 0) {
            PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSAction pSDEMSAction = new PSDEMSAction();
            pSDEMSAction.setPSDEMSActionId(pSMOSFile.getPSModelId());
            if (!pSDEMSActionService.get((IEntity)pSDEMSAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMSAction.getPSDEMSId(), (String)pSDEMainState.getPSDEMainStateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMSActionService.exportModelV2(pSDEMSAction);
            pSDEMSAction.reset();
            if (!pSDEMSActionService.setModelV2ResScope((IEntity)pSDEMSAction, "PSDEMAINSTATE", pSDEMainState.getPSDEMainStateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMSActionService.importModelV2(pSDEMSAction, objectNode);
            SessionFactoryManager.commit();
            return pSDEMSActionService.getFile((IEntity)pSDEMSAction);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEACTION", true), (boolean)false) == 0) {
            PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = new PSDEAction();
            pSDEAction.setPSDEActionId(pSMOSFile.getPSModelId());
            if (!pSDEActionService.get((IEntity)pSDEAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSDEMSActionService pSDEMSActionService = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEMSAction pSDEMSAction = new PSDEMSAction();
            pSDEMSAction.setPSDEMSId(pSDEMainState.getPSDEMainStateId());
            pSDEMSAction.setPSDEActionId(pSDEAction.getPSDEActionId());
            this.fillPasteEntity((IEntity)pSDEMSAction, "PASTETAG");
            pSDEMSActionService.create(pSDEMSAction);
            if (StringHelper.compare((String)pSDEAction.getPSDEId(), (String)pSDEMSAction.getPSDEId(), (boolean)false) != 0) {
                throw new Exception("\u6a21\u578b\u57df[\u5b9e\u4f53]\u4e0d\u4e00\u81f4");
            }
            SessionFactoryManager.commit();
            return pSDEMSActionService.getFile((IEntity)pSDEMSAction);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEMainStateRSs(PSDEMainState pSDEMainState, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEMAINSTATERS", true), (boolean)false) == 0) {
            PSDEMainStateRSService pSDEMainStateRSService = (PSDEMainStateRSService)ServiceGlobal.getService(PSDEMainStateRSService.class, (SessionFactory)this.getSessionFactory());
            PSDEMainStateRS pSDEMainStateRS = new PSDEMainStateRS();
            pSDEMainStateRS.setPSDEMainStateRSId(pSMOSFile.getPSModelId());
            if (!pSDEMainStateRSService.get((IEntity)pSDEMainStateRS, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEMainStateRS.getNextPSDEMSId(), (String)pSDEMainState.getPSDEMainStateId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEMainStateRSService.exportModelV2(pSDEMainStateRS);
            pSDEMainStateRS.reset();
            if (!pSDEMainStateRSService.setModelV2ResScope((IEntity)pSDEMainStateRS, "PSDEMAINSTATE", pSDEMainState.getPSDEMainStateId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEMainStateRSService.importModelV2(pSDEMainStateRS, objectNode);
            SessionFactoryManager.commit();
            return pSDEMainStateRSService.getFile((IEntity)pSDEMainStateRS);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEMainState pSDEMainState, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEMSFields(pSDEMainState, list);
        this.onFillPasteHelps_PSDEMSOPPrivs(pSDEMainState, list);
        this.onFillPasteHelps_PSDEMSActions(pSDEMainState, list);
        this.onFillPasteHelps_PSDEMainStateRSs(pSDEMainState, list);
        super.onFillPasteHelps(pSDEMainState, list);
    }

    protected void onFillPasteHelps_PSDEMSFields(PSDEMainState pSDEMainState, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u4e3b\u72b6\u6001]\u7684[\u5b9e\u4f53\u4e3b\u72b6\u6001\u5c5e\u6027]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSFIELD");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSFIELD_PSDEMAINSTATE_PSDEMSID");
        pSHelpSection.setUserTag("DER1N_PSDEMSFIELD_PSDEFIELD_PSDEFID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u5c5e\u6027\u7684[\u5b9e\u4f53\u5c5e\u6027]\u6784\u5efa[\u5b9e\u4f53\u4e3b\u72b6\u6001\u5c5e\u6027]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEMSOPPrivs(PSDEMainState pSDEMainState, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSOPPRIV");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u4e3b\u72b6\u6001]\u7684[\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSOPPRIV");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID");
        pSHelpSection.setUserTag("DER1N_PSDEMSOPPRIV_PSDEOPPRIV_PSDEOPPRIVID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u53ca\u5b9e\u4f53\u7684[\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6]\u6784\u5efa[\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEMSActions(PSDEMainState pSDEMainState, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSACTION");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u4e3b\u72b6\u6001]\u7684[\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMSACTION");
        pSHelpSection.setSectionParam2("DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID");
        pSHelpSection.setUserTag("DER1N_PSDEMSACTION_PSDEACTION_PSDEACTIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u5b9e\u4f53\u7684[\u5b9e\u4f53\u884c\u4e3a]\u6784\u5efa[\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEMainStateRSs(PSDEMainState pSDEMainState, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEMAINSTATERS");
        pSHelpSection.setSectionParam2("DER1N_PSDEMAINSTATERS_PSDEMAINSTATE_NEXTPSDEMSID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u4e3b\u72b6\u6001]\u7684[\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63a7\u5236\u884c\u4e3a>", "DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", "PSDEMSID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMainStateServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63a7\u5236\u884c\u4e3a>");
            } else if (PSDEMainStateServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemsactions");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID|PSDEMSID");
            pSMOSFile2.setFileTag3("PSDEMSACTION");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", "PSDEMSID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", "PSDEMSID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMainStateServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u63a7\u5236\u8bbf\u95ee\u6807\u8bc6>", "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", "PSDEMAINSTATEID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSDEMainStateServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u63a7\u5236\u8bbf\u95ee\u6807\u8bc6>");
            } else if (PSDEMainStateServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdemsopprivs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID|PSDEMAINSTATEID");
            pSMOSFile2.setFileTag3("PSDEMSOPPRIV");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", "PSDEMAINSTATEID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", "PSDEMAINSTATEID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEMainStateServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        ArrayList arrayList;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
        if (PSDEMainStateServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63a7\u5236\u884c\u4e3a>", (boolean)false) == 0 || PSDEMainStateServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEMSActions", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMSActionService)ServiceGlobal.getService(PSDEMSActionService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", "PSDEMSID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSDEMainStateServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u63a7\u5236\u8bbf\u95ee\u6807\u8bc6>", (boolean)false) == 0 || PSDEMainStateServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEMSOPPrivs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", "PSDEMAINSTATEID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMSACTION_PSDEMAINSTATE_PSDEMSID", (boolean)false) == 0) {
            if (PSDEMainStateServiceBase.getMOSVer() == 1) {
                return "<\u63a7\u5236\u884c\u4e3a>";
            }
            if (PSDEMainStateServiceBase.getMOSVer() == 2) {
                return "psdemsactions";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEMSOPPRIV_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)false) == 0) {
            if (PSDEMainStateServiceBase.getMOSVer() == 1) {
                return "<\u63a7\u5236\u8bbf\u95ee\u6807\u8bc6>";
            }
            if (PSDEMainStateServiceBase.getMOSVer() == 2) {
                return "psdemsopprivs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

