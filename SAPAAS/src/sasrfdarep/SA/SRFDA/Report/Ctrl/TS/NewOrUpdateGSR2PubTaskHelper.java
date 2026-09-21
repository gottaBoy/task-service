/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.GSR2Pub
 *  SA.SRFDA.Ctrl.Data.GSR2SumTable
 *  SA.SRFDA.Ctrl.Data.GSR2TD
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTask
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTaskPolicy
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Report.Ctrl.TS;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.GSR2Pub;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFDA.Ctrl.Data.GSR2TD;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Report.Ctrl.TS.BaseGSR2PubTaskHelper;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTaskPolicy;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class NewOrUpdateGSR2PubTaskHelper
extends BaseGSR2PubTaskHelper {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = new CallResult();
        GSR2Pub gsr2Pub = new GSR2Pub();
        gsr2Pub.Proxy(dedcContext.GetDataEntity(""));
        IDEDataCtrl gsr2stDataCtrl = dedcContext.GetDataCtrl("DE0501", false);
        if (gsr2stDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0501"));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        GSR2SumTable gsr2st = new GSR2SumTable();
        gsr2st.setGSR2SUMTABLEID(gsr2Pub.getGSR2SUMTABLEID());
        callResult = gsr2stDataCtrl.Get((BaseDataEntity)gsr2st);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u6c47\u603b\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)gsr2Pub.getGSR2SUMTABLEID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        IDEDataCtrl gsr2tdDataCtrl = dedcContext.GetDataCtrl("DE0502", false);
        if (gsr2tdDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0502"));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        GSR2TD gsr2td = new GSR2TD();
        gsr2td.setGSR2TDID(gsr2st.getTD());
        callResult = gsr2tdDataCtrl.Get((BaseDataEntity)gsr2td);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u65f6\u95f4\u7ef4\u5ea6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)gsr2st.getTD(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)gsr2td.getTSSDPOLICYID())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u5206\u7ec4\u65f6\u95f4\u7ef4\u5ea6[%1$s]\u6307\u5b9a\u53d1\u5e03\u65f6\u95f4\u7b56\u7565", (Object)gsr2st.getTD()));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        TSSDTask tssdTask = new TSSDTask();
        tssdTask.setTSSDTASKID(gsr2Pub.getGSR2PUBID());
        tssdTask.setTSSDTASKNAME(gsr2Pub.getGSR2PUBNAME());
        tssdTask.setTSSDTASKID(gsr2Pub.getGSR2PUBID());
        tssdTask.setTSSDENGINEID("REPORTPUBSCHEDULEENGINE");
        tssdTask.setTSSDTASKTYPEID("UID_2011624914316750018821121");
        tssdTask.SetParamValue("ENABLEFLAG", gsr2Pub.GetParamValue("VALIDFLAG"));
        String strTaskParam = StringHelper.Format((String)"GSR2PUBID=%1$s", (Object)gsr2Pub.getGSR2PUBID());
        tssdTask.setTASKPARAM(strTaskParam);
        IDEDataCtrl tssdTaskDataCtrl = dedcContext.GetDataCtrl("TS0026", false);
        if (tssdTaskDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0026"));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity checkkeyparam = new BaseDataEntity();
        tssdTask.CopyTo(checkkeyparam, true);
        callResult = tssdTaskDataCtrl.CheckKeyState(checkkeyparam);
        if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
            callResult.setRetCode(1);
            return callResult;
        }
        boolean bInsert = false;
        int nState = (Integer)callResult.getUserObject();
        if (nState == 0) {
            bInsert = true;
        } else if (nState == 1) {
            bInsert = false;
        } else {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e[%1$s]\u5df2\u7ecf\u88ab\u5220\u9664", (Object)gsr2Pub.getGSR2PUBID()));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        callResult = tssdTaskDataCtrl.Save(bInsert, (BaseDataEntity)tssdTask);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u4fdd\u5b58GSR2\u53d1\u5e03\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        IDEDataCtrl tssdTaskPolicyDataCtrl = dedcContext.GetDataCtrl("TS0027", false);
        if (tssdTaskPolicyDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0027"));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("TSSDTASKID", (Object)tssdTask.getTSSDTASKID());
        Vector taskPolicyList = new Vector();
        callResult = tssdTaskPolicyDataCtrl.Select(cond, taskPolicyList);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u67e5\u8be2\u5b9a\u65f6\u4efb\u52a1\u7b56\u7565\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (BaseDataEntity taskPolicyItem : taskPolicyList) {
            callResult = tssdTaskPolicyDataCtrl.Remove(taskPolicyItem);
            if (!callResult.IsError()) continue;
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5220\u9664\u5b9a\u65f6\u4efb\u52a1\u7b56\u7565\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        TSSDTaskPolicy taskPolicy = new TSSDTaskPolicy();
        taskPolicy.setTSSDTASKID(tssdTask.getTSSDTASKID());
        taskPolicy.setTSSDPOLICYID(gsr2td.getTSSDPOLICYID());
        callResult = tssdTaskPolicyDataCtrl.Save(true, (BaseDataEntity)taskPolicy);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u4fdd\u5b58\u5b9a\u65f6\u4efb\u52a1\u7b56\u7565\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }
}

