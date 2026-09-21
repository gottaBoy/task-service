/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSActionContext;
import SA.SRFDA.PS.Core.IPSModelObject;
import java.util.HashMap;

public interface IPSPublisherContext
extends IPSActionContext {
    public boolean isEnableVC();

    public boolean isRebuildMode();

    public HashMap<String, Object> getPubParams();

    public int getRebuildModeEx();

    public void log(int var1, IPSModelObject var2, String var3, String var4);

    public void log(int var1, IPSModelObject var2, String var3, String var4, String var5);

    public void log(int var1, IPSModelObject var2, String var3);
}

