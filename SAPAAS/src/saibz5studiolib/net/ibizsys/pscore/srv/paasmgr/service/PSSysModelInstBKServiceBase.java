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
import net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstBKDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstBKDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstBKServiceBase
extends PSCoreSysServiceBase<PSSysModelInstBK> {
    private static final Log log = LogFactory.getLog(PSSysModelInstBKServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysModelInstBKDEModel pSSysModelInstBKDEModel;
    private PSSysModelInstBKDAO pSSysModelInstBKDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstBKService";
    }

    public PSSysModelInstBKDEModel getPSSysModelInstBKDEModel() {
        if (this.pSSysModelInstBKDEModel == null) {
            try {
                this.pSSysModelInstBKDEModel = (PSSysModelInstBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSSysModelInstBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstBKDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysModelInstBKDEModel();
    }

    public PSSysModelInstBKDAO getPSSysModelInstBKDAO() {
        if (this.pSSysModelInstBKDAO == null) {
            try {
                this.pSSysModelInstBKDAO = (PSSysModelInstBKDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSSysModelInstBKDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelInstBKDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysModelInstBKDAO();
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

    protected void onFillParentInfo(PSSysModelInstBK pSSysModelInstBK, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINSTBK_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelInst);
            } else {
                iService.get(pSSysModelInst);
            }
            this.onFillParentInfo_Pssysmodelinst(pSSysModelInstBK, pSSysModelInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSMODELINSTBK_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSSysModelInstBK, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSSysModelInstBK, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssysmodelinst(PSSysModelInstBK pSSysModelInstBK, PSSysModelInst pSSysModelInst) throws Exception {
        pSSysModelInstBK.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSSysModelInstBK.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillParentInfo_PSTaskServer(PSSysModelInstBK pSSysModelInstBK, PSTaskServer pSTaskServer) throws Exception {
        pSSysModelInstBK.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSSysModelInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        if (bl) {
            if (pSSysModelInstBK.getBKState() == null) {
                pSSysModelInstBK.setBKState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSSysModelInstBK.getValidFlag() == null) {
                pSSysModelInstBK.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysModelInstBK, bl);
        this.onFillEntityFullInfo_Pssysmodelinst(pSSysModelInstBK, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSSysModelInstBK, bl);
    }

    protected void onFillEntityFullInfo_Pssysmodelinst(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        if (pSSysModelInstBK.isPSSysModelInstIdDirty()) {
            if (pSSysModelInstBK.getPSSysModelInstId() != null) {
                if (pSSysModelInstBK.getPSSysModelInstId() == null || pSSysModelInstBK.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSSysModelInstBK.getPssysmodelinst();
                    pSSysModelInstBK.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                }
            } else {
                pSSysModelInstBK.setPSSysModelInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        if (pSSysModelInstBK.isPSTaskServerIdDirty()) {
            if (pSSysModelInstBK.getPSTaskServerId() != null) {
                if (pSSysModelInstBK.getPSTaskServerId() == null || pSSysModelInstBK.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSSysModelInstBK.getPSTaskServer();
                    pSSysModelInstBK.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSSysModelInstBK.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysModelInstBK, bl);
    }

    public ArrayList<PSSysModelInstBK> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPssysmodelinst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSSysModelInstBK> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPssysmodelinst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSSysModelInstBK> selectByPssysmodelinst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysmodelinstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysmodelinstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysModelInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSSysModelInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSSysModelInstBK> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    public void resetPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInstBK> arrayList = this.selectByPssysmodelinst(pSSysModelInst);
        for (PSSysModelInstBK pSSysModelInstBK : arrayList) {
            PSSysModelInstBK pSSysModelInstBK2 = (PSSysModelInstBK)this.getDEModel().createEntity();
            pSSysModelInstBK2.setPSSysModelInstBKId(pSSysModelInstBK.getPSSysModelInstBKId());
            pSSysModelInstBK2.setPSSysModelInstId(null);
            this.update(pSSysModelInstBK2);
        }
    }

    public void removeByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstBKServiceBase.this.onBeforeRemoveByPssysmodelinst(pSSysModelInst2);
                PSSysModelInstBKServiceBase.this.internalRemoveByPssysmodelinst(pSSysModelInst2);
                PSSysModelInstBKServiceBase.this.onAfterRemoveByPssysmodelinst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSSysModelInstBK> arrayList = this.selectByPssysmodelinst(pSSysModelInst);
        this.onBeforeRemoveByPssysmodelinst(pSSysModelInst, arrayList);
        for (PSSysModelInstBK pSSysModelInstBK : arrayList) {
            this.remove(pSSysModelInstBK);
        }
        this.onAfterRemoveByPssysmodelinst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysmodelinst(PSSysModelInst pSSysModelInst, ArrayList<PSSysModelInstBK> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSSysModelInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSSysModelInstBK pSSysModelInstBK : arrayList) {
            PSSysModelInstBK pSSysModelInstBK2 = (PSSysModelInstBK)this.getDEModel().createEntity();
            pSSysModelInstBK2.setPSSysModelInstBKId(pSSysModelInstBK.getPSSysModelInstBKId());
            pSSysModelInstBK2.setPSTaskServerId(null);
            this.update(pSSysModelInstBK2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysModelInstBKServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSSysModelInstBKServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSSysModelInstBKServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSSysModelInstBK> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSSysModelInstBK pSSysModelInstBK : arrayList) {
            this.remove(pSSysModelInstBK);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSSysModelInstBK> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSSysModelInstBK> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysModelInstBK pSSysModelInstBK) throws Exception {
        super.onBeforeRemove(pSSysModelInstBK);
    }

    protected void replaceParentInfo(PSSysModelInstBK pSSysModelInstBK, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysModelInstBK, cloneSession);
        if (pSSysModelInstBK.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSSysModelInstBK.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_Pssysmodelinst(pSSysModelInstBK, (PSSysModelInst)iEntity);
        }
        if (pSSysModelInstBK.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSSysModelInstBK.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSSysModelInstBK, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysModelInstBK, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BKFilePath(bl, pSSysModelInstBK, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKFileSize(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKInfo(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKState(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKTime(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstBKId(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstBKName(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysModelInstBK, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysModelInstBK, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BKFilePath(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isBKFilePathDirty() : !pSSysModelInstBK.isBKFilePathDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getBKFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKFilePath_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKFileSize(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isBKFileSizeDirty() : !pSSysModelInstBK.isBKFileSizeDirty()) {
            return null;
        }
        Integer n = pSSysModelInstBK.getBKFileSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BKFileSize_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKInfo(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isBKInfoDirty() : !pSSysModelInstBK.isBKInfoDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getBKInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKInfo_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKState(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isBKStateDirty() && !bl2 : !pSSysModelInstBK.isBKStateDirty()) {
            return null;
        }
        Integer n = pSSysModelInstBK.getBKState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BKState_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_BKTime(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isBKTimeDirty() : !pSSysModelInstBK.isBKTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysModelInstBK.getBKTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BKTime_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isMemoDirty() : !pSSysModelInstBK.isMemoDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPasswdDirty() : !pSSysModelInstBK.isPasswdDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstBKId(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSSysModelInstBKIdDirty() && !bl2 : !pSSysModelInstBK.isPSSysModelInstBKIdDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSSysModelInstBKId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTBKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstBKId_Default(pSSysModelInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTBKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstBKName(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSSysModelInstBKNameDirty() && !bl2 : !pSSysModelInstBK.isPSSysModelInstBKNameDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSSysModelInstBKName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTBKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstBKName_Default(pSSysModelInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTBKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSSysModelInstIdDirty() : !pSSysModelInstBK.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default(pSSysModelInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSSysModelInstNameDirty() : !pSSysModelInstBK.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default(pSSysModelInstBK, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSTaskServerIdDirty() : !pSSysModelInstBK.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isPSTaskServerNameDirty() : !pSSysModelInstBK.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSSysModelInstBK.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSSysModelInstBK, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysModelInstBK pSSysModelInstBK, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysModelInstBK.isValidFlagDirty() && !bl2 : !pSSysModelInstBK.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysModelInstBK.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysModelInstBK, bl2, bl3);
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

    protected void onSyncEntity(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        super.onSyncEntity(pSSysModelInstBK, bl);
    }

    protected void onSyncIndexEntities(PSSysModelInstBK pSSysModelInstBK, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysModelInstBK, bl);
    }

    public Object getDataContextValue(PSSysModelInstBK pSSysModelInstBK, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysModelInstBK, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysModelInstBK pSSysModelInstBK, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysModelInstBK, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTBKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstBKId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTBKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstBKName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSysModelInstBKId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTBKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstBKName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTBKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysModelInstBK pSSysModelInstBK) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysModelInstBK)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysModelInstBK pSSysModelInstBK) throws Exception {
        super.onUpdateParent(pSSysModelInstBK);
    }

    @Override
    protected void exportCurXmlModel(PSSysModelInstBK pSSysModelInstBK, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSMODELINSTBK");
        if (!bl) {
            pSSysModelInstBK.setCreateDate(null);
            pSSysModelInstBK.setCreateMan(null);
            pSSysModelInstBK.setPSSysModelInstBKId(null);
            pSSysModelInstBK.setUpdateDate(null);
            pSSysModelInstBK.setUpdateMan(null);
            super.exportCurXmlModel(pSSysModelInstBK, xmlNode, bl);
        }
    }
}

