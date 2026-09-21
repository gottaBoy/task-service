/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.CAL.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormCalSeqHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        FormCalSeqHandler.RegisterFormFilledEvent(config, webContext);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){var F=$P.mainform;");
        script.Append("var varCalSeqId=F.G(F._UID['calseqid']);\r\n");
        script.Append("if(varCalSeqId==''){varCalSeqId=F.G(F._UID['calendarid']);}\r\n");
        script.Append("if(varCalSeqId==''){return;}\r\n");
        script.Append("var urlparams = { CALENDARID:varCalSeqId,SRFDERID:'DE0050_DE0120_CALENDARID' };\r\n");
        script.Append("var _URL ='../srfcalendar/calseqmgrview.jsp?' + Ext.urlEncode(urlparams);\r\n");
        script.Append("var ret = SRFUtility.showmodaldialog(_URL, {},'resizable:no;scroll:no;status:no;', 640, 480);\r\n");
        script.Append("}");
        return script.toString();
    }

    protected static void RegisterFormFilledEvent(ToolbarButtonConfig config, SRFExWebContext webContext) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var F=$P.mainform;if(F){\r\n");
        script.Append("F._MGR.on('filled',function(){\r\n");
        script.Append("var varCalSeqId=F.G(F._UID['calseqid']);\r\n");
        script.Append("});}\r\n");
        webContext.getPage().RegisterOnReadyScript(3, script.toString());
    }
}

