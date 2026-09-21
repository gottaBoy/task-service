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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.def.dao.PSV3MigrateDEDAO;
import net.ibizsys.pscore.srv.def.demodel.PSV3MigrateDEDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.entity.PSV3MigrateBase;
import net.ibizsys.pscore.srv.def.entity.PSV3MigrateDE;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MigrateDEServiceBase
extends PSCoreSysServiceBase<PSV3MigrateDE> {
    private static final Log log = LogFactory.getLog(PSV3MigrateDEServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSV3MigrateDEDEModel pSV3MigrateDEDEModel;
    private PSV3MigrateDEDAO pSV3MigrateDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSV3MigrateDEService";
    }

    public PSV3MigrateDEDEModel getPSV3MigrateDEDEModel() {
        if (this.pSV3MigrateDEDEModel == null) {
            try {
                this.pSV3MigrateDEDEModel = (PSV3MigrateDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MigrateDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MigrateDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSV3MigrateDEDEModel();
    }

    public PSV3MigrateDEDAO getPSV3MigrateDEDAO() {
        if (this.pSV3MigrateDEDAO == null) {
            try {
                this.pSV3MigrateDEDAO = (PSV3MigrateDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSV3MigrateDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MigrateDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSV3MigrateDEDAO();
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

    protected void onFillParentInfo(PSV3MigrateDE pSV3MigrateDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MIGRATEDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_Psde(pSV3MigrateDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MIGRATEDE_PSV3MIGRATE_PSV3MIGRATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MigrateService", (SessionFactory)this.getSessionFactory());
            PSV3Migrate pSV3Migrate = (PSV3Migrate)iService.getDEModel().createEntity();
            pSV3Migrate.set("PSV3MIGRATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSV3Migrate);
            } else {
                iService.get((IEntity)pSV3Migrate);
            }
            this.onFillParentInfo_Psv3migrate(pSV3MigrateDE, pSV3Migrate);
            return;
        }
        super.onFillParentInfo((IEntity)pSV3MigrateDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psde(PSV3MigrateDE pSV3MigrateDE, PSDataEntity pSDataEntity) throws Exception {
        pSV3MigrateDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSV3MigrateDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_Psv3migrate(PSV3MigrateDE pSV3MigrateDE, PSV3Migrate pSV3Migrate) throws Exception {
        pSV3MigrateDE.setPSSystemId(pSV3Migrate.getPSSystemId());
        pSV3MigrateDE.setPSV3MigrateId(pSV3Migrate.getPSV3MigrateId());
        pSV3MigrateDE.setPSV3MigrateName(pSV3Migrate.getPSV3MigrateName());
    }

    protected void onFillEntityFullInfo(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSV3MigrateDE, bl);
        this.onFillEntityFullInfo_Psde(pSV3MigrateDE, bl);
        this.onFillEntityFullInfo_Psv3migrate(pSV3MigrateDE, bl);
    }

    protected void onFillEntityFullInfo_Psde(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        if (pSV3MigrateDE.isPSDEIdDirty()) {
            if (pSV3MigrateDE.getPSDEId() != null) {
                if (pSV3MigrateDE.getPSDEId() == null || pSV3MigrateDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSV3MigrateDE.getPsde();
                    pSV3MigrateDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSV3MigrateDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psv3migrate(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSV3MigrateDE, bl);
    }

    public ArrayList<PSV3MigrateDE> selectByPsde(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPsde(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSV3MigrateDE> selectByPsde(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPsde(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSV3MigrateDE> selectByPsde(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsdeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsdeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSV3MigrateDE> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, "", -1);
    }

    public ArrayList<PSV3MigrateDE> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, string, -1);
    }

    public ArrayList<PSV3MigrateDE> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSV3MIGRATEID", (Object)pSV3MigrateBase.getPSV3MigrateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsv3migrateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsv3migrateCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsde(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPsde(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSV3MigrateDE> arrayList = this.selectByPsde(pSDataEntity);
        for (PSV3MigrateDE pSV3MigrateDE : arrayList) {
            PSV3MigrateDE pSV3MigrateDE2 = (PSV3MigrateDE)this.getDEModel().createEntity();
            pSV3MigrateDE2.setPSV3MigrateDEId(pSV3MigrateDE.getPSV3MigrateDEId());
            pSV3MigrateDE2.setPSDEId(null);
            this.update(pSV3MigrateDE2);
        }
    }

    public void removeByPsde(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MigrateDEServiceBase.this.onBeforeRemoveByPsde(pSDataEntity2);
                PSV3MigrateDEServiceBase.this.internalRemoveByPsde(pSDataEntity2);
                PSV3MigrateDEServiceBase.this.onAfterRemoveByPsde(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPsde(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPsde(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSV3MigrateDE> arrayList = this.selectByPsde(pSDataEntity);
        this.onBeforeRemoveByPsde(pSDataEntity, arrayList);
        for (PSV3MigrateDE pSV3MigrateDE : arrayList) {
            this.remove((IEntity)pSV3MigrateDE);
        }
        this.onAfterRemoveByPsde(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPsde(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPsde(PSDataEntity pSDataEntity, ArrayList<PSV3MigrateDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsde(PSDataEntity pSDataEntity, ArrayList<PSV3MigrateDE> arrayList) throws Exception {
    }

    public void testRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    public void resetPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MigrateDE> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        for (PSV3MigrateDE pSV3MigrateDE : arrayList) {
            PSV3MigrateDE pSV3MigrateDE2 = (PSV3MigrateDE)this.getDEModel().createEntity();
            pSV3MigrateDE2.setPSV3MigrateDEId(pSV3MigrateDE.getPSV3MigrateDEId());
            pSV3MigrateDE2.setPSV3MigrateId(null);
            this.update(pSV3MigrateDE2);
        }
    }

    public void removeByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        final PSV3Migrate pSV3Migrate2 = pSV3Migrate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MigrateDEServiceBase.this.onBeforeRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MigrateDEServiceBase.this.internalRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MigrateDEServiceBase.this.onAfterRemoveByPsv3migrate(pSV3Migrate2);
            }
        });
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void internalRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MigrateDE> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        this.onBeforeRemoveByPsv3migrate(pSV3Migrate, arrayList);
        for (PSV3MigrateDE pSV3MigrateDE : arrayList) {
            this.remove((IEntity)pSV3MigrateDE);
        }
        this.onAfterRemoveByPsv3migrate(pSV3Migrate, arrayList);
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MigrateDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MigrateDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSV3MigrateDE pSV3MigrateDE) throws Exception {
        super.onBeforeRemove(pSV3MigrateDE);
    }

    protected void replaceParentInfo(PSV3MigrateDE pSV3MigrateDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSV3MigrateDE, cloneSession);
        if (pSV3MigrateDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSV3MigrateDE.getPSDEId())) != null) {
            this.onFillParentInfo_Psde(pSV3MigrateDE, (PSDataEntity)iEntity);
        }
        if (pSV3MigrateDE.getPSV3MigrateId() != null && (iEntity = cloneSession.getEntity("PSV3MIGRATE", (Object)pSV3MigrateDE.getPSV3MigrateId())) != null) {
            this.onFillParentInfo_Psv3migrate(pSV3MigrateDE, (PSV3Migrate)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSV3MigrateDE, bl);
    }

    protected void onCheckEntity(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEID(bl, pSV3MigrateDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSV3MigrateDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSV3MigrateDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateDEId(bl, pSV3MigrateDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateDEName(bl, pSV3MigrateDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateId(bl, pSV3MigrateDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSV3MigrateDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEID(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isDEIDDirty() && !bl2 : !pSV3MigrateDE.isDEIDDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getDEID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEID_Default((IEntity)pSV3MigrateDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isPSDEIdDirty() : !pSV3MigrateDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSV3MigrateDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isPSDENameDirty() : !pSV3MigrateDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSV3MigrateDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSV3MigrateDEId(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isPSV3MigrateDEIdDirty() && !bl2 : !pSV3MigrateDE.isPSV3MigrateDEIdDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getPSV3MigrateDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateDEId_Default((IEntity)pSV3MigrateDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MigrateDEName(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isPSV3MigrateDENameDirty() && !bl2 : !pSV3MigrateDE.isPSV3MigrateDENameDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getPSV3MigrateDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateDEName_Default((IEntity)pSV3MigrateDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MigrateId(boolean bl, PSV3MigrateDE pSV3MigrateDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MigrateDE.isPSV3MigrateIdDirty() && !bl2 : !pSV3MigrateDE.isPSV3MigrateIdDirty()) {
            return null;
        }
        String string = pSV3MigrateDE.getPSV3MigrateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateId_Default((IEntity)pSV3MigrateDE, bl2, bl3);
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

    protected void onSyncEntity(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSV3MigrateDE, bl);
    }

    protected void onSyncIndexEntities(PSV3MigrateDE pSV3MigrateDE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSV3MigrateDE, bl);
    }

    public Object getDataContextValue(PSV3MigrateDE pSV3MigrateDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSV3MigrateDE, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSV3MigrateDE pSV3MigrateDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSV3MigrateDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATEDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MIGRATEDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MigrateDEName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSV3MigrateDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATEDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MigrateDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MIGRATEDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSV3MigrateDE pSV3MigrateDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSV3MigrateDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSV3MigrateDE pSV3MigrateDE) throws Exception {
        super.onUpdateParent((IEntity)pSV3MigrateDE);
    }

    @Override
    protected void exportCurXmlModel(PSV3MigrateDE pSV3MigrateDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSV3MIGRATEDE");
        if (!bl) {
            pSV3MigrateDE.setCreateDate(null);
            pSV3MigrateDE.setCreateMan(null);
            pSV3MigrateDE.setPSV3MigrateDEId(null);
            pSV3MigrateDE.setUpdateDate(null);
            pSV3MigrateDE.setUpdateMan(null);
            super.exportCurXmlModel(pSV3MigrateDE, xmlNode, bl);
        }
    }
}

