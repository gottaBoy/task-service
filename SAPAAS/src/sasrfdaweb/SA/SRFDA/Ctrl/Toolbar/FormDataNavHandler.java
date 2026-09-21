/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormDataNavHandler
implements ISRFExToolbarButtonHandler {
    public static final String TAG_NAVACTION = "NAVACTION";
    public static final String TAG_NAVACTION_FIRST = "FIRST";
    public static final String TAG_NAVACTION_PREV = "PREV";
    public static final String TAG_NAVACTION_NEXT = "NEXT";
    public static final String TAG_NAVACTION_LAST = "LAST";

    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        String strAction = config.GetExtValue(TAG_NAVACTION, "");
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("navdata('%1$s');\r\n", (Object)strAction);
        script.Append("}");
        return script.toString();
    }
}

