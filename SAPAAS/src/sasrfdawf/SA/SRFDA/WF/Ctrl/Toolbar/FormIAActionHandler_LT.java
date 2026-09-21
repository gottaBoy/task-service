/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class FormIAActionHandler_LT
implements ISRFExToolbarButtonHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        Page page;
        String strDESubWFId;
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        IDEHelper iDEHelper = daPage.getDEHelper();
        String strWFSTATE = config.GetExtValue("WFSTATE", "");
        String strWFSTEP = config.GetExtValue("WFSTEP", "");
        String strWFIAACTIONNAME = config.GetExtValue("WFIAACTIONNAME", "");
        String strWFPROCESSNAME = config.GetExtValue("WFPROCESSNAME", "");
        String strWFFORMNAME = config.GetExtValue("WFFORMNAME", "");
        String strWFIAPAGE = config.GetExtValue("WFIAPAGE", "");
        String strWFFAHELPER = config.GetExtValue("WFFAHELPER", "");
        String strWFIAACTIONS = config.GetExtValue("WFIAACTIONS", "");
        boolean bEnableSave = config.GetExtValue("WFENABLESAVE", false);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iDEHelper.getId());
        daParams.put("SRFWFSTATE", strWFSTATE);
        daParams.put("SRFWFSTEP", strWFSTEP);
        daParams.put("SRFWFPROCESSNAME", strWFPROCESSNAME);
        daParams.put("SRFWFFORMNAME", strWFFORMNAME);
        String strWFStepActorId = webContext.GetParamValue("WFSTEPACTORID");
        if (!StringHelper.IsNullOrEmpty((String)strWFStepActorId)) {
            daParams.put("WFSTEPACTORID", strWFStepActorId);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strDESubWFId = webContext.GetParamValue("SRFDESUBWFID")))) {
            daParams.put("SRFDESUBWFID", strDESubWFId);
            String strSubWFStep = webContext.GetParamValue("SRFWFSUBSTEP");
            daParams.put("SRFWFSUBSTEP", strSubWFStep);
        }
        if (StringHelper.IsNullOrEmpty((String)strWFIAPAGE)) {
            strWFIAPAGE = "../srfwf/wfiaactionview.jsp";
        } else if (strWFIAPAGE.indexOf(".jsp") == -1 && (page = ((SRFDAWebContext)webContext).getGlobalHelper().getDAModelStorage().FindPage(strWFIAPAGE)) != null) {
            strWFIAPAGE = page.GetTotalPagePath();
        }
        strWFIAPAGE = URLHelper.AppendURLSeperator((String)strWFIAPAGE);
        String strURL = StringHelper.Format((String)"%1$s%2$s", (Object)strWFIAPAGE, (Object)URLHelper.GetQueryString(daParams));
        StringBuilderEx script = new StringBuilderEx();
        if (bEnableSave) {
            String strGUID = Helper.GenGuid();
            script.Append("function(_1){");
            script.Append("if(!($P.mainform)){alert('\u754c\u9762\u4e3b\u8868\u5355\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u6267\u884c\u64cd\u4f5c');return;}\r\n");
            script.Append("if(!($P.object['%1$s'])){", (Object)strGUID);
            script.Append("$P.form[$P.mainform.formid].on('saved',function(_FORM,_SAVETAG){");
            script.Append("if(_SAVETAG!='%1$s')return;\r\n", (Object)strGUID);
            script.Append("if($P.wfactions==''||$P.wfactions==undefined){");
            script.Append("$P.wfactions=%1$s;", (Object)strWFIAACTIONS);
            script.Append("showwfactionselwin();return;", (Object)strWFIAACTIONS);
            script.Append("}");
            script.Append("var up={};up.SRFWFIAACTIONNAME=$P.wfaction;up.WFDESC=$P.wfmemo;");
            if (StringHelper.IsNullOrEmpty((String)strWFFORMNAME)) {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "&'+Ext.urlEncode(up)"), (String)"$P.keys", (int)200, (int)100, (String)"yes", (String)"no", (String)"no"));
            } else {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "&'+Ext.urlEncode(up)"), (String)"$P.keys", (int)800, (int)600, (String)"yes", (String)"no", (String)"no"));
            }
            script.Append("if(_DIALOGRESULT && $V(_DIALOGRESULT.ret,'false')=='ok'){");
            script.Append("window.close();");
            script.Append("SRFUtility.refreshpdg();");
            script.Append("return ;");
            script.Append("}");
            script.Append("});\r\n");
            script.Append("$P.object['%1$s']=true;", (Object)strGUID);
            script.Append("}\r\n");
            script.Append("$P.mainform.save2({srfsavetag:'%1$s'});", (Object)strGUID);
            script.Append("}");
        } else {
            script.Append("function(_1){");
            script.Append("if($P.wfactions==''||$P.wfactions==undefined){");
            script.Append("$P.wfactions=%1$s;", (Object)strWFIAACTIONS);
            script.Append("showwfactionselwin();return;", (Object)strWFIAACTIONS);
            script.Append("}");
            script.Append("var up={};up.SRFWFIAACTIONNAME=$P.wfaction;up.WFDESC=$P.wfmemo;");
            if (StringHelper.IsNullOrEmpty((String)strWFFORMNAME)) {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "&'+Ext.urlEncode(up)"), (String)"$P.keys", (int)200, (int)100, (String)"yes", (String)"no", (String)"no"));
            } else {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)("'" + strURL + "&'+Ext.urlEncode(up)"), (String)"$P.keys", (int)800, (int)600, (String)"yes", (String)"no", (String)"no"));
            }
            script.Append("if(_DIALOGRESULT && $V(_DIALOGRESULT.ret,'false')=='ok'){");
            script.Append("window.close();");
            script.Append("SRFUtility.refreshpdg();");
            script.Append("return ;");
            script.Append("}");
            script.Append("}");
        }
        return script.toString();
    }
}

