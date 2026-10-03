/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDELogicModel
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
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEOPPrivDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMSOPPrivServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerActionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEOPPrivServiceBase
extends PSCoreSysServiceBase<PSDEOPPriv> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYSANDDE = "CurSysAndDE";
    public static final String DATASET_CURSYSDE = "CurSysDE";
    public static final String DATASET_CURSYSNOTDE = "CurSysNotDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCMAPDERMAJORDEID = "CalcMapDERMajorDEId";
    private PSDEOPPrivDEModel pSDEOPPrivDEModel;
    private PSDEOPPrivDAO pSDEOPPrivDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService";
    }

    public PSDEOPPrivDEModel getPSDEOPPrivDEModel() {
        if (this.pSDEOPPrivDEModel == null) {
            try {
                this.pSDEOPPrivDEModel = (PSDEOPPrivDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEOPPrivDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEOPPrivDEModel();
    }

    public PSDEOPPrivDAO getPSDEOPPrivDAO() {
        if (this.pSDEOPPrivDAO == null) {
            try {
                this.pSDEOPPrivDAO = (PSDEOPPrivDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEOPPrivDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEOPPrivDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEOPPrivDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSANDDE, (boolean)true) == 0) {
            return this.fetchCurSysAndDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDE, (boolean)true) == 0) {
            return this.fetchCurSysDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOTDE, (boolean)true) == 0) {
            return this.fetchCurSysNotDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCMAPDERMAJORDEID, (boolean)true) == 0) {
            this.calcMapDERMajorDEId((PSDEOPPriv)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysAndDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSANDDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysNotDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOTDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcMapDERMajorDEId(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        pSDEOPPriv2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSDEOPPriv, ACTION_CALCMAPDERMAJORDEID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSDEOPPrivDEModel().getDELogic(ACTION_CALCMAPDERMAJORDEID);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSDEOPPriv2);
                actionContext.setSessionFactory(PSDEOPPrivServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSDEOPPriv pSDEOPPriv, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEOPPriv, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEOPPriv, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSDEOPPRIV_MAPPSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv2.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEOPPriv2);
            } else {
                iService.get(pSDEOPPriv2);
            }
            this.onFillParentInfo_MapPSDEOPPriv(pSDEOPPriv, pSDEOPPriv2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSDEOPPriv, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSDEOPPriv, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEOPPriv, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIV_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDEOPPriv, pSSysUniRes);
            return;
        }
        super.onFillParentInfo(pSDEOPPriv, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEOPPriv pSDEOPPriv, PSDataEntity pSDataEntity) throws Exception {
        pSDEOPPriv.setDEValidFlag(pSDataEntity.getValidFlag());
        pSDEOPPriv.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEOPPriv.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDEOPPriv, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEOPPriv pSDEOPPriv, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEOPPriv.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEOPPriv.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_MapPSDEOPPriv(PSDEOPPriv pSDEOPPriv, PSDEOPPriv pSDEOPPriv2) throws Exception {
        pSDEOPPriv.setMapPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
        pSDEOPPriv.setMapPSDEOPPrivName(pSDEOPPriv2.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDER(PSDEOPPriv pSDEOPPriv, PSDER pSDER) throws Exception {
        pSDEOPPriv.setDERValidFlag(pSDER.getValidFlag());
        pSDEOPPriv.setMajorPSDEId(pSDER.getMajorPSDEId());
        pSDEOPPriv.setPSDERId(pSDER.getPSDERId());
        pSDEOPPriv.setPSDERName(pSDER.getPSDERName());
        if (pSDER.getMinorPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEOPPriv, pSDER.getMinorPSDE());
        }
    }

    protected void onFillParentInfo_PSModule(PSDEOPPriv pSDEOPPriv, PSModule pSModule) throws Exception {
        pSDEOPPriv.setPSModuleId(pSModule.getPSModuleId());
        pSDEOPPriv.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSDEOPPriv pSDEOPPriv, PSSystem pSSystem) throws Exception {
        pSDEOPPriv.setPSSystemId(pSSystem.getPSSystemId());
        pSDEOPPriv.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDEOPPriv pSDEOPPriv, PSSysUniRes pSSysUniRes) throws Exception {
        pSDEOPPriv.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDEOPPriv.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected boolean onFillEntityKeyValue(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEOPPriv.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEOPPriv.get("PSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSDEOPPriv.get("PSDEOPPRIVNAME");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSDEOPPriv.get("PSDERID");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSDEOPPriv.set(this.getPSDEOPPrivDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        if (bl && pSDEOPPriv.getSystemFlag() == null) {
            pSDEOPPriv.setSystemFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSDE(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_MapPSDEOPPriv(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSDER(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSModule(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEOPPriv, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDEOPPriv, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        if (pSDEOPPriv.isPSDEIdDirty()) {
            if (pSDEOPPriv.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDEOPPriv.getPSDEId() == null || pSDEOPPriv.getPSDEName() == null) {
                    pSDataEntity = pSDEOPPriv.getPSDE();
                    pSDEOPPriv.setDEValidFlag(pSDataEntity.getValidFlag());
                    pSDEOPPriv.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDEOPPriv.getPSDE()).getPSSystemId(), (Object)pSDEOPPriv.getPSSystemId()) != 0L) {
                    pSDEOPPriv.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDEOPPriv, bl);
                }
            } else {
                pSDEOPPriv.setDEValidFlag(null);
                pSDEOPPriv.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MapPSDEOPPriv(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDER(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        if (pSDEOPPriv.isPSSystemIdDirty()) {
            if (pSDEOPPriv.getPSSystemId() != null) {
                if (pSDEOPPriv.getPSSystemId() == null || pSDEOPPriv.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDEOPPriv.getPSSystem();
                    pSDEOPPriv.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDEOPPriv.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        if (pSDEOPPriv.isPSSysUniResIdDirty()) {
            if (pSDEOPPriv.getPSSysUniResId() != null) {
                if (pSDEOPPriv.getPSSysUniResId() == null || pSDEOPPriv.getPSSysUniResName() == null) {
                    PSSysUniRes pSSysUniRes = pSDEOPPriv.getPSSysUniRes();
                    pSDEOPPriv.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
                }
            } else {
                pSDEOPPriv.setPSSysUniResName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEOPPriv, bl);
    }

    public ArrayList<PSDEOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPriv> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPriv> selectByMapPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByMapPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByMapPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByMapPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByMapPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAPPSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMapPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMapPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEOPPriv> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPriv> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPriv> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPriv> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDEOPPriv> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSDEId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIV_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEOPPRIV", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSDEFGroupId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByMapPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIV_PSDEOPPRIV_MAPPSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEOPPRIV", iDataEntityModel.getDataInfo(pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByMapPSDEOPPriv(pSDEOPPriv);
        for (PSDEOPPriv pSDEOPPriv2 : arrayList) {
            PSDEOPPriv pSDEOPPriv3 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv3.setPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
            pSDEOPPriv3.setMapPSDEOPPrivId(null);
            this.update(pSDEOPPriv3);
        }
    }

    public void removeByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByMapPSDEOPPriv(pSDEOPPriv2);
                PSDEOPPrivServiceBase.this.internalRemoveByMapPSDEOPPriv(pSDEOPPriv2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByMapPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByMapPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByMapPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEOPPriv pSDEOPPriv2 : arrayList) {
            this.remove(pSDEOPPriv2);
        }
        this.onAfterRemoveByMapPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMapPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIV_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSDEOPPRIV", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDER(pSDER);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSDERId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIV_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSDEOPPRIV", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSModule(pSModule);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSModuleId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSSystemId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIV_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDEOPPRIV", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            PSDEOPPriv pSDEOPPriv2 = (PSDEOPPriv)this.getDEModel().createEntity();
            pSDEOPPriv2.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
            pSDEOPPriv2.setPSSysUniResId(null);
            this.update(pSDEOPPriv2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEOPPrivServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEOPPrivServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEOPPriv> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDEOPPriv pSDEOPPriv : arrayList) {
            this.remove(pSDEOPPriv);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEOPPriv> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEOPPriv pSDEOPPriv) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSACHandlerActionService)ServiceGlobal.getService(PSACHandlerActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByExportPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByReadPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUser2PSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        ((PSACHandlerServiceBase)pSCoreSysServiceBase).testRemoveByUserPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByReadPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataImpServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEMSOPPrivService)ServiceGlobal.getService(PSDEMSOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMSOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivServiceBase)pSCoreSysServiceBase).testRemoveByMapPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByReadPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOpPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByCreatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByUpdatePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByMovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByRemovePSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysServiceAPIServiceBase)pSCoreSysServiceBase).testRemoveByDefaultPSDEOPPriv(pSDEOPPriv);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSDEOPPriv(pSDEOPPriv);
        super.onBeforeRemove(pSDEOPPriv);
    }

    protected void replaceParentInfo(PSDEOPPriv pSDEOPPriv, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEOPPriv, cloneSession);
        if (pSDEOPPriv.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEOPPriv.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEOPPriv, (PSDataEntity)iEntity);
        }
        if (pSDEOPPriv.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEOPPriv.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEOPPriv, (PSDEFGroup)iEntity);
        }
        if (pSDEOPPriv.getMapPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEOPPriv.getMapPSDEOPPrivId())) != null) {
            this.onFillParentInfo_MapPSDEOPPriv(pSDEOPPriv, (PSDEOPPriv)iEntity);
        }
        if (pSDEOPPriv.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEOPPriv.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSDEOPPriv, (PSDER)iEntity);
        }
        if (pSDEOPPriv.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSDEOPPriv.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSDEOPPriv, (PSModule)iEntity);
        }
        if (pSDEOPPriv.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEOPPriv.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEOPPriv, (PSSystem)iEntity);
        }
        if (pSDEOPPriv.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDEOPPriv.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDEOPPriv, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEOPPriv, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEOPPriv, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapPSDEOPPrivId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MapSysUniResMode(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OPPrivType(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivName(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResName(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SystemFlag(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEOPPriv, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEOPPriv, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isDynaModelFlagDirty() : !pSDEOPPriv.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPriv.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isLockFlagDirty() : !pSDEOPPriv.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPriv.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isLogicNameDirty() && !bl2 : !pSDEOPPriv.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_MapPSDEOPPrivId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isMapPSDEOPPrivIdDirty() : !pSDEOPPriv.isMapPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getMapPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MapPSDEOPPrivId_Default(pSDEOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPPSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MapSysUniResMode(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isMapSysUniResModeDirty() : !pSDEOPPriv.isMapSysUniResModeDirty()) {
            return null;
        }
        Integer n = pSDEOPPriv.getMapSysUniResMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MapSysUniResMode_Default(pSDEOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAPSYSUNIRESMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isMemoDirty() : !pSDEOPPriv.isMemoDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_OPPrivType(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isOPPrivTypeDirty() : !pSDEOPPriv.isOPPrivTypeDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getOPPrivType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OPPrivType_Default(pSDEOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPPRIVTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDEFGroupIdDirty() : !pSDEOPPriv.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDEIdDirty() : !pSDEOPPriv.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDENameDirty() : !pSDEOPPriv.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDEOPPrivIdDirty() && !bl2 : !pSDEOPPriv.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDEOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivName(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDEOPPrivNameDirty() && !bl2 : !pSDEOPPriv.isPSDEOPPrivNameDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDEOPPrivName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivName_Default(pSDEOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDERIdDirty() : !pSDEOPPriv.isPSDERIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSDynaInstIdDirty() : !pSDEOPPriv.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSModuleIdDirty() : !pSDEOPPriv.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSSystemIdDirty() && !bl2 : !pSDEOPPriv.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSSystemNameDirty() && !bl2 : !pSDEOPPriv.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSSysUniResIdDirty() : !pSDEOPPriv.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResName(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isPSSysUniResNameDirty() : !pSDEOPPriv.isPSSysUniResNameDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getPSSysUniResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResName_Default(pSDEOPPriv, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SystemFlag(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isSystemFlagDirty() : !pSDEOPPriv.isSystemFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPriv.getSystemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SystemFlag_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isUserCatDirty() : !pSDEOPPriv.isUserCatDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isUserTagDirty() : !pSDEOPPriv.isUserTagDirty()) {
            return null;
        }
        String string = pSDEOPPriv.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isUserTag2Dirty() : !pSDEOPPriv.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEOPPriv.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isUserTag3Dirty() : !pSDEOPPriv.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEOPPriv.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEOPPriv, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEOPPriv pSDEOPPriv, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPriv.isUserTag4Dirty() : !pSDEOPPriv.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEOPPriv.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEOPPriv, bl2, bl3);
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

    protected void onSyncEntity(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        super.onSyncEntity(pSDEOPPriv, bl);
    }

    protected void onSyncIndexEntities(PSDEOPPriv pSDEOPPriv, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEOPPriv, bl);
    }

    public Object getDataContextValue(PSDEOPPriv pSDEOPPriv, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEOPPRIV", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAPPSDEOPPRIVID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MAPPSDEOPPRIVNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEOPPriv, "majorpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSDEOPPriv, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEOPPriv.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEOPPriv pSDEOPPriv, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEOPPriv, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERVALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPPSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapPSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPPSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapPSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAPSYSUNIRESMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MapSysUniResMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPPRIVTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OPPrivType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SYSTEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SystemFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DERValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MajorPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapPSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPPSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapPSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAPPSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MapSysUniResMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OPPrivType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPPRIVTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEOPPRIVNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_SystemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDEOPPriv pSDEOPPriv) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEOPPriv)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEOPPriv pSDEOPPriv) throws Exception {
        IService iService;
        Object object = pSDEOPPriv.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEOPPRIV_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEOPPriv.get("PSDERID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEOPPRIV_PSDER_PSDERID", object);
        }
        super.onUpdateParent(pSDEOPPriv);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEOPPriv pSDEOPPriv, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEOPPRIV");
        if (!bl) {
            pSDEOPPriv.setCreateDate(null);
            pSDEOPPriv.setCreateMan(null);
            pSDEOPPriv.setPSDEOPPrivId(null);
            pSDEOPPriv.setUpdateDate(null);
            pSDEOPPriv.setUpdateMan(null);
            super.exportCurXmlModel(pSDEOPPriv, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEOPPriv pSDEOPPriv, PSSystem pSSystem) throws Exception {
        PSDEOPPriv pSDEOPPriv2 = new PSDEOPPriv();
        pSDEOPPriv2.setPSSystemId(pSDEOPPriv.getPSSystemId());
        pSDEOPPriv2.setPSDEId(pSDEOPPriv.getPSDEId());
        pSDEOPPriv2.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
        pSDEOPPriv2.setPSDERId(pSDEOPPriv.getPSDERId());
        if (this.selectOne(pSDEOPPriv2, true)) {
            return pSDEOPPriv2.getPSDEOPPrivId();
        }
        return super.getEntityFolderKeyValue(pSDEOPPriv, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEOPPriv pSDEOPPriv, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEOPPriv, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDER#%1$s", (Object)string);
        }
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIV_PSDER_PSDERID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIV_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIV_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIV_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDERNAME", null);
        }
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
        if (StringHelper.compare((String)string, (String)"PSDER", (boolean)true) == 0) {
            iEntity.set("PSDERID", (Object)string2);
            return true;
        }
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
        return new String[]{"PSDERID", "PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSDEOPPriv pSDEOPPriv) {
        if (!StringHelper.isNullOrEmpty((String)pSDEOPPriv.getPSDEOPPrivName())) {
            return pSDEOPPriv.getPSDEOPPrivName();
        }
        return super.getModelV2Tag(pSDEOPPriv);
    }

    @Override
    public boolean setModelV2Tag(PSDEOPPriv pSDEOPPriv, String string) {
        pSDEOPPriv.setPSDEOPPrivName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEOPPRIVNAME", "");
        map.put("PSDERID", "");
        map.put("PSDEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEOPPriv pSDEOPPriv, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEOPPriv.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEOPPriv, true);
        pSDEOPPriv.set("PSDEOPPRIVNAME", string);
        if (this.select(pSDEOPPriv, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEOPPriv, true);
        return super.getModelV2Entity(pSDEOPPriv, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEOPPriv pSDEOPPriv, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEOPPriv, objectNode, string, string2, n);
    }
}

