/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDGExTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDGExTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;

public class DGExExportExcelHandler
extends SRFExBaseDGExTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDGEx dgEx) {
        StringBuilderEx script = new StringBuilderEx();
        String strMaxRow = config.GetExtValue("MAXROW", "1000");
        String strExportType = config.GetExtValue("EXPORTTYPE", "");
        script.Append("function(_1,_2){");
        script.Append("if(!$P.store['%1$s'].lastOptions){alert('\u8bf7\u5148\u641c\u7d22\u6570\u636e\u518d\u70b9\u51fb\u5bfc\u51fa');return;}", (Object)dgEx.getUniqueID());
        script.Append("var param={};Ext.apply(param,$P.store['%1$s'].lastOptions.params);", (Object)dgEx.getUniqueID());
        if (!StringHelper.IsNullOrEmpty((String)strExportType)) {
            script.Append("param.exporttype='%1$s';", (Object)strExportType);
        }
        script.Append("$P.gridex['%1$s'].exportexcel(param,'%2$s');", (Object)dgEx.getUniqueID(), (Object)strMaxRow);
        script.Append("}");
        return script.toString();
    }
}

