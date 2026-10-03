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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterLogDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterLogDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterLogServiceBase
extends PSCoreSysServiceBase<PSDevCenterLog> {
    private static final Log log = LogFactory.getLog(PSDevCenterLogServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevCenterLogDEModel pSDevCenterLogDEModel;
    private PSDevCenterLogDAO pSDevCenterLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogService";
    }

    public PSDevCenterLogDEModel getPSDevCenterLogDEModel() {
        if (this.pSDevCenterLogDEModel == null) {
            try {
                this.pSDevCenterLogDEModel = (PSDevCenterLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevCenterLogDEModel();
    }

    public PSDevCenterLogDAO getPSDevCenterLogDAO() {
        if (this.pSDevCenterLogDAO == null) {
            try {
                this.pSDevCenterLogDAO = (PSDevCenterLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevCenterLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevCenterLog pSDevCenterLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevCenterLog, pSDevCenter);
            return;
        }
        super.onFillParentInfo(pSDevCenterLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDevCenterLog pSDevCenterLog, PSDevCenter pSDevCenter) throws Exception {
        pSDevCenterLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevCenterLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevCenterLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevCenterLog, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        if (pSDevCenterLog.isPSDevCenterIdDirty()) {
            if (pSDevCenterLog.getPSDevCenterId() != null) {
                if (pSDevCenterLog.getPSDevCenterId() == null || pSDevCenterLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevCenterLog.getPSDevCenter();
                    pSDevCenterLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevCenterLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevCenterLog, bl);
    }

    public ArrayList<PSDevCenterLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevCenterLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevCenterLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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
        ArrayList<PSDevCenterLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevCenterLog pSDevCenterLog : arrayList) {
            PSDevCenterLog pSDevCenterLog2 = (PSDevCenterLog)this.getDEModel().createEntity();
            pSDevCenterLog2.setPSDevCenterLogId(pSDevCenterLog.getPSDevCenterLogId());
            pSDevCenterLog2.setPSDevCenterId(null);
            this.update(pSDevCenterLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevCenterLog pSDevCenterLog : arrayList) {
            this.remove(pSDevCenterLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevCenterLog pSDevCenterLog) throws Exception {
        super.onBeforeRemove(pSDevCenterLog);
    }

    protected void replaceParentInfo(PSDevCenterLog pSDevCenterLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevCenterLog, cloneSession);
        if (pSDevCenterLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevCenterLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevCenterLog, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevCenterLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogInfo(bl, pSDevCenterLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo2(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogType(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterLogId(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterLogName(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoteAddr(bl, pSDevCenterLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevCenterLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isLogInfoDirty() : !pSDevCenterLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogInfo2(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isLogInfo2Dirty() : !pSDevCenterLog.isLogInfo2Dirty()) {
            return null;
        }
        String string = pSDevCenterLog.getLogInfo2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo2_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isLogLevelDirty() : !pSDevCenterLog.isLogLevelDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getLogLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogLevel_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isLogLevel2Dirty() : !pSDevCenterLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSDevCenterLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogType(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isLogTypeDirty() && !bl2 : !pSDevCenterLog.isLogTypeDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getLogType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogType_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isPSDevCenterIdDirty() && !bl2 : !pSDevCenterLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevCenterLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterLogId(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isPSDevCenterLogIdDirty() && !bl2 : !pSDevCenterLog.isPSDevCenterLogIdDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getPSDevCenterLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterLogId_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterLogName(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isPSDevCenterLogNameDirty() && !bl2 : !pSDevCenterLog.isPSDevCenterLogNameDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getPSDevCenterLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterLogName_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isPSDevCenterNameDirty() && !bl2 : !pSDevCenterLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDevCenterLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemoteAddr(boolean bl, PSDevCenterLog pSDevCenterLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterLog.isRemoteAddrDirty() : !pSDevCenterLog.isRemoteAddrDirty()) {
            return null;
        }
        String string = pSDevCenterLog.getRemoteAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoteAddr_Default(pSDevCenterLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOTEADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDevCenterLog, bl);
    }

    protected void onSyncIndexEntities(PSDevCenterLog pSDevCenterLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevCenterLog, bl);
    }

    public Object getDataContextValue(PSDevCenterLog pSDevCenterLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevCenterLog, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDevCenterLog.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevCenterLog pSDevCenterLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevCenterLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOTEADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoteAddr_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LogInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogInfo2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGLEVEL", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSDevCenterLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_RemoteAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOTEADDR", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSDevCenterLog pSDevCenterLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevCenterLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevCenterLog pSDevCenterLog) throws Exception {
        super.onUpdateParent(pSDevCenterLog);
    }

    @Override
    protected void exportCurXmlModel(PSDevCenterLog pSDevCenterLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVCENTERLOG");
        if (!bl) {
            pSDevCenterLog.setCreateDate(null);
            pSDevCenterLog.setCreateMan(null);
            pSDevCenterLog.setLogLevel2(null);
            pSDevCenterLog.setPSDevCenterLogId(null);
            pSDevCenterLog.setUpdateDate(null);
            pSDevCenterLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDevCenterLog, xmlNode, bl);
        }
    }
}

