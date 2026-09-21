/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.expbar.IPSWFExpBar
 *  net.ibizsys.paas.control.expbar.ExpBarItem
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 *  net.ibizsys.paas.control.expbar.IExpBarItem
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.expbar.IPSWFExpBar;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFExpBarModel
extends WFExpBarModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaWFExpBarModel.class);
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

    public IPSWFExpBar getPSWFExpBar() {
        return (IPSWFExpBar)this.getPSControl();
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

    protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {
        ArrayList items = this.getPSWFExpBar().getRootItem().getAllItems();
        for (IExpBarItem expitem : items) {
            ExpBarItem expBarItem = expBarRootItem.addItem(expitem.getId(), expitem.getPId());
            expBarItem.setText(expitem.getText());
            expBarItem.setExpViewId(expitem.getExpViewId());
            if (expitem.isExpanded()) {
                expBarItem.setExpanded(true);
            }
            if (!StringHelper.isNullOrEmpty((String)expitem.getIconPath())) {
                expBarItem.setIconPath(expitem.getIconPath());
            }
            if (!StringHelper.isNullOrEmpty((String)expitem.getIconCls())) {
                expBarItem.setIconCls(expitem.getIconCls());
            }
            if (!StringHelper.isNullOrEmpty((String)expitem.getCounterId())) {
                expBarItem.setCounterId(expitem.getCounterId());
                expBarItem.setCounterMode(expitem.getCounterMode());
            }
            Iterator viewparams = expitem.getViewParamNames();
            while (viewparams.hasNext()) {
                String strParamName = (String)viewparams.next();
                expBarItem.setViewParam(strParamName, expitem.getViewParam(strParamName));
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

