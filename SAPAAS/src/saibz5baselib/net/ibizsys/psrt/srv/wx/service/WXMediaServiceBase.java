/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.wx.service;

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
import net.ibizsys.psrt.srv.wx.dao.WXMediaDAO;
import net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.entity.WXAccountBase;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.entity.WXEntAppBase;
import net.ibizsys.psrt.srv.wx.entity.WXMedia;
import net.ibizsys.psrt.srv.wx.service.WXMediaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WXMediaServiceBase
extends PSRuntimeSysServiceBase<WXMedia> {
    private static final Log log = LogFactory.getLog(WXMediaServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private WXMediaDEModel wXMediaDEModel;
    private WXMediaDAO wXMediaDAO;

    public static WXMediaService getInstance() throws Exception {
        return WXMediaServiceBase.getInstance(null);
    }

    public static WXMediaService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WXMediaService)ServiceGlobal.getService(WXMediaService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wx.service.WXMediaService";
    }

    public WXMediaDEModel getWXMediaDEModel() {
        if (this.wXMediaDEModel == null) {
            try {
                this.wXMediaDEModel = (WXMediaDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXMediaDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXMediaDEModel();
    }

    public WXMediaDAO getWXMediaDAO() {
        if (this.wXMediaDAO == null) {
            try {
                this.wXMediaDAO = (WXMediaDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wx.dao.WXMediaDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXMediaDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWXMediaDAO();
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
    protected void onFillParentInfo(WXMedia et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXAccountService", this.getSessionFactory());
            WXAccount parentEntity = (WXAccount)iService.getDEModel().createEntity();
            parentEntity.set("WXACCOUNTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WXAccount(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WXMEDIA_WXENTAPP_WXENTAPPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXEntAppService", this.getSessionFactory());
            WXEntApp parentEntity = (WXEntApp)iService.getDEModel().createEntity();
            parentEntity.set("WXENTAPPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WXEntApp(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_WXAccount(WXMedia et, WXAccount parentEntity) throws Exception {
        et.setWXAccountId(parentEntity.getWXAccountId());
        et.setWXAccountName(parentEntity.getWXAccountName());
    }

    protected void onFillParentInfo_WXEntApp(WXMedia et, WXEntApp parentEntity) throws Exception {
        et.setWXEntAppId(parentEntity.getWXEntAppId());
        et.setWXEntAppName(parentEntity.getWXEntAppName());
    }

    @Override
    protected void onFillEntityFullInfo(WXMedia et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WXAccount(et, bCreate);
        this.onFillEntityFullInfo_WXEntApp(et, bCreate);
    }

    protected void onFillEntityFullInfo_WXAccount(WXMedia et, boolean bCreate) throws Exception {
        if (et.isWXAccountIdDirty()) {
            if (et.getWXAccountId() != null) {
                if (et.getWXAccountId() == null || et.getWXAccountName() == null) {
                    WXAccount parentEntity = et.getWXAccount();
                    et.setWXAccountName(parentEntity.getWXAccountName());
                }
            } else {
                et.setWXAccountName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WXEntApp(WXMedia et, boolean bCreate) throws Exception {
        if (et.isWXEntAppIdDirty()) {
            if (et.getWXEntAppId() != null) {
                if (et.getWXEntAppId() == null || et.getWXEntAppName() == null) {
                    WXEntApp parentEntity = et.getWXEntApp();
                    et.setWXEntAppName(parentEntity.getWXEntAppName());
                }
            } else {
                et.setWXEntAppName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(WXMedia et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WXMedia> selectByWXAccount(WXAccountBase parentEntity) throws Exception {
        return this.selectByWXAccount(parentEntity, "");
    }

    public ArrayList<WXMedia> selectByWXAccount(WXAccountBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WXACCOUNTID", parentEntity.getWXAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWXAccountCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWXAccountCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WXMedia> selectByWXEntApp(WXEntAppBase parentEntity) throws Exception {
        return this.selectByWXEntApp(parentEntity, "");
    }

    public ArrayList<WXMedia> selectByWXEntApp(WXEntAppBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WXENTAPPID", parentEntity.getWXEntAppId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWXEntAppCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWXEntAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWXAccount(WXAccount parentEntity) throws Exception {
        ArrayList<WXMedia> list = this.selectByWXAccount(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WXACCOUNT");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID", "", parentDEModel.getName(), "WXMEDIA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWXAccount(WXAccount parentEntity) throws Exception {
        ArrayList<WXMedia> list = this.selectByWXAccount(parentEntity);
        for (WXMedia item : list) {
            WXMedia item2 = (WXMedia)this.getDEModel().createEntity();
            item2.setWXMediaId(item.getWXMediaId());
            item2.setWXAccountId(null);
            this.update(item2);
        }
    }

    public void removeByWXAccount(WXAccount parentEntity) throws Exception {
        final WXAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WXMediaServiceBase.this.onBeforeRemoveByWXAccount(parentEntity2);
                WXMediaServiceBase.this.internalRemoveByWXAccount(parentEntity2);
                WXMediaServiceBase.this.onAfterRemoveByWXAccount(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWXAccount(WXAccount parentEntity) throws Exception {
    }

    protected void internalRemoveByWXAccount(WXAccount parentEntity) throws Exception {
        ArrayList<WXMedia> removeList = this.selectByWXAccount(parentEntity);
        this.onBeforeRemoveByWXAccount(parentEntity, removeList);
        for (WXMedia item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWXAccount(parentEntity, removeList);
    }

    protected void onAfterRemoveByWXAccount(WXAccount parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWXAccount(WXAccount parentEntity, ArrayList<WXMedia> removeList) throws Exception {
    }

    protected void onAfterRemoveByWXAccount(WXAccount parentEntity, ArrayList<WXMedia> removeList) throws Exception {
    }

    public void testRemoveByWXEntApp(WXEntApp parentEntity) throws Exception {
        ArrayList<WXMedia> list = this.selectByWXEntApp(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WXENTAPP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WXMEDIA_WXENTAPP_WXENTAPPID", "", parentDEModel.getName(), "WXMEDIA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWXEntApp(WXEntApp parentEntity) throws Exception {
        ArrayList<WXMedia> list = this.selectByWXEntApp(parentEntity);
        for (WXMedia item : list) {
            WXMedia item2 = (WXMedia)this.getDEModel().createEntity();
            item2.setWXMediaId(item.getWXMediaId());
            item2.setWXEntAppId(null);
            this.update(item2);
        }
    }

    public void removeByWXEntApp(WXEntApp parentEntity) throws Exception {
        final WXEntApp parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WXMediaServiceBase.this.onBeforeRemoveByWXEntApp(parentEntity2);
                WXMediaServiceBase.this.internalRemoveByWXEntApp(parentEntity2);
                WXMediaServiceBase.this.onAfterRemoveByWXEntApp(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWXEntApp(WXEntApp parentEntity) throws Exception {
    }

    protected void internalRemoveByWXEntApp(WXEntApp parentEntity) throws Exception {
        ArrayList<WXMedia> removeList = this.selectByWXEntApp(parentEntity);
        this.onBeforeRemoveByWXEntApp(parentEntity, removeList);
        for (WXMedia item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWXEntApp(parentEntity, removeList);
    }

    protected void onAfterRemoveByWXEntApp(WXEntApp parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWXEntApp(WXEntApp parentEntity, ArrayList<WXMedia> removeList) throws Exception {
    }

    protected void onAfterRemoveByWXEntApp(WXEntApp parentEntity, ArrayList<WXMedia> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WXMedia et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WXMedia et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWXAccountId() != null && (entity = cloneSession.getEntity("WXACCOUNT", et.getWXAccountId())) != null) {
            this.onFillParentInfo_WXAccount(et, (WXAccount)entity);
        }
        if (et.getWXEntAppId() != null && (entity = cloneSession.getEntity("WXENTAPP", et.getWXEntAppId())) != null) {
            this.onFillParentInfo_WXEntApp(et, (WXEntApp)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WXMedia et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver3(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Reserver4(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXAccountId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXAccountName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXEntAppId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXEntAppName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXMediaId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WXMediaName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isMemoDirty()) {
            return null;
        }
        String value = et.getMemo();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserverDirty()) {
            return null;
        }
        String value = et.getReserver();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver2Dirty()) {
            return null;
        }
        String value = et.getReserver2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver3Dirty()) {
            return null;
        }
        String value = et.getReserver3();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isReserver4Dirty()) {
            return null;
        }
        String value = et.getReserver4();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_Reserver4_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESERVER4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXAccountId(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXAccountIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWXAccountId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXAccountId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXAccountName(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXAccountNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWXAccountName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXAccountName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXACCOUNTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXEntAppId(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXEntAppIdDirty()) {
            return null;
        }
        String value = et.getWXEntAppId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXEntAppId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXENTAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXEntAppName(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXEntAppNameDirty()) {
            return null;
        }
        String value = et.getWXEntAppName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXEntAppName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXENTAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXMediaId(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXMediaIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWXMediaId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXMediaId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WXMediaName(boolean bBaseMode, WXMedia et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWXMediaNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWXMediaName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WXMediaName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WXMEDIANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WXMedia et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WXMedia et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WXMedia et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
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
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER3", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver3_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "RESERVER4", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Reserver4_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXACCOUNTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXAccountId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXACCOUNTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXAccountName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXENTAPPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXEntAppId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXENTAPPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXEntAppName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXMEDIAID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXMediaId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WXMEDIANAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WXMediaName_Default(et, bCreate, bTempMode);
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

    protected String onTestValueRule_Memo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER2", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver3_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER3", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_Reserver4_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESERVER4", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_WXAccountId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXACCOUNTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WXAccountName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXACCOUNTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WXEntAppId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXENTAPPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WXEntAppName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXENTAPPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WXMediaId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXMEDIAID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WXMediaName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WXMEDIANAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WXMedia et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WXMedia et) throws Exception {
        super.onUpdateParent(et);
    }
}

