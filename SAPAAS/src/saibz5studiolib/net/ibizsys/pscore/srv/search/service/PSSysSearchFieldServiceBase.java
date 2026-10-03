/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.search.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.search.dao.PSSysSearchFieldDAO;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchFieldDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDocBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSearchFieldServiceBase
extends PSCoreSysServiceBase<PSSysSearchField> {
    private static final Log log = LogFactory.getLog(PSSysSearchFieldServiceBase.class);
    public static final String DATASET_CURDOC = "CurDoc";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSearchFieldDEModel pSSysSearchFieldDEModel;
    private PSSysSearchFieldDAO pSSysSearchFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.search.service.PSSysSearchFieldService";
    }

    public PSSysSearchFieldDEModel getPSSysSearchFieldDEModel() {
        if (this.pSSysSearchFieldDEModel == null) {
            try {
                this.pSSysSearchFieldDEModel = (PSSysSearchFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSearchFieldDEModel();
    }

    public PSSysSearchFieldDAO getPSSysSearchFieldDAO() {
        if (this.pSSysSearchFieldDAO == null) {
            try {
                this.pSSysSearchFieldDAO = (PSSysSearchFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.search.dao.PSSysSearchFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSearchFieldDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDOC, (boolean)true) == 0) {
            return this.fetchCurDoc(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDoc(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDOC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysSearchField pSSysSearchField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.search.service.PSSysSearchDocService", (SessionFactory)this.getSessionFactory());
            PSSysSearchDoc pSSysSearchDoc = (PSSysSearchDoc)iService.getDEModel().createEntity();
            pSSysSearchDoc.set("PSSYSSEARCHDOCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSearchDoc);
            } else {
                iService.get(pSSysSearchDoc);
            }
            this.onFillParentInfo_PSSysSearchDoc(pSSysSearchField, pSSysSearchDoc);
            return;
        }
        super.onFillParentInfo(pSSysSearchField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysSearchDoc(PSSysSearchField pSSysSearchField, PSSysSearchDoc pSSysSearchDoc) throws Exception {
        pSSysSearchField.setPSSysSearchDocId(pSSysSearchDoc.getPSSysSearchDocId());
        pSSysSearchField.setPSSysSearchDocName(pSSysSearchDoc.getPSSysSearchDocName());
    }

    protected void onFillEntityFullInfo(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
        if (bl && pSSysSearchField.getValidFlag() == null) {
            pSSysSearchField.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysSearchField, bl);
        this.onFillEntityFullInfo_PSSysSearchDoc(pSSysSearchField, bl);
    }

    protected void onFillEntityFullInfo_PSSysSearchDoc(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysSearchField, bl);
    }

    public ArrayList<PSSysSearchField> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, "", -1);
    }

    public ArrayList<PSSysSearchField> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string) throws Exception {
        return this.selectByPSSysSearchDoc(pSSysSearchDocBase, string, -1);
    }

    public ArrayList<PSSysSearchField> selectByPSSysSearchDoc(PSSysSearchDocBase pSSysSearchDocBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHDOCID", (Object)pSSysSearchDocBase.getPSSysSearchDocId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchDocCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchDocCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchField> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHDOC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSearchDoc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID", "", iDataEntityModel.getName(), "PSSYSSEARCHFIELD", iDataEntityModel.getDataInfo(pSSysSearchDoc), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchField> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        for (PSSysSearchField pSSysSearchField : arrayList) {
            PSSysSearchField pSSysSearchField2 = (PSSysSearchField)this.getDEModel().createEntity();
            pSSysSearchField2.setPSSysSearchFieldId(pSSysSearchField.getPSSysSearchFieldId());
            pSSysSearchField2.setPSSysSearchDocId(null);
            this.update(pSSysSearchField2);
        }
    }

    public void removeByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        final PSSysSearchDoc pSSysSearchDoc2 = pSSysSearchDoc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSearchFieldServiceBase.this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysSearchFieldServiceBase.this.internalRemoveByPSSysSearchDoc(pSSysSearchDoc2);
                PSSysSearchFieldServiceBase.this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void internalRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
        ArrayList<PSSysSearchField> arrayList = this.selectByPSSysSearchDoc(pSSysSearchDoc);
        this.onBeforeRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
        for (PSSysSearchField pSSysSearchField : arrayList) {
            this.remove(pSSysSearchField);
        }
        this.onAfterRemoveByPSSysSearchDoc(pSSysSearchDoc, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysSearchField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchDoc(PSSysSearchDoc pSSysSearchDoc, ArrayList<PSSysSearchField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSearchField pSSysSearchField) throws Exception {
        PSSysSearchDEFieldService pSSysSearchDEFieldService = (PSSysSearchDEFieldService)ServiceGlobal.getService(PSSysSearchDEFieldService.class, (SessionFactory)this.getSessionFactory());
        pSSysSearchDEFieldService.testRemoveByPSSysSearchField(pSSysSearchField);
        super.onBeforeRemove(pSSysSearchField);
    }

    protected void replaceParentInfo(PSSysSearchField pSSysSearchField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysSearchField, cloneSession);
        if (pSSysSearchField.getPSSysSearchDocId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHDOC", (Object)pSSysSearchField.getPSSysSearchDocId())) != null) {
            this.onFillParentInfo_PSSysSearchDoc(pSSysSearchField, (PSSysSearchDoc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysSearchField, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Analyzer(bl, pSSysSearchField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DateFormat(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldDataFlag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldParams(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag2(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldType(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreFields(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncInParentFlag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexFlag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Pattern(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKey(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchDocId(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchFieldId(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchFieldName(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchAnalyzer(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StoreFlag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSearchField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysSearchField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Analyzer(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isAnalyzerDirty() : !pSSysSearchField.isAnalyzerDirty()) {
            return null;
        }
        String string = pSSysSearchField.getAnalyzer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Analyzer_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ANALYZER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isCodeNameDirty() && !bl2 : !pSSysSearchField.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysSearchField.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSSEARCHDOCID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchFieldDEModel(), "CODENAME", string3, pSSysSearchField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DateFormat(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isDateFormatDirty() : !pSSysSearchField.isDateFormatDirty()) {
            return null;
        }
        String string = pSSysSearchField.getDateFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DateFormat_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldDataFlag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isFieldDataFlagDirty() : !pSSysSearchField.isFieldDataFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getFieldDataFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FieldDataFlag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDDATAFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldParams(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isFieldParamsDirty() : !pSSysSearchField.isFieldParamsDirty()) {
            return null;
        }
        String string = pSSysSearchField.getFieldParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldParams_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isFieldTagDirty() : !pSSysSearchField.isFieldTagDirty()) {
            return null;
        }
        String string = pSSysSearchField.getFieldTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag2(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isFieldTag2Dirty() : !pSSysSearchField.isFieldTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchField.getFieldTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag2_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldType(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isFieldTypeDirty() : !pSSysSearchField.isFieldTypeDirty()) {
            return null;
        }
        String string = pSSysSearchField.getFieldType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldType_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreFields(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isIgnoreFieldsDirty() : !pSSysSearchField.isIgnoreFieldsDirty()) {
            return null;
        }
        String string = pSSysSearchField.getIgnoreFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IgnoreFields_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncInParentFlag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isIncInParentFlagDirty() : !pSSysSearchField.isIncInParentFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getIncInParentFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncInParentFlag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCINPARENTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexFlag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isIndexFlagDirty() : !pSSysSearchField.isIndexFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getIndexFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IndexFlag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isLogicNameDirty() : !pSSysSearchField.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysSearchField.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isMemoDirty() : !pSSysSearchField.isMemoDirty()) {
            return null;
        }
        String string = pSSysSearchField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysSearchField, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isOrderValueDirty() : !pSSysSearchField.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysSearchField, bl2, bl3);
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

    protected EntityFieldError onCheckField_Pattern(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isPatternDirty() : !pSSysSearchField.isPatternDirty()) {
            return null;
        }
        String string = pSSysSearchField.getPattern();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Pattern_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PATTERN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKey(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isPKeyDirty() : !pSSysSearchField.isPKeyDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getPKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PKey_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSSEARCHDOCID";
                String string2 = this.checkFieldDupRule(this.getPSSysSearchFieldDEModel(), "PKEY", string, pSSysSearchField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PKEY");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchDocId(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isPSSysSearchDocIdDirty() && !bl2 : !pSSysSearchField.isPSSysSearchDocIdDirty()) {
            return null;
        }
        String string = pSSysSearchField.getPSSysSearchDocId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchDocId_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHDOCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchFieldId(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isPSSysSearchFieldIdDirty() && !bl2 : !pSSysSearchField.isPSSysSearchFieldIdDirty()) {
            return null;
        }
        String string = pSSysSearchField.getPSSysSearchFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchFieldId_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchFieldName(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isPSSysSearchFieldNameDirty() && !bl2 : !pSSysSearchField.isPSSysSearchFieldNameDirty()) {
            return null;
        }
        String string = pSSysSearchField.getPSSysSearchFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchFieldName_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSSEARCHDOCID";
                String string4 = this.checkFieldDupRule(this.getPSSysSearchFieldDEModel(), "PSSYSSEARCHFIELDNAME", string3, pSSysSearchField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSEARCHFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchAnalyzer(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isSearchAnalyzerDirty() : !pSSysSearchField.isSearchAnalyzerDirty()) {
            return null;
        }
        String string = pSSysSearchField.getSearchAnalyzer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchAnalyzer_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHANALYZER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isStdDataTypeDirty() : !pSSysSearchField.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StoreFlag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isStoreFlagDirty() : !pSSysSearchField.isStoreFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getStoreFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StoreFlag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STOREFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isUserCatDirty() : !pSSysSearchField.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSearchField.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isUserTagDirty() : !pSSysSearchField.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSearchField.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isUserTag2Dirty() : !pSSysSearchField.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSearchField.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isUserTag3Dirty() : !pSSysSearchField.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSearchField.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isUserTag4Dirty() : !pSSysSearchField.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSearchField.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysSearchField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSearchField pSSysSearchField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSearchField.isValidFlagDirty() && !bl2 : !pSSysSearchField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSearchField.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysSearchField, bl2, bl3);
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

    protected void onSyncEntity(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
        super.onSyncEntity(pSSysSearchField, bl);
    }

    protected void onSyncIndexEntities(PSSysSearchField pSSysSearchField, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysSearchField, bl);
    }

    public Object getDataContextValue(PSSysSearchField pSSysSearchField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysSearchField, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSearchDoc pSSysSearchDoc = pSSysSearchField.getPSSysSearchDoc();
        if (pSSysSearchDoc != null && pSSysSearchDoc.contains(string)) {
            return pSSysSearchDoc.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSearchField pSSysSearchField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysSearchField, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ANALYZER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Analyzer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DateFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDDATAFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldDataFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCINPARENTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncInParentFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PATTERN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Pattern_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchDocName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHANALYZER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchAnalyzer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STOREFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StoreFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Analyzer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ANALYZER", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DateFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldDataFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FieldParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IGNOREFIELDS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IncInParentFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IndexFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Pattern_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PATTERN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysSearchDocId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchDocName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHDOCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHFIELDNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSSEARCHFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchAnalyzer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHANALYZER", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StoreFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSearchField pSSysSearchField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysSearchField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSearchField pSSysSearchField) throws Exception {
        super.onUpdateParent(pSSysSearchField);
    }

    @Override
    protected void exportCurXmlModel(PSSysSearchField pSSysSearchField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSEARCHFIELD");
        if (!bl) {
            pSSysSearchField.setCreateDate(null);
            pSSysSearchField.setCreateMan(null);
            pSSysSearchField.setPSSysSearchFieldId(null);
            pSSysSearchField.setUpdateDate(null);
            pSSysSearchField.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSearchField, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSearchField pSSysSearchField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSearchField, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDOCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSEARCHDOC#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDOCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSEARCHFIELD_PSSYSSEARCHDOC_PSSYSSEARCHDOCID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDOCID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSEARCHDOCNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHDOC", (boolean)true) == 0) {
            iEntity.set("PSSYSSEARCHDOCID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSEARCHDOCID"};
    }

    @Override
    public String getModelV2Tag(PSSysSearchField pSSysSearchField) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchField.getPSSysSearchFieldName())) {
            return pSSysSearchField.getPSSysSearchFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysSearchField.getCodeName())) {
            return pSSysSearchField.getCodeName();
        }
        return super.getModelV2Tag(pSSysSearchField);
    }

    @Override
    public boolean setModelV2Tag(PSSysSearchField pSSysSearchField, String string) {
        pSSysSearchField.setPSSysSearchFieldName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSEARCHFIELDNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSSEARCHDOCID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSearchField pSSysSearchField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSearchField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSearchField, true);
        pSSysSearchField.set("PSSYSSEARCHFIELDNAME", string);
        if (this.select(pSSysSearchField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSearchField, true);
        return super.getModelV2Entity(pSSysSearchField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSearchField pSSysSearchField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysSearchField, objectNode, string, string2, n);
    }
}

