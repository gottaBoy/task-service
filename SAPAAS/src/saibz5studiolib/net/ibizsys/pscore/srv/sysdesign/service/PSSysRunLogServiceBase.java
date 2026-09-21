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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysRunLogDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunLogDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSessionBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysRunLogServiceBase
extends PSCoreSysServiceBase<PSSysRunLog> {
    private static final Log log = LogFactory.getLog(PSSysRunLogServiceBase.class);
    public static final String DATASET_CURSYSRUN = "CurSysRun";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysRunLogDEModel pSSysRunLogDEModel;
    private PSSysRunLogDAO pSSysRunLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService";
    }

    public PSSysRunLogDEModel getPSSysRunLogDEModel() {
        if (this.pSSysRunLogDEModel == null) {
            try {
                this.pSSysRunLogDEModel = (PSSysRunLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRunLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysRunLogDEModel();
    }

    public PSSysRunLogDAO getPSSysRunLogDAO() {
        if (this.pSSysRunLogDAO == null) {
            try {
                this.pSSysRunLogDAO = (PSSysRunLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysRunLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRunLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysRunLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSRUN, (boolean)true) == 0) {
            return this.fetchCurSysRun(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSysRun(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSRUN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysRunLog pSSysRunLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNLOG_PSSYSRUNSESSION_PSSYSRUNSESSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService", (SessionFactory)this.getSessionFactory());
            PSSysRunSession pSSysRunSession = (PSSysRunSession)iService.getDEModel().createEntity();
            pSSysRunSession.set("PSSYSRUNSESSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysRunSession);
            } else {
                iService.get((IEntity)pSSysRunSession);
            }
            this.onFillParentInfo_PSSysRunSession(pSSysRunLog, pSSysRunSession);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSRUNLOG_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysRunLog, pSSystem);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysRunLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysRunSession(PSSysRunLog pSSysRunLog, PSSysRunSession pSSysRunSession) throws Exception {
        pSSysRunLog.setPSSysRunSessionId(pSSysRunSession.getPSSysRunSessionId());
        pSSysRunLog.setPSSysRunSessionName(pSSysRunSession.getPSSysRunSessionName());
        pSSysRunLog.setRunState(pSSysRunSession.getRunState());
    }

    protected void onFillParentInfo_PSSystem(PSSysRunLog pSSysRunLog, PSSystem pSSystem) throws Exception {
        pSSysRunLog.setPSSystemId(pSSystem.getPSSystemId());
        pSSysRunLog.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysRunLog, bl);
        this.onFillEntityFullInfo_PSSysRunSession(pSSysRunLog, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysRunLog, bl);
    }

    protected void onFillEntityFullInfo_PSSysRunSession(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        if (pSSysRunLog.isPSSysRunSessionIdDirty()) {
            if (pSSysRunLog.getPSSysRunSessionId() != null) {
                if (pSSysRunLog.getPSSysRunSessionId() == null || pSSysRunLog.getPSSysRunSessionName() == null) {
                    PSSysRunSession pSSysRunSession = pSSysRunLog.getPSSysRunSession();
                    pSSysRunLog.setPSSysRunSessionName(pSSysRunSession.getPSSysRunSessionName());
                    pSSysRunLog.setRunState(pSSysRunSession.getRunState());
                }
            } else {
                pSSysRunLog.setPSSysRunSessionName(null);
                pSSysRunLog.setRunState(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        if (pSSysRunLog.isPSSystemIdDirty()) {
            if (pSSysRunLog.getPSSystemId() != null) {
                if (pSSysRunLog.getPSSystemId() == null || pSSysRunLog.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysRunLog.getPSSystem();
                    pSSysRunLog.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysRunLog.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysRunLog, bl);
    }

    public ArrayList<PSSysRunLog> selectByPSSysRunSession(PSSysRunSessionBase pSSysRunSessionBase) throws Exception {
        return this.selectByPSSysRunSession(pSSysRunSessionBase, "", -1);
    }

    public ArrayList<PSSysRunLog> selectByPSSysRunSession(PSSysRunSessionBase pSSysRunSessionBase, String string) throws Exception {
        return this.selectByPSSysRunSession(pSSysRunSessionBase, string, -1);
    }

    public ArrayList<PSSysRunLog> selectByPSSysRunSession(PSSysRunSessionBase pSSysRunSessionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRUNSESSIONID", (Object)pSSysRunSessionBase.getPSSysRunSessionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysRunSessionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysRunSessionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysRunLog> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysRunLog> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysRunLog> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
    }

    public void resetPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
        ArrayList<PSSysRunLog> arrayList = this.selectByPSSysRunSession(pSSysRunSession);
        for (PSSysRunLog pSSysRunLog : arrayList) {
            PSSysRunLog pSSysRunLog2 = (PSSysRunLog)this.getDEModel().createEntity();
            pSSysRunLog2.setPSSysRunLogId(pSSysRunLog.getPSSysRunLogId());
            pSSysRunLog2.setPSSysRunSessionId(null);
            this.update(pSSysRunLog2);
        }
    }

    public void removeByPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
        final PSSysRunSession pSSysRunSession2 = pSSysRunSession;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunLogServiceBase.this.onBeforeRemoveByPSSysRunSession(pSSysRunSession2);
                PSSysRunLogServiceBase.this.internalRemoveByPSSysRunSession(pSSysRunSession2);
                PSSysRunLogServiceBase.this.onAfterRemoveByPSSysRunSession(pSSysRunSession2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
    }

    protected void internalRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
        ArrayList<PSSysRunLog> arrayList = this.selectByPSSysRunSession(pSSysRunSession);
        this.onBeforeRemoveByPSSysRunSession(pSSysRunSession, arrayList);
        for (PSSysRunLog pSSysRunLog : arrayList) {
            this.remove((IEntity)pSSysRunLog);
        }
        this.onAfterRemoveByPSSysRunSession(pSSysRunSession, arrayList);
    }

    protected void onAfterRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession) throws Exception {
    }

    protected void onBeforeRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession, ArrayList<PSSysRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysRunSession(PSSysRunSession pSSysRunSession, ArrayList<PSSysRunLog> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysRunLog> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysRunLog pSSysRunLog : arrayList) {
            PSSysRunLog pSSysRunLog2 = (PSSysRunLog)this.getDEModel().createEntity();
            pSSysRunLog2.setPSSysRunLogId(pSSysRunLog.getPSSysRunLogId());
            pSSysRunLog2.setPSSystemId(null);
            this.update(pSSysRunLog2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysRunLogServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysRunLogServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysRunLogServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysRunLog> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysRunLog pSSysRunLog : arrayList) {
            this.remove((IEntity)pSSysRunLog);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysRunLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysRunLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysRunLog pSSysRunLog) throws Exception {
        super.onBeforeRemove(pSSysRunLog);
    }

    protected void replaceParentInfo(PSSysRunLog pSSysRunLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysRunLog, cloneSession);
        if (pSSysRunLog.getPSSysRunSessionId() != null && (iEntity = cloneSession.getEntity("PSSYSRUNSESSION", (Object)pSSysRunLog.getPSSysRunSessionId())) != null) {
            this.onFillParentInfo_PSSysRunSession(pSSysRunLog, (PSSysRunSession)iEntity);
        }
        if (pSSysRunLog.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysRunLog.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysRunLog, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysRunLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogInfo(bl, pSSysRunLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo2(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogTime(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunLogId(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunLogName(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunSessionId(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysRunSessionName(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysRunLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysRunLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isLogInfoDirty() : !pSSysRunLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSSysRunLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogInfo2(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isLogInfo2Dirty() : !pSSysRunLog.isLogInfo2Dirty()) {
            return null;
        }
        String string = pSSysRunLog.getLogInfo2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo2_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogLevel(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isLogLevelDirty() : !pSSysRunLog.isLogLevelDirty()) {
            return null;
        }
        String string = pSSysRunLog.getLogLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogLevel_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isLogLevel2Dirty() : !pSSysRunLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSSysRunLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogTime(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isLogTimeDirty() && !bl2 : !pSSysRunLog.isLogTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysRunLog.getLogTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_LogTime_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysRunLogId(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSysRunLogIdDirty() && !bl2 : !pSSysRunLog.isPSSysRunLogIdDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSysRunLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunLogId_Default((IEntity)pSSysRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRunLogName(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSysRunLogNameDirty() && !bl2 : !pSSysRunLog.isPSSysRunLogNameDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSysRunLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunLogName_Default((IEntity)pSSysRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRunSessionId(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSysRunSessionIdDirty() : !pSSysRunLog.isPSSysRunSessionIdDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSysRunSessionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunSessionId_Default((IEntity)pSSysRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysRunSessionName(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSysRunSessionNameDirty() : !pSSysRunLog.isPSSysRunSessionNameDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSysRunSessionName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysRunSessionName_Default((IEntity)pSSysRunLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRUNSESSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSystemIdDirty() : !pSSysRunLog.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysRunLog pSSysRunLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysRunLog.isPSSystemNameDirty() : !pSSysRunLog.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysRunLog.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysRunLog, bl2, bl3);
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

    protected void onSyncEntity(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysRunLog, bl);
    }

    protected void onSyncIndexEntities(PSSysRunLog pSSysRunLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysRunLog, bl);
    }

    public Object getDataContextValue(PSSysRunLog pSSysRunLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysRunLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysRunLog pSSysRunLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysRunLog, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LOGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNSESSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunSessionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRUNSESSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysRunSessionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunState_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("LOGINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_LogTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysRunLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRunLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRunSessionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNSESSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysRunSessionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRUNSESSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RunState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSSysRunLog pSSysRunLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysRunLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysRunLog pSSysRunLog) throws Exception {
        super.onUpdateParent((IEntity)pSSysRunLog);
    }

    @Override
    protected void exportCurXmlModel(PSSysRunLog pSSysRunLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSRUNLOG");
        if (!bl) {
            pSSysRunLog.setLogLevel(null);
            pSSysRunLog.setLogLevel2(null);
            pSSysRunLog.setPSSystemId(null);
            pSSysRunLog.setPSSystemName(null);
            super.exportCurXmlModel(pSSysRunLog, xmlNode, bl);
        }
    }
}

