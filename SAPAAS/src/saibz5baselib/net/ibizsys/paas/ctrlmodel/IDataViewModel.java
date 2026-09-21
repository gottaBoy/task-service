/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.dataview.IDataView;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDataViewModel
extends ICtrlModel,
IDataView {
    public int getPageSize();

    public void fillFetchResult(MDAjaxActionResult var1, IDataTable var2) throws Exception;
}

