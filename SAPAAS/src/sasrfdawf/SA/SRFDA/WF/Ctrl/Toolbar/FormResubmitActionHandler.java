/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class FormResubmitActionHandler
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        IDEHelper iDEHelper = daPage.getDEHelper();
        String strWFSTATE = config.GetExtValue("WFSTATE", "");
        String strWFSTEP = config.GetExtValue("WFSTEP", "");
        String strWFUSERACTIONNAME = config.GetExtValue("WFUSERACTIONNAME", "");
        String strWFPROCESSNAME = config.GetExtValue("WFPROCESSNAME", "");
        String strWFIAPAGE = "../srfwf/wfresubmitactionview.jsp";
        String strWFRESUBMIT = config.GetExtValue("WFRESUBMIT", "FALSE");
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iDEHelper.getId());
        daParams.put("SRFWFSTATE", strWFSTATE);
        daParams.put("SRFWFSTEP", strWFSTEP);
        daParams.put("SRFWFUSERACTIONNAME", strWFUSERACTIONNAME);
        daParams.put("SRFWFPROCESSNAME", strWFPROCESSNAME);
        daParams.put("SRFWFRESUBMIT", strWFRESUBMIT);
        String strWFStepActorId = webContext.GetParamValue("WFSTEPACTORID");
        if (!StringHelper.IsNullOrEmpty((String)strWFStepActorId)) {
            daParams.put("WFSTEPACTORID", strWFStepActorId);
        }
        strWFIAPAGE = URLHelper.AppendURLSeperator((String)strWFIAPAGE);
        String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strWFIAPAGE, (Object)URLHelper.GetQueryString(daParams));
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "'"), (String)"$P.keys", (int)800, (int)600, (String)"yes", (String)"no", (String)"no"));
        script.Append("if(_DIALOGRESULT && $V(_DIALOGRESULT.ret,'false')=='ok'){");
        script.Append("SRFUtility.refreshpdg();");
        script.Append("window.close();return ;");
        script.Append("}");
        script.Append("}");
        return script.toString();
    }
}

