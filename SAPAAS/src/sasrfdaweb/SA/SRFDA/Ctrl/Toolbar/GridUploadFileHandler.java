/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridUploadFileHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)StringHelper.Format((String)"'../srfpage/uploadfileview.jsp?%1$s'", (Object)webContext.GetQueryString()), (String)"{}", (int)400, (int)300, (String)"no", (String)"no", (String)"no"));
        script.Append(" var _ret = 'cancel';\r\n");
        script.Append("if (_DIALOGRESULT != null && _DIALOGRESULT != undefined && _DIALOGRESULT.ret != undefined)\r\n");
        script.Append(" _ret = _DIALOGRESULT.ret;\r\n");
        script.Append("if (_ret == 'ok'){%1$s}\r\n", (Object)DataGridJSHelper.getDataReloadScript((String)dataGrid.getUniqueID()));
        script.Append("}");
        return script.toString();
    }
}

