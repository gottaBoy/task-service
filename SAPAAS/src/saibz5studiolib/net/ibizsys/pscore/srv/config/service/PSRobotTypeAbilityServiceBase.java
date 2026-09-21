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
import net.ibizsys.pscore.srv.config.dao.PSRobotTypeAbilityDAO;
import net.ibizsys.pscore.srv.config.demodel.PSRobotTypeAbilityDEModel;
import net.ibizsys.pscore.srv.config.entity.PSRobotType;
import net.ibizsys.pscore.srv.config.entity.PSRobotTypeAbility;
import net.ibizsys.pscore.srv.config.entity.PSRobotTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSRobotWorkType;
import net.ibizsys.pscore.srv.config.entity.PSRobotWorkTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRobotTypeAbilityServiceBase
extends PSCoreSysServiceBase<PSRobotTypeAbility> {
    private static final Log log = LogFactory.getLog(PSRobotTypeAbilityServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSRobotTypeAbilityDEModel pSRobotTypeAbilityDEModel;
    private PSRobotTypeAbilityDAO pSRobotTypeAbilityDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSRobotTypeAbilityService";
    }

    public PSRobotTypeAbilityDEModel getPSRobotTypeAbilityDEModel() {
        if (this.pSRobotTypeAbilityDEModel == null) {
            try {
                this.pSRobotTypeAbilityDEModel = (PSRobotTypeAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSRobotTypeAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRobotTypeAbilityDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSRobotTypeAbilityDEModel();
    }

    public PSRobotTypeAbilityDAO getPSRobotTypeAbilityDAO() {
        if (this.pSRobotTypeAbilityDAO == null) {
            try {
                this.pSRobotTypeAbilityDAO = (PSRobotTypeAbilityDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSRobotTypeAbilityDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRobotTypeAbilityDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSRobotTypeAbilityDAO();
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

    protected void onFillParentInfo(PSRobotTypeAbility pSRobotTypeAbility, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSROBOTTYPEABILITY_PSROBOTTYPE_PSROBOTTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotTypeService", (SessionFactory)this.getSessionFactory());
            PSRobotType pSRobotType = (PSRobotType)iService.getDEModel().createEntity();
            pSRobotType.set("PSROBOTTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRobotType);
            } else {
                iService.get((IEntity)pSRobotType);
            }
            this.onFillParentInfo_PSRobotType(pSRobotTypeAbility, pSRobotType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSROBOTTYPEABILITY_PSROBOTWORKTYPE_PSROBOTWORKTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService", (SessionFactory)this.getSessionFactory());
            PSRobotWorkType pSRobotWorkType = (PSRobotWorkType)iService.getDEModel().createEntity();
            pSRobotWorkType.set("PSROBOTWORKTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSRobotWorkType);
            } else {
                iService.get((IEntity)pSRobotWorkType);
            }
            this.onFillParentInfo_PSRobotWorkType(pSRobotTypeAbility, pSRobotWorkType);
            return;
        }
        super.onFillParentInfo((IEntity)pSRobotTypeAbility, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSRobotType(PSRobotTypeAbility pSRobotTypeAbility, PSRobotType pSRobotType) throws Exception {
        pSRobotTypeAbility.setPSRobotTypeId(pSRobotType.getPSRobotTypeId());
        pSRobotTypeAbility.setPSRobotTypeName(pSRobotType.getPSRobotTypeName());
    }

    protected void onFillParentInfo_PSRobotWorkType(PSRobotTypeAbility pSRobotTypeAbility, PSRobotWorkType pSRobotWorkType) throws Exception {
        pSRobotTypeAbility.setPSRobotWorkTypeId(pSRobotWorkType.getPSRobotWorkTypeId());
        pSRobotTypeAbility.setPSRobotWorkTypeName(pSRobotWorkType.getPSRobotWorkTypeName());
    }

    protected void onFillEntityFullInfo(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
        if (bl && pSRobotTypeAbility.getValidFlag() == null) {
            pSRobotTypeAbility.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSRobotTypeAbility, bl);
        this.onFillEntityFullInfo_PSRobotType(pSRobotTypeAbility, bl);
        this.onFillEntityFullInfo_PSRobotWorkType(pSRobotTypeAbility, bl);
    }

    protected void onFillEntityFullInfo_PSRobotType(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSRobotWorkType(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSRobotTypeAbility, bl);
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotType(PSRobotTypeBase pSRobotTypeBase) throws Exception {
        return this.selectByPSRobotType(pSRobotTypeBase, "", -1);
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotType(PSRobotTypeBase pSRobotTypeBase, String string) throws Exception {
        return this.selectByPSRobotType(pSRobotTypeBase, string, -1);
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotType(PSRobotTypeBase pSRobotTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROBOTTYPEID", (Object)pSRobotTypeBase.getPSRobotTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRobotTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRobotTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotWorkType(PSRobotWorkTypeBase pSRobotWorkTypeBase) throws Exception {
        return this.selectByPSRobotWorkType(pSRobotWorkTypeBase, "", -1);
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotWorkType(PSRobotWorkTypeBase pSRobotWorkTypeBase, String string) throws Exception {
        return this.selectByPSRobotWorkType(pSRobotWorkTypeBase, string, -1);
    }

    public ArrayList<PSRobotTypeAbility> selectByPSRobotWorkType(PSRobotWorkTypeBase pSRobotWorkTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSROBOTWORKTYPEID", (Object)pSRobotWorkTypeBase.getPSRobotWorkTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSRobotWorkTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSRobotWorkTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSRobotType(PSRobotType pSRobotType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotType(pSRobotType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROBOTTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRobotType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSROBOTTYPEABILITY_PSROBOTTYPE_PSROBOTTYPEID", "", iDataEntityModel.getName(), "PSROBOTTYPEABILITY", iDataEntityModel.getDataInfo((IEntity)pSRobotType), arrayList.get(0)));
        }
    }

    public void resetPSRobotType(PSRobotType pSRobotType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotType(pSRobotType);
        for (PSRobotTypeAbility pSRobotTypeAbility : arrayList) {
            PSRobotTypeAbility pSRobotTypeAbility2 = (PSRobotTypeAbility)this.getDEModel().createEntity();
            pSRobotTypeAbility2.setPSRobotTypeAbilityId(pSRobotTypeAbility.getPSRobotTypeAbilityId());
            pSRobotTypeAbility2.setPSRobotTypeId(null);
            this.update(pSRobotTypeAbility2);
        }
    }

    public void removeByPSRobotType(PSRobotType pSRobotType) throws Exception {
        final PSRobotType pSRobotType2 = pSRobotType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRobotTypeAbilityServiceBase.this.onBeforeRemoveByPSRobotType(pSRobotType2);
                PSRobotTypeAbilityServiceBase.this.internalRemoveByPSRobotType(pSRobotType2);
                PSRobotTypeAbilityServiceBase.this.onAfterRemoveByPSRobotType(pSRobotType2);
            }
        });
    }

    protected void onBeforeRemoveByPSRobotType(PSRobotType pSRobotType) throws Exception {
    }

    protected void internalRemoveByPSRobotType(PSRobotType pSRobotType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotType(pSRobotType);
        this.onBeforeRemoveByPSRobotType(pSRobotType, arrayList);
        for (PSRobotTypeAbility pSRobotTypeAbility : arrayList) {
            this.remove((IEntity)pSRobotTypeAbility);
        }
        this.onAfterRemoveByPSRobotType(pSRobotType, arrayList);
    }

    protected void onAfterRemoveByPSRobotType(PSRobotType pSRobotType) throws Exception {
    }

    protected void onBeforeRemoveByPSRobotType(PSRobotType pSRobotType, ArrayList<PSRobotTypeAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRobotType(PSRobotType pSRobotType, ArrayList<PSRobotTypeAbility> arrayList) throws Exception {
    }

    public void testRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotWorkType(pSRobotWorkType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSROBOTWORKTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSRobotWorkType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSROBOTTYPEABILITY_PSROBOTWORKTYPE_PSROBOTWORKTYPEID", "", iDataEntityModel.getName(), "PSROBOTTYPEABILITY", iDataEntityModel.getDataInfo((IEntity)pSRobotWorkType), arrayList.get(0)));
        }
    }

    public void resetPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotWorkType(pSRobotWorkType);
        for (PSRobotTypeAbility pSRobotTypeAbility : arrayList) {
            PSRobotTypeAbility pSRobotTypeAbility2 = (PSRobotTypeAbility)this.getDEModel().createEntity();
            pSRobotTypeAbility2.setPSRobotTypeAbilityId(pSRobotTypeAbility.getPSRobotTypeAbilityId());
            pSRobotTypeAbility2.setPSRobotWorkTypeId(null);
            this.update(pSRobotTypeAbility2);
        }
    }

    public void removeByPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
        final PSRobotWorkType pSRobotWorkType2 = pSRobotWorkType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSRobotTypeAbilityServiceBase.this.onBeforeRemoveByPSRobotWorkType(pSRobotWorkType2);
                PSRobotTypeAbilityServiceBase.this.internalRemoveByPSRobotWorkType(pSRobotWorkType2);
                PSRobotTypeAbilityServiceBase.this.onAfterRemoveByPSRobotWorkType(pSRobotWorkType2);
            }
        });
    }

    protected void onBeforeRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
    }

    protected void internalRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
        ArrayList<PSRobotTypeAbility> arrayList = this.selectByPSRobotWorkType(pSRobotWorkType);
        this.onBeforeRemoveByPSRobotWorkType(pSRobotWorkType, arrayList);
        for (PSRobotTypeAbility pSRobotTypeAbility : arrayList) {
            this.remove((IEntity)pSRobotTypeAbility);
        }
        this.onAfterRemoveByPSRobotWorkType(pSRobotWorkType, arrayList);
    }

    protected void onAfterRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType) throws Exception {
    }

    protected void onBeforeRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType, ArrayList<PSRobotTypeAbility> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSRobotWorkType(PSRobotWorkType pSRobotWorkType, ArrayList<PSRobotTypeAbility> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSRobotTypeAbility pSRobotTypeAbility) throws Exception {
        super.onBeforeRemove(pSRobotTypeAbility);
    }

    protected void replaceParentInfo(PSRobotTypeAbility pSRobotTypeAbility, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSRobotTypeAbility, cloneSession);
        if (pSRobotTypeAbility.getPSRobotTypeId() != null && (iEntity = cloneSession.getEntity("PSROBOTTYPE", (Object)pSRobotTypeAbility.getPSRobotTypeId())) != null) {
            this.onFillParentInfo_PSRobotType(pSRobotTypeAbility, (PSRobotType)iEntity);
        }
        if (pSRobotTypeAbility.getPSRobotWorkTypeId() != null && (iEntity = cloneSession.getEntity("PSROBOTWORKTYPE", (Object)pSRobotTypeAbility.getPSRobotWorkTypeId())) != null) {
            this.onFillParentInfo_PSRobotWorkType(pSRobotTypeAbility, (PSRobotWorkType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSRobotTypeAbility, bl);
    }

    protected void onCheckEntity(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Energy(bl, pSRobotTypeAbility, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotTypeAbilityId(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotTypeAbilityName(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotTypeId(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSRobotWorkTypeId(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RobotLevel(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSRobotTypeAbility, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSRobotTypeAbility, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Energy(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isEnergyDirty() : !pSRobotTypeAbility.isEnergyDirty()) {
            return null;
        }
        Integer n = pSRobotTypeAbility.getEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Energy_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isMemoDirty() : !pSRobotTypeAbility.isMemoDirty()) {
            return null;
        }
        String string = pSRobotTypeAbility.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSRobotTypeAbilityId(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isPSRobotTypeAbilityIdDirty() && !bl2 : !pSRobotTypeAbility.isPSRobotTypeAbilityIdDirty()) {
            return null;
        }
        String string = pSRobotTypeAbility.getPSRobotTypeAbilityId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTTYPEABILITYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotTypeAbilityId_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTTYPEABILITYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotTypeAbilityName(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isPSRobotTypeAbilityNameDirty() && !bl2 : !pSRobotTypeAbility.isPSRobotTypeAbilityNameDirty()) {
            return null;
        }
        String string = pSRobotTypeAbility.getPSRobotTypeAbilityName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTTYPEABILITYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotTypeAbilityName_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTTYPEABILITYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotTypeId(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isPSRobotTypeIdDirty() : !pSRobotTypeAbility.isPSRobotTypeIdDirty()) {
            return null;
        }
        String string = pSRobotTypeAbility.getPSRobotTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotTypeId_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSRobotWorkTypeId(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isPSRobotWorkTypeIdDirty() : !pSRobotTypeAbility.isPSRobotWorkTypeIdDirty()) {
            return null;
        }
        String string = pSRobotTypeAbility.getPSRobotWorkTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSRobotWorkTypeId_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSROBOTWORKTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RobotLevel(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isRobotLevelDirty() : !pSRobotTypeAbility.isRobotLevelDirty()) {
            return null;
        }
        Integer n = pSRobotTypeAbility.getRobotLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RobotLevel_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROBOTLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSRobotTypeAbility pSRobotTypeAbility, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSRobotTypeAbility.isValidFlagDirty() && !bl2 : !pSRobotTypeAbility.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSRobotTypeAbility.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSRobotTypeAbility, bl2, bl3);
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

    protected void onSyncEntity(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSRobotTypeAbility, bl);
    }

    protected void onSyncIndexEntities(PSRobotTypeAbility pSRobotTypeAbility, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSRobotTypeAbility, bl);
    }

    public Object getDataContextValue(PSRobotTypeAbility pSRobotTypeAbility, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSRobotTypeAbility, string, iDataContextParam)) != null) {
            return object;
        }
        PSRobotWorkType pSRobotWorkType = pSRobotTypeAbility.getPSRobotWorkType();
        if (pSRobotWorkType != null && pSRobotWorkType.contains(string)) {
            return pSRobotWorkType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSRobotTypeAbility pSRobotTypeAbility, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSRobotTypeAbility, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Energy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTTYPEABILITYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotTypeAbilityId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTTYPEABILITYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotTypeAbilityName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTWORKTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotWorkTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSROBOTWORKTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSRobotWorkTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROBOTLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RobotLevel_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Energy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSRobotTypeAbilityId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTTYPEABILITYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotTypeAbilityName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTTYPEABILITYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotWorkTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTWORKTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSRobotWorkTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSROBOTWORKTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RobotLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSRobotTypeAbility pSRobotTypeAbility) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSRobotTypeAbility)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSRobotTypeAbility pSRobotTypeAbility) throws Exception {
        super.onUpdateParent((IEntity)pSRobotTypeAbility);
    }

    @Override
    protected void exportCurXmlModel(PSRobotTypeAbility pSRobotTypeAbility, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSROBOTTYPEABILITY");
        if (!bl) {
            pSRobotTypeAbility.setCreateDate(null);
            pSRobotTypeAbility.setCreateMan(null);
            pSRobotTypeAbility.setPSRobotTypeAbilityId(null);
            pSRobotTypeAbility.setPSRobotTypeName(null);
            pSRobotTypeAbility.setPSRobotWorkTypeName(null);
            pSRobotTypeAbility.setUpdateDate(null);
            pSRobotTypeAbility.setUpdateMan(null);
            super.exportCurXmlModel(pSRobotTypeAbility, xmlNode, bl);
        }
    }
}

