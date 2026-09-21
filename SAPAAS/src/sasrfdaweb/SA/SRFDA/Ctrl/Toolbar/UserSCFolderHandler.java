/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebUtil
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseTreeTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Web.SRFDAWebUtil;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseTreeTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import javax.servlet.jsp.PageContext;

public class UserSCFolderHandler
extends SRFExBaseTreeTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExTreePanel treePanel) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(SRFDAWebUtil.OutputOpenModelPageJSCode((PageContext)webContext.getPage().getPageContext(), (String)"PAGE_DE0062_G001", (String)"", (String)"{}"));
        script.Append("}");
        return script.toString();
    }
}

