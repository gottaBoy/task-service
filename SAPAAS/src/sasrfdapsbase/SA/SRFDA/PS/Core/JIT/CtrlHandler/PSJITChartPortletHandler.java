/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.ChartPortletHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IPortletModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.ChartPortletHandlerBase;
import net.ibizsys.paas.ctrlmodel.IPortletModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITChartPortletHandler
extends ChartPortletHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITChartPortletHandler.class);
    private IPSControl iPSControl = null;
    private IPortletModel iPortletModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDBPortletPart getPSDBPortletPart() {
        return (IPSDBPortletPart)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDBPortletPart iPSDBPortletPart = this.getPSDBPortletPart();
        this.iPortletModel = (IPortletModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IPortletModel getPortletModel() {
        return this.iPortletModel;
    }
}

