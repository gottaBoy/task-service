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
import net.ibizsys.pscore.srv.config.dao.PSHelpArticleTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpArticleTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSHelpArticleType;
import net.ibizsys.pscore.srv.config.service.PSHelpArtSecService;
import net.ibizsys.pscore.srv.config.service.PSHelpArtSecServiceBase;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService;
import net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpArticleTypeServiceBase
extends PSCoreSysServiceBase<PSHelpArticleType> {
    private static final Log log = LogFactory.getLog(PSHelpArticleTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpArticleTypeDEModel pSHelpArticleTypeDEModel;
    private PSHelpArticleTypeDAO pSHelpArticleTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpArticleTypeService";
    }

    public PSHelpArticleTypeDEModel getPSHelpArticleTypeDEModel() {
        if (this.pSHelpArticleTypeDEModel == null) {
            try {
                this.pSHelpArticleTypeDEModel = (PSHelpArticleTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpArticleTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpArticleTypeDEModel();
    }

    public PSHelpArticleTypeDAO getPSHelpArticleTypeDAO() {
        if (this.pSHelpArticleTypeDAO == null) {
            try {
                this.pSHelpArticleTypeDAO = (PSHelpArticleTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpArticleTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpArticleTypeDAO();
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

    protected void onFillParentInfo(PSHelpArticleType pSHelpArticleType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPARTICLETYPE_PSHELPARTICLETEMPL_PSHELPARTICLETEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpArticleTemplService", (SessionFactory)this.getSessionFactory());
            PSHelpArticleTempl pSHelpArticleTempl = (PSHelpArticleTempl)iService.getDEModel().createEntity();
            pSHelpArticleTempl.set("PSHELPARTICLETEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpArticleTempl);
            } else {
                iService.get(pSHelpArticleTempl);
            }
            this.onFillParentInfo_PSHelpArticleTempl(pSHelpArticleType, pSHelpArticleTempl);
            return;
        }
        super.onFillParentInfo(pSHelpArticleType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpArticleTempl(PSHelpArticleType pSHelpArticleType, PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        pSHelpArticleType.setPSHelpArticleTemplId(pSHelpArticleTempl.getPSHelpArticleTemplId());
        pSHelpArticleType.setPSHelpArticleTemplName(pSHelpArticleTempl.getPSHelpArticleTemplName());
    }

    protected void onFillEntityFullInfo(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
        if (bl && pSHelpArticleType.getValidFlag() == null) {
            pSHelpArticleType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpArticleType, bl);
        this.onFillEntityFullInfo_PSHelpArticleTempl(pSHelpArticleType, bl);
    }

    protected void onFillEntityFullInfo_PSHelpArticleTempl(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpArticleType, bl);
    }

    public ArrayList<PSHelpArticleType> selectByPSHelpArticleTempl(PSHelpArticleTemplBase pSHelpArticleTemplBase) throws Exception {
        return this.selectByPSHelpArticleTempl(pSHelpArticleTemplBase, "", -1);
    }

    public ArrayList<PSHelpArticleType> selectByPSHelpArticleTempl(PSHelpArticleTemplBase pSHelpArticleTemplBase, String string) throws Exception {
        return this.selectByPSHelpArticleTempl(pSHelpArticleTemplBase, string, -1);
    }

    public ArrayList<PSHelpArticleType> selectByPSHelpArticleTempl(PSHelpArticleTemplBase pSHelpArticleTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPARTICLETEMPLID", (Object)pSHelpArticleTemplBase.getPSHelpArticleTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpArticleTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpArticleTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        ArrayList<PSHelpArticleType> arrayList = this.selectByPSHelpArticleTempl(pSHelpArticleTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPARTICLETEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpArticleTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPARTICLETYPE_PSHELPARTICLETEMPL_PSHELPARTICLETEMPLID", "", iDataEntityModel.getName(), "PSHELPARTICLETYPE", iDataEntityModel.getDataInfo(pSHelpArticleTempl), arrayList.get(0)));
        }
    }

    public void resetPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        ArrayList<PSHelpArticleType> arrayList = this.selectByPSHelpArticleTempl(pSHelpArticleTempl);
        for (PSHelpArticleType pSHelpArticleType : arrayList) {
            PSHelpArticleType pSHelpArticleType2 = (PSHelpArticleType)this.getDEModel().createEntity();
            pSHelpArticleType2.setPSHelpArticleTypeId(pSHelpArticleType.getPSHelpArticleTypeId());
            pSHelpArticleType2.setPSHelpArticleTemplId(null);
            this.update(pSHelpArticleType2);
        }
    }

    public void removeByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        final PSHelpArticleTempl pSHelpArticleTempl2 = pSHelpArticleTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpArticleTypeServiceBase.this.onBeforeRemoveByPSHelpArticleTempl(pSHelpArticleTempl2);
                PSHelpArticleTypeServiceBase.this.internalRemoveByPSHelpArticleTempl(pSHelpArticleTempl2);
                PSHelpArticleTypeServiceBase.this.onAfterRemoveByPSHelpArticleTempl(pSHelpArticleTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
    }

    protected void internalRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
        ArrayList<PSHelpArticleType> arrayList = this.selectByPSHelpArticleTempl(pSHelpArticleTempl);
        this.onBeforeRemoveByPSHelpArticleTempl(pSHelpArticleTempl, arrayList);
        for (PSHelpArticleType pSHelpArticleType : arrayList) {
            this.remove(pSHelpArticleType);
        }
        this.onAfterRemoveByPSHelpArticleTempl(pSHelpArticleTempl, arrayList);
    }

    protected void onAfterRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl, ArrayList<PSHelpArticleType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpArticleTempl(PSHelpArticleTempl pSHelpArticleTempl, ArrayList<PSHelpArticleType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpArticleType pSHelpArticleType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSHelpArticleTemplService)ServiceGlobal.getService(PSHelpArticleTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpArticleTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticleType(pSHelpArticleType);
        pSCoreSysServiceBase = (PSHelpArtSecService)ServiceGlobal.getService(PSHelpArtSecService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpArtSecServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticleType(pSHelpArticleType);
        ((PSHelpArtSecServiceBase)pSCoreSysServiceBase).removeByPSHelpArticleType(pSHelpArticleType);
        super.onBeforeRemove(pSHelpArticleType);
    }

    protected void replaceParentInfo(PSHelpArticleType pSHelpArticleType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpArticleType, cloneSession);
        if (pSHelpArticleType.getPSHelpArticleTemplId() != null && (iEntity = cloneSession.getEntity("PSHELPARTICLETEMPL", (Object)pSHelpArticleType.getPSHelpArticleTemplId())) != null) {
            this.onFillParentInfo_PSHelpArticleTempl(pSHelpArticleType, (PSHelpArticleTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpArticleType, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ArticleObj(bl, pSHelpArticleType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTemplId(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTypeId(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpArticleTypeName(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpArticleType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpArticleType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ArticleObj(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isArticleObjDirty() : !pSHelpArticleType.isArticleObjDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getArticleObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ArticleObj_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARTICLEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isMemoDirty() : !pSHelpArticleType.isMemoDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpArticleType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpArticleTemplId(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isPSHelpArticleTemplIdDirty() : !pSHelpArticleType.isPSHelpArticleTemplIdDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getPSHelpArticleTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTemplId_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleTypeId(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isPSHelpArticleTypeIdDirty() && !bl2 : !pSHelpArticleType.isPSHelpArticleTypeIdDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getPSHelpArticleTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTypeId_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpArticleTypeName(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isPSHelpArticleTypeNameDirty() && !bl2 : !pSHelpArticleType.isPSHelpArticleTypeNameDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getPSHelpArticleTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpArticleTypeName_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPARTICLETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isPubObjDirty() && !bl2 : !pSHelpArticleType.isPubObjDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isTypeObjDirty() : !pSHelpArticleType.isTypeObjDirty()) {
            return null;
        }
        String string = pSHelpArticleType.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default(pSHelpArticleType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpArticleType pSHelpArticleType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpArticleType.isValidFlagDirty() && !bl2 : !pSHelpArticleType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpArticleType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpArticleType, bl2, bl3);
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

    protected void onSyncEntity(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpArticleType, bl);
    }

    protected void onSyncIndexEntities(PSHelpArticleType pSHelpArticleType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpArticleType, bl);
    }

    public Object getDataContextValue(PSHelpArticleType pSHelpArticleType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpArticleType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpArticleType pSHelpArticleType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpArticleType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ARTICLEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArticleObj_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPARTICLETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpArticleTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ArticleObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ARTICLEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpArticleTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPARTICLETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSHelpArticleType pSHelpArticleType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpArticleType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpArticleType pSHelpArticleType) throws Exception {
        super.onUpdateParent(pSHelpArticleType);
    }

    @Override
    protected void exportCurXmlModel(PSHelpArticleType pSHelpArticleType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPARTICLETYPE");
        if (!bl) {
            pSHelpArticleType.setCreateDate(null);
            pSHelpArticleType.setCreateMan(null);
            pSHelpArticleType.setPSHelpArticleTemplName(null);
            pSHelpArticleType.setUpdateDate(null);
            pSHelpArticleType.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpArticleType, xmlNode, bl);
        }
    }
}

