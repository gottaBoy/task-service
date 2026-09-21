/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevTask;

public interface IPSDevTask {
    public static final int DEVTASKSTATE_NOTFINISH = 0;
    public static final int DEVTASKSTATE_FINISH = 1;

    public int getDevTaskState();

    public String getDevTaskToDo();

    public String getDevTaskLink();
}

