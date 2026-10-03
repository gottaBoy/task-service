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
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDColSetDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColSetDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnServiceBase;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDColSetServiceBase
extends PSCoreSysServiceBase<PSSysBDColSet> {
    private static final Log log = LogFactory.getLog(PSSysBDColSetServiceBase.class);
    public static final String DATASET_CURBDT = "CurBDT";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDColSetDEModel pSSysBDColSetDEModel;
    private PSSysBDColSetDAO pSSysBDColSetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService";
    }

    public PSSysBDColSetDEModel getPSSysBDColSetDEModel() {
        if (this.pSSysBDColSetDEModel == null) {
            try {
                this.pSSysBDColSetDEModel = (PSSysBDColSetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDColSetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDColSetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDColSetDEModel();
    }

    public PSSysBDColSetDAO getPSSysBDColSetDAO() {
        if (this.pSSysBDColSetDAO == null) {
            try {
                this.pSSysBDColSetDAO = (PSSysBDColSetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDColSetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDColSetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDColSetDAO();
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

    protected void onFillParentInfo(PSSysBDColSet pSSysBDColSet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_PSSysBDTable(pSSysBDColSet, pSSysBDTable);
            return;
        }
        super.onFillParentInfo(pSSysBDColSet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysBDTable(PSSysBDColSet pSSysBDColSet, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDColSet.setPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDColSet.setPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
    }

    protected void onFillEntityFullInfo(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        if (bl && pSSysBDColSet.getDefaultFlag() == null) {
            pSSysBDColSet.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSSysBDColSet, bl);
        this.onFillEntityFullInfo_PSSysBDTable(pSSysBDColSet, bl);
    }

    protected void onFillEntityFullInfo_PSSysBDTable(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDColSet, bl);
    }

    public ArrayList<PSSysBDColSet> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDColSet> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDColSet> selectByPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    public void resetPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDColSet> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        for (PSSysBDColSet pSSysBDColSet : arrayList) {
            PSSysBDColSet pSSysBDColSet2 = (PSSysBDColSet)this.getDEModel().createEntity();
            pSSysBDColSet2.setPSSysBDColSetId(pSSysBDColSet.getPSSysBDColSetId());
            pSSysBDColSet2.setPSSysBDTableId(null);
            this.update(pSSysBDColSet2);
        }
    }

    public void removeByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDColSetServiceBase.this.onBeforeRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDColSetServiceBase.this.internalRemoveByPSSysBDTable(pSSysBDTable2);
                PSSysBDColSetServiceBase.this.onAfterRemoveByPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDColSet> arrayList = this.selectByPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDColSet pSSysBDColSet : arrayList) {
            this.remove(pSSysBDColSet);
        }
        this.onAfterRemoveByPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDColSet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDColSet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDColSet pSSysBDColSet) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBDColumnService)ServiceGlobal.getService(PSSysBDColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDColSet(pSSysBDColSet);
        pSCoreSysServiceBase = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBDTableDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBDColSet(pSSysBDColSet);
        super.onBeforeRemove(pSSysBDColSet);
    }

    protected void replaceParentInfo(PSSysBDColSet pSSysBDColSet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDColSet, cloneSession);
        if (pSSysBDColSet.getPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDColSet.getPSSysBDTableId())) != null) {
            this.onFillParentInfo_PSSysBDTable(pSSysBDColSet, (PSSysBDTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDColSet, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysBDColSet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColSetId(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDColSetName(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableId(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDColSet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDColSet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isCodeNameDirty() && !bl2 : !pSSysBDColSet.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBDColSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDColSetDEModel(), "CODENAME", string3, pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isDefaultFlagDirty() && !bl2 : !pSSysBDColSet.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDColSet.getDefaultFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSSysBDColSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSBDTABLEID";
                String string2 = this.checkFieldDupRule(this.getPSSysBDColSetDEModel(), "DEFAULTFLAG", string, pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isLogicNameDirty() : !pSSysBDColSet.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isMemoDirty() : !pSSysBDColSet.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDColSetId(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isPSSysBDColSetIdDirty() && !bl2 : !pSSysBDColSet.isPSSysBDColSetIdDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getPSSysBDColSetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColSetId_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDColSetName(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isPSSysBDColSetNameDirty() && !bl2 : !pSSysBDColSet.isPSSysBDColSetNameDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getPSSysBDColSetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDColSetName_Default(pSSysBDColSet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDCOLSETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDColSetDEModel(), "PSSYSBDCOLSETNAME", string3, pSSysBDColSet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBDCOLSETNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableId(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isPSSysBDTableIdDirty() && !bl2 : !pSSysBDColSet.isPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableId_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isUserCatDirty() : !pSSysBDColSet.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isUserTagDirty() : !pSSysBDColSet.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDColSet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isUserTag2Dirty() : !pSSysBDColSet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDColSet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isUserTag3Dirty() : !pSSysBDColSet.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDColSet.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBDColSet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDColSet pSSysBDColSet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDColSet.isUserTag4Dirty() : !pSSysBDColSet.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDColSet.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBDColSet, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDColSet, bl);
    }

    protected void onSyncIndexEntities(PSSysBDColSet pSSysBDColSet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDColSet, bl);
    }

    public Object getDataContextValue(PSSysBDColSet pSSysBDColSet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDColSet, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDTable pSSysBDTable = pSSysBDColSet.getPSSysBDTable();
        if (pSSysBDTable != null && pSSysBDTable.contains(string)) {
            return pSSysBDTable.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDColSet pSSysBDColSet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDColSet, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLSETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDCOLSETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDColSetName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("PSSYSBDCOLSETNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSSYSBDCOLSETNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSSysBDColSet pSSysBDColSet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBDColSet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDColSet pSSysBDColSet) throws Exception {
        Object object = pSSysBDColSet.get("PSSYSBDTABLEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID", object);
        }
        super.onUpdateParent(pSSysBDColSet);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysBDColSet pSSysBDColSet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDCOLSET");
        if (!bl) {
            pSSysBDColSet.setCreateDate(null);
            pSSysBDColSet.setCreateMan(null);
            pSSysBDColSet.setDefaultFlag(null);
            pSSysBDColSet.setPSSysBDColSetId(null);
            pSSysBDColSet.setUpdateDate(null);
            pSSysBDColSet.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDColSet, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDColSet pSSysBDColSet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDColSet, string);
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
            return "DER1N_PSSYSBDCOLSET_PSSYSBDTABLE_PSSYSBDTABLEID";
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
    public String getModelV2Tag(PSSysBDColSet pSSysBDColSet) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDColSet.getPSSysBDColSetName())) {
            return pSSysBDColSet.getPSSysBDColSetName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBDColSet.getCodeName())) {
            return pSSysBDColSet.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDColSet);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDColSet pSSysBDColSet, String string) {
        pSSysBDColSet.setPSSysBDColSetName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDCOLSETNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBDTABLEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDColSet pSSysBDColSet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDColSet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDColSet, true);
        pSSysBDColSet.set("PSSYSBDCOLSETNAME", string);
        if (this.select(pSSysBDColSet, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDColSet, true);
        return super.getModelV2Entity(pSSysBDColSet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDColSet pSSysBDColSet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBDColSet, objectNode, string, string2, n);
    }
}

