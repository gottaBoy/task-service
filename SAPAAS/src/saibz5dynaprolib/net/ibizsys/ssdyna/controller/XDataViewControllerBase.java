/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IXDataViewController
 */
package net.ibizsys.ssdyna.controller;

import net.ibizsys.paas.controller.IXDataViewController;
import net.ibizsys.ssdyna.controller.ViewControllerBase;

public abstract class XDataViewControllerBase
extends ViewControllerBase
implements IXDataViewController {
    private boolean bReadOnly = false;

    public boolean isReadOnly() {
        return this.bReadOnly;
    }

    protected void setReadOnly(boolean bReadOnly) {
        this.bReadOnly = bReadOnly;
    }
}

