/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.UIGear.BaseUIGear
 *  SA.SRFramework.WebEx.SRFExDataGrid
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Web.JSGear.DataGridNewEditJSGear;
import SA.SRFDA.Web.JSGear.IDataGridNewEditJSUIGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.UIGear.BaseUIGear;
import SA.SRFramework.WebEx.SRFExDataGrid;

public class DefaultDataGridNewEditJSUIGear
extends BaseUIGear
implements IDataGridNewEditJSUIGear {
    @Override
    public boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode, boolean bInfoMode) {
        return DataGridNewEditJSGear.Load(daPage, dataGrid, bNew, bEdit, bDBClickEditMode, bInfoMode);
    }

    @Override
    public boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode) {
        return DataGridNewEditJSGear.Load(daPage, dataGrid, bNew, bEdit, bDBClickEditMode);
    }

    @Override
    public boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid) {
        return DataGridNewEditJSGear.Load(daPage, dataGrid);
    }
}

