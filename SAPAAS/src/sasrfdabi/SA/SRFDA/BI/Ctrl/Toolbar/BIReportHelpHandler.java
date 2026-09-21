/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.BI.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class BIReportHelpHandler
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        TreeMap<String, String> urlParams = new TreeMap<String, String>();
        urlParams.put("BIREPORTID", webContext.GetParamValue("BIREPORTID"));
        script.Append("var _URL='../srfbiui2/bireporthelpview.jsp?%1$s';", (Object)URLHelper.GetQueryString(urlParams));
        script.Append("%1$s;", (Object)BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"", (String)"'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0'", (boolean)false, (int)900, (int)640));
        script.Append("}");
        return script.toString();
    }
}

