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
import net.ibizsys.pscore.srv.config.dao.PSModelSectionDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelSectionDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelModule;
import net.ibizsys.pscore.srv.config.entity.PSModelModuleBase;
import net.ibizsys.pscore.srv.config.entity.PSModelSection;
import net.ibizsys.pscore.srv.config.entity.PSModelSectionBase;
import net.ibizsys.pscore.srv.config.service.PSModelSectionService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelSectionServiceBase
extends PSCoreSysServiceBase<PSModelSection> {
    private static final Log log = LogFactory.getLog(PSModelSectionServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelSectionDEModel pSModelSectionDEModel;
    private PSModelSectionDAO pSModelSectionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelSectionService";
    }

    public PSModelSectionDEModel getPSModelSectionDEModel() {
        if (this.pSModelSectionDEModel == null) {
            try {
                this.pSModelSectionDEModel = (PSModelSectionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelSectionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSectionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelSectionDEModel();
    }

    public PSModelSectionDAO getPSModelSectionDAO() {
        if (this.pSModelSectionDAO == null) {
            try {
                this.pSModelSectionDAO = (PSModelSectionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelSectionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelSectionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelSectionDAO();
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

    protected void onFillParentInfo(PSModelSection pSModelSection, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELSECTION_PSMODELMODULE_PSMODELMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelModuleService", (SessionFactory)this.getSessionFactory());
            PSModelModule pSModelModule = (PSModelModule)iService.getDEModel().createEntity();
            pSModelModule.set("PSMODELMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelModule);
            } else {
                iService.get(pSModelModule);
            }
            this.onFillParentInfo_Psmodelmodule(pSModelSection, pSModelModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELSECTION_PSMODELSECTION_PPSMODELSECTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelSectionService", (SessionFactory)this.getSessionFactory());
            PSModelSection pSModelSection2 = (PSModelSection)iService.getDEModel().createEntity();
            pSModelSection2.set("PSMODELSECTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelSection2);
            } else {
                iService.get(pSModelSection2);
            }
            this.onFillParentInfo_Ppsmodelsection(pSModelSection, pSModelSection2);
            return;
        }
        super.onFillParentInfo(pSModelSection, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psmodelmodule(PSModelSection pSModelSection, PSModelModule pSModelModule) throws Exception {
        pSModelSection.setPSModelModuleId(pSModelModule.getPSModelModuleId());
        pSModelSection.setPSModelModuleName(pSModelModule.getPSModelModuleName());
    }

    protected void onFillParentInfo_Ppsmodelsection(PSModelSection pSModelSection, PSModelSection pSModelSection2) throws Exception {
        pSModelSection.setPPSModelSectionId(pSModelSection2.getPSModelSectionId());
        pSModelSection.setPPSModelSectionName(pSModelSection2.getPSModelSectionName());
    }

    protected void onFillEntityFullInfo(PSModelSection pSModelSection, boolean bl) throws Exception {
        if (bl && pSModelSection.getValidFlag() == null) {
            pSModelSection.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelSection, bl);
        this.onFillEntityFullInfo_Psmodelmodule(pSModelSection, bl);
        this.onFillEntityFullInfo_Ppsmodelsection(pSModelSection, bl);
    }

    protected void onFillEntityFullInfo_Psmodelmodule(PSModelSection pSModelSection, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Ppsmodelsection(PSModelSection pSModelSection, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSModelSection pSModelSection, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelSection, bl);
    }

    public ArrayList<PSModelSection> selectByPsmodelmodule(PSModelModuleBase pSModelModuleBase) throws Exception {
        return this.selectByPsmodelmodule(pSModelModuleBase, "", -1);
    }

    public ArrayList<PSModelSection> selectByPsmodelmodule(PSModelModuleBase pSModelModuleBase, String string) throws Exception {
        return this.selectByPsmodelmodule(pSModelModuleBase, string, -1);
    }

    public ArrayList<PSModelSection> selectByPsmodelmodule(PSModelModuleBase pSModelModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELMODULEID", (Object)pSModelModuleBase.getPSModelModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmodelmoduleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmodelmoduleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelSection> selectByPpsmodelsection(PSModelSectionBase pSModelSectionBase) throws Exception {
        return this.selectByPpsmodelsection(pSModelSectionBase, "", -1);
    }

    public ArrayList<PSModelSection> selectByPpsmodelsection(PSModelSectionBase pSModelSectionBase, String string) throws Exception {
        return this.selectByPpsmodelsection(pSModelSectionBase, string, -1);
    }

    public ArrayList<PSModelSection> selectByPpsmodelsection(PSModelSectionBase pSModelSectionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSMODELSECTIONID", (Object)pSModelSectionBase.getPSModelSectionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpsmodelsectionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpsmodelsectionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPsmodelmodule(pSModelModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELSECTION_PSMODELMODULE_PSMODELMODULEID", "", iDataEntityModel.getName(), "PSMODELSECTION", iDataEntityModel.getDataInfo(pSModelModule), arrayList.get(0)));
        }
    }

    public void resetPsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPsmodelmodule(pSModelModule);
        for (PSModelSection pSModelSection : arrayList) {
            PSModelSection pSModelSection2 = (PSModelSection)this.getDEModel().createEntity();
            pSModelSection2.setPSModelSectionId(pSModelSection.getPSModelSectionId());
            pSModelSection2.setPSModelModuleId(null);
            this.update(pSModelSection2);
        }
    }

    public void removeByPsmodelmodule(PSModelModule pSModelModule) throws Exception {
        final PSModelModule pSModelModule2 = pSModelModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSectionServiceBase.this.onBeforeRemoveByPsmodelmodule(pSModelModule2);
                PSModelSectionServiceBase.this.internalRemoveByPsmodelmodule(pSModelModule2);
                PSModelSectionServiceBase.this.onAfterRemoveByPsmodelmodule(pSModelModule2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodelmodule(PSModelModule pSModelModule) throws Exception {
    }

    protected void internalRemoveByPsmodelmodule(PSModelModule pSModelModule) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPsmodelmodule(pSModelModule);
        this.onBeforeRemoveByPsmodelmodule(pSModelModule, arrayList);
        for (PSModelSection pSModelSection : arrayList) {
            this.remove(pSModelSection);
        }
        this.onAfterRemoveByPsmodelmodule(pSModelModule, arrayList);
    }

    protected void onAfterRemoveByPsmodelmodule(PSModelModule pSModelModule) throws Exception {
    }

    protected void onBeforeRemoveByPsmodelmodule(PSModelModule pSModelModule, ArrayList<PSModelSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodelmodule(PSModelModule pSModelModule, ArrayList<PSModelSection> arrayList) throws Exception {
    }

    public void testRemoveByPpsmodelsection(PSModelSection pSModelSection) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPpsmodelsection(pSModelSection, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELSECTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelSection);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELSECTION_PSMODELSECTION_PPSMODELSECTIONID", "", iDataEntityModel.getName(), "PSMODELSECTION", iDataEntityModel.getDataInfo(pSModelSection), arrayList.get(0)));
        }
    }

    public void resetPpsmodelsection(PSModelSection pSModelSection) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPpsmodelsection(pSModelSection);
        for (PSModelSection pSModelSection2 : arrayList) {
            PSModelSection pSModelSection3 = (PSModelSection)this.getDEModel().createEntity();
            pSModelSection3.setPSModelSectionId(pSModelSection2.getPSModelSectionId());
            pSModelSection3.setPPSModelSectionId(null);
            this.update(pSModelSection3);
        }
    }

    public void removeByPpsmodelsection(PSModelSection pSModelSection) throws Exception {
        final PSModelSection pSModelSection2 = pSModelSection;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSectionServiceBase.this.onBeforeRemoveByPpsmodelsection(pSModelSection2);
                PSModelSectionServiceBase.this.internalRemoveByPpsmodelsection(pSModelSection2);
                PSModelSectionServiceBase.this.onAfterRemoveByPpsmodelsection(pSModelSection2);
            }
        });
    }

    protected void onBeforeRemoveByPpsmodelsection(PSModelSection pSModelSection) throws Exception {
    }

    protected void internalRemoveByPpsmodelsection(PSModelSection pSModelSection) throws Exception {
        ArrayList<PSModelSection> arrayList = this.selectByPpsmodelsection(pSModelSection);
        this.onBeforeRemoveByPpsmodelsection(pSModelSection, arrayList);
        for (PSModelSection pSModelSection2 : arrayList) {
            this.remove(pSModelSection2);
        }
        this.onAfterRemoveByPpsmodelsection(pSModelSection, arrayList);
    }

    protected void onAfterRemoveByPpsmodelsection(PSModelSection pSModelSection) throws Exception {
    }

    protected void onBeforeRemoveByPpsmodelsection(PSModelSection pSModelSection, ArrayList<PSModelSection> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpsmodelsection(PSModelSection pSModelSection, ArrayList<PSModelSection> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelSection pSModelSection) throws Exception {
        PSModelSectionService pSModelSectionService = (PSModelSectionService)ServiceGlobal.getService(PSModelSectionService.class, (SessionFactory)this.getSessionFactory());
        pSModelSectionService.testRemoveByPpsmodelsection(pSModelSection);
        super.onBeforeRemove(pSModelSection);
    }

    protected void replaceParentInfo(PSModelSection pSModelSection, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelSection, cloneSession);
        if (pSModelSection.getPSModelModuleId() != null && (iEntity = cloneSession.getEntity("PSMODELMODULE", (Object)pSModelSection.getPSModelModuleId())) != null) {
            this.onFillParentInfo_Psmodelmodule(pSModelSection, (PSModelModule)iEntity);
        }
        if (pSModelSection.getPPSModelSectionId() != null && (iEntity = cloneSession.getEntity("PSMODELSECTION", (Object)pSModelSection.getPPSModelSectionId())) != null) {
            this.onFillParentInfo_Ppsmodelsection(pSModelSection, (PSModelSection)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelSection pSModelSection, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelSection, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSModelSection, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSModelSectionId(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelModuleId(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSectionId(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelSectionName(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SectionType(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelSection, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelSection, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isContentDirty() : !pSModelSection.isContentDirty()) {
            return null;
        }
        String string = pSModelSection.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isMemoDirty() : !pSModelSection.isMemoDirty()) {
            return null;
        }
        String string = pSModelSection.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isOrderValueDirty() : !pSModelSection.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelSection.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSModelSectionId(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isPPSModelSectionIdDirty() : !pSModelSection.isPPSModelSectionIdDirty()) {
            return null;
        }
        String string = pSModelSection.getPPSModelSectionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSModelSectionId_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSMODELSECTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelModuleId(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isPSModelModuleIdDirty() : !pSModelSection.isPSModelModuleIdDirty()) {
            return null;
        }
        String string = pSModelSection.getPSModelModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelModuleId_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelSectionId(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isPSModelSectionIdDirty() && !bl2 : !pSModelSection.isPSModelSectionIdDirty()) {
            return null;
        }
        String string = pSModelSection.getPSModelSectionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSECTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSectionId_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSECTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelSectionName(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isPSModelSectionNameDirty() && !bl2 : !pSModelSection.isPSModelSectionNameDirty()) {
            return null;
        }
        String string = pSModelSection.getPSModelSectionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSECTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelSectionName_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELSECTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SectionType(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isSectionTypeDirty() && !bl2 : !pSModelSection.isSectionTypeDirty()) {
            return null;
        }
        String string = pSModelSection.getSectionType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SectionType_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCaption(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isSubCaptionDirty() : !pSModelSection.isSubCaptionDirty()) {
            return null;
        }
        String string = pSModelSection.getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default(pSModelSection, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isUserTagDirty() : !pSModelSection.isUserTagDirty()) {
            return null;
        }
        String string = pSModelSection.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isUserTag2Dirty() : !pSModelSection.isUserTag2Dirty()) {
            return null;
        }
        String string = pSModelSection.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isUserTag3Dirty() : !pSModelSection.isUserTag3Dirty()) {
            return null;
        }
        String string = pSModelSection.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isUserTag4Dirty() : !pSModelSection.isUserTag4Dirty()) {
            return null;
        }
        String string = pSModelSection.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSModelSection, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelSection pSModelSection, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelSection.isValidFlagDirty() && !bl2 : !pSModelSection.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelSection.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelSection, bl2, bl3);
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

    protected void onSyncEntity(PSModelSection pSModelSection, boolean bl) throws Exception {
        super.onSyncEntity(pSModelSection, bl);
    }

    protected void onSyncIndexEntities(PSModelSection pSModelSection, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelSection, bl);
    }

    public Object getDataContextValue(PSModelSection pSModelSection, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelSection, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelSection pSModelSection, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelSection, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELSECTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelSectionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSMODELSECTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSModelSectionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSECTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSectionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELSECTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelSectionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SectionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_PPSModelSectionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELSECTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSMODELSECTIONID", "PSMODELSECTION", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSModelSectionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSMODELSECTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelSectionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSECTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelSectionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELSECTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SectionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECTIONTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPTION", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelSection pSModelSection) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelSection)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelSection pSModelSection) throws Exception {
        super.onUpdateParent(pSModelSection);
    }

    @Override
    protected void exportCurXmlModel(PSModelSection pSModelSection, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELSECTION");
        if (!bl) {
            pSModelSection.setCreateDate(null);
            pSModelSection.setCreateMan(null);
            pSModelSection.setPSModelSectionId(null);
            pSModelSection.setUpdateDate(null);
            pSModelSection.setUpdateMan(null);
            super.exportCurXmlModel(pSModelSection, xmlNode, bl);
        }
    }
}

