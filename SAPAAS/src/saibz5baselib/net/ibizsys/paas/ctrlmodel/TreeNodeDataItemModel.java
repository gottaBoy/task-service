/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public class TreeNodeDataItemModel
extends DataItemModel
implements ITreeNodeDataItem {
    private ITreeNodeModel iTreeNodeModel = null;
    private boolean bDataAccessAction = false;
    private ITreeModel iTreeModel = null;
    private String strPrivilegeId = null;
    private IDataEntityModel iDEModel = null;

    public void init(ITreeNodeModel iTreeNodeModel) throws Exception {
        this.setTreeNodeModel(iTreeNodeModel);
        this.onInit();
    }

    protected ITreeNodeModel getTreeNodeModel() {
        return this.iTreeNodeModel;
    }

    protected ITreeModel getTreeModel() {
        return this.iTreeModel;
    }

    protected void setTreeNodeModel(ITreeNodeModel iTreeNodeModel) throws Exception {
        this.iTreeNodeModel = iTreeNodeModel;
        if (this.iTreeNodeModel != null) {
            this.iTreeModel = this.iTreeNodeModel.getTreeModel();
            if (this.iTreeModel != null) {
                this.iDEModel = this.iTreeModel.getDEModel();
            }
            if (!StringHelper.isNullOrEmpty(this.iTreeNodeModel.getDEName())) {
                if (this.iDEModel != null) {
                    if (StringHelper.compare(this.iDEModel.getName(), this.iTreeNodeModel.getDEName(), true) != 0) {
                        this.iDEModel = this.iDEModel.getSystemModel().getDataEntityModel(this.iTreeNodeModel.getDEName());
                    }
                } else {
                    this.iDEModel = DEModelGlobal.getDEModel(this.iTreeNodeModel.getDEName());
                }
            }
        } else {
            this.iTreeModel = null;
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
            if (this.getTreeModel() == null) {
                throw new Exception(StringHelper.format("\u5f53\u524d\u6811\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u65e0\u6548"));
            }
            IDataEntityModel iDataEntityModel = this.getDEModel();
            if (iDataEntityModel == null) {
                return "{}";
            }
            IViewController iViewController = this.getTreeModel().getViewController();
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

