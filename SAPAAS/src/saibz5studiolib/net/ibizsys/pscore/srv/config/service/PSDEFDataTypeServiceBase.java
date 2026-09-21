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
import net.ibizsys.pscore.srv.config.dao.PSDEFDataTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSUnit;
import net.ibizsys.pscore.srv.config.entity.PSUnitBase;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.entity.PSValueRuleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplFieldService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDataTypeServiceBase
extends PSCoreSysServiceBase<PSDEFDataType> {
    private static final Log log = LogFactory.getLog(PSDEFDataTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSDEFDataTypeDEModel pSDEFDataTypeDEModel;
    private PSDEFDataTypeDAO pSDEFDataTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService";
    }

    public PSDEFDataTypeDEModel getPSDEFDataTypeDEModel() {
        if (this.pSDEFDataTypeDEModel == null) {
            try {
                this.pSDEFDataTypeDEModel = (PSDEFDataTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDataTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFDataTypeDEModel();
    }

    public PSDEFDataTypeDAO getPSDEFDataTypeDAO() {
        if (this.pSDEFDataTypeDAO == null) {
            try {
                this.pSDEFDataTypeDAO = (PSDEFDataTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDEFDataTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDataTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFDataTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
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

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEFDataType pSDEFDataType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDATATYPE_PSUNIT_PSUNITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUnitService", (SessionFactory)this.getSessionFactory());
            PSUnit pSUnit = (PSUnit)iService.getDEModel().createEntity();
            pSUnit.set("PSUNITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUnit);
            } else {
                iService.get((IEntity)pSUnit);
            }
            this.onFillParentInfo_PSUnit(pSDEFDataType, pSUnit);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDATATYPE_PSVALUERULE_PSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSValueRuleService", (SessionFactory)this.getSessionFactory());
            PSValueRule pSValueRule = (PSValueRule)iService.getDEModel().createEntity();
            pSValueRule.set("PSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSValueRule);
            } else {
                iService.get((IEntity)pSValueRule);
            }
            this.onFillParentInfo_PSValueRule(pSDEFDataType, pSValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFDataType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSUnit(PSDEFDataType pSDEFDataType, PSUnit pSUnit) throws Exception {
        pSDEFDataType.setPSUnitId(pSUnit.getPSUnitId());
        pSDEFDataType.setPSUnitName(pSUnit.getPSUnitName());
    }

    protected void onFillParentInfo_PSValueRule(PSDEFDataType pSDEFDataType, PSValueRule pSValueRule) throws Exception {
        pSDEFDataType.setPSValueRuleId(pSValueRule.getPSValueRuleId());
        pSDEFDataType.setPSValueRuleName(pSValueRule.getPSValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        if (bl && pSDEFDataType.getValidFlag() == null) {
            pSDEFDataType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEFDataType, bl);
        this.onFillEntityFullInfo_PSUnit(pSDEFDataType, bl);
        this.onFillEntityFullInfo_PSValueRule(pSDEFDataType, bl);
    }

    protected void onFillEntityFullInfo_PSUnit(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        if (pSDEFDataType.isPSUnitIdDirty()) {
            if (pSDEFDataType.getPSUnitId() != null) {
                if (pSDEFDataType.getPSUnitId() == null || pSDEFDataType.getPSUnitName() == null) {
                    PSUnit pSUnit = pSDEFDataType.getPSUnit();
                    pSDEFDataType.setPSUnitName(pSUnit.getPSUnitName());
                }
            } else {
                pSDEFDataType.setPSUnitName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSValueRule(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        if (pSDEFDataType.isPSValueRuleIdDirty()) {
            if (pSDEFDataType.getPSValueRuleId() != null) {
                if (pSDEFDataType.getPSValueRuleId() == null || pSDEFDataType.getPSValueRuleName() == null) {
                    PSValueRule pSValueRule = pSDEFDataType.getPSValueRule();
                    pSDEFDataType.setPSValueRuleName(pSValueRule.getPSValueRuleName());
                }
            } else {
                pSDEFDataType.setPSValueRuleName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFDataType, bl);
    }

    public ArrayList<PSDEFDataType> selectByPSUnit(PSUnitBase pSUnitBase) throws Exception {
        return this.selectByPSUnit(pSUnitBase, "", -1);
    }

    public ArrayList<PSDEFDataType> selectByPSUnit(PSUnitBase pSUnitBase, String string) throws Exception {
        return this.selectByPSUnit(pSUnitBase, string, -1);
    }

    public ArrayList<PSDEFDataType> selectByPSUnit(PSUnitBase pSUnitBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSUNITID", (Object)pSUnitBase.getPSUnitId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSUnitCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSUnitCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDataType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFDataType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFDataType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVALUERULEID", (Object)pSValueRuleBase.getPSValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSUnit(pSUnit, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUNIT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUnit);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFDATATYPE_PSUNIT_PSUNITID", "", iDataEntityModel.getName(), "PSDEFDATATYPE", iDataEntityModel.getDataInfo((IEntity)pSUnit), arrayList.get(0)));
        }
    }

    public void resetPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSUnit(pSUnit);
        for (PSDEFDataType pSDEFDataType : arrayList) {
            PSDEFDataType pSDEFDataType2 = (PSDEFDataType)this.getDEModel().createEntity();
            pSDEFDataType2.setPSDEFDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
            pSDEFDataType2.setPSUnitId(null);
            this.update(pSDEFDataType2);
        }
    }

    public void removeByPSUnit(PSUnit pSUnit) throws Exception {
        final PSUnit pSUnit2 = pSUnit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDataTypeServiceBase.this.onBeforeRemoveByPSUnit(pSUnit2);
                PSDEFDataTypeServiceBase.this.internalRemoveByPSUnit(pSUnit2);
                PSDEFDataTypeServiceBase.this.onAfterRemoveByPSUnit(pSUnit2);
            }
        });
    }

    protected void onBeforeRemoveByPSUnit(PSUnit pSUnit) throws Exception {
    }

    protected void internalRemoveByPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSUnit(pSUnit);
        this.onBeforeRemoveByPSUnit(pSUnit, arrayList);
        for (PSDEFDataType pSDEFDataType : arrayList) {
            this.remove((IEntity)pSDEFDataType);
        }
        this.onAfterRemoveByPSUnit(pSUnit, arrayList);
    }

    protected void onAfterRemoveByPSUnit(PSUnit pSUnit) throws Exception {
    }

    protected void onBeforeRemoveByPSUnit(PSUnit pSUnit, ArrayList<PSDEFDataType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUnit(PSUnit pSUnit, ArrayList<PSDEFDataType> arrayList) throws Exception {
    }

    public void testRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSValueRule(pSValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFDATATYPE_PSVALUERULE_PSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFDATATYPE", iDataEntityModel.getDataInfo((IEntity)pSValueRule), arrayList.get(0)));
        }
    }

    public void resetPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSValueRule(pSValueRule);
        for (PSDEFDataType pSDEFDataType : arrayList) {
            PSDEFDataType pSDEFDataType2 = (PSDEFDataType)this.getDEModel().createEntity();
            pSDEFDataType2.setPSDEFDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
            pSDEFDataType2.setPSValueRuleId(null);
            this.update(pSDEFDataType2);
        }
    }

    public void removeByPSValueRule(PSValueRule pSValueRule) throws Exception {
        final PSValueRule pSValueRule2 = pSValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDataTypeServiceBase.this.onBeforeRemoveByPSValueRule(pSValueRule2);
                PSDEFDataTypeServiceBase.this.internalRemoveByPSValueRule(pSValueRule2);
                PSDEFDataTypeServiceBase.this.onAfterRemoveByPSValueRule(pSValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void internalRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFDataType> arrayList = this.selectByPSValueRule(pSValueRule);
        this.onBeforeRemoveByPSValueRule(pSValueRule, arrayList);
        for (PSDEFDataType pSDEFDataType : arrayList) {
            this.remove((IEntity)pSDEFDataType);
        }
        this.onAfterRemoveByPSValueRule(pSValueRule, arrayList);
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSDEFDataType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSDEFDataType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFDataType pSDEFDataType) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCDETemplFieldService)ServiceGlobal.getService(PSDCDETemplFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCDETemplFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDataType(pSDEFDataType);
        pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDataType(pSDEFDataType);
        pSCoreSysServiceBase = (PSSubSysSADEFieldService)ServiceGlobal.getService(PSSubSysSADEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubSysSADEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSDataType(pSDEFDataType);
        super.onBeforeRemove(pSDEFDataType);
    }

    protected void replaceParentInfo(PSDEFDataType pSDEFDataType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFDataType, cloneSession);
        if (pSDEFDataType.getPSUnitId() != null && (iEntity = cloneSession.getEntity("PSUNIT", (Object)pSDEFDataType.getPSUnitId())) != null) {
            this.onFillParentInfo_PSUnit(pSDEFDataType, (PSUnit)iEntity);
        }
        if (pSDEFDataType.getPSValueRuleId() != null && (iEntity = cloneSession.getEntity("PSVALUERULE", (Object)pSDEFDataType.getPSValueRuleId())) != null) {
            this.onFillParentInfo_PSValueRule(pSDEFDataType, (PSValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFDataType, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DB2DataType(bl, pSDEFDataType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserCreate(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExPhyFlag(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormularFlag(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IntDataType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IntDataType2(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkFlag(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSSQLDataType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MySQLDataType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OracleDataType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PhysicalFlag(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PostgreSQLType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDataTypeId(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDataTypeName(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUnitId(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUnitName(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSValueRuleId(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSValueRuleName(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SADEFieldType(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SADEFieldType2(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeDesc(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEFDataType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFDataType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DB2DataType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isDB2DataTypeDirty() : !pSDEFDataType.isDB2DataTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getDB2DataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DB2DataType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DB2DATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserCreate(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isEnableUserCreateDirty() && !bl2 : !pSDEFDataType.isEnableUserCreateDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getEnableUserCreate();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERCREATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnableUserCreate_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERCREATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExPhyFlag(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isExPhyFlagDirty() : !pSDEFDataType.isExPhyFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getExPhyFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExPhyFlag_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPHYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormularFlag(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isFormularFlagDirty() : !pSDEFDataType.isFormularFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getFormularFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FormularFlag_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMULAFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IntDataType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isIntDataTypeDirty() : !pSDEFDataType.isIntDataTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getIntDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IntDataType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INTDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IntDataType2(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isIntDataType2Dirty() : !pSDEFDataType.isIntDataType2Dirty()) {
            return null;
        }
        String string = pSDEFDataType.getIntDataType2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IntDataType2_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INTDATATYPE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isLengthDirty() : !pSDEFDataType.isLengthDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkFlag(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isLinkFlagDirty() : !pSDEFDataType.isLinkFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getLinkFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkFlag_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isMemoDirty() : !pSDEFDataType.isMemoDirty()) {
            return null;
        }
        String string = pSDEFDataType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MSSQLDataType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isMSSQLDataTypeDirty() : !pSDEFDataType.isMSSQLDataTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getMSSQLDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSSQLDataType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSSQLDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MySQLDataType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isMySQLDataTypeDirty() : !pSDEFDataType.isMySQLDataTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getMySQLDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MySQLDataType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYSQLDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OracleDataType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isOracleDataTypeDirty() : !pSDEFDataType.isOracleDataTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getOracleDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OracleDataType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORACLEDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isOrderValueDirty() : !pSDEFDataType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEFDataType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PhysicalFlag(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPhysicalFlagDirty() : !pSDEFDataType.isPhysicalFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getPhysicalFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PhysicalFlag_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHYSICALFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PostgreSQLType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPostgreSQLTypeDirty() : !pSDEFDataType.isPostgreSQLTypeDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPostgreSQLType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PostgreSQLType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("POSTGRESQLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPrecision2Dirty() : !pSDEFDataType.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDataTypeId(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSDEFDataTypeIdDirty() && !bl2 : !pSDEFDataType.isPSDEFDataTypeIdDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSDEFDataTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDATATYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDataTypeId_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDataTypeName(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSDEFDataTypeNameDirty() && !bl2 : !pSDEFDataType.isPSDEFDataTypeNameDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSDEFDataTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDATATYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDataTypeName_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDATATYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUnitId(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSUnitIdDirty() : !pSDEFDataType.isPSUnitIdDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSUnitId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUnitId_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUNITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUnitName(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSUnitNameDirty() : !pSDEFDataType.isPSUnitNameDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSUnitName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUnitName_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSUNITNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSValueRuleId(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSValueRuleIdDirty() : !pSDEFDataType.isPSValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSValueRuleId_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSValueRuleName(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isPSValueRuleNameDirty() : !pSDEFDataType.isPSValueRuleNameDirty()) {
            return null;
        }
        String string = pSDEFDataType.getPSValueRuleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSValueRuleName_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVALUERULENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SADEFieldType(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isSADEFieldTypeDirty() : !pSDEFDataType.isSADEFieldTypeDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getSADEFieldType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SADEFieldType_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SADEFIELDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SADEFieldType2(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isSADEFieldType2Dirty() : !pSDEFDataType.isSADEFieldType2Dirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getSADEFieldType2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SADEFieldType2_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SADEFIELDTYPE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeDesc(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isTypeDescDirty() : !pSDEFDataType.isTypeDescDirty()) {
            return null;
        }
        String string = pSDEFDataType.getTypeDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeDesc_Default((IEntity)pSDEFDataType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEFDataType pSDEFDataType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDataType.isValidFlagDirty() : !pSDEFDataType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDataType.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEFDataType, bl2, bl3);
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

    protected void onSyncEntity(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFDataType, bl);
    }

    protected void onSyncIndexEntities(PSDEFDataType pSDEFDataType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFDataType, bl);
    }

    public Object getDataContextValue(PSDEFDataType pSDEFDataType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFDataType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFDataType pSDEFDataType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEFDataType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DB2DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DB2DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERCREATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserCreate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPHYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExPhyFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMULAFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormularFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INTDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IntDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INTDATATYPE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IntDataType2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSSQLDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSSQLDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYSQLDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MySQLDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORACLEDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OracleDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHYSICALFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PhysicalFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"POSTGRESQLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PostgreSQLType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUNITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUnitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSUNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSUnitName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SADEFIELDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SADEFieldType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SADEFIELDTYPE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SADEFieldType2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeDesc_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DB2DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DB2DATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableUserCreate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExPhyFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormularFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IntDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INTDATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IntDataType2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INTDATATYPE2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MSSQLDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSSQLDATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MySQLDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYSQLDATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OracleDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORACLEDATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PhysicalFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PostgreSQLType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("POSTGRESQLTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUnitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUNITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSUnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSUNITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SADEFieldType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SADEFieldType2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TypeDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEDESC", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFDataType pSDEFDataType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFDataType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFDataType pSDEFDataType) throws Exception {
        super.onUpdateParent((IEntity)pSDEFDataType);
    }

    @Override
    protected void exportCurXmlModel(PSDEFDataType pSDEFDataType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFDATATYPE");
        if (!bl) {
            pSDEFDataType.setCreateDate(null);
            pSDEFDataType.setCreateMan(null);
            pSDEFDataType.setUpdateDate(null);
            pSDEFDataType.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFDataType, xmlNode, bl);
        }
    }
}

