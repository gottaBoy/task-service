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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysDepInstDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysDepInstDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDepInstServiceBase
extends PSCoreSysServiceBase<PSDevSlnSysDepInst> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDepInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_ADDSYNCSYSMODELTASK = "X_ADDSYNCSYSMODELTASK";
    public static final String ACTION_CHECKINMODEL = "CheckInModel";
    public static final String ACTION_CHECKOUTMODEL = "CheckOutModel";
    private PSDevSlnSysDepInstDEModel pSDevSlnSysDepInstDEModel;
    private PSDevSlnSysDepInstDAO pSDevSlnSysDepInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService";
    }

    public PSDevSlnSysDepInstDEModel getPSDevSlnSysDepInstDEModel() {
        if (this.pSDevSlnSysDepInstDEModel == null) {
            try {
                this.pSDevSlnSysDepInstDEModel = (PSDevSlnSysDepInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysDepInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDepInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDepInstDEModel();
    }

    public PSDevSlnSysDepInstDAO getPSDevSlnSysDepInstDAO() {
        if (this.pSDevSlnSysDepInstDAO == null) {
            try {
                this.pSDevSlnSysDepInstDAO = (PSDevSlnSysDepInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysDepInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDepInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysDepInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDSYNCSYSMODELTASK, (boolean)true) == 0) {
            this.addSyncSysModelTask((PSDevSlnSysDepInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKINMODEL, (boolean)true) == 0) {
            this.checkInModel((PSDevSlnSysDepInst)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHECKOUTMODEL, (boolean)true) == 0) {
            this.checkOutModel((PSDevSlnSysDepInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void addSyncSysModelTask(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSYSMODELTASK, 0, pSDevSlnSysDepInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysDepInst, ACTION_X_ADDSYNCSYSMODELTASK);
        final PSDevSlnSysDepInst pSDevSlnSysDepInst2 = pSDevSlnSysDepInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDepInstServiceBase.this.getService(), PSDevSlnSysDepInstServiceBase.ACTION_X_ADDSYNCSYSMODELTASK, 40, pSDevSlnSysDepInst2, null).getResult() != 1) {
                    PSDevSlnSysDepInstServiceBase.this.onAddSyncSysModelTask(pSDevSlnSysDepInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDSYNCSYSMODELTASK, 99, pSDevSlnSysDepInst, null);
        }
    }

    protected void onAddSyncSysModelTask(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDSYNCSYSMODELTASK]");
    }

    public void checkInModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINMODEL, 0, pSDevSlnSysDepInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysDepInst, ACTION_CHECKINMODEL);
        final PSDevSlnSysDepInst pSDevSlnSysDepInst2 = pSDevSlnSysDepInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDepInstServiceBase.this.getService(), PSDevSlnSysDepInstServiceBase.ACTION_CHECKINMODEL, 40, pSDevSlnSysDepInst2, null).getResult() != 1) {
                    PSDevSlnSysDepInstServiceBase.this.onCheckInModel(pSDevSlnSysDepInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKINMODEL, 99, pSDevSlnSysDepInst, null);
        }
    }

    protected void onCheckInModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckInModel]");
    }

    public void checkOutModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTMODEL, 0, pSDevSlnSysDepInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSysDepInst, ACTION_CHECKOUTMODEL);
        final PSDevSlnSysDepInst pSDevSlnSysDepInst2 = pSDevSlnSysDepInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysDepInstServiceBase.this.getService(), PSDevSlnSysDepInstServiceBase.ACTION_CHECKOUTMODEL, 40, pSDevSlnSysDepInst2, null).getResult() != 1) {
                    PSDevSlnSysDepInstServiceBase.this.onCheckOutModel(pSDevSlnSysDepInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHECKOUTMODEL, 99, pSDevSlnSysDepInst, null);
        }
    }

    protected void onCheckOutModel(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CheckOutModel]");
    }

    protected void onFillParentInfo(PSDevSlnSysDepInst pSDevSlnSysDepInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTERSVN_INSTPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_InstPSDevCenterSVN(pSDevSlnSysDepInst, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSysDepInst, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysDepInst, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysDepInst, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelInst);
            } else {
                iService.get(pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSysDepInst, pSSysModelInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYSDEPINST_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDevSlnSysDepInst, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDevSlnSysDepInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_InstPSDevCenterSVN(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysDepInst.setInstPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysDepInst.setInstPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ModelPSDevCenterSVN(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSysDepInst.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSysDepInst.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSDevCenter pSDevCenter) throws Exception {
        pSDevSlnSysDepInst.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevSlnSysDepInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDevSlnSysDepInst.setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
        pSDevSlnSysDepInst.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDevSlnSysDepInst.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSSysModelInst pSSysModelInst) throws Exception {
        pSDevSlnSysDepInst.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDevSlnSysDepInst.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDevSlnSysDepInst pSDevSlnSysDepInst, PSTaskServer pSTaskServer) throws Exception {
        pSDevSlnSysDepInst.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDevSlnSysDepInst.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSysDepInst.getBackupState() == null) {
                pSDevSlnSysDepInst.setBackupState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnSysDepInst.getDepInstState() == null) {
                pSDevSlnSysDepInst.setDepInstState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
            if (pSDevSlnSysDepInst.getSingleInstMode() == null) {
                pSDevSlnSysDepInst.setSingleInstMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_InstPSDevCenterSVN(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_ModelPSDevCenterSVN(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDevSlnSysDepInst, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDevSlnSysDepInst, bl);
    }

    protected void onFillEntityFullInfo_InstPSDevCenterSVN(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ModelPSDevCenterSVN(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        if (pSDevSlnSysDepInst.isPSDevCenterIdDirty()) {
            if (pSDevSlnSysDepInst.getPSDevCenterId() != null) {
                if (pSDevSlnSysDepInst.getPSDevCenterId() == null || pSDevSlnSysDepInst.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevSlnSysDepInst.getPSDevCenter();
                    pSDevSlnSysDepInst.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevSlnSysDepInst.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        if (pSDevSlnSysDepInst.isPSTaskServerIdDirty()) {
            if (pSDevSlnSysDepInst.getPSTaskServerId() != null) {
                if (pSDevSlnSysDepInst.getPSTaskServerId() == null || pSDevSlnSysDepInst.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDevSlnSysDepInst.getPSTaskServer();
                    pSDevSlnSysDepInst.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDevSlnSysDepInst.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSysDepInst, bl);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByInstPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByInstPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByInstPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByInstPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByInstPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INSTPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInstPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInstPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSysDepInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDepInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevSlnSysDepInst> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDevSlnSysDepInst> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByInstPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTERSVN_INSTPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDEPINST", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByInstPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setInstPSDevCenterSVNId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByInstPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByInstPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByInstPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByInstPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByInstPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByInstPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInstPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    public void testRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDEPINST", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setModelPSDevCenterSVNId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDEPINST_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDEPINST", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setPSDevCenterId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDEPINST_PSDEVSLNSYS_PSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDEPINST", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setPSDevSlnSysId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYSDEPINST_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYSDEPINST", iDataEntityModel.getDataInfo(pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setPSSysModelInstId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            PSDevSlnSysDepInst pSDevSlnSysDepInst2 = (PSDevSlnSysDepInst)this.getDEModel().createEntity();
            pSDevSlnSysDepInst2.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
            pSDevSlnSysDepInst2.setPSTaskServerId(null);
            this.update(pSDevSlnSysDepInst2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysDepInstServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDevSlnSysDepInstServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDevSlnSysDepInstServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevSlnSysDepInst> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDevSlnSysDepInst pSDevSlnSysDepInst : arrayList) {
            this.remove(pSDevSlnSysDepInst);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevSlnSysDepInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysDynaInstService.testRemoveByPSDevSlnSysDepInst(pSDevSlnSysDepInst);
        super.onBeforeRemove(pSDevSlnSysDepInst);
    }

    protected void replaceParentInfo(PSDevSlnSysDepInst pSDevSlnSysDepInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSysDepInst, cloneSession);
        if (pSDevSlnSysDepInst.getInstPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysDepInst.getInstPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_InstPSDevCenterSVN(pSDevSlnSysDepInst, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysDepInst.getModelPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSysDepInst.getModelPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSysDepInst, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSysDepInst.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevSlnSysDepInst.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevSlnSysDepInst, (PSDevCenter)iEntity);
        }
        if (pSDevSlnSysDepInst.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSysDepInst.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDevSlnSysDepInst, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSysDepInst.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDevSlnSysDepInst.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSysDepInst, (PSSysModelInst)iEntity);
        }
        if (pSDevSlnSysDepInst.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDevSlnSysDepInst.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDevSlnSysDepInst, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSysDepInst, bl);
        pSDevSlnSysDepInst.resetBackupFilePath();
        pSDevSlnSysDepInst.resetBackupSize();
        pSDevSlnSysDepInst.resetBackupState();
        pSDevSlnSysDepInst.resetBackupTime();
        pSDevSlnSysDepInst.resetBeginBackupTime();
        pSDevSlnSysDepInst.resetDepInstState();
        pSDevSlnSysDepInst.resetEndBackupTime();
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupFilePath(bl, pSDevSlnSysDepInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupSize(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupState(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BackupTime(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeginBackupTime(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DepInstState(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndBackupTime(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstPSDevCenterSVNId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag2(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag3(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstTag4(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InstVer(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastCheckinTime(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelPSDevCenterSVNId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelVer(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDepInstId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysDepInstName(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SingleInstMode(bl, pSDevSlnSysDepInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSysDepInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupFilePath(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isBackupFilePathDirty() : !pSDevSlnSysDepInst.isBackupFilePathDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getBackupFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BackupFilePath_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPFILEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupSize(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isBackupSizeDirty() : !pSDevSlnSysDepInst.isBackupSizeDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getBackupSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BackupSize_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupState(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isBackupStateDirty() && !bl2 : !pSDevSlnSysDepInst.isBackupStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getBackupState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BackupState_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BackupTime(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isBackupTimeDirty() : !pSDevSlnSysDepInst.isBackupTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDepInst.getBackupTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BackupTime_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeginBackupTime(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isBeginBackupTimeDirty() : !pSDevSlnSysDepInst.isBeginBackupTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDepInst.getBeginBackupTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginBackupTime_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINBACKUPTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DepInstState(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isDepInstStateDirty() : !pSDevSlnSysDepInst.isDepInstStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getDepInstState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DepInstState_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPINSTSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndBackupTime(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isEndBackupTimeDirty() : !pSDevSlnSysDepInst.isEndBackupTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDepInst.getEndBackupTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndBackupTime_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDBACKUPTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isExpriedTimeDirty() : !pSDevSlnSysDepInst.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDepInst.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstPSDevCenterSVNId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstPSDevCenterSVNIdDirty() : !pSDevSlnSysDepInst.isInstPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getInstPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstPSDevCenterSVNId_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSTPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InstTag(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstTagDirty() : !pSDevSlnSysDepInst.isInstTagDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getInstTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstTag2(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstTag2Dirty() : !pSDevSlnSysDepInst.isInstTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getInstTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag2_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstTag3(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstTag3Dirty() : !pSDevSlnSysDepInst.isInstTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getInstTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag3_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstTag4(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstTag4Dirty() : !pSDevSlnSysDepInst.isInstTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getInstTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InstTag4_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_InstVer(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isInstVerDirty() : !pSDevSlnSysDepInst.isInstVerDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getInstVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InstVer_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_LastCheckinTime(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isLastCheckinTimeDirty() : !pSDevSlnSysDepInst.isLastCheckinTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSysDepInst.getLastCheckinTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastCheckinTime_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isMemoDirty() : !pSDevSlnSysDepInst.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelPSDevCenterSVNId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isModelPSDevCenterSVNIdDirty() : !pSDevSlnSysDepInst.isModelPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getModelPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelPSDevCenterSVNId_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelVer(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isModelVerDirty() : !pSDevSlnSysDepInst.isModelVerDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getModelVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelVer_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSDevCenterIdDirty() && !bl2 : !pSDevSlnSysDepInst.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSDevCenterNameDirty() : !pSDevSlnSysDepInst.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDepInstId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSDevSlnSysDepInstIdDirty() && !bl2 : !pSDevSlnSysDepInst.isPSDevSlnSysDepInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSDevSlnSysDepInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDEPINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDepInstId_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysDepInstName(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSDevSlnSysDepInstNameDirty() && !bl2 : !pSDevSlnSysDepInst.isPSDevSlnSysDepInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSDevSlnSysDepInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSDEPINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysDepInstName_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSysDepInst.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSSysModelInstIdDirty() : !pSDevSlnSysDepInst.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default(pSDevSlnSysDepInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSTaskServerIdDirty() : !pSDevSlnSysDepInst.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isPSTaskServerNameDirty() : !pSDevSlnSysDepInst.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDevSlnSysDepInst.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SingleInstMode(boolean bl, PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSysDepInst.isSingleInstModeDirty() : !pSDevSlnSysDepInst.isSingleInstModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnSysDepInst.getSingleInstMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SingleInstMode_Default(pSDevSlnSysDepInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SINGLEINSTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSysDepInst, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSysDepInst pSDevSlnSysDepInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSysDepInst, bl);
    }

    public Object getDataContextValue(PSDevSlnSysDepInst pSDevSlnSysDepInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSysDepInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSDevSlnSysDepInst.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSysDepInst pSDevSlnSysDepInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSysDepInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKUPFILEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupFilePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BACKUPSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BACKUPSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BACKUPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEGINBACKUPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginBackupTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPINSTSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DepInstState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDBACKUPTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndBackupTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSTPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstPSDevCenterSVNName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"INSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTCHECKINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastCheckinTime_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MODELVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelVer_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDEPINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDepInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSDEPINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysDepInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SINGLEINSTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SingleInstMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackupFilePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BACKUPFILEPATH", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BackupSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BackupState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BackupTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BeginBackupTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DepInstState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndBackupTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InstPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InstPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INSTPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_InstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastCheckinTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SingleInstMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSysDepInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSysDepInst pSDevSlnSysDepInst) throws Exception {
        super.onUpdateParent(pSDevSlnSysDepInst);
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSysDepInst pSDevSlnSysDepInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYSDEPINST");
        if (!bl) {
            pSDevSlnSysDepInst.setCreateDate(null);
            pSDevSlnSysDepInst.setCreateMan(null);
            pSDevSlnSysDepInst.setPSDevSlnSysDepInstId(null);
            pSDevSlnSysDepInst.setPSDevSlnSysName(null);
            pSDevSlnSysDepInst.setPSSysModelInstName(null);
            pSDevSlnSysDepInst.setUpdateDate(null);
            pSDevSlnSysDepInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSysDepInst, xmlNode, bl);
        }
    }
}

