/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public abstract class BaseFormTBBHandler
implements ISRFExToolbarButtonHandler {
    protected static void RegisterFormStateChangeEvent(ToolbarButtonConfig config, SRFExWebContext webContext, String strAction) {
        String strToolbarId = webContext.GetParamValue("%TOOLBARID%");
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            return;
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.mfhookevent[Ext.id()]=function(){");
        script.Append("$P.mainform._MGR.on('statechanged',function(){");
        script.Append("var _2=$P.toolbar['%1$s'].items.get('%2$s');if(_2){", (Object)strToolbarId, (Object)config.getID());
        script.Append("if($P.mainform._MGR.getstate('%1$s')){_2.enable();}else{_2.disable();}", (Object)strAction.toLowerCase());
        script.Append("}});};\r\n");
        webContext.getPage().RegisterOnReadyScript(1, script.toString());
    }
}

