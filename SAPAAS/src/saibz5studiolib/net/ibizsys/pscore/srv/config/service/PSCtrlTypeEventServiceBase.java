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
import net.ibizsys.pscore.srv.config.dao.PSCtrlTypeEventDAO;
import net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeEventDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlEvent;
import net.ibizsys.pscore.srv.config.entity.PSCtrlEventBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeEvent;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeEventServiceBase
extends PSCoreSysServiceBase<PSCtrlTypeEvent> {
    private static final Log log = LogFactory.getLog(PSCtrlTypeEventServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlTypeEventDEModel pSCtrlTypeEventDEModel;
    private PSCtrlTypeEventDAO pSCtrlTypeEventDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSCtrlTypeEventService";
    }

    public PSCtrlTypeEventDEModel getPSCtrlTypeEventDEModel() {
        if (this.pSCtrlTypeEventDEModel == null) {
            try {
                this.pSCtrlTypeEventDEModel = (PSCtrlTypeEventDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCtrlTypeEventDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeEventDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlTypeEventDEModel();
    }

    public PSCtrlTypeEventDAO getPSCtrlTypeEventDAO() {
        if (this.pSCtrlTypeEventDAO == null) {
            try {
                this.pSCtrlTypeEventDAO = (PSCtrlTypeEventDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSCtrlTypeEventDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlTypeEventDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlTypeEventDAO();
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

    protected void onFillParentInfo(PSCtrlTypeEvent pSCtrlTypeEvent, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEEVENT_PSCTRLEVENT_PSCTRLEVENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlEventService", (SessionFactory)this.getSessionFactory());
            PSCtrlEvent pSCtrlEvent = (PSCtrlEvent)iService.getDEModel().createEntity();
            pSCtrlEvent.set("PSCTRLEVENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlEvent);
            } else {
                iService.get(pSCtrlEvent);
            }
            this.onFillParentInfo_PSCtrlEvent(pSCtrlTypeEvent, pSCtrlEvent);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLTYPEEVENT_PSCTRLTYPE_PSCTRLTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory());
            PSCtrlType pSCtrlType = (PSCtrlType)iService.getDEModel().createEntity();
            pSCtrlType.set("PSCTRLTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlType);
            } else {
                iService.get(pSCtrlType);
            }
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeEvent, pSCtrlType);
            return;
        }
        super.onFillParentInfo(pSCtrlTypeEvent, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlEvent(PSCtrlTypeEvent pSCtrlTypeEvent, PSCtrlEvent pSCtrlEvent) throws Exception {
        pSCtrlTypeEvent.setPSCtrlEventId(pSCtrlEvent.getPSCtrlEventId());
        pSCtrlTypeEvent.setPSCtrlEventName(pSCtrlEvent.getPSCtrlEventName());
    }

    protected void onFillParentInfo_PSCtrlType(PSCtrlTypeEvent pSCtrlTypeEvent, PSCtrlType pSCtrlType) throws Exception {
        pSCtrlTypeEvent.setPSCtrlTypeId(pSCtrlType.getPSCtrlTypeId());
        pSCtrlTypeEvent.setPSCtrlTypeName(pSCtrlType.getPSCtrlTypeName());
    }

    protected void onFillEntityFullInfo(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
        if (bl && pSCtrlTypeEvent.getValidFlag() == null) {
            pSCtrlTypeEvent.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSCtrlTypeEvent, bl);
        this.onFillEntityFullInfo_PSCtrlEvent(pSCtrlTypeEvent, bl);
        this.onFillEntityFullInfo_PSCtrlType(pSCtrlTypeEvent, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlEvent(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlType(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlTypeEvent, bl);
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlEvent(PSCtrlEventBase pSCtrlEventBase) throws Exception {
        return this.selectByPSCtrlEvent(pSCtrlEventBase, "", -1);
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlEvent(PSCtrlEventBase pSCtrlEventBase, String string) throws Exception {
        return this.selectByPSCtrlEvent(pSCtrlEventBase, string, -1);
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlEvent(PSCtrlEventBase pSCtrlEventBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLEVENTID", (Object)pSCtrlEventBase.getPSCtrlEventId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlEventCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlEventCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, "", -1);
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string) throws Exception {
        return this.selectByPSCtrlType(pSCtrlTypeBase, string, -1);
    }

    public ArrayList<PSCtrlTypeEvent> selectByPSCtrlType(PSCtrlTypeBase pSCtrlTypeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
        ArrayList<PSCtrlTypeEvent> arrayList = this.selectByPSCtrlEvent(pSCtrlEvent, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLEVENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlEvent);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLTYPEEVENT_PSCTRLEVENT_PSCTRLEVENTID", "", iDataEntityModel.getName(), "PSCTRLTYPEEVENT", iDataEntityModel.getDataInfo(pSCtrlEvent), arrayList.get(0)));
        }
    }

    public void resetPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
        ArrayList<PSCtrlTypeEvent> arrayList = this.selectByPSCtrlEvent(pSCtrlEvent);
        for (PSCtrlTypeEvent pSCtrlTypeEvent : arrayList) {
            PSCtrlTypeEvent pSCtrlTypeEvent2 = (PSCtrlTypeEvent)this.getDEModel().createEntity();
            pSCtrlTypeEvent2.setPSCtrlTypeEventId(pSCtrlTypeEvent.getPSCtrlTypeEventId());
            pSCtrlTypeEvent2.setPSCtrlEventId(null);
            this.update(pSCtrlTypeEvent2);
        }
    }

    public void removeByPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
        final PSCtrlEvent pSCtrlEvent2 = pSCtrlEvent;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeEventServiceBase.this.onBeforeRemoveByPSCtrlEvent(pSCtrlEvent2);
                PSCtrlTypeEventServiceBase.this.internalRemoveByPSCtrlEvent(pSCtrlEvent2);
                PSCtrlTypeEventServiceBase.this.onAfterRemoveByPSCtrlEvent(pSCtrlEvent2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
    }

    protected void internalRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
        ArrayList<PSCtrlTypeEvent> arrayList = this.selectByPSCtrlEvent(pSCtrlEvent);
        this.onBeforeRemoveByPSCtrlEvent(pSCtrlEvent, arrayList);
        for (PSCtrlTypeEvent pSCtrlTypeEvent : arrayList) {
            this.remove(pSCtrlTypeEvent);
        }
        this.onAfterRemoveByPSCtrlEvent(pSCtrlEvent, arrayList);
    }

    protected void onAfterRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent, ArrayList<PSCtrlTypeEvent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlEvent(PSCtrlEvent pSCtrlEvent, ArrayList<PSCtrlTypeEvent> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    public void resetPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeEvent> arrayList = this.selectByPSCtrlType(pSCtrlType);
        for (PSCtrlTypeEvent pSCtrlTypeEvent : arrayList) {
            PSCtrlTypeEvent pSCtrlTypeEvent2 = (PSCtrlTypeEvent)this.getDEModel().createEntity();
            pSCtrlTypeEvent2.setPSCtrlTypeEventId(pSCtrlTypeEvent.getPSCtrlTypeEventId());
            pSCtrlTypeEvent2.setPSCtrlTypeId(null);
            this.update(pSCtrlTypeEvent2);
        }
    }

    public void removeByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        final PSCtrlType pSCtrlType2 = pSCtrlType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlTypeEventServiceBase.this.onBeforeRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeEventServiceBase.this.internalRemoveByPSCtrlType(pSCtrlType2);
                PSCtrlTypeEventServiceBase.this.onAfterRemoveByPSCtrlType(pSCtrlType2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void internalRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
        ArrayList<PSCtrlTypeEvent> arrayList = this.selectByPSCtrlType(pSCtrlType);
        this.onBeforeRemoveByPSCtrlType(pSCtrlType, arrayList);
        for (PSCtrlTypeEvent pSCtrlTypeEvent : arrayList) {
            this.remove(pSCtrlTypeEvent);
        }
        this.onAfterRemoveByPSCtrlType(pSCtrlType, arrayList);
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeEvent> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlType(PSCtrlType pSCtrlType, ArrayList<PSCtrlTypeEvent> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlTypeEvent pSCtrlTypeEvent) throws Exception {
        super.onBeforeRemove(pSCtrlTypeEvent);
    }

    protected void replaceParentInfo(PSCtrlTypeEvent pSCtrlTypeEvent, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlTypeEvent, cloneSession);
        if (pSCtrlTypeEvent.getPSCtrlEventId() != null && (iEntity = cloneSession.getEntity("PSCTRLEVENT", (Object)pSCtrlTypeEvent.getPSCtrlEventId())) != null) {
            this.onFillParentInfo_PSCtrlEvent(pSCtrlTypeEvent, (PSCtrlEvent)iEntity);
        }
        if (pSCtrlTypeEvent.getPSCtrlTypeId() != null && (iEntity = cloneSession.getEntity("PSCTRLTYPE", (Object)pSCtrlTypeEvent.getPSCtrlTypeId())) != null) {
            this.onFillParentInfo_PSCtrlType(pSCtrlTypeEvent, (PSCtrlType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlTypeEvent, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSCtrlTypeEvent, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlEventId(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeEventId(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeEventName(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlTypeId(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R7DExample(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCtrlTypeEvent, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlTypeEvent, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isMemoDirty() : !pSCtrlTypeEvent.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlTypeEvent, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isOrderValueDirty() : !pSCtrlTypeEvent.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeEvent.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSCtrlTypeEvent, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlEventId(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isPSCtrlEventIdDirty() : !pSCtrlTypeEvent.isPSCtrlEventIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getPSCtrlEventId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlEventId_Default(pSCtrlTypeEvent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLEVENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeEventId(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isPSCtrlTypeEventIdDirty() && !bl2 : !pSCtrlTypeEvent.isPSCtrlTypeEventIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getPSCtrlTypeEventId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEEVENTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeEventId_Default(pSCtrlTypeEvent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEEVENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeEventName(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isPSCtrlTypeEventNameDirty() && !bl2 : !pSCtrlTypeEvent.isPSCtrlTypeEventNameDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getPSCtrlTypeEventName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEEVENTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeEventName_Default(pSCtrlTypeEvent, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLTYPEEVENTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlTypeId(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isPSCtrlTypeIdDirty() : !pSCtrlTypeEvent.isPSCtrlTypeIdDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getPSCtrlTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlTypeId_Default(pSCtrlTypeEvent, bl2, bl3);
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

    protected EntityFieldError onCheckField_R7DExample(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isR7DExampleDirty() : !pSCtrlTypeEvent.isR7DExampleDirty()) {
            return null;
        }
        String string = pSCtrlTypeEvent.getR7DExample();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_R7DExample_Default(pSCtrlTypeEvent, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlTypeEvent.isValidFlagDirty() && !bl2 : !pSCtrlTypeEvent.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCtrlTypeEvent.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCtrlTypeEvent, bl2, bl3);
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

    protected void onSyncEntity(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlTypeEvent, bl);
    }

    protected void onSyncIndexEntities(PSCtrlTypeEvent pSCtrlTypeEvent, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlTypeEvent, bl);
    }

    public Object getDataContextValue(PSCtrlTypeEvent pSCtrlTypeEvent, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlTypeEvent, string, iDataContextParam)) != null) {
            return object;
        }
        PSCtrlEvent pSCtrlEvent = pSCtrlTypeEvent.getPSCtrlEvent();
        if (pSCtrlEvent != null && pSCtrlEvent.contains(string)) {
            return pSCtrlEvent.get(string);
        }
        PSCtrlType pSCtrlType = pSCtrlTypeEvent.getPSCtrlType();
        if (pSCtrlType != null && pSCtrlType.contains(string)) {
            return pSCtrlType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlTypeEvent pSCtrlTypeEvent, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlTypeEvent, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSCTRLEVENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlEventId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLEVENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlEventName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEEVENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeEventId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLTYPEEVENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlTypeEventName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSCtrlEventId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLEVENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlEventName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLEVENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeEventId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEEVENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlTypeEventName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLTYPEEVENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSCtrlTypeEvent pSCtrlTypeEvent) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlTypeEvent)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlTypeEvent pSCtrlTypeEvent) throws Exception {
        super.onUpdateParent(pSCtrlTypeEvent);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlTypeEvent pSCtrlTypeEvent, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLTYPEEVENT");
        if (!bl) {
            pSCtrlTypeEvent.setCreateDate(null);
            pSCtrlTypeEvent.setCreateMan(null);
            pSCtrlTypeEvent.setPSCtrlTypeEventId(null);
            pSCtrlTypeEvent.setUpdateDate(null);
            pSCtrlTypeEvent.setUpdateMan(null);
            super.exportCurXmlModel(pSCtrlTypeEvent, xmlNode, bl);
        }
    }
}

