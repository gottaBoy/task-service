/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDataViewModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public abstract class DataViewModelBase
extends CtrlModelBase
implements IDataViewModel {
    protected ArrayList<IDataViewDataItem> dataViewDataItemList = new ArrayList();
    private int nPageSize = -1;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareDataViewDataItems();
    }

    protected void prepareDataViewDataItems() throws Exception {
    }

    protected IDataViewDataItem createDataViewDataItem(String strDataItemName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IDataViewDataItem> getDataViewDataItems() {
        return this.dataViewDataItemList.iterator();
    }

    protected void registerDataViewDataItem(IDataViewDataItem iDataViewDataItem) {
        this.dataViewDataItemList.add(iDataViewDataItem);
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                JSONObject jo = new JSONObject();
                for (IDataViewDataItem iDataViewDataItem : this.dataViewDataItemList) {
                    Object objValue = this.getDataViewDataItemValue(iDataViewDataItem, iDataRow);
                    JSONObjectHelper.put(jo, iDataViewDataItem.getName(), objValue);
                }
                fetchResult.getRows().add(jo);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                JSONObject jo = new JSONObject();
                for (IDataViewDataItem iDataViewDataItem : this.dataViewDataItemList) {
                    Object objValue = this.getDataViewDataItemValue(iDataViewDataItem, iDataRow);
                    JSONObjectHelper.put(jo, iDataViewDataItem.getName(), objValue);
                }
                fetchResult.getRows().add(jo);
                ++i;
            }
        }
    }

    protected Object getDataViewDataItemValue(IDataViewDataItem iDataViewDataItem, IDataRow iDataRow) throws Exception {
        return iDataViewDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
    }

    @Override
    public String getControlType() {
        return "DATAVIEW";
    }

    @Override
    public int getPageSize() {
        return this.nPageSize;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }
}

