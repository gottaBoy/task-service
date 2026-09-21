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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.pscore.srv.paasmgr.dao.PSSysPrdVerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysPrdVerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysPrdVer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProductBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPrdVerServiceBase
extends PSCoreSysServiceBase<PSSysPrdVer> {
    private static final Log log = LogFactory.getLog(PSSysPrdVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysPrdVerDEModel pSSysPrdVerDEModel;
    private PSSysPrdVerDAO pSSysPrdVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSSysPrdVerService";
    }

    public PSSysPrdVerDEModel getPSSysPrdVerDEModel() {
        if (this.pSSysPrdVerDEModel == null) {
            try {
                this.pSSysPrdVerDEModel = (PSSysPrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysPrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPrdVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysPrdVerDEModel();
    }

    public PSSysPrdVerDAO getPSSysPrdVerDAO() {
        if (this.pSSysPrdVerDAO == null) {
            try {
                this.pSSysPrdVerDAO = (PSSysPrdVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSSysPrdVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPrdVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysPrdVerDAO();
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

    protected void onFillParentInfo(PSSysPrdVer pSSysPrdVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSPRDVER_PSSYSPRODUCT_PSSYSPRODUCTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService", (SessionFactory)this.getSessionFactory());
            PSSysProduct pSSysProduct = (PSSysProduct)iService.getDEModel().createEntity();
            pSSysProduct.set("PSSYSPRODUCTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysProduct);
            } else {
                iService.get((IEntity)pSSysProduct);
            }
            this.onFillParentInfo_PSSysProduct(pSSysPrdVer, pSSysProduct);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysPrdVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysProduct(PSSysPrdVer pSSysPrdVer, PSSysProduct pSSysProduct) throws Exception {
        pSSysPrdVer.setPSSysProductId(pSSysProduct.getPSSysProductId());
        pSSysPrdVer.setPSSysProductName(pSSysProduct.getPSSysProductName());
    }

    protected void onFillEntityFullInfo(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysPrdVer, bl);
        this.onFillEntityFullInfo_PSSysProduct(pSSysPrdVer, bl);
    }

    protected void onFillEntityFullInfo_PSSysProduct(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        if (pSSysPrdVer.isPSSysProductIdDirty()) {
            if (pSSysPrdVer.getPSSysProductId() != null) {
                if (pSSysPrdVer.getPSSysProductId() == null || pSSysPrdVer.getPSSysProductName() == null) {
                    PSSysProduct pSSysProduct = pSSysPrdVer.getPSSysProduct();
                    pSSysPrdVer.setPSSysProductName(pSSysProduct.getPSSysProductName());
                }
            } else {
                pSSysPrdVer.setPSSysProductName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysPrdVer, bl);
    }

    public ArrayList<PSSysPrdVer> selectByPSSysProduct(PSSysProductBase pSSysProductBase) throws Exception {
        return this.selectByPSSysProduct(pSSysProductBase, "", -1);
    }

    public ArrayList<PSSysPrdVer> selectByPSSysProduct(PSSysProductBase pSSysProductBase, String string) throws Exception {
        return this.selectByPSSysProduct(pSSysProductBase, string, -1);
    }

    public ArrayList<PSSysPrdVer> selectByPSSysProduct(PSSysProductBase pSSysProductBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPRODUCTID", (Object)pSSysProductBase.getPSSysProductId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysProductCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysProductCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
    }

    public void resetPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        ArrayList<PSSysPrdVer> arrayList = this.selectByPSSysProduct(pSSysProduct);
        for (PSSysPrdVer pSSysPrdVer : arrayList) {
            PSSysPrdVer pSSysPrdVer2 = (PSSysPrdVer)this.getDEModel().createEntity();
            pSSysPrdVer2.setPSSysPrdVerId(pSSysPrdVer.getPSSysPrdVerId());
            pSSysPrdVer2.setPSSysProductId(null);
            this.update(pSSysPrdVer2);
        }
    }

    public void removeByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        final PSSysProduct pSSysProduct2 = pSSysProduct;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysPrdVerServiceBase.this.onBeforeRemoveByPSSysProduct(pSSysProduct2);
                PSSysPrdVerServiceBase.this.internalRemoveByPSSysProduct(pSSysProduct2);
                PSSysPrdVerServiceBase.this.onAfterRemoveByPSSysProduct(pSSysProduct2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
    }

    protected void internalRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        ArrayList<PSSysPrdVer> arrayList = this.selectByPSSysProduct(pSSysProduct);
        this.onBeforeRemoveByPSSysProduct(pSSysProduct, arrayList);
        for (PSSysPrdVer pSSysPrdVer : arrayList) {
            this.remove((IEntity)pSSysPrdVer);
        }
        this.onAfterRemoveByPSSysProduct(pSSysProduct, arrayList);
    }

    protected void onAfterRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
    }

    protected void onBeforeRemoveByPSSysProduct(PSSysProduct pSSysProduct, ArrayList<PSSysPrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysProduct(PSSysProduct pSSysProduct, ArrayList<PSSysPrdVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysPrdVer pSSysPrdVer) throws Exception {
        super.onBeforeRemove(pSSysPrdVer);
    }

    protected void replaceParentInfo(PSSysPrdVer pSSysPrdVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysPrdVer, cloneSession);
        if (pSSysPrdVer.getPSSysProductId() != null && (iEntity = cloneSession.getEntity("PSSYSPRODUCT", (Object)pSSysPrdVer.getPSSysProductId())) != null) {
            this.onFillParentInfo_PSSysProduct(pSSysPrdVer, (PSSysProduct)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysPrdVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysPrdVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPrdVerId(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPrdVerName(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysProductId(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysProductName(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysPrdVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isMemoDirty() : !pSSysPrdVer.isMemoDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysPrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPrdVerId(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSysPrdVerIdDirty() && !bl2 : !pSSysPrdVer.isPSSysPrdVerIdDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSysPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPrdVerId_Default((IEntity)pSSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPrdVerName(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSysPrdVerNameDirty() && !bl2 : !pSSysPrdVer.isPSSysPrdVerNameDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSysPrdVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRDVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPrdVerName_Default((IEntity)pSSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysProductId(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSysProductIdDirty() : !pSSysPrdVer.isPSSysProductIdDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSysProductId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysProductId_Default((IEntity)pSSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRODUCTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysProductName(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSysProductNameDirty() : !pSSysPrdVer.isPSSysProductNameDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSysProductName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysProductName_Default((IEntity)pSSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPRODUCTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSystemIdDirty() : !pSSysPrdVer.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysPrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysPrdVer pSSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysPrdVer.isPSSystemNameDirty() : !pSSysPrdVer.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysPrdVer.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysPrdVer, bl2, bl3);
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

    protected void onSyncEntity(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysPrdVer, bl);
    }

    protected void onSyncIndexEntities(PSSysPrdVer pSSysPrdVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysPrdVer, bl);
    }

    public Object getDataContextValue(PSSysPrdVer pSSysPrdVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysPrdVer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysPrdVer pSSysPrdVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysPrdVer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRODUCTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysProductId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRODUCTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysProductName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysProductId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPRODUCTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysProductName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPRODUCTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysPrdVer pSSysPrdVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysPrdVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysPrdVer pSSysPrdVer) throws Exception {
        super.onUpdateParent((IEntity)pSSysPrdVer);
    }

    @Override
    protected void exportCurXmlModel(PSSysPrdVer pSSysPrdVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSPRDVER");
        if (!bl) {
            super.exportCurXmlModel(pSSysPrdVer, xmlNode, bl);
        }
    }
}

