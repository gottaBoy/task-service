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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCSysPrdVerDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysPrdVerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysPrdVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysProduct;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysProductBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSysPrdVerServiceBase
extends PSCoreSysServiceBase<PSDCSysPrdVer> {
    private static final Log log = LogFactory.getLog(PSDCSysPrdVerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCSysPrdVerDEModel pSDCSysPrdVerDEModel;
    private PSDCSysPrdVerDAO pSDCSysPrdVerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCSysPrdVerService";
    }

    public PSDCSysPrdVerDEModel getPSDCSysPrdVerDEModel() {
        if (this.pSDCSysPrdVerDEModel == null) {
            try {
                this.pSDCSysPrdVerDEModel = (PSDCSysPrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSysPrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysPrdVerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCSysPrdVerDEModel();
    }

    public PSDCSysPrdVerDAO getPSDCSysPrdVerDAO() {
        if (this.pSDCSysPrdVerDAO == null) {
            try {
                this.pSDCSysPrdVerDAO = (PSDCSysPrdVerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCSysPrdVerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSysPrdVerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCSysPrdVerDAO();
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

    protected void onFillParentInfo(PSDCSysPrdVer pSDCSysPrdVer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSPRDVER_PSDCSYSPRODUCT_PSDCSYSPRODUCTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysProductService", (SessionFactory)this.getSessionFactory());
            PSDCSysProduct pSDCSysProduct = (PSDCSysProduct)iService.getDEModel().createEntity();
            pSDCSysProduct.set("PSDCSYSPRODUCTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCSysProduct);
            } else {
                iService.get((IEntity)pSDCSysProduct);
            }
            this.onFillParentInfo_PSDCSysProduct(pSDCSysPrdVer, pSDCSysProduct);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCSYSPRDVER_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDCSysPrdVer, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCSysPrdVer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCSysProduct(PSDCSysPrdVer pSDCSysPrdVer, PSDCSysProduct pSDCSysProduct) throws Exception {
        pSDCSysPrdVer.setPSDCSysProductId(pSDCSysProduct.getPSDCSysProductId());
        pSDCSysPrdVer.setPSDCSysProductName(pSDCSysProduct.getPSDCSysProductName());
    }

    protected void onFillParentInfo_PSSystem(PSDCSysPrdVer pSDCSysPrdVer, PSSystem pSSystem) throws Exception {
        pSDCSysPrdVer.setPSSystemId(pSSystem.getPSSystemId());
        pSDCSysPrdVer.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCSysPrdVer, bl);
        this.onFillEntityFullInfo_PSDCSysProduct(pSDCSysPrdVer, bl);
        this.onFillEntityFullInfo_PSSystem(pSDCSysPrdVer, bl);
    }

    protected void onFillEntityFullInfo_PSDCSysProduct(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        if (pSDCSysPrdVer.isPSDCSysProductIdDirty()) {
            if (pSDCSysPrdVer.getPSDCSysProductId() != null) {
                if (pSDCSysPrdVer.getPSDCSysProductId() == null || pSDCSysPrdVer.getPSDCSysProductName() == null) {
                    PSDCSysProduct pSDCSysProduct = pSDCSysPrdVer.getPSDCSysProduct();
                    pSDCSysPrdVer.setPSDCSysProductName(pSDCSysProduct.getPSDCSysProductName());
                }
            } else {
                pSDCSysPrdVer.setPSDCSysProductName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        if (pSDCSysPrdVer.isPSSystemIdDirty()) {
            if (pSDCSysPrdVer.getPSSystemId() != null) {
                if (pSDCSysPrdVer.getPSSystemId() == null || pSDCSysPrdVer.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDCSysPrdVer.getPSSystem();
                    pSDCSysPrdVer.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDCSysPrdVer.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCSysPrdVer, bl);
    }

    public ArrayList<PSDCSysPrdVer> selectByPSDCSysProduct(PSDCSysProductBase pSDCSysProductBase) throws Exception {
        return this.selectByPSDCSysProduct(pSDCSysProductBase, "", -1);
    }

    public ArrayList<PSDCSysPrdVer> selectByPSDCSysProduct(PSDCSysProductBase pSDCSysProductBase, String string) throws Exception {
        return this.selectByPSDCSysProduct(pSDCSysProductBase, string, -1);
    }

    public ArrayList<PSDCSysPrdVer> selectByPSDCSysProduct(PSDCSysProductBase pSDCSysProductBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCSYSPRODUCTID", (Object)pSDCSysProductBase.getPSDCSysProductId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCSysProductCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCSysProductCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCSysPrdVer> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDCSysPrdVer> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDCSysPrdVer> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
    }

    public void resetPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
        ArrayList<PSDCSysPrdVer> arrayList = this.selectByPSDCSysProduct(pSDCSysProduct);
        for (PSDCSysPrdVer pSDCSysPrdVer : arrayList) {
            PSDCSysPrdVer pSDCSysPrdVer2 = (PSDCSysPrdVer)this.getDEModel().createEntity();
            pSDCSysPrdVer2.setPSDCSysPrdVerId(pSDCSysPrdVer.getPSDCSysPrdVerId());
            pSDCSysPrdVer2.setPSDCSysProductId(null);
            this.update(pSDCSysPrdVer2);
        }
    }

    public void removeByPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
        final PSDCSysProduct pSDCSysProduct2 = pSDCSysProduct;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysPrdVerServiceBase.this.onBeforeRemoveByPSDCSysProduct(pSDCSysProduct2);
                PSDCSysPrdVerServiceBase.this.internalRemoveByPSDCSysProduct(pSDCSysProduct2);
                PSDCSysPrdVerServiceBase.this.onAfterRemoveByPSDCSysProduct(pSDCSysProduct2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
    }

    protected void internalRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
        ArrayList<PSDCSysPrdVer> arrayList = this.selectByPSDCSysProduct(pSDCSysProduct);
        this.onBeforeRemoveByPSDCSysProduct(pSDCSysProduct, arrayList);
        for (PSDCSysPrdVer pSDCSysPrdVer : arrayList) {
            this.remove((IEntity)pSDCSysPrdVer);
        }
        this.onAfterRemoveByPSDCSysProduct(pSDCSysProduct, arrayList);
    }

    protected void onAfterRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct) throws Exception {
    }

    protected void onBeforeRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct, ArrayList<PSDCSysPrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCSysProduct(PSDCSysProduct pSDCSysProduct, ArrayList<PSDCSysPrdVer> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDCSysPrdVer> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCSYSPRDVER_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSDCSYSPRDVER", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDCSysPrdVer> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDCSysPrdVer pSDCSysPrdVer : arrayList) {
            PSDCSysPrdVer pSDCSysPrdVer2 = (PSDCSysPrdVer)this.getDEModel().createEntity();
            pSDCSysPrdVer2.setPSDCSysPrdVerId(pSDCSysPrdVer.getPSDCSysPrdVerId());
            pSDCSysPrdVer2.setPSSystemId(null);
            this.update(pSDCSysPrdVer2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCSysPrdVerServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDCSysPrdVerServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDCSysPrdVerServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDCSysPrdVer> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDCSysPrdVer pSDCSysPrdVer : arrayList) {
            this.remove((IEntity)pSDCSysPrdVer);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDCSysPrdVer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDCSysPrdVer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCSysPrdVer pSDCSysPrdVer) throws Exception {
        super.onBeforeRemove(pSDCSysPrdVer);
    }

    protected void replaceParentInfo(PSDCSysPrdVer pSDCSysPrdVer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCSysPrdVer, cloneSession);
        if (pSDCSysPrdVer.getPSDCSysProductId() != null && (iEntity = cloneSession.getEntity("PSDCSYSPRODUCT", (Object)pSDCSysPrdVer.getPSDCSysProductId())) != null) {
            this.onFillParentInfo_PSDCSysProduct(pSDCSysPrdVer, (PSDCSysProduct)iEntity);
        }
        if (pSDCSysPrdVer.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDCSysPrdVer.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDCSysPrdVer, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCSysPrdVer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCSysPrdVer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrdVerState(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysPrdVerId(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysPrdVerName(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysProductId(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysProductName(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDCSysPrdVer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCSysPrdVer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isMemoDirty() : !pSDCSysPrdVer.isMemoDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrdVerState(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPrdVerStateDirty() && !bl2 : !pSDCSysPrdVer.isPrdVerStateDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPrdVerState();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDVERSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrdVerState_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRDVERSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysPrdVerId(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSDCSysPrdVerIdDirty() && !bl2 : !pSDCSysPrdVer.isPSDCSysPrdVerIdDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSDCSysPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysPrdVerId_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysPrdVerName(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSDCSysPrdVerNameDirty() && !bl2 : !pSDCSysPrdVer.isPSDCSysPrdVerNameDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSDCSysPrdVerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRDVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysPrdVerName_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRDVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysProductId(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSDCSysProductIdDirty() : !pSDCSysPrdVer.isPSDCSysProductIdDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSDCSysProductId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysProductId_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRODUCTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysProductName(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSDCSysProductNameDirty() : !pSDCSysPrdVer.isPSDCSysProductNameDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSDCSysProductName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysProductName_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSPRODUCTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSSystemIdDirty() && !bl2 : !pSDCSysPrdVer.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDCSysPrdVer pSDCSysPrdVer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCSysPrdVer.isPSSystemNameDirty() && !bl2 : !pSDCSysPrdVer.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDCSysPrdVer.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSDCSysPrdVer, bl2, bl3);
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

    protected void onSyncEntity(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCSysPrdVer, bl);
    }

    protected void onSyncIndexEntities(PSDCSysPrdVer pSDCSysPrdVer, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCSysPrdVer, bl);
    }

    public Object getDataContextValue(PSDCSysPrdVer pSDCSysPrdVer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCSysPrdVer, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCSysProduct pSDCSysProduct = pSDCSysPrdVer.getPSDCSysProduct();
        if (pSDCSysProduct != null && pSDCSysProduct.contains(string)) {
            return pSDCSysProduct.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCSysPrdVer pSDCSysPrdVer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCSysPrdVer, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PRDVERSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrdVerState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSPRODUCTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysProductId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSPRODUCTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysProductName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PrdVerState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRDVERSTATE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysProductId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSPRODUCTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysProductName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSPRODUCTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCSysPrdVer pSDCSysPrdVer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCSysPrdVer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCSysPrdVer pSDCSysPrdVer) throws Exception {
        super.onUpdateParent((IEntity)pSDCSysPrdVer);
    }

    @Override
    protected void exportCurXmlModel(PSDCSysPrdVer pSDCSysPrdVer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCSYSPRDVER");
        if (!bl) {
            super.exportCurXmlModel(pSDCSysPrdVer, xmlNode, bl);
        }
    }
}

