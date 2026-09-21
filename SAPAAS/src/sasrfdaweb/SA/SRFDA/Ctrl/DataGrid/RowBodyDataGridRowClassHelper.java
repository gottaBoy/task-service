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

public class RowBodyDataGridRowClassHelper
extends SRFExDataGridRowClassHelper {
    public String GetJSCode(SRFExDataGrid arg0) {
        String strJSCode = "if(this.showPreview){";
        strJSCode = String.valueOf(strJSCode) + "var A=record.get(ROWBODY);";
        strJSCode = String.valueOf(strJSCode) + "if($V(A,'')!=''){";
        strJSCode = String.valueOf(strJSCode) + "rp.body='<div class=\"sx-rowbody\">'+A+'</div>';";
        strJSCode = String.valueOf(strJSCode) + "return 'x-grid3-row-expanded';";
        strJSCode = String.valueOf(strJSCode) + "}}";
        strJSCode = String.valueOf(strJSCode) + "return 'x-grid3-row-collapsed';";
        return strJSCode;
    }

    public boolean IsShowPreview() {
        return true;
    }

    public boolean IsEnableRowBody() {
        return true;
    }
}

