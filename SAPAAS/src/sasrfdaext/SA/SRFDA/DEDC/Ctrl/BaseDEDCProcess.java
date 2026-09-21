/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.IDEDCProcess
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public abstract class BaseDEDCProcess
implements IDEDCProcess {
    public CallResult GenCode(StringBuilderEx sb, IDACodeEngineContext iDACodeEngineContext, DEDCBaseProcessConfig processConfig) {
        return CallResult.Create((int)20);
    }

    public boolean isSupportGenCode() {
        return false;
    }
}

