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
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.pscore.srv.paasmgr.dao.PSTSCmdDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSTSCmdDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTSCmdServiceBase
extends PSCoreSysServiceBase<PSTSCmd> {
    private static final Log log = LogFactory.getLog(PSTSCmdServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_ENDTASK = "ENDTASK";
    public static final String ACTION_X2_EXECUTECLICMD = "X2_EXECUTECLICMD";
    public static final String ACTION_X2_EXECUTEDCCLICMD = "X2_EXECUTEDCCLICMD";
    public static final String ACTION_X2_EXECUTESLNCLICMD = "X2_EXECUTESLNCLICMD";
    public static final String ACTION_X2_EXECUTESYSCLICMD = "X2_EXECUTESYSCLICMD";
    public static final String ACTION_X2_EXECUTETEMPLCLICMD = "X2_EXECUTETEMPLCLICMD";
    private PSTSCmdDEModel pSTSCmdDEModel;
    private PSTSCmdDAO pSTSCmdDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService";
    }

    public PSTSCmdDEModel getPSTSCmdDEModel() {
        if (this.pSTSCmdDEModel == null) {
            try {
                this.pSTSCmdDEModel = (PSTSCmdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSTSCmdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTSCmdDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSTSCmdDEModel();
    }

    public PSTSCmdDAO getPSTSCmdDAO() {
        if (this.pSTSCmdDAO == null) {
            try {
                this.pSTSCmdDAO = (PSTSCmdDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSTSCmdDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSTSCmdDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSTSCmdDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_ENDTASK, (boolean)true) == 0) {
            this.endTask((PSTSCmd)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X2_EXECUTECLICMD, (boolean)true) == 0) {
            this.executeCLICmd((PSTSCmd)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X2_EXECUTEDCCLICMD, (boolean)true) == 0) {
            this.executeDCCLICmd((PSTSCmd)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X2_EXECUTESLNCLICMD, (boolean)true) == 0) {
            this.executeSlnCLICmd((PSTSCmd)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X2_EXECUTESYSCLICMD, (boolean)true) == 0) {
            this.executeSysCLICmd((PSTSCmd)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X2_EXECUTETEMPLCLICMD, (boolean)true) == 0) {
            this.executeTemplCLICmd((PSTSCmd)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void endTask(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_ENDTASK, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_ENDTASK);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_ENDTASK, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onEndTask(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_ENDTASK, 99, pSTSCmd, null);
        }
    }

    protected void onEndTask(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ENDTASK]");
    }

    public void executeCLICmd(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTECLICMD, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_X2_EXECUTECLICMD);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_X2_EXECUTECLICMD, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onExecuteCLICmd(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTECLICMD, 99, pSTSCmd, null);
        }
    }

    protected void onExecuteCLICmd(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X2_EXECUTECLICMD]");
    }

    public void executeDCCLICmd(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTEDCCLICMD, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_X2_EXECUTEDCCLICMD);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_X2_EXECUTEDCCLICMD, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onExecuteDCCLICmd(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTEDCCLICMD, 99, pSTSCmd, null);
        }
    }

    protected void onExecuteDCCLICmd(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X2_EXECUTEDCCLICMD]");
    }

    public void executeSlnCLICmd(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTESLNCLICMD, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_X2_EXECUTESLNCLICMD);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_X2_EXECUTESLNCLICMD, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onExecuteSlnCLICmd(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTESLNCLICMD, 99, pSTSCmd, null);
        }
    }

    protected void onExecuteSlnCLICmd(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X2_EXECUTESLNCLICMD]");
    }

    public void executeSysCLICmd(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTESYSCLICMD, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_X2_EXECUTESYSCLICMD);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_X2_EXECUTESYSCLICMD, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onExecuteSysCLICmd(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTESYSCLICMD, 99, pSTSCmd, null);
        }
    }

    protected void onExecuteSysCLICmd(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X2_EXECUTESYSCLICMD]");
    }

    public void executeTemplCLICmd(PSTSCmd pSTSCmd) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTETEMPLCLICMD, 0, pSTSCmd, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSTSCmd, ACTION_X2_EXECUTETEMPLCLICMD);
        final PSTSCmd pSTSCmd2 = pSTSCmd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSTSCmdServiceBase.this.getService(), PSTSCmdServiceBase.ACTION_X2_EXECUTETEMPLCLICMD, 40, pSTSCmd2, null).getResult() != 1) {
                    PSTSCmdServiceBase.this.onExecuteTemplCLICmd(pSTSCmd2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X2_EXECUTETEMPLCLICMD, 99, pSTSCmd, null);
        }
    }

    protected void onExecuteTemplCLICmd(PSTSCmd pSTSCmd) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X2_EXECUTETEMPLCLICMD]");
    }

    protected void onFillParentInfo(PSTSCmd pSTSCmd, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTSCMD_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSTSCmd, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTSCMD_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSTSCmd, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTSCMD_PSDEVSLNTEMPL_PSDEVSLNTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService", (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl = (PSDevSlnTempl)iService.getDEModel().createEntity();
            pSDevSlnTempl.set("PSDEVSLNTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnTempl);
            } else {
                iService.get(pSDevSlnTempl);
            }
            this.onFillParentInfo_PSDevSlnTempl(pSTSCmd, pSDevSlnTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTSCMD_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSTSCmd, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSTSCMD_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSTSCmd, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSTSCmd, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSTSCmd pSTSCmd, PSDevCenter pSDevCenter) throws Exception {
        pSTSCmd.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSTSCmd.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSTSCmd pSTSCmd, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSTSCmd.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSTSCmd.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSlnTempl(PSTSCmd pSTSCmd, PSDevSlnTempl pSDevSlnTempl) throws Exception {
        pSTSCmd.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
        pSTSCmd.setPSDevSlnTemplName(pSDevSlnTempl.getPSDevSlnTemplName());
    }

    protected void onFillParentInfo_PSDevSln(PSTSCmd pSTSCmd, PSDevSln pSDevSln) throws Exception {
        pSTSCmd.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSTSCmd.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSTaskServer(PSTSCmd pSTSCmd, PSTaskServer pSTaskServer) throws Exception {
        pSTSCmd.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSTSCmd.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSTSCmd, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSTSCmd, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSTSCmd, bl);
        this.onFillEntityFullInfo_PSDevSlnTempl(pSTSCmd, bl);
        this.onFillEntityFullInfo_PSDevSln(pSTSCmd, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSTSCmd, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        if (pSTSCmd.isPSDevCenterIdDirty()) {
            if (pSTSCmd.getPSDevCenterId() != null) {
                if (pSTSCmd.getPSDevCenterId() == null || pSTSCmd.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSTSCmd.getPSDevCenter();
                    pSTSCmd.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSTSCmd.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        if (pSTSCmd.isPSDevSlnSysIdDirty()) {
            if (pSTSCmd.getPSDevSlnSysId() != null) {
                if (pSTSCmd.getPSDevSlnSysId() == null || pSTSCmd.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSTSCmd.getPSDevSlnSys();
                    pSTSCmd.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSTSCmd.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnTempl(PSTSCmd pSTSCmd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevSln(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        if (pSTSCmd.isPSDevSlnIdDirty()) {
            if (pSTSCmd.getPSDevSlnId() != null) {
                if (pSTSCmd.getPSDevSlnId() == null || pSTSCmd.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSTSCmd.getPSDevSln();
                    pSTSCmd.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSTSCmd.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSTSCmd pSTSCmd, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        super.onWriteBackParent(pSTSCmd, bl);
    }

    public ArrayList<PSTSCmd> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSTSCmd> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSTSCmd> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, "", -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string) throws Exception {
        return this.selectByPSDevSlnTempl(pSDevSlnTemplBase, string, -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSlnTempl(PSDevSlnTemplBase pSDevSlnTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNTEMPLID", (Object)pSDevSlnTemplBase.getPSDevSlnTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSTSCmd> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSTSCmd> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSTSCmd> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSTSCmd> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSTSCmd> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSTSCmd pSTSCmd : arrayList) {
            PSTSCmd pSTSCmd2 = (PSTSCmd)this.getDEModel().createEntity();
            pSTSCmd2.setPSTSCmdId(pSTSCmd.getPSTSCmdId());
            pSTSCmd2.setPSDevCenterId(null);
            this.update(pSTSCmd2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTSCmdServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSTSCmdServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSTSCmdServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSTSCmd pSTSCmd : arrayList) {
            this.remove(pSTSCmd);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSTSCmd pSTSCmd : arrayList) {
            PSTSCmd pSTSCmd2 = (PSTSCmd)this.getDEModel().createEntity();
            pSTSCmd2.setPSTSCmdId(pSTSCmd.getPSTSCmdId());
            pSTSCmd2.setPSDevSlnSysId(null);
            this.update(pSTSCmd2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTSCmdServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSTSCmdServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSTSCmdServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSTSCmd pSTSCmd : arrayList) {
            this.remove(pSTSCmd);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    public void resetPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        for (PSTSCmd pSTSCmd : arrayList) {
            PSTSCmd pSTSCmd2 = (PSTSCmd)this.getDEModel().createEntity();
            pSTSCmd2.setPSTSCmdId(pSTSCmd.getPSTSCmdId());
            pSTSCmd2.setPSDevSlnTemplId(null);
            this.update(pSTSCmd2);
        }
    }

    public void removeByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTSCmdServiceBase.this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSTSCmdServiceBase.this.internalRemoveByPSDevSlnTempl(pSDevSlnTempl2);
                PSTSCmdServiceBase.this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void internalRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSlnTempl(pSDevSlnTempl);
        this.onBeforeRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
        for (PSTSCmd pSTSCmd : arrayList) {
            this.remove(pSTSCmd);
        }
        this.onAfterRemoveByPSDevSlnTempl(pSDevSlnTempl, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSTSCmd pSTSCmd : arrayList) {
            PSTSCmd pSTSCmd2 = (PSTSCmd)this.getDEModel().createEntity();
            pSTSCmd2.setPSTSCmdId(pSTSCmd.getPSTSCmdId());
            pSTSCmd2.setPSDevSlnId(null);
            this.update(pSTSCmd2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTSCmdServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSTSCmdServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSTSCmdServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSTSCmd pSTSCmd : arrayList) {
            this.remove(pSTSCmd);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSTSCmd pSTSCmd : arrayList) {
            PSTSCmd pSTSCmd2 = (PSTSCmd)this.getDEModel().createEntity();
            pSTSCmd2.setPSTSCmdId(pSTSCmd.getPSTSCmdId());
            pSTSCmd2.setPSTaskServerId(null);
            this.update(pSTSCmd2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSTSCmdServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSTSCmdServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSTSCmdServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSTSCmd> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSTSCmd pSTSCmd : arrayList) {
            this.remove(pSTSCmd);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSTSCmd> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSTSCmd pSTSCmd) throws Exception {
        super.onBeforeRemove(pSTSCmd);
    }

    protected void replaceParentInfo(PSTSCmd pSTSCmd, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSTSCmd, cloneSession);
        if (pSTSCmd.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSTSCmd.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSTSCmd, (PSDevCenter)iEntity);
        }
        if (pSTSCmd.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSTSCmd.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSTSCmd, (PSDevSlnSys)iEntity);
        }
        if (pSTSCmd.getPSDevSlnTemplId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNTEMPL", (Object)pSTSCmd.getPSDevSlnTemplId())) != null) {
            this.onFillParentInfo_PSDevSlnTempl(pSTSCmd, (PSDevSlnTempl)iEntity);
        }
        if (pSTSCmd.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSTSCmd.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSTSCmd, (PSDevSln)iEntity);
        }
        if (pSTSCmd.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSTSCmd.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSTSCmd, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSTSCmd, bl);
    }

    protected void onCheckEntity(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Data(bl, pSTSCmd, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnTemplId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTSCmdId(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTSCmdName(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Result(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RunCmd(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskName(bl, pSTSCmd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSTSCmd, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isDataDirty() : !pSTSCmd.isDataDirty()) {
            return null;
        }
        String string = pSTSCmd.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevCenterIdDirty() : !pSTSCmd.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevCenterNameDirty() : !pSTSCmd.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevSlnIdDirty() : !pSTSCmd.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevSlnNameDirty() : !pSTSCmd.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevSlnSysIdDirty() : !pSTSCmd.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevSlnSysNameDirty() : !pSTSCmd.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnTemplId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSDevSlnTemplIdDirty() : !pSTSCmd.isPSDevSlnTemplIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSDevSlnTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnTemplId_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSTaskServerIdDirty() : !pSTSCmd.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSTSCmd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTSCmdId(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSTSCmdIdDirty() && !bl2 : !pSTSCmd.isPSTSCmdIdDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSTSCmdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTSCMDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTSCmdId_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTSCMDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTSCmdName(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isPSTSCmdNameDirty() && !bl2 : !pSTSCmd.isPSTSCmdNameDirty()) {
            return null;
        }
        String string = pSTSCmd.getPSTSCmdName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTSCMDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTSCmdName_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTSCMDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Result(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isResultDirty() : !pSTSCmd.isResultDirty()) {
            return null;
        }
        String string = pSTSCmd.getResult();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Result_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RunCmd(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isRunCmdDirty() : !pSTSCmd.isRunCmdDirty()) {
            return null;
        }
        String string = pSTSCmd.getRunCmd();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RunCmd_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RUNCMD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskName(boolean bl, PSTSCmd pSTSCmd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSTSCmd.isTaskNameDirty() : !pSTSCmd.isTaskNameDirty()) {
            return null;
        }
        String string = pSTSCmd.getTaskName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskName_Default(pSTSCmd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        super.onSyncEntity(pSTSCmd, bl);
    }

    protected void onSyncIndexEntities(PSTSCmd pSTSCmd, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSTSCmd, bl);
    }

    public Object getDataContextValue(PSTSCmd pSTSCmd, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSTSCmd, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys = pSTSCmd.getPSDevSlnSys();
        if (pSDevSlnSys != null && pSDevSlnSys.contains(string)) {
            return pSDevSlnSys.get(string);
        }
        PSDevSln pSDevSln = pSTSCmd.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        PSTaskServer pSTaskServer = pSTSCmd.getPSTaskServer();
        if (pSTaskServer != null && pSTaskServer.contains(string)) {
            return pSTaskServer.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSTSCmd pSTSCmd, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSTSCmd, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTSCMDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTSCmdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTSCMDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTSCmdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Result_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RUNCMD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RunCmd_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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
            if (this.checkFieldStringLengthRule("PSDEVSLNTEMPLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSTSCmdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTSCMDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTSCmdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTSCMDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Result_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RunCmd_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RUNCMD", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSTSCmd pSTSCmd) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSTSCmd)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSTSCmd pSTSCmd) throws Exception {
        super.onUpdateParent(pSTSCmd);
    }

    @Override
    protected void exportCurXmlModel(PSTSCmd pSTSCmd, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSTSCMD");
        if (!bl) {
            pSTSCmd.setCreateDate(null);
            pSTSCmd.setCreateMan(null);
            pSTSCmd.setPSDevSlnId(null);
            pSTSCmd.setPSDevSlnName(null);
            pSTSCmd.setPSDevSlnSysName(null);
            pSTSCmd.setPSTaskServerName(null);
            pSTSCmd.setPSTSCmdId(null);
            pSTSCmd.setTaskName(null);
            pSTSCmd.setUpdateDate(null);
            pSTSCmd.setUpdateMan(null);
            super.exportCurXmlModel(pSTSCmd, xmlNode, bl);
        }
    }
}

