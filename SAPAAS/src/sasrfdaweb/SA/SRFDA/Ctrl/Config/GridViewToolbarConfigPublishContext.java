/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IGridViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Data.DataGrid;

public class GridViewToolbarConfigPublishContext
extends ToolbarConfigPublishContext
implements IGridViewToolbarConfigPublishContext {
    private boolean bPickupMode = false;
    private boolean bEnableRowEdit = false;
    private DataGrid dataGrid = null;

    @Override
    public boolean getPickupMode() {
        return this.bPickupMode;
    }

    @Override
    public boolean getEnableRowEdit() {
        return this.bEnableRowEdit;
    }

    @Override
    public DataGrid getDataGrid() {
        return this.dataGrid;
    }

    public void setPickupMode(boolean bPickupMode) {
        this.bPickupMode = bPickupMode;
    }

    public void setEnableRowEdit(boolean bEnableRowEdit) {
        this.bEnableRowEdit = bEnableRowEdit;
    }

    public void setDataGrid(DataGrid dataGrid) {
        this.dataGrid = dataGrid;
    }
}

