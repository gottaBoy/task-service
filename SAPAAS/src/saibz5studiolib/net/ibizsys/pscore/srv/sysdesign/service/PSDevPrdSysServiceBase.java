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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysServiceBase
extends PSCoreSysServiceBase<PSDevPrdSys> {
    private static final Log log = LogFactory.getLog(PSDevPrdSysServiceBase.class);
    public static final String DATASET_CURPRD = "CurPrd";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEDEVSLNSYS = "CreateDevSlnSys";
    private PSDevPrdSysDEModel pSDevPrdSysDEModel;
    private PSDevPrdSysDAO pSDevPrdSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService";
    }

    public PSDevPrdSysDEModel getPSDevPrdSysDEModel() {
        if (this.pSDevPrdSysDEModel == null) {
            try {
                this.pSDevPrdSysDEModel = (PSDevPrdSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevPrdSysDEModel();
    }

    public PSDevPrdSysDAO getPSDevPrdSysDAO() {
        if (this.pSDevPrdSysDAO == null) {
            try {
                this.pSDevPrdSysDAO = (PSDevPrdSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevPrdSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPRD, (boolean)true) == 0) {
            return this.fetchCurPrd(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEVSLNSYS, (boolean)true) == 0) {
            this.createDevSlnSys((PSDevPrdSys)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPrd(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPRD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void createDevSlnSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEVSLNSYS, 0, pSDevPrdSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevPrdSys, ACTION_CREATEDEVSLNSYS);
        final PSDevPrdSys pSDevPrdSys2 = pSDevPrdSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevPrdSysServiceBase.this.getService(), PSDevPrdSysServiceBase.ACTION_CREATEDEVSLNSYS, 40, pSDevPrdSys2, null).getResult() != 1) {
                    PSDevPrdSysServiceBase.this.onCreateDevSlnSys(pSDevPrdSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEVSLNSYS, 99, pSDevPrdSys, null);
        }
    }

    protected void onCreateDevSlnSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDevSlnSys]");
    }

    protected void onFillParentInfo(PSDevPrdSys pSDevPrdSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYS_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSubVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSubVer pSDevPrdSubVer = (PSDevPrdSubVer)iService.getDEModel().createEntity();
            pSDevPrdSubVer.set("PSDEVPRDSUBVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSubVer);
            } else {
                iService.get(pSDevPrdSubVer);
            }
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdSys, pSDevPrdSubVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYS_PSDEVPRDSYS_SRCPSDEVPRDSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService", (SessionFactory)this.getSessionFactory());
            PSDevPrdSys pSDevPrdSys2 = (PSDevPrdSys)iService.getDEModel().createEntity();
            pSDevPrdSys2.set("PSDEVPRDSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdSys2);
            } else {
                iService.get(pSDevPrdSys2);
            }
            this.onFillParentInfo_SrcPSDevPrdSys(pSDevPrdSys, pSDevPrdSys2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYS_PSDEVPRDVER_PSDEVPRDVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdVerService", (SessionFactory)this.getSessionFactory());
            PSDevPrdVer pSDevPrdVer = (PSDevPrdVer)iService.getDEModel().createEntity();
            pSDevPrdVer.set("PSDEVPRDVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrdVer);
            } else {
                iService.get(pSDevPrdVer);
            }
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSys, pSDevPrdVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYS_PSDEVPRD_PSDEVPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdService", (SessionFactory)this.getSessionFactory());
            PSDevPrd pSDevPrd = (PSDevPrd)iService.getDEModel().createEntity();
            pSDevPrd.set("PSDEVPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevPrd);
            } else {
                iService.get(pSDevPrd);
            }
            this.onFillParentInfo_PSDevPrd(pSDevPrdSys, pSDevPrd);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVPRDSYS_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevPrdSys, pSDevSlnSys);
            return;
        }
        super.onFillParentInfo(pSDevPrdSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevPrdSubVer(PSDevPrdSys pSDevPrdSys, PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        pSDevPrdSys.setPSDevPrdSubVerId(pSDevPrdSubVer.getPSDevPrdSubVerId());
        pSDevPrdSys.setPSDevPrdSubVerName(pSDevPrdSubVer.getPSDevPrdSubVerName());
        if (pSDevPrdSubVer.getPSDevPrdVer() != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSys, pSDevPrdSubVer.getPSDevPrdVer());
        }
    }

    protected void onFillParentInfo_SrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, PSDevPrdSys pSDevPrdSys2) throws Exception {
        pSDevPrdSys.setSrcPSDevPrdSysId(pSDevPrdSys2.getPSDevPrdSysId());
        pSDevPrdSys.setSrcPSDevPrdSysName(pSDevPrdSys2.getPSDevPrdSysName());
    }

    protected void onFillParentInfo_PSDevPrdVer(PSDevPrdSys pSDevPrdSys, PSDevPrdVer pSDevPrdVer) throws Exception {
        pSDevPrdSys.setPSDevPrdVerId(pSDevPrdVer.getPSDevPrdVerId());
        pSDevPrdSys.setPSDevPrdVerName(pSDevPrdVer.getPSDevPrdVerName());
        if (pSDevPrdVer.getPSDevPrd() != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSys, pSDevPrdVer.getPSDevPrd());
        }
    }

    protected void onFillParentInfo_PSDevPrd(PSDevPrdSys pSDevPrdSys, PSDevPrd pSDevPrd) throws Exception {
        pSDevPrdSys.setPSDevPrdId(pSDevPrd.getPSDevPrdId());
        pSDevPrdSys.setPSDevPrdName(pSDevPrd.getPSDevPrdName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevPrdSys pSDevPrdSys, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevPrdSys.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevPrdSys.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
        if (bl) {
            if (pSDevPrdSys.getDevPrdSysState() == null) {
                pSDevPrdSys.setDevPrdSysState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevPrdSys.getValidFlag() == null) {
                pSDevPrdSys.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevPrdSys, bl);
        this.onFillEntityFullInfo_PSDevPrdSubVer(pSDevPrdSys, bl);
        this.onFillEntityFullInfo_SrcPSDevPrdSys(pSDevPrdSys, bl);
        this.onFillEntityFullInfo_PSDevPrdVer(pSDevPrdSys, bl);
        this.onFillEntityFullInfo_PSDevPrd(pSDevPrdSys, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevPrdSys, bl);
    }

    protected void onFillEntityFullInfo_PSDevPrdSubVer(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrdVer(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevPrd(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevPrdSys, bl);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string) throws Exception {
        return this.selectByPSDevPrdSubVer(pSDevPrdSubVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdSubVer(PSDevPrdSubVerBase pSDevPrdSubVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDSUBVERID", (Object)pSDevPrdSubVerBase.getPSDevPrdSubVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdSubVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdSubVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSys> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase) throws Exception {
        return this.selectBySrcPSDevPrdSys(pSDevPrdSysBase, "", -1);
    }

    public ArrayList<PSDevPrdSys> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string) throws Exception {
        return this.selectBySrcPSDevPrdSys(pSDevPrdSysBase, string, -1);
    }

    public ArrayList<PSDevPrdSys> selectBySrcPSDevPrdSys(PSDevPrdSysBase pSDevPrdSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEVPRDSYSID", (Object)pSDevPrdSysBase.getPSDevPrdSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDevPrdSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDevPrdSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, "", -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string) throws Exception {
        return this.selectByPSDevPrdVer(pSDevPrdVerBase, string, -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrdVer(PSDevPrdVerBase pSDevPrdVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDVERID", (Object)pSDevPrdVerBase.getPSDevPrdVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, "", -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string) throws Exception {
        return this.selectByPSDevPrd(pSDevPrdBase, string, -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevPrd(PSDevPrdBase pSDevPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVPRDID", (Object)pSDevPrdBase.getPSDevPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevPrdCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevPrdSys> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevPrdSys> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSUBVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdSubVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYS_PSDEVPRDSUBVER_PSDEVPRDSUBVERID", "", iDataEntityModel.getName(), "PSDEVPRDSYS", iDataEntityModel.getDataInfo(pSDevPrdSubVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            PSDevPrdSys pSDevPrdSys2 = (PSDevPrdSys)this.getDEModel().createEntity();
            pSDevPrdSys2.setPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
            pSDevPrdSys2.setPSDevPrdSubVerId(null);
            this.update(pSDevPrdSys2);
        }
    }

    public void removeByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        final PSDevPrdSubVer pSDevPrdSubVer2 = pSDevPrdSubVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysServiceBase.this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSysServiceBase.this.internalRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
                PSDevPrdSysServiceBase.this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdSubVer(pSDevPrdSubVer);
        this.onBeforeRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            this.remove(pSDevPrdSys);
        }
        this.onAfterRemoveByPSDevPrdSubVer(pSDevPrdSubVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdSubVer(PSDevPrdSubVer pSDevPrdSubVer, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYS_PSDEVPRDSYS_SRCPSDEVPRDSYSID", "", iDataEntityModel.getName(), "PSDEVPRDSYS", iDataEntityModel.getDataInfo(pSDevPrdSys), arrayList.get(0)));
        }
    }

    public void resetSrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys);
        for (PSDevPrdSys pSDevPrdSys2 : arrayList) {
            PSDevPrdSys pSDevPrdSys3 = (PSDevPrdSys)this.getDEModel().createEntity();
            pSDevPrdSys3.setPSDevPrdSysId(pSDevPrdSys2.getPSDevPrdSysId());
            pSDevPrdSys3.setSrcPSDevPrdSysId(null);
            this.update(pSDevPrdSys3);
        }
    }

    public void removeBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        final PSDevPrdSys pSDevPrdSys2 = pSDevPrdSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysServiceBase.this.onBeforeRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysServiceBase.this.internalRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
                PSDevPrdSysServiceBase.this.onAfterRemoveBySrcPSDevPrdSys(pSDevPrdSys2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void internalRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectBySrcPSDevPrdSys(pSDevPrdSys);
        this.onBeforeRemoveBySrcPSDevPrdSys(pSDevPrdSys, arrayList);
        for (PSDevPrdSys pSDevPrdSys2 : arrayList) {
            this.remove(pSDevPrdSys2);
        }
        this.onAfterRemoveBySrcPSDevPrdSys(pSDevPrdSys, arrayList);
    }

    protected void onAfterRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDevPrdSys(PSDevPrdSys pSDevPrdSys, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRDVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrdVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYS_PSDEVPRDVER_PSDEVPRDVERID", "", iDataEntityModel.getName(), "PSDEVPRDSYS", iDataEntityModel.getDataInfo(pSDevPrdVer), arrayList.get(0)));
        }
    }

    public void resetPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            PSDevPrdSys pSDevPrdSys2 = (PSDevPrdSys)this.getDEModel().createEntity();
            pSDevPrdSys2.setPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
            pSDevPrdSys2.setPSDevPrdVerId(null);
            this.update(pSDevPrdSys2);
        }
    }

    public void removeByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        final PSDevPrdVer pSDevPrdVer2 = pSDevPrdVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysServiceBase.this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSysServiceBase.this.internalRemoveByPSDevPrdVer(pSDevPrdVer2);
                PSDevPrdSysServiceBase.this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void internalRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrdVer(pSDevPrdVer);
        this.onBeforeRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            this.remove(pSDevPrdSys);
        }
        this.onAfterRemoveByPSDevPrdVer(pSDevPrdVer, arrayList);
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrdVer(PSDevPrdVer pSDevPrdVer, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrd(pSDevPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYS_PSDEVPRD_PSDEVPRDID", "", iDataEntityModel.getName(), "PSDEVPRDSYS", iDataEntityModel.getDataInfo(pSDevPrd), arrayList.get(0)));
        }
    }

    public void resetPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrd(pSDevPrd);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            PSDevPrdSys pSDevPrdSys2 = (PSDevPrdSys)this.getDEModel().createEntity();
            pSDevPrdSys2.setPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
            pSDevPrdSys2.setPSDevPrdId(null);
            this.update(pSDevPrdSys2);
        }
    }

    public void removeByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        final PSDevPrd pSDevPrd2 = pSDevPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysServiceBase.this.onBeforeRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSysServiceBase.this.internalRemoveByPSDevPrd(pSDevPrd2);
                PSDevPrdSysServiceBase.this.onAfterRemoveByPSDevPrd(pSDevPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void internalRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevPrd(pSDevPrd);
        this.onBeforeRemoveByPSDevPrd(pSDevPrd, arrayList);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            this.remove(pSDevPrdSys);
        }
        this.onAfterRemoveByPSDevPrd(pSDevPrd, arrayList);
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevPrd(PSDevPrd pSDevPrd, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVPRDSYS_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVPRDSYS", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            PSDevPrdSys pSDevPrdSys2 = (PSDevPrdSys)this.getDEModel().createEntity();
            pSDevPrdSys2.setPSDevPrdSysId(pSDevPrdSys.getPSDevPrdSysId());
            pSDevPrdSys2.setPSDevSlnSysId(null);
            this.update(pSDevPrdSys2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevPrdSysServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevPrdSysServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevPrdSysServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevPrdSys> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevPrdSys pSDevPrdSys : arrayList) {
            this.remove(pSDevPrdSys);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevPrdSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevPrdSys pSDevPrdSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevPrdSysSyncService)ServiceGlobal.getService(PSDevPrdSysSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysSyncServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDevPrdSys(pSDevPrdSys);
        pSCoreSysServiceBase = (PSDevPrdSysSyncService)ServiceGlobal.getService(PSDevPrdSysSyncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysSyncServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDevPrdSys(pSDevPrdSys);
        pSCoreSysServiceBase = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDevPrdSys(pSDevPrdSys);
        super.onBeforeRemove(pSDevPrdSys);
    }

    protected void replaceParentInfo(PSDevPrdSys pSDevPrdSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevPrdSys, cloneSession);
        if (pSDevPrdSys.getPSDevPrdSubVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSUBVER", (Object)pSDevPrdSys.getPSDevPrdSubVerId())) != null) {
            this.onFillParentInfo_PSDevPrdSubVer(pSDevPrdSys, (PSDevPrdSubVer)iEntity);
        }
        if (pSDevPrdSys.getSrcPSDevPrdSysId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDSYS", (Object)pSDevPrdSys.getSrcPSDevPrdSysId())) != null) {
            this.onFillParentInfo_SrcPSDevPrdSys(pSDevPrdSys, (PSDevPrdSys)iEntity);
        }
        if (pSDevPrdSys.getPSDevPrdVerId() != null && (iEntity = cloneSession.getEntity("PSDEVPRDVER", (Object)pSDevPrdSys.getPSDevPrdVerId())) != null) {
            this.onFillParentInfo_PSDevPrdVer(pSDevPrdSys, (PSDevPrdVer)iEntity);
        }
        if (pSDevPrdSys.getPSDevPrdId() != null && (iEntity = cloneSession.getEntity("PSDEVPRD", (Object)pSDevPrdSys.getPSDevPrdId())) != null) {
            this.onFillParentInfo_PSDevPrd(pSDevPrdSys, (PSDevPrd)iEntity);
        }
        if (pSDevPrdSys.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevPrdSys.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevPrdSys, (PSDevSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevPrdSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DevPrdSysInfo(bl, pSDevPrdSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevPrdSysType(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevPrdSysState(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSubVerId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdSysName(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevPrdVerId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDevPrdSysId(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevPrdSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevPrdSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DevPrdSysInfo(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isDevPrdSysInfoDirty() : !pSDevPrdSys.isDevPrdSysInfoDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getDevPrdSysInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DevPrdSysInfo_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVPRDSYSINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevPrdSysType(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isDevPrdSysTypeDirty() && !bl2 : !pSDevPrdSys.isDevPrdSysTypeDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getDevPrdSysType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVPRDSYSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DevPrdSysType_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVPRDSYSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)25, (Object)string, (Object)"TRUNK") == 0L;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVPRDSUBVERID";
                String string4 = this.checkFieldDupRule(this.getPSDevPrdSysDEModel(), "DEVPRDSYSTYPE", string3, pSDevPrdSys, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEVPRDSYSTYPE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevPrdSysState(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isDevPrdSysStateDirty() : !pSDevPrdSys.isDevPrdSysStateDirty()) {
            return null;
        }
        Integer n = pSDevPrdSys.getDevPrdSysState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevPrdSysState_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVSYSSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isMemoDirty() : !pSDevPrdSys.isMemoDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevPrdSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevPrdId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevPrdIdDirty() && !bl2 : !pSDevPrdSys.isPSDevPrdIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSubVerId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevPrdSubVerIdDirty() && !bl2 : !pSDevPrdSys.isPSDevPrdSubVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevPrdSubVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSubVerId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSUBVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevPrdSysIdDirty() && !bl2 : !pSDevPrdSys.isPSDevPrdSysIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevPrdSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdSysName(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevPrdSysNameDirty() && !bl2 : !pSDevPrdSys.isPSDevPrdSysNameDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevPrdSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdSysName_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevPrdVerId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevPrdVerIdDirty() && !bl2 : !pSDevPrdSys.isPSDevPrdVerIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevPrdVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevPrdVerId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVPRDVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isPSDevSlnSysIdDirty() : !pSDevPrdSys.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDevPrdSysId(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isSrcPSDevPrdSysIdDirty() : !pSDevPrdSys.isSrcPSDevPrdSysIdDirty()) {
            return null;
        }
        String string = pSDevPrdSys.getSrcPSDevPrdSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDevPrdSysId_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEVPRDSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevPrdSys pSDevPrdSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevPrdSys.isValidFlagDirty() && !bl2 : !pSDevPrdSys.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevPrdSys.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevPrdSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
        super.onSyncEntity(pSDevPrdSys, bl);
    }

    protected void onSyncIndexEntities(PSDevPrdSys pSDevPrdSys, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevPrdSys, bl);
    }

    public Object getDataContextValue(PSDevPrdSys pSDevPrdSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevPrdSys, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevPrd pSDevPrd = pSDevPrdSys.getPSDevPrd();
        if (pSDevPrd != null && pSDevPrd.contains(string)) {
            return pSDevPrd.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevPrdSys pSDevPrdSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevPrdSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVPRDSYSINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevPrdSysInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVPRDSYSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevPrdSysType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSYSSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevPrdSysState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSUBVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSubVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSUBVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSubVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVPRDVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevPrdVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVPRDSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevPrdSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEVPRDSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDevPrdSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DevPrdSysInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVPRDSYSINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DevPrdSysType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVPRDSYSTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DevPrdSysState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSubVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSUBVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSubVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSUBVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevPrdVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVPRDVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevPrdSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVPRDSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDevPrdSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEVPRDSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevPrdSys pSDevPrdSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevPrdSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevPrdSys pSDevPrdSys) throws Exception {
        super.onUpdateParent(pSDevPrdSys);
    }

    @Override
    protected void exportCurXmlModel(PSDevPrdSys pSDevPrdSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVPRDSYS");
        if (!bl) {
            pSDevPrdSys.setCreateDate(null);
            pSDevPrdSys.setCreateMan(null);
            pSDevPrdSys.setPSDevPrdSysId(null);
            pSDevPrdSys.setUpdateDate(null);
            pSDevPrdSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDevPrdSys, xmlNode, bl);
        }
    }
}

