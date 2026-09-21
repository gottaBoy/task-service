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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysAPIDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysAPIDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysAPI;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVerBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysAPIServiceBase
extends PSCoreSysServiceBase<PSSaaSSysAPI> {
    private static final Log log = LogFactory.getLog(PSSaaSSysAPIServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSaaSSysAPIDEModel pSSaaSSysAPIDEModel;
    private PSSaaSSysAPIDAO pSSaaSSysAPIDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAPIService";
    }

    public PSSaaSSysAPIDEModel getPSSaaSSysAPIDEModel() {
        if (this.pSSaaSSysAPIDEModel == null) {
            try {
                this.pSSaaSSysAPIDEModel = (PSSaaSSysAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSSaaSSysAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysAPIDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSaaSSysAPIDEModel();
    }

    public PSSaaSSysAPIDAO getPSSaaSSysAPIDAO() {
        if (this.pSSaaSSysAPIDAO == null) {
            try {
                this.pSSaaSSysAPIDAO = (PSSaaSSysAPIDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSSaaSSysAPIDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysAPIDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSaaSSysAPIDAO();
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

    protected void onFillParentInfo(PSSaaSSysAPI pSSaaSSysAPI, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSAPI_PSSAASSYSVER_PSSAASSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysVer pSSaaSSysVer = (PSSaaSSysVer)iService.getDEModel().createEntity();
            pSSaaSSysVer.set("PSSAASSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysVer);
            } else {
                iService.get((IEntity)pSSaaSSysVer);
            }
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysAPI, pSSaaSSysVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSSaaSSysAPI, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSaaSSysVer(PSSaaSSysAPI pSSaaSSysAPI, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        pSSaaSSysAPI.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
        pSSaaSSysAPI.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
    }

    protected void onFillEntityFullInfo(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSaaSSysAPI, bl);
        this.onFillEntityFullInfo_PSSaaSSysVer(pSSaaSSysAPI, bl);
    }

    protected void onFillEntityFullInfo_PSSaaSSysVer(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSaaSSysAPI, bl);
    }

    public ArrayList<PSSaaSSysAPI> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, "", -1);
    }

    public ArrayList<PSSaaSSysAPI> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, string, -1);
    }

    public ArrayList<PSSaaSSysAPI> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSVERID", (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysAPI> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSAASSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSaaSSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSAPI_PSSAASSYSVER_PSSAASSYSVERID", "", iDataEntityModel.getName(), "PSSAASSYSAPI", iDataEntityModel.getDataInfo((IEntity)pSSaaSSysVer), arrayList.get(0)));
        }
    }

    public void resetPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysAPI> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        for (PSSaaSSysAPI pSSaaSSysAPI : arrayList) {
            PSSaaSSysAPI pSSaaSSysAPI2 = (PSSaaSSysAPI)this.getDEModel().createEntity();
            pSSaaSSysAPI2.setPSSaaSSysAPIId(pSSaaSSysAPI.getPSSaaSSysAPIId());
            pSSaaSSysAPI2.setPSSaaSSysVerId(null);
            this.update(pSSaaSSysAPI2);
        }
    }

    public void removeByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        final PSSaaSSysVer pSSaaSSysVer2 = pSSaaSSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysAPIServiceBase.this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysAPIServiceBase.this.internalRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysAPIServiceBase.this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysAPI> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
        for (PSSaaSSysAPI pSSaaSSysAPI : arrayList) {
            this.remove((IEntity)pSSaaSSysAPI);
        }
        this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysAPI> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysAPI> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        super.onBeforeRemove(pSSaaSSysAPI);
    }

    protected void replaceParentInfo(PSSaaSSysAPI pSSaaSSysAPI, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSaaSSysAPI, cloneSession);
        if (pSSaaSSysAPI.getPSSaaSSysVerId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSVER", (Object)pSSaaSSysAPI.getPSSaaSSysVerId())) != null) {
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysAPI, (PSSaaSSysVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSaaSSysAPI, bl);
    }

    protected void onCheckEntity(boolean bl, PSSaaSSysAPI pSSaaSSysAPI, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSSaaSSysAPIId(bl, pSSaaSSysAPI, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysAPIName(bl, pSSaaSSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSSaaSSysAPI, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSaaSSysAPI, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSSaaSSysAPIId(boolean bl, PSSaaSSysAPI pSSaaSSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysAPI.isPSSaaSSysAPIIdDirty() && !bl2 : !pSSaaSSysAPI.isPSSaaSSysAPIIdDirty()) {
            return null;
        }
        String string = pSSaaSSysAPI.getPSSaaSSysAPIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAPIId_Default((IEntity)pSSaaSSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysAPIName(boolean bl, PSSaaSSysAPI pSSaaSSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysAPI.isPSSaaSSysAPINameDirty() && !bl2 : !pSSaaSSysAPI.isPSSaaSSysAPINameDirty()) {
            return null;
        }
        String string = pSSaaSSysAPI.getPSSaaSSysAPIName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPINAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysAPIName_Default((IEntity)pSSaaSSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSAPINAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSSaaSSysAPI pSSaaSSysAPI, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysAPI.isPSSaaSSysVerIdDirty() && !bl2 : !pSSaaSSysAPI.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSSaaSSysAPI.getPSSaaSSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default((IEntity)pSSaaSSysAPI, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSaaSSysAPI, bl);
    }

    protected void onSyncIndexEntities(PSSaaSSysAPI pSSaaSSysAPI, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSaaSSysAPI, bl);
    }

    public Object getDataContextValue(PSSaaSSysAPI pSSaaSSysAPI, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSaaSSysAPI, string, iDataContextParam)) != null) {
            return object;
        }
        PSSaaSSysVer pSSaaSSysVer = pSSaaSSysAPI.getPSSaaSSysVer();
        if (pSSaaSSysVer != null && pSSaaSSysVer.contains(string)) {
            return pSSaaSSysVer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSaaSSysAPI pSSaaSSysAPI, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSaaSSysAPI, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSSaaSSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSaaSSysAPI)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSaaSSysAPI pSSaaSSysAPI) throws Exception {
        super.onUpdateParent((IEntity)pSSaaSSysAPI);
    }

    @Override
    protected void exportCurXmlModel(PSSaaSSysAPI pSSaaSSysAPI, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSAASSYSAPI");
        if (!bl) {
            pSSaaSSysAPI.setCreateDate(null);
            pSSaaSSysAPI.setCreateMan(null);
            pSSaaSSysAPI.setPSSaaSSysAPIId(null);
            pSSaaSSysAPI.setUpdateDate(null);
            pSSaaSSysAPI.setUpdateMan(null);
            super.exportCurXmlModel(pSSaaSSysAPI, xmlNode, bl);
        }
    }
}

