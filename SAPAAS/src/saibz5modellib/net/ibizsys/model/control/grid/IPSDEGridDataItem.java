/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridDataItem
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.paas.control.grid.IGridDataItem;

public interface IPSDEGridDataItem
extends IPSDataItem,
IGridDataItem {
    public IPSDEGrid getPSDEGrid();

    public IPSDEGridColumn getPSDEGridColumn();
}

