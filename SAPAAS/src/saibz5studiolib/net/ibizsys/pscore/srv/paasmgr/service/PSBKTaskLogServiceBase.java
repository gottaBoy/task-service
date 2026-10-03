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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.paasmgr.dao.PSBKTaskLogDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSBKTaskLogDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLogBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSBKTaskLogServiceBase
extends PSCoreSysServiceBase<PSBKTaskLog> {
    private static final Log log = LogFactory.getLog(PSBKTaskLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSBKTaskLogDEModel pSBKTaskLogDEModel;
    private PSBKTaskLogDAO pSBKTaskLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService";
    }

    public PSBKTaskLogDEModel getPSBKTaskLogDEModel() {
        if (this.pSBKTaskLogDEModel == null) {
            try {
                this.pSBKTaskLogDEModel = (PSBKTaskLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSBKTaskLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSBKTaskLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSBKTaskLogDEModel();
    }

    public PSBKTaskLogDAO getPSBKTaskLogDAO() {
        if (this.pSBKTaskLogDAO == null) {
            try {
                this.pSBKTaskLogDAO = (PSBKTaskLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSBKTaskLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSBKTaskLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSBKTaskLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSBKTaskLog pSBKTaskLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSBKTASKLOG_PSBKTASKLOG_PPSBKTASKLOGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService", (SessionFactory)this.getSessionFactory());
            PSBKTaskLog pSBKTaskLog2 = (PSBKTaskLog)iService.getDEModel().createEntity();
            pSBKTaskLog2.set("PSBKTASKLOGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSBKTaskLog2);
            } else {
                iService.get(pSBKTaskLog2);
            }
            this.onFillParentInfo_PPSBKTaskLog(pSBKTaskLog, pSBKTaskLog2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSBKTASKLOG_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRobot);
            } else {
                iService.get(pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSBKTaskLog, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSBKTASKLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSBKTaskLog, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSBKTASKLOG_PSDEVSLNSYS_PSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys);
            } else {
                iService.get(pSDevSlnSys);
            }
            this.onFillParentInfo_PSDevSlnSys(pSBKTaskLog, pSDevSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSBKTASKLOG_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSBKTaskLog, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSBKTaskLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSBKTaskLog(PSBKTaskLog pSBKTaskLog, PSBKTaskLog pSBKTaskLog2) throws Exception {
        pSBKTaskLog.setPPSBKTaskLogId(pSBKTaskLog2.getPSBKTaskLogId());
        pSBKTaskLog.setPPSBKTaskLogName(pSBKTaskLog2.getPSBKTaskLogName());
    }

    protected void onFillParentInfo_PSDCRobot(PSBKTaskLog pSBKTaskLog, PSDCRobot pSDCRobot) throws Exception {
        pSBKTaskLog.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSBKTaskLog.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDevCenter(PSBKTaskLog pSBKTaskLog, PSDevCenter pSDevCenter) throws Exception {
        pSBKTaskLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSBKTaskLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSlnSys(PSBKTaskLog pSBKTaskLog, PSDevSlnSys pSDevSlnSys) throws Exception {
        pSBKTaskLog.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSBKTaskLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSTaskServer(PSBKTaskLog pSBKTaskLog, PSTaskServer pSTaskServer) throws Exception {
        pSBKTaskLog.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSBKTaskLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSBKTaskLog, bl);
        this.onFillEntityFullInfo_PPSBKTaskLog(pSBKTaskLog, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSBKTaskLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSBKTaskLog, bl);
        this.onFillEntityFullInfo_PSDevSlnSys(pSBKTaskLog, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSBKTaskLog, bl);
    }

    protected void onFillEntityFullInfo_PPSBKTaskLog(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (pSBKTaskLog.isPPSBKTaskLogIdDirty()) {
            if (pSBKTaskLog.getPPSBKTaskLogId() != null) {
                if (pSBKTaskLog.getPPSBKTaskLogId() == null || pSBKTaskLog.getPPSBKTaskLogName() == null) {
                    PSBKTaskLog pSBKTaskLog2 = pSBKTaskLog.getPPSBKTaskLog();
                    pSBKTaskLog.setPPSBKTaskLogName(pSBKTaskLog2.getPSBKTaskLogName());
                }
            } else {
                pSBKTaskLog.setPPSBKTaskLogName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (pSBKTaskLog.isPSDCRobotIdDirty()) {
            if (pSBKTaskLog.getPSDCRobotId() != null) {
                if (pSBKTaskLog.getPSDCRobotId() == null || pSBKTaskLog.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSBKTaskLog.getPSDCRobot();
                    pSBKTaskLog.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSBKTaskLog.setPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (pSBKTaskLog.isPSDevCenterIdDirty()) {
            if (pSBKTaskLog.getPSDevCenterId() != null) {
                if (pSBKTaskLog.getPSDevCenterId() == null || pSBKTaskLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSBKTaskLog.getPSDevCenter();
                    pSBKTaskLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSBKTaskLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSys(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (pSBKTaskLog.isPSDevSlnSysIdDirty()) {
            if (pSBKTaskLog.getPSDevSlnSysId() != null) {
                if (pSBKTaskLog.getPSDevSlnSysId() == null || pSBKTaskLog.getPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys = pSBKTaskLog.getPSDevSlnSys();
                    pSBKTaskLog.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
                }
            } else {
                pSBKTaskLog.setPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        if (pSBKTaskLog.isPSTaskServerIdDirty()) {
            if (pSBKTaskLog.getPSTaskServerId() != null) {
                if (pSBKTaskLog.getPSTaskServerId() == null || pSBKTaskLog.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSBKTaskLog.getPSTaskServer();
                    pSBKTaskLog.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSBKTaskLog.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSBKTaskLog, bl);
    }

    public ArrayList<PSBKTaskLog> selectByPPSBKTaskLog(PSBKTaskLogBase pSBKTaskLogBase) throws Exception {
        return this.selectByPPSBKTaskLog(pSBKTaskLogBase, "", -1);
    }

    public ArrayList<PSBKTaskLog> selectByPPSBKTaskLog(PSBKTaskLogBase pSBKTaskLogBase, String string) throws Exception {
        return this.selectByPPSBKTaskLog(pSBKTaskLogBase, string, -1);
    }

    public ArrayList<PSBKTaskLog> selectByPPSBKTaskLog(PSBKTaskLogBase pSBKTaskLogBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSBKTASKLOGID", (Object)pSBKTaskLogBase.getPSBKTaskLogId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSBKTaskLogCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSBKTaskLogCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSBKTaskLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
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

    public ArrayList<PSBKTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSBKTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
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

    public ArrayList<PSBKTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSBKTaskLog> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
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

    public void testRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
    }

    public void resetPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPPSBKTaskLog(pSBKTaskLog);
        for (PSBKTaskLog pSBKTaskLog2 : arrayList) {
            PSBKTaskLog pSBKTaskLog3 = (PSBKTaskLog)this.getDEModel().createEntity();
            pSBKTaskLog3.setPSBKTaskLogId(pSBKTaskLog2.getPSBKTaskLogId());
            pSBKTaskLog3.setPPSBKTaskLogId(null);
            this.update(pSBKTaskLog3);
        }
    }

    public void removeByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
        final PSBKTaskLog pSBKTaskLog2 = pSBKTaskLog;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSBKTaskLogServiceBase.this.onBeforeRemoveByPPSBKTaskLog(pSBKTaskLog2);
                PSBKTaskLogServiceBase.this.internalRemoveByPPSBKTaskLog(pSBKTaskLog2);
                PSBKTaskLogServiceBase.this.onAfterRemoveByPPSBKTaskLog(pSBKTaskLog2);
            }
        });
    }

    protected void onBeforeRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
    }

    protected void internalRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPPSBKTaskLog(pSBKTaskLog);
        this.onBeforeRemoveByPPSBKTaskLog(pSBKTaskLog, arrayList);
        for (PSBKTaskLog pSBKTaskLog2 : arrayList) {
            this.remove(pSBKTaskLog2);
        }
        this.onAfterRemoveByPPSBKTaskLog(pSBKTaskLog, arrayList);
    }

    protected void onAfterRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog) throws Exception {
    }

    protected void onBeforeRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSBKTaskLog(PSBKTaskLog pSBKTaskLog, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            PSBKTaskLog pSBKTaskLog2 = (PSBKTaskLog)this.getDEModel().createEntity();
            pSBKTaskLog2.setPSBKTaskLogId(pSBKTaskLog.getPSBKTaskLogId());
            pSBKTaskLog2.setPSDCRobotId(null);
            this.update(pSBKTaskLog2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSBKTaskLogServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSBKTaskLogServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSBKTaskLogServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            this.remove(pSBKTaskLog);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            PSBKTaskLog pSBKTaskLog2 = (PSBKTaskLog)this.getDEModel().createEntity();
            pSBKTaskLog2.setPSBKTaskLogId(pSBKTaskLog.getPSBKTaskLogId());
            pSBKTaskLog2.setPSDevCenterId(null);
            this.update(pSBKTaskLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSBKTaskLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSBKTaskLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSBKTaskLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            this.remove(pSBKTaskLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    public void resetPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            PSBKTaskLog pSBKTaskLog2 = (PSBKTaskLog)this.getDEModel().createEntity();
            pSBKTaskLog2.setPSBKTaskLogId(pSBKTaskLog.getPSBKTaskLogId());
            pSBKTaskLog2.setPSDevSlnSysId(null);
            this.update(pSBKTaskLog2);
        }
    }

    public void removeByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSBKTaskLogServiceBase.this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSBKTaskLogServiceBase.this.internalRemoveByPSDevSlnSys(pSDevSlnSys2);
                PSBKTaskLogServiceBase.this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            this.remove(pSBKTaskLog);
        }
        this.onAfterRemoveByPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            PSBKTaskLog pSBKTaskLog2 = (PSBKTaskLog)this.getDEModel().createEntity();
            pSBKTaskLog2.setPSBKTaskLogId(pSBKTaskLog.getPSBKTaskLogId());
            pSBKTaskLog2.setPSTaskServerId(null);
            this.update(pSBKTaskLog2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSBKTaskLogServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSBKTaskLogServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSBKTaskLogServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSBKTaskLog> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSBKTaskLog pSBKTaskLog : arrayList) {
            this.remove(pSBKTaskLog);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSBKTaskLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSBKTaskLog pSBKTaskLog) throws Exception {
        super.onBeforeRemove(pSBKTaskLog);
    }

    protected void replaceParentInfo(PSBKTaskLog pSBKTaskLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSBKTaskLog, cloneSession);
        if (pSBKTaskLog.getPPSBKTaskLogId() != null && (iEntity = cloneSession.getEntity("PSBKTASKLOG", (Object)pSBKTaskLog.getPPSBKTaskLogId())) != null) {
            this.onFillParentInfo_PPSBKTaskLog(pSBKTaskLog, (PSBKTaskLog)iEntity);
        }
        if (pSBKTaskLog.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSBKTaskLog.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSBKTaskLog, (PSDCRobot)iEntity);
        }
        if (pSBKTaskLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSBKTaskLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSBKTaskLog, (PSDevCenter)iEntity);
        }
        if (pSBKTaskLog.getPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSBKTaskLog.getPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PSDevSlnSys(pSBKTaskLog, (PSDevSlnSys)iEntity);
        }
        if (pSBKTaskLog.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSBKTaskLog.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSBKTaskLog, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSBKTaskLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSBKTaskLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSBKTaskLogId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSBKTaskLogName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSBKTaskLogId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSBKTaskLogName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSConsoleId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoteAddr(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResultInfo(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskCat(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam2(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam3(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskParam4(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskState(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TaskType(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UseRobotFlag(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSBKTaskLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSBKTaskLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isBeginTimeDirty() : !pSBKTaskLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSBKTaskLog.getBeginTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isEndTimeDirty() : !pSBKTaskLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSBKTaskLog.getEndTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isOrderValueDirty() && !bl2 : !pSBKTaskLog.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSBKTaskLog.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSBKTaskLogId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPPSBKTaskLogIdDirty() : !pSBKTaskLog.isPPSBKTaskLogIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPPSBKTaskLogId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSBKTaskLogId_Default(pSBKTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSBKTASKLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSBKTaskLogName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPPSBKTaskLogNameDirty() : !pSBKTaskLog.isPPSBKTaskLogNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPPSBKTaskLogName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSBKTaskLogName_Default(pSBKTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSBKTASKLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSBKTaskLogId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSBKTaskLogIdDirty() && !bl2 : !pSBKTaskLog.isPSBKTaskLogIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSBKTaskLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSBKTASKLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSBKTaskLogId_Default(pSBKTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSBKTASKLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSBKTaskLogName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSBKTaskLogNameDirty() && !bl2 : !pSBKTaskLog.isPSBKTaskLogNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSBKTaskLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSBKTASKLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSBKTaskLogName_Default(pSBKTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSBKTASKLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDCRobotIdDirty() : !pSBKTaskLog.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDCRobotNameDirty() : !pSBKTaskLog.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDevCenterIdDirty() : !pSBKTaskLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDevCenterNameDirty() : !pSBKTaskLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDevSlnSysIdDirty() : !pSBKTaskLog.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDevSlnSysNameDirty() : !pSBKTaskLog.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDSConsoleId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDSConsoleIdDirty() : !pSBKTaskLog.isPSDSConsoleIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDSConsoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSConsoleId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSDynaInstIdDirty() : !pSBKTaskLog.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSTaskServerIdDirty() : !pSBKTaskLog.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isPSTaskServerNameDirty() : !pSBKTaskLog.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemoteAddr(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isRemoteAddrDirty() : !pSBKTaskLog.isRemoteAddrDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getRemoteAddr();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemoteAddr_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_ResultInfo(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isResultInfoDirty() : !pSBKTaskLog.isResultInfoDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getResultInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResultInfo_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskCat(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskCatDirty() : !pSBKTaskLog.isTaskCatDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskCat_Default(pSBKTaskLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TaskParam(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskParamDirty() : !pSBKTaskLog.isTaskParamDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam2(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskParam2Dirty() : !pSBKTaskLog.isTaskParam2Dirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam2_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam3(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskParam3Dirty() : !pSBKTaskLog.isTaskParam3Dirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam3_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskParam4(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskParam4Dirty() : !pSBKTaskLog.isTaskParam4Dirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskParam4_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskState(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskStateDirty() && !bl2 : !pSBKTaskLog.isTaskStateDirty()) {
            return null;
        }
        Integer n = pSBKTaskLog.getTaskState();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKSTATE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_TaskState_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_TaskType(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isTaskTypeDirty() && !bl2 : !pSBKTaskLog.isTaskTypeDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getTaskType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TASKTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TaskType_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_UseRobotFlag(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isUseRobotFlagDirty() : !pSBKTaskLog.isUseRobotFlagDirty()) {
            return null;
        }
        Integer n = pSBKTaskLog.getUseRobotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UseRobotFlag_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isUserTagDirty() : !pSBKTaskLog.isUserTagDirty()) {
            return null;
        }
        String string = pSBKTaskLog.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSBKTaskLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSBKTaskLog pSBKTaskLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSBKTaskLog.isUserTag2Dirty() : !pSBKTaskLog.isUserTag2Dirty()) {
            return null;
        }
        String string = pSBKTaskLog.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSBKTaskLog, bl2, bl3);
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

    protected void onSyncEntity(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        super.onSyncEntity(pSBKTaskLog, bl);
    }

    protected void onSyncIndexEntities(PSBKTaskLog pSBKTaskLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSBKTaskLog, bl);
    }

    public Object getDataContextValue(PSBKTaskLog pSBKTaskLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSBKTaskLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSBKTaskLog pSBKTaskLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSBKTaskLog, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSBKTASKLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSBKTaskLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSBKTASKLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSBKTaskLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSBKTASKLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSBKTaskLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSBKTASKLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSBKTaskLogName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"REMOTEADDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoteAddr_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESULTINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResultInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TASKCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TaskCat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSBKTaskLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSBKTASKLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSBKTaskLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSBKTASKLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSBKTaskLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSBKTASKLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSBKTaskLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSBKTASKLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_TaskCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TASKCAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected boolean onMergeChild(String string, String string2, PSBKTaskLog pSBKTaskLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSBKTaskLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSBKTaskLog pSBKTaskLog) throws Exception {
        super.onUpdateParent(pSBKTaskLog);
    }

    @Override
    protected void exportCurXmlModel(PSBKTaskLog pSBKTaskLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSBKTASKLOG");
        if (!bl) {
            pSBKTaskLog.setCreateDate(null);
            pSBKTaskLog.setCreateMan(null);
            pSBKTaskLog.setPSBKTaskLogId(null);
            pSBKTaskLog.setUpdateDate(null);
            pSBKTaskLog.setUpdateMan(null);
            super.exportCurXmlModel(pSBKTaskLog, xmlNode, bl);
        }
    }
}

