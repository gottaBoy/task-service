/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.pswf.ctrlhandler.WFExpBarHandlerBase
 *  net.ibizsys.pswf.ctrlmodel.IWFExpBarModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSWFExpBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.pswf.ctrlhandler.WFExpBarHandlerBase;
import net.ibizsys.pswf.ctrlmodel.IWFExpBarModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITWFExpBarHandler
extends WFExpBarHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITWFExpBarHandler.class);
    private IPSControl iPSControl = null;
    private IWFExpBarModel iWFExpBarModel = null;

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

    protected void onInit() throws Exception {
        IPSWFExpBar iPSWFExpBar = this.getPSWFExpBar();
        this.iWFExpBarModel = (IWFExpBarModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IWFExpBarModel getWFExpBarModel() {
        return this.iWFExpBarModel;
    }
}

