/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;

public interface ICalendarItemModel
extends IModelBase {
    public ICalendarModel getCalendarModel();

    public String getDEName();

    public void fillFetchResult(ICalendarItemFetchContext var1, ArrayList<ICalendarItem> var2, IDataTable var3) throws Exception;

    public String getIconCls();

    public String getIconPath();

    public String getItemType();

    public ICalendarItemDataItem getCalendarItemDataItem(String var1) throws Exception;

    public Iterator<ICalendarItemDataItem> getCalendarItemDataItems();

    public String getDEDataSetName();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getCreateDEActionName();

    public String getCreateDataAccessAction();

    public String getUpdateDEActionName();

    public String getUpdateDataAccessAction();

    public String getRemoveDEActionName();

    public String getRemoveDataAccessAction();

    public String getActiveDataDELogicId();

    public String getTipsField();

    public String getContentField();

    public String getBeginTimeField();

    public String getEndTimeField();

    public String getColorField();

    public String getBKColorField();

    public int getMaxSize();

    public String getColor();

    public String getBKColor();

    public String getLevelField();

    public void fillInputValues(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public ICalendarItem getCalendarItem(IDataObject var1, boolean var2) throws Exception;
}

