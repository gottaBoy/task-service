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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSModelExampleStepDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelExampleStepDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleBase;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleStep;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleStepServiceBase
extends PSCoreSysServiceBase<PSModelExampleStep> {
    private static final Log log = LogFactory.getLog(PSModelExampleStepServiceBase.class);
    private PSModelExampleStepDEModel pSModelExampleStepDEModel;
    private PSModelExampleStepDAO pSModelExampleStepDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelExampleStepService";
    }

    public PSModelExampleStepDEModel getPSModelExampleStepDEModel() {
        if (this.pSModelExampleStepDEModel == null) {
            try {
                this.pSModelExampleStepDEModel = (PSModelExampleStepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelExampleStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleStepDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelExampleStepDEModel();
    }

    public PSModelExampleStepDAO getPSModelExampleStepDAO() {
        if (this.pSModelExampleStepDAO == null) {
            try {
                this.pSModelExampleStepDAO = (PSModelExampleStepDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelExampleStepDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleStepDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelExampleStepDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSModelExampleStep pSModelExampleStep, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELEXAMPLESTEP_PSMODELEXAMPLE_PSMODELEXAMPLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleService", (SessionFactory)this.getSessionFactory());
            PSModelExample pSModelExample = (PSModelExample)iService.getDEModel().createEntity();
            pSModelExample.set("PSMODELEXAMPLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelExample);
            } else {
                iService.get((IEntity)pSModelExample);
            }
            this.onFillParentInfo_PSModelExample(pSModelExampleStep, pSModelExample);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelExampleStep, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelExample(PSModelExampleStep pSModelExampleStep, PSModelExample pSModelExample) throws Exception {
        pSModelExampleStep.setPSModelExampleId(pSModelExample.getPSModelExampleId());
        pSModelExampleStep.setPSModelExampleName(pSModelExample.getPSModelExampleName());
    }

    protected void onFillEntityFullInfo(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
        if (bl && pSModelExampleStep.getValidFlag() == null) {
            pSModelExampleStep.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSModelExampleStep, bl);
        this.onFillEntityFullInfo_PSModelExample(pSModelExampleStep, bl);
    }

    protected void onFillEntityFullInfo_PSModelExample(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelExampleStep, bl);
    }

    public ArrayList<PSModelExampleStep> selectByPSModelExample(PSModelExampleBase pSModelExampleBase) throws Exception {
        return this.selectByPSModelExample(pSModelExampleBase, "", -1);
    }

    public ArrayList<PSModelExampleStep> selectByPSModelExample(PSModelExampleBase pSModelExampleBase, String string) throws Exception {
        return this.selectByPSModelExample(pSModelExampleBase, string, -1);
    }

    public ArrayList<PSModelExampleStep> selectByPSModelExample(PSModelExampleBase pSModelExampleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELEXAMPLEID", (Object)pSModelExampleBase.getPSModelExampleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelExampleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelExampleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelExample(PSModelExample pSModelExample) throws Exception {
    }

    public void resetPSModelExample(PSModelExample pSModelExample) throws Exception {
        ArrayList<PSModelExampleStep> arrayList = this.selectByPSModelExample(pSModelExample);
        for (PSModelExampleStep pSModelExampleStep : arrayList) {
            PSModelExampleStep pSModelExampleStep2 = (PSModelExampleStep)this.getDEModel().createEntity();
            pSModelExampleStep2.setPSModelExampleStepId(pSModelExampleStep.getPSModelExampleStepId());
            pSModelExampleStep2.setPSModelExampleId(null);
            this.update(pSModelExampleStep2);
        }
    }

    public void removeByPSModelExample(PSModelExample pSModelExample) throws Exception {
        final PSModelExample pSModelExample2 = pSModelExample;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelExampleStepServiceBase.this.onBeforeRemoveByPSModelExample(pSModelExample2);
                PSModelExampleStepServiceBase.this.internalRemoveByPSModelExample(pSModelExample2);
                PSModelExampleStepServiceBase.this.onAfterRemoveByPSModelExample(pSModelExample2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelExample(PSModelExample pSModelExample) throws Exception {
    }

    protected void internalRemoveByPSModelExample(PSModelExample pSModelExample) throws Exception {
        ArrayList<PSModelExampleStep> arrayList = this.selectByPSModelExample(pSModelExample);
        this.onBeforeRemoveByPSModelExample(pSModelExample, arrayList);
        for (PSModelExampleStep pSModelExampleStep : arrayList) {
            this.remove((IEntity)pSModelExampleStep);
        }
        this.onAfterRemoveByPSModelExample(pSModelExample, arrayList);
    }

    protected void onAfterRemoveByPSModelExample(PSModelExample pSModelExample) throws Exception {
    }

    protected void onBeforeRemoveByPSModelExample(PSModelExample pSModelExample, ArrayList<PSModelExampleStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelExample(PSModelExample pSModelExample, ArrayList<PSModelExampleStep> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelExampleStep pSModelExampleStep) throws Exception {
        super.onBeforeRemove(pSModelExampleStep);
    }

    protected void replaceParentInfo(PSModelExampleStep pSModelExampleStep, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelExampleStep, cloneSession);
        if (pSModelExampleStep.getPSModelExampleId() != null && (iEntity = cloneSession.getEntity("PSMODELEXAMPLE", (Object)pSModelExampleStep.getPSModelExampleId())) != null) {
            this.onFillParentInfo_PSModelExample(pSModelExampleStep, (PSModelExample)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelExampleStep, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSModelExampleStep, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentAsCode(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImageFlag(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkFlag(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleId(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleStepId(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleStepName(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepSN(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelExampleStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelExampleStep, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isBottomContentDirty() : !pSModelExampleStep.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isContentDirty() : !pSModelExampleStep.isContentDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentAsCode(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isContentAsCodeDirty() : !pSModelExampleStep.isContentAsCodeDirty()) {
            return null;
        }
        Integer n = pSModelExampleStep.getContentAsCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ContentAsCode_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTASCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isHeaderContentDirty() : !pSModelExampleStep.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImageFlag(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isImageFlagDirty() : !pSModelExampleStep.isImageFlagDirty()) {
            return null;
        }
        Integer n = pSModelExampleStep.getImageFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImageFlag_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMAGEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkFlag(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isLinkFlagDirty() : !pSModelExampleStep.isLinkFlagDirty()) {
            return null;
        }
        Integer n = pSModelExampleStep.getLinkFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkFlag_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isMemoDirty() : !pSModelExampleStep.isMemoDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelExampleStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isOrderValueDirty() : !pSModelExampleStep.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelExampleStep.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleId(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isPSModelExampleIdDirty() : !pSModelExampleStep.isPSModelExampleIdDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getPSModelExampleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleId_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleStepId(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isPSModelExampleStepIdDirty() && !bl2 : !pSModelExampleStep.isPSModelExampleStepIdDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getPSModelExampleStepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLESTEPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleStepId_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLESTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleStepName(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isPSModelExampleStepNameDirty() && !bl2 : !pSModelExampleStep.isPSModelExampleStepNameDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getPSModelExampleStepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLESTEPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleStepName_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLESTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepSN(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isStepSNDirty() : !pSModelExampleStep.isStepSNDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getStepSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepSN_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isTitleDirty() : !pSModelExampleStep.isTitleDirty()) {
            return null;
        }
        String string = pSModelExampleStep.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSModelExampleStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelExampleStep pSModelExampleStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExampleStep.isValidFlagDirty() && !bl2 : !pSModelExampleStep.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelExampleStep.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSModelExampleStep, bl2, bl3);
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

    protected void onSyncEntity(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelExampleStep, bl);
    }

    protected void onSyncIndexEntities(PSModelExampleStep pSModelExampleStep, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelExampleStep, bl);
    }

    public Object getDataContextValue(PSModelExampleStep pSModelExampleStep, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelExampleStep, string, iDataContextParam)) != null) {
            return object;
        }
        PSModelExample pSModelExample = pSModelExampleStep.getPSModelExample();
        if (pSModelExample != null && pSModelExample.contains(string)) {
            return pSModelExample.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSModelExampleStep pSModelExampleStep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelExampleStep, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTASCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ContentAsCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMAGEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ImageFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_LinkFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLESTEPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleStepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLESTEPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleStepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_StepSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentAsCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImageFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSModelExampleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleStepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLESTEPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleStepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLESTEPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPSN", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelExampleStep pSModelExampleStep) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelExampleStep)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelExampleStep pSModelExampleStep) throws Exception {
        super.onUpdateParent((IEntity)pSModelExampleStep);
    }

    @Override
    protected void exportCurXmlModel(PSModelExampleStep pSModelExampleStep, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELEXAMPLESTEP");
        if (!bl) {
            pSModelExampleStep.setCreateDate(null);
            pSModelExampleStep.setCreateMan(null);
            pSModelExampleStep.setPSModelExampleName(null);
            pSModelExampleStep.setPSModelExampleStepId(null);
            pSModelExampleStep.setUpdateDate(null);
            pSModelExampleStep.setUpdateMan(null);
            super.exportCurXmlModel(pSModelExampleStep, xmlNode, bl);
        }
    }
}

