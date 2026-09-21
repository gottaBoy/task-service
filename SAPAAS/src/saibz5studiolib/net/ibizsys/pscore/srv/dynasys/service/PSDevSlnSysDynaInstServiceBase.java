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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysDynaInst> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSER3 = "CurUser3";
    public static final String DATASET_CURUSER4 = "CurUser4";
    public static final String DATASET_CURUSER5 = "CurUser5";
    public static final String DATASET_CURUSER6 = "CurUser6";
    public static final String DATASET_CURUSERALL = "CurUserAll";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CHECKINCFG = "CheckInCfg";
    public static final String ACTION_CHECKINMODEL = "CheckInModel";
    public static final String ACTION_CHECKOUTALLMODEL = "CheckOutAllModel";
    public static final String ACTION_CHECKOUTCFG = "CheckOutCfg";
    public static final String ACTION_CHECKOUTMODEL = "CheckOutModel";
    private PSDevSlnSysDynaInstDEModel pSDevSlnSysDynaInstDEModel;
    private PSDevSlnSysDynaInstDAO pSDevSlnSysDynaInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService";
    }

    public PSDevSlnSysDynaInstDEModel getPSDevSlnSysDynaInstDEModel() {
        if (this.pSDevSlnSysDynaInstDEModel == null) {
            try {
                this.pSDevSlnSysDynaInstDEModel = (PSDevSlnSysDynaInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDynaInstDEModel();
    }

    public PSDevSlnSysDynaInstDAO getPSDevSlnSysDynaInstDAO() {
        if (this.pSDevSlnSysDynaInstDAO == null) {
            try {
                this.pSDevSlnSysDynaInstDAO = (PSDevSlnSysDynaInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysDynaInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER5, (boolean)true) == 0) {
            return this.fetchCurUser5(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER6, (boolean)true) == 0) {
            return this.fetchCurUser6(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERALL, (boolean)true) == 0) {
            return this.fetchCurUserAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CHECKINCFG, (boolean)true) == 0) {
            this.checkInCfg((PSDevSlnSysDynaInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKINMODEL, (boolean)true) == 0) {
            this.checkInModel((PSDevSlnSysDynaInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKOUTALLMODEL, (boolean)true) == 0) {
            this.checkOutAllModel((PSDevSlnSysDynaInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKOUTCFG, (boolean)true) == 0) {
            this.checkOutCfg((PSDevSlnSysDynaInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKOUTMODEL, (boolean)true) == 0) {
            this.checkOutModel((PSDevSlnSysDynaInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
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

    public DBFetchResult fetchCurUser5(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER5, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser6(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER6, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void checkInCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINCFG, 0, (IEntity)pSDevSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysDynaInst, ACTION_CHECKINCFG);
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstServiceBase.this.getService(), PSDevSlnSysDynaInstServiceBase.ACTION_CHECKINCFG, 40, (IEntity)pSDevSlnSysDynaInst2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstServiceBase.this.onCheckInCfg(pSDevSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINCFG, 99, (IEntity)pSDevSlnSysDynaInst, null);
        }
    }

    protected void onCheckInCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckInCfg]");
    }

    public void checkInModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINMODEL, 0, (IEntity)pSDevSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysDynaInst, ACTION_CHECKINMODEL);
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstServiceBase.this.getService(), PSDevSlnSysDynaInstServiceBase.ACTION_CHECKINMODEL, 40, (IEntity)pSDevSlnSysDynaInst2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstServiceBase.this.onCheckInModel(pSDevSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINMODEL, 99, (IEntity)pSDevSlnSysDynaInst, null);
        }
    }

    protected void onCheckInModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckInModel]");
    }

    public void checkOutAllModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTALLMODEL, 0, (IEntity)pSDevSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysDynaInst, ACTION_CHECKOUTALLMODEL);
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstServiceBase.this.getService(), PSDevSlnSysDynaInstServiceBase.ACTION_CHECKOUTALLMODEL, 40, (IEntity)pSDevSlnSysDynaInst2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstServiceBase.this.onCheckOutAllModel(pSDevSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTALLMODEL, 99, (IEntity)pSDevSlnSysDynaInst, null);
        }
    }

    protected void onCheckOutAllModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckOutAllModel]");
    }

    public void checkOutCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTCFG, 0, (IEntity)pSDevSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysDynaInst, ACTION_CHECKOUTCFG);
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstServiceBase.this.getService(), PSDevSlnSysDynaInstServiceBase.ACTION_CHECKOUTCFG, 40, (IEntity)pSDevSlnSysDynaInst2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstServiceBase.this.onCheckOutCfg(pSDevSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTCFG, 99, (IEntity)pSDevSlnSysDynaInst, null);
        }
    }

    protected void onCheckOutCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckOutCfg]");
    }

    public void checkOutModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTMODEL, 0, (IEntity)pSDevSlnSysDynaInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevSlnSysDynaInst, ACTION_CHECKOUTMODEL);
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDynaInstServiceBase.this.getService(), PSDevSlnSysDynaInstServiceBase.ACTION_CHECKOUTMODEL, 40, (IEntity)pSDevSlnSysDynaInst2, null).getResult() != 1) {
                    PSDevSlnSysDynaInstServiceBase.this.onCheckOutModel(pSDevSlnSysDynaInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTMODEL, 99, (IEntity)pSDevSlnSysDynaInst, null);
        }
    }

    protected void onCheckOutModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckOutModel]");
    }

    protected void onFillParentInfo(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTERSVN_CFGPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_CfgPSDevCenterSVN(pSDevSlnSysDynaInst, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterSVN);
            } else {
                iService.get((IEntity)pSDevCenterSVN);
            }
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSysDynaInst, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysDynaInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDEPINST_PSDEVSLNSYSDEPINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDepInst pSDevSlnSysDepInst = (PSDevSlnSysDepInst)iService.getDEModel().createEntity();
            pSDevSlnSysDepInst.set("PSDEVSLNSYSDEPINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysDepInst);
            } else {
                iService.get((IEntity)pSDevSlnSysDepInst);
            }
            this.onFillParentInfo_PSDevSlnSysDepInst(pSDevSlnSysDynaInst, pSDevSlnSysDepInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINST_PPSDEVSLNSYSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)iService.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.set("PSDEVSLNSYSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSysDynaInst2);
            } else {
                iService.get((IEntity)pSDevSlnSysDynaInst2);
            }
            this.onFillParentInfo_PPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, pSDevSlnSysDynaInst2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSlnSys);
            } else {
                iService.get((IEntity)pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysDynaInst, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevSln);
            } else {
                iService.get((IEntity)pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnSysDynaInst, pSDevSln);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevSlnSysDynaInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_CfgPSDevCenterSVN(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysDynaInst.setCfgPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysDynaInst.setCfgPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ModelPSDevCenterSVN(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysDynaInst.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysDynaInst.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysDynaInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysDynaInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSysDepInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        pSDevSlnSysDynaInst.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
        pSDevSlnSysDynaInst.setPSDevSlnSysDepInstName(pSDevSlnSysDepInst.getPSDevSlnSysDepInstName());
    }

    protected void onFillParentInfo_PPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevSlnSysDynaInst pSDevSlnSysDynaInst2) throws Exception {
        pSDevSlnSysDynaInst.setPPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId());
        pSDevSlnSysDynaInst.setPPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst2.getPSDevSlnSysDynaInstName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysDynaInst.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysDynaInst.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, PSDevSln pSDevSln) throws Exception {
        pSDevSlnSysDynaInst.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSysDynaInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSysDynaInst.getInstState() == null) {
                pSDevSlnSysDynaInst.setInstState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnSysDynaInst.getValidFlag() == null) {
                pSDevSlnSysDynaInst.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_CfgPSDevCenterSVN(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_ModelPSDevCenterSVN(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PSDevSlnSysDepInst(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysDynaInst, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnSysDynaInst, bl);
    }

    protected void onFillEntityFullInfo_CfgPSDevCenterSVN(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ModelPSDevCenterSVN(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInst.isPSDevCenterIdDirty()) {
            if (pSDevSlnSysDynaInst.getPSDevCenterId() != null) {
                if (pSDevSlnSysDynaInst.getPSDevCenterId() == null || pSDevSlnSysDynaInst.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysDynaInst.getPSDevCenter();
                    pSDevSlnSysDynaInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysDynaInst.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysDepInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInst.isPSDevSlnSysDepInstIdDirty()) {
            if (pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId() != null) {
                if (pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId() == null || pSDevSlnSysDynaInst.getPSDevSlnSysDepInstName() == null) {
                    PSDevSlnSysDepInst pSDevSlnSysDepInst = pSDevSlnSysDynaInst.getPSDevSlnSysDepInst();
                    pSDevSlnSysDynaInst.setPSDevSlnSysDepInstName(pSDevSlnSysDepInst.getPSDevSlnSysDepInstName());
                }
            } else {
                pSDevSlnSysDynaInst.setPSDevSlnSysDepInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInst.isPPSDevSlnSysDynaInstIdDirty()) {
            if (pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId() != null) {
                if (pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId() == null || pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstName() == null) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInst.setPPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst2.getPSDevSlnSysDynaInstName());
                }
            } else {
                pSDevSlnSysDynaInst.setPPSDevSlnSysDynaInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInst.isPSDevSlnIdDirty()) {
            if (pSDevSlnSysDynaInst.getPSDevSlnId() != null) {
                if (pSDevSlnSysDynaInst.getPSDevSlnId() == null || pSDevSlnSysDynaInst.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
                    pSDevSlnSysDynaInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDevSlnSysDynaInst.setPSDevSlnName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevSlnSysDynaInst, bl);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByCfgPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByCfgPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByCfgPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CFGPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCfgPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCfgPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MODELPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByModelPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByModelPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSysDepInst(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase) throws Exception {
        return this.selectByPSDevSlnSysDepInst(pSDevSlnSysDepInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSysDepInst(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, String string) throws Exception {
        return this.selectByPSDevSlnSysDepInst(pSDevSlnSysDepInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSysDepInst(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSDEPINSTID", (Object)pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysDepInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysDepInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) throws Exception {
        return this.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string) throws Exception {
        return this.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVSLNSYSDYNAINSTID", (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevSlnSysDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevSlnSysDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDynaInst> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public void testRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTERSVN_CFGPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setCfgPSDevCenterSVNId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByCfgPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByCfgPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByCfgPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByCfgPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCfgPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setModelPSDevCenterSVNId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setPSDevCenterId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSysDepInst(pSDevSlnSysDepInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSDEPINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysDepInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDEPINST_PSDEVSLNSYSDEPINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysDepInst), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSysDepInst(pSDevSlnSysDepInst);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setPSDevSlnSysDepInstId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        final PSDevSlnSysDepInst pSDevSlnSysDepInst2 = pSDevSlnSysDepInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSysDepInst(pSDevSlnSysDepInst);
        this.onBeforeRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysDepInst(PSDevSlnSysDepInst pSDevSlnSysDepInst, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSysDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYSDYNAINST_PPSDEVSLNSYSDYNAINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSysDynaInst), arrayList.get(0)));
        }
    }

    public void resetPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst3 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst3.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst2.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst3.setPPSDevSlnSysDynaInstId(null);
            this.update(pSDevSlnSysDynaInst3);
        }
    }

    public void removeByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = pSDevSlnSysDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void internalRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        this.onBeforeRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst2);
        }
        this.onAfterRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, arrayList);
    }

    protected void onAfterRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevSlnSysDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDYNAINST_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDYNAINST", iDataEntityModel.getDataInfo((IEntity)pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = (PSDevSlnSysDynaInst)this.getDEModel().createEntity();
            pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            pSDevSlnSysDynaInst2.setPSDevSlnId(null);
            this.update(pSDevSlnSysDynaInst2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDynaInstServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysDynaInstServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysDynaInstServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst : arrayList) {
            this.remove((IEntity)pSDevSlnSysDynaInst);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSysDynaInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        ((PSDevSlnSysDynaInstRefServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        pSCoreSysServiceBase = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
        super.onBeforeRemove(pSDevSlnSysDynaInst);
    }

    protected void replaceParentInfo(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevSlnSysDynaInst, cloneSession);
        if (pSDevSlnSysDynaInst.getCfgPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysDynaInst.getCfgPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_CfgPSDevCenterSVN(pSDevSlnSysDynaInst, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysDynaInst.getModelPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysDynaInst.getModelPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSysDynaInst, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysDynaInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysDynaInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysDynaInst, (PSDevCenter)iEntity);
        }
        if (pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDEPINST", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId())) != null) {
            this.onFillParentInfo_PSDevSlnSysDepInst(pSDevSlnSysDynaInst, (PSDevSlnSysDepInst)iEntity);
        }
        if (pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId())) != null) {
            this.onFillParentInfo_PPSDevSlnSysDynaInst(pSDevSlnSysDynaInst, (PSDevSlnSysDynaInst)iEntity);
        }
        if (pSDevSlnSysDynaInst.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysDynaInst, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysDynaInst.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnSysDynaInst.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSysDynaInst, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevSlnSysDynaInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CfgPSDevCenterSVNId(bl, pSDevSlnSysDynaInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstModelPath(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstState(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag2(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag3(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag4(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag5(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag6(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag7(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag8(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstType(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastCheckinTime(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelPSDevCenterSVNId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PInstModelPath(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnSysDynaInstId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnSysDynaInstName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDepInstId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDepInstName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDynaInstName(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefUpdateDate(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootInstModelPath(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysModelPath(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSysDynaInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevSlnSysDynaInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CfgPSDevCenterSVNId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isCfgPSDevCenterSVNIdDirty() : !pSDevSlnSysDynaInst.isCfgPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getCfgPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CfgPSDevCenterSVNId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CFGPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Color(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isColorDirty() : !pSDevSlnSysDynaInst.isColorDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isExpriedTimeDirty() : !pSDevSlnSysDynaInst.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDynaInst.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstModelPath(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstModelPathDirty() : !pSDevSlnSysDynaInst.isInstModelPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstModelPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstModelPath_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTMODELPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstState(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstStateDirty() && !bl2 : !pSDevSlnSysDynaInst.isInstStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInst.getInstState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_InstState_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTagDirty() : !pSDevSlnSysDynaInst.isInstTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag2(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag2Dirty() : !pSDevSlnSysDynaInst.isInstTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag2_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag3(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag3Dirty() : !pSDevSlnSysDynaInst.isInstTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag3_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag4(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag4Dirty() : !pSDevSlnSysDynaInst.isInstTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag4_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag5(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag5Dirty() : !pSDevSlnSysDynaInst.isInstTag5Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag5_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag6(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag6Dirty() : !pSDevSlnSysDynaInst.isInstTag6Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag6_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag7(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag7Dirty() : !pSDevSlnSysDynaInst.isInstTag7Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag7_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag8(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTag8Dirty() : !pSDevSlnSysDynaInst.isInstTag8Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstTag8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag8_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTAG8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstType(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstTypeDirty() : !pSDevSlnSysDynaInst.isInstTypeDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getInstType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstType_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isInstVerDirty() : !pSDevSlnSysDynaInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastCheckinTime(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isLastCheckinTimeDirty() : !pSDevSlnSysDynaInst.isLastCheckinTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDynaInst.getLastCheckinTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastCheckinTime_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTCHECKINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isLogicNameDirty() : !pSDevSlnSysDynaInst.isLogicNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isMemoDirty() : !pSDevSlnSysDynaInst.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelPSDevCenterSVNId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isModelPSDevCenterSVNIdDirty() : !pSDevSlnSysDynaInst.isModelPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getModelPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelPSDevCenterSVNId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isOrderValueDirty() : !pSDevSlnSysDynaInst.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInst.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PInstModelPath(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPInstModelPathDirty() : !pSDevSlnSysDynaInst.isPInstModelPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPInstModelPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PInstModelPath_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PINSTMODELPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnSysDynaInstId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPPSDevSlnSysDynaInstIdDirty() : !pSDevSlnSysDynaInst.isPPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnSysDynaInstId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnSysDynaInstName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPPSDevSlnSysDynaInstNameDirty() : !pSDevSlnSysDynaInst.isPPSDevSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnSysDynaInstName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevCenterIdDirty() && !bl2 : !pSDevSlnSysDynaInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevCenterNameDirty() : !pSDevSlnSysDynaInst.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnIdDirty() : !pSDevSlnSysDynaInst.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnNameDirty() : !pSDevSlnSysDynaInst.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDepInstId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnSysDepInstIdDirty() : !pSDevSlnSysDynaInst.isPSDevSlnSysDepInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysDepInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDepInstId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDEPINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDepInstName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnSysDepInstNameDirty() : !pSDevSlnSysDynaInst.isPSDevSlnSysDepInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysDepInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDepInstName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDEPINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnSysDynaInstIdDirty() && !bl2 : !pSDevSlnSysDynaInst.isPSDevSlnSysDynaInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysDynaInstName(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnSysDynaInstNameDirty() && !bl2 : !pSDevSlnSysDynaInst.isPSDevSlnSysDynaInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDynaInstName_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isPSDevSlnSysIdDirty() : !pSDevSlnSysDynaInst.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefUpdateDate(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isRefUpdateDateDirty() : !pSDevSlnSysDynaInst.isRefUpdateDateDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDynaInst.getRefUpdateDate();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RefUpdateDate_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFUPDATEDATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RootInstModelPath(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isRootInstModelPathDirty() : !pSDevSlnSysDynaInst.isRootInstModelPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getRootInstModelPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RootInstModelPath_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTINSTMODELPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysModelPath(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isSysModelPathDirty() : !pSDevSlnSysDynaInst.isSysModelPathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getSysModelPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysModelPath_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMODELPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isUserTagDirty() : !pSDevSlnSysDynaInst.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isUserTag2Dirty() : !pSDevSlnSysDynaInst.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDynaInst.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDynaInst.isValidFlagDirty() && !bl2 : !pSDevSlnSysDynaInst.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDynaInst.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDevSlnSysDynaInst, bl2, bl3);
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

    protected void onSyncEntity(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevSlnSysDynaInst, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevSlnSysDynaInst, bl);
    }

    public Object getDataContextValue(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevSlnSysDynaInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysDynaInst.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevSlnSysDynaInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CFGPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CFGPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CfgPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTMODELPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstModelPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTAG8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstTag8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTCHECKINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastCheckinTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PINSTMODELPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PInstModelPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDEPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDepInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDEPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDepInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFUPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefUpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTINSTMODELPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootInstModelPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMODELPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysModelPath_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CfgPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CfgPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CFGPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstModelPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTMODELPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG5", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG6", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG7", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstTag8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTAG8", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastCheckinTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PInstModelPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PINSTMODELPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDevSlnSysDepInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDEPINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDepInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDEPINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefUpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RootInstModelPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROOTINSTMODELPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysModelPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSMODELPATH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevSlnSysDynaInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        super.onUpdateParent((IEntity)pSDevSlnSysDynaInst);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSDYNAINST");
        if (!bl) {
            pSDevSlnSysDynaInst.setCreateDate(null);
            pSDevSlnSysDynaInst.setCreateMan(null);
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(null);
            pSDevSlnSysDynaInst.setUpdateDate(null);
            pSDevSlnSysDynaInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysDynaInst, xmlNode, bl);
        }
    }
}

