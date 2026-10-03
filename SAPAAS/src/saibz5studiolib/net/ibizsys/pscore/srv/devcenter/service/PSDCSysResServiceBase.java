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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSysResDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysResDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysRes;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProductBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysResServiceBase
extends PSCoreSysServiceBase<PSDCSysRes> {
    private static final Log log = LogFactory.getLog(PSDCSysResServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCSysResDEModel pSDCSysResDEModel;
    private PSDCSysResDAO pSDCSysResDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSysResService";
    }

    public PSDCSysResDEModel getPSDCSysResDEModel() {
        if (this.pSDCSysResDEModel == null) {
            try {
                this.pSDCSysResDEModel = (PSDCSysResDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysResDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysResDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSysResDEModel();
    }

    public PSDCSysResDAO getPSDCSysResDAO() {
        if (this.pSDCSysResDAO == null) {
            try {
                this.pSDCSysResDAO = (PSDCSysResDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSysResDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysResDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSysResDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCSysRes pSDCSysRes, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSRES_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCSysRes, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSRES_PSSYSPRODUCT_PSSYSPRODUCTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService", (SessionFactory)this.getSessionFactory());
            PSSysProduct pSSysProduct = (PSSysProduct)iService.getDEModel().createEntity();
            pSSysProduct.set("PSSYSPRODUCTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysProduct);
            } else {
                iService.get(pSSysProduct);
            }
            this.onFillParentInfo_PSSysProduct(pSDCSysRes, pSSysProduct);
            return;
        }
        super.onFillParentInfo(pSDCSysRes, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCSysRes pSDCSysRes, PSDevCenter pSDevCenter) throws Exception {
        pSDCSysRes.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCSysRes.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSysProduct(PSDCSysRes pSDCSysRes, PSSysProduct pSSysProduct) throws Exception {
        pSDCSysRes.setProductSN(pSSysProduct.getProductSN());
        pSDCSysRes.setPSSvrProviderName(pSSysProduct.getPSSvrProviderName());
        pSDCSysRes.setPSSysProductId(pSSysProduct.getPSSysProductId());
        pSDCSysRes.setPSSysProductName(pSSysProduct.getPSSysProductName());
    }

    protected void onFillEntityFullInfo(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCSysRes, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCSysRes, bl);
        this.onFillEntityFullInfo_PSSysProduct(pSDCSysRes, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysProduct(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        if (pSDCSysRes.isPSSysProductIdDirty()) {
            if (pSDCSysRes.getPSSysProductId() != null) {
                if (pSDCSysRes.getPSSysProductId() == null || pSDCSysRes.getPSSysProductName() == null) {
                    PSSysProduct pSSysProduct = pSDCSysRes.getPSSysProduct();
                    pSDCSysRes.setProductSN(pSSysProduct.getProductSN());
                    pSDCSysRes.setPSSvrProviderName(pSSysProduct.getPSSvrProviderName());
                    pSDCSysRes.setPSSysProductName(pSSysProduct.getPSSysProductName());
                }
            } else {
                pSDCSysRes.setProductSN(null);
                pSDCSysRes.setPSSvrProviderName(null);
                pSDCSysRes.setPSSysProductName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCSysRes, bl);
    }

    public ArrayList<PSDCSysRes> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCSysRes> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCSysRes> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSysRes> selectByPSSysProduct(PSSysProductBase pSSysProductBase) throws Exception {
        return this.selectByPSSysProduct(pSSysProductBase, "", -1);
    }

    public ArrayList<PSDCSysRes> selectByPSSysProduct(PSSysProductBase pSSysProductBase, String string) throws Exception {
        return this.selectByPSSysProduct(pSSysProductBase, string, -1);
    }

    public ArrayList<PSDCSysRes> selectByPSSysProduct(PSSysProductBase pSSysProductBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSysRes> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCSysRes pSDCSysRes : arrayList) {
            PSDCSysRes pSDCSysRes2 = (PSDCSysRes)this.getDEModel().createEntity();
            pSDCSysRes2.setPSDCSysResId(pSDCSysRes.getPSDCSysResId());
            pSDCSysRes2.setPSDevCenterId(null);
            this.update(pSDCSysRes2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysResServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCSysResServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCSysResServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCSysRes> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCSysRes pSDCSysRes : arrayList) {
            this.remove(pSDCSysRes);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCSysRes> arrayList) throws Exception {
    }

    public void testRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        ArrayList<PSDCSysRes> arrayList = this.selectByPSSysProduct(pSSysProduct, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPRODUCT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysProduct);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSYSRES_PSSYSPRODUCT_PSSYSPRODUCTID", "", iDataEntityModel.getName(), "PSDCSYSRES", iDataEntityModel.getDataInfo(pSSysProduct), arrayList.get(0)));
        }
    }

    public void resetPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        ArrayList<PSDCSysRes> arrayList = this.selectByPSSysProduct(pSSysProduct);
        for (PSDCSysRes pSDCSysRes : arrayList) {
            PSDCSysRes pSDCSysRes2 = (PSDCSysRes)this.getDEModel().createEntity();
            pSDCSysRes2.setPSDCSysResId(pSDCSysRes.getPSDCSysResId());
            pSDCSysRes2.setPSSysProductId(null);
            this.update(pSDCSysRes2);
        }
    }

    public void removeByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        final PSSysProduct pSSysProduct2 = pSSysProduct;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysResServiceBase.this.onBeforeRemoveByPSSysProduct(pSSysProduct2);
                PSDCSysResServiceBase.this.internalRemoveByPSSysProduct(pSSysProduct2);
                PSDCSysResServiceBase.this.onAfterRemoveByPSSysProduct(pSSysProduct2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
    }

    protected void internalRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
        ArrayList<PSDCSysRes> arrayList = this.selectByPSSysProduct(pSSysProduct);
        this.onBeforeRemoveByPSSysProduct(pSSysProduct, arrayList);
        for (PSDCSysRes pSDCSysRes : arrayList) {
            this.remove(pSDCSysRes);
        }
        this.onAfterRemoveByPSSysProduct(pSSysProduct, arrayList);
    }

    protected void onAfterRemoveByPSSysProduct(PSSysProduct pSSysProduct) throws Exception {
    }

    protected void onBeforeRemoveByPSSysProduct(PSSysProduct pSSysProduct, ArrayList<PSDCSysRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysProduct(PSSysProduct pSSysProduct, ArrayList<PSDCSysRes> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSysRes pSDCSysRes) throws Exception {
        PSDepSlnPrdService pSDepSlnPrdService = (PSDepSlnPrdService)ServiceGlobal.getService(PSDepSlnPrdService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnPrdService.testRemoveByPSDCSysRes(pSDCSysRes);
        super.onBeforeRemove(pSDCSysRes);
    }

    protected void replaceParentInfo(PSDCSysRes pSDCSysRes, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCSysRes, cloneSession);
        if (pSDCSysRes.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCSysRes.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCSysRes, (PSDevCenter)iEntity);
        }
        if (pSDCSysRes.getPSSysProductId() != null && (iEntity = cloneSession.getEntity("PSSYSPRODUCT", (Object)pSDCSysRes.getPSSysProductId())) != null) {
            this.onFillParentInfo_PSSysProduct(pSDCSysRes, (PSSysProduct)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCSysRes, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCSysRes, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysResId(bl, pSDCSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysResName(bl, pSDCSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysProductId(bl, pSDCSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysProductName(bl, pSDCSysRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCSysRes, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isMemoDirty() : !pSDCSysRes.isMemoDirty()) {
            return null;
        }
        String string = pSDCSysRes.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCSysRes, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCSysResId(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isPSDCSysResIdDirty() && !bl2 : !pSDCSysRes.isPSDCSysResIdDirty()) {
            return null;
        }
        String string = pSDCSysRes.getPSDCSysResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSRESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysResId_Default(pSDCSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysResName(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isPSDCSysResNameDirty() && !bl2 : !pSDCSysRes.isPSDCSysResNameDirty()) {
            return null;
        }
        String string = pSDCSysRes.getPSDCSysResName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSRESNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysResName_Default(pSDCSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isPSDevCenterIdDirty() : !pSDCSysRes.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCSysRes.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCSysRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysProductId(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isPSSysProductIdDirty() : !pSDCSysRes.isPSSysProductIdDirty()) {
            return null;
        }
        String string = pSDCSysRes.getPSSysProductId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysProductId_Default(pSDCSysRes, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysProductName(boolean bl, PSDCSysRes pSDCSysRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysRes.isPSSysProductNameDirty() : !pSDCSysRes.isPSSysProductNameDirty()) {
            return null;
        }
        String string = pSDCSysRes.getPSSysProductName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysProductName_Default(pSDCSysRes, bl2, bl3);
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

    protected void onSyncEntity(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        super.onSyncEntity(pSDCSysRes, bl);
    }

    protected void onSyncIndexEntities(PSDCSysRes pSDCSysRes, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCSysRes, bl);
    }

    public Object getDataContextValue(PSDCSysRes pSDCSysRes, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCSysRes, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSysRes pSDCSysRes, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCSysRes, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCSYSRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRPROVIDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrProviderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRODUCTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysProductId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPRODUCTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysProductName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCSysResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSDCSysRes pSDCSysRes) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCSysRes)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSysRes pSDCSysRes) throws Exception {
        super.onUpdateParent(pSDCSysRes);
    }

    @Override
    protected void exportCurXmlModel(PSDCSysRes pSDCSysRes, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSYSRES");
        if (!bl) {
            pSDCSysRes.setPSDevCenterName(null);
            super.exportCurXmlModel(pSDCSysRes, xmlNode, bl);
        }
    }
}

