/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;

public interface IPSModelDiffPlugin
extends IPSModelPlugin {
    public int diff(IPSModelDiffActionContext var1, Object var2, Object var3) throws Exception;
}

