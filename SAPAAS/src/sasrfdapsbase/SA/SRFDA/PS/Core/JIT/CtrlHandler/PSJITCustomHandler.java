/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.CtrlHandlerBase
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITCustomHandler
extends CtrlHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITCustomHandler.class);
    private IPSControl iPSControl = null;
    private ICtrlModel iCtrlModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    public ICtrlModel getCtrlModel() {
        return this.iCtrlModel;
    }
}

