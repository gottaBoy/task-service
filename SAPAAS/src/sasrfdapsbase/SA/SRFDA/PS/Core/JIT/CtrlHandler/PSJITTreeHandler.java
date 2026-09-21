/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.TreeHandlerBase
 *  net.ibizsys.paas.ctrlmodel.ITreeModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.TreeHandlerBase;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITTreeHandler
extends TreeHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITTreeHandler.class);
    private IPSControl iPSControl = null;
    private ITreeModel iTreeModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDETree getPSDETree() {
        return (IPSDETree)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDETree iPSDETree = this.getPSDETree();
        this.iTreeModel = (ITreeModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected ITreeModel getTreeModel() {
        return this.iTreeModel;
    }
}

