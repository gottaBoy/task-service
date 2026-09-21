/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.drctrl.IPSDEDRTab
 *  net.ibizsys.paas.ctrlhandler.DRTabHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDRTabModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.paas.ctrlhandler.DRTabHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaDRTabHandler
extends DRTabHandlerBase
implements IDynaCtrlHandler {
    private static final Log log = LogFactory.getLog(DynaDRTabHandler.class);
    private IPSControl iPSControl = null;
    private IDRTabModel iDRTabModel = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.iDRTabModel = (IDRTabModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDRTab getPSDEDRTab() {
        return (IPSDEDRTab)this.getPSControl();
    }

    protected IDRTabModel getDRTabModel() {
        return this.iDRTabModel;
    }
}

