/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;

public class GridRemoveByQueryHandler
extends SRFExBaseDataGridTBBHandler
implements ISRFExToolbarMenuHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.store['%1$s'].lastOptions==null){alert('\u5f53\u524d\u8fd8\u672a\u8fdb\u884c\u67e5\u8be2\uff0c\u8bf7\u5148\u67e5\u8be2\u518d\u6267\u884c\u64cd\u4f5c!');return;}\r\n", (Object)dataGrid.getUniqueID());
        script.Append(" if (!confirm('\u786e\u5b9e\u8981\u5220\u9664\u7b26\u5408\u67e5\u8be2\u6761\u4ef6\u7684\u6570\u636e\uff1f\u6570\u636e\u5220\u9664\u5c06\u4e0d\u53ef\u6062\u590d\uff01 ')) { return; }\r\n");
        script.Append("$P.grid['%1$s'].gridmgr.customcall2($P.store['%1$s'].lastOptions.params,'REMOVEBYQUERY','\u5220\u9664\u5f53\u524d\u67e5\u8be2\u6570\u636e');\r\n", (Object)dataGrid.getUniqueID());
        script.Append("}");
        return script.toString();
    }

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        if (obj != null && obj instanceof SRFExDataGrid) {
            SRFExDataGrid dataGrid = (SRFExDataGrid)obj;
            script.Append("if($P.store['%1$s'].lastOptions==null){alert('\u5f53\u524d\u8fd8\u672a\u8fdb\u884c\u67e5\u8be2\uff0c\u8bf7\u5148\u67e5\u8be2\u518d\u6267\u884c\u64cd\u4f5c!');return;}\r\n", (Object)dataGrid.getUniqueID());
            script.Append(" if (!confirm('\u786e\u5b9e\u8981\u5220\u9664\u7b26\u5408\u67e5\u8be2\u6761\u4ef6\u7684\u6570\u636e\uff1f\u6570\u636e\u5220\u9664\u5c06\u4e0d\u53ef\u6062\u590d\uff01 ')) { return; }\r\n");
            script.Append("$P.grid['%1$s'].gridmgr.customcall2($P.store['%1$s'].lastOptions.params,'REMOVEBYQUERY','\u5220\u9664\u5f53\u524d\u67e5\u8be2\u6570\u636e');\r\n", (Object)dataGrid.getUniqueID());
        }
        script.Append("}");
        return script.toString();
    }
}

