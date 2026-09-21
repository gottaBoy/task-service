/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class GridReminderHisHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        GridReminderHisHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        int nWidth = 800;
        int nHeight = 600;
        String strURL = "";
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        String strReminderHisPageId = "PAGE_WF0015_G001";
        Page reminderHisPage = ((ISRFDAWebContext)webContext).getGlobalHelper().getDAModelStorage().FindPage(strReminderHisPageId);
        if (reminderHisPage == null) {
            daPage.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strReminderHisPageId));
            return "";
        }
        if (!StringHelper.IsNullOrEmpty((String)reminderHisPage.GetTotalPagePath())) {
            strURL = reminderHisPage.GetTotalPagePath();
        }
        if (reminderHisPage.getWIDTH() != 0) {
            nWidth = reminderHisPage.getWIDTH();
        }
        if (reminderHisPage.getHEIGHT() != 0) {
            nHeight = reminderHisPage.getHEIGHT();
        }
        if (!StringHelper.IsNullOrEmpty((String)reminderHisPage.getWINDOWSTYLE())) {
            strWindowStyle = reminderHisPage.getWINDOWSTYLE();
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _URL='%1$s';\r\n", (Object)strURL);
        script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
        script.Append("_URL += Ext.urlEncode(_1);\r\n");
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
        script.Append(DataGridJSHelper.getDataReloadScript((String)dataGrid.getUniqueID()));
        script.Append("}");
        return script.toString();
    }
}

