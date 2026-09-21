/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.IS.Ctrl.Data.ISEraseItem;
import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFramework.DataEx.CallResult;
import java.util.TreeMap;

public interface ISRFISEraseItemHelper {
    public CallResult Erase(ISRFISIndexContext var1, ISEraseItem var2, TreeMap<String, String> var3);

    public CallResult FinishErase(ISRFISIndexContext var1, ISEraseItem var2, TreeMap<String, String> var3);
}

