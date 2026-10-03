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
import net.ibizsys.pscore.srv.config.dao.PSSysModelFuncTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFunc;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSSysModelFuncTempl;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelFuncTemplServiceBase
extends PSCoreSysServiceBase<PSSysModelFuncTempl> {
    private static final Log log = LogFactory.getLog(PSSysModelFuncTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelFuncTemplDEModel pSSysModelFuncTemplDEModel;
    private PSSysModelFuncTemplDAO pSSysModelFuncTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysModelFuncTemplService";
    }

    public PSSysModelFuncTemplDEModel getPSSysModelFuncTemplDEModel() {
        if (this.pSSysModelFuncTemplDEModel == null) {
            try {
                this.pSSysModelFuncTemplDEModel = (PSSysModelFuncTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysModelFuncTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelFuncTemplDEModel();
    }

    public PSSysModelFuncTemplDAO getPSSysModelFuncTemplDAO() {
        if (this.pSSysModelFuncTemplDAO == null) {
            try {
                this.pSSysModelFuncTemplDAO = (PSSysModelFuncTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysModelFuncTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFuncTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelFuncTemplDAO();
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

    protected void onFillParentInfo(PSSysModelFuncTempl pSSysModelFuncTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELFUNCTEMPL_PSSYSMODELFUNC_PSSYSMODELFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelFuncService", (SessionFactory)this.getSessionFactory());
            PSSysModelFunc pSSysModelFunc = (PSSysModelFunc)iService.getDEModel().createEntity();
            pSSysModelFunc.set("PSSYSMODELFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelFunc);
            } else {
                iService.get(pSSysModelFunc);
            }
            this.onFillParentInfo_PSSysModelFunc(pSSysModelFuncTempl, pSSysModelFunc);
            return;
        }
        super.onFillParentInfo(pSSysModelFuncTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysModelFunc(PSSysModelFuncTempl pSSysModelFuncTempl, PSSysModelFunc pSSysModelFunc) throws Exception {
        pSSysModelFuncTempl.setPSSysModelFuncId(pSSysModelFunc.getPSSysModelFuncId());
        pSSysModelFuncTempl.setPSSysModelFuncName(pSSysModelFunc.getPSSysModelFuncName());
    }

    protected void onFillEntityFullInfo(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysModelFuncTempl, bl);
        this.onFillEntityFullInfo_PSSysModelFunc(pSSysModelFuncTempl, bl);
    }

    protected void onFillEntityFullInfo_PSSysModelFunc(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysModelFuncTempl, bl);
    }

    public ArrayList<PSSysModelFuncTempl> selectByPSSysModelFunc(PSSysModelFuncBase pSSysModelFuncBase) throws Exception {
        return this.selectByPSSysModelFunc(pSSysModelFuncBase, "", -1);
    }

    public ArrayList<PSSysModelFuncTempl> selectByPSSysModelFunc(PSSysModelFuncBase pSSysModelFuncBase, String string) throws Exception {
        return this.selectByPSSysModelFunc(pSSysModelFuncBase, string, -1);
    }

    public ArrayList<PSSysModelFuncTempl> selectByPSSysModelFunc(PSSysModelFuncBase pSSysModelFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELFUNCID", (Object)pSSysModelFuncBase.getPSSysModelFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelFuncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
        ArrayList<PSSysModelFuncTempl> arrayList = this.selectByPSSysModelFunc(pSSysModelFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSMODELFUNCTEMPL_PSSYSMODELFUNC_PSSYSMODELFUNCID", "", iDataEntityModel.getName(), "PSSYSMODELFUNCTEMPL", iDataEntityModel.getDataInfo(pSSysModelFunc), arrayList.get(0)));
        }
    }

    public void resetPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
        ArrayList<PSSysModelFuncTempl> arrayList = this.selectByPSSysModelFunc(pSSysModelFunc);
        for (PSSysModelFuncTempl pSSysModelFuncTempl : arrayList) {
            PSSysModelFuncTempl pSSysModelFuncTempl2 = (PSSysModelFuncTempl)this.getDEModel().createEntity();
            pSSysModelFuncTempl2.setPSSysModelFuncTemplId(pSSysModelFuncTempl.getPSSysModelFuncTemplId());
            pSSysModelFuncTempl2.setPSSysModelFuncId(null);
            this.update(pSSysModelFuncTempl2);
        }
    }

    public void removeByPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
        final PSSysModelFunc pSSysModelFunc2 = pSSysModelFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelFuncTemplServiceBase.this.onBeforeRemoveByPSSysModelFunc(pSSysModelFunc2);
                PSSysModelFuncTemplServiceBase.this.internalRemoveByPSSysModelFunc(pSSysModelFunc2);
                PSSysModelFuncTemplServiceBase.this.onAfterRemoveByPSSysModelFunc(pSSysModelFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
    }

    protected void internalRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
        ArrayList<PSSysModelFuncTempl> arrayList = this.selectByPSSysModelFunc(pSSysModelFunc);
        this.onBeforeRemoveByPSSysModelFunc(pSSysModelFunc, arrayList);
        for (PSSysModelFuncTempl pSSysModelFuncTempl : arrayList) {
            this.remove(pSSysModelFuncTempl);
        }
        this.onAfterRemoveByPSSysModelFunc(pSSysModelFunc, arrayList);
    }

    protected void onAfterRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc, ArrayList<PSSysModelFuncTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelFunc(PSSysModelFunc pSSysModelFunc, ArrayList<PSSysModelFuncTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelFuncTempl pSSysModelFuncTempl) throws Exception {
        super.onBeforeRemove(pSSysModelFuncTempl);
    }

    protected void replaceParentInfo(PSSysModelFuncTempl pSSysModelFuncTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysModelFuncTempl, cloneSession);
        if (pSSysModelFuncTempl.getPSSysModelFuncId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELFUNC", (Object)pSSysModelFuncTempl.getPSSysModelFuncId())) != null) {
            this.onFillParentInfo_PSSysModelFunc(pSSysModelFuncTempl, (PSSysModelFunc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysModelFuncTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ANGULARJS(bl, pSSysModelFuncTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EXTJS(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FR7(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_J2EE6_IBIZSYSRT(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_J2EE6_IBIZSYSRT_R2(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JQuery(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JQuery_R2(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFuncId(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFuncTemplId(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelFuncTemplName(bl, pSSysModelFuncTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysModelFuncTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ANGULARJS(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isANGULARJSDirty() : !pSSysModelFuncTempl.isANGULARJSDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getANGULARJS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ANGULARJS_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ANGULARJS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EXTJS(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isEXTJSDirty() : !pSSysModelFuncTempl.isEXTJSDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getEXTJS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EXTJS_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTJS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FR7(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isFR7Dirty() : !pSSysModelFuncTempl.isFR7Dirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getFR7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FR7_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FR7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_J2EE6_IBIZSYSRT(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isJ2EE6_IBIZSYSRTDirty() : !pSSysModelFuncTempl.isJ2EE6_IBIZSYSRTDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getJ2EE6_IBIZSYSRT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_J2EE6_IBIZSYSRT_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("J2EE6_IBIZSYSRT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_J2EE6_IBIZSYSRT_R2(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isJ2EE6_IBIZSYSRT_R2Dirty() : !pSSysModelFuncTempl.isJ2EE6_IBIZSYSRT_R2Dirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getJ2EE6_IBIZSYSRT_R2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_J2EE6_IBIZSYSRT_R2_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("J2EE6_IBIZSYSRT_R2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JQuery(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isJQueryDirty() : !pSSysModelFuncTempl.isJQueryDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getJQuery();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JQuery_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JQUERY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JQuery_R2(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isJQuery_R2Dirty() : !pSSysModelFuncTempl.isJQuery_R2Dirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getJQuery_R2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JQuery_R2_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JQUERY_R2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isMemoDirty() : !pSSysModelFuncTempl.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysModelFuncTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelFuncId(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isPSSysModelFuncIdDirty() && !bl2 : !pSSysModelFuncTempl.isPSSysModelFuncIdDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getPSSysModelFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFuncId_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFuncTemplId(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isPSSysModelFuncTemplIdDirty() && !bl2 : !pSSysModelFuncTempl.isPSSysModelFuncTemplIdDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getPSSysModelFuncTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFuncTemplId_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelFuncTemplName(boolean bl, PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelFuncTempl.isPSSysModelFuncTemplNameDirty() && !bl2 : !pSSysModelFuncTempl.isPSSysModelFuncTemplNameDirty()) {
            return null;
        }
        String string = pSSysModelFuncTempl.getPSSysModelFuncTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelFuncTemplName_Default(pSSysModelFuncTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELFUNCTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSSysModelFuncTempl, bl);
    }

    protected void onSyncIndexEntities(PSSysModelFuncTempl pSSysModelFuncTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysModelFuncTempl, bl);
    }

    public Object getDataContextValue(PSSysModelFuncTempl pSSysModelFuncTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysModelFuncTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelFuncTempl pSSysModelFuncTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysModelFuncTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ANGULARJS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ANGULARJS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTJS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EXTJS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FR7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FR7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"J2EE6_IBIZSYSRT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_J2EE6_IBIZSYSRT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"J2EE6_IBIZSYSRT_R2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_J2EE6_IBIZSYSRT_R2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JQUERY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JQuery_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JQUERY_R2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JQuery_R2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELFUNCTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelFuncTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ANGULARJS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ANGULARJS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_EXTJS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXTJS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FR7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FR7", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_J2EE6_IBIZSYSRT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("J2EE6_IBIZSYSRT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_J2EE6_IBIZSYSRT_R2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("J2EE6_IBIZSYSRT_R2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JQuery_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JQUERY", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JQuery_R2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JQUERY_R2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSSysModelFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFuncTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelFuncTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELFUNCTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysModelFuncTempl pSSysModelFuncTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysModelFuncTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelFuncTempl pSSysModelFuncTempl) throws Exception {
        super.onUpdateParent(pSSysModelFuncTempl);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelFuncTempl pSSysModelFuncTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELFUNCTEMPL");
        if (!bl) {
            pSSysModelFuncTempl.setCreateDate(null);
            pSSysModelFuncTempl.setCreateMan(null);
            pSSysModelFuncTempl.setPSSysModelFuncTemplId(null);
            pSSysModelFuncTempl.setUpdateDate(null);
            pSSysModelFuncTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelFuncTempl, xmlNode, bl);
        }
    }
}

