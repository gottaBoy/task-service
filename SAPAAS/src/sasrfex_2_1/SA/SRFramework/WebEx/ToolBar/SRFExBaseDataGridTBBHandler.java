/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class SRFExBaseDataGridTBBHandler
implements ISRFExToolbarButtonHandler {
    @Override
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        if (obj != null && obj instanceof SRFExDataGrid) {
            return this.OnGetJSCode(config, webContext, (SRFExDataGrid)obj);
        }
        return "";
    }

    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        return "";
    }

    protected static void RegisterDataGridSelecteEvent(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        String strEnableScript = StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').enable();", (Object)strToolbarId, (Object)config.getID());
        String strDisableScript = StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').disable();", (Object)strToolbarId, (Object)config.getID());
        StringBuilderEx script = new StringBuilderEx();
        script.Append(DataGridJSHelper.getOnRowSelectedEventScript(dataGrid.getUniqueID(), strEnableScript));
        script.Append(DataGridJSHelper.getOnRowSelectedCancelEventScript(dataGrid.getUniqueID(), strDisableScript));
        webContext.getPage().RegisterOnReadyScript(3, script.toString());
    }

    protected static void RegisterDataGridSelecteEvent2(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        String strEnableScript = StringHelper.Format((String)"var bEnable = (%1$s != 0);", (Object)DataGridJSHelper.getDataGridCheckedRowCount(dataGrid.getUniqueID()));
        strEnableScript = String.valueOf(strEnableScript) + StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').setDisabled(!bEnable);", (Object)strToolbarId, (Object)config.getID());
        StringBuilderEx script = new StringBuilderEx();
        script.Append(DataGridJSHelper.getOnRowSelectedCancelEventScript(dataGrid.getUniqueID(), strEnableScript));
        script.Append(DataGridJSHelper.getOnRowClickedEventScript(dataGrid.getUniqueID(), strEnableScript));
        script.Append(DataGridJSHelper.getOnRowCheckActionEventScript(dataGrid.getUniqueID(), strEnableScript));
        webContext.getPage().RegisterOnReadyScript(3, script.toString());
    }

    protected static void RegisterDataGridEditableChangeEvent(boolean bEnable, ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        String strEnableScript = StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').enable();", (Object)strToolbarId, (Object)config.getID());
        String strDisableScript = StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').disable();", (Object)strToolbarId, (Object)config.getID());
        StringBuilderEx script = new StringBuilderEx();
        String strToggleCode = StringHelper.Format((String)"if(%4$s%1$s){%2$s}else{%3$s}", (Object)DataGridJSHelper.getGetDataGridEditable(dataGrid.getUniqueID()), (Object)strEnableScript, (Object)strDisableScript, (Object)(bEnable ? "" : "!"));
        script.Append(strToggleCode);
        script.Append(DataGridJSHelper.getOnEditableChangeEventScript(dataGrid.getUniqueID(), strToggleCode));
        webContext.getPage().RegisterOnReadyScript(3, script.toString());
    }
}

