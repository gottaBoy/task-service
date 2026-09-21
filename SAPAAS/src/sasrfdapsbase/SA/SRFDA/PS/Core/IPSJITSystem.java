/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSJITSystem
extends IPSSystem {
    public IPSApplication getPSJITApplication(String var1) throws Exception;

    public void resetPSJITApplication(String var1);
}

