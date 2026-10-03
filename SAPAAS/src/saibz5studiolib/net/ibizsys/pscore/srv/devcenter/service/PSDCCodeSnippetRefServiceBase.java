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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCCodeSnippetRefDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetRefDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetRef;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCCodeSnippetRefServiceBase
extends PSCoreSysServiceBase<PSDCCodeSnippetRef> {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCCodeSnippetRefDEModel pSDCCodeSnippetRefDEModel;
    private PSDCCodeSnippetRefDAO pSDCCodeSnippetRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetRefService";
    }

    public PSDCCodeSnippetRefDEModel getPSDCCodeSnippetRefDEModel() {
        if (this.pSDCCodeSnippetRefDEModel == null) {
            try {
                this.pSDCCodeSnippetRefDEModel = (PSDCCodeSnippetRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCCodeSnippetRefDEModel();
    }

    public PSDCCodeSnippetRefDAO getPSDCCodeSnippetRefDAO() {
        if (this.pSDCCodeSnippetRefDAO == null) {
            try {
                this.pSDCCodeSnippetRefDAO = (PSDCCodeSnippetRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCCodeSnippetRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCCodeSnippetRefDAO();
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

    protected void onFillParentInfo(PSDCCodeSnippetRef pSDCCodeSnippetRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCODESNIPPETREF_PSDCCODESNIPPET_PSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCodeSnippet);
            } else {
                iService.get(pSDCCodeSnippet);
            }
            this.onFillParentInfo_PSDCCodeSnippet(pSDCCodeSnippetRef, pSDCCodeSnippet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCCODESNIPPETREF_PSDCCODESNIPPET_REFPSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCodeSnippet);
            } else {
                iService.get(pSDCCodeSnippet);
            }
            this.onFillParentInfo_RefPSDCCodeSnippet(pSDCCodeSnippetRef, pSDCCodeSnippet);
            return;
        }
        super.onFillParentInfo(pSDCCodeSnippetRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCodeSnippet(PSDCCodeSnippetRef pSDCCodeSnippetRef, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSDCCodeSnippetRef.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSDCCodeSnippetRef.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillParentInfo_RefPSDCCodeSnippet(PSDCCodeSnippetRef pSDCCodeSnippetRef, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSDCCodeSnippetRef.setRefPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSDCCodeSnippetRef.setRefPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillEntityFullInfo(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCCodeSnippetRef, bl);
        this.onFillEntityFullInfo_PSDCCodeSnippet(pSDCCodeSnippetRef, bl);
        this.onFillEntityFullInfo_RefPSDCCodeSnippet(pSDCCodeSnippetRef, bl);
    }

    protected void onFillEntityFullInfo_PSDCCodeSnippet(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDCCodeSnippet(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCCodeSnippetRef, bl);
    }

    public ArrayList<PSDCCodeSnippetRef> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSDCCodeSnippetRef> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSDCCodeSnippetRef> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCODESNIPPETID", (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCodeSnippetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCodeSnippetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCCodeSnippetRef> selectByRefPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByRefPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSDCCodeSnippetRef> selectByRefPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByRefPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSDCCodeSnippetRef> selectByRefPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDCCODESNIPPETID", (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDCCodeSnippetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDCCodeSnippetCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    public void resetPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDCCodeSnippetRef> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSDCCodeSnippetRef pSDCCodeSnippetRef : arrayList) {
            PSDCCodeSnippetRef pSDCCodeSnippetRef2 = (PSDCCodeSnippetRef)this.getDEModel().createEntity();
            pSDCCodeSnippetRef2.setPSDCCodeSnippetRefId(pSDCCodeSnippetRef.getPSDCCodeSnippetRefId());
            pSDCCodeSnippetRef2.setPSDCCodeSnippetId(null);
            this.update(pSDCCodeSnippetRef2);
        }
    }

    public void removeByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCodeSnippetRefServiceBase.this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDCCodeSnippetRefServiceBase.this.internalRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDCCodeSnippetRefServiceBase.this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDCCodeSnippetRef> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSDCCodeSnippetRef pSDCCodeSnippetRef : arrayList) {
            this.remove(pSDCCodeSnippetRef);
        }
        this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDCCodeSnippetRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDCCodeSnippetRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDCCodeSnippetRef> arrayList = this.selectByRefPSDCCodeSnippet(pSDCCodeSnippet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCODESNIPPET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCCodeSnippet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCCODESNIPPETREF_PSDCCODESNIPPET_REFPSDCCODESNIPPETID", "", iDataEntityModel.getName(), "PSDCCODESNIPPETREF", iDataEntityModel.getDataInfo(pSDCCodeSnippet), arrayList.get(0)));
        }
    }

    public void resetRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDCCodeSnippetRef> arrayList = this.selectByRefPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSDCCodeSnippetRef pSDCCodeSnippetRef : arrayList) {
            PSDCCodeSnippetRef pSDCCodeSnippetRef2 = (PSDCCodeSnippetRef)this.getDEModel().createEntity();
            pSDCCodeSnippetRef2.setPSDCCodeSnippetRefId(pSDCCodeSnippetRef.getPSDCCodeSnippetRefId());
            pSDCCodeSnippetRef2.setRefPSDCCodeSnippetId(null);
            this.update(pSDCCodeSnippetRef2);
        }
    }

    public void removeByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCCodeSnippetRefServiceBase.this.onBeforeRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDCCodeSnippetRefServiceBase.this.internalRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet2);
                PSDCCodeSnippetRefServiceBase.this.onAfterRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSDCCodeSnippetRef> arrayList = this.selectByRefPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSDCCodeSnippetRef pSDCCodeSnippetRef : arrayList) {
            this.remove(pSDCCodeSnippetRef);
        }
        this.onAfterRemoveByRefPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDCCodeSnippetRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSDCCodeSnippetRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCCodeSnippetRef pSDCCodeSnippetRef) throws Exception {
        super.onBeforeRemove(pSDCCodeSnippetRef);
    }

    protected void replaceParentInfo(PSDCCodeSnippetRef pSDCCodeSnippetRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCCodeSnippetRef, cloneSession);
        if (pSDCCodeSnippetRef.getPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSDCCodeSnippetRef.getPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_PSDCCodeSnippet(pSDCCodeSnippetRef, (PSDCCodeSnippet)iEntity);
        }
        if (pSDCCodeSnippetRef.getRefPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSDCCodeSnippetRef.getRefPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_RefPSDCCodeSnippet(pSDCCodeSnippetRef, (PSDCCodeSnippet)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCCodeSnippetRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCCodeSnippetRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSDCCodeSnippetRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetRefId(bl, pSDCCodeSnippetRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetRefName(bl, pSDCCodeSnippetRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDCCodeSnippetId(bl, pSDCCodeSnippetRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCCodeSnippetRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippetRef.isMemoDirty() : !pSDCCodeSnippetRef.isMemoDirty()) {
            return null;
        }
        String string = pSDCCodeSnippetRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCCodeSnippetRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippetRef.isPSDCCodeSnippetIdDirty() : !pSDCCodeSnippetRef.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippetRef.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default(pSDCCodeSnippetRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetRefId(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippetRef.isPSDCCodeSnippetRefIdDirty() && !bl2 : !pSDCCodeSnippetRef.isPSDCCodeSnippetRefIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippetRef.getPSDCCodeSnippetRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetRefId_Default(pSDCCodeSnippetRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetRefName(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippetRef.isPSDCCodeSnippetRefNameDirty() && !bl2 : !pSDCCodeSnippetRef.isPSDCCodeSnippetRefNameDirty()) {
            return null;
        }
        String string = pSDCCodeSnippetRef.getPSDCCodeSnippetRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetRefName_Default(pSDCCodeSnippetRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDCCODESNIPPETID";
                String string4 = this.checkFieldDupRule(this.getPSDCCodeSnippetRefDEModel(), "PSDCCODESNIPPETREFNAME", string3, pSDCCodeSnippetRef, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCCODESNIPPETREFNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDCCodeSnippetId(boolean bl, PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCCodeSnippetRef.isRefPSDCCodeSnippetIdDirty() && !bl2 : !pSDCCodeSnippetRef.isRefPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSDCCodeSnippetRef.getRefPSDCCodeSnippetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDCCODESNIPPETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDCCodeSnippetId_Default(pSDCCodeSnippetRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
        super.onSyncEntity(pSDCCodeSnippetRef, bl);
    }

    protected void onSyncIndexEntities(PSDCCodeSnippetRef pSDCCodeSnippetRef, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCCodeSnippetRef, bl);
    }

    public Object getDataContextValue(PSDCCodeSnippetRef pSDCCodeSnippetRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCCodeSnippetRef, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCCodeSnippet pSDCCodeSnippet = pSDCCodeSnippetRef.getPSDCCodeSnippet();
        if (pSDCCodeSnippet != null && pSDCCodeSnippet.contains(string)) {
            return pSDCCodeSnippet.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCCodeSnippetRef pSDCCodeSnippetRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCCodeSnippetRef, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDCCodeSnippetName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCCodeSnippetRef pSDCCodeSnippetRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCCodeSnippetRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCCodeSnippetRef pSDCCodeSnippetRef) throws Exception {
        super.onUpdateParent(pSDCCodeSnippetRef);
    }

    @Override
    protected void exportCurXmlModel(PSDCCodeSnippetRef pSDCCodeSnippetRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCCODESNIPPETREF");
        if (!bl) {
            pSDCCodeSnippetRef.setCreateDate(null);
            pSDCCodeSnippetRef.setCreateMan(null);
            pSDCCodeSnippetRef.setPSDCCodeSnippetName(null);
            pSDCCodeSnippetRef.setPSDCCodeSnippetRefId(null);
            pSDCCodeSnippetRef.setUpdateDate(null);
            pSDCCodeSnippetRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDCCodeSnippetRef, xmlNode, bl);
        }
    }
}

