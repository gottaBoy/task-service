/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridRefreshHandler
extends SRFExBaseDataGridTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("}");
        return script.toString();
    }
}

