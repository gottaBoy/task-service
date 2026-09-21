/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDELogicModel
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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.bdscheme.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDColumnDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColumnDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSetBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColumn;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDEBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDColumnServiceBase
extends PSCoreSysServiceBase<PSSysBDColumn> {
    private static final Log log = LogFactory.getLog(PSSysBDColumnServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCPSDE_FI = "CALCPSDE_FI";
    private PSSysBDColumnDEModel pSSysBDColumnDEModel;
    private PSSysBDColumnDAO pSSysBDColumnDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService";
    }

    public PSSysBDColumnDEModel getPSSysBDColumnDEModel() {
        if (this.pSSysBDColumnDEModel == null) {
            try {
                this.pSSysBDColumnDEModel = (PSSysBDColumnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColumnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDColumnDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDColumnDEModel();
    }

    public PSSysBDColumnDAO getPSSysBDColumnDAO() {
        if (this.pSSysBDColumnDAO == null) {
            try {
                this.pSSysBDColumnDAO = (PSSysBDColumnDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDColumnDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDColumnDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDColumnDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCPSDE_FI, (boolean)true) == 0) {
            this.calcPSDE_FI((PSSysBDColumn)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcPSDE_FI(PSSysBDColumn pSSysBDColumn) throws Exception {
        final PSSysBDColumn pSSysBDColumn2 = pSSysBDColumn;
        pSSysBDColumn2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction((IEntity)pSSysBDColumn, ACTION_CALCPSDE_FI);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSSysBDColumnDEModel().getDELogic("CalcPSDE");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSSysBDColumn2);
                actionContext.setSessionFactory(PSSysBDColumnServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSSysBDColumn pSSysBDColumn, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBDColumn, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBDColumn, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDCOLSET_PSSYSBDCOLSETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService", (SessionFactory)this.getSessionFactory());
            PSSysBDColSet pSSysBDColSet = (PSSysBDColSet)iService.getDEModel().createEntity();
            pSSysBDColSet.set("PSSYSBDCOLSETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDColSet);
            } else {
                iService.get((IEntity)pSSysBDColSet);
            }
            this.onFillParentInfo_PSSysBDColSet(pSSysBDColumn, pSSysBDColSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLEDE_PSSYSBDTABLEDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService", (SessionFactory)this.getSessionFactory());
            PSSysBDTableDE pSSysBDTableDE = (PSSysBDTableDE)iService.getDEModel().createEntity();
            pSSysBDTableDE.set("PSSYSBDTABLEDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDTableDE);
            } else {
                iService.get((IEntity)pSSysBDTableDE);
            }
            this.onFillParentInfo_PSSysBDTableDE(pSSysBDColumn, pSSysBDTableDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBDTable);
            } else {
                iService.get((IEntity)pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSSysBDColumn, pSSysBDTable);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBDColumn, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysBDColumn pSSysBDColumn, PSDataEntity pSDataEntity) throws Exception {
        pSSysBDColumn.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBDColumn.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEF(PSSysBDColumn pSSysBDColumn, PSDEField pSDEField) throws Exception {
        pSSysBDColumn.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBDColumn.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysBDColSet(PSSysBDColumn pSSysBDColumn, PSSysBDColSet pSSysBDColSet) throws Exception {
        pSSysBDColumn.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
        pSSysBDColumn.setPSSysBDColSetName(pSSysBDColSet.getPSSysBDColSetName());
    }

    protected void onFillParentInfo_PSSysBDTableDE(PSSysBDColumn pSSysBDColumn, PSSysBDTableDE pSSysBDTableDE) throws Exception {
        pSSysBDColumn.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
        pSSysBDColumn.setPSSysBDTableDEName(pSSysBDTableDE.getPSSysBDTableDEName());
    }

    protected void onFillParentInfo_PSSysBDTable(PSSysBDColumn pSSysBDColumn, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDColumn.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDColumn.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected boolean onFillEntityKeyValue(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDColumn.get("PSSYSBDTABLEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDColumn.get("PSSYSBDTABLEDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSSysBDColumn.get("PSSYSBDCOLUMNNAME");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSSysBDColumn.set(this.getPSSysBDColumnDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysBDColumn, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBDColumn, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBDColumn, bl);
        this.onFillEntityFullInfo_PSSysBDColSet(pSSysBDColumn, bl);
        this.onFillEntityFullInfo_PSSysBDTableDE(pSSysBDColumn, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSSysBDColumn, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        if (pSSysBDColumn.isPSDEIdDirty()) {
            if (pSSysBDColumn.getPSDEId() != null) {
                if (pSSysBDColumn.getPSDEId() == null || pSSysBDColumn.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBDColumn.getPSDE();
                    pSSysBDColumn.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBDColumn.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        if (pSSysBDColumn.isPSDEFIdDirty()) {
            if (pSSysBDColumn.getPSDEFId() != null) {
                if (pSSysBDColumn.getPSDEFId() == null || pSSysBDColumn.getPSDEFName() == null) {
                    PSDEField pSDEField = pSSysBDColumn.getPSDEF();
                    pSSysBDColumn.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysBDColumn.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBDColSet(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDTableDE(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        if (pSSysBDColumn.isPSSysBDTableIdDirty()) {
            if (pSSysBDColumn.getPSSysBDTableId() != null) {
                if (pSSysBDColumn.getPSSysBDTableId() == null || pSSysBDColumn.getPSSysBDTableName() == null) {
                    PSSysBDTable pSSysBDTable = pSSysBDColumn.getPSSysBDTable();
                    pSSysBDColumn.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
                }
            } else {
                pSSysBDColumn.setPSSysBDTableName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBDColumn, bl);
    }

    public ArrayList<PSSysBDColumn> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDColumn> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase) throws Exception {
        return this.selectByPSSysBDColSet(pSSysBDColSetBase, "", -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase, String string) throws Exception {
        return this.selectByPSSysBDColSet(pSSysBDColSetBase, string, -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDCOLSETID", (Object)pSSysBDColSetBase.getPSSysBDColSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDColSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDColSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTableDE(PSSysBDTableDEBase pSSysBDTableDEBase) throws Exception {
        return this.selectByPSSysBDTableDE(pSSysBDTableDEBase, "", -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTableDE(PSSysBDTableDEBase pSSysBDTableDEBase, String string) throws Exception {
        return this.selectByPSSysBDTableDE(pSSysBDTableDEBase, string, -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTableDE(PSSysBDTableDEBase pSSysBDTableDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDTABLEDEID", (Object)pSSysBDTableDEBase.getPSSysBDTableDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDTableDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDTableDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDColumn> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDTABLEID", (Object)pSSysBDTableBase.getPSSysBDTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDTableCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDCOLUMN_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBDCOLUMN", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            PSSysBDColumn pSSysBDColumn2 = (PSSysBDColumn)this.getDEModel().createEntity();
            pSSysBDColumn2.setPSSysBDColumnId(pSSysBDColumn.getPSSysBDColumnId());
            pSSysBDColumn2.setPSDEId(null);
            this.update(pSSysBDColumn2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColumnServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBDColumnServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBDColumnServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            this.remove((IEntity)pSSysBDColumn);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDCOLUMN_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBDCOLUMN", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            PSSysBDColumn pSSysBDColumn2 = (PSSysBDColumn)this.getDEModel().createEntity();
            pSSysBDColumn2.setPSSysBDColumnId(pSSysBDColumn.getPSSysBDColumnId());
            pSSysBDColumn2.setPSDEFId(null);
            this.update(pSSysBDColumn2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColumnServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBDColumnServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBDColumnServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            this.remove((IEntity)pSSysBDColumn);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDCOLSET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDColSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDCOLUMN_PSSYSBDCOLSET_PSSYSBDCOLSETID", "", iDataEntityModel.getName(), "PSSYSBDCOLUMN", iDataEntityModel.getDataInfo((IEntity)pSSysBDColSet), arrayList.get(0)));
        }
    }

    public void resetPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            PSSysBDColumn pSSysBDColumn2 = (PSSysBDColumn)this.getDEModel().createEntity();
            pSSysBDColumn2.setPSSysBDColumnId(pSSysBDColumn.getPSSysBDColumnId());
            pSSysBDColumn2.setPSSysBDColSetId(null);
            this.update(pSSysBDColumn2);
        }
    }

    public void removeByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        final PSSysBDColSet pSSysBDColSet2 = pSSysBDColSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColumnServiceBase.this.onBeforeRemoveByPSSysBDColSet(pSSysBDColSet2);
                PSSysBDColumnServiceBase.this.internalRemoveByPSSysBDColSet(pSSysBDColSet2);
                PSSysBDColumnServiceBase.this.onAfterRemoveByPSSysBDColSet(pSSysBDColSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
    }

    protected void internalRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet);
        this.onBeforeRemoveByPSSysBDColSet(pSSysBDColSet, arrayList);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            this.remove((IEntity)pSSysBDColumn);
        }
        this.onAfterRemoveByPSSysBDColSet(pSSysBDColSet, arrayList);
    }

    protected void onAfterRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDTableDE(pSSysBDTableDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDTABLEDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBDTableDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDCOLUMN_PSSYSBDTABLEDE_PSSYSBDTABLEDEID", "", iDataEntityModel.getName(), "PSSYSBDCOLUMN", iDataEntityModel.getDataInfo((IEntity)pSSysBDTableDE), arrayList.get(0)));
        }
    }

    public void resetPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDTableDE(pSSysBDTableDE);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            PSSysBDColumn pSSysBDColumn2 = (PSSysBDColumn)this.getDEModel().createEntity();
            pSSysBDColumn2.setPSSysBDColumnId(pSSysBDColumn.getPSSysBDColumnId());
            pSSysBDColumn2.setPSSysBDTableDEId(null);
            this.update(pSSysBDColumn2);
        }
    }

    public void removeByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        final PSSysBDTableDE pSSysBDTableDE2 = pSSysBDTableDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColumnServiceBase.this.onBeforeRemoveByPSSysBDTableDE(pSSysBDTableDE2);
                PSSysBDColumnServiceBase.this.internalRemoveByPSSysBDTableDE(pSSysBDTableDE2);
                PSSysBDColumnServiceBase.this.onAfterRemoveByPSSysBDTableDE(pSSysBDTableDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
    }

    protected void internalRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDTableDE(pSSysBDTableDE);
        this.onBeforeRemoveByPSSysBDTableDE(pSSysBDTableDE, arrayList);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            this.remove((IEntity)pSSysBDColumn);
        }
        this.onAfterRemoveByPSSysBDTableDE(pSSysBDTableDE, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTableDE(PSSysBDTableDE pSSysBDTableDE, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            PSSysBDColumn pSSysBDColumn2 = (PSSysBDColumn)this.getDEModel().createEntity();
            pSSysBDColumn2.setPSSysBDColumnId(pSSysBDColumn.getPSSysBDColumnId());
            pSSysBDColumn2.setPSSysBDTableId(null);
            this.update(pSSysBDColumn2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColumnServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDColumnServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDColumnServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDColumn> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDColumn pSSysBDColumn : arrayList) {
            this.remove((IEntity)pSSysBDColumn);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDColumn> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDColumn pSSysBDColumn) throws Exception {
        super.onBeforeRemove(pSSysBDColumn);
    }

    protected void replaceParentInfo(PSSysBDColumn pSSysBDColumn, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBDColumn, cloneSession);
        if (pSSysBDColumn.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBDColumn.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBDColumn, (PSDataEntity)iEntity);
        }
        if (pSSysBDColumn.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBDColumn.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBDColumn, (PSDEField)iEntity);
        }
        if (pSSysBDColumn.getPSSysBDColSetId() != null && (iEntity = cloneSession.getEntity("PSSYSBDCOLSET", (Object)pSSysBDColumn.getPSSysBDColSetId())) != null) {
            this.onFillParentInfo_PSSysBDColSet(pSSysBDColumn, (PSSysBDColSet)iEntity);
        }
        if (pSSysBDColumn.getPSSysBDTableDEId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLEDE", (Object)pSSysBDColumn.getPSSysBDTableDEId())) != null) {
            this.onFillParentInfo_PSSysBDTableDE(pSSysBDColumn, (PSSysBDTableDE)iEntity);
        }
        if (pSSysBDColumn.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDColumn.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSSysBDColumn, (PSSysBDTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBDColumn, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysBDColumn, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullColName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColSetId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColumnId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColumnName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDEId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableName(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnionKeyValue(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBDColumn, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isCodeNameDirty() : !pSSysBDColumn.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBDColumn, bl2, bl3);
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
                string3 = "PSSYSBDCOLSETID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDColumnDEModel(), "CODENAME", string3, pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullColName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isFullColNameDirty() : !pSSysBDColumn.isFullColNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getFullColName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullColName_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCOLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDColumnDEModel(), "FULLCOLNAME", string3, pSSysBDColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("FULLCOLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isLogicNameDirty() : !pSSysBDColumn.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isMemoDirty() : !pSSysBDColumn.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSDEFIdDirty() && !bl2 : !pSSysBDColumn.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_PSDEF((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSDEFNameDirty() && !bl2 : !pSSysBDColumn.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSDEIdDirty() && !bl2 : !pSSysBDColumn.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSDENameDirty() && !bl2 : !pSSysBDColumn.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDColSetId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDColSetIdDirty() && !bl2 : !pSSysBDColumn.isPSSysBDColSetIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDColSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColSetId_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDColumnId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDColumnIdDirty() && !bl2 : !pSSysBDColumn.isPSSysBDColumnIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDColumnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLUMNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColumnId_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLUMNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDColumnName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDColumnNameDirty() && !bl2 : !pSSysBDColumn.isPSSysBDColumnNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDColumnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLUMNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColumnName_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLUMNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableDEId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDTableDEIdDirty() && !bl2 : !pSSysBDColumn.isPSSysBDTableDEIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDTableDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableDEId_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDTableIdDirty() && !bl2 : !pSSysBDColumn.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableName(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isPSSysBDTableNameDirty() && !bl2 : !pSSysBDColumn.isPSSysBDTableNameDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getPSSysBDTableName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableName_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnionKeyValue(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUnionKeyValueDirty() : !pSSysBDColumn.isUnionKeyValueDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUnionKeyValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UnionKeyValue_Default((IEntity)pSSysBDColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNIONKEYVALUE");
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
                string3 = "PSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDColumnDEModel(), "UNIONKEYVALUE", string3, pSSysBDColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("UNIONKEYVALUE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUserCatDirty() : !pSSysBDColumn.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUserTagDirty() : !pSSysBDColumn.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUserTag2Dirty() : !pSSysBDColumn.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUserTag3Dirty() : !pSSysBDColumn.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDColumn pSSysBDColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColumn.isUserTag4Dirty() : !pSSysBDColumn.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDColumn.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBDColumn, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBDColumn, bl);
    }

    protected void onSyncIndexEntities(PSSysBDColumn pSSysBDColumn, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBDColumn, bl);
    }

    public Object getDataContextValue(PSSysBDColumn pSSysBDColumn, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBDColumn, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDTable pSSysBDTable = pSSysBDColumn.getPSSysBDTable();
        if (pSSysBDTable != null && pSSysBDTable.contains(string)) {
            return pSSysBDTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDColumn pSSysBDColumn, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBDColumn, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"FULLCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEF", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_PSDEF(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLSETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLSETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLUMNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColumnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLUMNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColumnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNIONKEYVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnionKeyValue_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_FullColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCOLNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("FULLCOLNAME", iEntity, bl2, "[A-Za-z]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEFId_PSDEF(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEFID", "PSDEFIELD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u5c5e\u6027\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSSysBDColSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDCOLSETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDColSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDCOLSETNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDColumnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDCOLUMNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDColumnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDCOLUMNNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSSYSBDCOLUMNNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnionKeyValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UNIONKEYVALUE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected boolean onMergeChild(String string, String string2, PSSysBDColumn pSSysBDColumn) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBDColumn)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDColumn pSSysBDColumn) throws Exception {
        Object object = pSSysBDColumn.get("PSSYSBDTABLEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID", object);
        }
        super.onUpdateParent((IEntity)pSSysBDColumn);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDColumn pSSysBDColumn, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDCOLUMN");
        if (!bl) {
            pSSysBDColumn.setCreateDate(null);
            pSSysBDColumn.setCreateMan(null);
            pSSysBDColumn.setFullColName(null);
            pSSysBDColumn.setPSSysBDColumnId(null);
            pSSysBDColumn.setUnionKeyValue(null);
            pSSysBDColumn.setUpdateDate(null);
            pSSysBDColumn.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDColumn, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDColumn pSSysBDColumn, PSSystem pSSystem) throws Exception {
        PSSysBDColumn pSSysBDColumn2 = new PSSysBDColumn();
        pSSysBDColumn2.setPSSysBDTableId(pSSysBDColumn.getPSSysBDTableId());
        pSSysBDColumn2.setPSSysBDTableDEId(pSSysBDColumn.getPSSysBDTableDEId());
        pSSysBDColumn2.setPSSysBDColumnName(pSSysBDColumn.getPSSysBDColumnName());
        if (this.selectOne((IEntity)pSSysBDColumn2, true)) {
            return pSSysBDColumn2.getPSSysBDColumnId();
        }
        return super.getEntityFolderKeyValue(pSSysBDColumn, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDColumn pSSysBDColumn, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDColumn, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBDTABLE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDCOLUMN_PSSYSBDTABLE_PSSYSBDTABLEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDTABLENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLE", (boolean)true) == 0) {
            iEntity.set("PSSYSBDTABLEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBDTABLEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBDColumn pSSysBDColumn) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDColumn.getPSSysBDColumnName())) {
            return pSSysBDColumn.getPSSysBDColumnName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBDColumn.getCodeName())) {
            return pSSysBDColumn.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDColumn);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDColumn pSSysBDColumn, String string) {
        pSSysBDColumn.setPSSysBDColumnName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDCOLUMNNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBDTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDColumn pSSysBDColumn, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDColumn.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDColumn, true);
        pSSysBDColumn.set("PSSYSBDCOLUMNNAME", string);
        if (this.select(pSSysBDColumn, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDColumn, true);
        return super.getModelV2Entity(pSSysBDColumn, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDColumn pSSysBDColumn, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysBDColumn, objectNode, string, string2, n);
    }
}

