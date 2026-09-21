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

public class DateColumnEditor
extends SRFExDataGridBaseEditor {
    protected DataGridColumnEditorConfig dataGridColumnEditorConfig = null;
    private static final Log log = LogFactory.getLog(DateColumnEditor.class);
    protected boolean bInitListItem = false;

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridColumnEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridColumnEditorConfig ? this.baseConfig : null;
    }

    protected String OnRenderJSCode() {
        if (this.dataGridColumnEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("%1$s = new Ext.form.ComboBox ({editable:false});\r\n", (Object)"_GRIDEDITOR");
        script.Append("$P.picker['%2$s'] = %1$s;\r\n", (Object)"_GRIDEDITOR", (Object)this.getUniqueID());
        script.Append("%1$s.onTriggerClick = function(_1){", (Object)"_GRIDEDITOR");
        script.Append("var elid=$P.picker['%1$s'].el.dom.id;", (Object)this.getUniqueID());
        boolean bDayEnable = this.dataGridColumnEditorConfig.GetExtValue("DAYENABLE", true);
        boolean bHourEnable = this.dataGridColumnEditorConfig.GetExtValue("HOURENABLE", false);
        boolean bMinuteEnable = this.dataGridColumnEditorConfig.GetExtValue("MINUTEENABLE", false);
        boolean bSecondEnable = this.dataGridColumnEditorConfig.GetExtValue("SECONDENABLE", false);
        if (!bDayEnable) {
            script.Append("WdatePicker({el:elid,dateFmt:'HH:mm:ss'});");
        } else if (bSecondEnable) {
            script.Append("WdatePicker({el:elid,dateFmt:'yyyy-MM-dd HH:mm:ss'});");
        } else if (bMinuteEnable) {
            script.Append("WdatePicker({el:elid,dateFmt:'yyyy-MM-dd HH:mm:00'});");
        } else if (bHourEnable) {
            script.Append("WdatePicker({el:elid,dateFmt:'yyyy-MM-dd HH:00:00'});");
        } else {
            script.Append("WdatePicker({el:elid,dateFmt:'yyyy-MM-dd'});");
        }
        script.Append("};");
        return script.toString();
    }
}

