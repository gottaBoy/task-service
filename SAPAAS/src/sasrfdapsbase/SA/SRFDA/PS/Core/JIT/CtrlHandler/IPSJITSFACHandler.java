/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;

public interface IPSJITSFACHandler
extends IPSSFACHandler {
    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl var1, boolean var2) throws Exception;
}

