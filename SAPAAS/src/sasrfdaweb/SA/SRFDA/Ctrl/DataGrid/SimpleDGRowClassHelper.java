/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridRowClassHelper
 *  SA.SRFramework.WebEx.SRFExDataGrid
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.WebEx.DataGrid.SRFExDataGridRowClassHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;

public class SimpleDGRowClassHelper
extends SRFExDataGridRowClassHelper {
    public String GetJSCode(SRFExDataGrid dataGrid) {
        return "return (index%2==0)?'sx-row-lightstrip':'sx-row-darkstrip';";
    }
}

