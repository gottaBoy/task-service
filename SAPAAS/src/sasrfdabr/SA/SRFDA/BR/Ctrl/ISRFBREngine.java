/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.Data.BREngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public interface ISRFBREngine {
    public CallResult Init(ISRFDAGlobalHelper var1, BREngine var2);

    public CallResult Execute(String var1, String var2, BaseDataEntity var3, String var4);

    public CallResult Manage(String var1, BaseDataEntity var2, String var3);

    public void Quit();
}

