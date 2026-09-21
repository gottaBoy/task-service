/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.AppMenuHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.AppMenuHandlerBase;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITAppMenuHandler
extends AppMenuHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITAppMenuHandler.class);
    private IPSControl iPSControl = null;
    private IAppMenuModel iAppMenuModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSAppMenu getPSAppMenu() {
        return (IPSAppMenu)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSAppMenu iPSAppMenu = this.getPSAppMenu();
        this.iAppMenuModel = (IAppMenuModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IAppMenuModel getAppMenuModel() {
        return this.iAppMenuModel;
    }
}

