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
import net.ibizsys.pscore.srv.paasmgr.dao.PSMavenServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSMavenServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMavenRepoService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMavenServerServiceBase
extends PSCoreSysServiceBase<PSMavenServer> {
    private static final Log log = LogFactory.getLog(PSMavenServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMavenServerDEModel pSMavenServerDEModel;
    private PSMavenServerDAO pSMavenServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSMavenServerService";
    }

    public PSMavenServerDEModel getPSMavenServerDEModel() {
        if (this.pSMavenServerDEModel == null) {
            try {
                this.pSMavenServerDEModel = (PSMavenServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSMavenServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMavenServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMavenServerDEModel();
    }

    public PSMavenServerDAO getPSMavenServerDAO() {
        if (this.pSMavenServerDAO == null) {
            try {
                this.pSMavenServerDAO = (PSMavenServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSMavenServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMavenServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMavenServerDAO();
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

    protected void onFillParentInfo(PSMavenServer pSMavenServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMAVENSERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSMavenServer, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSMavenServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSvrDomain(PSMavenServer pSMavenServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSMavenServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSMavenServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSMavenServer pSMavenServer, boolean bl) throws Exception {
        if (bl && pSMavenServer.getValidFlag() == null) {
            pSMavenServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSMavenServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSMavenServer, bl);
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSMavenServer pSMavenServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSMavenServer pSMavenServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSMavenServer, bl);
    }

    public ArrayList<PSMavenServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSMavenServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSMavenServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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
        ArrayList<PSMavenServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMAVENSERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSMAVENSERVER", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSMavenServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSMavenServer pSMavenServer : arrayList) {
            PSMavenServer pSMavenServer2 = (PSMavenServer)this.getDEModel().createEntity();
            pSMavenServer2.setPSMavenServerId(pSMavenServer.getPSMavenServerId());
            pSMavenServer2.setPSSvrDomainId(null);
            this.update(pSMavenServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMavenServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSMavenServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSMavenServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSMavenServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSMavenServer pSMavenServer : arrayList) {
            this.remove(pSMavenServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSMavenServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSMavenServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMavenServer pSMavenServer) throws Exception {
        PSMavenRepoService pSMavenRepoService = (PSMavenRepoService)ServiceGlobal.getService(PSMavenRepoService.class, (SessionFactory)this.getSessionFactory());
        pSMavenRepoService.testRemoveByPSMavenServer(pSMavenServer);
        super.onBeforeRemove(pSMavenServer);
    }

    protected void replaceParentInfo(PSMavenServer pSMavenServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMavenServer, cloneSession);
        if (pSMavenServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSMavenServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSMavenServer, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMavenServer pSMavenServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMavenServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_APIPath(bl, pSMavenServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenPasswd(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenServerType(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenUrl(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MavenUserName(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMavenServerId(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMavenServerName(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSMavenServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMavenServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_APIPath(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isAPIPathDirty() && !bl2 : !pSMavenServer.isAPIPathDirty()) {
            return null;
        }
        String string = pSMavenServer.getAPIPath();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APIPATH");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_APIPath_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APIPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isIpAddrDirty() && !bl2 : !pSMavenServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSMavenServer.getIpAddr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSMavenServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isIpAddr2Dirty() : !pSMavenServer.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSMavenServer.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenPasswd(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isMavenPasswdDirty() : !pSMavenServer.isMavenPasswdDirty()) {
            return null;
        }
        String string = pSMavenServer.getMavenPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenPasswd_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenServerType(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isMavenServerTypeDirty() && !bl2 : !pSMavenServer.isMavenServerTypeDirty()) {
            return null;
        }
        String string = pSMavenServer.getMavenServerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENSERVERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenServerType_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENSERVERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenUrl(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isMavenUrlDirty() && !bl2 : !pSMavenServer.isMavenUrlDirty()) {
            return null;
        }
        String string = pSMavenServer.getMavenUrl();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENURL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenUrl_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MavenUserName(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isMavenUserNameDirty() : !pSMavenServer.isMavenUserNameDirty()) {
            return null;
        }
        String string = pSMavenServer.getMavenUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MavenUserName_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAVENUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isMemoDirty() : !pSMavenServer.isMemoDirty()) {
            return null;
        }
        String string = pSMavenServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMavenServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isPasswdDirty() : !pSMavenServer.isPasswdDirty()) {
            return null;
        }
        String string = pSMavenServer.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSMavenServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isPortDirty() : !pSMavenServer.isPortDirty()) {
            return null;
        }
        Integer n = pSMavenServer.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMavenServerId(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isPSMavenServerIdDirty() && !bl2 : !pSMavenServer.isPSMavenServerIdDirty()) {
            return null;
        }
        String string = pSMavenServer.getPSMavenServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMAVENSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMavenServerId_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMAVENSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMavenServerName(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isPSMavenServerNameDirty() && !bl2 : !pSMavenServer.isPSMavenServerNameDirty()) {
            return null;
        }
        String string = pSMavenServer.getPSMavenServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMAVENSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMavenServerName_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMAVENSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isPSSvrDomainIdDirty() : !pSMavenServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSMavenServer.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSMavenServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isUserNameDirty() : !pSMavenServer.isUserNameDirty()) {
            return null;
        }
        String string = pSMavenServer.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSMavenServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSMavenServer pSMavenServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMavenServer.isValidFlagDirty() && !bl2 : !pSMavenServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSMavenServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSMavenServer, bl2, bl3);
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

    protected void onSyncEntity(PSMavenServer pSMavenServer, boolean bl) throws Exception {
        super.onSyncEntity(pSMavenServer, bl);
    }

    protected void onSyncIndexEntities(PSMavenServer pSMavenServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMavenServer, bl);
    }

    public Object getDataContextValue(PSMavenServer pSMavenServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMavenServer, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMavenServer pSMavenServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMavenServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APIPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENSERVERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenServerType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAVENUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MavenUserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMAVENSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMavenServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMAVENSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMavenServerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_APIPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APIPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_IpAddr2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IPADDR2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MavenPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENPASSWD", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MavenServerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENSERVERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MavenUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MavenUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAVENUSERNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_Port_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSMavenServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMAVENSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMavenServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMAVENSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSMavenServer pSMavenServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMavenServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMavenServer pSMavenServer) throws Exception {
        super.onUpdateParent(pSMavenServer);
    }

    @Override
    protected void exportCurXmlModel(PSMavenServer pSMavenServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMAVENSERVER");
        if (!bl) {
            pSMavenServer.setCreateDate(null);
            pSMavenServer.setCreateMan(null);
            pSMavenServer.setPSMavenServerId(null);
            pSMavenServer.setPSSvrDomainName(null);
            pSMavenServer.setUpdateDate(null);
            pSMavenServer.setUpdateMan(null);
            super.exportCurXmlModel(pSMavenServer, xmlNode, bl);
        }
    }
}

