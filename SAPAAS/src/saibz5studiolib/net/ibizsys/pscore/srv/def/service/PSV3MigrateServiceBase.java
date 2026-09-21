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
package net.ibizsys.pscore.srv.def.service;

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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.def.dao.PSV3MigrateDAO;
import net.ibizsys.pscore.srv.def.demodel.PSV3MigrateDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.service.PSV3MGFormService;
import net.ibizsys.pscore.srv.def.service.PSV3MGFormServiceBase;
import net.ibizsys.pscore.srv.def.service.PSV3MGGridService;
import net.ibizsys.pscore.srv.def.service.PSV3MGGridServiceBase;
import net.ibizsys.pscore.srv.def.service.PSV3MGViewService;
import net.ibizsys.pscore.srv.def.service.PSV3MGViewServiceBase;
import net.ibizsys.pscore.srv.def.service.PSV3MigrateDEService;
import net.ibizsys.pscore.srv.def.service.PSV3MigrateDEServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MigrateServiceBase
extends PSCoreSysServiceBase<PSV3Migrate> {
    private static final Log log = LogFactory.getLog(PSV3MigrateServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSV3MigrateDEModel pSV3MigrateDEModel;
    private PSV3MigrateDAO pSV3MigrateDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSV3MigrateService";
    }

    public PSV3MigrateDEModel getPSV3MigrateDEModel() {
        if (this.pSV3MigrateDEModel == null) {
            try {
                this.pSV3MigrateDEModel = (PSV3MigrateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MigrateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MigrateDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSV3MigrateDEModel();
    }

    public PSV3MigrateDAO getPSV3MigrateDAO() {
        if (this.pSV3MigrateDAO == null) {
            try {
                this.pSV3MigrateDAO = (PSV3MigrateDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSV3MigrateDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MigrateDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSV3MigrateDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSV3Migrate pSV3Migrate, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MIGRATE_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_Psmodule(pSV3Migrate, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MIGRATE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_Pssystem(pSV3Migrate, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSV3Migrate, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psmodule(PSV3Migrate pSV3Migrate, PSModule pSModule) throws Exception {
        pSV3Migrate.setPSModuleId(pSModule.getPSModuleId());
        pSV3Migrate.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_Pssystem(PSV3Migrate pSV3Migrate, PSSystem pSSystem) throws Exception {
        pSV3Migrate.setPSSystemId(pSSystem.getPSSystemId());
        pSV3Migrate.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSV3Migrate, bl);
        this.onFillEntityFullInfo_Psmodule(pSV3Migrate, bl);
        this.onFillEntityFullInfo_Pssystem(pSV3Migrate, bl);
    }

    protected void onFillEntityFullInfo_Psmodule(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssystem(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSV3Migrate, bl);
    }

    public ArrayList<PSV3Migrate> selectByPsmodule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPsmodule(pSModuleBase, "", -1);
    }

    public ArrayList<PSV3Migrate> selectByPsmodule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPsmodule(pSModuleBase, string, -1);
    }

    public ArrayList<PSV3Migrate> selectByPsmodule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmoduleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmoduleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSV3Migrate> selectByPssystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPssystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSV3Migrate> selectByPssystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPssystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSV3Migrate> selectByPssystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsmodule(PSModule pSModule) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPsmodule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSV3MIGRATE_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSV3MIGRATE", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPsmodule(PSModule pSModule) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPsmodule(pSModule);
        for (PSV3Migrate pSV3Migrate : arrayList) {
            PSV3Migrate pSV3Migrate2 = (PSV3Migrate)this.getDEModel().createEntity();
            pSV3Migrate2.setPSV3MigrateId(pSV3Migrate.getPSV3MigrateId());
            pSV3Migrate2.setPSModuleId(null);
            this.update(pSV3Migrate2);
        }
    }

    public void removeByPsmodule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MigrateServiceBase.this.onBeforeRemoveByPsmodule(pSModule2);
                PSV3MigrateServiceBase.this.internalRemoveByPsmodule(pSModule2);
                PSV3MigrateServiceBase.this.onAfterRemoveByPsmodule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPsmodule(PSModule pSModule) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPsmodule(pSModule);
        this.onBeforeRemoveByPsmodule(pSModule, arrayList);
        for (PSV3Migrate pSV3Migrate : arrayList) {
            this.remove((IEntity)pSV3Migrate);
        }
        this.onAfterRemoveByPsmodule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPsmodule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPsmodule(PSModule pSModule, ArrayList<PSV3Migrate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodule(PSModule pSModule, ArrayList<PSV3Migrate> arrayList) throws Exception {
    }

    public void testRemoveByPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPssystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSV3MIGRATE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSV3MIGRATE", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPssystem(pSSystem);
        for (PSV3Migrate pSV3Migrate : arrayList) {
            PSV3Migrate pSV3Migrate2 = (PSV3Migrate)this.getDEModel().createEntity();
            pSV3Migrate2.setPSV3MigrateId(pSV3Migrate.getPSV3MigrateId());
            pSV3Migrate2.setPSSystemId(null);
            this.update(pSV3Migrate2);
        }
    }

    public void removeByPssystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MigrateServiceBase.this.onBeforeRemoveByPssystem(pSSystem2);
                PSV3MigrateServiceBase.this.internalRemoveByPssystem(pSSystem2);
                PSV3MigrateServiceBase.this.onAfterRemoveByPssystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSV3Migrate> arrayList = this.selectByPssystem(pSSystem);
        this.onBeforeRemoveByPssystem(pSSystem, arrayList);
        for (PSV3Migrate pSV3Migrate : arrayList) {
            this.remove((IEntity)pSV3Migrate);
        }
        this.onAfterRemoveByPssystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem, ArrayList<PSV3Migrate> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem, ArrayList<PSV3Migrate> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSV3Migrate pSV3Migrate) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSV3MGFormService)ServiceGlobal.getService(PSV3MGFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSV3MGFormServiceBase)pSCoreSysServiceBase).testRemoveByPsv3migrate(pSV3Migrate);
        ((PSV3MGFormServiceBase)pSCoreSysServiceBase).removeByPsv3migrate(pSV3Migrate);
        pSCoreSysServiceBase = (PSV3MGGridService)ServiceGlobal.getService(PSV3MGGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSV3MGGridServiceBase)pSCoreSysServiceBase).testRemoveByPsv3migrate(pSV3Migrate);
        ((PSV3MGGridServiceBase)pSCoreSysServiceBase).removeByPsv3migrate(pSV3Migrate);
        pSCoreSysServiceBase = (PSV3MGViewService)ServiceGlobal.getService(PSV3MGViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSV3MGViewServiceBase)pSCoreSysServiceBase).testRemoveByPsv3migrate(pSV3Migrate);
        ((PSV3MGViewServiceBase)pSCoreSysServiceBase).removeByPsv3migrate(pSV3Migrate);
        pSCoreSysServiceBase = (PSV3MigrateDEService)ServiceGlobal.getService(PSV3MigrateDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSV3MigrateDEServiceBase)pSCoreSysServiceBase).testRemoveByPsv3migrate(pSV3Migrate);
        ((PSV3MigrateDEServiceBase)pSCoreSysServiceBase).removeByPsv3migrate(pSV3Migrate);
        super.onBeforeRemove(pSV3Migrate);
    }

    protected void replaceParentInfo(PSV3Migrate pSV3Migrate, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSV3Migrate, cloneSession);
        if (pSV3Migrate.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSV3Migrate.getPSModuleId())) != null) {
            this.onFillParentInfo_Psmodule(pSV3Migrate, (PSModule)iEntity);
        }
        if (pSV3Migrate.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSV3Migrate.getPSSystemId())) != null) {
            this.onFillParentInfo_Pssystem(pSV3Migrate, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSV3Migrate, bl);
    }

    protected void onCheckEntity(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEIDPREFIX(bl, pSV3Migrate, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DENamePREFIX(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExcludeIDS(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExcludeNameS(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateId(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateName(bl, pSV3Migrate, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSV3Migrate, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEIDPREFIX(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isDEIDPREFIXDirty() : !pSV3Migrate.isDEIDPREFIXDirty()) {
            return null;
        }
        String string = pSV3Migrate.getDEIDPREFIX();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEIDPREFIX_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEIDPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DENamePREFIX(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isDENamePREFIXDirty() : !pSV3Migrate.isDENamePREFIXDirty()) {
            return null;
        }
        String string = pSV3Migrate.getDENamePREFIX();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DENamePREFIX_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAMEPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExcludeIDS(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isExcludeIDSDirty() : !pSV3Migrate.isExcludeIDSDirty()) {
            return null;
        }
        String string = pSV3Migrate.getExcludeIDS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExcludeIDS_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCLUDEIDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExcludeNameS(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isExcludeNameSDirty() : !pSV3Migrate.isExcludeNameSDirty()) {
            return null;
        }
        String string = pSV3Migrate.getExcludeNameS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExcludeNameS_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXCLUDENAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isMemoDirty() : !pSV3Migrate.isMemoDirty()) {
            return null;
        }
        String string = pSV3Migrate.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSV3Migrate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isPSModuleIdDirty() && !bl2 : !pSV3Migrate.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSV3Migrate.getPSModuleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSV3Migrate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isPSSystemIdDirty() && !bl2 : !pSV3Migrate.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSV3Migrate.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSV3Migrate, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSV3MigrateId(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isPSV3MigrateIdDirty() && !bl2 : !pSV3Migrate.isPSV3MigrateIdDirty()) {
            return null;
        }
        String string = pSV3Migrate.getPSV3MigrateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateId_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MigrateName(boolean bl, PSV3Migrate pSV3Migrate, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3Migrate.isPSV3MigrateNameDirty() && !bl2 : !pSV3Migrate.isPSV3MigrateNameDirty()) {
            return null;
        }
        String string = pSV3Migrate.getPSV3MigrateName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateName_Default((IEntity)pSV3Migrate, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSV3Migrate, bl);
    }

    protected void onSyncIndexEntities(PSV3Migrate pSV3Migrate, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSV3Migrate, bl);
    }

    public Object getDataContextValue(PSV3Migrate pSV3Migrate, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSV3Migrate, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSV3Migrate pSV3Migrate, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSV3Migrate, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEIDPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEIDPREFIX_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DENAMEPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DENamePREFIX_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCLUDEIDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExcludeIDS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXCLUDENAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExcludeNameS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEIDPREFIX_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEIDPREFIX", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DENamePREFIX_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAMEPREFIX", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExcludeIDS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCLUDEIDS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExcludeNameS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXCLUDENAMES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_PSV3MigrateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MigrateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSV3Migrate pSV3Migrate) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSV3Migrate)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSV3Migrate pSV3Migrate) throws Exception {
        super.onUpdateParent((IEntity)pSV3Migrate);
    }

    @Override
    protected void exportCurXmlModel(PSV3Migrate pSV3Migrate, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSV3MIGRATE");
        if (!bl) {
            pSV3Migrate.setCreateDate(null);
            pSV3Migrate.setCreateMan(null);
            pSV3Migrate.setPSV3MigrateId(null);
            pSV3Migrate.setUpdateDate(null);
            pSV3Migrate.setUpdateMan(null);
            super.exportCurXmlModel(pSV3Migrate, xmlNode, bl);
        }
    }
}

