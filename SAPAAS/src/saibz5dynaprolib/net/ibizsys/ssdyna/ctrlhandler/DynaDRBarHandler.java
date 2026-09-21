/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.drctrl.IPSDEDRBar
 *  net.ibizsys.paas.ctrlhandler.DRBarHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDRBarModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.paas.ctrlhandler.DRBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaDRBarHandler
extends DRBarHandlerBase
implements IDynaCtrlHandler {
    private static final Log log = LogFactory.getLog(DynaDRBarHandler.class);
    private IPSControl iPSControl = null;
    private IDRBarModel iDRBarModel = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.iDRBarModel = (IDRBarModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDRBar getPSDEDRBar() {
        return (IPSDEDRBar)this.getPSControl();
    }

    protected IDRBarModel getDRBarModel() {
        return this.iDRBarModel;
    }
}

