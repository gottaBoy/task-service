/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormPrintHandler
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.mainform == null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u6253\u5370');return;}\r\n");
        script.Append("if(!$P.mainform.haskeys()){alert('\u8868\u5355\u4e0d\u5b58\u5728\u6709\u6548\u6570\u636e\uff0c\u65e0\u6cd5\u6253\u5370');return;}");
        script.Append("var _URL='../srfreport/printform.jsp?SRFDEID=%1$s&'+Ext.urlEncode($P.mainform.getkeys());", (Object)webContext.GetParamValue("SRFDEID"));
        if (webContext.getWebExConfig().GetValue("SRFDA", "PRINTWINDOWPOPUPMODE", false)) {
            script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"", (int)900, (int)650, (String)"yes", (String)"no", (String)"no"));
        } else {
            script.Append(BrowserJSHelper.getShowWindowScript((String)"_URL", (String)"", (String)"'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0,width=930,height=670'", (boolean)false));
        }
        script.Append("}");
        return script.toString();
    }
}

