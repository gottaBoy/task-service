/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewController
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.pswf.controller.IDynaWFViewControllerInst;

public interface IDynaWFViewController
extends IDynaViewController {
    public IDynaWFViewControllerInst getDynaWFViewControllerInst();

    public String getViewWFId();
}

