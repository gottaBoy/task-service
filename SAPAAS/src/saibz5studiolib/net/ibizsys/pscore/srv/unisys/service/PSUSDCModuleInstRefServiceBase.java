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
import net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstRefDAO;
import net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstRefDEModel;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstBase;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInstRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstRefServiceBase
extends PSCoreSysServiceBase<PSUSDCModuleInstRef> {
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUSDCModuleInstRefDEModel pSUSDCModuleInstRefDEModel;
    private PSUSDCModuleInstRefDAO pSUSDCModuleInstRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstRefService";
    }

    public PSUSDCModuleInstRefDEModel getPSUSDCModuleInstRefDEModel() {
        if (this.pSUSDCModuleInstRefDEModel == null) {
            try {
                this.pSUSDCModuleInstRefDEModel = (PSUSDCModuleInstRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.unisys.demodel.PSUSDCModuleInstRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUSDCModuleInstRefDEModel();
    }

    public PSUSDCModuleInstRefDAO getPSUSDCModuleInstRefDAO() {
        if (this.pSUSDCModuleInstRefDAO == null) {
            try {
                this.pSUSDCModuleInstRefDAO = (PSUSDCModuleInstRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.unisys.dao.PSUSDCModuleInstRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUSDCModuleInstRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUSDCModuleInstRefDAO();
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

    protected void onFillParentInfo(PSUSDCModuleInstRef pSUSDCModuleInstRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINSTREF_PSUSDCMODULEINST_PSUSDCMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSDCModuleInst pSUSDCModuleInst = (PSUSDCModuleInst)iService.getDEModel().createEntity();
            pSUSDCModuleInst.set("PSUSDCMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSUSDCModuleInst);
            } else {
                iService.get(pSUSDCModuleInst);
            }
            this.onFillParentInfo_PSUSDCModuleInst(pSUSDCModuleInstRef, pSUSDCModuleInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUSDCMODULEINSTREF_PSUSDCMODULEINST_REFPSUSDCMODULEINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService", (SessionFactory)this.getSessionFactory());
            PSUSDCModuleInst pSUSDCModuleInst = (PSUSDCModuleInst)iService.getDEModel().createEntity();
            pSUSDCModuleInst.set("PSUSDCMODULEINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSUSDCModuleInst);
            } else {
                iService.get(pSUSDCModuleInst);
            }
            this.onFillParentInfo_RefPSUSDCModuleInst(pSUSDCModuleInstRef, pSUSDCModuleInst);
            return;
        }
        super.onFillParentInfo(pSUSDCModuleInstRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUSDCModuleInst(PSUSDCModuleInstRef pSUSDCModuleInstRef, PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        pSUSDCModuleInstRef.setPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
        pSUSDCModuleInstRef.setPSUSDCModuleInstName(pSUSDCModuleInst.getPSUSDCModuleInstName());
    }

    protected void onFillParentInfo_RefPSUSDCModuleInst(PSUSDCModuleInstRef pSUSDCModuleInstRef, PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        pSUSDCModuleInstRef.setRefPSUSDCModuleInstId(pSUSDCModuleInst.getPSUSDCModuleInstId());
        pSUSDCModuleInstRef.setRefPSUSDCModuleInstName(pSUSDCModuleInst.getPSUSDCModuleInstName());
    }

    protected void onFillEntityFullInfo(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSUSDCModuleInstRef, bl);
        this.onFillEntityFullInfo_PSUSDCModuleInst(pSUSDCModuleInstRef, bl);
        this.onFillEntityFullInfo_RefPSUSDCModuleInst(pSUSDCModuleInstRef, bl);
    }

    protected void onFillEntityFullInfo_PSUSDCModuleInst(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSUSDCModuleInst(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSUSDCModuleInstRef, bl);
    }

    public ArrayList<PSUSDCModuleInstRef> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase) throws Exception {
        return this.selectByPSUSDCModuleInst(pSUSDCModuleInstBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInstRef> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string) throws Exception {
        return this.selectByPSUSDCModuleInst(pSUSDCModuleInstBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInstRef> selectByPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUSDCMODULEINSTID", (Object)pSUSDCModuleInstBase.getPSUSDCModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUSDCModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUSDCModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSUSDCModuleInstRef> selectByRefPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase) throws Exception {
        return this.selectByRefPSUSDCModuleInst(pSUSDCModuleInstBase, "", -1);
    }

    public ArrayList<PSUSDCModuleInstRef> selectByRefPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string) throws Exception {
        return this.selectByRefPSUSDCModuleInst(pSUSDCModuleInstBase, string, -1);
    }

    public ArrayList<PSUSDCModuleInstRef> selectByRefPSUSDCModuleInst(PSUSDCModuleInstBase pSUSDCModuleInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSUSDCMODULEINSTID", (Object)pSUSDCModuleInstBase.getPSUSDCModuleInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSUSDCModuleInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSUSDCModuleInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSDCMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSUSDCModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINSTREF_PSUSDCMODULEINST_PSUSDCMODULEINSTID", "", iDataEntityModel.getName(), "PSUSDCMODULEINSTREF", iDataEntityModel.getDataInfo(pSUSDCModuleInst), arrayList.get(0)));
        }
    }

    public void resetPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst);
        for (PSUSDCModuleInstRef pSUSDCModuleInstRef : arrayList) {
            PSUSDCModuleInstRef pSUSDCModuleInstRef2 = (PSUSDCModuleInstRef)this.getDEModel().createEntity();
            pSUSDCModuleInstRef2.setPSUSDCModuleInstRefId(pSUSDCModuleInstRef.getPSUSDCModuleInstRefId());
            pSUSDCModuleInstRef2.setPSUSDCModuleInstId(null);
            this.update(pSUSDCModuleInstRef2);
        }
    }

    public void removeByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        final PSUSDCModuleInst pSUSDCModuleInst2 = pSUSDCModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstRefServiceBase.this.onBeforeRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstRefServiceBase.this.internalRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstRefServiceBase.this.onAfterRemoveByPSUSDCModuleInst(pSUSDCModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void internalRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByPSUSDCModuleInst(pSUSDCModuleInst);
        this.onBeforeRemoveByPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
        for (PSUSDCModuleInstRef pSUSDCModuleInstRef : arrayList) {
            this.remove(pSUSDCModuleInstRef);
        }
        this.onAfterRemoveByPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
    }

    protected void onAfterRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByRefPSUSDCModuleInst(pSUSDCModuleInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUSDCMODULEINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSUSDCModuleInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSUSDCMODULEINSTREF_PSUSDCMODULEINST_REFPSUSDCMODULEINSTID", "", iDataEntityModel.getName(), "PSUSDCMODULEINSTREF", iDataEntityModel.getDataInfo(pSUSDCModuleInst), arrayList.get(0)));
        }
    }

    public void resetRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByRefPSUSDCModuleInst(pSUSDCModuleInst);
        for (PSUSDCModuleInstRef pSUSDCModuleInstRef : arrayList) {
            PSUSDCModuleInstRef pSUSDCModuleInstRef2 = (PSUSDCModuleInstRef)this.getDEModel().createEntity();
            pSUSDCModuleInstRef2.setPSUSDCModuleInstRefId(pSUSDCModuleInstRef.getPSUSDCModuleInstRefId());
            pSUSDCModuleInstRef2.setRefPSUSDCModuleInstId(null);
            this.update(pSUSDCModuleInstRef2);
        }
    }

    public void removeByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        final PSUSDCModuleInst pSUSDCModuleInst2 = pSUSDCModuleInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUSDCModuleInstRefServiceBase.this.onBeforeRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstRefServiceBase.this.internalRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst2);
                PSUSDCModuleInstRefServiceBase.this.onAfterRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void internalRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
        ArrayList<PSUSDCModuleInstRef> arrayList = this.selectByRefPSUSDCModuleInst(pSUSDCModuleInst);
        this.onBeforeRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
        for (PSUSDCModuleInstRef pSUSDCModuleInstRef : arrayList) {
            this.remove(pSUSDCModuleInstRef);
        }
        this.onAfterRemoveByRefPSUSDCModuleInst(pSUSDCModuleInst, arrayList);
    }

    protected void onAfterRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst) throws Exception {
    }

    protected void onBeforeRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSUSDCModuleInst(PSUSDCModuleInst pSUSDCModuleInst, ArrayList<PSUSDCModuleInstRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUSDCModuleInstRef pSUSDCModuleInstRef) throws Exception {
        super.onBeforeRemove(pSUSDCModuleInstRef);
    }

    protected void replaceParentInfo(PSUSDCModuleInstRef pSUSDCModuleInstRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSUSDCModuleInstRef, cloneSession);
        if (pSUSDCModuleInstRef.getPSUSDCModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSDCMODULEINST", (Object)pSUSDCModuleInstRef.getPSUSDCModuleInstId())) != null) {
            this.onFillParentInfo_PSUSDCModuleInst(pSUSDCModuleInstRef, (PSUSDCModuleInst)iEntity);
        }
        if (pSUSDCModuleInstRef.getRefPSUSDCModuleInstId() != null && (iEntity = cloneSession.getEntity("PSUSDCMODULEINST", (Object)pSUSDCModuleInstRef.getRefPSUSDCModuleInstId())) != null) {
            this.onFillParentInfo_RefPSUSDCModuleInst(pSUSDCModuleInstRef, (PSUSDCModuleInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSUSDCModuleInstRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSUSDCModuleInstId(bl, pSUSDCModuleInstRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstRefId(bl, pSUSDCModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUSDCModuleInstRefName(bl, pSUSDCModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSUSDCModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSUSDCModuleInstId(bl, pSUSDCModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSUSDCModuleInstRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSUSDCModuleInstRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstId(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isPSUSDCModuleInstIdDirty() : !pSUSDCModuleInstRef.isPSUSDCModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getPSUSDCModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstId_Default(pSUSDCModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstRefId(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isPSUSDCModuleInstRefIdDirty() && !bl2 : !pSUSDCModuleInstRef.isPSUSDCModuleInstRefIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getPSUSDCModuleInstRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstRefId_Default(pSUSDCModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUSDCModuleInstRefName(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isPSUSDCModuleInstRefNameDirty() && !bl2 : !pSUSDCModuleInstRef.isPSUSDCModuleInstRefNameDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getPSUSDCModuleInstRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUSDCModuleInstRefName_Default(pSUSDCModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUSDCMODULEINSTREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isRefModeDirty() && !bl2 : !pSUSDCModuleInstRef.isRefModeDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getRefMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default(pSUSDCModuleInstRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSUSDCModuleInstId(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isRefPSUSDCModuleInstIdDirty() : !pSUSDCModuleInstRef.isRefPSUSDCModuleInstIdDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getRefPSUSDCModuleInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSUSDCModuleInstId_Default(pSUSDCModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSUSDCMODULEINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUSDCModuleInstRef.isServiceUrlDirty() : !pSUSDCModuleInstRef.isServiceUrlDirty()) {
            return null;
        }
        String string = pSUSDCModuleInstRef.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default(pSUSDCModuleInstRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
        super.onSyncEntity(pSUSDCModuleInstRef, bl);
    }

    protected void onSyncIndexEntities(PSUSDCModuleInstRef pSUSDCModuleInstRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSUSDCModuleInstRef, bl);
    }

    public Object getDataContextValue(PSUSDCModuleInstRef pSUSDCModuleInstRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSUSDCModuleInstRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSUSDCModuleInst pSUSDCModuleInst = pSUSDCModuleInstRef.getPSUSDCModuleInst();
        if (pSUSDCModuleInst != null && pSUSDCModuleInst.contains(string)) {
            return pSUSDCModuleInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUSDCModuleInstRef pSUSDCModuleInstRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSUSDCModuleInstRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUSDCMODULEINSTREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUSDCModuleInstRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSUSDCMODULEINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSUSDCModuleInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSUSDCMODULEINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSUSDCModuleInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSUSDCModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUSDCModuleInstRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUSDCMODULEINSTREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSUSDCModuleInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSUSDCMODULEINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSUSDCModuleInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSUSDCMODULEINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected boolean onMergeChild(String string, String string2, PSUSDCModuleInstRef pSUSDCModuleInstRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSUSDCModuleInstRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUSDCModuleInstRef pSUSDCModuleInstRef) throws Exception {
        super.onUpdateParent(pSUSDCModuleInstRef);
    }

    @Override
    protected void exportCurXmlModel(PSUSDCModuleInstRef pSUSDCModuleInstRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUSDCMODULEINSTREF");
        if (!bl) {
            pSUSDCModuleInstRef.setCreateDate(null);
            pSUSDCModuleInstRef.setCreateMan(null);
            pSUSDCModuleInstRef.setPSUSDCModuleInstName(null);
            pSUSDCModuleInstRef.setPSUSDCModuleInstRefId(null);
            pSUSDCModuleInstRef.setRefPSUSDCModuleInstName(null);
            pSUSDCModuleInstRef.setUpdateDate(null);
            pSUSDCModuleInstRef.setUpdateMan(null);
            super.exportCurXmlModel(pSUSDCModuleInstRef, xmlNode, bl);
        }
    }
}

