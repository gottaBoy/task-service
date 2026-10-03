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
import net.ibizsys.pscore.srv.config.dao.PSSysLanItemDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSysLanItemDEModel;
import net.ibizsys.pscore.srv.config.entity.PSLanguage;
import net.ibizsys.pscore.srv.config.entity.PSLanguageBase;
import net.ibizsys.pscore.srv.config.entity.PSSysLanItem;
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.entity.PSSysLanResBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysLanItemServiceBase
extends PSCoreSysServiceBase<PSSysLanItem> {
    private static final Log log = LogFactory.getLog(PSSysLanItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysLanItemDEModel pSSysLanItemDEModel;
    private PSSysLanItemDAO pSSysLanItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSysLanItemService";
    }

    public PSSysLanItemDEModel getPSSysLanItemDEModel() {
        if (this.pSSysLanItemDEModel == null) {
            try {
                this.pSSysLanItemDEModel = (PSSysLanItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysLanItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysLanItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysLanItemDEModel();
    }

    public PSSysLanItemDAO getPSSysLanItemDAO() {
        if (this.pSSysLanItemDAO == null) {
            try {
                this.pSSysLanItemDAO = (PSSysLanItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSysLanItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysLanItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysLanItemDAO();
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

    protected void onFillParentInfo(PSSysLanItem pSSysLanItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSLANITEM_PSLANGUAGE_PSLANGUAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSLanguageService", (SessionFactory)this.getSessionFactory());
            PSLanguage pSLanguage = (PSLanguage)iService.getDEModel().createEntity();
            pSLanguage.set("PSLANGUAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguage);
            } else {
                iService.get(pSLanguage);
            }
            this.onFillParentInfo_PSLanguage(pSSysLanItem, pSLanguage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSLANITEM_PSSYSLANRES_PSSYSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysLanResService", (SessionFactory)this.getSessionFactory());
            PSSysLanRes pSSysLanRes = (PSSysLanRes)iService.getDEModel().createEntity();
            pSSysLanRes.set("PSSYSLANRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysLanRes);
            } else {
                iService.get(pSSysLanRes);
            }
            this.onFillParentInfo_PSSysLanRes(pSSysLanItem, pSSysLanRes);
            return;
        }
        super.onFillParentInfo(pSSysLanItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSLanguage(PSSysLanItem pSSysLanItem, PSLanguage pSLanguage) throws Exception {
        pSSysLanItem.setPSLanguageId(pSLanguage.getPSLanguageId());
        pSSysLanItem.setPSLanguageName(pSLanguage.getPSLanguageName());
    }

    protected void onFillParentInfo_PSSysLanRes(PSSysLanItem pSSysLanItem, PSSysLanRes pSSysLanRes) throws Exception {
        pSSysLanItem.setPSSysLanResId(pSSysLanRes.getPSSysLanResId());
        pSSysLanItem.setPSSysLanResName(pSSysLanRes.getPSSysLanResName());
    }

    protected void onFillEntityFullInfo(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysLanItem, bl);
        this.onFillEntityFullInfo_PSLanguage(pSSysLanItem, bl);
        this.onFillEntityFullInfo_PSSysLanRes(pSSysLanItem, bl);
    }

    protected void onFillEntityFullInfo_PSLanguage(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysLanRes(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysLanItem, bl);
    }

    public ArrayList<PSSysLanItem> selectByPSLanguage(PSLanguageBase pSLanguageBase) throws Exception {
        return this.selectByPSLanguage(pSLanguageBase, "", -1);
    }

    public ArrayList<PSSysLanItem> selectByPSLanguage(PSLanguageBase pSLanguageBase, String string) throws Exception {
        return this.selectByPSLanguage(pSLanguageBase, string, -1);
    }

    public ArrayList<PSSysLanItem> selectByPSLanguage(PSLanguageBase pSLanguageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSLANGUAGEID", (Object)pSLanguageBase.getPSLanguageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSLanguageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSLanguageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysLanItem> selectByPSSysLanRes(PSSysLanResBase pSSysLanResBase) throws Exception {
        return this.selectByPSSysLanRes(pSSysLanResBase, "", -1);
    }

    public ArrayList<PSSysLanItem> selectByPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string) throws Exception {
        return this.selectByPSSysLanRes(pSSysLanResBase, string, -1);
    }

    public ArrayList<PSSysLanItem> selectByPSSysLanRes(PSSysLanResBase pSSysLanResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSLANRESID", (Object)pSSysLanResBase.getPSSysLanResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSLanguage(pSLanguage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSLANITEM_PSLANGUAGE_PSLANGUAGEID", "", iDataEntityModel.getName(), "PSSYSLANITEM", iDataEntityModel.getDataInfo(pSLanguage), arrayList.get(0)));
        }
    }

    public void resetPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSLanguage(pSLanguage);
        for (PSSysLanItem pSSysLanItem : arrayList) {
            PSSysLanItem pSSysLanItem2 = (PSSysLanItem)this.getDEModel().createEntity();
            pSSysLanItem2.setPSSysLanItemId(pSSysLanItem.getPSSysLanItemId());
            pSSysLanItem2.setPSLanguageId(null);
            this.update(pSSysLanItem2);
        }
    }

    public void removeByPSLanguage(PSLanguage pSLanguage) throws Exception {
        final PSLanguage pSLanguage2 = pSLanguage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysLanItemServiceBase.this.onBeforeRemoveByPSLanguage(pSLanguage2);
                PSSysLanItemServiceBase.this.internalRemoveByPSLanguage(pSLanguage2);
                PSSysLanItemServiceBase.this.onAfterRemoveByPSLanguage(pSLanguage2);
            }
        });
    }

    protected void onBeforeRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
    }

    protected void internalRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSLanguage(pSLanguage);
        this.onBeforeRemoveByPSLanguage(pSLanguage, arrayList);
        for (PSSysLanItem pSSysLanItem : arrayList) {
            this.remove(pSSysLanItem);
        }
        this.onAfterRemoveByPSLanguage(pSLanguage, arrayList);
    }

    protected void onAfterRemoveByPSLanguage(PSLanguage pSLanguage) throws Exception {
    }

    protected void onBeforeRemoveByPSLanguage(PSLanguage pSLanguage, ArrayList<PSSysLanItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSLanguage(PSLanguage pSLanguage, ArrayList<PSSysLanItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSSysLanRes(pSSysLanRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSLANRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysLanRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSLANITEM_PSSYSLANRES_PSSYSLANRESID", "", iDataEntityModel.getName(), "PSSYSLANITEM", iDataEntityModel.getDataInfo(pSSysLanRes), arrayList.get(0)));
        }
    }

    public void resetPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSSysLanRes(pSSysLanRes);
        for (PSSysLanItem pSSysLanItem : arrayList) {
            PSSysLanItem pSSysLanItem2 = (PSSysLanItem)this.getDEModel().createEntity();
            pSSysLanItem2.setPSSysLanItemId(pSSysLanItem.getPSSysLanItemId());
            pSSysLanItem2.setPSSysLanResId(null);
            this.update(pSSysLanItem2);
        }
    }

    public void removeByPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        final PSSysLanRes pSSysLanRes2 = pSSysLanRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysLanItemServiceBase.this.onBeforeRemoveByPSSysLanRes(pSSysLanRes2);
                PSSysLanItemServiceBase.this.internalRemoveByPSSysLanRes(pSSysLanRes2);
                PSSysLanItemServiceBase.this.onAfterRemoveByPSSysLanRes(pSSysLanRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void internalRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
        ArrayList<PSSysLanItem> arrayList = this.selectByPSSysLanRes(pSSysLanRes);
        this.onBeforeRemoveByPSSysLanRes(pSSysLanRes, arrayList);
        for (PSSysLanItem pSSysLanItem : arrayList) {
            this.remove(pSSysLanItem);
        }
        this.onAfterRemoveByPSSysLanRes(pSSysLanRes, arrayList);
    }

    protected void onAfterRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysLanItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysLanRes(PSSysLanRes pSSysLanRes, ArrayList<PSSysLanItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysLanItem pSSysLanItem) throws Exception {
        super.onBeforeRemove(pSSysLanItem);
    }

    protected void replaceParentInfo(PSSysLanItem pSSysLanItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysLanItem, cloneSession);
        if (pSSysLanItem.getPSLanguageId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGE", (Object)pSSysLanItem.getPSLanguageId())) != null) {
            this.onFillParentInfo_PSLanguage(pSSysLanItem, (PSLanguage)iEntity);
        }
        if (pSSysLanItem.getPSSysLanResId() != null && (iEntity = cloneSession.getEntity("PSSYSLANRES", (Object)pSSysLanItem.getPSSysLanResId())) != null) {
            this.onFillParentInfo_PSSysLanRes(pSSysLanItem, (PSSysLanRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysLanItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSSysLanItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content2(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSLanguageId(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysLanItemId(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysLanItemName(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysLanResId(bl, pSSysLanItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysLanItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isContentDirty() : !pSSysLanItem.isContentDirty()) {
            return null;
        }
        String string = pSSysLanItem.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSSysLanItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content2(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isContent2Dirty() : !pSSysLanItem.isContent2Dirty()) {
            return null;
        }
        String string = pSSysLanItem.getContent2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content2_Default(pSSysLanItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isMemoDirty() : !pSSysLanItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysLanItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysLanItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSLanguageId(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isPSLanguageIdDirty() && !bl2 : !pSSysLanItem.isPSLanguageIdDirty()) {
            return null;
        }
        String string = pSSysLanItem.getPSLanguageId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSLanguageId_Default(pSSysLanItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSLANGUAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysLanItemId(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isPSSysLanItemIdDirty() && !bl2 : !pSSysLanItem.isPSSysLanItemIdDirty()) {
            return null;
        }
        String string = pSSysLanItem.getPSSysLanItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysLanItemId_Default(pSSysLanItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysLanItemName(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isPSSysLanItemNameDirty() && !bl2 : !pSSysLanItem.isPSSysLanItemNameDirty()) {
            return null;
        }
        String string = pSSysLanItem.getPSSysLanItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysLanItemName_Default(pSSysLanItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysLanResId(boolean bl, PSSysLanItem pSSysLanItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysLanItem.isPSSysLanResIdDirty() && !bl2 : !pSSysLanItem.isPSSysLanResIdDirty()) {
            return null;
        }
        String string = pSSysLanItem.getPSSysLanResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANRESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysLanResId_Default(pSSysLanItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysLanItem, bl);
    }

    protected void onSyncIndexEntities(PSSysLanItem pSSysLanItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysLanItem, bl);
    }

    public Object getDataContextValue(PSSysLanItem pSSysLanItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysLanItem, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysLanItem pSSysLanItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysLanItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSLANGUAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSLANGUAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSLanguageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSLANITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysLanItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSLANITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysLanItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysLanResName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected String onTestValueRule_PSLanguageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSLanguageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSLANGUAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysLanItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSLANITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysLanItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSLANITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysLanItem pSSysLanItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysLanItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysLanItem pSSysLanItem) throws Exception {
        super.onUpdateParent(pSSysLanItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysLanItem pSSysLanItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSLANITEM");
        if (!bl) {
            pSSysLanItem.setCreateDate(null);
            pSSysLanItem.setCreateMan(null);
            pSSysLanItem.setUpdateDate(null);
            pSSysLanItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSysLanItem, xmlNode, bl);
        }
    }
}

