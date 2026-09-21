/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.ssdyna.controller.DynaEditViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdynawf.controller.DynaWFEditViewControllerInst;

public abstract class DynaWFEditViewControllerBase
extends DynaEditViewControllerBase {
    @Override
    protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
        return new DynaWFEditViewControllerInst();
    }
}

