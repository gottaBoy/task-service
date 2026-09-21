/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGrid
 */
package net.ibizsys.model.control.grid;

import java.util.Iterator;
import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.grid.IGrid;

public interface IPSDEGrid
extends IPSMDAjaxControl,
IGrid {
    public static final String GRIDSTYLE_TREEGRID = "TREEGRID";
    public static final String GRIDSTYLE_GROUPGRID = "GROUPGRID";
    public static final String GRIDSTYLE_LIST = "LIST";
    public static final String GRIDSTYLE_LIST_SORT = "LIST_SORT";
    public static final String SORTMODE_REMOTE = "REMOTE";
    public static final String SORTMODE_LOCAL = "LOCAL";

    public Iterator<IPSDEGridColumn> getPSDEGridColumns();

    public Iterator<IPSDEGridColumn> getAllPSDEGridColumns();

    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    public Iterator<IPSDEGridEditItem> getPSDEGridEditItems();

    public boolean isEnablePagingBar();

    public boolean isEnableRowEdit();

    public int getPagingSize();

    public boolean isSingleSelect();

    public boolean isForceFit();

    public String getGridStyle();

    public boolean isNoSort();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isHideHeader();

    public boolean isStateful();

    public Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates();

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String var1) throws Exception;

    public Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems();

    public String getEmptyText();

    public String getSortMode();
}

