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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.systest.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSampleValueBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.dao.PSSysTDItemDAO;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTDItemDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestDataBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTDItemServiceBase
extends PSCoreSysServiceBase<PSSysTDItem> {
    private static final Log log = LogFactory.getLog(PSSysTDItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITDATAITEMS = "InitDataItems";
    private PSSysTDItemDEModel pSSysTDItemDEModel;
    private PSSysTDItemDAO pSSysTDItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTDItemService";
    }

    public PSSysTDItemDEModel getPSSysTDItemDEModel() {
        if (this.pSSysTDItemDEModel == null) {
            try {
                this.pSSysTDItemDEModel = (PSSysTDItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTDItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTDItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTDItemDEModel();
    }

    public PSSysTDItemDAO getPSSysTDItemDAO() {
        if (this.pSSysTDItemDAO == null) {
            try {
                this.pSSysTDItemDAO = (PSSysTDItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.systest.dao.PSSysTDItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTDItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTDItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDATAITEMS, (boolean)true) == 0) {
            this.initDataItems((PSSysTDItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void initDataItems(PSSysTDItem pSSysTDItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDATAITEMS, 0, pSSysTDItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysTDItem, ACTION_INITDATAITEMS);
        final PSSysTDItem pSSysTDItem2 = pSSysTDItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysTDItemServiceBase.this.getService(), PSSysTDItemServiceBase.ACTION_INITDATAITEMS, 40, pSSysTDItem2, null).getResult() != 1) {
                    PSSysTDItemServiceBase.this.onInitDataItems(pSSysTDItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDATAITEMS, 99, pSSysTDItem, null);
        }
    }

    protected void onInitDataItems(PSSysTDItem pSSysTDItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDataItems]");
    }

    protected void onFillParentInfo(PSSysTDItem pSSysTDItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysTDItem, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSSysTDItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSSysTDItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysTDItem, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSSYSSAMPLEVALUE_PSSYSSAMPLEVALUEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSampleValueService", (SessionFactory)this.getSessionFactory());
            PSSysSampleValue pSSysSampleValue = (PSSysSampleValue)iService.getDEModel().createEntity();
            pSSysSampleValue.set("PSSYSSAMPLEVALUEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSampleValue);
            } else {
                iService.get(pSSysSampleValue);
            }
            this.onFillParentInfo_PSSysSampleValue(pSSysTDItem, pSSysSampleValue);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestData);
            } else {
                iService.get(pSSysTestData);
            }
            this.onFillParentInfo_PSSysTestData(pSSysTDItem, pSSysTestData);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTDITEM_PSSYSTESTDATA_REFPSSYSTESTDATAID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.systest.service.PSSysTestDataService", (SessionFactory)this.getSessionFactory());
            PSSysTestData pSSysTestData = (PSSysTestData)iService.getDEModel().createEntity();
            pSSysTestData.set("PSSYSTESTDATAID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTestData);
            } else {
                iService.get(pSSysTestData);
            }
            this.onFillParentInfo_RefPSSysTestData(pSSysTDItem, pSSysTestData);
            return;
        }
        super.onFillParentInfo(pSSysTDItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysTDItem pSSysTDItem, PSCodeList pSCodeList) throws Exception {
        pSSysTDItem.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysTDItem.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSSysTDItem pSSysTDItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysTDItem.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysTDItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSSysTDItem pSSysTDItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysTDItem.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysTDItem.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEF(PSSysTDItem pSSysTDItem, PSDEField pSDEField) throws Exception {
        pSSysTDItem.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysTDItem.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysSampleValue(PSSysTDItem pSSysTDItem, PSSysSampleValue pSSysSampleValue) throws Exception {
        pSSysTDItem.setPSSysSampleValueId(pSSysSampleValue.getPSSysSampleValueId());
        pSSysTDItem.setPSSysSampleValueName(pSSysSampleValue.getPSSysSampleValueName());
    }

    protected void onFillParentInfo_PSSysTestData(PSSysTDItem pSSysTDItem, PSSysTestData pSSysTestData) throws Exception {
        pSSysTDItem.setPSDEId(pSSysTestData.getPSDEId());
        pSSysTDItem.setPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillParentInfo_RefPSSysTestData(PSSysTDItem pSSysTDItem, PSSysTestData pSSysTestData) throws Exception {
        pSSysTDItem.setRefPSSysTestDataId(pSSysTestData.getPSSysTestDataId());
        pSSysTDItem.setRefPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
    }

    protected void onFillEntityFullInfo(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        if (bl && pSSysTDItem.getValidFlag() == null) {
            pSSysTDItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysTDItem, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysTDItem, bl);
        this.onFillEntityFullInfo_RefPSDE(pSSysTDItem, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSSysTDItem, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysTDItem, bl);
        this.onFillEntityFullInfo_PSSysSampleValue(pSSysTDItem, bl);
        this.onFillEntityFullInfo_PSSysTestData(pSSysTDItem, bl);
        this.onFillEntityFullInfo_RefPSSysTestData(pSSysTDItem, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        if (pSSysTDItem.isRefPSDEIdDirty()) {
            if (pSSysTDItem.getRefPSDEId() != null) {
                if (pSSysTDItem.getRefPSDEId() == null || pSSysTDItem.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysTDItem.getRefPSDE();
                    pSSysTDItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysTDItem.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        if (pSSysTDItem.isPSDEFIdDirty()) {
            if (pSSysTDItem.getPSDEFId() != null) {
                if (pSSysTDItem.getPSDEFId() == null || pSSysTDItem.getPSDEFName() == null) {
                    PSDEField pSDEField = pSSysTDItem.getPSDEF();
                    pSSysTDItem.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysTDItem.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSampleValue(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTestData(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        if (pSSysTDItem.isPSSysTestDataIdDirty()) {
            if (pSSysTDItem.getPSSysTestDataId() != null) {
                if (pSSysTDItem.getPSSysTestDataId() == null || pSSysTDItem.getPSSysTestDataName() == null) {
                    PSSysTestData pSSysTestData = pSSysTDItem.getPSSysTestData();
                    pSSysTDItem.setPSDEId(pSSysTestData.getPSDEId());
                    pSSysTDItem.setPSSysTestDataName(pSSysTestData.getPSSysTestDataName());
                }
            } else {
                pSSysTDItem.setPSDEId(null);
                pSSysTDItem.setPSSysTestDataName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSSysTestData(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTDItem, bl);
    }

    public ArrayList<PSSysTDItem> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTDItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysTDItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTDItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTDItem> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase) throws Exception {
        return this.selectByPSSysSampleValue(pSSysSampleValueBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string) throws Exception {
        return this.selectByPSSysSampleValue(pSSysSampleValueBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByPSSysSampleValue(PSSysSampleValueBase pSSysSampleValueBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSAMPLEVALUEID", (Object)pSSysSampleValueBase.getPSSysSampleValueId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSampleValueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSampleValueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTDItem> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTDATAID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTestDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTestDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTDItem> selectTempByPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectTempByPSSysTestData(pSSysTestDataBase, "");
    }

    public ArrayList<PSSysTDItem> selectTempByPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTESTDATAID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysTestDataCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysTestDataCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTDItem> selectByRefPSSysTestData(PSSysTestDataBase pSSysTestDataBase) throws Exception {
        return this.selectByRefPSSysTestData(pSSysTestDataBase, "", -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string) throws Exception {
        return this.selectByRefPSSysTestData(pSSysTestDataBase, string, -1);
    }

    public ArrayList<PSSysTDItem> selectByRefPSSysTestData(PSSysTestDataBase pSSysTestDataBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSTESTDATAID", (Object)pSSysTestDataBase.getPSSysTestDataId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysTestDataCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysTestDataCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setPSCodeListId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysTDItemServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysTDItemServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setRefPSDEId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSSysTDItemServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSSysTDItemServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setRefPSDEDataSetId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSSysTDItemServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSSysTDItemServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setPSDEFId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysTDItemServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysTDItemServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSAMPLEVALUE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSampleValue);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSSYSSAMPLEVALUE_PSSYSSAMPLEVALUEID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSSysSampleValue), arrayList.get(0)));
        }
    }

    public void resetPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setPSSysSampleValueId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        final PSSysSampleValue pSSysSampleValue2 = pSSysSampleValue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByPSSysSampleValue(pSSysSampleValue2);
                PSSysTDItemServiceBase.this.internalRemoveByPSSysSampleValue(pSSysSampleValue2);
                PSSysTDItemServiceBase.this.onAfterRemoveByPSSysSampleValue(pSSysSampleValue2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void internalRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSSysSampleValue(pSSysSampleValue);
        this.onBeforeRemoveByPSSysSampleValue(pSSysSampleValue, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByPSSysSampleValue(pSSysSampleValue, arrayList);
    }

    protected void onAfterRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSampleValue(PSSysSampleValue pSSysSampleValue, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    public void resetPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSSysTestData(pSSysTestData);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setPSSysTestDataId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void resetTempPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectTempByPSSysTestData(pSSysTestData);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setPSSysTestDataId(null);
            this.updateTemp(pSSysTDItem2);
        }
    }

    public void removeByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.internalRemoveByPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.onAfterRemoveByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSSysTestData(pSSysTestData, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTESTDATA");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTestData);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTDITEM_PSSYSTESTDATA_REFPSSYSTESTDATAID", "", iDataEntityModel.getName(), "PSSYSTDITEM", iDataEntityModel.getDataInfo(pSSysTestData), arrayList.get(0)));
        }
    }

    public void resetRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSSysTestData(pSSysTestData);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            PSSysTDItem pSSysTDItem2 = (PSSysTDItem)this.getDEModel().createEntity();
            pSSysTDItem2.setPSSysTDItemId(pSSysTDItem.getPSSysTDItemId());
            pSSysTDItem2.setRefPSSysTestDataId(null);
            this.update(pSSysTDItem2);
        }
    }

    public void removeByRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveByRefPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.internalRemoveByRefPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.onAfterRemoveByRefPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveByRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectByRefPSSysTestData(pSSysTestData);
        this.onBeforeRemoveByRefPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.remove(pSSysTDItem);
        }
        this.onAfterRemoveByRefPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveByRefPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTDItem pSSysTDItem) throws Exception {
        super.onBeforeRemove(pSSysTDItem);
    }

    public void removeTempByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        final PSSysTestData pSSysTestData2 = pSSysTestData;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTDItemServiceBase.this.onBeforeRemoveTempByPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.internalRemoveTempByPSSysTestData(pSSysTestData2);
                PSSysTDItemServiceBase.this.onAfterRemoveTempByPSSysTestData(pSSysTestData2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void internalRemoveTempByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
        ArrayList<PSSysTDItem> arrayList = this.selectTempByPSSysTestData(pSSysTestData);
        this.onBeforeRemoveTempByPSSysTestData(pSSysTestData, arrayList);
        for (PSSysTDItem pSSysTDItem : arrayList) {
            this.removeTemp(pSSysTDItem);
        }
        this.onAfterRemoveTempByPSSysTestData(pSSysTestData, arrayList);
    }

    protected void onAfterRemoveTempByPSSysTestData(PSSysTestData pSSysTestData) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysTestData(PSSysTestData pSSysTestData, ArrayList<PSSysTDItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysTDItem pSSysTDItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTDItem, cloneSession);
        if (pSSysTDItem.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysTDItem.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysTDItem, (PSCodeList)iEntity);
        }
        if (pSSysTDItem.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysTDItem.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSSysTDItem, (PSDataEntity)iEntity);
        }
        if (pSSysTDItem.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysTDItem.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSSysTDItem, (PSDEDataSet)iEntity);
        }
        if (pSSysTDItem.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysTDItem.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysTDItem, (PSDEField)iEntity);
        }
        if (pSSysTDItem.getPSSysSampleValueId() != null && (iEntity = cloneSession.getEntity("PSSYSSAMPLEVALUE", (Object)pSSysTDItem.getPSSysSampleValueId())) != null) {
            this.onFillParentInfo_PSSysSampleValue(pSSysTDItem, (PSSysSampleValue)iEntity);
        }
        if (pSSysTDItem.getPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTDItem.getPSSysTestDataId())) != null) {
            this.onFillParentInfo_PSSysTestData(pSSysTDItem, (PSSysTestData)iEntity);
        }
        if (pSSysTDItem.getRefPSSysTestDataId() != null && (iEntity = cloneSession.getEntity("PSSYSTESTDATA", (Object)pSSysTDItem.getRefPSSysTestDataId())) != null) {
            this.onFillParentInfo_RefPSSysTestData(pSSysTDItem, (PSSysTestData)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTDItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BadValue(bl, pSSysTDItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSampleValueId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTDItemId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTDItemName(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTestDataName(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysTestDataId(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Value(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueRange(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueType(bl, pSSysTDItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTDItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BadValue(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isBadValueDirty() : !pSSysTDItem.isBadValueDirty()) {
            return null;
        }
        String string = pSSysTDItem.getBadValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BadValue_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BADVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isMemoDirty() : !pSSysTDItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysTDItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isOrderValueDirty() : !pSSysTDItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysTDItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSCodeListIdDirty() : !pSSysTDItem.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSDEFIdDirty() : !pSSysTDItem.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSDEFNameDirty() : !pSSysTDItem.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSampleValueId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSSysSampleValueIdDirty() : !pSSysTDItem.isPSSysSampleValueIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSSysSampleValueId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSampleValueId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSAMPLEVALUEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTDItemId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSSysTDItemIdDirty() && !bl2 : !pSSysTDItem.isPSSysTDItemIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSSysTDItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTDITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTDItemId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTDITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTDItemName(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSSysTDItemNameDirty() && !bl2 : !pSSysTDItem.isPSSysTDItemNameDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSSysTDItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTDITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTDItemName_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTDITEMNAME");
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
                string3 = "PSSYSTESTDATAID";
                String string4 = this.checkFieldDupRule(this.getPSSysTDItemDEModel(), "PSSYSTDITEMNAME", string3, pSSysTDItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSTDITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestDataId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSSysTestDataIdDirty() : !pSSysTDItem.isPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTestDataName(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isPSSysTestDataNameDirty() : !pSSysTDItem.isPSSysTestDataNameDirty()) {
            return null;
        }
        String string = pSSysTDItem.getPSSysTestDataName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTestDataName_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTESTDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isRefPSDEDataSetIdDirty() : !pSSysTDItem.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isRefPSDEIdDirty() : !pSSysTDItem.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isRefPSDENameDirty() : !pSSysTDItem.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSSysTDItem.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSSysTestDataId(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isRefPSSysTestDataIdDirty() : !pSSysTDItem.isRefPSSysTestDataIdDirty()) {
            return null;
        }
        String string = pSSysTDItem.getRefPSSysTestDataId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysTestDataId_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSTESTDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isStdDataTypeDirty() : !pSSysTDItem.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysTDItem.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isUserCatDirty() : !pSSysTDItem.isUserCatDirty()) {
            return null;
        }
        String string = pSSysTDItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isUserTagDirty() : !pSSysTDItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysTDItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isUserTag2Dirty() : !pSSysTDItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysTDItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isUserTag3Dirty() : !pSSysTDItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysTDItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isUserTag4Dirty() : !pSSysTDItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysTDItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isValidFlagDirty() : !pSSysTDItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysTDItem.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysTDItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Value(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isValueDirty() : !pSSysTDItem.isValueDirty()) {
            return null;
        }
        String string = pSSysTDItem.getValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Value_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueRange(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isValueRangeDirty() : !pSSysTDItem.isValueRangeDirty()) {
            return null;
        }
        String string = pSSysTDItem.getValueRange();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueRange_Default(pSSysTDItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUERANGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueType(boolean bl, PSSysTDItem pSSysTDItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTDItem.isValueTypeDirty() && !bl2 : !pSSysTDItem.isValueTypeDirty()) {
            return null;
        }
        String string = pSSysTDItem.getValueType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueType_Default(pSSysTDItem, bl2, bl3);
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

    protected void onSyncEntity(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTDItem, bl);
    }

    protected void onSyncIndexEntities(PSSysTDItem pSSysTDItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTDItem, bl);
    }

    public Object getDataContextValue(PSSysTDItem pSSysTDItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSSysTDItem, "refpsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSSysTDItem, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSSysTestData pSSysTestData = pSSysTDItem.getPSSysTestData();
        if (pSSysTestData != null && pSSysTestData.contains(string)) {
            return pSSysTestData.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTDItem pSSysTDItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysTDItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BADVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BadValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAMPLEVALUEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSampleValueId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSAMPLEVALUENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSampleValueName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTDITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTDItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTDITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTDItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTestDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSTESTDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysTestDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSTESTDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysTestDataName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Value_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUERANGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueRange_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BadValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BADVALUE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSampleValueId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAMPLEVALUEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSampleValueName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSAMPLEVALUENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTDItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTDITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTDItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTDITEMNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSSYSTDITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTestDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTESTDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSSysTestDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSTESTDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysTestDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSTESTDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_Value_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueRange_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUERANGE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysTDItem pSSysTDItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTDItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTDItem pSSysTDItem) throws Exception {
        super.onUpdateParent(pSSysTDItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysTDItem pSSysTDItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTDITEM");
        if (!bl) {
            pSSysTDItem.setCreateDate(null);
            pSSysTDItem.setCreateMan(null);
            pSSysTDItem.setPSSysTDItemId(null);
            pSSysTDItem.setUpdateDate(null);
            pSSysTDItem.setUpdateMan(null);
            pSSysTDItem.setPSDEId(null);
            pSSysTDItem.setPSSysTestDataId(null);
            pSSysTDItem.setPSSysTestDataName(null);
            super.exportCurXmlModel(pSSysTDItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTDItem pSSysTDItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTDItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTESTDATA#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSTDITEM_PSSYSTESTDATA_PSSYSTESTDATAID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTDATAID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTESTDATANAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTESTDATA", (boolean)true) == 0) {
            iEntity.set("PSSYSTESTDATAID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTESTDATAID"};
    }

    @Override
    public String getModelV2Tag(PSSysTDItem pSSysTDItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysTDItem.getPSSysTDItemName())) {
            return pSSysTDItem.getPSSysTDItemName();
        }
        return super.getModelV2Tag(pSSysTDItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysTDItem pSSysTDItem, String string) {
        pSSysTDItem.setPSSysTDItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTDITEMNAME", "");
        map.put("PSSYSTESTDATAID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysTDItem pSSysTDItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTDItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTDItem, true);
        pSSysTDItem.set("PSSYSTDITEMNAME", string);
        if (this.select(pSSysTDItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysTDItem, true);
        return super.getModelV2Entity(pSSysTDItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTDItem pSSysTDItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysTDItem, objectNode, string, string2, n);
    }
}

