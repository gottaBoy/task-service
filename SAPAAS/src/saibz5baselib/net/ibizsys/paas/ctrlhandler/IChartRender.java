/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IChartRender
extends IMDCtrlRender {
    public void fillFetchResult(IChartModel var1, MDAjaxActionResult var2, IDataTable var3) throws Exception;
}

