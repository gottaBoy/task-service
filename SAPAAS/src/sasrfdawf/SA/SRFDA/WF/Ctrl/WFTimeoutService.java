/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Ctrl.Data.WFInstance
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Ctrl.Data.WFInstance;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFTimeoutService
extends BaseService {
    private static Log log = LogFactory.getLog(WFTimeoutService.class);
    private Timer checkTimer = null;
    protected String strQuerySQL = "select t1.* from t_SRFWFINSTANCE t1 INNER JOIN T_SRFWFSTEP t2 ON t1.ACTIVESTEPID =  t2.WFSTEPID where (t1.ISCLOSE IS NULL OR t1.ISCLOSE = 0) AND t2.DEADline IS NOT NULL and t2.DEADline<? ORDER BY t2.DEADline DESC";
    protected String strWFWSURL = "";
    int nCheckTimer = 300000;
    protected boolean bRunFlag = false;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.strQuerySQL = this.GetServiceParam("QUERYSQL", this.strQuerySQL);
        this.strWFWSURL = this.GetServiceParam("WFWSURL", "");
        if (StringHelper.IsNullOrEmpty((String)this.strWFWSURL)) {
            this.strWFWSURL = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        }
        this.nCheckTimer = Integer.parseInt(this.GetServiceParam("CHECKTIMER", "300000"));
        if (StringHelper.IsNullOrEmpty((String)this.strQuerySQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u8d85\u65f6\u68c0\u67e5SQL");
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strWFWSURL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41WebService\u8def\u5f84");
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.checkTimer == null) {
            this.checkTimer = new Timer("WFTIMEOUTCHECKER");
            this.checkTimer.schedule((TimerTask)((Object)this), 30000L, (long)this.nCheckTimer);
        }
        log.info((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u8d85\u65f6\u540e\u53f0\u68c0\u67e5\u7a0b\u5e8f\u542f\u52a8\u6210\u529f\uff0c\u68c0\u67e5\u95f4\u9694\u4e3a[%1$s]\u8c6a\u79d2.", (Object)this.nCheckTimer));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u8d85\u65f6\u540e\u53f0\u68c0\u67e5\u7a0b\u5e8f\u5173\u95ed."));
        if (this.checkTimer != null) {
            this.checkTimer.cancel();
            this.checkTimer = null;
        }
        return super.OnStop();
    }

    public void run() {
        if (this.bRunFlag) {
            return;
        }
        try {
            this.bRunFlag = true;
            this.InternalRun();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.bRunFlag = false;
    }

    protected void InternalRun() {
        Vector timeoutWFInstaceList = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.AddDateTime((Object)new Date());
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, (Vector)callParamList.GetList(), timeoutWFInstaceList, (String)WFInstance.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8d85\u65f6\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (timeoutWFInstaceList.size() == 0) {
            return;
        }
        for (WFInstance wfInst : timeoutWFInstaceList) {
            WFClientAPI wfClientAPI = new WFClientAPI();
            callResult = wfClientAPI.Init(this.strWFWSURL, true);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            WFCallResult wfCallResult = wfClientAPI.TimeoutIAAction(wfInst.getWFWORKFLOWID(), "SYSTEM", wfInst.getUSERDATA(), wfInst.getUSERDATA2(), wfInst.getUSERDATA3(), wfInst.getUSERDATA4(), wfInst.getACTIVESTEPNAME(), "SRFWFTIMEOUT", "", "", "");
            if (wfCallResult != null && wfCallResult.getRetCode() == 0) continue;
            log.error((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u4ea4\u4e92\u8d85\u65f6\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
        }
    }
}

