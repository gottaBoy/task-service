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
 *  net.ibizsys.paas.db.SelectCond
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
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqModuleDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqModuleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActorBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysReqModuleServiceBase
extends PSCoreSysServiceBase<PSSysReqModule> {
    private static final Log log = LogFactory.getLog(PSSysReqModuleServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYS2 = "CurSys2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VIEW = "VIEW";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysReqModuleDEModel pSSysReqModuleDEModel;
    private PSSysReqModuleDAO pSSysReqModuleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService";
    }

    public PSSysReqModuleDEModel getPSSysReqModuleDEModel() {
        if (this.pSSysReqModuleDEModel == null) {
            try {
                this.pSSysReqModuleDEModel = (PSSysReqModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqModuleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysReqModuleDEModel();
    }

    public PSSysReqModuleDAO getPSSysReqModuleDAO() {
        if (this.pSSysReqModuleDAO == null) {
            try {
                this.pSSysReqModuleDAO = (PSSysReqModuleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqModuleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqModuleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysReqModuleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS2, (boolean)true) == 0) {
            return this.fetchCurSys2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VIEW, (boolean)true) == 0) {
            return this.fetchView(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VIEW, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysReqModule pSSysReqModule, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSSysReqModule, pSDevPrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrd);
            } else {
                iService.get(pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSSysReqModule, pSDevPrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysReqModule, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSSYSACTOR_PSSYSACTORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService", (SessionFactory)this.getSessionFactory());
            PSSysActor pSSysActor = (PSSysActor)iService.getDEModel().createEntity();
            pSSysActor.set("PSSYSACTORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysActor);
            } else {
                iService.get(pSSysActor);
            }
            this.onFillParentInfo_PSSysActor(pSSysReqModule, pSSysActor);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqModuleService", (SessionFactory)this.getSessionFactory());
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)iService.getDEModel().createEntity();
            pSSysReqModule2.set("PSSYSREQMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqModule2);
            } else {
                iService.get(pSSysReqModule2);
            }
            this.onFillParentInfo_PPSysReqModule(pSSysReqModule, pSSysReqModule2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysReqModule, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSREQMODULE_PSSYSUSERCASE_PSSYSUSECASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserCase);
            } else {
                iService.get(pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUseCase(pSSysReqModule, pSSysUserCase);
            return;
        }
        super.onFillParentInfo(pSSysReqModule, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdVer(PSSysReqModule pSSysReqModule, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSSysReqModule.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSSysReqModule.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
        if (pSDevPrdVer.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSSysReqModule, pSDevPrdVer.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSSysReqModule pSSysReqModule, PSDevPrd pSDevPrd) throws Exception {
        pSSysReqModule.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSSysReqModule.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillParentInfo_PSModule(PSSysReqModule pSSysReqModule, PSModule pSModule) throws Exception {
        pSSysReqModule.setPSModuleId(pSModule.getPSModuleId());
        pSSysReqModule.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysActor(PSSysReqModule pSSysReqModule, PSSysActor pSSysActor) throws Exception {
        pSSysReqModule.setPSSysActorId(pSSysActor.getPSSysActorId());
        pSSysReqModule.setPSSysActorName(pSSysActor.getPSSysActorName());
    }

    protected void onFillParentInfo_PPSysReqModule(PSSysReqModule pSSysReqModule, PSSysReqModule pSSysReqModule2) throws Exception {
        pSSysReqModule.setPPSSysReqModuleId(pSSysReqModule2.getPSSysReqModuleId());
        pSSysReqModule.setPPSSysReqModuleName(pSSysReqModule2.getPSSysReqModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSSysReqModule pSSysReqModule, PSSystem pSSystem) throws Exception {
        pSSysReqModule.setPSSystemId(pSSystem.getPSSystemId());
        pSSysReqModule.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUseCase(PSSysReqModule pSSysReqModule, PSSysUserCase pSSysUserCase) throws Exception {
        pSSysReqModule.setPSSysUseCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSSysReqModule.setPSSysUseCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        if (bl) {
            if (pSSysReqModule.getCodeName() == null) {
                pSSysReqModule.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "ReqMod", 25));
            }
            if (pSSysReqModule.getModuleType() == null) {
                pSSysReqModule.setModuleType((String)this.getDefaultValue(this.getWebContext(), "", "NORMAL", 25));
            }
            if (pSSysReqModule.getPSSysReqModuleName() == null) {
                pSSysReqModule.setPSSysReqModuleName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u9700\u6c42\u6a21\u5757", 25));
            }
        }
        super.onFillEntityFullInfo(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSModule(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSSysActor(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PPSysReqModule(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysReqModule, bl);
        this.onFillEntityFullInfo_PSSysUseCase(pSSysReqModule, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysActor(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSysReqModule(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        if (pSSysReqModule.isPSSystemIdDirty()) {
            if (pSSysReqModule.getPSSystemId() != null) {
                if (pSSysReqModule.getPSSystemId() == null || pSSysReqModule.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysReqModule.getPSSystem();
                    pSSysReqModule.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysReqModule.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUseCase(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysReqModule, bl);
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDVERID", (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqModule> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysReqModule> selectByPSSysActor(PSSysActorBase pSSysActorBase) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string) throws Exception {
        return this.selectByPSSysActor(pSSysActorBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSysActor(PSSysActorBase pSSysActorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSACTORID", (Object)pSSysActorBase.getPSSysActorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysActorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysActorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqModule> selectByPPSysReqModule(PSSysReqModuleBase pSSysReqModuleBase) throws Exception {
        return this.selectByPPSysReqModule(pSSysReqModuleBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPPSysReqModule(PSSysReqModuleBase pSSysReqModuleBase, String string) throws Exception {
        return this.selectByPPSysReqModule(pSSysReqModuleBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPPSysReqModule(PSSysReqModuleBase pSSysReqModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSREQMODULEID", (Object)pSSysReqModuleBase.getPSSysReqModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSysReqModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSysReqModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysReqModule> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysReqModule> selectByPSSysUseCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUseCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSysUseCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUseCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSSysReqModule> selectByPSSysUseCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSECASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUseCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUseCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSDevPrdVerId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSDevPrdId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSModule(pSModule);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSModuleId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysActor(pSSysActor, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSACTOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysActor);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSSYSACTOR_PSSYSACTORID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSSysActor), arrayList.get(0)));
        }
    }

    public void resetPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysActor(pSSysActor);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSSysActorId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSSysActor(PSSysActor pSSysActor) throws Exception {
        final PSSysActor pSSysActor2 = pSSysActor;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSSysActor(pSSysActor2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSSysActor(pSSysActor2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSSysActor(pSSysActor2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void internalRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysActor(pSSysActor);
        this.onBeforeRemoveByPSSysActor(pSSysActor, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSSysActor(pSSysActor, arrayList);
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor) throws Exception {
    }

    protected void onBeforeRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysActor(PSSysActor pSSysActor, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPPSysReqModule(pSSysReqModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSSysReqModule), arrayList.get(0)));
        }
    }

    public void resetPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPPSysReqModule(pSSysReqModule);
        for (PSSysReqModule pSSysReqModule2 : arrayList) {
            PSSysReqModule pSSysReqModule3 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule3.setPSSysReqModuleId(pSSysReqModule2.getPSSysReqModuleId());
            pSSysReqModule3.setPPSSysReqModuleId(null);
            this.update(pSSysReqModule3);
        }
    }

    public void removeByPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        final PSSysReqModule pSSysReqModule2 = pSSysReqModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPPSysReqModule(pSSysReqModule2);
                PSSysReqModuleServiceBase.this.internalRemoveByPPSysReqModule(pSSysReqModule2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPPSysReqModule(pSSysReqModule2);
            }
        });
    }

    protected void onBeforeRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
    }

    protected void internalRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPPSysReqModule(pSSysReqModule);
        this.onBeforeRemoveByPPSysReqModule(pSSysReqModule, arrayList);
        for (PSSysReqModule pSSysReqModule2 : arrayList) {
            this.remove(pSSysReqModule2);
        }
        this.onAfterRemoveByPPSysReqModule(pSSysReqModule, arrayList);
    }

    protected void onAfterRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule) throws Exception {
    }

    protected void onBeforeRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSysReqModule(PSSysReqModule pSSysReqModule, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSSystemId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysUseCase(pSSysUserCase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERCASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUserCase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSREQMODULE_PSSYSUSERCASE_PSSYSUSECASEID", "", iDataEntityModel.getName(), "PSSYSREQMODULE", iDataEntityModel.getDataInfo(pSSysUserCase), arrayList.get(0)));
        }
    }

    public void resetPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysUseCase(pSSysUserCase);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            PSSysReqModule pSSysReqModule2 = (PSSysReqModule)this.getDEModel().createEntity();
            pSSysReqModule2.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
            pSSysReqModule2.setPSSysUseCaseId(null);
            this.update(pSSysReqModule2);
        }
    }

    public void removeByPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysReqModuleServiceBase.this.onBeforeRemoveByPSSysUseCase(pSSysUserCase2);
                PSSysReqModuleServiceBase.this.internalRemoveByPSSysUseCase(pSSysUserCase2);
                PSSysReqModuleServiceBase.this.onAfterRemoveByPSSysUseCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSSysReqModule> arrayList = this.selectByPSSysUseCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUseCase(pSSysUserCase, arrayList);
        for (PSSysReqModule pSSysReqModule : arrayList) {
            this.remove(pSSysReqModule);
        }
        this.onAfterRemoveByPSSysUseCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUseCase(PSSysUserCase pSSysUserCase, ArrayList<PSSysReqModule> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysReqModule pSSysReqModule) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysReqModule(pSSysReqModule);
        pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqModuleServiceBase)pSCoreSysServiceBase).testRemoveByPPSysReqModule(pSSysReqModule);
        super.onBeforeRemove(pSSysReqModule);
    }

    protected void replaceParentInfo(PSSysReqModule pSSysReqModule, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysReqModule, cloneSession);
        if (pSSysReqModule.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSSysReqModule.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSSysReqModule, (PSDevPrdVer)iEntity);
        }
        if (pSSysReqModule.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSSysReqModule.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSSysReqModule, (PSDevPrd)iEntity);
        }
        if (pSSysReqModule.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysReqModule.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysReqModule, (PSModule)iEntity);
        }
        if (pSSysReqModule.getPSSysActorId() != null && (iEntity = cloneSession.getEntity("PSSYSACTOR", (Object)pSSysReqModule.getPSSysActorId())) != null) {
            this.onFillParentInfo_PSSysActor(pSSysReqModule, (PSSysActor)iEntity);
        }
        if (pSSysReqModule.getPPSSysReqModuleId() != null && (iEntity = cloneSession.getEntity("PSSYSREQMODULE", (Object)pSSysReqModule.getPPSSysReqModuleId())) != null) {
            this.onFillParentInfo_PPSysReqModule(pSSysReqModule, (PSSysReqModule)iEntity);
        }
        if (pSSysReqModule.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysReqModule.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysReqModule, (PSSystem)iEntity);
        }
        if (pSSysReqModule.getPSSysUseCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSSysReqModule.getPSSysUseCaseId())) != null) {
            this.onFillParentInfo_PSSysUseCase(pSSysReqModule, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysReqModule, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AIBuildMode(bl, pSSysReqModule, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIBuildState(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIChoices(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPrompt(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices2(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices3(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AIPromptChoices4(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleSN(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag2(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag3(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleTag4(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleType(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysReqModuleId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysActorId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqModuleId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqModuleName(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUseCaseId(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReqModel(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReqModelType(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Subject(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysReqModule, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysReqModule, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AIBuildMode(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIBuildModeDirty() : !pSSysReqModule.isAIBuildModeDirty()) {
            return null;
        }
        Integer n = pSSysReqModule.getAIBuildMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AIBuildMode_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIBUILDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIBuildState(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIBuildStateDirty() : !pSSysReqModule.isAIBuildStateDirty()) {
            return null;
        }
        Integer n = pSSysReqModule.getAIBuildState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AIBuildState_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIBUILDSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIChoices(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIChoicesDirty() : !pSSysReqModule.isAIChoicesDirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIChoices();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIChoices_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AICHOICES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPrompt(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIPromptDirty() : !pSSysReqModule.isAIPromptDirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIPrompt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPrompt_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIPromptChoicesDirty() : !pSSysReqModule.isAIPromptChoicesDirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIPromptChoices();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices2(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIPromptChoices2Dirty() : !pSSysReqModule.isAIPromptChoices2Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIPromptChoices2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices2_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices3(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIPromptChoices3Dirty() : !pSSysReqModule.isAIPromptChoices3Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIPromptChoices3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices3_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AIPromptChoices4(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isAIPromptChoices4Dirty() : !pSSysReqModule.isAIPromptChoices4Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getAIPromptChoices4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AIPromptChoices4_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AIPROMPTCHOICES4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isCodeNameDirty() : !pSSysReqModule.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysReqModule.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysReqModule, bl2, bl3);
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
                string3 = "PSSYSTEMID";
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PPSSYSREQMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysReqModuleDEModel(), "CODENAME", string3, pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isContentDirty() : !pSSysReqModule.isContentDirty()) {
            return null;
        }
        String string = pSSysReqModule.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isContentTypeDirty() : !pSSysReqModule.isContentTypeDirty()) {
            return null;
        }
        String string = pSSysReqModule.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isMemoDirty() : !pSSysReqModule.isMemoDirty()) {
            return null;
        }
        String string = pSSysReqModule.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModuleSN(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleSNDirty() : !pSSysReqModule.isModuleSNDirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleSN_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULESN");
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
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysReqModuleDEModel(), "MODULESN", string3, pSSysReqModule, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MODULESN");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleTag(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleTagDirty() : !pSSysReqModule.isModuleTagDirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleTag2(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleTag2Dirty() : !pSSysReqModule.isModuleTag2Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag2_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleTag3(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleTag3Dirty() : !pSSysReqModule.isModuleTag3Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag3_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleTag4(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleTag4Dirty() : !pSSysReqModule.isModuleTag4Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleTag4_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModuleType(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isModuleTypeDirty() : !pSSysReqModule.isModuleTypeDirty()) {
            return null;
        }
        String string = pSSysReqModule.getModuleType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleType_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isOrderValueDirty() : !pSSysReqModule.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysReqModule.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysReqModuleId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPPSSysReqModuleIdDirty() : !pSSysReqModule.isPPSSysReqModuleIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPPSSysReqModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysReqModuleId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSREQMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSDevPrdIdDirty() : !pSSysReqModule.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSDevPrdId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSDevPrdVerIdDirty() : !pSSysReqModule.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSDevPrdVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSModuleIdDirty() : !pSSysReqModule.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysActorId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSysActorIdDirty() : !pSSysReqModule.isPSSysActorIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSysActorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysActorId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqModuleId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSysReqModuleIdDirty() && !bl2 : !pSSysReqModule.isPSSysReqModuleIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSysReqModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqModuleId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqModuleName(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSysReqModuleNameDirty() && !bl2 : !pSSysReqModule.isPSSysReqModuleNameDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSysReqModuleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQMODULENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqModuleName_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQMODULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSystemIdDirty() && !bl2 : !pSSysReqModule.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSystemNameDirty() && !bl2 : !pSSysReqModule.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUseCaseId(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isPSSysUseCaseIdDirty() : !pSSysReqModule.isPSSysUseCaseIdDirty()) {
            return null;
        }
        String string = pSSysReqModule.getPSSysUseCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUseCaseId_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSECASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReqModel(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isReqModelDirty() : !pSSysReqModule.isReqModelDirty()) {
            return null;
        }
        String string = pSSysReqModule.getReqModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReqModel_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReqModelType(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isReqModelTypeDirty() : !pSSysReqModule.isReqModelTypeDirty()) {
            return null;
        }
        String string = pSSysReqModule.getReqModelType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ReqModelType_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQMODELTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Subject(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isSubjectDirty() : !pSSysReqModule.isSubjectDirty()) {
            return null;
        }
        String string = pSSysReqModule.getSubject();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Subject_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isTagsDirty() : !pSSysReqModule.isTagsDirty()) {
            return null;
        }
        String string = pSSysReqModule.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSSysReqModule, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TAGS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isUserCatDirty() : !pSSysReqModule.isUserCatDirty()) {
            return null;
        }
        String string = pSSysReqModule.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isUserTagDirty() : !pSSysReqModule.isUserTagDirty()) {
            return null;
        }
        String string = pSSysReqModule.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isUserTag2Dirty() : !pSSysReqModule.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isUserTag3Dirty() : !pSSysReqModule.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysReqModule, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysReqModule pSSysReqModule, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysReqModule.isUserTag4Dirty() : !pSSysReqModule.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysReqModule.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysReqModule, bl2, bl3);
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

    protected void onSyncEntity(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        super.onSyncEntity(pSSysReqModule, bl);
    }

    protected void onSyncIndexEntities(PSSysReqModule pSSysReqModule, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysReqModule, bl);
    }

    public Object getDataContextValue(PSSysReqModule pSSysReqModule, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysReqModule, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysReqModule pSSysReqModule2 = pSSysReqModule.getPPSysReqModule();
        if (pSSysReqModule2 != null && pSSysReqModule2.contains(string)) {
            return pSSysReqModule2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysReqModule pSSysReqModule, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysReqModule, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AIBUILDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIBuildMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIBUILDSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIBuildState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AICHOICES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIChoices_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPrompt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AIPROMPTCHOICES4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AIPromptChoices4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSREQMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysReqModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSREQMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysReqModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACTORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysActorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSECASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUseCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSECASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUseCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReqModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQMODELTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReqModelType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBJECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Subject_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TAGS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Tags_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AIBuildMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AIBuildState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AIChoices_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AICHOICES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPrompt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES3", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AIPromptChoices4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AIPROMPTCHOICES4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_ModuleTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETAG4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModuleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULETYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSSysReqModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSREQMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysReqModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSREQMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysActorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysActorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACTORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUseCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSECASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUseCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSECASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReqModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReqModelType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQMODELTYPE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Subject_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Tags_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TAGS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysReqModule pSSysReqModule) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysReqModule)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysReqModule pSSysReqModule) throws Exception {
        super.onUpdateParent(pSSysReqModule);
    }

    @Override
    protected void exportCurXmlModel(PSSysReqModule pSSysReqModule, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSREQMODULE");
        if (!bl) {
            pSSysReqModule.setCreateDate(null);
            pSSysReqModule.setCreateMan(null);
            pSSysReqModule.setPSSysReqModuleId(null);
            pSSysReqModule.setUpdateDate(null);
            pSSysReqModule.setUpdateMan(null);
            super.exportCurXmlModel(pSSysReqModule, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysReqModule pSSysReqModule, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysReqModule, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSREQMODULE#%1$s", (Object)string);
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQMODULE_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSREQMODULE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSREQMODULENAME", null);
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
        if (StringHelper.compare((String)string, (String)"PSSYSREQMODULE", (boolean)true) == 0) {
            iEntity.set("PPSSYSREQMODULEID", (Object)string2);
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
        return new String[]{"PPSSYSREQMODULEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysReqModule pSSysReqModule) {
        if (!StringHelper.isNullOrEmpty((String)pSSysReqModule.getCodeName())) {
            return pSSysReqModule.getCodeName();
        }
        return super.getModelV2Tag(pSSysReqModule);
    }

    @Override
    public boolean setModelV2Tag(PSSysReqModule pSSysReqModule, String string) {
        pSSysReqModule.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("MODULESN", "");
        map.put("PPSSYSREQMODULEID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysReqModule pSSysReqModule, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysReqModule.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysReqModule, true);
        pSSysReqModule.set("CODENAME", string);
        if (this.select(pSSysReqModule, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysReqModule, true);
        return super.getModelV2Entity(pSSysReqModule, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysReqModule pSSysReqModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysReqModule, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysReqModule pSSysReqModule, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSREQITEM", (Object)pSSysReqModule.getPSSysReqModuleId()))).exists()) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysReqItem();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysReqItemServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysReqItem)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSREQITEM", (Object)((PSSysReqItem)entityBase).getPSSysReqItemId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQMODULE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSREQMODULE", (Object)pSSysReqModule.getPSSysReqModuleId()))).exists()) {
            pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
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
                entityBase = new PSSysReqModule();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysReqModuleServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysReqModule)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSREQMODULE", (Object)((PSSysReqModule)entityBase).getPSSysReqModuleId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysReqModule, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysReqModule pSSysReqModule, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSREQITEM_PSSYSREQMODULE_PSSYSREQMODULEID")) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSREQITEM", (Object)pSSysReqModule.getPSSysReqModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSREQMODULE#%1$s", (Object)pSSysReqModule.getPSSysReqModuleId());
                for (PSSysReqItem item : ((PSSysReqItemServiceBase)pSCoreSysServiceBase).selectByPSSysReqModule(pSSysReqModule)) {
                    String itemScope = ((PSSysReqItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
                    if (StringHelper.compare(scope, itemScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(item, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysreqitemname")) {
                            string = objectNode.get("pssysreqitemname").asText();
                        }
                        if (objectNode2.has("pssysreqitemname")) {
                            string2 = objectNode2.get("pssysreqitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysReqItem item = new PSSysReqItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)item, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(item, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSREQMODULE_PSSYSREQMODULE_PPSSYSREQMODULEID")) {
            pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSREQMODULE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSREQMODULE", (Object)pSSysReqModule.getPSSysReqModuleId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSREQMODULE#%1$s", (Object)pSSysReqModule.getPSSysReqModuleId());
                for (PSSysReqModule module : ((PSSysReqModuleServiceBase)pSCoreSysServiceBase).selectByPPSysReqModule(pSSysReqModule)) {
                    String moduleScope = ((PSSysReqModuleServiceBase)pSCoreSysServiceBase).getModelV2ResScope(module);
                    if (StringHelper.compare(scope, moduleScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(module, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode children = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysreqmodulename")) {
                            string = objectNode.get("pssysreqmodulename").asText();
                        }
                        if (objectNode2.has("pssysreqmodulename")) {
                            string2 = objectNode2.get("pssysreqmodulename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode child : arrayList) {
                    PSSysReqModule module = new PSSysReqModule();
                    PSModelV2Helper.fromJSONObject((IDataObject)module, child, false);
                    children.add((JsonNode)pSCoreSysServiceBase.exportModelV2(module, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysReqModule, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysReqModule pSSysReqModule) throws Exception {
        super.onEmptyModelV2(pSSysReqModule);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysReqModule pSSysReqModule, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysReqItem();
        entityBase.set("PSSYSREQMODULEID", pSSysReqModule.getPSSysReqModuleId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysReqModule();
        entityBase.set("PPSSYSREQMODULEID", pSSysReqModule.getPSSysReqModuleId());
        pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysReqModule, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysReqModule pSSysReqModule, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysReqModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode child = (ObjectNode)arrayNode.get(n2);
                    PSSysReqItem item = new PSSysReqItem();
                    item.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
                    item.setPSSysReqModuleName(pSSysReqModule.getPSSysReqModuleName());
                    pSCoreSysServiceBase.compileModelV2(item, child, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string4);
                if (folder.exists()) {
                    for (File child : folder.listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSysReqItem item = new PSSysReqItem();
                        item.setPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
                        item.setPSSysReqModuleName(pSSysReqModule.getPSSysReqModuleName());
                        pSCoreSysServiceBase.compileModelV2(item, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysReqModuleServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysReqModuleService)ServiceGlobal.getService(PSSysReqModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode child = (ObjectNode)arrayNode.get(n2);
                    PSSysReqModule module = new PSSysReqModule();
                    module.setPPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
                    module.setPPSSysReqModuleName(pSSysReqModule.getPSSysReqModuleName());
                    pSCoreSysServiceBase.compileModelV2(module, child, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string5);
                if (folder.exists()) {
                    for (File child : folder.listFiles()) {
                        if (!child.isDirectory()) continue;
                        PSSysReqModule module = new PSSysReqModule();
                        module.setPPSSysReqModuleId(pSSysReqModule.getPSSysReqModuleId());
                        module.setPPSSysReqModuleName(pSSysReqModule.getPSSysReqModuleName());
                        pSCoreSysServiceBase.compileModelV2(module, null, string, child.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysReqModule, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysReqModule pSSysReqModule, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSSysReqModule, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSSysReqModule pSSysReqModule, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSSysReqModule, list);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysReqModule pSSysReqModule, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "ReqMod");
        defaultValueMap.put("PSSYSREQMODULENAME", "\u9700\u6c42\u6a21\u5757");
    }
}
