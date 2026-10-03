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
import net.ibizsys.pscore.srv.config.dao.PSSFCodeTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFCodeTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTempl;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCodeTemplServiceBase
extends PSCoreSysServiceBase<PSSFCodeTempl> {
    private static final Log log = LogFactory.getLog(PSSFCodeTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFCodeTemplDEModel pSSFCodeTemplDEModel;
    private PSSFCodeTemplDAO pSSFCodeTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFCodeTemplService";
    }

    public PSSFCodeTemplDEModel getPSSFCodeTemplDEModel() {
        if (this.pSSFCodeTemplDEModel == null) {
            try {
                this.pSSFCodeTemplDEModel = (PSSFCodeTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCodeTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFCodeTemplDEModel();
    }

    public PSSFCodeTemplDAO getPSSFCodeTemplDAO() {
        if (this.pSSFCodeTemplDAO == null) {
            try {
                this.pSSFCodeTemplDAO = (PSSFCodeTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFCodeTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFCodeTemplDAO();
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

    protected void onFillParentInfo(PSSFCodeTempl pSSFCodeTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFCODETEMPL_PSSFCODETYPE_PSSFCODETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService", (SessionFactory)this.getSessionFactory());
            PSSFCodeType pSSFCodeType = (PSSFCodeType)iService.getDEModel().createEntity();
            pSSFCodeType.set("PSSFCODETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFCodeType);
            } else {
                iService.get(pSSFCodeType);
            }
            this.onFillParentInfo_PSSFCodeType(pSSFCodeTempl, pSSFCodeType);
            return;
        }
        super.onFillParentInfo(pSSFCodeTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFCodeType(PSSFCodeTempl pSSFCodeTempl, PSSFCodeType pSSFCodeType) throws Exception {
        pSSFCodeTempl.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
        pSSFCodeTempl.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
        pSSFCodeTempl.setPSSFStyleId(pSSFCodeType.getPSSFStyleId());
    }

    protected void onFillEntityFullInfo(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
        if (bl && pSSFCodeTempl.getValidFlag() == null) {
            pSSFCodeTempl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSFCodeTempl, bl);
        this.onFillEntityFullInfo_PSSFCodeType(pSSFCodeTempl, bl);
    }

    protected void onFillEntityFullInfo_PSSFCodeType(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFCodeTempl, bl);
    }

    public ArrayList<PSSFCodeTempl> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, "", -1);
    }

    public ArrayList<PSSFCodeTempl> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, string, -1);
    }

    public ArrayList<PSSFCodeTempl> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODETYPEID", (Object)pSSFCodeTypeBase.getPSSFCodeTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    public void resetPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSFCodeTempl> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        for (PSSFCodeTempl pSSFCodeTempl : arrayList) {
            PSSFCodeTempl pSSFCodeTempl2 = (PSSFCodeTempl)this.getDEModel().createEntity();
            pSSFCodeTempl2.setPSSFCodeTemplId(pSSFCodeTempl.getPSSFCodeTemplId());
            pSSFCodeTempl2.setPSSFCodeTypeId(null);
            this.update(pSSFCodeTempl2);
        }
    }

    public void removeByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        final PSSFCodeType pSSFCodeType2 = pSSFCodeType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFCodeTemplServiceBase.this.onBeforeRemoveByPSSFCodeType(pSSFCodeType2);
                PSSFCodeTemplServiceBase.this.internalRemoveByPSSFCodeType(pSSFCodeType2);
                PSSFCodeTemplServiceBase.this.onAfterRemoveByPSSFCodeType(pSSFCodeType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void internalRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSFCodeTempl> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        this.onBeforeRemoveByPSSFCodeType(pSSFCodeType, arrayList);
        for (PSSFCodeTempl pSSFCodeTempl : arrayList) {
            this.remove(pSSFCodeTempl);
        }
        this.onAfterRemoveByPSSFCodeType(pSSFCodeType, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSFCodeTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSFCodeTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFCodeTempl pSSFCodeTempl) throws Exception {
        super.onBeforeRemove(pSSFCodeTempl);
    }

    protected void replaceParentInfo(PSSFCodeTempl pSSFCodeTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFCodeTempl, cloneSession);
        if (pSSFCodeTempl.getPSSFCodeTypeId() != null && (iEntity = cloneSession.getEntity("PSSFCODETYPE", (Object)pSSFCodeTempl.getPSSFCodeTypeId())) != null) {
            this.onFillParentInfo_PSSFCodeType(pSSFCodeTempl, (PSSFCodeType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFCodeTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicName(bl, pSSFCodeTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTemplId(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTemplName(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeId(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplDesc(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFCodeTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFCodeTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isLogicNameDirty() : !pSSFCodeTempl.isLogicNameDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSFCodeTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isMemoDirty() : !pSSFCodeTempl.isMemoDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFCodeTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeTemplId(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isPSSFCodeTemplIdDirty() && !bl2 : !pSSFCodeTempl.isPSSFCodeTemplIdDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getPSSFCodeTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTemplId_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTemplName(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isPSSFCodeTemplNameDirty() && !bl2 : !pSSFCodeTempl.isPSSFCodeTemplNameDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getPSSFCodeTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTemplName_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTypeId(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isPSSFCodeTypeIdDirty() && !bl2 : !pSSFCodeTempl.isPSSFCodeTypeIdDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getPSSFCodeTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeId_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isTemplCodeDirty() : !pSSFCodeTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isTemplCode2Dirty() : !pSSFCodeTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplDesc(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isTemplDescDirty() : !pSSFCodeTempl.isTemplDescDirty()) {
            return null;
        }
        String string = pSSFCodeTempl.getTemplDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplDesc_Default(pSSFCodeTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFCodeTempl pSSFCodeTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFCodeTempl.isValidFlagDirty() : !pSSFCodeTempl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFCodeTempl.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSFCodeTempl, bl2, bl3);
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

    protected void onSyncEntity(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSSFCodeTempl, bl);
    }

    protected void onSyncIndexEntities(PSSFCodeTempl pSSFCodeTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFCodeTempl, bl);
    }

    public Object getDataContextValue(PSSFCodeTempl pSSFCodeTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFCodeTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFCodeType pSSFCodeType = pSSFCodeTempl.getPSSFCodeType();
        if (pSSFCodeType != null && pSSFCodeType.contains(string)) {
            return pSSFCodeType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFCodeTempl pSSFCodeTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFCodeTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplDesc_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSFCodeTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSSFCodeTempl pSSFCodeTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFCodeTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFCodeTempl pSSFCodeTempl) throws Exception {
        super.onUpdateParent(pSSFCodeTempl);
    }

    @Override
    protected void exportCurXmlModel(PSSFCodeTempl pSSFCodeTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFCODETEMPL");
        if (!bl) {
            pSSFCodeTempl.setCreateDate(null);
            pSSFCodeTempl.setCreateMan(null);
            pSSFCodeTempl.setPSSFCodeTemplId(null);
            pSSFCodeTempl.setPSSFStyleId(null);
            pSSFCodeTempl.setUpdateDate(null);
            pSSFCodeTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSSFCodeTempl, xmlNode, bl);
        }
    }
}

