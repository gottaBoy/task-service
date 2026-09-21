/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevStudio;

public interface IPSBKTaskSessionContext {
    public void executeTask(Runnable var1);

    public int getTaskThreadCount();

    public String getQueueInfo();

    public boolean getLastRunFlag();
}

