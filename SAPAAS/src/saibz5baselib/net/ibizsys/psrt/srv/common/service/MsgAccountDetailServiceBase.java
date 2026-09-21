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

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
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
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgAccountBase;
import net.ibizsys.psrt.srv.common.entity.MsgAccountDetail;
import net.ibizsys.psrt.srv.common.service.MsgAccountDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class MsgAccountDetailServiceBase
extends PSRuntimeSysServiceBase<MsgAccountDetail> {
    private static final Log log = LogFactory.getLog(MsgAccountDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private MsgAccountDetailDEModel msgAccountDetailDEModel;
    private MsgAccountDetailDAO msgAccountDetailDAO;

    public static MsgAccountDetailService getInstance() throws Exception {
        return MsgAccountDetailServiceBase.getInstance(null);
    }

    public static MsgAccountDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (MsgAccountDetailService)ServiceGlobal.getService(MsgAccountDetailService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.MsgAccountDetailService";
    }

    public MsgAccountDetailDEModel getMsgAccountDetailDEModel() {
        if (this.msgAccountDetailDEModel == null) {
            try {
                this.msgAccountDetailDEModel = (MsgAccountDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgAccountDetailDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgAccountDetailDEModel();
    }

    public MsgAccountDetailDAO getMsgAccountDetailDAO() {
        if (this.msgAccountDetailDAO == null) {
            try {
                this.msgAccountDetailDAO = (MsgAccountDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgAccountDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getMsgAccountDetailDAO();
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
    protected void onFillParentInfo(MsgAccountDetail et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService", this.getSessionFactory());
            MsgAccount parentEntity = (MsgAccount)iService.getDEModel().createEntity();
            parentEntity.set("MSGACCOUNTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_MajorMsgAccount(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService", this.getSessionFactory());
            MsgAccount parentEntity = (MsgAccount)iService.getDEModel().createEntity();
            parentEntity.set("MSGACCOUNTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_MinorMsgAccount(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_MajorMsgAccount(MsgAccountDetail et, MsgAccount parentEntity) throws Exception {
        et.setMajorMsgAccountId(parentEntity.getMsgAccountId());
        et.setMajorMsgAccountName(parentEntity.getMsgAccountName());
    }

    protected void onFillParentInfo_MinorMsgAccount(MsgAccountDetail et, MsgAccount parentEntity) throws Exception {
        et.setMinorMsgAccountId(parentEntity.getMsgAccountId());
        et.setMinorMsgAccountName(parentEntity.getMsgAccountName());
    }

    @Override
    protected void onFillEntityFullInfo(MsgAccountDetail et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_MajorMsgAccount(et, bCreate);
        this.onFillEntityFullInfo_MinorMsgAccount(et, bCreate);
    }

    protected void onFillEntityFullInfo_MajorMsgAccount(MsgAccountDetail et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorMsgAccount(MsgAccountDetail et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(MsgAccountDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<MsgAccountDetail> selectByMajorMsgAccount(MsgAccountBase parentEntity) throws Exception {
        return this.selectByMajorMsgAccount(parentEntity, "");
    }

    public ArrayList<MsgAccountDetail> selectByMajorMsgAccount(MsgAccountBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORMSGACCOUNTID", parentEntity.getMsgAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByMajorMsgAccountCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByMajorMsgAccountCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<MsgAccountDetail> selectByMinorMsgAccount(MsgAccountBase parentEntity) throws Exception {
        return this.selectByMinorMsgAccount(parentEntity, "");
    }

    public ArrayList<MsgAccountDetail> selectByMinorMsgAccount(MsgAccountBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORMSGACCOUNTID", parentEntity.getMsgAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByMinorMsgAccountCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByMinorMsgAccountCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    public void resetMajorMsgAccount(MsgAccount parentEntity) throws Exception {
        ArrayList<MsgAccountDetail> list = this.selectByMajorMsgAccount(parentEntity);
        for (MsgAccountDetail item : list) {
            MsgAccountDetail item2 = (MsgAccountDetail)this.getDEModel().createEntity();
            item2.setMsgAccountDetailId(item.getMsgAccountDetailId());
            item2.setMajorMsgAccountId(null);
            this.update(item2);
        }
    }

    public void removeByMajorMsgAccount(MsgAccount parentEntity) throws Exception {
        final MsgAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                MsgAccountDetailServiceBase.this.onBeforeRemoveByMajorMsgAccount(parentEntity2);
                MsgAccountDetailServiceBase.this.internalRemoveByMajorMsgAccount(parentEntity2);
                MsgAccountDetailServiceBase.this.onAfterRemoveByMajorMsgAccount(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMajorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    protected void internalRemoveByMajorMsgAccount(MsgAccount parentEntity) throws Exception {
        ArrayList<MsgAccountDetail> removeList = this.selectByMajorMsgAccount(parentEntity);
        this.onBeforeRemoveByMajorMsgAccount(parentEntity, removeList);
        for (MsgAccountDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByMajorMsgAccount(parentEntity, removeList);
    }

    protected void onAfterRemoveByMajorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByMajorMsgAccount(MsgAccount parentEntity, ArrayList<MsgAccountDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByMajorMsgAccount(MsgAccount parentEntity, ArrayList<MsgAccountDetail> removeList) throws Exception {
    }

    public void testRemoveByMinorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    public void resetMinorMsgAccount(MsgAccount parentEntity) throws Exception {
        ArrayList<MsgAccountDetail> list = this.selectByMinorMsgAccount(parentEntity);
        for (MsgAccountDetail item : list) {
            MsgAccountDetail item2 = (MsgAccountDetail)this.getDEModel().createEntity();
            item2.setMsgAccountDetailId(item.getMsgAccountDetailId());
            item2.setMinorMsgAccountId(null);
            this.update(item2);
        }
    }

    public void removeByMinorMsgAccount(MsgAccount parentEntity) throws Exception {
        final MsgAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                MsgAccountDetailServiceBase.this.onBeforeRemoveByMinorMsgAccount(parentEntity2);
                MsgAccountDetailServiceBase.this.internalRemoveByMinorMsgAccount(parentEntity2);
                MsgAccountDetailServiceBase.this.onAfterRemoveByMinorMsgAccount(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByMinorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    protected void internalRemoveByMinorMsgAccount(MsgAccount parentEntity) throws Exception {
        ArrayList<MsgAccountDetail> removeList = this.selectByMinorMsgAccount(parentEntity);
        this.onBeforeRemoveByMinorMsgAccount(parentEntity, removeList);
        for (MsgAccountDetail item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByMinorMsgAccount(parentEntity, removeList);
    }

    protected void onAfterRemoveByMinorMsgAccount(MsgAccount parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByMinorMsgAccount(MsgAccount parentEntity, ArrayList<MsgAccountDetail> removeList) throws Exception {
    }

    protected void onAfterRemoveByMinorMsgAccount(MsgAccount parentEntity, ArrayList<MsgAccountDetail> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(MsgAccountDetail et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(MsgAccountDetail et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getMajorMsgAccountId() != null && (entity = cloneSession.getEntity("MSGACCOUNT", et.getMajorMsgAccountId())) != null) {
            this.onFillParentInfo_MajorMsgAccount(et, (MsgAccount)entity);
        }
        if (et.getMinorMsgAccountId() != null && (entity = cloneSession.getEntity("MSGACCOUNT", et.getMinorMsgAccountId())) != null) {
            this.onFillParentInfo_MinorMsgAccount(et, (MsgAccount)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(MsgAccountDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, MsgAccountDetail et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MajorMsgAccountId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorMsgAccountId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgAccountDetailId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgAccountDetailName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_MajorMsgAccountId(boolean bBaseMode, MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMajorMsgAccountIdDirty()) {
            return null;
        }
        String value = et.getMajorMsgAccountId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MajorMsgAccountId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORMSGACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorMsgAccountId(boolean bBaseMode, MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMinorMsgAccountIdDirty()) {
            return null;
        }
        String value = et.getMinorMsgAccountId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MinorMsgAccountId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORMSGACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgAccountDetailId(boolean bBaseMode, MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMsgAccountDetailIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMsgAccountDetailId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MsgAccountDetailId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MsgAccountDetailName(boolean bBaseMode, MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMsgAccountDetailNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getMsgAccountDetailName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_MsgAccountDetailName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGACCOUNTDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(MsgAccountDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(MsgAccountDetail et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(MsgAccountDetail et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        MsgAccount majorMsgAccount = et.getMajorMsgAccount();
        if (majorMsgAccount != null && majorMsgAccount.contains(strField)) {
            return majorMsgAccount.get(strField);
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MAJORMSGACCOUNTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MajorMsgAccountId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MAJORMSGACCOUNTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MajorMsgAccountName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MINORMSGACCOUNTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MinorMsgAccountId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MINORMSGACCOUNTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MinorMsgAccountName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MSGACCOUNTDETAILID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MsgAccountDetailId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MSGACCOUNTDETAILNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_MsgAccountDetailName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
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

    protected String onTestValueRule_MajorMsgAccountId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORMSGACCOUNTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MajorMsgAccountName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORMSGACCOUNTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MinorMsgAccountId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORMSGACCOUNTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MinorMsgAccountName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORMSGACCOUNTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MsgAccountDetailId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGACCOUNTDETAILID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_MsgAccountDetailName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGACCOUNTDETAILNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, MsgAccountDetail et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(MsgAccountDetail et) throws Exception {
        super.onUpdateParent(et);
    }
}

