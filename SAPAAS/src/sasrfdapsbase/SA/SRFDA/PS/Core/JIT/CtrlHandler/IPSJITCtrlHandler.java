/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.ICtrlHandler
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;

public interface IPSJITCtrlHandler
extends ICtrlHandler {
    public void init(IViewController var1, IPSControl var2) throws Exception;

    public IPSControl getPSControl();
}

