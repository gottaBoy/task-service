/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase
 *  net.ibizsys.paas.ctrlmodel.ISearchFormModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase;
import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITSearchFormHandler
extends SearchFormHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITSearchFormHandler.class);
    private IPSControl iPSControl = null;
    private ISearchFormModel iSearchFormModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDESearchForm getPSDESearchForm() {
        return (IPSDESearchForm)this.getPSControl();
    }

    protected void onInit() throws Exception {
        this.iSearchFormModel = (ISearchFormModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected ISearchFormModel getSearchFormModel() {
        return this.iSearchFormModel;
    }
}

