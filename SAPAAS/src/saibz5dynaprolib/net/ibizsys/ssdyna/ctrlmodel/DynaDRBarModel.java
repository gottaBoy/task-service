/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.ibizsys.paas.control.drctrl.IDRCtrlItem
 *  net.ibizsys.paas.ctrlmodel.DRBarModelBase
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlmodel.DRBarModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaDRBarModel
extends DRBarModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaDRBarModel.class);
    private IPSControl iPSControl = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDRBar getPSDEDRBar() {
        return (IPSDEDRBar)this.getPSControl();
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(this.getPSControl().getPSDataEntity().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.getDEModel();
    }

    protected void onPrepareRootItem(DRCtrlRootItem drCtrlRootItem) throws Exception {
        ArrayList items = this.getPSDEDRBar().getRootItem().getAllItems();
        for (IDRCtrlItem dritem : items) {
            DRCtrlItem drCtrlItem = drCtrlRootItem.addItem(dritem.getId(), dritem.getPId());
            drCtrlItem.setText(dritem.getText());
            drCtrlItem.setDRViewId(dritem.getDRViewId());
            if (dritem.isExpanded()) {
                drCtrlItem.setExpanded(true);
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getIconPath())) {
                drCtrlItem.setIconPath(dritem.getIconPath());
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getIconCls())) {
                drCtrlItem.setIconCls(dritem.getIconCls());
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getCounterId())) {
                drCtrlItem.setCounterId(dritem.getCounterId());
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getEnableMode())) {
                drCtrlItem.setEnableMode(dritem.getEnableMode());
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getTestEnableDEActionName())) {
                drCtrlItem.setTestEnableDEActionName(dritem.getTestEnableDEActionName());
            }
            if (!StringHelper.isNullOrEmpty((String)dritem.getTestEnableDEOPPriv())) {
                drCtrlItem.setTestEnableDEOPPriv(dritem.getTestEnableDEOPPriv());
            }
            Iterator viewparams = dritem.getViewParamNames();
            while (viewparams.hasNext()) {
                String strParamName = (String)viewparams.next();
                drCtrlItem.setViewParam(strParamName, dritem.getViewParam(strParamName));
            }
        }
    }

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }
}

