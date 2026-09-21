/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridColumn
 */
package net.ibizsys.model.control.grid;

import java.util.Iterator;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.paas.control.grid.IGridColumn;

public interface IPSDEGridColumn
extends IPSModelObject,
IGridColumn {
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public IPSDEGrid getPSDEGrid();

    public String getCodeName();

    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    public String getWidthUnit();

    public int getWidth();

    public String getColumnType();

    public boolean isEnableSort();

    public String getWidthString();

    public boolean isHiddenDataItem();

    public String getAlign();

    public boolean isHideDefault();

    public boolean isEnableRowEdit();

    public IPSDEGridEditItem getPSDEGridEditItem();

    public IPSDEGridColumn getParentPSGridColumn();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public String getColumnStyle();

    public String getUserTag();

    public String getUserTag2();

    public IPSSysCss getHeaderPSSysCss();

    public IPSSysCss getCellPSSysCss();
}

