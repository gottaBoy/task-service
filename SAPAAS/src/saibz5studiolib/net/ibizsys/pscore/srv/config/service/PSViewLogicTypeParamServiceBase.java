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
import net.ibizsys.pscore.srv.config.dao.PSViewLogicTypeParamDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeParamDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeParam;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewLogicTypeParamServiceBase
extends PSCoreSysServiceBase<PSViewLogicTypeParam> {
    private static final Log log = LogFactory.getLog(PSViewLogicTypeParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSViewLogicTypeParamDEModel pSViewLogicTypeParamDEModel;
    private PSViewLogicTypeParamDAO pSViewLogicTypeParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewLogicTypeParamService";
    }

    public PSViewLogicTypeParamDEModel getPSViewLogicTypeParamDEModel() {
        if (this.pSViewLogicTypeParamDEModel == null) {
            try {
                this.pSViewLogicTypeParamDEModel = (PSViewLogicTypeParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewLogicTypeParamDEModel();
    }

    public PSViewLogicTypeParamDAO getPSViewLogicTypeParamDAO() {
        if (this.pSViewLogicTypeParamDAO == null) {
            try {
                this.pSViewLogicTypeParamDAO = (PSViewLogicTypeParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewLogicTypeParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewLogicTypeParamDAO();
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

    protected void onFillParentInfo(PSViewLogicTypeParam pSViewLogicTypeParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWLOGICTYPEPARAM_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory());
            PSViewLogicType pSViewLogicType = (PSViewLogicType)iService.getDEModel().createEntity();
            pSViewLogicType.set("PSVIEWLOGICTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewLogicType);
            } else {
                iService.get(pSViewLogicType);
            }
            this.onFillParentInfo_PSViewLogicType(pSViewLogicTypeParam, pSViewLogicType);
            return;
        }
        super.onFillParentInfo(pSViewLogicTypeParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewLogicType(PSViewLogicTypeParam pSViewLogicTypeParam, PSViewLogicType pSViewLogicType) throws Exception {
        pSViewLogicTypeParam.setPSViewLogicTypeId(pSViewLogicType.getPSViewLogicTypeId());
        pSViewLogicTypeParam.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
    }

    protected void onFillEntityFullInfo(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSViewLogicTypeParam, bl);
        this.onFillEntityFullInfo_PSViewLogicType(pSViewLogicTypeParam, bl);
    }

    protected void onFillEntityFullInfo_PSViewLogicType(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        if (pSViewLogicTypeParam.isPSViewLogicTypeIdDirty()) {
            if (pSViewLogicTypeParam.getPSViewLogicTypeId() != null) {
                if (pSViewLogicTypeParam.getPSViewLogicTypeId() == null || pSViewLogicTypeParam.getPSViewLogicTypeName() == null) {
                    PSViewLogicType pSViewLogicType = pSViewLogicTypeParam.getPSViewLogicType();
                    pSViewLogicTypeParam.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
                }
            } else {
                pSViewLogicTypeParam.setPSViewLogicTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSViewLogicTypeParam, bl);
    }

    public ArrayList<PSViewLogicTypeParam> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, "", -1);
    }

    public ArrayList<PSViewLogicTypeParam> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, string, -1);
    }

    public ArrayList<PSViewLogicTypeParam> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWLOGICTYPEID", (Object)pSViewLogicTypeBase.getPSViewLogicTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewLogicTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewLogicTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    public void resetPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSViewLogicTypeParam> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        for (PSViewLogicTypeParam pSViewLogicTypeParam : arrayList) {
            PSViewLogicTypeParam pSViewLogicTypeParam2 = (PSViewLogicTypeParam)this.getDEModel().createEntity();
            pSViewLogicTypeParam2.setPSViewLogicTypeParamId(pSViewLogicTypeParam.getPSViewLogicTypeParamId());
            pSViewLogicTypeParam2.setPSViewLogicTypeId(null);
            this.update(pSViewLogicTypeParam2);
        }
    }

    public void removeByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        final PSViewLogicType pSViewLogicType2 = pSViewLogicType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewLogicTypeParamServiceBase.this.onBeforeRemoveByPSViewLogicType(pSViewLogicType2);
                PSViewLogicTypeParamServiceBase.this.internalRemoveByPSViewLogicType(pSViewLogicType2);
                PSViewLogicTypeParamServiceBase.this.onAfterRemoveByPSViewLogicType(pSViewLogicType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void internalRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSViewLogicTypeParam> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        this.onBeforeRemoveByPSViewLogicType(pSViewLogicType, arrayList);
        for (PSViewLogicTypeParam pSViewLogicTypeParam : arrayList) {
            this.remove(pSViewLogicTypeParam);
        }
        this.onAfterRemoveByPSViewLogicType(pSViewLogicType, arrayList);
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSViewLogicTypeParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSViewLogicTypeParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewLogicTypeParam pSViewLogicTypeParam) throws Exception {
        super.onBeforeRemove(pSViewLogicTypeParam);
    }

    protected void replaceParentInfo(PSViewLogicTypeParam pSViewLogicTypeParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSViewLogicTypeParam, cloneSession);
        if (pSViewLogicTypeParam.getPSViewLogicTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWLOGICTYPE", (Object)pSViewLogicTypeParam.getPSViewLogicTypeId())) != null) {
            this.onFillParentInfo_PSViewLogicType(pSViewLogicTypeParam, (PSViewLogicType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSViewLogicTypeParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EnableSubKey(bl, pSViewLogicTypeParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxCount(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamCat(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamDesc(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamValue(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamValue2(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeId(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeName(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeParamId(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeParamName(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjScope(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefObjType(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSViewLogicTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSViewLogicTypeParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EnableSubKey(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isEnableSubKeyDirty() && !bl2 : !pSViewLogicTypeParam.isEnableSubKeyDirty()) {
            return null;
        }
        Integer n = pSViewLogicTypeParam.getEnableSubKey();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESUBKEY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnableSubKey_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESUBKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxCount(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isMaxCountDirty() : !pSViewLogicTypeParam.isMaxCountDirty()) {
            return null;
        }
        Integer n = pSViewLogicTypeParam.getMaxCount();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxCount_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXCOUNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isMemoDirty() : !pSViewLogicTypeParam.isMemoDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSViewLogicTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isOrderValueDirty() && !bl2 : !pSViewLogicTypeParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSViewLogicTypeParam.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSViewLogicTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamCat(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isParamCatDirty() : !pSViewLogicTypeParam.isParamCatDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getParamCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamCat_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamDesc(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isParamDescDirty() : !pSViewLogicTypeParam.isParamDescDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getParamDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamDesc_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isParamTypeDirty() && !bl2 : !pSViewLogicTypeParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getParamType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamValue(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isParamValueDirty() : !pSViewLogicTypeParam.isParamValueDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getParamValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamValue_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamValue2(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isParamValue2Dirty() : !pSViewLogicTypeParam.isParamValue2Dirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getParamValue2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamValue2_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMVALUE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeId(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isPSViewLogicTypeIdDirty() && !bl2 : !pSViewLogicTypeParam.isPSViewLogicTypeIdDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getPSViewLogicTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeId_Default(pSViewLogicTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewLogicTypeName(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isPSViewLogicTypeNameDirty() && !bl2 : !pSViewLogicTypeParam.isPSViewLogicTypeNameDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getPSViewLogicTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeName_Default(pSViewLogicTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewLogicTypeParamId(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isPSViewLogicTypeParamIdDirty() && !bl2 : !pSViewLogicTypeParam.isPSViewLogicTypeParamIdDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getPSViewLogicTypeParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeParamId_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeParamName(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isPSViewLogicTypeParamNameDirty() && !bl2 : !pSViewLogicTypeParam.isPSViewLogicTypeParamNameDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getPSViewLogicTypeParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeParamName_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjScope(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isRefObjScopeDirty() : !pSViewLogicTypeParam.isRefObjScopeDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getRefObjScope();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjScope_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJSCOPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefObjType(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isRefObjTypeDirty() : !pSViewLogicTypeParam.isRefObjTypeDirty()) {
            return null;
        }
        String string = pSViewLogicTypeParam.getRefObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefObjType_Default(pSViewLogicTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewLogicTypeParam.isValidFlagDirty() && !bl2 : !pSViewLogicTypeParam.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSViewLogicTypeParam.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSViewLogicTypeParam, bl2, bl3);
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

    protected void onSyncEntity(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        super.onSyncEntity(pSViewLogicTypeParam, bl);
    }

    protected void onSyncIndexEntities(PSViewLogicTypeParam pSViewLogicTypeParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSViewLogicTypeParam, bl);
    }

    public Object getDataContextValue(PSViewLogicTypeParam pSViewLogicTypeParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSViewLogicTypeParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSViewLogicType pSViewLogicType = pSViewLogicTypeParam.getPSViewLogicType();
        if (pSViewLogicType != null && pSViewLogicType.contains(string)) {
            return pSViewLogicType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSViewLogicTypeParam pSViewLogicTypeParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSViewLogicTypeParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESUBKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSubKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXCOUNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxCount_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMVALUE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamValue2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJSCOPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjScope_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefObjType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EnableSubKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxCount_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ParamCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMCAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMDESC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMVALUE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamValue2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMVALUE2", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_PSViewLogicTypeParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPEPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPEPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjScope_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJSCOPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFOBJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSViewLogicTypeParam pSViewLogicTypeParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSViewLogicTypeParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewLogicTypeParam pSViewLogicTypeParam) throws Exception {
        super.onUpdateParent(pSViewLogicTypeParam);
    }

    @Override
    protected void exportCurXmlModel(PSViewLogicTypeParam pSViewLogicTypeParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWLOGICTYPEPARAM");
        if (!bl) {
            pSViewLogicTypeParam.setCreateDate(null);
            pSViewLogicTypeParam.setCreateMan(null);
            pSViewLogicTypeParam.setPSViewLogicTypeParamId(null);
            pSViewLogicTypeParam.setUpdateDate(null);
            pSViewLogicTypeParam.setUpdateMan(null);
            super.exportCurXmlModel(pSViewLogicTypeParam, xmlNode, bl);
        }
    }
}

