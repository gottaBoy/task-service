/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.DataViewHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IDataViewModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewHandler;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.DataViewHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDataViewModel;
import net.ibizsys.paas.db.DBFetchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITDataViewHandler
extends DataViewHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITDataViewHandler.class);
    private IPSControl iPSControl = null;
    private IDataViewModel iDataViewModel = null;
    private IPSDEDataViewHandler iPSDEDataViewHandler = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEDataView getPSDEDataView() {
        return (IPSDEDataView)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDEDataView iPSDEDataView = this.getPSDEDataView();
        if (this.getPSDEDataView().getPSAjaxControlHandler() != null) {
            this.iPSDEDataViewHandler = (IPSDEDataViewHandler)this.getPSDEDataView().getPSAjaxControlHandler();
        }
        this.iDataViewModel = (IDataViewModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IDataViewModel getDataViewModel() {
        return this.iDataViewModel;
    }

    public IPSDEDataViewHandler getPSDEDataViewHandler() {
        return this.iPSDEDataViewHandler;
    }

    protected void prepareDataAccessActions() throws Exception {
        super.prepareDataAccessActions();
        if (this.getPSDEDataViewHandler() != null) {
            Iterator<String> ajaxActions = this.getPSDEDataViewHandler().getAjaxActions();
            while (ajaxActions.hasNext()) {
                this.registerDataAccessAction(ajaxActions.next(), "NONE");
            }
        }
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
        return this.getService().fetchDataSet(this.getPSDEDataViewHandler().getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
    }

    public int getTempMode() {
        if (this.getPSDEDataViewHandler().getTempMode() > 0) {
            return this.getPSDEDataViewHandler().getTempMode();
        }
        return super.getTempMode();
    }
}

