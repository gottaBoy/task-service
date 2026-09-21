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
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADEFieldDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEFieldDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysSADEFieldServiceBase
extends PSCoreSysServiceBase<PSSubSysSADEField> {
    private static final Log log = LogFactory.getLog(PSSubSysSADEFieldServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSubSysSADEFieldDEModel pSSubSysSADEFieldDEModel;
    private PSSubSysSADEFieldDAO pSSubSysSADEFieldDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEFieldService";
    }

    public PSSubSysSADEFieldDEModel getPSSubSysSADEFieldDEModel() {
        if (this.pSSubSysSADEFieldDEModel == null) {
            try {
                this.pSSubSysSADEFieldDEModel = (PSSubSysSADEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADEFieldDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSubSysSADEFieldDEModel();
    }

    public PSSubSysSADEFieldDAO getPSSubSysSADEFieldDAO() {
        if (this.pSSubSysSADEFieldDAO == null) {
            try {
                this.pSSubSysSADEFieldDAO = (PSSubSysSADEFieldDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADEFieldDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADEFieldDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSubSysSADEFieldDAO();
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

    protected void onFillParentInfo(PSSubSysSADEField pSSubSysSADEField, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADEFIELD_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSubSysSADEField, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADEFIELD_PSDEFDATATYPE_PSDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory());
            PSDEFDataType pSDEFDataType = (PSDEFDataType)iService.getDEModel().createEntity();
            pSDEFDataType.set("PSDEFDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFDataType);
            } else {
                iService.get((IEntity)pSDEFDataType);
            }
            this.onFillParentInfo_PSDataType(pSSubSysSADEField, pSDEFDataType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADEFIELD_PSSUBSYSSADE_PSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_PSSubSysSADE(pSSubSysSADEField, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADEFIELD_PSSUBSYSSADE_REFPSSUBSYSSADEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADEService", (SessionFactory)this.getSessionFactory());
            PSSubSysSADE pSSubSysSADE = (PSSubSysSADE)iService.getDEModel().createEntity();
            pSSubSysSADE.set("PSSUBSYSSADEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSubSysSADE);
            } else {
                iService.get((IEntity)pSSubSysSADE);
            }
            this.onFillParentInfo_RefPSSubSysSADE(pSSubSysSADEField, pSSubSysSADE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSUBSYSSADEFIELD_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysValueRule);
            } else {
                iService.get((IEntity)pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSSubSysSADEField, pSSysValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSSubSysSADEField, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSubSysSADEField pSSubSysSADEField, PSCodeList pSCodeList) throws Exception {
        pSSubSysSADEField.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSubSysSADEField.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDataType(PSSubSysSADEField pSSubSysSADEField, PSDEFDataType pSDEFDataType) throws Exception {
        pSSubSysSADEField.setPSDataTypeId(pSDEFDataType.getPSDEFDataTypeId());
        pSSubSysSADEField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
    }

    protected void onFillParentInfo_PSSubSysSADE(PSSubSysSADEField pSSubSysSADEField, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADEField.setPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADEField.setPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
        pSSubSysSADEField.setPSSubSysServiceAPIId(pSSubSysSADE.getPSSubSysServiceAPIId());
    }

    protected void onFillParentInfo_RefPSSubSysSADE(PSSubSysSADEField pSSubSysSADEField, PSSubSysSADE pSSubSysSADE) throws Exception {
        pSSubSysSADEField.setRefPSSubSysSADEId(pSSubSysSADE.getPSSubSysSADEId());
        pSSubSysSADEField.setRefPSSubSysSADEName(pSSubSysSADE.getPSSubSysSADEName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSSubSysSADEField pSSubSysSADEField, PSSysValueRule pSSysValueRule) throws Exception {
        pSSubSysSADEField.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSSubSysSADEField.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        if (bl) {
            if (pSSubSysSADEField.getAllowEmpty() == null) {
                pSSubSysSADEField.setAllowEmpty((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSubSysSADEField.getMajorField() == null) {
                pSSubSysSADEField.setMajorField((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSubSysSADEField.getPKey() == null) {
                pSSubSysSADEField.setPKey((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSubSysSADEField.getValidFlag() == null) {
                pSSubSysSADEField.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSubSysSADEField, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSubSysSADEField, bl);
        this.onFillEntityFullInfo_PSDataType(pSSubSysSADEField, bl);
        this.onFillEntityFullInfo_PSSubSysSADE(pSSubSysSADEField, bl);
        this.onFillEntityFullInfo_RefPSSubSysSADE(pSSubSysSADEField, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSSubSysSADEField, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDataType(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        if (pSSubSysSADEField.isPSDataTypeIdDirty()) {
            if (pSSubSysSADEField.getPSDataTypeId() != null) {
                if (pSSubSysSADEField.getPSDataTypeId() == null || pSSubSysSADEField.getPSDataTypeName() == null) {
                    PSDEFDataType pSDEFDataType = pSSubSysSADEField.getPSDataType();
                    pSSubSysSADEField.setPSDataTypeName(pSDEFDataType.getPSDEFDataTypeName());
                }
            } else {
                pSSubSysSADEField.setPSDataTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSubSysSADE(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSubSysSADE(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSubSysSADEField, bl);
    }

    public ArrayList<PSSubSysSADEField> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSubSysSADEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, "", -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string) throws Exception {
        return this.selectByPSDataType(pSDEFDataTypeBase, string, -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSDataType(PSDEFDataTypeBase pSDEFDataTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDATATYPEID", (Object)pSDEFDataTypeBase.getPSDEFDataTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDataTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADEField> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADEField> selectByRefPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase) throws Exception {
        return this.selectByRefPSSubSysSADE(pSSubSysSADEBase, "", -1);
    }

    public ArrayList<PSSubSysSADEField> selectByRefPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string) throws Exception {
        return this.selectByRefPSSubSysSADE(pSSubSysSADEBase, string, -1);
    }

    public ArrayList<PSSubSysSADEField> selectByRefPSSubSysSADE(PSSubSysSADEBase pSSubSysSADEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSUBSYSSADEID", (Object)pSSubSysSADEBase.getPSSubSysSADEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSubSysSADECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSubSysSADECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSubSysSADEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSSubSysSADEField> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
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
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADEFIELD_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSUBSYSSADEFIELD", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            PSSubSysSADEField pSSubSysSADEField2 = (PSSubSysSADEField)this.getDEModel().createEntity();
            pSSubSysSADEField2.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSSubSysSADEField2.setPSCodeListId(null);
            this.update(pSSubSysSADEField2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADEFieldServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSubSysSADEFieldServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSubSysSADEFieldServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            this.remove((IEntity)pSSubSysSADEField);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    public void testRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSDataType(pSDEFDataType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFDATATYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFDataType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADEFIELD_PSDEFDATATYPE_PSDATATYPEID", "", iDataEntityModel.getName(), "PSSUBSYSSADEFIELD", iDataEntityModel.getDataInfo((IEntity)pSDEFDataType), arrayList.get(0)));
        }
    }

    public void resetPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSDataType(pSDEFDataType);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            PSSubSysSADEField pSSubSysSADEField2 = (PSSubSysSADEField)this.getDEModel().createEntity();
            pSSubSysSADEField2.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSSubSysSADEField2.setPSDataTypeId(null);
            this.update(pSSubSysSADEField2);
        }
    }

    public void removeByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        final PSDEFDataType pSDEFDataType2 = pSDEFDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADEFieldServiceBase.this.onBeforeRemoveByPSDataType(pSDEFDataType2);
                PSSubSysSADEFieldServiceBase.this.internalRemoveByPSDataType(pSDEFDataType2);
                PSSubSysSADEFieldServiceBase.this.onAfterRemoveByPSDataType(pSDEFDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void internalRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSDataType(pSDEFDataType);
        this.onBeforeRemoveByPSDataType(pSDEFDataType, arrayList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            this.remove((IEntity)pSSubSysSADEField);
        }
        this.onAfterRemoveByPSDataType(pSDEFDataType, arrayList);
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDataType(PSDEFDataType pSDEFDataType, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADEFIELD_PSSUBSYSSADE_PSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            PSSubSysSADEField pSSubSysSADEField2 = (PSSubSysSADEField)this.getDEModel().createEntity();
            pSSubSysSADEField2.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSSubSysSADEField2.setPSSubSysSADEId(null);
            this.update(pSSubSysSADEField2);
        }
    }

    public void removeByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADEFieldServiceBase.this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADEFieldServiceBase.this.internalRemoveByPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADEFieldServiceBase.this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            this.remove((IEntity)pSSubSysSADEField);
        }
        this.onAfterRemoveByPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByRefPSSubSysSADE(pSSubSysSADE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYSSADE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSubSysSADE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADEFIELD_PSSUBSYSSADE_REFPSSUBSYSSADEID", "", iDataEntityModel.getName(), "PSSUBSYSSADEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSubSysSADE), arrayList.get(0)));
        }
    }

    public void resetRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByRefPSSubSysSADE(pSSubSysSADE);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            PSSubSysSADEField pSSubSysSADEField2 = (PSSubSysSADEField)this.getDEModel().createEntity();
            pSSubSysSADEField2.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSSubSysSADEField2.setRefPSSubSysSADEId(null);
            this.update(pSSubSysSADEField2);
        }
    }

    public void removeByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        final PSSubSysSADE pSSubSysSADE2 = pSSubSysSADE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADEFieldServiceBase.this.onBeforeRemoveByRefPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADEFieldServiceBase.this.internalRemoveByRefPSSubSysSADE(pSSubSysSADE2);
                PSSubSysSADEFieldServiceBase.this.onAfterRemoveByRefPSSubSysSADE(pSSubSysSADE2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void internalRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByRefPSSubSysSADE(pSSubSysSADE);
        this.onBeforeRemoveByRefPSSubSysSADE(pSSubSysSADE, arrayList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            this.remove((IEntity)pSSubSysSADEField);
        }
        this.onAfterRemoveByRefPSSubSysSADE(pSSubSysSADE, arrayList);
    }

    protected void onAfterRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSubSysSADE(PSSubSysSADE pSSubSysSADE, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSUBSYSSADEFIELD_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSSUBSYSSADEFIELD", iDataEntityModel.getDataInfo((IEntity)pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            PSSubSysSADEField pSSubSysSADEField2 = (PSSubSysSADEField)this.getDEModel().createEntity();
            pSSubSysSADEField2.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSSubSysSADEField2.setPSSysValueRuleId(null);
            this.update(pSSubSysSADEField2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSubSysSADEFieldServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSSubSysSADEFieldServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSSubSysSADEFieldServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSubSysSADEField> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSSubSysSADEField pSSubSysSADEField : arrayList) {
            this.remove((IEntity)pSSubSysSADEField);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSubSysSADEField> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        pSDEFieldService.testRemoveByPSSubSysSADEField(pSSubSysSADEField);
        super.onBeforeRemove(pSSubSysSADEField);
    }

    protected void replaceParentInfo(PSSubSysSADEField pSSubSysSADEField, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSubSysSADEField, cloneSession);
        if (pSSubSysSADEField.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSubSysSADEField.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSubSysSADEField, (PSCodeList)iEntity);
        }
        if (pSSubSysSADEField.getPSDataTypeId() != null && (iEntity = cloneSession.getEntity("PSDEFDATATYPE", (Object)pSSubSysSADEField.getPSDataTypeId())) != null) {
            this.onFillParentInfo_PSDataType(pSSubSysSADEField, (PSDEFDataType)iEntity);
        }
        if (pSSubSysSADEField.getPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADEField.getPSSubSysSADEId())) != null) {
            this.onFillParentInfo_PSSubSysSADE(pSSubSysSADEField, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADEField.getRefPSSubSysSADEId() != null && (iEntity = cloneSession.getEntity("PSSUBSYSSADE", (Object)pSSubSysSADEField.getRefPSSubSysSADEId())) != null) {
            this.onFillParentInfo_RefPSSubSysSADE(pSSubSysSADEField, (PSSubSysSADE)iEntity);
        }
        if (pSSubSysSADEField.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSSubSysSADEField.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSSubSysSADEField, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSubSysSADEField, bl);
    }

    protected void onCheckEntity(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSSubSysSADEField, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArrayFlag(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExampleValue(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldTag2(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldType(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorField(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKey(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDataTypeName(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEFieldId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEFieldName(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubSysSADEId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSubSysSADEId(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSubSysSADEField, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSubSysSADEField, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isAllowEmptyDirty() : !pSSubSysSADEField.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isArrayFlagDirty() : !pSSubSysSADEField.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ARRAYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isCodeNameDirty() && !bl2 : !pSSubSysSADEField.isCodeNameDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADEFieldDEModel(), "CODENAME", string3, pSSubSysSADEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isCodeName2Dirty() : !pSSubSysSADEField.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isDefaultValueDirty() : !pSSubSysSADEField.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExampleValue(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isExampleValueDirty() : !pSSubSysSADEField.isExampleValueDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getExampleValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExampleValue_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLEVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isFieldTagDirty() : !pSSubSysSADEField.isFieldTagDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getFieldTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldTag2(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isFieldTag2Dirty() : !pSSubSysSADEField.isFieldTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getFieldTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldTag2_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldType(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isFieldTypeDirty() : !pSSubSysSADEField.isFieldTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getFieldType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldType_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isLengthDirty() : !pSSubSysSADEField.isLengthDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isLogicNameDirty() : !pSSubSysSADEField.isLogicNameDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorField(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isMajorFieldDirty() && !bl2 : !pSSubSysSADEField.isMajorFieldDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getMajorField();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_MajorField_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFIELD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSUBSYSSADEID";
                String string2 = this.checkFieldDupRule(this.getPSSubSysSADEFieldDEModel(), "MAJORFIELD", string, pSSubSysSADEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MAJORFIELD");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isMaxValueDirty() : !pSSubSysSADEField.isMaxValueDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isMemoDirty() : !pSSubSysSADEField.isMemoDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isMinStrLengthDirty() : !pSSubSysSADEField.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isMinValueDirty() : !pSSubSysSADEField.isMinValueDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isOrderValueDirty() : !pSSubSysSADEField.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PKey(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPKeyDirty() && !bl2 : !pSSubSysSADEField.isPKeyDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getPKey();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_PKey_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSUBSYSSADEID";
                String string2 = this.checkFieldDupRule(this.getPSSubSysSADEFieldDEModel(), "PKEY", string, pSSubSysSADEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PKEY");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPrecision2Dirty() : !pSSubSysSADEField.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPredefinedTypeDirty() : !pSSubSysSADEField.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
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
                string3 = "PSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADEFieldDEModel(), "PREDEFINEDTYPE", string3, pSSubSysSADEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PREDEFINEDTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSCodeListIdDirty() : !pSSubSysSADEField.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDataTypeId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSDataTypeIdDirty() : !pSSubSysSADEField.isPSDataTypeIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDataTypeName(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSDataTypeNameDirty() : !pSSubSysSADEField.isPSDataTypeNameDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSDataTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDataTypeName_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDATATYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADEFieldId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSSubSysSADEFieldIdDirty() && !bl2 : !pSSubSysSADEField.isPSSubSysSADEFieldIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSSubSysSADEFieldId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEFIELDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEFieldId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEFIELDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADEFieldName(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSSubSysSADEFieldNameDirty() && !bl2 : !pSSubSysSADEField.isPSSubSysSADEFieldNameDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSSubSysSADEFieldName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEFIELDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEFieldName_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSUBSYSSADEID";
                String string4 = this.checkFieldDupRule(this.getPSSubSysSADEFieldDEModel(), "PSSUBSYSSADEFIELDNAME", string3, pSSubSysSADEField, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSUBSYSSADEFIELDNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubSysSADEId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSSubSysSADEIdDirty() && !bl2 : !pSSubSysSADEField.isPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSSubSysSADEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubSysSADEId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isPSSysValueRuleIdDirty() : !pSSubSysSADEField.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSSubSysSADEId(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isRefPSSubSysSADEIdDirty() : !pSSubSysSADEField.isRefPSSubSysSADEIdDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getRefPSSubSysSADEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSubSysSADEId_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSUBSYSSADEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isStdDataTypeDirty() : !pSSubSysSADEField.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isUserCatDirty() : !pSSubSysSADEField.isUserCatDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isUserTagDirty() : !pSSubSysSADEField.isUserTagDirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isUserTag2Dirty() : !pSSubSysSADEField.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isUserTag3Dirty() : !pSSubSysSADEField.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isUserTag4Dirty() : !pSSubSysSADEField.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSubSysSADEField.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSubSysSADEField, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSubSysSADEField pSSubSysSADEField, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSubSysSADEField.isValidFlagDirty() : !pSSubSysSADEField.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSubSysSADEField.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSubSysSADEField, bl2, bl3);
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

    protected void onSyncEntity(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSubSysSADEField, bl);
    }

    protected void onSyncIndexEntities(PSSubSysSADEField pSSubSysSADEField, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSubSysSADEField, bl);
    }

    public Object getDataContextValue(PSSubSysSADEField pSSubSysSADEField, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSubSysSADEField, string, iDataContextParam)) != null) {
            return object;
        }
        PSSubSysSADE pSSubSysSADE = pSSubSysSADEField.getPSSubSysSADE();
        if (pSSubSysSADE != null && pSSubSysSADE.contains(string)) {
            return pSSubSysSADE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSubSysSADEField pSSubSysSADEField, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSubSysSADEField, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMPLEVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExampleValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFIELD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorField_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEFIELDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEFieldId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSUBSYSSADEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSubSysSADEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSUBSYSSADENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSubSysSADEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExampleValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMPLEVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorField_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEFieldId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEFIELDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEFIELDNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("PSSUBSYSSADEFIELDNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_RefPSSubSysSADEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSUBSYSSADEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSubSysSADEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSUBSYSSADENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSubSysSADEField pSSubSysSADEField) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSubSysSADEField)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSubSysSADEField pSSubSysSADEField) throws Exception {
        super.onUpdateParent((IEntity)pSSubSysSADEField);
    }

    @Override
    protected void exportCurXmlModel(PSSubSysSADEField pSSubSysSADEField, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSUBSYSSADEFIELD");
        if (!bl) {
            pSSubSysSADEField.setCreateDate(null);
            pSSubSysSADEField.setCreateMan(null);
            pSSubSysSADEField.setPSSubSysSADEFieldId(null);
            pSSubSysSADEField.setUpdateDate(null);
            pSSubSysSADEField.setUpdateMan(null);
            super.exportCurXmlModel(pSSubSysSADEField, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSubSysSADEField pSSubSysSADEField, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSubSysSADEField, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSUBSYSSADE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSUBSYSSADEFIELD_PSSUBSYSSADE_PSSUBSYSSADEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSUBSYSSADENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSUBSYSSADE", (boolean)true) == 0) {
            iEntity.set("PSSUBSYSSADEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSUBSYSSADEID"};
    }

    @Override
    public String getModelV2Tag(PSSubSysSADEField pSSubSysSADEField) {
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADEField.getPSSubSysSADEFieldName())) {
            return pSSubSysSADEField.getPSSubSysSADEFieldName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSubSysSADEField.getCodeName())) {
            return pSSubSysSADEField.getCodeName();
        }
        return super.getModelV2Tag(pSSubSysSADEField);
    }

    @Override
    public boolean setModelV2Tag(PSSubSysSADEField pSSubSysSADEField, String string) {
        pSSubSysSADEField.setPSSubSysSADEFieldName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSUBSYSSADEFIELDNAME", "");
        map.put("CODENAME", "");
        map.put("PSSUBSYSSADEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSubSysSADEField pSSubSysSADEField, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSubSysSADEField.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSubSysSADEField, true);
        pSSubSysSADEField.set("PSSUBSYSSADEFIELDNAME", string);
        if (this.select(pSSubSysSADEField, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSubSysSADEField, true);
        return super.getModelV2Entity(pSSubSysSADEField, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSubSysSADEField pSSubSysSADEField, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSubSysSADEField, objectNode, string, string2, n);
    }
}

