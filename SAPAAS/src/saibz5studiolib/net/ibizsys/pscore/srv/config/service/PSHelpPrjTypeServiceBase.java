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
import net.ibizsys.pscore.srv.config.dao.PSHelpPrjTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSHelpPrjTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSHelpPrjTempl;
import net.ibizsys.pscore.srv.config.entity.PSHelpPrjTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSHelpPrjType;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSHelpPrjTypeServiceBase
extends PSCoreSysServiceBase<PSHelpPrjType> {
    private static final Log log = LogFactory.getLog(PSHelpPrjTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSHelpPrjTypeDEModel pSHelpPrjTypeDEModel;
    private PSHelpPrjTypeDAO pSHelpPrjTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSHelpPrjTypeService";
    }

    public PSHelpPrjTypeDEModel getPSHelpPrjTypeDEModel() {
        if (this.pSHelpPrjTypeDEModel == null) {
            try {
                this.pSHelpPrjTypeDEModel = (PSHelpPrjTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSHelpPrjTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpPrjTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSHelpPrjTypeDEModel();
    }

    public PSHelpPrjTypeDAO getPSHelpPrjTypeDAO() {
        if (this.pSHelpPrjTypeDAO == null) {
            try {
                this.pSHelpPrjTypeDAO = (PSHelpPrjTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSHelpPrjTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpPrjTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSHelpPrjTypeDAO();
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

    protected void onFillParentInfo(PSHelpPrjType pSHelpPrjType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSHELPPRJTYPE_PSHELPPRJTEMPL_PSHELPPRJTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSHelpPrjTemplService", (SessionFactory)this.getSessionFactory());
            PSHelpPrjTempl pSHelpPrjTempl = (PSHelpPrjTempl)iService.getDEModel().createEntity();
            pSHelpPrjTempl.set("PSHELPPRJTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSHelpPrjTempl);
            } else {
                iService.get((IEntity)pSHelpPrjTempl);
            }
            this.onFillParentInfo_PSHelpPrjTempl(pSHelpPrjType, pSHelpPrjTempl);
            return;
        }
        super.onFillParentInfo((IEntity)pSHelpPrjType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSHelpPrjTempl(PSHelpPrjType pSHelpPrjType, PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
        pSHelpPrjType.setPSHelpPrjTemplId(pSHelpPrjTempl.getPSHelpPrjTemplId());
        pSHelpPrjType.setPSHelpPrjTemplName(pSHelpPrjTempl.getPSHelpPrjTemplName());
    }

    protected void onFillEntityFullInfo(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
        if (bl && pSHelpPrjType.getValidFlag() == null) {
            pSHelpPrjType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSHelpPrjType, bl);
        this.onFillEntityFullInfo_PSHelpPrjTempl(pSHelpPrjType, bl);
    }

    protected void onFillEntityFullInfo_PSHelpPrjTempl(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSHelpPrjType, bl);
    }

    public ArrayList<PSHelpPrjType> selectByPSHelpPrjTempl(PSHelpPrjTemplBase pSHelpPrjTemplBase) throws Exception {
        return this.selectByPSHelpPrjTempl(pSHelpPrjTemplBase, "", -1);
    }

    public ArrayList<PSHelpPrjType> selectByPSHelpPrjTempl(PSHelpPrjTemplBase pSHelpPrjTemplBase, String string) throws Exception {
        return this.selectByPSHelpPrjTempl(pSHelpPrjTemplBase, string, -1);
    }

    public ArrayList<PSHelpPrjType> selectByPSHelpPrjTempl(PSHelpPrjTemplBase pSHelpPrjTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPPRJTEMPLID", (Object)pSHelpPrjTemplBase.getPSHelpPrjTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpPrjTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpPrjTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
    }

    public void resetPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
        ArrayList<PSHelpPrjType> arrayList = this.selectByPSHelpPrjTempl(pSHelpPrjTempl);
        for (PSHelpPrjType pSHelpPrjType : arrayList) {
            PSHelpPrjType pSHelpPrjType2 = (PSHelpPrjType)this.getDEModel().createEntity();
            pSHelpPrjType2.setPSHelpPrjTypeId(pSHelpPrjType.getPSHelpPrjTypeId());
            pSHelpPrjType2.setPSHelpPrjTemplId(null);
            this.update(pSHelpPrjType2);
        }
    }

    public void removeByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
        final PSHelpPrjTempl pSHelpPrjTempl2 = pSHelpPrjTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSHelpPrjTypeServiceBase.this.onBeforeRemoveByPSHelpPrjTempl(pSHelpPrjTempl2);
                PSHelpPrjTypeServiceBase.this.internalRemoveByPSHelpPrjTempl(pSHelpPrjTempl2);
                PSHelpPrjTypeServiceBase.this.onAfterRemoveByPSHelpPrjTempl(pSHelpPrjTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
    }

    protected void internalRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
        ArrayList<PSHelpPrjType> arrayList = this.selectByPSHelpPrjTempl(pSHelpPrjTempl);
        this.onBeforeRemoveByPSHelpPrjTempl(pSHelpPrjTempl, arrayList);
        for (PSHelpPrjType pSHelpPrjType : arrayList) {
            this.remove((IEntity)pSHelpPrjType);
        }
        this.onAfterRemoveByPSHelpPrjTempl(pSHelpPrjTempl, arrayList);
    }

    protected void onAfterRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl, ArrayList<PSHelpPrjType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpPrjTempl(PSHelpPrjTempl pSHelpPrjTempl, ArrayList<PSHelpPrjType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSHelpPrjType pSHelpPrjType) throws Exception {
        super.onBeforeRemove(pSHelpPrjType);
    }

    protected void replaceParentInfo(PSHelpPrjType pSHelpPrjType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSHelpPrjType, cloneSession);
        if (pSHelpPrjType.getPSHelpPrjTemplId() != null && (iEntity = cloneSession.getEntity("PSHELPPRJTEMPL", (Object)pSHelpPrjType.getPSHelpPrjTemplId())) != null) {
            this.onFillParentInfo_PSHelpPrjTempl(pSHelpPrjType, (PSHelpPrjTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSHelpPrjType, bl);
    }

    protected void onCheckEntity(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSHelpPrjType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjObj(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpPrjTemplId(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpPrjTypeId(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpPrjTypeName(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSHelpPrjType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSHelpPrjType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isMemoDirty() : !pSHelpPrjType.isMemoDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSHelpPrjType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PrjObj(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isPrjObjDirty() : !pSHelpPrjType.isPrjObjDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getPrjObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjObj_Default((IEntity)pSHelpPrjType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpPrjTemplId(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isPSHelpPrjTemplIdDirty() : !pSHelpPrjType.isPSHelpPrjTemplIdDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getPSHelpPrjTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpPrjTemplId_Default((IEntity)pSHelpPrjType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpPrjTypeId(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isPSHelpPrjTypeIdDirty() && !bl2 : !pSHelpPrjType.isPSHelpPrjTypeIdDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getPSHelpPrjTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpPrjTypeId_Default((IEntity)pSHelpPrjType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSHelpPrjTypeName(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isPSHelpPrjTypeNameDirty() && !bl2 : !pSHelpPrjType.isPSHelpPrjTypeNameDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getPSHelpPrjTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpPrjTypeName_Default((IEntity)pSHelpPrjType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPPRJTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isPubObjDirty() && !bl2 : !pSHelpPrjType.isPubObjDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default((IEntity)pSHelpPrjType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isTypeObjDirty() : !pSHelpPrjType.isTypeObjDirty()) {
            return null;
        }
        String string = pSHelpPrjType.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default((IEntity)pSHelpPrjType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSHelpPrjType pSHelpPrjType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSHelpPrjType.isValidFlagDirty() && !bl2 : !pSHelpPrjType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSHelpPrjType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSHelpPrjType, bl2, bl3);
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

    protected void onSyncEntity(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSHelpPrjType, bl);
    }

    protected void onSyncIndexEntities(PSHelpPrjType pSHelpPrjType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSHelpPrjType, bl);
    }

    public Object getDataContextValue(PSHelpPrjType pSHelpPrjType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSHelpPrjType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSHelpPrjType pSHelpPrjType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSHelpPrjType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PRJOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPPRJTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpPrjTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpPrjTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpPrjTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpPrjTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpPrjTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPPRJTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected boolean onMergeChild(String string, String string2, PSHelpPrjType pSHelpPrjType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSHelpPrjType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSHelpPrjType pSHelpPrjType) throws Exception {
        super.onUpdateParent((IEntity)pSHelpPrjType);
    }

    @Override
    protected void exportCurXmlModel(PSHelpPrjType pSHelpPrjType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSHELPPRJTYPE");
        if (!bl) {
            pSHelpPrjType.setCreateDate(null);
            pSHelpPrjType.setCreateMan(null);
            pSHelpPrjType.setPSHelpPrjTemplName(null);
            pSHelpPrjType.setUpdateDate(null);
            pSHelpPrjType.setUpdateMan(null);
            super.exportCurXmlModel(pSHelpPrjType, xmlNode, bl);
        }
    }
}

