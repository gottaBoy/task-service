/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebContext
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

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class GridIAActionHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        Page page;
        boolean bSupportMulti;
        boolean bl = bSupportMulti = StringHelper.Compare((String)config.GetExtValue("WFSUPPORTMULTI", "TRUE"), (String)"TRUE", (boolean)true) == 0;
        if (bSupportMulti) {
            GridIAActionHandler.RegisterDataGridSelecteEvent2((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        } else {
            GridIAActionHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        String strIAActionName = config.GetExtValue("WFIAACTIONLOGICNAME", "");
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        IDEHelper iDEHelper = daPage.getDEHelper();
        String strWFSTATE = config.GetExtValue("WFSTATE", "");
        String strWFSTEP = config.GetExtValue("WFSTEP", "");
        String strWFIAACTIONNAME = config.GetExtValue("WFIAACTIONNAME", "");
        String strWFPROCESSNAME = config.GetExtValue("WFPROCESSNAME", "");
        String strWFFORMNAME = config.GetExtValue("WFFORMNAME", "");
        String strWFIAPAGE = config.GetExtValue("WFIAPAGE", "");
        String strWFFAHELPER = config.GetExtValue("WFFAHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strWFIAPAGE)) {
            strWFIAPAGE = "../srfwf/wfiaactionview.jsp";
        } else if (strWFIAPAGE.indexOf(".jsp") == -1 && (page = ((SRFDAWebContext)webContext).getGlobalHelper().getDAModelStorage().FindPage(strWFIAPAGE)) != null) {
            strWFIAPAGE = page.GetTotalPagePath();
        }
        strWFIAPAGE = URLHelper.AppendURLSeperator((String)strWFIAPAGE);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iDEHelper.getId());
        daParams.put("SRFWFSTATE", strWFSTATE);
        daParams.put("SRFWFSTEP", strWFSTEP);
        daParams.put("SRFWFIAACTIONNAME", strWFIAACTIONNAME);
        daParams.put("SRFWFPROCESSNAME", strWFPROCESSNAME);
        daParams.put("SRFWFFORMNAME", strWFFORMNAME);
        daParams.put("WFFAHELPER", strWFFAHELPER);
        String strDESubWFId = webContext.GetParamValue("SRFDESUBWFID");
        if (!StringHelper.IsNullOrEmpty((String)strDESubWFId)) {
            daParams.put("SRFDESUBWFID", strDESubWFId);
            String strSubWFStep = webContext.GetParamValue("SRFWFSUBSTEP");
            daParams.put("SRFWFSUBSTEP", strSubWFStep);
        }
        if (bSupportMulti) {
            script.Append(" if(!confirm('\u786e\u5b9e\u8981\u5bf9\u6570\u636e\\r\\n\\r\\n' +$P.grid['%1$s'].gridmgr.getcheckedrows2('srfdamajortext')+'\\r\\n\\r\\n\u6267\u884c [%2$s] \u64cd\u4f5c\u5417?'))return;", (Object)dataGrid.getUniqueID(), (Object)strIAActionName);
        } else {
            script.Append(" if(!confirm('\u786e\u5b9e\u8981\u5bf9\u6570\u636e\\r\\n\\r\\n' +$P.grid['%1$s'].gridmgr.getSelectedText()+'\\r\\n\\r\\n\u6267\u884c [%2$s] \u64cd\u4f5c\u5417?'))return;", (Object)dataGrid.getUniqueID(), (Object)strIAActionName);
        }
        String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strWFIAPAGE, (Object)URLHelper.GetQueryString(daParams));
        if (bSupportMulti) {
            script.Append("var keys = $P.grid['%1$s'].gridmgr.getcheckedrows2($P.grid['%1$s'].gridmgr.KEYS[0]);\r\n", (Object)dataGrid.getUniqueID());
        } else {
            script.Append("var keys = $P.grid['%1$s'].gridmgr.getSelectedKey();\r\n", (Object)dataGrid.getUniqueID());
        }
        if (StringHelper.IsNullOrEmpty((String)strWFFORMNAME)) {
            script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "'"), (String)"keys", (int)200, (int)100, (String)"yes", (String)"no", (String)"no"));
        } else {
            script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "'"), (String)"keys", (int)800, (int)600, (String)"yes", (String)"no", (String)"no"));
        }
        script.Append("if(_DIALOGRESULT && $V(_DIALOGRESULT.ret,'false')=='ok'){");
        script.Append("SRFUtility.refreshdg();");
        script.Append("return ;");
        script.Append("}");
        script.Append("}");
        return script.toString();
    }
}

