/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.service;

import java.sql.Timestamp;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO;
import net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class MsgSendQueueServiceBase
extends PSRuntimeSysServiceBase<MsgSendQueue> {
    private static final Log log = LogFactory.getLog(MsgSendQueueServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private MsgSendQueueDEModel msgSendQueueDEModel;
    private MsgSendQueueDAO msgSendQueueDAO;

    public static MsgSendQueueService getInstance() throws Exception {
        return MsgSendQueueServiceBase.getInstance(null);
    }

    public static MsgSendQueueService getInstance(SessionFactory sessionFactory) throws Exception {
        return (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.MsgSendQueueService";
    }

    public MsgSendQueueDEModel getMsgSendQueueDEModel() {
        if (this.msgSendQueueDEModel == null) {
            try {
                this.msgSendQueueDEModel = (MsgSendQueueDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgSendQueueDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgSendQueueDEModel();
    }

    public MsgSendQueueDAO getMsgSendQueueDAO() {
        if (this.msgSendQueueDAO == null) {
            try {
                this.msgSendQueueDAO = (MsgSendQueueDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgSendQueueDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getMsgSendQueueDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    @Override
    protected void onFillParentInfo(MsgSendQueue et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    @Override
    protected void onFillEntityFullInfo(MsgSendQueue et, boolean bCreate) throws Exception {
        if (bCreate) {
            if (et.getIsError() == null) {
                et.setIsError((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "0", 9));
            }
            if (et.getMsgSendQueueName() == null) {
                et.setMsgSendQueueName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u6d88\u606f\u53d1\u9001\u961f\u5217", 25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);
    }

    @Override
    protected void onWriteBackParent(MsgSendQueue et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    @Override
    protected void onBeforeRemove(MsgSendQueue et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void onRemoveEntityUncopyValues(MsgSendQueue et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstAddresses(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstUsers(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ErrorInfo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileAT(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileAT2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileAT3(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileAT4(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImportanceFlag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IsError(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IsSend(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgSendQueueId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgSendQueueName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgType(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanSendTime(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessTime(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SendTag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Subject(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalDstAddresses(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData3(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData4(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isContentDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getContent();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Content_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isContentTypeDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getContentType();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ContentType_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstAddresses(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDstAddressesDirty()) {
            return null;
        }
        String value = et.getDstAddresses();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DstAddresses_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTADDRESSES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstUsers(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDstUsersDirty()) {
            return null;
        }
        String value = et.getDstUsers();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DstUsers_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTUSERS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ErrorInfo(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isErrorInfoDirty()) {
            return null;
        }
        String value = et.getErrorInfo();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ErrorInfo_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ERRORINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileAT(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isFileATDirty()) {
            return null;
        }
        String value = et.getFileAT();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_FileAT_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileAT2(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isFileAT2Dirty()) {
            return null;
        }
        String value = et.getFileAT2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_FileAT2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEAT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileAT3(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isFileAT3Dirty()) {
            return null;
        }
        String value = et.getFileAT3();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_FileAT3_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEAT3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileAT4(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isFileAT4Dirty()) {
            return null;
        }
        String value = et.getFileAT4();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_FileAT4_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEAT4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImportanceFlag(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isImportanceFlagDirty()) {
            return null;
        }
        Integer value = et.getImportanceFlag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ImportanceFlag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPORTANCEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IsError(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isIsErrorDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISERROR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getIsError();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISERROR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_IsError_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISERROR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IsSend(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isIsSendDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSEND");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getIsSend();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSEND");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_IsSend_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSEND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgSendQueueId(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMsgSendQueueIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMsgSendQueueId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MsgSendQueueId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgSendQueueName(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMsgSendQueueNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMsgSendQueueName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MsgSendQueueName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGSENDQUEUENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgType(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMsgTypeDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getMsgType();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MsgType_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlanSendTime(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPlanSendTimeDirty()) {
            return null;
        }
        Timestamp value = et.getPlanSendTime();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PlanSendTime_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANSENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProcessTime(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isProcessTimeDirty()) {
            return null;
        }
        Timestamp value = et.getProcessTime();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ProcessTime_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SendTag(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSendTagDirty()) {
            return null;
        }
        String value = et.getSendTag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SendTag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SENDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Subject(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSubjectDirty()) {
            return null;
        }
        String value = et.getSubject();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Subject_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBJECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalDstAddresses(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isTotalDstAddressesDirty()) {
            return null;
        }
        String value = et.getTotalDstAddresses();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_TotalDstAddresses_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALDSTADDRESSES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDataDirty()) {
            return null;
        }
        String value = et.getUserData();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserData2Dirty()) {
            return null;
        }
        String value = et.getUserData2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData3(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserData3Dirty()) {
            return null;
        }
        String value = et.getUserData3();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData3_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData4(boolean bBaseMode, MsgSendQueue et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserData4Dirty()) {
            return null;
        }
        String value = et.getUserData4();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserData4_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(MsgSendQueue et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(MsgSendQueue et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(MsgSendQueue et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CONTENT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Content_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CONTENTTYPE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ContentType_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTADDRESSES", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstAddresses_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTUSERS", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstUsers_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ERRORINFO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ErrorInfo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "FILEAT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_FileAT_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "FILEAT2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_FileAT2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "FILEAT3", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_FileAT3_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "FILEAT4", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_FileAT4_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "IMPORTANCEFLAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ImportanceFlag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ISERROR", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_IsError_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ISSEND", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_IsSend_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MSGSENDQUEUEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MsgSendQueueId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MSGSENDQUEUENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MsgSendQueueName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MSGTYPE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MsgType_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PLANSENDTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PlanSendTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PROCESSTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ProcessTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SENDTAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SendTag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SUBJECT", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Subject_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "TOTALDSTADDRESSES", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_TotalDstAddresses_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA3", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData3_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDATA4", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserData4_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_Content_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ContentType_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstAddresses_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTADDRESSES", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstUsers_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTUSERS", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ErrorInfo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ERRORINFO", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_FileAT_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEAT", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_FileAT2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEAT2", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_FileAT3_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEAT3", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_FileAT4_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEAT4", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ImportanceFlag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_IsError_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_IsSend_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_MsgSendQueueId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGSENDQUEUEID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MsgSendQueueName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGSENDQUEUENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MsgType_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_PlanSendTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_ProcessTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_SendTag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SENDTAG", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Subject_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBJECT", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_TotalDstAddresses_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOTALDSTADDRESSES", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData3_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA3", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserData4_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA4", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, MsgSendQueue et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(MsgSendQueue et) throws Exception {
        super.onUpdateParent(et);
    }
}

