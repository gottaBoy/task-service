/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.ICounterHandler
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;

public interface IPSJITCounterHandler
extends ICounterHandler {
    public void init(IPSJITSystemModel var1, IPSSysCounter var2) throws Exception;
}

