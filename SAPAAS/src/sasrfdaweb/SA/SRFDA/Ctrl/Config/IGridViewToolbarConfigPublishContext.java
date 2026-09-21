/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Data.DataGrid;

public interface IGridViewToolbarConfigPublishContext
extends IToolbarConfigPublishContext {
    public boolean getPickupMode();

    public boolean getEnableRowEdit();

    public DataGrid getDataGrid();
}

