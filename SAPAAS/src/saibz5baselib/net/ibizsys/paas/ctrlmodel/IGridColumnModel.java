/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.web.IWebContext;

public interface IGridColumnModel
extends IGridColumn {
    @Override
    public String getExcelText(IWebContext var1, Object var2) throws Exception;

    @Override
    public String getExcelText(IWebContext var1, Object var2, boolean var3) throws Exception;

    public IGridDataItem getGridDataItem() throws Exception;
}

