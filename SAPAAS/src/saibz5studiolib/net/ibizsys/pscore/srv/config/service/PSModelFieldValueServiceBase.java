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
import net.ibizsys.pscore.srv.config.dao.PSModelFieldValueDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelFieldValueDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldBase;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldValue;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroup;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroupBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelFieldValueServiceBase
extends PSCoreSysServiceBase<PSModelFieldValue> {
    private static final Log log = LogFactory.getLog(PSModelFieldValueServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelFieldValueDEModel pSModelFieldValueDEModel;
    private PSModelFieldValueDAO pSModelFieldValueDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelFieldValueService";
    }

    public PSModelFieldValueDEModel getPSModelFieldValueDEModel() {
        if (this.pSModelFieldValueDEModel == null) {
            try {
                this.pSModelFieldValueDEModel = (PSModelFieldValueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelFieldValueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelFieldValueDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelFieldValueDEModel();
    }

    public PSModelFieldValueDAO getPSModelFieldValueDAO() {
        if (this.pSModelFieldValueDAO == null) {
            try {
                this.pSModelFieldValueDAO = (PSModelFieldValueDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelFieldValueDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelFieldValueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelFieldValueDAO();
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

    protected void onFillParentInfo(PSModelFieldValue pSModelFieldValue, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELFIELDVALUE_PSMODELFIELD_PSMODELFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelFieldService", (SessionFactory)this.getSessionFactory());
            PSModelField pSModelField = (PSModelField)iService.getDEModel().createEntity();
            pSModelField.set("PSMODELFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelField);
            } else {
                iService.get(pSModelField);
            }
            this.onFillParentInfo_PSModelField(pSModelFieldValue, pSModelField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELFIELDVALUE_PSMODELVALUEGROUP_PSMODELVALUEGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelValueGroupService", (SessionFactory)this.getSessionFactory());
            PSModelValueGroup pSModelValueGroup = (PSModelValueGroup)iService.getDEModel().createEntity();
            pSModelValueGroup.set("PSMODELVALUEGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelValueGroup);
            } else {
                iService.get(pSModelValueGroup);
            }
            this.onFillParentInfo_PSModelValueGroup(pSModelFieldValue, pSModelValueGroup);
            return;
        }
        super.onFillParentInfo(pSModelFieldValue, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelField(PSModelFieldValue pSModelFieldValue, PSModelField pSModelField) throws Exception {
        pSModelFieldValue.setPSModelFieldId(pSModelField.getPSModelFieldId());
        pSModelFieldValue.setPSModelFieldName(pSModelField.getPSModelFieldName());
    }

    protected void onFillParentInfo_PSModelValueGroup(PSModelFieldValue pSModelFieldValue, PSModelValueGroup pSModelValueGroup) throws Exception {
        pSModelFieldValue.setPSModelValueGroupId(pSModelValueGroup.getPSModelValueGroupId());
        pSModelFieldValue.setPSModelValueGroupName(pSModelValueGroup.getPSModelValueGroupName());
    }

    protected void onFillEntityFullInfo(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        if (bl && pSModelFieldValue.getValidFlag() == null) {
            pSModelFieldValue.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelFieldValue, bl);
        this.onFillEntityFullInfo_PSModelField(pSModelFieldValue, bl);
        this.onFillEntityFullInfo_PSModelValueGroup(pSModelFieldValue, bl);
    }

    protected void onFillEntityFullInfo_PSModelField(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        if (pSModelFieldValue.isPSModelFieldIdDirty()) {
            if (pSModelFieldValue.getPSModelFieldId() != null) {
                if (pSModelFieldValue.getPSModelFieldId() == null || pSModelFieldValue.getPSModelFieldName() == null) {
                    PSModelField pSModelField = pSModelFieldValue.getPSModelField();
                    pSModelFieldValue.setPSModelFieldName(pSModelField.getPSModelFieldName());
                }
            } else {
                pSModelFieldValue.setPSModelFieldName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModelValueGroup(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelFieldValue, bl);
    }

    public ArrayList<PSModelFieldValue> selectByPSModelField(PSModelFieldBase pSModelFieldBase) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, "", -1);
    }

    public ArrayList<PSModelFieldValue> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, string, -1);
    }

    public ArrayList<PSModelFieldValue> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELFIELDID", (Object)pSModelFieldBase.getPSModelFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelFieldValue> selectByPSModelValueGroup(PSModelValueGroupBase pSModelValueGroupBase) throws Exception {
        return this.selectByPSModelValueGroup(pSModelValueGroupBase, "", -1);
    }

    public ArrayList<PSModelFieldValue> selectByPSModelValueGroup(PSModelValueGroupBase pSModelValueGroupBase, String string) throws Exception {
        return this.selectByPSModelValueGroup(pSModelValueGroupBase, string, -1);
    }

    public ArrayList<PSModelFieldValue> selectByPSModelValueGroup(PSModelValueGroupBase pSModelValueGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELVALUEGROUPID", (Object)pSModelValueGroupBase.getPSModelValueGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelValueGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelValueGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelField(pSModelField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELFIELDVALUE_PSMODELFIELD_PSMODELFIELDID", "", iDataEntityModel.getName(), "PSMODELFIELDVALUE", iDataEntityModel.getDataInfo(pSModelField), arrayList.get(0)));
        }
    }

    public void resetPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelField(pSModelField);
        for (PSModelFieldValue pSModelFieldValue : arrayList) {
            PSModelFieldValue pSModelFieldValue2 = (PSModelFieldValue)this.getDEModel().createEntity();
            pSModelFieldValue2.setPSModelFieldValueId(pSModelFieldValue.getPSModelFieldValueId());
            pSModelFieldValue2.setPSModelFieldId(null);
            this.update(pSModelFieldValue2);
        }
    }

    public void removeByPSModelField(PSModelField pSModelField) throws Exception {
        final PSModelField pSModelField2 = pSModelField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelFieldValueServiceBase.this.onBeforeRemoveByPSModelField(pSModelField2);
                PSModelFieldValueServiceBase.this.internalRemoveByPSModelField(pSModelField2);
                PSModelFieldValueServiceBase.this.onAfterRemoveByPSModelField(pSModelField2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void internalRemoveByPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelField(pSModelField);
        this.onBeforeRemoveByPSModelField(pSModelField, arrayList);
        for (PSModelFieldValue pSModelFieldValue : arrayList) {
            this.remove(pSModelFieldValue);
        }
        this.onAfterRemoveByPSModelField(pSModelField, arrayList);
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSModelFieldValue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSModelFieldValue> arrayList) throws Exception {
    }

    public void testRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelValueGroup(pSModelValueGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELVALUEGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelValueGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELFIELDVALUE_PSMODELVALUEGROUP_PSMODELVALUEGROUPID", "", iDataEntityModel.getName(), "PSMODELFIELDVALUE", iDataEntityModel.getDataInfo(pSModelValueGroup), arrayList.get(0)));
        }
    }

    public void resetPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelValueGroup(pSModelValueGroup);
        for (PSModelFieldValue pSModelFieldValue : arrayList) {
            PSModelFieldValue pSModelFieldValue2 = (PSModelFieldValue)this.getDEModel().createEntity();
            pSModelFieldValue2.setPSModelFieldValueId(pSModelFieldValue.getPSModelFieldValueId());
            pSModelFieldValue2.setPSModelValueGroupId(null);
            this.update(pSModelFieldValue2);
        }
    }

    public void removeByPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
        final PSModelValueGroup pSModelValueGroup2 = pSModelValueGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelFieldValueServiceBase.this.onBeforeRemoveByPSModelValueGroup(pSModelValueGroup2);
                PSModelFieldValueServiceBase.this.internalRemoveByPSModelValueGroup(pSModelValueGroup2);
                PSModelFieldValueServiceBase.this.onAfterRemoveByPSModelValueGroup(pSModelValueGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
    }

    protected void internalRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
        ArrayList<PSModelFieldValue> arrayList = this.selectByPSModelValueGroup(pSModelValueGroup);
        this.onBeforeRemoveByPSModelValueGroup(pSModelValueGroup, arrayList);
        for (PSModelFieldValue pSModelFieldValue : arrayList) {
            this.remove(pSModelFieldValue);
        }
        this.onAfterRemoveByPSModelValueGroup(pSModelValueGroup, arrayList);
    }

    protected void onAfterRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup, ArrayList<PSModelFieldValue> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelValueGroup(PSModelValueGroup pSModelValueGroup, ArrayList<PSModelFieldValue> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelFieldValue pSModelFieldValue) throws Exception {
        super.onBeforeRemove(pSModelFieldValue);
    }

    protected void replaceParentInfo(PSModelFieldValue pSModelFieldValue, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelFieldValue, cloneSession);
        if (pSModelFieldValue.getPSModelFieldId() != null && (iEntity = cloneSession.getEntity("PSMODELFIELD", (Object)pSModelFieldValue.getPSModelFieldId())) != null) {
            this.onFillParentInfo_PSModelField(pSModelFieldValue, (PSModelField)iEntity);
        }
        if (pSModelFieldValue.getPSModelValueGroupId() != null && (iEntity = cloneSession.getEntity("PSMODELVALUEGROUP", (Object)pSModelFieldValue.getPSModelValueGroupId())) != null) {
            this.onFillParentInfo_PSModelValueGroup(pSModelFieldValue, (PSModelValueGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelFieldValue, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConceptContent(bl, pSModelFieldValue, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConceptFlag(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConceptTitle(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImageFlag(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkFlag(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldId(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldName(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldValueId(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldValueName(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelValueGroupId(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueDesc(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFlag(bl, pSModelFieldValue, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelFieldValue, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConceptContent(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isConceptContentDirty() : !pSModelFieldValue.isConceptContentDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getConceptContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConceptContent_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONCEPTCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConceptFlag(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isConceptFlagDirty() : !pSModelFieldValue.isConceptFlagDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getConceptFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ConceptFlag_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONCEPTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConceptTitle(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isConceptTitleDirty() : !pSModelFieldValue.isConceptTitleDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getConceptTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConceptTitle_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONCEPTTITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImageFlag(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isImageFlagDirty() : !pSModelFieldValue.isImageFlagDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getImageFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImageFlag_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMAGEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkFlag(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isLinkFlagDirty() : !pSModelFieldValue.isLinkFlagDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getLinkFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkFlag_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isMemoDirty() : !pSModelFieldValue.isMemoDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelFieldValue, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isOrderValueDirty() : !pSModelFieldValue.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSModelFieldValue, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelFieldId(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isPSModelFieldIdDirty() : !pSModelFieldValue.isPSModelFieldIdDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getPSModelFieldId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldId_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldName(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isPSModelFieldNameDirty() : !pSModelFieldValue.isPSModelFieldNameDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getPSModelFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldName_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldValueId(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isPSModelFieldValueIdDirty() && !bl2 : !pSModelFieldValue.isPSModelFieldValueIdDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getPSModelFieldValueId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDVALUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldValueId_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDVALUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldValueName(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isPSModelFieldValueNameDirty() && !bl2 : !pSModelFieldValue.isPSModelFieldValueNameDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getPSModelFieldValueName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDVALUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldValueName_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDVALUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelValueGroupId(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isPSModelValueGroupIdDirty() : !pSModelFieldValue.isPSModelValueGroupIdDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getPSModelValueGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelValueGroupId_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVALUEGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isValidFlagDirty() && !bl2 : !pSModelFieldValue.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelFieldValue, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isValueDirty() : !pSModelFieldValue.isValueDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Value_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueDesc(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isValueDescDirty() : !pSModelFieldValue.isValueDescDirty()) {
            return null;
        }
        String string = pSModelFieldValue.getValueDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueDesc_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFlag(boolean bl, PSModelFieldValue pSModelFieldValue, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelFieldValue.isValueFlagDirty() : !pSModelFieldValue.isValueFlagDirty()) {
            return null;
        }
        Integer n = pSModelFieldValue.getValueFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValueFlag_Default(pSModelFieldValue, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        super.onSyncEntity(pSModelFieldValue, bl);
    }

    protected void onSyncIndexEntities(PSModelFieldValue pSModelFieldValue, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelFieldValue, bl);
    }

    public Object getDataContextValue(PSModelFieldValue pSModelFieldValue, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelFieldValue, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelFieldValue pSModelFieldValue, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelFieldValue, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONCEPTCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConceptContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONCEPTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConceptFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONCEPTTITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConceptTitle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMAGEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImageFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDVALUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldValueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDVALUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldValueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVALUEGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelValueGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVALUEGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelValueGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ConceptContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONCEPTCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConceptFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ConceptTitle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONCEPTTITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ImageFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSModelFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldValueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDVALUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldValueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDVALUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelValueGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVALUEGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelValueGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVALUEGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Value_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelFieldValue pSModelFieldValue) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelFieldValue)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelFieldValue pSModelFieldValue) throws Exception {
        super.onUpdateParent(pSModelFieldValue);
    }

    @Override
    protected void exportCurXmlModel(PSModelFieldValue pSModelFieldValue, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELFIELDVALUE");
        if (!bl) {
            pSModelFieldValue.setCreateDate(null);
            pSModelFieldValue.setCreateMan(null);
            pSModelFieldValue.setPSModelFieldValueId(null);
            pSModelFieldValue.setPSModelValueGroupName(null);
            pSModelFieldValue.setUpdateDate(null);
            pSModelFieldValue.setUpdateMan(null);
            super.exportCurXmlModel(pSModelFieldValue, xmlNode, bl);
        }
    }
}

