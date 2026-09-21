/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.list;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.list.IListDataItem;

public interface IList
extends IControl {
    public Iterator<IListDataItem> getListDataItems();
}

