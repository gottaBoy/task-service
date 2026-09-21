/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.IGanttModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IGanttRender
extends IMDCtrlRender {
    public String getItemType(IWebContext var1) throws Exception;

    public String getItemId(IWebContext var1) throws Exception;

    public void fillFetchResult(IGanttModel var1, MDAjaxActionResult var2, ArrayList<IGanttItem> var3) throws Exception;

    public void fillItemResult(IGanttModel var1, MDAjaxActionResult var2, IGanttItem var3) throws Exception;
}

