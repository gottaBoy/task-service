/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDCProcess
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCCustomProcess
extends DEDCProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strProcessObject = processConfig.getDEDCProcess().getPROCESSOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strProcessObject)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61");
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strProcessObject));
        IDEDCProcess iDEDCProcess = dedcContext.GetGlobalHelper().getDEDCProcessStorage().FindDEDCProcess(strProcessObject);
        if (iDEDCProcess == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strProcessObject));
            return callResult;
        }
        return iDEDCProcess.Execute(dedcContext, processConfig);
    }
}

