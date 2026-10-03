/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.GSR2Pub
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTask
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Report.Ctrl.TS;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.GSR2Pub;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Report.Ctrl.TS.BaseGSR2PubTaskHelper;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class RemoveGSR2PubTaskHelper
extends BaseGSR2PubTaskHelper {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = new CallResult();
        GSR2Pub gsr2Pub = new GSR2Pub();
        gsr2Pub.Proxy(dedcContext.GetDataEntity(""));
        TSSDTask tssdTask = new TSSDTask();
        tssdTask.setTSSDTASKID(gsr2Pub.getGSR2PUBID());
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
            return callResult;
        }
        if (nState != 1) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e[%1$s]\u5df2\u7ecf\u88ab\u5220\u9664", (Object)gsr2Pub.getGSR2PUBID()));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        bInsert = false;
        IDEDataCtrl tssdTaskPolicyDataCtrl = dedcContext.GetDataCtrl("TS0027", false);
        if (tssdTaskPolicyDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"TS0027"));
            dedcContext.DebugOutput((Object)this, callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("TSSDTASKID", (Object)tssdTask.getTSSDTASKID());
        Vector<BaseDataEntity> taskPolicyList = new Vector<BaseDataEntity>();
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
        callResult = tssdTaskDataCtrl.Remove((BaseDataEntity)tssdTask);
        if (callResult.IsError()) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5220\u9664\u5b9a\u65f6\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }
}

