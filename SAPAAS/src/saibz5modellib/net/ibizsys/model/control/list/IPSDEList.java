/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.list;

import java.util.Iterator;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.control.list.IPSList;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;

public interface IPSDEList
extends IPSList {
    public static final String MOBLISTSTYLE_ICONVIEW = "ICONVIEW";
    public static final String MOBLISTSTYLE_LISTVIEW = "LISTVIEW";
    public static final String MOBLISTSTYLE_SWIPERVIEW = "SWIPERVIEW";

    public IPSDEDataSet getPSDEDataSet();

    public IPSDELogic getActiveDataPSDELogic();

    public Iterator<IPSDEListItem> getPSDEListItems();

    public boolean isShowHeader();

    public boolean isForceFit();

    public int getPagingSize();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isNoSort();

    public boolean isAppendDEItems();

    public String getMobListStyle();
}

