/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 */
package net.ibizsys.ssdyna.view;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public interface IDynaViewInstModel
extends IDynaViewModel,
IDynaViewControllerInst {
    public IDynaViewModel getDynaViewModel();
}

