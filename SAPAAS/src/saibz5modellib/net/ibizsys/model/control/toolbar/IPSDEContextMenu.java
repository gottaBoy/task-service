/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.toolbar;

import java.util.Iterator;
import net.ibizsys.model.control.toolbar.IPSDEContextMenuItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;

public interface IPSDEContextMenu
extends IPSDEToolbar {
    @Deprecated
    public Iterator<IPSDEContextMenuItem> getPSContextMenuItems() throws Exception;

    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception;
}

