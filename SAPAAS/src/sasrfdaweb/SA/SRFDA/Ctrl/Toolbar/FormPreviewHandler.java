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

public class FormPreviewHandler
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.mainform == null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u9884\u89c8');return;}\r\n");
        int nWidth = 980;
        int nHeight = 680;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        script.Append("var _URL = '../srfda/formpreview.jsp?';\r\n");
        script.Append("var _1= $P.mainform.getkeys();\r\n");
        script.Append("_URL += Ext.urlEncode(_1);\r\n");
        script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        script.Append("}");
        return script.toString();
    }
}

