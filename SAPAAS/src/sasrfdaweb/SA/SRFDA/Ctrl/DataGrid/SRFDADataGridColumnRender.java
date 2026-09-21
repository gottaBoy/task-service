/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridColumnRender
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridColumnRender;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;

public class SRFDADataGridColumnRender
extends SRFExDataGridColumnRender {
    public String GetJSCode(SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        return this.OnGetJSCode((SRFDAWebContext)dataGrid.getWebContext(), dataGrid, baseConfig);
    }

    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        return "";
    }
}

