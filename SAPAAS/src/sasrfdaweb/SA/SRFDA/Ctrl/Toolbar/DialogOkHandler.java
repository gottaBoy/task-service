/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class DialogOkHandler
implements ISRFExToolbarButtonHandler {
    public static final String TAG_JSCODE = "JSCODE";

    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        String strJSCode = config.GetExtValue(TAG_JSCODE, "");
        if (!StringHelper.IsNullOrEmpty((String)strJSCode)) {
            script.Append("if(!%1$s)return;", (Object)strJSCode);
        }
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        script.Append("}");
        return script.toString();
    }
}

