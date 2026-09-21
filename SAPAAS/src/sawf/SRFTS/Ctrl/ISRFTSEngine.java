/*
 * Decompiled with CFR 0.152.
 */
package SRFTS.Ctrl;

public interface ISRFTSEngine {
    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);

    public boolean AddRunningTask(String var1);

    public void RemoveRunningTask(String var1);
}

