/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.Utility.ISRFExPOLogger
 */
package SA.SRFDA.Web.Utility;

import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;

public interface ISRFDAPOLogger
extends ISRFExPOLogger {
    public void LogDBAction(String var1, String var2, String var3, boolean var4, String var5, int var6);

    public void LogDBQuery(String var1, String var2, String var3, String var4, int var5);

    public void LogDCAction(String var1, String var2, String var3, boolean var4, String var5, int var6);
}

