/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.TreeExpBarModelBase
 *  net.ibizsys.paas.demodel.IDataEntityModel
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.TreeExpBarModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class PSJITTreeExpBarModel
extends TreeExpBarModelBase
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

    public IPSTreeExpBar getPSTreeExpBar() {
        return (IPSTreeExpBar)this.getPSControl();
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
}

