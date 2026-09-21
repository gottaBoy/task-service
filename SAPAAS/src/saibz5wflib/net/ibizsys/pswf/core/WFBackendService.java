/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.BackendServiceBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.entity.WFUCPolicy
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  net.ibizsys.psrt.srv.wf.service.WFUCPolicyService
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFModelGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFBackendService
extends BackendServiceBase {
    private static Log log = LogFactory.getLog(WFBackendService.class);
    private Timer checkTimer = null;
    protected String strQuerySQL = "select t1.* from t_SRFWFINSTANCE t1 INNER JOIN T_SRFWFSTEP t2 ON t1.ACTIVESTEPID =  t2.WFSTEPID where (t1.ISCLOSE IS NULL OR t1.ISCLOSE = 0) AND t2.DEADline IS NOT NULL and t2.DEADline<? ORDER BY t2.DEADline DESC";
    protected String strQuerySQLLowCase = "select t1.activestepid,t1.activestepname,t1.cancelreason,t1.createdate,t1.createman,t1.enable,t1.endtime,t1.errorinfo,t1.importanceflag,t1.iscancel,t1.isclose,t1.iserror,t1.isfinish,t1.lastaction,t1.lastactorid,t1.lastwfstepid,t1.memo,t1.orgid,t1.orgname,t1.owner,t1.parallelinst,t1.pstepid,t1.pwfinstanceid,t1.result,t1.starttime,t1.suspendflag,t1.tracestep,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.userdata3,t1.userdata4,t1.userdatainfo,t1.usertag,t1.usertag2,t1.wfinstanceid,t1.wfinstancename,t1.wfmodel,t1.wfversion,t1.wfworkflowid from t_srfwfinstance t1 inner join t_srfwfstep t2 on t1.activestepid =  t2.wfstepid where (t1.isclose is null or t1.isclose = 0) and t2.deadline is not null and t2.deadline<? order by t2.deadline desc";
    protected String strQuerySQL2 = "select t1.* from t_srfwfucpolicy t1 where (t1.policystate=1 and t1.begintime <= ? ) or (t1.policystate=2 and t1.ENDTIME is not null and t1.ENDTIME < ?)";
    protected String strQuerySQL2LowCase = "select t1.begintime,t1.createdate,t1.createman,t1.endtime,t1.majorwfuserid,t1.memo,t1.minorwfuserid,t1.policystate,t1.updatedate,t1.updateman,t1.userdata,t1.userdata2,t1.validflag,t1.wfucpolicyid,t1.wfucpolicyname from t_srfwfucpolicy t1 where (t1.policystate=1 and t1.begintime <= ? ) or (t1.policystate=2 and t1.endtime is not null and t1.endtime < ?)";
    int nCheckTimer = 30000;
    private WFStepService wfStepService = null;
    private WFUCPolicyService wfUCPolicyService = null;
    private boolean bChecking = false;

    protected void onInit() throws Exception {
        super.onInit();
        int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
        if (WebConfig.getCurrent().isLowCaseSql()) {
            this.strQuerySQL = this.getServiceParam("QUERYSQL", this.strQuerySQLLowCase);
            this.strQuerySQL2 = this.getServiceParam("QUERYSQL2", this.strQuerySQL2LowCase);
        } else {
            this.strQuerySQL = this.getServiceParam("QUERYSQL", this.strQuerySQL);
            this.strQuerySQL2 = this.getServiceParam("QUERYSQL2", this.strQuerySQL2);
        }
        this.nCheckTimer = Integer.parseInt(this.getServiceParam("CHECKTIMER", "30000"));
        this.wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class);
        this.wfUCPolicyService = (WFUCPolicyService)ServiceGlobal.getService(WFUCPolicyService.class);
        this.strQuerySQL = this.wfStepService.getDAO().getRealDBDialect().getPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.isNullOrEmpty((String)this.strQuerySQL)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u8d85\u65f6\u68c0\u67e5SQL");
        }
        this.strQuerySQL2 = this.wfUCPolicyService.getDAO().getRealDBDialect().getPagingSQL(this.strQuerySQL2, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.isNullOrEmpty((String)this.strQuerySQL)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u5de5\u4f5c\u59d4\u6d3e\u7b56\u7565\u68c0\u67e5SQL");
        }
    }

    protected void onStart() throws Exception {
        super.onStart();
        if (this.checkTimer == null) {
            this.checkTimer = new Timer("WFBACKSERVICE");
            this.checkTimer.schedule(new TimerTask(){

                @Override
                public void run() {
                    WFBackendService.this.runTask();
                }
            }, this.nCheckTimer, (long)this.nCheckTimer);
        }
        log.info((Object)StringHelper.format((String)"WF Service Start"));
    }

    protected void onStop() throws Exception {
        log.info((Object)StringHelper.format((String)"WF Service Stop"));
        if (this.checkTimer != null) {
            this.checkTimer.cancel();
            this.checkTimer = null;
        }
        super.onStop();
    }

    protected void onRun() throws Exception {
        try {
            this.internalRun();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u8d85\u65f6\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        try {
            this.internalRun2();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u59d4\u6d3e\u5904\u7406\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }

    protected void internalRun() throws Exception {
        SqlParamList sqlParamList = new SqlParamList();
        Date date = new Date();
        Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
        sqlParamList.addDateTime((Object)sendTime);
        ArrayList timeoutWFInstanceList = this.wfStepService.selectRaw(this.strQuerySQL, sqlParamList);
        if (timeoutWFInstanceList.size() == 0) {
            return;
        }
        for (IEntity wfInst : timeoutWFInstanceList) {
            WFInstance wfInstance = new WFInstance();
            wfInst.copyTo((IDataObject)wfInstance, false);
            IWFService iWFService = WFModelGlobal.getWFModel((String)wfInstance.getWFWorkflowId()).getWFService();
            WFActionParam wfActionParam = new WFActionParam();
            wfActionParam.setUserData(wfInstance.getUserData());
            wfActionParam.setUserData4(wfInstance.getUserData4());
            wfActionParam.setOpPersonId("SYSTEM");
            wfActionParam.setStepId(wfInstance.getActiveStepName());
            wfActionParam.setConnection("SRFWFTIMEOUT");
            try {
                iWFService.timeoutIAAction(wfActionParam);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u4ea4\u4e92\u8d85\u65f6\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
            }
        }
    }

    protected void internalRun2() throws Exception {
        SqlParamList sqlParamList = new SqlParamList();
        Date date = new Date();
        Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
        sqlParamList.addDateTime((Object)sendTime);
        sqlParamList.addDateTime((Object)sendTime);
        ArrayList wfUCPolicyList = this.wfUCPolicyService.selectRaw(this.strQuerySQL2, sqlParamList);
        if (wfUCPolicyList.size() == 0) {
            return;
        }
        for (IEntity iEntity : wfUCPolicyList) {
            WFUCPolicy wfUCPolicy = new WFUCPolicy();
            iEntity.copyTo((IDataObject)wfUCPolicy, false);
            try {
                WFUCPolicy wfUCPolicy2;
                if (wfUCPolicy.getPolicyState() == WFUCPolicyStateCodeListModel.NOTAPPLIED) {
                    wfUCPolicy2 = new WFUCPolicy();
                    wfUCPolicy2.setWFUCPolicyId(wfUCPolicy.getWFUCPolicyId());
                    wfUCPolicy2.setPolicyState(WFUCPolicyStateCodeListModel.APPLIED);
                    this.wfUCPolicyService.update((IEntity)wfUCPolicy2);
                    continue;
                }
                if (wfUCPolicy.getPolicyState() != WFUCPolicyStateCodeListModel.APPLIED) continue;
                wfUCPolicy2 = new WFUCPolicy();
                wfUCPolicy2.setWFUCPolicyId(wfUCPolicy.getWFUCPolicyId());
                wfUCPolicy2.setPolicyState(WFUCPolicyStateCodeListModel.EXPIRED);
                this.wfUCPolicyService.update((IEntity)wfUCPolicy2);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u59d4\u6d3e\u7b56\u7565\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
            }
        }
    }
}

