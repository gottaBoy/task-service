/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.list.IList
 */
package net.ibizsys.model.control.list;

import java.util.Iterator;
import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.control.list.IPSListDataItem;
import net.ibizsys.model.control.list.IPSListItem;
import net.ibizsys.paas.control.list.IList;

public interface IPSList
extends IPSMDAjaxControl,
IList {
    public Iterator<IPSListItem> getPSListItems();

    public Iterator<IPSListDataItem> getPSListDataItems();

    public String getEmptyText();

    public IPSListDataItem getPSListDataItem(String var1, boolean var2) throws Exception;
}

