/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.JIT.Core;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSJITCounter
extends IPSCounter {
    public IPSJITCounterHandler createPSJITConterHandler(boolean var1) throws Exception;
}

