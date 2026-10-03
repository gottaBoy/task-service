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
import net.ibizsys.pscore.srv.devcenter.service.PSDCDeployServerService;
import net.ibizsys.pscore.srv.paasmgr.dao.PSDeployServerDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSDeployServerDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenter;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDeployServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDeployServerServiceBase
extends PSCoreSysServiceBase<PSDeployServer> {
    private static final Log log = LogFactory.getLog(PSDeployServerServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDeployServerDEModel pSDeployServerDEModel;
    private PSDeployServerDAO pSDeployServerDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSDeployServerService";
    }

    public PSDeployServerDEModel getPSDeployServerDEModel() {
        if (this.pSDeployServerDEModel == null) {
            try {
                this.pSDeployServerDEModel = (PSDeployServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSDeployServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDeployServerDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDeployServerDEModel();
    }

    public PSDeployServerDAO getPSDeployServerDAO() {
        if (this.pSDeployServerDAO == null) {
            try {
                this.pSDeployServerDAO = (PSDeployServerDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSDeployServerDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDeployServerDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDeployServerDAO();
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

    protected void onFillParentInfo(PSDeployServer pSDeployServer, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPLOYSERVER_PSDEPLOYCENTER_PSDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDeployCenter pSDeployCenter = (PSDeployCenter)iService.getDEModel().createEntity();
            pSDeployCenter.set("PSDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDeployCenter);
            } else {
                iService.get(pSDeployCenter);
            }
            this.onFillParentInfo_PSDeployCenter(pSDeployServer, pSDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPLOYSERVER_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSDeployServer, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSDeployServer, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDeployCenter(PSDeployServer pSDeployServer, PSDeployCenter pSDeployCenter) throws Exception {
        pSDeployServer.setPSDeployCenterId(pSDeployCenter.getPSDeployCenterId());
        pSDeployServer.setPSDeployCenterName(pSDeployCenter.getPSDeployCenterName());
    }

    protected void onFillParentInfo_PSSvrDomain(PSDeployServer pSDeployServer, PSSvrDomain pSSvrDomain) throws Exception {
        pSDeployServer.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSDeployServer.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        if (bl && pSDeployServer.getValidFlag() == null) {
            pSDeployServer.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDeployServer, bl);
        this.onFillEntityFullInfo_PSDeployCenter(pSDeployServer, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSDeployServer, bl);
    }

    protected void onFillEntityFullInfo_PSDeployCenter(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        if (pSDeployServer.isPSDeployCenterIdDirty()) {
            if (pSDeployServer.getPSDeployCenterId() != null) {
                if (pSDeployServer.getPSDeployCenterId() == null || pSDeployServer.getPSDeployCenterName() == null) {
                    PSDeployCenter pSDeployCenter = pSDeployServer.getPSDeployCenter();
                    pSDeployServer.setPSDeployCenterName(pSDeployCenter.getPSDeployCenterName());
                }
            } else {
                pSDeployServer.setPSDeployCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSDeployServer pSDeployServer, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        super.onWriteBackParent(pSDeployServer, bl);
    }

    public ArrayList<PSDeployServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, "", -1);
    }

    public ArrayList<PSDeployServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string) throws Exception {
        return this.selectByPSDeployCenter(pSDeployCenterBase, string, -1);
    }

    public ArrayList<PSDeployServer> selectByPSDeployCenter(PSDeployCenterBase pSDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPLOYCENTERID", (Object)pSDeployCenterBase.getPSDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDeployServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSDeployServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSDeployServer> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPLOYSERVER_PSDEPLOYCENTER_PSDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDEPLOYSERVER", iDataEntityModel.getDataInfo(pSDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        for (PSDeployServer pSDeployServer : arrayList) {
            PSDeployServer pSDeployServer2 = (PSDeployServer)this.getDEModel().createEntity();
            pSDeployServer2.setPSDeployServerId(pSDeployServer.getPSDeployServerId());
            pSDeployServer2.setPSDeployCenterId(null);
            this.update(pSDeployServer2);
        }
    }

    public void removeByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        final PSDeployCenter pSDeployCenter2 = pSDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDeployServerServiceBase.this.onBeforeRemoveByPSDeployCenter(pSDeployCenter2);
                PSDeployServerServiceBase.this.internalRemoveByPSDeployCenter(pSDeployCenter2);
                PSDeployServerServiceBase.this.onAfterRemoveByPSDeployCenter(pSDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSDeployCenter(pSDeployCenter);
        this.onBeforeRemoveByPSDeployCenter(pSDeployCenter, arrayList);
        for (PSDeployServer pSDeployServer : arrayList) {
            this.remove(pSDeployServer);
        }
        this.onAfterRemoveByPSDeployCenter(pSDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSDeployServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDeployCenter(PSDeployCenter pSDeployCenter, ArrayList<PSDeployServer> arrayList) throws Exception {
    }

    public void testRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPLOYSERVER_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSDEPLOYSERVER", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSDeployServer pSDeployServer : arrayList) {
            PSDeployServer pSDeployServer2 = (PSDeployServer)this.getDEModel().createEntity();
            pSDeployServer2.setPSDeployServerId(pSDeployServer.getPSDeployServerId());
            pSDeployServer2.setPSSvrDomainId(null);
            this.update(pSDeployServer2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDeployServerServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSDeployServerServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSDeployServerServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSDeployServer> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSDeployServer pSDeployServer : arrayList) {
            this.remove(pSDeployServer);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDeployServer> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSDeployServer> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDeployServer pSDeployServer) throws Exception {
        PSDCDeployServerService pSDCDeployServerService = (PSDCDeployServerService)ServiceGlobal.getService(PSDCDeployServerService.class, (SessionFactory)this.getSessionFactory());
        pSDCDeployServerService.testRemoveByPSDeployServer(pSDeployServer);
        super.onBeforeRemove(pSDeployServer);
    }

    protected void replaceParentInfo(PSDeployServer pSDeployServer, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDeployServer, cloneSession);
        if (pSDeployServer.getPSDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDEPLOYCENTER", (Object)pSDeployServer.getPSDeployCenterId())) != null) {
            this.onFillParentInfo_PSDeployCenter(pSDeployServer, (PSDeployCenter)iEntity);
        }
        if (pSDeployServer.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSDeployServer.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSDeployServer, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDeployServer, bl);
    }

    protected void onCheckEntity(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IpAddr(bl, pSDeployServer, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployCenterId(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployCenterName(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployServerId(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDeployServerName(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResPos(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSDeployServer, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDeployServer, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isIpAddrDirty() && !bl2 : !pSDeployServer.isIpAddrDirty()) {
            return null;
        }
        String string = pSDeployServer.getIpAddr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IPADDR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isMemoDirty() : !pSDeployServer.isMemoDirty()) {
            return null;
        }
        String string = pSDeployServer.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPasswdDirty() && !bl2 : !pSDeployServer.isPasswdDirty()) {
            return null;
        }
        String string = pSDeployServer.getPasswd();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPortDirty() : !pSDeployServer.isPortDirty()) {
            return null;
        }
        Integer n = pSDeployServer.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDeployCenterId(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPSDeployCenterIdDirty() : !pSDeployServer.isPSDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDeployServer.getPSDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployCenterId_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployCenterName(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPSDeployCenterNameDirty() : !pSDeployServer.isPSDeployCenterNameDirty()) {
            return null;
        }
        String string = pSDeployServer.getPSDeployCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployCenterName_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployServerId(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPSDeployServerIdDirty() && !bl2 : !pSDeployServer.isPSDeployServerIdDirty()) {
            return null;
        }
        String string = pSDeployServer.getPSDeployServerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYSERVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployServerId_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDeployServerName(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPSDeployServerNameDirty() && !bl2 : !pSDeployServer.isPSDeployServerNameDirty()) {
            return null;
        }
        String string = pSDeployServer.getPSDeployServerName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYSERVERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDeployServerName_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPLOYSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isPSSvrDomainIdDirty() && !bl2 : !pSDeployServer.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSDeployServer.getPSSvrDomainId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSVRDOMAINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResPos(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isResPosDirty() : !pSDeployServer.isResPosDirty()) {
            return null;
        }
        Integer n = pSDeployServer.getResPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResPos_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isResReadyTimeDirty() : !pSDeployServer.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDeployServer.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isResStateDirty() : !pSDeployServer.isResStateDirty()) {
            return null;
        }
        Integer n = pSDeployServer.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isSSHIPAddrDirty() : !pSDeployServer.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSDeployServer.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHIPADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isSSHPortDirty() : !pSDeployServer.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSDeployServer.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SSHPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isUploadFileModeDirty() : !pSDeployServer.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSDeployServer.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADFILEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isUploadPathDirty() : !pSDeployServer.isUploadPathDirty()) {
            return null;
        }
        String string = pSDeployServer.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPLOADPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isUserNameDirty() && !bl2 : !pSDeployServer.isUserNameDirty()) {
            return null;
        }
        String string = pSDeployServer.getUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isValidFlagDirty() && !bl2 : !pSDeployServer.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDeployServer.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDeployServer, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSDeployServer pSDeployServer, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDeployServer.isWorkshopPathDirty() : !pSDeployServer.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSDeployServer.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSDeployServer, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WORKSHOPPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        super.onSyncEntity(pSDeployServer, bl);
    }

    protected void onSyncIndexEntities(PSDeployServer pSDeployServer, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDeployServer, bl);
    }

    public Object getDataContextValue(PSDeployServer pSDeployServer, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDeployServer, string, iDataContextParam)) != null) {
            return object;
        }
        PSSvrDomain pSSvrDomain = pSDeployServer.getPSSvrDomain();
        if (pSSvrDomain != null && pSSvrDomain.contains(string)) {
            return pSSvrDomain.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDeployServer pSDeployServer, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDeployServer, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPLOYSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDeployServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHIPADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHIPAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SSHPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SSHPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADFILEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadFileMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPLOADPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UploadPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDeployServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPLOYSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ResPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SSHIPAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SSHIPADDR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SSHPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UploadFileMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADFILEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UploadPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPLOADPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_WorkshopPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WORKSHOPPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDeployServer pSDeployServer) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDeployServer)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDeployServer pSDeployServer) throws Exception {
        super.onUpdateParent(pSDeployServer);
    }

    @Override
    protected void exportCurXmlModel(PSDeployServer pSDeployServer, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPLOYSERVER");
        if (!bl) {
            pSDeployServer.setCreateDate(null);
            pSDeployServer.setCreateMan(null);
            pSDeployServer.setPSDeployServerId(null);
            pSDeployServer.setUpdateDate(null);
            pSDeployServer.setUpdateMan(null);
            super.exportCurXmlModel(pSDeployServer, xmlNode, bl);
        }
    }
}

