/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSWFEngineTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSWFEngineTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSWFEngineType;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFEngineTypeServiceBase
extends PSCoreSysServiceBase<PSWFEngineType> {
    private static final Log log = LogFactory.getLog(PSWFEngineTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWFEngineTypeDEModel pSWFEngineTypeDEModel;
    private PSWFEngineTypeDAO pSWFEngineTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSWFEngineTypeService";
    }

    public PSWFEngineTypeDEModel getPSWFEngineTypeDEModel() {
        if (this.pSWFEngineTypeDEModel == null) {
            try {
                this.pSWFEngineTypeDEModel = (PSWFEngineTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSWFEngineTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFEngineTypeDEModel();
    }

    public PSWFEngineTypeDAO getPSWFEngineTypeDAO() {
        if (this.pSWFEngineTypeDAO == null) {
            try {
                this.pSWFEngineTypeDAO = (PSWFEngineTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSWFEngineTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFEngineTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFEngineTypeDAO();
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

    protected void onFillParentInfo(PSWFEngineType pSWFEngineType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSWFEngineType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSWFEngineType pSWFEngineType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWFEngineType, bl);
    }

    protected void onWriteBackParent(PSWFEngineType pSWFEngineType, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFEngineType, bl);
    }

    @Override
    protected void onBeforeRemove(PSWFEngineType pSWFEngineType) throws Exception {
        super.onBeforeRemove(pSWFEngineType);
    }

    protected void onRemoveEntityUncopyValues(PSWFEngineType pSWFEngineType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFEngineType, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSWFEngineType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFEngineTypeId(bl, pSWFEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFEngineTypeName(bl, pSWFEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag(bl, pSWFEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag2(bl, pSWFEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWFEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFEngineType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isMemoDirty() : !pSWFEngineType.isMemoDirty()) {
            return null;
        }
        String string = pSWFEngineType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFEngineTypeId(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isPSWFEngineTypeIdDirty() && !bl2 : !pSWFEngineType.isPSWFEngineTypeIdDirty()) {
            return null;
        }
        String string = pSWFEngineType.getPSWFEngineTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFENGINETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFEngineTypeId_Default(pSWFEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFENGINETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFEngineTypeName(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isPSWFEngineTypeNameDirty() && !bl2 : !pSWFEngineType.isPSWFEngineTypeNameDirty()) {
            return null;
        }
        String string = pSWFEngineType.getPSWFEngineTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFENGINETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFEngineTypeName_Default(pSWFEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFENGINETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeTag(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isTypeTagDirty() : !pSWFEngineType.isTypeTagDirty()) {
            return null;
        }
        String string = pSWFEngineType.getTypeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag_Default(pSWFEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeTag2(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isTypeTag2Dirty() : !pSWFEngineType.isTypeTag2Dirty()) {
            return null;
        }
        String string = pSWFEngineType.getTypeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag2_Default(pSWFEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWFEngineType pSWFEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFEngineType.isValidFlagDirty() && !bl2 : !pSWFEngineType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWFEngineType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSWFEngineType, bl2, bl3);
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

    protected void onSyncEntity(PSWFEngineType pSWFEngineType, boolean bl) throws Exception {
        super.onSyncEntity(pSWFEngineType, bl);
    }

    protected void onSyncIndexEntities(PSWFEngineType pSWFEngineType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFEngineType, bl);
    }

    public Object getDataContextValue(PSWFEngineType pSWFEngineType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFEngineType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWFEngineType pSWFEngineType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFEngineType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSWFENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFEngineTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag2_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFEngineTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFENGINETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFEngineTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFENGINETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWFEngineType pSWFEngineType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFEngineType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFEngineType pSWFEngineType) throws Exception {
        super.onUpdateParent(pSWFEngineType);
    }

    @Override
    protected void exportCurXmlModel(PSWFEngineType pSWFEngineType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFENGINETYPE");
        if (!bl) {
            pSWFEngineType.setCreateDate(null);
            pSWFEngineType.setCreateMan(null);
            pSWFEngineType.setPSWFEngineTypeId(null);
            pSWFEngineType.setUpdateDate(null);
            pSWFEngineType.setUpdateMan(null);
            super.exportCurXmlModel(pSWFEngineType, xmlNode, bl);
        }
    }
}

