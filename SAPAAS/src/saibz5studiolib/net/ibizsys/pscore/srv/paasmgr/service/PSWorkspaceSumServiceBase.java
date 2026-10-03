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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspaceSumDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspaceSumDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceSum;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspaceSumServiceBase
extends PSCoreSysServiceBase<PSWorkspaceSum> {
    private static final Log log = LogFactory.getLog(PSWorkspaceSumServiceBase.class);
    private PSWorkspaceSumDEModel pSWorkspaceSumDEModel;
    private PSWorkspaceSumDAO pSWorkspaceSumDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceSumService";
    }

    public PSWorkspaceSumDEModel getPSWorkspaceSumDEModel() {
        if (this.pSWorkspaceSumDEModel == null) {
            try {
                this.pSWorkspaceSumDEModel = (PSWorkspaceSumDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSWorkspaceSumDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspaceSumDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWorkspaceSumDEModel();
    }

    public PSWorkspaceSumDAO getPSWorkspaceSumDAO() {
        if (this.pSWorkspaceSumDAO == null) {
            try {
                this.pSWorkspaceSumDAO = (PSWorkspaceSumDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSWorkspaceSumDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWorkspaceSumDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWorkspaceSumDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSWorkspaceSum pSWorkspaceSum, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWORKSPACESUM_PSWORKSPACE_PSWORKSPACEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService", (SessionFactory)this.getSessionFactory());
            PSWorkspace pSWorkspace = (PSWorkspace)iService.getDEModel().createEntity();
            pSWorkspace.set("PSWORKSPACEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWorkspace);
            } else {
                iService.get(pSWorkspace);
            }
            this.onFillParentInfo_PSWorkspace(pSWorkspaceSum, pSWorkspace);
            return;
        }
        super.onFillParentInfo(pSWorkspaceSum, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWorkspace(PSWorkspaceSum pSWorkspaceSum, PSWorkspace pSWorkspace) throws Exception {
        pSWorkspaceSum.setPSWorkspaceId(pSWorkspace.getPSWorkspaceId());
        pSWorkspaceSum.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
    }

    protected boolean onFillEntityKeyValue(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSWorkspaceSum.get("PSWORKSPACEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSWorkspaceSum.get("SUMTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSWorkspaceSum.get("SUMTAG");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSWorkspaceSum.get("SUMTAG2");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        stringBuilderEx.append("||");
        Object object5 = pSWorkspaceSum.get("PSDCWORKSPACEID");
        if (object5 == null) {
            object5 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object5);
        String string = stringBuilderEx.toString();
        pSWorkspaceSum.set(this.getPSWorkspaceSumDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWorkspaceSum, bl);
        this.onFillEntityFullInfo_PSWorkspace(pSWorkspaceSum, bl);
    }

    protected void onFillEntityFullInfo_PSWorkspace(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        if (pSWorkspaceSum.isPSWorkspaceIdDirty()) {
            if (pSWorkspaceSum.getPSWorkspaceId() != null) {
                if (pSWorkspaceSum.getPSWorkspaceId() == null || pSWorkspaceSum.getPSWorkspaceName() == null) {
                    PSWorkspace pSWorkspace = pSWorkspaceSum.getPSWorkspace();
                    pSWorkspaceSum.setPSWorkspaceName(pSWorkspace.getPSWorkspaceName());
                }
            } else {
                pSWorkspaceSum.setPSWorkspaceName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        super.onWriteBackParent(pSWorkspaceSum, bl);
    }

    public ArrayList<PSWorkspaceSum> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, "", -1);
    }

    public ArrayList<PSWorkspaceSum> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string) throws Exception {
        return this.selectByPSWorkspace(pSWorkspaceBase, string, -1);
    }

    public ArrayList<PSWorkspaceSum> selectByPSWorkspace(PSWorkspaceBase pSWorkspaceBase, String string, int n) throws Exception {
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
        ArrayList<PSWorkspaceSum> arrayList = this.selectByPSWorkspace(pSWorkspace);
        for (PSWorkspaceSum pSWorkspaceSum : arrayList) {
            PSWorkspaceSum pSWorkspaceSum2 = (PSWorkspaceSum)this.getDEModel().createEntity();
            pSWorkspaceSum2.setPSWorkspaceSumId(pSWorkspaceSum.getPSWorkspaceSumId());
            pSWorkspaceSum2.setPSWorkspaceId(null);
            this.update(pSWorkspaceSum2);
        }
    }

    public void removeByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        final PSWorkspace pSWorkspace2 = pSWorkspace;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWorkspaceSumServiceBase.this.onBeforeRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspaceSumServiceBase.this.internalRemoveByPSWorkspace(pSWorkspace2);
                PSWorkspaceSumServiceBase.this.onAfterRemoveByPSWorkspace(pSWorkspace2);
            }
        });
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void internalRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
        ArrayList<PSWorkspaceSum> arrayList = this.selectByPSWorkspace(pSWorkspace);
        this.onBeforeRemoveByPSWorkspace(pSWorkspace, arrayList);
        for (PSWorkspaceSum pSWorkspaceSum : arrayList) {
            this.remove(pSWorkspaceSum);
        }
        this.onAfterRemoveByPSWorkspace(pSWorkspace, arrayList);
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace) throws Exception {
    }

    protected void onBeforeRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspaceSum> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWorkspace(PSWorkspace pSWorkspace, ArrayList<PSWorkspaceSum> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWorkspaceSum pSWorkspaceSum) throws Exception {
        super.onBeforeRemove(pSWorkspaceSum);
    }

    protected void replaceParentInfo(PSWorkspaceSum pSWorkspaceSum, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWorkspaceSum, cloneSession);
        if (pSWorkspaceSum.getPSWorkspaceId() != null && (iEntity = cloneSession.getEntity("PSWORKSPACE", (Object)pSWorkspaceSum.getPSWorkspaceId())) != null) {
            this.onFillParentInfo_PSWorkspace(pSWorkspaceSum, (PSWorkspace)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWorkspaceSum, bl);
    }

    protected void onCheckEntity(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSWorkspaceSum, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceId(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceName(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceSumId(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWorkspaceSumName(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SumTag(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SumTag2(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SumType(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value2(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value3(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value4(bl, pSWorkspaceSum, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWorkspaceSum, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isPSDCWorkspaceIdDirty() : !pSWorkspaceSum.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getPSDCWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceId(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isPSWorkspaceIdDirty() && !bl2 : !pSWorkspaceSum.isPSWorkspaceIdDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getPSWorkspaceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceId_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceName(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isPSWorkspaceNameDirty() : !pSWorkspaceSum.isPSWorkspaceNameDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getPSWorkspaceName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceName_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWorkspaceSumId(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isPSWorkspaceSumIdDirty() && !bl2 : !pSWorkspaceSum.isPSWorkspaceSumIdDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getPSWorkspaceSumId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACESUMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceSumId_Default(pSWorkspaceSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACESUMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWorkspaceSumName(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isPSWorkspaceSumNameDirty() && !bl2 : !pSWorkspaceSum.isPSWorkspaceSumNameDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getPSWorkspaceSumName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACESUMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWorkspaceSumName_Default(pSWorkspaceSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWORKSPACESUMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SumTag(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isSumTagDirty() && !bl2 : !pSWorkspaceSum.isSumTagDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getSumTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUMTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SumTag_Default(pSWorkspaceSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SumTag2(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isSumTag2Dirty() : !pSWorkspaceSum.isSumTag2Dirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getSumTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SumTag2_Default(pSWorkspaceSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SumType(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isSumTypeDirty() && !bl2 : !pSWorkspaceSum.isSumTypeDirty()) {
            return null;
        }
        String string = pSWorkspaceSum.getSumType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SumType_Default(pSWorkspaceSum, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Value(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isValueDirty() : !pSWorkspaceSum.isValueDirty()) {
            return null;
        }
        Integer n = pSWorkspaceSum.getValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value2(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isValue2Dirty() : !pSWorkspaceSum.isValue2Dirty()) {
            return null;
        }
        Integer n = pSWorkspaceSum.getValue2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value2_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value3(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isValue3Dirty() : !pSWorkspaceSum.isValue3Dirty()) {
            return null;
        }
        Integer n = pSWorkspaceSum.getValue3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value3_Default(pSWorkspaceSum, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value4(boolean bl, PSWorkspaceSum pSWorkspaceSum, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWorkspaceSum.isValue4Dirty() : !pSWorkspaceSum.isValue4Dirty()) {
            return null;
        }
        Integer n = pSWorkspaceSum.getValue4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Value4_Default(pSWorkspaceSum, bl2, bl3);
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

    protected void onSyncEntity(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        super.onSyncEntity(pSWorkspaceSum, bl);
    }

    protected void onSyncIndexEntities(PSWorkspaceSum pSWorkspaceSum, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWorkspaceSum, bl);
    }

    public Object getDataContextValue(PSWorkspaceSum pSWorkspaceSum, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWorkspaceSum, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWorkspaceSum pSWorkspaceSum, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWorkspaceSum, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACESUMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceSumId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWORKSPACESUMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWorkspaceSumName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SumTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SumTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_SumType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Value2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Value3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
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

    protected String onTestValueRule_PSWorkspaceSumId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACESUMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWorkspaceSumName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWORKSPACESUMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SumTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SumTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUMTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SumType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUMTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSWorkspaceSum pSWorkspaceSum) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWorkspaceSum)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWorkspaceSum pSWorkspaceSum) throws Exception {
        super.onUpdateParent(pSWorkspaceSum);
    }

    @Override
    protected void exportCurXmlModel(PSWorkspaceSum pSWorkspaceSum, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWORKSPACESUM");
        if (!bl) {
            pSWorkspaceSum.setCreateDate(null);
            pSWorkspaceSum.setCreateMan(null);
            pSWorkspaceSum.setPSWorkspaceSumId(null);
            pSWorkspaceSum.setUpdateDate(null);
            pSWorkspaceSum.setUpdateMan(null);
            super.exportCurXmlModel(pSWorkspaceSum, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSWorkspaceSum pSWorkspaceSum, PSSystem pSSystem) throws Exception {
        PSWorkspaceSum pSWorkspaceSum2 = new PSWorkspaceSum();
        pSWorkspaceSum2.setPSWorkspaceId(pSWorkspaceSum.getPSWorkspaceId());
        pSWorkspaceSum2.setSumType(pSWorkspaceSum.getSumType());
        pSWorkspaceSum2.setSumTag(pSWorkspaceSum.getSumTag());
        pSWorkspaceSum2.setSumTag2(pSWorkspaceSum.getSumTag2());
        pSWorkspaceSum2.setPSDCWorkspaceId(pSWorkspaceSum.getPSDCWorkspaceId());
        if (this.selectOne(pSWorkspaceSum2, true)) {
            return pSWorkspaceSum2.getPSWorkspaceSumId();
        }
        return super.getEntityFolderKeyValue(pSWorkspaceSum, pSSystem);
    }
}

