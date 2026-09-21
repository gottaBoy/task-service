/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.Data.BRInstance;
import SA.SRFDA.BR.Ctrl.ISRFBREngineContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public interface ISRFBRInstance {
    public CallResult Init(ISRFBREngineContext var1, BRInstance var2);

    public BRInstance getBRInstance();

    public void ResetParam(String var1, double var2);

    public BaseDataEntity GetInstParam();

    public void UpdateInstParam(BaseDataEntity var1);

    public void Quit();
}

