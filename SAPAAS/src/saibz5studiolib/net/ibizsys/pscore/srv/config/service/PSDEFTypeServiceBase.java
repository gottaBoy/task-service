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
import net.ibizsys.pscore.srv.config.dao.PSDEFTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSDEFTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFType;
import net.ibizsys.pscore.srv.config.entity.PSUnit;
import net.ibizsys.pscore.srv.config.entity.PSUnitBase;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.entity.PSValueRuleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFTypeServiceBase
extends PSCoreSysServiceBase<PSDEFType> {
    private static final Log log = LogFactory.getLog(PSDEFTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFTypeDEModel pSDEFTypeDEModel;
    private PSDEFTypeDAO pSDEFTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSDEFTypeService";
    }

    public PSDEFTypeDEModel getPSDEFTypeDEModel() {
        if (this.pSDEFTypeDEModel == null) {
            try {
                this.pSDEFTypeDEModel = (PSDEFTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFTypeDEModel();
    }

    public PSDEFTypeDAO getPSDEFTypeDAO() {
        if (this.pSDEFTypeDAO == null) {
            try {
                this.pSDEFTypeDAO = (PSDEFTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSDEFTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFTypeDAO();
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

    protected void onFillParentInfo(PSDEFType pSDEFType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFTYPE_PSCODELISTTEMPL_PSCODELISTTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCodeListTemplService", (SessionFactory)this.getSessionFactory());
            PSCodeListTempl pSCodeListTempl = (PSCodeListTempl)iService.getDEModel().createEntity();
            pSCodeListTempl.set("PSCODELISTTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeListTempl);
            } else {
                iService.get((IEntity)pSCodeListTempl);
            }
            this.onFillParentInfo_PSCodeListTempl(pSDEFType, pSCodeListTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFTYPE_PSUNIT_PSUNITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUnitService", (SessionFactory)this.getSessionFactory());
            PSUnit pSUnit = (PSUnit)iService.getDEModel().createEntity();
            pSUnit.set("PSUNITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSUnit);
            } else {
                iService.get((IEntity)pSUnit);
            }
            this.onFillParentInfo_PSUnit(pSDEFType, pSUnit);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFTYPE_PSVALUERULE_PSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSValueRuleService", (SessionFactory)this.getSessionFactory());
            PSValueRule pSValueRule = (PSValueRule)iService.getDEModel().createEntity();
            pSValueRule.set("PSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSValueRule);
            } else {
                iService.get((IEntity)pSValueRule);
            }
            this.onFillParentInfo_PSValueRule(pSDEFType, pSValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeListTempl(PSDEFType pSDEFType, PSCodeListTempl pSCodeListTempl) throws Exception {
        pSDEFType.setPSCodeListTemplId(pSCodeListTempl.getPSCodeListTemplId());
        pSDEFType.setPSCodeListTemplName(pSCodeListTempl.getPSCodeListTemplName());
    }

    protected void onFillParentInfo_PSUnit(PSDEFType pSDEFType, PSUnit pSUnit) throws Exception {
        pSDEFType.setPSUnitId(pSUnit.getPSUnitId());
        pSDEFType.setPSUnitName(pSUnit.getPSUnitName());
    }

    protected void onFillParentInfo_PSValueRule(PSDEFType pSDEFType, PSValueRule pSValueRule) throws Exception {
        pSDEFType.setPSValueRuleId(pSValueRule.getPSValueRuleId());
        pSDEFType.setPSValueRuleName(pSValueRule.getPSValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFType pSDEFType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEFType, bl);
        this.onFillEntityFullInfo_PSCodeListTempl(pSDEFType, bl);
        this.onFillEntityFullInfo_PSUnit(pSDEFType, bl);
        this.onFillEntityFullInfo_PSValueRule(pSDEFType, bl);
    }

    protected void onFillEntityFullInfo_PSCodeListTempl(PSDEFType pSDEFType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSUnit(PSDEFType pSDEFType, boolean bl) throws Exception {
        if (pSDEFType.isPSUnitIdDirty()) {
            if (pSDEFType.getPSUnitId() != null) {
                if (pSDEFType.getPSUnitId() == null || pSDEFType.getPSUnitName() == null) {
                    PSUnit pSUnit = pSDEFType.getPSUnit();
                    pSDEFType.setPSUnitName(pSUnit.getPSUnitName());
                }
            } else {
                pSDEFType.setPSUnitName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSValueRule(PSDEFType pSDEFType, boolean bl) throws Exception {
        if (pSDEFType.isPSValueRuleIdDirty()) {
            if (pSDEFType.getPSValueRuleId() != null) {
                if (pSDEFType.getPSValueRuleId() == null || pSDEFType.getPSValueRuleName() == null) {
                    PSValueRule pSValueRule = pSDEFType.getPSValueRule();
                    pSDEFType.setPSValueRuleName(pSValueRule.getPSValueRuleName());
                }
            } else {
                pSDEFType.setPSValueRuleName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFType pSDEFType, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFType, bl);
    }

    public ArrayList<PSDEFType> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase) throws Exception {
        return this.selectByPSCodeListTempl(pSCodeListTemplBase, "", -1);
    }

    public ArrayList<PSDEFType> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase, String string) throws Exception {
        return this.selectByPSCodeListTempl(pSCodeListTemplBase, string, -1);
    }

    public ArrayList<PSDEFType> selectByPSCodeListTempl(PSCodeListTemplBase pSCodeListTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTTEMPLID", (Object)pSCodeListTemplBase.getPSCodeListTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFType> selectByPSUnit(PSUnitBase pSUnitBase) throws Exception {
        return this.selectByPSUnit(pSUnitBase, "", -1);
    }

    public ArrayList<PSDEFType> selectByPSUnit(PSUnitBase pSUnitBase, String string) throws Exception {
        return this.selectByPSUnit(pSUnitBase, string, -1);
    }

    public ArrayList<PSDEFType> selectByPSUnit(PSUnitBase pSUnitBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string) throws Exception {
        return this.selectByPSValueRule(pSValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFType> selectByPSValueRule(PSValueRuleBase pSValueRuleBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELISTTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeListTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFTYPE_PSCODELISTTEMPL_PSCODELISTTEMPLID", "", iDataEntityModel.getName(), "PSDEFTYPE", iDataEntityModel.getDataInfo((IEntity)pSCodeListTempl), arrayList.get(0)));
        }
    }

    public void resetPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl);
        for (PSDEFType pSDEFType : arrayList) {
            PSDEFType pSDEFType2 = (PSDEFType)this.getDEModel().createEntity();
            pSDEFType2.setPSDEFTypeId(pSDEFType.getPSDEFTypeId());
            pSDEFType2.setPSCodeListTemplId(null);
            this.update(pSDEFType2);
        }
    }

    public void removeByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        final PSCodeListTempl pSCodeListTempl2 = pSCodeListTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFTypeServiceBase.this.onBeforeRemoveByPSCodeListTempl(pSCodeListTempl2);
                PSDEFTypeServiceBase.this.internalRemoveByPSCodeListTempl(pSCodeListTempl2);
                PSDEFTypeServiceBase.this.onAfterRemoveByPSCodeListTempl(pSCodeListTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
    }

    protected void internalRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSCodeListTempl(pSCodeListTempl);
        this.onBeforeRemoveByPSCodeListTempl(pSCodeListTempl, arrayList);
        for (PSDEFType pSDEFType : arrayList) {
            this.remove((IEntity)pSDEFType);
        }
        this.onAfterRemoveByPSCodeListTempl(pSCodeListTempl, arrayList);
    }

    protected void onAfterRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeListTempl(PSCodeListTempl pSCodeListTempl, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSUnit(pSUnit, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSUNIT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSUnit);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFTYPE_PSUNIT_PSUNITID", "", iDataEntityModel.getName(), "PSDEFTYPE", iDataEntityModel.getDataInfo((IEntity)pSUnit), arrayList.get(0)));
        }
    }

    public void resetPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSUnit(pSUnit);
        for (PSDEFType pSDEFType : arrayList) {
            PSDEFType pSDEFType2 = (PSDEFType)this.getDEModel().createEntity();
            pSDEFType2.setPSDEFTypeId(pSDEFType.getPSDEFTypeId());
            pSDEFType2.setPSUnitId(null);
            this.update(pSDEFType2);
        }
    }

    public void removeByPSUnit(PSUnit pSUnit) throws Exception {
        final PSUnit pSUnit2 = pSUnit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFTypeServiceBase.this.onBeforeRemoveByPSUnit(pSUnit2);
                PSDEFTypeServiceBase.this.internalRemoveByPSUnit(pSUnit2);
                PSDEFTypeServiceBase.this.onAfterRemoveByPSUnit(pSUnit2);
            }
        });
    }

    protected void onBeforeRemoveByPSUnit(PSUnit pSUnit) throws Exception {
    }

    protected void internalRemoveByPSUnit(PSUnit pSUnit) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSUnit(pSUnit);
        this.onBeforeRemoveByPSUnit(pSUnit, arrayList);
        for (PSDEFType pSDEFType : arrayList) {
            this.remove((IEntity)pSDEFType);
        }
        this.onAfterRemoveByPSUnit(pSUnit, arrayList);
    }

    protected void onAfterRemoveByPSUnit(PSUnit pSUnit) throws Exception {
    }

    protected void onBeforeRemoveByPSUnit(PSUnit pSUnit, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSUnit(PSUnit pSUnit, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSValueRule(pSValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFTYPE_PSVALUERULE_PSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFTYPE", iDataEntityModel.getDataInfo((IEntity)pSValueRule), arrayList.get(0)));
        }
    }

    public void resetPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSValueRule(pSValueRule);
        for (PSDEFType pSDEFType : arrayList) {
            PSDEFType pSDEFType2 = (PSDEFType)this.getDEModel().createEntity();
            pSDEFType2.setPSDEFTypeId(pSDEFType.getPSDEFTypeId());
            pSDEFType2.setPSValueRuleId(null);
            this.update(pSDEFType2);
        }
    }

    public void removeByPSValueRule(PSValueRule pSValueRule) throws Exception {
        final PSValueRule pSValueRule2 = pSValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFTypeServiceBase.this.onBeforeRemoveByPSValueRule(pSValueRule2);
                PSDEFTypeServiceBase.this.internalRemoveByPSValueRule(pSValueRule2);
                PSDEFTypeServiceBase.this.onAfterRemoveByPSValueRule(pSValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void internalRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
        ArrayList<PSDEFType> arrayList = this.selectByPSValueRule(pSValueRule);
        this.onBeforeRemoveByPSValueRule(pSValueRule, arrayList);
        for (PSDEFType pSDEFType : arrayList) {
            this.remove((IEntity)pSDEFType);
        }
        this.onAfterRemoveByPSValueRule(pSValueRule, arrayList);
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSValueRule(PSValueRule pSValueRule, ArrayList<PSDEFType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFType pSDEFType) throws Exception {
        super.onBeforeRemove(pSDEFType);
    }

    protected void replaceParentInfo(PSDEFType pSDEFType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFType, cloneSession);
        if (pSDEFType.getPSCodeListTemplId() != null && (iEntity = cloneSession.getEntity("PSCODELISTTEMPL", (Object)pSDEFType.getPSCodeListTemplId())) != null) {
            this.onFillParentInfo_PSCodeListTempl(pSDEFType, (PSCodeListTempl)iEntity);
        }
        if (pSDEFType.getPSUnitId() != null && (iEntity = cloneSession.getEntity("PSUNIT", (Object)pSDEFType.getPSUnitId())) != null) {
            this.onFillParentInfo_PSUnit(pSDEFType, (PSUnit)iEntity);
        }
        if (pSDEFType.getPSValueRuleId() != null && (iEntity = cloneSession.getEntity("PSVALUERULE", (Object)pSDEFType.getPSValueRuleId())) != null) {
            this.onFillParentInfo_PSValueRule(pSDEFType, (PSValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFType pSDEFType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFType, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DataTypes(bl, pSDEFType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DotNETFormat(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorHeight(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorWidth(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Fields(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormItemObj(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColAlign(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColCLMode(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColObj(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColWidth(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconPath(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncrementFlag(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JAVAFormat(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSFormat(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValueStr(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorHeight(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorType(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorWidth(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValueStr(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjHelper(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ObjHelper2(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListTemplId(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFTypeId(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFTypeName(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUnitId(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSUnitName(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSValueRuleId(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSValueRuleName(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PYFormat(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorHeight(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorType(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorWidth(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorHeight(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorType(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorWidth(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchModeObj(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFItemObj(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StrLength(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestData(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSFormat(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIModeObj(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnsignedFlag(bl, pSDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DataTypes(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isDataTypesDirty() : !pSDEFType.isDataTypesDirty()) {
            return null;
        }
        String string = pSDEFType.getDataTypes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataTypes_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DotNETFormat(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isDotNETFormatDirty() : !pSDEFType.isDotNETFormatDirty()) {
            return null;
        }
        String string = pSDEFType.getDotNETFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DotNETFormat_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOTNETFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorHeight(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isEditorHeightDirty() : !pSDEFType.isEditorHeightDirty()) {
            return null;
        }
        Integer n = pSDEFType.getEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditorHeight_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isEditorTypeDirty() : !pSDEFType.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFType.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorWidth(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isEditorWidthDirty() : !pSDEFType.isEditorWidthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditorWidth_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Fields(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isFieldsDirty() : !pSDEFType.isFieldsDirty()) {
            return null;
        }
        String string = pSDEFType.getFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Fields_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormItemObj(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isFormItemObjDirty() : !pSDEFType.isFormItemObjDirty()) {
            return null;
        }
        String string = pSDEFType.getFormItemObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormItemObj_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMITEMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColAlign(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isGridColAlignDirty() : !pSDEFType.isGridColAlignDirty()) {
            return null;
        }
        String string = pSDEFType.getGridColAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColAlign_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColCLMode(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isGridColCLModeDirty() : !pSDEFType.isGridColCLModeDirty()) {
            return null;
        }
        String string = pSDEFType.getGridColCLMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColCLMode_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLCLMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColObj(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isGridColObjDirty() : !pSDEFType.isGridColObjDirty()) {
            return null;
        }
        String string = pSDEFType.getGridColObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColObj_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColWidth(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isGridColWidthDirty() : !pSDEFType.isGridColWidthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getGridColWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridColWidth_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconPath(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isIconPathDirty() : !pSDEFType.isIconPathDirty()) {
            return null;
        }
        String string = pSDEFType.getIconPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconPath_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncrementFlag(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isIncrementFlagDirty() : !pSDEFType.isIncrementFlagDirty()) {
            return null;
        }
        Integer n = pSDEFType.getIncrementFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncrementFlag_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCREMENTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JAVAFormat(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isJAVAFormatDirty() : !pSDEFType.isJAVAFormatDirty()) {
            return null;
        }
        String string = pSDEFType.getJAVAFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JAVAFormat_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JAVAFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JSFormat(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isJSFormatDirty() : !pSDEFType.isJSFormatDirty()) {
            return null;
        }
        String string = pSDEFType.getJSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSFormat_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValueStr(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMaxValueStrDirty() : !pSDEFType.isMaxValueStrDirty()) {
            return null;
        }
        String string = pSDEFType.getMaxValueStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValueStr_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUESTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MBEditorHeight(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMBEditorHeightDirty() : !pSDEFType.isMBEditorHeightDirty()) {
            return null;
        }
        Integer n = pSDEFType.getMBEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MBEditorHeight_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MBEDITORHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MBEditorType(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMBEditorTypeDirty() : !pSDEFType.isMBEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFType.getMBEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MBEditorType_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MBEDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MBEditorWidth(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMBEditorWidthDirty() : !pSDEFType.isMBEditorWidthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getMBEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MBEditorWidth_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MBEDITORWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMemoDirty() : !pSDEFType.isMemoDirty()) {
            return null;
        }
        String string = pSDEFType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMinStrLengthDirty() : !pSDEFType.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValueStr(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isMinValueStrDirty() : !pSDEFType.isMinValueStrDirty()) {
            return null;
        }
        String string = pSDEFType.getMinValueStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValueStr_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUESTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjHelper(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isObjHelperDirty() && !bl2 : !pSDEFType.isObjHelperDirty()) {
            return null;
        }
        String string = pSDEFType.getObjHelper();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJHELPER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjHelper_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJHELPER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ObjHelper2(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isObjHelper2Dirty() : !pSDEFType.isObjHelper2Dirty()) {
            return null;
        }
        String string = pSDEFType.getObjHelper2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ObjHelper2_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OBJHELPER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isOrderValueDirty() : !pSDEFType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPrecision2Dirty() : !pSDEFType.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEFType.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListTemplId(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSCodeListTemplIdDirty() : !pSDEFType.isPSCodeListTemplIdDirty()) {
            return null;
        }
        String string = pSDEFType.getPSCodeListTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListTemplId_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFTypeId(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSDEFTypeIdDirty() && !bl2 : !pSDEFType.isPSDEFTypeIdDirty()) {
            return null;
        }
        String string = pSDEFType.getPSDEFTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFTypeId_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFTypeName(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSDEFTypeNameDirty() && !bl2 : !pSDEFType.isPSDEFTypeNameDirty()) {
            return null;
        }
        String string = pSDEFType.getPSDEFTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFTypeName_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSUnitId(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSUnitIdDirty() : !pSDEFType.isPSUnitIdDirty()) {
            return null;
        }
        String string = pSDEFType.getPSUnitId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUnitId_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSUnitName(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSUnitNameDirty() : !pSDEFType.isPSUnitNameDirty()) {
            return null;
        }
        String string = pSDEFType.getPSUnitName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSUnitName_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSValueRuleId(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSValueRuleIdDirty() : !pSDEFType.isPSValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFType.getPSValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSValueRuleId_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSValueRuleName(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPSValueRuleNameDirty() : !pSDEFType.isPSValueRuleNameDirty()) {
            return null;
        }
        String string = pSDEFType.getPSValueRuleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSValueRuleName_Default((IEntity)pSDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PYFormat(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isPYFormatDirty() : !pSDEFType.isPYFormatDirty()) {
            return null;
        }
        String string = pSDEFType.getPYFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PYFormat_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PYFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchEditorHeight(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchEditorHeightDirty() : !pSDEFType.isSearchEditorHeightDirty()) {
            return null;
        }
        Integer n = pSDEFType.getSearchEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchEditorHeight_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHEDITORHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchEditorType(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchEditorTypeDirty() : !pSDEFType.isSearchEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFType.getSearchEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchEditorType_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHEDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchEditorWidth(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchEditorWidthDirty() : !pSDEFType.isSearchEditorWidthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getSearchEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchEditorWidth_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHEDITORWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchMBEditorHeight(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchMBEditorHeightDirty() : !pSDEFType.isSearchMBEditorHeightDirty()) {
            return null;
        }
        Integer n = pSDEFType.getSearchMBEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchMBEditorHeight_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMBEDITORHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchMBEditorType(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchMBEditorTypeDirty() : !pSDEFType.isSearchMBEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFType.getSearchMBEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchMBEditorType_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMBEDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchMBEditorWidth(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchMBEditorWidthDirty() : !pSDEFType.isSearchMBEditorWidthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getSearchMBEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchMBEditorWidth_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMBEDITORWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchModeObj(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSearchModeObjDirty() : !pSDEFType.isSearchModeObjDirty()) {
            return null;
        }
        String string = pSDEFType.getSearchModeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchModeObj_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMODEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SFItemObj(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isSFItemObjDirty() : !pSDEFType.isSFItemObjDirty()) {
            return null;
        }
        String string = pSDEFType.getSFItemObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SFItemObj_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFITEMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isStdDataTypeDirty() : !pSDEFType.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSDEFType.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StrLength(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isStrLengthDirty() : !pSDEFType.isStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFType.getStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StrLength_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestData(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isTestDataDirty() : !pSDEFType.isTestDataDirty()) {
            return null;
        }
        String string = pSDEFType.getTestData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestData_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TSFormat(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isTSFormatDirty() : !pSDEFType.isTSFormatDirty()) {
            return null;
        }
        String string = pSDEFType.getTSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TSFormat_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TSFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIModeObj(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isUIModeObjDirty() : !pSDEFType.isUIModeObjDirty()) {
            return null;
        }
        String string = pSDEFType.getUIModeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIModeObj_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIMODEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnsignedFlag(boolean bl, PSDEFType pSDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFType.isUnsignedFlagDirty() : !pSDEFType.isUnsignedFlagDirty()) {
            return null;
        }
        Integer n = pSDEFType.getUnsignedFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnsignedFlag_Default((IEntity)pSDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNSIGNEDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFType pSDEFType, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFType, bl);
    }

    protected void onSyncIndexEntities(PSDEFType pSDEFType, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFType, bl);
    }

    public Object getDataContextValue(PSDEFType pSDEFType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFType pSDEFType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEFType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataTypes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOTNETFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DotNETFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Fields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMITEMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormItemObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLCLMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColCLMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCREMENTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncrementFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JAVAFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JAVAFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUESTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValueStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MBEDITORHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MBEditorHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MBEDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MBEditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MBEDITORWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MBEditorWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUESTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValueStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJHELPER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjHelper_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OBJHELPER2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ObjHelper2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PYFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PYFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHEDITORHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchEditorHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHEDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchEditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHEDITORWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchEditorWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMBEDITORHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchMBEditorHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMBEDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchMBEditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMBEDITORWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchMBEditorWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMODEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchModeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFITEMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFItemObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TSFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIMODEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIModeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNSIGNEDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnsignedFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DataTypes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPES", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DotNETFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOTNETFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Fields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormItemObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMITEMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColCLMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLCLMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDCOLOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridColWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IconPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IncrementFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_JAVAFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JAVAFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JSFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxValueStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUESTR", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MBEditorHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MBEditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MBEDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MBEditorWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MinStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinValueStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUESTR", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ObjHelper_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJHELPER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ObjHelper2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OBJHELPER2", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCodeListTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PYFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PYFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchEditorHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchEditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHEDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchEditorWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchMBEditorHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchMBEditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHMBEDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchMBEditorWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SearchModeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHMODEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SFItemObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFITEMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTDATA", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TSFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TSFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIModeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIMODEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnsignedFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDEFType pSDEFType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFType pSDEFType) throws Exception {
        super.onUpdateParent((IEntity)pSDEFType);
    }

    @Override
    protected void exportCurXmlModel(PSDEFType pSDEFType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFTYPE");
        if (!bl) {
            pSDEFType.setCreateDate(null);
            pSDEFType.setCreateMan(null);
            pSDEFType.setPSDEFTypeId(null);
            pSDEFType.setUpdateDate(null);
            pSDEFType.setUpdateMan(null);
            super.exportCurXmlModel(pSDEFType, xmlNode, bl);
        }
    }
}

