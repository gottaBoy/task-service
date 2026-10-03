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
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformServiceBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSMSPlatformDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSMSPlatformDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomainBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformFuncServiceBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService;
import net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMSPlatformServiceBase
extends PSCoreSysServiceBase<PSMSPlatform> {
    private static final Log log = LogFactory.getLog(PSMSPlatformServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMSPlatformDEModel pSMSPlatformDEModel;
    private PSMSPlatformDAO pSMSPlatformDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService";
    }

    public PSMSPlatformDEModel getPSMSPlatformDEModel() {
        if (this.pSMSPlatformDEModel == null) {
            try {
                this.pSMSPlatformDEModel = (PSMSPlatformDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSMSPlatformDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMSPlatformDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMSPlatformDEModel();
    }

    public PSMSPlatformDAO getPSMSPlatformDAO() {
        if (this.pSMSPlatformDAO == null) {
            try {
                this.pSMSPlatformDAO = (PSMSPlatformDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSMSPlatformDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMSPlatformDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMSPlatformDAO();
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

    protected void onFillParentInfo(PSMSPlatform pSMSPlatform, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMSPLATFORM_PSSVRDOMAIN_PSSVRDOMAINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService", (SessionFactory)this.getSessionFactory());
            PSSvrDomain pSSvrDomain = (PSSvrDomain)iService.getDEModel().createEntity();
            pSSvrDomain.set("PSSVRDOMAINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSvrDomain);
            } else {
                iService.get(pSSvrDomain);
            }
            this.onFillParentInfo_PSSvrDomain(pSMSPlatform, pSSvrDomain);
            return;
        }
        super.onFillParentInfo(pSMSPlatform, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSvrDomain(PSMSPlatform pSMSPlatform, PSSvrDomain pSSvrDomain) throws Exception {
        pSMSPlatform.setPSSvrDomainId(pSSvrDomain.getPSSvrDomainId());
        pSMSPlatform.setPSSvrDomainName(pSSvrDomain.getPSSvrDomainName());
    }

    protected void onFillEntityFullInfo(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
        if (bl && pSMSPlatform.getValidFlag() == null) {
            pSMSPlatform.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSMSPlatform, bl);
        this.onFillEntityFullInfo_PSSvrDomain(pSMSPlatform, bl);
    }

    protected void onFillEntityFullInfo_PSSvrDomain(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
        super.onWriteBackParent(pSMSPlatform, bl);
    }

    public ArrayList<PSMSPlatform> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, "", -1);
    }

    public ArrayList<PSMSPlatform> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string) throws Exception {
        return this.selectByPSSvrDomain(pSSvrDomainBase, string, -1);
    }

    public ArrayList<PSMSPlatform> selectByPSSvrDomain(PSSvrDomainBase pSSvrDomainBase, String string, int n) throws Exception {
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
        ArrayList<PSMSPlatform> arrayList = this.selectByPSSvrDomain(pSSvrDomain, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSVRDOMAIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSvrDomain);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMSPLATFORM_PSSVRDOMAIN_PSSVRDOMAINID", "", iDataEntityModel.getName(), "PSMSPLATFORM", iDataEntityModel.getDataInfo(pSSvrDomain), arrayList.get(0)));
        }
    }

    public void resetPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSMSPlatform> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        for (PSMSPlatform pSMSPlatform : arrayList) {
            PSMSPlatform pSMSPlatform2 = (PSMSPlatform)this.getDEModel().createEntity();
            pSMSPlatform2.setPSMSPlatformId(pSMSPlatform.getPSMSPlatformId());
            pSMSPlatform2.setPSSvrDomainId(null);
            this.update(pSMSPlatform2);
        }
    }

    public void removeByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        final PSSvrDomain pSSvrDomain2 = pSSvrDomain;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMSPlatformServiceBase.this.onBeforeRemoveByPSSvrDomain(pSSvrDomain2);
                PSMSPlatformServiceBase.this.internalRemoveByPSSvrDomain(pSSvrDomain2);
                PSMSPlatformServiceBase.this.onAfterRemoveByPSSvrDomain(pSSvrDomain2);
            }
        });
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void internalRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
        ArrayList<PSMSPlatform> arrayList = this.selectByPSSvrDomain(pSSvrDomain);
        this.onBeforeRemoveByPSSvrDomain(pSSvrDomain, arrayList);
        for (PSMSPlatform pSMSPlatform : arrayList) {
            this.remove(pSMSPlatform);
        }
        this.onAfterRemoveByPSSvrDomain(pSSvrDomain, arrayList);
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain) throws Exception {
    }

    protected void onBeforeRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSMSPlatform> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSvrDomain(PSSvrDomain pSSvrDomain, ArrayList<PSMSPlatform> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMSPlatform pSMSPlatform) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMSPlatformServiceBase)pSCoreSysServiceBase).testRemoveByPSMSPlatform(pSMSPlatform);
        pSCoreSysServiceBase = (PSMSPlatformFuncService)ServiceGlobal.getService(PSMSPlatformFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSMSPlatformFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSMSPlatform(pSMSPlatform);
        ((PSMSPlatformFuncServiceBase)pSCoreSysServiceBase).removeByPSMSPlatform(pSMSPlatform);
        pSCoreSysServiceBase = (PSMSPlatformNodeService)ServiceGlobal.getService(PSMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSMSPlatformNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSMSPlatform(pSMSPlatform);
        super.onBeforeRemove(pSMSPlatform);
    }

    protected void replaceParentInfo(PSMSPlatform pSMSPlatform, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMSPlatform, cloneSession);
        if (pSMSPlatform.getPSSvrDomainId() != null && (iEntity = cloneSession.getEntity("PSSVRDOMAIN", (Object)pSMSPlatform.getPSSvrDomainId())) != null) {
            this.onFillParentInfo_PSSvrDomain(pSMSPlatform, (PSSvrDomain)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMSPlatform, bl);
    }

    protected void onCheckEntity(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AdminPasswd(bl, pSMSPlatform, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AdminUserName(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LocalRes(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSType(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformId(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformName(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSvrDomainId(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResState(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WebConsolePath(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSMSPlatform, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMSPlatform, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AdminPasswd(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isAdminPasswdDirty() : !pSMSPlatform.isAdminPasswdDirty()) {
            return null;
        }
        String string = pSMSPlatform.getAdminPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminPasswd_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINPASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AdminUserName(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isAdminUserNameDirty() : !pSMSPlatform.isAdminUserNameDirty()) {
            return null;
        }
        String string = pSMSPlatform.getAdminUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AdminUserName_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADMINUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isIpAddrDirty() : !pSMSPlatform.isIpAddrDirty()) {
            return null;
        }
        String string = pSMSPlatform.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isIpAddr2Dirty() : !pSMSPlatform.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSMSPlatform.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_LocalRes(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isLocalResDirty() : !pSMSPlatform.isLocalResDirty()) {
            return null;
        }
        Integer n = pSMSPlatform.getLocalRes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LocalRes_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCALRES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isMemoDirty() : !pSMSPlatform.isMemoDirty()) {
            return null;
        }
        String string = pSMSPlatform.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_MSType(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isMSTypeDirty() && !bl2 : !pSMSPlatform.isMSTypeDirty()) {
            return null;
        }
        String string = pSMSPlatform.getMSType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSType_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isPasswdDirty() : !pSMSPlatform.isPasswdDirty()) {
            return null;
        }
        String string = pSMSPlatform.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isPortDirty() : !pSMSPlatform.isPortDirty()) {
            return null;
        }
        Integer n = pSMSPlatform.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSMSPlatformId(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isPSMSPlatformIdDirty() && !bl2 : !pSMSPlatform.isPSMSPlatformIdDirty()) {
            return null;
        }
        String string = pSMSPlatform.getPSMSPlatformId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformId_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformName(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isPSMSPlatformNameDirty() && !bl2 : !pSMSPlatform.isPSMSPlatformNameDirty()) {
            return null;
        }
        String string = pSMSPlatform.getPSMSPlatformName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformName_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSvrDomainId(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isPSSvrDomainIdDirty() : !pSMSPlatform.isPSSvrDomainIdDirty()) {
            return null;
        }
        String string = pSMSPlatform.getPSSvrDomainId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSvrDomainId_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResState(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isResStateDirty() : !pSMSPlatform.isResStateDirty()) {
            return null;
        }
        Integer n = pSMSPlatform.getResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResState_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isSSHIPAddrDirty() : !pSMSPlatform.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSMSPlatform.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isSSHPortDirty() : !pSMSPlatform.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSMSPlatform.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isUploadFileModeDirty() : !pSMSPlatform.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSMSPlatform.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isUploadPathDirty() : !pSMSPlatform.isUploadPathDirty()) {
            return null;
        }
        String string = pSMSPlatform.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isUserNameDirty() : !pSMSPlatform.isUserNameDirty()) {
            return null;
        }
        String string = pSMSPlatform.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isValidFlagDirty() && !bl2 : !pSMSPlatform.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSMSPlatform.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSMSPlatform, bl2, bl3);
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

    protected EntityFieldError onCheckField_WebConsolePath(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isWebConsolePathDirty() : !pSMSPlatform.isWebConsolePathDirty()) {
            return null;
        }
        String string = pSMSPlatform.getWebConsolePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WebConsolePath_Default(pSMSPlatform, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEBCONSOLEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSMSPlatform pSMSPlatform, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatform.isWorkshopPathDirty() : !pSMSPlatform.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSMSPlatform.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSMSPlatform, bl2, bl3);
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

    protected void onSyncEntity(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
        super.onSyncEntity(pSMSPlatform, bl);
    }

    protected void onSyncIndexEntities(PSMSPlatform pSMSPlatform, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMSPlatform, bl);
    }

    public Object getDataContextValue(PSMSPlatform pSMSPlatform, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMSPlatform, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMSPlatform pSMSPlatform, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMSPlatform, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADMINPASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminPasswd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADMINUSERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AdminUserName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"LOCALRES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LocalRes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Passwd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Port_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSVRDOMAINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSvrDomainName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"WEBCONSOLEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WebConsolePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WORKSHOPPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WorkshopPath_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AdminPasswd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINPASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AdminUserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADMINUSERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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
            if (this.checkFieldStringLengthRule("IPADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_LocalRes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSMSPlatformId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_WebConsolePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WEBCONSOLEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected boolean onMergeChild(String string, String string2, PSMSPlatform pSMSPlatform) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMSPlatform)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMSPlatform pSMSPlatform) throws Exception {
        super.onUpdateParent(pSMSPlatform);
    }

    @Override
    protected void exportCurXmlModel(PSMSPlatform pSMSPlatform, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMSPLATFORM");
        if (!bl) {
            pSMSPlatform.setCreateDate(null);
            pSMSPlatform.setCreateMan(null);
            pSMSPlatform.setPSMSPlatformId(null);
            pSMSPlatform.setPSSvrDomainName(null);
            pSMSPlatform.setUpdateDate(null);
            pSMSPlatform.setUpdateMan(null);
            super.exportCurXmlModel(pSMSPlatform, xmlNode, bl);
        }
    }
}

