/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import net.ibizsys.paas.core.DefaultDEDataChangeDispatchParam;
import net.ibizsys.paas.core.IDEDataChangeDispatcher;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;
import net.ibizsys.psrt.srv.common.entity.DEDataChg2;
import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;
import net.ibizsys.psrt.srv.common.service.DEDataChg2Service;
import net.ibizsys.psrt.srv.common.service.DEDataChgDispService;
import net.ibizsys.psrt.srv.common.service.DEDataChgService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataChangeDispatchBackendService
extends BackendServiceBase {
    private static Log log = LogFactory.getLog(DEDataChangeDispatchBackendService.class);
    public static final String PARAM_POLLTIMER = "POLLTIMER";
    public static final String PARAM_QUERYSQL = "QUERYSQL";
    private int nPollTimer = 15000;
    private Timer pollTimer = null;
    protected ArrayList<IDEDataChangeDispatcher> dataChangeDispatcherList = new ArrayList();
    private DEDataChgDispService deDataChgDispService = null;
    private DEDataChgService deDataChgService = null;
    private DEDataChg2Service deDataChg2Service = null;

    @Override
    protected void onInit() throws Exception {
        this.deDataChgDispService = (DEDataChgDispService)ServiceGlobal.getService(DEDataChgDispService.class);
        this.deDataChgService = (DEDataChgService)ServiceGlobal.getService(DEDataChgService.class);
        this.deDataChg2Service = (DEDataChg2Service)ServiceGlobal.getService(DEDataChg2Service.class);
        super.onInit();
    }

    @Override
    protected void onStart() throws Exception {
        this.nPollTimer = Integer.parseInt(this.getServiceParam(PARAM_POLLTIMER, "15000"));
        SelectCond selectCond = new SelectCond();
        selectCond.set("VALIDFLAG", 1);
        ArrayList deDataChgDispList = this.deDataChgDispService.select(selectCond);
        for (DEDataChgDisp deDataChgDisp : deDataChgDispList) {
            Object objDEDataChgDisp = ObjectHelper.create(deDataChgDisp.getEngineObject());
            if (objDEDataChgDisp == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u5bf9\u8c61[%1$s]", deDataChgDisp.getEngineObject()));
            }
            IDEDataChangeDispatcher iDEDataChangeDispatcher = null;
            if (!(objDEDataChgDisp instanceof IDEDataChangeDispatcher)) {
                throw new Exception(StringHelper.format("\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", deDataChgDisp.getEngineObject()));
            }
            iDEDataChangeDispatcher = (IDEDataChangeDispatcher)objDEDataChgDisp;
            iDEDataChangeDispatcher.init(deDataChgDisp);
            this.dataChangeDispatcherList.add(iDEDataChangeDispatcher);
        }
        if (this.pollTimer == null) {
            this.pollTimer = new Timer("DEDATACHANGEDISPATCH");
            this.pollTimer.schedule(new TimerTask(){

                @Override
                public void run() {
                    DEDataChangeDispatchBackendService.this.runTask();
                }
            }, this.nPollTimer, (long)this.nPollTimer);
        }
        log.info((Object)StringHelper.format("DEDataChangeDispatchService Start"));
        super.onStart();
    }

    @Override
    protected void onStop() throws Exception {
        log.info((Object)StringHelper.format("DEDataChangeDispatchService Stop"));
        if (this.pollTimer != null) {
            this.pollTimer.cancel();
            this.pollTimer = null;
        }
        this.dataChangeDispatcherList.clear();
        super.onStop();
    }

    @Override
    protected void onRun() throws Exception {
        super.onRun();
        SelectCond selectCond = new SelectCond();
        selectCond.setOrderInfo("ORDER BY CREATEDATE");
        selectCond.setMaxRowCount(500);
        ArrayList deDataChgList = this.deDataChgService.select(selectCond);
        for (DEDataChg deDataChg : deDataChgList) {
            String strDispError = "";
            DEDataChg2 deDataChg2 = new DEDataChg2();
            deDataChg.copyTo(deDataChg2, false);
            deDataChg2.setDEDataChg2Id(deDataChg.getDEDataChgId());
            deDataChg2.setDEDataChg2Name(deDataChg.getDEDataChgName());
            try {
                DefaultDEDataChangeDispatchParam dataChangeDispatchParam = new DefaultDEDataChangeDispatchParam(DEModelGlobal.getDEModel(deDataChg.getDEName()), deDataChg);
                deDataChg.getEventType().intValue();
                for (IDEDataChangeDispatcher iDEDataChangeDispatcher : this.dataChangeDispatcherList) {
                    try {
                        iDEDataChangeDispatcher.dispatch(dataChangeDispatchParam);
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.format("\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u3010%1$s\u3011\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDEDataChangeDispatcher.getName(), ex.getMessage()), (Throwable)ex);
                        if (!StringHelper.isNullOrEmpty(strDispError)) {
                            strDispError = String.valueOf(strDispError) + "\r\n";
                        }
                        strDispError = String.valueOf(strDispError) + StringHelper.format("\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u3010%1$s\u3011\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iDEDataChangeDispatcher.getName(), ex.getMessage());
                    }
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
                deDataChg2.setError(StringHelper.format("\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
            if (!StringHelper.isNullOrEmpty(strDispError)) {
                deDataChg2.setDISPError(strDispError);
            }
            try {
                this.deDataChgService.remove(deDataChg);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u79fb\u9664\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u53d1\u751f\u9519\u8bef\uff0c%1$", ex.getMessage()));
                continue;
            }
            try {
                this.deDataChg2Service.create(deDataChg2, false);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u4fdd\u5b58\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u53d1\u751f\u9519\u8bef\uff0c%1$", ex.getMessage()));
            }
        }
    }
}

