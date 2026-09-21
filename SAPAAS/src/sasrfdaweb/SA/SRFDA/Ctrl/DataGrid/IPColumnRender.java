/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridColumnRender
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.WebEx.DataGrid.SRFExDataGridColumnRender;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;

public class IPColumnRender
extends SRFExDataGridColumnRender {
    public String GetJSCode(SRFExDataGrid dataGrid, DataGridColumnRenderConfig renderConfig) {
        return "return SRFUtility.long2ip(value);";
    }
}

