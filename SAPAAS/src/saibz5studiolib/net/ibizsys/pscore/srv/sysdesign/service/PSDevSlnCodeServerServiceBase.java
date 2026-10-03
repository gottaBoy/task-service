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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServerBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCodeServerDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCodeServerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCodeServer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnCodeServerServiceBase
extends PSCoreSysServiceBase<PSDevSlnCodeServer> {
    private static final Log log = LogFactory.getLog(PSDevSlnCodeServerServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDevSlnCodeServerDEModel pSDevSlnCodeServerDEModel;
    private PSDevSlnCodeServerDAO pSDevSlnCodeServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCodeServerService";
    }

    public PSDevSlnCodeServerDEModel getPSDevSlnCodeServerDEModel() {
        if (this.pSDevSlnCodeServerDEModel == null) {
            try {
                this.pSDevSlnCodeServerDEModel = (PSDevSlnCodeServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCodeServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCodeServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnCodeServerDEModel();
    }

    public PSDevSlnCodeServerDAO getPSDevSlnCodeServerDAO() {
        if (this.pSDevSlnCodeServerDAO == null) {
            try {
                this.pSDevSlnCodeServerDAO = (PSDevSlnCodeServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCodeServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCodeServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnCodeServerDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDevSlnCodeServer pSDevSlnCodeServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNCODESERVER_PSDEVCENTERSERVER_PSDEVCENTERSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService", (SessionFactory)this.getSessionFactory());
            PSDevCenterServer pSDevCenterServer = (PSDevCenterServer)iService.getDEModel().createEntity();
            pSDevCenterServer.set("PSDEVCENTERSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterServer);
            } else {
                iService.get(pSDevCenterServer);
            }
            this.onFillParentInfo_PSDevCenterServer(pSDevSlnCodeServer, pSDevCenterServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNCODESERVER_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnCodeServer, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDevSlnCodeServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterServer(PSDevSlnCodeServer pSDevSlnCodeServer, PSDevCenterServer pSDevCenterServer) throws Exception {
        pSDevSlnCodeServer.setPSDevCenterServerId(pSDevCenterServer.getPSDevCenterServerId());
        pSDevSlnCodeServer.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnCodeServer pSDevSlnCodeServer, PSDevSln pSDevSln) throws Exception {
        pSDevSlnCodeServer.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnCodeServer.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDevSlnCodeServer, bl);
        this.onFillEntityFullInfo_PSDevCenterServer(pSDevSlnCodeServer, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnCodeServer, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterServer(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        if (pSDevSlnCodeServer.isPSDevCenterServerIdDirty()) {
            if (pSDevSlnCodeServer.getPSDevCenterServerId() != null) {
                if (pSDevSlnCodeServer.getPSDevCenterServerId() == null || pSDevSlnCodeServer.getPSDevCenterServerName() == null) {
                    PSDevCenterServer pSDevCenterServer = pSDevSlnCodeServer.getPSDevCenterServer();
                    pSDevSlnCodeServer.setPSDevCenterServerName(pSDevCenterServer.getPSDevCenterServerName());
                }
            } else {
                pSDevSlnCodeServer.setPSDevCenterServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnCodeServer, bl);
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, "", -1);
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string) throws Exception {
        return this.selectByPSDevCenterServer(pSDevCenterServerBase, string, -1);
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevCenterServer(PSDevCenterServerBase pSDevCenterServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSERVERID", (Object)pSDevCenterServerBase.getPSDevCenterServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterServerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnCodeServer> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSERVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterServer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNCODESERVER_PSDEVCENTERSERVER_PSDEVCENTERSERVERID", "", iDataEntityModel.getName(), "PSDEVSLNCODESERVER", iDataEntityModel.getDataInfo(pSDevCenterServer), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        for (PSDevSlnCodeServer pSDevSlnCodeServer : arrayList) {
            PSDevSlnCodeServer pSDevSlnCodeServer2 = (PSDevSlnCodeServer)this.getDEModel().createEntity();
            pSDevSlnCodeServer2.setPSDevSlnCodeServerId(pSDevSlnCodeServer.getPSDevSlnCodeServerId());
            pSDevSlnCodeServer2.setPSDevCenterServerId(null);
            this.update(pSDevSlnCodeServer2);
        }
    }

    public void removeByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        final PSDevCenterServer pSDevCenterServer2 = pSDevCenterServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnCodeServerServiceBase.this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDevSlnCodeServerServiceBase.this.internalRemoveByPSDevCenterServer(pSDevCenterServer2);
                PSDevSlnCodeServerServiceBase.this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void internalRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevCenterServer(pSDevCenterServer);
        this.onBeforeRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
        for (PSDevSlnCodeServer pSDevSlnCodeServer : arrayList) {
            this.remove(pSDevSlnCodeServer);
        }
        this.onAfterRemoveByPSDevCenterServer(pSDevCenterServer, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDevSlnCodeServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterServer(PSDevCenterServer pSDevCenterServer, ArrayList<PSDevSlnCodeServer> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNCODESERVER_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNCODESERVER", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnCodeServer pSDevSlnCodeServer : arrayList) {
            PSDevSlnCodeServer pSDevSlnCodeServer2 = (PSDevSlnCodeServer)this.getDEModel().createEntity();
            pSDevSlnCodeServer2.setPSDevSlnCodeServerId(pSDevSlnCodeServer.getPSDevSlnCodeServerId());
            pSDevSlnCodeServer2.setPSDevSlnId(null);
            this.update(pSDevSlnCodeServer2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnCodeServerServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnCodeServerServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnCodeServerServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnCodeServer> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnCodeServer pSDevSlnCodeServer : arrayList) {
            this.remove(pSDevSlnCodeServer);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnCodeServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnCodeServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        PSDevSlnUserCSService pSDevSlnUserCSService = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnUserCSService.testRemoveByPSDevSlnCodeServer(pSDevSlnCodeServer);
        super.onBeforeRemove(pSDevSlnCodeServer);
    }

    protected void replaceParentInfo(PSDevSlnCodeServer pSDevSlnCodeServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnCodeServer, cloneSession);
        if (pSDevSlnCodeServer.getPSDevCenterServerId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSERVER", (Object)pSDevSlnCodeServer.getPSDevCenterServerId())) != null) {
            this.onFillParentInfo_PSDevCenterServer(pSDevSlnCodeServer, (PSDevCenterServer)iEntity);
        }
        if (pSDevSlnCodeServer.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnCodeServer.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnCodeServer, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnCodeServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CSParam(bl, pSDevSlnCodeServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam2(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam3(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSParam4(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostPasswd(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HostUserName(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerId(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterServerName(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnCodeServerId(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnCodeServerName(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDevSlnCodeServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnCodeServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CSParam(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isCSParamDirty() : !pSDevSlnCodeServer.isCSParamDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getCSParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam2(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isCSParam2Dirty() : !pSDevSlnCodeServer.isCSParam2Dirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getCSParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSParam2_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam3(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isCSParam3Dirty() : !pSDevSlnCodeServer.isCSParam3Dirty()) {
            return null;
        }
        Integer n = pSDevSlnCodeServer.getCSParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam3_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSParam4(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isCSParam4Dirty() : !pSDevSlnCodeServer.isCSParam4Dirty()) {
            return null;
        }
        Integer n = pSDevSlnCodeServer.getCSParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CSParam4_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isExpriedTimeDirty() : !pSDevSlnCodeServer.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnCodeServer.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostPasswd(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isHostPasswdDirty() : !pSDevSlnCodeServer.isHostPasswdDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getHostPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostPasswd_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HostUserName(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isHostUserNameDirty() : !pSDevSlnCodeServer.isHostUserNameDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getHostUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HostUserName_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOSTUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isMemoDirty() : !pSDevSlnCodeServer.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnCodeServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterServerId(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isPSDevCenterServerIdDirty() : !pSDevSlnCodeServer.isPSDevCenterServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getPSDevCenterServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerId_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterServerName(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isPSDevCenterServerNameDirty() : !pSDevSlnCodeServer.isPSDevCenterServerNameDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getPSDevCenterServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterServerName_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnCodeServerId(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isPSDevSlnCodeServerIdDirty() && !bl2 : !pSDevSlnCodeServer.isPSDevSlnCodeServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getPSDevSlnCodeServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCODESERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnCodeServerId_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCODESERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnCodeServerName(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isPSDevSlnCodeServerNameDirty() && !bl2 : !pSDevSlnCodeServer.isPSDevSlnCodeServerNameDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getPSDevSlnCodeServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCODESERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnCodeServerName_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNCODESERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isPSDevSlnIdDirty() : !pSDevSlnCodeServer.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnCodeServer.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnCodeServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isResReadyTimeDirty() : !pSDevSlnCodeServer.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnCodeServer.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDevSlnCodeServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnCodeServer.isResStateDirty() : !pSDevSlnCodeServer.isResStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnCodeServer.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDevSlnCodeServer, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnCodeServer, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnCodeServer pSDevSlnCodeServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnCodeServer, bl);
    }

    public Object getDataContextValue(PSDevSlnCodeServer pSDevSlnCodeServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnCodeServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnCodeServer pSDevSlnCodeServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnCodeServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOSTUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HostUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCODESERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCodeServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNCODESERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnCodeServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CSParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CSParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HostPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HostUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HOSTUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_PSDevCenterServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnCodeServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCODESERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnCodeServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNCODESERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnCodeServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnCodeServer pSDevSlnCodeServer) throws Exception {
        super.onUpdateParent(pSDevSlnCodeServer);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnCodeServer pSDevSlnCodeServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNCODESERVER");
        if (!bl) {
            pSDevSlnCodeServer.setCreateDate(null);
            pSDevSlnCodeServer.setCreateMan(null);
            pSDevSlnCodeServer.setPSDevSlnCodeServerId(null);
            pSDevSlnCodeServer.setPSDevSlnName(null);
            pSDevSlnCodeServer.setUpdateDate(null);
            pSDevSlnCodeServer.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnCodeServer, xmlNode, bl);
        }
    }
}

