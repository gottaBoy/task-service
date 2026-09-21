/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSystemMQDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemMQDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemMQ;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSystemMQServiceBase
extends PSCoreSysServiceBase<PSSystemMQ> {
    private static final Log log = LogFactory.getLog(PSSystemMQServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSystemMQDEModel pSSystemMQDEModel;
    private PSSystemMQDAO pSSystemMQDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSystemMQService";
    }

    public PSSystemMQDEModel getPSSystemMQDEModel() {
        if (this.pSSystemMQDEModel == null) {
            try {
                this.pSSystemMQDEModel = (PSSystemMQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemMQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemMQDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSystemMQDEModel();
    }

    public PSSystemMQDAO getPSSystemMQDAO() {
        if (this.pSSystemMQDAO == null) {
            try {
                this.pSSystemMQDAO = (PSSystemMQDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSystemMQDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemMQDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSystemMQDAO();
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

    protected void onFillParentInfo(PSSystemMQ pSSystemMQ, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMMQ_PSDEVCENTERMQ_PSDEVCENTERMQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService", (SessionFactory)this.getSessionFactory());
            PSDevCenterMQ pSDevCenterMQ = (PSDevCenterMQ)iService.getDEModel().createEntity();
            pSDevCenterMQ.set("PSDEVCENTERMQID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterMQ);
            } else {
                iService.get((IEntity)pSDevCenterMQ);
            }
            this.onFillParentInfo_PSDevCenterMQ(pSSystemMQ, pSDevCenterMQ);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTEMMQ_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSystemMQ, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSystemMQ, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterMQ(PSSystemMQ pSSystemMQ, PSDevCenterMQ pSDevCenterMQ) throws Exception {
        pSSystemMQ.setPSDevCenterMQId(pSDevCenterMQ.getPSDevCenterMQId());
        pSSystemMQ.setPSDevCenterMQName(pSDevCenterMQ.getPSDevCenterMQName());
    }

    protected void onFillParentInfo_PSSystem(PSSystemMQ pSSystemMQ, PSSystem pSSystem) throws Exception {
        pSSystemMQ.setPSSystemId(pSSystem.getPSSystemId());
        pSSystemMQ.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSystemMQ, bl);
        this.onFillEntityFullInfo_PSDevCenterMQ(pSSystemMQ, bl);
        this.onFillEntityFullInfo_PSSystem(pSSystemMQ, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterMQ(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        if (pSSystemMQ.isPSSystemIdDirty()) {
            if (pSSystemMQ.getPSSystemId() != null) {
                if (pSSystemMQ.getPSSystemId() == null || pSSystemMQ.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSystemMQ.getPSSystem();
                    pSSystemMQ.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSystemMQ.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSystemMQ, bl);
    }

    public ArrayList<PSSystemMQ> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase) throws Exception {
        return this.selectByPSDevCenterMQ(pSDevCenterMQBase, "", -1);
    }

    public ArrayList<PSSystemMQ> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase, String string) throws Exception {
        return this.selectByPSDevCenterMQ(pSDevCenterMQBase, string, -1);
    }

    public ArrayList<PSSystemMQ> selectByPSDevCenterMQ(PSDevCenterMQBase pSDevCenterMQBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERMQID", (Object)pSDevCenterMQBase.getPSDevCenterMQId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterMQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterMQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSystemMQ> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSystemMQ> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSystemMQ> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSSystemMQ> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERMQ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterMQ);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTEMMQ_PSDEVCENTERMQ_PSDEVCENTERMQID", "", iDataEntityModel.getName(), "PSSYSTEMMQ", iDataEntityModel.getDataInfo((IEntity)pSDevCenterMQ), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSSystemMQ> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ);
        for (PSSystemMQ pSSystemMQ : arrayList) {
            PSSystemMQ pSSystemMQ2 = (PSSystemMQ)this.getDEModel().createEntity();
            pSSystemMQ2.setPSSystemMQId(pSSystemMQ.getPSSystemMQId());
            pSSystemMQ2.setPSDevCenterMQId(null);
            this.update(pSSystemMQ2);
        }
    }

    public void removeByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        final PSDevCenterMQ pSDevCenterMQ2 = pSDevCenterMQ;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemMQServiceBase.this.onBeforeRemoveByPSDevCenterMQ(pSDevCenterMQ2);
                PSSystemMQServiceBase.this.internalRemoveByPSDevCenterMQ(pSDevCenterMQ2);
                PSSystemMQServiceBase.this.onAfterRemoveByPSDevCenterMQ(pSDevCenterMQ2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
    }

    protected void internalRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
        ArrayList<PSSystemMQ> arrayList = this.selectByPSDevCenterMQ(pSDevCenterMQ);
        this.onBeforeRemoveByPSDevCenterMQ(pSDevCenterMQ, arrayList);
        for (PSSystemMQ pSSystemMQ : arrayList) {
            this.remove((IEntity)pSSystemMQ);
        }
        this.onAfterRemoveByPSDevCenterMQ(pSDevCenterMQ, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ, ArrayList<PSSystemMQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterMQ(PSDevCenterMQ pSDevCenterMQ, ArrayList<PSSystemMQ> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemMQ> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSystemMQ pSSystemMQ : arrayList) {
            PSSystemMQ pSSystemMQ2 = (PSSystemMQ)this.getDEModel().createEntity();
            pSSystemMQ2.setPSSystemMQId(pSSystemMQ.getPSSystemMQId());
            pSSystemMQ2.setPSSystemId(null);
            this.update(pSSystemMQ2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSystemMQServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSystemMQServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSystemMQServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSystemMQ> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSystemMQ pSSystemMQ : arrayList) {
            this.remove((IEntity)pSSystemMQ);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemMQ> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSystemMQ> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSystemMQ pSSystemMQ) throws Exception {
        super.onBeforeRemove(pSSystemMQ);
    }

    protected void replaceParentInfo(PSSystemMQ pSSystemMQ, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSystemMQ, cloneSession);
        if (pSSystemMQ.getPSDevCenterMQId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERMQ", (Object)pSSystemMQ.getPSDevCenterMQId())) != null) {
            this.onFillParentInfo_PSDevCenterMQ(pSSystemMQ, (PSDevCenterMQ)iEntity);
        }
        if (pSSystemMQ.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSystemMQ.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSystemMQ, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSystemMQ, bl);
    }

    protected void onCheckEntity(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSystemMQ, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MQId(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterMQId(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemMQId(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemMQName(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResInfo(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSSystemMQ, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSystemMQ, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isMemoDirty() : !pSSystemMQ.isMemoDirty()) {
            return null;
        }
        String string = pSSystemMQ.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSystemMQ, bl2, bl3);
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

    protected EntityFieldError onCheckField_MQId(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isMQIdDirty() && !bl2 : !pSSystemMQ.isMQIdDirty()) {
            return null;
        }
        String string = pSSystemMQ.getMQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MQId_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterMQId(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isPSDevCenterMQIdDirty() : !pSSystemMQ.isPSDevCenterMQIdDirty()) {
            return null;
        }
        String string = pSSystemMQ.getPSDevCenterMQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterMQId_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERMQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isPSSystemIdDirty() : !pSSystemMQ.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSystemMQ.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemMQId(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isPSSystemMQIdDirty() && !bl2 : !pSSystemMQ.isPSSystemMQIdDirty()) {
            return null;
        }
        String string = pSSystemMQ.getPSSystemMQId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMMQID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemMQId_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMMQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemMQName(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isPSSystemMQNameDirty() && !bl2 : !pSSystemMQ.isPSSystemMQNameDirty()) {
            return null;
        }
        String string = pSSystemMQ.getPSSystemMQName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMMQNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemMQName_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMMQNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isPSSystemNameDirty() : !pSSystemMQ.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSystemMQ.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResInfo(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isResInfoDirty() : !pSSystemMQ.isResInfoDirty()) {
            return null;
        }
        String string = pSSystemMQ.getResInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResInfo_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isResReadyTimeDirty() : !pSSystemMQ.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSystemMQ.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResState(boolean bl, PSSystemMQ pSSystemMQ, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSystemMQ.isResStateDirty() : !pSSystemMQ.isResStateDirty()) {
            return null;
        }
        Integer n = pSSystemMQ.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default((IEntity)pSSystemMQ, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSystemMQ, bl);
    }

    protected void onSyncIndexEntities(PSSystemMQ pSSystemMQ, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSystemMQ, bl);
    }

    public Object getDataContextValue(PSSystemMQ pSSystemMQ, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSystemMQ, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSystemMQ pSSystemMQ, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSystemMQ, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERMQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterMQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERMQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterMQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMMQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemMQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMMQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemMQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MQID", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterMQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERMQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterMQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERMQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemMQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMMQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemMQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMMQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSSystemMQ pSSystemMQ) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSystemMQ)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSystemMQ pSSystemMQ) throws Exception {
        super.onUpdateParent((IEntity)pSSystemMQ);
    }

    @Override
    protected void exportCurXmlModel(PSSystemMQ pSSystemMQ, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTEMMQ");
        if (!bl) {
            pSSystemMQ.setMQId(null);
            pSSystemMQ.setPSDevCenterMQName(null);
            super.exportCurXmlModel(pSSystemMQ, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSystemMQ pSSystemMQ, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSystemMQ, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTEMMQ_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSystemMQ pSSystemMQ) {
        return super.getModelV2Tag(pSSystemMQ);
    }

    @Override
    public boolean setModelV2Tag(PSSystemMQ pSSystemMQ, String string) {
        return super.setModelV2Tag(pSSystemMQ, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSystemMQ pSSystemMQ, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSystemMQ.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSystemMQ, true);
        return super.getModelV2Entity(pSSystemMQ, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSystemMQ pSSystemMQ, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSystemMQ, objectNode, string, string2, n);
    }
}

