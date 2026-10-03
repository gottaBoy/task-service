/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDESampleDataDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleDataRef;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataRefService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataRefServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestDataServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDESampleDataServiceBase
extends PSCoreSysServiceBase<PSDESampleData> {
    private static final Log log = LogFactory.getLog(PSDESampleDataServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDESampleDataDEModel pSDESampleDataDEModel;
    private PSDESampleDataDAO pSDESampleDataDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService";
    }

    public PSDESampleDataDEModel getPSDESampleDataDEModel() {
        if (this.pSDESampleDataDEModel == null) {
            try {
                this.pSDESampleDataDEModel = (PSDESampleDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESampleDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESampleDataDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDESampleDataDEModel();
    }

    public PSDESampleDataDAO getPSDESampleDataDAO() {
        if (this.pSDESampleDataDAO == null) {
            try {
                this.pSDESampleDataDAO = (PSDESampleDataDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDESampleDataDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESampleDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDESampleDataDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDESampleData pSDESampleData, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAMPLEDATA_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDESampleData, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAMPLEDATA_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMainState);
            } else {
                iService.get(pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDESampleData, pSDEMainState);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDESAMPLEDATA_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDESampleData, pSSysReqItem);
            return;
        }
        super.onFillParentInfo(pSDESampleData, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDESampleData pSDESampleData, PSDataEntity pSDataEntity) throws Exception {
        pSDESampleData.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDESampleData.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEMainState(PSDESampleData pSDESampleData, PSDEMainState pSDEMainState) throws Exception {
        pSDESampleData.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDESampleData.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDESampleData pSDESampleData, PSSysReqItem pSSysReqItem) throws Exception {
        pSDESampleData.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDESampleData.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillEntityFullInfo(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        if (bl) {
            if (pSDESampleData.getCodeName() == null) {
                pSDESampleData.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "SampleData", 25));
            }
            if (pSDESampleData.getPSDESampleDataName() == null) {
                pSDESampleData.setPSDESampleDataName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u793a\u4f8b\u6570\u636e", 25));
            }
        }
        super.onFillEntityFullInfo(pSDESampleData, bl);
        this.onFillEntityFullInfo_PSDE(pSDESampleData, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDESampleData, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDESampleData, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        if (pSDESampleData.isPSDEIdDirty()) {
            if (pSDESampleData.getPSDEId() != null) {
                if (pSDESampleData.getPSDEId() == null || pSDESampleData.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDESampleData.getPSDE();
                    pSDESampleData.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDESampleData.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDESampleData pSDESampleData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDESampleData pSDESampleData, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        super.onWriteBackParent(pSDESampleData, bl);
    }

    public ArrayList<PSDESampleData> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDESampleData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDESampleData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESampleData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDESampleData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDESampleData> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDESampleData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDESampleData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDESampleData> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDESampleData pSDESampleData : arrayList) {
            PSDESampleData pSDESampleData2 = (PSDESampleData)this.getDEModel().createEntity();
            pSDESampleData2.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
            pSDESampleData2.setPSDEId(null);
            this.update(pSDESampleData2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESampleDataServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDESampleDataServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDESampleDataServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDESampleData pSDESampleData : arrayList) {
            this.remove(pSDESampleData);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAMPLEDATA_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSDESAMPLEDATA", iDataEntityModel.getDataInfo(pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDESampleData pSDESampleData : arrayList) {
            PSDESampleData pSDESampleData2 = (PSDESampleData)this.getDEModel().createEntity();
            pSDESampleData2.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
            pSDESampleData2.setPSDEMainStateId(null);
            this.update(pSDESampleData2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESampleDataServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDESampleDataServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDESampleDataServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDESampleData pSDESampleData : arrayList) {
            this.remove(pSDESampleData);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDESAMPLEDATA_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDESAMPLEDATA", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDESampleData pSDESampleData : arrayList) {
            PSDESampleData pSDESampleData2 = (PSDESampleData)this.getDEModel().createEntity();
            pSDESampleData2.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
            pSDESampleData2.setPSSysReqItemId(null);
            this.update(pSDESampleData2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDESampleDataServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDESampleDataServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDESampleDataServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDESampleData> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDESampleData pSDESampleData : arrayList) {
            this.remove(pSDESampleData);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDESampleData> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDESampleData pSDESampleData) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByInPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByInPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataSetServiceBase)pSCoreSysServiceBase).testRemoveByOutPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESampleDataRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDESampleData(pSDESampleData);
        ((PSDESampleDataRefServiceBase)pSCoreSysServiceBase).removeByPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESampleDataRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDESampleData(pSDESampleData);
        pSCoreSysServiceBase = (PSSysTestDataService)ServiceGlobal.getService(PSSysTestDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDESampleData(pSDESampleData);
        super.onBeforeRemove(pSDESampleData);
    }

    protected void replaceParentInfo(PSDESampleData pSDESampleData, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDESampleData, cloneSession);
        if (pSDESampleData.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDESampleData.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDESampleData, (PSDataEntity)iEntity);
        }
        if (pSDESampleData.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDESampleData.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDESampleData, (PSDEMainState)iEntity);
        }
        if (pSDESampleData.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDESampleData.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDESampleData, (PSSysReqItem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDESampleData, bl);
    }

    protected void onCheckEntity(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDESampleData, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data2(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicMode(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESampleDataId(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESampleDataName(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomCnt(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomMode(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomParam(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomParam2(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomParam3(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RandomParam4(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDTag(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDTag2(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDTag3(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SDTag4(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Usage(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDESampleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDESampleData, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isCodeNameDirty() && !bl2 : !pSDESampleData.isCodeNameDirty()) {
            return null;
        }
        String string = pSDESampleData.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDESampleData, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDESampleDataDEModel(), "CODENAME", string3, pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isCustomCodeDirty() : !pSDESampleData.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDESampleData.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isCustomModeDirty() : !pSDESampleData.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDESampleData.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isDataDirty() : !pSDESampleData.isDataDirty()) {
            return null;
        }
        String string = pSDESampleData.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data2(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isData2Dirty() : !pSDESampleData.isData2Dirty()) {
            return null;
        }
        String string = pSDESampleData.getData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data2_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataType(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isDataTypeDirty() : !pSDESampleData.isDataTypeDirty()) {
            return null;
        }
        String string = pSDESampleData.getDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicMode(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isLogicModeDirty() : !pSDESampleData.isLogicModeDirty()) {
            return null;
        }
        String string = pSDESampleData.getLogicMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicMode_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isMemoDirty() : !pSDESampleData.isMemoDirty()) {
            return null;
        }
        String string = pSDESampleData.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSDEIdDirty() && !bl2 : !pSDESampleData.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSDEMainStateIdDirty() : !pSDESampleData.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSDENameDirty() && !bl2 : !pSDESampleData.isPSDENameDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESampleDataId(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSDESampleDataIdDirty() && !bl2 : !pSDESampleData.isPSDESampleDataIdDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSDESampleDataId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataId_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESampleDataName(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSDESampleDataNameDirty() && !bl2 : !pSDESampleData.isPSDESampleDataNameDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSDESampleDataName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESampleDataName_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESAMPLEDATANAME");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDESampleDataDEModel(), "PSDESAMPLEDATANAME", string3, pSDESampleData, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDESAMPLEDATANAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isPSSysReqItemIdDirty() : !pSDESampleData.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDESampleData.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomCnt(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomCntDirty() : !pSDESampleData.isRandomCntDirty()) {
            return null;
        }
        Integer n = pSDESampleData.getRandomCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RandomCnt_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomMode(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomModeDirty() : !pSDESampleData.isRandomModeDirty()) {
            return null;
        }
        String string = pSDESampleData.getRandomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RandomMode_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomParam(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomParamDirty() : !pSDESampleData.isRandomParamDirty()) {
            return null;
        }
        String string = pSDESampleData.getRandomParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RandomParam_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomParam2(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomParam2Dirty() : !pSDESampleData.isRandomParam2Dirty()) {
            return null;
        }
        String string = pSDESampleData.getRandomParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RandomParam2_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomParam3(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomParam3Dirty() : !pSDESampleData.isRandomParam3Dirty()) {
            return null;
        }
        Integer n = pSDESampleData.getRandomParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RandomParam3_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RandomParam4(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isRandomParam4Dirty() : !pSDESampleData.isRandomParam4Dirty()) {
            return null;
        }
        Integer n = pSDESampleData.getRandomParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RandomParam4_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RANDOMPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDTag(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isSDTagDirty() : !pSDESampleData.isSDTagDirty()) {
            return null;
        }
        String string = pSDESampleData.getSDTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDTag_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDTag2(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isSDTag2Dirty() : !pSDESampleData.isSDTag2Dirty()) {
            return null;
        }
        String string = pSDESampleData.getSDTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDTag2_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDTag3(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isSDTag3Dirty() : !pSDESampleData.isSDTag3Dirty()) {
            return null;
        }
        String string = pSDESampleData.getSDTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDTag3_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SDTag4(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isSDTag4Dirty() : !pSDESampleData.isSDTag4Dirty()) {
            return null;
        }
        String string = pSDESampleData.getSDTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SDTag4_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SDTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Usage(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUsageDirty() : !pSDESampleData.isUsageDirty()) {
            return null;
        }
        String string = pSDESampleData.getUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Usage_Default(pSDESampleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUserCatDirty() : !pSDESampleData.isUserCatDirty()) {
            return null;
        }
        String string = pSDESampleData.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUserTagDirty() : !pSDESampleData.isUserTagDirty()) {
            return null;
        }
        String string = pSDESampleData.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUserTag2Dirty() : !pSDESampleData.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDESampleData.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUserTag3Dirty() : !pSDESampleData.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDESampleData.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDESampleData, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDESampleData pSDESampleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDESampleData.isUserTag4Dirty() : !pSDESampleData.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDESampleData.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDESampleData, bl2, bl3);
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

    protected void onSyncEntity(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        super.onSyncEntity(pSDESampleData, bl);
    }

    protected void onSyncIndexEntities(PSDESampleData pSDESampleData, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDESampleData, bl);
    }

    public Object getDataContextValue(PSDESampleData pSDESampleData, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDESampleData, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDESampleData pSDESampleData, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDESampleData, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESAMPLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESampleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RANDOMPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RandomParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SDTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SDTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Usage_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 16000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESampleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESAMPLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RandomCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RandomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RANDOMMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RandomParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RANDOMPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RandomParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RANDOMPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RandomParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RandomParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SDTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SDTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SDTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_Usage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDESampleData pSDESampleData) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDESampleData)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDESampleData pSDESampleData) throws Exception {
        super.onUpdateParent(pSDESampleData);
    }

    @Override
    protected void exportCurXmlModel(PSDESampleData pSDESampleData, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDESAMPLEDATA");
        if (!bl) {
            pSDESampleData.setCreateDate(null);
            pSDESampleData.setCreateMan(null);
            pSDESampleData.setPSDESampleDataId(null);
            pSDESampleData.setUpdateDate(null);
            pSDESampleData.setUpdateMan(null);
            super.exportCurXmlModel(pSDESampleData, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDESampleData pSDESampleData, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDESampleData, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDESAMPLEDATA_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDESampleData pSDESampleData) {
        if (!StringHelper.isNullOrEmpty((String)pSDESampleData.getCodeName())) {
            return pSDESampleData.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESampleData.getPSDESampleDataName())) {
            return pSDESampleData.getPSDESampleDataName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDESampleData.getCodeName())) {
            return pSDESampleData.getCodeName();
        }
        return super.getModelV2Tag(pSDESampleData);
    }

    @Override
    public boolean setModelV2Tag(PSDESampleData pSDESampleData, String string) {
        pSDESampleData.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDESAMPLEDATANAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDESAMPLEDATANAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDESampleData pSDESampleData, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDESampleData.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDESampleData, true);
        pSDESampleData.set("CODENAME", string);
        if (this.select(pSDESampleData, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDESampleData, true);
        return super.getModelV2Entity(pSDESampleData, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDESampleData pSDESampleData, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDESampleData, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDESampleData pSDESampleData, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESAMPLEDATA#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDESAMPLEDATAREF", (Object)pSDESampleData.getPSDESampleDataId()))).exists()) {
            PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDESampleDataRefService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDESampleDataRef pSDESampleDataRef = new PSDESampleDataRef();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDESampleDataRef, objectNode, false);
                String string6 = pSDESampleDataRefService.getModelV2Tag(pSDESampleDataRef);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDESAMPLEDATAREF", (Object)pSDESampleDataRef.getPSDESampleDataRefId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDESampleDataRefService.exportModelV2(pSDESampleDataRef, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSDESampleData, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDESampleData pSDESampleData, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID")) {
            PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDESAMPLEDATA#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDESAMPLEDATAREF", (Object)pSDESampleData.getPSDESampleDataId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDESAMPLEDATA#%1$s", (Object)pSDESampleData.getPSDESampleDataId());
                for (PSDESampleDataRef ref : pSDESampleDataRefService.selectByPSDESampleData(pSDESampleData)) {
                    String refScope = pSDESampleDataRefService.getModelV2ResScope(ref);
                    if (StringHelper.compare((String)scope, (String)refScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(ref, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String modelName = pSDESampleDataRefService.getModelV2Name(false);
                ArrayNode arrayNode = objectNode.putArray(modelName.toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdesampledatarefname")) {
                            string = objectNode.get("psdesampledatarefname").asText();
                        }
                        if (objectNode2.has("psdesampledatarefname")) {
                            string2 = objectNode2.get("psdesampledatarefname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode refNode : arrayList) {
                    PSDESampleDataRef ref = new PSDESampleDataRef();
                    PSModelV2Helper.fromJSONObject((IDataObject)ref, refNode, false);
                    arrayNode.add((JsonNode)pSDESampleDataRefService.exportModelV2(ref, string));
                }
            }
        }
        super.onExportCurModelV2(pSDESampleData, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDESampleData pSDESampleData) throws Exception {
        super.onEmptyModelV2(pSDESampleData);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
        if (pSDESampleDataRefService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDESampleData pSDESampleData, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDESampleDataRef pSDESampleDataRef = new PSDESampleDataRef();
        pSDESampleDataRef.set("PSDESAMPLEDATAID", pSDESampleData.getPSDESampleDataId());
        PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDESampleDataRefService.getModelV2Entity(pSDESampleDataRef, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDESampleData, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDESampleData pSDESampleData, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSDESampleDataServiceBase.isSimpleImportExportMode("")) {
            PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSDESampleDataRefService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSDESampleDataRef pSDESampleDataRef = new PSDESampleDataRef();
                    pSDESampleDataRef.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
                    pSDESampleDataRef.setPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
                    pSDESampleDataRefService.compileModelV2(pSDESampleDataRef, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSDESampleDataRef pSDESampleDataRef = new PSDESampleDataRef();
                        pSDESampleDataRef.setPSDESampleDataId(pSDESampleData.getPSDESampleDataId());
                        pSDESampleDataRef.setPSDESampleDataName(pSDESampleData.getPSDESampleDataName());
                        pSDESampleDataRefService.compileModelV2(pSDESampleDataRef, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDESampleData, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDESampleData pSDESampleData, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDESampleDataRefs(pSDESampleData, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDESampleData, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDESampleDataRefs(PSDESampleData pSDESampleData, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDESAMPLEDATAREF", true), (boolean)false) == 0) {
            PSDESampleDataRefService pSDESampleDataRefService = (PSDESampleDataRefService)ServiceGlobal.getService(PSDESampleDataRefService.class, (SessionFactory)this.getSessionFactory());
            PSDESampleDataRef pSDESampleDataRef = new PSDESampleDataRef();
            pSDESampleDataRef.setPSDESampleDataRefId(pSMOSFile.getPSModelId());
            if (!pSDESampleDataRefService.get(pSDESampleDataRef, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDESampleDataRef.getPSDESampleDataId(), (String)pSDESampleData.getPSDESampleDataId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDESampleDataRefService.exportModelV2(pSDESampleDataRef);
            pSDESampleDataRef.reset();
            if (!pSDESampleDataRefService.setModelV2ResScope(pSDESampleDataRef, "PSDESAMPLEDATA", pSDESampleData.getPSDESampleDataId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDESampleDataRefService.importModelV2(pSDESampleDataRef, objectNode);
            SessionFactoryManager.commit();
            return pSDESampleDataRefService.getFile(pSDESampleDataRef);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDESampleData pSDESampleData, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDESampleDataRefs(pSDESampleData, list);
        super.onFillPasteHelps(pSDESampleData, list);
    }

    protected void onFillPasteHelps_PSDESampleDataRefs(PSDESampleData pSDESampleData, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDESAMPLEDATAREF");
        pSHelpSection.setSectionParam2("DER1N_PSDESAMPLEDATAREF_PSDESAMPLEDATA_PSDESAMPLEDATAID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u793a\u4f8b\u6570\u636e]\u7684[\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u5f15\u7528]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDESampleData pSDESampleData, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "SampleData");
        defaultValueMap.put("PSDESAMPLEDATANAME", "\u793a\u4f8b\u6570\u636e");
    }
}
