/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  javax.servlet.ServletContext
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Client.KPIParam;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import javax.servlet.ServletContext;

public interface ISRFKPIEngine {
    public CallResult Init(ServletContext var1, BaseDBCallerHelperEx var2, String var3);

    public CallResult StartNew(KPIParam var1);
}

