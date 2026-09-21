/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.util.StringHelper;

public abstract class CalendarModelBase
extends CtrlModelBase
implements ICalendarModel {
    private HashMap<String, ICalendarItemModel> calendarItemModelMap = new HashMap();
    private ArrayList<ICalendarItemModel> calendarItemModelList = new ArrayList();

    @Override
    public String getControlType() {
        return "CALENDAR";
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPrepareCalendarModel();
    }

    protected void onPrepareCalendarModel() throws Exception {
    }

    protected void registerCalendarItemModel(ICalendarItemModel iCalendarItemTypeModel) throws Exception {
        this.calendarItemModelMap.put(iCalendarItemTypeModel.getId(), iCalendarItemTypeModel);
        if (!StringHelper.isNullOrEmpty(iCalendarItemTypeModel.getItemType())) {
            this.calendarItemModelMap.put(iCalendarItemTypeModel.getItemType(), iCalendarItemTypeModel);
        }
        this.calendarItemModelList.add(iCalendarItemTypeModel);
    }

    @Override
    public ICalendarItemModel getCalendarItemModel(String strCalendarItemModelId) throws Exception {
        ICalendarItemModel iCalendarItemModel = this.calendarItemModelMap.get(strCalendarItemModelId);
        if (iCalendarItemModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65e5\u5386\u9879\u6a21\u578b[%1$s]", strCalendarItemModelId));
        }
        return iCalendarItemModel;
    }

    @Override
    public Iterator<ICalendarItemModel> getCalendarItemModels() {
        return this.calendarItemModelList.iterator();
    }

    @Override
    public boolean isOutputCalendarItem(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItem iCalendarItem) throws Exception {
        return true;
    }

    @Override
    public boolean isOutputCalendarItemModel(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel) throws Exception {
        return true;
    }
}

