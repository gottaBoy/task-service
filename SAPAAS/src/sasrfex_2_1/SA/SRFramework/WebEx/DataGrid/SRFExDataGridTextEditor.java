/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridTextEditorConfig;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;

public class SRFExDataGridTextEditor
extends SRFExDataGridBaseEditor {
    protected DataGridTextEditorConfig dataGridTextEditorConfig = null;

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridTextEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridTextEditorConfig ? (DataGridTextEditorConfig)this.baseConfig : null;
    }

    public DataGridTextEditorConfig getTextEditorConfig() {
        return this.dataGridTextEditorConfig;
    }

    @Override
    protected String OnRenderJSCode() {
        if (this.dataGridTextEditorConfig == null) {
            return "";
        }
        if (this.dataGridTextEditorConfig.isMultiLine()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("%1$s = new Ext.form.TriggerField({ allowBlank: %2$s , defaultAutoCreate : {tag: \"textarea\",style:\"height:22px\"}});\r\n", "_GRIDEDITOR", this.dataGridTextEditorConfig.getAllowEmpty() ? "true" : "false");
            script.Append("$P.picker['%2$s'] = %1$s;\r\n", "_GRIDEDITOR", this.getUniqueID());
            script.Append("%1$s.onTriggerClick = function(_1){", "_GRIDEDITOR");
            script.Append(BrowserJSHelper.getShowDialogScript(null, "'../srfcommon/textareapage.jsp'", StringHelper.Format((String)"$P.picker['%1$s'].getRawValue()", (Object)this.getUniqueID()), 700, 500, "no", "no", "no"));
            script.Append("var _ret = 'cancel';\r\n");
            script.Append("if(_DIALOGRESULT&& _DIALOGRESULT.ret)\r\n ");
            script.Append("_ret =_DIALOGRESULT.ret; \r\n");
            script.Append("if(_ret=='ok'){");
            script.Append("var _value = $V(_DIALOGRESULT.value,'');");
            script.Append("$P.picker['%1$s'].setValue( _value);", this.getUniqueID());
            script.Append("$P.grid['%1$s'].stopEditing(false);", this.dataGrid.getUniqueID());
            script.Append("}else{");
            script.Append("$P.grid['%1$s'].stopEditing(true);", this.dataGrid.getUniqueID());
            script.Append("}");
            script.Append("};");
            return script.toString();
        }
        if (this.dataGridTextEditorConfig.getAllowEmpty()) {
            return StringHelper.Format((String)"%1$s = new Ext.form.TextField({ allowBlank: true });\r\n", (Object)"_GRIDEDITOR");
        }
        return StringHelper.Format((String)"%1$s = new Ext.form.TextField({ allowBlank: false });\r\n", (Object)"_GRIDEDITOR");
    }
}

