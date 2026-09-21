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
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysRefDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysRefDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrvBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysRefServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysRef> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysRefServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATELINKSTATE = "UpdateLinkState";
    private PSDevSlnSysRefDEModel pSDevSlnSysRefDEModel;
    private PSDevSlnSysRefDAO pSDevSlnSysRefDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService";
    }

    public PSDevSlnSysRefDEModel getPSDevSlnSysRefDEModel() {
        if (this.pSDevSlnSysRefDEModel == null) {
            try {
                this.pSDevSlnSysRefDEModel = (PSDevSlnSysRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysRefDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysRefDEModel();
    }

    public PSDevSlnSysRefDAO getPSDevSlnSysRefDAO() {
        if (this.pSDevSlnSysRefDAO == null) {
            try {
                this.pSDevSlnSysRefDAO = (PSDevSlnSysRefDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysRefDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysRefDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysRefDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATELINKSTATE, (boolean)true) == 0) {
            this.updateLinkState((PSDevSlnSysRef)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateLinkState(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 0, (IEntity)pSDevSlnSysRef, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysRef, ACTION_UPDATELINKSTATE);
        final PSDevSlnSysRef pSDevSlnSysRef2 = pSDevSlnSysRef;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysRefServiceBase.this.getService(), PSDevSlnSysRefServiceBase.ACTION_UPDATELINKSTATE, 40, (IEntity)pSDevSlnSysRef2, null).getResult() != 1) {
                    PSDevSlnSysRefServiceBase.this.onUpdateLinkState(pSDevSlnSysRef2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATELINKSTATE, 99, (IEntity)pSDevSlnSysRef, null);
        }
    }

    protected void onUpdateLinkState(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateLinkState]");
    }

    protected void onFillParentInfo(PSDevSlnSysRef pSDevSlnSysRef, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREF_PSDEVSLNSYSAPI_REFPSDEVSLNSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = (PSDevSlnSysAPI)iService.getDEModel().createEntity();
            pSDevSlnSysAPI.set("PSDEVSLNSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysAPI);
            } else {
                iService.get((IEntity)pSDevSlnSysAPI);
            }
            this.onFillParentInfo_RefPSDevSlnSysAPI(pSDevSlnSysRef, pSDevSlnSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREF_PSDEVSLNSYSSRV_REFPSDEVSLNSYSSRVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = (PSDevSlnSysSrv)iService.getDEModel().createEntity();
            pSDevSlnSysSrv.set("PSDEVSLNSYSSRVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysSrv);
            } else {
                iService.get((IEntity)pSDevSlnSysSrv);
            }
            this.onFillParentInfo_RefPSDevSlnSysSrv(pSDevSlnSysRef, pSDevSlnSysSrv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREF_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysRef, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREF_PSDEVSLNSYS_REFPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_RefPSDevSlnSys(pSDevSlnSysRef, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSREF_PSDEVSLN_REFPSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_RefPSDevSln(pSDevSlnSysRef, pSDevSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnSysRef, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_RefPSDevSlnSysAPI(PSDevSlnSysRef pSDevSlnSysRef, PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        pSDevSlnSysRef.setRefPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        pSDevSlnSysRef.setRefPSDevSlnSysAPIName(pSDevSlnSysAPI.getPSDevSlnSysAPIName());
    }

    protected void onFillParentInfo_RefPSDevSlnSysSrv(PSDevSlnSysRef pSDevSlnSysRef, PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        pSDevSlnSysRef.setRefPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
        pSDevSlnSysRef.setRefPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysRef pSDevSlnSysRef, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysRef.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysRef.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysRef.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_RefPSDevSlnSys(PSDevSlnSysRef pSDevSlnSysRef, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysRef.setRefPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysRef.setRefPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_RefPSDevSln(PSDevSlnSysRef pSDevSlnSysRef, PSDevSln pSDevSln) throws Exception {
        pSDevSlnSysRef.setRefPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSysRef.setRefPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSysRef.getLinkFlag() == null) {
                pSDevSlnSysRef.setLinkFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSysRef.getLinkState() == null) {
                pSDevSlnSysRef.setLinkState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnSysRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnSysAPI(pSDevSlnSysRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnSysSrv(pSDevSlnSysRef, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysRef, bl);
        this.onFillEntityFullInfo_RefPSDevSlnSys(pSDevSlnSysRef, bl);
        this.onFillEntityFullInfo_RefPSDevSln(pSDevSlnSysRef, bl);
    }

    protected void onFillEntityFullInfo_RefPSDevSlnSysAPI(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSlnSysSrv(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSlnSys(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDevSln(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnSysRef, bl);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase) throws Exception {
        return this.selectByRefPSDevSlnSysAPI(pSDevSlnSysAPIBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string) throws Exception {
        return this.selectByRefPSDevSlnSysAPI(pSDevSlnSysAPIBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysAPI(PSDevSlnSysAPIBase pSDevSlnSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNSYSAPIID", (Object)pSDevSlnSysAPIBase.getPSDevSlnSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase) throws Exception {
        return this.selectByRefPSDevSlnSysSrv(pSDevSlnSysSrvBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string) throws Exception {
        return this.selectByRefPSDevSlnSysSrv(pSDevSlnSysSrvBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNSYSSRVID", (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnSysSrvCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnSysSrvCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRef> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByRefPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByRefPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByRefPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByRefPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnSysRef> selectByRefPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysAPI(pSDevSlnSysAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREF_PSDEVSLNSYSAPI_REFPSDEVSLNSYSAPIID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREF", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysAPI), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysAPI(pSDevSlnSysAPI);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            PSDevSlnSysRef pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getDEModel().createEntity();
            pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRef2.setRefPSDevSlnSysAPIId(null);
            this.update(pSDevSlnSysRef2);
        }
    }

    public void removeByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        final PSDevSlnSysAPI pSDevSlnSysAPI2 = pSDevSlnSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefServiceBase.this.onBeforeRemoveByRefPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnSysRefServiceBase.this.internalRemoveByRefPSDevSlnSysAPI(pSDevSlnSysAPI2);
                PSDevSlnSysRefServiceBase.this.onAfterRemoveByRefPSDevSlnSysAPI(pSDevSlnSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysAPI(pSDevSlnSysAPI);
        this.onBeforeRemoveByRefPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            this.remove((IEntity)pSDevSlnSysRef);
        }
        this.onAfterRemoveByRefPSDevSlnSysAPI(pSDevSlnSysAPI, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnSysAPI(PSDevSlnSysAPI pSDevSlnSysAPI, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysSrv(pSDevSlnSysSrv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSSRV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysSrv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREF_PSDEVSLNSYSSRV_REFPSDEVSLNSYSSRVID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREF", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysSrv), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysSrv(pSDevSlnSysSrv);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            PSDevSlnSysRef pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getDEModel().createEntity();
            pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRef2.setRefPSDevSlnSysSrvId(null);
            this.update(pSDevSlnSysRef2);
        }
    }

    public void removeByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        final PSDevSlnSysSrv pSDevSlnSysSrv2 = pSDevSlnSysSrv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefServiceBase.this.onBeforeRemoveByRefPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnSysRefServiceBase.this.internalRemoveByRefPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnSysRefServiceBase.this.onAfterRemoveByRefPSDevSlnSysSrv(pSDevSlnSysSrv2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSysSrv(pSDevSlnSysSrv);
        this.onBeforeRemoveByRefPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            this.remove((IEntity)pSDevSlnSysRef);
        }
        this.onAfterRemoveByRefPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            PSDevSlnSysRef pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getDEModel().createEntity();
            pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRef2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysRef2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            this.remove((IEntity)pSDevSlnSysRef);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREF_PSDEVSLNSYS_REFPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREF", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            PSDevSlnSysRef pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getDEModel().createEntity();
            pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRef2.setRefPSDevSlnSysId(null);
            this.update(pSDevSlnSysRef2);
        }
    }

    public void removeByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefServiceBase.this.onBeforeRemoveByRefPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefServiceBase.this.internalRemoveByRefPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysRefServiceBase.this.onAfterRemoveByRefPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByRefPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            this.remove((IEntity)pSDevSlnSysRef);
        }
        this.onAfterRemoveByRefPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSREF_PSDEVSLN_REFPSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSREF", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetRefPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSln(pSDevSln);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            PSDevSlnSysRef pSDevSlnSysRef2 = (PSDevSlnSysRef)this.getDEModel().createEntity();
            pSDevSlnSysRef2.setPSDevSlnSysRefId(pSDevSlnSysRef.getPSDevSlnSysRefId());
            pSDevSlnSysRef2.setRefPSDevSlnId(null);
            this.update(pSDevSlnSysRef2);
        }
    }

    public void removeByRefPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysRefServiceBase.this.onBeforeRemoveByRefPSDevSln(pSDevSln2);
                PSDevSlnSysRefServiceBase.this.internalRemoveByRefPSDevSln(pSDevSln2);
                PSDevSlnSysRefServiceBase.this.onAfterRemoveByRefPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByRefPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysRef> arrayList = this.selectByRefPSDevSln(pSDevSln);
        this.onBeforeRemoveByRefPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnSysRef pSDevSlnSysRef : arrayList) {
            this.remove((IEntity)pSDevSlnSysRef);
        }
        this.onAfterRemoveByRefPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByRefPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysRef> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        PSDevSlnSysRefLinkService pSDevSlnSysRefLinkService = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysRefLinkService.testRemoveByPSDevSlnSysRef(pSDevSlnSysRef);
        pSDevSlnSysRefLinkService.removeByPSDevSlnSysRef(pSDevSlnSysRef);
        super.onBeforeRemove(pSDevSlnSysRef);
    }

    protected void replaceParentInfo(PSDevSlnSysRef pSDevSlnSysRef, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnSysRef, cloneSession);
        if (pSDevSlnSysRef.getRefPSDevSlnSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPI", (Object)pSDevSlnSysRef.getRefPSDevSlnSysAPIId())) != null) {
            this.onFillParentInfo_RefPSDevSlnSysAPI(pSDevSlnSysRef, (PSDevSlnSysAPI)iEntity);
        }
        if (pSDevSlnSysRef.getRefPSDevSlnSysSrvId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSSRV", (Object)pSDevSlnSysRef.getRefPSDevSlnSysSrvId())) != null) {
            this.onFillParentInfo_RefPSDevSlnSysSrv(pSDevSlnSysRef, (PSDevSlnSysSrv)iEntity);
        }
        if (pSDevSlnSysRef.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysRef.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysRef, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysRef.getRefPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysRef.getRefPSDevSlnSysId())) != null) {
            this.onFillParentInfo_RefPSDevSlnSys(pSDevSlnSysRef, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysRef.getRefPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnSysRef.getRefPSDevSlnId())) != null) {
            this.onFillParentInfo_RefPSDevSln(pSDevSlnSysRef, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnSysRef, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DENames(bl, pSDevSlnSysRef, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreImpDBModel(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreImpUIModel(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreImpWFModel(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpCoreModelOnly(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpMode(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImpUIModel(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkCode(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkFlag(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkRepMsg(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkReqMsg(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkState(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModuleList(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysRefId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysRefName(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefMode(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParam(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParam2(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefParams(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnSysAPIId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnSysId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDevSlnSysSrvId(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SetDENamesFlag(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SetModuleFlag(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysCodeName(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysPkgName(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Usage(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnSysRef, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnSysRef, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DENames(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isDENamesDirty() : !pSDevSlnSysRef.isDENamesDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getDENames();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DENames_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAMES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreImpDBModel(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isIgnoreImpDBModelDirty() : !pSDevSlnSysRef.isIgnoreImpDBModelDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getIgnoreImpDBModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreImpDBModel_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREIMPDBMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreImpUIModel(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isIgnoreImpUIModelDirty() : !pSDevSlnSysRef.isIgnoreImpUIModelDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getIgnoreImpUIModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreImpUIModel_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREIMPUIMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreImpWFModel(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isIgnoreImpWFModelDirty() : !pSDevSlnSysRef.isIgnoreImpWFModelDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getIgnoreImpWFModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreImpWFModel_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREIMPWFMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpCoreModelOnly(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isImpCoreModelOnlyDirty() : !pSDevSlnSysRef.isImpCoreModelOnlyDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getImpCoreModelOnly();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImpCoreModelOnly_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPCOREMODELONLY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpMode(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isImpModeDirty() : !pSDevSlnSysRef.isImpModeDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getImpMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ImpMode_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImpUIModel(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isImpUIModelDirty() : !pSDevSlnSysRef.isImpUIModelDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getImpUIModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImpUIModel_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMPUIMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkCode(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isLinkCodeDirty() : !pSDevSlnSysRef.isLinkCodeDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getLinkCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkCode_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkFlag(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isLinkFlagDirty() : !pSDevSlnSysRef.isLinkFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getLinkFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkFlag_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkRepMsg(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isLinkRepMsgDirty() : !pSDevSlnSysRef.isLinkRepMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getLinkRepMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkRepMsg_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKREPMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkReqMsg(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isLinkReqMsgDirty() : !pSDevSlnSysRef.isLinkReqMsgDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getLinkReqMsg();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkReqMsg_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKREQMSG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkState(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isLinkStateDirty() : !pSDevSlnSysRef.isLinkStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getLinkState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkState_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isMemoDirty() : !pSDevSlnSysRef.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModuleList(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isModuleListDirty() : !pSDevSlnSysRef.isModuleListDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getModuleList();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModuleList_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODULELIST");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isOrderValueDirty() : !pSDevSlnSysRef.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysRef.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysRefId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isPSDevSlnSysRefIdDirty() && !bl2 : !pSDevSlnSysRef.isPSDevSlnSysRefIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getPSDevSlnSysRefId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysRefId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysRefName(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isPSDevSlnSysRefNameDirty() && !bl2 : !pSDevSlnSysRef.isPSDevSlnSysRefNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getPSDevSlnSysRefName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysRefName_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSREFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefMode(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefModeDirty() && !bl2 : !pSDevSlnSysRef.isRefModeDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefMode_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFMODE");
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
                string3 = "PSDEVSLNSYSID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysRefDEModel(), "REFMODE", string3, pSDevSlnSysRef, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REFMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParam(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefParamDirty() : !pSDevSlnSysRef.isRefParamDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParam_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParam2(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefParam2Dirty() : !pSDevSlnSysRef.isRefParam2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParam2_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefParams(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefParamsDirty() : !pSDevSlnSysRef.isRefParamsDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefParams_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefPSDevSlnIdDirty() : !pSDevSlnSysRef.isRefPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnSysAPIId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefPSDevSlnSysAPIIdDirty() : !pSDevSlnSysRef.isRefPSDevSlnSysAPIIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefPSDevSlnSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnSysAPIId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnSysId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefPSDevSlnSysIdDirty() : !pSDevSlnSysRef.isRefPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnSysId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDevSlnSysSrvId(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isRefPSDevSlnSysSrvIdDirty() : !pSDevSlnSysRef.isRefPSDevSlnSysSrvIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getRefPSDevSlnSysSrvId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDevSlnSysSrvId_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEVSLNSYSSRVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SetDENamesFlag(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isSetDENamesFlagDirty() : !pSDevSlnSysRef.isSetDENamesFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getSetDENamesFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SetDENamesFlag_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SETDENAMESFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SetModuleFlag(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isSetModuleFlagDirty() : !pSDevSlnSysRef.isSetModuleFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysRef.getSetModuleFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SetModuleFlag_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SETMODULEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysCodeName(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isSysCodeNameDirty() : !pSDevSlnSysRef.isSysCodeNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getSysCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysCodeName_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysPkgName(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isSysPkgNameDirty() : !pSDevSlnSysRef.isSysPkgNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getSysPkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysPkgName_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Usage(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUsageDirty() : !pSDevSlnSysRef.isUsageDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Usage_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUserCatDirty() : !pSDevSlnSysRef.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUserTagDirty() : !pSDevSlnSysRef.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUserTag2Dirty() : !pSDevSlnSysRef.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUserTag3Dirty() : !pSDevSlnSysRef.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnSysRef pSDevSlnSysRef, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysRef.isUserTag4Dirty() : !pSDevSlnSysRef.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysRef.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDevSlnSysRef, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnSysRef, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysRef pSDevSlnSysRef, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnSysRef, bl);
    }

    public Object getDataContextValue(PSDevSlnSysRef pSDevSlnSysRef, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVSLNSYSSRV", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEVSLNSYSID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEVSLNSYSSRVID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEVSLNSYSSRVNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDevSlnSysRef, "refpsdevslnsysid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue((IEntity)pSDevSlnSysRef, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysRef.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysRef pSDevSlnSysRef, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnSysRef, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DENAMES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DENames_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREIMPDBMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreImpDBModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREIMPUIMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreImpUIModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREIMPWFMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreImpWFModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPCOREMODELONLY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpCoreModelOnly_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMPUIMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImpUIModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKREPMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkRepMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKREQMSG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkReqMsg_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODULELIST", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModuleList_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSREFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysRefName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSSRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysSrvId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEVSLNSYSSRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDevSlnSysSrvName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SETDENAMESFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SetDENamesFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SETMODULEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SetModuleFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Usage_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DENames_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DENAMES", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreImpDBModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreImpUIModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreImpWFModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImpCoreModelOnly_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ImpMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IMPMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImpUIModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKCODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkRepMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKREPMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkReqMsg_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKREQMSG", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModuleList_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODULELIST", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDevSlnSysRefId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysRefName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSREFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAM", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAM2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if ((this.checkFieldSimpleRule("REFPSDEVSLNSYSID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("REFPSDEVSLNSYSID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "psdevslnsysid", "\u5f00\u53d1\u7cfb\u7edf\u4e0d\u80fd\u5f15\u7528\u81ea\u8eab", true)) && this.checkFieldStringLengthRule("REFPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("REFPSDEVSLNSYSID", "PSDEVSLNSYSREF", iEntity, bl2, "")) {
                return null;
            }
            return "(\u5f00\u53d1\u7cfb\u7edf\u4e0d\u80fd\u5f15\u7528\u81ea\u8eab \u5e76\u4e14 \u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysSrvId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSSRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDevSlnSysSrvName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEVSLNSYSSRVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SetDENamesFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SetModuleFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSPKGNAME", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_Usage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USAGE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnSysRef)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysRef pSDevSlnSysRef) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnSysRef);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysRef pSDevSlnSysRef, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSREF");
        if (!bl) {
            pSDevSlnSysRef.setCreateDate(null);
            pSDevSlnSysRef.setCreateMan(null);
            pSDevSlnSysRef.setPSDevSlnSysRefId(null);
            pSDevSlnSysRef.setUpdateDate(null);
            pSDevSlnSysRef.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysRef, xmlNode, bl);
        }
    }
}

