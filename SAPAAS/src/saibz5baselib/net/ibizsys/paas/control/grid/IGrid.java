/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.grid;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;

public interface IGrid
extends IControl {
    public static final String FetchAction = "fetch";

    public Iterator<IGridColumn> getGridColumns();

    public Iterator<IGridDataItem> getGridDataItems();

    public Iterator<IGridEditItem> getGridEditItems();
}

