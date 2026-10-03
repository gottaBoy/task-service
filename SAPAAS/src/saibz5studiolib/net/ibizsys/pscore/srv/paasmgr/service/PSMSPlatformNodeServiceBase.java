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
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.paasmgr.dao.PSMSPlatformNodeDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSMSPlatformNodeDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatform;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMSPlatformNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMSPlatformNodeServiceBase
extends PSCoreSysServiceBase<PSMSPlatformNode> {
    private static final Log log = LogFactory.getLog(PSMSPlatformNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMSPlatformNodeDEModel pSMSPlatformNodeDEModel;
    private PSMSPlatformNodeDAO pSMSPlatformNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformNodeService";
    }

    public PSMSPlatformNodeDEModel getPSMSPlatformNodeDEModel() {
        if (this.pSMSPlatformNodeDEModel == null) {
            try {
                this.pSMSPlatformNodeDEModel = (PSMSPlatformNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSMSPlatformNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMSPlatformNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMSPlatformNodeDEModel();
    }

    public PSMSPlatformNodeDAO getPSMSPlatformNodeDAO() {
        if (this.pSMSPlatformNodeDAO == null) {
            try {
                this.pSMSPlatformNodeDAO = (PSMSPlatformNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSMSPlatformNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMSPlatformNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMSPlatformNodeDAO();
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

    protected void onFillParentInfo(PSMSPlatformNode pSMSPlatformNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMSPLATFORMNODE_PSMSPLATFORM_PSMSPLATFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSMSPlatformService", (SessionFactory)this.getSessionFactory());
            PSMSPlatform pSMSPlatform = (PSMSPlatform)iService.getDEModel().createEntity();
            pSMSPlatform.set("PSMSPLATFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMSPlatform);
            } else {
                iService.get(pSMSPlatform);
            }
            this.onFillParentInfo_PSMSPlatform(pSMSPlatformNode, pSMSPlatform);
            return;
        }
        super.onFillParentInfo(pSMSPlatformNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSMSPlatform(PSMSPlatformNode pSMSPlatformNode, PSMSPlatform pSMSPlatform) throws Exception {
        pSMSPlatformNode.setPSMSPlatformId(pSMSPlatform.getPSMSPlatformId());
        pSMSPlatformNode.setPSMSPlatformName(pSMSPlatform.getPSMSPlatformName());
    }

    protected void onFillEntityFullInfo(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
        if (bl && pSMSPlatformNode.getValidFlag() == null) {
            pSMSPlatformNode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSMSPlatformNode, bl);
        this.onFillEntityFullInfo_PSMSPlatform(pSMSPlatformNode, bl);
    }

    protected void onFillEntityFullInfo_PSMSPlatform(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
        super.onWriteBackParent(pSMSPlatformNode, bl);
    }

    public ArrayList<PSMSPlatformNode> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase) throws Exception {
        return this.selectByPSMSPlatform(pSMSPlatformBase, "", -1);
    }

    public ArrayList<PSMSPlatformNode> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase, String string) throws Exception {
        return this.selectByPSMSPlatform(pSMSPlatformBase, string, -1);
    }

    public ArrayList<PSMSPlatformNode> selectByPSMSPlatform(PSMSPlatformBase pSMSPlatformBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMSPLATFORMID", (Object)pSMSPlatformBase.getPSMSPlatformId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMSPlatformCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMSPlatformCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSMSPlatformNode> arrayList = this.selectByPSMSPlatform(pSMSPlatform, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMSPLATFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSMSPlatform);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMSPLATFORMNODE_PSMSPLATFORM_PSMSPLATFORMID", "", iDataEntityModel.getName(), "PSMSPLATFORMNODE", iDataEntityModel.getDataInfo(pSMSPlatform), arrayList.get(0)));
        }
    }

    public void resetPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSMSPlatformNode> arrayList = this.selectByPSMSPlatform(pSMSPlatform);
        for (PSMSPlatformNode pSMSPlatformNode : arrayList) {
            PSMSPlatformNode pSMSPlatformNode2 = (PSMSPlatformNode)this.getDEModel().createEntity();
            pSMSPlatformNode2.setPSMSPlatformNodeId(pSMSPlatformNode.getPSMSPlatformNodeId());
            pSMSPlatformNode2.setPSMSPlatformId(null);
            this.update(pSMSPlatformNode2);
        }
    }

    public void removeByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        final PSMSPlatform pSMSPlatform2 = pSMSPlatform;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMSPlatformNodeServiceBase.this.onBeforeRemoveByPSMSPlatform(pSMSPlatform2);
                PSMSPlatformNodeServiceBase.this.internalRemoveByPSMSPlatform(pSMSPlatform2);
                PSMSPlatformNodeServiceBase.this.onAfterRemoveByPSMSPlatform(pSMSPlatform2);
            }
        });
    }

    protected void onBeforeRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
    }

    protected void internalRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
        ArrayList<PSMSPlatformNode> arrayList = this.selectByPSMSPlatform(pSMSPlatform);
        this.onBeforeRemoveByPSMSPlatform(pSMSPlatform, arrayList);
        for (PSMSPlatformNode pSMSPlatformNode : arrayList) {
            this.remove(pSMSPlatformNode);
        }
        this.onAfterRemoveByPSMSPlatform(pSMSPlatform, arrayList);
    }

    protected void onAfterRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform) throws Exception {
    }

    protected void onBeforeRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform, ArrayList<PSMSPlatformNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMSPlatform(PSMSPlatform pSMSPlatform, ArrayList<PSMSPlatformNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        pSDCMSPlatformNodeService.testRemoveByPSMSPlatformNode(pSMSPlatformNode);
        super.onBeforeRemove(pSMSPlatformNode);
    }

    protected void replaceParentInfo(PSMSPlatformNode pSMSPlatformNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMSPlatformNode, cloneSession);
        if (pSMSPlatformNode.getPSMSPlatformId() != null && (iEntity = cloneSession.getEntity("PSMSPLATFORM", (Object)pSMSPlatformNode.getPSMSPlatformId())) != null) {
            this.onFillParentInfo_PSMSPlatform(pSMSPlatformNode, (PSMSPlatform)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMSPlatformNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_IpAddr(bl, pSMSPlatformNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IpAddr2(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Passwd(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Port(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformId(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformNodeId(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMSPlatformNodeName(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHIPAddr(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SSHPort(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadFileMode(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UploadPath(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WorkshopPath(bl, pSMSPlatformNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMSPlatformNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_IpAddr(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isIpAddrDirty() : !pSMSPlatformNode.isIpAddrDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getIpAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_IpAddr2(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isIpAddr2Dirty() : !pSMSPlatformNode.isIpAddr2Dirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getIpAddr2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IpAddr2_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isMemoDirty() : !pSMSPlatformNode.isMemoDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Passwd(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isPasswdDirty() : !pSMSPlatformNode.isPasswdDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getPasswd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Passwd_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_Port(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isPortDirty() : !pSMSPlatformNode.isPortDirty()) {
            return null;
        }
        Integer n = pSMSPlatformNode.getPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Port_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSMSPlatformId(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isPSMSPlatformIdDirty() && !bl2 : !pSMSPlatformNode.isPSMSPlatformIdDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getPSMSPlatformId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformId_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSMSPlatformNodeId(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isPSMSPlatformNodeIdDirty() && !bl2 : !pSMSPlatformNode.isPSMSPlatformNodeIdDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getPSMSPlatformNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformNodeId_Default(pSMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMSPlatformNodeName(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isPSMSPlatformNodeNameDirty() && !bl2 : !pSMSPlatformNode.isPSMSPlatformNodeNameDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getPSMSPlatformNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMSPlatformNodeName_Default(pSMSPlatformNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMSPLATFORMNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SSHIPAddr(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isSSHIPAddrDirty() : !pSMSPlatformNode.isSSHIPAddrDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getSSHIPAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SSHIPAddr_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_SSHPort(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isSSHPortDirty() : !pSMSPlatformNode.isSSHPortDirty()) {
            return null;
        }
        Integer n = pSMSPlatformNode.getSSHPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SSHPort_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadFileMode(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isUploadFileModeDirty() : !pSMSPlatformNode.isUploadFileModeDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getUploadFileMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadFileMode_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UploadPath(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isUploadPathDirty() : !pSMSPlatformNode.isUploadPathDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getUploadPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UploadPath_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserName(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isUserNameDirty() : !pSMSPlatformNode.isUserNameDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getUserName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isValidFlagDirty() && !bl2 : !pSMSPlatformNode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSMSPlatformNode.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSMSPlatformNode, bl2, bl3);
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

    protected EntityFieldError onCheckField_WorkshopPath(boolean bl, PSMSPlatformNode pSMSPlatformNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMSPlatformNode.isWorkshopPathDirty() : !pSMSPlatformNode.isWorkshopPathDirty()) {
            return null;
        }
        String string = pSMSPlatformNode.getWorkshopPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WorkshopPath_Default(pSMSPlatformNode, bl2, bl3);
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

    protected void onSyncEntity(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
        super.onSyncEntity(pSMSPlatformNode, bl);
    }

    protected void onSyncIndexEntities(PSMSPlatformNode pSMSPlatformNode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMSPlatformNode, bl);
    }

    public Object getDataContextValue(PSMSPlatformNode pSMSPlatformNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMSPlatformNode, string, iDataContextParam)) != null) {
            return object;
        }
        PSMSPlatform pSMSPlatform = pSMSPlatformNode.getPSMSPlatform();
        if (pSMSPlatform != null && pSMSPlatform.contains(string)) {
            return pSMSPlatform.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSMSPlatformNode pSMSPlatformNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMSPlatformNode, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"IPADDR2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IpAddr2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMSPLATFORMNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMSPlatformNodeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSMSPlatformNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMSPlatformNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMSPLATFORMNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected boolean onMergeChild(String string, String string2, PSMSPlatformNode pSMSPlatformNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMSPlatformNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMSPlatformNode pSMSPlatformNode) throws Exception {
        super.onUpdateParent(pSMSPlatformNode);
    }

    @Override
    protected void exportCurXmlModel(PSMSPlatformNode pSMSPlatformNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMSPLATFORMNODE");
        if (!bl) {
            pSMSPlatformNode.setCreateDate(null);
            pSMSPlatformNode.setCreateMan(null);
            pSMSPlatformNode.setPSMSPlatformNodeId(null);
            pSMSPlatformNode.setUpdateDate(null);
            pSMSPlatformNode.setUpdateMan(null);
            super.exportCurXmlModel(pSMSPlatformNode, xmlNode, bl);
        }
    }
}

