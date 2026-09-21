/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;

public class GridCustomCallHandler
extends SRFExBaseDataGridTBBHandler
implements ISRFExToolbarMenuHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        if (config.GetExtValue("HOOKEVENT", true)) {
            GridCustomCallHandler.RegisterDataGridSelecteEvent2((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        String strCallId = config.GetExtValue("CALLID", "");
        String strCallName = config.GetExtValue("CALLNAME", "");
        boolean bConfirm = config.GetExtValue("CONFIRM", true);
        String strCallParam = config.GetExtValue("CALLPARAM", "{}");
        String strCallJSCode = config.GetExtValue("CALLJSCODE", "");
        script.Append("var _P=%1$s;", (Object)strCallParam);
        if (!StringHelper.IsNullOrEmpty((String)strCallJSCode)) {
            script.Append(strCallJSCode);
        }
        script.Append("$P.grid['%1$s'].gridmgr.customcall(_P,'%2$s','%3$s',%4$s);\r\n", (Object)dataGrid.getUniqueID(), (Object)strCallId, (Object)strCallName, (Object)bConfirm);
        script.Append("}");
        return script.toString();
    }

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        if (obj != null && obj instanceof SRFExDataGrid) {
            SRFExDataGrid dataGrid = (SRFExDataGrid)obj;
            String strCallId = config.GetExtValue("CALLID", "");
            String strCallName = config.GetExtValue("CALLNAME", "");
            boolean bConfirm = config.GetExtValue("CONFIRM", true);
            String strCallParam = config.GetExtValue("CALLPARAM", "{}");
            String strCallJSCode = config.GetExtValue("CALLJSCODE", "");
            script.Append("var _P=%1$s;", (Object)strCallParam);
            if (!StringHelper.IsNullOrEmpty((String)strCallJSCode)) {
                script.Append(strCallJSCode);
            }
            script.Append("$P.grid['%1$s'].gridmgr.customcall(_P,'%2$s','%3$s',%4$s);\r\n", (Object)dataGrid.getUniqueID(), (Object)strCallId, (Object)strCallName, (Object)bConfirm, (Object)strCallParam);
        }
        script.Append("}");
        return script.toString();
    }
}

