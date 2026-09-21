/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridHandler
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.GridHandlerBase
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridHandler;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaGridHandler
extends GridHandlerBase
implements IDynaCtrlHandler {
    private IPSControl iPSControl = null;
    private IDynaCtrlModel iDynaCtrlModel = null;
    private IPSDEGridHandler iPSDEGridHandler = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        if (this.getPSDEGrid().getPSAjaxControlHandler() != null) {
            this.iPSDEGridHandler = (IPSDEGridHandler)this.getPSDEGrid().getPSAjaxControlHandler();
        }
        this.iDynaCtrlModel = (IDynaCtrlModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected IGridModel getGridModel() {
        return (IGridModel)this.iDynaCtrlModel;
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
        super.onInit();
    }

    public IPSDEGridHandler getPSDEGridHandler() {
        return this.iPSDEGridHandler;
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

    protected void removeEntity(Object objKeyValue) throws Exception {
        String strDEActionName = this.getPSDEGridHandler().getDEActionName("remove");
        if (StringHelper.isNullOrEmpty((String)strDEActionName)) {
            super.removeEntity(objKeyValue);
            return;
        }
        IEntity entity = this.getDEModel().createEntity();
        entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
        this.getService().executeAction(strDEActionName.toUpperCase(), entity);
    }
}

