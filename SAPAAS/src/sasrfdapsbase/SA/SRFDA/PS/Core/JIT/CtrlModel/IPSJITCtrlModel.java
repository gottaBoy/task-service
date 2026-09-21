/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

public interface IPSJITCtrlModel
extends ICtrlModel {
    public void init(IViewController var1, IPSControl var2) throws Exception;

    public IPSControl getPSControl();
}

