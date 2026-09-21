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
import net.ibizsys.pscore.srv.config.dao.PSUIEngineTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSUIEngineTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeParamService;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeParamServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUIEngineTypeServiceBase
extends PSCoreSysServiceBase<PSUIEngineType> {
    private static final Log log = LogFactory.getLog(PSUIEngineTypeServiceBase.class);
    public static final String DATASET_CTRLVALID = "CtrlValid";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSUIEngineTypeDEModel pSUIEngineTypeDEModel;
    private PSUIEngineTypeDAO pSUIEngineTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService";
    }

    public PSUIEngineTypeDEModel getPSUIEngineTypeDEModel() {
        if (this.pSUIEngineTypeDEModel == null) {
            try {
                this.pSUIEngineTypeDEModel = (PSUIEngineTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSUIEngineTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUIEngineTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUIEngineTypeDEModel();
    }

    public PSUIEngineTypeDAO getPSUIEngineTypeDAO() {
        if (this.pSUIEngineTypeDAO == null) {
            try {
                this.pSUIEngineTypeDAO = (PSUIEngineTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSUIEngineTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUIEngineTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUIEngineTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CTRLVALID, (boolean)true) == 0) {
            return this.fetchCtrlValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCtrlValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CTRLVALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSUIEngineType pSUIEngineType, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSUIEngineType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSUIEngineType pSUIEngineType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUIEngineType, bl);
    }

    protected void onWriteBackParent(PSUIEngineType pSUIEngineType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUIEngineType, bl);
    }

    @Override
    protected void onBeforeRemove(PSUIEngineType pSUIEngineType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSUIEngineType(pSUIEngineType);
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).resetPSUIEngineType(pSUIEngineType);
        pSCoreSysServiceBase = (PSUIEngineTypeParamService)ServiceGlobal.getService(PSUIEngineTypeParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSUIEngineTypeParamServiceBase)pSCoreSysServiceBase).testRemoveByPSUIEngineType(pSUIEngineType);
        ((PSUIEngineTypeParamServiceBase)pSCoreSysServiceBase).removeByPSUIEngineType(pSUIEngineType);
        super.onBeforeRemove(pSUIEngineType);
    }

    protected void onRemoveEntityUncopyValues(PSUIEngineType pSUIEngineType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUIEngineType, bl);
    }

    protected void onCheckEntity(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EngineCat(bl, pSUIEngineType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineObj(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam10Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam2Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam3Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam4Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam5Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam6Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam7Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam8Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Flag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParam9Label(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EngineParamLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2UICtrlFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2UICtrlLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2UILogicFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2UILogicLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3UICtrlFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3UICtrlLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3UILogicFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3UILogicLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4UICtrlFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4UICtrlLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4UILogicFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4UILogicLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelEngineObj(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeId(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeName(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeCode(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UICtrlFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UICtrlLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UILogicFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UILogicLabel(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UtilParams(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSUIEngineType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUIEngineType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EngineCat(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineCatDirty() && !bl2 : !pSUIEngineType.isEngineCatDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineCat();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINECAT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineCat_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINECAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineObj(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineObjDirty() : !pSUIEngineType.isEngineObjDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineObj_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam10FlagDirty() : !pSUIEngineType.isEngineParam10FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam10Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam10Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam10Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam10LabelDirty() : !pSUIEngineType.isEngineParam10LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam10Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam10Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM10LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam2FlagDirty() : !pSUIEngineType.isEngineParam2FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam2Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam2Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam2Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam2LabelDirty() : !pSUIEngineType.isEngineParam2LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam2Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam2Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM2LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam3FlagDirty() : !pSUIEngineType.isEngineParam3FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam3Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam3Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam3Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam3LabelDirty() : !pSUIEngineType.isEngineParam3LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam3Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam3Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM3LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam4FlagDirty() : !pSUIEngineType.isEngineParam4FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam4Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam4Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam4Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam4LabelDirty() : !pSUIEngineType.isEngineParam4LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam4Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam4Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM4LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam5FlagDirty() : !pSUIEngineType.isEngineParam5FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam5Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam5Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam5Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam5LabelDirty() : !pSUIEngineType.isEngineParam5LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam5Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam5Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM5LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam6FlagDirty() : !pSUIEngineType.isEngineParam6FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam6Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam6Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam6Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam6LabelDirty() : !pSUIEngineType.isEngineParam6LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam6Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam6Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM6LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam7FlagDirty() : !pSUIEngineType.isEngineParam7FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam7Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam7Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam7Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam7LabelDirty() : !pSUIEngineType.isEngineParam7LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam7Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam7Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM7LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam8FlagDirty() : !pSUIEngineType.isEngineParam8FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam8Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam8Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam8Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam8LabelDirty() : !pSUIEngineType.isEngineParam8LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam8Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam8Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM8LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Flag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam9FlagDirty() : !pSUIEngineType.isEngineParam9FlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParam9Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParam9Flag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParam9Label(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParam9LabelDirty() : !pSUIEngineType.isEngineParam9LabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParam9Label();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParam9Label_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAM9LABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParamFlagDirty() : !pSUIEngineType.isEngineParamFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getEngineParamFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EngineParamFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EngineParamLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isEngineParamLabelDirty() : !pSUIEngineType.isEngineParamLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getEngineParamLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EngineParamLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENGINEPARAMLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isLogicNameDirty() : !pSUIEngineType.isLogicNameDirty()) {
            return null;
        }
        String string = pSUIEngineType.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSUIEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isMemoDirty() : !pSUIEngineType.isMemoDirty()) {
            return null;
        }
        String string = pSUIEngineType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSUIEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2UICtrlFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo2UICtrlFlagDirty() : !pSUIEngineType.isNo2UICtrlFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo2UICtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2UICtrlFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2UICTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2UICtrlLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo2UICtrlLabelDirty() : !pSUIEngineType.isNo2UICtrlLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo2UICtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2UICtrlLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2UICTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2UILogicFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo2UILogicFlagDirty() : !pSUIEngineType.isNo2UILogicFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo2UILogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No2UILogicFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2UILOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2UILogicLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo2UILogicLabelDirty() : !pSUIEngineType.isNo2UILogicLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo2UILogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2UILogicLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2UILOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3UICtrlFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo3UICtrlFlagDirty() : !pSUIEngineType.isNo3UICtrlFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo3UICtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3UICtrlFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3UICTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3UICtrlLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo3UICtrlLabelDirty() : !pSUIEngineType.isNo3UICtrlLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo3UICtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3UICtrlLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3UICTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3UILogicFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo3UILogicFlagDirty() : !pSUIEngineType.isNo3UILogicFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo3UILogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No3UILogicFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3UILOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3UILogicLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo3UILogicLabelDirty() : !pSUIEngineType.isNo3UILogicLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo3UILogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3UILogicLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3UILOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4UICtrlFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo4UICtrlFlagDirty() : !pSUIEngineType.isNo4UICtrlFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo4UICtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4UICtrlFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4UICTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4UICtrlLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo4UICtrlLabelDirty() : !pSUIEngineType.isNo4UICtrlLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo4UICtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4UICtrlLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4UICTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4UILogicFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo4UILogicFlagDirty() : !pSUIEngineType.isNo4UILogicFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getNo4UILogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_No4UILogicFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4UILOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4UILogicLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isNo4UILogicLabelDirty() : !pSUIEngineType.isNo4UILogicLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getNo4UILogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4UILogicLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4UILOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelEngineObj(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isPanelEngineObjDirty() : !pSUIEngineType.isPanelEngineObjDirty()) {
            return null;
        }
        String string = pSUIEngineType.getPanelEngineObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PanelEngineObj_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELENGINEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeId(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isPSUIEngineTypeIdDirty() && !bl2 : !pSUIEngineType.isPSUIEngineTypeIdDirty()) {
            return null;
        }
        String string = pSUIEngineType.getPSUIEngineTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeId_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeName(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isPSUIEngineTypeNameDirty() && !bl2 : !pSUIEngineType.isPSUIEngineTypeNameDirty()) {
            return null;
        }
        String string = pSUIEngineType.getPSUIEngineTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeName_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeCode(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isTypeCodeDirty() && !bl2 : !pSUIEngineType.isTypeCodeDirty()) {
            return null;
        }
        String string = pSUIEngineType.getTypeCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeCode_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isTypeObjDirty() : !pSUIEngineType.isTypeObjDirty()) {
            return null;
        }
        String string = pSUIEngineType.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default((IEntity)pSUIEngineType, bl2, bl3);
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

    protected EntityFieldError onCheckField_UICtrlFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isUICtrlFlagDirty() : !pSUIEngineType.isUICtrlFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getUICtrlFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UICtrlFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UICTRLFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UICtrlLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isUICtrlLabelDirty() : !pSUIEngineType.isUICtrlLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getUICtrlLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UICtrlLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UICTRLLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UILogicFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isUILogicFlagDirty() : !pSUIEngineType.isUILogicFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getUILogicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UILogicFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UILOGICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UILogicLabel(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isUILogicLabelDirty() : !pSUIEngineType.isUILogicLabelDirty()) {
            return null;
        }
        String string = pSUIEngineType.getUILogicLabel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UILogicLabel_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UILOGICLABEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UtilParams(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isUtilParamsDirty() : !pSUIEngineType.isUtilParamsDirty()) {
            return null;
        }
        String string = pSUIEngineType.getUtilParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UtilParams_Default((IEntity)pSUIEngineType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UTILPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSUIEngineType pSUIEngineType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineType.isValidFlagDirty() && !bl2 : !pSUIEngineType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSUIEngineType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSUIEngineType, bl2, bl3);
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

    protected void onSyncEntity(PSUIEngineType pSUIEngineType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUIEngineType, bl);
    }

    protected void onSyncIndexEntities(PSUIEngineType pSUIEngineType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUIEngineType, bl);
    }

    public Object getDataContextValue(PSUIEngineType pSUIEngineType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUIEngineType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSUIEngineType pSUIEngineType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUIEngineType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINECAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM10LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam10Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM2LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam2Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM3LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam3Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM4LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam4Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM5LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam5Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM6LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam6Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM7LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam7Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM8LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam8Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAM9LABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParam9Label_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENGINEPARAMLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EngineParamLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2UICTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2UICtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2UICTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2UICtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2UILOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2UILogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2UILOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2UILogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3UICTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3UICtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3UICTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3UICtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3UILOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3UILogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3UILOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3UILogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4UICTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4UICtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4UICTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4UICtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4UILOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4UILogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4UILOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4UILogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELENGINEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelEngineObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UICTRLFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UICtrlFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UICTRLLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UICtrlLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UILOGICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UILogicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UILOGICLABEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UILogicLabel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UTILPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UtilParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EngineCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINECAT", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam10Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam10Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM10LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam2Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam2Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM2LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam3Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam3Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM3LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam4Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam4Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM4LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam5Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam5Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM5LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam6Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam6Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM6LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam7Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam7Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM7LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam8Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam8Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM8LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParam9Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParam9Label_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAM9LABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EngineParamFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EngineParamLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENGINEPARAMLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_No2UICtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2UICtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2UICTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2UILogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No2UILogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2UILOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3UICtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3UICtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3UICTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3UILogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No3UILogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3UILOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4UICtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4UICtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4UICTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4UILogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_No4UILogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4UILOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PanelEngineObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELENGINEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPECODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_UICtrlFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UICtrlLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UICTRLLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UILogicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UILogicLabel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UILOGICLABEL", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_UtilParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UTILPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSUIEngineType pSUIEngineType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUIEngineType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUIEngineType pSUIEngineType) throws Exception {
        super.onUpdateParent((IEntity)pSUIEngineType);
    }

    @Override
    protected void exportCurXmlModel(PSUIEngineType pSUIEngineType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUIENGINETYPE");
        if (!bl) {
            pSUIEngineType.setCreateDate(null);
            pSUIEngineType.setCreateMan(null);
            pSUIEngineType.setUpdateDate(null);
            pSUIEngineType.setUpdateMan(null);
            super.exportCurXmlModel(pSUIEngineType, xmlNode, bl);
        }
    }
}

