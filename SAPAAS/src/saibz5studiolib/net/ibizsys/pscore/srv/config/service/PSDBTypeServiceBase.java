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
import net.ibizsys.pscore.srv.config.dao.PSDBTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDBTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.service.PSDBVFCodeService;
import net.ibizsys.pscore.srv.config.service.PSDBVFCodeServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplService;
import net.ibizsys.pscore.srv.def.service.PSDBSysProcTemplServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBTypeServiceBase
extends PSCoreSysServiceBase<PSDBType> {
    private static final Log log = LogFactory.getLog(PSDBTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBTypeDEModel pSDBTypeDEModel;
    private PSDBTypeDAO pSDBTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDBTypeService";
    }

    public PSDBTypeDEModel getPSDBTypeDEModel() {
        if (this.pSDBTypeDEModel == null) {
            try {
                this.pSDBTypeDEModel = (PSDBTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDBTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBTypeDEModel();
    }

    public PSDBTypeDAO getPSDBTypeDAO() {
        if (this.pSDBTypeDAO == null) {
            try {
                this.pSDBTypeDAO = (PSDBTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDBTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBTypeDAO();
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

    protected void onFillParentInfo(PSDBType pSDBType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSDBType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDBType pSDBType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDBType, bl);
    }

    protected void onWriteBackParent(PSDBType pSDBType, boolean bl) throws Exception {
        super.onWriteBackParent(pSDBType, bl);
    }

    @Override
    protected void onBeforeRemove(PSDBType pSDBType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDBSysProcTemplService)ServiceGlobal.getService(PSDBSysProcTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBSysProcTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDBType(pSDBType);
        ((PSDBSysProcTemplServiceBase)pSCoreSysServiceBase).removeByPSDBType(pSDBType);
        pSCoreSysServiceBase = (PSDBVFCodeService)ServiceGlobal.getService(PSDBVFCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDBVFCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDBType(pSDBType);
        ((PSDBVFCodeServiceBase)pSCoreSysServiceBase).removeByPSDBType(pSDBType);
        pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSDBType(pSDBType);
        super.onBeforeRemove(pSDBType);
    }

    protected void onRemoveEntityUncopyValues(PSDBType pSDBType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDBType, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DBClientPath(bl, pSDBType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDBCfgObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDQEngObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDQPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDSPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFDTColObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeleteSPPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetSPPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HibDialect(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InsertSPPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstallPath(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JdbcDialect(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JdbcDriverName(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeId(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeName(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysDBCfgObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeHelper(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateSPPubObj(bl, pSDBType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDBType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DBClientPath(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDBClientPathDirty() : !pSDBType.isDBClientPathDirty()) {
            return null;
        }
        String string = pSDBType.getDBClientPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBClientPath_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBCLIENTPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDBCfgObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDEDBCfgObjDirty() && !bl2 : !pSDBType.isDEDBCfgObjDirty()) {
            return null;
        }
        String string = pSDBType.getDEDBCfgObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDBCFGOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEDBCfgObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDBCFGOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDQEngObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDEDQEngObjDirty() && !bl2 : !pSDBType.isDEDQEngObjDirty()) {
            return null;
        }
        String string = pSDBType.getDEDQEngObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDQENGOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEDQEngObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDQENGOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDQPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDEDQPubObjDirty() && !bl2 : !pSDBType.isDEDQPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getDEDQPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDQPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEDQPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDQPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDSPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDEDSPubObjDirty() && !bl2 : !pSDBType.isDEDSPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getDEDSPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDSPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEDSPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDSPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFDTColObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDEFDTColObjDirty() && !bl2 : !pSDBType.isDEFDTColObjDirty()) {
            return null;
        }
        String string = pSDBType.getDEFDTColObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDTCOLOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEFDTColObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFDTCOLOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeleteSPPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isDeleteSPPubObjDirty() && !bl2 : !pSDBType.isDeleteSPPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getDeleteSPPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DELETESPPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeleteSPPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DELETESPPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetSPPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isGetSPPubObjDirty() && !bl2 : !pSDBType.isGetSPPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getGetSPPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETSPPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetSPPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETSPPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HibDialect(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isHibDialectDirty() && !bl2 : !pSDBType.isHibDialectDirty()) {
            return null;
        }
        String string = pSDBType.getHibDialect();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIBDIALECT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_HibDialect_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIBDIALECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isIconPathDirty() : !pSDBType.isIconPathDirty()) {
            return null;
        }
        String string = pSDBType.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InsertSPPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isInsertSPPubObjDirty() && !bl2 : !pSDBType.isInsertSPPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getInsertSPPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSERTSPPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_InsertSPPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSERTSPPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstallPath(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isInstallPathDirty() : !pSDBType.isInstallPathDirty()) {
            return null;
        }
        String string = pSDBType.getInstallPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstallPath_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTALLPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JdbcDialect(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isJdbcDialectDirty() && !bl2 : !pSDBType.isJdbcDialectDirty()) {
            return null;
        }
        String string = pSDBType.getJdbcDialect();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCDIALECT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_JdbcDialect_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCDIALECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JdbcDriverName(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isJdbcDriverNameDirty() && !bl2 : !pSDBType.isJdbcDriverNameDirty()) {
            return null;
        }
        String string = pSDBType.getJdbcDriverName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCDRIVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_JdbcDriverName_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCDRIVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isMemoDirty() : !pSDBType.isMemoDirty()) {
            return null;
        }
        String string = pSDBType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDBType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBTypeId(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isPSDBTypeIdDirty() && !bl2 : !pSDBType.isPSDBTypeIdDirty()) {
            return null;
        }
        String string = pSDBType.getPSDBTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeId_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBTypeName(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isPSDBTypeNameDirty() && !bl2 : !pSDBType.isPSDBTypeNameDirty()) {
            return null;
        }
        String string = pSDBType.getPSDBTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeName_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isPubModeDirty() : !pSDBType.isPubModeDirty()) {
            return null;
        }
        Integer n = pSDBType.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysDBCfgObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isSysDBCfgObjDirty() && !bl2 : !pSDBType.isSysDBCfgObjDirty()) {
            return null;
        }
        String string = pSDBType.getSysDBCfgObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSDBCFGOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysDBCfgObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSDBCFGOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeHelper(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isTypeHelperDirty() && !bl2 : !pSDBType.isTypeHelperDirty()) {
            return null;
        }
        String string = pSDBType.getTypeHelper();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEHELPER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeHelper_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEHELPER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateSPPubObj(boolean bl, PSDBType pSDBType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBType.isUpdateSPPubObjDirty() && !bl2 : !pSDBType.isUpdateSPPubObjDirty()) {
            return null;
        }
        String string = pSDBType.getUpdateSPPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATESPPUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateSPPubObj_Default(pSDBType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATESPPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDBType pSDBType, boolean bl) throws Exception {
        super.onSyncEntity(pSDBType, bl);
    }

    protected void onSyncIndexEntities(PSDBType pSDBType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDBType, bl);
    }

    public Object getDataContextValue(PSDBType pSDBType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDBType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBType pSDBType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDBType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBCLIENTPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBClientPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDBCFGOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDBCfgObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDQENGOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDQEngObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDQPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDQPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDSPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDSPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFDTCOLOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFDTColObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELETESPPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeleteSPPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETSPPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetSPPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIBDIALECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HibDialect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSERTSPPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InsertSPPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTALLPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstallPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JDBCDIALECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JdbcDialect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JDBCDRIVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JdbcDriverName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSDBCFGOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysDBCfgObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEHELPER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeHelper_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATESPPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateSPPubObj_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DBClientPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBCLIENTPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEDBCfgObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEDBCFGOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEDQEngObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEDQENGOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEDQPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEDQPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEDSPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEDSPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEFDTColObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFDTCOLOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeleteSPPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DELETESPPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetSPPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETSPPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HibDialect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HIBDIALECT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InsertSPPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSERTSPPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstallPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTALLPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JdbcDialect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JDBCDIALECT", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JdbcDriverName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JDBCDRIVERNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSDBTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysDBCfgObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSDBCFGOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeHelper_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEHELPER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_UpdateSPPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATESPPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDBType pSDBType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDBType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBType pSDBType) throws Exception {
        super.onUpdateParent(pSDBType);
    }

    @Override
    protected void exportCurXmlModel(PSDBType pSDBType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBTYPE");
        if (!bl) {
            pSDBType.setCreateDate(null);
            pSDBType.setCreateMan(null);
            pSDBType.setUpdateDate(null);
            pSDBType.setUpdateMan(null);
            super.exportCurXmlModel(pSDBType, xmlNode, bl);
        }
    }
}

