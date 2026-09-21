/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.list.IList;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IListModel
extends ICtrlModel,
IList {
    public void fillFetchResult(MDAjaxActionResult var1, IDataTable var2) throws Exception;

    public int getPageSize();
}

