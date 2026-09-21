/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridComboEditor
 *  SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridComboEditor;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeListColumnEditor
extends SRFExDataGridBaseEditor {
    protected DataGridColumnEditorConfig dataGridColumnEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDataGridComboEditor.class);
    protected boolean bInitListItem = false;

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridColumnEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridColumnEditorConfig ? this.baseConfig : null;
    }

    protected String OnRenderHTMLCode() {
        if (this.dataGridColumnEditorConfig == null) {
            return super.OnRenderHTMLCode();
        }
        String strCodeList = this.baseConfig.GetExtValue("CODELIST", "");
        if (StringHelper.IsNullOrEmpty((String)strCodeList)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u914d\u7f6e");
            return "";
        }
        boolean bEmtpy = this.baseConfig.GetExtValue("EMPTYENABLE", true);
        CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeList, this.getWebContext().getLocalization());
        if (codeListConfig == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)strCodeList));
            return "";
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("<select name=\"%1$s\" id=\"%1$s\" style=\"display: none;\">", (Object)this.getUniqueID());
        if (bEmtpy) {
            script.Append("<option value=\"%1$s\">%2$s</option>", (Object)"", (Object)codeListConfig.getEmptyText());
        }
        if (codeListConfig.getCodeItems() != null) {
            int nListCount = codeListConfig.getCodeItems().size();
            int i = 0;
            while (i < nListCount) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                script.Append("<option value=\"%1$s\">%2$s</option>", (Object)codeItemConfig.getValue(), (Object)codeItemConfig.getText());
                ++i;
            }
        }
        script.Append("</select>");
        return script.toString();
    }

    protected String OnRenderJSCode() {
        if (this.dataGridColumnEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("%1$s = new Ext.form.ComboBox({typeAhead:true,triggerAction:'all',transform:'%2$s',lazyRender:true,listClass:'x-combo-list-small'", (Object)"_GRIDEDITOR", (Object)this.getUniqueID());
        script.Append("});\r\n");
        return script.toString();
    }
}

