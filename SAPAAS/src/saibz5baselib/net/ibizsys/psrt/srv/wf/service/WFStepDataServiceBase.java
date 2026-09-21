/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.wf.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.wf.dao.WFStepDataDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFInstanceBase;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFStepBase;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserBase;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class WFStepDataServiceBase
extends PSRuntimeSysServiceBase<WFStepData> {
    private static final Log log = LogFactory.getLog(WFStepDataServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_MYHIST = "MyHist";
    public static final String ACTION_ROLLBACK = "Rollback";
    private WFStepDataDEModel wFStepDataDEModel;
    private WFStepDataDAO wFStepDataDAO;

    public static WFStepDataService getInstance() throws Exception {
        return WFStepDataServiceBase.getInstance(null);
    }

    public static WFStepDataService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFStepDataService";
    }

    public WFStepDataDEModel getWFStepDataDEModel() {
        if (this.wFStepDataDEModel == null) {
            try {
                this.wFStepDataDEModel = (WFStepDataDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDataDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFStepDataDEModel();
    }

    public WFStepDataDAO getWFStepDataDAO() {
        if (this.wFStepDataDAO == null) {
            try {
                this.wFStepDataDAO = (WFStepDataDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFStepDataDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getWFStepDataDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare(strDataSetName, DATASET_MYHIST, true) == 0) {
            return this.fetchMyHist(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        if (StringHelper.compare(strAction, ACTION_ROLLBACK, true) == 0) {
            this.rollback((WFStepData)entity);
            return;
        }
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    public DBFetchResult fetchMyHist(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MYHIST, false);
        return dbFetchResult;
    }

    public void rollback(WFStepData wFStepData) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", ACTION_ROLLBACK), wFStepData);
            return;
        }
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction(this, ACTION_ROLLBACK, 0, wFStepData, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(wFStepData, ACTION_ROLLBACK);
        final WFStepData wFStepData2 = wFStepData;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(WFStepDataServiceBase.this.getService(), WFStepDataServiceBase.ACTION_ROLLBACK, 40, wFStepData2, null).getResult() != 1) {
                    WFStepDataServiceBase.this.onRollback(wFStepData2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction(this, ACTION_ROLLBACK, 99, wFStepData, null);
        }
    }

    protected void onRollback(WFStepData wFStepData) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[Rollback]");
    }

    @Override
    protected void onFillParentInfo(WFStepData et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFInstanceService", this.getSessionFactory());
            WFInstance parentEntity = (WFInstance)iService.getDEModel().createEntity();
            parentEntity.set("WFINSTANCEID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFInstance(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFSTEPDATA_WFSTEP_WFSTEPID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService", this.getSessionFactory());
            WFStep parentEntity = (WFStep)iService.getDEModel().createEntity();
            parentEntity.set("WFSTEPID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_WFStep(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService", this.getSessionFactory());
            WFUser parentEntity = (WFUser)iService.getDEModel().createEntity();
            parentEntity.set("WFUSERID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_OriginalWFUser(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_WFInstance(WFStepData et, WFInstance parentEntity) throws Exception {
        et.setUserData(parentEntity.getUserData());
        et.setUserDataDesc(parentEntity.getUserDataInfo());
        et.setWFInstanceId(parentEntity.getWFInstanceId());
        et.setWFInstanceName(parentEntity.getWFInstanceName());
    }

    protected void onFillParentInfo_WFStep(WFStepData et, WFStep parentEntity) throws Exception {
        et.setWFPLogicName(parentEntity.getWFPLogicName());
        et.setWFStepId(parentEntity.getWFStepId());
        et.setWFStepName(parentEntity.getWFStepName());
    }

    protected void onFillParentInfo_OriginalWFUser(WFStepData et, WFUser parentEntity) throws Exception {
        et.setOriginalWFUserId(parentEntity.getWFUserId());
        et.setOriginalWFUserName(parentEntity.getWFUserName());
    }

    @Override
    protected void onFillEntityFullInfo(WFStepData et, boolean bCreate) throws Exception {
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_WFInstance(et, bCreate);
        this.onFillEntityFullInfo_WFStep(et, bCreate);
        this.onFillEntityFullInfo_OriginalWFUser(et, bCreate);
    }

    protected void onFillEntityFullInfo_WFInstance(WFStepData et, boolean bCreate) throws Exception {
        if (et.isWFInstanceIdDirty()) {
            if (et.getWFInstanceId() != null) {
                if (et.getUserData() == null || et.getUserDataDesc() == null || et.getWFInstanceId() == null || et.getWFInstanceName() == null) {
                    WFInstance parentEntity = et.getWFInstance();
                    et.setUserData(parentEntity.getUserData());
                    et.setUserDataDesc(parentEntity.getUserDataInfo());
                    et.setWFInstanceName(parentEntity.getWFInstanceName());
                }
            } else {
                et.setUserData(null);
                et.setUserDataDesc(null);
                et.setWFInstanceName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_WFStep(WFStepData et, boolean bCreate) throws Exception {
        if (et.isWFStepIdDirty()) {
            if (et.getWFStepId() != null) {
                if (et.getWFPLogicName() == null || et.getWFStepId() == null || et.getWFStepName() == null) {
                    WFStep parentEntity = et.getWFStep();
                    et.setWFPLogicName(parentEntity.getWFPLogicName());
                    et.setWFStepName(parentEntity.getWFStepName());
                }
            } else {
                et.setWFPLogicName(null);
                et.setWFStepName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OriginalWFUser(WFStepData et, boolean bCreate) throws Exception {
        if (et.isOriginalWFUserIdDirty()) {
            if (et.getOriginalWFUserId() != null) {
                if (et.getOriginalWFUserId() == null || et.getOriginalWFUserName() == null) {
                    WFUser parentEntity = et.getOriginalWFUser();
                    et.setOriginalWFUserName(parentEntity.getWFUserName());
                }
            } else {
                et.setOriginalWFUserName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(WFStepData et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<WFStepData> selectByWFInstance(WFInstanceBase parentEntity) throws Exception {
        return this.selectByWFInstance(parentEntity, "");
    }

    public ArrayList<WFStepData> selectByWFInstance(WFInstanceBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFINSTANCEID", parentEntity.getWFInstanceId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFInstanceCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFInstanceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFStepData> selectByWFStep(WFStepBase parentEntity) throws Exception {
        return this.selectByWFStep(parentEntity, "");
    }

    public ArrayList<WFStepData> selectByWFStep(WFStepBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPID", parentEntity.getWFStepId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByWFStepCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByWFStepCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<WFStepData> selectByOriginalWFUser(WFUserBase parentEntity) throws Exception {
        return this.selectByOriginalWFUser(parentEntity, "");
    }

    public ArrayList<WFStepData> selectByOriginalWFUser(WFUserBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORIGINALWFUSERID", parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByOriginalWFUserCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByOriginalWFUserCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByWFInstance(WFInstance parentEntity) throws Exception {
        ArrayList<WFStepData> list = this.selectByWFInstance(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFINSTANCE");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID", "", parentDEModel.getName(), "WFSTEPDATA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWFInstance(WFInstance parentEntity) throws Exception {
        ArrayList<WFStepData> list = this.selectByWFInstance(parentEntity);
        for (WFStepData item : list) {
            WFStepData item2 = (WFStepData)this.getDEModel().createEntity();
            item2.setWFStepDataId(item.getWFStepDataId());
            item2.setWFInstanceId(null);
            this.update(item2);
        }
    }

    public void removeByWFInstance(WFInstance parentEntity) throws Exception {
        final WFInstance parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFStepDataServiceBase.this.onBeforeRemoveByWFInstance(parentEntity2);
                WFStepDataServiceBase.this.internalRemoveByWFInstance(parentEntity2);
                WFStepDataServiceBase.this.onAfterRemoveByWFInstance(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFInstance(WFInstance parentEntity) throws Exception {
    }

    protected void internalRemoveByWFInstance(WFInstance parentEntity) throws Exception {
        ArrayList<WFStepData> removeList = this.selectByWFInstance(parentEntity);
        this.onBeforeRemoveByWFInstance(parentEntity, removeList);
        for (WFStepData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFInstance(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFInstance(WFInstance parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFInstance(WFInstance parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFInstance(WFInstance parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    public void testRemoveByWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFStepData> list = this.selectByWFStep(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFSTEP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_WFSTEPDATA_WFSTEP_WFSTEPID", "", parentDEModel.getName(), "WFSTEPDATA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFStepData> list = this.selectByWFStep(parentEntity);
        for (WFStepData item : list) {
            WFStepData item2 = (WFStepData)this.getDEModel().createEntity();
            item2.setWFStepDataId(item.getWFStepDataId());
            item2.setWFStepId(null);
            this.update(item2);
        }
    }

    public void removeByWFStep(WFStep parentEntity) throws Exception {
        final WFStep parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFStepDataServiceBase.this.onBeforeRemoveByWFStep(parentEntity2);
                WFStepDataServiceBase.this.internalRemoveByWFStep(parentEntity2);
                WFStepDataServiceBase.this.onAfterRemoveByWFStep(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByWFStep(WFStep parentEntity) throws Exception {
    }

    protected void internalRemoveByWFStep(WFStep parentEntity) throws Exception {
        ArrayList<WFStepData> removeList = this.selectByWFStep(parentEntity);
        this.onBeforeRemoveByWFStep(parentEntity, removeList);
        for (WFStepData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByWFStep(parentEntity, removeList);
    }

    protected void onAfterRemoveByWFStep(WFStep parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByWFStep(WFStep parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    protected void onAfterRemoveByWFStep(WFStep parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    public void testRemoveByOriginalWFUser(WFUser parentEntity) throws Exception {
    }

    public void resetOriginalWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFStepData> list = this.selectByOriginalWFUser(parentEntity);
        for (WFStepData item : list) {
            WFStepData item2 = (WFStepData)this.getDEModel().createEntity();
            item2.setWFStepDataId(item.getWFStepDataId());
            item2.setOriginalWFUserId(null);
            this.update(item2);
        }
    }

    public void removeByOriginalWFUser(WFUser parentEntity) throws Exception {
        final WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                WFStepDataServiceBase.this.onBeforeRemoveByOriginalWFUser(parentEntity2);
                WFStepDataServiceBase.this.internalRemoveByOriginalWFUser(parentEntity2);
                WFStepDataServiceBase.this.onAfterRemoveByOriginalWFUser(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByOriginalWFUser(WFUser parentEntity) throws Exception {
    }

    protected void internalRemoveByOriginalWFUser(WFUser parentEntity) throws Exception {
        ArrayList<WFStepData> removeList = this.selectByOriginalWFUser(parentEntity);
        this.onBeforeRemoveByOriginalWFUser(parentEntity, removeList);
        for (WFStepData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByOriginalWFUser(parentEntity, removeList);
    }

    protected void onAfterRemoveByOriginalWFUser(WFUser parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByOriginalWFUser(WFUser parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    protected void onAfterRemoveByOriginalWFUser(WFUser parentEntity, ArrayList<WFStepData> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(WFStepData et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(WFStepData et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getWFInstanceId() != null && (entity = cloneSession.getEntity("WFINSTANCE", et.getWFInstanceId())) != null) {
            this.onFillParentInfo_WFInstance(et, (WFInstance)entity);
        }
        if (et.getWFStepId() != null && (entity = cloneSession.getEntity("WFSTEP", et.getWFStepId())) != null) {
            this.onFillParentInfo_WFStep(et, (WFStep)entity);
        }
        if (et.getOriginalWFUserId() != null && (entity = cloneSession.getEntity("WFUSER", et.getOriginalWFUserId())) != null) {
            this.onFillParentInfo_OriginalWFUser(et, (WFUser)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(WFStepData et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActorId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActorName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActorName2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConnectionName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextTo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OriginalWFUserId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OriginalWFUserName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDParam(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDParam2(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDataDesc(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFActionLanResTag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFInstanceId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFInstanceName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFPLogicName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepDataId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepDataName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepLanResTag(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_ActorId(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActorIdDirty()) {
            return null;
        }
        String value = et.getActorId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActorId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActorName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActorNameDirty()) {
            return null;
        }
        String value = et.getActorName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActorName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTORNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActorName2(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isActorName2Dirty()) {
            return null;
        }
        String value = et.getActorName2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ActorName2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTORNAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConnectionName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isConnectionNameDirty()) {
            return null;
        }
        String value = et.getConnectionName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_ConnectionName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNECTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_NextTo(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isNextToDirty()) {
            return null;
        }
        String value = et.getNextTo();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_NextTo_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTTO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OriginalWFUserId(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isOriginalWFUserIdDirty()) {
            return null;
        }
        String value = et.getOriginalWFUserId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_OriginalWFUserId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIGINALWFUSERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OriginalWFUserName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isOriginalWFUserNameDirty()) {
            return null;
        }
        String value = et.getOriginalWFUserName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_OriginalWFUserName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIGINALWFUSERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDParam(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSDParamDirty()) {
            return null;
        }
        String value = et.getSDParam();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SDParam_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDParam2(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSDParam2Dirty()) {
            return null;
        }
        String value = et.getSDParam2();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SDParam2_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_UserDataDesc(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDataDescDirty()) {
            return null;
        }
        String value = et.getUserDataDesc();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDataDesc_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATADESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFActionLanResTag(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFActionLanResTagDirty()) {
            return null;
        }
        String value = et.getWFActionLanResTag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFActionLanResTag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFACTIONLANRESTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFInstanceId(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFInstanceIdDirty()) {
            return null;
        }
        String value = et.getWFInstanceId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFInstanceId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTANCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFInstanceName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFInstanceNameDirty()) {
            return null;
        }
        String value = et.getWFInstanceName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFInstanceName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFINSTANCENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFPLogicName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFPLogicNameDirty()) {
            return null;
        }
        String value = et.getWFPLogicName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFPLogicName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFPLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepDataId(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepDataIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFStepDataId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepDataId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepDataName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepDataNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getWFStepDataName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepDataName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepId(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepIdDirty()) {
            return null;
        }
        String value = et.getWFStepId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepLanResTag(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepLanResTagDirty()) {
            return null;
        }
        String value = et.getWFStepLanResTag();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepLanResTag_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPLANRESTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepName(boolean bBaseMode, WFStepData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isWFStepNameDirty()) {
            return null;
        }
        String value = et.getWFStepName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_WFStepName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(WFStepData et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(WFStepData et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(WFStepData et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "ACTIONTIME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActionTime_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ACTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActorId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ACTORNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActorName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ACTORNAME2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ActorName2_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CONNECTIONNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_ConnectionName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "NEXTTO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_NextTo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ORIGINALWFUSERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_OriginalWFUserId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ORIGINALWFUSERNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_OriginalWFUserName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SDPARAM", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SDParam_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SDPARAM2", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SDParam2_Default(et, bCreate, bTempMode);
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
        if (StringHelper.compare(strDEFieldName, "USERDATADESC", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDataDesc_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFACTIONLANRESTAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFActionLanResTag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFINSTANCEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFInstanceId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFINSTANCENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFInstanceName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFPLOGICNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFPLogicName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPDATAID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepDataId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPDATANAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepDataName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPLANRESTAG", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepLanResTag_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "WFSTEPNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_WFStepName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_ActionTime_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_ActorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTORID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ActorName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTORNAME", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ActorName2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTORNAME2", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_ConnectionName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNECTIONNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_Memo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_NextTo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTTO", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_OriginalWFUserId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORIGINALWFUSERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_OriginalWFUserName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORIGINALWFUSERNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_SDParam_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPARAM", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_SDParam2_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDPARAM2", et, bTempMode, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_UserDataDesc_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATADESC", et, bTempMode, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFActionLanResTag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFACTIONLANRESTAG", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFInstanceId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFINSTANCEID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFInstanceName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFINSTANCENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFPLogicName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFPLOGICNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepDataId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPDATAID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepDataName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPDATANAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepLanResTag_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPLANRESTAG", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_WFStepName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFStepData et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(WFStepData et) throws Exception {
        super.onUpdateParent(et);
    }
}

