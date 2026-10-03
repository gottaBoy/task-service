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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUseCaseCatDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUseCaseCatDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUseCaseCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUseCaseCatServiceBase
extends PSCoreSysServiceBase<PSSysUseCaseCat> {
    private static final Log log = LogFactory.getLog(PSSysUseCaseCatServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysUseCaseCatDEModel pSSysUseCaseCatDEModel;
    private PSSysUseCaseCatDAO pSSysUseCaseCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUseCaseCatService";
    }

    public PSSysUseCaseCatDEModel getPSSysUseCaseCatDEModel() {
        if (this.pSSysUseCaseCatDEModel == null) {
            try {
                this.pSSysUseCaseCatDEModel = (PSSysUseCaseCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUseCaseCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUseCaseCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUseCaseCatDEModel();
    }

    public PSSysUseCaseCatDAO getPSSysUseCaseCatDAO() {
        if (this.pSSysUseCaseCatDAO == null) {
            try {
                this.pSSysUseCaseCatDAO = (PSSysUseCaseCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUseCaseCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUseCaseCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUseCaseCatDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysUseCaseCat pSSysUseCaseCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSECASECAT_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysUseCaseCat, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSECASECAT_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysUseCaseCat, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysUseCaseCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModule(PSSysUseCaseCat pSSysUseCaseCat, PSModule pSModule) throws Exception {
        pSSysUseCaseCat.setPSModuleId(pSModule.getPSModuleId());
        pSSysUseCaseCat.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSystem(PSSysUseCaseCat pSSysUseCaseCat, PSSystem pSSystem) throws Exception {
        pSSysUseCaseCat.setPSSystemId(pSSystem.getPSSystemId());
        pSSysUseCaseCat.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        if (bl && pSSysUseCaseCat.getCodeName() == null) {
            pSSysUseCaseCat.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "UseCaseCat", 25));
        }
        super.onFillEntityFullInfo(pSSysUseCaseCat, bl);
        this.onFillEntityFullInfo_PSModule(pSSysUseCaseCat, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysUseCaseCat, bl);
    }

    protected void onFillEntityFullInfo_PSModule(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        if (pSSysUseCaseCat.isPSSystemIdDirty()) {
            if (pSSysUseCaseCat.getPSSystemId() != null) {
                if (pSSysUseCaseCat.getPSSystemId() == null || pSSysUseCaseCat.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysUseCaseCat.getPSSystem();
                    pSSysUseCaseCat.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysUseCaseCat.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysUseCaseCat, bl);
    }

    public ArrayList<PSSysUseCaseCat> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysUseCaseCat> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysUseCaseCat> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysUseCaseCat> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysUseCaseCat> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysUseCaseCat> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUseCaseCat> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSECASECAT_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSUSECASECAT", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUseCaseCat> arrayList = this.selectByPSModule(pSModule);
        for (PSSysUseCaseCat pSSysUseCaseCat : arrayList) {
            PSSysUseCaseCat pSSysUseCaseCat2 = (PSSysUseCaseCat)this.getDEModel().createEntity();
            pSSysUseCaseCat2.setPSSysUseCaseCatId(pSSysUseCaseCat.getPSSysUseCaseCatId());
            pSSysUseCaseCat2.setPSModuleId(null);
            this.update(pSSysUseCaseCat2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUseCaseCatServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysUseCaseCatServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysUseCaseCatServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysUseCaseCat> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysUseCaseCat pSSysUseCaseCat : arrayList) {
            this.remove(pSSysUseCaseCat);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUseCaseCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysUseCaseCat> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUseCaseCat> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysUseCaseCat pSSysUseCaseCat : arrayList) {
            PSSysUseCaseCat pSSysUseCaseCat2 = (PSSysUseCaseCat)this.getDEModel().createEntity();
            pSSysUseCaseCat2.setPSSysUseCaseCatId(pSSysUseCaseCat.getPSSysUseCaseCatId());
            pSSysUseCaseCat2.setPSSystemId(null);
            this.update(pSSysUseCaseCat2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUseCaseCatServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysUseCaseCatServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysUseCaseCatServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysUseCaseCat> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysUseCaseCat pSSysUseCaseCat : arrayList) {
            this.remove(pSSysUseCaseCat);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUseCaseCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysUseCaseCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUseCaseCat pSSysUseCaseCat) throws Exception {
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        pSSysUserCaseService.testRemoveByPSSysUseCaseCat(pSSysUseCaseCat);
        super.onBeforeRemove(pSSysUseCaseCat);
    }

    protected void replaceParentInfo(PSSysUseCaseCat pSSysUseCaseCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysUseCaseCat, cloneSession);
        if (pSSysUseCaseCat.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysUseCaseCat.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysUseCaseCat, (PSModule)iEntity);
        }
        if (pSSysUseCaseCat.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysUseCaseCat.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysUseCaseCat, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysUseCaseCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CatSN(bl, pSSysUseCaseCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatTag(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatTag2(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUseCaseCatId(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUseCaseCatName(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Tags(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUseCaseCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysUseCaseCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CatSN(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isCatSNDirty() : !pSSysUseCaseCat.isCatSNDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getCatSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatSN_Default(pSSysUseCaseCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CatTag(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isCatTagDirty() : !pSSysUseCaseCat.isCatTagDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getCatTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag_Default(pSSysUseCaseCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CatTag2(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isCatTag2Dirty() : !pSSysUseCaseCat.isCatTag2Dirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getCatTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag2_Default(pSSysUseCaseCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isCodeNameDirty() && !bl2 : !pSSysUseCaseCat.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysUseCaseCat, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysUseCaseCatDEModel(), "CODENAME", string3, pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isContentDirty() : !pSSysUseCaseCat.isContentDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isMemoDirty() : !pSSysUseCaseCat.isMemoDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isOrderValueDirty() : !pSSysUseCaseCat.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysUseCaseCat.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isPSModuleIdDirty() : !pSSysUseCaseCat.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isPSSystemIdDirty() : !pSSysUseCaseCat.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isPSSystemNameDirty() : !pSSysUseCaseCat.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUseCaseCatId(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isPSSysUseCaseCatIdDirty() && !bl2 : !pSSysUseCaseCat.isPSSysUseCaseCatIdDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getPSSysUseCaseCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSECASECATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUseCaseCatId_Default(pSSysUseCaseCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSECASECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUseCaseCatName(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isPSSysUseCaseCatNameDirty() && !bl2 : !pSSysUseCaseCat.isPSSysUseCaseCatNameDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getPSSysUseCaseCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSECASECATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUseCaseCatName_Default(pSSysUseCaseCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSECASECATNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysUseCaseCatDEModel(), "PSSYSUSECASECATNAME", string3, pSSysUseCaseCat, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSUSECASECATNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Tags(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isTagsDirty() : !pSSysUseCaseCat.isTagsDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getTags();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Tags_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isUserCatDirty() : !pSSysUseCaseCat.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isUserTagDirty() : !pSSysUseCaseCat.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isUserTag2Dirty() : !pSSysUseCaseCat.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isUserTag3Dirty() : !pSSysUseCaseCat.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUseCaseCat pSSysUseCaseCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUseCaseCat.isUserTag4Dirty() : !pSSysUseCaseCat.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUseCaseCat.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysUseCaseCat, bl2, bl3);
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

    protected void onSyncEntity(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        super.onSyncEntity(pSSysUseCaseCat, bl);
    }

    protected void onSyncIndexEntities(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysUseCaseCat, bl);
    }

    public Object getDataContextValue(PSSysUseCaseCat pSSysUseCaseCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysUseCaseCat, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUseCaseCat pSSysUseCaseCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysUseCaseCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CATSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSUSECASECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUseCaseCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSECASECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUseCaseCatName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CatSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysUseCaseCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSECASECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUseCaseCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSECASECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysUseCaseCat pSSysUseCaseCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysUseCaseCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUseCaseCat pSSysUseCaseCat) throws Exception {
        super.onUpdateParent(pSSysUseCaseCat);
    }

    @Override
    protected void exportCurXmlModel(PSSysUseCaseCat pSSysUseCaseCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUSECASECAT");
        if (!bl) {
            pSSysUseCaseCat.setCreateDate(null);
            pSSysUseCaseCat.setCreateMan(null);
            pSSysUseCaseCat.setPSSysUseCaseCatId(null);
            pSSysUseCaseCat.setUpdateDate(null);
            pSSysUseCaseCat.setUpdateMan(null);
            super.exportCurXmlModel(pSSysUseCaseCat, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUseCaseCat pSSysUseCaseCat, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUseCaseCat, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSECASECAT_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSECASECAT_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
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
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysUseCaseCat pSSysUseCaseCat) {
        if (!StringHelper.isNullOrEmpty((String)pSSysUseCaseCat.getCodeName())) {
            return pSSysUseCaseCat.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUseCaseCat.getPSSysUseCaseCatName())) {
            return pSSysUseCaseCat.getPSSysUseCaseCatName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysUseCaseCat.getCodeName())) {
            return pSSysUseCaseCat.getCodeName();
        }
        return super.getModelV2Tag(pSSysUseCaseCat);
    }

    @Override
    public boolean setModelV2Tag(PSSysUseCaseCat pSSysUseCaseCat, String string) {
        pSSysUseCaseCat.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSUSECASECATNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSUSECASECATNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUseCaseCat pSSysUseCaseCat, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUseCaseCat.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUseCaseCat, true);
        pSSysUseCaseCat.set("CODENAME", string);
        if (this.select(pSSysUseCaseCat, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysUseCaseCat, true);
        return super.getModelV2Entity(pSSysUseCaseCat, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUseCaseCat pSSysUseCaseCat, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysUseCaseCat, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSUSERCASE_PSSYSUSECASECAT_PSSYSUSECASECATID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysUseCaseCat pSSysUseCaseCat, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSUSERCASE_PSSYSUSECASECAT_PSSYSUSECASECATID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSUSECASECAT#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSUSERCASE", (Object)pSSysUseCaseCat.getPSSysUseCaseCatId()))).exists()) {
            PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysUserCaseService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysUserCase, objectNode, false);
                String string6 = pSSysUserCaseService.getModelV2Tag(pSSysUserCase);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSUSERCASE", (Object)pSSysUserCase.getPSSysUserCaseId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysUserCaseService.exportModelV2(pSSysUserCase, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysUseCaseCat, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysUseCaseCat pSSysUseCaseCat, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSUSERCASE_PSSYSUSECASECAT_PSSYSUSECASECATID")) {
            PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSUSECASECAT#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSUSERCASE", (Object)pSSysUseCaseCat.getPSSysUseCaseCatId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSUSECASECAT#%1$s", (Object)pSSysUseCaseCat.getPSSysUseCaseCatId());
                for (PSSysUserCase useCase : pSSysUserCaseService.selectByPSSysUseCaseCat(pSSysUseCaseCat)) {
                    String useCaseScope = pSSysUserCaseService.getModelV2ResScope(useCase);
                    if (StringHelper.compare((String)scope, (String)useCaseScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(useCase, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSSysUserCaseService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysusercasename")) {
                            string = objectNode.get("pssysusercasename").asText();
                        }
                        if (objectNode2.has("pssysusercasename")) {
                            string2 = objectNode2.get("pssysusercasename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode useCaseNode : arrayList) {
                    PSSysUserCase useCase = new PSSysUserCase();
                    PSModelV2Helper.fromJSONObject((IDataObject)useCase, useCaseNode, false);
                    output.add((JsonNode)pSSysUserCaseService.exportModelV2(useCase, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysUseCaseCat, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysUseCaseCat pSSysUseCaseCat) throws Exception {
        super.onEmptyModelV2(pSSysUseCaseCat);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysUserCaseService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysUseCaseCat pSSysUseCaseCat, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysUserCase pSSysUserCase = new PSSysUserCase();
        pSSysUserCase.set("PSSYSUSECASECATID", pSSysUseCaseCat.getPSSysUseCaseCatId());
        PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysUserCaseService.getModelV2Entity(pSSysUserCase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysUseCaseCat, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysUseCaseCat pSSysUseCaseCat, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysUseCaseCatServiceBase.isSimpleImportExportMode("")) {
            PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysUserCaseService.getModelV2Name(null, false);
            if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"pssysusecases");
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysUserCase pSSysUserCase = new PSSysUserCase();
                    pSSysUserCase.setPSSysUseCaseCatId(pSSysUseCaseCat.getPSSysUseCaseCatId());
                    pSSysUserCase.setPSSysUseCaseCatName(pSSysUseCaseCat.getPSSysUseCaseCatName());
                    pSSysUserCaseService.compileModelV2(pSSysUserCase, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (!file.exists()) {
                    string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSSYSUSECASES");
                    file = new File(string4);
                }
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysUserCase pSSysUserCase = new PSSysUserCase();
                        pSSysUserCase.setPSSysUseCaseCatId(pSSysUseCaseCat.getPSSysUseCaseCatId());
                        pSSysUserCase.setPSSysUseCaseCatName(pSSysUseCaseCat.getPSSysUseCaseCatName());
                        pSSysUserCaseService.compileModelV2(pSSysUserCase, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysUseCaseCat, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysUseCaseCat pSSysUseCaseCat, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSUSERCASE_PSSYSUSECASECAT_PSSYSUSECASECATID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysUseCases(pSSysUseCaseCat, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysUseCaseCat, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysUseCases(PSSysUseCaseCat pSSysUseCaseCat, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUSERCASE", true), (boolean)false) == 0) {
            PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = new PSSysUserCase();
            pSSysUserCase.setPSSysUserCaseId(pSMOSFile.getPSModelId());
            if (!pSSysUserCaseService.get(pSSysUserCase, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysUserCase.getPSSysUseCaseCatId(), (String)pSSysUseCaseCat.getPSSysUseCaseCatId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysUserCaseService.exportModelV2(pSSysUserCase);
            pSSysUserCase.reset();
            if (!pSSysUserCaseService.setModelV2ResScope(pSSysUserCase, "PSSYSUSECASECAT", pSSysUseCaseCat.getPSSysUseCaseCatId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysUserCaseService.importModelV2(pSSysUserCase, objectNode);
            SessionFactoryManager.commit();
            return pSSysUserCaseService.getFile(pSSysUserCase);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysUseCaseCat pSSysUseCaseCat, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysUseCases(pSSysUseCaseCat, list);
        super.onFillPasteHelps(pSSysUseCaseCat, list);
    }

    protected void onFillPasteHelps_PSSysUseCases(PSSysUseCaseCat pSSysUseCaseCat, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSUSERCASE");
        pSHelpSection.setSectionParam2("DER1N_PSSYSUSERCASE_PSSYSUSECASECAT_PSSYSUSECASECATID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u7528\u4f8b\u5206\u7c7b]\u7684[\u7cfb\u7edf\u7528\u4f8b]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysUseCaseCat pSSysUseCaseCat, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "UseCaseCat");
    }
}
