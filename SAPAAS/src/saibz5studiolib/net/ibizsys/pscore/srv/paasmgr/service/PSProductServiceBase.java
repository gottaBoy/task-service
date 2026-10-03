/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.paasmgr.dao.PSProductDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSProductDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSProduct;
import net.ibizsys.pscore.srv.paasmgr.entity.PSProductBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProvider;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrProviderBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSProductServiceBase<ET extends PSProduct>
extends PSCoreSysServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSProductServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_INDEXDER = "IndexDER";
    private PSProductDEModel pSProductDEModel;
    private PSProductDAO pSProductDAO;

    public PSProductDEModel getPSProductDEModel() {
        if (this.pSProductDEModel == null) {
            try {
                this.pSProductDEModel = (PSProductDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSProductDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSProductDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSProductDEModel();
    }

    public PSProductDAO getPSProductDAO() {
        if (this.pSProductDAO == null) {
            try {
                this.pSProductDAO = (PSProductDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSProductDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSProductDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSProductDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_INDEXDER, (boolean)true) == 0) {
            return this.fetchIndexDER(iDEDataSetFetchContext);
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

    public DBFetchResult fetchIndexDER(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_INDEXDER, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(ET ET, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPRODUCT_PSSVRPROVIDER_PSSVRPROVIDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrProviderService", (SessionFactory)this.getSessionFactory());
            PSSvrProvider pSSvrProvider = (PSSvrProvider)iService.getDEModel().createEntity();
            pSSvrProvider.set("PSSVRPROVIDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrProvider);
            } else {
                iService.get(pSSvrProvider);
            }
            this.onFillParentInfo_Pssvrprovider(ET, pSSvrProvider);
            return;
        }
        super.onFillParentInfo(ET, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssvrprovider(ET ET, PSSvrProvider pSSvrProvider) throws Exception {
        ((PSProductBase)ET).setPSSvrProviderId(pSSvrProvider.getPSSvrProviderId());
        ((PSProductBase)ET).setPSSvrProviderName(pSSvrProvider.getPSSvrProviderName());
    }

    protected void onFillEntityFullInfo(ET ET, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(ET, bl);
        this.onFillEntityFullInfo_Pssvrprovider(ET, bl);
    }

    protected void onFillEntityFullInfo_Pssvrprovider(ET ET, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(ET ET, boolean bl) throws Exception {
        super.onWriteBackParent(ET, bl);
    }

    public ArrayList<ET> selectByPssvrprovider(PSSvrProviderBase pSSvrProviderBase) throws Exception {
        return this.selectByPssvrprovider(pSSvrProviderBase, "", -1);
    }

    public ArrayList<ET> selectByPssvrprovider(PSSvrProviderBase pSSvrProviderBase, String string) throws Exception {
        return this.selectByPssvrprovider(pSSvrProviderBase, string, -1);
    }

    public ArrayList<ET> selectByPssvrprovider(PSSvrProviderBase pSSvrProviderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRPROVIDERID", (Object)pSSvrProviderBase.getPSSvrProviderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssvrproviderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssvrproviderCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<ET> arrayList = this.selectByPssvrprovider(pSSvrProvider, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRPROVIDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrProvider);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPRODUCT_PSSVRPROVIDER_PSSVRPROVIDERID", "", iDataEntityModel.getName(), "PSPRODUCT", iDataEntityModel.getDataInfo(pSSvrProvider), arrayList.get(0)));
        }
    }

    public void resetPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<ET> arrayList = this.selectByPssvrprovider(pSSvrProvider);
        for (ET pSProduct : arrayList) {
            ET pSProduct2 = (ET)this.getDEModel().createEntity();
            pSProduct2.setPSProductId(pSProduct.getPSProductId());
            pSProduct2.setPSSvrProviderId(null);
            this.update(pSProduct2);
        }
    }

    public void removeByPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
        final PSSvrProvider pSSvrProvider2 = pSSvrProvider;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSProductServiceBase.this.onBeforeRemoveByPssvrprovider(pSSvrProvider2);
                PSProductServiceBase.this.internalRemoveByPssvrprovider(pSSvrProvider2);
                PSProductServiceBase.this.onAfterRemoveByPssvrprovider(pSSvrProvider2);
            }
        });
    }

    protected void onBeforeRemoveByPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
    }

    protected void internalRemoveByPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
        ArrayList<ET> arrayList = this.selectByPssvrprovider(pSSvrProvider);
        this.onBeforeRemoveByPssvrprovider(pSSvrProvider, arrayList);
        for (ET pSProduct : arrayList) {
            this.remove(pSProduct);
        }
        this.onAfterRemoveByPssvrprovider(pSSvrProvider, arrayList);
    }

    protected void onAfterRemoveByPssvrprovider(PSSvrProvider pSSvrProvider) throws Exception {
    }

    protected void onBeforeRemoveByPssvrprovider(PSSvrProvider pSSvrProvider, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssvrprovider(PSSvrProvider pSSvrProvider, ArrayList<ET> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(ET ET) throws Exception {
        super.onBeforeRemove(ET);
    }

    protected void replaceParentInfo(ET ET, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(ET, cloneSession);
        if (((PSProductBase)ET).getPSSvrProviderId() != null && (iEntity = cloneSession.getEntity("PSSVRPROVIDER", (Object)((PSProductBase)ET).getPSSvrProviderId())) != null) {
            this.onFillParentInfo_Pssvrprovider(ET, (PSSvrProvider)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(ET ET, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(ET, bl);
    }

    protected void onCheckEntity(boolean bl, ET ET, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, ET, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProductSN(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProductState(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSProductId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSProductName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSProductType(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrProviderId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, ET, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isMemoDirty() : !((PSProductBase)ET).isMemoDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProductSN(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isProductSNDirty() : !((PSProductBase)ET).isProductSNDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getProductSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProductSN_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRODUCTSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProductState(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isProductStateDirty() && !bl2 : !((PSProductBase)ET).isProductStateDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getProductState();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRODUCTSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProductState_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRODUCTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSProductId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isPSProductIdDirty() && !bl2 : !((PSProductBase)ET).isPSProductIdDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getPSProductId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSProductId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSProductName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isPSProductNameDirty() && !bl2 : !((PSProductBase)ET).isPSProductNameDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getPSProductName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSProductName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSProductType(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isPSProductTypeDirty() && !bl2 : !((PSProductBase)ET).isPSProductTypeDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getPSProductType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSProductType_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPRODUCTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrProviderId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSProductBase)ET).isPSSvrProviderIdDirty() : !((PSProductBase)ET).isPSSvrProviderIdDirty()) {
            return null;
        }
        String string = ((PSProductBase)ET).getPSSvrProviderId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrProviderId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRPROVIDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(ET ET, boolean bl) throws Exception {
        super.onSyncEntity(ET, bl);
    }

    protected void onSyncIndexEntities(ET ET, boolean bl) throws Exception {
        super.onSyncIndexEntities(ET, bl);
    }

    public Object getDataContextValue(ET ET, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(ET, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(ET, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PRODUCTSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProductSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRODUCTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProductState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPRODUCTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSProductId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPRODUCTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSProductName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPRODUCTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSProductType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRPROVIDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrProviderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRPROVIDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrProviderName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ProductSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRODUCTSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProductState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRODUCTSTATE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSProductId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPRODUCTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSProductName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPRODUCTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSProductType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPRODUCTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrProviderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRPROVIDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrProviderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRPROVIDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, ET ET) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, ET)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(ET ET) throws Exception {
        super.onUpdateParent(ET);
    }

    @Override
    protected void exportCurXmlModel(ET ET, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPRODUCT");
        if (!bl) {
            ((PSProductBase)ET).setProductSN(null);
            ((PSProductBase)ET).setPSProductType(null);
            ((PSProductBase)ET).setPSSvrProviderName(null);
            super.exportCurXmlModel(ET, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(ET ET) throws Exception {
        return ((PSProductBase)ET).getPSProductType();
    }
}
