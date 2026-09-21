/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

public interface IPSDEGridUAColumn
extends IPSDEGridColumn {
    public IPSDEUIActionGroup getPSDEUIActionGroup();
}

