/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDASystemAdmin {
    public void Init(ISRFDAGlobalHelper var1);

    public boolean isContainsFunc(String var1);

    public boolean isFuncScript(String var1);

    public CallResult GetFuncScript(String var1);

    public CallResult CallFunc(String var1, String var2);
}

