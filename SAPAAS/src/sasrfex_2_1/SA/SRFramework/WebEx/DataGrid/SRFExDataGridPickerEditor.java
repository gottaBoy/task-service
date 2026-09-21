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
import SA.SRFramework.WebEx.DataGrid.UI.DataGridPickerEditorConfig;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDataGridPickerEditor
extends SRFExDataGridBaseEditor {
    protected DataGridPickerEditorConfig dataGridPickerEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDataGridPickerEditor.class);

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridPickerEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridPickerEditorConfig ? (DataGridPickerEditorConfig)this.baseConfig : null;
    }

    public DataGridPickerEditorConfig getPickerEditorConfig() {
        return this.dataGridPickerEditorConfig;
    }

    @Override
    protected String OnRenderHTMLCode() {
        return super.OnRenderHTMLCode();
    }

    @Override
    protected String OnRenderJSCode() {
        String strValueName;
        String strParamName;
        String[] formParamPair;
        String strFormParam;
        int i;
        String[] formParams;
        PickerDialogConfig pickerDialogConfig;
        if (this.dataGridPickerEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("%1$s = new Ext.form.TriggerField();\r\n", "_GRIDEDITOR");
        script.Append("$P.picker['%2$s'] = %1$s;\r\n", "_GRIDEDITOR", this.getUniqueID());
        script.Append("%1$s.onTriggerClick = function(_1){", "_GRIDEDITOR");
        String strAppendFormParams = this.getPickerEditorConfig().getAppendFormParams();
        String strUpdateFormParams = this.getPickerEditorConfig().getUpdateFormParams();
        String strAppendParams = this.getPickerEditorConfig().getAppendParams();
        String strDialogURL = this.getPickerEditorConfig().getDialogURL();
        int nDialogWidth = this.getPickerEditorConfig().getDialogWidth();
        int nDialogHeight = this.getPickerEditorConfig().getDialogHeight();
        String strDialogResizable = this.getPickerEditorConfig().getDialogResizable();
        String strDialogScroll = this.getPickerEditorConfig().getDialogScroll();
        String strDialogStatus = this.getPickerEditorConfig().getDialogStatus();
        if (StringHelper.Length((String)this.getPickerEditorConfig().getPickerDialogId()) > 0 && (pickerDialogConfig = this.getWebContext().getPickerDialogMgr().Get(this.getPickerEditorConfig().getPickerDialogId())) != null) {
            if (StringHelper.Length((String)strAppendParams) == 0) {
                strAppendParams = pickerDialogConfig.getAppendParams();
            }
            if (StringHelper.Length((String)strDialogURL) == 0) {
                strDialogURL = pickerDialogConfig.getDialogURL();
            }
            if (StringHelper.Length((String)strAppendFormParams) == 0) {
                strAppendFormParams = pickerDialogConfig.getAppendFormParams();
            }
            if (StringHelper.Length((String)strUpdateFormParams) == 0) {
                strUpdateFormParams = pickerDialogConfig.getUpdateFormParams();
            }
            nDialogWidth = pickerDialogConfig.getDialogWidth();
            nDialogHeight = pickerDialogConfig.getDialogHeight();
            strDialogResizable = pickerDialogConfig.getDialogResizable();
            strDialogScroll = pickerDialogConfig.getDialogScroll();
            strDialogStatus = pickerDialogConfig.getDialogStatus();
        }
        if (StringHelper.Length((String)(strAppendParams = this.getWebContext().GetParamsString(strAppendParams))) > 0) {
            strDialogURL = strDialogURL.indexOf("?") == -1 ? String.valueOf(strDialogURL) + "?" : String.valueOf(strDialogURL) + "&";
            strDialogURL = String.valueOf(strDialogURL) + strAppendParams;
        }
        strDialogURL = strDialogURL.indexOf("?") == -1 ? String.valueOf(strDialogURL) + "?" : String.valueOf(strDialogURL) + "&";
        script.Append("var _URL = '%1$s';", strDialogURL);
        script.Append("var _PARAMS = {};");
        if (StringHelper.Length((String)strAppendFormParams) > 0) {
            formParams = strAppendFormParams.split("[,]");
            i = 0;
            while (i < formParams.length) {
                strFormParam = formParams[i];
                if (StringHelper.Length((String)strFormParam) != 0 && (formParamPair = strFormParam.split("[|]")).length != 0) {
                    strParamName = formParamPair[0];
                    strValueName = formParamPair[0];
                    if (formParamPair.length >= 2) {
                        strValueName = formParamPair[1];
                    }
                    script.Append("_PARAMS['%1$s'] =  $V($P.grid['%2$s'].gridmgr.AR.get('%3$s'),'');", strParamName, this.dataGrid.getUniqueID(), strValueName.toLowerCase());
                }
                ++i;
            }
        }
        script.Append("_PARAMS['%1$s'] = $P.picker['%2$s'].getValue();", "PICKUPTEXT", this.getUniqueID());
        if (StringHelper.Length((String)this.dataGridPickerEditorConfig.getValueField()) == 0) {
            script.Append("_PARAMS['%1$s'] = $P.picker['%2$s'].getValue();", "PICKUPVALUE", this.getUniqueID());
        } else {
            script.Append("_PARAMS['%1$s'] = $V($P.grid['%2$s'].gridmgr.AR.get('%3$s'),'');", "PICKUPVALUE", this.dataGridPickerEditorConfig.getValueField().toLowerCase());
        }
        script.Append("_URL+=Ext.urlEncode(_PARAMS);");
        script.Append(BrowserJSHelper.getShowDialogScript(null, "_URL", "", nDialogWidth, nDialogHeight, strDialogResizable, strDialogScroll, strDialogStatus));
        script.Append("var _ret = 'cancel';\r\n");
        script.Append("if(_DIALOGRESULT!=null && _DIALOGRESULT!= undefined && _DIALOGRESULT.ret != undefined)\r\n ");
        script.Append("_ret =_DIALOGRESULT.ret; \r\n");
        script.Append("if(_ret=='ok'){");
        script.Append("var _text = $V(_DIALOGRESULT.text,'');");
        script.Append("var _value = $V(_DIALOGRESULT.value,'');");
        script.Append("$P.picker['%1$s'].setValue( _text);", this.getUniqueID());
        if (StringHelper.Length((String)this.dataGridPickerEditorConfig.getValueField()) != 0) {
            script.Append("$P.grid['%1$s'].gridmgr.AR.set('%2$s',_value);\r\n", this.dataGrid.getUniqueID(), this.dataGridPickerEditorConfig.getValueField().toLowerCase());
        }
        if (StringHelper.Length((String)strUpdateFormParams) > 0) {
            formParams = strUpdateFormParams.split("[,]");
            i = 0;
            while (i < formParams.length) {
                strFormParam = formParams[i];
                if (StringHelper.Length((String)strFormParam) != 0 && (formParamPair = strFormParam.split("[|]")).length != 0) {
                    strParamName = formParamPair[0];
                    strValueName = formParamPair[0];
                    if (formParamPair.length >= 2) {
                        strValueName = formParamPair[1];
                    }
                    script.Append("var _%1$s = $V(_DIALOGRESULT.%2$s,'');", strParamName.toLowerCase(), strValueName.toLowerCase());
                    script.Append("$P.grid['%1$s'].gridmgr.AR.set('%2$s',_%2$s);", this.dataGrid.getUniqueID(), strParamName.toLowerCase());
                }
                ++i;
            }
        }
        if (StringHelper.Length((String)this.getPickerEditorConfig().getOKJSCode()) > 0) {
            script.Append(this.getPickerEditorConfig().getOKJSCode());
        }
        script.Append("$P.grid['%1$s'].stopEditing(false);", this.dataGrid.getUniqueID());
        script.Append("}else{");
        if (StringHelper.Length((String)this.getPickerEditorConfig().getCANCELJSCode()) > 0) {
            script.Append(this.getPickerEditorConfig().getCANCELJSCode());
        }
        script.Append("$P.grid['%1$s'].stopEditing(true);", this.dataGrid.getUniqueID());
        script.Append("}");
        script.Append("};");
        return script.toString();
    }
}

