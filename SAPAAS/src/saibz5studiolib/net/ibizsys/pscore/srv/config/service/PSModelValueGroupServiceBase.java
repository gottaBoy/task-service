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
import net.ibizsys.pscore.srv.config.dao.PSModelValueGroupDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelValueGroupDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.entity.PSModelFieldBase;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroup;
import net.ibizsys.pscore.srv.config.service.PSModelFieldValueService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelValueGroupServiceBase
extends PSCoreSysServiceBase<PSModelValueGroup> {
    private static final Log log = LogFactory.getLog(PSModelValueGroupServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelValueGroupDEModel pSModelValueGroupDEModel;
    private PSModelValueGroupDAO pSModelValueGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelValueGroupService";
    }

    public PSModelValueGroupDEModel getPSModelValueGroupDEModel() {
        if (this.pSModelValueGroupDEModel == null) {
            try {
                this.pSModelValueGroupDEModel = (PSModelValueGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelValueGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelValueGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelValueGroupDEModel();
    }

    public PSModelValueGroupDAO getPSModelValueGroupDAO() {
        if (this.pSModelValueGroupDAO == null) {
            try {
                this.pSModelValueGroupDAO = (PSModelValueGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelValueGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelValueGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelValueGroupDAO();
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

    protected void onFillParentInfo(PSModelValueGroup pSModelValueGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVALUEGROUP_PSMODELFIELD_PSMODELFIELDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelFieldService", (SessionFactory)this.getSessionFactory());
            PSModelField pSModelField = (PSModelField)iService.getDEModel().createEntity();
            pSModelField.set("PSMODELFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelField);
            } else {
                iService.get(pSModelField);
            }
            this.onFillParentInfo_PSModelField(pSModelValueGroup, pSModelField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVALUEGROUP_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_Psmodel(pSModelValueGroup, pSModel);
            return;
        }
        super.onFillParentInfo(pSModelValueGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelField(PSModelValueGroup pSModelValueGroup, PSModelField pSModelField) throws Exception {
        pSModelValueGroup.setPSModelFieldId(pSModelField.getPSModelFieldId());
        pSModelValueGroup.setPSModelFieldName(pSModelField.getPSModelFieldName());
    }

    protected void onFillParentInfo_Psmodel(PSModelValueGroup pSModelValueGroup, PSModel pSModel) throws Exception {
        pSModelValueGroup.setPSModelId(pSModel.getPSModelId());
        pSModelValueGroup.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSModelValueGroup, bl);
        this.onFillEntityFullInfo_PSModelField(pSModelValueGroup, bl);
        this.onFillEntityFullInfo_Psmodel(pSModelValueGroup, bl);
    }

    protected void onFillEntityFullInfo_PSModelField(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        if (pSModelValueGroup.isPSModelFieldIdDirty()) {
            if (pSModelValueGroup.getPSModelFieldId() != null) {
                if (pSModelValueGroup.getPSModelFieldId() == null || pSModelValueGroup.getPSModelFieldName() == null) {
                    PSModelField pSModelField = pSModelValueGroup.getPSModelField();
                    pSModelValueGroup.setPSModelFieldName(pSModelField.getPSModelFieldName());
                }
            } else {
                pSModelValueGroup.setPSModelFieldName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Psmodel(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        if (pSModelValueGroup.isPSModelIdDirty()) {
            if (pSModelValueGroup.getPSModelId() != null) {
                if (pSModelValueGroup.getPSModelId() == null || pSModelValueGroup.getPSModelName() == null) {
                    PSModel pSModel = pSModelValueGroup.getPsmodel();
                    pSModelValueGroup.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelValueGroup.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelValueGroup, bl);
    }

    public ArrayList<PSModelValueGroup> selectByPSModelField(PSModelFieldBase pSModelFieldBase) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, "", -1);
    }

    public ArrayList<PSModelValueGroup> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string) throws Exception {
        return this.selectByPSModelField(pSModelFieldBase, string, -1);
    }

    public ArrayList<PSModelValueGroup> selectByPSModelField(PSModelFieldBase pSModelFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELFIELDID", (Object)pSModelFieldBase.getPSModelFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelFieldCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelFieldCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelValueGroup> selectByPsmodel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPsmodel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelValueGroup> selectByPsmodel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPsmodel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelValueGroup> selectByPsmodel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmodelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmodelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPSModelField(pSModelField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModelField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELVALUEGROUP_PSMODELFIELD_PSMODELFIELDID", "", iDataEntityModel.getName(), "PSMODELVALUEGROUP", iDataEntityModel.getDataInfo(pSModelField), arrayList.get(0)));
        }
    }

    public void resetPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPSModelField(pSModelField);
        for (PSModelValueGroup pSModelValueGroup : arrayList) {
            PSModelValueGroup pSModelValueGroup2 = (PSModelValueGroup)this.getDEModel().createEntity();
            pSModelValueGroup2.setPSModelValueGroupId(pSModelValueGroup.getPSModelValueGroupId());
            pSModelValueGroup2.setPSModelFieldId(null);
            this.update(pSModelValueGroup2);
        }
    }

    public void removeByPSModelField(PSModelField pSModelField) throws Exception {
        final PSModelField pSModelField2 = pSModelField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelValueGroupServiceBase.this.onBeforeRemoveByPSModelField(pSModelField2);
                PSModelValueGroupServiceBase.this.internalRemoveByPSModelField(pSModelField2);
                PSModelValueGroupServiceBase.this.onAfterRemoveByPSModelField(pSModelField2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void internalRemoveByPSModelField(PSModelField pSModelField) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPSModelField(pSModelField);
        this.onBeforeRemoveByPSModelField(pSModelField, arrayList);
        for (PSModelValueGroup pSModelValueGroup : arrayList) {
            this.remove(pSModelValueGroup);
        }
        this.onAfterRemoveByPSModelField(pSModelField, arrayList);
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField) throws Exception {
    }

    protected void onBeforeRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSModelValueGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelField(PSModelField pSModelField, ArrayList<PSModelValueGroup> arrayList) throws Exception {
    }

    public void testRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPsmodel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELVALUEGROUP_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSMODELVALUEGROUP", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPsmodel(pSModel);
        for (PSModelValueGroup pSModelValueGroup : arrayList) {
            PSModelValueGroup pSModelValueGroup2 = (PSModelValueGroup)this.getDEModel().createEntity();
            pSModelValueGroup2.setPSModelValueGroupId(pSModelValueGroup.getPSModelValueGroupId());
            pSModelValueGroup2.setPSModelId(null);
            this.update(pSModelValueGroup2);
        }
    }

    public void removeByPsmodel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelValueGroupServiceBase.this.onBeforeRemoveByPsmodel(pSModel2);
                PSModelValueGroupServiceBase.this.internalRemoveByPsmodel(pSModel2);
                PSModelValueGroupServiceBase.this.onAfterRemoveByPsmodel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPsmodel(PSModel pSModel) throws Exception {
        ArrayList<PSModelValueGroup> arrayList = this.selectByPsmodel(pSModel);
        this.onBeforeRemoveByPsmodel(pSModel, arrayList);
        for (PSModelValueGroup pSModelValueGroup : arrayList) {
            this.remove(pSModelValueGroup);
        }
        this.onAfterRemoveByPsmodel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelValueGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodel(PSModel pSModel, ArrayList<PSModelValueGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelValueGroup pSModelValueGroup) throws Exception {
        PSModelFieldValueService pSModelFieldValueService = (PSModelFieldValueService)ServiceGlobal.getService(PSModelFieldValueService.class, (SessionFactory)this.getSessionFactory());
        pSModelFieldValueService.testRemoveByPSModelValueGroup(pSModelValueGroup);
        super.onBeforeRemove(pSModelValueGroup);
    }

    protected void replaceParentInfo(PSModelValueGroup pSModelValueGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelValueGroup, cloneSession);
        if (pSModelValueGroup.getPSModelFieldId() != null && (iEntity = cloneSession.getEntity("PSMODELFIELD", (Object)pSModelValueGroup.getPSModelFieldId())) != null) {
            this.onFillParentInfo_PSModelField(pSModelValueGroup, (PSModelField)iEntity);
        }
        if (pSModelValueGroup.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelValueGroup.getPSModelId())) != null) {
            this.onFillParentInfo_Psmodel(pSModelValueGroup, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelValueGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_GroupDesc(bl, pSModelValueGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListName(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldId(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelFieldName(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelValueGroupId(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelValueGroupName(bl, pSModelValueGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelValueGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_GroupDesc(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isGroupDescDirty() : !pSModelValueGroup.isGroupDescDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getGroupDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupDesc_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isMemoDirty() : !pSModelValueGroup.isMemoDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelValueGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSCodeListIdDirty() : !pSModelValueGroup.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListName(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSCodeListNameDirty() : !pSModelValueGroup.isPSCodeListNameDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSCodeListName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListName_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldId(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelFieldIdDirty() : !pSModelValueGroup.isPSModelFieldIdDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelFieldId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldId_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelFieldName(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelFieldNameDirty() : !pSModelValueGroup.isPSModelFieldNameDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelFieldName_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelIdDirty() : !pSModelValueGroup.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelNameDirty() : !pSModelValueGroup.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelValueGroupId(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelValueGroupIdDirty() && !bl2 : !pSModelValueGroup.isPSModelValueGroupIdDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelValueGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVALUEGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelValueGroupId_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVALUEGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelValueGroupName(boolean bl, PSModelValueGroup pSModelValueGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelValueGroup.isPSModelValueGroupNameDirty() && !bl2 : !pSModelValueGroup.isPSModelValueGroupNameDirty()) {
            return null;
        }
        String string = pSModelValueGroup.getPSModelValueGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVALUEGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelValueGroupName_Default(pSModelValueGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVALUEGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSModelValueGroup, bl);
    }

    protected void onSyncIndexEntities(PSModelValueGroup pSModelValueGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelValueGroup, bl);
    }

    public Object getDataContextValue(PSModelValueGroup pSModelValueGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelValueGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelValueGroup pSModelValueGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelValueGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVALUEGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelValueGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVALUEGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelValueGroupName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_GroupDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPDESC", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELFIELDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelValueGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVALUEGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelValueGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVALUEGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelValueGroup pSModelValueGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelValueGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelValueGroup pSModelValueGroup) throws Exception {
        super.onUpdateParent(pSModelValueGroup);
    }

    @Override
    protected void exportCurXmlModel(PSModelValueGroup pSModelValueGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELVALUEGROUP");
        if (!bl) {
            pSModelValueGroup.setCreateDate(null);
            pSModelValueGroup.setCreateMan(null);
            pSModelValueGroup.setPSModelValueGroupId(null);
            pSModelValueGroup.setUpdateDate(null);
            pSModelValueGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSModelValueGroup, xmlNode, bl);
        }
    }
}

