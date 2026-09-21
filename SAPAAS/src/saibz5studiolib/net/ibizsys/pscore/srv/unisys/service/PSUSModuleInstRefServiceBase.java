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
package net.ibizsys.pscore.srv.unisys.service;

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
import net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstRefDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstRefDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInstRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleInstRefServiceBase
extends PSCoreSysServiceBase<PSUSModuleInstRef> {
    private static final Log log = LogFactory.getLog(PSUSModuleInstRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSModuleInstRefDEModel pSUSModuleInstRefDEModel;
    private PSUSModuleInstRefDAO pSUSModuleInstRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstRefService";
    }

    public PSUSModuleInstRefDEModel getPSUSModuleInstRefDEModel() {
        if (this.pSUSModuleInstRefDEModel == null) {
            try {
                this.pSUSModuleInstRefDEModel = (PSUSModuleInstRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSModuleInstRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSModuleInstRefDEModel();
    }

    public PSUSModuleInstRefDAO getPSUSModuleInstRefDAO() {
        if (this.pSUSModuleInstRefDAO == null) {
            try {
                this.pSUSModuleInstRefDAO = (PSUSModuleInstRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSModuleInstRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSModuleInstRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSModuleInstRefDAO();
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

    protected void onFillParentInfo(PSUSModuleInstRef pSUSModuleInstRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSMODULEINSTREF_PSUSMODULEINST_PSUSMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSModuleInst pSUSModuleInst = (PSUSModuleInst)iService.getDEModel().createEntity();
            pSUSModuleInst.set("PSUSMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModuleInst);
            } else {
                iService.get((IEntity)pSUSModuleInst);
            }
            this.onFillParentInfo_PSUSModuleInst(pSUSModuleInstRef, pSUSModuleInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSMODULEINSTREF_PSUSMODULEINST_REFPSUSMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSModuleInst pSUSModuleInst = (PSUSModuleInst)iService.getDEModel().createEntity();
            pSUSModuleInst.set("PSUSMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUSModuleInst);
            } else {
                iService.get((IEntity)pSUSModuleInst);
            }
            this.onFillParentInfo_RefPSUSModuleInst(pSUSModuleInstRef, pSUSModuleInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSUSModuleInstRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUSModuleInst(PSUSModuleInstRef pSUSModuleInstRef, PSUSModuleInst pSUSModuleInst) throws Exception {
        pSUSModuleInstRef.setPSUSModuleInstId(pSUSModuleInst.getPSUSModuleInstId());
        pSUSModuleInstRef.setPSUSModuleInstName(pSUSModuleInst.getPSUSModuleInstName());
    }

    protected void onFillParentInfo_RefPSUSModuleInst(PSUSModuleInstRef pSUSModuleInstRef, PSUSModuleInst pSUSModuleInst) throws Exception {
        pSUSModuleInstRef.setRefPSUSModuleInstId(pSUSModuleInst.getPSUSModuleInstId());
        pSUSModuleInstRef.setRefPSUSModuleInstName(pSUSModuleInst.getPSUSModuleInstName());
    }

    protected void onFillEntityFullInfo(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUSModuleInstRef, bl);
        this.onFillEntityFullInfo_PSUSModuleInst(pSUSModuleInstRef, bl);
        this.onFillEntityFullInfo_RefPSUSModuleInst(pSUSModuleInstRef, bl);
    }

    protected void onFillEntityFullInfo_PSUSModuleInst(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSUSModuleInst(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUSModuleInstRef, bl);
    }

    public ArrayList<PSUSModuleInstRef> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, "", -1);
    }

    public ArrayList<PSUSModuleInstRef> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string) throws Exception {
        return this.selectByPSUSModuleInst(pSUSModuleInstBase, string, -1);
    }

    public ArrayList<PSUSModuleInstRef> selectByPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSMODULEINSTID", (Object)pSUSModuleInstBase.getPSUSModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSModuleInstRef> selectByRefPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase) throws Exception {
        return this.selectByRefPSUSModuleInst(pSUSModuleInstBase, "", -1);
    }

    public ArrayList<PSUSModuleInstRef> selectByRefPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string) throws Exception {
        return this.selectByRefPSUSModuleInst(pSUSModuleInstBase, string, -1);
    }

    public ArrayList<PSUSModuleInstRef> selectByRefPSUSModuleInst(PSUSModuleInstBase pSUSModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSUSMODULEINSTID", (Object)pSUSModuleInstBase.getPSUSModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSUSModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSUSModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSMODULEINSTREF_PSUSMODULEINST_PSUSMODULEINSTID", "", iDataEntityModel.getName(), "PSUSMODULEINSTREF", iDataEntityModel.getDataInfo((IEntity)pSUSModuleInst), arrayList.get(0)));
        }
    }

    public void resetPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        for (PSUSModuleInstRef pSUSModuleInstRef : arrayList) {
            PSUSModuleInstRef pSUSModuleInstRef2 = (PSUSModuleInstRef)this.getDEModel().createEntity();
            pSUSModuleInstRef2.setPSUSModuleInstRefId(pSUSModuleInstRef.getPSUSModuleInstRefId());
            pSUSModuleInstRef2.setPSUSModuleInstId(null);
            this.update(pSUSModuleInstRef2);
        }
    }

    public void removeByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        final PSUSModuleInst pSUSModuleInst2 = pSUSModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSModuleInstRefServiceBase.this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstRefServiceBase.this.internalRemoveByPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstRefServiceBase.this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void internalRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByPSUSModuleInst(pSUSModuleInst);
        this.onBeforeRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
        for (PSUSModuleInstRef pSUSModuleInstRef : arrayList) {
            this.remove((IEntity)pSUSModuleInstRef);
        }
        this.onAfterRemoveByPSUSModuleInst(pSUSModuleInst, arrayList);
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByRefPSUSModuleInst(pSUSModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUSModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSMODULEINSTREF_PSUSMODULEINST_REFPSUSMODULEINSTID", "", iDataEntityModel.getName(), "PSUSMODULEINSTREF", iDataEntityModel.getDataInfo((IEntity)pSUSModuleInst), arrayList.get(0)));
        }
    }

    public void resetRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByRefPSUSModuleInst(pSUSModuleInst);
        for (PSUSModuleInstRef pSUSModuleInstRef : arrayList) {
            PSUSModuleInstRef pSUSModuleInstRef2 = (PSUSModuleInstRef)this.getDEModel().createEntity();
            pSUSModuleInstRef2.setPSUSModuleInstRefId(pSUSModuleInstRef.getPSUSModuleInstRefId());
            pSUSModuleInstRef2.setRefPSUSModuleInstId(null);
            this.update(pSUSModuleInstRef2);
        }
    }

    public void removeByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        final PSUSModuleInst pSUSModuleInst2 = pSUSModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSModuleInstRefServiceBase.this.onBeforeRemoveByRefPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstRefServiceBase.this.internalRemoveByRefPSUSModuleInst(pSUSModuleInst2);
                PSUSModuleInstRefServiceBase.this.onAfterRemoveByRefPSUSModuleInst(pSUSModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void internalRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
        ArrayList<PSUSModuleInstRef> arrayList = this.selectByRefPSUSModuleInst(pSUSModuleInst);
        this.onBeforeRemoveByRefPSUSModuleInst(pSUSModuleInst, arrayList);
        for (PSUSModuleInstRef pSUSModuleInstRef : arrayList) {
            this.remove((IEntity)pSUSModuleInstRef);
        }
        this.onAfterRemoveByRefPSUSModuleInst(pSUSModuleInst, arrayList);
    }

    protected void onAfterRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSUSModuleInst(PSUSModuleInst pSUSModuleInst, ArrayList<PSUSModuleInstRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSModuleInstRef pSUSModuleInstRef) throws Exception {
        super.onBeforeRemove(pSUSModuleInstRef);
    }

    protected void replaceParentInfo(PSUSModuleInstRef pSUSModuleInstRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUSModuleInstRef, cloneSession);
        if (pSUSModuleInstRef.getPSUSModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSMODULEINST", (Object)pSUSModuleInstRef.getPSUSModuleInstId())) != null) {
            this.onFillParentInfo_PSUSModuleInst(pSUSModuleInstRef, (PSUSModuleInst)iEntity);
        }
        if (pSUSModuleInstRef.getRefPSUSModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSMODULEINST", (Object)pSUSModuleInstRef.getRefPSUSModuleInstId())) != null) {
            this.onFillParentInfo_RefPSUSModuleInst(pSUSModuleInstRef, (PSUSModuleInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUSModuleInstRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSUSModuleInstRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstId(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstRefId(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSModuleInstRefName(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSUSModuleInstId(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSUSModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUSModuleInstRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isMemoDirty() : !pSUSModuleInstRef.isMemoDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUSModuleInstId(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isPSUSModuleInstIdDirty() : !pSUSModuleInstRef.isPSUSModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getPSUSModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstId_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstRefId(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isPSUSModuleInstRefIdDirty() && !bl2 : !pSUSModuleInstRef.isPSUSModuleInstRefIdDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getPSUSModuleInstRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstRefId_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSModuleInstRefName(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isPSUSModuleInstRefNameDirty() && !bl2 : !pSUSModuleInstRef.isPSUSModuleInstRefNameDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getPSUSModuleInstRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSModuleInstRefName_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSMODULEINSTREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isRefModeDirty() && !bl2 : !pSUSModuleInstRef.isRefModeDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getRefMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSUSModuleInstId(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isRefPSUSModuleInstIdDirty() : !pSUSModuleInstRef.isRefPSUSModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSModuleInstRef.getRefPSUSModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSUSModuleInstId_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSUSMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSUSModuleInstRef pSUSModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSModuleInstRef.isValidFlagDirty() && !bl2 : !pSUSModuleInstRef.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSUSModuleInstRef.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSUSModuleInstRef, bl2, bl3);
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

    protected void onSyncEntity(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUSModuleInstRef, bl);
    }

    protected void onSyncIndexEntities(PSUSModuleInstRef pSUSModuleInstRef, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUSModuleInstRef, bl);
    }

    public Object getDataContextValue(PSUSModuleInstRef pSUSModuleInstRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUSModuleInstRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSModuleInst pSUSModuleInst = pSUSModuleInstRef.getPSUSModuleInst();
        if (pSUSModuleInst != null && pSUSModuleInst.contains(string)) {
            return pSUSModuleInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSModuleInstRef pSUSModuleInstRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUSModuleInstRef, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSMODULEINSTREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSModuleInstRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSUSMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSUSModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSUSMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSUSModuleInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSUSModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSModuleInstRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSMODULEINSTREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSUSModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSUSMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSUSModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSUSMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSUSModuleInstRef pSUSModuleInstRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUSModuleInstRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSModuleInstRef pSUSModuleInstRef) throws Exception {
        super.onUpdateParent((IEntity)pSUSModuleInstRef);
    }

    @Override
    protected void exportCurXmlModel(PSUSModuleInstRef pSUSModuleInstRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSMODULEINSTREF");
        if (!bl) {
            pSUSModuleInstRef.setCreateDate(null);
            pSUSModuleInstRef.setCreateMan(null);
            pSUSModuleInstRef.setPSUSModuleInstName(null);
            pSUSModuleInstRef.setPSUSModuleInstRefId(null);
            pSUSModuleInstRef.setRefPSUSModuleInstName(null);
            pSUSModuleInstRef.setUpdateDate(null);
            pSUSModuleInstRef.setUpdateMan(null);
            super.exportCurXmlModel(pSUSModuleInstRef, xmlNode, bl);
        }
    }
}

