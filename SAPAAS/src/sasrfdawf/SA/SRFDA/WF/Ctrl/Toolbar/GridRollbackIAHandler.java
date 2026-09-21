/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class GridRollbackIAHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        boolean bSupportMulti = false;
        if (bSupportMulti) {
            GridRollbackIAHandler.RegisterDataGridSelecteEvent2((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        } else {
            GridRollbackIAHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        IDEHelper iDEHelper = daPage.getDEHelper();
        String strWFIAPAGE = "../srfwf/wfrollbackiaview.jsp";
        strWFIAPAGE = URLHelper.AppendURLSeperator((String)strWFIAPAGE);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", "WF0002");
        if (bSupportMulti) {
            script.Append(" if(!confirm('\u786e\u5b9e\u8981\u5bf9\u6570\u636e\\r\\n\\r\\n' +$P.grid['%1$s'].gridmgr.getcheckedrows2('srfdamajortext')+'\\r\\n\\r\\n\u6267\u884c [%2$s] \u64cd\u4f5c\u5417?'))return;", (Object)dataGrid.getUniqueID(), (Object)"\u6d41\u7a0b\u64a4\u56de\u64cd\u4f5c");
        } else {
            script.Append(" if(!confirm('\u786e\u5b9e\u8981\u5bf9\u6570\u636e\\r\\n\\r\\n' +$P.grid['%1$s'].gridmgr.getSelectedText()+'\\r\\n\\r\\n\u6267\u884c [%2$s] \u64cd\u4f5c\u5417?'))return;", (Object)dataGrid.getUniqueID(), (Object)"\u6d41\u7a0b\u64a4\u56de\u64cd\u4f5c");
        }
        String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strWFIAPAGE, (Object)URLHelper.GetQueryString(daParams));
        if (bSupportMulti) {
            script.Append("var keys = $P.grid['%1$s'].gridmgr.getcheckedrows2($P.grid['%1$s'].gridmgr.KEYS[0]);\r\n", (Object)dataGrid.getUniqueID());
        } else {
            script.Append("var keys = $P.grid['%1$s'].gridmgr.getSelected().get('wfinstanceid');\r\n", (Object)dataGrid.getUniqueID());
        }
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "'"), (String)"keys", (int)800, (int)600, (String)"yes", (String)"no", (String)"no"));
        script.Append("if(_DIALOGRESULT && $V(_DIALOGRESULT.ret,'false')=='ok'){");
        script.Append("SRFUtility.refreshdg();");
        script.Append("return ;");
        script.Append("}");
        script.Append("}");
        return script.toString();
    }
}

