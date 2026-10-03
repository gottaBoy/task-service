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
package net.ibizsys.pscore.srv.def.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCodeBase;
import net.ibizsys.pscore.srv.def.dao.PSDBProcParamDAO;
import net.ibizsys.pscore.srv.def.demodel.PSDBProcParamDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDBProcParam;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBProcParamServiceBase
extends PSCoreSysServiceBase<PSDBProcParam> {
    private static final Log log = LogFactory.getLog(PSDBProcParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBProcParamDEModel pSDBProcParamDEModel;
    private PSDBProcParamDAO pSDBProcParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.def.service.PSDBProcParamService";
    }

    public PSDBProcParamDEModel getPSDBProcParamDEModel() {
        if (this.pSDBProcParamDEModel == null) {
            try {
                this.pSDBProcParamDEModel = (PSDBProcParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDBProcParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBProcParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBProcParamDEModel();
    }

    public PSDBProcParamDAO getPSDBProcParamDAO() {
        if (this.pSDBProcParamDAO == null) {
            try {
                this.pSDBProcParamDAO = (PSDBProcParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.def.dao.PSDBProcParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBProcParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBProcParamDAO();
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

    protected void onFillParentInfo(PSDBProcParam pSDBProcParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBPROCPARAM_PSDESPCODE_PSDESPCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService", (SessionFactory)this.getSessionFactory());
            PSDESPCode pSDESPCode = (PSDESPCode)iService.getDEModel().createEntity();
            pSDESPCode.set("PSDESPCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDESPCode);
            } else {
                iService.get(pSDESPCode);
            }
            this.onFillParentInfo_PSDESPCode(pSDBProcParam, pSDESPCode);
            return;
        }
        super.onFillParentInfo(pSDBProcParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDESPCode(PSDBProcParam pSDBProcParam, PSDESPCode pSDESPCode) throws Exception {
        pSDBProcParam.setPSDESPCodeId(pSDESPCode.getPSDESPCodeId());
        pSDBProcParam.setPSDESPCodeName(pSDESPCode.getPSDESPCodeName());
    }

    protected void onFillEntityFullInfo(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDBProcParam, bl);
        this.onFillEntityFullInfo_PSDESPCode(pSDBProcParam, bl);
    }

    protected void onFillEntityFullInfo_PSDESPCode(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSDBProcParam, bl);
    }

    public ArrayList<PSDBProcParam> selectByPSDESPCode(PSDESPCodeBase pSDESPCodeBase) throws Exception {
        return this.selectByPSDESPCode(pSDESPCodeBase, "", -1);
    }

    public ArrayList<PSDBProcParam> selectByPSDESPCode(PSDESPCodeBase pSDESPCodeBase, String string) throws Exception {
        return this.selectByPSDESPCode(pSDESPCodeBase, string, -1);
    }

    public ArrayList<PSDBProcParam> selectByPSDESPCode(PSDESPCodeBase pSDESPCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESPCODEID", (Object)pSDESPCodeBase.getPSDESPCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESPCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESPCodeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
    }

    public void resetPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
        ArrayList<PSDBProcParam> arrayList = this.selectByPSDESPCode(pSDESPCode);
        for (PSDBProcParam pSDBProcParam : arrayList) {
            PSDBProcParam pSDBProcParam2 = (PSDBProcParam)this.getDEModel().createEntity();
            pSDBProcParam2.setPSDBProcParamId(pSDBProcParam.getPSDBProcParamId());
            pSDBProcParam2.setPSDESPCodeId(null);
            this.update(pSDBProcParam2);
        }
    }

    public void removeByPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
        final PSDESPCode pSDESPCode2 = pSDESPCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBProcParamServiceBase.this.onBeforeRemoveByPSDESPCode(pSDESPCode2);
                PSDBProcParamServiceBase.this.internalRemoveByPSDESPCode(pSDESPCode2);
                PSDBProcParamServiceBase.this.onAfterRemoveByPSDESPCode(pSDESPCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
    }

    protected void internalRemoveByPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
        ArrayList<PSDBProcParam> arrayList = this.selectByPSDESPCode(pSDESPCode);
        this.onBeforeRemoveByPSDESPCode(pSDESPCode, arrayList);
        for (PSDBProcParam pSDBProcParam : arrayList) {
            this.remove(pSDBProcParam);
        }
        this.onAfterRemoveByPSDESPCode(pSDESPCode, arrayList);
    }

    protected void onAfterRemoveByPSDESPCode(PSDESPCode pSDESPCode) throws Exception {
    }

    protected void onBeforeRemoveByPSDESPCode(PSDESPCode pSDESPCode, ArrayList<PSDBProcParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESPCode(PSDESPCode pSDESPCode, ArrayList<PSDBProcParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBProcParam pSDBProcParam) throws Exception {
        super.onBeforeRemove(pSDBProcParam);
    }

    protected void replaceParentInfo(PSDBProcParam pSDBProcParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDBProcParam, cloneSession);
        if (pSDBProcParam.getPSDESPCodeId() != null && (iEntity = cloneSession.getEntity("PSDESPCODE", (Object)pSDBProcParam.getPSDESPCodeId())) != null) {
            this.onFillParentInfo_PSDESPCode(pSDBProcParam, (PSDESPCode)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDBProcParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_JdbcType(bl, pSDBProcParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamDIR(bl, pSDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBProcParamId(bl, pSDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBProcParamName(bl, pSDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESPCodeId(bl, pSDBProcParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDBProcParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_JdbcType(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isJdbcTypeDirty() && !bl2 : !pSDBProcParam.isJdbcTypeDirty()) {
            return null;
        }
        Integer n = pSDBProcParam.getJdbcType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_JdbcType_Default(pSDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JDBCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isOrderValueDirty() && !bl2 : !pSDBProcParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDBProcParam.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDBProcParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_ParamDIR(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isParamDIRDirty() && !bl2 : !pSDBProcParam.isParamDIRDirty()) {
            return null;
        }
        Integer n = pSDBProcParam.getParamDIR();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDIR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ParamDIR_Default(pSDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBProcParamId(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isPSDBProcParamIdDirty() && !bl2 : !pSDBProcParam.isPSDBProcParamIdDirty()) {
            return null;
        }
        String string = pSDBProcParam.getPSDBProcParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBPROCPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBProcParamId_Default(pSDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBPROCPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBProcParamName(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isPSDBProcParamNameDirty() && !bl2 : !pSDBProcParam.isPSDBProcParamNameDirty()) {
            return null;
        }
        String string = pSDBProcParam.getPSDBProcParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBPROCPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBProcParamName_Default(pSDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBPROCPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESPCodeId(boolean bl, PSDBProcParam pSDBProcParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBProcParam.isPSDESPCodeIdDirty() && !bl2 : !pSDBProcParam.isPSDESPCodeIdDirty()) {
            return null;
        }
        String string = pSDBProcParam.getPSDESPCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESPCodeId_Default(pSDBProcParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESPCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
        super.onSyncEntity(pSDBProcParam, bl);
    }

    protected void onSyncIndexEntities(PSDBProcParam pSDBProcParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDBProcParam, bl);
    }

    public Object getDataContextValue(PSDBProcParam pSDBProcParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDBProcParam, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBProcParam pSDBProcParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDBProcParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JDBCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JdbcType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamDIR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBPROCPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBProcParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBPROCPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBProcParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESPCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESPCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_JdbcType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamDIR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDBProcParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBPROCPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBProcParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBPROCPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESPCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESPCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDBProcParam pSDBProcParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDBProcParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBProcParam pSDBProcParam) throws Exception {
        super.onUpdateParent(pSDBProcParam);
    }

    @Override
    protected void exportCurXmlModel(PSDBProcParam pSDBProcParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBPROCPARAM");
        if (!bl) {
            pSDBProcParam.setCreateDate(null);
            pSDBProcParam.setCreateMan(null);
            pSDBProcParam.setPSDBProcParamId(null);
            pSDBProcParam.setUpdateDate(null);
            pSDBProcParam.setUpdateMan(null);
            super.exportCurXmlModel(pSDBProcParam, xmlNode, bl);
        }
    }
}

