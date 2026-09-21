/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public class CalendarItemDataItemModel
extends DataItemModel
implements ICalendarItemDataItem {
    private ICalendarItemModel iCalendarItemModel = null;
    private boolean bDataAccessAction = false;
    private ICalendarModel iCalendarModel = null;
    private String strPrivilegeId = null;
    private IDataEntityModel iDEModel = null;

    public void init(ICalendarItemModel iCalendarItemModel) throws Exception {
        this.setCalendarItemModel(iCalendarItemModel);
        this.onInit();
    }

    protected ICalendarItemModel getCalendarItemModel() {
        return this.iCalendarItemModel;
    }

    protected ICalendarModel getCalendarModel() {
        return this.iCalendarModel;
    }

    protected void setCalendarItemModel(ICalendarItemModel iCalendarItemModel) throws Exception {
        this.iCalendarItemModel = iCalendarItemModel;
        if (this.iCalendarItemModel != null) {
            this.iCalendarModel = this.iCalendarItemModel.getCalendarModel();
            if (this.iCalendarModel != null) {
                this.iDEModel = this.iCalendarModel.getDEModel();
            }
            if (!StringHelper.isNullOrEmpty(this.iCalendarItemModel.getDEName())) {
                if (this.iDEModel != null) {
                    if (StringHelper.compare(this.iDEModel.getName(), this.iCalendarItemModel.getDEName(), true) != 0) {
                        this.iDEModel = this.iDEModel.getSystemModel().getDataEntityModel(this.iCalendarItemModel.getDEName());
                    }
                } else {
                    this.iDEModel = DEModelGlobal.getDEModel(this.iCalendarItemModel.getDEName());
                }
            }
        } else {
            this.iCalendarModel = null;
            this.iDEModel = null;
        }
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        if (this.getDEModel() != null) {
            return this.getDEModel().getSystemModel();
        }
        return null;
    }

    @Override
    public boolean isDataAccessAction() {
        return this.bDataAccessAction;
    }

    public void setDataAccessAction(boolean bDataAccessAction) {
        this.bDataAccessAction = bDataAccessAction;
    }

    @Override
    public Object getValue(IWebContext iWebContext, Object object) throws Exception {
        if (this.isDataAccessAction()) {
            if (this.getCalendarModel() == null) {
                throw new Exception(StringHelper.format("\u5f53\u524d\u65e5\u5386\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u65e0\u6548"));
            }
            IDataEntityModel iDataEntityModel = this.getDEModel();
            if (iDataEntityModel == null) {
                return "{}";
            }
            IViewController iViewController = this.getCalendarModel().getViewController();
            String strKeyName = this.getDataItemParams()[0].getName();
            Iterator<String> deDataAccessActions = iViewController.getDEDataAccessActions(iDataEntityModel.getName());
            if (deDataAccessActions != null) {
                JSONObject jo = new JSONObject();
                if (object instanceof IDataRow) {
                    Object iEntity = iDataEntityModel.createEntity();
                    DataObject.fromDataRow(iEntity, (IDataRow)object);
                    while (deDataAccessActions.hasNext()) {
                        String strAccessAction = deDataAccessActions.next();
                        if (StringHelper.compare(iDataEntityModel.getDEOPPrivTarget(strAccessAction), "NONE", true) == 0) continue;
                        CallResult callResult = iViewController.testDEDataAccessAction(iDataEntityModel, iEntity, strAccessAction, true);
                        if (callResult.isOk()) {
                            jo.put(strAccessAction, 1);
                            continue;
                        }
                        jo.put(strAccessAction, 0);
                    }
                } else if (object instanceof ISimpleDataObject) {
                    Object objKey = ((ISimpleDataObject)object).get(strKeyName);
                    while (deDataAccessActions.hasNext()) {
                        String strAccessAction = deDataAccessActions.next();
                        if (StringHelper.compare(iDataEntityModel.getDEOPPrivTarget(strAccessAction), "NONE", true) == 0) continue;
                        CallResult callResult = iViewController.testDEDataAccessAction(iDataEntityModel, objKey, strAccessAction, true);
                        if (callResult.isOk()) {
                            jo.put(strAccessAction, 1);
                            continue;
                        }
                        jo.put(strAccessAction, 0);
                    }
                }
                return jo.toString();
            }
            return "{}";
        }
        return super.getValue(iWebContext, object);
    }

    @Override
    protected IDataEntityModel getDEModel() throws Exception {
        return this.iDEModel;
    }

    @Override
    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }
}

