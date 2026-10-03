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
import net.ibizsys.pscore.srv.config.dao.PSViewTypeLogicDAO;
import net.ibizsys.pscore.srv.config.demodel.PSViewTypeLogicDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeLogic;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeLogicServiceBase
extends PSCoreSysServiceBase<PSViewTypeLogic> {
    private static final Log log = LogFactory.getLog(PSViewTypeLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSViewTypeLogicDEModel pSViewTypeLogicDEModel;
    private PSViewTypeLogicDAO pSViewTypeLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSViewTypeLogicService";
    }

    public PSViewTypeLogicDEModel getPSViewTypeLogicDEModel() {
        if (this.pSViewTypeLogicDEModel == null) {
            try {
                this.pSViewTypeLogicDEModel = (PSViewTypeLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewTypeLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewTypeLogicDEModel();
    }

    public PSViewTypeLogicDAO getPSViewTypeLogicDAO() {
        if (this.pSViewTypeLogicDAO == null) {
            try {
                this.pSViewTypeLogicDAO = (PSViewTypeLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSViewTypeLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewTypeLogicDAO();
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

    protected void onFillParentInfo(PSViewTypeLogic pSViewTypeLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWTYPELOGIC_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory());
            PSViewLogicType pSViewLogicType = (PSViewLogicType)iService.getDEModel().createEntity();
            pSViewLogicType.set("PSVIEWLOGICTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewLogicType);
            } else {
                iService.get(pSViewLogicType);
            }
            this.onFillParentInfo_PSViewLogicType(pSViewTypeLogic, pSViewLogicType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWTYPELOGIC_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSViewTypeLogic, pSViewType);
            return;
        }
        super.onFillParentInfo(pSViewTypeLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewLogicType(PSViewTypeLogic pSViewTypeLogic, PSViewLogicType pSViewLogicType) throws Exception {
        pSViewTypeLogic.setPSViewLogicTypeId(pSViewLogicType.getPSViewLogicTypeId());
        pSViewTypeLogic.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
    }

    protected void onFillParentInfo_PSViewType(PSViewTypeLogic pSViewTypeLogic, PSViewType pSViewType) throws Exception {
        pSViewTypeLogic.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSViewTypeLogic.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSViewTypeLogic, bl);
        this.onFillEntityFullInfo_PSViewLogicType(pSViewTypeLogic, bl);
        this.onFillEntityFullInfo_PSViewType(pSViewTypeLogic, bl);
    }

    protected void onFillEntityFullInfo_PSViewLogicType(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSViewTypeLogic, bl);
    }

    public ArrayList<PSViewTypeLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, "", -1);
    }

    public ArrayList<PSViewTypeLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, string, -1);
    }

    public ArrayList<PSViewTypeLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSViewTypeLogic> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSViewTypeLogic> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSViewTypeLogic> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPEID", (Object)pSViewTypeBase.getPSViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    public void resetPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSViewTypeLogic> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        for (PSViewTypeLogic pSViewTypeLogic : arrayList) {
            PSViewTypeLogic pSViewTypeLogic2 = (PSViewTypeLogic)this.getDEModel().createEntity();
            pSViewTypeLogic2.setPSViewTypeLogicId(pSViewTypeLogic.getPSViewTypeLogicId());
            pSViewTypeLogic2.setPSViewLogicTypeId(null);
            this.update(pSViewTypeLogic2);
        }
    }

    public void removeByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        final PSViewLogicType pSViewLogicType2 = pSViewLogicType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewTypeLogicServiceBase.this.onBeforeRemoveByPSViewLogicType(pSViewLogicType2);
                PSViewTypeLogicServiceBase.this.internalRemoveByPSViewLogicType(pSViewLogicType2);
                PSViewTypeLogicServiceBase.this.onAfterRemoveByPSViewLogicType(pSViewLogicType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void internalRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSViewTypeLogic> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        this.onBeforeRemoveByPSViewLogicType(pSViewLogicType, arrayList);
        for (PSViewTypeLogic pSViewTypeLogic : arrayList) {
            this.remove(pSViewTypeLogic);
        }
        this.onAfterRemoveByPSViewLogicType(pSViewLogicType, arrayList);
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSViewTypeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSViewTypeLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSViewTypeLogic> arrayList = this.selectByPSViewType(pSViewType);
        for (PSViewTypeLogic pSViewTypeLogic : arrayList) {
            PSViewTypeLogic pSViewTypeLogic2 = (PSViewTypeLogic)this.getDEModel().createEntity();
            pSViewTypeLogic2.setPSViewTypeLogicId(pSViewTypeLogic.getPSViewTypeLogicId());
            pSViewTypeLogic2.setPSViewTypeId(null);
            this.update(pSViewTypeLogic2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewTypeLogicServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSViewTypeLogicServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSViewTypeLogicServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSViewTypeLogic> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSViewTypeLogic pSViewTypeLogic : arrayList) {
            this.remove(pSViewTypeLogic);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSViewTypeLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSViewTypeLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewTypeLogic pSViewTypeLogic) throws Exception {
        super.onBeforeRemove(pSViewTypeLogic);
    }

    protected void replaceParentInfo(PSViewTypeLogic pSViewTypeLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSViewTypeLogic, cloneSession);
        if (pSViewTypeLogic.getPSViewLogicTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWLOGICTYPE", (Object)pSViewTypeLogic.getPSViewLogicTypeId())) != null) {
            this.onFillParentInfo_PSViewLogicType(pSViewTypeLogic, (PSViewLogicType)iEntity);
        }
        if (pSViewTypeLogic.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSViewTypeLogic.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSViewTypeLogic, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSViewTypeLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSViewTypeLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeId(bl, pSViewTypeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSViewTypeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeLogicId(bl, pSViewTypeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeLogicName(bl, pSViewTypeLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSViewTypeLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeLogic.isMemoDirty() : !pSViewTypeLogic.isMemoDirty()) {
            return null;
        }
        String string = pSViewTypeLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSViewTypeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewLogicTypeId(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeLogic.isPSViewLogicTypeIdDirty() && !bl2 : !pSViewTypeLogic.isPSViewLogicTypeIdDirty()) {
            return null;
        }
        String string = pSViewTypeLogic.getPSViewLogicTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeId_Default(pSViewTypeLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeLogic.isPSViewTypeIdDirty() && !bl2 : !pSViewTypeLogic.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSViewTypeLogic.getPSViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSViewTypeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeLogicId(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeLogic.isPSViewTypeLogicIdDirty() && !bl2 : !pSViewTypeLogic.isPSViewTypeLogicIdDirty()) {
            return null;
        }
        String string = pSViewTypeLogic.getPSViewTypeLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPELOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeLogicId_Default(pSViewTypeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeLogicName(boolean bl, PSViewTypeLogic pSViewTypeLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewTypeLogic.isPSViewTypeLogicNameDirty() : !pSViewTypeLogic.isPSViewTypeLogicNameDirty()) {
            return null;
        }
        String string = pSViewTypeLogic.getPSViewTypeLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeLogicName_Default(pSViewTypeLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPELOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSViewTypeLogic, bl);
    }

    protected void onSyncIndexEntities(PSViewTypeLogic pSViewTypeLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSViewTypeLogic, bl);
    }

    public Object getDataContextValue(PSViewTypeLogic pSViewTypeLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSViewTypeLogic, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSViewTypeLogic pSViewTypeLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSViewTypeLogic, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSViewTypeLogic pSViewTypeLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSViewTypeLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewTypeLogic pSViewTypeLogic) throws Exception {
        super.onUpdateParent(pSViewTypeLogic);
    }

    @Override
    protected void exportCurXmlModel(PSViewTypeLogic pSViewTypeLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWTYPELOGIC");
        if (!bl) {
            pSViewTypeLogic.setCreateDate(null);
            pSViewTypeLogic.setCreateMan(null);
            pSViewTypeLogic.setPSViewTypeLogicId(null);
            pSViewTypeLogic.setUpdateDate(null);
            pSViewTypeLogic.setUpdateMan(null);
            super.exportCurXmlModel(pSViewTypeLogic, xmlNode, bl);
        }
    }
}

