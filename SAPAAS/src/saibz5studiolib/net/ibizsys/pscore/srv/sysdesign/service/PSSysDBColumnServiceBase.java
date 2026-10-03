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
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBColumnDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBColumnDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTableBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBColumnServiceBase
extends PSCoreSysServiceBase<PSSysDBColumn> {
    private static final Log log = LogFactory.getLog(PSSysDBColumnServiceBase.class);
    public static final String DATASET_CURTABLE = "CurTable";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDBColumnDEModel pSSysDBColumnDEModel;
    private PSSysDBColumnDAO pSSysDBColumnDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService";
    }

    public PSSysDBColumnDEModel getPSSysDBColumnDEModel() {
        if (this.pSSysDBColumnDEModel == null) {
            try {
                this.pSSysDBColumnDEModel = (PSSysDBColumnDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBColumnDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBColumnDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDBColumnDEModel();
    }

    public PSSysDBColumnDAO getPSSysDBColumnDAO() {
        if (this.pSSysDBColumnDAO == null) {
            try {
                this.pSSysDBColumnDAO = (PSSysDBColumnDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDBColumnDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBColumnDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDBColumnDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURTABLE, (boolean)true) == 0) {
            return this.fetchCurTable(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurTable(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTABLE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDBColumn pSSysDBColumn, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBCOLUMN_PSSYSDBCOLUMN_REFPSSYSDBCOLUMNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService", (SessionFactory)this.getSessionFactory());
            PSSysDBColumn pSSysDBColumn2 = (PSSysDBColumn)iService.getDEModel().createEntity();
            pSSysDBColumn2.set("PSSYSDBCOLUMNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBColumn2);
            } else {
                iService.get(pSSysDBColumn2);
            }
            this.onFillParentInfo_RefPSSysDBColumn(pSSysDBColumn, pSSysDBColumn2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService", (SessionFactory)this.getSessionFactory());
            PSSysDBTable pSSysDBTable = (PSSysDBTable)iService.getDEModel().createEntity();
            pSSysDBTable.set("PSSYSDBTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBTable);
            } else {
                iService.get(pSSysDBTable);
            }
            this.onFillParentInfo_PSSysDBTable(pSSysDBColumn, pSSysDBTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_REFPSSYSDBTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService", (SessionFactory)this.getSessionFactory());
            PSSysDBTable pSSysDBTable = (PSSysDBTable)iService.getDEModel().createEntity();
            pSSysDBTable.set("PSSYSDBTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBTable);
            } else {
                iService.get(pSSysDBTable);
            }
            this.onFillParentInfo_RefPSSysDBTable(pSSysDBColumn, pSSysDBTable);
            return;
        }
        super.onFillParentInfo(pSSysDBColumn, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_RefPSSysDBColumn(PSSysDBColumn pSSysDBColumn, PSSysDBColumn pSSysDBColumn2) throws Exception {
        pSSysDBColumn.setRefPSSysDBColumnId(pSSysDBColumn2.getPSSysDBColumnId());
        pSSysDBColumn.setRefPSSysDBColumnName(pSSysDBColumn2.getPSSysDBColumnName());
    }

    protected void onFillParentInfo_PSSysDBTable(PSSysDBColumn pSSysDBColumn, PSSysDBTable pSSysDBTable) throws Exception {
        pSSysDBColumn.setPSSysDBSchemeId(pSSysDBTable.getPSSysDBSchemeId());
        pSSysDBColumn.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
        pSSysDBColumn.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
    }

    protected void onFillParentInfo_RefPSSysDBTable(PSSysDBColumn pSSysDBColumn, PSSysDBTable pSSysDBTable) throws Exception {
        pSSysDBColumn.setRefPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
        pSSysDBColumn.setRefPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
    }

    protected void onFillEntityFullInfo(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
        if (bl) {
            if (pSSysDBColumn.getAllowEmpty() == null) {
                pSSysDBColumn.setAllowEmpty((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSSysDBColumn.getFKey() == null) {
                pSSysDBColumn.setFKey((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysDBColumn.getPKey() == null) {
                pSSysDBColumn.setPKey((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysDBColumn, bl);
        this.onFillEntityFullInfo_RefPSSysDBColumn(pSSysDBColumn, bl);
        this.onFillEntityFullInfo_PSSysDBTable(pSSysDBColumn, bl);
        this.onFillEntityFullInfo_RefPSSysDBTable(pSSysDBColumn, bl);
    }

    protected void onFillEntityFullInfo_RefPSSysDBColumn(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBTable(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysDBTable(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDBColumn, bl);
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase) throws Exception {
        return this.selectByRefPSSysDBColumn(pSSysDBColumnBase, "", -1);
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase, String string) throws Exception {
        return this.selectByRefPSSysDBColumn(pSSysDBColumnBase, string, -1);
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBColumn(PSSysDBColumnBase pSSysDBColumnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSDBCOLUMNID", (Object)pSSysDBColumnBase.getPSSysDBColumnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysDBColumnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysDBColumnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBColumn> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, "", -1);
    }

    public ArrayList<PSSysDBColumn> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string) throws Exception {
        return this.selectByPSSysDBTable(pSSysDBTableBase, string, -1);
    }

    public ArrayList<PSSysDBColumn> selectByPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBTABLEID", (Object)pSSysDBTableBase.getPSSysDBTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBTable(PSSysDBTableBase pSSysDBTableBase) throws Exception {
        return this.selectByRefPSSysDBTable(pSSysDBTableBase, "", -1);
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string) throws Exception {
        return this.selectByRefPSSysDBTable(pSSysDBTableBase, string, -1);
    }

    public ArrayList<PSSysDBColumn> selectByRefPSSysDBTable(PSSysDBTableBase pSSysDBTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSDBTABLEID", (Object)pSSysDBTableBase.getPSSysDBTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysDBTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysDBTableCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    public void resetRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByRefPSSysDBColumn(pSSysDBColumn);
        for (PSSysDBColumn pSSysDBColumn2 : arrayList) {
            PSSysDBColumn pSSysDBColumn3 = (PSSysDBColumn)this.getDEModel().createEntity();
            pSSysDBColumn3.setPSSysDBColumnId(pSSysDBColumn2.getPSSysDBColumnId());
            pSSysDBColumn3.setRefPSSysDBColumnId(null);
            this.update(pSSysDBColumn3);
        }
    }

    public void removeByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        final PSSysDBColumn pSSysDBColumn2 = pSSysDBColumn;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBColumnServiceBase.this.onBeforeRemoveByRefPSSysDBColumn(pSSysDBColumn2);
                PSSysDBColumnServiceBase.this.internalRemoveByRefPSSysDBColumn(pSSysDBColumn2);
                PSSysDBColumnServiceBase.this.onAfterRemoveByRefPSSysDBColumn(pSSysDBColumn2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    protected void internalRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByRefPSSysDBColumn(pSSysDBColumn);
        this.onBeforeRemoveByRefPSSysDBColumn(pSSysDBColumn, arrayList);
        for (PSSysDBColumn pSSysDBColumn2 : arrayList) {
            this.remove(pSSysDBColumn2);
        }
        this.onAfterRemoveByRefPSSysDBColumn(pSSysDBColumn, arrayList);
    }

    protected void onAfterRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysDBColumn(PSSysDBColumn pSSysDBColumn, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    public void resetPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        for (PSSysDBColumn pSSysDBColumn : arrayList) {
            PSSysDBColumn pSSysDBColumn2 = (PSSysDBColumn)this.getDEModel().createEntity();
            pSSysDBColumn2.setPSSysDBColumnId(pSSysDBColumn.getPSSysDBColumnId());
            pSSysDBColumn2.setPSSysDBTableId(null);
            this.update(pSSysDBColumn2);
        }
    }

    public void removeByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        final PSSysDBTable pSSysDBTable2 = pSSysDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBColumnServiceBase.this.onBeforeRemoveByPSSysDBTable(pSSysDBTable2);
                PSSysDBColumnServiceBase.this.internalRemoveByPSSysDBTable(pSSysDBTable2);
                PSSysDBColumnServiceBase.this.onAfterRemoveByPSSysDBTable(pSSysDBTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void internalRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByPSSysDBTable(pSSysDBTable);
        this.onBeforeRemoveByPSSysDBTable(pSSysDBTable, arrayList);
        for (PSSysDBColumn pSSysDBColumn : arrayList) {
            this.remove(pSSysDBColumn);
        }
        this.onAfterRemoveByPSSysDBTable(pSSysDBTable, arrayList);
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    public void resetRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByRefPSSysDBTable(pSSysDBTable);
        for (PSSysDBColumn pSSysDBColumn : arrayList) {
            PSSysDBColumn pSSysDBColumn2 = (PSSysDBColumn)this.getDEModel().createEntity();
            pSSysDBColumn2.setPSSysDBColumnId(pSSysDBColumn.getPSSysDBColumnId());
            pSSysDBColumn2.setRefPSSysDBTableId(null);
            this.update(pSSysDBColumn2);
        }
    }

    public void removeByRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        final PSSysDBTable pSSysDBTable2 = pSSysDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDBColumnServiceBase.this.onBeforeRemoveByRefPSSysDBTable(pSSysDBTable2);
                PSSysDBColumnServiceBase.this.internalRemoveByRefPSSysDBTable(pSSysDBTable2);
                PSSysDBColumnServiceBase.this.onAfterRemoveByRefPSSysDBTable(pSSysDBTable2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void internalRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
        ArrayList<PSSysDBColumn> arrayList = this.selectByRefPSSysDBTable(pSSysDBTable);
        this.onBeforeRemoveByRefPSSysDBTable(pSSysDBTable, arrayList);
        for (PSSysDBColumn pSSysDBColumn : arrayList) {
            this.remove(pSSysDBColumn);
        }
        this.onAfterRemoveByRefPSSysDBTable(pSSysDBTable, arrayList);
    }

    protected void onAfterRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysDBTable(PSSysDBTable pSSysDBTable, ArrayList<PSSysDBColumn> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDBColumn pSSysDBColumn) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysDBColumn(pSSysDBColumn);
        ((PSDEFieldServiceBase)pSCoreSysServiceBase).resetPSSysDBColumn(pSSysDBColumn);
        pSCoreSysServiceBase = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).testRemoveByRefPSSysDBColumn(pSSysDBColumn);
        ((PSSysDBColumnServiceBase)pSCoreSysServiceBase).resetRefPSSysDBColumn(pSSysDBColumn);
        super.onBeforeRemove(pSSysDBColumn);
    }

    protected void replaceParentInfo(PSSysDBColumn pSSysDBColumn, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDBColumn, cloneSession);
        if (pSSysDBColumn.getRefPSSysDBColumnId() != null && (iEntity = cloneSession.getEntity("PSSYSDBCOLUMN", (Object)pSSysDBColumn.getRefPSSysDBColumnId())) != null) {
            this.onFillParentInfo_RefPSSysDBColumn(pSSysDBColumn, (PSSysDBColumn)iEntity);
        }
        if (pSSysDBColumn.getPSSysDBTableId() != null && (iEntity = cloneSession.getEntity("PSSYSDBTABLE", (Object)pSSysDBColumn.getPSSysDBTableId())) != null) {
            this.onFillParentInfo_PSSysDBTable(pSSysDBColumn, (PSSysDBTable)iEntity);
        }
        if (pSSysDBColumn.getRefPSSysDBTableId() != null && (iEntity = cloneSession.getEntity("PSSYSDBTABLE", (Object)pSSysDBColumn.getRefPSSysDBTableId())) != null) {
            this.onFillParentInfo_RefPSSysDBTable(pSSysDBColumn, (PSSysDBTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDBColumn, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSSysDBColumn, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColDesc(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColumnTag(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColumnTag2(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataType(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataTypes(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DropSql(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FKey(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IdentityMode(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Length(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKey(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBColumnId(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBColumnName(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBTableId(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysDBColumnId(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysDBTableId(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StdDataType(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnsignedMode(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysDBColumn, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDBColumn, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isAllowEmptyDirty() : !pSSysDBColumn.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isCodeNameDirty() : !pSSysDBColumn.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysDBColumn, bl2, bl3);
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
                string3 = "PSSYSDBTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBColumnDEModel(), "CODENAME", string3, pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isCodeName2Dirty() : !pSSysDBColumn.isCodeName2Dirty()) {
            return null;
        }
        String string = pSSysDBColumn.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSSysDBColumn, bl2, bl3);
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
                string3 = "PSSYSDBTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBColumnDEModel(), "CODENAME2", string3, pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColDesc(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isColDescDirty() : !pSSysDBColumn.isColDescDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getColDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColDesc_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColumnTag(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isColumnTagDirty() : !pSSysDBColumn.isColumnTagDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getColumnTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColumnTag_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLUMNTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColumnTag2(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isColumnTag2Dirty() : !pSSysDBColumn.isColumnTag2Dirty()) {
            return null;
        }
        String string = pSSysDBColumn.getColumnTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColumnTag2_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLUMNTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isCreateSqlDirty() : !pSSysDBColumn.isCreateSqlDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getCreateSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataType(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isDataTypeDirty() : !pSSysDBColumn.isDataTypeDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataType_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataTypes(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isDataTypesDirty() : !pSSysDBColumn.isDataTypesDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getDataTypes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataTypes_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isDefaultValueDirty() : !pSSysDBColumn.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_DropSql(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isDropSqlDirty() : !pSSysDBColumn.isDropSqlDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getDropSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DropSql_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_FKey(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isFKeyDirty() : !pSSysDBColumn.isFKeyDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getFKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FKey_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IdentityMode(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isIdentityModeDirty() : !pSSysDBColumn.isIdentityModeDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getIdentityMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IdentityMode_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IDENTITYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSDBTABLEID";
                String string2 = this.checkFieldDupRule(this.getPSSysDBColumnDEModel(), "IDENTITYMODE", string, pSSysDBColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("IDENTITYMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Length(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isLengthDirty() : !pSSysDBColumn.isLengthDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Length_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isLogicNameDirty() : !pSSysDBColumn.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isMemoDirty() : !pSSysDBColumn.isMemoDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isOrderValueDirty() : !pSSysDBColumn.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PKey(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isPKeyDirty() : !pSSysDBColumn.isPKeyDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getPKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PKey_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isPrecision2Dirty() : !pSSysDBColumn.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDBColumnId(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isPSSysDBColumnIdDirty() && !bl2 : !pSSysDBColumn.isPSSysDBColumnIdDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getPSSysDBColumnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBCOLUMNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBColumnId_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBCOLUMNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBColumnName(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isPSSysDBColumnNameDirty() && !bl2 : !pSSysDBColumn.isPSSysDBColumnNameDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getPSSysDBColumnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBCOLUMNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBColumnName_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBCOLUMNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSDBTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysDBColumnDEModel(), "PSSYSDBCOLUMNNAME", string3, pSSysDBColumn, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSDBCOLUMNNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBTableId(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isPSSysDBTableIdDirty() && !bl2 : !pSSysDBColumn.isPSSysDBTableIdDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getPSSysDBTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBTableId_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSSysDBColumnId(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isRefPSSysDBColumnIdDirty() : !pSSysDBColumn.isRefPSSysDBColumnIdDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getRefPSSysDBColumnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysDBColumnId_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSDBCOLUMNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysDBTableId(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isRefPSSysDBTableIdDirty() : !pSSysDBColumn.isRefPSSysDBTableIdDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getRefPSSysDBTableId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysDBTableId_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSDBTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StdDataType(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isStdDataTypeDirty() : !pSSysDBColumn.isStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StdDataType_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UnsignedMode(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUnsignedModeDirty() : !pSSysDBColumn.isUnsignedModeDirty()) {
            return null;
        }
        Integer n = pSSysDBColumn.getUnsignedMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnsignedMode_Default(pSSysDBColumn, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNSIGNEDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUserCatDirty() : !pSSysDBColumn.isUserCatDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUserTagDirty() : !pSSysDBColumn.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDBColumn.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUserTag2Dirty() : !pSSysDBColumn.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDBColumn.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUserTag3Dirty() : !pSSysDBColumn.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysDBColumn.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysDBColumn, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysDBColumn pSSysDBColumn, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDBColumn.isUserTag4Dirty() : !pSSysDBColumn.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysDBColumn.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysDBColumn, bl2, bl3);
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

    protected void onSyncEntity(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDBColumn, bl);
    }

    protected void onSyncIndexEntities(PSSysDBColumn pSSysDBColumn, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDBColumn, bl);
    }

    public Object getDataContextValue(PSSysDBColumn pSSysDBColumn, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSDBCOLUMN", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSSYSDBTABLEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSSYSDBCOLUMNID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSSYSDBCOLUMNNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSSysDBColumn, "refpssysdbtableid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue(pSSysDBColumn, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSSysDBTable pSSysDBTable = pSSysDBColumn.getPSSysDBTable();
        if (pSSysDBTable != null && pSSysDBTable.contains(string)) {
            return pSSysDBTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDBColumn pSSysDBColumn, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDBColumn, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLUMNTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColumnTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLUMNTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColumnTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATATYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataTypes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DROPSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DropSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IDENTITYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IdentityMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Length_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBCOLUMNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBColumnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBCOLUMNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBColumnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDBCOLUMNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDBColumnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDBCOLUMNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDBColumnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNSIGNEDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnsignedMode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLDESC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColumnTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLUMNTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColumnTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLUMNTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_CreateSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATATYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_FKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IdentityMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Length_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysDBColumnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBCOLUMNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBColumnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBCOLUMNNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("PSSYSDBCOLUMNNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_RefPSSysDBColumnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDBCOLUMNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDBColumnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDBCOLUMNNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDBTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDBTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysDBTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSDBTABLENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected String onTestValueRule_UnsignedMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDBColumn pSSysDBColumn) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDBColumn)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDBColumn pSSysDBColumn) throws Exception {
        super.onUpdateParent(pSSysDBColumn);
    }

    @Override
    protected void exportCurXmlModel(PSSysDBColumn pSSysDBColumn, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDBCOLUMN");
        if (!bl) {
            pSSysDBColumn.setCreateDate(null);
            pSSysDBColumn.setCreateMan(null);
            pSSysDBColumn.setPSSysDBColumnId(null);
            pSSysDBColumn.setUpdateDate(null);
            pSSysDBColumn.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDBColumn, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDBColumn pSSysDBColumn, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDBColumn, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSDBTABLE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDBCOLUMN_PSSYSDBTABLE_PSSYSDBTABLEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBTABLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSDBTABLENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSDBTABLE", (boolean)true) == 0) {
            iEntity.set("PSSYSDBTABLEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSDBTABLEID"};
    }

    @Override
    public String getModelV2Tag(PSSysDBColumn pSSysDBColumn) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDBColumn.getPSSysDBColumnName())) {
            return pSSysDBColumn.getPSSysDBColumnName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBColumn.getPSSysDBColumnName())) {
            return pSSysDBColumn.getPSSysDBColumnName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysDBColumn.getCodeName())) {
            return pSSysDBColumn.getCodeName();
        }
        return super.getModelV2Tag(pSSysDBColumn);
    }

    @Override
    public boolean setModelV2Tag(PSSysDBColumn pSSysDBColumn, String string) {
        pSSysDBColumn.setPSSysDBColumnName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDBCOLUMNNAME", "");
        map.put("PSSYSDBCOLUMNNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSDBTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDBColumn pSSysDBColumn, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDBColumn.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDBColumn, true);
        pSSysDBColumn.set("PSSYSDBCOLUMNNAME", string);
        if (this.select(pSSysDBColumn, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDBColumn, true);
        return super.getModelV2Entity(pSSysDBColumn, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDBColumn pSSysDBColumn, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDBColumn, objectNode, string, string2, n);
    }
}

