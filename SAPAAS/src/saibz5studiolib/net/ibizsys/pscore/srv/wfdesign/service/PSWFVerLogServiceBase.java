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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.wfdesign.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFVerLogDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVerLogDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVerLog;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFVerLogServiceBase
extends PSCoreSysServiceBase<PSWFVerLog> {
    private static final Log log = LogFactory.getLog(PSWFVerLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_RESTOREVER = "RestoreVer";
    private PSWFVerLogDEModel pSWFVerLogDEModel;
    private PSWFVerLogDAO pSWFVerLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogService";
    }

    public PSWFVerLogDEModel getPSWFVerLogDEModel() {
        if (this.pSWFVerLogDEModel == null) {
            try {
                this.pSWFVerLogDEModel = (PSWFVerLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVerLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFVerLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFVerLogDEModel();
    }

    public PSWFVerLogDAO getPSWFVerLogDAO() {
        if (this.pSWFVerLogDAO == null) {
            try {
                this.pSWFVerLogDAO = (PSWFVerLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFVerLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFVerLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFVerLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_RESTOREVER, (boolean)true) == 0) {
            this.restoreVer((PSWFVerLog)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void restoreVer(PSWFVerLog pSWFVerLog) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_RESTOREVER, 0, pSWFVerLog, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSWFVerLog, ACTION_RESTOREVER);
        final PSWFVerLog pSWFVerLog2 = pSWFVerLog;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVerLogServiceBase.this.getService(), PSWFVerLogServiceBase.ACTION_RESTOREVER, 40, pSWFVerLog2, null).getResult() != 1) {
                    PSWFVerLogServiceBase.this.onRestoreVer(pSWFVerLog2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_RESTOREVER, 99, pSWFVerLog, null);
        }
    }

    protected void onRestoreVer(PSWFVerLog pSWFVerLog) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RestoreVer]");
    }

    protected void onFillParentInfo(PSWFVerLog pSWFVerLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERLOG_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWFVersion);
            } else {
                iService.get(pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSWFVerLog, pSWFVersion);
            return;
        }
        super.onFillParentInfo(pSWFVerLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWFVersion(PSWFVerLog pSWFVerLog, PSWFVersion pSWFVersion) throws Exception {
        pSWFVerLog.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSWFVerLog.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
    }

    protected void onFillEntityFullInfo(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWFVerLog, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSWFVerLog, bl);
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        if (pSWFVerLog.isPSWFVersionIdDirty()) {
            if (pSWFVerLog.getPSWFVersionId() != null) {
                if (pSWFVerLog.getPSWFVersionId() == null || pSWFVerLog.getPSWFVersionName() == null) {
                    PSWFVersion pSWFVersion = pSWFVerLog.getPSWFVersion();
                    pSWFVerLog.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                }
            } else {
                pSWFVerLog.setPSWFVersionName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSWFVerLog, bl);
    }

    public ArrayList<PSWFVerLog> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSWFVerLog> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSWFVerLog> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFVerLog> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSWFVerLog pSWFVerLog : arrayList) {
            PSWFVerLog pSWFVerLog2 = (PSWFVerLog)this.getDEModel().createEntity();
            pSWFVerLog2.setPSWFVerLogId(pSWFVerLog.getPSWFVerLogId());
            pSWFVerLog2.setPSWFVersionId(null);
            this.update(pSWFVerLog2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVerLogServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSWFVerLogServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSWFVerLogServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSWFVerLog> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSWFVerLog pSWFVerLog : arrayList) {
            this.remove(pSWFVerLog);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFVerLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSWFVerLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFVerLog pSWFVerLog) throws Exception {
        super.onBeforeRemove(pSWFVerLog);
    }

    protected void replaceParentInfo(PSWFVerLog pSWFVerLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWFVerLog, cloneSession);
        if (pSWFVerLog.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSWFVerLog.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSWFVerLog, (PSWFVersion)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWFVerLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackDataTag(bl, pSWFVerLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupData(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVerLogId(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVerLogName(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionName(bl, pSWFVerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWFVerLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackDataTag(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isBackDataTagDirty() : !pSWFVerLog.isBackDataTagDirty()) {
            return null;
        }
        String string = pSWFVerLog.getBackDataTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackDataTag_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKDATATAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupData(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isBackupDataDirty() : !pSWFVerLog.isBackupDataDirty()) {
            return null;
        }
        String string = pSWFVerLog.getBackupData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackupData_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isDynaModelFlagDirty() : !pSWFVerLog.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFVerLog.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isMemoDirty() : !pSWFVerLog.isMemoDirty()) {
            return null;
        }
        String string = pSWFVerLog.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWFVerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isPSDynaInstIdDirty() : !pSWFVerLog.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFVerLog.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVerLogId(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isPSWFVerLogIdDirty() && !bl2 : !pSWFVerLog.isPSWFVerLogIdDirty()) {
            return null;
        }
        String string = pSWFVerLog.getPSWFVerLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVerLogId_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVerLogName(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isPSWFVerLogNameDirty() && !bl2 : !pSWFVerLog.isPSWFVerLogNameDirty()) {
            return null;
        }
        String string = pSWFVerLog.getPSWFVerLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVerLogName_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isPSWFVersionIdDirty() : !pSWFVerLog.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFVerLog.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionName(boolean bl, PSWFVerLog pSWFVerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVerLog.isPSWFVersionNameDirty() : !pSWFVerLog.isPSWFVersionNameDirty()) {
            return null;
        }
        String string = pSWFVerLog.getPSWFVersionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionName_Default(pSWFVerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        super.onSyncEntity(pSWFVerLog, bl);
    }

    protected void onSyncIndexEntities(PSWFVerLog pSWFVerLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWFVerLog, bl);
    }

    public Object getDataContextValue(PSWFVerLog pSWFVerLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWFVerLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWFVerLog pSWFVerLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWFVerLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKDATATAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackDataTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BACKUPDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVerLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVerLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackDataTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BACKDATATAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BackupData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BACKUPDATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVerLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVerLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSWFVerLog pSWFVerLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWFVerLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWFVerLog pSWFVerLog) throws Exception {
        super.onUpdateParent(pSWFVerLog);
    }

    @Override
    protected void exportCurXmlModel(PSWFVerLog pSWFVerLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFVERLOG");
        if (!bl) {
            pSWFVerLog.setCreateDate(null);
            pSWFVerLog.setCreateMan(null);
            pSWFVerLog.setPSWFVerLogId(null);
            pSWFVerLog.setUpdateDate(null);
            pSWFVerLog.setUpdateMan(null);
            super.exportCurXmlModel(pSWFVerLog, xmlNode, bl);
        }
    }
}

