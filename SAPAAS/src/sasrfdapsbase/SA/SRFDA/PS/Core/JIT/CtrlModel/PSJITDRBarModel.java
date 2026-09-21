/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.drctrl.DRCtrlItem
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.ibizsys.paas.control.drctrl.IDRCtrlItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.DRBarModelBase
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.DRBarModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITDRBarModel
extends DRBarModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
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
                return this.getViewController().getSystemModel().getDataEntityModel(this.getPSControl().getPSDataEntity().getName());
            }
        }
        catch (Exception exception) {
            // empty catch block
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
}

