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
package net.ibizsys.pscore.srv.wfplatform.service;

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
import net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCWFInstDAO;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWFInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppEntityBase;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWFInst;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWorkflow;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWorkflowBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCWFInstServiceBase
extends PSCoreSysServiceBase<PSWPDCWFInst> {
    private static final Log log = LogFactory.getLog(PSWPDCWFInstServiceBase.class);
    private PSWPDCWFInstDEModel pSWPDCWFInstDEModel;
    private PSWPDCWFInstDAO pSWPDCWFInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFInstService";
    }

    public PSWPDCWFInstDEModel getPSWPDCWFInstDEModel() {
        if (this.pSWPDCWFInstDEModel == null) {
            try {
                this.pSWPDCWFInstDEModel = (PSWPDCWFInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWFInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCWFInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWPDCWFInstDEModel();
    }

    public PSWPDCWFInstDAO getPSWPDCWFInstDAO() {
        if (this.pSWPDCWFInstDAO == null) {
            try {
                this.pSWPDCWFInstDAO = (PSWPDCWFInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCWFInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCWFInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWPDCWFInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSWPDCWFInst pSWPDCWFInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCWFINST_PSWPDCAPPENTITY_PSWPDCAPPENTITYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService", (SessionFactory)this.getSessionFactory());
            PSWPDCAppEntity pSWPDCAppEntity = (PSWPDCAppEntity)iService.getDEModel().createEntity();
            pSWPDCAppEntity.set("PSWPDCAPPENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPDCAppEntity);
            } else {
                iService.get(pSWPDCAppEntity);
            }
            this.onFillParentInfo_Pswpdcappentity(pSWPDCWFInst, pSWPDCAppEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWPDCWFINST_PSWPDCWORKFLOW_PSWPDCWORKFLOWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWPDCWorkflow pSWPDCWorkflow = (PSWPDCWorkflow)iService.getDEModel().createEntity();
            pSWPDCWorkflow.set("PSWPDCWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWPDCWorkflow);
            } else {
                iService.get(pSWPDCWorkflow);
            }
            this.onFillParentInfo_Pswpdcworkflow(pSWPDCWFInst, pSWPDCWorkflow);
            return;
        }
        super.onFillParentInfo(pSWPDCWFInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pswpdcappentity(PSWPDCWFInst pSWPDCWFInst, PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        pSWPDCWFInst.setPSWPDCAppEntityId(pSWPDCAppEntity.getPSWPDCAppEntityId());
        pSWPDCWFInst.setPSWPDCAppEntityName(pSWPDCAppEntity.getPSWPDCAppEntityName());
    }

    protected void onFillParentInfo_Pswpdcworkflow(PSWPDCWFInst pSWPDCWFInst, PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
        pSWPDCWFInst.setPSWPDCWorkflowId(pSWPDCWorkflow.getPSWPDCWorkflowId());
        pSWPDCWFInst.setPSWPDCWorkflowName(pSWPDCWorkflow.getPSWPDCWorkflowName());
    }

    protected void onFillEntityFullInfo(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWPDCWFInst, bl);
        this.onFillEntityFullInfo_Pswpdcappentity(pSWPDCWFInst, bl);
        this.onFillEntityFullInfo_Pswpdcworkflow(pSWPDCWFInst, bl);
    }

    protected void onFillEntityFullInfo_Pswpdcappentity(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pswpdcworkflow(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSWPDCWFInst, bl);
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcappentity(PSWPDCAppEntityBase pSWPDCAppEntityBase) throws Exception {
        return this.selectByPswpdcappentity(pSWPDCAppEntityBase, "", -1);
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcappentity(PSWPDCAppEntityBase pSWPDCAppEntityBase, String string) throws Exception {
        return this.selectByPswpdcappentity(pSWPDCAppEntityBase, string, -1);
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcappentity(PSWPDCAppEntityBase pSWPDCAppEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPDCAPPENTITYID", (Object)pSWPDCAppEntityBase.getPSWPDCAppEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPswpdcappentityCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPswpdcappentityCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcworkflow(PSWPDCWorkflowBase pSWPDCWorkflowBase) throws Exception {
        return this.selectByPswpdcworkflow(pSWPDCWorkflowBase, "", -1);
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcworkflow(PSWPDCWorkflowBase pSWPDCWorkflowBase, String string) throws Exception {
        return this.selectByPswpdcworkflow(pSWPDCWorkflowBase, string, -1);
    }

    public ArrayList<PSWPDCWFInst> selectByPswpdcworkflow(PSWPDCWorkflowBase pSWPDCWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWPDCWORKFLOWID", (Object)pSWPDCWorkflowBase.getPSWPDCWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPswpdcworkflowCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPswpdcworkflowCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcappentity(pSWPDCAppEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPDCAPPENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPDCAppEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCWFINST_PSWPDCAPPENTITY_PSWPDCAPPENTITYID", "", iDataEntityModel.getName(), "PSWPDCWFINST", iDataEntityModel.getDataInfo(pSWPDCAppEntity), arrayList.get(0)));
        }
    }

    public void resetPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcappentity(pSWPDCAppEntity);
        for (PSWPDCWFInst pSWPDCWFInst : arrayList) {
            PSWPDCWFInst pSWPDCWFInst2 = (PSWPDCWFInst)this.getDEModel().createEntity();
            pSWPDCWFInst2.setPSWPDCWFInstId(pSWPDCWFInst.getPSWPDCWFInstId());
            pSWPDCWFInst2.setPSWPDCAppEntityId(null);
            this.update(pSWPDCWFInst2);
        }
    }

    public void removeByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        final PSWPDCAppEntity pSWPDCAppEntity2 = pSWPDCAppEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCWFInstServiceBase.this.onBeforeRemoveByPswpdcappentity(pSWPDCAppEntity2);
                PSWPDCWFInstServiceBase.this.internalRemoveByPswpdcappentity(pSWPDCAppEntity2);
                PSWPDCWFInstServiceBase.this.onAfterRemoveByPswpdcappentity(pSWPDCAppEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
    }

    protected void internalRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcappentity(pSWPDCAppEntity);
        this.onBeforeRemoveByPswpdcappentity(pSWPDCAppEntity, arrayList);
        for (PSWPDCWFInst pSWPDCWFInst : arrayList) {
            this.remove(pSWPDCWFInst);
        }
        this.onAfterRemoveByPswpdcappentity(pSWPDCAppEntity, arrayList);
    }

    protected void onAfterRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity) throws Exception {
    }

    protected void onBeforeRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity, ArrayList<PSWPDCWFInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPswpdcappentity(PSWPDCAppEntity pSWPDCAppEntity, ArrayList<PSWPDCWFInst> arrayList) throws Exception {
    }

    public void testRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcworkflow(pSWPDCWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWPDCWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWPDCWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWPDCWFINST_PSWPDCWORKFLOW_PSWPDCWORKFLOWID", "", iDataEntityModel.getName(), "PSWPDCWFINST", iDataEntityModel.getDataInfo(pSWPDCWorkflow), arrayList.get(0)));
        }
    }

    public void resetPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcworkflow(pSWPDCWorkflow);
        for (PSWPDCWFInst pSWPDCWFInst : arrayList) {
            PSWPDCWFInst pSWPDCWFInst2 = (PSWPDCWFInst)this.getDEModel().createEntity();
            pSWPDCWFInst2.setPSWPDCWFInstId(pSWPDCWFInst.getPSWPDCWFInstId());
            pSWPDCWFInst2.setPSWPDCWorkflowId(null);
            this.update(pSWPDCWFInst2);
        }
    }

    public void removeByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
        final PSWPDCWorkflow pSWPDCWorkflow2 = pSWPDCWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWPDCWFInstServiceBase.this.onBeforeRemoveByPswpdcworkflow(pSWPDCWorkflow2);
                PSWPDCWFInstServiceBase.this.internalRemoveByPswpdcworkflow(pSWPDCWorkflow2);
                PSWPDCWFInstServiceBase.this.onAfterRemoveByPswpdcworkflow(pSWPDCWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
    }

    protected void internalRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
        ArrayList<PSWPDCWFInst> arrayList = this.selectByPswpdcworkflow(pSWPDCWorkflow);
        this.onBeforeRemoveByPswpdcworkflow(pSWPDCWorkflow, arrayList);
        for (PSWPDCWFInst pSWPDCWFInst : arrayList) {
            this.remove(pSWPDCWFInst);
        }
        this.onAfterRemoveByPswpdcworkflow(pSWPDCWorkflow, arrayList);
    }

    protected void onAfterRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow, ArrayList<PSWPDCWFInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPswpdcworkflow(PSWPDCWorkflow pSWPDCWorkflow, ArrayList<PSWPDCWFInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWPDCWFInst pSWPDCWFInst) throws Exception {
        super.onBeforeRemove(pSWPDCWFInst);
    }

    protected void replaceParentInfo(PSWPDCWFInst pSWPDCWFInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWPDCWFInst, cloneSession);
        if (pSWPDCWFInst.getPSWPDCAppEntityId() != null && (iEntity = cloneSession.getEntity("PSWPDCAPPENTITY", (Object)pSWPDCWFInst.getPSWPDCAppEntityId())) != null) {
            this.onFillParentInfo_Pswpdcappentity(pSWPDCWFInst, (PSWPDCAppEntity)iEntity);
        }
        if (pSWPDCWFInst.getPSWPDCWorkflowId() != null && (iEntity = cloneSession.getEntity("PSWPDCWORKFLOW", (Object)pSWPDCWFInst.getPSWPDCWorkflowId())) != null) {
            this.onFillParentInfo_Pswpdcworkflow(pSWPDCWFInst, (PSWPDCWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWPDCWFInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSWPDCAppEntityId(bl, pSWPDCWFInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCWFInstId(bl, pSWPDCWFInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCWFInstName(bl, pSWPDCWFInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWPDCWorkflowId(bl, pSWPDCWFInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFInstSN(bl, pSWPDCWFInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWPDCWFInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSWPDCAppEntityId(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCWFInst.isPSWPDCAppEntityIdDirty() && !bl2 : !pSWPDCWFInst.isPSWPDCAppEntityIdDirty()) {
            return null;
        }
        String string = pSWPDCWFInst.getPSWPDCAppEntityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCAppEntityId_Default(pSWPDCWFInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCAPPENTITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCWFInstId(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCWFInst.isPSWPDCWFInstIdDirty() && !bl2 : !pSWPDCWFInst.isPSWPDCWFInstIdDirty()) {
            return null;
        }
        String string = pSWPDCWFInst.getPSWPDCWFInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWFINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCWFInstId_Default(pSWPDCWFInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWFINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCWFInstName(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCWFInst.isPSWPDCWFInstNameDirty() && !bl2 : !pSWPDCWFInst.isPSWPDCWFInstNameDirty()) {
            return null;
        }
        String string = pSWPDCWFInst.getPSWPDCWFInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWFINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCWFInstName_Default(pSWPDCWFInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWFINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWPDCWorkflowId(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCWFInst.isPSWPDCWorkflowIdDirty() && !bl2 : !pSWPDCWFInst.isPSWPDCWorkflowIdDirty()) {
            return null;
        }
        String string = pSWPDCWFInst.getPSWPDCWorkflowId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWORKFLOWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWPDCWorkflowId_Default(pSWPDCWFInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWPDCWORKFLOWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFInstSN(boolean bl, PSWPDCWFInst pSWPDCWFInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWPDCWFInst.isWFInstSNDirty() && !bl2 : !pSWPDCWFInst.isWFInstSNDirty()) {
            return null;
        }
        String string = pSWPDCWFInst.getWFInstSN();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTSN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFInstSN_Default(pSWPDCWFInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
        super.onSyncEntity(pSWPDCWFInst, bl);
    }

    protected void onSyncIndexEntities(PSWPDCWFInst pSWPDCWFInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWPDCWFInst, bl);
    }

    public Object getDataContextValue(PSWPDCWFInst pSWPDCWFInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWPDCWFInst, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSWPDCWFInst pSWPDCWFInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWPDCWFInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPENTITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppEntityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCAPPENTITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCAppEntityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCWFINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCWFInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCWFINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCWFInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCWORKFLOWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCWorkflowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWPDCWORKFLOWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSWPDCWorkflowName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFINSTSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_WFInstSN_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSWPDCAppEntityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPENTITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCAppEntityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCAPPENTITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCWFInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCWFINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCWFInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCWFINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCWorkflowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCWORKFLOWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWPDCWorkflowName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWPDCWORKFLOWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_WFInstSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFINSTSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSWPDCWFInst pSWPDCWFInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWPDCWFInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWPDCWFInst pSWPDCWFInst) throws Exception {
        super.onUpdateParent(pSWPDCWFInst);
    }

    @Override
    protected void exportCurXmlModel(PSWPDCWFInst pSWPDCWFInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWPDCWFINST");
        if (!bl) {
            pSWPDCWFInst.setCreateDate(null);
            pSWPDCWFInst.setCreateMan(null);
            pSWPDCWFInst.setPSWPDCWFInstId(null);
            pSWPDCWFInst.setUpdateDate(null);
            pSWPDCWFInst.setUpdateMan(null);
            super.exportCurXmlModel(pSWPDCWFInst, xmlNode, bl);
        }
    }
}

