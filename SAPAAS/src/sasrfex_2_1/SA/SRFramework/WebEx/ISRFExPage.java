/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.DataEx.CallResult;

public interface ISRFExPage {
    public boolean IsBackEndMode();

    public void PageLog(Object var1, int var2, String var3);

    public void PageLog(Object var1, String var2, CallResult var3);

    public void PageLog(Object var1, int var2, String var3, Throwable var4);
}

