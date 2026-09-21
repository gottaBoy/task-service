/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class GridPrintHandler
extends SRFExBaseDataGridTBBHandler {
    boolean bPrintWindowPopUpMode = false;
    String strMultiPrint = null;
    String strPrintDialogMode = "NONE";

    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        this.bPrintWindowPopUpMode = webContext.getWebExConfig().GetValue("SRFDA", "PRINTWINDOWPOPUPMODE", false);
        this.strMultiPrint = config.GetExtValue("MULTIPRINT", webContext.getWebExConfig().GetValue("SRFDA", "MULTIPRINT", "FALSE"));
        this.strPrintDialogMode = config.GetExtValue("PRINTDIALOGMODE", webContext.getWebExConfig().GetValue("SRFDA", "PRINTDIALOGMODE", "FALSE"));
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(this.AppendPrintModeJSCode(config, webContext, dataGrid));
        script.Append(this.AppendBrowserJSCode(config, webContext, dataGrid));
        script.Append("}");
        return script.toString();
    }

    protected String AppendBrowserJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        if (this.bPrintWindowPopUpMode) {
            return BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"", (int)900, (int)650, (String)"yes", (String)"no", (String)"no");
        }
        return BrowserJSHelper.getShowWindowScript((String)"_URL", (String)"", (String)"'resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0,width=930,height=670'", (boolean)false);
    }

    protected String AppendPrintModeJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        if (StringHelper.Compare((String)this.strMultiPrint, (String)"TRUE", (boolean)true) == 0) {
            return this.GetMultiplePrintModeJSCode(config, webContext, dataGrid);
        }
        return this.GetSinglePrintModeJSCode(config, webContext, dataGrid);
    }

    protected String GetMultiplePrintModeJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        GridPrintHandler.RegisterDataGridSelecteEvent2((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _KEYS= $P.grid['%1$s'].gridmgr.KEYS;", (Object)dataGrid.getUniqueID());
        script.Append("if(_KEYS==null||_KEYS==undefined||_KEYS.length==0){alert('\u8868\u683c\u4e3b\u952e\u672a\u5b9a\u4e49!');return;}", (Object)dataGrid.getUniqueID());
        script.Append("var _PARAMS= {};");
        script.Append("_PARAMS['PRINTMODE']='MULTIPLE';");
        script.Append("_PARAMS['PRINTDIALOGMODE']= '%1$s';", (Object)this.strPrintDialogMode);
        script.Append("_PARAMS[_KEYS[0]]= %1$s;", (Object)DataGridJSHelper.getDataGridCheckedRows((String)dataGrid.getUniqueID()));
        script.Append("var _URL='../srfreport/printform.jsp?SRFDEID=%1$s&'+Ext.urlEncode(_PARAMS);", (Object)webContext.GetParamValue("SRFDEID"));
        return script.toString();
    }

    protected String GetSinglePrintModeJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        GridPrintHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _K= %1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
        script.Append("var _URL='../srfreport/printform.jsp?SRFDEID=%1$s&'+Ext.urlEncode(_K);", (Object)webContext.GetParamValue("SRFDEID"));
        return script.toString();
    }
}

