/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;

public interface IDynaCtrlHandler
extends ICtrlHandler {
    public void init(IDynaViewControllerInst var1, IDynaCtrlModel var2) throws Exception;

    public IDynaCtrlModel getDynaCtrlModel();
}

