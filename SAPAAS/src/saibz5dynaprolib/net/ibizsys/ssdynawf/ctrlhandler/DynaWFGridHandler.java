/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler
 *  net.ibizsys.model.control.grid.IPSDEGrid
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
package net.ibizsys.ssdynawf.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.ctrlhandler.WFGridHandlerBase;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFGridHandler
extends WFGridHandlerBase
implements IDynaCtrlHandler {
    private static final Log log = LogFactory.getLog(DynaWFGridHandler.class);
    private IPSControl iPSControl = null;
    private IGridModel iGridModel = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
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

