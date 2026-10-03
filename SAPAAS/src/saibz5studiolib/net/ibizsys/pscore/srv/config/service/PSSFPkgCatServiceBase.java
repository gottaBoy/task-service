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
import net.ibizsys.pscore.srv.config.dao.PSSFPkgCatDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPkgCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgCat;
import net.ibizsys.pscore.srv.config.service.PSSFPkgService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPkgCatServiceBase
extends PSCoreSysServiceBase<PSSFPkgCat> {
    private static final Log log = LogFactory.getLog(PSSFPkgCatServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPkgCatDEModel pSSFPkgCatDEModel;
    private PSSFPkgCatDAO pSSFPkgCatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPkgCatService";
    }

    public PSSFPkgCatDEModel getPSSFPkgCatDEModel() {
        if (this.pSSFPkgCatDEModel == null) {
            try {
                this.pSSFPkgCatDEModel = (PSSFPkgCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPkgCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgCatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPkgCatDEModel();
    }

    public PSSFPkgCatDAO getPSSFPkgCatDAO() {
        if (this.pSSFPkgCatDAO == null) {
            try {
                this.pSSFPkgCatDAO = (PSSFPkgCatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPkgCatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgCatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPkgCatDAO();
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

    protected void onFillParentInfo(PSSFPkgCat pSSFPkgCat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPKGCAT_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFPkgCat, pSSF);
            return;
        }
        super.onFillParentInfo(pSSFPkgCat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSF(PSSFPkgCat pSSFPkgCat, PSSF pSSF) throws Exception {
        pSSFPkgCat.setPSSFId(pSSF.getPSSFId());
        pSSFPkgCat.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFPkgCat, bl);
        this.onFillEntityFullInfo_PSSF(pSSFPkgCat, bl);
    }

    protected void onFillEntityFullInfo_PSSF(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        if (pSSFPkgCat.isPSSFIdDirty()) {
            if (pSSFPkgCat.getPSSFId() != null) {
                if (pSSFPkgCat.getPSSFId() == null || pSSFPkgCat.getPSSFName() == null) {
                    PSSF pSSF = pSSFPkgCat.getPSSF();
                    pSSFPkgCat.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSFPkgCat.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFPkgCat, bl);
    }

    public ArrayList<PSSFPkgCat> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFPkgCat> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFPkgCat> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPkgCat> arrayList = this.selectByPSSF(pSSF);
        for (PSSFPkgCat pSSFPkgCat : arrayList) {
            PSSFPkgCat pSSFPkgCat2 = (PSSFPkgCat)this.getDEModel().createEntity();
            pSSFPkgCat2.setPSSFPkgCatId(pSSFPkgCat.getPSSFPkgCatId());
            pSSFPkgCat2.setPSSFId(null);
            this.update(pSSFPkgCat2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPkgCatServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFPkgCatServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFPkgCatServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFPkgCat> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFPkgCat pSSFPkgCat : arrayList) {
            this.remove(pSSFPkgCat);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPkgCat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFPkgCat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPkgCat pSSFPkgCat) throws Exception {
        PSSFPkgService pSSFPkgService = (PSSFPkgService)ServiceGlobal.getService(PSSFPkgService.class, (SessionFactory)this.getSessionFactory());
        pSSFPkgService.testRemoveByPSSFPkgCat(pSSFPkgCat);
        super.onBeforeRemove(pSSFPkgCat);
    }

    protected void replaceParentInfo(PSSFPkgCat pSSFPkgCat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFPkgCat, cloneSession);
        if (pSSFPkgCat.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFPkgCat.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFPkgCat, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFPkgCat, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CatTag(bl, pSSFPkgCat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatTag2(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgCatId(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgCatName(bl, pSSFPkgCat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFPkgCat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CatTag(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isCatTagDirty() : !pSSFPkgCat.isCatTagDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getCatTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CatTag2(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isCatTag2Dirty() : !pSSFPkgCat.isCatTag2Dirty()) {
            return null;
        }
        String string = pSSFPkgCat.getCatTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatTag2_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isMemoDirty() : !pSSFPkgCat.isMemoDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFPkgCat, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isPSSFIdDirty() : !pSSFPkgCat.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isPSSFNameDirty() : !pSSFPkgCat.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgCatId(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isPSSFPkgCatIdDirty() && !bl2 : !pSSFPkgCat.isPSSFPkgCatIdDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getPSSFPkgCatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGCATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgCatId_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgCatName(boolean bl, PSSFPkgCat pSSFPkgCat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPkgCat.isPSSFPkgCatNameDirty() && !bl2 : !pSSFPkgCat.isPSSFPkgCatNameDirty()) {
            return null;
        }
        String string = pSSFPkgCat.getPSSFPkgCatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGCATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgCatName_Default(pSSFPkgCat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGCATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        super.onSyncEntity(pSSFPkgCat, bl);
    }

    protected void onSyncIndexEntities(PSSFPkgCat pSSFPkgCat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFPkgCat, bl);
    }

    public Object getDataContextValue(PSSFPkgCat pSSFPkgCat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFPkgCat, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPkgCat pSSFPkgCat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFPkgCat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CATTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CatTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSFPkgCat pSSFPkgCat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFPkgCat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPkgCat pSSFPkgCat) throws Exception {
        super.onUpdateParent(pSSFPkgCat);
    }

    @Override
    protected void exportCurXmlModel(PSSFPkgCat pSSFPkgCat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPKGCAT");
        if (!bl) {
            pSSFPkgCat.setCreateDate(null);
            pSSFPkgCat.setCreateMan(null);
            pSSFPkgCat.setPSSFPkgCatId(null);
            pSSFPkgCat.setUpdateDate(null);
            pSSFPkgCat.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPkgCat, xmlNode, bl);
        }
    }
}

