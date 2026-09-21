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
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridSaveRowHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        StringBuilderEx script = new StringBuilderEx();
        GridSaveRowHandler.RegisterDataGridEditableChangeEvent((boolean)true, (ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        script.Append("function(_1,_2){");
        script.Append("if(!%1$s)return;", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
        script.Append("%1$s", (Object)DataGridJSHelper.getDataGridSaveRow((String)dataGrid.getUniqueID()));
        script.Append("}");
        return script.toString();
    }
}

