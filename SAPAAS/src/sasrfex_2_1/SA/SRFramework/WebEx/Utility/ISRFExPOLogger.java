/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;

public interface ISRFExPOLogger {
    public void setGlobalHelper(ISRFExGlobalHelper var1);

    public void Start();

    public void Stop();

    public void LogPageAction(SRFExPage var1, int var2);

    public void LogWFAction(String var1, String var2, String var3, int var4);
}

