/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class HelpHandler
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        SRFDAWebContext daWebContext = (SRFDAWebContext)webContext;
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        String strDEId = daWebContext.getSRFDEID();
        String strPageId = daWebContext.getSRFPageId();
        String strPageType = config.GetExtValue("PAGETYPE", "");
        TreeMap<String, String> urlParams = new TreeMap<String, String>();
        urlParams.put("DEID", strDEId);
        urlParams.put("PAGEID", strPageId);
        urlParams.put("PAGETYPE", strPageType);
        urlParams.put("HELPITEMID", daWebContext.getPage().getPageParam("PAGE.HELPITEM", ""));
        script.Append("var _URL='../srfpage/helpdocview.jsp?%1$s';", (Object)URLHelper.GetQueryString(urlParams));
        script.Append("if(Ext.isFunction($P.help)){_URL=$P.help(_URL);if(_URL==undefined||_URL=='')return;}");
        script.Append("%1$s;", (Object)BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"", (String)"'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0'", (boolean)false, (int)900, (int)640));
        script.Append("}");
        return script.toString();
    }
}

