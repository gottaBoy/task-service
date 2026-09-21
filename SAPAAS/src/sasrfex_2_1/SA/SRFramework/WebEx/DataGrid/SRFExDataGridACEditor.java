/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridACEditorConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDataGridACEditor
extends SRFExDataGridBaseEditor {
    protected DataGridACEditorConfig dataGridACEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDataGridACEditor.class);

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridACEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridACEditorConfig ? (DataGridACEditorConfig)this.baseConfig : null;
    }

    public DataGridACEditorConfig getACEditorConfig() {
        return this.dataGridACEditorConfig;
    }

    @Override
    protected String OnRenderHTMLCode() {
        return super.OnRenderHTMLCode();
    }

    @Override
    protected String OnRenderJSCode() {
        String strACAfterSelectCode;
        int k;
        if (this.dataGridACEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        StringBuilderEx script = new StringBuilderEx();
        String strACDataURL = this.dataGridACEditorConfig.getACDataURL();
        if (StringHelper.Length((String)strACDataURL) == 0) {
            strACDataURL = this.getWebContext().getWebConfig().GetExtValue("AUTOCOMPLETE", "");
        }
        if (StringHelper.Length((String)strACDataURL) == 0) {
            log.error((Object)StringHelper.Format((String)"\u6587\u672c\u5bf9\u8c61[%1$s]\u5b9a\u4e49\u4e86\u81ea\u52a8\u5b8c\u6210\u6a21\u5f0f\uff0c\u7f3a\u4e4f\u6570\u636e\u6e90\u8def\u5f84", (Object)this.dataGridACEditorConfig.getID()));
            return "";
        }
        strACDataURL = URLHelper.AppendURLSeperator(strACDataURL);
        strACDataURL = String.valueOf(strACDataURL) + this.getWebContext().GetParamsString(this.dataGridACEditorConfig.getACAppendParams());
        if (!StringHelper.IsNullOrEmpty((String)this.dataGridACEditorConfig.getACAppendURLParams())) {
            strACDataURL = URLHelper.AppendURLSeperator(strACDataURL);
            strACDataURL = String.valueOf(strACDataURL) + this.dataGridACEditorConfig.getACAppendURLParams();
        }
        script.Append("var httpProxy = new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:30000,url:'%1$s'}));\r\n", strACDataURL);
        String strACFillParams = this.dataGridACEditorConfig.getACFillParams();
        if (StringHelper.Length((String)strACFillParams) > 0) {
            script.Append("var RecordDef = Ext.data.Record.create([{name: 'text'},{name: 'value'},{name: 'realtext'}");
            String[] list = strACFillParams.split("[|]");
            int k2 = 0;
            while (k2 < list.length) {
                script.Append(",{name: '%1$s'}", list[k2].toLowerCase());
                ++k2;
            }
            script.Append("]);\r\n");
        } else {
            script.Append("var RecordDef = Ext.data.Record.create([{name: 'text'},{name: 'value'},{name: 'realtext'}]);\r\n");
        }
        script.Append("var myReader = new Ext.data.JsonReader({ root: \"items\"}, RecordDef);\r\n");
        script.Append("var varStore = new Ext.data.Store({proxy:httpProxy,reader:myReader});\r\n");
        script.Append("varStore.userparams = {%1$s};\r\n", this.dataGridACEditorConfig.getACUserParams());
        script.Append("varStore.on('beforeload',onfillparams);\r\n");
        script.Append("function onfillparams(_T,_OP){\r\n");
        script.Append("_OP.params['acmode'] = '%1$s';\r\n", this.dataGridACEditorConfig.getACMode());
        script.Append("_OP.params['action'] = 'fetch';\r\n");
        script.Append("_OP.params['actiontype'] = 'autocompleteaction';\r\n");
        String strACParams = this.dataGridACEditorConfig.getACParams();
        if (StringHelper.Length((String)strACParams) > 0) {
            String[] list = strACParams.split("[|]");
            k = 0;
            while (k < list.length) {
                script.Append("_OP.params['%1$s'] = $V($P.grid['%2$s'].gridmgr.AR.get('%1$s'),'');\r\n", list[k].toLowerCase(), this.dataGrid.getUniqueID());
                ++k;
            }
        }
        script.Append("Ext.apply( _OP.params,_T.userparams);\r\n");
        script.Append("}\r\n");
        script.Append("var ac = new Ext.form.ComboBox({");
        script.Append("    store: varStore,");
        script.Append("    displayField:'text',");
        script.Append("    minChars:%1$s,", this.dataGridACEditorConfig.getACMinChars());
        script.Append("    typeAhead: false,");
        script.Append("   loadingText: '\u52a0\u8f7d...',");
        script.Append("   queryParam: 'acquery',");
        if (this.dataGridACEditorConfig.getACListWidth() > 0) {
            script.Append("   listWidth: %1$s,", this.dataGridACEditorConfig.getACListWidth());
        }
        if (this.dataGridACEditorConfig.getACForceSelection()) {
            script.Append("  forceSelection:true,");
        }
        if (this.dataGridACEditorConfig.getACHideTrigger()) {
            script.Append("   hideTrigger:true");
        } else {
            script.Append("   hideTrigger:false");
            if (this.dataGridACEditorConfig.isACTriggerAsAll()) {
                script.Append(" ,triggerAction:'all'");
            }
        }
        script.Append("   });");
        script.Append("$P.autocomplete['%1$s']= ac;", this.getUniqueID());
        script.Append("ac.on('select',function(_1,_2,_3){if(_2){\r\n");
        if (StringHelper.Length((String)strACFillParams) > 0) {
            String[] list = strACFillParams.split("[|]");
            k = 0;
            while (k < list.length) {
                script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('%1$s'));\r\n", list[k].toLowerCase(), this.dataGrid.getUniqueID());
                ++k;
            }
        }
        script.Append("if(_2.get('realtext')!=undefined){_1.setValue(_2.get('realtext'));}");
        script.Append("$P.autocomplete['%1$s'].lastvalue = _1.getValue();", this.getUniqueID());
        String strValueField = this.getACEditorConfig().getValueField();
        if (!StringHelper.IsNullOrEmpty((String)strValueField)) {
            script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('value'));\r\n", strValueField.toLowerCase(), this.dataGrid.getUniqueID());
        }
        if (StringHelper.Length((String)(strACAfterSelectCode = this.dataGridACEditorConfig.getACAfterSelectCode())) > 0) {
            script.Append(strACAfterSelectCode);
        }
        script.Append("}});");
        script.Append("ac.on('beforequery',function(_1){$P.autocomplete['%1$s'].lastQuery = null;if(_1.forceAll){_1.query='';}}\t);\r\n", this.getUniqueID());
        script.Append("%1$s = ac;\r\n", "_GRIDEDITOR");
        return script.toString();
    }
}

