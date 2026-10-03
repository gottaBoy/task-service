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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDEDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSetBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableDEServiceBase
extends PSCoreSysServiceBase<PSSysBDTableDE> {
    private static final Log log = LogFactory.getLog(PSSysBDTableDEServiceBase.class);
    public static final String DATASET_CURBDT = "CurBDT";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDTableDEDEModel pSSysBDTableDEDEModel;
    private PSSysBDTableDEDAO pSSysBDTableDEDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService";
    }

    public PSSysBDTableDEDEModel getPSSysBDTableDEDEModel() {
        if (this.pSSysBDTableDEDEModel == null) {
            try {
                this.pSSysBDTableDEDEModel = (PSSysBDTableDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDEDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDTableDEDEModel();
    }

    public PSSysBDTableDEDAO getPSSysBDTableDEDAO() {
        if (this.pSSysBDTableDEDAO == null) {
            try {
                this.pSSysBDTableDEDAO = (PSSysBDTableDEDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDEDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDEDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDTableDEDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURBDT, (boolean)true) == 0) {
            return this.fetchCurBDT(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurBDT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURBDT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysBDTableDE pSSysBDTableDE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysBDTableDE, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDE_PSSYSBDCOLSET_PSSYSBDCOLSETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService", (SessionFactory)this.getSessionFactory());
            PSSysBDColSet pSSysBDColSet = (PSSysBDColSet)iService.getDEModel().createEntity();
            pSSysBDColSet.set("PSSYSBDCOLSETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDColSet);
            } else {
                iService.get(pSSysBDColSet);
            }
            this.onFillParentInfo_PSSysBDColSet(pSSysBDTableDE, pSSysBDColSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSSysBDTableDE, pSSysBDTable);
            return;
        }
        super.onFillParentInfo(pSSysBDTableDE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysBDTableDE pSSysBDTableDE, PSDataEntity pSDataEntity) throws Exception {
        pSSysBDTableDE.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysBDTableDE.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysBDColSet(PSSysBDTableDE pSSysBDTableDE, PSSysBDColSet pSSysBDColSet) throws Exception {
        pSSysBDTableDE.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
        pSSysBDTableDE.setPSSysBDColSetName(pSSysBDColSet.getPSSysBDColSetName());
    }

    protected void onFillParentInfo_PSSysBDTable(PSSysBDTableDE pSSysBDTableDE, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDTableDE.setPSSysBDSchemeId(pSSysBDTable.getPSSysBDSchemeId());
        pSSysBDTableDE.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDTableDE.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected boolean onFillEntityKeyValue(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDTableDE.get("PSSYSBDTABLEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDTableDE.get("PSDEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSSysBDTableDE.get("DEFAULTFLAG");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSSysBDTableDE.set(this.getPSSysBDTableDEDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBDTableDE.getAddColMode() == null) {
                pSSysBDTableDE.setAddColMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysBDTableDE.getDefaultFlag() == null) {
                pSSysBDTableDE.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysBDTableDE, bl);
        this.onFillEntityFullInfo_PSDE(pSSysBDTableDE, bl);
        this.onFillEntityFullInfo_PSSysBDColSet(pSSysBDTableDE, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSSysBDTableDE, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        if (pSSysBDTableDE.isPSDEIdDirty()) {
            if (pSSysBDTableDE.getPSDEId() != null) {
                if (pSSysBDTableDE.getPSDEId() == null || pSSysBDTableDE.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysBDTableDE.getPSDE();
                    pSSysBDTableDE.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysBDTableDE.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBDColSet(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDTableDE, bl);
    }

    public ArrayList<PSSysBDTableDE> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDTableDE> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase) throws Exception {
        return this.selectByPSSysBDColSet(pSSysBDColSetBase, "", -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase, String string) throws Exception {
        return this.selectByPSSysBDColSet(pSSysBDColSetBase, string, -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSSysBDColSet(PSSysBDColSetBase pSSysBDColSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDTableDE> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDTableDE> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
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
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLEDE_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSBDTABLEDE", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            PSSysBDTableDE pSSysBDTableDE2 = (PSSysBDTableDE)this.getDEModel().createEntity();
            pSSysBDTableDE2.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
            pSSysBDTableDE2.setPSDEId(null);
            this.update(pSSysBDTableDE2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableDEServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysBDTableDEServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysBDTableDEServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            this.remove(pSSysBDTableDE);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDCOLSET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBDColSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLEDE_PSSYSBDCOLSET_PSSYSBDCOLSETID", "", iDataEntityModel.getName(), "PSSYSBDTABLEDE", iDataEntityModel.getDataInfo(pSSysBDColSet), arrayList.get(0)));
        }
    }

    public void resetPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            PSSysBDTableDE pSSysBDTableDE2 = (PSSysBDTableDE)this.getDEModel().createEntity();
            pSSysBDTableDE2.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
            pSSysBDTableDE2.setPSSysBDColSetId(null);
            this.update(pSSysBDTableDE2);
        }
    }

    public void removeByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        final PSSysBDColSet pSSysBDColSet2 = pSSysBDColSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableDEServiceBase.this.onBeforeRemoveByPSSysBDColSet(pSSysBDColSet2);
                PSSysBDTableDEServiceBase.this.internalRemoveByPSSysBDColSet(pSSysBDColSet2);
                PSSysBDTableDEServiceBase.this.onAfterRemoveByPSSysBDColSet(pSSysBDColSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
    }

    protected void internalRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSSysBDColSet(pSSysBDColSet);
        this.onBeforeRemoveByPSSysBDColSet(pSSysBDColSet, arrayList);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            this.remove(pSSysBDTableDE);
        }
        this.onAfterRemoveByPSSysBDColSet(pSSysBDColSet, arrayList);
    }

    protected void onAfterRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDColSet(PSSysBDColSet pSSysBDColSet, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            PSSysBDTableDE pSSysBDTableDE2 = (PSSysBDTableDE)this.getDEModel().createEntity();
            pSSysBDTableDE2.setPSSysBDTableDEId(pSSysBDTableDE.getPSSysBDTableDEId());
            pSSysBDTableDE2.setPSSysBDTableId(null);
            this.update(pSSysBDTableDE2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableDEServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDTableDEServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDTableDEServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableDE> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDTableDE pSSysBDTableDE : arrayList) {
            this.remove(pSSysBDTableDE);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableDE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        PSSysBDColumnService pSSysBDColumnService = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        pSSysBDColumnService.testRemoveByPSSysBDTableDE(pSSysBDTableDE);
        super.onBeforeRemove(pSSysBDTableDE);
    }

    protected void replaceParentInfo(PSSysBDTableDE pSSysBDTableDE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDTableDE, cloneSession);
        if (pSSysBDTableDE.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysBDTableDE.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysBDTableDE, (PSDataEntity)iEntity);
        }
        if (pSSysBDTableDE.getPSSysBDColSetId() != null && (iEntity = cloneSession.getEntity("PSSYSBDCOLSET", (Object)pSSysBDTableDE.getPSSysBDColSetId())) != null) {
            this.onFillParentInfo_PSSysBDColSet(pSSysBDTableDE, (PSSysBDColSet)iEntity);
        }
        if (pSSysBDTableDE.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDTableDE.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSSysBDTableDE, (PSSysBDTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDTableDE, bl);
        pSSysBDTableDE.resetDefaultFlag();
    }

    protected void onCheckEntity(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AddColMode(bl, pSSysBDTableDE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColFilter(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColSetId(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDEId(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDEName(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowKeyFormat(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowKeyParams(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDTableDE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDTableDE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AddColMode(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isAddColModeDirty() && !bl2 : !pSSysBDTableDE.isAddColModeDirty()) {
            return null;
        }
        Integer n = pSSysBDTableDE.getAddColMode();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDCOLMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_AddColMode_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDCOLMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColFilter(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isColFilterDirty() : !pSSysBDTableDE.isColFilterDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getColFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColFilter_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isDefaultFlagDirty() && !bl2 : !pSSysBDTableDE.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDTableDE.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"2") == 0L || DataTypeHelper.compare((int)9, (Object)n, (Object)"3") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSBDTABLEID";
                String string2 = this.checkFieldDupRule(this.getPSSysBDTableDEDEModel(), "DEFAULTFLAG", string, pSSysBDTableDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isLockFlagDirty() : !pSSysBDTableDE.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDTableDE.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isMemoDirty() : !pSSysBDTableDE.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSDEIdDirty() && !bl2 : !pSSysBDTableDE.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSDENameDirty() && !bl2 : !pSSysBDTableDE.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDTABLEDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableDEDEModel(), "PSDENAME", string3, pSSysBDTableDE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDColSetId(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSSysBDColSetIdDirty() && !bl2 : !pSSysBDTableDE.isPSSysBDColSetIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSSysBDColSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColSetId_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDTableDEId(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSSysBDTableDEIdDirty() && !bl2 : !pSSysBDTableDE.isPSSysBDTableDEIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSSysBDTableDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableDEId_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDTableDEName(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSSysBDTableDENameDirty() && !bl2 : !pSSysBDTableDE.isPSSysBDTableDENameDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSSysBDTableDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableDEName_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isPSSysBDTableIdDirty() && !bl2 : !pSSysBDTableDE.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_RowKeyFormat(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isRowKeyFormatDirty() : !pSSysBDTableDE.isRowKeyFormatDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getRowKeyFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RowKeyFormat_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWKEYFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RowKeyParams(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isRowKeyParamsDirty() : !pSSysBDTableDE.isRowKeyParamsDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getRowKeyParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RowKeyParams_Default(pSSysBDTableDE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWKEYPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isUserCatDirty() : !pSSysBDTableDE.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isUserTagDirty() : !pSSysBDTableDE.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isUserTag2Dirty() : !pSSysBDTableDE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isUserTag3Dirty() : !pSSysBDTableDE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBDTableDE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDTableDE pSSysBDTableDE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDE.isUserTag4Dirty() : !pSSysBDTableDE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDTableDE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBDTableDE, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDTableDE, bl);
    }

    protected void onSyncIndexEntities(PSSysBDTableDE pSSysBDTableDE, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDTableDE, bl);
    }

    public Object getDataContextValue(PSSysBDTableDE pSSysBDTableDE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDTableDE, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSSysBDTableDE.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSysBDTable pSSysBDTable = pSSysBDTableDE.getPSSysBDTable();
        if (pSSysBDTable != null && pSSysBDTable.contains(string)) {
            return pSSysBDTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDTableDE pSSysBDTableDE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDTableDE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADDCOLMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AddColMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ROWKEYFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowKeyFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROWKEYPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowKeyParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AddColMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLFILTER", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_RowKeyFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROWKEYFORMAT", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RowKeyParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROWKEYPARAMS", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysBDTableDE pSSysBDTableDE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBDTableDE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDTableDE pSSysBDTableDE) throws Exception {
        Object object = pSSysBDTableDE.get("PSSYSBDTABLEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID", object);
        }
        super.onUpdateParent(pSSysBDTableDE);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDTableDE pSSysBDTableDE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDTABLEDE");
        if (!bl) {
            pSSysBDTableDE.setCreateDate(null);
            pSSysBDTableDE.setCreateMan(null);
            pSSysBDTableDE.setPSSysBDTableDEId(null);
            pSSysBDTableDE.setUpdateDate(null);
            pSSysBDTableDE.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDTableDE, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDTableDE pSSysBDTableDE, PSSystem pSSystem) throws Exception {
        PSSysBDTableDE pSSysBDTableDE2 = new PSSysBDTableDE();
        pSSysBDTableDE2.setPSSysBDTableId(pSSysBDTableDE.getPSSysBDTableId());
        pSSysBDTableDE2.setPSDEId(pSSysBDTableDE.getPSDEId());
        pSSysBDTableDE2.setDefaultFlag(pSSysBDTableDE.getDefaultFlag());
        if (this.selectOne(pSSysBDTableDE2, true)) {
            return pSSysBDTableDE2.getPSSysBDTableDEId();
        }
        return super.getEntityFolderKeyValue(pSSysBDTableDE, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDTableDE pSSysBDTableDE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDTableDE, string);
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
            return "DER1N_PSSYSBDTABLEDE_PSSYSBDTABLE_PSSYSBDTABLEID";
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
    public String getModelV2Tag(PSSysBDTableDE pSSysBDTableDE) {
        return super.getModelV2Tag(pSSysBDTableDE);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDTableDE pSSysBDTableDE, String string) {
        return super.setModelV2Tag(pSSysBDTableDE, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDTableDE pSSysBDTableDE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDTableDE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDTableDE, true);
        return super.getModelV2Entity(pSSysBDTableDE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDTableDE pSSysBDTableDE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDTableDE, objectNode, string, string2, n);
    }
}

