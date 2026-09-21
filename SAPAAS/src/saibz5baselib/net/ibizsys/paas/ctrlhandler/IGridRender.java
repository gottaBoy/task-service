/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IGridRender
extends IMDCtrlRender {
    public void fillFetchResult(IGridModel var1, MDAjaxActionResult var2, IDataTable var3) throws Exception;
}

