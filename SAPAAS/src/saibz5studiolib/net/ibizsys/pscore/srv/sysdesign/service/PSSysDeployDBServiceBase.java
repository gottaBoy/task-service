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
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployDBDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployDBDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeployDB;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployDBServiceBase
extends PSCoreSysServiceBase<PSSysDeployDB> {
    private static final Log log = LogFactory.getLog(PSSysDeployDBServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDeployDBDEModel pSSysDeployDBDEModel;
    private PSSysDeployDBDAO pSSysDeployDBDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployDBService";
    }

    public PSSysDeployDBDEModel getPSSysDeployDBDEModel() {
        if (this.pSSysDeployDBDEModel == null) {
            try {
                this.pSSysDeployDBDEModel = (PSSysDeployDBDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDeployDBDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployDBDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDeployDBDEModel();
    }

    public PSSysDeployDBDAO getPSSysDeployDBDAO() {
        if (this.pSSysDeployDBDAO == null) {
            try {
                this.pSSysDeployDBDAO = (PSSysDeployDBDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDeployDBDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDeployDBDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDeployDBDAO();
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

    protected void onFillParentInfo(PSSysDeployDB pSSysDeployDB, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEPLOYDB_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSSysDeployDB, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEPLOYDB_PSSYSDEPLOY_PSSYSDEPLOYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService", (SessionFactory)this.getSessionFactory());
            PSSysDeploy pSSysDeploy = (PSSysDeploy)iService.getDEModel().createEntity();
            pSSysDeploy.set("PSSYSDEPLOYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDeploy);
            } else {
                iService.get(pSSysDeploy);
            }
            this.onFillParentInfo_Pssysdeploy(pSSysDeployDB, pSSysDeploy);
            return;
        }
        super.onFillParentInfo(pSSysDeployDB, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSSysDeployDB pSSysDeployDB, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSSysDeployDB.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSSysDeployDB.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_Pssysdeploy(PSSysDeployDB pSSysDeployDB, PSSysDeploy pSSysDeploy) throws Exception {
        pSSysDeployDB.setPSSysDeployId(pSSysDeploy.getPSSysDeployId());
        pSSysDeployDB.setPSSysDeployName(pSSysDeploy.getPSSysDeployName());
    }

    protected void onFillEntityFullInfo(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysDeployDB, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSSysDeployDB, bl);
        this.onFillEntityFullInfo_Pssysdeploy(pSSysDeployDB, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pssysdeploy(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDeployDB, bl);
    }

    public ArrayList<PSSysDeployDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSSysDeployDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSSysDeployDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDeployDB> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, "", -1);
    }

    public ArrayList<PSSysDeployDB> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string) throws Exception {
        return this.selectByPssysdeploy(pSSysDeployBase, string, -1);
    }

    public ArrayList<PSSysDeployDB> selectByPssysdeploy(PSSysDeployBase pSSysDeployBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDEPLOYID", (Object)pSSysDeployBase.getPSSysDeployId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssysdeployCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssysdeployCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSysDeployDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEPLOYDB_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSSYSDEPLOYDB", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSysDeployDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSSysDeployDB pSSysDeployDB : arrayList) {
            PSSysDeployDB pSSysDeployDB2 = (PSSysDeployDB)this.getDEModel().createEntity();
            pSSysDeployDB2.setPSSysDeployDBId(pSSysDeployDB.getPSSysDeployDBId());
            pSSysDeployDB2.setPSDevCenterDBInstId(null);
            this.update(pSSysDeployDB2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDeployDBServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSysDeployDBServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSysDeployDBServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSysDeployDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSSysDeployDB pSSysDeployDB : arrayList) {
            this.remove(pSSysDeployDB);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSysDeployDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSysDeployDB> arrayList) throws Exception {
    }

    public void testRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    public void resetPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployDB> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        for (PSSysDeployDB pSSysDeployDB : arrayList) {
            PSSysDeployDB pSSysDeployDB2 = (PSSysDeployDB)this.getDEModel().createEntity();
            pSSysDeployDB2.setPSSysDeployDBId(pSSysDeployDB.getPSSysDeployDBId());
            pSSysDeployDB2.setPSSysDeployId(null);
            this.update(pSSysDeployDB2);
        }
    }

    public void removeByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        final PSSysDeploy pSSysDeploy2 = pSSysDeploy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDeployDBServiceBase.this.onBeforeRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployDBServiceBase.this.internalRemoveByPssysdeploy(pSSysDeploy2);
                PSSysDeployDBServiceBase.this.onAfterRemoveByPssysdeploy(pSSysDeploy2);
            }
        });
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void internalRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
        ArrayList<PSSysDeployDB> arrayList = this.selectByPssysdeploy(pSSysDeploy);
        this.onBeforeRemoveByPssysdeploy(pSSysDeploy, arrayList);
        for (PSSysDeployDB pSSysDeployDB : arrayList) {
            this.remove(pSSysDeployDB);
        }
        this.onAfterRemoveByPssysdeploy(pSSysDeploy, arrayList);
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy) throws Exception {
    }

    protected void onBeforeRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssysdeploy(PSSysDeploy pSSysDeploy, ArrayList<PSSysDeployDB> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDeployDB pSSysDeployDB) throws Exception {
        super.onBeforeRemove(pSSysDeployDB);
    }

    protected void replaceParentInfo(PSSysDeployDB pSSysDeployDB, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDeployDB, cloneSession);
        if (pSSysDeployDB.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSSysDeployDB.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSSysDeployDB, (PSDevCenterDBInst)iEntity);
        }
        if (pSSysDeployDB.getPSSysDeployId() != null && (iEntity = cloneSession.getEntity("PSSYSDEPLOY", (Object)pSSysDeployDB.getPSSysDeployId())) != null) {
            this.onFillParentInfo_Pssysdeploy(pSSysDeployDB, (PSSysDeploy)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDeployDB, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ConnStr(bl, pSSysDeployDB, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBName(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBType(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PASSWD(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployDBId(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployDBName(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDeployId(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserName(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSSysDeployDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDeployDB, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ConnStr(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isConnStrDirty() && !bl2 : !pSSysDeployDB.isConnStrDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getConnStr();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConnStr_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONNSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBName(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isDBNameDirty() && !bl2 : !pSSysDeployDB.isDBNameDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBName_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBType(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isDBTypeDirty() && !bl2 : !pSSysDeployDB.isDBTypeDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getDBType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBType_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isMemoDirty() : !pSSysDeployDB.isMemoDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDeployDB, bl2, bl3);
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

    protected EntityFieldError onCheckField_PASSWD(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isPASSWDDirty() && !bl2 : !pSSysDeployDB.isPASSWDDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getPASSWD();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PASSWD_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PASSWD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isPSDevCenterDBInstIdDirty() : !pSSysDeployDB.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployDBId(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isPSSysDeployDBIdDirty() && !bl2 : !pSSysDeployDB.isPSSysDeployDBIdDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getPSSysDeployDBId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYDBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployDBId_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYDBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployDBName(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isPSSysDeployDBNameDirty() && !bl2 : !pSSysDeployDB.isPSSysDeployDBNameDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getPSSysDeployDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYDBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployDBName_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYDBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDeployId(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isPSSysDeployIdDirty() && !bl2 : !pSSysDeployDB.isPSSysDeployIdDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getPSSysDeployId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDeployId_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEPLOYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserName(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isUserNameDirty() && !bl2 : !pSSysDeployDB.isUserNameDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getUserName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserName_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSSysDeployDB pSSysDeployDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDeployDB.isUserParamsDirty() : !pSSysDeployDB.isUserParamsDirty()) {
            return null;
        }
        String string = pSSysDeployDB.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSSysDeployDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDeployDB, bl);
    }

    protected void onSyncIndexEntities(PSSysDeployDB pSSysDeployDB, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDeployDB, bl);
    }

    public Object getDataContextValue(PSSysDeployDB pSSysDeployDB, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDeployDB, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDeployDB pSSysDeployDB, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDeployDB, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONNSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConnStr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PASSWD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PASSWD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYDBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployDBId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYDBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployDBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEPLOYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDeployName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ConnStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONNSTR", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_DBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_PASSWD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PASSWD", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployDBId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYDBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployDBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYDBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDeployName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEPLOYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERNAME", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSysDeployDB pSSysDeployDB) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDeployDB)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDeployDB pSSysDeployDB) throws Exception {
        super.onUpdateParent(pSSysDeployDB);
    }

    @Override
    protected void exportCurXmlModel(PSSysDeployDB pSSysDeployDB, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEPLOYDB");
        if (!bl) {
            pSSysDeployDB.setCreateDate(null);
            pSSysDeployDB.setCreateMan(null);
            pSSysDeployDB.setPSSysDeployDBId(null);
            pSSysDeployDB.setUpdateDate(null);
            pSSysDeployDB.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDeployDB, xmlNode, bl);
        }
    }
}

