/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExBaseTreeTBBHandler
implements ISRFExToolbarButtonHandler {
    @Override
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        return this.OnGetJSCode(config, webContext, (SRFExTreePanel)obj);
    }

    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExTreePanel treePanel) {
        return "";
    }
}

