/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormRemoveHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        FormRemoveHandler.RegisterFormStateChangeEvent(config, webContext, "DELETE");
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.mainform==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u5220\u9664\u64cd\u4f5c');return;}\r\n");
        boolean bTempDataMode = SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)((SRFDAWebContext)webContext), (boolean)false);
        if (bTempDataMode) {
            script.Append("var _2=$P.mainform.G($P.mainform._UID['srfdatempkeyid']);if(_2=='')return;\r\n");
            script.Append("if(!confirm('\u786e\u5b9e\u8981\u5220\u9664\u5f53\u524d\u6570\u636e\uff1f'))return;");
            script.Append("$P.mainform.remove2(_2);");
        } else {
            script.Append("if(!$P.mainform.haskeys())return;\r\n");
            script.Append("if(!confirm('\u786e\u5b9e\u8981\u5220\u9664\u5f53\u524d\u6570\u636e\uff1f'))return;");
            script.Append("$P.mainform.remove();");
        }
        script.Append("}");
        return script.toString();
    }
}

