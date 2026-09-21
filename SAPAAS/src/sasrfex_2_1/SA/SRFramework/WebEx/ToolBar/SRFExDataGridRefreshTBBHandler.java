/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExDataGridRefreshTBBHandler
extends SRFExBaseDataGridTBBHandler {
    @Override
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("alert('aaaa');");
        script.Append("}");
        return script.toString();
    }
}

