/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.DRTabHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDRTabModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRTab;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.DRTabHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITDRTabHandler
extends DRTabHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITDRTabHandler.class);
    private IPSControl iPSControl = null;
    private IDRTabModel iDRTabModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDRTab getPSDEDRTab() {
        return (IPSDEDRTab)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDEDRTab iPSDEDRTab = this.getPSDEDRTab();
        this.iDRTabModel = (IDRTabModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IDRTabModel getDRTabModel() {
        return this.iDRTabModel;
    }
}

