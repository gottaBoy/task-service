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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSubSysDMDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSubSysDMDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSysDM;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysDMServiceBase
extends PSCoreSysServiceBase<PSSubSysDM> {
    private static final Log log = LogFactory.getLog(PSSubSysDMServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubSysDMDEModel pSSubSysDMDEModel;
    private PSSubSysDMDAO pSSubSysDMDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSubSysDMService";
    }

    public PSSubSysDMDEModel getPSSubSysDMDEModel() {
        if (this.pSSubSysDMDEModel == null) {
            try {
                this.pSSubSysDMDEModel = (PSSubSysDMDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSubSysDMDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysDMDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysDMDEModel();
    }

    public PSSubSysDMDAO getPSSubSysDMDAO() {
        if (this.pSSubSysDMDAO == null) {
            try {
                this.pSSubSysDMDAO = (PSSubSysDMDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSubSysDMDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysDMDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysDMDAO();
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

    protected void onFillParentInfo(PSSubSysDM pSSubSysDM, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSDM_PSSUBSYS_PSSUBSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory());
            PSSubSys pSSubSys = (PSSubSys)iService.getDEModel().createEntity();
            pSSubSys.set("PSSUBSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSys);
            } else {
                iService.get(pSSubSys);
            }
            this.onFillParentInfo_PSSubSys(pSSubSysDM, pSSubSys);
            return;
        }
        super.onFillParentInfo(pSSubSysDM, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSubSys(PSSubSysDM pSSubSysDM, PSSubSys pSSubSys) throws Exception {
        pSSubSysDM.setPSSubSysId(pSSubSys.getPSSubSysId());
        pSSubSysDM.setPSSubSysName(pSSubSys.getPSSubSysName());
    }

    protected void onFillEntityFullInfo(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSubSysDM, bl);
        this.onFillEntityFullInfo_PSSubSys(pSSubSysDM, bl);
    }

    protected void onFillEntityFullInfo_PSSubSys(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        if (pSSubSysDM.isPSSubSysIdDirty()) {
            if (pSSubSysDM.getPSSubSysId() != null) {
                if (pSSubSysDM.getPSSubSysId() == null || pSSubSysDM.getPSSubSysName() == null) {
                    PSSubSys pSSubSys = pSSubSysDM.getPSSubSys();
                    pSSubSysDM.setPSSubSysName(pSSubSys.getPSSubSysName());
                }
            } else {
                pSSubSysDM.setPSSubSysName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        super.onWriteBackParent(pSSubSysDM, bl);
    }

    public ArrayList<PSSubSysDM> selectByPSSubSys(PSSubSysBase pSSubSysBase) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, "", -1);
    }

    public ArrayList<PSSubSysDM> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string) throws Exception {
        return this.selectByPSSubSys(pSSubSysBase, string, -1);
    }

    public ArrayList<PSSubSysDM> selectByPSSubSys(PSSubSysBase pSSubSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSID", (Object)pSSubSysBase.getPSSubSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    public void resetPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSubSysDM> arrayList = this.selectByPSSubSys(pSSubSys);
        for (PSSubSysDM pSSubSysDM : arrayList) {
            PSSubSysDM pSSubSysDM2 = (PSSubSysDM)this.getDEModel().createEntity();
            pSSubSysDM2.setPSSubSysDMId(pSSubSysDM.getPSSubSysDMId());
            pSSubSysDM2.setPSSubSysId(null);
            this.update(pSSubSysDM2);
        }
    }

    public void removeByPSSubSys(PSSubSys pSSubSys) throws Exception {
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysDMServiceBase.this.onBeforeRemoveByPSSubSys(pSSubSys2);
                PSSubSysDMServiceBase.this.internalRemoveByPSSubSys(pSSubSys2);
                PSSubSysDMServiceBase.this.onAfterRemoveByPSSubSys(pSSubSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void internalRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSSubSysDM> arrayList = this.selectByPSSubSys(pSSubSys);
        this.onBeforeRemoveByPSSubSys(pSSubSys, arrayList);
        for (PSSubSysDM pSSubSysDM : arrayList) {
            this.remove(pSSubSysDM);
        }
        this.onAfterRemoveByPSSubSys(pSSubSys, arrayList);
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSubSysDM> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSys(PSSubSys pSSubSys, ArrayList<PSSubSysDM> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysDM pSSubSysDM) throws Exception {
        super.onBeforeRemove(pSSubSysDM);
    }

    protected void replaceParentInfo(PSSubSysDM pSSubSysDM, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSubSysDM, cloneSession);
        if (pSSubSysDM.getPSSubSysId() != null && (iEntity = cloneSession.getEntity("PSSUBSYS", (Object)pSSubSysDM.getPSSubSysId())) != null) {
            this.onFillParentInfo_PSSubSys(pSSubSysDM, (PSSubSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSubSysDM, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DataSQL(bl, pSSubSysDM, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelSQL(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelSQL2(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelSQL3(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelSQL4(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysDMId(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysDMName(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysId(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysName(bl, pSSubSysDM, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSubSysDM, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DataSQL(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isDataSQLDirty() : !pSSubSysDM.isDataSQLDirty()) {
            return null;
        }
        String string = pSSubSysDM.getDataSQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataSQL_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isMemoDirty() : !pSSubSysDM.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysDM.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSubSysDM, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelSQL(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isModelSQLDirty() && !bl2 : !pSSubSysDM.isModelSQLDirty()) {
            return null;
        }
        String string = pSSubSysDM.getModelSQL();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSQL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelSQL_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelSQL2(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isModelSQL2Dirty() : !pSSubSysDM.isModelSQL2Dirty()) {
            return null;
        }
        String string = pSSubSysDM.getModelSQL2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelSQL2_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSQL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelSQL3(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isModelSQL3Dirty() : !pSSubSysDM.isModelSQL3Dirty()) {
            return null;
        }
        String string = pSSubSysDM.getModelSQL3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelSQL3_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSQL3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelSQL4(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isModelSQL4Dirty() : !pSSubSysDM.isModelSQL4Dirty()) {
            return null;
        }
        String string = pSSubSysDM.getModelSQL4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelSQL4_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSQL4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysDMId(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isPSSubSysDMIdDirty() && !bl2 : !pSSubSysDM.isPSSubSysDMIdDirty()) {
            return null;
        }
        String string = pSSubSysDM.getPSSubSysDMId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSDMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysDMId_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSDMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysDMName(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isPSSubSysDMNameDirty() && !bl2 : !pSSubSysDM.isPSSubSysDMNameDirty()) {
            return null;
        }
        String string = pSSubSysDM.getPSSubSysDMName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSDMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysDMName_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSDMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysId(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isPSSubSysIdDirty() : !pSSubSysDM.isPSSubSysIdDirty()) {
            return null;
        }
        String string = pSSubSysDM.getPSSubSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysId_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysName(boolean bl, PSSubSysDM pSSubSysDM, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysDM.isPSSubSysNameDirty() : !pSSubSysDM.isPSSubSysNameDirty()) {
            return null;
        }
        String string = pSSubSysDM.getPSSubSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysName_Default(pSSubSysDM, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        super.onSyncEntity(pSSubSysDM, bl);
    }

    protected void onSyncIndexEntities(PSSubSysDM pSSubSysDM, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSubSysDM, bl);
    }

    public Object getDataContextValue(PSSubSysDM pSSubSysDM, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSubSysDM, string, iDataContextParam)) != null) {
            return object;
        }
        PSSubSys pSSubSys = pSSubSysDM.getPSSubSys();
        if (pSSubSys != null && pSSubSys.contains(string)) {
            return pSSubSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysDM pSSubSysDM, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSubSysDM, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelSQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSQL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelSQL2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSQL3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelSQL3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSQL4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelSQL4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSDMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysDMId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSDMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysDMName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DataSQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_ModelSQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELSQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelSQL2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELSQL2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelSQL3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELSQL3", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelSQL4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELSQL4", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysDMId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSDMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysDMName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSDMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSubSysDM pSSubSysDM) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSubSysDM)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysDM pSSubSysDM) throws Exception {
        super.onUpdateParent(pSSubSysDM);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysDM pSSubSysDM, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSDM");
        if (!bl) {
            super.exportCurXmlModel(pSSubSysDM, xmlNode, bl);
        }
    }
}

