/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.THGroup
 *  SA.SRFDA.Ctrl.Data.Threshold
 *  SA.SRFDA.Ctrl.DataGrid.CodeListColumnRender
 *  SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.THGroup;
import SA.SRFDA.Ctrl.Data.Threshold;
import SA.SRFDA.Ctrl.DataGrid.CodeListColumnRender;
import SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThresholdColumnRender
extends SRFDADataGridColumnRender {
    private static final Log log = LogFactory.getLog(CodeListColumnRender.class);

    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        String strTHGroupId = baseConfig.GetExtValue("THGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strTHGroupId)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u9600\u503c\u7ec4\u914d\u7f6e");
            return "return value;";
        }
        THGroup thGroup = webContext.getGlobalHelper().getDAModelStorage().FindTHGroup(strTHGroupId);
        if (thGroup == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9600\u503c\u7ec4[%1$s]", (Object)strTHGroupId));
            return "return value;";
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if(value=='')return value;");
        script.Append("var v1=parseFloat(value);if(v1==NaN)return value;");
        for (Threshold threshold : thGroup.getThresholds()) {
            script.Append("if(v1>=%1$s && v1 <%2$s){return '<span style=\"color:%3$s\">'+value+'</span>';}\r\n", (Object)Float.valueOf(threshold.getSTARTVALUE()), (Object)Float.valueOf(threshold.getENDVALUE()), (Object)threshold.getCOLOR(), (Object)threshold.getCOLOR());
        }
        script.Append("return value;");
        return script.toString();
    }
}

