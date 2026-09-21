/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.service;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO;
import net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDGTheme;
import net.ibizsys.psrt.srv.common.service.UserDGThemeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserDGThemeServiceBase
extends PSRuntimeSysServiceBase<UserDGTheme> {
    private static final Log log = LogFactory.getLog(UserDGThemeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private UserDGThemeDEModel userDGThemeDEModel;
    private UserDGThemeDAO userDGThemeDAO;

    public static UserDGThemeService getInstance() throws Exception {
        return UserDGThemeServiceBase.getInstance(null);
    }

    public static UserDGThemeService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserDGThemeService)ServiceGlobal.getService(UserDGThemeService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserDGThemeService";
    }

    public UserDGThemeDEModel getUserDGThemeDEModel() {
        if (this.userDGThemeDEModel == null) {
            try {
                this.userDGThemeDEModel = (UserDGThemeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDGThemeDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserDGThemeDEModel();
    }

    public UserDGThemeDAO getUserDGThemeDAO() {
        if (this.userDGThemeDAO == null) {
            try {
                this.userDGThemeDAO = (UserDGThemeDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userDGThemeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getUserDGThemeDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    @Override
    protected void onFillParentInfo(UserDGTheme et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    @Override
    protected void onFillEntityFullInfo(UserDGTheme et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
    }

    @Override
    protected void onWriteBackParent(UserDGTheme et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    @Override
    protected void onBeforeRemove(UserDGTheme et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void onRemoveEntityUncopyValues(UserDGTheme et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DataGridId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DGThemeModel(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PersonId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProjectId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver3(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDGThemeId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDGThemeName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_DataGridId(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDataGridIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getDataGridId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DataGridId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DGThemeModel(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDGThemeModelDirty()) {
            return null;
        }
        String value = et.getDGThemeModel();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DGThemeModel_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DGTHEMEMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PersonId(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPersonIdDirty()) {
            return null;
        }
        String value = et.getPersonId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PersonId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PERSONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProjectId(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isProjectIdDirty()) {
            return null;
        }
        String value = et.getProjectId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ProjectId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROJECTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserverDirty()) {
            return null;
        }
        String value = et.getReserver();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver2Dirty()) {
            return null;
        }
        String value = et.getReserver2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver3Dirty()) {
            return null;
        }
        String value = et.getReserver3();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDGThemeId(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDGThemeIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDGThemeId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDGThemeId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDGThemeName(boolean bBaseMode, UserDGTheme et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDGThemeNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserDGThemeName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDGThemeName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDGTHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(UserDGTheme et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(UserDGTheme et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(UserDGTheme et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DATAGRIDID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DataGridId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DGTHEMEMODEL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DGThemeModel_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PERSONID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PersonId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PROJECTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ProjectId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER3", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDGTHEMEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDGThemeId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDGTHEMENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDGThemeName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_CreateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DataGridId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAGRIDID", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DGThemeModel_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DGTHEMEMODEL", et, bTempMode, null, false, 3000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[3000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[3000]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PersonId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PERSONID", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ProjectId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROJECTID", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER2", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver3_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER3", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDGThemeId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDGTHEMEID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserDGThemeName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDGTHEMENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserDGTheme et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(UserDGTheme et) throws Exception {
        super.onUpdateParent(et);
    }
}

