/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dataview.IDataView
 */
package net.ibizsys.model.control.dataview;

import java.util.Iterator;
import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.control.dataview.IPSDEDataViewDataItem;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.dataview.IDataView;

public interface IPSDEDataView
extends IPSMDAjaxControl,
IDataView {
    public Iterator<IPSDEDataViewDataItem> getPSDEDataViewDataItems();

    public boolean isEnablePagingBar();

    public int getPagingSize();

    public boolean isSingleSelect();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public boolean isNoSort();

    public boolean isAppendDEItems();

    public IPSDEDataSet getPSDEDataSet();

    public String getEmptyText();
}

