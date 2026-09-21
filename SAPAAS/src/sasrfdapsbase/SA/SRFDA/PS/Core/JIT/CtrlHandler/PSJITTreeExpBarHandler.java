/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.ITreeHandler
 *  net.ibizsys.paas.ctrlhandler.TreeExpBarHandlerBase
 *  net.ibizsys.paas.ctrlmodel.ITreeExpBarModel
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ITreeHandler;
import net.ibizsys.paas.ctrlhandler.TreeExpBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.ITreeExpBarModel;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITTreeExpBarHandler
extends TreeExpBarHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITTreeExpBarHandler.class);
    private IPSControl iPSControl = null;
    private ITreeExpBarModel iTreeExpBarModel = null;

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

    protected void onInit() throws Exception {
        IPSTreeExpBar iPSTreeExpBar = this.getPSTreeExpBar();
        this.iTreeExpBarModel = (ITreeExpBarModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected ITreeExpBarModel getTreeExpBarModel() {
        return this.iTreeExpBarModel;
    }

    protected ITreeHandler getTreeHandler() throws Exception {
        if (this.getPSTreeExpBar().getPSDETree() != null) {
            return (ITreeHandler)this.getViewController().getCtrlHandler(String.valueOf(this.getPSTreeExpBar().getName().toLowerCase()) + "_tree");
        }
        return super.getTreeHandler();
    }

    protected ITreeModel getTreeModel() throws Exception {
        if (this.getPSTreeExpBar().getPSDETree() != null) {
            return (ITreeModel)this.getViewController().getCtrlModel(String.valueOf(this.getPSTreeExpBar().getName().toLowerCase()) + "_tree");
        }
        return super.getTreeModel();
    }
}

