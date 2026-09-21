/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskSessionContext;
import SA.SRFDA.PS.Core.IPSObject;

public interface IPSBKTask
extends IPSObject {
    public IPSBKTask getParentPSBKTask();

    public boolean run(IPSBKTaskSessionContext var1);

    public void cancel(boolean var1, String var2);

    public String getTaskType();

    public String getTaskParam();

    public String getTaskParam2();

    public String getTaskParam3();

    public String getTaskParam4();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public void setQueueInfo(int var1, int var2);

    public String getQueueInfo();

    public String getCreateMan();

    public int getTaskLevel();
}

