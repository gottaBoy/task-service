/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridReminderHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        GridReminderHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        int nWidth = 800;
        int nHeight = 600;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _URL='%1$s';\r\n", (Object)"../srfpage/simpleeditview.jsp?SRFPAGEID=PAGE_WF0015_E002&SRFDEID=WF0015&SRFDERID=DER1N_WFREMINDER_WFSTEPACTORID&SRFPDEID=WF0006&SRFNEWDATA=TRUE&");
        script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
        script.Append("_URL += Ext.urlEncode(_1);\r\n");
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
        script.Append("}");
        return script.toString();
    }
}

