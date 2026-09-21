/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class FormViewWFStepActorHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        FormViewWFStepActorHandler.RegisterFormStateChangeEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (String)"WFVIEWSTEPACTOR");
        SRFDAPageEx page = (SRFDAPageEx)webContext.getPage();
        String strWFStepActorGridPageId = webContext.getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
        Page p = page.getDAModelStorage().FindPage(strWFStepActorGridPageId);
        if (p == null) {
            page.OutputAlertMsg(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u9875\u9762[%1$s]", (Object)strWFStepActorGridPageId), false);
            return "";
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _F=$P.mainform;");
        script.Append("if(_F==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u7ee7\u7eed\u64cd\u4f5c');return;}\r\n");
        script.Append("var A=Ext.apply({DEID:'%1$s',SRFPDEID:'%1$s'},_F.getkeys());", (Object)page.getDEHelper().getId());
        script.Append("var B='%1$s'+Ext.urlEncode(A);", (Object)URLHelper.AppendURLSeperator((String)p.GetTotalPagePath()));
        script.Append("SRFUtility.showmodaldialog(B,{},'resizable:no;scroll:no;status:no;',800,480);");
        script.Append("}");
        return script.toString();
    }
}

