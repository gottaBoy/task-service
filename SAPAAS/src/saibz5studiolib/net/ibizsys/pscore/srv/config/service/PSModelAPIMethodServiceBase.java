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
import net.ibizsys.pscore.srv.config.dao.PSModelAPIMethodDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelAPIMethodDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIInt;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIIntBase;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIMethod;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSModelAPIRSService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIMethodServiceBase
extends PSCoreSysServiceBase<PSModelAPIMethod> {
    private static final Log log = LogFactory.getLog(PSModelAPIMethodServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelAPIMethodDEModel pSModelAPIMethodDEModel;
    private PSModelAPIMethodDAO pSModelAPIMethodDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService";
    }

    public PSModelAPIMethodDEModel getPSModelAPIMethodDEModel() {
        if (this.pSModelAPIMethodDEModel == null) {
            try {
                this.pSModelAPIMethodDEModel = (PSModelAPIMethodDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelAPIMethodDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIMethodDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelAPIMethodDEModel();
    }

    public PSModelAPIMethodDAO getPSModelAPIMethodDAO() {
        if (this.pSModelAPIMethodDAO == null) {
            try {
                this.pSModelAPIMethodDAO = (PSModelAPIMethodDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelAPIMethodDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIMethodDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelAPIMethodDAO();
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

    protected void onFillParentInfo(PSModelAPIMethod pSModelAPIMethod, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELAPIMETHOD_PSMODELAPIINT_PSMODELAPIINTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIIntService", (SessionFactory)this.getSessionFactory());
            PSModelAPIInt pSModelAPIInt = (PSModelAPIInt)iService.getDEModel().createEntity();
            pSModelAPIInt.set("PSMODELAPIINTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModelAPIInt);
            } else {
                iService.get(pSModelAPIInt);
            }
            this.onFillParentInfo_PSModelAPIInt(pSModelAPIMethod, pSModelAPIInt);
            return;
        }
        super.onFillParentInfo(pSModelAPIMethod, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelAPIInt(PSModelAPIMethod pSModelAPIMethod, PSModelAPIInt pSModelAPIInt) throws Exception {
        pSModelAPIMethod.setPSModelAPIIntId(pSModelAPIInt.getPSModelAPIIntId());
        pSModelAPIMethod.setPSModelAPIIntName(pSModelAPIInt.getPSModelAPIIntName());
        pSModelAPIMethod.setPSModelAPIName(pSModelAPIInt.getPSModelAPIName());
    }

    protected void onFillEntityFullInfo(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSModelAPIMethod, bl);
        this.onFillEntityFullInfo_PSModelAPIInt(pSModelAPIMethod, bl);
    }

    protected void onFillEntityFullInfo_PSModelAPIInt(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        if (pSModelAPIMethod.isPSModelAPIIntIdDirty()) {
            if (pSModelAPIMethod.getPSModelAPIIntId() != null) {
                if (pSModelAPIMethod.getPSModelAPIIntId() == null || pSModelAPIMethod.getPSModelAPIIntName() == null) {
                    PSModelAPIInt pSModelAPIInt = pSModelAPIMethod.getPSModelAPIInt();
                    pSModelAPIMethod.setPSModelAPIIntName(pSModelAPIInt.getPSModelAPIIntName());
                    pSModelAPIMethod.setPSModelAPIName(pSModelAPIInt.getPSModelAPIName());
                }
            } else {
                pSModelAPIMethod.setPSModelAPIIntName(null);
                pSModelAPIMethod.setPSModelAPIName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelAPIMethod, bl);
    }

    public ArrayList<PSModelAPIMethod> selectByPSModelAPIInt(PSModelAPIIntBase pSModelAPIIntBase) throws Exception {
        return this.selectByPSModelAPIInt(pSModelAPIIntBase, "", -1);
    }

    public ArrayList<PSModelAPIMethod> selectByPSModelAPIInt(PSModelAPIIntBase pSModelAPIIntBase, String string) throws Exception {
        return this.selectByPSModelAPIInt(pSModelAPIIntBase, string, -1);
    }

    public ArrayList<PSModelAPIMethod> selectByPSModelAPIInt(PSModelAPIIntBase pSModelAPIIntBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELAPIINTID", (Object)pSModelAPIIntBase.getPSModelAPIIntId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelAPIIntCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelAPIIntCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
    }

    public void resetPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
        ArrayList<PSModelAPIMethod> arrayList = this.selectByPSModelAPIInt(pSModelAPIInt);
        for (PSModelAPIMethod pSModelAPIMethod : arrayList) {
            PSModelAPIMethod pSModelAPIMethod2 = (PSModelAPIMethod)this.getDEModel().createEntity();
            pSModelAPIMethod2.setPSModelAPIMethodId(pSModelAPIMethod.getPSModelAPIMethodId());
            pSModelAPIMethod2.setPSModelAPIIntId(null);
            this.update(pSModelAPIMethod2);
        }
    }

    public void removeByPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
        final PSModelAPIInt pSModelAPIInt2 = pSModelAPIInt;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelAPIMethodServiceBase.this.onBeforeRemoveByPSModelAPIInt(pSModelAPIInt2);
                PSModelAPIMethodServiceBase.this.internalRemoveByPSModelAPIInt(pSModelAPIInt2);
                PSModelAPIMethodServiceBase.this.onAfterRemoveByPSModelAPIInt(pSModelAPIInt2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
    }

    protected void internalRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
        ArrayList<PSModelAPIMethod> arrayList = this.selectByPSModelAPIInt(pSModelAPIInt);
        this.onBeforeRemoveByPSModelAPIInt(pSModelAPIInt, arrayList);
        for (PSModelAPIMethod pSModelAPIMethod : arrayList) {
            this.remove(pSModelAPIMethod);
        }
        this.onAfterRemoveByPSModelAPIInt(pSModelAPIInt, arrayList);
    }

    protected void onAfterRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt) throws Exception {
    }

    protected void onBeforeRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt, ArrayList<PSModelAPIMethod> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelAPIInt(PSModelAPIInt pSModelAPIInt, ArrayList<PSModelAPIMethod> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        PSModelAPIRSService pSModelAPIRSService = (PSModelAPIRSService)ServiceGlobal.getService(PSModelAPIRSService.class, (SessionFactory)this.getSessionFactory());
        pSModelAPIRSService.testRemoveByPSModelAPIMethod(pSModelAPIMethod);
        super.onBeforeRemove(pSModelAPIMethod);
    }

    protected void replaceParentInfo(PSModelAPIMethod pSModelAPIMethod, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelAPIMethod, cloneSession);
        if (pSModelAPIMethod.getPSModelAPIIntId() != null && (iEntity = cloneSession.getEntity("PSMODELAPIINT", (Object)pSModelAPIMethod.getPSModelAPIIntId())) != null) {
            this.onFillParentInfo_PSModelAPIInt(pSModelAPIMethod, (PSModelAPIInt)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelAPIMethod, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSModelAPIMethod, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIIntId(bl, pSModelAPIMethod, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIIntName(bl, pSModelAPIMethod, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIMethodId(bl, pSModelAPIMethod, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelAPIMethodName(bl, pSModelAPIMethod, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelAPIMethod, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIMethod.isMemoDirty() : !pSModelAPIMethod.isMemoDirty()) {
            return null;
        }
        String string = pSModelAPIMethod.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelAPIMethod, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelAPIIntId(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIMethod.isPSModelAPIIntIdDirty() : !pSModelAPIMethod.isPSModelAPIIntIdDirty()) {
            return null;
        }
        String string = pSModelAPIMethod.getPSModelAPIIntId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIIntId_Default(pSModelAPIMethod, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIIntName(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIMethod.isPSModelAPIIntNameDirty() : !pSModelAPIMethod.isPSModelAPIIntNameDirty()) {
            return null;
        }
        String string = pSModelAPIMethod.getPSModelAPIIntName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIIntName_Default(pSModelAPIMethod, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIINTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIMethodId(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIMethod.isPSModelAPIMethodIdDirty() && !bl2 : !pSModelAPIMethod.isPSModelAPIMethodIdDirty()) {
            return null;
        }
        String string = pSModelAPIMethod.getPSModelAPIMethodId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIMETHODID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIMethodId_Default(pSModelAPIMethod, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIMETHODID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelAPIMethodName(boolean bl, PSModelAPIMethod pSModelAPIMethod, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelAPIMethod.isPSModelAPIMethodNameDirty() && !bl2 : !pSModelAPIMethod.isPSModelAPIMethodNameDirty()) {
            return null;
        }
        String string = pSModelAPIMethod.getPSModelAPIMethodName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIMETHODNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelAPIMethodName_Default(pSModelAPIMethod, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELAPIMETHODNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        super.onSyncEntity(pSModelAPIMethod, bl);
    }

    protected void onSyncIndexEntities(PSModelAPIMethod pSModelAPIMethod, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelAPIMethod, bl);
    }

    public Object getDataContextValue(PSModelAPIMethod pSModelAPIMethod, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelAPIMethod, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelAPIMethod pSModelAPIMethod, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelAPIMethod, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIINTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIIntId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIIntName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIMETHODID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIMethodId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPIMETHODNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIMethodName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelAPIName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSModelAPIIntId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIINTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIIntName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIINTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIMethodId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIMETHODID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIMethodName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPIMETHODNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSModelAPIMethod pSModelAPIMethod) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelAPIMethod)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelAPIMethod pSModelAPIMethod) throws Exception {
        super.onUpdateParent(pSModelAPIMethod);
    }

    @Override
    protected void exportCurXmlModel(PSModelAPIMethod pSModelAPIMethod, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELAPIMETHOD");
        if (!bl) {
            pSModelAPIMethod.setCreateDate(null);
            pSModelAPIMethod.setCreateMan(null);
            pSModelAPIMethod.setPSModelAPIMethodId(null);
            pSModelAPIMethod.setUpdateDate(null);
            pSModelAPIMethod.setUpdateMan(null);
            super.exportCurXmlModel(pSModelAPIMethod, xmlNode, bl);
        }
    }
}

