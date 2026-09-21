/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.DRBarHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDRBarModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.DRBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITDRBarHandler
extends DRBarHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITDRBarHandler.class);
    private IPSControl iPSControl = null;
    private IDRBarModel iDRBarModel = null;

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

    protected void onInit() throws Exception {
        IPSDEDRBar iPSDEDRBar = this.getPSDEDRBar();
        this.iDRBarModel = (IDRBarModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IDRBarModel getDRBarModel() {
        return this.iDRBarModel;
    }
}

