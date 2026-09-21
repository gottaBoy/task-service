/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.ctrlhandler.ICtrlHandler
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public interface IDynaCtrlHandler
extends ICtrlHandler {
    public void init(IDynaViewModel var1, IPSControl var2) throws Exception;

    public IPSControl getPSControl();
}

