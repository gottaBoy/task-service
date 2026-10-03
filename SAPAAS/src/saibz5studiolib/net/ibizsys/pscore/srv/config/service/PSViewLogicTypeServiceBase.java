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
import net.ibizsys.pscore.srv.config.dao.PSViewLogicTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeParamService;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeParamServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewLogicTypeServiceBase
extends PSCoreSysServiceBase<PSViewLogicType> {
    private static final Log log = LogFactory.getLog(PSViewLogicTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSViewLogicTypeDEModel pSViewLogicTypeDEModel;
    private PSViewLogicTypeDAO pSViewLogicTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService";
    }

    public PSViewLogicTypeDEModel getPSViewLogicTypeDEModel() {
        if (this.pSViewLogicTypeDEModel == null) {
            try {
                this.pSViewLogicTypeDEModel = (PSViewLogicTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewLogicTypeDEModel();
    }

    public PSViewLogicTypeDAO getPSViewLogicTypeDAO() {
        if (this.pSViewLogicTypeDAO == null) {
            try {
                this.pSViewLogicTypeDAO = (PSViewLogicTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewLogicTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewLogicTypeDAO();
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

    protected void onFillParentInfo(PSViewLogicType pSViewLogicType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSViewLogicType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSViewLogicType pSViewLogicType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSViewLogicType, bl);
    }

    protected void onWriteBackParent(PSViewLogicType pSViewLogicType, boolean bl) throws Exception {
        super.onWriteBackParent(pSViewLogicType, bl);
    }

    @Override
    protected void onBeforeRemove(PSViewLogicType pSViewLogicType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPFVLTemplService)ServiceGlobal.getService(PSPFVLTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFVLTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSViewLogicType(pSViewLogicType);
        pSCoreSysServiceBase = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSViewLogicType(pSViewLogicType);
        pSCoreSysServiceBase = (PSViewLogicTypeParamService)ServiceGlobal.getService(PSViewLogicTypeParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewLogicTypeParamServiceBase)pSCoreSysServiceBase).testRemoveByPSViewLogicType(pSViewLogicType);
        ((PSViewLogicTypeParamServiceBase)pSCoreSysServiceBase).removeByPSViewLogicType(pSViewLogicType);
        super.onBeforeRemove(pSViewLogicType);
    }

    protected void onRemoveEntityUncopyValues(PSViewLogicType pSViewLogicType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSViewLogicType, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_APPViewLogicOBJ(bl, pSViewLogicType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewLogicType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessName(bl, pSViewLogicType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeId(bl, pSViewLogicType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeName(bl, pSViewLogicType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSViewLogicType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSViewLogicType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_APPViewLogicOBJ(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isAPPViewLogicOBJDirty() && !bl2 : !pSViewLogicType.isAPPViewLogicOBJDirty()) {
            return null;
        }
        String string = pSViewLogicType.getAPPViewLogicOBJ();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWLOGICOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_APPViewLogicOBJ_Default(pSViewLogicType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWLOGICOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isMemoDirty() : !pSViewLogicType.isMemoDirty()) {
            return null;
        }
        String string = pSViewLogicType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSViewLogicType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcessName(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isProcessNameDirty() && !bl2 : !pSViewLogicType.isProcessNameDirty()) {
            return null;
        }
        String string = pSViewLogicType.getProcessName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessName_Default(pSViewLogicType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeId(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isPSViewLogicTypeIdDirty() && !bl2 : !pSViewLogicType.isPSViewLogicTypeIdDirty()) {
            return null;
        }
        String string = pSViewLogicType.getPSViewLogicTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeId_Default(pSViewLogicType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeName(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isPSViewLogicTypeNameDirty() && !bl2 : !pSViewLogicType.isPSViewLogicTypeNameDirty()) {
            return null;
        }
        String string = pSViewLogicType.getPSViewLogicTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeName_Default(pSViewLogicType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSViewLogicType pSViewLogicType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicType.isValidFlagDirty() : !pSViewLogicType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSViewLogicType.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSViewLogicType, bl2, bl3);
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

    protected void onSyncEntity(PSViewLogicType pSViewLogicType, boolean bl) throws Exception {
        super.onSyncEntity(pSViewLogicType, bl);
    }

    protected void onSyncIndexEntities(PSViewLogicType pSViewLogicType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSViewLogicType, bl);
    }

    public Object getDataContextValue(PSViewLogicType pSViewLogicType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSViewLogicType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewLogicType pSViewLogicType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSViewLogicType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPVIEWLOGICOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APPViewLogicOBJ_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_APPViewLogicOBJ_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPVIEWLOGICOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSViewLogicType pSViewLogicType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSViewLogicType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewLogicType pSViewLogicType) throws Exception {
        super.onUpdateParent(pSViewLogicType);
    }

    @Override
    protected void exportCurXmlModel(PSViewLogicType pSViewLogicType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWLOGICTYPE");
        if (!bl) {
            pSViewLogicType.setCreateDate(null);
            pSViewLogicType.setCreateMan(null);
            pSViewLogicType.setUpdateDate(null);
            pSViewLogicType.setUpdateMan(null);
            super.exportCurXmlModel(pSViewLogicType, xmlNode, bl);
        }
    }
}

