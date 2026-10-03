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
import net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspacePolicyDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspacePolicyDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspacePolicy;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspacePolicyServiceBase
extends PSCoreSysServiceBase<PSWorkspacePolicy> {
    private static final Log log = LogFactory.getLog(PSWorkspacePolicyServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWorkspacePolicyDEModel pSWorkspacePolicyDEModel;
    private PSWorkspacePolicyDAO pSWorkspacePolicyDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSWorkspacePolicyService";
    }

    public PSWorkspacePolicyDEModel getPSWorkspacePolicyDEModel() {
        if (this.pSWorkspacePolicyDEModel == null) {
            try {
                this.pSWorkspacePolicyDEModel = (PSWorkspacePolicyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspacePolicyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspacePolicyDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWorkspacePolicyDEModel();
    }

    public PSWorkspacePolicyDAO getPSWorkspacePolicyDAO() {
        if (this.pSWorkspacePolicyDAO == null) {
            try {
                this.pSWorkspacePolicyDAO = (PSWorkspacePolicyDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspacePolicyDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspacePolicyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWorkspacePolicyDAO();
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

    protected void onFillParentInfo(PSWorkspacePolicy pSWorkspacePolicy, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKSPACEPOLICY_PSWORKSPACE_PSWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSWorkspace pSWorkspace = (PSWorkspace)iService.getDEModel().createEntity();
            pSWorkspace.set("PSWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkspace);
            } else {
                iService.get(pSWorkspace);
            }
            this.onFillParentInfo_PSWorkspace(pSWorkspacePolicy, pSWorkspace);
            return;
        }
        super.onFillParentInfo(pSWorkspacePolicy, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWorkspace(PSWorkspacePolicy pSWorkspacePolicy, PSWorkspace pSWorkspace) throws Exception {
        pSWorkspacePolicy.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        pSWorkspacePolicy.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
    }

    protected void onFillEntityFullInfo(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWorkspacePolicy, bl);
        this.onFillEntityFullInfo_PSWorkspace(pSWorkspacePolicy, bl);
    }

    protected void onFillEntityFullInfo_PSWorkspace(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        if (pSWorkspacePolicy.isPSWorkspaceIdDirty()) {
            if (pSWorkspacePolicy.getPSWorkspaceId() != null) {
                if (pSWorkspacePolicy.getPSWorkspaceId() == null || pSWorkspacePolicy.getPSWorkspaceName() == null) {
                    PSWorkspace pSWorkspace = pSWorkspacePolicy.getPSWorkspace();
                    pSWorkspacePolicy.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
                }
            } else {
                pSWorkspacePolicy.setPSWorkspaceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        super.onWriteBackParent(pSWorkspacePolicy, bl);
    }

    public ArrayList<PSWorkspacePolicy> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, "", -1);
    }

    public ArrayList<PSWorkspacePolicy> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, string, -1);
    }

    public ArrayList<PSWorkspacePolicy> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string, int n) throws Exception {
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

    public void testRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    public void resetPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWorkspacePolicy> arrayList = this.selectByPSWorkspace(pSWorkspace);
        for (PSWorkspacePolicy pSWorkspacePolicy : arrayList) {
            PSWorkspacePolicy pSWorkspacePolicy2 = (PSWorkspacePolicy)this.getDEModel().createEntity();
            pSWorkspacePolicy2.setPSWorkspacePolicyId(pSWorkspacePolicy.getPSWorkspacePolicyId());
            pSWorkspacePolicy2.setPSWorkspaceId(null);
            this.update(pSWorkspacePolicy2);
        }
    }

    public void removeByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        final PSWorkspace pSWorkspace2 = pSWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkspacePolicyServiceBase.this.onBeforeRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspacePolicyServiceBase.this.internalRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspacePolicyServiceBase.this.onAfterRemoveByPSWorkspace(pSWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void internalRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWorkspacePolicy> arrayList = this.selectByPSWorkspace(pSWorkspace);
        this.onBeforeRemoveByPSWorkspace(pSWorkspace, arrayList);
        for (PSWorkspacePolicy pSWorkspacePolicy : arrayList) {
            this.remove(pSWorkspacePolicy);
        }
        this.onAfterRemoveByPSWorkspace(pSWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspacePolicy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspacePolicy> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWorkspacePolicy pSWorkspacePolicy) throws Exception {
        super.onBeforeRemove(pSWorkspacePolicy);
    }

    protected void replaceParentInfo(PSWorkspacePolicy pSWorkspacePolicy, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWorkspacePolicy, cloneSession);
        if (pSWorkspacePolicy.getPSWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSWORKSPACE", (Object)pSWorkspacePolicy.getPSWorkspaceId())) != null) {
            this.onFillParentInfo_PSWorkspace(pSWorkspacePolicy, (PSWorkspace)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWorkspacePolicy, bl);
    }

    protected void onCheckEntity(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PolicyTag(bl, pSWorkspacePolicy, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyTag2(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyTag3(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyTag4(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PolicyType(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceId(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceName(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspacePolicyId(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspacePolicyName(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value2(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value3(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value4(bl, pSWorkspacePolicy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWorkspacePolicy, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PolicyTag(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPolicyTagDirty() && !bl2 : !pSWorkspacePolicy.isPolicyTagDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPolicyTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyTag_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyTag2(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPolicyTag2Dirty() && !bl2 : !pSWorkspacePolicy.isPolicyTag2Dirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPolicyTag2();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG2");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyTag2_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyTag3(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPolicyTag3Dirty() : !pSWorkspacePolicy.isPolicyTag3Dirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPolicyTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyTag3_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyTag4(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPolicyTag4Dirty() : !pSWorkspacePolicy.isPolicyTag4Dirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPolicyTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyTag4_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PolicyType(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPolicyTypeDirty() && !bl2 : !pSWorkspacePolicy.isPolicyTypeDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPolicyType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PolicyType_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POLICYTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPSDCWorkspaceIdDirty() : !pSWorkspacePolicy.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPSDCWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceId(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPSWorkspaceIdDirty() : !pSWorkspacePolicy.isPSWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPSWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceId_Default(pSWorkspacePolicy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceName(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPSWorkspaceNameDirty() : !pSWorkspacePolicy.isPSWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPSWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceName_Default(pSWorkspacePolicy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspacePolicyId(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPSWorkspacePolicyIdDirty() && !bl2 : !pSWorkspacePolicy.isPSWorkspacePolicyIdDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPSWorkspacePolicyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEPOLICYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspacePolicyId_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspacePolicyName(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isPSWorkspacePolicyNameDirty() && !bl2 : !pSWorkspacePolicy.isPSWorkspacePolicyNameDirty()) {
            return null;
        }
        String string = pSWorkspacePolicy.getPSWorkspacePolicyName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEPOLICYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspacePolicyName_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEPOLICYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Value(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isValueDirty() : !pSWorkspacePolicy.isValueDirty()) {
            return null;
        }
        Integer n = pSWorkspacePolicy.getValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Value2(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isValue2Dirty() : !pSWorkspacePolicy.isValue2Dirty()) {
            return null;
        }
        Integer n = pSWorkspacePolicy.getValue2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value2_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Value3(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isValue3Dirty() : !pSWorkspacePolicy.isValue3Dirty()) {
            return null;
        }
        Integer n = pSWorkspacePolicy.getValue3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value3_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Value4(boolean bl, PSWorkspacePolicy pSWorkspacePolicy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspacePolicy.isValue4Dirty() : !pSWorkspacePolicy.isValue4Dirty()) {
            return null;
        }
        Integer n = pSWorkspacePolicy.getValue4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value4_Default(pSWorkspacePolicy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        super.onSyncEntity(pSWorkspacePolicy, bl);
    }

    protected void onSyncIndexEntities(PSWorkspacePolicy pSWorkspacePolicy, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWorkspacePolicy, bl);
    }

    public Object getDataContextValue(PSWorkspacePolicy pSWorkspacePolicy, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWorkspacePolicy, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWorkspacePolicy pSWorkspacePolicy, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWorkspacePolicy, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POLICYTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PolicyType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEPOLICYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspacePolicyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEPOLICYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspacePolicyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PolicyTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PolicyTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PolicyTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PolicyTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PolicyType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POLICYTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSWorkspacePolicyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACEPOLICYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspacePolicyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACEPOLICYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Value_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Value2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Value3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Value4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSWorkspacePolicy pSWorkspacePolicy) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWorkspacePolicy)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWorkspacePolicy pSWorkspacePolicy) throws Exception {
        super.onUpdateParent(pSWorkspacePolicy);
    }

    @Override
    protected void exportCurXmlModel(PSWorkspacePolicy pSWorkspacePolicy, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWORKSPACEPOLICY");
        if (!bl) {
            pSWorkspacePolicy.setCreateDate(null);
            pSWorkspacePolicy.setCreateMan(null);
            pSWorkspacePolicy.setPSWorkspacePolicyId(null);
            pSWorkspacePolicy.setUpdateDate(null);
            pSWorkspacePolicy.setUpdateMan(null);
            super.exportCurXmlModel(pSWorkspacePolicy, xmlNode, bl);
        }
    }
}

