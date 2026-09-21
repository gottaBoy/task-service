/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.expbar.ExpBarItem
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 *  net.ibizsys.paas.control.expbar.IExpBarItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSWFExpBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase;

public class PSJITWFExpBarModel
extends WFExpBarModelBase
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

    public IPSWFExpBar getPSWFExpBar() {
        return (IPSWFExpBar)this.getPSControl();
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
}

