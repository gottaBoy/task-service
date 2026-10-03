/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCDBTableDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBTableDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBTable;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBTableServiceBase
extends PSCoreSysServiceBase<PSDCDBTable> {
    private static final Log log = LogFactory.getLog(PSDCDBTableServiceBase.class);
    public static final String DATASET_CURDB = "CurDB";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_GENINSERTCODE = "GenInsertCode";
    public static final String ACTION_GENSELECTCODE = "GenSelectCode";
    private PSDCDBTableDEModel pSDCDBTableDEModel;
    private PSDCDBTableDAO pSDCDBTableDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCDBTableService";
    }

    public PSDCDBTableDEModel getPSDCDBTableDEModel() {
        if (this.pSDCDBTableDEModel == null) {
            try {
                this.pSDCDBTableDEModel = (PSDCDBTableDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBTableDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBTableDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCDBTableDEModel();
    }

    public PSDCDBTableDAO getPSDCDBTableDAO() {
        if (this.pSDCDBTableDAO == null) {
            try {
                this.pSDCDBTableDAO = (PSDCDBTableDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCDBTableDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBTableDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCDBTableDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDB, (boolean)true) == 0) {
            return this.fetchCurDB(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_GENINSERTCODE, (boolean)true) == 0) {
            this.genInsertCode((PSDCDBTable)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GENSELECTCODE, (boolean)true) == 0) {
            this.genSelectCode((PSDCDBTable)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDB(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDB, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void genInsertCode(PSDCDBTable pSDCDBTable) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENINSERTCODE, 0, pSDCDBTable, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCDBTable, ACTION_GENINSERTCODE);
        final PSDCDBTable pSDCDBTable2 = pSDCDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCDBTableServiceBase.this.getService(), PSDCDBTableServiceBase.ACTION_GENINSERTCODE, 40, pSDCDBTable2, null).getResult() != 1) {
                    PSDCDBTableServiceBase.this.onGenInsertCode(pSDCDBTable2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENINSERTCODE, 99, pSDCDBTable, null);
        }
    }

    protected void onGenInsertCode(PSDCDBTable pSDCDBTable) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GenInsertCode]");
    }

    public void genSelectCode(PSDCDBTable pSDCDBTable) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENSELECTCODE, 0, pSDCDBTable, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCDBTable, ACTION_GENSELECTCODE);
        final PSDCDBTable pSDCDBTable2 = pSDCDBTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCDBTableServiceBase.this.getService(), PSDCDBTableServiceBase.ACTION_GENSELECTCODE, 40, pSDCDBTable2, null).getResult() != 1) {
                    PSDCDBTableServiceBase.this.onGenSelectCode(pSDCDBTable2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENSELECTCODE, 99, pSDCDBTable, null);
        }
    }

    protected void onGenSelectCode(PSDCDBTable pSDCDBTable) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GenSelectCode]");
    }

    protected void onFillParentInfo(PSDCDBTable pSDCDBTable, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCDBTABLE_PSDEVCENTERDBINST_PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDDBInst(pSDCDBTable, pSDevCenterDBInst);
            return;
        }
        super.onFillParentInfo(pSDCDBTable, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDDBInst(PSDCDBTable pSDCDBTable, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDCDBTable.setPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDCDBTable.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillEntityFullInfo(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCDBTable, bl);
        this.onFillEntityFullInfo_PSDDBInst(pSDCDBTable, bl);
    }

    protected void onFillEntityFullInfo_PSDDBInst(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        if (pSDCDBTable.isPSDCDBInstIdDirty()) {
            if (pSDCDBTable.getPSDCDBInstId() != null) {
                if (pSDCDBTable.getPSDCDBInstId() == null || pSDCDBTable.getPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDCDBTable.getPSDDBInst();
                    pSDCDBTable.setPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDCDBTable.setPSDCDBInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCDBTable, bl);
    }

    public ArrayList<PSDCDBTable> selectByPSDDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDCDBTable> selectByPSDDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDCDBTable> selectByPSDDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDDBInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    public void resetPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBTable> arrayList = this.selectByPSDDBInst(pSDevCenterDBInst);
        for (PSDCDBTable pSDCDBTable : arrayList) {
            PSDCDBTable pSDCDBTable2 = (PSDCDBTable)this.getDEModel().createEntity();
            pSDCDBTable2.setPSDCDBTableId(pSDCDBTable.getPSDCDBTableId());
            pSDCDBTable2.setPSDCDBInstId(null);
            this.update(pSDCDBTable2);
        }
    }

    public void removeByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCDBTableServiceBase.this.onBeforeRemoveByPSDDBInst(pSDevCenterDBInst2);
                PSDCDBTableServiceBase.this.internalRemoveByPSDDBInst(pSDevCenterDBInst2);
                PSDCDBTableServiceBase.this.onAfterRemoveByPSDDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDCDBTable> arrayList = this.selectByPSDDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDDBInst(pSDevCenterDBInst, arrayList);
        for (PSDCDBTable pSDCDBTable : arrayList) {
            this.remove(pSDCDBTable);
        }
        this.onAfterRemoveByPSDDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBTable> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDCDBTable> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCDBTable pSDCDBTable) throws Exception {
        super.onBeforeRemove(pSDCDBTable);
    }

    protected void replaceParentInfo(PSDCDBTable pSDCDBTable, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCDBTable, cloneSession);
        if (pSDCDBTable.getPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDCDBTable.getPSDCDBInstId())) != null) {
            this.onFillParentInfo_PSDDBInst(pSDCDBTable, (PSDevCenterDBInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCDBTable, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCDBTable, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstId(bl, pSDCDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBInstName(bl, pSDCDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBTableId(bl, pSDCDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDBTableName(bl, pSDCDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SQL(bl, pSDCDBTable, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCDBTable, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isMemoDirty() : !pSDCDBTable.isMemoDirty()) {
            return null;
        }
        String string = pSDCDBTable.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCDBTable, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCDBInstId(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isPSDCDBInstIdDirty() : !pSDCDBTable.isPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDCDBTable.getPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstId_Default(pSDCDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBInstName(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isPSDCDBInstNameDirty() : !pSDCDBTable.isPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDCDBTable.getPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBInstName_Default(pSDCDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBTableId(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isPSDCDBTableIdDirty() && !bl2 : !pSDCDBTable.isPSDCDBTableIdDirty()) {
            return null;
        }
        String string = pSDCDBTable.getPSDCDBTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBTableId_Default(pSDCDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDBTableName(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isPSDCDBTableNameDirty() && !bl2 : !pSDCDBTable.isPSDCDBTableNameDirty()) {
            return null;
        }
        String string = pSDCDBTable.getPSDCDBTableName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBTABLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDBTableName_Default(pSDCDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDBTABLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SQL(boolean bl, PSDCDBTable pSDCDBTable, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCDBTable.isSQLDirty() : !pSDCDBTable.isSQLDirty()) {
            return null;
        }
        String string = pSDCDBTable.getSQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SQL_Default(pSDCDBTable, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        super.onSyncEntity(pSDCDBTable, bl);
    }

    protected void onSyncIndexEntities(PSDCDBTable pSDCDBTable, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCDBTable, bl);
    }

    public Object getDataContextValue(PSDCDBTable pSDCDBTable, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCDBTable, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCDBTable pSDCDBTable, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCDBTable, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDBTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDBTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDBTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDBTABLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected boolean onMergeChild(String string, String string2, PSDCDBTable pSDCDBTable) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCDBTable)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCDBTable pSDCDBTable) throws Exception {
        super.onUpdateParent(pSDCDBTable);
    }

    @Override
    protected void exportCurXmlModel(PSDCDBTable pSDCDBTable, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCDBTABLE");
        if (!bl) {
            pSDCDBTable.setCreateDate(null);
            pSDCDBTable.setCreateMan(null);
            pSDCDBTable.setPSDCDBTableId(null);
            pSDCDBTable.setUpdateDate(null);
            pSDCDBTable.setUpdateMan(null);
            super.exportCurXmlModel(pSDCDBTable, xmlNode, bl);
        }
    }
}

