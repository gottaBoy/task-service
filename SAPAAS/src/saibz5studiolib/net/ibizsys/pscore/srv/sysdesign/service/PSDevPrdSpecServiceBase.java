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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSpecDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecPlanServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSpecServiceBase
extends PSCoreSysServiceBase<PSDevPrdSpec> {
    private static final Log log = LogFactory.getLog(PSDevPrdSpecServiceBase.class);
    public static final String DATASET_CURVER = "CurVer";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdSpecDEModel pSDevPrdSpecDEModel;
    private PSDevPrdSpecDAO pSDevPrdSpecDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSpecService";
    }

    public PSDevPrdSpecDEModel getPSDevPrdSpecDEModel() {
        if (this.pSDevPrdSpecDEModel == null) {
            try {
                this.pSDevPrdSpecDEModel = (PSDevPrdSpecDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSpecDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSpecDEModel();
    }

    public PSDevPrdSpecDAO getPSDevPrdSpecDAO() {
        if (this.pSDevPrdSpecDAO == null) {
            try {
                this.pSDevPrdSpecDAO = (PSDevPrdSpecDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSpecDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSpecDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSpecDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURVER, (boolean)true) == 0) {
            return this.fetchCurVer(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurVer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevPrdSpec pSDevPrdSpec, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSPEC_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpec, pSDevPrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSPEC_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrd);
            } else {
                iService.get(pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSDevPrdSpec, pSDevPrd);
            return;
        }
        super.onFillParentInfo(pSDevPrdSpec, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdSpec pSDevPrdSpec, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdSpec.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdSpec.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
        if (pSDevPrdVer.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSpec, pSDevPrdVer.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSDevPrdSpec pSDevPrdSpec, PSDevPrd pSDevPrd) throws Exception {
        pSDevPrdSpec.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSDevPrdSpec.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevPrdSpec, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdSpec, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSDevPrdSpec, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevPrdSpec, bl);
    }

    public ArrayList<PSDevPrdSpec> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSpec> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSpec> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevPrdSpec> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSDevPrdSpec> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSDevPrdSpec> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSPEC_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSDEVPRDSPEC", iDataEntityModel.getDataInfo(pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdSpec pSDevPrdSpec : arrayList) {
            PSDevPrdSpec pSDevPrdSpec2 = (PSDevPrdSpec)this.getDEModel().createEntity();
            pSDevPrdSpec2.setPSDevPrdSpecId(pSDevPrdSpec.getPSDevPrdSpecId());
            pSDevPrdSpec2.setPSDevPrdVerId(null);
            this.update(pSDevPrdSpec2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSpecServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSpecServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSpecServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdSpec pSDevPrdSpec : arrayList) {
            this.remove(pSDevPrdSpec);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSpec> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSpec> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSPEC_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSDEVPRDSPEC", iDataEntityModel.getDataInfo(pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSDevPrdSpec pSDevPrdSpec : arrayList) {
            PSDevPrdSpec pSDevPrdSpec2 = (PSDevPrdSpec)this.getDEModel().createEntity();
            pSDevPrdSpec2.setPSDevPrdSpecId(pSDevPrdSpec.getPSDevPrdSpecId());
            pSDevPrdSpec2.setPSDevPrdId(null);
            this.update(pSDevPrdSpec2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSpecServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSpecServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSpecServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSpec> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSDevPrdSpec pSDevPrdSpec : arrayList) {
            this.remove(pSDevPrdSpec);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSpec> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSpec> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevPrdSpecPlanService)ServiceGlobal.getService(PSDevPrdSpecPlanService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSpecPlanServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSpec(pSDevPrdSpec);
        pSCoreSysServiceBase = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysReqItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevPrdSpec(pSDevPrdSpec);
        super.onBeforeRemove(pSDevPrdSpec);
    }

    protected void replaceParentInfo(PSDevPrdSpec pSDevPrdSpec, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevPrdSpec, cloneSession);
        if (pSDevPrdSpec.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdSpec.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSpec, (PSDevPrdVer)iEntity);
        }
        if (pSDevPrdSpec.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSDevPrdSpec.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSpec, (PSDevPrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevPrdSpec, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSDevPrdSpec, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecId(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSpecName(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecSN(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpecState(bl, pSDevPrdSpec, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevPrdSpec, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isContentDirty() : !pSDevPrdSpec.isContentDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSDevPrdSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isMemoDirty() : !pSDevPrdSpec.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevPrdSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isPSDevPrdIdDirty() && !bl2 : !pSDevPrdSpec.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getPSDevPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default(pSDevPrdSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdSpecId(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isPSDevPrdSpecIdDirty() && !bl2 : !pSDevPrdSpec.isPSDevPrdSpecIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getPSDevPrdSpecId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecId_Default(pSDevPrdSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSpecName(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isPSDevPrdSpecNameDirty() && !bl2 : !pSDevPrdSpec.isPSDevPrdSpecNameDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getPSDevPrdSpecName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSpecName_Default(pSDevPrdSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSPECNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isPSDevPrdVerIdDirty() && !bl2 : !pSDevPrdSpec.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getPSDevPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSDevPrdSpec, bl2, bl3);
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

    protected EntityFieldError onCheckField_SpecSN(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isSpecSNDirty() : !pSDevPrdSpec.isSpecSNDirty()) {
            return null;
        }
        String string = pSDevPrdSpec.getSpecSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpecSN_Default(pSDevPrdSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpecState(boolean bl, PSDevPrdSpec pSDevPrdSpec, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSpec.isSpecStateDirty() && !bl2 : !pSDevPrdSpec.isSpecStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdSpec.getSpecState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_SpecState_Default(pSDevPrdSpec, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPECSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
        super.onSyncEntity(pSDevPrdSpec, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSpec pSDevPrdSpec, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevPrdSpec, bl);
    }

    public Object getDataContextValue(PSDevPrdSpec pSDevPrdSpec, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevPrdSpec, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSpec pSDevPrdSpec, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevPrdSpec, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPECSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpecState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDevPrdSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SpecSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPECSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpecState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDevPrdSpec pSDevPrdSpec) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevPrdSpec)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSpec pSDevPrdSpec) throws Exception {
        super.onUpdateParent(pSDevPrdSpec);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSpec pSDevPrdSpec, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSPEC");
        if (!bl) {
            pSDevPrdSpec.setCreateDate(null);
            pSDevPrdSpec.setCreateMan(null);
            pSDevPrdSpec.setPSDevPrdSpecId(null);
            pSDevPrdSpec.setUpdateDate(null);
            pSDevPrdSpec.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSpec, xmlNode, bl);
        }
    }
}

