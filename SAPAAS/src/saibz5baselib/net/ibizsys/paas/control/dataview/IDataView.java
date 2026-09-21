/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.dataview;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;

public interface IDataView
extends IControl {
    public static final String FetchAction = "fetch";

    public Iterator<IDataViewDataItem> getDataViewDataItems();
}

