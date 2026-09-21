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
package net.ibizsys.pscore.srv.paasmgr.service;

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
import net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSStudioServerLogServiceBase
extends PSCoreSysServiceBase<PSStudioServerLog> {
    private static final Log log = LogFactory.getLog(PSStudioServerLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSStudioServerLogDEModel pSStudioServerLogDEModel;
    private PSStudioServerLogDAO pSStudioServerLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerLogService";
    }

    public PSStudioServerLogDEModel getPSStudioServerLogDEModel() {
        if (this.pSStudioServerLogDEModel == null) {
            try {
                this.pSStudioServerLogDEModel = (PSStudioServerLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioServerLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSStudioServerLogDEModel();
    }

    public PSStudioServerLogDAO getPSStudioServerLogDAO() {
        if (this.pSStudioServerLogDAO == null) {
            try {
                this.pSStudioServerLogDAO = (PSStudioServerLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSStudioServerLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioServerLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSStudioServerLogDAO();
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

    protected void onFillParentInfo(PSStudioServerLog pSStudioServerLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSTUDIOSERVERLOG_PSSTUDIOSERVER_PSSTUDIOSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService", (SessionFactory)this.getSessionFactory());
            PSStudioServer pSStudioServer = (PSStudioServer)iService.getDEModel().createEntity();
            pSStudioServer.set("PSSTUDIOSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSStudioServer);
            } else {
                iService.get((IEntity)pSStudioServer);
            }
            this.onFillParentInfo_PSStudioServer(pSStudioServerLog, pSStudioServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSStudioServerLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSStudioServer(PSStudioServerLog pSStudioServerLog, PSStudioServer pSStudioServer) throws Exception {
        pSStudioServerLog.setPSStudioServerId(pSStudioServer.getPSStudioServerId());
        pSStudioServerLog.setPSStudioServerName(pSStudioServer.getPSStudioServerName());
    }

    protected void onFillEntityFullInfo(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSStudioServerLog, bl);
        this.onFillEntityFullInfo_PSStudioServer(pSStudioServerLog, bl);
    }

    protected void onFillEntityFullInfo_PSStudioServer(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        if (pSStudioServerLog.isPSStudioServerIdDirty()) {
            if (pSStudioServerLog.getPSStudioServerId() != null) {
                if (pSStudioServerLog.getPSStudioServerId() == null || pSStudioServerLog.getPSStudioServerName() == null) {
                    PSStudioServer pSStudioServer = pSStudioServerLog.getPSStudioServer();
                    pSStudioServerLog.setPSStudioServerName(pSStudioServer.getPSStudioServerName());
                }
            } else {
                pSStudioServerLog.setPSStudioServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSStudioServerLog, bl);
    }

    public ArrayList<PSStudioServerLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase) throws Exception {
        return this.selectByPSStudioServer(pSStudioServerBase, "", -1);
    }

    public ArrayList<PSStudioServerLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase, String string) throws Exception {
        return this.selectByPSStudioServer(pSStudioServerBase, string, -1);
    }

    public ArrayList<PSStudioServerLog> selectByPSStudioServer(PSStudioServerBase pSStudioServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOSERVERID", (Object)pSStudioServerBase.getPSStudioServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    public void resetPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        ArrayList<PSStudioServerLog> arrayList = this.selectByPSStudioServer(pSStudioServer);
        for (PSStudioServerLog pSStudioServerLog : arrayList) {
            PSStudioServerLog pSStudioServerLog2 = (PSStudioServerLog)this.getDEModel().createEntity();
            pSStudioServerLog2.setPSStudioServerLogId(pSStudioServerLog.getPSStudioServerLogId());
            pSStudioServerLog2.setPSStudioServerId(null);
            this.update(pSStudioServerLog2);
        }
    }

    public void removeByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        final PSStudioServer pSStudioServer2 = pSStudioServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSStudioServerLogServiceBase.this.onBeforeRemoveByPSStudioServer(pSStudioServer2);
                PSStudioServerLogServiceBase.this.internalRemoveByPSStudioServer(pSStudioServer2);
                PSStudioServerLogServiceBase.this.onAfterRemoveByPSStudioServer(pSStudioServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    protected void internalRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
        ArrayList<PSStudioServerLog> arrayList = this.selectByPSStudioServer(pSStudioServer);
        this.onBeforeRemoveByPSStudioServer(pSStudioServer, arrayList);
        for (PSStudioServerLog pSStudioServerLog : arrayList) {
            this.remove((IEntity)pSStudioServerLog);
        }
        this.onAfterRemoveByPSStudioServer(pSStudioServer, arrayList);
    }

    protected void onAfterRemoveByPSStudioServer(PSStudioServer pSStudioServer) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioServer(PSStudioServer pSStudioServer, ArrayList<PSStudioServerLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioServer(PSStudioServer pSStudioServer, ArrayList<PSStudioServerLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSStudioServerLog pSStudioServerLog) throws Exception {
        super.onBeforeRemove(pSStudioServerLog);
    }

    protected void replaceParentInfo(PSStudioServerLog pSStudioServerLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSStudioServerLog, cloneSession);
        if (pSStudioServerLog.getPSStudioServerId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOSERVER", (Object)pSStudioServerLog.getPSStudioServerId())) != null) {
            this.onFillParentInfo_PSStudioServer(pSStudioServerLog, (PSStudioServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSStudioServerLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DCCnt(bl, pSStudioServerLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FreeMemory(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogTime(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxMemory(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerId(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerLogId(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerLogName(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioServerName(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelCnt(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelInstCnt(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadCnt(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalMemory(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCnt(bl, pSStudioServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSStudioServerLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DCCnt(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isDCCntDirty() : !pSStudioServerLog.isDCCntDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getDCCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCCnt_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isDefaultFlagDirty() && !bl2 : !pSStudioServerLog.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FreeMemory(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isFreeMemoryDirty() : !pSStudioServerLog.isFreeMemoryDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getFreeMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FreeMemory_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FREEMEMORY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogTime(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isLogTimeDirty() : !pSStudioServerLog.isLogTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSStudioServerLog.getLogTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogTime_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxMemory(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isMaxMemoryDirty() : !pSStudioServerLog.isMaxMemoryDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getMaxMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxMemory_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXMEMORY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerId(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isPSStudioServerIdDirty() : !pSStudioServerLog.isPSStudioServerIdDirty()) {
            return null;
        }
        String string = pSStudioServerLog.getPSStudioServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerId_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerLogId(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isPSStudioServerLogIdDirty() && !bl2 : !pSStudioServerLog.isPSStudioServerLogIdDirty()) {
            return null;
        }
        String string = pSStudioServerLog.getPSStudioServerLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerLogId_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerLogName(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isPSStudioServerLogNameDirty() && !bl2 : !pSStudioServerLog.isPSStudioServerLogNameDirty()) {
            return null;
        }
        String string = pSStudioServerLog.getPSStudioServerLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerLogName_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioServerName(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isPSStudioServerNameDirty() : !pSStudioServerLog.isPSStudioServerNameDirty()) {
            return null;
        }
        String string = pSStudioServerLog.getPSStudioServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioServerName_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelCnt(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isSysModelCntDirty() : !pSStudioServerLog.isSysModelCntDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getSysModelCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelCnt_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelInstCnt(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isSysModelInstCntDirty() : !pSStudioServerLog.isSysModelInstCntDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getSysModelInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelInstCnt_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadCnt(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isThreadCntDirty() : !pSStudioServerLog.isThreadCntDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getThreadCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadCnt_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("THREADCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalMemory(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isTotalMemoryDirty() : !pSStudioServerLog.isTotalMemoryDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getTotalMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalMemory_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALMEMORY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCnt(boolean bl, PSStudioServerLog pSStudioServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSStudioServerLog.isUserCntDirty() : !pSStudioServerLog.isUserCntDirty()) {
            return null;
        }
        Integer n = pSStudioServerLog.getUserCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserCnt_Default((IEntity)pSStudioServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSStudioServerLog, bl);
    }

    protected void onSyncIndexEntities(PSStudioServerLog pSStudioServerLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSStudioServerLog, bl);
    }

    public Object getDataContextValue(PSStudioServerLog pSStudioServerLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSStudioServerLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSStudioServerLog pSStudioServerLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSStudioServerLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FREEMEMORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FreeMemory_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXMEMORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxMemory_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THREADCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThreadCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALMEMORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalMemory_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCnt_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DCCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FreeMemory_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxMemory_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSStudioServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysModelCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysModelInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ThreadCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TotalMemory_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSStudioServerLog pSStudioServerLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSStudioServerLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSStudioServerLog pSStudioServerLog) throws Exception {
        super.onUpdateParent((IEntity)pSStudioServerLog);
    }

    @Override
    protected void exportCurXmlModel(PSStudioServerLog pSStudioServerLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSTUDIOSERVERLOG");
        if (!bl) {
            pSStudioServerLog.setCreateDate(null);
            pSStudioServerLog.setCreateMan(null);
            pSStudioServerLog.setPSStudioServerLogId(null);
            pSStudioServerLog.setUpdateDate(null);
            pSStudioServerLog.setUpdateMan(null);
            super.exportCurXmlModel(pSStudioServerLog, xmlNode, bl);
        }
    }
}

