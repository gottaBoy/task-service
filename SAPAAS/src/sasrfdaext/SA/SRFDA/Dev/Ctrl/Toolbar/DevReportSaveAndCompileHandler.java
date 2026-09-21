/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Dev.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class DevReportSaveAndCompileHandler
extends BaseFormTBBHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        DevReportSaveAndCompileHandler.RegisterFormStateChangeEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (String)"CREATE");
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _F=$P.mainform;");
        script.Append("if(_F==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u4fdd\u5b58\u5e76\u7f16\u8bd1\u64cd\u4f5c');return;}\r\n");
        script.Append("_F.saveandclose=false;");
        script.Append("_F.save2({srfdevreport:'COMPILE'});");
        script.Append("}");
        return script.toString();
    }
}

