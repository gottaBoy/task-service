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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrvBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnTemplServiceBase
extends PSCoreSysServiceBase<PSDevSlnTempl> {
    private static final Log log = LogFactory.getLog(PSDevSlnTemplServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNTRUNK = "CurSlnTrunk";
    public static final String DATASET_CURTEMPLBRANCH = "CurTemplBranch";
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSER3 = "CurUser3";
    public static final String DATASET_CURUSER4 = "CurUser4";
    public static final String DATASET_CURUSERALL = "CurUserAll";
    public static final String DATASET_CURUSERTRUNK = "CurUserTrunk";
    public static final String DATASET_CURUSERTRUNK3 = "CurUserTrunk3";
    public static final String DATASET_CURUSERTRUNK4 = "CurUserTrunk4";
    public static final String DATASET_CURUSERTRUNK5 = "CurUserTrunk5";
    public static final String DATASET_CURUSERTRUNK6 = "CurUserTrunk6";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_GETWITHREPO = "GetWithRepo";
    public static final String ACTION_PUBTEMPL = "PubTempl";
    private PSDevSlnTemplDEModel pSDevSlnTemplDEModel;
    private PSDevSlnTemplDAO pSDevSlnTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService";
    }

    public PSDevSlnTemplDEModel getPSDevSlnTemplDEModel() {
        if (this.pSDevSlnTemplDEModel == null) {
            try {
                this.pSDevSlnTemplDEModel = (PSDevSlnTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnTemplDEModel();
    }

    public PSDevSlnTemplDAO getPSDevSlnTemplDAO() {
        if (this.pSDevSlnTemplDAO == null) {
            try {
                this.pSDevSlnTemplDAO = (PSDevSlnTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnTemplDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNTRUNK, (boolean)true) == 0) {
            return this.fetchCurSlnTrunk(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURTEMPLBRANCH, (boolean)true) == 0) {
            return this.fetchCurTemplBranch(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER, (boolean)true) == 0) {
            return this.fetchCurUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER3, (boolean)true) == 0) {
            return this.fetchCurUser3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER4, (boolean)true) == 0) {
            return this.fetchCurUser4(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERALL, (boolean)true) == 0) {
            return this.fetchCurUserAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK, (boolean)true) == 0) {
            return this.fetchCurUserTrunk(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK3, (boolean)true) == 0) {
            return this.fetchCurUserTrunk3(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK4, (boolean)true) == 0) {
            return this.fetchCurUserTrunk4(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK5, (boolean)true) == 0) {
            return this.fetchCurUserTrunk5(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK6, (boolean)true) == 0) {
            return this.fetchCurUserTrunk6(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHREPO, (boolean)true) == 0) {
            this.getWithRepo((PSDevSlnTempl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PUBTEMPL, (boolean)true) == 0) {
            this.pubTempl((PSDevSlnTempl)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnTrunk(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNTRUNK, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurTemplBranch(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURTEMPLBRANCH, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser4(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER4, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK3, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk4(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK4, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk5(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK5, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk6(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK6, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void getWithRepo(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHREPO, 0, (IEntity)pSDevSlnTempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnTempl, ACTION_GETWITHREPO);
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnTemplServiceBase.this.getService(), PSDevSlnTemplServiceBase.ACTION_GETWITHREPO, 40, (IEntity)pSDevSlnTempl2, null).getResult() != 1) {
                    PSDevSlnTemplServiceBase.this.onGetWithRepo(pSDevSlnTempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHREPO, 99, (IEntity)pSDevSlnTempl, null);
        }
    }

    protected void onGetWithRepo(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithRepo]");
    }

    public void pubTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PUBTEMPL, 0, (IEntity)pSDevSlnTempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnTempl, ACTION_PUBTEMPL);
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnTemplServiceBase.this.getService(), PSDevSlnTemplServiceBase.ACTION_PUBTEMPL, 40, (IEntity)pSDevSlnTempl2, null).getResult() != 1) {
                    PSDevSlnTemplServiceBase.this.onPubTempl(pSDevSlnTempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PUBTEMPL, 99, (IEntity)pSDevSlnTempl, null);
        }
    }

    protected void onPubTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PubTempl]");
    }

    protected void onFillParentInfo(PSDevSlnTempl pSDevSlnTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnTempl, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = (PSDevSlnSysApp)iService.getDEModel().createEntity();
            pSDevSlnSysApp.set("PSDEVSLNSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysApp);
            } else {
                iService.get((IEntity)pSDevSlnSysApp);
            }
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnTempl, pSDevSlnSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = (PSDevSlnSysSrv)iService.getDEModel().createEntity();
            pSDevSlnSysSrv.set("PSDEVSLNSYSSRVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysSrv);
            } else {
                iService.get((IEntity)pSDevSlnSysSrv);
            }
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnTempl, pSDevSlnSysSrv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnTempl, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_MAINPSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl2.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnTempl2);
            } else {
                iService.get((IEntity)pSDevSlnTempl2);
            }
            this.onFillParentInfo_MainPSDevSlnTempl(pSDevSlnTempl, pSDevSlnTempl2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_PPSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl3 = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl3.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnTempl3);
            } else {
                iService.get((IEntity)pSDevSlnTempl3);
            }
            this.onFillParentInfo_PPSDevSlnTempl(pSDevSlnTempl, pSDevSlnTempl3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnTempl, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFStyle);
            } else {
                iService.get((IEntity)pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSDevSlnTempl, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSPFSTYLE_TEMPLPSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFStyle);
            } else {
                iService.get((IEntity)pSPFStyle);
            }
            this.onFillParentInfo_TemplPSPFStyle(pSDevSlnTempl, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSDevSlnTempl, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSDevSlnTempl, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSSFSTYLE_TEMPLPSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_TemplPSSFStyle(pSDevSlnTempl, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNTEMPL_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSF);
            } else {
                iService.get((IEntity)pSSF);
            }
            this.onFillParentInfo_PSSF(pSDevSlnTempl, pSSF);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnTempl pSDevSlnTempl, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnTempl.setGitBranch(pSDevCenterSVN.getGitBranch());
        pSDevSlnTempl.setGitPath(pSDevCenterSVN.getGitPath());
        pSDevSlnTempl.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnTempl.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevSlnSysApp(PSDevSlnTempl pSDevSlnTempl, PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        pSDevSlnTempl.setPSDevSlnSysAppId(pSDevSlnSysApp.getPSDevSlnSysAppId());
        pSDevSlnTempl.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
    }

    protected void onFillParentInfo_PSDevSlnSysSrv(PSDevSlnTempl pSDevSlnTempl, PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        pSDevSlnTempl.setPSDevSlnSysSrvId(pSDevSlnSysSrv.getPSDevSlnSysSrvId());
        pSDevSlnTempl.setPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnTempl pSDevSlnTempl, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnTempl.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnTempl.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_MainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, PSDevSlnTempl pSDevSlnTempl2) throws Exception {
        pSDevSlnTempl.setMainPSDevSlnTemplId(pSDevSlnTempl2.getPSDevSlnTemplId());
        pSDevSlnTempl.setMainPSDevSlnTemplName(pSDevSlnTempl2.getPSDevSlnTemplName());
        if (pSDevSlnTempl2.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnTempl, pSDevSlnTempl2.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, PSDevSlnTempl pSDevSlnTempl2) throws Exception {
        pSDevSlnTempl.setPPSDevSlnTemplId(pSDevSlnTempl2.getPSDevSlnTemplId());
        pSDevSlnTempl.setPPSDevSlnTemplName(pSDevSlnTempl2.getPSDevSlnTemplName());
        if (pSDevSlnTempl2.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnTempl, pSDevSlnTempl2.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnTempl pSDevSlnTempl, PSDevSln pSDevSln) throws Exception {
        pSDevSlnTempl.setPSDevCenterId(pSDevSln.getPSDevCenterId());
        pSDevSlnTempl.setPSDevCenterName(pSDevSln.getPSDevCenterName());
        pSDevSlnTempl.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnTempl.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSPFStyle(PSDevSlnTempl pSDevSlnTempl, PSPFStyle pSPFStyle) throws Exception {
        pSDevSlnTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSDevSlnTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_TemplPSPFStyle(PSDevSlnTempl pSDevSlnTempl, PSPFStyle pSPFStyle) throws Exception {
        pSDevSlnTempl.setTemplPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSDevSlnTempl.setTemplPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSDevSlnTempl pSDevSlnTempl, PSPF pSPF) throws Exception {
        pSDevSlnTempl.setPSPFId(pSPF.getPSPFId());
        pSDevSlnTempl.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSFStyle(PSDevSlnTempl pSDevSlnTempl, PSSFStyle pSSFStyle) throws Exception {
        pSDevSlnTempl.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSDevSlnTempl.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_TemplPSSFStyle(PSDevSlnTempl pSDevSlnTempl, PSSFStyle pSSFStyle) throws Exception {
        pSDevSlnTempl.setTemplPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSDevSlnTempl.setTemplPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSDevSlnTempl pSDevSlnTempl, PSSF pSSF) throws Exception {
        pSDevSlnTempl.setPSSFId(pSSF.getPSSFId());
        pSDevSlnTempl.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnTempl.getDevTemplState() == null) {
                pSDevSlnTempl.setDevTemplState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnTempl.getEnableRef() == null) {
                pSDevSlnTempl.setEnableRef((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnTempl.getStyleEngine() == null) {
                pSDevSlnTempl.setStyleEngine((String)this.getDefaultValue(this.getWebContext(), "", "V2", 25));
            }
            if (pSDevSlnTempl.getVCType() == null) {
                pSDevSlnTempl.setVCType((String)this.getDefaultValue(this.getWebContext(), "", "TRUNK", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSDevSlnSysApp(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSDevSlnSysSrv(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_MainPSDevSlnTempl(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PPSDevSlnTempl(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_TemplPSPFStyle(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSPF(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_TemplPSSFStyle(pSDevSlnTempl, bl);
        this.onFillEntityFullInfo_PSSF(pSDevSlnTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isPSDevCenterSVNIdDirty()) {
            if (pSDevSlnTempl.getPSDevCenterSVNId() != null) {
                if (pSDevSlnTempl.getPSDevCenterSVNId() == null || pSDevSlnTempl.getPSDevCenterSVNName() == null) {
                    PSDevCenterSVN pSDevCenterSVN = pSDevSlnTempl.getPSDevCenterSVN();
                    pSDevSlnTempl.setGitBranch(pSDevCenterSVN.getGitBranch());
                    pSDevSlnTempl.setGitPath(pSDevCenterSVN.getGitPath());
                    pSDevSlnTempl.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                }
            } else {
                pSDevSlnTempl.setGitBranch(null);
                pSDevSlnTempl.setGitPath(null);
                pSDevSlnTempl.setPSDevCenterSVNName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysApp(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isPSDevSlnSysAppIdDirty()) {
            if (pSDevSlnTempl.getPSDevSlnSysAppId() != null) {
                if (pSDevSlnTempl.getPSDevSlnSysAppId() == null || pSDevSlnTempl.getPSDevSlnSysAppName() == null) {
                    PSDevSlnSysApp pSDevSlnSysApp = pSDevSlnTempl.getPSDevSlnSysApp();
                    pSDevSlnTempl.setPSDevSlnSysAppName(pSDevSlnSysApp.getPSDevSlnSysAppName());
                }
            } else {
                pSDevSlnTempl.setPSDevSlnSysAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysSrv(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isPSDevSlnSysSrvIdDirty()) {
            if (pSDevSlnTempl.getPSDevSlnSysSrvId() != null) {
                if (pSDevSlnTempl.getPSDevSlnSysSrvId() == null || pSDevSlnTempl.getPSDevSlnSysSrvName() == null) {
                    PSDevSlnSysSrv pSDevSlnSysSrv = pSDevSlnTempl.getPSDevSlnSysSrv();
                    pSDevSlnTempl.setPSDevSlnSysSrvName(pSDevSlnSysSrv.getPSDevSlnSysSrvName());
                }
            } else {
                pSDevSlnTempl.setPSDevSlnSysSrvName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isPSDevSlnSysIdDirty()) {
            if (pSDevSlnTempl.getPSDevSlnSysId() != null) {
                if (pSDevSlnTempl.getPSDevSlnSysId() == null || pSDevSlnTempl.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDevSlnTempl.getPSDevSlnSys();
                    pSDevSlnTempl.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDevSlnTempl.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isMainPSDevSlnTemplIdDirty()) {
            if (pSDevSlnTempl.getMainPSDevSlnTemplId() != null) {
                PSDevSlnTempl pSDevSlnTempl2;
                if (pSDevSlnTempl.getMainPSDevSlnTemplId() == null || pSDevSlnTempl.getMainPSDevSlnTemplName() == null) {
                    pSDevSlnTempl2 = pSDevSlnTempl.getMainPSDevSlnTempl();
                    pSDevSlnTempl.setMainPSDevSlnTemplName(pSDevSlnTempl2.getPSDevSlnTemplName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDevSlnTempl2 = pSDevSlnTempl.getMainPSDevSlnTempl()).getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnId()) != 0L) {
                    pSDevSlnTempl.setPSDevSlnId(pSDevSlnTempl2.getPSDevSlnId());
                    this.onFillEntityFullInfo_PSDevSln(pSDevSlnTempl, bl);
                }
            } else {
                pSDevSlnTempl.setMainPSDevSlnTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        if (pSDevSlnTempl.isPPSDevSlnTemplIdDirty()) {
            if (pSDevSlnTempl.getPPSDevSlnTemplId() != null) {
                PSDevSlnTempl pSDevSlnTempl2;
                if (pSDevSlnTempl.getPPSDevSlnTemplId() == null || pSDevSlnTempl.getPPSDevSlnTemplName() == null) {
                    pSDevSlnTempl2 = pSDevSlnTempl.getPPSDevSlnTempl();
                    pSDevSlnTempl.setPPSDevSlnTemplName(pSDevSlnTempl2.getPSDevSlnTemplName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDevSlnTempl2 = pSDevSlnTempl.getPPSDevSlnTempl()).getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnId()) != 0L) {
                    pSDevSlnTempl.setPSDevSlnId(pSDevSlnTempl2.getPSDevSlnId());
                    this.onFillEntityFullInfo_PSDevSln(pSDevSlnTempl, bl);
                }
            } else {
                pSDevSlnTempl.setPPSDevSlnTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TemplPSPFStyle(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TemplPSSFStyle(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnTempl, bl);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string) throws Exception {
        return this.selectByPSDevSlnSysApp(pSDevSlnSysAppBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysApp(PSDevSlnSysAppBase pSDevSlnSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSAPPID", (Object)pSDevSlnSysAppBase.getPSDevSlnSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string) throws Exception {
        return this.selectByPSDevSlnSysSrv(pSDevSlnSysSrvBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSysSrv(PSDevSlnSysSrvBase pSDevSlnSysSrvBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSSRVID", (Object)pSDevSlnSysSrvBase.getPSDevSlnSysSrvId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysSrvCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysSrvCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnTempl> selectByMainPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByMainPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByMainPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByMainPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByMainPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAINPSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMainPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMainPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByTemplPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByTemplPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLPSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByTemplPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByTemplPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByTemplPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEMPLPSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTemplPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTemplPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnTempl> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSDevSlnTempl> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysApp), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSDevSlnSysAppId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        final PSDevSlnSysApp pSDevSlnSysApp2 = pSDevSlnSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysApp(pSDevSlnSysApp);
        this.onBeforeRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSDevSlnSysApp(pSDevSlnSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysApp(PSDevSlnSysApp pSDevSlnSysApp, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSSRV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysSrv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysSrv), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSDevSlnSysSrvId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        final PSDevSlnSysSrv pSDevSlnSysSrv2 = pSDevSlnSysSrv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSysSrv(pSDevSlnSysSrv);
        this.onBeforeRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSDevSlnSysSrv(pSDevSlnSysSrv, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysSrv(PSDevSlnSysSrv pSDevSlnSysSrv, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSDevSlnSysId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByMainPSDevSlnTempl(pSDevSlnTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_MAINPSDEVSLNTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSlnTempl), arrayList.get(0)));
        }
    }

    public void resetMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByMainPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnTempl pSDevSlnTempl2 : arrayList) {
            PSDevSlnTempl pSDevSlnTempl3 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl3.setPSDevSlnTemplId(pSDevSlnTempl2.getPSDevSlnTemplId());
            pSDevSlnTempl3.setMainPSDevSlnTemplId(null);
            this.update(pSDevSlnTempl3);
        }
    }

    public void removeByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByMainPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplServiceBase.this.internalRemoveByMainPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByMainPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByMainPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByMainPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl2 : arrayList) {
            this.remove((IEntity)pSDevSlnTempl2);
        }
        this.onAfterRemoveByMainPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMainPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPPSDevSlnTempl(pSDevSlnTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_PPSDEVSLNTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSlnTempl), arrayList.get(0)));
        }
    }

    public void resetPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPPSDevSlnTempl(pSDevSlnTempl);
        for (PSDevSlnTempl pSDevSlnTempl2 : arrayList) {
            PSDevSlnTempl pSDevSlnTempl3 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl3.setPSDevSlnTemplId(pSDevSlnTempl2.getPSDevSlnTemplId());
            pSDevSlnTempl3.setPPSDevSlnTemplId(null);
            this.update(pSDevSlnTempl3);
        }
    }

    public void removeByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPPSDevSlnTempl(pSDevSlnTempl2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl2 : arrayList) {
            this.remove((IEntity)pSDevSlnTempl2);
        }
        this.onAfterRemoveByPPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSDevSlnId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSPFStyleId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByTemplPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_TEMPLPSPFSTYLEID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByTemplPSPFStyle(pSPFStyle);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setTemplPSPFStyleId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByTemplPSPFStyle(pSPFStyle2);
                PSDevSlnTemplServiceBase.this.internalRemoveByTemplPSPFStyle(pSPFStyle2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByTemplPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByTemplPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByTemplPSPFStyle(pSPFStyle, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByTemplPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPF(pSPF);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSPFId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSSFStyleId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByTemplPSSFStyle(pSSFStyle);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setTemplPSSFStyleId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByTemplPSSFStyle(pSSFStyle2);
                PSDevSlnTemplServiceBase.this.internalRemoveByTemplPSSFStyle(pSSFStyle2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByTemplPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByTemplPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByTemplPSSFStyle(pSSFStyle, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByTemplPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTemplPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNTEMPL_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSDEVSLNTEMPL", iDataEntityModel.getDataInfo((IEntity)pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSF(pSSF);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getDEModel().createEntity();
            pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTempl2.setPSSFId(null);
            this.update(pSDevSlnTempl2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSDevSlnTemplServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSDevSlnTemplServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnTempl> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSDevSlnTempl pSDevSlnTempl : arrayList) {
            this.remove((IEntity)pSDevSlnTempl);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSDevSlnTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnLinkService)ServiceGlobal.getService(PSDevSlnLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnTemplRefService)ServiceGlobal.getService(PSDevSlnTemplRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnTempl(pSDevSlnTempl);
        ((PSDevSlnTemplRefServiceBase)pSCoreSysServiceBase).removeByPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnTemplRefService)ServiceGlobal.getService(PSDevSlnTemplRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSlnTempl(pSDevSlnTempl);
        ((PSDevSlnTemplRefServiceBase)pSCoreSysServiceBase).resetRefPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByMainPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserCSServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnTempl(pSDevSlnTempl);
        pSCoreSysServiceBase = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnTempl(pSDevSlnTempl);
        super.onBeforeRemove(pSDevSlnTempl);
    }

    protected void replaceParentInfo(PSDevSlnTempl pSDevSlnTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnTempl, cloneSession);
        if (pSDevSlnTempl.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnTempl.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnTempl, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnTempl.getPSDevSlnSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSAPP", (Object)pSDevSlnTempl.getPSDevSlnSysAppId())) != null) {
            this.onFillParentInfo_PSDevSlnSysApp(pSDevSlnTempl, (PSDevSlnSysApp)iEntity);
        }
        if (pSDevSlnTempl.getPSDevSlnSysSrvId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSSRV", (Object)pSDevSlnTempl.getPSDevSlnSysSrvId())) != null) {
            this.onFillParentInfo_PSDevSlnSysSrv(pSDevSlnTempl, (PSDevSlnSysSrv)iEntity);
        }
        if (pSDevSlnTempl.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnTempl.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnTempl, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnTempl.getMainPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnTempl.getMainPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_MainPSDevSlnTempl(pSDevSlnTempl, (PSDevSlnTempl)iEntity);
        }
        if (pSDevSlnTempl.getPPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSDevSlnTempl.getPPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PPSDevSlnTempl(pSDevSlnTempl, (PSDevSlnTempl)iEntity);
        }
        if (pSDevSlnTempl.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnTempl.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnTempl, (PSDevSln)iEntity);
        }
        if (pSDevSlnTempl.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSDevSlnTempl.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSDevSlnTempl, (PSPFStyle)iEntity);
        }
        if (pSDevSlnTempl.getTemplPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSDevSlnTempl.getTemplPSPFStyleId())) != null) {
            this.onFillParentInfo_TemplPSPFStyle(pSDevSlnTempl, (PSPFStyle)iEntity);
        }
        if (pSDevSlnTempl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDevSlnTempl.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDevSlnTempl, (PSPF)iEntity);
        }
        if (pSDevSlnTempl.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSDevSlnTempl.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSDevSlnTempl, (PSSFStyle)iEntity);
        }
        if (pSDevSlnTempl.getTemplPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSDevSlnTempl.getTemplPSSFStyleId())) != null) {
            this.onFillParentInfo_TemplPSSFStyle(pSDevSlnTempl, (PSSFStyle)iEntity);
        }
        if (pSDevSlnTempl.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSDevSlnTempl.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSDevSlnTempl, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionOwner(bl, pSDevSlnTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurAction(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevTemplState(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRef(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastActiveTime(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastPubDate(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSDevSlnTemplId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSDevSlnTemplName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam2(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam3(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam4(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnTemplId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnTemplName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrvId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysSrvName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplName(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCode(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleCode(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleEngine(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplMDUrl(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplParams(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSPFStyleId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplPSSFStyleId(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplTag(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplTag2(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplType(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2GitPath(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VCType(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerStr(bl, pSDevSlnTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionOwner(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isActionOwnerDirty() : !pSDevSlnTempl.isActionOwnerDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getActionOwner();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionOwner_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONOWNER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CurAction(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isCurActionDirty() : !pSDevSlnTempl.isCurActionDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getCurAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurAction_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevTemplState(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isDevTemplStateDirty() : !pSDevSlnTempl.isDevTemplStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnTempl.getDevTemplState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevTemplState_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVTEMPLSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRef(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isEnableRefDirty() : !pSDevSlnTempl.isEnableRefDirty()) {
            return null;
        }
        Integer n = pSDevSlnTempl.getEnableRef();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRef_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEREF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isExpriedTimeDirty() : !pSDevSlnTempl.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnTempl.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_LastActiveTime(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isLastActiveTimeDirty() : !pSDevSlnTempl.isLastActiveTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnTempl.getLastActiveTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastActiveTime_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTACTIVETIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastPubDate(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isLastPubDateDirty() : !pSDevSlnTempl.isLastPubDateDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnTempl.getLastPubDate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastPubDate_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTPUBDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isLogicNameDirty() : !pSDevSlnTempl.isLogicNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MainPSDevSlnTemplId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isMainPSDevSlnTemplIdDirty() : !pSDevSlnTempl.isMainPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getMainPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSDevSlnTemplId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainPSDevSlnTemplName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isMainPSDevSlnTemplNameDirty() : !pSDevSlnTempl.isMainPSDevSlnTemplNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getMainPSDevSlnTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSDevSlnTemplName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isMemoDirty() : !pSDevSlnTempl.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPkgParamDirty() : !pSDevSlnTempl.isPkgParamDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPkgParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam2(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPkgParam2Dirty() : !pSDevSlnTempl.isPkgParam2Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPkgParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam2_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam3(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPkgParam3Dirty() : !pSDevSlnTempl.isPkgParam3Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPkgParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam3_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam4(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPkgParam4Dirty() : !pSDevSlnTempl.isPkgParam4Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPkgParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam4_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnTemplId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPPSDevSlnTemplIdDirty() : !pSDevSlnTempl.isPPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnTemplId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnTemplName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPPSDevSlnTemplNameDirty() : !pSDevSlnTempl.isPPSDevSlnTemplNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPPSDevSlnTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnTemplName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevCenterSVNIdDirty() : !pSDevSlnTempl.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevCenterSVNNameDirty() : !pSDevSlnTempl.isPSDevCenterSVNNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevCenterSVNName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnIdDirty() : !pSDevSlnTempl.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysAppIdDirty() : !pSDevSlnTempl.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
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
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplDEModel(), "PSDEVSLNSYSAPPID", string3, pSDevSlnTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysAppName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysAppNameDirty() : !pSDevSlnTempl.isPSDevSlnSysAppNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysIdDirty() : !pSDevSlnTempl.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysNameDirty() : !pSDevSlnTempl.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrvId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysSrvIdDirty() : !pSDevSlnTempl.isPSDevSlnSysSrvIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysSrvId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrvId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRVID");
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
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplDEModel(), "PSDEVSLNSYSSRVID", string3, pSDevSlnTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSSRVID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysSrvName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnSysSrvNameDirty() : !pSDevSlnTempl.isPSDevSlnSysSrvNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnSysSrvName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysSrvName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSSRVNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnTemplIdDirty() && !bl2 : !pSDevSlnTempl.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnTemplName(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSDevSlnTemplNameDirty() && !bl2 : !pSDevSlnTempl.isPSDevSlnTemplNameDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSDevSlnTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplName_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplDEModel(), "PSDEVSLNTEMPLNAME", string3, pSDevSlnTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNTEMPLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSPFIdDirty() : !pSDevSlnTempl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSPFStyleIdDirty() : !pSDevSlnTempl.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSSFIdDirty() : !pSDevSlnTempl.isPSSFIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPSSFStyleIdDirty() : !pSDevSlnTempl.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isPubModeDirty() : !pSDevSlnTempl.isPubModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnTempl.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCode(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isRefCodeDirty() : !pSDevSlnTempl.isRefCodeDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getRefCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCode_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCODE");
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
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplDEModel(), "REFCODE", string3, pSDevSlnTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REFCODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleCode(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isStyleCodeDirty() : !pSDevSlnTempl.isStyleCodeDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getStyleCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleCode_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLECODE");
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
                string3 = "PSDEVCENTERID";
                string3 = string3 + ";";
                string3 = string3 + "PSPFID";
                string3 = string3 + ";";
                string3 = string3 + "PSSFID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnTemplDEModel(), "STYLECODE", string3, pSDevSlnTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("STYLECODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleEngine(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isStyleEngineDirty() : !pSDevSlnTempl.isStyleEngineDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getStyleEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleEngine_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLEENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplMDUrl(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplMDUrlDirty() : !pSDevSlnTempl.isTemplMDUrlDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplMDUrl_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplParams(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplParamsDirty() : !pSDevSlnTempl.isTemplParamsDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplParams_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplPSPFStyleId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplPSPFStyleIdDirty() : !pSDevSlnTempl.isTemplPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSPFStyleId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplPSSFStyleId(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplPSSFStyleIdDirty() : !pSDevSlnTempl.isTemplPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplPSSFStyleId_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLPSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplTag(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplTagDirty() : !pSDevSlnTempl.isTemplTagDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplTag_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplTag2(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplTag2Dirty() : !pSDevSlnTempl.isTemplTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplTag2_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplType(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isTemplTypeDirty() : !pSDevSlnTempl.isTemplTypeDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getTemplType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplType_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isUserCatDirty() : !pSDevSlnTempl.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isUserTagDirty() : !pSDevSlnTempl.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isUserTag2Dirty() : !pSDevSlnTempl.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isUserTag3Dirty() : !pSDevSlnTempl.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isUserTag4Dirty() : !pSDevSlnTempl.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDevSlnTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_V2GitPath(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isV2GitPathDirty() : !pSDevSlnTempl.isV2GitPathDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getV2GitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2GitPath_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VCType(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isVCTypeDirty() : !pSDevSlnTempl.isVCTypeDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getVCType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VCType_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerStr(boolean bl, PSDevSlnTempl pSDevSlnTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnTempl.isVerStrDirty() : !pSDevSlnTempl.isVerStrDirty()) {
            return null;
        }
        String string = pSDevSlnTempl.getVerStr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerStr_Default((IEntity)pSDevSlnTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSTR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnTempl, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnTempl, bl);
    }

    public Object getDataContextValue(PSDevSlnTempl pSDevSlnTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSln pSDevSln = pSDevSlnTempl.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnTempl pSDevSlnTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONOWNER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionOwner_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVTEMPLSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevTemplState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEREF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRef_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTACTIVETIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastActiveTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTPUBDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastPubDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSSRVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysSrvName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLEENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLPSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplPSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"V2GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VCType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERSTR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerStr_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionOwner_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONOWNER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_CurAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURACTION", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DevTemplState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableRef_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LastActiveTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastPubDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MainPSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainPSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PkgParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM2", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM3", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM4", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnSysSrvId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysSrvName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSSRVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSDEVSLNTEMPLNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StyleCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLECODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("STYLECODE", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StyleEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLEENGINE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplPSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLPSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_V2GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2GITPATH", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VCType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VCTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerStr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSTR", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnTempl);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnTempl pSDevSlnTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNTEMPL");
        if (!bl) {
            pSDevSlnTempl.setActionOwner(null);
            pSDevSlnTempl.setCreateDate(null);
            pSDevSlnTempl.setCreateMan(null);
            pSDevSlnTempl.setCurAction(null);
            pSDevSlnTempl.setMainPSDevSlnTemplId(null);
            pSDevSlnTempl.setMainPSDevSlnTemplName(null);
            pSDevSlnTempl.setPSDevSlnName(null);
            pSDevSlnTempl.setPSDevSlnTemplId(null);
            pSDevSlnTempl.setPSPFStyleName(null);
            pSDevSlnTempl.setPSSFStyleName(null);
            pSDevSlnTempl.setRefCode(null);
            pSDevSlnTempl.setTemplPSPFStyleName(null);
            pSDevSlnTempl.setTemplPSSFStyleName(null);
            pSDevSlnTempl.setUpdateDate(null);
            pSDevSlnTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnTempl, xmlNode, bl);
        }
    }
}

