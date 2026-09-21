/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface ICalendarRender
extends IMDCtrlRender {
    public String getItemType(IWebContext var1) throws Exception;

    public String getItemId(IWebContext var1) throws Exception;

    public void fillFetchResult(ICalendarModel var1, MDAjaxActionResult var2, ArrayList<ICalendarItem> var3) throws Exception;

    public void fillItemResult(ICalendarModel var1, MDAjaxActionResult var2, ICalendarItem var3) throws Exception;
}

