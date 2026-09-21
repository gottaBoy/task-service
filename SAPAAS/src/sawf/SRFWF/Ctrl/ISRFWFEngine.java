/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  javax.servlet.ServletContext
 */
package SRFWF.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SRFWF.Client.WFParam;
import javax.servlet.ServletContext;

public interface ISRFWFEngine {
    public CallResult Init(ServletContext var1, BaseDBCallerHelperEx var2, String var3);

    public CallResult StartNew(WFParam var1);

    public CallResult SubmitIAAction(boolean var1, WFParam var2);

    public CallResult UserClose(WFParam var1);

    public CallResult Restart(WFParam var1);
}

