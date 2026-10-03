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
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBTableDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBTableDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBSchemeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBTableServiceBase
extends PSCoreSysServiceBase<PSSysDBTable> {
    private static final Log log = LogFactory.getLog(PSSysDBTableServiceBase.class);
    public static final String DATASET_CURDSLINK = "CurDSLink";
    public static final String DATASET_CURSCHEME = "CurScheme";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_TABLE = "Table";
    public static final String DATASET_VIEW = "View";
    private PSSysDBTableDEModel pSSysDBTableDEModel;
    private PSSysDBTableDAO pSSysDBTableDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService";
    }

    public PSSysDBTableDEModel getPSSysDBTableDEModel() {
        if (this.pSSysDBTableDEModel == null) {
            try {
                this.pSSysDBTableDEModel = (PSSysDBTableDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBTableDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBTableDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBTableDEModel();
    }

    public PSSysDBTableDAO getPSSysDBTableDAO() {
        if (this.pSSysDBTableDAO == null) {
            try {
                this.pSSysDBTableDAO = (PSSysDBTableDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBTableDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBTableDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBTableDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDSLINK, (boolean)true) == 0) {
            return this.fetchCurDSLink(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSCHEME, (boolean)true) == 0) {
            return this.fetchCurScheme(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_TABLE, (boolean)true) == 0) {
            return this.fetchTable(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VIEW, (boolean)true) == 0) {
            return this.fetchView(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDSLink(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDSLINK, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurScheme(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSCHEME, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTable(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_TABLE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VIEW, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDBTable pSSysDBTable, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBTABLE_PSSYSDBSCHEME_PSSYSDBSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = (PSSysDBScheme)iService.getDEModel().createEntity();
            pSSysDBScheme.set("PSSYSDBSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBScheme);
            } else {
                iService.get(pSSysDBScheme);
            }
            this.onFillParentInfo_PSSysDBScheme(pSSysDBTable, pSSysDBScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBTABLE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysDBTable, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysDBTable, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysDBScheme(PSSysDBTable pSSysDBTable, PSSysDBScheme pSSysDBScheme) throws Exception {
        pSSysDBTable.setDSLink(pSSysDBScheme.getDSLink());
        pSSysDBTable.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
        pSSysDBTable.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
        if (pSSysDBScheme.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSSysDBTable, pSSysDBScheme.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSSystem(PSSysDBTable pSSysDBTable, PSSystem pSSystem) throws Exception {
        pSSysDBTable.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDBTable.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        if (bl && pSSysDBTable.getTableType() == null) {
            pSSysDBTable.setTableType((String)this.getDefaultValue(this.getWebContext(), "", "TABLE", 25));
        }
        super.onFillEntityFullInfo(pSSysDBTable, bl);
        this.onFillEntityFullInfo_PSSysDBScheme(pSSysDBTable, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysDBTable, bl);
    }

    protected void onFillEntityFullInfo_PSSysDBScheme(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        if (pSSysDBTable.isPSSystemIdDirty()) {
            if (pSSysDBTable.getPSSystemId() != null) {
                if (pSSysDBTable.getPSSystemId() == null || pSSysDBTable.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysDBTable.getPSSystem();
                    pSSysDBTable.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysDBTable.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDBTable, bl);
    }

    public ArrayList<PSSysDBTable> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, "", -1);
    }

    public ArrayList<PSSysDBTable> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string) throws Exception {
        return this.selectByPSSysDBScheme(pSSysDBSchemeBase, string, -1);
    }

    public ArrayList<PSSysDBTable> selectByPSSysDBScheme(PSSysDBSchemeBase pSSysDBSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBSCHEMEID", (Object)pSSysDBSchemeBase.getPSSysDBSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBTable> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDBTable> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDBTable> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDBScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBTABLE_PSSYSDBSCHEME_PSSYSDBSCHEMEID", "", iDataEntityModel.getName(), "PSSYSDBTABLE", iDataEntityModel.getDataInfo(pSSysDBScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        for (PSSysDBTable pSSysDBTable : arrayList) {
            PSSysDBTable pSSysDBTable2 = (PSSysDBTable)this.getDEModel().createEntity();
            pSSysDBTable2.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
            pSSysDBTable2.setPSSysDBSchemeId(null);
            this.update(pSSysDBTable2);
        }
    }

    public void removeByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        final PSSysDBScheme pSSysDBScheme2 = pSSysDBScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBTableServiceBase.this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysDBTableServiceBase.this.internalRemoveByPSSysDBScheme(pSSysDBScheme2);
                PSSysDBTableServiceBase.this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void internalRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSysDBScheme(pSSysDBScheme);
        this.onBeforeRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
        for (PSSysDBTable pSSysDBTable : arrayList) {
            this.remove(pSSysDBTable);
        }
        this.onAfterRemoveByPSSysDBScheme(pSSysDBScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysDBTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBScheme(PSSysDBScheme pSSysDBScheme, ArrayList<PSSysDBTable> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDBTABLE_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSDBTABLE", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysDBTable pSSysDBTable : arrayList) {
            PSSysDBTable pSSysDBTable2 = (PSSysDBTable)this.getDEModel().createEntity();
            pSSysDBTable2.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
            pSSysDBTable2.setPSSystemId(null);
            this.update(pSSysDBTable2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBTableServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysDBTableServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysDBTableServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDBTable> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysDBTable pSSysDBTable : arrayList) {
            this.remove(pSSysDBTable);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDBTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDBTable> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBTable pSSysDBTable) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBTable(pSSysDBTable);
        pSCoreSysServiceBase = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETableServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBTable(pSSysDBTable);
        pSCoreSysServiceBase = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBTable(pSSysDBTable);
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).removeByPSSysDBTable(pSSysDBTable);
        pSCoreSysServiceBase = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDBTable(pSSysDBTable);
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).resetRefPSSysDBTable(pSSysDBTable);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBTable(pSSysDBTable);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysDBTable(pSSysDBTable);
        super.onBeforeRemove(pSSysDBTable);
    }

    protected void replaceParentInfo(PSSysDBTable pSSysDBTable, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDBTable, cloneSession);
        if (pSSysDBTable.getPSSysDBSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSDBSCHEME", (Object)pSSysDBTable.getPSSysDBSchemeId())) != null) {
            this.onFillParentInfo_PSSysDBScheme(pSSysDBTable, (PSSysDBScheme)iEntity);
        }
        if (pSSysDBTable.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDBTable.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysDBTable, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDBTable, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AutoExtendModel(bl, pSSysDBTable, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DropSql(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExistingModel(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBSchemeId(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableId(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableName(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabDesc(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TableTag(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TableTag2(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TableType(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDBTable, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AutoExtendModel(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isAutoExtendModelDirty() : !pSSysDBTable.isAutoExtendModelDirty()) {
            return null;
        }
        Integer n = pSSysDBTable.getAutoExtendModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoExtendModel_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTOEXTENDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isCodeNameDirty() : !pSSysDBTable.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDBTable.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysDBTable, bl2, bl3);
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBTableDEModel(), "CODENAME", string3, pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isCodeName2Dirty() : !pSSysDBTable.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSysDBTable.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBTableDEModel(), "CODENAME2", string3, pSSysDBTable, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isCreateSqlDirty() : !pSSysDBTable.isCreateSqlDirty()) {
            return null;
        }
        String string = pSSysDBTable.getCreateSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DropSql(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isDropSqlDirty() : !pSSysDBTable.isDropSqlDirty()) {
            return null;
        }
        String string = pSSysDBTable.getDropSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DropSql_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DROPSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExistingModel(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isExistingModelDirty() : !pSSysDBTable.isExistingModelDirty()) {
            return null;
        }
        Integer n = pSSysDBTable.getExistingModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExistingModel_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXISTINGMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isLogicNameDirty() : !pSSysDBTable.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDBTable.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isMemoDirty() : !pSSysDBTable.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBTable.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBSchemeId(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isPSSysDBSchemeIdDirty() && !bl2 : !pSSysDBTable.isPSSysDBSchemeIdDirty()) {
            return null;
        }
        String string = pSSysDBTable.getPSSysDBSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBSchemeId_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableId(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isPSSysDBTableIdDirty() && !bl2 : !pSSysDBTable.isPSSysDBTableIdDirty()) {
            return null;
        }
        String string = pSSysDBTable.getPSSysDBTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableId_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableName(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isPSSysDBTableNameDirty() && !bl2 : !pSSysDBTable.isPSSysDBTableNameDirty()) {
            return null;
        }
        String string = pSSysDBTable.getPSSysDBTableName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableName_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLENAME");
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
                string3 = "PSSYSDBSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBTableDEModel(), "PSSYSDBTABLENAME", string3, pSSysDBTable, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBTABLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isPSSystemIdDirty() : !pSSysDBTable.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDBTable.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isPSSystemNameDirty() : !pSSysDBTable.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysDBTable.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_TabDesc(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isTabDescDirty() : !pSSysDBTable.isTabDescDirty()) {
            return null;
        }
        String string = pSSysDBTable.getTabDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TabDesc_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TableTag(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isTableTagDirty() : !pSSysDBTable.isTableTagDirty()) {
            return null;
        }
        String string = pSSysDBTable.getTableTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TableTag_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TableTag2(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isTableTag2Dirty() : !pSSysDBTable.isTableTag2Dirty()) {
            return null;
        }
        String string = pSSysDBTable.getTableTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TableTag2_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TableType(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isTableTypeDirty() && !bl2 : !pSSysDBTable.isTableTypeDirty()) {
            return null;
        }
        String string = pSSysDBTable.getTableType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TableType_Default(pSSysDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isUserCatDirty() : !pSSysDBTable.isUserCatDirty()) {
            return null;
        }
        String string = pSSysDBTable.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isUserTagDirty() : !pSSysDBTable.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDBTable.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isUserTag2Dirty() : !pSSysDBTable.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDBTable.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isUserTag3Dirty() : !pSSysDBTable.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysDBTable.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysDBTable pSSysDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBTable.isUserTag4Dirty() : !pSSysDBTable.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysDBTable.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysDBTable, bl2, bl3);
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

    protected void onSyncEntity(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDBTable, bl);
    }

    protected void onSyncIndexEntities(PSSysDBTable pSSysDBTable, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDBTable, bl);
    }

    public Object getDataContextValue(PSSysDBTable pSSysDBTable, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDBTable, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysDBScheme pSSysDBScheme = pSSysDBTable.getPSSysDBScheme();
        if (pSSysDBScheme != null && pSSysDBScheme.contains(string)) {
            return pSSysDBScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBTable pSSysDBTable, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDBTable, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AUTOEXTENDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoExtendModel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CREATESQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DROPSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DropSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSLINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DSLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXISTINGMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExistingModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TableType_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AutoExtendModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CreateSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DropSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DROPSQL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DSLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSLINK", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExistingModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PSSysDBSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBTABLENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_TabDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABDESC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TableTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TableTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TableType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDBTable pSSysDBTable) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDBTable)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBTable pSSysDBTable) throws Exception {
        super.onUpdateParent(pSSysDBTable);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBTable pSSysDBTable, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBTABLE");
        if (!bl) {
            pSSysDBTable.setCreateDate(null);
            pSSysDBTable.setCreateMan(null);
            pSSysDBTable.setPSSysDBTableId(null);
            pSSysDBTable.setUpdateDate(null);
            pSSysDBTable.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDBTable, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBTable pSSysDBTable, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBTable, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBTABLE_PSSYSDBSCHEME_PSSYSDBSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSDBSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDBSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBTable pSSysDBTable) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDBTable.getPSSysDBTableName())) {
            return pSSysDBTable.getPSSysDBTableName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBTable.getPSSysDBTableName())) {
            return pSSysDBTable.getPSSysDBTableName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBTable.getCodeName())) {
            return pSSysDBTable.getCodeName();
        }
        return super.getModelV2Tag(pSSysDBTable);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBTable pSSysDBTable, String string) {
        pSSysDBTable.setPSSysDBTableName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBTABLENAME", "");
        map.put("PSSYSDBTABLENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSDBSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBTable pSSysDBTable, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBTable.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBTable, true);
        pSSysDBTable.set("PSSYSDBTABLENAME", string);
        if (this.select(pSSysDBTable, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDBTable, true);
        return super.getModelV2Entity(pSSysDBTable, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBTable pSSysDBTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDBTable, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysDBTable pSSysDBTable, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDBTABLE#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSDBCOLUMN", (Object)pSSysDBTable.getPSSysDBTableId()))).exists()) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysDBColumnService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysDBColumn, objectNode, false);
                String string6 = pSSysDBColumnService.getModelV2Tag(pSSysDBColumn);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSDBCOLUMN", (Object)pSSysDBColumn.getPSSysDBColumnId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysDBColumnService.exportModelV2(pSSysDBColumn, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysDBTable, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysDBTable pSSysDBTable, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID")) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSDBTABLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSDBCOLUMN", (Object)pSSysDBTable.getPSSysDBTableId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSDBTABLE#%1$s", (Object)pSSysDBTable.getPSSysDBTableId());
                for (PSSysDBColumn column : pSSysDBColumnService.selectByPSSysDBTable(pSSysDBTable)) {
                    String columnScope = pSSysDBColumnService.getModelV2ResScope(column);
                    if (StringHelper.compare((String)scope, (String)columnScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(column, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSSysDBColumnService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("pssysdbcolumnname")) {
                            string = objectNode.get("pssysdbcolumnname").asText();
                        }
                        if (objectNode2.has("pssysdbcolumnname")) {
                            string2 = objectNode2.get("pssysdbcolumnname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode columnNode : arrayList) {
                    PSSysDBColumn column = new PSSysDBColumn();
                    PSModelV2Helper.fromJSONObject((IDataObject)column, columnNode, false);
                    output.add((JsonNode)pSSysDBColumnService.exportModelV2(column, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysDBTable, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysDBTable pSSysDBTable) throws Exception {
        super.onEmptyModelV2(pSSysDBTable);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysDBColumnService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysDBTable pSSysDBTable, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
        pSSysDBColumn.set("PSSYSDBTABLEID", pSSysDBTable.getPSSysDBTableId());
        PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysDBColumnService.getModelV2Entity(pSSysDBColumn, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysDBTable, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysDBTable pSSysDBTable, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSSysDBTableServiceBase.isSimpleImportExportMode("")) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysDBColumnService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                    pSSysDBColumn.setPSSysDBSchemeId(pSSysDBTable.getPSSysDBSchemeId());
                    pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                    pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                    pSSysDBColumnService.compileModelV2(pSSysDBColumn, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
                        pSSysDBColumn.setPSSysDBSchemeId(pSSysDBTable.getPSSysDBSchemeId());
                        pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                        pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                        pSSysDBColumnService.compileModelV2(pSSysDBColumn, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysDBTable, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysDBTable pSSysDBTable, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysDBColumns(pSSysDBTable, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysDBTable, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysDBColumns(PSSysDBTable pSSysDBTable, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSDBCOLUMN", true), (boolean)false) == 0) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBColumn pSSysDBColumn = new PSSysDBColumn();
            pSSysDBColumn.setPSSysDBColumnId(pSMOSFile.getPSModelId());
            if (!pSSysDBColumnService.get(pSSysDBColumn, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysDBColumn.getPSSysDBTableId(), (String)pSSysDBTable.getPSSysDBTableId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysDBColumnService.exportModelV2(pSSysDBColumn);
            pSSysDBColumn.reset();
            if (!pSSysDBColumnService.setModelV2ResScope(pSSysDBColumn, "PSSYSDBTABLE", pSSysDBTable.getPSSysDBTableId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysDBColumnService.importModelV2(pSSysDBColumn, objectNode);
            SessionFactoryManager.commit();
            return pSSysDBColumnService.getFile(pSSysDBColumn);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysDBTable pSSysDBTable, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysDBColumns(pSSysDBTable, list);
        super.onFillPasteHelps(pSSysDBTable, list);
    }

    protected void onFillPasteHelps_PSSysDBColumns(PSSysDBTable pSSysDBTable, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSDBCOLUMN");
        pSHelpSection.setSectionParam2("DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u6570\u636e\u5e93\u8868]\u7684[\u6570\u636e\u5e93\u5217]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u6570\u636e\u5217>", "DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", "PSSYSDBTABLEID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSSysDBTableServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6570\u636e\u5217>");
            } else if (PSSysDBTableServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssysdbcolumns");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID|PSSYSDBTABLEID");
            pSMOSFile2.setFileTag3("PSSYSDBCOLUMN");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", "PSSYSDBTABLEID", pSMOSFile.getPSModelId(), "", "")) {
                PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysDBColumnService, "DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", "PSSYSDBTABLEID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSSysDBColumnService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysDBTableServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSSysDBTableServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u6570\u636e\u5217>", (boolean)false) == 0 || PSSysDBTableServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysDBColumns", (boolean)true) == 0) {
            PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSSysDBColumnService, "DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", "PSSYSDBTABLEID", pSMOSFile.getPSModelId(), "", "");
            ArrayList<PSSysDBColumn> arrayList2 = pSSysDBColumnService.selectEx((ISelectContext)selectContext);
            for (PSSysDBColumn pSSysDBColumn : arrayList2) {
                PSMOSFile pSMOSFile2 = pSSysDBColumnService.getFile(pSMOSFile, pSSysDBColumn, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", (boolean)false) == 0) {
            if (PSSysDBTableServiceBase.getMOSVer() == 1) {
                return "<\u6570\u636e\u5217>";
            }
            if (PSSysDBTableServiceBase.getMOSVer() == 2) {
                return "pssysdbcolumns";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }
}

