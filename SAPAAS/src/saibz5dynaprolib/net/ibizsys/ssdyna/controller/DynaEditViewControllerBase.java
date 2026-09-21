/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.ssdyna.controller;

import net.ibizsys.ssdyna.controller.DynaEditViewControllerInst;
import net.ibizsys.ssdyna.controller.DynaViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;

public abstract class DynaEditViewControllerBase
extends DynaViewControllerBase {
    @Override
    protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
        return new DynaEditViewControllerInst();
    }
}

