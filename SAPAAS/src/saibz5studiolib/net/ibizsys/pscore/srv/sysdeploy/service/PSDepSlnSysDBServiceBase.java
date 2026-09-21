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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDBDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDBDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnDBInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnDBInstBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDB;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysDBServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysDB> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysDBServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysDBDEModel pSDepSlnSysDBDEModel;
    private PSDepSlnSysDBDAO pSDepSlnSysDBDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService";
    }

    public PSDepSlnSysDBDEModel getPSDepSlnSysDBDEModel() {
        if (this.pSDepSlnSysDBDEModel == null) {
            try {
                this.pSDepSlnSysDBDEModel = (PSDepSlnSysDBDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDBDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDBDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysDBDEModel();
    }

    public PSDepSlnSysDBDAO getPSDepSlnSysDBDAO() {
        if (this.pSDepSlnSysDBDAO == null) {
            try {
                this.pSDepSlnSysDBDAO = (PSDepSlnSysDBDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDBDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDBDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysDBDAO();
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

    protected void onFillParentInfo(PSDepSlnSysDB pSDepSlnSysDB, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDB_PSDEPSLNDBINST_PSDEPSLNDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnDBInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnDBInst pSDepSlnDBInst = (PSDepSlnDBInst)iService.getDEModel().createEntity();
            pSDepSlnDBInst.set("PSDEPSLNDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnDBInst);
            } else {
                iService.get((IEntity)pSDepSlnDBInst);
            }
            this.onFillParentInfo_PSDepSlnDBInst(pSDepSlnSysDB, pSDepSlnDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDB_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSys);
            } else {
                iService.get((IEntity)pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysDB, pSDepSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDB_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnSysDB, pSDepSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnSysDB, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnDBInst(PSDepSlnSysDB pSDepSlnSysDB, PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        pSDepSlnSysDB.setPSDepSlnDBInstId(pSDepSlnDBInst.getPSDepSlnDBInstId());
        pSDepSlnSysDB.setPSDepSlnDBInstName(pSDepSlnDBInst.getPSDepSlnDBInstName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysDB pSDepSlnSysDB, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysDB.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysDB.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnSysDB pSDepSlnSysDB, PSDepSln pSDepSln) throws Exception {
        pSDepSlnSysDB.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnSysDB.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnSysDB, bl);
        this.onFillEntityFullInfo_PSDepSlnDBInst(pSDepSlnSysDB, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysDB, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnSysDB, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnDBInst(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnSysDB, bl);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnDBInst(PSDepSlnDBInstBase pSDepSlnDBInstBase) throws Exception {
        return this.selectByPSDepSlnDBInst(pSDepSlnDBInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnDBInst(PSDepSlnDBInstBase pSDepSlnDBInstBase, String string) throws Exception {
        return this.selectByPSDepSlnDBInst(pSDepSlnDBInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnDBInst(PSDepSlnDBInstBase pSDepSlnDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNDBINSTID", (Object)pSDepSlnDBInstBase.getPSDepSlnDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDB> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnDBInst(pSDepSlnDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDB_PSDEPSLNDBINST_PSDEPSLNDBINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDB", iDataEntityModel.getDataInfo((IEntity)pSDepSlnDBInst), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnDBInst(pSDepSlnDBInst);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            PSDepSlnSysDB pSDepSlnSysDB2 = (PSDepSlnSysDB)this.getDEModel().createEntity();
            pSDepSlnSysDB2.setPSDepSlnSysDBId(pSDepSlnSysDB.getPSDepSlnSysDBId());
            pSDepSlnSysDB2.setPSDepSlnDBInstId(null);
            this.update(pSDepSlnSysDB2);
        }
    }

    public void removeByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        final PSDepSlnDBInst pSDepSlnDBInst2 = pSDepSlnDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDBServiceBase.this.onBeforeRemoveByPSDepSlnDBInst(pSDepSlnDBInst2);
                PSDepSlnSysDBServiceBase.this.internalRemoveByPSDepSlnDBInst(pSDepSlnDBInst2);
                PSDepSlnSysDBServiceBase.this.onAfterRemoveByPSDepSlnDBInst(pSDepSlnDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
    }

    protected void internalRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnDBInst(pSDepSlnDBInst);
        this.onBeforeRemoveByPSDepSlnDBInst(pSDepSlnDBInst, arrayList);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            this.remove((IEntity)pSDepSlnSysDB);
        }
        this.onAfterRemoveByPSDepSlnDBInst(pSDepSlnDBInst, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnDBInst(PSDepSlnDBInst pSDepSlnDBInst, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDB_PSDEPSLNSYS_PSDEPSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDB", iDataEntityModel.getDataInfo((IEntity)pSDepSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            PSDepSlnSysDB pSDepSlnSysDB2 = (PSDepSlnSysDB)this.getDEModel().createEntity();
            pSDepSlnSysDB2.setPSDepSlnSysDBId(pSDepSlnSysDB.getPSDepSlnSysDBId());
            pSDepSlnSysDB2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysDB2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDBServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysDBServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysDBServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            this.remove((IEntity)pSDepSlnSysDB);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDB_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDB", iDataEntityModel.getDataInfo((IEntity)pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            PSDepSlnSysDB pSDepSlnSysDB2 = (PSDepSlnSysDB)this.getDEModel().createEntity();
            pSDepSlnSysDB2.setPSDepSlnSysDBId(pSDepSlnSysDB.getPSDepSlnSysDBId());
            pSDepSlnSysDB2.setPSDepSlnId(null);
            this.update(pSDepSlnSysDB2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDBServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysDBServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysDBServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysDB> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnSysDB pSDepSlnSysDB : arrayList) {
            this.remove((IEntity)pSDepSlnSysDB);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysDB> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysDB pSDepSlnSysDB) throws Exception {
        super.onBeforeRemove(pSDepSlnSysDB);
    }

    protected void replaceParentInfo(PSDepSlnSysDB pSDepSlnSysDB, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnSysDB, cloneSession);
        if (pSDepSlnSysDB.getPSDepSlnDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNDBINST", (Object)pSDepSlnSysDB.getPSDepSlnDBInstId())) != null) {
            this.onFillParentInfo_PSDepSlnDBInst(pSDepSlnSysDB, (PSDepSlnDBInst)iEntity);
        }
        if (pSDepSlnSysDB.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysDB.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysDB, (PSDepSlnSys)iEntity);
        }
        if (pSDepSlnSysDB.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnSysDB.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnSysDB, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnSysDB, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysDB, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnDBInstId(bl, pSDepSlnSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDBId(bl, pSDepSlnSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDBName(bl, pSDepSlnSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysDB, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnSysDB, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isMemoDirty() : !pSDepSlnSysDB.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnDBInstId(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isPSDepSlnDBInstIdDirty() && !bl2 : !pSDepSlnSysDB.isPSDepSlnDBInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getPSDepSlnDBInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnDBInstId_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnSysDB.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDBId(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isPSDepSlnSysDBIdDirty() && !bl2 : !pSDepSlnSysDB.isPSDepSlnSysDBIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getPSDepSlnSysDBId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDBId_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDBName(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isPSDepSlnSysDBNameDirty() && !bl2 : !pSDepSlnSysDB.isPSDepSlnSysDBNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getPSDepSlnSysDBName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDBNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDBName_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDBNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEPSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDepSlnSysDBDEModel(), "PSDEPSLNSYSDBNAME", string3, pSDepSlnSysDB, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEPSLNSYSDBNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysDB pSDepSlnSysDB, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDB.isPSDepSlnSysIdDirty() && !bl2 : !pSDepSlnSysDB.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDB.getPSDepSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default((IEntity)pSDepSlnSysDB, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnSysDB, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysDB pSDepSlnSysDB, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnSysDB, bl);
    }

    public Object getDataContextValue(PSDepSlnSysDB pSDepSlnSysDB, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnSysDB, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnSys pSDepSlnSys = pSDepSlnSysDB.getPSDepSlnSys();
        if (pSDepSlnSys != null && pSDepSlnSys.contains(string)) {
            return pSDepSlnSys.get(string);
        }
        PSDepSln pSDepSln = pSDepSlnSysDB.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysDB pSDepSlnSysDB, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnSysDB, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDBId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDBName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysDBId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysDBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysDB pSDepSlnSysDB) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnSysDB)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysDB pSDepSlnSysDB) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnSysDB);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysDB pSDepSlnSysDB, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSDB");
        if (!bl) {
            pSDepSlnSysDB.setCreateDate(null);
            pSDepSlnSysDB.setCreateMan(null);
            pSDepSlnSysDB.setPSDepSlnSysDBId(null);
            pSDepSlnSysDB.setUpdateDate(null);
            pSDepSlnSysDB.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysDB, xmlNode, bl);
        }
    }
}

