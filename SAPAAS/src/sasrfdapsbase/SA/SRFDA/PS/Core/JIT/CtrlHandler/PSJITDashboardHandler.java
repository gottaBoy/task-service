/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.DashboardHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDashboardModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.DashboardHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDashboardModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITDashboardHandler
extends DashboardHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITDashboardHandler.class);
    private IPSControl iPSControl = null;
    private IDashboardModel iDashboardModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDashboard getPSDashboard() {
        return (IPSDashboard)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDashboard iPSDashboard = this.getPSDashboard();
        this.iDashboardModel = (IDashboardModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IDashboardModel getDashboardModel() {
        return this.iDashboardModel;
    }
}

