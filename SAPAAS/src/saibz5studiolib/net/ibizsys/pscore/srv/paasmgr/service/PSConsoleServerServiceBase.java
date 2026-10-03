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
import net.ibizsys.pscore.srv.paasmgr.dao.PSConsoleServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSConsoleServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSConsoleServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSConsoleServerServiceBase
extends PSCoreSysServiceBase<PSConsoleServer> {
    private static final Log log = LogFactory.getLog(PSConsoleServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSConsoleServerDEModel pSConsoleServerDEModel;
    private PSConsoleServerDAO pSConsoleServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSConsoleServerService";
    }

    public PSConsoleServerDEModel getPSConsoleServerDEModel() {
        if (this.pSConsoleServerDEModel == null) {
            try {
                this.pSConsoleServerDEModel = (PSConsoleServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSConsoleServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSConsoleServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSConsoleServerDEModel();
    }

    public PSConsoleServerDAO getPSConsoleServerDAO() {
        if (this.pSConsoleServerDAO == null) {
            try {
                this.pSConsoleServerDAO = (PSConsoleServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSConsoleServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSConsoleServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSConsoleServerDAO();
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

    protected void onFillParentInfo(PSConsoleServer pSConsoleServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCONSOLESERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSConsoleServer, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSConsoleServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSvrDomain(PSConsoleServer pSConsoleServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSConsoleServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSConsoleServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSConsoleServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSConsoleServer, bl);
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSConsoleServer, bl);
    }

    public ArrayList<PSConsoleServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSConsoleServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSConsoleServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSConsoleServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCONSOLESERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSCONSOLESERVER", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSConsoleServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSConsoleServer pSConsoleServer : arrayList) {
            PSConsoleServer pSConsoleServer2 = (PSConsoleServer)this.getDEModel().createEntity();
            pSConsoleServer2.setPSConsoleServerId(pSConsoleServer.getPSConsoleServerId());
            pSConsoleServer2.setPSSvrDomainId(null);
            this.update(pSConsoleServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSConsoleServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSConsoleServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSConsoleServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSConsoleServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSConsoleServer pSConsoleServer : arrayList) {
            this.remove(pSConsoleServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSConsoleServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSConsoleServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSConsoleServer pSConsoleServer) throws Exception {
        super.onBeforeRemove(pSConsoleServer);
    }

    protected void replaceParentInfo(PSConsoleServer pSConsoleServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSConsoleServer, cloneSession);
        if (pSConsoleServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSConsoleServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSConsoleServer, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSConsoleServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CSState(bl, pSConsoleServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpAddress(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IPPort(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSConsoleServerId(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSConsoleServerName(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSConsoleServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSConsoleServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CSState(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isCSStateDirty() && !bl2 : !pSConsoleServer.isCSStateDirty()) {
            return null;
        }
        Integer n = pSConsoleServer.getCSState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_CSState_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpAddress(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isHttpAddressDirty() : !pSConsoleServer.isHttpAddressDirty()) {
            return null;
        }
        String string = pSConsoleServer.getHttpAddress();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HttpAddress_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPADDRESS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isHttpPortDirty() && !bl2 : !pSConsoleServer.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSConsoleServer.getHttpPort();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isIpAddrDirty() && !bl2 : !pSConsoleServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSConsoleServer.getIpAddr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IPPort(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isIPPortDirty() && !bl2 : !pSConsoleServer.isIPPortDirty()) {
            return null;
        }
        Integer n = pSConsoleServer.getIPPort();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPPORT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_IPPort_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isMemoDirty() : !pSConsoleServer.isMemoDirty()) {
            return null;
        }
        String string = pSConsoleServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSConsoleServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSConsoleServerId(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isPSConsoleServerIdDirty() && !bl2 : !pSConsoleServer.isPSConsoleServerIdDirty()) {
            return null;
        }
        String string = pSConsoleServer.getPSConsoleServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSConsoleServerId_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSConsoleServerName(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isPSConsoleServerNameDirty() && !bl2 : !pSConsoleServer.isPSConsoleServerNameDirty()) {
            return null;
        }
        String string = pSConsoleServer.getPSConsoleServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSConsoleServerName_Default(pSConsoleServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCONSOLESERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSConsoleServer pSConsoleServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSConsoleServer.isPSSvrDomainIdDirty() : !pSConsoleServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSConsoleServer.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSConsoleServer, bl2, bl3);
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

    protected void onSyncEntity(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
        super.onSyncEntity(pSConsoleServer, bl);
    }

    protected void onSyncIndexEntities(PSConsoleServer pSConsoleServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSConsoleServer, bl);
    }

    public Object getDataContextValue(PSConsoleServer pSConsoleServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSConsoleServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSConsoleServer pSConsoleServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSConsoleServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPADDRESS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpAddress_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IPPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCONSOLESERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSConsoleServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCONSOLESERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSConsoleServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CSState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HttpAddress_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTTPADDRESS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IpAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IPPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSConsoleServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCONSOLESERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSConsoleServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCONSOLESERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSConsoleServer pSConsoleServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSConsoleServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSConsoleServer pSConsoleServer) throws Exception {
        super.onUpdateParent(pSConsoleServer);
    }

    @Override
    protected void exportCurXmlModel(PSConsoleServer pSConsoleServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCONSOLESERVER");
        if (!bl) {
            pSConsoleServer.setCreateDate(null);
            pSConsoleServer.setCreateMan(null);
            pSConsoleServer.setPSConsoleServerId(null);
            pSConsoleServer.setPSSvrDomainName(null);
            pSConsoleServer.setUpdateDate(null);
            pSConsoleServer.setUpdateMan(null);
            super.exportCurXmlModel(pSConsoleServer, xmlNode, bl);
        }
    }
}

