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
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVerBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSSaaSSysDBDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSSaaSSysDBDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSSaaSSysDB;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysDBServiceBase
extends PSCoreSysServiceBase<PSSaaSSysDB> {
    private static final Log log = LogFactory.getLog(PSSaaSSysDBServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSaaSSysDBDEModel pSSaaSSysDBDEModel;
    private PSSaaSSysDBDAO pSSaaSSysDBDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSSaaSSysDBService";
    }

    public PSSaaSSysDBDEModel getPSSaaSSysDBDEModel() {
        if (this.pSSaaSSysDBDEModel == null) {
            try {
                this.pSSaaSSysDBDEModel = (PSSaaSSysDBDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSSaaSSysDBDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysDBDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSaaSSysDBDEModel();
    }

    public PSSaaSSysDBDAO getPSSaaSSysDBDAO() {
        if (this.pSSaaSSysDBDAO == null) {
            try {
                this.pSSaaSSysDBDAO = (PSSaaSSysDBDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSSaaSSysDBDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSaaSSysDBDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSaaSSysDBDAO();
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

    protected void onFillParentInfo(PSSaaSSysDB pSSaaSSysDB, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSDB_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_PSDevCenterDBInst(pSSaaSSysDB, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSDB_PSDEVCENTERDBINST_SAMPLEPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterDBInst);
            } else {
                iService.get((IEntity)pSDevCenterDBInst);
            }
            this.onFillParentInfo_SamplePSDCDBInst(pSSaaSSysDB, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSAASSYSDB_PSSAASSYSVER_PSSAASSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService", (SessionFactory)this.getSessionFactory());
            PSSaaSSysVer pSSaaSSysVer = (PSSaaSSysVer)iService.getDEModel().createEntity();
            pSSaaSSysVer.set("PSSAASSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSaaSSysVer);
            } else {
                iService.get((IEntity)pSSaaSSysVer);
            }
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysDB, pSSaaSSysVer);
            return;
        }
        super.onFillParentInfo((IEntity)pSSaaSSysDB, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterDBInst(PSSaaSSysDB pSSaaSSysDB, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSSaaSSysDB.setPSDBInstId(pSDevCenterDBInst.getPSDBDevInstId());
        pSSaaSSysDB.setPSDevCenterDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSSaaSSysDB.setPSDevCenterDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_SamplePSDCDBInst(PSSaaSSysDB pSSaaSSysDB, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSSaaSSysDB.setSamplePSDBInstId(pSDevCenterDBInst.getPSDBDevInstId());
        pSSaaSSysDB.setSamplePSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSSaaSSysDB.setSamplePSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PSSaaSSysVer(PSSaaSSysDB pSSaaSSysDB, PSSaaSSysVer pSSaaSSysVer) throws Exception {
        pSSaaSSysDB.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
        pSSaaSSysDB.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
    }

    protected void onFillEntityFullInfo(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSaaSSysDB, bl);
        this.onFillEntityFullInfo_PSDevCenterDBInst(pSSaaSSysDB, bl);
        this.onFillEntityFullInfo_SamplePSDCDBInst(pSSaaSSysDB, bl);
        this.onFillEntityFullInfo_PSSaaSSysVer(pSSaaSSysDB, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterDBInst(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SamplePSDCDBInst(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSaaSSysVer(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSaaSSysDB, bl);
    }

    public ArrayList<PSSaaSSysDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSSaaSSysDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPSDevCenterDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSSaaSSysDB> selectByPSDevCenterDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSSaaSSysDB> selectBySamplePSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectBySamplePSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSSaaSSysDB> selectBySamplePSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectBySamplePSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSSaaSSysDB> selectBySamplePSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SAMPLEPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySamplePSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySamplePSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSaaSSysDB> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, "", -1);
    }

    public ArrayList<PSSaaSSysDB> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string) throws Exception {
        return this.selectByPSSaaSSysVer(pSSaaSSysVerBase, string, -1);
    }

    public ArrayList<PSSaaSSysDB> selectByPSSaaSSysVer(PSSaaSSysVerBase pSSaaSSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSVERID", (Object)pSSaaSSysVerBase.getPSSaaSSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysVerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSDB_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID", "", iDataEntityModel.getName(), "PSSAASSYSDB", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            PSSaaSSysDB pSSaaSSysDB2 = (PSSaaSSysDB)this.getDEModel().createEntity();
            pSSaaSSysDB2.setPSSaaSSysDBId(pSSaaSSysDB.getPSSaaSSysDBId());
            pSSaaSSysDB2.setPSDevCenterDBInstId(null);
            this.update(pSSaaSSysDB2);
        }
    }

    public void removeByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysDBServiceBase.this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSaaSSysDBServiceBase.this.internalRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
                PSSaaSSysDBServiceBase.this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSDevCenterDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            this.remove((IEntity)pSSaaSSysDB);
        }
        this.onAfterRemoveByPSDevCenterDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    public void testRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectBySamplePSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSDB_PSDEVCENTERDBINST_SAMPLEPSDCDBINSTID", "", iDataEntityModel.getName(), "PSSAASSYSDB", iDataEntityModel.getDataInfo((IEntity)pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetSamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectBySamplePSDCDBInst(pSDevCenterDBInst);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            PSSaaSSysDB pSSaaSSysDB2 = (PSSaaSSysDB)this.getDEModel().createEntity();
            pSSaaSSysDB2.setPSSaaSSysDBId(pSSaaSSysDB.getPSSaaSSysDBId());
            pSSaaSSysDB2.setSamplePSDCDBInstId(null);
            this.update(pSSaaSSysDB2);
        }
    }

    public void removeBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysDBServiceBase.this.onBeforeRemoveBySamplePSDCDBInst(pSDevCenterDBInst2);
                PSSaaSSysDBServiceBase.this.internalRemoveBySamplePSDCDBInst(pSDevCenterDBInst2);
                PSSaaSSysDBServiceBase.this.onAfterRemoveBySamplePSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectBySamplePSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveBySamplePSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            this.remove((IEntity)pSSaaSSysDB);
        }
        this.onAfterRemoveBySamplePSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySamplePSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSAASSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSaaSSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSAASSYSDB_PSSAASSYSVER_PSSAASSYSVERID", "", iDataEntityModel.getName(), "PSSAASSYSDB", iDataEntityModel.getDataInfo((IEntity)pSSaaSSysVer), arrayList.get(0)));
        }
    }

    public void resetPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            PSSaaSSysDB pSSaaSSysDB2 = (PSSaaSSysDB)this.getDEModel().createEntity();
            pSSaaSSysDB2.setPSSaaSSysDBId(pSSaaSSysDB.getPSSaaSSysDBId());
            pSSaaSSysDB2.setPSSaaSSysVerId(null);
            this.update(pSSaaSSysDB2);
        }
    }

    public void removeByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        final PSSaaSSysVer pSSaaSSysVer2 = pSSaaSSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSaaSSysDBServiceBase.this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysDBServiceBase.this.internalRemoveByPSSaaSSysVer(pSSaaSSysVer2);
                PSSaaSSysDBServiceBase.this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void internalRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
        ArrayList<PSSaaSSysDB> arrayList = this.selectByPSSaaSSysVer(pSSaaSSysVer);
        this.onBeforeRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
        for (PSSaaSSysDB pSSaaSSysDB : arrayList) {
            this.remove((IEntity)pSSaaSSysDB);
        }
        this.onAfterRemoveByPSSaaSSysVer(pSSaaSSysVer, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSysVer(PSSaaSSysVer pSSaaSSysVer, ArrayList<PSSaaSSysDB> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSaaSSysDB pSSaaSSysDB) throws Exception {
        super.onBeforeRemove(pSSaaSSysDB);
    }

    protected void replaceParentInfo(PSSaaSSysDB pSSaaSSysDB, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSaaSSysDB, cloneSession);
        if (pSSaaSSysDB.getPSDevCenterDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSSaaSSysDB.getPSDevCenterDBInstId())) != null) {
            this.onFillParentInfo_PSDevCenterDBInst(pSSaaSSysDB, (PSDevCenterDBInst)iEntity);
        }
        if (pSSaaSSysDB.getSamplePSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSSaaSSysDB.getSamplePSDCDBInstId())) != null) {
            this.onFillParentInfo_SamplePSDCDBInst(pSSaaSSysDB, (PSDevCenterDBInst)iEntity);
        }
        if (pSSaaSSysDB.getPSSaaSSysVerId() != null && (iEntity = cloneSession.getEntity("PSSAASSYSVER", (Object)pSSaaSSysDB.getPSSaaSSysVerId())) != null) {
            this.onFillParentInfo_PSSaaSSysVer(pSSaaSSysDB, (PSSaaSSysVer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSaaSSysDB, bl);
    }

    protected void onCheckEntity(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSaaSSysDB, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterDBInstId(bl, pSSaaSSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysDBId(bl, pSSaaSSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaasSysDBName(bl, pSSaaSSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysVerId(bl, pSSaaSSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SamplePSDCDBInstId(bl, pSSaaSSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSaaSSysDB, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isMemoDirty() : !pSSaaSSysDB.isMemoDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSaaSSysDB, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterDBInstId(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isPSDevCenterDBInstIdDirty() : !pSSaaSSysDB.isPSDevCenterDBInstIdDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getPSDevCenterDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterDBInstId_Default((IEntity)pSSaaSSysDB, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSaaSSysDBId(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isPSSaaSSysDBIdDirty() && !bl2 : !pSSaaSSysDB.isPSSaaSSysDBIdDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getPSSaaSSysDBId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSDBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysDBId_Default((IEntity)pSSaaSSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSDBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaasSysDBName(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isPSSaasSysDBNameDirty() && !bl2 : !pSSaaSSysDB.isPSSaasSysDBNameDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getPSSaasSysDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSDBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaasSysDBName_Default((IEntity)pSSaaSSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSDBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSAASSYSVERID";
                String string4 = this.checkFieldDupRule(this.getPSSaaSSysDBDEModel(), "PSSAASSYSDBNAME", string3, pSSaaSSysDB, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSAASSYSDBNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysVerId(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isPSSaaSSysVerIdDirty() && !bl2 : !pSSaaSSysDB.isPSSaaSSysVerIdDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getPSSaaSSysVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysVerId_Default((IEntity)pSSaaSSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SamplePSDCDBInstId(boolean bl, PSSaaSSysDB pSSaaSSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSaaSSysDB.isSamplePSDCDBInstIdDirty() : !pSSaaSSysDB.isSamplePSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSSaaSSysDB.getSamplePSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SamplePSDCDBInstId_Default((IEntity)pSSaaSSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SAMPLEPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSaaSSysDB, bl);
    }

    protected void onSyncIndexEntities(PSSaaSSysDB pSSaaSSysDB, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSaaSSysDB, bl);
    }

    public Object getDataContextValue(PSSaaSSysDB pSSaaSSysDB, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSaaSSysDB, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSaaSSysDB pSSaaSSysDB, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSaaSSysDB, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSDBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysDBId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSDBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaasSysDBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAMPLEPSDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SamplePSDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAMPLEPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SamplePSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAMPLEPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SamplePSDCDBInstName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSaaSSysDBId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSDBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaasSysDBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSDBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SamplePSDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAMPLEPSDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SamplePSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAMPLEPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SamplePSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAMPLEPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSaaSSysDB pSSaaSSysDB) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSaaSSysDB)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSaaSSysDB pSSaaSSysDB) throws Exception {
        super.onUpdateParent((IEntity)pSSaaSSysDB);
    }

    @Override
    protected void exportCurXmlModel(PSSaaSSysDB pSSaaSSysDB, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSAASSYSDB");
        if (!bl) {
            pSSaaSSysDB.setCreateDate(null);
            pSSaaSSysDB.setCreateMan(null);
            pSSaaSSysDB.setPSSaaSSysDBId(null);
            pSSaaSSysDB.setUpdateDate(null);
            pSSaaSSysDB.setUpdateMan(null);
            super.exportCurXmlModel(pSSaaSSysDB, xmlNode, bl);
        }
    }
}

