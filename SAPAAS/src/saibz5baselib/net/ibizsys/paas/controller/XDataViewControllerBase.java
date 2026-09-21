/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.IXDataViewController;
import net.ibizsys.paas.controller.ViewControllerBase;

public abstract class XDataViewControllerBase
extends ViewControllerBase
implements IXDataViewController {
    private boolean bReadOnly = false;

    @Override
    public boolean isReadOnly() {
        return this.bReadOnly;
    }

    protected void setReadOnly(boolean bReadOnly) {
        this.bReadOnly = bReadOnly;
    }
}

