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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.config.dao.PSCtrlTypeActionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeActionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlAction;
import net.ibizsys.pscore.srv.config.entity.PSCtrlActionBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeAction;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeActionServiceBase
extends PSCoreSysServiceBase<PSCtrlTypeAction> {
    private static final Log log = LogFactory.getLog(PSCtrlTypeActionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlTypeActionDEModel pSCtrlTypeActionDEModel;
    private PSCtrlTypeActionDAO pSCtrlTypeActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCtrlTypeActionService";
    }

    public PSCtrlTypeActionDEModel getPSCtrlTypeActionDEModel() {
        if (this.pSCtrlTypeActionDEModel == null) {
            try {
                this.pSCtrlTypeActionDEModel = (PSCtrlTypeActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlTypeActionDEModel();
    }

    public PSCtrlTypeActionDAO getPSCtrlTypeActionDAO() {
        if (this.pSCtrlTypeActionDAO == null) {
            try {
                this.pSCtrlTypeActionDAO = (PSCtrlTypeActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCtrlTypeActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlTypeActionDAO();
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

    protected void onFillParentInfo(PSCtrlTypeAction pSCtrlTypeAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEACTION_PSCTRLACTION_PSCTRLACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlActionService", (SessionFactory)this.getSessionFactory());
            PSCtrlAction pSCtrlAction = (PSCtrlAction)iService.getDEModel().createEntity();
            pSCtrlAction.set("PSCTRLACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlAction);
            } else {
                iService.get(pSCtrlAction);
            }
            this.onFillParentInfo_PSCtrlAction(pSCtrlTypeAction, pSCtrlAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEACTION_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeAction, pSCtrlType);
            return;
        }
        super.onFillParentInfo(pSCtrlTypeAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlAction(PSCtrlTypeAction pSCtrlTypeAction, PSCtrlAction pSCtrlAction) throws Exception {
        pSCtrlTypeAction.setPSCtrlActionId(pSCtrlAction.getPSCtrlActionId());
        pSCtrlTypeAction.setPSCtrlActionName(pSCtrlAction.getPSCtrlActionName());
    }

    protected void onFillParentInfo_PSCtrlType(PSCtrlTypeAction pSCtrlTypeAction, PSCtrlType pSCtrlType) throws Exception {
        pSCtrlTypeAction.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSCtrlTypeAction.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected void onFillEntityFullInfo(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
        if (bl && pSCtrlTypeAction.getValidFlag() == null) {
            pSCtrlTypeAction.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSCtrlTypeAction, bl);
        this.onFillEntityFullInfo_PSCtrlAction(pSCtrlTypeAction, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSCtrlTypeAction, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlAction(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlTypeAction, bl);
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlAction(PSCtrlActionBase pSCtrlActionBase) throws Exception {
        return this.selectByPSCtrlAction(pSCtrlActionBase, "", -1);
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlAction(PSCtrlActionBase pSCtrlActionBase, String string) throws Exception {
        return this.selectByPSCtrlAction(pSCtrlActionBase, string, -1);
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlAction(PSCtrlActionBase pSCtrlActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLACTIONID", (Object)pSCtrlActionBase.getPSCtrlActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSCtrlTypeAction> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLTYPEID", (Object)pSCtrlTypeBase.getPSCtrlTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
        ArrayList<PSCtrlTypeAction> arrayList = this.selectByPSCtrlAction(pSCtrlAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLTYPEACTION_PSCTRLACTION_PSCTRLACTIONID", "", iDataEntityModel.getName(), "PSCTRLTYPEACTION", iDataEntityModel.getDataInfo(pSCtrlAction), arrayList.get(0)));
        }
    }

    public void resetPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
        ArrayList<PSCtrlTypeAction> arrayList = this.selectByPSCtrlAction(pSCtrlAction);
        for (PSCtrlTypeAction pSCtrlTypeAction : arrayList) {
            PSCtrlTypeAction pSCtrlTypeAction2 = (PSCtrlTypeAction)this.getDEModel().createEntity();
            pSCtrlTypeAction2.setPSCtrlTypeActionId(pSCtrlTypeAction.getPSCtrlTypeActionId());
            pSCtrlTypeAction2.setPSCtrlActionId(null);
            this.update(pSCtrlTypeAction2);
        }
    }

    public void removeByPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
        final PSCtrlAction pSCtrlAction2 = pSCtrlAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeActionServiceBase.this.onBeforeRemoveByPSCtrlAction(pSCtrlAction2);
                PSCtrlTypeActionServiceBase.this.internalRemoveByPSCtrlAction(pSCtrlAction2);
                PSCtrlTypeActionServiceBase.this.onAfterRemoveByPSCtrlAction(pSCtrlAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
    }

    protected void internalRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
        ArrayList<PSCtrlTypeAction> arrayList = this.selectByPSCtrlAction(pSCtrlAction);
        this.onBeforeRemoveByPSCtrlAction(pSCtrlAction, arrayList);
        for (PSCtrlTypeAction pSCtrlTypeAction : arrayList) {
            this.remove(pSCtrlTypeAction);
        }
        this.onAfterRemoveByPSCtrlAction(pSCtrlAction, arrayList);
    }

    protected void onAfterRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction, ArrayList<PSCtrlTypeAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlAction(PSCtrlAction pSCtrlAction, ArrayList<PSCtrlTypeAction> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeAction> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSCtrlTypeAction pSCtrlTypeAction : arrayList) {
            PSCtrlTypeAction pSCtrlTypeAction2 = (PSCtrlTypeAction)this.getDEModel().createEntity();
            pSCtrlTypeAction2.setPSCtrlTypeActionId(pSCtrlTypeAction.getPSCtrlTypeActionId());
            pSCtrlTypeAction2.setPSCtrlTypeId(null);
            this.update(pSCtrlTypeAction2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeActionServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeActionServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeActionServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeAction> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSCtrlTypeAction pSCtrlTypeAction : arrayList) {
            this.remove(pSCtrlTypeAction);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlTypeAction pSCtrlTypeAction) throws Exception {
        super.onBeforeRemove(pSCtrlTypeAction);
    }

    protected void replaceParentInfo(PSCtrlTypeAction pSCtrlTypeAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlTypeAction, cloneSession);
        if (pSCtrlTypeAction.getPSCtrlActionId() != null && (iEntity = cloneSession.getEntity("PSCTRLACTION", (Object)pSCtrlTypeAction.getPSCtrlActionId())) != null) {
            this.onFillParentInfo_PSCtrlAction(pSCtrlTypeAction, (PSCtrlAction)iEntity);
        }
        if (pSCtrlTypeAction.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSCtrlTypeAction.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeAction, (PSCtrlType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlTypeAction, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSCtrlTypeAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlActionId(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeActionId(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeActionName(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R7DExample(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCtrlTypeAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlTypeAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isMemoDirty() : !pSCtrlTypeAction.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlTypeAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isOrderValueDirty() : !pSCtrlTypeAction.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeAction.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSCtrlTypeAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlActionId(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isPSCtrlActionIdDirty() : !pSCtrlTypeAction.isPSCtrlActionIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getPSCtrlActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlActionId_Default(pSCtrlTypeAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeActionId(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isPSCtrlTypeActionIdDirty() && !bl2 : !pSCtrlTypeAction.isPSCtrlTypeActionIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getPSCtrlTypeActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeActionId_Default(pSCtrlTypeAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeActionName(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isPSCtrlTypeActionNameDirty() && !bl2 : !pSCtrlTypeAction.isPSCtrlTypeActionNameDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getPSCtrlTypeActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeActionName_Default(pSCtrlTypeAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isPSCtrlTypeIdDirty() : !pSCtrlTypeAction.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getPSCtrlTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSCtrlTypeAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R7DExample(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isR7DExampleDirty() : !pSCtrlTypeAction.isR7DExampleDirty()) {
            return null;
        }
        String string = pSCtrlTypeAction.getR7DExample();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_R7DExample_Default(pSCtrlTypeAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R7DEXAMPLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCtrlTypeAction pSCtrlTypeAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeAction.isValidFlagDirty() && !bl2 : !pSCtrlTypeAction.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeAction.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCtrlTypeAction, bl2, bl3);
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

    protected void onSyncEntity(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlTypeAction, bl);
    }

    protected void onSyncIndexEntities(PSCtrlTypeAction pSCtrlTypeAction, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlTypeAction, bl);
    }

    public Object getDataContextValue(PSCtrlTypeAction pSCtrlTypeAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlTypeAction, string, iDataContextParam)) != null) {
            return object;
        }
        PSCtrlAction pSCtrlAction = pSCtrlTypeAction.getPSCtrlAction();
        if (pSCtrlAction != null && pSCtrlAction.contains(string)) {
            return pSCtrlAction.get(string);
        }
        PSCtrlType pSCtrlType = pSCtrlTypeAction.getPSCtrlType();
        if (pSCtrlType != null && pSCtrlType.contains(string)) {
            return pSCtrlType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlTypeAction pSCtrlTypeAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlTypeAction, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"R7DEXAMPLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_R7DExample_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCtrlActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_R7DExample_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R7DEXAMPLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCtrlTypeAction pSCtrlTypeAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlTypeAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlTypeAction pSCtrlTypeAction) throws Exception {
        super.onUpdateParent(pSCtrlTypeAction);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlTypeAction pSCtrlTypeAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLTYPEACTION");
        if (!bl) {
            pSCtrlTypeAction.setCreateDate(null);
            pSCtrlTypeAction.setCreateMan(null);
            pSCtrlTypeAction.setPSCtrlTypeActionId(null);
            pSCtrlTypeAction.setUpdateDate(null);
            pSCtrlTypeAction.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlTypeAction, xmlNode, bl);
        }
    }
}

