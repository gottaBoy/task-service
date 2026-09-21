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
import net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTaskServerLogServiceBase
extends PSCoreSysServiceBase<PSTaskServerLog> {
    private static final Log log = LogFactory.getLog(PSTaskServerLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSTaskServerLogDEModel pSTaskServerLogDEModel;
    private PSTaskServerLogDAO pSTaskServerLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerLogService";
    }

    public PSTaskServerLogDEModel getPSTaskServerLogDEModel() {
        if (this.pSTaskServerLogDEModel == null) {
            try {
                this.pSTaskServerLogDEModel = (PSTaskServerLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSTaskServerLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSTaskServerLogDEModel();
    }

    public PSTaskServerLogDAO getPSTaskServerLogDAO() {
        if (this.pSTaskServerLogDAO == null) {
            try {
                this.pSTaskServerLogDAO = (PSTaskServerLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSTaskServerLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTaskServerLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSTaskServerLogDAO();
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

    protected void onFillParentInfo(PSTaskServerLog pSTaskServerLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTASKSERVERLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSTaskServerLog, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSTaskServerLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSTaskServer(PSTaskServerLog pSTaskServerLog, PSTaskServer pSTaskServer) throws Exception {
        pSTaskServerLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSTaskServerLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        if (bl) {
            if (pSTaskServerLog.getASBookingQueueCnt() == null) {
                pSTaskServerLog.setASBookingQueueCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSTaskServerLog.getASBookingQueueCnt2() == null) {
                pSTaskServerLog.setASBookingQueueCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSTaskServerLog.getDSBookingQueueCnt() == null) {
                pSTaskServerLog.setDSBookingQueueCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSTaskServerLog.getDSBookingQueueCnt2() == null) {
                pSTaskServerLog.setDSBookingQueueCnt2((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSTaskServerLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSTaskServerLog, bl);
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        if (pSTaskServerLog.isPSTaskServerIdDirty()) {
            if (pSTaskServerLog.getPSTaskServerId() != null) {
                if (pSTaskServerLog.getPSTaskServerId() == null || pSTaskServerLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSTaskServerLog.getPSTaskServer();
                    pSTaskServerLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSTaskServerLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSTaskServerLog, bl);
    }

    public ArrayList<PSTaskServerLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSTaskServerLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSTaskServerLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSTaskServerLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSTaskServerLog pSTaskServerLog : arrayList) {
            PSTaskServerLog pSTaskServerLog2 = (PSTaskServerLog)this.getDEModel().createEntity();
            pSTaskServerLog2.setPSTaskServerLogId(pSTaskServerLog.getPSTaskServerLogId());
            pSTaskServerLog2.setPSTaskServerId(null);
            this.update(pSTaskServerLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTaskServerLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSTaskServerLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSTaskServerLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSTaskServerLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSTaskServerLog pSTaskServerLog : arrayList) {
            this.remove((IEntity)pSTaskServerLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSTaskServerLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSTaskServerLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSTaskServerLog pSTaskServerLog) throws Exception {
        super.onBeforeRemove(pSTaskServerLog);
    }

    protected void replaceParentInfo(PSTaskServerLog pSTaskServerLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSTaskServerLog, cloneSession);
        if (pSTaskServerLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSTaskServerLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSTaskServerLog, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSTaskServerLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ASBookingQueueCnt(bl, pSTaskServerLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ASBookingQueueCnt2(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBDevInstCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTaskQueueCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTaskQueueCnt2(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DCTaskQueueCnt3(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSBookingQueueCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DSBookingQueueCnt2(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FreeMemory(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITSysCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogTime(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxMemory(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerLogId(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerLogName(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelHelperCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelInstCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTaskQueueCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTaskQueueCnt2(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTaskQueueCnt3(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ThreadCnt(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalMemory(bl, pSTaskServerLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSTaskServerLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ASBookingQueueCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isASBookingQueueCntDirty() : !pSTaskServerLog.isASBookingQueueCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getASBookingQueueCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ASBookingQueueCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASBOOKINGQUEUECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ASBookingQueueCnt2(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isASBookingQueueCnt2Dirty() : !pSTaskServerLog.isASBookingQueueCnt2Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getASBookingQueueCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ASBookingQueueCnt2_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASBOOKINGQUEUECNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBDevInstCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDBDevInstCntDirty() : !pSTaskServerLog.isDBDevInstCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDBDevInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DBDevInstCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBDEVINSTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDCCntDirty() : !pSTaskServerLog.isDCCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDCCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_DCTaskQueueCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDCTaskQueueCntDirty() : !pSTaskServerLog.isDCTaskQueueCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDCTaskQueueCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCTaskQueueCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTASKQUEUECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTaskQueueCnt2(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDCTaskQueueCnt2Dirty() : !pSTaskServerLog.isDCTaskQueueCnt2Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDCTaskQueueCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCTaskQueueCnt2_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTASKQUEUECNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DCTaskQueueCnt3(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDCTaskQueueCnt3Dirty() : !pSTaskServerLog.isDCTaskQueueCnt3Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDCTaskQueueCnt3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DCTaskQueueCnt3_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DCTASKQUEUECNT3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDefaultFlagDirty() && !bl2 : !pSTaskServerLog.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_DSBookingQueueCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDSBookingQueueCntDirty() : !pSTaskServerLog.isDSBookingQueueCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDSBookingQueueCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DSBookingQueueCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSBOOKINGQUEUECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DSBookingQueueCnt2(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isDSBookingQueueCnt2Dirty() : !pSTaskServerLog.isDSBookingQueueCnt2Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getDSBookingQueueCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DSBookingQueueCnt2_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSBOOKINGQUEUECNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FreeMemory(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isFreeMemoryDirty() : !pSTaskServerLog.isFreeMemoryDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getFreeMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FreeMemory_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_JITSysCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isJITSysCntDirty() : !pSTaskServerLog.isJITSysCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getJITSysCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_JITSysCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITSYSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogTime(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isLogTimeDirty() : !pSTaskServerLog.isLogTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSTaskServerLog.getLogTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogTime_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_MaxMemory(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isMaxMemoryDirty() : !pSTaskServerLog.isMaxMemoryDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getMaxMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxMemory_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isPSTaskServerIdDirty() : !pSTaskServerLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSTaskServerLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerLogId(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isPSTaskServerLogIdDirty() && !bl2 : !pSTaskServerLog.isPSTaskServerLogIdDirty()) {
            return null;
        }
        String string = pSTaskServerLog.getPSTaskServerLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerLogId_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerLogName(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isPSTaskServerLogNameDirty() && !bl2 : !pSTaskServerLog.isPSTaskServerLogNameDirty()) {
            return null;
        }
        String string = pSTaskServerLog.getPSTaskServerLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerLogName_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isPSTaskServerNameDirty() : !pSTaskServerLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSTaskServerLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isRobotCntDirty() : !pSTaskServerLog.isRobotCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getRobotCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RobotCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysModelCntDirty() : !pSTaskServerLog.isSysModelCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysModelCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysModelHelperCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysModelHelperCntDirty() : !pSTaskServerLog.isSysModelHelperCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysModelHelperCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelHelperCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELHELPERCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelInstCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysModelInstCntDirty() : !pSTaskServerLog.isSysModelInstCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysModelInstCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysModelInstCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysTaskQueueCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysTaskQueueCntDirty() : !pSTaskServerLog.isSysTaskQueueCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysTaskQueueCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysTaskQueueCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTASKQUEUECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTaskQueueCnt2(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysTaskQueueCnt2Dirty() : !pSTaskServerLog.isSysTaskQueueCnt2Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysTaskQueueCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysTaskQueueCnt2_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTASKQUEUECNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTaskQueueCnt3(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isSysTaskQueueCnt3Dirty() : !pSTaskServerLog.isSysTaskQueueCnt3Dirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getSysTaskQueueCnt3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysTaskQueueCnt3_Default((IEntity)pSTaskServerLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTASKQUEUECNT3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ThreadCnt(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isThreadCntDirty() : !pSTaskServerLog.isThreadCntDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getThreadCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ThreadCnt_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TotalMemory(boolean bl, PSTaskServerLog pSTaskServerLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTaskServerLog.isTotalMemoryDirty() : !pSTaskServerLog.isTotalMemoryDirty()) {
            return null;
        }
        Integer n = pSTaskServerLog.getTotalMemory();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalMemory_Default((IEntity)pSTaskServerLog, bl2, bl3);
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

    protected void onSyncEntity(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSTaskServerLog, bl);
    }

    protected void onSyncIndexEntities(PSTaskServerLog pSTaskServerLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSTaskServerLog, bl);
    }

    public Object getDataContextValue(PSTaskServerLog pSTaskServerLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSTaskServerLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSTaskServerLog pSTaskServerLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSTaskServerLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASBOOKINGQUEUECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASBookingQueueCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASBOOKINGQUEUECNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASBookingQueueCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBDEVINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBDevInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTASKQUEUECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTaskQueueCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTASKQUEUECNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTaskQueueCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DCTASKQUEUECNT3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DCTaskQueueCnt3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSBOOKINGQUEUECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSBookingQueueCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSBOOKINGQUEUECNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSBookingQueueCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FREEMEMORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FreeMemory_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITSYSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITSysCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXMEMORY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxMemory_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELHELPERCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelHelperCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELINSTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelInstCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTASKQUEUECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTaskQueueCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTASKQUEUECNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTaskQueueCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTASKQUEUECNT3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTaskQueueCnt3_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ASBookingQueueCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ASBookingQueueCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DBDevInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCTaskQueueCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCTaskQueueCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DCTaskQueueCnt3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSBookingQueueCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DSBookingQueueCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FreeMemory_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_JITSysCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxMemory_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RobotCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysModelCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysModelHelperCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysModelInstCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysTaskQueueCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysTaskQueueCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysTaskQueueCnt3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSTaskServerLog pSTaskServerLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSTaskServerLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSTaskServerLog pSTaskServerLog) throws Exception {
        super.onUpdateParent((IEntity)pSTaskServerLog);
    }

    @Override
    protected void exportCurXmlModel(PSTaskServerLog pSTaskServerLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSTASKSERVERLOG");
        if (!bl) {
            pSTaskServerLog.setCreateDate(null);
            pSTaskServerLog.setCreateMan(null);
            pSTaskServerLog.setPSTaskServerLogId(null);
            pSTaskServerLog.setUpdateDate(null);
            pSTaskServerLog.setUpdateMan(null);
            super.exportCurXmlModel(pSTaskServerLog, xmlNode, bl);
        }
    }
}

