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
import net.ibizsys.pscore.srv.config.dao.PSMIDetailDAO;
import net.ibizsys.pscore.srv.config.demodel.PSMIDetailDEModel;
import net.ibizsys.pscore.srv.config.entity.PSMIDetail;
import net.ibizsys.pscore.srv.config.entity.PSModelInit;
import net.ibizsys.pscore.srv.config.entity.PSModelInitBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMIDetailServiceBase
extends PSCoreSysServiceBase<PSMIDetail> {
    private static final Log log = LogFactory.getLog(PSMIDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMIDetailDEModel pSMIDetailDEModel;
    private PSMIDetailDAO pSMIDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSMIDetailService";
    }

    public PSMIDetailDEModel getPSMIDetailDEModel() {
        if (this.pSMIDetailDEModel == null) {
            try {
                this.pSMIDetailDEModel = (PSMIDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSMIDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMIDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMIDetailDEModel();
    }

    public PSMIDetailDAO getPSMIDetailDAO() {
        if (this.pSMIDetailDAO == null) {
            try {
                this.pSMIDetailDAO = (PSMIDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSMIDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMIDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMIDetailDAO();
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

    protected void onFillParentInfo(PSMIDetail pSMIDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMIDETAIL_PSMODELINIT_PSMODELINITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelInitService", (SessionFactory)this.getSessionFactory());
            PSModelInit pSModelInit = (PSModelInit)iService.getDEModel().createEntity();
            pSModelInit.set("PSMODELINITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelInit);
            } else {
                iService.get((IEntity)pSModelInit);
            }
            this.onFillParentInfo_Psmodelinit(pSMIDetail, pSModelInit);
            return;
        }
        super.onFillParentInfo((IEntity)pSMIDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Psmodelinit(PSMIDetail pSMIDetail, PSModelInit pSModelInit) throws Exception {
        pSMIDetail.setPSModelInitId(pSModelInit.getPSModelInitId());
        pSMIDetail.setPSModelInitName(pSModelInit.getPSModelInitName());
    }

    protected void onFillEntityFullInfo(PSMIDetail pSMIDetail, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSMIDetail, bl);
        this.onFillEntityFullInfo_Psmodelinit(pSMIDetail, bl);
    }

    protected void onFillEntityFullInfo_Psmodelinit(PSMIDetail pSMIDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSMIDetail pSMIDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSMIDetail, bl);
    }

    public ArrayList<PSMIDetail> selectByPsmodelinit(PSModelInitBase pSModelInitBase) throws Exception {
        return this.selectByPsmodelinit(pSModelInitBase, "", -1);
    }

    public ArrayList<PSMIDetail> selectByPsmodelinit(PSModelInitBase pSModelInitBase, String string) throws Exception {
        return this.selectByPsmodelinit(pSModelInitBase, string, -1);
    }

    public ArrayList<PSMIDetail> selectByPsmodelinit(PSModelInitBase pSModelInitBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELINITID", (Object)pSModelInitBase.getPSModelInitId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPsmodelinitCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPsmodelinitCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPsmodelinit(PSModelInit pSModelInit) throws Exception {
    }

    public void resetPsmodelinit(PSModelInit pSModelInit) throws Exception {
        ArrayList<PSMIDetail> arrayList = this.selectByPsmodelinit(pSModelInit);
        for (PSMIDetail pSMIDetail : arrayList) {
            PSMIDetail pSMIDetail2 = (PSMIDetail)this.getDEModel().createEntity();
            pSMIDetail2.setPSMIDetailId(pSMIDetail.getPSMIDetailId());
            pSMIDetail2.setPSModelInitId(null);
            this.update(pSMIDetail2);
        }
    }

    public void removeByPsmodelinit(PSModelInit pSModelInit) throws Exception {
        final PSModelInit pSModelInit2 = pSModelInit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMIDetailServiceBase.this.onBeforeRemoveByPsmodelinit(pSModelInit2);
                PSMIDetailServiceBase.this.internalRemoveByPsmodelinit(pSModelInit2);
                PSMIDetailServiceBase.this.onAfterRemoveByPsmodelinit(pSModelInit2);
            }
        });
    }

    protected void onBeforeRemoveByPsmodelinit(PSModelInit pSModelInit) throws Exception {
    }

    protected void internalRemoveByPsmodelinit(PSModelInit pSModelInit) throws Exception {
        ArrayList<PSMIDetail> arrayList = this.selectByPsmodelinit(pSModelInit);
        this.onBeforeRemoveByPsmodelinit(pSModelInit, arrayList);
        for (PSMIDetail pSMIDetail : arrayList) {
            this.remove((IEntity)pSMIDetail);
        }
        this.onAfterRemoveByPsmodelinit(pSModelInit, arrayList);
    }

    protected void onAfterRemoveByPsmodelinit(PSModelInit pSModelInit) throws Exception {
    }

    protected void onBeforeRemoveByPsmodelinit(PSModelInit pSModelInit, ArrayList<PSMIDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPsmodelinit(PSModelInit pSModelInit, ArrayList<PSMIDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMIDetail pSMIDetail) throws Exception {
        super.onBeforeRemove(pSMIDetail);
    }

    protected void replaceParentInfo(PSMIDetail pSMIDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSMIDetail, cloneSession);
        if (pSMIDetail.getPSModelInitId() != null && (iEntity = cloneSession.getEntity("PSMODELINIT", (Object)pSMIDetail.getPSModelInitId())) != null) {
            this.onFillParentInfo_Psmodelinit(pSMIDetail, (PSModelInit)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMIDetail pSMIDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSMIDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_InitMode(bl, pSMIDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMIDetailId(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMIDetailName(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelInitId(bl, pSMIDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSMIDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_InitMode(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isInitModeDirty() : !pSMIDetail.isInitModeDirty()) {
            return null;
        }
        String string = pSMIDetail.getInitMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitMode_Default((IEntity)pSMIDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isMemoDirty() : !pSMIDetail.isMemoDirty()) {
            return null;
        }
        String string = pSMIDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSMIDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isOrderValueDirty() && !bl2 : !pSMIDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSMIDetail.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSMIDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isPSDENameDirty() : !pSMIDetail.isPSDENameDirty()) {
            return null;
        }
        String string = pSMIDetail.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSMIDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMIDetailId(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isPSMIDetailIdDirty() && !bl2 : !pSMIDetail.isPSMIDetailIdDirty()) {
            return null;
        }
        String string = pSMIDetail.getPSMIDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMIDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMIDetailId_Default((IEntity)pSMIDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMIDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMIDetailName(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isPSMIDetailNameDirty() && !bl2 : !pSMIDetail.isPSMIDetailNameDirty()) {
            return null;
        }
        String string = pSMIDetail.getPSMIDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMIDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMIDetailName_Default((IEntity)pSMIDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMIDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelInitId(boolean bl, PSMIDetail pSMIDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMIDetail.isPSModelInitIdDirty() && !bl2 : !pSMIDetail.isPSModelInitIdDirty()) {
            return null;
        }
        String string = pSMIDetail.getPSModelInitId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELINITID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelInitId_Default((IEntity)pSMIDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELINITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSMIDetail pSMIDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSMIDetail, bl);
    }

    protected void onSyncIndexEntities(PSMIDetail pSMIDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSMIDetail, bl);
    }

    public Object getDataContextValue(PSMIDetail pSMIDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSMIDetail, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMIDetail pSMIDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSMIDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMIDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMIDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMIDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMIDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELINITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelInitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELINITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelInitName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_InitMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMIDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMIDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMIDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMIDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelInitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELINITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelInitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELINITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSMIDetail pSMIDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSMIDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMIDetail pSMIDetail) throws Exception {
        super.onUpdateParent((IEntity)pSMIDetail);
    }

    @Override
    protected void exportCurXmlModel(PSMIDetail pSMIDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMIDETAIL");
        if (!bl) {
            pSMIDetail.setCreateDate(null);
            pSMIDetail.setCreateMan(null);
            pSMIDetail.setPSMIDetailId(null);
            pSMIDetail.setUpdateDate(null);
            pSMIDetail.setUpdateMan(null);
            super.exportCurXmlModel(pSMIDetail, xmlNode, bl);
        }
    }
}

