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
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.UserRoleDataDAO;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDataDEModel;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgBase;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.OrgSectorBase;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionServiceBase;
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailServiceBase;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.common.service.UserRoleDatasService;
import net.ibizsys.psrt.srv.common.service.UserRoleDatasServiceBase;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.entity.DataEntityBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserRoleDataServiceBase
extends PSRuntimeSysServiceBase<UserRoleData> {
    private static final Log log = LogFactory.getLog(UserRoleDataServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private UserRoleDataDEModel userRoleDataDEModel;
    private UserRoleDataDAO userRoleDataDAO;

    public static UserRoleDataService getInstance() throws Exception {
        return UserRoleDataServiceBase.getInstance(null);
    }

    public static UserRoleDataService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserRoleDataService)ServiceGlobal.getService(UserRoleDataService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserRoleDataService";
    }

    public UserRoleDataDEModel getUserRoleDataDEModel() {
        if (this.userRoleDataDEModel == null) {
            try {
                this.userRoleDataDEModel = (UserRoleDataDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDataDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getUserRoleDataDEModel();
    }

    public UserRoleDataDAO getUserRoleDataDAO() {
        if (this.userRoleDataDAO == null) {
            try {
                this.userRoleDataDAO = (UserRoleDataDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserRoleDataDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getUserRoleDataDAO();
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
    protected void onFillParentInfo(UserRoleData et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERROLEDATA_DATAENTITY_DEID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.demodel.service.DataEntityService", this.getSessionFactory());
            DataEntity parentEntity = (DataEntity)iService.getDEModel().createEntity();
            parentEntity.set("DEID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DE(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgSectorService", this.getSessionFactory());
            OrgSector parentEntity = (OrgSector)iService.getDEModel().createEntity();
            parentEntity.set("ORGSECTORID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DstOrgSector(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_USERROLEDATA_ORG_DSTORGID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgService", this.getSessionFactory());
            Org parentEntity = (Org)iService.getDEModel().createEntity();
            parentEntity.set("ORGID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DstOrg(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_DE(UserRoleData et, DataEntity parentEntity) throws Exception {
        et.setDEId(parentEntity.getDEId());
        et.setDEName(parentEntity.getDEName());
    }

    protected void onFillParentInfo_DstOrgSector(UserRoleData et, OrgSector parentEntity) throws Exception {
        et.setDstOrgSectorId(parentEntity.getOrgSectorId());
        et.setDstOrgSectorName(parentEntity.getOrgSectorName());
    }

    protected void onFillParentInfo_DstOrg(UserRoleData et, Org parentEntity) throws Exception {
        et.setDstOrgId(parentEntity.getOrgId());
        et.setDstOrgName(parentEntity.getOrgName());
    }

    @Override
    protected void onFillEntityFullInfo(UserRoleData et, boolean bCreate) throws Exception {
        if (bCreate) {
            if (et.getIsAllData() == null) {
                et.setIsAllData((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "1", 9));
            }
            if (et.getUDVersion() == null) {
                et.setUDVersion((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_DE(et, bCreate);
        this.onFillEntityFullInfo_DstOrgSector(et, bCreate);
        this.onFillEntityFullInfo_DstOrg(et, bCreate);
    }

    protected void onFillEntityFullInfo_DE(UserRoleData et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_DstOrgSector(UserRoleData et, boolean bCreate) throws Exception {
    }

    protected void onFillEntityFullInfo_DstOrg(UserRoleData et, boolean bCreate) throws Exception {
    }

    @Override
    protected void onWriteBackParent(UserRoleData et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<UserRoleData> selectByDE(DataEntityBase parentEntity) throws Exception {
        return this.selectByDE(parentEntity, "");
    }

    public ArrayList<UserRoleData> selectByDE(DataEntityBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEID", parentEntity.getDEId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByDECond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<UserRoleData> selectByDstOrgSector(OrgSectorBase parentEntity) throws Exception {
        return this.selectByDstOrgSector(parentEntity, "");
    }

    public ArrayList<UserRoleData> selectByDstOrgSector(OrgSectorBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTORGSECTORID", parentEntity.getOrgSectorId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByDstOrgSectorCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByDstOrgSectorCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<UserRoleData> selectByDstOrg(OrgBase parentEntity) throws Exception {
        return this.selectByDstOrg(parentEntity, "");
    }

    public ArrayList<UserRoleData> selectByDstOrg(OrgBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTORGID", parentEntity.getOrgId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByDstOrgCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByDstOrgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByDE(DataEntity parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDE(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("DATAENTITY");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERROLEDATA_DATAENTITY_DEID", "", parentDEModel.getName(), "USERROLEDATA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetDE(DataEntity parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDE(parentEntity);
        for (UserRoleData item : list) {
            UserRoleData item2 = (UserRoleData)this.getDEModel().createEntity();
            item2.setUserRoleDataId(item.getUserRoleDataId());
            item2.setDEId(null);
            this.update(item2);
        }
    }

    public void removeByDE(DataEntity parentEntity) throws Exception {
        final DataEntity parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserRoleDataServiceBase.this.onBeforeRemoveByDE(parentEntity2);
                UserRoleDataServiceBase.this.internalRemoveByDE(parentEntity2);
                UserRoleDataServiceBase.this.onAfterRemoveByDE(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDE(DataEntity parentEntity) throws Exception {
    }

    protected void internalRemoveByDE(DataEntity parentEntity) throws Exception {
        ArrayList<UserRoleData> removeList = this.selectByDE(parentEntity);
        this.onBeforeRemoveByDE(parentEntity, removeList);
        for (UserRoleData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByDE(parentEntity, removeList);
    }

    protected void onAfterRemoveByDE(DataEntity parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByDE(DataEntity parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    protected void onAfterRemoveByDE(DataEntity parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    public void testRemoveByDstOrgSector(OrgSector parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDstOrgSector(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("ORGSECTOR");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID", "", parentDEModel.getName(), "USERROLEDATA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetDstOrgSector(OrgSector parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDstOrgSector(parentEntity);
        for (UserRoleData item : list) {
            UserRoleData item2 = (UserRoleData)this.getDEModel().createEntity();
            item2.setUserRoleDataId(item.getUserRoleDataId());
            item2.setDstOrgSectorId(null);
            this.update(item2);
        }
    }

    public void removeByDstOrgSector(OrgSector parentEntity) throws Exception {
        final OrgSector parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserRoleDataServiceBase.this.onBeforeRemoveByDstOrgSector(parentEntity2);
                UserRoleDataServiceBase.this.internalRemoveByDstOrgSector(parentEntity2);
                UserRoleDataServiceBase.this.onAfterRemoveByDstOrgSector(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstOrgSector(OrgSector parentEntity) throws Exception {
    }

    protected void internalRemoveByDstOrgSector(OrgSector parentEntity) throws Exception {
        ArrayList<UserRoleData> removeList = this.selectByDstOrgSector(parentEntity);
        this.onBeforeRemoveByDstOrgSector(parentEntity, removeList);
        for (UserRoleData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByDstOrgSector(parentEntity, removeList);
    }

    protected void onAfterRemoveByDstOrgSector(OrgSector parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstOrgSector(OrgSector parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    protected void onAfterRemoveByDstOrgSector(OrgSector parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    public void testRemoveByDstOrg(Org parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDstOrg(parentEntity);
        if (list.size() > 0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("ORG");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_USERROLEDATA_ORG_DSTORGID", "", parentDEModel.getName(), "USERROLEDATA", parentDEModel.getDataInfo(parentEntity)));
        }
    }

    public void resetDstOrg(Org parentEntity) throws Exception {
        ArrayList<UserRoleData> list = this.selectByDstOrg(parentEntity);
        for (UserRoleData item : list) {
            UserRoleData item2 = (UserRoleData)this.getDEModel().createEntity();
            item2.setUserRoleDataId(item.getUserRoleDataId());
            item2.setDstOrgId(null);
            this.update(item2);
        }
    }

    public void removeByDstOrg(Org parentEntity) throws Exception {
        final Org parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                UserRoleDataServiceBase.this.onBeforeRemoveByDstOrg(parentEntity2);
                UserRoleDataServiceBase.this.internalRemoveByDstOrg(parentEntity2);
                UserRoleDataServiceBase.this.onAfterRemoveByDstOrg(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByDstOrg(Org parentEntity) throws Exception {
    }

    protected void internalRemoveByDstOrg(Org parentEntity) throws Exception {
        ArrayList<UserRoleData> removeList = this.selectByDstOrg(parentEntity);
        this.onBeforeRemoveByDstOrg(parentEntity, removeList);
        for (UserRoleData item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByDstOrg(parentEntity, removeList);
    }

    protected void onAfterRemoveByDstOrg(Org parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByDstOrg(Org parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    protected void onAfterRemoveByDstOrg(Org parentEntity, ArrayList<UserRoleData> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(UserRoleData et) throws Exception {
        PSRuntimeSysServiceBase service = (UserRoleDataActionService)ServiceGlobal.getService(UserRoleDataActionService.class, this.getSessionFactory());
        ((UserRoleDataActionServiceBase)service).testRemoveByUserRoleData(et);
        service = (UserRoleDataDetailService)ServiceGlobal.getService(UserRoleDataDetailService.class, this.getSessionFactory());
        ((UserRoleDataDetailServiceBase)service).testRemoveByUserRoleData(et);
        service = (UserRoleDatasService)ServiceGlobal.getService(UserRoleDatasService.class, this.getSessionFactory());
        ((UserRoleDatasServiceBase)service).testRemoveByUserRoleData(et);
        service = (UserRoleDataActionService)ServiceGlobal.getService(UserRoleDataActionService.class, this.getSessionFactory());
        ((UserRoleDataActionServiceBase)service).removeByUserRoleData(et);
        service = (UserRoleDataDetailService)ServiceGlobal.getService(UserRoleDataDetailService.class, this.getSessionFactory());
        ((UserRoleDataDetailServiceBase)service).removeByUserRoleData(et);
        service = (UserRoleDatasService)ServiceGlobal.getService(UserRoleDatasService.class, this.getSessionFactory());
        ((UserRoleDatasServiceBase)service).removeByUserRoleData(et);
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(UserRoleData et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getDEId() != null && (entity = cloneSession.getEntity("DATAENTITY", et.getDEId())) != null) {
            this.onFillParentInfo_DE(et, (DataEntity)entity);
        }
        if (et.getDstOrgSectorId() != null && (entity = cloneSession.getEntity("ORGSECTOR", et.getDstOrgSectorId())) != null) {
            this.onFillParentInfo_DstOrgSector(et, (OrgSector)entity);
        }
        if (et.getDstOrgId() != null && (entity = cloneSession.getEntity("ORG", et.getDstOrgId())) != null) {
            this.onFillParentInfo_DstOrg(et, (Org)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(UserRoleData et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BCDR(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstOrgId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstOrgSectorId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstSecBC(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IsAllData(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrgDR(bBaseMode, et, bCreate, bTempMode)) != null) {
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
        if ((entityFieldError = this.onCheckField_SecDR(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFUserPub(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UDVersion(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserDR(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleDataId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleDataName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_BCDR(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isBCDRDirty()) {
            return null;
        }
        Integer value = et.getBCDR();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_BCDR_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BCDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEId(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDEIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getDEId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DEId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstOrgId(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDstOrgIdDirty()) {
            return null;
        }
        String value = et.getDstOrgId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DstOrgId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTORGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstOrgSectorId(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDstOrgSectorIdDirty()) {
            return null;
        }
        String value = et.getDstOrgSectorId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DstOrgSectorId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTORGSECTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstSecBC(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isDstSecBCDirty()) {
            return null;
        }
        String value = et.getDstSecBC();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_DstSecBC_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTSECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IsAllData(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isIsAllDataDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISALLDATA");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getIsAllData();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISALLDATA");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_IsAllData_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISALLDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_OrgDR(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isOrgDRDirty()) {
            return null;
        }
        Integer value = et.getOrgDR();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_OrgDR_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
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

    protected EntityFieldError onCheckField_SecDR(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSecDRDirty()) {
            return null;
        }
        Integer value = et.getSecDR();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SecDR_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSRFSysPubDirty()) {
            return null;
        }
        Integer value = et.getSRFSysPub();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SRFSysPub_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFUserPub(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isSRFUserPubDirty()) {
            return null;
        }
        Integer value = et.getSRFUserPub();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_SRFUserPub_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFUSERPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UDVersion(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUDVersionDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getUDVersion();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UDVersion_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UDVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserDR(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserDRDirty()) {
            return null;
        }
        Integer value = et.getUserDR();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserDR_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleDataId(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleDataIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleDataId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleDataId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserRoleDataName(boolean bBaseMode, UserRoleData et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isUserRoleDataNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getUserRoleDataName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_UserRoleDataName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLEDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(UserRoleData et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(UserRoleData et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(UserRoleData et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        DataEntity dE = et.getDE();
        if (dE != null && dE.contains(strField)) {
            return dE.get(strField);
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "BCDR", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_BCDR_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DEId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DEName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTORGID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstOrgId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTORGNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstOrgName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTORGSECTORID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstOrgSectorId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTORGSECTORNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstOrgSectorName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "DSTSECBC", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_DstSecBC_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ISALLDATA", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_IsAllData_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "MEMO", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_Memo_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ORGDR", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_OrgDR_Default(et, bCreate, bTempMode);
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
        if (StringHelper.compare(strDEFieldName, "SECDR", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SecDR_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SRFSYSPUB", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "SRFUSERPUB", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_SRFUserPub_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UDVERSION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UDVersion_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERDR", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserDR_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDATAID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDataId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "USERROLEDATANAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UserRoleDataName_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_BCDR_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_DEId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEID", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DEName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstOrgId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTORGID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstOrgName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTORGNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstOrgSectorId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTORGSECTORID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstOrgSectorName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTORGSECTORNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_DstSecBC_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTSECBC", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_IsAllData_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", et, bTempMode, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_OrgDR_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_SecDR_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_SRFUserPub_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UDVersion_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
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

    protected String onTestValueRule_UserDR_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserRoleDataId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDATAID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UserRoleDataName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLEDATANAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserRoleData et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(UserRoleData et) throws Exception {
        super.onUpdateParent(et);
    }
}

