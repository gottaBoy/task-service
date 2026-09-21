/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEDCSetRetInfoProcess
extends DEDCProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        int nRetCode = 1;
        if (!StringHelper.IsNullOrEmpty((String)processConfig.getDEDCProcess().getERRORCODE())) {
            nRetCode = Integer.parseInt(processConfig.getDEDCProcess().getERRORCODE());
        }
        if (!processConfig.getDEDCProcess().IsParamNull("PARAM7")) {
            nRetCode = processConfig.getDEDCProcess().getPARAM7();
        }
        callResult.setRetCode(nRetCode);
        callResult.setErrorInfo(processConfig.getDEDCProcess().getERRORINFO());
        return callResult;
    }
}

