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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubRefDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubRefDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubRefServiceBase
extends PSCoreSysServiceBase<PSSysSFPubRef> {
    private static final Log log = LogFactory.getLog(PSSysSFPubRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSFPubRefDEModel pSSysSFPubRefDEModel;
    private PSSysSFPubRefDAO pSSysSFPubRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubRefService";
    }

    public PSSysSFPubRefDEModel getPSSysSFPubRefDEModel() {
        if (this.pSSysSFPubRefDEModel == null) {
            try {
                this.pSSysSFPubRefDEModel = (PSSysSFPubRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSFPubRefDEModel();
    }

    public PSSysSFPubRefDAO getPSSysSFPubRefDAO() {
        if (this.pSSysSFPubRefDAO == null) {
            try {
                this.pSSysSFPubRefDAO = (PSSysSFPubRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSFPubRefDAO();
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

    protected void onFillParentInfo(PSSysSFPubRef pSSysSFPubRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUBREF_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPub);
            } else {
                iService.get(pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSysSFPubRef, pSSysSFPub);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUBREF_PSSYSSFPUB_REFPSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSFPub);
            } else {
                iService.get(pSSysSFPub);
            }
            this.onFillParentInfo_RefPSSysSFPub(pSSysSFPubRef, pSSysSFPub);
            return;
        }
        super.onFillParentInfo(pSSysSFPubRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysSFPub(PSSysSFPubRef pSSysSFPubRef, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysSFPubRef.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysSFPubRef.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillParentInfo_RefPSSysSFPub(PSSysSFPubRef pSSysSFPubRef, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysSFPubRef.setRefPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysSFPubRef.setRefPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillEntityFullInfo(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
        if (bl && pSSysSFPubRef.getValidFlag() == null) {
            pSSysSFPubRef.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysSFPubRef, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSysSFPubRef, bl);
        this.onFillEntityFullInfo_RefPSSysSFPub(pSSysSFPubRef, bl);
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysSFPub(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSFPubRef, bl);
    }

    public ArrayList<PSSysSFPubRef> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysSFPubRef> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysSFPubRef> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFPubRef> selectByRefPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByRefPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysSFPubRef> selectByRefPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByRefPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysSFPubRef> selectByRefPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubRef> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSysSFPubRef pSSysSFPubRef : arrayList) {
            PSSysSFPubRef pSSysSFPubRef2 = (PSSysSFPubRef)this.getDEModel().createEntity();
            pSSysSFPubRef2.setPSSysSFPubRefId(pSSysSFPubRef.getPSSysSFPubRefId());
            pSSysSFPubRef2.setPSSysSFPubId(null);
            this.update(pSSysSFPubRef2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubRefServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFPubRefServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFPubRefServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubRef> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysSFPubRef pSSysSFPubRef : arrayList) {
            this.remove(pSSysSFPubRef);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubRef> arrayList = this.selectByRefPSSysSFPub(pSSysSFPub, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPUB");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSFPub);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFPUBREF_PSSYSSFPUB_REFPSSYSSFPUBID", "", iDataEntityModel.getName(), "PSSYSSFPUBREF", iDataEntityModel.getDataInfo(pSSysSFPub), arrayList.get(0)));
        }
    }

    public void resetRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubRef> arrayList = this.selectByRefPSSysSFPub(pSSysSFPub);
        for (PSSysSFPubRef pSSysSFPubRef : arrayList) {
            PSSysSFPubRef pSSysSFPubRef2 = (PSSysSFPubRef)this.getDEModel().createEntity();
            pSSysSFPubRef2.setPSSysSFPubRefId(pSSysSFPubRef.getPSSysSFPubRefId());
            pSSysSFPubRef2.setRefPSSysSFPubId(null);
            this.update(pSSysSFPubRef2);
        }
    }

    public void removeByRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubRefServiceBase.this.onBeforeRemoveByRefPSSysSFPub(pSSysSFPub2);
                PSSysSFPubRefServiceBase.this.internalRemoveByRefPSSysSFPub(pSSysSFPub2);
                PSSysSFPubRefServiceBase.this.onAfterRemoveByRefPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubRef> arrayList = this.selectByRefPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByRefPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysSFPubRef pSSysSFPubRef : arrayList) {
            this.remove(pSSysSFPubRef);
        }
        this.onAfterRemoveByRefPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSFPubRef pSSysSFPubRef) throws Exception {
        super.onBeforeRemove(pSSysSFPubRef);
    }

    protected void replaceParentInfo(PSSysSFPubRef pSSysSFPubRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSFPubRef, cloneSession);
        if (pSSysSFPubRef.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysSFPubRef.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSysSFPubRef, (PSSysSFPub)iEntity);
        }
        if (pSSysSFPubRef.getRefPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysSFPubRef.getRefPSSysSFPubId())) != null) {
            this.onFillParentInfo_RefPSSysSFPub(pSSysSFPubRef, (PSSysSFPub)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSFPubRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysSFPubRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubRefId(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubRefName(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysSFPubId(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSFPubRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSFPubRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isMemoDirty() : !pSSysSFPubRef.isMemoDirty()) {
            return null;
        }
        String string = pSSysSFPubRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSFPubRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isOrderValueDirty() : !pSSysSFPubRef.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSFPubRef.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysSFPubRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isPSSysSFPubIdDirty() && !bl2 : !pSSysSFPubRef.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFPubRef.getPSSysSFPubId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default(pSSysSFPubRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubRefId(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isPSSysSFPubRefIdDirty() && !bl2 : !pSSysSFPubRef.isPSSysSFPubRefIdDirty()) {
            return null;
        }
        String string = pSSysSFPubRef.getPSSysSFPubRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubRefId_Default(pSSysSFPubRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubRefName(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isPSSysSFPubRefNameDirty() && !bl2 : !pSSysSFPubRef.isPSSysSFPubRefNameDirty()) {
            return null;
        }
        String string = pSSysSFPubRef.getPSSysSFPubRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubRefName_Default(pSSysSFPubRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysSFPubId(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isRefPSSysSFPubIdDirty() && !bl2 : !pSSysSFPubRef.isRefPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFPubRef.getRefPSSysSFPubId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSSFPUBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysSFPubId_Default(pSSysSFPubRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSSFPUBID");
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
                string3 = "PSSYSSFPUBID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPubRefDEModel(), "REFPSSYSSFPUBID", string3, pSSysSFPubRef, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REFPSSYSSFPUBID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSFPubRef pSSysSFPubRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubRef.isValidFlagDirty() && !bl2 : !pSSysSFPubRef.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFPubRef.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysSFPubRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSFPubRef, bl);
    }

    protected void onSyncIndexEntities(PSSysSFPubRef pSSysSFPubRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSFPubRef, bl);
    }

    public Object getDataContextValue(PSSysSFPubRef pSSysSFPubRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSFPubRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSFPub pSSysSFPub = pSSysSFPubRef.getPSSysSFPub();
        if (pSSysSFPub != null && pSSysSFPub.contains(string)) {
            return pSSysSFPub.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSFPubRef pSSysSFPubRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSFPubRef, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSFPubRef pSSysSFPubRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSFPubRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSFPubRef pSSysSFPubRef) throws Exception {
        super.onUpdateParent(pSSysSFPubRef);
    }

    @Override
    protected void exportCurXmlModel(PSSysSFPubRef pSSysSFPubRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSFPUBREF");
        if (!bl) {
            pSSysSFPubRef.setCreateDate(null);
            pSSysSFPubRef.setCreateMan(null);
            pSSysSFPubRef.setPSSysSFPubRefId(null);
            pSSysSFPubRef.setUpdateDate(null);
            pSSysSFPubRef.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSFPubRef, xmlNode, bl);
        }
    }
}

