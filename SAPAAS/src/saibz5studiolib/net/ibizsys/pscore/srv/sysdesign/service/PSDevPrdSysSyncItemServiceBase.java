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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysSyncItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysSyncItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSync;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSyncBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSyncItem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysSyncItemServiceBase
extends PSCoreSysServiceBase<PSDevPrdSysSyncItem> {
    private static final Log log = LogFactory.getLog(PSDevPrdSysSyncItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevPrdSysSyncItemDEModel pSDevPrdSysSyncItemDEModel;
    private PSDevPrdSysSyncItemDAO pSDevPrdSysSyncItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncItemService";
    }

    public PSDevPrdSysSyncItemDEModel getPSDevPrdSysSyncItemDEModel() {
        if (this.pSDevPrdSysSyncItemDEModel == null) {
            try {
                this.pSDevPrdSysSyncItemDEModel = (PSDevPrdSysSyncItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysSyncItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysSyncItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSysSyncItemDEModel();
    }

    public PSDevPrdSysSyncItemDAO getPSDevPrdSysSyncItemDAO() {
        if (this.pSDevPrdSysSyncItemDAO == null) {
            try {
                this.pSDevPrdSysSyncItemDAO = (PSDevPrdSysSyncItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysSyncItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysSyncItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSysSyncItemDAO();
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

    protected void onFillParentInfo(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYSSYNCITEM_PSDEVPRDSYSSYNC_PSDEVPRDSYSSYNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSysSync pSDevPrdSysSync = (PSDevPrdSysSync)iService.getDEModel().createEntity();
            pSDevPrdSysSync.set("PSDEVPRDSYSSYNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevPrdSysSync);
            } else {
                iService.get((IEntity)pSDevPrdSysSync);
            }
            this.onFillParentInfo_PSDevPrdSysSync(pSDevPrdSysSyncItem, pSDevPrdSysSync);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevPrdSysSyncItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdSysSync(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        pSDevPrdSysSyncItem.setPSDevPrdSysSyncId(pSDevPrdSysSync.getPSDevPrdSysSyncId());
        pSDevPrdSysSyncItem.setPSDevPrdSysSyncName(pSDevPrdSysSync.getPSDevPrdSysSyncName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevPrdSysSyncItem, bl);
        this.onFillEntityFullInfo_PSDevPrdSysSync(pSDevPrdSysSyncItem, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdSysSync(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        if (pSDevPrdSysSyncItem.isPSDevPrdSysSyncIdDirty()) {
            if (pSDevPrdSysSyncItem.getPSDevPrdSysSyncId() != null) {
                if (pSDevPrdSysSyncItem.getPSDevPrdSysSyncId() == null || pSDevPrdSysSyncItem.getPSDevPrdSysSyncName() == null) {
                    PSDevPrdSysSync pSDevPrdSysSync = pSDevPrdSysSyncItem.getPSDevPrdSysSync();
                    pSDevPrdSysSyncItem.setPSDevPrdSysSyncName(pSDevPrdSysSync.getPSDevPrdSysSyncName());
                }
            } else {
                pSDevPrdSysSyncItem.setPSDevPrdSysSyncName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevPrdSysSyncItem, bl);
    }

    public ArrayList<PSDevPrdSysSyncItem> selectByPSDevPrdSysSync(PSDevPrdSysSyncBase pSDevPrdSysSyncBase) throws Exception {
        return this.selectByPSDevPrdSysSync(pSDevPrdSysSyncBase, "", -1);
    }

    public ArrayList<PSDevPrdSysSyncItem> selectByPSDevPrdSysSync(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, String string) throws Exception {
        return this.selectByPSDevPrdSysSync(pSDevPrdSysSyncBase, string, -1);
    }

    public ArrayList<PSDevPrdSysSyncItem> selectByPSDevPrdSysSync(PSDevPrdSysSyncBase pSDevPrdSysSyncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDSYSSYNCID", (Object)pSDevPrdSysSyncBase.getPSDevPrdSysSyncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdSysSyncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdSysSyncCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
    }

    public void resetPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        ArrayList<PSDevPrdSysSyncItem> arrayList = this.selectByPSDevPrdSysSync(pSDevPrdSysSync);
        for (PSDevPrdSysSyncItem pSDevPrdSysSyncItem : arrayList) {
            PSDevPrdSysSyncItem pSDevPrdSysSyncItem2 = (PSDevPrdSysSyncItem)this.getDEModel().createEntity();
            pSDevPrdSysSyncItem2.setPSDevPrdSysSyncItemId(pSDevPrdSysSyncItem.getPSDevPrdSysSyncItemId());
            pSDevPrdSysSyncItem2.setPSDevPrdSysSyncId(null);
            this.update(pSDevPrdSysSyncItem2);
        }
    }

    public void removeByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        final PSDevPrdSysSync pSDevPrdSysSync2 = pSDevPrdSysSync;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysSyncItemServiceBase.this.onBeforeRemoveByPSDevPrdSysSync(pSDevPrdSysSync2);
                PSDevPrdSysSyncItemServiceBase.this.internalRemoveByPSDevPrdSysSync(pSDevPrdSysSync2);
                PSDevPrdSysSyncItemServiceBase.this.onAfterRemoveByPSDevPrdSysSync(pSDevPrdSysSync2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
        ArrayList<PSDevPrdSysSyncItem> arrayList = this.selectByPSDevPrdSysSync(pSDevPrdSysSync);
        this.onBeforeRemoveByPSDevPrdSysSync(pSDevPrdSysSync, arrayList);
        for (PSDevPrdSysSyncItem pSDevPrdSysSyncItem : arrayList) {
            this.remove((IEntity)pSDevPrdSysSyncItem);
        }
        this.onAfterRemoveByPSDevPrdSysSync(pSDevPrdSysSync, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync, ArrayList<PSDevPrdSysSyncItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSysSync(PSDevPrdSysSync pSDevPrdSysSync, ArrayList<PSDevPrdSysSyncItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSysSyncItem pSDevPrdSysSyncItem) throws Exception {
        super.onBeforeRemove(pSDevPrdSysSyncItem);
    }

    protected void replaceParentInfo(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevPrdSysSyncItem, cloneSession);
        if (pSDevPrdSysSyncItem.getPSDevPrdSysSyncId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSYSSYNC", (Object)pSDevPrdSysSyncItem.getPSDevPrdSysSyncId())) != null) {
            this.onFillParentInfo_PSDevPrdSysSync(pSDevPrdSysSyncItem, (PSDevPrdSysSync)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevPrdSysSyncItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_OrderValue(bl, pSDevPrdSysSyncItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncId(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncItemId(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncItemName(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysSyncName(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncAction(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam2(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam3(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam4(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam5(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncParam6(bl, pSDevPrdSysSyncItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevPrdSysSyncItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isOrderValueDirty() : !pSDevPrdSysSyncItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevPrdSysSyncItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdSysSyncId(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isPSDevPrdSysSyncIdDirty() && !bl2 : !pSDevPrdSysSyncItem.isPSDevPrdSysSyncIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getPSDevPrdSysSyncId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncId_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysSyncItemId(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isPSDevPrdSysSyncItemIdDirty() && !bl2 : !pSDevPrdSysSyncItem.isPSDevPrdSysSyncItemIdDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getPSDevPrdSysSyncItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncItemId_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysSyncItemName(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isPSDevPrdSysSyncItemNameDirty() && !bl2 : !pSDevPrdSysSyncItem.isPSDevPrdSysSyncItemNameDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getPSDevPrdSysSyncItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncItemName_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysSyncName(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isPSDevPrdSysSyncNameDirty() && !bl2 : !pSDevPrdSysSyncItem.isPSDevPrdSysSyncNameDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getPSDevPrdSysSyncName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysSyncName_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSSYNCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncAction(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncActionDirty() && !bl2 : !pSDevPrdSysSyncItem.isSyncActionDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getSyncAction();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCACTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncAction_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParamDirty() : !pSDevPrdSysSyncItem.isSyncParamDirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getSyncParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncParam_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam2(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParam2Dirty() : !pSDevPrdSysSyncItem.isSyncParam2Dirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getSyncParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncParam2_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam3(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParam3Dirty() : !pSDevPrdSysSyncItem.isSyncParam3Dirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getSyncParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncParam3_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam4(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParam4Dirty() : !pSDevPrdSysSyncItem.isSyncParam4Dirty()) {
            return null;
        }
        String string = pSDevPrdSysSyncItem.getSyncParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SyncParam4_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam5(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParam5Dirty() : !pSDevPrdSysSyncItem.isSyncParam5Dirty()) {
            return null;
        }
        Integer n = pSDevPrdSysSyncItem.getSyncParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncParam5_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncParam6(boolean bl, PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSysSyncItem.isSyncParam6Dirty() : !pSDevPrdSysSyncItem.isSyncParam6Dirty()) {
            return null;
        }
        Integer n = pSDevPrdSysSyncItem.getSyncParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncParam6_Default((IEntity)pSDevPrdSysSyncItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevPrdSysSyncItem, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevPrdSysSyncItem, bl);
    }

    public Object getDataContextValue(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevPrdSysSyncItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevPrdSysSync pSDevPrdSysSync = pSDevPrdSysSyncItem.getPSDevPrdSysSync();
        if (pSDevPrdSysSync != null && pSDevPrdSysSync.contains(string)) {
            return pSDevPrdSysSync.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevPrdSysSyncItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSSYNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysSyncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncParam6_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevPrdSysSyncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysSyncItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysSyncItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysSyncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSSYNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCACTION", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCPARAM3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYNCPARAM4", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SyncParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevPrdSysSyncItem pSDevPrdSysSyncItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevPrdSysSyncItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSysSyncItem pSDevPrdSysSyncItem) throws Exception {
        super.onUpdateParent((IEntity)pSDevPrdSysSyncItem);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSysSyncItem pSDevPrdSysSyncItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSYSSYNCITEM");
        if (!bl) {
            pSDevPrdSysSyncItem.setCreateDate(null);
            pSDevPrdSysSyncItem.setCreateMan(null);
            pSDevPrdSysSyncItem.setPSDevPrdSysSyncItemId(null);
            pSDevPrdSysSyncItem.setUpdateDate(null);
            pSDevPrdSysSyncItem.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSysSyncItem, xmlNode, bl);
        }
    }
}

