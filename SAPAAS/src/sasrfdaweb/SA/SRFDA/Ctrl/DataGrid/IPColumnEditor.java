/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor
 *  SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IPColumnEditor
extends SRFExDataGridBaseEditor {
    private static final Log log = LogFactory.getLog(IPColumnEditor.class);
    protected DataGridColumnEditorConfig dataGridColumnEditorConfig = null;
    protected boolean bInitListItem = false;

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridColumnEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridColumnEditorConfig ? this.baseConfig : null;
    }

    protected String OnRenderHTMLCode() {
        return super.OnRenderHTMLCode();
    }

    protected String OnRenderJSCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("");
        script.Append("%1$s = new Ext.form.ComboBox({typeAhead:true,hideTrigger:true,triggerAction:'all',lazyRender:true,listClass:'x-combo-list-small'", (Object)"_GRIDEDITOR", (Object)this.getUniqueID());
        script.Append(",store:[]");
        script.Append("});\r\n");
        script.Append("%1$s.on('focus',function(_1){_1.setRawValue(SRFUtility.long2ip(_1.getValue()));});", (Object)"_GRIDEDITOR");
        script.Append("%1$s.on('blur',function(_1){if(_1.startValue != _1.getValue()){_1.setValue(SRFUtility.ip2long(_1.getRawValue()));}});", (Object)"_GRIDEDITOR");
        return script.toString();
    }
}

