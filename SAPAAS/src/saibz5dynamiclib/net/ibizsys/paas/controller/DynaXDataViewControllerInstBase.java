/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IXDataViewController
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.DynaViewControllerInstBase;
import net.ibizsys.paas.controller.IXDataViewController;

public abstract class DynaXDataViewControllerInstBase
extends DynaViewControllerInstBase
implements IXDataViewController {
    private boolean bReadOnly = false;

    public boolean isReadOnly() {
        return this.bReadOnly;
    }

    protected void setReadOnly(boolean bReadOnly) {
        this.bReadOnly = bReadOnly;
    }
}

