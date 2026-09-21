/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExMenuHandler;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;

public class SRFExBaseTreeMenuHandler
implements ISRFExMenuHandler {
    @Override
    public String getJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        return this.OnGetJSCode(config, webContext, (SRFExTreePanel)obj);
    }

    protected String OnGetJSCode(MenuItemExConfig config, SRFExWebContext webContext, SRFExTreePanel treePanel) {
        return "";
    }
}

