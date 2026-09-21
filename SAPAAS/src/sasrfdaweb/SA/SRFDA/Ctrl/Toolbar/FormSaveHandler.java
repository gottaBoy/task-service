/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class FormSaveHandler
extends BaseFormTBBHandler {
    public static final String TAG_DATAACTION = "DATAACTION";

    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        String strDataAction = config.GetExtValue(TAG_DATAACTION, "UPDATE");
        if (!StringHelper.IsNullOrEmpty((String)strDataAction)) {
            FormSaveHandler.RegisterFormStateChangeEvent(config, webContext, strDataAction);
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _F=$P.mainform;");
        script.Append("if(_F==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u4fdd\u5b58\u64cd\u4f5c');return;}\r\n");
        boolean bSaveAndClose = config.GetExtValue("SAVEANDCLOSE", false);
        boolean bSaveAndNew = config.GetExtValue("SAVEANDNEW", false);
        script.Append("_F.saveandclose=%1$s;", (Object)(bSaveAndClose ? "true" : "false"));
        script.Append("_F.saveandnew=%1$s;", (Object)(bSaveAndNew ? "true" : "false"));
        script.Append("_F.save();");
        script.Append("}");
        return script.toString();
    }
}

