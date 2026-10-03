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
import net.ibizsys.pscore.srv.config.dao.PSModelExampleCatDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelExampleCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCat;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCatBase;
import net.ibizsys.pscore.srv.config.service.PSModelExampleCatService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleCatServiceBase
extends PSCoreSysServiceBase<PSModelExampleCat> {
    private static final Log log = LogFactory.getLog(PSModelExampleCatServiceBase.class);
    private PSModelExampleCatDEModel pSModelExampleCatDEModel;
    private PSModelExampleCatDAO pSModelExampleCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelExampleCatService";
    }

    public PSModelExampleCatDEModel getPSModelExampleCatDEModel() {
        if (this.pSModelExampleCatDEModel == null) {
            try {
                this.pSModelExampleCatDEModel = (PSModelExampleCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelExampleCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelExampleCatDEModel();
    }

    public PSModelExampleCatDAO getPSModelExampleCatDAO() {
        if (this.pSModelExampleCatDAO == null) {
            try {
                this.pSModelExampleCatDAO = (PSModelExampleCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelExampleCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelExampleCatDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSModelExampleCat pSModelExampleCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELEXAMPLECAT_PSMODELEXAMPLECAT_PPSMODELEXAMPLECATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleCatService", (SessionFactory)this.getSessionFactory());
            PSModelExampleCat pSModelExampleCat2 = (PSModelExampleCat)iService.getDEModel().createEntity();
            pSModelExampleCat2.set("PSMODELEXAMPLECATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelExampleCat2);
            } else {
                iService.get(pSModelExampleCat2);
            }
            this.onFillParentInfo_PPSModelExampleCat(pSModelExampleCat, pSModelExampleCat2);
            return;
        }
        super.onFillParentInfo(pSModelExampleCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSModelExampleCat(PSModelExampleCat pSModelExampleCat, PSModelExampleCat pSModelExampleCat2) throws Exception {
        pSModelExampleCat.setPPSModelExampleCatId(pSModelExampleCat2.getPSModelExampleCatId());
        pSModelExampleCat.setPPSModelExampleCatName(pSModelExampleCat2.getPSModelExampleCatName());
    }

    protected void onFillEntityFullInfo(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
        if (bl && pSModelExampleCat.getValidFlag() == null) {
            pSModelExampleCat.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelExampleCat, bl);
        this.onFillEntityFullInfo_PPSModelExampleCat(pSModelExampleCat, bl);
    }

    protected void onFillEntityFullInfo_PPSModelExampleCat(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelExampleCat, bl);
    }

    public ArrayList<PSModelExampleCat> selectByPPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase) throws Exception {
        return this.selectByPPSModelExampleCat(pSModelExampleCatBase, "", -1);
    }

    public ArrayList<PSModelExampleCat> selectByPPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase, String string) throws Exception {
        return this.selectByPPSModelExampleCat(pSModelExampleCatBase, string, -1);
    }

    public ArrayList<PSModelExampleCat> selectByPPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELEXAMPLECATID", (Object)pSModelExampleCatBase.getPSModelExampleCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSModelExampleCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSModelExampleCatCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExampleCat> arrayList = this.selectByPPSModelExampleCat(pSModelExampleCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELEXAMPLECAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelExampleCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELEXAMPLECAT_PSMODELEXAMPLECAT_PPSMODELEXAMPLECATID", "", iDataEntityModel.getName(), "PSMODELEXAMPLECAT", iDataEntityModel.getDataInfo(pSModelExampleCat), arrayList.get(0)));
        }
    }

    public void resetPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExampleCat> arrayList = this.selectByPPSModelExampleCat(pSModelExampleCat);
        for (PSModelExampleCat pSModelExampleCat2 : arrayList) {
            PSModelExampleCat pSModelExampleCat3 = (PSModelExampleCat)this.getDEModel().createEntity();
            pSModelExampleCat3.setPSModelExampleCatId(pSModelExampleCat2.getPSModelExampleCatId());
            pSModelExampleCat3.setPPSModelExampleCatId(null);
            this.update(pSModelExampleCat3);
        }
    }

    public void removeByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        final PSModelExampleCat pSModelExampleCat2 = pSModelExampleCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelExampleCatServiceBase.this.onBeforeRemoveByPPSModelExampleCat(pSModelExampleCat2);
                PSModelExampleCatServiceBase.this.internalRemoveByPPSModelExampleCat(pSModelExampleCat2);
                PSModelExampleCatServiceBase.this.onAfterRemoveByPPSModelExampleCat(pSModelExampleCat2);
            }
        });
    }

    protected void onBeforeRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
    }

    protected void internalRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExampleCat> arrayList = this.selectByPPSModelExampleCat(pSModelExampleCat);
        this.onBeforeRemoveByPPSModelExampleCat(pSModelExampleCat, arrayList);
        for (PSModelExampleCat pSModelExampleCat2 : arrayList) {
            this.remove(pSModelExampleCat2);
        }
        this.onAfterRemoveByPPSModelExampleCat(pSModelExampleCat, arrayList);
    }

    protected void onAfterRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
    }

    protected void onBeforeRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat, ArrayList<PSModelExampleCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSModelExampleCat(PSModelExampleCat pSModelExampleCat, ArrayList<PSModelExampleCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelExampleCat pSModelExampleCat) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModelExampleCatService)ServiceGlobal.getService(PSModelExampleCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelExampleCatServiceBase)pSCoreSysServiceBase).testRemoveByPPSModelExampleCat(pSModelExampleCat);
        pSCoreSysServiceBase = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelExampleServiceBase)pSCoreSysServiceBase).testRemoveByPSModelExampleCat(pSModelExampleCat);
        super.onBeforeRemove(pSModelExampleCat);
    }

    protected void replaceParentInfo(PSModelExampleCat pSModelExampleCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelExampleCat, cloneSession);
        if (pSModelExampleCat.getPPSModelExampleCatId() != null && (iEntity = cloneSession.getEntity("PSMODELEXAMPLECAT", (Object)pSModelExampleCat.getPPSModelExampleCatId())) != null) {
            this.onFillParentInfo_PPSModelExampleCat(pSModelExampleCat, (PSModelExampleCat)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelExampleCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArticleMode(bl, pSModelExampleCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomContent(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatSN(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExampleType(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelExampleCatId(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleCatId(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleCatName(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelExampleCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelExampleCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArticleMode(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isArticleModeDirty() : !pSModelExampleCat.isArticleModeDirty()) {
            return null;
        }
        Integer n = pSModelExampleCat.getArticleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArticleMode_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isBottomContentDirty() : !pSModelExampleCat.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CatSN(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isCatSNDirty() : !pSModelExampleCat.isCatSNDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getCatSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatSN_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isContentDirty() : !pSModelExampleCat.isContentDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSModelExampleCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_ExampleType(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isExampleTypeDirty() : !pSModelExampleCat.isExampleTypeDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getExampleType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExampleType_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isHeaderContentDirty() : !pSModelExampleCat.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isMemoDirty() : !pSModelExampleCat.isMemoDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelExampleCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isOrderValueDirty() : !pSModelExampleCat.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelExampleCat.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSModelExampleCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSModelExampleCatId(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isPPSModelExampleCatIdDirty() : !pSModelExampleCat.isPPSModelExampleCatIdDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getPPSModelExampleCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelExampleCatId_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELEXAMPLECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleCatId(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isPSModelExampleCatIdDirty() && !bl2 : !pSModelExampleCat.isPSModelExampleCatIdDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getPSModelExampleCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLECATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleCatId_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleCatName(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isPSModelExampleCatNameDirty() && !bl2 : !pSModelExampleCat.isPSModelExampleCatNameDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getPSModelExampleCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLECATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleCatName_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLECATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isTitleDirty() : !pSModelExampleCat.isTitleDirty()) {
            return null;
        }
        String string = pSModelExampleCat.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(pSModelExampleCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelExampleCat pSModelExampleCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleCat.isValidFlagDirty() : !pSModelExampleCat.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelExampleCat.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelExampleCat, bl2, bl3);
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

    protected void onSyncEntity(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
        super.onSyncEntity(pSModelExampleCat, bl);
    }

    protected void onSyncIndexEntities(PSModelExampleCat pSModelExampleCat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelExampleCat, bl);
    }

    public Object getDataContextValue(PSModelExampleCat pSModelExampleCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelExampleCat, string, iDataContextParam)) != null) {
            return object;
        }
        PSModelExampleCat pSModelExampleCat2 = pSModelExampleCat.getPPSModelExampleCat();
        if (pSModelExampleCat2 != null && pSModelExampleCat2.contains(string)) {
            return pSModelExampleCat2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSModelExampleCat pSModelExampleCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelExampleCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARTICLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ArticleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CatSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMPLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ExampleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELEXAMPLECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelExampleCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELEXAMPLECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelExampleCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ArticleMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_ExampleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMPLETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PPSModelExampleCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELEXAMPLECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSMODELEXAMPLECATID", "PSMODELEXAMPLECAT", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSModelExampleCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELEXAMPLECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected boolean onMergeChild(String string, String string2, PSModelExampleCat pSModelExampleCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelExampleCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelExampleCat pSModelExampleCat) throws Exception {
        super.onUpdateParent(pSModelExampleCat);
    }

    @Override
    protected void exportCurXmlModel(PSModelExampleCat pSModelExampleCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELEXAMPLECAT");
        if (!bl) {
            pSModelExampleCat.setCreateDate(null);
            pSModelExampleCat.setCreateMan(null);
            pSModelExampleCat.setPPSModelExampleCatName(null);
            pSModelExampleCat.setUpdateDate(null);
            pSModelExampleCat.setUpdateMan(null);
            super.exportCurXmlModel(pSModelExampleCat, xmlNode, bl);
        }
    }
}

