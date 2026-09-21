/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;

public class ToolbarSpaceConfig
extends BaseToolbarItemConfig {
    public static String TAG_TOOLBARSPACE = "SRFEXTOOLBARSPACE";

    @Override
    protected String OnGetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        return "' '";
    }
}

