/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.Web.ListItemCollection
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.ListItemCollection;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridComboEditorConfig;
import SA.SRFramework.WebEx.UI.ListFillerConfig;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDataGridComboEditor
extends SRFExDataGridBaseEditor {
    protected DataGridComboEditorConfig dataGridComboEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDataGridComboEditor.class);
    protected boolean bInitListItem = false;

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridComboEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridComboEditorConfig ? (DataGridComboEditorConfig)this.baseConfig : null;
    }

    public DataGridComboEditorConfig getComboEditorConfig() {
        return this.dataGridComboEditorConfig;
    }

    @Override
    protected String OnRenderHTMLCode() {
        if (this.dataGridComboEditorConfig == null) {
            return super.OnRenderHTMLCode();
        }
        this.InitListItems();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("<select name=\"%1$s\" id=\"%1$s\" style=\"display: none;\">", this.getUniqueID());
        int nListCount = this.getListItems().size();
        int i = 0;
        while (i < nListCount) {
            ListItem tempItem = this.getListItems().Get(i);
            script.Append("<option value=\"%1$s\">%2$s</option>", tempItem.getValue(), tempItem.getText());
            ++i;
        }
        script.Append("</select>");
        return script.toString();
    }

    @Override
    protected String OnRenderJSCode() {
        if (this.dataGridComboEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("%1$s = new Ext.form.ComboBox({typeAhead:true,triggerAction:'all',transform:'%2$s',lazyRender:true,listClass:'x-combo-list-small'", "_GRIDEDITOR", this.getUniqueID());
        if (!this.dataGridComboEditorConfig.isForceSelection()) {
            script.Append(",forceSelection:false");
        }
        script.Append("});\r\n");
        String strValueField = this.dataGridComboEditorConfig.getValueField();
        if (StringHelper.Length((String)strValueField) > 0) {
            script.Append("%1$s.on('select',function(_1,_2,_3){if(_2){\r\n", "_GRIDEDITOR");
            script.Append("_1.setValue(_2.get('text'));");
            script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('value'));\r\n", strValueField.toLowerCase(), this.dataGrid.getUniqueID());
            script.Append("}});", strValueField.toLowerCase(), this.dataGrid.getUniqueID());
        }
        return script.toString();
    }

    protected void InitListItems() {
        ListFillerConfig listFillerConfig;
        if (this.bInitListItem) {
            return;
        }
        this.bInitListItem = true;
        if (this.dataGridComboEditorConfig != null && (listFillerConfig = this.dataGridComboEditorConfig.getListFillerConfig()) != null) {
            ArrayList list;
            CodeListConfig codeListConfig;
            if (StringHelper.Length((String)listFillerConfig.getCodeList()) > 0 && (codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(listFillerConfig.getCodeList(), this.getWebContext().getLocalization())) != null && (list = codeListConfig.getCodeItems()) != null) {
                int i = 0;
                while (i < list.size()) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)list.get(i));
                    this.dataGridComboEditorConfig.getListItems().Add(new ListItem(codeItemConfig.getText(), codeItemConfig.getValue()));
                    ++i;
                }
            }
            if (listFillerConfig.getEmptySupported()) {
                ListItem listItem = new ListItem(listFillerConfig.getEmptyText(), "");
                if (listFillerConfig.getEmptyAtFirst()) {
                    this.dataGridComboEditorConfig.getListItems().Insert(0, listItem);
                } else {
                    this.dataGridComboEditorConfig.getListItems().Add(listItem);
                }
            }
        }
    }

    public ListItemCollection getListItems() {
        if (this.dataGridComboEditorConfig == null) {
            return null;
        }
        return this.dataGridComboEditorConfig.getListItems();
    }
}

