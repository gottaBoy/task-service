/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

public interface IDynaViewController
extends IViewController {
    public IDynaViewControllerInst getDynaViewControllerInst();

    public boolean isEnableDynaView();

    public IDynaViewControllerInst prepareDynaViewControllerInst() throws Exception;

    public ICtrlHandler getCtrlHandler(String var1, boolean var2) throws Exception;

    public ICtrlModel getCtrlModel(String var1, boolean var2) throws Exception;

    public void resetDynaViewControllerInsts() throws Exception;
}

