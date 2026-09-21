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
 *  net.ibizsys.paas.db.SqlParamList
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
import java.util.Iterator;
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
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBIAggTableDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIAggTableDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggColumn;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBISchemeBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIAggTableServiceBase
extends PSCoreSysServiceBase<PSSysBIAggTable> {
    private static final Log log = LogFactory.getLog(PSSysBIAggTableServiceBase.class);
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBIAggTableDEModel pSSysBIAggTableDEModel;
    private PSSysBIAggTableDAO pSSysBIAggTableDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService";
    }

    public PSSysBIAggTableDEModel getPSSysBIAggTableDEModel() {
        if (this.pSSysBIAggTableDEModel == null) {
            try {
                this.pSSysBIAggTableDEModel = (PSSysBIAggTableDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIAggTableDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIAggTableDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBIAggTableDEModel();
    }

    public PSSysBIAggTableDAO getPSSysBIAggTableDAO() {
        if (this.pSSysBIAggTableDAO == null) {
            try {
                this.pSSysBIAggTableDAO = (PSSysBIAggTableDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBIAggTableDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIAggTableDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBIAggTableDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchTempCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBIAggTable pSSysBIAggTable, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGTABLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBIAggTable, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGTABLE_PSDEDATAQUERY_PSDEDATAQUERYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDataQuery(pSSysBIAggTable, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGTABLE_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysBIAggTable, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGTABLE_PSSYSBICUBE_PSSYSBICUBEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory());
            PSSysBICube pSSysBICube = (PSSysBICube)iService.getDEModel().createEntity();
            pSSysBICube.set("PSSYSBICUBEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBICube);
            } else {
                iService.get((IEntity)pSSysBICube);
            }
            this.onFillParentInfo_PSSysBICube(pSSysBIAggTable, pSSysBICube);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBIAGGTABLE_PSSYSBISCHEME_PSSYSBISCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBIScheme pSSysBIScheme = (PSSysBIScheme)iService.getDEModel().createEntity();
            pSSysBIScheme.set("PSSYSBISCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIScheme);
            } else {
                iService.get((IEntity)pSSysBIScheme);
            }
            this.onFillParentInfo_PSSysBIScheme(pSSysBIAggTable, pSSysBIScheme);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBIAggTable, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysBIAggTable pSSysBIAggTable, PSDataEntity pSDataEntity) throws Exception {
        pSSysBIAggTable.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBIAggTable.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDataQuery(PSSysBIAggTable pSSysBIAggTable, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSSysBIAggTable.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
        pSSysBIAggTable.setPSDEDataQueryName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysBIAggTable pSSysBIAggTable, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysBIAggTable.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysBIAggTable.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSSysBICube(PSSysBIAggTable pSSysBIAggTable, PSSysBICube pSSysBICube) throws Exception {
        pSSysBIAggTable.setPSSysBICubeId(pSSysBICube.getPSSysBICubeId());
        pSSysBIAggTable.setPSSysBICubeName(pSSysBICube.getPSSysBICubeName());
    }

    protected void onFillParentInfo_PSSysBIScheme(PSSysBIAggTable pSSysBIAggTable, PSSysBIScheme pSSysBIScheme) throws Exception {
        pSSysBIAggTable.setPSSysBISchemeId(pSSysBIScheme.getPSSysBISchemeId());
        pSSysBIAggTable.setPSSysBISchemeName(pSSysBIScheme.getPSSysBISchemeName());
    }

    protected void onFillEntityFullInfo(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBIAggTable.getCodeName() == null) {
                pSSysBIAggTable.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "AggTable", 25));
            }
            if (pSSysBIAggTable.getPSSysBIAggTableName() == null) {
                pSSysBIAggTable.setPSSysBIAggTableName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u805a\u5408\u6570\u636e", 25));
            }
            if (pSSysBIAggTable.getValidFlag() == null) {
                pSSysBIAggTable.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysBIAggTable, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBIAggTable, bl);
        this.onFillEntityFullInfo_PSDEDataQuery(pSSysBIAggTable, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysBIAggTable, bl);
        this.onFillEntityFullInfo_PSSysBICube(pSSysBIAggTable, bl);
        this.onFillEntityFullInfo_PSSysBIScheme(pSSysBIAggTable, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        if (pSSysBIAggTable.isPSDEIdDirty()) {
            if (pSSysBIAggTable.getPSDEId() != null) {
                if (pSSysBIAggTable.getPSDEId() == null || pSSysBIAggTable.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBIAggTable.getPSDE();
                    pSSysBIAggTable.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBIAggTable.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataQuery(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICube(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIScheme(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBIAggTable, bl);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBIAggTable> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDataQuery(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDEDataQuery(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAQUERYID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataQueryCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataQueryCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggTable> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, "", -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string) throws Exception {
        return this.selectByPSSysBICube(pSSysBICubeBase, string, -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBICube(PSSysBICubeBase pSSysBICubeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEID", (Object)pSSysBICubeBase.getPSSysBICubeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, "", -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string) throws Exception {
        return this.selectByPSSysBIScheme(pSSysBISchemeBase, string, -1);
    }

    public ArrayList<PSSysBIAggTable> selectByPSSysBIScheme(PSSysBISchemeBase pSSysBISchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBISCHEMEID", (Object)pSSysBISchemeBase.getPSSysBISchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBISchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBISchemeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGTABLE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBIAGGTABLE", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            PSSysBIAggTable pSSysBIAggTable2 = (PSSysBIAggTable)this.getDEModel().createEntity();
            pSSysBIAggTable2.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
            pSSysBIAggTable2.setPSDEId(null);
            this.update(pSSysBIAggTable2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggTableServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBIAggTableServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBIAggTableServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            this.remove((IEntity)pSSysBIAggTable);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGTABLE_PSDEDATAQUERY_PSDEDATAQUERYID", "", iDataEntityModel.getName(), "PSSYSBIAGGTABLE", iDataEntityModel.getDataInfo((IEntity)pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            PSSysBIAggTable pSSysBIAggTable2 = (PSSysBIAggTable)this.getDEModel().createEntity();
            pSSysBIAggTable2.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
            pSSysBIAggTable2.setPSDEDataQueryId(null);
            this.update(pSSysBIAggTable2);
        }
    }

    public void removeByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggTableServiceBase.this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSSysBIAggTableServiceBase.this.internalRemoveByPSDEDataQuery(pSDEDataQuery2);
                PSSysBIAggTableServiceBase.this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataQuery(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            this.remove((IEntity)pSSysBIAggTable);
        }
        this.onAfterRemoveByPSDEDataQuery(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataQuery(PSDEDataQuery pSDEDataQuery, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGTABLE_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSBIAGGTABLE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            PSSysBIAggTable pSSysBIAggTable2 = (PSSysBIAggTable)this.getDEModel().createEntity();
            pSSysBIAggTable2.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
            pSSysBIAggTable2.setPSDEDataSetId(null);
            this.update(pSSysBIAggTable2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggTableServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysBIAggTableServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysBIAggTableServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            this.remove((IEntity)pSSysBIAggTable);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    public void resetPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSSysBICube(pSSysBICube);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            PSSysBIAggTable pSSysBIAggTable2 = (PSSysBIAggTable)this.getDEModel().createEntity();
            pSSysBIAggTable2.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
            pSSysBIAggTable2.setPSSysBICubeId(null);
            this.update(pSSysBIAggTable2);
        }
    }

    public void removeByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        final PSSysBICube pSSysBICube2 = pSSysBICube;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggTableServiceBase.this.onBeforeRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIAggTableServiceBase.this.internalRemoveByPSSysBICube(pSSysBICube2);
                PSSysBIAggTableServiceBase.this.onAfterRemoveByPSSysBICube(pSSysBICube2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void internalRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSSysBICube(pSSysBICube);
        this.onBeforeRemoveByPSSysBICube(pSSysBICube, arrayList);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            this.remove((IEntity)pSSysBIAggTable);
        }
        this.onAfterRemoveByPSSysBICube(pSSysBICube, arrayList);
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICube(PSSysBICube pSSysBICube, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBISCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBIAGGTABLE_PSSYSBISCHEME_PSSYSBISCHEMEID", "", iDataEntityModel.getName(), "PSSYSBIAGGTABLE", iDataEntityModel.getDataInfo((IEntity)pSSysBIScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            PSSysBIAggTable pSSysBIAggTable2 = (PSSysBIAggTable)this.getDEModel().createEntity();
            pSSysBIAggTable2.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
            pSSysBIAggTable2.setPSSysBISchemeId(null);
            this.update(pSSysBIAggTable2);
        }
    }

    public void removeByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        final PSSysBIScheme pSSysBIScheme2 = pSSysBIScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBIAggTableServiceBase.this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIAggTableServiceBase.this.internalRemoveByPSSysBIScheme(pSSysBIScheme2);
                PSSysBIAggTableServiceBase.this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
        ArrayList<PSSysBIAggTable> arrayList = this.selectByPSSysBIScheme(pSSysBIScheme);
        this.onBeforeRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
        for (PSSysBIAggTable pSSysBIAggTable : arrayList) {
            this.remove((IEntity)pSSysBIAggTable);
        }
        this.onAfterRemoveByPSSysBIScheme(pSSysBIScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIScheme(PSSysBIScheme pSSysBIScheme, ArrayList<PSSysBIAggTable> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIAggTable(pSSysBIAggTable);
        pSCoreSysServiceBase = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBIAggTable(pSSysBIAggTable);
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).removeByPSSysBIAggTable(pSSysBIAggTable);
        super.onBeforeRemove(pSSysBIAggTable);
    }

    protected void onBeforeRemoveTemp(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        pSSysBIAggColumnService.removeTempByPSSysBIAggTable(pSSysBIAggTable);
        super.onBeforeRemoveTemp((IEntity)pSSysBIAggTable);
    }

    protected void getRelatedDataTempMajor(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        this.getRelatedDataTempMajor_PSSysBIAggColumn(pSSysBIAggTable);
        super.getRelatedDataTempMajor((IEntity)pSSysBIAggTable);
    }

    protected void getRelatedDataTempMajor_PSSysBIAggColumn(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIAggColumn> arrayList = null;
        String string = pSSysBIAggTable.getPSSysBIAggTableId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysBIAggColumnService.selectByPSSysBIAggTable(pSSysBIAggTable) : pSSysBIAggColumnService.selectTempByPSSysBIAggTable(pSSysBIAggTable);
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            pSSysBIAggColumnService.getTempMajor(pSSysBIAggColumn);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysBIAggTable pSSysBIAggTable, PSSysBIAggTable pSSysBIAggTable2) throws Exception {
        ArrayList<PSSysBIAggColumn> arrayList = this.updateRelatedDataTempMajor_removePSSysBIAggColumn(pSSysBIAggTable, pSSysBIAggTable2);
        this.updateRelatedDataTempMajor_updatePSSysBIAggColumn(pSSysBIAggTable, pSSysBIAggTable2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysBIAggTable, (IEntity)pSSysBIAggTable2);
    }

    protected ArrayList<PSSysBIAggColumn> updateRelatedDataTempMajor_removePSSysBIAggColumn(PSSysBIAggTable pSSysBIAggTable, PSSysBIAggTable pSSysBIAggTable2) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIAggColumn> arrayList = pSSysBIAggColumnService.selectTempByPSSysBIAggTable(pSSysBIAggTable);
        ArrayList<PSSysBIAggColumn> arrayList2 = pSSysBIAggColumnService.selectByPSSysBIAggTable(pSSysBIAggTable2);
        HashMap<String, PSSysBIAggColumn> hashMap = new HashMap<String, PSSysBIAggColumn>();
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList2) {
            hashMap.put(pSSysBIAggColumn.getPSSysBIAggColumnId(), pSSysBIAggColumn);
        }
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            Object object = pSSysBIAggColumn.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysBIAggColumn pSSysBIAggColumn : hashMap.values()) {
            pSSysBIAggColumnService.remove((IEntity)pSSysBIAggColumn);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysBIAggColumn(PSSysBIAggTable pSSysBIAggTable, PSSysBIAggTable pSSysBIAggTable2, ArrayList<PSSysBIAggColumn> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            pSSysBIAggColumnService.updateTempMajor(pSSysBIAggColumn);
        }
    }

    protected void replaceParentInfo(PSSysBIAggTable pSSysBIAggTable, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBIAggTable, cloneSession);
        if (pSSysBIAggTable.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBIAggTable.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBIAggTable, (PSDataEntity)iEntity);
        }
        if (pSSysBIAggTable.getPSDEDataQueryId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSSysBIAggTable.getPSDEDataQueryId())) != null) {
            this.onFillParentInfo_PSDEDataQuery(pSSysBIAggTable, (PSDEDataQuery)iEntity);
        }
        if (pSSysBIAggTable.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysBIAggTable.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysBIAggTable, (PSDEDataSet)iEntity);
        }
        if (pSSysBIAggTable.getPSSysBICubeId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBE", (Object)pSSysBIAggTable.getPSSysBICubeId())) != null) {
            this.onFillParentInfo_PSSysBICube(pSSysBIAggTable, (PSSysBICube)iEntity);
        }
        if (pSSysBIAggTable.getPSSysBISchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBISCHEME", (Object)pSSysBIAggTable.getPSSysBISchemeId())) != null) {
            this.onFillParentInfo_PSSysBIScheme(pSSysBIAggTable, (PSSysBIScheme)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBIAggTable, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BIAggTableMode(bl, pSSysBIAggTable, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggTableOption(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggTableParams(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggTableTag(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BIAggTableTag2(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataQueryId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggTableId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIAggTableName(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBISchemeId(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RealTimeMode(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBIAggTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBIAggTable, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BIAggTableMode(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isBIAggTableModeDirty() : !pSSysBIAggTable.isBIAggTableModeDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getBIAggTableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggTableMode_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGTABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggTableOption(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isBIAggTableOptionDirty() : !pSSysBIAggTable.isBIAggTableOptionDirty()) {
            return null;
        }
        Integer n = pSSysBIAggTable.getBIAggTableOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BIAggTableOption_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGTABLEOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggTableParams(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isBIAggTableParamsDirty() : !pSSysBIAggTable.isBIAggTableParamsDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getBIAggTableParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggTableParams_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGTABLEPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggTableTag(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isBIAggTableTagDirty() : !pSSysBIAggTable.isBIAggTableTagDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getBIAggTableTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggTableTag_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGTABLETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BIAggTableTag2(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isBIAggTableTag2Dirty() : !pSSysBIAggTable.isBIAggTableTag2Dirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getBIAggTableTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BIAggTableTag2_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIAGGTABLETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isCodeNameDirty() && !bl2 : !pSSysBIAggTable.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIAggTableDEModel(), "CODENAME", string3, pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isMemoDirty() : !pSSysBIAggTable.isMemoDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataQueryId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSDEDataQueryIdDirty() : !pSSysBIAggTable.isPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSDEDataQueryId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataQueryId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSDEDataSetIdDirty() : !pSSysBIAggTable.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSDEIdDirty() && !bl2 : !pSSysBIAggTable.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSDENameDirty() : !pSSysBIAggTable.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBIAggTableId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSSysBIAggTableIdDirty() && !bl2 : !pSSysBIAggTable.isPSSysBIAggTableIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSSysBIAggTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggTableId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIAggTableName(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSSysBIAggTableNameDirty() && !bl2 : !pSSysBIAggTable.isPSSysBIAggTableNameDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSSysBIAggTableName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIAggTableName_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIAGGTABLENAME");
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
                string3 = "PSSYSBISCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBIAggTableDEModel(), "PSSYSBIAGGTABLENAME", string3, pSSysBIAggTable, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBIAGGTABLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSSysBICubeIdDirty() && !bl2 : !pSSysBIAggTable.isPSSysBICubeIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSSysBICubeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBISchemeId(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isPSSysBISchemeIdDirty() && !bl2 : !pSSysBIAggTable.isPSSysBISchemeIdDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getPSSysBISchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBISchemeId_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBISCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RealTimeMode(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isRealTimeModeDirty() : !pSSysBIAggTable.isRealTimeModeDirty()) {
            return null;
        }
        Integer n = pSSysBIAggTable.getRealTimeMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RealTimeMode_Default((IEntity)pSSysBIAggTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REALTIMEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isUserCatDirty() : !pSSysBIAggTable.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isUserTagDirty() : !pSSysBIAggTable.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isUserTag2Dirty() : !pSSysBIAggTable.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isUserTag3Dirty() : !pSSysBIAggTable.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isUserTag4Dirty() : !pSSysBIAggTable.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBIAggTable.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBIAggTable pSSysBIAggTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBIAggTable.isValidFlagDirty() && !bl2 : !pSSysBIAggTable.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBIAggTable.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBIAggTable, bl2, bl3);
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

    protected void onSyncEntity(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBIAggTable, bl);
    }

    protected void onSyncIndexEntities(PSSysBIAggTable pSSysBIAggTable, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBIAggTable, bl);
    }

    public Object getDataContextValue(PSSysBIAggTable pSSysBIAggTable, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBIAggTable, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBIScheme pSSysBIScheme = pSSysBIAggTable.getPSSysBIScheme();
        if (pSSysBIScheme != null && pSSysBIScheme.contains(string)) {
            return pSSysBIScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBIAggTable pSSysBIAggTable, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBIAggTable, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BIAGGTABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggTableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGTABLEOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggTableOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGTABLEPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggTableParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGTABLETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggTableTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BIAGGTABLETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BIAggTableTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIAGGTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIAggTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBISchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REALTIMEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RealTimeMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BIAggTableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGTABLEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIAggTableOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BIAggTableParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGTABLEPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIAggTableTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGTABLETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BIAggTableTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIAGGTABLETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysBIAggTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIAggTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIAGGTABLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBISchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBISCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RealTimeMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysBIAggTable pSSysBIAggTable) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBIAggTable)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        super.onUpdateParent((IEntity)pSSysBIAggTable);
    }

    protected void onCopyDetails(PSSysBIAggTable pSSysBIAggTable, Object object) throws Exception {
        PSSysBIAggTable pSSysBIAggTable2 = new PSSysBIAggTable();
        pSSysBIAggTable2.set("PSSYSBIAGGTABLEID", object);
        String string = DataObject.getStringValue((Object)pSSysBIAggTable.get("PSSYSBIAGGTABLEID"));
        super.onCopyDetails((IEntity)pSSysBIAggTable, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysBIAggTable pSSysBIAggTable, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBIAGGTABLE");
        if (!bl) {
            pSSysBIAggTable.setCreateDate(null);
            pSSysBIAggTable.setCreateMan(null);
            pSSysBIAggTable.setPSSysBIAggTableId(null);
            pSSysBIAggTable.setUpdateDate(null);
            pSSysBIAggTable.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBIAggTable, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysBIAggTable pSSysBIAggTable, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysBIAggColumn(pSSysBIAggTable, xmlNode);
        super.onExportRelatedXmlModel(pSSysBIAggTable, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysBIAggColumn(PSSysBIAggTable pSSysBIAggTable, XmlNode xmlNode) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIAggColumn> arrayList = null;
        String string = pSSysBIAggTable.getPSSysBIAggTableId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysBIAggColumnService.selectByPSSysBIAggTable(pSSysBIAggTable) : pSSysBIAggColumnService.selectTempByPSSysBIAggTable(pSSysBIAggTable);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSBIAGGCOLUMNS");
            xmlNode.addNode(xmlNode2);
            for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
                pSSysBIAggColumnService.exportXmlModel(pSSysBIAggColumn, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysBIAggTable pSSysBIAggTable, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSBIAGGCOLUMNS");
        this.importRelatedXmlModel_PSSysBIAggColumn(pSSysBIAggTable, xmlNode2);
        super.onImportRelatedXmlModel(pSSysBIAggTable, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysBIAggColumn(PSSysBIAggTable pSSysBIAggTable, XmlNode xmlNode) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysBIAggTable.getPSSysBIAggTableId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysBIAggColumnService.removeByPSSysBIAggTable(pSSysBIAggTable);
        } else {
            pSSysBIAggColumnService.removeTempByPSSysBIAggTable(pSSysBIAggTable);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysBIAggColumn pSSysBIAggColumn = new PSSysBIAggColumn();
                pSSysBIAggColumnService.fillParentInfo((IEntity)pSSysBIAggColumn, "DER1N", "DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", pSSysBIAggTable.getPSSysBIAggTableId());
                pSSysBIAggColumnService.importXmlModel(pSSysBIAggColumn, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBIAggTable pSSysBIAggTable, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBIAggTable, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBISCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBIAGGTABLE_PSSYSBISCHEME_PSSYSBISCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBISCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBISCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBISCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBISCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBIAggTable pSSysBIAggTable) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggTable.getCodeName())) {
            return pSSysBIAggTable.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggTable.getPSSysBIAggTableName())) {
            return pSSysBIAggTable.getPSSysBIAggTableName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBIAggTable.getCodeName())) {
            return pSSysBIAggTable.getCodeName();
        }
        return super.getModelV2Tag(pSSysBIAggTable);
    }

    @Override
    public boolean setModelV2Tag(PSSysBIAggTable pSSysBIAggTable, String string) {
        pSSysBIAggTable.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSBIAGGTABLENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBISCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBIAggTable pSSysBIAggTable, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBIAggTable.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBIAggTable, true);
        pSSysBIAggTable.set("CODENAME", string);
        if (this.select(pSSysBIAggTable, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBIAggTable, true);
        return super.getModelV2Entity(pSSysBIAggTable, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBIAggTable pSSysBIAggTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBIAggTable, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysBIAggTable pSSysBIAggTable, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysBIAggTable, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysBIAggTable pSSysBIAggTable, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID")) {
            Object object;
            PSSysBIAggColumn pSSysBIAggColumn2;
            Object object2;
            Object object3;
            Object object4;
            PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysBIAggColumn> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSBIAGGTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSBIAGGCOLUMN", (Object)pSSysBIAggTable.getPSSysBIAggTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSSysBIAggColumn2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSSysBIAggColumn2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysBIAggColumn>();
                object4 = pSSysBIAggColumnService.selectByPSSysBIAggTable(pSSysBIAggTable);
                object3 = StringHelper.format((String)"PSSYSBIAGGTABLE#%1$s", (Object)pSSysBIAggTable.getPSSysBIAggTableId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSSysBIAggColumn2 = object2.next();
                    object = pSSysBIAggColumnService.getModelV2ResScope((IEntity)pSSysBIAggColumn2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysBIAggColumn)PSModelV2Helper.toJSONObject((IEntity)pSSysBIAggColumn2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysBIAggColumnService.getModelV2Name(false);
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
                        if (objectNode.has("pssysbiaggcolumnname")) {
                            string = objectNode.get("pssysbiaggcolumnname").asText();
                        }
                        if (objectNode2.has("pssysbiaggcolumnname")) {
                            string2 = objectNode2.get("pssysbiaggcolumnname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSSysBIAggColumn pSSysBIAggColumn2 : arrayList) {
                    object = new PSSysBIAggColumn();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSSysBIAggColumn2, false);
                    object3.add((JsonNode)pSSysBIAggColumnService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysBIAggTable, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysBIAggTable pSSysBIAggTable) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysBIAggColumn> arrayList = pSSysBIAggColumnService.selectByPSSysBIAggTable(pSSysBIAggTable);
        String string = StringHelper.format((String)"PSSYSBIAGGTABLE#%1$s", (Object)pSSysBIAggTable.getPSSysBIAggTableId());
        for (PSSysBIAggColumn pSSysBIAggColumn : arrayList) {
            String string2 = pSSysBIAggColumnService.getModelV2ResScope((IEntity)pSSysBIAggColumn);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysBIAggColumnService.emptyModelV2(pSSysBIAggColumn);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysBIAggTable.getPSSysBIAggTableId());
        pSSysBIAggColumnService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysBIAggColumnService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSBIAGGCOLUMN WHERE PSSYSBIAGGTABLEID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysBIAggTable);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysBIAggColumnService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysBIAggTable pSSysBIAggTable, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysBIAggColumn pSSysBIAggColumn = new PSSysBIAggColumn();
        pSSysBIAggColumn.set("PSSYSBIAGGTABLEID", pSSysBIAggTable.getPSSysBIAggTableId());
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysBIAggColumnService.getModelV2Entity(pSSysBIAggColumn, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysBIAggTable, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysBIAggTable pSSysBIAggTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysBIAggColumnService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysBIAggColumn pSSysBIAggColumn = new PSSysBIAggColumn();
                pSSysBIAggColumn.setPSDEId(pSSysBIAggTable.getPSDEId());
                pSSysBIAggColumn.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
                pSSysBIAggColumn.setPSSysBIAggTableName(pSSysBIAggTable.getPSSysBIAggTableName());
                pSSysBIAggColumn.setPSSysBICubeId(pSSysBIAggTable.getPSSysBICubeId());
                pSSysBIAggColumnService.compileModelV2(pSSysBIAggColumn, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysBIAggColumn pSSysBIAggColumn = new PSSysBIAggColumn();
                    pSSysBIAggColumn.setPSDEId(pSSysBIAggTable.getPSDEId());
                    pSSysBIAggColumn.setPSSysBIAggTableId(pSSysBIAggTable.getPSSysBIAggTableId());
                    pSSysBIAggColumn.setPSSysBIAggTableName(pSSysBIAggTable.getPSSysBIAggTableName());
                    pSSysBIAggColumn.setPSSysBICubeId(pSSysBIAggTable.getPSSysBICubeId());
                    pSSysBIAggColumnService.compileModelV2(pSSysBIAggColumn, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysBIAggTable, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysBIAggTable pSSysBIAggTable, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysBIAggColumns(pSSysBIAggTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysBIAggTable, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysBIAggColumns(PSSysBIAggTable pSSysBIAggTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSBIAGGCOLUMN", true), (boolean)false) == 0) {
            PSSysBIAggColumnService pSSysBIAggColumnService = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
            PSSysBIAggColumn pSSysBIAggColumn = new PSSysBIAggColumn();
            pSSysBIAggColumn.setPSSysBIAggColumnId(pSMOSFile.getPSModelId());
            if (!pSSysBIAggColumnService.get((IEntity)pSSysBIAggColumn, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysBIAggColumn.getPSSysBIAggTableId(), (String)pSSysBIAggTable.getPSSysBIAggTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysBIAggColumnService.exportModelV2(pSSysBIAggColumn);
            pSSysBIAggColumn.reset();
            if (!pSSysBIAggColumnService.setModelV2ResScope((IEntity)pSSysBIAggColumn, "PSSYSBIAGGTABLE", pSSysBIAggTable.getPSSysBIAggTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysBIAggColumnService.importModelV2(pSSysBIAggColumn, objectNode);
            SessionFactoryManager.commit();
            return pSSysBIAggColumnService.getFile((IEntity)pSSysBIAggColumn);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysBIAggTable pSSysBIAggTable, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysBIAggColumns(pSSysBIAggTable, list);
        super.onFillPasteHelps(pSSysBIAggTable, list);
    }

    protected void onFillPasteHelps_PSSysBIAggColumns(PSSysBIAggTable pSSysBIAggTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSBIAGGCOLUMN");
        pSHelpSection.setSectionParam2("DER1N_PSSYSBIAGGCOLUMN_PSSYSBIAGGTABLE_PSSYSBIAGGTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e]\u7684[\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e\u5217]");
        list.add(pSHelpSection);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBIAggTable pSSysBIAggTable, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "AggTable");
        defaultValueMap.put("PSSYSBIAGGTABLENAME", "\u805a\u5408\u6570\u636e");
    }
}

