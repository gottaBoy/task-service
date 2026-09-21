/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.ChartHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IChartModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlHandler;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartHandler;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.ChartHandlerBase;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.DBFetchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITChartHandler
extends ChartHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITChartHandler.class);
    private IPSControl iPSControl = null;
    private IChartModel iChartModel = null;
    private IPSDEChartHandler iPSDEChartHandler = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEChart getPSDEChart() {
        return (IPSDEChart)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDEChart iPSDEChart = this.getPSDEChart();
        if (this.getPSDEChart().getPSAjaxControlHandler() != null) {
            this.iPSDEChartHandler = (IPSDEChartHandler)this.getPSDEChart().getPSAjaxControlHandler();
        }
        this.iChartModel = (IChartModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IChartModel getChartModel() {
        return this.iChartModel;
    }

    public IPSDEChartHandler getPSDEChartHandler() {
        return this.iPSDEChartHandler;
    }

    protected void prepareDataAccessActions() throws Exception {
        super.prepareDataAccessActions();
        if (this.getPSDEChartHandler() != null) {
            Iterator<String> ajaxActions = this.getPSDEChartHandler().getAjaxActions();
            while (ajaxActions.hasNext()) {
                this.registerDataAccessAction(ajaxActions.next(), "NONE");
            }
        }
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
        if (this.getPSDEChartHandler().getPSDEDataSet() != null) {
            return this.getService().fetchDataSet(this.getPSDEChartHandler().getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
        }
        return this.getService().fetchDataSet(this.getPSDEChart().getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
    }

    public int getTempMode() {
        if (this.getPSDEChartHandler().getTempMode() > 0) {
            return this.getPSDEChartHandler().getTempMode();
        }
        return super.getTempMode();
    }
}

