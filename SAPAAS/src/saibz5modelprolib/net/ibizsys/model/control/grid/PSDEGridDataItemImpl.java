/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.data.PSDataItemImpl;

public class PSDEGridDataItemImpl
extends PSDataItemImpl
implements IPSDEGridDataItem {
    private boolean bDataAccessAction = false;
    private String strPrivilegeId = null;
    private IPSDEGrid iPSDEGrid = null;
    private IPSDEGridColumn iPSDEGridColumn = null;

    public void init(IPSDEGridColumn iPSDEGridColumn) throws Exception {
        this.iPSDEGridColumn = iPSDEGridColumn;
        this.iPSDEGrid = this.iPSDEGridColumn.getPSDEGrid();
        this.onInit();
    }

    public void init(IPSDEGrid iPSDEGrid) throws Exception {
        this.iPSDEGrid = iPSDEGrid;
        this.onInit();
    }

    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u6570\u636e\u9879")
    public boolean isDataAccessAction() {
        return this.bDataAccessAction;
    }

    public void setDataAccessAction(boolean bDataAccessAction) {
        this.bDataAccessAction = bDataAccessAction;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDEGrid() != null) {
            return ((IPSModelObjectRuntime)this.getPSDEGrid()).getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    public IPSDEGridColumn getPSDEGridColumn() {
        return this.iPSDEGridColumn;
    }
}

