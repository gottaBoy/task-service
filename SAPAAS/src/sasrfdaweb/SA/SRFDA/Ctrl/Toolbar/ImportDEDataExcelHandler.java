/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;

public class ImportDEDataExcelHandler
implements ISRFExToolbarButtonHandler,
ISRFExToolbarMenuHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        if (obj != null && obj instanceof SRFExDataGrid) {
            SRFExDataGrid dataGrid = (SRFExDataGrid)obj;
            int nWidth = 980;
            int nHeight = 680;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            script.Append("var _URL = '../srfpage/uploaddedataexcelview.jsp?SRFDEID=';\r\n", (Object)"");
            script.Append("if(%1$s){_URL+=%1$s.get('DEID');}else{return;}\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
            script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        }
        script.Append("}");
        return script.toString();
    }

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        if (obj != null && obj instanceof SRFExDataGrid) {
            SRFExDataGrid dataGrid = (SRFExDataGrid)obj;
            int nWidth = 980;
            int nHeight = 680;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            script.Append("var _URL = '../srfpage/uploaddedataexcelview.jsp?SRFDEID=';\r\n", (Object)"");
            script.Append("if(%1$s){_URL+=%1$s.get('DEID');}else{return;}\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
            script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        }
        script.Append("}");
        return script.toString();
    }
}

