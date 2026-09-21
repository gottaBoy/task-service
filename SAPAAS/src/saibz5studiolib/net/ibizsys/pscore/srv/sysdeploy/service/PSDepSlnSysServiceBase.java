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

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpecBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAPI;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAPIBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAppBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVerBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnParamServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAPIServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAppService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysBDServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDBServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysKeyServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysMQServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysWFServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnUserServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysServiceBase
extends PSCoreSysServiceBase<PSDepSlnSys> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysDEModel pSDepSlnSysDEModel;
    private PSDepSlnSysDAO pSDepSlnSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService";
    }

    public PSDepSlnSysDEModel getPSDepSlnSysDEModel() {
        if (this.pSDepSlnSysDEModel == null) {
            try {
                this.pSDepSlnSysDEModel = (PSDepSlnSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysDEModel();
    }

    public PSDepSlnSysDAO getPSDepSlnSysDAO() {
        if (this.pSDepSlnSysDAO == null) {
            try {
                this.pSDepSlnSysDAO = (PSDepSlnSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDepSlnSys pSDepSlnSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService", (SessionFactory)this.getSessionFactory());
            PSDCContainerSpec pSDCContainerSpec = (PSDCContainerSpec)iService.getDEModel().createEntity();
            pSDCContainerSpec.set("PSDCCONTAINERSPECID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCContainerSpec);
            } else {
                iService.get((IEntity)pSDCContainerSpec);
            }
            this.onFillParentInfo_PSDCContainerSpec(pSDepSlnSys, pSDCContainerSpec);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSln);
            } else {
                iService.get((IEntity)pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnSys, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDEPSYSAPI_PSDEPSYSAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAPIService", (SessionFactory)this.getSessionFactory());
            PSDepSysAPI pSDepSysAPI = (PSDepSysAPI)iService.getDEModel().createEntity();
            pSDepSysAPI.set("PSDEPSYSAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSysAPI);
            } else {
                iService.get((IEntity)pSDepSysAPI);
            }
            this.onFillParentInfo_PSDepSysAPI(pSDepSlnSys, pSDepSysAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDEPSYSAPP_PSDEPSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService", (SessionFactory)this.getSessionFactory());
            PSDepSysApp pSDepSysApp = (PSDepSysApp)iService.getDEModel().createEntity();
            pSDepSysApp.set("PSDEPSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSysApp);
            } else {
                iService.get((IEntity)pSDepSysApp);
            }
            this.onFillParentInfo_PSDepSysApp(pSDepSlnSys, pSDepSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDEPSYSVER_PSDEPSYSVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService", (SessionFactory)this.getSessionFactory());
            PSDepSysVer pSDepSysVer = (PSDepSysVer)iService.getDEModel().createEntity();
            pSDepSysVer.set("PSDEPSYSVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSysVer);
            } else {
                iService.get((IEntity)pSDepSysVer);
            }
            this.onFillParentInfo_PSDepSysVer(pSDepSlnSys, pSDepSysVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSDEPSYS_PSDEPSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService", (SessionFactory)this.getSessionFactory());
            PSDepSys pSDepSys = (PSDepSys)iService.getDEModel().createEntity();
            pSDepSys.set("PSDEPSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSys);
            } else {
                iService.get((IEntity)pSDepSys);
            }
            this.onFillParentInfo_PSDepSys(pSDepSlnSys, pSDepSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYS_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysModelInst);
            } else {
                iService.get((IEntity)pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDepSlnSys, pSSysModelInst);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCContainerSpec(PSDepSlnSys pSDepSlnSys, PSDCContainerSpec pSDCContainerSpec) throws Exception {
        pSDepSlnSys.setPSDCContainerSpecId(pSDCContainerSpec.getPSDCContainerSpecId());
        pSDepSlnSys.setPSDCContainerSpecName(pSDCContainerSpec.getPSDCContainerSpecName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnSys pSDepSlnSys, PSDepSln pSDepSln) throws Exception {
        pSDepSlnSys.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnSys.setPSDepSlnName(pSDepSln.getPSDepSlnName());
        pSDepSlnSys.setPSDevCenterId(pSDepSln.getPSDevCenterId());
        pSDepSlnSys.setPSDevCenterName(pSDepSln.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDepSysAPI(PSDepSlnSys pSDepSlnSys, PSDepSysAPI pSDepSysAPI) throws Exception {
        pSDepSlnSys.setPSDepSysAPIId(pSDepSysAPI.getPSDepSysAPIId());
        pSDepSlnSys.setPSDepSysAPIName(pSDepSysAPI.getPSDepSysAPIName());
    }

    protected void onFillParentInfo_PSDepSysApp(PSDepSlnSys pSDepSlnSys, PSDepSysApp pSDepSysApp) throws Exception {
        pSDepSlnSys.setPSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
        pSDepSlnSys.setPSDepSysAppName(pSDepSysApp.getPSDepSysAppName());
    }

    protected void onFillParentInfo_PSDepSysVer(PSDepSlnSys pSDepSlnSys, PSDepSysVer pSDepSysVer) throws Exception {
        pSDepSlnSys.setPSDepSysVerId(pSDepSysVer.getPSDepSysVerId());
        pSDepSlnSys.setPSDepSysVerName(pSDepSysVer.getPSDepSysVerName());
    }

    protected void onFillParentInfo_PSDepSys(PSDepSlnSys pSDepSlnSys, PSDepSys pSDepSys) throws Exception {
        pSDepSlnSys.setPSDepSysId(pSDepSys.getPSDepSysId());
        pSDepSlnSys.setPSDepSysName(pSDepSys.getPSDepSysName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDepSlnSys pSDepSlnSys, PSSysModelInst pSSysModelInst) throws Exception {
        pSDepSlnSys.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDepSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDCContainerSpec(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDepSysAPI(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDepSysApp(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDepSysVer(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSDepSys(pSDepSlnSys, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDepSlnSys, bl);
    }

    protected void onFillEntityFullInfo_PSDCContainerSpec(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSysAPI(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSysApp(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSysVer(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSys(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnSys, bl);
    }

    public ArrayList<PSDepSlnSys> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string) throws Exception {
        return this.selectByPSDCContainerSpec(pSDCContainerSpecBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDCContainerSpec(PSDCContainerSpecBase pSDCContainerSpecBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCONTAINERSPECID", (Object)pSDCContainerSpecBase.getPSDCContainerSpecId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCContainerSpecCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCContainerSpecCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnSys> selectByPSDepSysAPI(PSDepSysAPIBase pSDepSysAPIBase) throws Exception {
        return this.selectByPSDepSysAPI(pSDepSysAPIBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysAPI(PSDepSysAPIBase pSDepSysAPIBase, String string) throws Exception {
        return this.selectByPSDepSysAPI(pSDepSysAPIBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysAPI(PSDepSysAPIBase pSDepSysAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSAPIID", (Object)pSDepSysAPIBase.getPSDepSysAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase) throws Exception {
        return this.selectByPSDepSysApp(pSDepSysAppBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string) throws Exception {
        return this.selectByPSDepSysApp(pSDepSysAppBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSAPPID", (Object)pSDepSysAppBase.getPSDepSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string) throws Exception {
        return this.selectByPSDepSysVer(pSDepSysVerBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSysVer(PSDepSysVerBase pSDepSysVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSVERID", (Object)pSDepSysVerBase.getPSDepSysVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSys(PSDepSysBase pSDepSysBase) throws Exception {
        return this.selectByPSDepSys(pSDepSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSys(PSDepSysBase pSDepSysBase, String string) throws Exception {
        return this.selectByPSDepSys(pSDepSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSDepSys(PSDepSysBase pSDepSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSID", (Object)pSDepSysBase.getPSDepSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDepSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCCONTAINERSPEC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCContainerSpec);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDCCONTAINERSPEC_PSDCCONTAINERSPECID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDCContainerSpec), arrayList.get(0)));
        }
    }

    public void resetPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDCContainerSpecId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        final PSDCContainerSpec pSDCContainerSpec2 = pSDCContainerSpec;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDCContainerSpec(pSDCContainerSpec2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void internalRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDCContainerSpec(pSDCContainerSpec);
        this.onBeforeRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDCContainerSpec(pSDCContainerSpec, arrayList);
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec) throws Exception {
    }

    protected void onBeforeRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCContainerSpec(PSDCContainerSpec pSDCContainerSpec, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDepSlnId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysAPI(pSDepSysAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSysAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDEPSYSAPI_PSDEPSYSAPIID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDepSysAPI), arrayList.get(0)));
        }
    }

    public void resetPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysAPI(pSDepSysAPI);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDepSysAPIId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
        final PSDepSysAPI pSDepSysAPI2 = pSDepSysAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDepSysAPI(pSDepSysAPI2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDepSysAPI(pSDepSysAPI2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDepSysAPI(pSDepSysAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
    }

    protected void internalRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysAPI(pSDepSysAPI);
        this.onBeforeRemoveByPSDepSysAPI(pSDepSysAPI, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDepSysAPI(pSDepSysAPI, arrayList);
    }

    protected void onAfterRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysAPI(PSDepSysAPI pSDepSysAPI, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysApp(pSDepSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDEPSYSAPP_PSDEPSYSAPPID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDepSysApp), arrayList.get(0)));
        }
    }

    public void resetPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysApp(pSDepSysApp);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDepSysAppId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        final PSDepSysApp pSDepSysApp2 = pSDepSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDepSysApp(pSDepSysApp2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDepSysApp(pSDepSysApp2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDepSysApp(pSDepSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void internalRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysApp(pSDepSysApp);
        this.onBeforeRemoveByPSDepSysApp(pSDepSysApp, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDepSysApp(pSDepSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysVer(pSDepSysVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSysVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDEPSYSVER_PSDEPSYSVERID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDepSysVer), arrayList.get(0)));
        }
    }

    public void resetPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDepSysVerId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        final PSDepSysVer pSDepSysVer2 = pSDepSysVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDepSysVer(pSDepSysVer2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDepSysVer(pSDepSysVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void internalRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSysVer(pSDepSysVer);
        this.onBeforeRemoveByPSDepSysVer(pSDepSysVer, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDepSysVer(pSDepSysVer, arrayList);
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysVer(PSDepSysVer pSDepSysVer, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSys(pSDepSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSDEPSYS_PSDEPSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSDepSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSys(pSDepSys);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSDepSysId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSDepSys(PSDepSys pSDepSys) throws Exception {
        final PSDepSys pSDepSys2 = pSDepSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSDepSys(pSDepSys2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSDepSys(pSDepSys2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSDepSys(pSDepSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
    }

    protected void internalRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSDepSys(pSDepSys);
        this.onBeforeRemoveByPSDepSys(pSDepSys, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSDepSys(pSDepSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSys(PSDepSys pSDepSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSys(PSDepSys pSDepSys, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSys(PSDepSys pSDepSys, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYS_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEPSLNSYS", iDataEntityModel.getDataInfo((IEntity)pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            PSDepSlnSys pSDepSlnSys2 = (PSDepSlnSys)this.getDEModel().createEntity();
            pSDepSlnSys2.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
            pSDepSlnSys2.setPSSysModelInstId(null);
            this.update(pSDepSlnSys2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSlnSysServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDepSlnSysServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDepSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDepSlnSys pSDepSlnSys : arrayList) {
            this.remove((IEntity)pSDepSlnSys);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDepSlnSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSys pSDepSlnSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnParamService)ServiceGlobal.getService(PSDepSlnParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnParamServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        ((PSDepSlnParamServiceBase)pSCoreSysServiceBase).removeByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysAPIService)ServiceGlobal.getService(PSDepSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysAppService)ServiceGlobal.getService(PSDepSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysBDService)ServiceGlobal.getService(PSDepSlnSysBDService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysBDServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        ((PSDepSlnSysBDServiceBase)pSCoreSysServiceBase).removeByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysDBService)ServiceGlobal.getService(PSDepSlnSysDBService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysDBServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysFileService)ServiceGlobal.getService(PSDepSlnSysFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysFileServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        ((PSDepSlnSysFileServiceBase)pSCoreSysServiceBase).removeByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysKeyService)ServiceGlobal.getService(PSDepSlnSysKeyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysKeyServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        ((PSDepSlnSysKeyServiceBase)pSCoreSysServiceBase).resetPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysMQService)ServiceGlobal.getService(PSDepSlnSysMQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysMQServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnSysWFService)ServiceGlobal.getService(PSDepSlnSysWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysWFServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        ((PSDepSlnSysWFServiceBase)pSCoreSysServiceBase).removeByPSDepSlnSys(pSDepSlnSys);
        pSCoreSysServiceBase = (PSDepSlnUserService)ServiceGlobal.getService(PSDepSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnSys(pSDepSlnSys);
        super.onBeforeRemove(pSDepSlnSys);
    }

    protected void replaceParentInfo(PSDepSlnSys pSDepSlnSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnSys, cloneSession);
        if (pSDepSlnSys.getPSDCContainerSpecId() != null && (iEntity = cloneSession.getEntity("PSDCCONTAINERSPEC", (Object)pSDepSlnSys.getPSDCContainerSpecId())) != null) {
            this.onFillParentInfo_PSDCContainerSpec(pSDepSlnSys, (PSDCContainerSpec)iEntity);
        }
        if (pSDepSlnSys.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnSys.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnSys, (PSDepSln)iEntity);
        }
        if (pSDepSlnSys.getPSDepSysAPIId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSAPI", (Object)pSDepSlnSys.getPSDepSysAPIId())) != null) {
            this.onFillParentInfo_PSDepSysAPI(pSDepSlnSys, (PSDepSysAPI)iEntity);
        }
        if (pSDepSlnSys.getPSDepSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSAPP", (Object)pSDepSlnSys.getPSDepSysAppId())) != null) {
            this.onFillParentInfo_PSDepSysApp(pSDepSlnSys, (PSDepSysApp)iEntity);
        }
        if (pSDepSlnSys.getPSDepSysVerId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSVER", (Object)pSDepSlnSys.getPSDepSysVerId())) != null) {
            this.onFillParentInfo_PSDepSysVer(pSDepSlnSys, (PSDepSysVer)iEntity);
        }
        if (pSDepSlnSys.getPSDepSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSYS", (Object)pSDepSlnSys.getPSDepSysId())) != null) {
            this.onFillParentInfo_PSDepSys(pSDepSlnSys, (PSDepSys)iEntity);
        }
        if (pSDepSlnSys.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDepSlnSys.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDepSlnSys, (PSSysModelInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ContentType(bl, pSDepSlnSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPULimit(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DepSysState(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MemoryLimit(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCContainerSpecId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysName(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAPIId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAppId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysVerId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Replication(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isContentTypeDirty() && !bl2 : !pSDepSlnSys.isContentTypeDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getContentType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CPULimit(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isCPULimitDirty() : !pSDepSlnSys.isCPULimitDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getCPULimit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CPULimit_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPULIMIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DepSysState(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isDepSysStateDirty() : !pSDepSlnSys.isDepSysStateDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getDepSysState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DepSysState_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPSYSSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isEnableDynaSysDirty() : !pSDepSlnSys.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isExpriedTimeDirty() : !pSDepSlnSys.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDepSlnSys.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isMemoDirty() : !pSDepSlnSys.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_MemoryLimit(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isMemoryLimitDirty() : !pSDepSlnSys.isMemoryLimitDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getMemoryLimit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MemoryLimit_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMORYLIMIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCContainerSpecId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDCContainerSpecIdDirty() : !pSDepSlnSys.isPSDCContainerSpecIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDCContainerSpecId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCContainerSpecId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCONTAINERSPECID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnSys.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default((IEntity)pSDepSlnSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSlnSysIdDirty() && !bl2 : !pSDepSlnSys.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default((IEntity)pSDepSlnSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysName(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSlnSysNameDirty() && !bl2 : !pSDepSlnSys.isPSDepSlnSysNameDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSlnSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysName_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAPIId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSysAPIIdDirty() : !pSDepSlnSys.isPSDepSysAPIIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSysAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAPIId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAppId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSysAppIdDirty() : !pSDepSlnSys.isPSDepSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAppId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSysIdDirty() : !pSDepSlnSys.isPSDepSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysVerId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSDepSysVerIdDirty() : !pSDepSlnSys.isPSDepSysVerIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSDepSysVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysVerId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSSysModelInstIdDirty() : !pSDepSlnSys.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isPSSystemIdDirty() : !pSDepSlnSys.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDepSlnSys.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Replication(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isReplicationDirty() : !pSDepSlnSys.isReplicationDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getReplication();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Replication_Default((IEntity)pSDepSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPLICATION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSlnSys pSDepSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSys.isValidFlagDirty() : !pSDepSlnSys.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSlnSys.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDepSlnSys, bl2, bl3);
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

    protected void onSyncEntity(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnSys, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSys pSDepSlnSys, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnSys, bl);
    }

    public Object getDataContextValue(PSDepSlnSys pSDepSlnSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnSys, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnSys.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSys pSDepSlnSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPULIMIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPULimit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSYSSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepSysState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMORYLIMIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MemoryLimit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCONTAINERSPECNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCContainerSpecName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPLICATION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Replication_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPULimit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DepSysState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MemoryLimit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCContainerSpecId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCContainerSpecName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCONTAINERSPECNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDepSysAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Replication_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSys pSDepSlnSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSys pSDepSlnSys) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnSys);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSys pSDepSlnSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYS");
        if (!bl) {
            pSDepSlnSys.setCreateDate(null);
            pSDepSlnSys.setCreateMan(null);
            pSDepSlnSys.setPSDCContainerSpecName(null);
            pSDepSlnSys.setPSDepSlnSysId(null);
            pSDepSlnSys.setPSDepSysAPIName(null);
            pSDepSlnSys.setPSDepSysAppName(null);
            pSDepSlnSys.setUpdateDate(null);
            pSDepSlnSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSys, xmlNode, bl);
        }
    }
}

