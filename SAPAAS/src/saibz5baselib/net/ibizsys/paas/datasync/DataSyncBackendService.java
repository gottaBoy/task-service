/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.datasync;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.datasync.ActiveMQDataSyncEngine;
import net.ibizsys.paas.datasync.DataSyncGlobal;
import net.ibizsys.paas.datasync.DefaultDataSyncParam;
import net.ibizsys.paas.datasync.IDataSyncEngine;
import net.ibizsys.paas.datasync.IDataSyncInEngine;
import net.ibizsys.paas.datasync.IDataSyncOutEngine;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn2;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut2;
import net.ibizsys.psrt.srv.common.service.DataSyncAgentService;
import net.ibizsys.psrt.srv.common.service.DataSyncIn2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncOut2Service;
import net.ibizsys.psrt.srv.common.service.DataSyncOutService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataSyncBackendService
extends BackendServiceBase {
    private static Log log = LogFactory.getLog(DataSyncBackendService.class);
    public static final String PARAM_POLLTIMER = "POLLTIMER";
    public static final String PARAM_QUERYSQL = "QUERYSQL";
    private int nPollTimer = 30000;
    private Timer pollTimer = null;
    protected Hashtable<String, IDataSyncOutEngine> deDataSyncOutEngines = new Hashtable();
    protected Hashtable<String, IDataSyncInEngine> deDataSyncInEngines = new Hashtable();
    private String strFileLocalPath = "";
    private DataSyncOutService dataSyncOutService = null;
    private DataSyncOut2Service dataSyncOut2Service = null;
    private DataSyncIn2Service dataSyncIn2Service = null;
    private DataSyncAgentService dataSyncAgentService = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strFileLocalPath = this.getServiceParam("FILEFOLDER", "");
        if (StringHelper.isNullOrEmpty(this.strFileLocalPath)) {
            log.warn((Object)"\u6ca1\u6709\u5b9a\u4e49\u672c\u5730\u6587\u4ef6\u5b58\u50a8\u8def\u5f84\uff0c\u6587\u4ef6\u540c\u6b65\u65f6\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef");
        }
        this.dataSyncOutService = (DataSyncOutService)ServiceGlobal.getService(DataSyncOutService.class);
        this.dataSyncOut2Service = (DataSyncOut2Service)ServiceGlobal.getService(DataSyncOut2Service.class);
        this.dataSyncOut2Service = (DataSyncOut2Service)ServiceGlobal.getService(DataSyncOut2Service.class);
        this.dataSyncAgentService = (DataSyncAgentService)ServiceGlobal.getService(DataSyncAgentService.class);
        this.dataSyncIn2Service = (DataSyncIn2Service)ServiceGlobal.getService(DataSyncIn2Service.class);
    }

    @Override
    protected void onStart() throws Exception {
        super.onStart();
        this.nPollTimer = Integer.parseInt(this.getServiceParam(PARAM_POLLTIMER, "30000"));
        this.prepareDataSyncEngine();
        if (this.pollTimer == null) {
            this.pollTimer = new Timer("DEDATASYNCSERVICETIMER");
            this.pollTimer.schedule(new TimerTask(){

                @Override
                public void run() {
                    DataSyncBackendService.this.runTask();
                }
            }, this.nPollTimer, (long)this.nPollTimer);
        }
        log.info((Object)StringHelper.format("DataSyncService Start"));
    }

    protected void prepareDataSyncEngine() throws Exception {
        this.deDataSyncOutEngines.clear();
        this.deDataSyncInEngines.clear();
        SelectCond selectCond = new SelectCond();
        ArrayList dataSyncAgentList = this.dataSyncAgentService.select(selectCond);
        for (DataSyncAgent dataSyncAgent : dataSyncAgentList) {
            try {
                IDataSyncEngine iDataSyncEngine = this.createDataSyncEngine(dataSyncAgent);
                if (StringHelper.compare(iDataSyncEngine.getSyncDir(), "OUT", true) == 0) {
                    this.deDataSyncOutEngines.put(iDataSyncEngine.getId(), (IDataSyncOutEngine)iDataSyncEngine);
                    continue;
                }
                this.deDataSyncInEngines.put(iDataSyncEngine.getId(), (IDataSyncInEngine)iDataSyncEngine);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%2$s", dataSyncAgent.getDataSyncAgentId(), ex.getMessage()));
            }
        }
    }

    protected void resetDataSyncEngine() {
        for (IDataSyncOutEngine iDataSyncOutEngine : this.deDataSyncOutEngines.values()) {
            try {
                iDataSyncOutEngine.quit();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u9000\u51fa\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDataSyncOutEngine.getId(), ex.getMessage()));
            }
        }
        for (IDataSyncInEngine iDataSyncInEngine : this.deDataSyncInEngines.values()) {
            try {
                iDataSyncInEngine.quit();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u540c\u6b65\u5f15\u64ce\u5bf9\u8c61[%1$s]\u9000\u51fa\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDataSyncInEngine.getId(), ex.getMessage()));
            }
        }
        this.deDataSyncOutEngines.clear();
        this.deDataSyncInEngines.clear();
    }

    @Override
    protected void onStop() throws Exception {
        log.info((Object)StringHelper.format("DEDataSyncService Stop"));
        if (this.pollTimer != null) {
            this.pollTimer.cancel();
            this.pollTimer = null;
        }
        this.resetDataSyncEngine();
        super.onStop();
    }

    @Override
    protected void onRun() throws Exception {
        for (IDataSyncOutEngine iDataSyncOutEngine : this.deDataSyncOutEngines.values()) {
            try {
                if (!iDataSyncOutEngine.checkSend()) {
                    log.error((Object)StringHelper.format("\u6570\u636e\u540c\u6b65\u53d1\u9001\u5f15\u64ce[%1$s]\u53d1\u9001\u6d4b\u8bd5\u5931\u8d25\uff0c\u5ffd\u7565\u672c\u8f6e\u53d1\u9001", iDataSyncOutEngine.getName()));
                    continue;
                }
                int PAGESIZE = 500;
                SelectCond selectCond = new SelectCond();
                selectCond.setMaxRowCount(PAGESIZE);
                selectCond.setOrderInfo("ORDER BY CREATEDATE");
                selectCond.set("SYNCAGENT", iDataSyncOutEngine.getId());
                ArrayList dataSyncOutList = this.dataSyncOutService.select(selectCond);
                if (dataSyncOutList.size() == 0) continue;
                for (DataSyncOut dataSyncOut : dataSyncOutList) {
                    DefaultDataSyncParam defaultDataSyncParam = new DefaultDataSyncParam();
                    defaultDataSyncParam.setDataSyncOut(dataSyncOut);
                    DataSyncOut2 dataSyncOut2 = new DataSyncOut2();
                    dataSyncOut.copyTo(dataSyncOut2, false);
                    dataSyncOut2.setDataSyncOut2Id(dataSyncOut.getDataSyncOutId());
                    dataSyncOut2.setDataSyncOut2Name(dataSyncOut.getDataSyncOutName());
                    try {
                        iDataSyncOutEngine.send(defaultDataSyncParam);
                    }
                    catch (Exception ex) {
                        dataSyncOut2.setError(StringHelper.format("\u5904\u7406\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
                    }
                    this.dataSyncOutService.remove(dataSyncOut);
                    this.dataSyncOut2Service.create(dataSyncOut2, false);
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u6570\u636e\u540c\u6b65\u63a5\u6536\u5f15\u64ce[%1$s]\u53d1\u9001\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDataSyncOutEngine.getName(), ex.getMessage()), (Throwable)ex);
            }
        }
        for (IDataSyncInEngine iDataSyncInEngine : this.deDataSyncInEngines.values()) {
            try {
                DefaultDataSyncParam defaultDataSyncParam = new DefaultDataSyncParam();
                iDataSyncInEngine.recv(defaultDataSyncParam);
                this.processDataSyncIns(defaultDataSyncParam.getDataSyncIns());
                defaultDataSyncParam.resetDataSyncIns();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u6570\u636e\u540c\u6b65\u63a5\u6536\u5f15\u64ce[%1$s]\u63a5\u6536\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDataSyncInEngine.getName(), ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void processDataSyncIns(ArrayList<DataSyncIn> dataSyncInList) throws Exception {
        if (dataSyncInList.size() == 0) {
            return;
        }
        for (DataSyncIn dataSyncIn : dataSyncInList) {
            Iterator<IDEDataSyncIn> deDataSyncIns = DataSyncGlobal.getDEDataSyncIns(dataSyncIn.getDEName());
            if (deDataSyncIns == null) continue;
            DataSyncIn2 dataSyncIn2 = new DataSyncIn2();
            dataSyncIn.copyTo(dataSyncIn2, true);
            dataSyncIn2.setDataSyncIn2Name(dataSyncIn.getDataSyncInName());
            while (deDataSyncIns.hasNext()) {
                IDEDataSyncIn iDEDataSyncIn = deDataSyncIns.next();
                if (StringHelper.compare(iDEDataSyncIn.getSyncAgent(), dataSyncIn.getSyncAgent(), false) != 0) continue;
                try {
                    IService iService = DEModelGlobal.getDEModel(iDEDataSyncIn.getDataEntity().getName()).getService();
                    iService.syncData(dataSyncIn, iDEDataSyncIn);
                }
                catch (Exception ex) {
                    String strError = StringHelper.format("[%1$s]%2$s", iDEDataSyncIn.getDataEntity().getName(), ex.getMessage());
                    if (StringHelper.isNullOrEmpty(dataSyncIn2.getError())) {
                        dataSyncIn2.setError(strError);
                        continue;
                    }
                    dataSyncIn2.setError(String.valueOf(dataSyncIn2.getError()) + ";" + strError);
                }
            }
            try {
                this.dataSyncIn2Service.create(dataSyncIn2, false);
            }
            catch (Exception ex) {
                dataSyncIn2.setError(StringHelper.format("\u4fdd\u5b58\u6570\u636e\u540c\u6b65\u8f93\u5165\u961f\u5217(\u5df2\u5904\u7406)\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", ex.getMessage()));
                log.error((Object)dataSyncIn2.getError());
            }
        }
    }

    protected boolean testDataImport(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncIn, IService iService) throws Exception {
        if ((dataSyncIn.getEventType() & iDEDataSyncIn.getEventType()) == 0) {
            return false;
        }
        if (StringHelper.isNullOrEmpty(iDEDataSyncIn.getTestDEActionName())) {
            return true;
        }
        Object iEntity = iService.getDEModel().createEntity();
        if (!StringHelper.isNullOrEmpty(dataSyncIn.getLogicData())) {
            DataObject.fromJSONObject(iEntity, JSONObjectHelper.fromString(dataSyncIn.getLogicData()));
        }
        iService.executeAction(iDEDataSyncIn.getTestDEActionName(), (IEntity)iEntity);
        return DataObject.getBoolValue(iEntity, "SRFRET", false);
    }

    protected void processDataImport(DataSyncIn dataSyncIn, IDEDataSyncIn iDEDataSyncInc, IService iService) throws Exception {
        if (StringHelper.isNullOrEmpty(iDEDataSyncInc.getImportDEActionName())) {
            if (dataSyncIn.getEventType() == DataChangeEventCodeListModel.DELETE) {
                Object iEntity = iService.getDEModel().createEntity();
                iEntity.set(iService.getDEModel().getKeyDEField().getName(), dataSyncIn.getDataKey());
                try {
                    iService.remove(iEntity);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format("\u79fb\u9664\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
                }
            } else if ((dataSyncIn.getEventType() & DataChangeEventCodeListModel.CREATEORUPDATE) > 0) {
                Object iEntity = iService.getDEModel().createEntity();
                JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
                DataObject.fromJSONObject(iEntity, jo);
                try {
                    iService.save(iEntity);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format("\u4fdd\u5b58\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
                }
            }
        } else {
            Object iEntity = iService.getDEModel().createEntity();
            JSONObject jo = JSONObjectHelper.fromString(dataSyncIn.getLogicData());
            DataObject.fromJSONObject(iEntity, jo);
            try {
                iService.executeAction(iDEDataSyncInc.getImportDEActionName(), (IEntity)iEntity);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format("\u5bfc\u5165\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", dataSyncIn.getDEName(), dataSyncIn.getDataKey(), ex.getMessage()));
            }
        }
    }

    protected IDataSyncEngine createDataSyncEngine(DataSyncAgent dataSyncAgent) throws Exception {
        ActiveMQDataSyncEngine activeMQDataSyncEngine = new ActiveMQDataSyncEngine();
        activeMQDataSyncEngine.init(dataSyncAgent);
        return activeMQDataSyncEngine;
    }
}

