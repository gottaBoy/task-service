/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExBaseDGExTBBHandler
implements ISRFExToolbarButtonHandler {
    @Override
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        if (obj != null && obj instanceof SRFExDGEx) {
            return this.OnGetJSCode(config, webContext, (SRFExDGEx)obj);
        }
        return "";
    }

    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDGEx dgEx) {
        return "";
    }
}

