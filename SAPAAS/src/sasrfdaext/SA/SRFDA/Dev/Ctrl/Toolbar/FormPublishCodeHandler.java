/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler
 *  SA.SRFDA.Web.SRFDAWebUtil
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFDA.Dev.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFDA.Web.SRFDAWebUtil;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import javax.servlet.jsp.PageContext;

public class FormPublishCodeHandler
extends BaseFormTBBHandler
implements ISRFExToolbarMenuHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        return this.OutputJSCode((XMLConfig)config, webContext, obj);
    }

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        return this.OutputJSCode((XMLConfig)config, webContext, obj);
    }

    protected String OutputJSCode(XMLConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.mainform==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u53d1\u5e03\u64cd\u4f5c');return;}\r\n");
        script.Append("if(!$P.mainform.haskeys()){alert('\u8bf7\u5148\u4fdd\u5b58\u5f53\u524d\u6570\u636e\u518d\u6267\u884c\u53d1\u5e03\u64cd\u4f5c');return;}\r\n");
        script.Append("var A=$P.mainform.getkeys();");
        script.Append("var C='';for(B in A){C=A[B];break;} A.srfdakeys=C;");
        script.Append("A.codetype='%1$s';", (Object)config.GetExtValue("CODETYPE", ""));
        script.Append(SRFDAWebUtil.OutputOpenModalPageJSCode((PageContext)webContext.getPage().getPageContext(), (String)"PAGE_00025", (String)"ret", (String)"A"));
        script.Append("}");
        return script.toString();
    }
}

