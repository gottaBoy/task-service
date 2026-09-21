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
import net.ibizsys.pscore.srv.paasmgr.dao.PSDBDevInstBKDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDBDevInstBKDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBDevInstBKServiceBase
extends PSCoreSysServiceBase<PSDBDevInstBK> {
    private static final Log log = LogFactory.getLog(PSDBDevInstBKServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDBDevInstBKDEModel pSDBDevInstBKDEModel;
    private PSDBDevInstBKDAO pSDBDevInstBKDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstBKService";
    }

    public PSDBDevInstBKDEModel getPSDBDevInstBKDEModel() {
        if (this.pSDBDevInstBKDEModel == null) {
            try {
                this.pSDBDevInstBKDEModel = (PSDBDevInstBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDBDevInstBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBDevInstBKDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDBDevInstBKDEModel();
    }

    public PSDBDevInstBKDAO getPSDBDevInstBKDAO() {
        if (this.pSDBDevInstBKDAO == null) {
            try {
                this.pSDBDevInstBKDAO = (PSDBDevInstBKDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDBDevInstBKDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBDevInstBKDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDBDevInstBKDAO();
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

    protected void onFillParentInfo(PSDBDevInstBK pSDBDevInstBK, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINSTBK_PSDBDEVINST_PSDBDEVINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService", (SessionFactory)this.getSessionFactory());
            PSDBDevInst pSDBDevInst = (PSDBDevInst)iService.getDEModel().createEntity();
            pSDBDevInst.set("PSDBDEVINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDBDevInst);
            } else {
                iService.get((IEntity)pSDBDevInst);
            }
            this.onFillParentInfo_PSDBDevInst(pSDBDevInstBK, pSDBDevInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDBDEVINSTBK_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDBDevInstBK, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDBDevInstBK, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBDevInst(PSDBDevInstBK pSDBDevInstBK, PSDBDevInst pSDBDevInst) throws Exception {
        pSDBDevInstBK.setPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
        pSDBDevInstBK.setPSDBDevInstName(pSDBDevInst.getPSDBDevInstName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDBDevInstBK pSDBDevInstBK, PSTaskServer pSTaskServer) throws Exception {
        pSDBDevInstBK.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDBDevInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        if (bl) {
            if (pSDBDevInstBK.getBackupMode() == null) {
                pSDBDevInstBK.setBackupMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDBDevInstBK.getBKState() == null) {
                pSDBDevInstBK.setBKState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDBDevInstBK.getValidFlag() == null) {
                pSDBDevInstBK.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDBDevInstBK, bl);
        this.onFillEntityFullInfo_PSDBDevInst(pSDBDevInstBK, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDBDevInstBK, bl);
    }

    protected void onFillEntityFullInfo_PSDBDevInst(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        if (pSDBDevInstBK.isPSDBDevInstIdDirty()) {
            if (pSDBDevInstBK.getPSDBDevInstId() != null) {
                if (pSDBDevInstBK.getPSDBDevInstId() == null || pSDBDevInstBK.getPSDBDevInstName() == null) {
                    PSDBDevInst pSDBDevInst = pSDBDevInstBK.getPSDBDevInst();
                    pSDBDevInstBK.setPSDBDevInstName(pSDBDevInst.getPSDBDevInstName());
                }
            } else {
                pSDBDevInstBK.setPSDBDevInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        if (pSDBDevInstBK.isPSTaskServerIdDirty()) {
            if (pSDBDevInstBK.getPSTaskServerId() != null) {
                if (pSDBDevInstBK.getPSTaskServerId() == null || pSDBDevInstBK.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDBDevInstBK.getPSTaskServer();
                    pSDBDevInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDBDevInstBK.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDBDevInstBK, bl);
    }

    public ArrayList<PSDBDevInstBK> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase) throws Exception {
        return this.selectByPSDBDevInst(pSDBDevInstBase, "", -1);
    }

    public ArrayList<PSDBDevInstBK> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string) throws Exception {
        return this.selectByPSDBDevInst(pSDBDevInstBase, string, -1);
    }

    public ArrayList<PSDBDevInstBK> selectByPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBDEVINSTID", (Object)pSDBDevInstBase.getPSDBDevInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBDevInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBDevInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDBDevInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDBDevInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDBDevInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    public void resetPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSDBDevInstBK> arrayList = this.selectByPSDBDevInst(pSDBDevInst);
        for (PSDBDevInstBK pSDBDevInstBK : arrayList) {
            PSDBDevInstBK pSDBDevInstBK2 = (PSDBDevInstBK)this.getDEModel().createEntity();
            pSDBDevInstBK2.setPSDBDevInstBKId(pSDBDevInstBK.getPSDBDevInstBKId());
            pSDBDevInstBK2.setPSDBDevInstId(null);
            this.update(pSDBDevInstBK2);
        }
    }

    public void removeByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        final PSDBDevInst pSDBDevInst2 = pSDBDevInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstBKServiceBase.this.onBeforeRemoveByPSDBDevInst(pSDBDevInst2);
                PSDBDevInstBKServiceBase.this.internalRemoveByPSDBDevInst(pSDBDevInst2);
                PSDBDevInstBKServiceBase.this.onAfterRemoveByPSDBDevInst(pSDBDevInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void internalRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSDBDevInstBK> arrayList = this.selectByPSDBDevInst(pSDBDevInst);
        this.onBeforeRemoveByPSDBDevInst(pSDBDevInst, arrayList);
        for (PSDBDevInstBK pSDBDevInstBK : arrayList) {
            this.remove((IEntity)pSDBDevInstBK);
        }
        this.onAfterRemoveByPSDBDevInst(pSDBDevInst, arrayList);
    }

    protected void onAfterRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSDBDevInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSDBDevInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDBDevInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDBDevInstBK pSDBDevInstBK : arrayList) {
            PSDBDevInstBK pSDBDevInstBK2 = (PSDBDevInstBK)this.getDEModel().createEntity();
            pSDBDevInstBK2.setPSDBDevInstBKId(pSDBDevInstBK.getPSDBDevInstBKId());
            pSDBDevInstBK2.setPSTaskServerId(null);
            this.update(pSDBDevInstBK2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDBDevInstBKServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDBDevInstBKServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDBDevInstBKServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDBDevInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDBDevInstBK pSDBDevInstBK : arrayList) {
            this.remove((IEntity)pSDBDevInstBK);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDBDevInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDBDevInstBK> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDBDevInstBK pSDBDevInstBK) throws Exception {
        super.onBeforeRemove(pSDBDevInstBK);
    }

    protected void replaceParentInfo(PSDBDevInstBK pSDBDevInstBK, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDBDevInstBK, cloneSession);
        if (pSDBDevInstBK.getPSDBDevInstId() != null && (iEntity = cloneSession.getEntity("PSDBDEVINST", (Object)pSDBDevInstBK.getPSDBDevInstId())) != null) {
            this.onFillParentInfo_PSDBDevInst(pSDBDevInstBK, (PSDBDevInst)iEntity);
        }
        if (pSDBDevInstBK.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDBDevInstBK.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDBDevInstBK, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDBDevInstBK, bl);
    }

    protected void onCheckEntity(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BKFilePath(bl, pSDBDevInstBK, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKFileSize(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKInfo(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupMode(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKState(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKTime(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstBKId(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstBKName(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstId(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBDevInstName(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDBDevInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDBDevInstBK, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BKFilePath(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBKFilePathDirty() : !pSDBDevInstBK.isBKFilePathDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getBKFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKFilePath_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKFILEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKFileSize(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBKFileSizeDirty() : !pSDBDevInstBK.isBKFileSizeDirty()) {
            return null;
        }
        Integer n = pSDBDevInstBK.getBKFileSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BKFileSize_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKFILESIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKInfo(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBKInfoDirty() : !pSDBDevInstBK.isBKInfoDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getBKInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKInfo_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupMode(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBackupModeDirty() && !bl2 : !pSDBDevInstBK.isBackupModeDirty()) {
            return null;
        }
        Integer n = pSDBDevInstBK.getBackupMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupMode_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKState(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBKStateDirty() && !bl2 : !pSDBDevInstBK.isBKStateDirty()) {
            return null;
        }
        Integer n = pSDBDevInstBK.getBKState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BKState_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKTime(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isBKTimeDirty() : !pSDBDevInstBK.isBKTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDBDevInstBK.getBKTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BKTime_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isMemoDirty() : !pSDBDevInstBK.isMemoDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDBDevInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPasswdDirty() : !pSDBDevInstBK.isPasswdDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstBKId(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSDBDevInstBKIdDirty() && !bl2 : !pSDBDevInstBK.isPSDBDevInstBKIdDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSDBDevInstBKId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstBKId_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstBKName(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSDBDevInstBKNameDirty() && !bl2 : !pSDBDevInstBK.isPSDBDevInstBKNameDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSDBDevInstBKName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstBKName_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTBKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstId(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSDBDevInstIdDirty() : !pSDBDevInstBK.isPSDBDevInstIdDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSDBDevInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstId_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBDevInstName(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSDBDevInstNameDirty() : !pSDBDevInstBK.isPSDBDevInstNameDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSDBDevInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBDevInstName_Default((IEntity)pSDBDevInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBDEVINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSTaskServerIdDirty() : !pSDBDevInstBK.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSDBDevInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isPSTaskServerNameDirty() : !pSDBDevInstBK.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDBDevInstBK.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSDBDevInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDBDevInstBK pSDBDevInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDBDevInstBK.isValidFlagDirty() && !bl2 : !pSDBDevInstBK.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDBDevInstBK.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDBDevInstBK, bl2, bl3);
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

    protected void onSyncEntity(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDBDevInstBK, bl);
    }

    protected void onSyncIndexEntities(PSDBDevInstBK pSDBDevInstBK, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDBDevInstBK, bl);
    }

    public Object getDataContextValue(PSDBDevInstBK pSDBDevInstBK, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDBDevInstBK, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDBDevInstBK pSDBDevInstBK, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDBDevInstBK, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BKFILEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKFilePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKFILESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKFileSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BKFilePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKFILEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BKFileSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BackupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_Passwd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected boolean onMergeChild(String string, String string2, PSDBDevInstBK pSDBDevInstBK) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDBDevInstBK)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDBDevInstBK pSDBDevInstBK) throws Exception {
        super.onUpdateParent((IEntity)pSDBDevInstBK);
    }

    @Override
    protected void exportCurXmlModel(PSDBDevInstBK pSDBDevInstBK, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDBDEVINSTBK");
        if (!bl) {
            pSDBDevInstBK.setCreateDate(null);
            pSDBDevInstBK.setCreateMan(null);
            pSDBDevInstBK.setPSDBDevInstBKId(null);
            pSDBDevInstBK.setUpdateDate(null);
            pSDBDevInstBK.setUpdateMan(null);
            super.exportCurXmlModel(pSDBDevInstBK, xmlNode, bl);
        }
    }
}

