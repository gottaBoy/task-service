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
import net.ibizsys.pscore.srv.config.dao.PSModelRSDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelRSDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelRS;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelRSServiceBase
extends PSCoreSysServiceBase<PSModelRS> {
    private static final Log log = LogFactory.getLog(PSModelRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelRSDEModel pSModelRSDEModel;
    private PSModelRSDAO pSModelRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelRSService";
    }

    public PSModelRSDEModel getPSModelRSDEModel() {
        if (this.pSModelRSDEModel == null) {
            try {
                this.pSModelRSDEModel = (PSModelRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelRSDEModel();
    }

    public PSModelRSDAO getPSModelRSDAO() {
        if (this.pSModelRSDAO == null) {
            try {
                this.pSModelRSDAO = (PSModelRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelRSDAO();
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

    protected void onFillParentInfo(PSModelRS pSModelRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELRS_PSMODEL_MAJORPSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_MajorPSModel(pSModelRS, pSModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELRS_PSMODEL_MINORPSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_MinorPSModel(pSModelRS, pSModel);
            return;
        }
        super.onFillParentInfo(pSModelRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSModel(PSModelRS pSModelRS, PSModel pSModel) throws Exception {
        pSModelRS.setMajorPSModelId(pSModel.getPSModelId());
        pSModelRS.setMajorPSModelName(pSModel.getPSModelName());
    }

    protected void onFillParentInfo_MinorPSModel(PSModelRS pSModelRS, PSModel pSModel) throws Exception {
        pSModelRS.setMinorPSModelId(pSModel.getPSModelId());
        pSModelRS.setMinorPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelRS pSModelRS, boolean bl) throws Exception {
        if (bl && pSModelRS.getValidFlag() == null) {
            pSModelRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelRS, bl);
        this.onFillEntityFullInfo_MajorPSModel(pSModelRS, bl);
        this.onFillEntityFullInfo_MinorPSModel(pSModelRS, bl);
    }

    protected void onFillEntityFullInfo_MajorPSModel(PSModelRS pSModelRS, boolean bl) throws Exception {
        if (pSModelRS.isMajorPSModelIdDirty()) {
            if (pSModelRS.getMajorPSModelId() != null) {
                if (pSModelRS.getMajorPSModelId() == null || pSModelRS.getMajorPSModelName() == null) {
                    PSModel pSModel = pSModelRS.getMajorPSModel();
                    pSModelRS.setMajorPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelRS.setMajorPSModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorPSModel(PSModelRS pSModelRS, boolean bl) throws Exception {
        if (pSModelRS.isMinorPSModelIdDirty()) {
            if (pSModelRS.getMinorPSModelId() != null) {
                if (pSModelRS.getMinorPSModelId() == null || pSModelRS.getMinorPSModelName() == null) {
                    PSModel pSModel = pSModelRS.getMinorPSModel();
                    pSModelRS.setMinorPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelRS.setMinorPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelRS pSModelRS, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelRS, bl);
    }

    public ArrayList<PSModelRS> selectByMajorPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByMajorPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelRS> selectByMajorPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByMajorPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelRS> selectByMajorPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelRS> selectByMinorPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByMinorPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelRS> selectByMinorPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByMinorPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelRS> selectByMinorPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSModelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMajorPSModel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELRS_PSMODEL_MAJORPSMODELID", "", iDataEntityModel.getName(), "PSMODELRS", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetMajorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMajorPSModel(pSModel);
        for (PSModelRS pSModelRS : arrayList) {
            PSModelRS pSModelRS2 = (PSModelRS)this.getDEModel().createEntity();
            pSModelRS2.setPSModelRSId(pSModelRS.getPSModelRSId());
            pSModelRS2.setMajorPSModelId(null);
            this.update(pSModelRS2);
        }
    }

    public void removeByMajorPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelRSServiceBase.this.onBeforeRemoveByMajorPSModel(pSModel2);
                PSModelRSServiceBase.this.internalRemoveByMajorPSModel(pSModel2);
                PSModelRSServiceBase.this.onAfterRemoveByMajorPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByMajorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMajorPSModel(pSModel);
        this.onBeforeRemoveByMajorPSModel(pSModel, arrayList);
        for (PSModelRS pSModelRS : arrayList) {
            this.remove(pSModelRS);
        }
        this.onAfterRemoveByMajorPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByMajorPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSModel(PSModel pSModel, ArrayList<PSModelRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSModel(PSModel pSModel, ArrayList<PSModelRS> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMinorPSModel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELRS_PSMODEL_MINORPSMODELID", "", iDataEntityModel.getName(), "PSMODELRS", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetMinorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMinorPSModel(pSModel);
        for (PSModelRS pSModelRS : arrayList) {
            PSModelRS pSModelRS2 = (PSModelRS)this.getDEModel().createEntity();
            pSModelRS2.setPSModelRSId(pSModelRS.getPSModelRSId());
            pSModelRS2.setMinorPSModelId(null);
            this.update(pSModelRS2);
        }
    }

    public void removeByMinorPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelRSServiceBase.this.onBeforeRemoveByMinorPSModel(pSModel2);
                PSModelRSServiceBase.this.internalRemoveByMinorPSModel(pSModel2);
                PSModelRSServiceBase.this.onAfterRemoveByMinorPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByMinorPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelRS> arrayList = this.selectByMinorPSModel(pSModel);
        this.onBeforeRemoveByMinorPSModel(pSModel, arrayList);
        for (PSModelRS pSModelRS : arrayList) {
            this.remove(pSModelRS);
        }
        this.onAfterRemoveByMinorPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByMinorPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSModel(PSModel pSModel, ArrayList<PSModelRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSModel(PSModel pSModel, ArrayList<PSModelRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelRS pSModelRS) throws Exception {
        super.onBeforeRemove(pSModelRS);
    }

    protected void replaceParentInfo(PSModelRS pSModelRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelRS, cloneSession);
        if (pSModelRS.getMajorPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelRS.getMajorPSModelId())) != null) {
            this.onFillParentInfo_MajorPSModel(pSModelRS, (PSModel)iEntity);
        }
        if (pSModelRS.getMinorPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelRS.getMinorPSModelId())) != null) {
            this.onFillParentInfo_MinorPSModel(pSModelRS, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelRS pSModelRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MajorPSModelId(bl, pSModelRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSModelName(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSModelId(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSModelName(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelRSId(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelRSName(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MajorPSModelId(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isMajorPSModelIdDirty() && !bl2 : !pSModelRS.isMajorPSModelIdDirty()) {
            return null;
        }
        String string = pSModelRS.getMajorPSModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSModelId_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorPSModelName(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isMajorPSModelNameDirty() && !bl2 : !pSModelRS.isMajorPSModelNameDirty()) {
            return null;
        }
        String string = pSModelRS.getMajorPSModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSModelName_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isMemoDirty() : !pSModelRS.isMemoDirty()) {
            return null;
        }
        String string = pSModelRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSModelId(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isMinorPSModelIdDirty() && !bl2 : !pSModelRS.isMinorPSModelIdDirty()) {
            return null;
        }
        String string = pSModelRS.getMinorPSModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSModelId_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSModelName(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isMinorPSModelNameDirty() && !bl2 : !pSModelRS.isMinorPSModelNameDirty()) {
            return null;
        }
        String string = pSModelRS.getMinorPSModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSModelName_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelRSId(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isPSModelRSIdDirty() && !bl2 : !pSModelRS.isPSModelRSIdDirty()) {
            return null;
        }
        String string = pSModelRS.getPSModelRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELRSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelRSId_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELRSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelRSName(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isPSModelRSNameDirty() && !bl2 : !pSModelRS.isPSModelRSNameDirty()) {
            return null;
        }
        String string = pSModelRS.getPSModelRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELRSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelRSName_Default(pSModelRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELRSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelRS pSModelRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelRS.isValidFlagDirty() && !bl2 : !pSModelRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelRS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelRS, bl2, bl3);
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

    protected void onSyncEntity(PSModelRS pSModelRS, boolean bl) throws Exception {
        super.onSyncEntity(pSModelRS, bl);
    }

    protected void onSyncIndexEntities(PSModelRS pSModelRS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelRS, bl);
    }

    public Object getDataContextValue(PSModelRS pSModelRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelRS, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelRS pSModelRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelRS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELRSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELRSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MajorPSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MinorPSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELRSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELRSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelRS pSModelRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelRS pSModelRS) throws Exception {
        super.onUpdateParent(pSModelRS);
    }

    @Override
    protected void exportCurXmlModel(PSModelRS pSModelRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELRS");
        if (!bl) {
            pSModelRS.setCreateDate(null);
            pSModelRS.setCreateMan(null);
            pSModelRS.setPSModelRSId(null);
            pSModelRS.setUpdateDate(null);
            pSModelRS.setUpdateMan(null);
            super.exportCurXmlModel(pSModelRS, xmlNode, bl);
        }
    }
}

