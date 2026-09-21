/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.ssdyna.controller.DynaViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;
import net.ibizsys.ssdynawf.controller.DynaWFDataRedirectViewControllerInst;

public abstract class DynaWFDataRedirectViewControllerBase
extends DynaViewControllerBase {
    @Override
    protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
        return new DynaWFDataRedirectViewControllerInst();
    }
}

