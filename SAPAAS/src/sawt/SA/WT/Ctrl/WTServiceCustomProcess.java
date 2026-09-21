/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDCProcess
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public abstract class WTServiceCustomProcess
implements IDEDCProcess {
    public abstract CallResult Execute(IDEDataCtrlEngineContext var1, DEDCBaseProcessConfig var2);

    public CallResult GenCode(StringBuilderEx arg0, IDACodeEngineContext arg1, DEDCBaseProcessConfig arg2) {
        return null;
    }

    public boolean isSupportGenCode() {
        return false;
    }
}

