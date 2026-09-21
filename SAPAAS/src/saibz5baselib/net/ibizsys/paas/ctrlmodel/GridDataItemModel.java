/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public class GridDataItemModel
extends DataItemModel
implements IGridDataItem {
    private IGrid iGrid = null;
    private boolean bDataAccessAction = false;
    private IGridModel iGridModel = null;
    private String strPrivilegeId = null;
    private String strGroupItem = null;

    public void init(IGrid iGrid) throws Exception {
        this.setGrid(iGrid);
        this.onInit();
    }

    protected IGrid getGrid() {
        return this.iGrid;
    }

    protected IGridModel getGridModel() {
        return this.iGridModel;
    }

    protected void setGrid(IGrid iGrid) {
        this.iGrid = iGrid;
        if (this.iGrid == null) {
            this.iGridModel = null;
        } else if (this.iGrid instanceof IGridModel) {
            this.iGridModel = (IGridModel)this.iGrid;
        }
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        return this.getGrid().getDataEntity().getSystem();
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
            if (this.getGridModel() == null) {
                throw new Exception(StringHelper.format("\u5f53\u524d\u8868\u683c\u6a21\u578b\u5bf9\u8c61\u65e0\u6548"));
            }
            IDataEntityModel iDataEntityModel = this.getGridModel().getDEModel();
            if (iDataEntityModel == null) {
                return "{}";
            }
            IViewController iViewController = this.getGridModel().getViewController();
            String strKeyName = this.getDataItemParams()[0].getName();
            Iterator<String> deDataAccessActions = iViewController.getDEDataAccessActions(iDataEntityModel.getName());
            if (deDataAccessActions != null) {
                JSONObject jo = new JSONObject();
                if (object instanceof IDataRow) {
                    Object iEntity = this.getGridModel().getDEModel().createEntity();
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
        return (IDataEntityModel)this.getGrid().getDataEntity();
    }

    @Override
    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }
}

