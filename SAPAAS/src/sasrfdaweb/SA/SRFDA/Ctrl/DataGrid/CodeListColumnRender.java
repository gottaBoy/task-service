/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeListColumnRender
extends SRFDADataGridColumnRender {
    private static final Log log = LogFactory.getLog(CodeListColumnRender.class);

    @Override
    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        String strCodeList = baseConfig.GetExtValue("CODELIST", "");
        if (StringHelper.IsNullOrEmpty((String)strCodeList)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u914d\u7f6e");
            return "return value;";
        }
        CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(strCodeList, webContext.getLocalization());
        if (codeListConfig == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)strCodeList));
            return "return value;";
        }
        StringBuilderEx script = new StringBuilderEx();
        this.AppendCodeItemConfigCode(script, (CodeItemConfig)codeListConfig);
        script.Append("return '%1$s';", (Object)codeListConfig.getEmptyText());
        return script.toString();
    }

    protected void AppendCodeItemConfigCode(StringBuilderEx script, CodeItemConfig codeItemConfig) {
        if (codeItemConfig.getCodeItems() == null) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            script.Append("if(value=='%1$s')return '%2$s';\r\n", (Object)childItemConfig.getValue(), (Object)childItemConfig.getTextWithStyle());
            this.AppendCodeItemConfigCode(script, childItemConfig);
            ++i;
        }
    }
}

