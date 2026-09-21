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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevBKTaskDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevBKTaskDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTaskBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevBKTaskServiceBase
extends PSCoreSysServiceBase<PSSysDevBKTask> {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskServiceBase.class);
    public static final String DATASET_CURSYSFINISH = "CurSysFinish";
    public static final String DATASET_CURSYSRUN = "CurSysRun";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_X_CANCELTASK = "X_CANCELTASK";
    public static final String ACTION_REMOVEEXECUTED = "RemoveExecuted";
    private PSSysDevBKTaskDEModel pSSysDevBKTaskDEModel;
    private PSSysDevBKTaskDAO pSSysDevBKTaskDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService";
    }

    public PSSysDevBKTaskDEModel getPSSysDevBKTaskDEModel() {
        if (this.pSSysDevBKTaskDEModel == null) {
            try {
                this.pSSysDevBKTaskDEModel = (PSSysDevBKTaskDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevBKTaskDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevBKTaskDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDevBKTaskDEModel();
    }

    public PSSysDevBKTaskDAO getPSSysDevBKTaskDAO() {
        if (this.pSSysDevBKTaskDAO == null) {
            try {
                this.pSSysDevBKTaskDAO = (PSSysDevBKTaskDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevBKTaskDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevBKTaskDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDevBKTaskDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSFINISH, (boolean)true) == 0) {
            return this.fetchCurSysFinish(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSRUN, (boolean)true) == 0) {
            return this.fetchCurSysRun(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_CANCELTASK, (boolean)true) == 0) {
            this.cancelTask((PSSysDevBKTask)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REMOVEEXECUTED, (boolean)true) == 0) {
            this.removeExecuted((PSSysDevBKTask)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSysFinish(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSFINISH, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysRun(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSRUN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void cancelTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_CANCELTASK, 0, (IEntity)pSSysDevBKTask, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysDevBKTask, ACTION_X_CANCELTASK);
        final PSSysDevBKTask pSSysDevBKTask2 = pSSysDevBKTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysDevBKTaskServiceBase.this.getService(), PSSysDevBKTaskServiceBase.ACTION_X_CANCELTASK, 40, (IEntity)pSSysDevBKTask2, null).getResult() != 1) {
                    PSSysDevBKTaskServiceBase.this.onCancelTask(pSSysDevBKTask2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_CANCELTASK, 99, (IEntity)pSSysDevBKTask, null);
        }
    }

    protected void onCancelTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_CANCELTASK]");
    }

    public void removeExecuted(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REMOVEEXECUTED, 0, (IEntity)pSSysDevBKTask, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysDevBKTask, ACTION_REMOVEEXECUTED);
        final PSSysDevBKTask pSSysDevBKTask2 = pSSysDevBKTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysDevBKTaskServiceBase.this.getService(), PSSysDevBKTaskServiceBase.ACTION_REMOVEEXECUTED, 40, (IEntity)pSSysDevBKTask2, null).getResult() != 1) {
                    PSSysDevBKTaskServiceBase.this.onRemoveExecuted(pSSysDevBKTask2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REMOVEEXECUTED, 99, (IEntity)pSSysDevBKTask, null);
        }
    }

    protected void onRemoveExecuted(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RemoveExecuted]");
    }

    protected void onFillParentInfo(PSSysDevBKTask pSSysDevBKTask, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVBKTASK_PSDCROBOT_PLANPSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRobot);
            } else {
                iService.get((IEntity)pSDCRobot);
            }
            this.onFillParentInfo_PlanPSDCRobot(pSSysDevBKTask, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVBKTASK_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCRobot);
            } else {
                iService.get((IEntity)pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSSysDevBKTask, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVBKTASK_PSSYSDEVBKTASK_PPSSYSDEVBKTASKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService", (SessionFactory)this.getSessionFactory());
            PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)iService.getDEModel().createEntity();
            pSSysDevBKTask2.set("PSSYSDEVBKTASKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDevBKTask2);
            } else {
                iService.get((IEntity)pSSysDevBKTask2);
            }
            this.onFillParentInfo_PPSysDevBKTask(pSSysDevBKTask, pSSysDevBKTask2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVBKTASK_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysDevBKTask, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDEVBKTASK_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSSysDevBKTask, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDevBKTask, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PlanPSDCRobot(PSSysDevBKTask pSSysDevBKTask, PSDCRobot pSDCRobot) throws Exception {
        pSSysDevBKTask.setPlanPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSSysDevBKTask.setPlanPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDCRobot(PSSysDevBKTask pSSysDevBKTask, PSDCRobot pSDCRobot) throws Exception {
        pSSysDevBKTask.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSSysDevBKTask.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask, PSSysDevBKTask pSSysDevBKTask2) throws Exception {
        pSSysDevBKTask.setPPSSysDevBKTaskId(pSSysDevBKTask2.getPSSysDevBKTaskId());
        pSSysDevBKTask.setPPSSysDevBKTaskName(pSSysDevBKTask2.getPSSysDevBKTaskName());
    }

    protected void onFillParentInfo_PSSystem(PSSysDevBKTask pSSysDevBKTask, PSSystem pSSystem) throws Exception {
        pSSysDevBKTask.setPSSystemId(pSSystem.getPSSystemId());
        pSSysDevBKTask.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSTaskServer(PSSysDevBKTask pSSysDevBKTask, PSTaskServer pSTaskServer) throws Exception {
        pSSysDevBKTask.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSSysDevBKTask.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (bl && pSSysDevBKTask.getOrderValue() == null) {
            pSSysDevBKTask.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysDevBKTask, bl);
        this.onFillEntityFullInfo_PlanPSDCRobot(pSSysDevBKTask, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSSysDevBKTask, bl);
        this.onFillEntityFullInfo_PPSysDevBKTask(pSSysDevBKTask, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysDevBKTask, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSSysDevBKTask, bl);
    }

    protected void onFillEntityFullInfo_PlanPSDCRobot(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (pSSysDevBKTask.isPlanPSDCRobotIdDirty()) {
            if (pSSysDevBKTask.getPlanPSDCRobotId() != null) {
                if (pSSysDevBKTask.getPlanPSDCRobotId() == null || pSSysDevBKTask.getPlanPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSSysDevBKTask.getPlanPSDCRobot();
                    pSSysDevBKTask.setPlanPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSSysDevBKTask.setPlanPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (pSSysDevBKTask.isPSDCRobotIdDirty()) {
            if (pSSysDevBKTask.getPSDCRobotId() != null) {
                if (pSSysDevBKTask.getPSDCRobotId() == null || pSSysDevBKTask.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSSysDevBKTask.getPSDCRobot();
                    pSSysDevBKTask.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSSysDevBKTask.setPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (pSSysDevBKTask.isPPSSysDevBKTaskIdDirty()) {
            if (pSSysDevBKTask.getPPSSysDevBKTaskId() != null) {
                if (pSSysDevBKTask.getPPSSysDevBKTaskId() == null || pSSysDevBKTask.getPPSSysDevBKTaskName() == null) {
                    PSSysDevBKTask pSSysDevBKTask2 = pSSysDevBKTask.getPPSysDevBKTask();
                    pSSysDevBKTask.setPPSSysDevBKTaskName(pSSysDevBKTask2.getPSSysDevBKTaskName());
                }
            } else {
                pSSysDevBKTask.setPPSSysDevBKTaskName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (pSSysDevBKTask.isPSSystemIdDirty()) {
            if (pSSysDevBKTask.getPSSystemId() != null) {
                if (pSSysDevBKTask.getPSSystemId() == null || pSSysDevBKTask.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysDevBKTask.getPSSystem();
                    pSSysDevBKTask.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysDevBKTask.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        if (pSSysDevBKTask.isPSTaskServerIdDirty()) {
            if (pSSysDevBKTask.getPSTaskServerId() != null) {
                if (pSSysDevBKTask.getPSTaskServerId() == null || pSSysDevBKTask.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSSysDevBKTask.getPSTaskServer();
                    pSSysDevBKTask.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSSysDevBKTask.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDevBKTask, bl);
    }

    public ArrayList<PSSysDevBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPlanPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPlanPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPlanPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDevBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDevBKTask> selectByPPSysDevBKTask(PSSysDevBKTaskBase pSSysDevBKTaskBase) throws Exception {
        return this.selectByPPSysDevBKTask(pSSysDevBKTaskBase, "", -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPPSysDevBKTask(PSSysDevBKTaskBase pSSysDevBKTaskBase, String string) throws Exception {
        return this.selectByPPSysDevBKTask(pSSysDevBKTaskBase, string, -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPPSysDevBKTask(PSSysDevBKTaskBase pSSysDevBKTaskBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSDEVBKTASKID", (Object)pSSysDevBKTaskBase.getPSSysDevBKTaskId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSysDevBKTaskCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSysDevBKTaskCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDevBKTask> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDevBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSSysDevBKTask> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCROBOT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDCRobot);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDEVBKTASK_PSDCROBOT_PLANPSDCROBOTID", "", iDataEntityModel.getName(), "PSSYSDEVBKTASK", iDataEntityModel.getDataInfo((IEntity)pSDCRobot), arrayList.get(0)));
        }
    }

    public void resetPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)this.getDEModel().createEntity();
            pSSysDevBKTask2.setPSSysDevBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
            pSSysDevBKTask2.setPlanPSDCRobotId(null);
            this.update(pSSysDevBKTask2);
        }
    }

    public void removeByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevBKTaskServiceBase.this.onBeforeRemoveByPlanPSDCRobot(pSDCRobot2);
                PSSysDevBKTaskServiceBase.this.internalRemoveByPlanPSDCRobot(pSDCRobot2);
                PSSysDevBKTaskServiceBase.this.onAfterRemoveByPlanPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPlanPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPlanPSDCRobot(pSDCRobot, arrayList);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            this.remove((IEntity)pSSysDevBKTask);
        }
        this.onAfterRemoveByPlanPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPlanPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)this.getDEModel().createEntity();
            pSSysDevBKTask2.setPSSysDevBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
            pSSysDevBKTask2.setPSDCRobotId(null);
            this.update(pSSysDevBKTask2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevBKTaskServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSSysDevBKTaskServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSSysDevBKTaskServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            this.remove((IEntity)pSSysDevBKTask);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
    }

    public void resetPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPPSysDevBKTask(pSSysDevBKTask);
        for (PSSysDevBKTask pSSysDevBKTask2 : arrayList) {
            PSSysDevBKTask pSSysDevBKTask3 = (PSSysDevBKTask)this.getDEModel().createEntity();
            pSSysDevBKTask3.setPSSysDevBKTaskId(pSSysDevBKTask2.getPSSysDevBKTaskId());
            pSSysDevBKTask3.setPPSSysDevBKTaskId(null);
            this.update(pSSysDevBKTask3);
        }
    }

    public void removeByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        final PSSysDevBKTask pSSysDevBKTask2 = pSSysDevBKTask;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevBKTaskServiceBase.this.onBeforeRemoveByPPSysDevBKTask(pSSysDevBKTask2);
                PSSysDevBKTaskServiceBase.this.internalRemoveByPPSysDevBKTask(pSSysDevBKTask2);
                PSSysDevBKTaskServiceBase.this.onAfterRemoveByPPSysDevBKTask(pSSysDevBKTask2);
            }
        });
    }

    protected void onBeforeRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
    }

    protected void internalRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPPSysDevBKTask(pSSysDevBKTask);
        this.onBeforeRemoveByPPSysDevBKTask(pSSysDevBKTask, arrayList);
        for (PSSysDevBKTask pSSysDevBKTask2 : arrayList) {
            this.remove((IEntity)pSSysDevBKTask2);
        }
        this.onAfterRemoveByPPSysDevBKTask(pSSysDevBKTask, arrayList);
    }

    protected void onAfterRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask) throws Exception {
    }

    protected void onBeforeRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSysDevBKTask(PSSysDevBKTask pSSysDevBKTask, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)this.getDEModel().createEntity();
            pSSysDevBKTask2.setPSSysDevBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
            pSSysDevBKTask2.setPSSystemId(null);
            this.update(pSSysDevBKTask2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevBKTaskServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysDevBKTaskServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysDevBKTaskServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            this.remove((IEntity)pSSysDevBKTask);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            PSSysDevBKTask pSSysDevBKTask2 = (PSSysDevBKTask)this.getDEModel().createEntity();
            pSSysDevBKTask2.setPSSysDevBKTaskId(pSSysDevBKTask.getPSSysDevBKTaskId());
            pSSysDevBKTask2.setPSTaskServerId(null);
            this.update(pSSysDevBKTask2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDevBKTaskServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSSysDevBKTaskServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSSysDevBKTaskServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSSysDevBKTask> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSSysDevBKTask pSSysDevBKTask : arrayList) {
            this.remove((IEntity)pSSysDevBKTask);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSSysDevBKTask> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        PSSysDevBKTaskService pSSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)this.getSessionFactory());
        pSSysDevBKTaskService.testRemoveByPPSysDevBKTask(pSSysDevBKTask);
        pSSysDevBKTaskService.removeByPPSysDevBKTask(pSSysDevBKTask);
        super.onBeforeRemove(pSSysDevBKTask);
    }

    protected void replaceParentInfo(PSSysDevBKTask pSSysDevBKTask, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDevBKTask, cloneSession);
        if (pSSysDevBKTask.getPlanPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSSysDevBKTask.getPlanPSDCRobotId())) != null) {
            this.onFillParentInfo_PlanPSDCRobot(pSSysDevBKTask, (PSDCRobot)iEntity);
        }
        if (pSSysDevBKTask.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSSysDevBKTask.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSSysDevBKTask, (PSDCRobot)iEntity);
        }
        if (pSSysDevBKTask.getPPSSysDevBKTaskId() != null && (iEntity = cloneSession.getEntity("PSSYSDEVBKTASK", (Object)pSSysDevBKTask.getPPSSysDevBKTaskId())) != null) {
            this.onFillParentInfo_PPSysDevBKTask(pSSysDevBKTask, (PSSysDevBKTask)iEntity);
        }
        if (pSSysDevBKTask.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysDevBKTask.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysDevBKTask, (PSSystem)iEntity);
        }
        if (pSSysDevBKTask.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSSysDevBKTask.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSSysDevBKTask, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDevBKTask, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSSysDevBKTask, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullResultInfo(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkInfo(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelLevel(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanPSDCRobotId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlanPSDCRobotName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysDevBKTaskId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysDevBKTaskName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDevBKTaskId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDevBKTaskName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueueInfo(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoteAddr(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam2(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam3(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam4(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskState(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskType(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UseRobotFlag(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysDevBKTask, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDevBKTask, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isBeginTimeDirty() : !pSSysDevBKTask.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDevBKTask.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isEndTimeDirty() : !pSSysDevBKTask.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSSysDevBKTask.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_FullResultInfo(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isFullResultInfoDirty() : !pSSysDevBKTask.isFullResultInfoDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getFullResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullResultInfo_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkInfo(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isLinkInfoDirty() : !pSSysDevBKTask.isLinkInfoDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getLinkInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkInfo_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isMemoDirty() : !pSSysDevBKTask.isMemoDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelLevel(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isModelLevelDirty() : !pSSysDevBKTask.isModelLevelDirty()) {
            return null;
        }
        Integer n = pSSysDevBKTask.getModelLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelLevel_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isOrderValueDirty() && !bl2 : !pSSysDevBKTask.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysDevBKTask.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlanPSDCRobotId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPlanPSDCRobotIdDirty() : !pSSysDevBKTask.isPlanPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPlanPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlanPSDCRobotId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PlanPSDCRobotName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPlanPSDCRobotNameDirty() : !pSSysDevBKTask.isPlanPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPlanPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlanPSDCRobotName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysDevBKTaskId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPPSSysDevBKTaskIdDirty() : !pSSysDevBKTask.isPPSSysDevBKTaskIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPPSSysDevBKTaskId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysDevBKTaskId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSDEVBKTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysDevBKTaskName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPPSSysDevBKTaskNameDirty() : !pSSysDevBKTask.isPPSSysDevBKTaskNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPPSSysDevBKTaskName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysDevBKTaskName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSDEVBKTASKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDCRobotIdDirty() : !pSSysDevBKTask.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDCRobotNameDirty() : !pSSysDevBKTask.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDevSlnIdDirty() : !pSSysDevBKTask.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDevSlnSysIdDirty() : !pSSysDevBKTask.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDSConsoleIdDirty() : !pSSysDevBKTask.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSDynaInstIdDirty() : !pSSysDevBKTask.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDevBKTaskId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSSysDevBKTaskIdDirty() && !bl2 : !pSSysDevBKTask.isPSSysDevBKTaskIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSSysDevBKTaskId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVBKTASKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevBKTaskId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVBKTASKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDevBKTaskName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSSysDevBKTaskNameDirty() && !bl2 : !pSSysDevBKTask.isPSSysDevBKTaskNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSSysDevBKTaskName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVBKTASKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDevBKTaskName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDEVBKTASKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSSysModelInstIdDirty() : !pSSysDevBKTask.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSSystemIdDirty() : !pSSysDevBKTask.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSSystemNameDirty() : !pSSysDevBKTask.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSTaskServerIdDirty() : !pSSysDevBKTask.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isPSTaskServerNameDirty() : !pSSysDevBKTask.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_QueueInfo(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isQueueInfoDirty() : !pSSysDevBKTask.isQueueInfoDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getQueueInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QueueInfo_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemoteAddr(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isRemoteAddrDirty() : !pSSysDevBKTask.isRemoteAddrDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getRemoteAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoteAddr_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResultInfo(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isResultInfoDirty() : !pSSysDevBKTask.isResultInfoDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskParamDirty() : !pSSysDevBKTask.isTaskParamDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getTaskParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam2(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskParam2Dirty() : !pSSysDevBKTask.isTaskParam2Dirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getTaskParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam2_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam3(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskParam3Dirty() : !pSSysDevBKTask.isTaskParam3Dirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getTaskParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam3_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam4(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskParam4Dirty() : !pSSysDevBKTask.isTaskParam4Dirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getTaskParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam4_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskState(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskStateDirty() && !bl2 : !pSSysDevBKTask.isTaskStateDirty()) {
            return null;
        }
        Integer n = pSSysDevBKTask.getTaskState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_TaskState_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskType(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isTaskTypeDirty() && !bl2 : !pSSysDevBKTask.isTaskTypeDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getTaskType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskType_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_UseRobotFlag(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isUseRobotFlagDirty() : !pSSysDevBKTask.isUseRobotFlagDirty()) {
            return null;
        }
        Integer n = pSSysDevBKTask.getUseRobotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UseRobotFlag_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isUserTagDirty() : !pSSysDevBKTask.isUserTagDirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysDevBKTask pSSysDevBKTask, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDevBKTask.isUserTag2Dirty() : !pSSysDevBKTask.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysDevBKTask.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysDevBKTask, bl2, bl3);
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

    protected void onSyncEntity(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDevBKTask, bl);
    }

    protected void onSyncIndexEntities(PSSysDevBKTask pSSysDevBKTask, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDevBKTask, bl);
    }

    public Object getDataContextValue(PSSysDevBKTask pSSysDevBKTask, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDevBKTask, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDevBKTask pSSysDevBKTask, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDevBKTask, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"LINKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelLevel_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PPSSYSDEVBKTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDevBKTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSDEVBKTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysDevBKTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSCONSOLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSConsoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVBKTASKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevBKTaskId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDEVBKTASKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDevBKTaskName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REMOTEADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoteAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TASKSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_LinkInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_ModelLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PPSSysDevBKTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDEVBKTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSSYSDEVBKTASKID", "PSSYSDEVBKTASK", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysDevBKTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSDEVBKTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDevBKTaskId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVBKTASKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDevBKTaskName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDEVBKTASKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysDevBKTask pSSysDevBKTask) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDevBKTask)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDevBKTask pSSysDevBKTask) throws Exception {
        super.onUpdateParent((IEntity)pSSysDevBKTask);
    }

    @Override
    protected void exportCurXmlModel(PSSysDevBKTask pSSysDevBKTask, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDEVBKTASK");
        if (!bl) {
            super.exportCurXmlModel(pSSysDevBKTask, xmlNode, bl);
        }
    }
}

