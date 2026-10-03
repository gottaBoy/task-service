/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.config.entity.PSDEFType;
import net.ibizsys.pscore.srv.config.entity.PSDEFTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDEFTypeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDEFTypeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDEFType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnitBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDEFTypeServiceBase
extends PSCoreSysServiceBase<PSSysDEFType> {
    private static final Log log = LogFactory.getLog(PSSysDEFTypeServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDEFTypeDEModel pSSysDEFTypeDEModel;
    private PSSysDEFTypeDAO pSSysDEFTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService";
    }

    public PSSysDEFTypeDEModel getPSSysDEFTypeDEModel() {
        if (this.pSSysDEFTypeDEModel == null) {
            try {
                this.pSSysDEFTypeDEModel = (PSSysDEFTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDEFTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDEFTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDEFTypeDEModel();
    }

    public PSSysDEFTypeDAO getPSSysDEFTypeDAO() {
        if (this.pSSysDEFTypeDAO == null) {
            try {
                this.pSSysDEFTypeDAO = (PSSysDEFTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDEFTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDEFTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDEFTypeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDEFType pSSysDEFType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEFTYPE_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysDEFType, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEFTYPE_PSDEFTYPE_PSDEFTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFType pSDEFType = (PSDEFType)iService.getDEModel().createEntity();
            pSDEFType.set("PSDEFTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFType);
            } else {
                iService.get(pSDEFType);
            }
            this.onFillParentInfo_PSDEFType(pSSysDEFType, pSDEFType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEFTYPE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysDEFType, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEFTYPE_PSSYSUNIT_PSSYSUNITID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService", (SessionFactory)this.getSessionFactory());
            PSSysUnit pSSysUnit = (PSSysUnit)iService.getDEModel().createEntity();
            pSSysUnit.set("PSSYSUNITID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUnit);
            } else {
                iService.get(pSSysUnit);
            }
            this.onFillParentInfo_PSSysUnit(pSSysDEFType, pSSysUnit);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEFTYPE_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSSysDEFType, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSSysDEFType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysDEFType pSSysDEFType, PSCodeList pSCodeList) throws Exception {
        pSSysDEFType.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysDEFType.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEFType(PSSysDEFType pSSysDEFType, PSDEFType pSDEFType) throws Exception {
        pSSysDEFType.setPSDEFTypeId(pSDEFType.getPSDEFTypeId());
        pSSysDEFType.setPSDEFTypeName(pSDEFType.getPSDEFTypeName());
    }

    protected void onFillParentInfo_PSSystem(PSSysDEFType pSSysDEFType, PSSystem pSSystem) throws Exception {
        pSSysDEFType.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDEFType.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUnit(PSSysDEFType pSSysDEFType, PSSysUnit pSSysUnit) throws Exception {
        pSSysDEFType.setPSSysUnitId(pSSysUnit.getPSSysUnitId());
        pSSysDEFType.setPSSysUnitName(pSSysUnit.getPSSysUnitName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSSysDEFType pSSysDEFType, PSSysValueRule pSSysValueRule) throws Exception {
        pSSysDEFType.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSSysDEFType.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        if (bl && pSSysDEFType.getValidFlag() == null) {
            pSSysDEFType.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysDEFType, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysDEFType, bl);
        this.onFillEntityFullInfo_PSDEFType(pSSysDEFType, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysDEFType, bl);
        this.onFillEntityFullInfo_PSSysUnit(pSSysDEFType, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSSysDEFType, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFType(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        if (pSSysDEFType.isPSDEFTypeIdDirty()) {
            if (pSSysDEFType.getPSDEFTypeId() != null) {
                if (pSSysDEFType.getPSDEFTypeId() == null || pSSysDEFType.getPSDEFTypeName() == null) {
                    PSDEFType pSDEFType = pSSysDEFType.getPSDEFType();
                    pSSysDEFType.setPSDEFTypeName(pSDEFType.getPSDEFTypeName());
                }
            } else {
                pSSysDEFType.setPSDEFTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        if (pSSysDEFType.isPSSystemIdDirty()) {
            if (pSSysDEFType.getPSSystemId() != null) {
                if (pSSysDEFType.getPSSystemId() == null || pSSysDEFType.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysDEFType.getPSSystem();
                    pSSysDEFType.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysDEFType.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysUnit(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDEFType, bl);
    }

    public ArrayList<PSSysDEFType> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysDEFType> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysDEFType> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDEFType> selectByPSDEFType(PSDEFTypeBase pSDEFTypeBase) throws Exception {
        return this.selectByPSDEFType(pSDEFTypeBase, "", -1);
    }

    public ArrayList<PSSysDEFType> selectByPSDEFType(PSDEFTypeBase pSDEFTypeBase, String string) throws Exception {
        return this.selectByPSDEFType(pSDEFTypeBase, string, -1);
    }

    public ArrayList<PSSysDEFType> selectByPSDEFType(PSDEFTypeBase pSDEFTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFTYPEID", (Object)pSDEFTypeBase.getPSDEFTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDEFType> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDEFType> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, "", -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string) throws Exception {
        return this.selectByPSSysUnit(pSSysUnitBase, string, -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSysUnit(PSSysUnitBase pSSysUnitBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNITID", (Object)pSSysUnitBase.getPSSysUnitId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUnitCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUnitCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDEFType> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSSysDEFType> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEFTYPE_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSDEFTYPE", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            PSSysDEFType pSSysDEFType2 = (PSSysDEFType)this.getDEModel().createEntity();
            pSSysDEFType2.setPSSysDEFTypeId(pSSysDEFType.getPSSysDEFTypeId());
            pSSysDEFType2.setPSCodeListId(null);
            this.update(pSSysDEFType2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDEFTypeServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysDEFTypeServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysDEFTypeServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            this.remove(pSSysDEFType);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFType(PSDEFType pSDEFType) throws Exception {
    }

    public void resetPSDEFType(PSDEFType pSDEFType) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSDEFType(pSDEFType);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            PSSysDEFType pSSysDEFType2 = (PSSysDEFType)this.getDEModel().createEntity();
            pSSysDEFType2.setPSSysDEFTypeId(pSSysDEFType.getPSSysDEFTypeId());
            pSSysDEFType2.setPSDEFTypeId(null);
            this.update(pSSysDEFType2);
        }
    }

    public void removeByPSDEFType(PSDEFType pSDEFType) throws Exception {
        final PSDEFType pSDEFType2 = pSDEFType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDEFTypeServiceBase.this.onBeforeRemoveByPSDEFType(pSDEFType2);
                PSSysDEFTypeServiceBase.this.internalRemoveByPSDEFType(pSDEFType2);
                PSSysDEFTypeServiceBase.this.onAfterRemoveByPSDEFType(pSDEFType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFType(PSDEFType pSDEFType) throws Exception {
    }

    protected void internalRemoveByPSDEFType(PSDEFType pSDEFType) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSDEFType(pSDEFType);
        this.onBeforeRemoveByPSDEFType(pSDEFType, arrayList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            this.remove(pSSysDEFType);
        }
        this.onAfterRemoveByPSDEFType(pSDEFType, arrayList);
    }

    protected void onAfterRemoveByPSDEFType(PSDEFType pSDEFType) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFType(PSDEFType pSDEFType, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFType(PSDEFType pSDEFType, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            PSSysDEFType pSSysDEFType2 = (PSSysDEFType)this.getDEModel().createEntity();
            pSSysDEFType2.setPSSysDEFTypeId(pSSysDEFType.getPSSysDEFTypeId());
            pSSysDEFType2.setPSSystemId(null);
            this.update(pSSysDEFType2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDEFTypeServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysDEFTypeServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysDEFTypeServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            this.remove(pSSysDEFType);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysUnit(pSSysUnit, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUnit);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEFTYPE_PSSYSUNIT_PSSYSUNITID", "", iDataEntityModel.getName(), "PSSYSDEFTYPE", iDataEntityModel.getDataInfo(pSSysUnit), arrayList.get(0)));
        }
    }

    public void resetPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysUnit(pSSysUnit);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            PSSysDEFType pSSysDEFType2 = (PSSysDEFType)this.getDEModel().createEntity();
            pSSysDEFType2.setPSSysDEFTypeId(pSSysDEFType.getPSSysDEFTypeId());
            pSSysDEFType2.setPSSysUnitId(null);
            this.update(pSSysDEFType2);
        }
    }

    public void removeByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        final PSSysUnit pSSysUnit2 = pSSysUnit;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDEFTypeServiceBase.this.onBeforeRemoveByPSSysUnit(pSSysUnit2);
                PSSysDEFTypeServiceBase.this.internalRemoveByPSSysUnit(pSSysUnit2);
                PSSysDEFTypeServiceBase.this.onAfterRemoveByPSSysUnit(pSSysUnit2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void internalRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysUnit(pSSysUnit);
        this.onBeforeRemoveByPSSysUnit(pSSysUnit, arrayList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            this.remove(pSSysDEFType);
        }
        this.onAfterRemoveByPSSysUnit(pSSysUnit, arrayList);
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUnit(PSSysUnit pSSysUnit, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEFTYPE_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSSYSDEFTYPE", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            PSSysDEFType pSSysDEFType2 = (PSSysDEFType)this.getDEModel().createEntity();
            pSSysDEFType2.setPSSysDEFTypeId(pSSysDEFType.getPSSysDEFTypeId());
            pSSysDEFType2.setPSSysValueRuleId(null);
            this.update(pSSysDEFType2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDEFTypeServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSSysDEFTypeServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSSysDEFTypeServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDEFType> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSSysDEFType pSSysDEFType : arrayList) {
            this.remove(pSSysDEFType);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSysDEFType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDEFType pSSysDEFType) throws Exception {
        super.onBeforeRemove(pSSysDEFType);
    }

    protected void replaceParentInfo(PSSysDEFType pSSysDEFType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDEFType, cloneSession);
        if (pSSysDEFType.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysDEFType.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysDEFType, (PSCodeList)iEntity);
        }
        if (pSSysDEFType.getPSDEFTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFTYPE", (Object)pSSysDEFType.getPSDEFTypeId())) != null) {
            this.onFillParentInfo_PSDEFType(pSSysDEFType, (PSDEFType)iEntity);
        }
        if (pSSysDEFType.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDEFType.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysDEFType, (PSSystem)iEntity);
        }
        if (pSSysDEFType.getPSSysUnitId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIT", (Object)pSSysDEFType.getPSSysUnitId())) != null) {
            this.onFillParentInfo_PSSysUnit(pSSysDEFType, (PSSysUnit)iEntity);
        }
        if (pSSysDEFType.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSSysDEFType.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSSysDEFType, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDEFType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EditorHeight(bl, pSSysDEFType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorWidth(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Fields(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColAlign(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColCLMode(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColWidth(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JSFormat(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorHeight(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorType(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MBEditorWidth(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFTypeId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFTypeName(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDEFTypeId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDEFTypeName(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUnitId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PYFormat(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorHeight(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorType(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchEditorWidth(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorHeight(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorType(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchMBEditorWidth(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StrLength(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TSFormat(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSSysDEFType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDEFType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EditorHeight(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isEditorHeightDirty() : !pSSysDEFType.isEditorHeightDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditorHeight_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isEditorTypeDirty() : !pSSysDEFType.isEditorTypeDirty()) {
            return null;
        }
        String string = pSSysDEFType.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorWidth(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isEditorWidthDirty() : !pSSysDEFType.isEditorWidthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EditorWidth_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Fields(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isFieldsDirty() : !pSSysDEFType.isFieldsDirty()) {
            return null;
        }
        String string = pSSysDEFType.getFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Fields_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridColAlign(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isGridColAlignDirty() : !pSSysDEFType.isGridColAlignDirty()) {
            return null;
        }
        String string = pSSysDEFType.getGridColAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColAlign_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridColCLMode(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isGridColCLModeDirty() : !pSSysDEFType.isGridColCLModeDirty()) {
            return null;
        }
        String string = pSSysDEFType.getGridColCLMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridColCLMode_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridColWidth(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isGridColWidthDirty() : !pSSysDEFType.isGridColWidthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getGridColWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridColWidth_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_JSFormat(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isJSFormatDirty() : !pSSysDEFType.isJSFormatDirty()) {
            return null;
        }
        String string = pSSysDEFType.getJSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JSFormat_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMaxValueDirty() : !pSSysDEFType.isMaxValueDirty()) {
            return null;
        }
        String string = pSSysDEFType.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MBEditorHeight(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMBEditorHeightDirty() : !pSSysDEFType.isMBEditorHeightDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getMBEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MBEditorHeight_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MBEditorType(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMBEditorTypeDirty() : !pSSysDEFType.isMBEditorTypeDirty()) {
            return null;
        }
        String string = pSSysDEFType.getMBEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MBEditorType_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MBEditorWidth(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMBEditorWidthDirty() : !pSSysDEFType.isMBEditorWidthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getMBEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MBEditorWidth_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMemoDirty() : !pSSysDEFType.isMemoDirty()) {
            return null;
        }
        String string = pSSysDEFType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMinStrLengthDirty() : !pSSysDEFType.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isMinValueDirty() : !pSSysDEFType.isMinValueDirty()) {
            return null;
        }
        String string = pSSysDEFType.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isOrderValueDirty() : !pSSysDEFType.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPrecision2Dirty() : !pSSysDEFType.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSCodeListIdDirty() : !pSSysDEFType.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFTypeId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSDEFTypeIdDirty() && !bl2 : !pSSysDEFType.isPSDEFTypeIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSDEFTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFTypeId_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFTypeName(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSDEFTypeNameDirty() && !bl2 : !pSSysDEFType.isPSDEFTypeNameDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSDEFTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFTypeName_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDEFTypeId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSysDEFTypeIdDirty() && !bl2 : !pSSysDEFType.isPSSysDEFTypeIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSysDEFTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEFTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDEFTypeId_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEFTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDEFTypeName(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSysDEFTypeNameDirty() && !bl2 : !pSSysDEFType.isPSSysDEFTypeNameDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSysDEFTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEFTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDEFTypeName_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEFTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysDEFTypeDEModel(), "PSSYSDEFTYPENAME", string3, pSSysDEFType, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDEFTYPENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSystemIdDirty() && !bl2 : !pSSysDEFType.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSystemNameDirty() && !bl2 : !pSSysDEFType.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUnitId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSysUnitIdDirty() : !pSSysDEFType.isPSSysUnitIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSysUnitId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUnitId_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNITID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPSSysValueRuleIdDirty() : !pSSysDEFType.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PYFormat(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isPYFormatDirty() : !pSSysDEFType.isPYFormatDirty()) {
            return null;
        }
        String string = pSSysDEFType.getPYFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PYFormat_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchEditorHeight(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchEditorHeightDirty() : !pSSysDEFType.isSearchEditorHeightDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getSearchEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchEditorHeight_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchEditorType(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchEditorTypeDirty() : !pSSysDEFType.isSearchEditorTypeDirty()) {
            return null;
        }
        String string = pSSysDEFType.getSearchEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchEditorType_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchEditorWidth(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchEditorWidthDirty() : !pSSysDEFType.isSearchEditorWidthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getSearchEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchEditorWidth_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchMBEditorHeight(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchMBEditorHeightDirty() : !pSSysDEFType.isSearchMBEditorHeightDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getSearchMBEditorHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchMBEditorHeight_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchMBEditorType(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchMBEditorTypeDirty() : !pSSysDEFType.isSearchMBEditorTypeDirty()) {
            return null;
        }
        String string = pSSysDEFType.getSearchMBEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchMBEditorType_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_SearchMBEditorWidth(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isSearchMBEditorWidthDirty() : !pSSysDEFType.isSearchMBEditorWidthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getSearchMBEditorWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SearchMBEditorWidth_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isStdDataTypeDirty() : !pSSysDEFType.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_StrLength(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isStrLengthDirty() : !pSSysDEFType.isStrLengthDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StrLength_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_TSFormat(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isTSFormatDirty() : !pSSysDEFType.isTSFormatDirty()) {
            return null;
        }
        String string = pSSysDEFType.getTSFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TSFormat_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isValidFlagDirty() && !bl2 : !pSSysDEFType.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysDEFType.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysDEFType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSSysDEFType pSSysDEFType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDEFType.isValueFormatDirty() : !pSSysDEFType.isValueFormatDirty()) {
            return null;
        }
        String string = pSSysDEFType.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSSysDEFType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDEFType, bl);
    }

    protected void onSyncIndexEntities(PSSysDEFType pSSysDEFType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDEFType, bl);
    }

    public Object getDataContextValue(PSSysDEFType pSSysDEFType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDEFType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDEFType pSSysDEFType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDEFType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GRIDCOLALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLCLMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColCLMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JSFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEFTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDEFTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEFTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDEFTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNITNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUnitName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TSFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TSFormat_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_GridColWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDEFTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEFTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDEFTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEFTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUnitId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUnitName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNITNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDEFType pSSysDEFType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDEFType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDEFType pSSysDEFType) throws Exception {
        super.onUpdateParent(pSSysDEFType);
    }

    @Override
    protected void exportCurXmlModel(PSSysDEFType pSSysDEFType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEFTYPE");
        if (!bl) {
            pSSysDEFType.setCreateDate(null);
            pSSysDEFType.setCreateMan(null);
            pSSysDEFType.setPSSysDEFTypeId(null);
            pSSysDEFType.setUpdateDate(null);
            pSSysDEFType.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDEFType, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDEFType pSSysDEFType, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDEFType, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDEFTYPE_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysDEFType pSSysDEFType) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDEFType.getPSSysDEFTypeName())) {
            return pSSysDEFType.getPSSysDEFTypeName();
        }
        return super.getModelV2Tag(pSSysDEFType);
    }

    @Override
    public boolean setModelV2Tag(PSSysDEFType pSSysDEFType, String string) {
        pSSysDEFType.setPSSysDEFTypeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDEFTYPENAME", "");
        map.put("PSSYSDEFTYPENAME", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDEFType pSSysDEFType, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDEFType.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDEFType, true);
        pSSysDEFType.set("PSSYSDEFTYPENAME", string);
        if (this.select(pSSysDEFType, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDEFType, true);
        return super.getModelV2Entity(pSSysDEFType, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDEFType pSSysDEFType, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysDEFType, objectNode, string, string2, n);
    }
}

