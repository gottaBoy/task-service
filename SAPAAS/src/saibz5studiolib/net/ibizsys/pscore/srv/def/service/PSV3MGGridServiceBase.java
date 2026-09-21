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
import net.ibizsys.pscore.srv.def.dao.PSV3MGGridDAO;
import net.ibizsys.pscore.srv.def.demodel.PSV3MGGridDEModel;
import net.ibizsys.pscore.srv.def.entity.PSV3MGGrid;
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.entity.PSV3MigrateBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MGGridServiceBase
extends PSCoreSysServiceBase<PSV3MGGrid> {
    private static final Log log = LogFactory.getLog(PSV3MGGridServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSV3MGGridDEModel pSV3MGGridDEModel;
    private PSV3MGGridDAO pSV3MGGridDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSV3MGGridService";
    }

    public PSV3MGGridDEModel getPSV3MGGridDEModel() {
        if (this.pSV3MGGridDEModel == null) {
            try {
                this.pSV3MGGridDEModel = (PSV3MGGridDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSV3MGGridDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGGridDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSV3MGGridDEModel();
    }

    public PSV3MGGridDAO getPSV3MGGridDAO() {
        if (this.pSV3MGGridDAO == null) {
            try {
                this.pSV3MGGridDAO = (PSV3MGGridDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSV3MGGridDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSV3MGGridDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSV3MGGridDAO();
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

    protected void onFillParentInfo(PSV3MGGrid pSV3MGGrid, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSV3MGGRID_PSV3MIGRATE_PSV3MIGRATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MigrateService", (SessionFactory)this.getSessionFactory());
            PSV3Migrate pSV3Migrate = (PSV3Migrate)iService.getDEModel().createEntity();
            pSV3Migrate.set("PSV3MIGRATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSV3Migrate);
            } else {
                iService.get((IEntity)pSV3Migrate);
            }
            this.onFillParentInfo_Psv3migrate(pSV3MGGrid, pSV3Migrate);
            return;
        }
        super.onFillParentInfo((IEntity)pSV3MGGrid, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psv3migrate(PSV3MGGrid pSV3MGGrid, PSV3Migrate pSV3Migrate) throws Exception {
        pSV3MGGrid.setPSV3MigrateId(pSV3Migrate.getPSV3MigrateId());
        pSV3MGGrid.setPSV3MigrateName(pSV3Migrate.getPSV3MigrateName());
    }

    protected void onFillEntityFullInfo(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSV3MGGrid, bl);
        this.onFillEntityFullInfo_Psv3migrate(pSV3MGGrid, bl);
    }

    protected void onFillEntityFullInfo_Psv3migrate(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSV3MGGrid, bl);
    }

    public ArrayList<PSV3MGGrid> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, "", -1);
    }

    public ArrayList<PSV3MGGrid> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string) throws Exception {
        return this.selectByPsv3migrate(pSV3MigrateBase, string, -1);
    }

    public ArrayList<PSV3MGGrid> selectByPsv3migrate(PSV3MigrateBase pSV3MigrateBase, String string, int n) throws Exception {
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

    public void testRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    public void resetPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MGGrid> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        for (PSV3MGGrid pSV3MGGrid : arrayList) {
            PSV3MGGrid pSV3MGGrid2 = (PSV3MGGrid)this.getDEModel().createEntity();
            pSV3MGGrid2.setPSV3MGGridId(pSV3MGGrid.getPSV3MGGridId());
            pSV3MGGrid2.setPSV3MigrateId(null);
            this.update(pSV3MGGrid2);
        }
    }

    public void removeByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        final PSV3Migrate pSV3Migrate2 = pSV3Migrate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSV3MGGridServiceBase.this.onBeforeRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MGGridServiceBase.this.internalRemoveByPsv3migrate(pSV3Migrate2);
                PSV3MGGridServiceBase.this.onAfterRemoveByPsv3migrate(pSV3Migrate2);
            }
        });
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void internalRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
        ArrayList<PSV3MGGrid> arrayList = this.selectByPsv3migrate(pSV3Migrate);
        this.onBeforeRemoveByPsv3migrate(pSV3Migrate, arrayList);
        for (PSV3MGGrid pSV3MGGrid : arrayList) {
            this.remove((IEntity)pSV3MGGrid);
        }
        this.onAfterRemoveByPsv3migrate(pSV3Migrate, arrayList);
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate) throws Exception {
    }

    protected void onBeforeRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MGGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsv3migrate(PSV3Migrate pSV3Migrate, ArrayList<PSV3MGGrid> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSV3MGGrid pSV3MGGrid) throws Exception {
        super.onBeforeRemove(pSV3MGGrid);
    }

    protected void replaceParentInfo(PSV3MGGrid pSV3MGGrid, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSV3MGGrid, cloneSession);
        if (pSV3MGGrid.getPSV3MigrateId() != null && (iEntity = cloneSession.getEntity("PSV3MIGRATE", (Object)pSV3MGGrid.getPSV3MigrateId())) != null) {
            this.onFillParentInfo_Psv3migrate(pSV3MGGrid, (PSV3Migrate)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSV3MGGrid, bl);
    }

    protected void onCheckEntity(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEGRIDID(bl, pSV3MGGrid, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEID(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEName(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreFlag(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MGGridId(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MGGridName(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSV3MigrateId(bl, pSV3MGGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSV3MGGrid, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEGRIDID(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isDEGRIDIDDirty() && !bl2 : !pSV3MGGrid.isDEGRIDIDDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getDEGRIDID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEGRIDID_Default((IEntity)pSV3MGGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEID(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isDEIDDirty() && !bl2 : !pSV3MGGrid.isDEIDDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getDEID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEID_Default((IEntity)pSV3MGGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_DEName(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isDENameDirty() && !bl2 : !pSV3MGGrid.isDENameDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEName_Default((IEntity)pSV3MGGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreFlag(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isIgnoreFlagDirty() : !pSV3MGGrid.isIgnoreFlagDirty()) {
            return null;
        }
        Integer n = pSV3MGGrid.getIgnoreFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreFlag_Default((IEntity)pSV3MGGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MGGridId(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isPSV3MGGridIdDirty() && !bl2 : !pSV3MGGrid.isPSV3MGGridIdDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getPSV3MGGridId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MGGridId_Default((IEntity)pSV3MGGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MGGridName(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isPSV3MGGridNameDirty() && !bl2 : !pSV3MGGrid.isPSV3MGGridNameDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getPSV3MGGridName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGGRIDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MGGridName_Default((IEntity)pSV3MGGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MGGRIDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSV3MigrateId(boolean bl, PSV3MGGrid pSV3MGGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSV3MGGrid.isPSV3MigrateIdDirty() && !bl2 : !pSV3MGGrid.isPSV3MigrateIdDirty()) {
            return null;
        }
        String string = pSV3MGGrid.getPSV3MigrateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSV3MIGRATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSV3MigrateId_Default((IEntity)pSV3MGGrid, bl2, bl3);
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

    protected void onSyncEntity(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSV3MGGrid, bl);
    }

    protected void onSyncIndexEntities(PSV3MGGrid pSV3MGGrid, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSV3MGGrid, bl);
    }

    public Object getDataContextValue(PSV3MGGrid pSV3MGGrid, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSV3MGGrid, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSV3MGGrid pSV3MGGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSV3MGGrid, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEGRIDID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MGGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MGGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSV3MGGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSV3MGGridName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEGRIDID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEGRIDID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_DEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSV3MGGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MGGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSV3MGGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSV3MGGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSV3MGGrid pSV3MGGrid) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSV3MGGrid)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSV3MGGrid pSV3MGGrid) throws Exception {
        super.onUpdateParent((IEntity)pSV3MGGrid);
    }

    @Override
    protected void exportCurXmlModel(PSV3MGGrid pSV3MGGrid, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSV3MGGRID");
        if (!bl) {
            pSV3MGGrid.setCreateDate(null);
            pSV3MGGrid.setCreateMan(null);
            pSV3MGGrid.setPSV3MGGridId(null);
            pSV3MGGrid.setUpdateDate(null);
            pSV3MGGrid.setUpdateMan(null);
            super.exportCurXmlModel(pSV3MGGrid, xmlNode, bl);
        }
    }
}

