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
import net.ibizsys.pscore.srv.config.dao.PSSearchEngineTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSearchEngineTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSearchEngineType;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSearchEngineTypeServiceBase
extends PSCoreSysServiceBase<PSSearchEngineType> {
    private static final Log log = LogFactory.getLog(PSSearchEngineTypeServiceBase.class);
    private PSSearchEngineTypeDEModel pSSearchEngineTypeDEModel;
    private PSSearchEngineTypeDAO pSSearchEngineTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSearchEngineTypeService";
    }

    public PSSearchEngineTypeDEModel getPSSearchEngineTypeDEModel() {
        if (this.pSSearchEngineTypeDEModel == null) {
            try {
                this.pSSearchEngineTypeDEModel = (PSSearchEngineTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSearchEngineTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSearchEngineTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSearchEngineTypeDEModel();
    }

    public PSSearchEngineTypeDAO getPSSearchEngineTypeDAO() {
        if (this.pSSearchEngineTypeDAO == null) {
            try {
                this.pSSearchEngineTypeDAO = (PSSearchEngineTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSearchEngineTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSearchEngineTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSearchEngineTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSSearchEngineType pSSearchEngineType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSSearchEngineType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSSearchEngineType pSSearchEngineType, boolean bl) throws Exception {
        if (bl && pSSearchEngineType.getValidFlag() == null) {
            pSSearchEngineType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSearchEngineType, bl);
    }

    protected void onWriteBackParent(PSSearchEngineType pSSearchEngineType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSearchEngineType, bl);
    }

    @Override
    protected void onBeforeRemove(PSSearchEngineType pSSearchEngineType) throws Exception {
        super.onBeforeRemove(pSSearchEngineType);
    }

    protected void onRemoveEntityUncopyValues(PSSearchEngineType pSSearchEngineType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSearchEngineType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSearchEngineType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSearchEngineTypeId(bl, pSSearchEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSearchEngineTypeName(bl, pSSearchEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag(bl, pSSearchEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeTag2(bl, pSSearchEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSearchEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSearchEngineType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isMemoDirty() : !pSSearchEngineType.isMemoDirty()) {
            return null;
        }
        String string = pSSearchEngineType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSearchEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSearchEngineTypeId(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isPSSearchEngineTypeIdDirty() && !bl2 : !pSSearchEngineType.isPSSearchEngineTypeIdDirty()) {
            return null;
        }
        String string = pSSearchEngineType.getPSSearchEngineTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSearchEngineTypeId_Default(pSSearchEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSearchEngineTypeName(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isPSSearchEngineTypeNameDirty() && !bl2 : !pSSearchEngineType.isPSSearchEngineTypeNameDirty()) {
            return null;
        }
        String string = pSSearchEngineType.getPSSearchEngineTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSearchEngineTypeName_Default(pSSearchEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSEARCHENGINETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeTag(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isTypeTagDirty() : !pSSearchEngineType.isTypeTagDirty()) {
            return null;
        }
        String string = pSSearchEngineType.getTypeTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag_Default(pSSearchEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_TypeTag2(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isTypeTag2Dirty() : !pSSearchEngineType.isTypeTag2Dirty()) {
            return null;
        }
        String string = pSSearchEngineType.getTypeTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeTag2_Default(pSSearchEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSearchEngineType pSSearchEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSearchEngineType.isValidFlagDirty() && !bl2 : !pSSearchEngineType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSearchEngineType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSearchEngineType, bl2, bl3);
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

    protected void onSyncEntity(PSSearchEngineType pSSearchEngineType, boolean bl) throws Exception {
        super.onSyncEntity(pSSearchEngineType, bl);
    }

    protected void onSyncIndexEntities(PSSearchEngineType pSSearchEngineType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSearchEngineType, bl);
    }

    public Object getDataContextValue(PSSearchEngineType pSSearchEngineType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSearchEngineType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSearchEngineType pSSearchEngineType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSearchEngineType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSEARCHENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSearchEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSEARCHENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSSearchEngineTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_TypeTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSearchEngineTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSEARCHENGINETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSearchEngineTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSEARCHENGINETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSearchEngineType pSSearchEngineType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSearchEngineType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSearchEngineType pSSearchEngineType) throws Exception {
        super.onUpdateParent(pSSearchEngineType);
    }

    @Override
    protected void exportCurXmlModel(PSSearchEngineType pSSearchEngineType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSEARCHENGINETYPE");
        if (!bl) {
            pSSearchEngineType.setCreateDate(null);
            pSSearchEngineType.setCreateMan(null);
            pSSearchEngineType.setUpdateDate(null);
            pSSearchEngineType.setUpdateMan(null);
            super.exportCurXmlModel(pSSearchEngineType, xmlNode, bl);
        }
    }
}

