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
import net.ibizsys.pscore.srv.config.dao.PSUIEngineTypeParamDAO;
import net.ibizsys.pscore.srv.config.demodel.PSUIEngineTypeParamDEModel;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSUIEngineTypeParam;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUIEngineTypeParamServiceBase
extends PSCoreSysServiceBase<PSUIEngineTypeParam> {
    private static final Log log = LogFactory.getLog(PSUIEngineTypeParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUIEngineTypeParamDEModel pSUIEngineTypeParamDEModel;
    private PSUIEngineTypeParamDAO pSUIEngineTypeParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSUIEngineTypeParamService";
    }

    public PSUIEngineTypeParamDEModel getPSUIEngineTypeParamDEModel() {
        if (this.pSUIEngineTypeParamDEModel == null) {
            try {
                this.pSUIEngineTypeParamDEModel = (PSUIEngineTypeParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSUIEngineTypeParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUIEngineTypeParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUIEngineTypeParamDEModel();
    }

    public PSUIEngineTypeParamDAO getPSUIEngineTypeParamDAO() {
        if (this.pSUIEngineTypeParamDAO == null) {
            try {
                this.pSUIEngineTypeParamDAO = (PSUIEngineTypeParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSUIEngineTypeParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUIEngineTypeParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUIEngineTypeParamDAO();
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

    protected void onFillParentInfo(PSUIEngineTypeParam pSUIEngineTypeParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUIENGINETYPEPARAM_PSUIENGINETYPE_PSUIENGINETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService", (SessionFactory)this.getSessionFactory());
            PSUIEngineType pSUIEngineType = (PSUIEngineType)iService.getDEModel().createEntity();
            pSUIEngineType.set("PSUIENGINETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUIEngineType);
            } else {
                iService.get((IEntity)pSUIEngineType);
            }
            this.onFillParentInfo_PSUIEngineType(pSUIEngineTypeParam, pSUIEngineType);
            return;
        }
        super.onFillParentInfo((IEntity)pSUIEngineTypeParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUIEngineType(PSUIEngineTypeParam pSUIEngineTypeParam, PSUIEngineType pSUIEngineType) throws Exception {
        pSUIEngineTypeParam.setPSUIEngineTypeId(pSUIEngineType.getPSUIEngineTypeId());
        pSUIEngineTypeParam.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
    }

    protected void onFillEntityFullInfo(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSUIEngineTypeParam, bl);
        this.onFillEntityFullInfo_PSUIEngineType(pSUIEngineTypeParam, bl);
    }

    protected void onFillEntityFullInfo_PSUIEngineType(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        if (pSUIEngineTypeParam.isPSUIEngineTypeIdDirty()) {
            if (pSUIEngineTypeParam.getPSUIEngineTypeId() != null) {
                if (pSUIEngineTypeParam.getPSUIEngineTypeId() == null || pSUIEngineTypeParam.getPSUIEngineTypeName() == null) {
                    PSUIEngineType pSUIEngineType = pSUIEngineTypeParam.getPSUIEngineType();
                    pSUIEngineTypeParam.setPSUIEngineTypeName(pSUIEngineType.getPSUIEngineTypeName());
                }
            } else {
                pSUIEngineTypeParam.setPSUIEngineTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUIEngineTypeParam, bl);
    }

    public ArrayList<PSUIEngineTypeParam> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, "", -1);
    }

    public ArrayList<PSUIEngineTypeParam> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string) throws Exception {
        return this.selectByPSUIEngineType(pSUIEngineTypeBase, string, -1);
    }

    public ArrayList<PSUIEngineTypeParam> selectByPSUIEngineType(PSUIEngineTypeBase pSUIEngineTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUIENGINETYPEID", (Object)pSUIEngineTypeBase.getPSUIEngineTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUIEngineTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUIEngineTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    public void resetPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSUIEngineTypeParam> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        for (PSUIEngineTypeParam pSUIEngineTypeParam : arrayList) {
            PSUIEngineTypeParam pSUIEngineTypeParam2 = (PSUIEngineTypeParam)this.getDEModel().createEntity();
            pSUIEngineTypeParam2.setPSUIEngineTypeParamId(pSUIEngineTypeParam.getPSUIEngineTypeParamId());
            pSUIEngineTypeParam2.setPSUIEngineTypeId(null);
            this.update(pSUIEngineTypeParam2);
        }
    }

    public void removeByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        final PSUIEngineType pSUIEngineType2 = pSUIEngineType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUIEngineTypeParamServiceBase.this.onBeforeRemoveByPSUIEngineType(pSUIEngineType2);
                PSUIEngineTypeParamServiceBase.this.internalRemoveByPSUIEngineType(pSUIEngineType2);
                PSUIEngineTypeParamServiceBase.this.onAfterRemoveByPSUIEngineType(pSUIEngineType2);
            }
        });
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void internalRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
        ArrayList<PSUIEngineTypeParam> arrayList = this.selectByPSUIEngineType(pSUIEngineType);
        this.onBeforeRemoveByPSUIEngineType(pSUIEngineType, arrayList);
        for (PSUIEngineTypeParam pSUIEngineTypeParam : arrayList) {
            this.remove((IEntity)pSUIEngineTypeParam);
        }
        this.onAfterRemoveByPSUIEngineType(pSUIEngineType, arrayList);
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType) throws Exception {
    }

    protected void onBeforeRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSUIEngineTypeParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUIEngineType(PSUIEngineType pSUIEngineType, ArrayList<PSUIEngineTypeParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUIEngineTypeParam pSUIEngineTypeParam) throws Exception {
        super.onBeforeRemove(pSUIEngineTypeParam);
    }

    protected void replaceParentInfo(PSUIEngineTypeParam pSUIEngineTypeParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUIEngineTypeParam, cloneSession);
        if (pSUIEngineTypeParam.getPSUIEngineTypeId() != null && (iEntity = cloneSession.getEntity("PSUIENGINETYPE", (Object)pSUIEngineTypeParam.getPSUIEngineTypeId())) != null) {
            this.onFillParentInfo_PSUIEngineType(pSUIEngineTypeParam, (PSUIEngineType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUIEngineTypeParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSUIEngineTypeId(bl, pSUIEngineTypeParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeName(bl, pSUIEngineTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeParamId(bl, pSUIEngineTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUIEngineTypeParamName(bl, pSUIEngineTypeParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUIEngineTypeParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeId(boolean bl, PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineTypeParam.isPSUIEngineTypeIdDirty() && !bl2 : !pSUIEngineTypeParam.isPSUIEngineTypeIdDirty()) {
            return null;
        }
        String string = pSUIEngineTypeParam.getPSUIEngineTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeId_Default((IEntity)pSUIEngineTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUIEngineTypeName(boolean bl, PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineTypeParam.isPSUIEngineTypeNameDirty() : !pSUIEngineTypeParam.isPSUIEngineTypeNameDirty()) {
            return null;
        }
        String string = pSUIEngineTypeParam.getPSUIEngineTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeName_Default((IEntity)pSUIEngineTypeParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUIEngineTypeParamId(boolean bl, PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineTypeParam.isPSUIEngineTypeParamIdDirty() && !bl2 : !pSUIEngineTypeParam.isPSUIEngineTypeParamIdDirty()) {
            return null;
        }
        String string = pSUIEngineTypeParam.getPSUIEngineTypeParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeParamId_Default((IEntity)pSUIEngineTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUIEngineTypeParamName(boolean bl, PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUIEngineTypeParam.isPSUIEngineTypeParamNameDirty() && !bl2 : !pSUIEngineTypeParam.isPSUIEngineTypeParamNameDirty()) {
            return null;
        }
        String string = pSUIEngineTypeParam.getPSUIEngineTypeParamName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEPARAMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUIEngineTypeParamName_Default((IEntity)pSUIEngineTypeParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUIENGINETYPEPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUIEngineTypeParam, bl);
    }

    protected void onSyncIndexEntities(PSUIEngineTypeParam pSUIEngineTypeParam, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUIEngineTypeParam, bl);
    }

    public Object getDataContextValue(PSUIEngineTypeParam pSUIEngineTypeParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUIEngineTypeParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSUIEngineType pSUIEngineType = pSUIEngineTypeParam.getPSUIEngineType();
        if (pSUIEngineType != null && pSUIEngineType.contains(string)) {
            return pSUIEngineType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSUIEngineTypeParam pSUIEngineTypeParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUIEngineTypeParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUIENGINETYPEPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUIEngineTypeParamName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSUIEngineTypeParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPEPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUIEngineTypeParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUIENGINETYPEPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSUIEngineTypeParam pSUIEngineTypeParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUIEngineTypeParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUIEngineTypeParam pSUIEngineTypeParam) throws Exception {
        super.onUpdateParent((IEntity)pSUIEngineTypeParam);
    }

    @Override
    protected void exportCurXmlModel(PSUIEngineTypeParam pSUIEngineTypeParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUIENGINETYPEPARAM");
        if (!bl) {
            pSUIEngineTypeParam.setCreateDate(null);
            pSUIEngineTypeParam.setCreateMan(null);
            pSUIEngineTypeParam.setPSUIEngineTypeParamId(null);
            pSUIEngineTypeParam.setUpdateDate(null);
            pSUIEngineTypeParam.setUpdateMan(null);
            super.exportCurXmlModel(pSUIEngineTypeParam, xmlNode, bl);
        }
    }
}

