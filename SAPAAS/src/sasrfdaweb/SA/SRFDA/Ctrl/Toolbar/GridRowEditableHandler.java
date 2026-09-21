/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridRowEditableHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        StringBuilderEx script = new StringBuilderEx();
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (!StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            String strToggleCode = StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(%3$s);", (Object)strToolbarId, (Object)config.getID(), (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
            script.Append(strToggleCode);
            script.Append(DataGridJSHelper.getOnEditableChangeEventScript((String)dataGrid.getUniqueID(), (String)strToggleCode));
            webContext.getPage().RegisterOnReadyScript(3, script.toString());
        }
        script.Reset();
        script.Append("function(_1,_2){");
        script.Append("var _1=%1$s;", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
        script.Append("%1$s", (Object)DataGridJSHelper.getSetDataGridEditable((String)dataGrid.getUniqueID(), (String)"!_1"));
        script.Append("}");
        return script.toString();
    }
}

