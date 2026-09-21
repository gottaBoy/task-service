/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseTreeTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExTreeRefreshTBBHandler
extends SRFExBaseTreeTBBHandler {
    @Override
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExTreePanel treePanel) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(TreeJSHelper.getTreeReloadEx(treePanel.getUniqueID()));
        script.Append("}");
        return script.toString();
    }
}

