/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public interface IDEDCProcess {
    public CallResult Execute(IDEDataCtrlEngineContext var1, DEDCBaseProcessConfig var2);

    public boolean isSupportGenCode();

    public CallResult GenCode(StringBuilderEx var1, IDACodeEngineContext var2, DEDCBaseProcessConfig var3);
}

