/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 */
package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;

public interface IPSExpBar
extends IPSAjaxControl {
    public ExpBarRootItem getRootItem();

    public String getTitle();

    public boolean isEnableCounter();
}

