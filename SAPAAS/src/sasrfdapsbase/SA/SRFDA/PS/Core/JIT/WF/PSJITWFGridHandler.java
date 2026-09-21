/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.ctrlhandler.WFGridHandlerBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.Control.Ajax.IPSMDAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.ctrlhandler.WFGridHandlerBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITWFGridHandler
extends WFGridHandlerBase
implements IPSJITCtrlHandler {
    private static final Log log = LogFactory.getLog(PSJITWFGridHandler.class);
    private IPSControl iPSControl = null;
    private IGridModel iGridModel = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEGrid getPSDEGrid() {
        return (IPSDEGrid)this.getPSControl();
    }

    protected void onInit() throws Exception {
        IPSDEGrid iPSDEGrid = this.getPSDEGrid();
        if (iPSDEGrid.isNoSort()) {
            this.setEnableUserSort(false);
        }
        if (iPSDEGrid.getMinorSortPSDEF() != null) {
            this.setMinorSortField(iPSDEGrid.getMinorSortPSDEF().getName());
            this.setMinorSortDir(iPSDEGrid.getMinorSortDir());
        }
        if (iPSDEGrid.isEnableRowEdit()) {
            this.setEnableRowEdit(true);
        }
        if (iPSDEGrid.isEnableItemPrivilege()) {
            this.setEnableItemPriv(true);
        }
        if (iPSDEGrid.getPSAjaxControlHandler() != null) {
            IPSMDAjaxControlHandler achandler = (IPSMDAjaxControlHandler)iPSDEGrid.getPSAjaxControlHandler();
            if (achandler.isEnableOrgDR()) {
                this.setEnableOrgDR(true);
                this.setOrgDR(achandler.getOrgDR());
            }
            if (achandler.isEnableSecDR()) {
                this.setEnableSecDR(true);
                this.setSecDR(achandler.getSecDR());
            }
            if (achandler.isEnableSecBC()) {
                this.setEnableSecBC(true);
                this.setSecBC(achandler.getSecBC());
            }
            if (achandler.isEnableUserDR()) {
                this.setEnableUserDR(true);
            }
            if (achandler.getPSDEDataExport() != null) {
                this.setDEDataExportId(achandler.getPSDEDataExport().getId());
            }
        }
        this.iGridModel = (IGridModel)this.getViewController().getCtrlModel(this.getPSControl().getName().toLowerCase());
        super.onInit();
    }

    protected IGridModel getGridModel() {
        return this.iGridModel;
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
        IPSMDAjaxControlHandler achandler = (IPSMDAjaxControlHandler)this.getPSDEGrid().getPSAjaxControlHandler();
        if (!this.getPSControl().getPSAppView().isPickupView() || !this.getPSDEGrid().getPSDataEntity().isEnableTempData()) {
            if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() > 0) {
                return this.getService().fetchDataSetTemp(achandler.getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
            }
            return this.getService().fetchDataSet(achandler.getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
        }
        if (WebContext.isTempMode((IWebContext)this.getWebContext())) {
            return this.getService().fetchDataSetTemp(achandler.getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
        }
        return this.getService().fetchDataSet(achandler.getPSDEDataSet().getName(), (IDEDataSetFetchContext)deDataSetFetchContext);
    }

    public int getTempMode() {
        if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() == 1) {
            return 1;
        }
        if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() == 2) {
            return 2;
        }
        return super.getTempMode();
    }
}

