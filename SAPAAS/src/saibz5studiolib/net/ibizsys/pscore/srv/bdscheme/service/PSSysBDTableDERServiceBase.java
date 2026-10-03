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
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDERDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDERDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDER;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableDERServiceBase
extends PSCoreSysServiceBase<PSSysBDTableDER> {
    private static final Log log = LogFactory.getLog(PSSysBDTableDERServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDTableDERDEModel pSSysBDTableDERDEModel;
    private PSSysBDTableDERDAO pSSysBDTableDERDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDERService";
    }

    public PSSysBDTableDERDEModel getPSSysBDTableDERDEModel() {
        if (this.pSSysBDTableDERDEModel == null) {
            try {
                this.pSSysBDTableDERDEModel = (PSSysBDTableDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDERDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDTableDERDEModel();
    }

    public PSSysBDTableDERDAO getPSSysBDTableDERDAO() {
        if (this.pSSysBDTableDERDAO == null) {
            try {
                this.pSSysBDTableDERDAO = (PSSysBDTableDERDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableDERDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableDERDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDTableDERDAO();
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

    protected void onFillParentInfo(PSSysBDTableDER pSSysBDTableDER, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDER_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysBDTableDER, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSSysBDTableDER, pSSysBDTable);
            return;
        }
        super.onFillParentInfo(pSSysBDTableDER, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDER(PSSysBDTableDER pSSysBDTableDER, PSDER pSDER) throws Exception {
        pSSysBDTableDER.setPSDERId(pSDER.getPSDERId());
        pSSysBDTableDER.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysBDTable(PSSysBDTableDER pSSysBDTableDER, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDTableDER.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDTableDER.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected boolean onFillEntityKeyValue(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDTableDER.get("PSSYSBDTABLEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDTableDER.get("PSDERID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysBDTableDER.set(this.getPSSysBDTableDERDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysBDTableDER, bl);
        this.onFillEntityFullInfo_PSDER(pSSysBDTableDER, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSSysBDTableDER, bl);
    }

    protected void onFillEntityFullInfo_PSDER(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDTableDER, bl);
    }

    public ArrayList<PSSysBDTableDER> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysBDTableDER> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysBDTableDER> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTableDER> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDTableDER> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDTableDER> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableDER> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLEDER_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSBDTABLEDER", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableDER> arrayList = this.selectByPSDER(pSDER);
        for (PSSysBDTableDER pSSysBDTableDER : arrayList) {
            PSSysBDTableDER pSSysBDTableDER2 = (PSSysBDTableDER)this.getDEModel().createEntity();
            pSSysBDTableDER2.setPSSysBDTableDERId(pSSysBDTableDER.getPSSysBDTableDERId());
            pSSysBDTableDER2.setPSDERId(null);
            this.update(pSSysBDTableDER2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableDERServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysBDTableDERServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysBDTableDERServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableDER> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysBDTableDER pSSysBDTableDER : arrayList) {
            this.remove(pSSysBDTableDER);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTableDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTableDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableDER> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSSysBDTableDER pSSysBDTableDER : arrayList) {
            PSSysBDTableDER pSSysBDTableDER2 = (PSSysBDTableDER)this.getDEModel().createEntity();
            pSSysBDTableDER2.setPSSysBDTableDERId(pSSysBDTableDER.getPSSysBDTableDERId());
            pSSysBDTableDER2.setPSSysBDTableId(null);
            this.update(pSSysBDTableDER2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableDERServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDTableDERServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDTableDERServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableDER> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDTableDER pSSysBDTableDER : arrayList) {
            this.remove(pSSysBDTableDER);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableDER> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDTableDER pSSysBDTableDER) throws Exception {
        super.onBeforeRemove(pSSysBDTableDER);
    }

    protected void replaceParentInfo(PSSysBDTableDER pSSysBDTableDER, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDTableDER, cloneSession);
        if (pSSysBDTableDER.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysBDTableDER.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysBDTableDER, (PSDER)iEntity);
        }
        if (pSSysBDTableDER.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDTableDER.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSSysBDTableDER, (PSSysBDTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDTableDER, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DERLevel(bl, pSSysBDTableDER, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDERId(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableDERName(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDTableDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDTableDER, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DERLevel(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isDERLevelDirty() && !bl2 : !pSSysBDTableDER.isDERLevelDirty()) {
            return null;
        }
        Integer n = pSSysBDTableDER.getDERLevel();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERLEVEL");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DERLevel_Default(pSSysBDTableDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isMemoDirty() : !pSSysBDTableDER.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isPSDERIdDirty() && !bl2 : !pSSysBDTableDER.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getPSDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysBDTableDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableDERId(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isPSSysBDTableDERIdDirty() && !bl2 : !pSSysBDTableDER.isPSSysBDTableDERIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getPSSysBDTableDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableDERId_Default(pSSysBDTableDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableDERName(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isPSSysBDTableDERNameDirty() && !bl2 : !pSSysBDTableDER.isPSSysBDTableDERNameDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getPSSysBDTableDERName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableDERName_Default(pSSysBDTableDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableDERDEModel(), "PSSYSBDTABLEDERNAME", string3, pSSysBDTableDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBDTABLEDERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isPSSysBDTableIdDirty() && !bl2 : !pSSysBDTableDER.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isUserCatDirty() : !pSSysBDTableDER.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isUserTagDirty() : !pSSysBDTableDER.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isUserTag2Dirty() : !pSSysBDTableDER.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isUserTag3Dirty() : !pSSysBDTableDER.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBDTableDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDTableDER pSSysBDTableDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableDER.isUserTag4Dirty() : !pSSysBDTableDER.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDTableDER.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBDTableDER, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDTableDER, bl);
    }

    protected void onSyncIndexEntities(PSSysBDTableDER pSSysBDTableDER, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDTableDER, bl);
    }

    public Object getDataContextValue(PSSysBDTableDER pSSysBDTableDER, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDTableDER, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDTable pSSysBDTable = pSSysBDTableDER.getPSSysBDTable();
        if (pSSysBDTable != null && pSSysBDTable.contains(string)) {
            return pSSysBDTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDTableDER pSSysBDTableDER, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDTableDER, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DERLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLEDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSSYSBDTABLEDERNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSSysBDTableDER pSSysBDTableDER) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBDTableDER)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDTableDER pSSysBDTableDER) throws Exception {
        Object object = pSSysBDTableDER.get("PSSYSBDTABLEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID", object);
        }
        super.onUpdateParent(pSSysBDTableDER);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDTableDER pSSysBDTableDER, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDTABLEDER");
        if (!bl) {
            pSSysBDTableDER.setCreateDate(null);
            pSSysBDTableDER.setCreateMan(null);
            pSSysBDTableDER.setPSSysBDTableDERId(null);
            pSSysBDTableDER.setUpdateDate(null);
            pSSysBDTableDER.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDTableDER, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDTableDER pSSysBDTableDER, PSSystem pSSystem) throws Exception {
        PSSysBDTableDER pSSysBDTableDER2 = new PSSysBDTableDER();
        pSSysBDTableDER2.setPSSysBDTableId(pSSysBDTableDER.getPSSysBDTableId());
        pSSysBDTableDER2.setPSDERId(pSSysBDTableDER.getPSDERId());
        if (this.selectOne(pSSysBDTableDER2, true)) {
            return pSSysBDTableDER2.getPSSysBDTableDERId();
        }
        return super.getEntityFolderKeyValue(pSSysBDTableDER, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDTableDER pSSysBDTableDER, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDTableDER, string);
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
            return "DER1N_PSSYSBDTABLEDER_PSSYSBDTABLE_PSSYSBDTABLEID";
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
    public String getModelV2Tag(PSSysBDTableDER pSSysBDTableDER) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTableDER.getPSSysBDTableDERName())) {
            return pSSysBDTableDER.getPSSysBDTableDERName();
        }
        return super.getModelV2Tag(pSSysBDTableDER);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDTableDER pSSysBDTableDER, String string) {
        pSSysBDTableDER.setPSSysBDTableDERName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDTABLEDERNAME", "");
        map.put("PSSYSBDTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDTableDER pSSysBDTableDER, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDTableDER.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDTableDER, true);
        pSSysBDTableDER.set("PSSYSBDTABLEDERNAME", string);
        if (this.select(pSSysBDTableDER, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDTableDER, true);
        return super.getModelV2Entity(pSSysBDTableDER, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDTableDER pSSysBDTableDER, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysBDTableDER, objectNode, string, string2, n);
    }
}

