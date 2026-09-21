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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIHierarchyDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIHierarchyDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimensionBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIHierarchyServiceBase
extends PSCoreSysServiceBase<PSSysBIHierarchy> {
    private static final Log log = LogFactory.getLog(PSSysBIHierarchyServiceBase.class);
    public static final String DATASET_CURDIMENSION = "CurDimension";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBIHierarchyDEModel pSSysBIHierarchyDEModel;
    private PSSysBIHierarchyDAO pSSysBIHierarchyDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService";
    }

    public PSSysBIHierarchyDEModel getPSSysBIHierarchyDEModel() {
        if (this.pSSysBIHierarchyDEModel == null) {
            try {
                this.pSSysBIHierarchyDEModel = (PSSysBIHierarchyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIHierarchyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIHierarchyDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIHierarchyDEModel();
    }

    public PSSysBIHierarchyDAO getPSSysBIHierarchyDAO() {
        if (this.pSSysBIHierarchyDAO == null) {
            try {
                this.pSSysBIHierarchyDAO = (PSSysBIHierarchyDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIHierarchyDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIHierarchyDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIHierarchyDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDIMENSION, (boolean)true) == 0) {
            return this.fetchCurDimension(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDimension(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDIMENSION, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBIHierarchy pSSysBIHierarchy, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIHIERARCHY_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysBIHierarchy, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIHIERARCHY_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBIHierarchy, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService", (SessionFactory)this.getSessionFactory());
            PSSysBIDimension pSSysBIDimension = (PSSysBIDimension)iService.getDEModel().createEntity();
            pSSysBIDimension.set("PSSYSBIDIMENSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIDimension);
            } else {
                iService.get((IEntity)pSSysBIDimension);
            }
            this.onFillParentInfo_PSSysBIDimension(pSSysBIHierarchy, pSSysBIDimension);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBIHierarchy, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSSysBIHierarchy pSSysBIHierarchy, PSCodeList pSCodeList) throws Exception {
        pSSysBIHierarchy.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysBIHierarchy.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDE(PSSysBIHierarchy pSSysBIHierarchy, PSDataEntity pSDataEntity) throws Exception {
        pSSysBIHierarchy.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBIHierarchy.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysBIDimension(PSSysBIHierarchy pSSysBIHierarchy, PSSysBIDimension pSSysBIDimension) throws Exception {
        pSSysBIHierarchy.setPSSysBIDimensionId(pSSysBIDimension.getPSSysBIDimensionId());
        pSSysBIHierarchy.setPSSysBIDimensionName(pSSysBIDimension.getPSSysBIDimensionName());
    }

    protected void onFillEntityFullInfo(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        if (bl && pSSysBIHierarchy.getCodeName() == null) {
            pSSysBIHierarchy.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Hierarchy", 25));
        }
        super.onFillEntityFullInfo((IEntity)pSSysBIHierarchy, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysBIHierarchy, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBIHierarchy, bl);
        this.onFillEntityFullInfo_PSSysBIDimension(pSSysBIHierarchy, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        if (pSSysBIHierarchy.isPSDEIdDirty()) {
            if (pSSysBIHierarchy.getPSDEId() != null) {
                if (pSSysBIHierarchy.getPSDEId() == null || pSSysBIHierarchy.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBIHierarchy.getPSDE();
                    pSSysBIHierarchy.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBIHierarchy.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBIDimension(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBIHierarchy, bl);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIHierarchy> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIHierarchy> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase) throws Exception {
        return this.selectByPSSysBIDimension(pSSysBIDimensionBase, "", -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase, String string) throws Exception {
        return this.selectByPSSysBIDimension(pSSysBIDimensionBase, string, -1);
    }

    public ArrayList<PSSysBIHierarchy> selectByPSSysBIDimension(PSSysBIDimensionBase pSSysBIDimensionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIDIMENSIONID", (Object)pSSysBIDimensionBase.getPSSysBIDimensionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIDimensionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIDimensionCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIHIERARCHY_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSBIHIERARCHY", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            PSSysBIHierarchy pSSysBIHierarchy2 = (PSSysBIHierarchy)this.getDEModel().createEntity();
            pSSysBIHierarchy2.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
            pSSysBIHierarchy2.setPSCodeListId(null);
            this.update(pSSysBIHierarchy2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIHierarchyServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysBIHierarchyServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysBIHierarchyServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            this.remove((IEntity)pSSysBIHierarchy);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIHIERARCHY_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBIHIERARCHY", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            PSSysBIHierarchy pSSysBIHierarchy2 = (PSSysBIHierarchy)this.getDEModel().createEntity();
            pSSysBIHierarchy2.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
            pSSysBIHierarchy2.setPSDEId(null);
            this.update(pSSysBIHierarchy2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIHierarchyServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBIHierarchyServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBIHierarchyServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            this.remove((IEntity)pSSysBIHierarchy);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
    }

    public void resetPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSSysBIDimension(pSSysBIDimension);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            PSSysBIHierarchy pSSysBIHierarchy2 = (PSSysBIHierarchy)this.getDEModel().createEntity();
            pSSysBIHierarchy2.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
            pSSysBIHierarchy2.setPSSysBIDimensionId(null);
            this.update(pSSysBIHierarchy2);
        }
    }

    public void removeByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        final PSSysBIDimension pSSysBIDimension2 = pSSysBIDimension;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIHierarchyServiceBase.this.onBeforeRemoveByPSSysBIDimension(pSSysBIDimension2);
                PSSysBIHierarchyServiceBase.this.internalRemoveByPSSysBIDimension(pSSysBIDimension2);
                PSSysBIHierarchyServiceBase.this.onAfterRemoveByPSSysBIDimension(pSSysBIDimension2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
    }

    protected void internalRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
        ArrayList<PSSysBIHierarchy> arrayList = this.selectByPSSysBIDimension(pSSysBIDimension);
        this.onBeforeRemoveByPSSysBIDimension(pSSysBIDimension, arrayList);
        for (PSSysBIHierarchy pSSysBIHierarchy : arrayList) {
            this.remove((IEntity)pSSysBIHierarchy);
        }
        this.onAfterRemoveByPSSysBIDimension(pSSysBIDimension, arrayList);
    }

    protected void onAfterRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIDimension(PSSysBIDimension pSSysBIDimension, ArrayList<PSSysBIHierarchy> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBICubeLevelService)ServiceGlobal.getService(PSSysBICubeLevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeLevelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIHierarchy(pSSysBIHierarchy);
        pSCoreSysServiceBase = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBILevelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIHierarchy(pSSysBIHierarchy);
        ((PSSysBILevelServiceBase)pSCoreSysServiceBase).removeByPSSysBIHierarchy(pSSysBIHierarchy);
        super.onBeforeRemove(pSSysBIHierarchy);
    }

    protected void replaceParentInfo(PSSysBIHierarchy pSSysBIHierarchy, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBIHierarchy, cloneSession);
        if (pSSysBIHierarchy.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysBIHierarchy.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysBIHierarchy, (PSCodeList)iEntity);
        }
        if (pSSysBIHierarchy.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBIHierarchy.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBIHierarchy, (PSDataEntity)iEntity);
        }
        if (pSSysBIHierarchy.getPSSysBIDimensionId() != null && (iEntity = cloneSession.getEntity("PSSYSBIDIMENSION", (Object)pSSysBIHierarchy.getPSSysBIDimensionId())) != null) {
            this.onFillParentInfo_PSSysBIDimension(pSSysBIHierarchy, (PSSysBIDimension)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBIHierarchy, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllCaption(bl, pSSysBIHierarchy, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIHierarchyTag(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIHierarchyTag2(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIHierarchyType(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HasAll(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIDimensionId(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIHierarchyId(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIHierarchyName(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIHierarchy, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBIHierarchy, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllCaption(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isAllCaptionDirty() : !pSSysBIHierarchy.isAllCaptionDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getAllCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AllCaption_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIHierarchyTag(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isBIHierarchyTagDirty() : !pSSysBIHierarchy.isBIHierarchyTagDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getBIHierarchyTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIHierarchyTag_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIHIERARCHYTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIHierarchyTag2(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isBIHierarchyTag2Dirty() : !pSSysBIHierarchy.isBIHierarchyTag2Dirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getBIHierarchyTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIHierarchyTag2_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIHIERARCHYTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIHierarchyType(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isBIHierarchyTypeDirty() && !bl2 : !pSSysBIHierarchy.isBIHierarchyTypeDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getBIHierarchyType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIHIERARCHYTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIHierarchyType_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIHIERARCHYTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isCodeNameDirty() && !bl2 : !pSSysBIHierarchy.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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
                string3 = "PSSYSBIDIMENSIONID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIHierarchyDEModel(), "CODENAME", string3, pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_HasAll(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isHasAllDirty() : !pSSysBIHierarchy.isHasAllDirty()) {
            return null;
        }
        Integer n = pSSysBIHierarchy.getHasAll();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HasAll_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HASALL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isMemoDirty() : !pSSysBIHierarchy.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isOrderValueDirty() : !pSSysBIHierarchy.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBIHierarchy.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSCodeListIdDirty() : !pSSysBIHierarchy.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSDEIdDirty() : !pSSysBIHierarchy.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSDENameDirty() : !pSSysBIHierarchy.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIDimensionId(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSSysBIDimensionIdDirty() : !pSSysBIHierarchy.isPSSysBIDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSSysBIDimensionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIDimensionId_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIDIMENSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIHierarchyId(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSSysBIHierarchyIdDirty() && !bl2 : !pSSysBIHierarchy.isPSSysBIHierarchyIdDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSSysBIHierarchyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIHierarchyId_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIHierarchyName(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isPSSysBIHierarchyNameDirty() && !bl2 : !pSSysBIHierarchy.isPSSysBIHierarchyNameDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getPSSysBIHierarchyName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIHierarchyName_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYNAME");
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
                string3 = "PSSYSBIDIMENSIONID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIHierarchyDEModel(), "PSSYSBIHIERARCHYNAME", string3, pSSysBIHierarchy, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBIHIERARCHYNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isUserCatDirty() : !pSSysBIHierarchy.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isUserTagDirty() : !pSSysBIHierarchy.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isUserTag2Dirty() : !pSSysBIHierarchy.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isUserTag3Dirty() : !pSSysBIHierarchy.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isUserTag4Dirty() : !pSSysBIHierarchy.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIHierarchy.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIHierarchy pSSysBIHierarchy, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIHierarchy.isValidFlagDirty() && !bl2 : !pSSysBIHierarchy.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIHierarchy.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBIHierarchy, bl2, bl3);
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

    protected void onSyncEntity(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBIHierarchy, bl);
    }

    protected void onSyncIndexEntities(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBIHierarchy, bl);
    }

    public Object getDataContextValue(PSSysBIHierarchy pSSysBIHierarchy, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBIHierarchy, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIDimension pSSysBIDimension = pSSysBIHierarchy.getPSSysBIDimension();
        if (pSSysBIDimension != null && pSSysBIDimension.contains(string)) {
            return pSSysBIDimension.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIHierarchy pSSysBIHierarchy, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBIHierarchy, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIHIERARCHYTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIHierarchyTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIHIERARCHYTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIHierarchyTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIHIERARCHYTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIHierarchyType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"HASALL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HasAll_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ALLCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIHierarchyTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIHIERARCHYTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIHierarchyTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIHIERARCHYTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIHierarchyType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIHIERARCHYTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_HasAll_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysBIDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIDimensionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIHierarchyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIHierarchyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBIHierarchy)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        super.onUpdateParent((IEntity)pSSysBIHierarchy);
    }

    protected void onCopyDetails(PSSysBIHierarchy pSSysBIHierarchy, Object object) throws Exception {
        PSSysBIHierarchy pSSysBIHierarchy2 = new PSSysBIHierarchy();
        pSSysBIHierarchy2.set("PSSYSBIHIERARCHYID", object);
        String string = DataObject.getStringValue((Object)pSSysBIHierarchy.get("PSSYSBIHIERARCHYID"));
        PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBILevel> arrayList = pSSysBILevelService.selectByPSSysBIHierarchy(pSSysBIHierarchy2);
        for (PSSysBILevel pSSysBILevel : arrayList) {
            Object object2 = pSSysBILevel.get("PSSYSBILEVELID");
            pSSysBILevelService.getDraftFrom((IEntity)pSSysBILevel);
            pSSysBILevelService.fillParentInfo((IEntity)pSSysBILevel, "DER1N", "DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", string);
            pSSysBILevelService.create(pSSysBILevel);
            pSSysBILevelService.copyDetails(pSSysBILevel, object2);
        }
        super.onCopyDetails((IEntity)pSSysBIHierarchy, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIHierarchy pSSysBIHierarchy, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIHIERARCHY");
        if (!bl) {
            pSSysBIHierarchy.setCreateDate(null);
            pSSysBIHierarchy.setCreateMan(null);
            pSSysBIHierarchy.setPSSysBIHierarchyId(null);
            pSSysBIHierarchy.setUpdateDate(null);
            pSSysBIHierarchy.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBIHierarchy, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIHierarchy pSSysBIHierarchy, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIHierarchy, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBIDIMENSION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIHIERARCHY_PSSYSBIDIMENSION_PSSYSBIDIMENSIONID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBIDIMENSIONNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSION", (boolean)true) == 0) {
            iEntity.set("PSSYSBIDIMENSIONID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBIDIMENSIONID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIHierarchy pSSysBIHierarchy) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIHierarchy.getCodeName())) {
            return pSSysBIHierarchy.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIHierarchy.getPSSysBIHierarchyName())) {
            return pSSysBIHierarchy.getPSSysBIHierarchyName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIHierarchy.getCodeName())) {
            return pSSysBIHierarchy.getCodeName();
        }
        return super.getModelV2Tag(pSSysBIHierarchy);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIHierarchy pSSysBIHierarchy, String string) {
        pSSysBIHierarchy.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBIHIERARCHYNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBIDIMENSIONID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIHierarchy pSSysBIHierarchy, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIHierarchy.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIHierarchy, true);
        pSSysBIHierarchy.set("CODENAME", string);
        if (this.select(pSSysBIHierarchy, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIHierarchy, true);
        return super.getModelV2Entity(pSSysBIHierarchy, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIHierarchy pSSysBIHierarchy, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBIHierarchy, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBIHierarchy pSSysBIHierarchy, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIHIERARCHY#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSBILEVEL", (Object)pSSysBIHierarchy.getPSSysBIHierarchyId()))).exists()) {
            PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysBILevelService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysBILevel pSSysBILevel = new PSSysBILevel();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysBILevel, objectNode, false);
                String string6 = pSSysBILevelService.getModelV2Tag(pSSysBILevel);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSBILEVEL", (Object)pSSysBILevel.getPSSysBILevelId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysBILevelService.exportModelV2(pSSysBILevel, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysBIHierarchy, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBIHierarchy pSSysBIHierarchy, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID")) {
            Object object;
            PSSysBILevel pSSysBILevel2;
            Object object2;
            Object object3;
            Object object4;
            PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysBILevel> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIHIERARCHY#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBILEVEL", (Object)pSSysBIHierarchy.getPSSysBIHierarchyId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysBILevel2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysBILevel2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysBILevel>();
                object4 = pSSysBILevelService.selectByPSSysBIHierarchy(pSSysBIHierarchy);
                object3 = StringHelper.format((String)"PSSYSBIHIERARCHY#%1$s", (Object)pSSysBIHierarchy.getPSSysBIHierarchyId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysBILevel2 = object2.next();
                    object = pSSysBILevelService.getModelV2ResScope((IEntity)pSSysBILevel2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBILevel)PSModelV2Helper.toJSONObject((IEntity)pSSysBILevel2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysBILevelService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
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
                        if (objectNode.has("pssysbilevelname")) {
                            string = objectNode.get("pssysbilevelname").asText();
                        }
                        if (objectNode2.has("pssysbilevelname")) {
                            string2 = objectNode2.get("pssysbilevelname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysBILevel pSSysBILevel2 : arrayList) {
                    object = new PSSysBILevel();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysBILevel2, false);
                    object3.add((JsonNode)pSSysBILevelService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBIHierarchy, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        super.onEmptyModelV2(pSSysBIHierarchy);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBILevelService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBIHierarchy pSSysBIHierarchy, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysBILevel pSSysBILevel = new PSSysBILevel();
        pSSysBILevel.set("PSSYSBIHIERARCHYID", pSSysBIHierarchy.getPSSysBIHierarchyId());
        PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysBILevelService.getModelV2Entity(pSSysBILevel, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBIHierarchy, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBIHierarchy pSSysBIHierarchy, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysBIHierarchyServiceBase.isSimpleImportExportMode("")) {
            PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysBILevelService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysBILevel pSSysBILevel = new PSSysBILevel();
                    pSSysBILevel.setPSDEId(pSSysBIHierarchy.getPSDEId());
                    pSSysBILevel.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
                    pSSysBILevel.setPSSysBIHierarchyName(pSSysBIHierarchy.getPSSysBIHierarchyName());
                    pSSysBILevelService.compileModelV2(pSSysBILevel, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysBILevel pSSysBILevel = new PSSysBILevel();
                        pSSysBILevel.setPSDEId(pSSysBIHierarchy.getPSDEId());
                        pSSysBILevel.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
                        pSSysBILevel.setPSSysBIHierarchyName(pSSysBIHierarchy.getPSSysBIHierarchyName());
                        pSSysBILevelService.compileModelV2(pSSysBILevel, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBIHierarchy, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBIHierarchy pSSysBIHierarchy, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBILevels(pSSysBIHierarchy, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBIHierarchy, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBILevels(PSSysBIHierarchy pSSysBIHierarchy, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBILEVEL", true), (boolean)false) == 0) {
            PSSysBILevelService pSSysBILevelService = (PSSysBILevelService)ServiceGlobal.getService(PSSysBILevelService.class, (SessionFactory)this.getSessionFactory());
            PSSysBILevel pSSysBILevel = new PSSysBILevel();
            pSSysBILevel.setPSSysBILevelId(pSMOSFile.getPSModelId());
            if (!pSSysBILevelService.get((IEntity)pSSysBILevel, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBILevel.getPSSysBIHierarchyId(), (String)pSSysBIHierarchy.getPSSysBIHierarchyId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBILevelService.exportModelV2(pSSysBILevel);
            pSSysBILevel.reset();
            if (!pSSysBILevelService.setModelV2ResScope((IEntity)pSSysBILevel, "PSSYSBIHIERARCHY", pSSysBIHierarchy.getPSSysBIHierarchyId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBILevelService.importModelV2(pSSysBILevel, objectNode);
            SessionFactoryManager.commit();
            return pSSysBILevelService.getFile((IEntity)pSSysBILevel);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBIHierarchy pSSysBIHierarchy, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBILevels(pSSysBIHierarchy, list);
        super.onFillPasteHelps(pSSysBIHierarchy, list);
    }

    protected void onFillPasteHelps_PSSysBILevels(PSSysBIHierarchy pSSysBIHierarchy, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBILEVEL");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBILEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u4f53\u7cfb]\u7684[\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u5c42\u7ea7]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBIHierarchy pSSysBIHierarchy, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Hierarchy");
    }
}

