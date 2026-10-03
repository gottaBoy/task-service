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
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.config.dao.PSPDTAppFuncDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPDTAppFuncDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPDTAppFunc;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPDTAppFuncServiceBase
extends PSCoreSysServiceBase<PSPDTAppFunc> {
    private static final Log log = LogFactory.getLog(PSPDTAppFuncServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPDTAppFuncDEModel pSPDTAppFuncDEModel;
    private PSPDTAppFuncDAO pSPDTAppFuncDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService";
    }

    public PSPDTAppFuncDEModel getPSPDTAppFuncDEModel() {
        if (this.pSPDTAppFuncDEModel == null) {
            try {
                this.pSPDTAppFuncDEModel = (PSPDTAppFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPDTAppFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPDTAppFuncDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPDTAppFuncDEModel();
    }

    public PSPDTAppFuncDAO getPSPDTAppFuncDAO() {
        if (this.pSPDTAppFuncDAO == null) {
            try {
                this.pSPDTAppFuncDAO = (PSPDTAppFuncDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPDTAppFuncDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPDTAppFuncDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPDTAppFuncDAO();
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

    protected void onFillParentInfo(PSPDTAppFunc pSPDTAppFunc, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSPDTAppFunc, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSPDTAppFunc pSPDTAppFunc, boolean bl) throws Exception {
        if (bl && pSPDTAppFunc.getValidFlag() == null) {
            pSPDTAppFunc.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSPDTAppFunc, bl);
    }

    protected void onWriteBackParent(PSPDTAppFunc pSPDTAppFunc, boolean bl) throws Exception {
        super.onWriteBackParent(pSPDTAppFunc, bl);
    }

    @Override
    protected void onBeforeRemove(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        pSAppFuncService.testRemoveByPSPDTAppFunc(pSPDTAppFunc);
        super.onBeforeRemove(pSPDTAppFunc);
    }

    protected void onRemoveEntityUncopyValues(PSPDTAppFunc pSPDTAppFunc, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPDTAppFunc, bl);
    }

    protected void onCheckEntity(boolean bl, PSPDTAppFunc pSPDTAppFunc, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPDTAppFunc, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPDTAppFuncId(bl, pSPDTAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPDTAppFuncName(bl, pSPDTAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPDTAppFunc, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPDTAppFunc, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPDTAppFunc pSPDTAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPDTAppFunc.isMemoDirty() : !pSPDTAppFunc.isMemoDirty()) {
            return null;
        }
        String string = pSPDTAppFunc.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPDTAppFunc, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPDTAppFuncId(boolean bl, PSPDTAppFunc pSPDTAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPDTAppFunc.isPSPDTAppFuncIdDirty() && !bl2 : !pSPDTAppFunc.isPSPDTAppFuncIdDirty()) {
            return null;
        }
        String string = pSPDTAppFunc.getPSPDTAppFuncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPDTAPPFUNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPDTAppFuncId_Default(pSPDTAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPDTAPPFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPDTAppFuncName(boolean bl, PSPDTAppFunc pSPDTAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPDTAppFunc.isPSPDTAppFuncNameDirty() && !bl2 : !pSPDTAppFunc.isPSPDTAppFuncNameDirty()) {
            return null;
        }
        String string = pSPDTAppFunc.getPSPDTAppFuncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPDTAPPFUNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPDTAppFuncName_Default(pSPDTAppFunc, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPDTAPPFUNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPDTAppFunc pSPDTAppFunc, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPDTAppFunc.isValidFlagDirty() && !bl2 : !pSPDTAppFunc.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPDTAppFunc.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSPDTAppFunc, bl2, bl3);
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

    protected void onSyncEntity(PSPDTAppFunc pSPDTAppFunc, boolean bl) throws Exception {
        super.onSyncEntity(pSPDTAppFunc, bl);
    }

    protected void onSyncIndexEntities(PSPDTAppFunc pSPDTAppFunc, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPDTAppFunc, bl);
    }

    public Object getDataContextValue(PSPDTAppFunc pSPDTAppFunc, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPDTAppFunc, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPDTAppFunc pSPDTAppFunc, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPDTAppFunc, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSPDTAPPFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPDTAppFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPDTAPPFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPDTAppFuncName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPDTAppFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPDTAPPFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPDTAppFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPDTAPPFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPDTAppFunc pSPDTAppFunc) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPDTAppFunc)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPDTAppFunc pSPDTAppFunc) throws Exception {
        super.onUpdateParent(pSPDTAppFunc);
    }

    @Override
    protected void exportCurXmlModel(PSPDTAppFunc pSPDTAppFunc, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPDTAPPFUNC");
        if (!bl) {
            pSPDTAppFunc.setCreateDate(null);
            pSPDTAppFunc.setCreateMan(null);
            pSPDTAppFunc.setUpdateDate(null);
            pSPDTAppFunc.setUpdateMan(null);
            super.exportCurXmlModel(pSPDTAppFunc, xmlNode, bl);
        }
    }
}

