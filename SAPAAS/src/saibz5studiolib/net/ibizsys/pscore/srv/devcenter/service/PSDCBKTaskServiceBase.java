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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCBKTaskDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCBKTaskDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCBKTaskServiceBase
extends PSCoreSysServiceBase<PSDCBKTask> {
    private static final Log log = LogFactory.getLog(PSDCBKTaskServiceBase.class);
    public static final String DATASET_CURRUN = "CurRun";
    public static final String DATASET_CURSLNFINISH = "CurSlnFinish";
    public static final String DATASET_CURSLNRUN = "CurSlnRun";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FINISH = "Finish";
    public static final String ACTION_X_CANCELTASK = "X_CANCELTASK";
    public static final String ACTION_X_STARTTASK = "X_STARTTASK";
    private PSDCBKTaskDEModel pSDCBKTaskDEModel;
    private PSDCBKTaskDAO pSDCBKTaskDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService";
    }

    public PSDCBKTaskDEModel getPSDCBKTaskDEModel() {
        if (this.pSDCBKTaskDEModel == null) {
            try {
                this.pSDCBKTaskDEModel = (PSDCBKTaskDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCBKTaskDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBKTaskDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCBKTaskDEModel();
    }

    public PSDCBKTaskDAO getPSDCBKTaskDAO() {
        if (this.pSDCBKTaskDAO == null) {
            try {
                this.pSDCBKTaskDAO = (PSDCBKTaskDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCBKTaskDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBKTaskDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCBKTaskDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURRUN, (boolean)true) == 0) {
            return this.fetchCurRun(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNFINISH, (boolean)true) == 0) {
            return this.fetchCurSlnFinish(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNRUN, (boolean)true) == 0) {
            return this.fetchCurSlnRun(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FINISH, (boolean)true) == 0) {
            return this.fetchFinish(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_CANCELTASK, (boolean)true) == 0) {
            this.cancelTask((PSDCBKTask)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_STARTTASK, (boolean)true) == 0) {
            this.startTask((PSDCBKTask)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurRun(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURRUN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnFinish(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNFINISH, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnRun(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNRUN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFinish(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FINISH, false);
        return dBFetchResult;
    }

    public void cancelTask(PSDCBKTask pSDCBKTask) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_CANCELTASK, 0, pSDCBKTask, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCBKTask, ACTION_X_CANCELTASK);
        final PSDCBKTask pSDCBKTask2 = pSDCBKTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCBKTaskServiceBase.this.getService(), PSDCBKTaskServiceBase.ACTION_X_CANCELTASK, 40, pSDCBKTask2, null).getResult() != 1) {
                    PSDCBKTaskServiceBase.this.onCancelTask(pSDCBKTask2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_CANCELTASK, 99, pSDCBKTask, null);
        }
    }

    protected void onCancelTask(PSDCBKTask pSDCBKTask) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_CANCELTASK]");
    }

    public void startTask(PSDCBKTask pSDCBKTask) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTTASK, 0, pSDCBKTask, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCBKTask, ACTION_X_STARTTASK);
        final PSDCBKTask pSDCBKTask2 = pSDCBKTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCBKTaskServiceBase.this.getService(), PSDCBKTaskServiceBase.ACTION_X_STARTTASK, 40, pSDCBKTask2, null).getResult() != 1) {
                    PSDCBKTaskServiceBase.this.onStartTask(pSDCBKTask2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_STARTTASK, 99, pSDCBKTask, null);
        }
    }

    protected void onStartTask(PSDCBKTask pSDCBKTask) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_STARTTASK]");
    }

    protected void onFillParentInfo(PSDCBKTask pSDCBKTask, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSDCROBOT_PLANPSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRobot);
            } else {
                iService.get(pSDCRobot);
            }
            this.onFillParentInfo_PlanPSDCRobot(pSDCBKTask, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRobot);
            } else {
                iService.get(pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSDCBKTask, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCBKTask, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSDCBKTask, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCBKTask, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCBKTASK_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDCBKTask, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDCBKTask, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PlanPSDCRobot(PSDCBKTask pSDCBKTask, PSDCRobot pSDCRobot) throws Exception {
        pSDCBKTask.setPlanPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSDCBKTask.setPlanPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDCRobot(PSDCBKTask pSDCBKTask, PSDCRobot pSDCRobot) throws Exception {
        pSDCBKTask.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSDCBKTask.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCBKTask pSDCBKTask, PSDevCenter pSDevCenter) throws Exception {
        pSDCBKTask.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCBKTask.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSDCBKTask pSDCBKTask, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSDCBKTask.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDCBKTask.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCBKTask pSDCBKTask, PSDevSln pSDevSln) throws Exception {
        pSDCBKTask.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCBKTask.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDCBKTask pSDCBKTask, PSTaskServer pSTaskServer) throws Exception {
        pSDCBKTask.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDCBKTask.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (bl) {
            if (pSDCBKTask.getOrderValue() == null) {
                pSDCBKTask.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
            if (pSDCBKTask.getTaskState() == null) {
                pSDCBKTask.setTaskState((Integer)this.getDefaultValue(this.getWebContext(), "", "10", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PlanPSDCRobot(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCBKTask, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDCBKTask, bl);
    }

    protected void onFillEntityFullInfo_PlanPSDCRobot(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPlanPSDCRobotIdDirty()) {
            if (pSDCBKTask.getPlanPSDCRobotId() != null) {
                if (pSDCBKTask.getPlanPSDCRobotId() == null || pSDCBKTask.getPlanPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSDCBKTask.getPlanPSDCRobot();
                    pSDCBKTask.setPlanPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSDCBKTask.setPlanPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPSDCRobotIdDirty()) {
            if (pSDCBKTask.getPSDCRobotId() != null) {
                if (pSDCBKTask.getPSDCRobotId() == null || pSDCBKTask.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSDCBKTask.getPSDCRobot();
                    pSDCBKTask.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSDCBKTask.setPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPSDevCenterIdDirty()) {
            if (pSDCBKTask.getPSDevCenterId() != null) {
                if (pSDCBKTask.getPSDevCenterId() == null || pSDCBKTask.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCBKTask.getPSDevCenter();
                    pSDCBKTask.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCBKTask.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPSDevSlnSysIdDirty()) {
            if (pSDCBKTask.getPSDevSlnSysId() != null) {
                if (pSDCBKTask.getPSDevSlnSysId() == null || pSDCBKTask.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSDCBKTask.getPSDevSlnSys();
                    pSDCBKTask.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSDCBKTask.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPSDevSlnIdDirty()) {
            if (pSDCBKTask.getPSDevSlnId() != null) {
                if (pSDCBKTask.getPSDevSlnId() == null || pSDCBKTask.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDCBKTask.getPSDevSln();
                    pSDCBKTask.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDCBKTask.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        if (pSDCBKTask.isPSTaskServerIdDirty()) {
            if (pSDCBKTask.getPSTaskServerId() != null) {
                if (pSDCBKTask.getPSTaskServerId() == null || pSDCBKTask.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDCBKTask.getPSTaskServer();
                    pSDCBKTask.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDCBKTask.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCBKTask, bl);
    }

    public ArrayList<PSDCBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPlanPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPlanPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PLANPSDCROBOTID", (Object)pSDCRobotBase.getPSDCRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPlanPSDCRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPlanPSDCRobotCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCROBOTID", (Object)pSDCRobotBase.getPSDCRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRobotCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCBKTask> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCBKTask> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCBKTask> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDCBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDCBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDCBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCROBOT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRobot);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCBKTASK_PSDCROBOT_PLANPSDCROBOTID", "", iDataEntityModel.getName(), "PSDCBKTASK", iDataEntityModel.getDataInfo(pSDCRobot), arrayList.get(0)));
        }
    }

    public void resetPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPlanPSDCRobotId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPlanPSDCRobot(pSDCRobot2);
                PSDCBKTaskServiceBase.this.internalRemoveByPlanPSDCRobot(pSDCRobot2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPlanPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPlanPSDCRobot(pSDCRobot, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPlanPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPSDCRobotId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSDCBKTaskServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPSDevCenterId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCBKTaskServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPSDevSlnSysId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCBKTaskServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPSDevSlnId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCBKTaskServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            PSDCBKTask pSDCBKTask2 = (PSDCBKTask)this.getDEModel().createEntity();
            pSDCBKTask2.setPSDCBKTaskId(pSDCBKTask.getPSDCBKTaskId());
            pSDCBKTask2.setPSTaskServerId(null);
            this.update(pSDCBKTask2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCBKTaskServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDCBKTaskServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDCBKTaskServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDCBKTask> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDCBKTask pSDCBKTask : arrayList) {
            this.remove(pSDCBKTask);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDCBKTask> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCBKTask pSDCBKTask) throws Exception {
        super.onBeforeRemove(pSDCBKTask);
    }

    protected void replaceParentInfo(PSDCBKTask pSDCBKTask, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCBKTask, cloneSession);
        if (pSDCBKTask.getPlanPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSDCBKTask.getPlanPSDCRobotId())) != null) {
            this.onFillParentInfo_PlanPSDCRobot(pSDCBKTask, (PSDCRobot)iEntity);
        }
        if (pSDCBKTask.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSDCBKTask.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSDCBKTask, (PSDCRobot)iEntity);
        }
        if (pSDCBKTask.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCBKTask.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCBKTask, (PSDevCenter)iEntity);
        }
        if (pSDCBKTask.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDCBKTask.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSDCBKTask, (PSDevSlnSys)iEntity);
        }
        if (pSDCBKTask.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCBKTask.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCBKTask, (PSDevSln)iEntity);
        }
        if (pSDCBKTask.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDCBKTask.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDCBKTask, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCBKTask, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDCBKTask, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullResultInfo(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastCalcTime(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanPSDCRobotId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanPSDCRobotName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBKTaskId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCBKTaskName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueueInfo(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemainingTime(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoteAddr(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepInfo(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam2(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam3(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam4(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParams(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskState(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskType(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalTime(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UseRobotFlag(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCBKTask, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isBeginTimeDirty() : !pSDCBKTask.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCBKTask.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isEndTimeDirty() : !pSDCBKTask.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCBKTask.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullResultInfo(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isFullResultInfoDirty() : !pSDCBKTask.isFullResultInfoDirty()) {
            return null;
        }
        String string = pSDCBKTask.getFullResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullResultInfo_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLRESULTINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastCalcTime(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isLastCalcTimeDirty() : !pSDCBKTask.isLastCalcTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCBKTask.getLastCalcTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastCalcTime_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTCALCTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isMemoDirty() : !pSDCBKTask.isMemoDirty()) {
            return null;
        }
        String string = pSDCBKTask.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isOrderValueDirty() && !bl2 : !pSDCBKTask.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDCBKTask.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlanPSDCRobotId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPlanPSDCRobotIdDirty() : !pSDCBKTask.isPlanPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPlanPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlanPSDCRobotId_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANPSDCROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlanPSDCRobotName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPlanPSDCRobotNameDirty() : !pSDCBKTask.isPlanPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPlanPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlanPSDCRobotName_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLANPSDCROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCBKTaskId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDCBKTaskIdDirty() && !bl2 : !pSDCBKTask.isPSDCBKTaskIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDCBKTaskId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBKTASKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBKTaskId_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBKTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCBKTaskName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDCBKTaskNameDirty() && !bl2 : !pSDCBKTask.isPSDCBKTaskNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDCBKTaskName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBKTASKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCBKTaskName_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCBKTASKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDCRobotIdDirty() : !pSDCBKTask.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDCRobotNameDirty() : !pSDCBKTask.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevCenterIdDirty() : !pSDCBKTask.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevCenterNameDirty() : !pSDCBKTask.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevSlnIdDirty() : !pSDCBKTask.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevSlnNameDirty() : !pSDCBKTask.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevSlnName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevSlnSysIdDirty() : !pSDCBKTask.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDevSlnSysNameDirty() : !pSDCBKTask.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDSConsoleIdDirty() : !pSDCBKTask.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSCONSOLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSDynaInstIdDirty() : !pSDCBKTask.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSTaskServerIdDirty() : !pSDCBKTask.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isPSTaskServerNameDirty() : !pSDCBKTask.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDCBKTask.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_QueueInfo(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isQueueInfoDirty() : !pSDCBKTask.isQueueInfoDirty()) {
            return null;
        }
        String string = pSDCBKTask.getQueueInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueueInfo_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUEUEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemainingTime(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isRemainingTimeDirty() : !pSDCBKTask.isRemainingTimeDirty()) {
            return null;
        }
        Integer n = pSDCBKTask.getRemainingTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemainingTime_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMAININGTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoteAddr(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isRemoteAddrDirty() : !pSDCBKTask.isRemoteAddrDirty()) {
            return null;
        }
        String string = pSDCBKTask.getRemoteAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoteAddr_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOTEADDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResultInfo(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isResultInfoDirty() : !pSDCBKTask.isResultInfoDirty()) {
            return null;
        }
        String string = pSDCBKTask.getResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESULTINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepInfo(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isStepInfoDirty() : !pSDCBKTask.isStepInfoDirty()) {
            return null;
        }
        String string = pSDCBKTask.getStepInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepInfo_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParam(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskParamDirty() : !pSDCBKTask.isTaskParamDirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParam2(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskParam2Dirty() : !pSDCBKTask.isTaskParam2Dirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam2_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParam3(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskParam3Dirty() : !pSDCBKTask.isTaskParam3Dirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam3_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParam4(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskParam4Dirty() : !pSDCBKTask.isTaskParam4Dirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam4_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParams(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskParamsDirty() : !pSDCBKTask.isTaskParamsDirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParams_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskState(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskStateDirty() && !bl2 : !pSDCBKTask.isTaskStateDirty()) {
            return null;
        }
        Integer n = pSDCBKTask.getTaskState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_TaskState_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskType(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTaskTypeDirty() && !bl2 : !pSDCBKTask.isTaskTypeDirty()) {
            return null;
        }
        String string = pSDCBKTask.getTaskType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskType_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalTime(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isTotalTimeDirty() : !pSDCBKTask.isTotalTimeDirty()) {
            return null;
        }
        Integer n = pSDCBKTask.getTotalTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalTime_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UseRobotFlag(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isUseRobotFlagDirty() : !pSDCBKTask.isUseRobotFlagDirty()) {
            return null;
        }
        Integer n = pSDCBKTask.getUseRobotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UseRobotFlag_Default(pSDCBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEROBOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isUserTagDirty() : !pSDCBKTask.isUserTagDirty()) {
            return null;
        }
        String string = pSDCBKTask.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCBKTask pSDCBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCBKTask.isUserTag2Dirty() : !pSDCBKTask.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCBKTask.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCBKTask, bl2, bl3);
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

    protected void onSyncEntity(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        super.onSyncEntity(pSDCBKTask, bl);
    }

    protected void onSyncIndexEntities(PSDCBKTask pSDCBKTask, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCBKTask, bl);
    }

    public Object getDataContextValue(PSDCBKTask pSDCBKTask, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCBKTask, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevCenter pSDevCenter = pSDCBKTask.getPSDevCenter();
        if (pSDevCenter != null && pSDevCenter.contains(string)) {
            return pSDevCenter.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCBKTask pSDCBKTask, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCBKTask, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLRESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullResultInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTCALCTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastCalcTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLANPSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlanPSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLANPSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlanPSDCRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBKTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBKTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCBKTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCBKTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUEUEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueueInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMAININGTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemainingTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOTEADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoteAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEROBOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UseRobotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FullResultInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLRESULTINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LastCalcTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PlanPSDCRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLANPSDCROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlanPSDCRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLANPSDCROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBKTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBKTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCBKTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCBKTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDSConsoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSCONSOLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_QueueInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUEUEINFO", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemainingTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RemoteAddr_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOTEADDR", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResultInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESULTINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TaskState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TaskType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TotalTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_UseRobotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, PSDCBKTask pSDCBKTask) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCBKTask)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCBKTask pSDCBKTask) throws Exception {
        super.onUpdateParent(pSDCBKTask);
    }

    @Override
    protected void exportCurXmlModel(PSDCBKTask pSDCBKTask, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCBKTASK");
        if (!bl) {
            pSDCBKTask.setCreateDate(null);
            pSDCBKTask.setCreateMan(null);
            pSDCBKTask.setPSDCBKTaskId(null);
            pSDCBKTask.setPSDevCenterName(null);
            pSDCBKTask.setUpdateDate(null);
            pSDCBKTask.setUpdateMan(null);
            super.exportCurXmlModel(pSDCBKTask, xmlNode, bl);
        }
    }
}

