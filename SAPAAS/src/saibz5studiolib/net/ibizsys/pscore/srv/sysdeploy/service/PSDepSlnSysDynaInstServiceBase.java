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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDynaInstDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDynaInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysDynaInstServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysDynaInst> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysDynaInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLN2 = "CurSln2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_GENALLINSTSBAK = "GenAllInstsBak";
    public static final String ACTION_GENCURINSTBAK = "GenCurInstBak";
    private PSDepSlnSysDynaInstDEModel pSDepSlnSysDynaInstDEModel;
    private PSDepSlnSysDynaInstDAO pSDepSlnSysDynaInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService";
    }

    public PSDepSlnSysDynaInstDEModel getPSDepSlnSysDynaInstDEModel() {
        if (this.pSDepSlnSysDynaInstDEModel == null) {
            try {
                this.pSDepSlnSysDynaInstDEModel = (PSDepSlnSysDynaInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDynaInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDynaInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysDynaInstDEModel();
    }

    public PSDepSlnSysDynaInstDAO getPSDepSlnSysDynaInstDAO() {
        if (this.pSDepSlnSysDynaInstDAO == null) {
            try {
                this.pSDepSlnSysDynaInstDAO = (PSDepSlnSysDynaInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDynaInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDynaInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysDynaInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN2, (boolean)true) == 0) {
            return this.fetchCurSln2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_GENALLINSTSBAK, (boolean)true) == 0) {
            this.genAllInstsBak((PSDepSlnSysDynaInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GENCURINSTBAK, (boolean)true) == 0) {
            this.genCurInstBak((PSDepSlnSysDynaInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void genAllInstsBak(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENALLINSTSBAK, 0, (IEntity)pSDepSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDepSlnSysDynaInst, ACTION_GENALLINSTSBAK);
        final PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDepSlnSysDynaInstServiceBase.this.getService(), PSDepSlnSysDynaInstServiceBase.ACTION_GENALLINSTSBAK, 40, (IEntity)pSDepSlnSysDynaInst2, null).getResult() != 1) {
                    PSDepSlnSysDynaInstServiceBase.this.onGenAllInstsBak(pSDepSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENALLINSTSBAK, 99, (IEntity)pSDepSlnSysDynaInst, null);
        }
    }

    protected void onGenAllInstsBak(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GenAllInstsBak]");
    }

    public void genCurInstBak(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GENCURINSTBAK, 0, (IEntity)pSDepSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDepSlnSysDynaInst, ACTION_GENCURINSTBAK);
        final PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDepSlnSysDynaInstServiceBase.this.getService(), PSDepSlnSysDynaInstServiceBase.ACTION_GENCURINSTBAK, 40, (IEntity)pSDepSlnSysDynaInst2, null).getResult() != 1) {
                    PSDepSlnSysDynaInstServiceBase.this.onGenCurInstBak(pSDepSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GENCURINSTBAK, 99, (IEntity)pSDepSlnSysDynaInst, null);
        }
    }

    protected void onGenCurInstBak(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GenCurInstBak]");
    }

    protected void onFillParentInfo(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYSDYNAINST_PPSDEPSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = (PSDepSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDepSlnSysDynaInst2.set("PSDEPSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSysDynaInst2);
            } else {
                iService.get((IEntity)pSDepSlnSysDynaInst2);
            }
            this.onFillParentInfo_PPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, pSDepSlnSysDynaInst2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYSDYNAINST_PROXYPSDEPSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst3 = (PSDepSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDepSlnSysDynaInst3.set("PSDEPSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSysDynaInst3);
            } else {
                iService.get((IEntity)pSDepSlnSysDynaInst3);
            }
            this.onFillParentInfo_ProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, pSDepSlnSysDynaInst3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnSys);
            } else {
                iService.get((IEntity)pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysDynaInst, pSDepSlnSys);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnSysDynaInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, PSDepSlnSysDynaInst pSDepSlnSysDynaInst2) throws Exception {
        pSDepSlnSysDynaInst.setPPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstId());
        pSDepSlnSysDynaInst.setPPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstName());
    }

    protected void onFillParentInfo_ProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, PSDepSlnSysDynaInst pSDepSlnSysDynaInst2) throws Exception {
        pSDepSlnSysDynaInst.setProxyPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstId());
        pSDepSlnSysDynaInst.setProxyPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysDynaInst.setPSDepSlnId(pSDepSlnSys.getPSDepSlnId());
        pSDepSlnSysDynaInst.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysDynaInst.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_ProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysDynaInst, bl);
    }

    protected void onFillEntityFullInfo_PPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDepSlnSysDynaInst.isPPSDepSlnSysDynaInstIdDirty()) {
            if (pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstId() != null) {
                if (pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstId() == null || pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstName() == null) {
                    PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInst();
                    pSDepSlnSysDynaInst.setPPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstName());
                }
            } else {
                pSDepSlnSysDynaInst.setPPSDepSlnSysDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_ProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDepSlnSysDynaInst.isProxyPSDepSlnSysDynaInstIdDirty()) {
            if (pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstId() != null) {
                if (pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstId() == null || pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstName() == null) {
                    PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInst();
                    pSDepSlnSysDynaInst.setProxyPSDepSlnSysDynaInstName(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstName());
                }
            } else {
                pSDepSlnSysDynaInst.setProxyPSDepSlnSysDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnSysDynaInst, bl);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase) throws Exception {
        return this.selectByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEPSLNSYSDYNAINSTID", (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDepSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDepSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase) throws Exception {
        return this.selectByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PROXYPSDEPSLNSYSDYNAINSTID", (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByProxyPSDepSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByProxyPSDepSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysDynaInst> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnSysDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYSDYNAINST_PPSDEPSLNSYSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDepSlnSysDynaInst), arrayList.get(0)));
        }
    }

    public void resetPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 : arrayList) {
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst3 = (PSDepSlnSysDynaInst)this.getDEModel().createEntity();
            pSDepSlnSysDynaInst3.setPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstId());
            pSDepSlnSysDynaInst3.setPPSDepSlnSysDynaInstId(null);
            this.update(pSDepSlnSysDynaInst3);
        }
    }

    public void removeByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        final PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDynaInstServiceBase.this.onBeforeRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysDynaInstServiceBase.this.internalRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysDynaInstServiceBase.this.onAfterRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        this.onBeforeRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 : arrayList) {
            this.remove((IEntity)pSDepSlnSysDynaInst2);
        }
        this.onAfterRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnSysDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYSDYNAINST_PROXYPSDEPSLNSYSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDepSlnSysDynaInst), arrayList.get(0)));
        }
    }

    public void resetProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 : arrayList) {
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst3 = (PSDepSlnSysDynaInst)this.getDEModel().createEntity();
            pSDepSlnSysDynaInst3.setPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst2.getPSDepSlnSysDynaInstId());
            pSDepSlnSysDynaInst3.setProxyPSDepSlnSysDynaInstId(null);
            this.update(pSDepSlnSysDynaInst3);
        }
    }

    public void removeByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        final PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = pSDepSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDynaInstServiceBase.this.onBeforeRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysDynaInstServiceBase.this.internalRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
                PSDepSlnSysDynaInstServiceBase.this.onAfterRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        this.onBeforeRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 : arrayList) {
            this.remove((IEntity)pSDepSlnSysDynaInst2);
        }
        this.onAfterRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByProxyPSDepSlnSysDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSDYNAINST_PSDEPSLNSYS_PSDEPSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDepSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst : arrayList) {
            PSDepSlnSysDynaInst pSDepSlnSysDynaInst2 = (PSDepSlnSysDynaInst)this.getDEModel().createEntity();
            pSDepSlnSysDynaInst2.setPSDepSlnSysDynaInstId(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstId());
            pSDepSlnSysDynaInst2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysDynaInst2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysDynaInstServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysDynaInstServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysDynaInstServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysDynaInst> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysDynaInst pSDepSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDepSlnSysDynaInst);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysDynaInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        PSDepSlnSysDynaInstService pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysDynaInstService.testRemoveByPPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnSysDynaInstService.testRemoveByProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst);
        super.onBeforeRemove(pSDepSlnSysDynaInst);
    }

    protected void replaceParentInfo(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnSysDynaInst, cloneSession);
        if (pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYSDYNAINST", (Object)pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, (PSDepSlnSysDynaInst)iEntity);
        }
        if (pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYSDYNAINST", (Object)pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_ProxyPSDepSlnSysDynaInst(pSDepSlnSysDynaInst, (PSDepSlnSysDynaInst)iEntity);
        }
        if (pSDepSlnSysDynaInst.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysDynaInst.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysDynaInst, (PSDepSlnSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnSysDynaInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_InstMode(bl, pSDepSlnSysDynaInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDepSlnSysDynaInstId(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDepSlnSysDynaInstName(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyPSDepSlnSysDynaInstId(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProxyPSDepSlnSysDynaInstName(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDynaInstId(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysDynaInstName(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnSysDynaInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_InstMode(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isInstModeDirty() : !pSDepSlnSysDynaInst.isInstModeDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstMode_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isMemoDirty() : !pSDepSlnSysDynaInst.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDepSlnSysDynaInstId(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isPPSDepSlnSysDynaInstIdDirty() : !pSDepSlnSysDynaInst.isPPSDepSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDepSlnSysDynaInstId_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEPSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDepSlnSysDynaInstName(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isPPSDepSlnSysDynaInstNameDirty() : !pSDepSlnSysDynaInst.isPPSDepSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getPPSDepSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDepSlnSysDynaInstName_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEPSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyPSDepSlnSysDynaInstId(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isProxyPSDepSlnSysDynaInstIdDirty() : !pSDepSlnSysDynaInst.isProxyPSDepSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyPSDepSlnSysDynaInstId_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYPSDEPSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ProxyPSDepSlnSysDynaInstName(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isProxyPSDepSlnSysDynaInstNameDirty() : !pSDepSlnSysDynaInst.isProxyPSDepSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getProxyPSDepSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProxyPSDepSlnSysDynaInstName_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROXYPSDEPSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDynaInstId(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isPSDepSlnSysDynaInstIdDirty() && !bl2 : !pSDepSlnSysDynaInst.isPSDepSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDynaInstId_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysDynaInstName(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isPSDepSlnSysDynaInstNameDirty() && !bl2 : !pSDepSlnSysDynaInst.isPSDepSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysDynaInstName_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isPSDepSlnSysIdDirty() && !bl2 : !pSDepSlnSysDynaInst.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getPSDepSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isUserTagDirty() : !pSDepSlnSysDynaInst.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isUserTag2Dirty() : !pSDepSlnSysDynaInst.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSlnSysDynaInst.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysDynaInst.isValidFlagDirty() : !pSDepSlnSysDynaInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnSysDynaInst.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDepSlnSysDynaInst, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnSysDynaInst, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnSysDynaInst, bl);
    }

    public Object getDataContextValue(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnSysDynaInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnSys pSDepSlnSys = pSDepSlnSysDynaInst.getPSDepSlnSys();
        if (pSDepSlnSys != null && pSDepSlnSys.contains(string)) {
            return pSDepSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnSysDynaInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEPSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDepSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEPSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDepSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYPSDEPSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyPSDepSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PROXYPSDEPSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProxyPSDepSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysDynaInstName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_InstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PPSDepSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEPSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDepSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEPSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyPSDepSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYPSDEPSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ProxyPSDepSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROXYPSDEPSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDepSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnSysDynaInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnSysDynaInst);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysDynaInst pSDepSlnSysDynaInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSDYNAINST");
        if (!bl) {
            pSDepSlnSysDynaInst.setCreateDate(null);
            pSDepSlnSysDynaInst.setCreateMan(null);
            pSDepSlnSysDynaInst.setPSDepSlnSysDynaInstId(null);
            pSDepSlnSysDynaInst.setUpdateDate(null);
            pSDepSlnSysDynaInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysDynaInst, xmlNode, bl);
        }
    }
}

