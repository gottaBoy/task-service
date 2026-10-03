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
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysPubLockDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysPubLockDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysPubLock;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysPubLockServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysPubLock> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysPubLockServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnSysPubLockDEModel pSDevSlnSysPubLockDEModel;
    private PSDevSlnSysPubLockDAO pSDevSlnSysPubLockDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysPubLockService";
    }

    public PSDevSlnSysPubLockDEModel getPSDevSlnSysPubLockDEModel() {
        if (this.pSDevSlnSysPubLockDEModel == null) {
            try {
                this.pSDevSlnSysPubLockDEModel = (PSDevSlnSysPubLockDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysPubLockDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysPubLockDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysPubLockDEModel();
    }

    public PSDevSlnSysPubLockDAO getPSDevSlnSysPubLockDAO() {
        if (this.pSDevSlnSysPubLockDAO == null) {
            try {
                this.pSDevSlnSysPubLockDAO = (PSDevSlnSysPubLockDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysPubLockDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysPubLockDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysPubLockDAO();
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

    protected void onFillParentInfo(PSDevSlnSysPubLock pSDevSlnSysPubLock, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSPUBLOCK_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysPubLock, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysPubLock, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDevSlnSysPubLock pSDevSlnSysPubLock, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysPubLock.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysPubLock.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        if (bl && pSDevSlnSysPubLock.getValidFlag() == null) {
            pSDevSlnSysPubLock.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDevSlnSysPubLock, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevSlnSysPubLock, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        if (pSDevSlnSysPubLock.isPSDevCenterIdDirty()) {
            if (pSDevSlnSysPubLock.getPSDevCenterId() != null) {
                if (pSDevSlnSysPubLock.getPSDevCenterId() == null || pSDevSlnSysPubLock.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysPubLock.getPSDevCenter();
                    pSDevSlnSysPubLock.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysPubLock.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysPubLock, bl);
    }

    public ArrayList<PSDevSlnSysPubLock> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysPubLock> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysPubLock> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysPubLock> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevSlnSysPubLock pSDevSlnSysPubLock : arrayList) {
            PSDevSlnSysPubLock pSDevSlnSysPubLock2 = (PSDevSlnSysPubLock)this.getDEModel().createEntity();
            pSDevSlnSysPubLock2.setPSDevSlnSysPubLockId(pSDevSlnSysPubLock.getPSDevSlnSysPubLockId());
            pSDevSlnSysPubLock2.setPSDevCenterId(null);
            this.update(pSDevSlnSysPubLock2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysPubLockServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysPubLockServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysPubLockServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysPubLock> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysPubLock pSDevSlnSysPubLock : arrayList) {
            this.remove(pSDevSlnSysPubLock);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysPubLock> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysPubLock> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysPubLock pSDevSlnSysPubLock) throws Exception {
        super.onBeforeRemove(pSDevSlnSysPubLock);
    }

    protected void replaceParentInfo(PSDevSlnSysPubLock pSDevSlnSysPubLock, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysPubLock, cloneSession);
        if (pSDevSlnSysPubLock.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysPubLock.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysPubLock, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysPubLock, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LockReason(bl, pSDevSlnSysPubLock, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysPubLockId(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysPubLockName(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnlockTime(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysPubLock, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysPubLock, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LockReason(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isLockReasonDirty() : !pSDevSlnSysPubLock.isLockReasonDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getLockReason();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LockReason_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKREASON");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isPSDevCenterIdDirty() : !pSDevSlnSysPubLock.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isPSDevCenterNameDirty() : !pSDevSlnSysPubLock.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysPubLockId(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isPSDevSlnSysPubLockIdDirty() && !bl2 : !pSDevSlnSysPubLock.isPSDevSlnSysPubLockIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getPSDevSlnSysPubLockId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPUBLOCKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysPubLockId_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPUBLOCKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysPubLockName(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isPSDevSlnSysPubLockNameDirty() && !bl2 : !pSDevSlnSysPubLock.isPSDevSlnSysPubLockNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getPSDevSlnSysPubLockName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPUBLOCKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysPubLockName_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSPUBLOCKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isTemplCodeDirty() : !pSDevSlnSysPubLock.isTemplCodeDirty()) {
            return null;
        }
        String string = pSDevSlnSysPubLock.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSDevSlnSysPubLock, bl2, bl3);
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

    protected EntityFieldError onCheckField_UnlockTime(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isUnlockTimeDirty() : !pSDevSlnSysPubLock.isUnlockTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysPubLock.getUnlockTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnlockTime_Default(pSDevSlnSysPubLock, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNLOCKTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysPubLock.isValidFlagDirty() && !bl2 : !pSDevSlnSysPubLock.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysPubLock.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSysPubLock, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysPubLock, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysPubLock pSDevSlnSysPubLock, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysPubLock, bl);
    }

    public Object getDataContextValue(PSDevSlnSysPubLock pSDevSlnSysPubLock, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysPubLock, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysPubLock pSDevSlnSysPubLock, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysPubLock, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKREASON", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockReason_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSPUBLOCKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysPubLockId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSPUBLOCKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysPubLockName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNLOCKTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnlockTime_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LockReason_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOCKREASON", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysPubLockId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSPUBLOCKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysPubLockName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSPUBLOCKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UnlockTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysPubLock pSDevSlnSysPubLock) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysPubLock)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysPubLock pSDevSlnSysPubLock) throws Exception {
        super.onUpdateParent(pSDevSlnSysPubLock);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysPubLock pSDevSlnSysPubLock, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSPUBLOCK");
        if (!bl) {
            pSDevSlnSysPubLock.setCreateDate(null);
            pSDevSlnSysPubLock.setCreateMan(null);
            pSDevSlnSysPubLock.setPSDevSlnSysPubLockId(null);
            pSDevSlnSysPubLock.setUpdateDate(null);
            pSDevSlnSysPubLock.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysPubLock, xmlNode, bl);
        }
    }
}

