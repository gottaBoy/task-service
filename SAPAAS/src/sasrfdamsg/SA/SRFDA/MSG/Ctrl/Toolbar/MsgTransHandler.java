/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.MSG.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class MsgTransHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        MsgTransHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        int nWidth = 900;
        int nHeight = 600;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        script.Append("var _R = %1$s;", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
        script.Append("var _MSGID = SRFUtility.getvalue(_R.get('MESSAGEID'),'');");
        script.Append("var _URL = '../srfmessage/msgeditview.jsp?MESSAGEID='+_MSGID+'&MSGMODE=TRANS';\r\n");
        script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        script.Append("}");
        return script.toString();
    }
}

