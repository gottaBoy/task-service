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
import net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspaceLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspaceLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspaceLogServiceBase
extends PSCoreSysServiceBase<PSWorkspaceLog> {
    private static final Log log = LogFactory.getLog(PSWorkspaceLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWorkspaceLogDEModel pSWorkspaceLogDEModel;
    private PSWorkspaceLogDAO pSWorkspaceLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceLogService";
    }

    public PSWorkspaceLogDEModel getPSWorkspaceLogDEModel() {
        if (this.pSWorkspaceLogDEModel == null) {
            try {
                this.pSWorkspaceLogDEModel = (PSWorkspaceLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspaceLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspaceLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWorkspaceLogDEModel();
    }

    public PSWorkspaceLogDAO getPSWorkspaceLogDAO() {
        if (this.pSWorkspaceLogDAO == null) {
            try {
                this.pSWorkspaceLogDAO = (PSWorkspaceLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspaceLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspaceLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWorkspaceLogDAO();
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

    protected void onFillParentInfo(PSWorkspaceLog pSWorkspaceLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKSPACELOG_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSWorkspaceLog, pSSvrDomain);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKSPACELOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSWorkspaceLog, pSTaskServer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKSPACELOG_PSWORKSPACE_PSWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSWorkspace pSWorkspace = (PSWorkspace)iService.getDEModel().createEntity();
            pSWorkspace.set("PSWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkspace);
            } else {
                iService.get(pSWorkspace);
            }
            this.onFillParentInfo_PSWorkspace(pSWorkspaceLog, pSWorkspace);
            return;
        }
        super.onFillParentInfo(pSWorkspaceLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSvrDomain(PSWorkspaceLog pSWorkspaceLog, PSSvrDomain pSSvrDomain) throws Exception {
        pSWorkspaceLog.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSWorkspaceLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillParentInfo_PSTaskServer(PSWorkspaceLog pSWorkspaceLog, PSTaskServer pSTaskServer) throws Exception {
        pSWorkspaceLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSWorkspaceLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillParentInfo_PSWorkspace(PSWorkspaceLog pSWorkspaceLog, PSWorkspace pSWorkspace) throws Exception {
        pSWorkspaceLog.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        pSWorkspaceLog.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
    }

    protected void onFillEntityFullInfo(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWorkspaceLog, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSWorkspaceLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSWorkspaceLog, bl);
        this.onFillEntityFullInfo_PSWorkspace(pSWorkspaceLog, bl);
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        if (pSWorkspaceLog.isPSSvrDomainIdDirty()) {
            if (pSWorkspaceLog.getPSSvrDomainId() != null) {
                if (pSWorkspaceLog.getPSSvrDomainId() == null || pSWorkspaceLog.getPSSvrDomainName() == null) {
                    PSSvrDomain pSSvrDomain = pSWorkspaceLog.getPSSvrDomain();
                    pSWorkspaceLog.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
                }
            } else {
                pSWorkspaceLog.setPSSvrDomainName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        if (pSWorkspaceLog.isPSTaskServerIdDirty()) {
            if (pSWorkspaceLog.getPSTaskServerId() != null) {
                if (pSWorkspaceLog.getPSTaskServerId() == null || pSWorkspaceLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSWorkspaceLog.getPSTaskServer();
                    pSWorkspaceLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSWorkspaceLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWorkspace(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        if (pSWorkspaceLog.isPSWorkspaceIdDirty()) {
            if (pSWorkspaceLog.getPSWorkspaceId() != null) {
                if (pSWorkspaceLog.getPSWorkspaceId() == null || pSWorkspaceLog.getPSWorkspaceName() == null) {
                    PSWorkspace pSWorkspace = pSWorkspaceLog.getPSWorkspace();
                    pSWorkspaceLog.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
                }
            } else {
                pSWorkspaceLog.setPSWorkspaceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSWorkspaceLog, bl);
    }

    public ArrayList<PSWorkspaceLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSVRDOMAINID", (Object)pSSvrDomainBase.getPSSvrDomainId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSvrDomainCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSvrDomainCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWorkspaceLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public ArrayList<PSWorkspaceLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, "", -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, string, -1);
    }

    public ArrayList<PSWorkspaceLog> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWORKSPACEID", (Object)pSWorkspaceBase.getPSWorkspaceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWorkspaceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWorkspaceCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            PSWorkspaceLog pSWorkspaceLog2 = (PSWorkspaceLog)this.getDEModel().createEntity();
            pSWorkspaceLog2.setPSWorkspaceLogId(pSWorkspaceLog.getPSWorkspaceLogId());
            pSWorkspaceLog2.setPSSvrDomainId(null);
            this.update(pSWorkspaceLog2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkspaceLogServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSWorkspaceLogServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSWorkspaceLogServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            this.remove(pSWorkspaceLog);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            PSWorkspaceLog pSWorkspaceLog2 = (PSWorkspaceLog)this.getDEModel().createEntity();
            pSWorkspaceLog2.setPSWorkspaceLogId(pSWorkspaceLog.getPSWorkspaceLogId());
            pSWorkspaceLog2.setPSTaskServerId(null);
            this.update(pSWorkspaceLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkspaceLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSWorkspaceLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSWorkspaceLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            this.remove(pSWorkspaceLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    public void testRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    public void resetPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSWorkspace(pSWorkspace);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            PSWorkspaceLog pSWorkspaceLog2 = (PSWorkspaceLog)this.getDEModel().createEntity();
            pSWorkspaceLog2.setPSWorkspaceLogId(pSWorkspaceLog.getPSWorkspaceLogId());
            pSWorkspaceLog2.setPSWorkspaceId(null);
            this.update(pSWorkspaceLog2);
        }
    }

    public void removeByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        final PSWorkspace pSWorkspace2 = pSWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkspaceLogServiceBase.this.onBeforeRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspaceLogServiceBase.this.internalRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspaceLogServiceBase.this.onAfterRemoveByPSWorkspace(pSWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void internalRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWorkspaceLog> arrayList = this.selectByPSWorkspace(pSWorkspace);
        this.onBeforeRemoveByPSWorkspace(pSWorkspace, arrayList);
        for (PSWorkspaceLog pSWorkspaceLog : arrayList) {
            this.remove(pSWorkspaceLog);
        }
        this.onAfterRemoveByPSWorkspace(pSWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspaceLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWorkspaceLog pSWorkspaceLog) throws Exception {
        super.onBeforeRemove(pSWorkspaceLog);
    }

    protected void replaceParentInfo(PSWorkspaceLog pSWorkspaceLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWorkspaceLog, cloneSession);
        if (pSWorkspaceLog.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSWorkspaceLog.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSWorkspaceLog, (PSSvrDomain)iEntity);
        }
        if (pSWorkspaceLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSWorkspaceLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSWorkspaceLog, (PSTaskServer)iEntity);
        }
        if (pSWorkspaceLog.getPSWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSWORKSPACE", (Object)pSWorkspaceLog.getPSWorkspaceId())) != null) {
            this.onFillParentInfo_PSWorkspace(pSWorkspaceLog, (PSWorkspace)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWorkspaceLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogInfo(bl, pSWorkspaceLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogType(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainName(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceId(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceLogId(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceLogName(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceName(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWorkspaceLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWorkspaceLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isLogInfoDirty() : !pSWorkspaceLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogLevel(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isLogLevelDirty() : !pSWorkspaceLog.isLogLevelDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getLogLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogLevel_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isLogLevel2Dirty() : !pSWorkspaceLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSWorkspaceLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogType(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isLogTypeDirty() && !bl2 : !pSWorkspaceLog.isLogTypeDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getLogType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogType_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSSvrDomainIdDirty() : !pSWorkspaceLog.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainName(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSSvrDomainNameDirty() : !pSWorkspaceLog.isPSSvrDomainNameDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSSvrDomainName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainName_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSTaskServerIdDirty() : !pSWorkspaceLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSTaskServerNameDirty() : !pSWorkspaceLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSWorkspaceLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceId(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSWorkspaceIdDirty() : !pSWorkspaceLog.isPSWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceId_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceLogId(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSWorkspaceLogIdDirty() && !bl2 : !pSWorkspaceLog.isPSWorkspaceLogIdDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSWorkspaceLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACELOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceLogId_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACELOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceLogName(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSWorkspaceLogNameDirty() && !bl2 : !pSWorkspaceLog.isPSWorkspaceLogNameDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSWorkspaceLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACELOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceLogName_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACELOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceName(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isPSWorkspaceNameDirty() : !pSWorkspaceLog.isPSWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getPSWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceName_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isUserTagDirty() : !pSWorkspaceLog.isUserTagDirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isUserTag2Dirty() : !pSWorkspaceLog.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isUserTag3Dirty() : !pSWorkspaceLog.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWorkspaceLog pSWorkspaceLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceLog.isUserTag4Dirty() : !pSWorkspaceLog.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWorkspaceLog.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWorkspaceLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        super.onSyncEntity(pSWorkspaceLog, bl);
    }

    protected void onSyncIndexEntities(PSWorkspaceLog pSWorkspaceLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWorkspaceLog, bl);
    }

    public Object getDataContextValue(PSWorkspaceLog pSWorkspaceLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWorkspaceLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWorkspaceLog pSWorkspaceLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWorkspaceLog, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LOGLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACELOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACELOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("LOGTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrDomainId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSvrDomainName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSVRDOMAINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspaceLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACELOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspaceLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACELOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspaceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSWorkspaceLog pSWorkspaceLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWorkspaceLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWorkspaceLog pSWorkspaceLog) throws Exception {
        super.onUpdateParent(pSWorkspaceLog);
    }

    @Override
    protected void exportCurXmlModel(PSWorkspaceLog pSWorkspaceLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWORKSPACELOG");
        if (!bl) {
            pSWorkspaceLog.setCreateDate(null);
            pSWorkspaceLog.setCreateMan(null);
            pSWorkspaceLog.setLogLevel2(null);
            pSWorkspaceLog.setPSWorkspaceLogId(null);
            pSWorkspaceLog.setUpdateDate(null);
            pSWorkspaceLog.setUpdateMan(null);
            super.exportCurXmlModel(pSWorkspaceLog, xmlNode, bl);
        }
    }
}

