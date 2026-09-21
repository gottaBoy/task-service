/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;

public interface IPSDEContextMenuItem
extends IPSDEToolbarItem {
    public IPSDEContextMenu getPSDEContextMenu();

    public IPSDEContextMenuItem getParentPSDEContextMenuItem();
}

