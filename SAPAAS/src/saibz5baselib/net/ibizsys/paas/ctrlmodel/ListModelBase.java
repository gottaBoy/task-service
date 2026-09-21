/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.list.IListDataItem;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IListModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

public abstract class ListModelBase
extends CtrlModelBase
implements IListModel {
    private ArrayList<IListDataItem> listDataItemList = new ArrayList();
    private int nPageSize = -1;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareListDataItemModels();
    }

    @Override
    public String getControlType() {
        return "LIST";
    }

    protected void prepareListDataItemModels() throws Exception {
    }

    protected void registerListDataItem(IListDataItem iListDataItem) {
        this.listDataItemList.add(iListDataItem);
    }

    @Override
    public Iterator<IListDataItem> getListDataItems() {
        return this.listDataItemList.iterator();
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
        IMDCtrlHandler iMDCtrlHandler = null;
        boolean bEnableItemPriv = false;
        if (iCtrlHandler != null && iCtrlHandler instanceof IMDCtrlHandler) {
            iMDCtrlHandler = (IMDCtrlHandler)iCtrlHandler;
            bEnableItemPriv = iMDCtrlHandler.isEnableItemPriv();
        }
        if (dt.getCachedRowCount() == -1) {
            IDataRow iDataRow;
            while ((iDataRow = dt.next()) != null) {
                JSONObject jo = new JSONObject();
                for (IListDataItem iListDataItem : this.listDataItemList) {
                    String strPrivilegeId;
                    boolean bItemReadOk = true;
                    if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iListDataItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 1) == 0) {
                        bItemReadOk = false;
                    }
                    if (bItemReadOk) {
                        Object objValue = this.getListDataItemValue(iListDataItem, iDataRow);
                        JSONObjectHelper.put(jo, iListDataItem.getName(), objValue);
                        continue;
                    }
                    jo.put(iListDataItem.getName(), (Object)JSONNull.getInstance());
                }
                fetchResult.getRows().add(jo);
            }
        } else {
            int nRows = dt.getCachedRowCount();
            int i = 0;
            while (i < nRows) {
                IDataRow iDataRow = dt.getCachedRow(i);
                JSONObject jo = new JSONObject();
                for (IListDataItem iListDataItem : this.listDataItemList) {
                    String strPrivilegeId;
                    boolean bItemReadOk = true;
                    if (bEnableItemPriv && !StringHelper.isNullOrEmpty(strPrivilegeId = iListDataItem.getPrivilegeId()) && (this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & 1) == 0) {
                        bItemReadOk = false;
                    }
                    if (bItemReadOk) {
                        Object objValue = this.getListDataItemValue(iListDataItem, iDataRow);
                        JSONObjectHelper.put(jo, iListDataItem.getName(), objValue);
                        continue;
                    }
                    jo.put(iListDataItem.getName(), (Object)JSONNull.getInstance());
                }
                fetchResult.getRows().add(jo);
                ++i;
            }
        }
    }

    protected Object getListDataItemValue(IListDataItem iListDataItem, IDataRow iDataRow) throws Exception {
        Object objValue = iListDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
        if (objValue == null) {
            return JSONNull.getInstance();
        }
        return objValue;
    }

    @Override
    public int getPageSize() {
        return this.nPageSize;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }
}

