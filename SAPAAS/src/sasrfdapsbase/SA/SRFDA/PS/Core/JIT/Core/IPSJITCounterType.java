/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.JIT.Core;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSJITCounterType
extends IPSCounterType {
    public IPSJITCounterHandler createPSJITConterHandler(IPSSysCounter var1) throws Exception;
}

