/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;

public interface ICalendarModel
extends ICtrlModel {
    public static final String ITEM_SEPARATOR = ";";

    public ICalendarItemModel getCalendarItemModel(String var1) throws Exception;

    public Iterator<ICalendarItemModel> getCalendarItemModels();

    public boolean isOutputCalendarItem(ICalendarItemFetchContext var1, ICalendarItem var2) throws Exception;

    public boolean isOutputCalendarItemModel(ICalendarItemFetchContext var1, ICalendarItemModel var2) throws Exception;
}

