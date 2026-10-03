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
import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDynaModelAttrDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDynaModelAttrDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelAttr;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDynaModelAttrServiceBase
extends PSCoreSysServiceBase<PSSysDynaModelAttr> {
    private static final Log log = LogFactory.getLog(PSSysDynaModelAttrServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDynaModelAttrDEModel pSSysDynaModelAttrDEModel;
    private PSSysDynaModelAttrDAO pSSysDynaModelAttrDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService";
    }

    public PSSysDynaModelAttrDEModel getPSSysDynaModelAttrDEModel() {
        if (this.pSSysDynaModelAttrDEModel == null) {
            try {
                this.pSSysDynaModelAttrDEModel = (PSSysDynaModelAttrDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDynaModelAttrDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDynaModelAttrDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDynaModelAttrDEModel();
    }

    public PSSysDynaModelAttrDAO getPSSysDynaModelAttrDAO() {
        if (this.pSSysDynaModelAttrDAO == null) {
            try {
                this.pSSysDynaModelAttrDAO = (PSSysDynaModelAttrDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDynaModelAttrDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDynaModelAttrDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDynaModelAttrDAO();
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

    protected void onFillParentInfo(PSSysDynaModelAttr pSSysDynaModelAttr, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysDynaModelAttr, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSSysDynaModelAttr, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSDEFGROUP_REFPSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_RefPSDEFGroup(pSSysDynaModelAttr, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysDynaModelAttr, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_RefPSSysDynaModel(pSSysDynaModelAttr, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDYNAMODELATTR_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSSysDynaModelAttr, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSSysDynaModelAttr, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", string2);
            return this.onSyncDER1NData_PSSysDynaModel(pSSysDynaModel, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysDynaModelAttr pSSysDynaModelAttr, PSCodeList pSCodeList) throws Exception {
        pSSysDynaModelAttr.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysDynaModelAttr.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSSysDynaModelAttr pSSysDynaModelAttr, PSDataEntity pSDataEntity) throws Exception {
        pSSysDynaModelAttr.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysDynaModelAttr.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEFGroup(PSSysDynaModelAttr pSSysDynaModelAttr, PSDEFGroup pSDEFGroup) throws Exception {
        pSSysDynaModelAttr.setRefPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSSysDynaModelAttr.setRefPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysDynaModelAttr pSSysDynaModelAttr, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysDynaModelAttr.setDynaModelUsage(pSSysDynaModel.getDynaModelUsage());
        pSSysDynaModelAttr.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysDynaModelAttr.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected String onSyncDER1NData_PSSysDynaModel(PSSysDynaModel pSSysDynaModel, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSSysDynaModel(pSSysDynaModel);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
            for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSSysDynaModelAttr, (String)"PSSYSDYNAMODELATTRID", (String)""))) continue;
                this.remove(pSSysDynaModelAttr);
            }
        }
        return null;
    }

    protected void onFillParentInfo_RefPSSysDynaModel(PSSysDynaModelAttr pSSysDynaModelAttr, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysDynaModelAttr.setRefPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysDynaModelAttr.setRefPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSSysDynaModelAttr pSSysDynaModelAttr, PSSysValueRule pSSysValueRule) throws Exception {
        pSSysDynaModelAttr.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSSysDynaModelAttr.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        if (bl && pSSysDynaModelAttr.getValidFlag() == null) {
            pSSysDynaModelAttr.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_RefPSDE(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_RefPSDEFGroup(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_RefPSSysDynaModel(pSSysDynaModelAttr, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSSysDynaModelAttr, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        if (pSSysDynaModelAttr.isRefPSDEIdDirty()) {
            if (pSSysDynaModelAttr.getRefPSDEId() != null) {
                if (pSSysDynaModelAttr.getRefPSDEId() == null || pSSysDynaModelAttr.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysDynaModelAttr.getRefPSDE();
                    pSSysDynaModelAttr.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysDynaModelAttr.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEFGroup(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        if (pSSysDynaModelAttr.isPSSysDynaModelIdDirty()) {
            if (pSSysDynaModelAttr.getPSSysDynaModelId() != null) {
                if (pSSysDynaModelAttr.getPSSysDynaModelId() == null || pSSysDynaModelAttr.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSSysDynaModelAttr.getPSSysDynaModel();
                    pSSysDynaModelAttr.setDynaModelUsage(pSSysDynaModel.getDynaModelUsage());
                    pSSysDynaModelAttr.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSSysDynaModelAttr.setDynaModelUsage(null);
                pSSysDynaModelAttr.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSSysDynaModel(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDynaModelAttr, bl);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByRefPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByRefPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByRefPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByRefPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSSysDynaModelAttr> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
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
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODELATTR_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSDYNAMODELATTR", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setPSCodeListId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODELATTR_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSSYSDYNAMODELATTR", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setRefPSDEId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODELATTR_PSDEFGROUP_REFPSDEFGROUPID", "", iDataEntityModel.getName(), "PSSYSDYNAMODELATTR", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDEFGroup(pSDEFGroup);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setRefPSDEFGroupId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByRefPSDEFGroup(pSDEFGroup2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByRefPSDEFGroup(pSDEFGroup2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByRefPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByRefPSDEFGroup(pSDEFGroup, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByRefPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setPSSysDynaModelId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_REFPSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSDYNAMODELATTR", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setRefPSSysDynaModelId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByRefPSSysDynaModel(pSSysDynaModel2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByRefPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByRefPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDYNAMODELATTR_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSSYSDYNAMODELATTR", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            PSSysDynaModelAttr pSSysDynaModelAttr2 = (PSSysDynaModelAttr)this.getDEModel().createEntity();
            pSSysDynaModelAttr2.setPSSysDynaModelAttrId(pSSysDynaModelAttr.getPSSysDynaModelAttrId());
            pSSysDynaModelAttr2.setPSSysValueRuleId(null);
            this.update(pSSysDynaModelAttr2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDynaModelAttrServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSSysDynaModelAttrServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSSysDynaModelAttrServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSSysDynaModelAttr> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSSysDynaModelAttr pSSysDynaModelAttr : arrayList) {
            this.remove(pSSysDynaModelAttr);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSSysDynaModelAttr> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDynaModelAttr pSSysDynaModelAttr) throws Exception {
        super.onBeforeRemove(pSSysDynaModelAttr);
    }

    protected void replaceParentInfo(PSSysDynaModelAttr pSSysDynaModelAttr, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDynaModelAttr, cloneSession);
        if (pSSysDynaModelAttr.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysDynaModelAttr.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysDynaModelAttr, (PSCodeList)iEntity);
        }
        if (pSSysDynaModelAttr.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysDynaModelAttr.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSSysDynaModelAttr, (PSDataEntity)iEntity);
        }
        if (pSSysDynaModelAttr.getRefPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSSysDynaModelAttr.getRefPSDEFGroupId())) != null) {
            this.onFillParentInfo_RefPSDEFGroup(pSSysDynaModelAttr, (PSDEFGroup)iEntity);
        }
        if (pSSysDynaModelAttr.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysDynaModelAttr.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysDynaModelAttr, (PSSysDynaModel)iEntity);
        }
        if (pSSysDynaModelAttr.getRefPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysDynaModelAttr.getRefPSSysDynaModelId())) != null) {
            this.onFillParentInfo_RefPSSysDynaModel(pSSysDynaModelAttr, (PSSysDynaModel)iEntity);
        }
        if (pSSysDynaModelAttr.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSSysDynaModelAttr.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSSysDynaModelAttr, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDynaModelAttr, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSSysDynaModelAttr, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ArrayFlag(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrTag(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrTag2(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue10(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue11(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue12(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue13(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue14(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue15(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue16(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue2(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue20(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue21(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue22(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue23(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue24(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue25(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue26(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue27(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue28(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue29(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue3(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue30(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue4(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue5(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue6(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue7(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue8(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrValue9(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JsonFormat(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelAttrId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelAttrName(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEFGroupId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysDynaModelId(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueType(bl, pSSysDynaModelAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDynaModelAttr, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAllowEmptyDirty() : !pSSysDynaModelAttr.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_ArrayFlag(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isArrayFlagDirty() : !pSSysDynaModelAttr.isArrayFlagDirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getArrayFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ArrayFlag_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_AttrTag(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrTagDirty() : !pSSysDynaModelAttr.isAttrTagDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrTag_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrTag2(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrTag2Dirty() : !pSSysDynaModelAttr.isAttrTag2Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrTag2_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValueDirty() : !pSSysDynaModelAttr.isAttrValueDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue10(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue10Dirty() : !pSSysDynaModelAttr.isAttrValue10Dirty()) {
            return null;
        }
        Double d = pSSysDynaModelAttr.getAttrValue10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue10_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue11(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue11Dirty() : !pSSysDynaModelAttr.isAttrValue11Dirty()) {
            return null;
        }
        Double d = pSSysDynaModelAttr.getAttrValue11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue11_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue12(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue12Dirty() : !pSSysDynaModelAttr.isAttrValue12Dirty()) {
            return null;
        }
        Double d = pSSysDynaModelAttr.getAttrValue12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue12_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue13(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue13Dirty() : !pSSysDynaModelAttr.isAttrValue13Dirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDynaModelAttr.getAttrValue13();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue13_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE13");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue14(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue14Dirty() : !pSSysDynaModelAttr.isAttrValue14Dirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDynaModelAttr.getAttrValue14();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue14_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE14");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue15(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue15Dirty() : !pSSysDynaModelAttr.isAttrValue15Dirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDynaModelAttr.getAttrValue15();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue15_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE15");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue16(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue16Dirty() : !pSSysDynaModelAttr.isAttrValue16Dirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDynaModelAttr.getAttrValue16();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue16_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE16");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue2(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue2Dirty() : !pSSysDynaModelAttr.isAttrValue2Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue2_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue20(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue20Dirty() : !pSSysDynaModelAttr.isAttrValue20Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue20();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue20_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE20");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue21(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue21Dirty() : !pSSysDynaModelAttr.isAttrValue21Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue21();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue21_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE21");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue22(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue22Dirty() : !pSSysDynaModelAttr.isAttrValue22Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue22();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue22_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE22");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue23(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue23Dirty() : !pSSysDynaModelAttr.isAttrValue23Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue23();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue23_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE23");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue24(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue24Dirty() : !pSSysDynaModelAttr.isAttrValue24Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue24();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue24_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE24");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue25(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue25Dirty() : !pSSysDynaModelAttr.isAttrValue25Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue25();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue25_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE25");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue26(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue26Dirty() : !pSSysDynaModelAttr.isAttrValue26Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue26();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue26_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE26");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue27(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue27Dirty() : !pSSysDynaModelAttr.isAttrValue27Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue27();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue27_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE27");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue28(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue28Dirty() : !pSSysDynaModelAttr.isAttrValue28Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue28();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue28_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE28");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue29(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue29Dirty() : !pSSysDynaModelAttr.isAttrValue29Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue29();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue29_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE29");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue3(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue3Dirty() : !pSSysDynaModelAttr.isAttrValue3Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue3_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue30(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue30Dirty() : !pSSysDynaModelAttr.isAttrValue30Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue30();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue30_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE30");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue4(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue4Dirty() : !pSSysDynaModelAttr.isAttrValue4Dirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getAttrValue4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrValue4_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue5(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue5Dirty() : !pSSysDynaModelAttr.isAttrValue5Dirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getAttrValue5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue5_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue6(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue6Dirty() : !pSSysDynaModelAttr.isAttrValue6Dirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getAttrValue6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue6_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue7(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue7Dirty() : !pSSysDynaModelAttr.isAttrValue7Dirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getAttrValue7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue7_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue8(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue8Dirty() : !pSSysDynaModelAttr.isAttrValue8Dirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getAttrValue8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue8_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrValue9(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isAttrValue9Dirty() : !pSSysDynaModelAttr.isAttrValue9Dirty()) {
            return null;
        }
        Double d = pSSysDynaModelAttr.getAttrValue9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AttrValue9_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRVALUE9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isCodeNameDirty() : !pSSysDynaModelAttr.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JsonFormat(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isJsonFormatDirty() : !pSSysDynaModelAttr.isJsonFormatDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getJsonFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JsonFormat_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSONFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isLogicNameDirty() : !pSSysDynaModelAttr.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isMemoDirty() : !pSSysDynaModelAttr.isMemoDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isOrderValueDirty() : !pSSysDynaModelAttr.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSCodeListIdDirty() : !pSSysDynaModelAttr.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelAttrId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSSysDynaModelAttrIdDirty() && !bl2 : !pSSysDynaModelAttr.isPSSysDynaModelAttrIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSSysDynaModelAttrId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELATTRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelAttrId_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELATTRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelAttrName(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSSysDynaModelAttrNameDirty() && !bl2 : !pSSysDynaModelAttr.isPSSysDynaModelAttrNameDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSSysDynaModelAttrName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELATTRNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelAttrName_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELATTRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSDYNAMODELID";
                String string4 = this.checkFieldDupRule(this.getPSSysDynaModelAttrDEModel(), "PSSYSDYNAMODELATTRNAME", string3, pSSysDynaModelAttr, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDYNAMODELATTRNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSSysDynaModelIdDirty() && !bl2 : !pSSysDynaModelAttr.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSSysDynaModelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSSysDynaModelNameDirty() && !bl2 : !pSSysDynaModelAttr.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSSysDynaModelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isPSSysValueRuleIdDirty() : !pSSysDynaModelAttr.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEFGroupId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isRefPSDEFGroupIdDirty() : !pSSysDynaModelAttr.isRefPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getRefPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEFGroupId_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isRefPSDEIdDirty() : !pSSysDynaModelAttr.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isRefPSDENameDirty() : !pSSysDynaModelAttr.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysDynaModelId(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isRefPSSysDynaModelIdDirty() : !pSSysDynaModelAttr.isRefPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getRefPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysDynaModelId_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isStdDataTypeDirty() : !pSSysDynaModelAttr.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isValidFlagDirty() && !bl2 : !pSSysDynaModelAttr.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysDynaModelAttr.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysDynaModelAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValueType(boolean bl, PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDynaModelAttr.isValueTypeDirty() && !bl2 : !pSSysDynaModelAttr.isValueTypeDirty()) {
            return null;
        }
        String string = pSSysDynaModelAttr.getValueType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueType_Default(pSSysDynaModelAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDynaModelAttr, bl);
    }

    protected void onSyncIndexEntities(PSSysDynaModelAttr pSSysDynaModelAttr, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDynaModelAttr, bl);
    }

    public Object getDataContextValue(PSSysDynaModelAttr pSSysDynaModelAttr, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFGROUP", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEFGROUPID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEFGROUPNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSSysDynaModelAttr, "refpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSSysDynaModelAttr, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSSysDynaModel pSSysDynaModel = pSSysDynaModelAttr.getPSSysDynaModel();
        if (pSSysDynaModel != null && pSSysDynaModel.contains(string)) {
            return pSSysDynaModel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDynaModelAttr pSSysDynaModelAttr, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDynaModelAttr, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ARRAYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ArrayFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE13", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue13_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE14", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue14_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE15", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue15_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE16", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue16_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE20", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue20_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE21", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue21_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE22", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue22_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE23", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue23_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE24", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue24_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE25", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue25_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE26", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue26_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE27", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue27_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE28", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue28_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE29", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue29_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE30", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue30_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRVALUE9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrValue9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELUSAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelUsage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSONFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JsonFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELATTRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelAttrId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelAttrName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDynaModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ArrayFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue13_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue14_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue15_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue16_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue20_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE20", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue21_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE21", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue22_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE22", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue23_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE23", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue24_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE24", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue25_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE25", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue26_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE26", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue27_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE27", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue28_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE28", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue29_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE29", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue30_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE30", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRVALUE4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrValue5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrValue9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_DynaModelUsage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNAMODELUSAGE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JsonFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSONFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysDynaModelAttrId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELATTRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelAttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELATTRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUETYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDynaModelAttr pSSysDynaModelAttr) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDynaModelAttr)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDynaModelAttr pSSysDynaModelAttr) throws Exception {
        super.onUpdateParent(pSSysDynaModelAttr);
    }

    @Override
    protected void exportCurXmlModel(PSSysDynaModelAttr pSSysDynaModelAttr, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDYNAMODELATTR");
        if (!bl) {
            pSSysDynaModelAttr.setCreateDate(null);
            pSSysDynaModelAttr.setCreateMan(null);
            pSSysDynaModelAttr.setPSSysDynaModelAttrId(null);
            pSSysDynaModelAttr.setUpdateDate(null);
            pSSysDynaModelAttr.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDynaModelAttr, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDynaModelAttr pSSysDynaModelAttr, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDynaModelAttr, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDYNAMODELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDYNAMODEL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDYNAMODELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDYNAMODELATTR_PSSYSDYNAMODEL_PSSYSDYNAMODELID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDYNAMODELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDYNAMODELNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODEL", (boolean)true) == 0) {
            iEntity.set("PSSYSDYNAMODELID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDYNAMODELID"};
    }

    @Override
    public String getModelV2Tag(PSSysDynaModelAttr pSSysDynaModelAttr) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDynaModelAttr.getPSSysDynaModelAttrName())) {
            return pSSysDynaModelAttr.getPSSysDynaModelAttrName();
        }
        return super.getModelV2Tag(pSSysDynaModelAttr);
    }

    @Override
    public boolean setModelV2Tag(PSSysDynaModelAttr pSSysDynaModelAttr, String string) {
        pSSysDynaModelAttr.setPSSysDynaModelAttrName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDYNAMODELATTRNAME", "");
        map.put("PSSYSDYNAMODELID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDynaModelAttr pSSysDynaModelAttr, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDynaModelAttr.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDynaModelAttr, true);
        pSSysDynaModelAttr.set("PSSYSDYNAMODELATTRNAME", string);
        if (this.select(pSSysDynaModelAttr, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDynaModelAttr, true);
        return super.getModelV2Entity(pSSysDynaModelAttr, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDynaModelAttr pSSysDynaModelAttr, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysDynaModelAttr, objectNode, string, string2, n);
    }
}

