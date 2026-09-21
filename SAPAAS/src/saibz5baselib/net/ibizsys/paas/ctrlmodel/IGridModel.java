/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public interface IGridModel
extends ICtrlModel,
IGrid {
    public void fillFetchResult(MDAjaxActionResult var1, IDataTable var2) throws Exception;

    public IGridDataItem getGridDataItem(String var1) throws Exception;

    public IGridEditItem getGridEditItem(String var1, boolean var2) throws Exception;

    public boolean convertEntityFieldError(EntityFieldError var1) throws Exception;

    public void fillRowOutputDatas(IDataObject var1, boolean var2, JSONObject var3, JSONObject var4, JSONObject var5) throws Exception;

    public void fillRowInputValues(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public Object getGridEditItemInputValue(String var1, IWebContext var2) throws Exception;

    public void fillRowDefaultValues(IDataObject var1, boolean var2) throws Exception;

    public void testRowValueRule(IService var1, IDataObject var2, boolean var3) throws Exception;

    public String getColumnExcelText(IGridColumn var1, IWebContext var2, Object var3, boolean var4) throws Exception;
}

