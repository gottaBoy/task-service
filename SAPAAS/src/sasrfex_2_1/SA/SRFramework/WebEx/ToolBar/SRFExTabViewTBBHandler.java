/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseTabViewTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExTabViewTBBHandler
extends SRFExBaseTabViewTBBHandler {
    @Override
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExTabView tabView) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("$P.tabview['%1$s'].toolbarclick('%2$s');\r\n", tabView.getUniqueID(), config.GetExtValue("TABVIEWPAGEID", ""));
        script.Append("}");
        return script.toString();
    }
}

