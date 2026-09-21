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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysTaskDataDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTaskDataDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskData;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTaskDataServiceBase
extends PSCoreSysServiceBase<PSSysTaskData> {
    private static final Log log = LogFactory.getLog(PSSysTaskDataServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysTaskDataDEModel pSSysTaskDataDEModel;
    private PSSysTaskDataDAO pSSysTaskDataDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskDataService";
    }

    public PSSysTaskDataDEModel getPSSysTaskDataDEModel() {
        if (this.pSSysTaskDataDEModel == null) {
            try {
                this.pSSysTaskDataDEModel = (PSSysTaskDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTaskDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTaskDataDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTaskDataDEModel();
    }

    public PSSysTaskDataDAO getPSSysTaskDataDAO() {
        if (this.pSSysTaskDataDAO == null) {
            try {
                this.pSSysTaskDataDAO = (PSSysTaskDataDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysTaskDataDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTaskDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTaskDataDAO();
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

    protected void onFillParentInfo(PSSysTaskData pSSysTaskData, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTASKDATA_PSSYSTASK_PSSYSTASKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
            PSSysTask pSSysTask = (PSSysTask)iService.getDEModel().createEntity();
            pSSysTask.set("PSSYSTASKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysTask);
            } else {
                iService.get((IEntity)pSSysTask);
            }
            this.onFillParentInfo_PSSysTask(pSSysTaskData, pSSysTask);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysTaskData, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysTask(PSSysTaskData pSSysTaskData, PSSysTask pSSysTask) throws Exception {
        pSSysTaskData.setPSSysTaskId(pSSysTask.getPSSysTaskId());
        pSSysTaskData.setPSSysTaskName(pSSysTask.getPSSysTaskName());
    }

    protected void onFillEntityFullInfo(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysTaskData, bl);
        this.onFillEntityFullInfo_PSSysTask(pSSysTaskData, bl);
    }

    protected void onFillEntityFullInfo_PSSysTask(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysTaskData, bl);
    }

    public ArrayList<PSSysTaskData> selectByPSSysTask(PSSysTaskBase pSSysTaskBase) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, "", -1);
    }

    public ArrayList<PSSysTaskData> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string) throws Exception {
        return this.selectByPSSysTask(pSSysTaskBase, string, -1);
    }

    public ArrayList<PSSysTaskData> selectByPSSysTask(PSSysTaskBase pSSysTaskBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTASKID", (Object)pSSysTaskBase.getPSSysTaskId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTaskCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTaskCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    public void resetPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSSysTaskData> arrayList = this.selectByPSSysTask(pSSysTask);
        for (PSSysTaskData pSSysTaskData : arrayList) {
            PSSysTaskData pSSysTaskData2 = (PSSysTaskData)this.getDEModel().createEntity();
            pSSysTaskData2.setPSSysTaskDataId(pSSysTaskData.getPSSysTaskDataId());
            pSSysTaskData2.setPSSysTaskId(null);
            this.update(pSSysTaskData2);
        }
    }

    public void removeByPSSysTask(PSSysTask pSSysTask) throws Exception {
        final PSSysTask pSSysTask2 = pSSysTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTaskDataServiceBase.this.onBeforeRemoveByPSSysTask(pSSysTask2);
                PSSysTaskDataServiceBase.this.internalRemoveByPSSysTask(pSSysTask2);
                PSSysTaskDataServiceBase.this.onAfterRemoveByPSSysTask(pSSysTask2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void internalRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
        ArrayList<PSSysTaskData> arrayList = this.selectByPSSysTask(pSSysTask);
        this.onBeforeRemoveByPSSysTask(pSSysTask, arrayList);
        for (PSSysTaskData pSSysTaskData : arrayList) {
            this.remove((IEntity)pSSysTaskData);
        }
        this.onAfterRemoveByPSSysTask(pSSysTask, arrayList);
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSSysTaskData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTask(PSSysTask pSSysTask, ArrayList<PSSysTaskData> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTaskData pSSysTaskData) throws Exception {
        super.onBeforeRemove(pSSysTaskData);
    }

    protected void replaceParentInfo(PSSysTaskData pSSysTaskData, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysTaskData, cloneSession);
        if (pSSysTaskData.getPSSysTaskId() != null && (iEntity = cloneSession.getEntity("PSSYSTASK", (Object)pSSysTaskData.getPSSysTaskId())) != null) {
            this.onFillParentInfo_PSSysTask(pSSysTaskData, (PSSysTask)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysTaskData, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTaskData pSSysTaskData, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSSysTaskData, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskDataId(bl, pSSysTaskData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskDataName(bl, pSSysTaskData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTaskId(bl, pSSysTaskData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysTaskData, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSSysTaskData pSSysTaskData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTaskData.isContentDirty() : !pSSysTaskData.isContentDirty()) {
            return null;
        }
        String string = pSSysTaskData.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSSysTaskData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTaskDataId(boolean bl, PSSysTaskData pSSysTaskData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTaskData.isPSSysTaskDataIdDirty() && !bl2 : !pSSysTaskData.isPSSysTaskDataIdDirty()) {
            return null;
        }
        String string = pSSysTaskData.getPSSysTaskDataId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskDataId_Default((IEntity)pSSysTaskData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTaskDataName(boolean bl, PSSysTaskData pSSysTaskData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTaskData.isPSSysTaskDataNameDirty() && !bl2 : !pSSysTaskData.isPSSysTaskDataNameDirty()) {
            return null;
        }
        String string = pSSysTaskData.getPSSysTaskDataName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskDataName_Default((IEntity)pSSysTaskData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTaskId(boolean bl, PSSysTaskData pSSysTaskData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTaskData.isPSSysTaskIdDirty() : !pSSysTaskData.isPSSysTaskIdDirty()) {
            return null;
        }
        String string = pSSysTaskData.getPSSysTaskId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTaskId_Default((IEntity)pSSysTaskData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysTaskData, bl);
    }

    protected void onSyncIndexEntities(PSSysTaskData pSSysTaskData, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysTaskData, bl);
    }

    public Object getDataContextValue(PSSysTaskData pSSysTaskData, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysTaskData, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysTask pSSysTask = pSSysTaskData.getPSSysTask();
        if (pSSysTask != null && pSSysTask.contains(string)) {
            return pSSysTask.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTaskData pSSysTaskData, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysTaskData, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTASKDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_PSSysTaskDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysTaskData pSSysTaskData) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysTaskData)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTaskData pSSysTaskData) throws Exception {
        Object object = pSSysTaskData.get("PSSYSTASKID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSTASKDATA_PSSYSTASK_PSSYSTASKID", object);
        }
        super.onUpdateParent((IEntity)pSSysTaskData);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysTaskData pSSysTaskData, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTASKDATA");
        if (!bl) {
            pSSysTaskData.setCreateDate(null);
            pSSysTaskData.setCreateMan(null);
            pSSysTaskData.setPSSysTaskDataId(null);
            pSSysTaskData.setPSSysTaskName(null);
            pSSysTaskData.setUpdateDate(null);
            pSSysTaskData.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTaskData, xmlNode, bl);
        }
    }
}

