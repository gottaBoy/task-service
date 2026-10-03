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
import net.ibizsys.pscore.srv.config.dao.PSHelpSectionTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpSectionTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSHelpSectionType;
import net.ibizsys.pscore.srv.config.service.PSHelpArtSecService;
import net.ibizsys.pscore.srv.config.service.PSHelpArtSecServiceBase;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService;
import net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpSectionTypeServiceBase
extends PSCoreSysServiceBase<PSHelpSectionType> {
    private static final Log log = LogFactory.getLog(PSHelpSectionTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpSectionTypeDEModel pSHelpSectionTypeDEModel;
    private PSHelpSectionTypeDAO pSHelpSectionTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpSectionTypeService";
    }

    public PSHelpSectionTypeDEModel getPSHelpSectionTypeDEModel() {
        if (this.pSHelpSectionTypeDEModel == null) {
            try {
                this.pSHelpSectionTypeDEModel = (PSHelpSectionTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpSectionTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpSectionTypeDEModel();
    }

    public PSHelpSectionTypeDAO getPSHelpSectionTypeDAO() {
        if (this.pSHelpSectionTypeDAO == null) {
            try {
                this.pSHelpSectionTypeDAO = (PSHelpSectionTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpSectionTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpSectionTypeDAO();
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

    protected void onFillParentInfo(PSHelpSectionType pSHelpSectionType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPSECTIONTYPE_PSHELPSECTIONTEMPL_PSHELPSECTIONTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpSectionTemplService", (SessionFactory)this.getSessionFactory());
            PSHelpSectionTempl pSHelpSectionTempl = (PSHelpSectionTempl)iService.getDEModel().createEntity();
            pSHelpSectionTempl.set("PSHELPSECTIONTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpSectionTempl);
            } else {
                iService.get(pSHelpSectionTempl);
            }
            this.onFillParentInfo_PSHelpSectionTempl(pSHelpSectionType, pSHelpSectionTempl);
            return;
        }
        super.onFillParentInfo(pSHelpSectionType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpSectionTempl(PSHelpSectionType pSHelpSectionType, PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        pSHelpSectionType.setPSHelpSectionTemplId(pSHelpSectionTempl.getPSHelpSectionTemplId());
        pSHelpSectionType.setPSHelpSectionTemplName(pSHelpSectionTempl.getPSHelpSectionTemplName());
    }

    protected void onFillEntityFullInfo(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
        if (bl && pSHelpSectionType.getValidFlag() == null) {
            pSHelpSectionType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSHelpSectionType, bl);
        this.onFillEntityFullInfo_PSHelpSectionTempl(pSHelpSectionType, bl);
    }

    protected void onFillEntityFullInfo_PSHelpSectionTempl(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
        super.onWriteBackParent(pSHelpSectionType, bl);
    }

    public ArrayList<PSHelpSectionType> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase) throws Exception {
        return this.selectByPSHelpSectionTempl(pSHelpSectionTemplBase, "", -1);
    }

    public ArrayList<PSHelpSectionType> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase, String string) throws Exception {
        return this.selectByPSHelpSectionTempl(pSHelpSectionTemplBase, string, -1);
    }

    public ArrayList<PSHelpSectionType> selectByPSHelpSectionTempl(PSHelpSectionTemplBase pSHelpSectionTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPSECTIONTEMPLID", (Object)pSHelpSectionTemplBase.getPSHelpSectionTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpSectionTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpSectionTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSectionType> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPSECTIONTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpSectionTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSHELPSECTIONTYPE_PSHELPSECTIONTEMPL_PSHELPSECTIONTEMPLID", "", iDataEntityModel.getName(), "PSHELPSECTIONTYPE", iDataEntityModel.getDataInfo(pSHelpSectionTempl), arrayList.get(0)));
        }
    }

    public void resetPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSectionType> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl);
        for (PSHelpSectionType pSHelpSectionType : arrayList) {
            PSHelpSectionType pSHelpSectionType2 = (PSHelpSectionType)this.getDEModel().createEntity();
            pSHelpSectionType2.setPSHelpSectionTypeId(pSHelpSectionType.getPSHelpSectionTypeId());
            pSHelpSectionType2.setPSHelpSectionTemplId(null);
            this.update(pSHelpSectionType2);
        }
    }

    public void removeByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        final PSHelpSectionTempl pSHelpSectionTempl2 = pSHelpSectionTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpSectionTypeServiceBase.this.onBeforeRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
                PSHelpSectionTypeServiceBase.this.internalRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
                PSHelpSectionTypeServiceBase.this.onAfterRemoveByPSHelpSectionTempl(pSHelpSectionTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
    }

    protected void internalRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
        ArrayList<PSHelpSectionType> arrayList = this.selectByPSHelpSectionTempl(pSHelpSectionTempl);
        this.onBeforeRemoveByPSHelpSectionTempl(pSHelpSectionTempl, arrayList);
        for (PSHelpSectionType pSHelpSectionType : arrayList) {
            this.remove(pSHelpSectionType);
        }
        this.onAfterRemoveByPSHelpSectionTempl(pSHelpSectionTempl, arrayList);
    }

    protected void onAfterRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl, ArrayList<PSHelpSectionType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpSectionTempl(PSHelpSectionTempl pSHelpSectionTempl, ArrayList<PSHelpSectionType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpSectionType pSHelpSectionType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSHelpArtSecService)ServiceGlobal.getService(PSHelpArtSecService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpArtSecServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpSectionType(pSHelpSectionType);
        pSCoreSysServiceBase = (PSHelpSectionTemplService)ServiceGlobal.getService(PSHelpSectionTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSHelpArticleType(pSHelpSectionType);
        super.onBeforeRemove(pSHelpSectionType);
    }

    protected void replaceParentInfo(PSHelpSectionType pSHelpSectionType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSHelpSectionType, cloneSession);
        if (pSHelpSectionType.getPSHelpSectionTemplId() != null && (iEntity = cloneSession.getEntity("PSHELPSECTIONTEMPL", (Object)pSHelpSectionType.getPSHelpSectionTemplId())) != null) {
            this.onFillParentInfo_PSHelpSectionTempl(pSHelpSectionType, (PSHelpSectionTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSHelpSectionType, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSHelpSectionType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OutputDir(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTemplId(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTypeId(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpSectionTypeName(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionObj(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpSectionType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSHelpSectionType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isMemoDirty() : !pSHelpSectionType.isMemoDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSHelpSectionType, bl2, bl3);
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

    protected EntityFieldError onCheckField_OutputDir(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isOutputDirDirty() : !pSHelpSectionType.isOutputDirDirty()) {
            return null;
        }
        Integer n = pSHelpSectionType.getOutputDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OutputDir_Default(pSHelpSectionType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OUTPUTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTemplId(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isPSHelpSectionTemplIdDirty() : !pSHelpSectionType.isPSHelpSectionTemplIdDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getPSHelpSectionTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTemplId_Default(pSHelpSectionType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTypeId(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isPSHelpSectionTypeIdDirty() && !bl2 : !pSHelpSectionType.isPSHelpSectionTypeIdDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getPSHelpSectionTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTypeId_Default(pSHelpSectionType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpSectionTypeName(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isPSHelpSectionTypeNameDirty() && !bl2 : !pSHelpSectionType.isPSHelpSectionTypeNameDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getPSHelpSectionTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpSectionTypeName_Default(pSHelpSectionType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPSECTIONTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isPubObjDirty() && !bl2 : !pSHelpSectionType.isPubObjDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSHelpSectionType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SectionObj(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isSectionObjDirty() : !pSHelpSectionType.isSectionObjDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getSectionObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionObj_Default(pSHelpSectionType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isTypeObjDirty() : !pSHelpSectionType.isTypeObjDirty()) {
            return null;
        }
        String string = pSHelpSectionType.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default(pSHelpSectionType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpSectionType pSHelpSectionType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpSectionType.isValidFlagDirty() && !bl2 : !pSHelpSectionType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpSectionType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSHelpSectionType, bl2, bl3);
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

    protected void onSyncEntity(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
        super.onSyncEntity(pSHelpSectionType, bl);
    }

    protected void onSyncIndexEntities(PSHelpSectionType pSHelpSectionType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSHelpSectionType, bl);
    }

    public Object getDataContextValue(PSHelpSectionType pSHelpSectionType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSHelpSectionType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpSectionType pSHelpSectionType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSHelpSectionType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"OUTPUTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OutputDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPSECTIONTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpSectionTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionObj_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OutputDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSHelpSectionTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpSectionTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPSECTIONTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SectionObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSHelpSectionType pSHelpSectionType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSHelpSectionType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpSectionType pSHelpSectionType) throws Exception {
        super.onUpdateParent(pSHelpSectionType);
    }

    @Override
    protected void exportCurXmlModel(PSHelpSectionType pSHelpSectionType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPSECTIONTYPE");
        if (!bl) {
            pSHelpSectionType.setCreateDate(null);
            pSHelpSectionType.setCreateMan(null);
            pSHelpSectionType.setPSHelpSectionTemplName(null);
            pSHelpSectionType.setUpdateDate(null);
            pSHelpSectionType.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpSectionType, xmlNode, bl);
        }
    }
}

