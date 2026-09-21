/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.CAL.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormEditCalSeqHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        FormEditCalSeqHandler.RegisterFormFilledEvent(config, webContext);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var varCalSeqId=$P.mainform.getvalue($P.mainform._UID['calseqid']);\r\n");
        script.Append("if(varCalSeqId==''){varCalSeqId=$P.mainform.getvalue($P.mainform._UID['calendarid']);}\r\n");
        script.Append("if(varCalSeqId==''){return;}\r\n");
        script.Append("var _URL=window.location.href;\r\n");
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        IDEHelper iDEHelper = daPage.getDEHelper();
        script.Append("_URL+='&SEQMODE=TRUE';\r\n");
        script.Append("_URL+=('&%1$s='+varCalSeqId);\r\n", (Object)iDEHelper.GetKeyDEFHelper().getName());
        script.Append("window.location=_URL;\r\n");
        script.Append("}");
        return script.toString();
    }

    protected static void RegisterFormFilledEvent(ToolbarButtonConfig config, SRFExWebContext webContext) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if($P.mainform){\r\n");
        script.Append("$P.form[$P.mainform.formid].on('filled',function(){\r\n");
        script.Append("var varCalSeqId=$P.mainform.getvalue($P.mainform._UID['calseqid']);\r\n");
        script.Append("var btn=$P.toolbar['%1$s'].items.get('%2$s');\r\n", (Object)strToolbarId, (Object)config.getID());
        script.Append("if(btn){if(varCalSeqId!=''){btn.enable();}else{btn.disable();}}\r\n");
        script.Append("});}\r\n");
        webContext.getPage().RegisterOnReadyScript(3, script.toString());
    }
}

