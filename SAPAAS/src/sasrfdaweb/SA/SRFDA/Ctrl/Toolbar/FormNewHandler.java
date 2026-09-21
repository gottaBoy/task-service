/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormNewHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        FormNewHandler.RegisterFormStateChangeEvent(config, webContext, "CREATE");
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("if($P.mainform == null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u65b0\u5efa\u64cd\u4f5c');return;}\r\n");
        script.Append("$P.mainform.newdata();");
        script.Append("}");
        return script.toString();
    }
}

