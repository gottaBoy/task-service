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
import net.ibizsys.pscore.srv.config.dao.PSDBVFCodeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDBVFCodeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDBType;
import net.ibizsys.pscore.srv.config.entity.PSDBTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSDBVFCode;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFunc;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFuncBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBVFCodeServiceBase
extends PSCoreSysServiceBase<PSDBVFCode> {
    private static final Log log = LogFactory.getLog(PSDBVFCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBVFCodeDEModel pSDBVFCodeDEModel;
    private PSDBVFCodeDAO pSDBVFCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDBVFCodeService";
    }

    public PSDBVFCodeDEModel getPSDBVFCodeDEModel() {
        if (this.pSDBVFCodeDEModel == null) {
            try {
                this.pSDBVFCodeDEModel = (PSDBVFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDBVFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBVFCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBVFCodeDEModel();
    }

    public PSDBVFCodeDAO getPSDBVFCodeDAO() {
        if (this.pSDBVFCodeDAO == null) {
            try {
                this.pSDBVFCodeDAO = (PSDBVFCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDBVFCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBVFCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBVFCodeDAO();
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

    protected void onFillParentInfo(PSDBVFCode pSDBVFCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBVFCODE_PSDBTYPE_PSDBTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBTypeService", (SessionFactory)this.getSessionFactory());
            PSDBType pSDBType = (PSDBType)iService.getDEModel().createEntity();
            pSDBType.set("PSDBTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBType);
            } else {
                iService.get((IEntity)pSDBType);
            }
            this.onFillParentInfo_PSDBType(pSDBVFCode, pSDBType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBVFCODE_PSDBVALUEFUNC_PSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueFuncService", (SessionFactory)this.getSessionFactory());
            PSDBValueFunc pSDBValueFunc = (PSDBValueFunc)iService.getDEModel().createEntity();
            pSDBValueFunc.set("PSDBVALUEFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBValueFunc);
            } else {
                iService.get((IEntity)pSDBValueFunc);
            }
            this.onFillParentInfo_PSDBVF(pSDBVFCode, pSDBValueFunc);
            return;
        }
        super.onFillParentInfo((IEntity)pSDBVFCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBType(PSDBVFCode pSDBVFCode, PSDBType pSDBType) throws Exception {
        pSDBVFCode.setPSDBTypeId(pSDBType.getPSDBTypeId());
        pSDBVFCode.setPSDBTypeName(pSDBType.getPSDBTypeName());
    }

    protected void onFillParentInfo_PSDBVF(PSDBVFCode pSDBVFCode, PSDBValueFunc pSDBValueFunc) throws Exception {
        pSDBVFCode.setPSDBVFID(pSDBValueFunc.getPSDBValueFuncId());
        pSDBVFCode.setPSDBVFName(pSDBValueFunc.getPSDBValueFuncName());
    }

    protected void onFillEntityFullInfo(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDBVFCode, bl);
        this.onFillEntityFullInfo_PSDBType(pSDBVFCode, bl);
        this.onFillEntityFullInfo_PSDBVF(pSDBVFCode, bl);
    }

    protected void onFillEntityFullInfo_PSDBType(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDBVF(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDBVFCode, bl);
    }

    public ArrayList<PSDBVFCode> selectByPSDBType(PSDBTypeBase pSDBTypeBase) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, "", -1);
    }

    public ArrayList<PSDBVFCode> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string) throws Exception {
        return this.selectByPSDBType(pSDBTypeBase, string, -1);
    }

    public ArrayList<PSDBVFCode> selectByPSDBType(PSDBTypeBase pSDBTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBTYPEID", (Object)pSDBTypeBase.getPSDBTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDBVFCode> selectByPSDBVF(PSDBValueFuncBase pSDBValueFuncBase) throws Exception {
        return this.selectByPSDBVF(pSDBValueFuncBase, "", -1);
    }

    public ArrayList<PSDBVFCode> selectByPSDBVF(PSDBValueFuncBase pSDBValueFuncBase, String string) throws Exception {
        return this.selectByPSDBVF(pSDBValueFuncBase, string, -1);
    }

    public ArrayList<PSDBVFCode> selectByPSDBVF(PSDBValueFuncBase pSDBValueFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVFID", (Object)pSDBValueFuncBase.getPSDBValueFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBVFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBVFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    public void resetPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDBVFCode> arrayList = this.selectByPSDBType(pSDBType);
        for (PSDBVFCode pSDBVFCode : arrayList) {
            PSDBVFCode pSDBVFCode2 = (PSDBVFCode)this.getDEModel().createEntity();
            pSDBVFCode2.setPSDBVFCodeId(pSDBVFCode.getPSDBVFCodeId());
            pSDBVFCode2.setPSDBTypeId(null);
            this.update(pSDBVFCode2);
        }
    }

    public void removeByPSDBType(PSDBType pSDBType) throws Exception {
        final PSDBType pSDBType2 = pSDBType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBVFCodeServiceBase.this.onBeforeRemoveByPSDBType(pSDBType2);
                PSDBVFCodeServiceBase.this.internalRemoveByPSDBType(pSDBType2);
                PSDBVFCodeServiceBase.this.onAfterRemoveByPSDBType(pSDBType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void internalRemoveByPSDBType(PSDBType pSDBType) throws Exception {
        ArrayList<PSDBVFCode> arrayList = this.selectByPSDBType(pSDBType);
        this.onBeforeRemoveByPSDBType(pSDBType, arrayList);
        for (PSDBVFCode pSDBVFCode : arrayList) {
            this.remove((IEntity)pSDBVFCode);
        }
        this.onAfterRemoveByPSDBType(pSDBType, arrayList);
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType) throws Exception {
    }

    protected void onBeforeRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDBVFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBType(PSDBType pSDBType, ArrayList<PSDBVFCode> arrayList) throws Exception {
    }

    public void testRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
    }

    public void resetPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
        ArrayList<PSDBVFCode> arrayList = this.selectByPSDBVF(pSDBValueFunc);
        for (PSDBVFCode pSDBVFCode : arrayList) {
            PSDBVFCode pSDBVFCode2 = (PSDBVFCode)this.getDEModel().createEntity();
            pSDBVFCode2.setPSDBVFCodeId(pSDBVFCode.getPSDBVFCodeId());
            pSDBVFCode2.setPSDBVFID(null);
            this.update(pSDBVFCode2);
        }
    }

    public void removeByPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
        final PSDBValueFunc pSDBValueFunc2 = pSDBValueFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBVFCodeServiceBase.this.onBeforeRemoveByPSDBVF(pSDBValueFunc2);
                PSDBVFCodeServiceBase.this.internalRemoveByPSDBVF(pSDBValueFunc2);
                PSDBVFCodeServiceBase.this.onAfterRemoveByPSDBVF(pSDBValueFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
    }

    protected void internalRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
        ArrayList<PSDBVFCode> arrayList = this.selectByPSDBVF(pSDBValueFunc);
        this.onBeforeRemoveByPSDBVF(pSDBValueFunc, arrayList);
        for (PSDBVFCode pSDBVFCode : arrayList) {
            this.remove((IEntity)pSDBVFCode);
        }
        this.onAfterRemoveByPSDBVF(pSDBValueFunc, arrayList);
    }

    protected void onAfterRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc, ArrayList<PSDBVFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBVF(PSDBValueFunc pSDBValueFunc, ArrayList<PSDBVFCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBVFCode pSDBVFCode) throws Exception {
        super.onBeforeRemove(pSDBVFCode);
    }

    protected void replaceParentInfo(PSDBVFCode pSDBVFCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDBVFCode, cloneSession);
        if (pSDBVFCode.getPSDBTypeId() != null && (iEntity = cloneSession.getEntity("PSDBTYPE", (Object)pSDBVFCode.getPSDBTypeId())) != null) {
            this.onFillParentInfo_PSDBType(pSDBVFCode, (PSDBType)iEntity);
        }
        if (pSDBVFCode.getPSDBVFID() != null && (iEntity = cloneSession.getEntity("PSDBVALUEFUNC", (Object)pSDBVFCode.getPSDBVFID())) != null) {
            this.onFillParentInfo_PSDBVF(pSDBVFCode, (PSDBValueFunc)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDBVFCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_FUNCCode(bl, pSDBVFCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBTypeId(bl, pSDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBVFCodeId(bl, pSDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBVFCodeName(bl, pSDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBVFID(bl, pSDBVFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDBVFCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_FUNCCode(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isFUNCCodeDirty() && !bl2 : !pSDBVFCode.isFUNCCodeDirty()) {
            return null;
        }
        String string = pSDBVFCode.getFUNCCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FUNCCode_Default((IEntity)pSDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FUNCCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isMemoDirty() : !pSDBVFCode.isMemoDirty()) {
            return null;
        }
        String string = pSDBVFCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDBVFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBTypeId(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isPSDBTypeIdDirty() && !bl2 : !pSDBVFCode.isPSDBTypeIdDirty()) {
            return null;
        }
        String string = pSDBVFCode.getPSDBTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBTypeId_Default((IEntity)pSDBVFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDBVFCodeId(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isPSDBVFCodeIdDirty() && !bl2 : !pSDBVFCode.isPSDBVFCodeIdDirty()) {
            return null;
        }
        String string = pSDBVFCode.getPSDBVFCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBVFCodeId_Default((IEntity)pSDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBVFCodeName(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isPSDBVFCodeNameDirty() && !bl2 : !pSDBVFCode.isPSDBVFCodeNameDirty()) {
            return null;
        }
        String string = pSDBVFCode.getPSDBVFCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBVFCodeName_Default((IEntity)pSDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBVFID(boolean bl, PSDBVFCode pSDBVFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBVFCode.isPSDBVFIDDirty() && !bl2 : !pSDBVFCode.isPSDBVFIDDirty()) {
            return null;
        }
        String string = pSDBVFCode.getPSDBVFID();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBVFID_Default((IEntity)pSDBVFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDBVFCode, bl);
    }

    protected void onSyncIndexEntities(PSDBVFCode pSDBVFCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDBVFCode, bl);
    }

    public Object getDataContextValue(PSDBVFCode pSDBVFCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDBVFCode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBVFCode pSDBVFCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDBVFCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FUNCCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FUNCCode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDBVFCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBVFCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBVFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBVFID_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBVFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FUNCCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FUNCCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_PSDBVFCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVFCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBVFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVFCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBVFID_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBVFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDBVFCode pSDBVFCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDBVFCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBVFCode pSDBVFCode) throws Exception {
        super.onUpdateParent((IEntity)pSDBVFCode);
    }

    @Override
    protected void exportCurXmlModel(PSDBVFCode pSDBVFCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBVFCODE");
        if (!bl) {
            pSDBVFCode.setCreateDate(null);
            pSDBVFCode.setCreateMan(null);
            pSDBVFCode.setPSDBVFCodeId(null);
            pSDBVFCode.setUpdateDate(null);
            pSDBVFCode.setUpdateMan(null);
            super.exportCurXmlModel(pSDBVFCode, xmlNode, bl);
        }
    }
}

