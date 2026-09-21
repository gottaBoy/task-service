/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DataGrid.SRFExDataGridBaseEditor;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PickupColumnEditor
extends SRFExDataGridBaseEditor {
    protected DataGridColumnEditorConfig dataGridColumnEditorConfig = null;
    private static final Log log = LogFactory.getLog(PickupColumnEditor.class);
    protected boolean bInitListItem = false;

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridColumnEditorConfig = this.baseConfig != null && this.baseConfig instanceof DataGridColumnEditorConfig ? this.baseConfig : null;
    }

    protected String OnRenderJSCode() {
        String strValueName;
        String strParamName;
        String[] formParamPair;
        String strFormParam;
        int i;
        String[] formParams;
        String strACAfterSelectCode;
        String strACAppendFormParams;
        String strACFillParamsEx;
        if (this.dataGridColumnEditorConfig == null) {
            return super.OnRenderJSCode();
        }
        String strValueField = this.dataGridColumnEditorConfig.GetExtValue("VALUEFIELD", "");
        StringBuilderEx script = new StringBuilderEx();
        String strACDataURL = this.dataGridColumnEditorConfig.GetExtValue("ACDATAURL", "");
        if (StringHelper.Length((String)strACDataURL) == 0) {
            strACDataURL = this.getWebContext().getWebConfig().GetExtValue("AUTOCOMPLETE", "");
        }
        if (StringHelper.Length((String)strACDataURL) == 0) {
            log.error((Object)StringHelper.Format((String)"\u6587\u672c\u5bf9\u8c61[%1$s]\u5b9a\u4e49\u4e86\u81ea\u52a8\u5b8c\u6210\u6a21\u5f0f\uff0c\u7f3a\u4e4f\u6570\u636e\u6e90\u8def\u5f84", (Object)this.dataGridColumnEditorConfig.getID()));
            return "";
        }
        if (StringHelper.Length((String)strACDataURL) > 0) {
            strACDataURL = URLHelper.AppendURLSeperator((String)strACDataURL);
            strACDataURL = String.valueOf(strACDataURL) + this.getWebContext().GetParamsString(this.dataGridColumnEditorConfig.GetExtValue("ACAPPENDPARAMS", ""));
            String strACAppendURLParams = this.dataGridColumnEditorConfig.GetExtValue("ACAPPENDURLPARAMS", "");
            if (!StringHelper.IsNullOrEmpty((String)strACAppendURLParams)) {
                strACDataURL = URLHelper.AppendURLSeperator((String)strACDataURL);
                strACDataURL = String.valueOf(strACDataURL) + strACAppendURLParams;
            }
        }
        TreeMap<String, Integer> rd = new TreeMap<String, Integer>();
        script.Append("var httpProxy = new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:30000,url:'%1$s'}));\r\n", (Object)strACDataURL);
        script.Append("var RecordDef = Ext.data.Record.create([{name:'text'},{name:'value'},{name:'realtext'}");
        rd.put("text", 0);
        rd.put("value", 0);
        rd.put("realtext", 0);
        String strACFillParams = this.dataGridColumnEditorConfig.GetExtValue("ACFILLPARAMS", "");
        if (StringHelper.Length((String)strACFillParams) > 0) {
            String[] list = strACFillParams.split("[|]");
            int k = 0;
            while (k < list.length) {
                if (!rd.containsKey(list[k].toLowerCase())) {
                    script.Append(",{name:'%1$s'}", (Object)list[k].toLowerCase());
                    rd.put(list[k].toLowerCase(), 0);
                }
                ++k;
            }
        }
        if (StringHelper.Length((String)(strACFillParamsEx = this.dataGridColumnEditorConfig.GetExtValue("ACFILLPARAMSEX", ""))) > 0) {
            String[] fillParams = strACFillParamsEx.split("[,]");
            int i2 = 0;
            while (i2 < fillParams.length) {
                String[] fillParamPair;
                String strFillParam = fillParams[i2];
                if (StringHelper.Length((String)strFillParam) != 0 && (fillParamPair = strFillParam.split("[|]")).length != 0) {
                    String strParamName2 = fillParamPair[0];
                    String strValueName2 = fillParamPair[0];
                    if (fillParamPair.length >= 2) {
                        strValueName2 = fillParamPair[1];
                    }
                    if (!rd.containsKey(strValueName2.toLowerCase())) {
                        script.Append(",{name: '%1$s'}", (Object)strValueName2.toLowerCase());
                        rd.put(fillParamPair[0].toLowerCase(), 0);
                    }
                }
                ++i2;
            }
        }
        script.Append("]);\r\n");
        script.Append("var myReader = new Ext.data.JsonReader({ root: \"items\"}, RecordDef);\r\n");
        script.Append("var varStore = new Ext.data.Store({proxy:httpProxy,reader:myReader});\r\n");
        script.Append("varStore.userparams = {%1$s};\r\n", (Object)this.dataGridColumnEditorConfig.GetExtValue("ACUSERPARAMS", ""));
        script.Append("varStore.on('beforeload',\r\n");
        script.Append("function(_T,_OP){\r\n");
        script.Append("_OP.params['acmode']='%1$s';\r\n", (Object)this.dataGridColumnEditorConfig.GetExtValue("ACMODE", ""));
        script.Append("_OP.params['action']='fetch';\r\n");
        script.Append("_OP.params['actiontype']='autocompleteaction';\r\n");
        String strACParams = this.dataGridColumnEditorConfig.GetExtValue("ACPARAMS", "");
        if (StringHelper.Length((String)strACParams) > 0) {
            String[] list = strACParams.split("[|]");
            int k = 0;
            while (k < list.length) {
                script.Append("_OP.params['%1$s']=$V($P.grid['%2$s'].gridmgr.AR.get('%1$s'),'');\r\n", (Object)list[k].toLowerCase(), (Object)this.dataGrid.getUniqueID());
                ++k;
            }
        }
        if (StringHelper.Length((String)(strACAppendFormParams = this.dataGridColumnEditorConfig.GetExtValue("ACAPPENDFORMPARAMS", ""))) > 0) {
            String[] formParams2 = strACAppendFormParams.split("[,]");
            int i3 = 0;
            while (i3 < formParams2.length) {
                String[] formParamPair2;
                String strFormParam2 = formParams2[i3];
                if (StringHelper.Length((String)strFormParam2) != 0 && (formParamPair2 = strFormParam2.split("[|]")).length != 0) {
                    String strParamName3 = formParamPair2[0];
                    String strValueName3 = formParamPair2[0];
                    if (formParamPair2.length >= 2) {
                        strValueName3 = formParamPair2[1];
                    }
                    script.Append("_OP.params['%1$s']=$V($P.grid['%3$s'].gridmgr.AR.get('%2$s'),'');\r\n", (Object)strParamName3.toLowerCase(), (Object)strValueName3.toLowerCase(), (Object)this.dataGrid.getUniqueID());
                }
                ++i3;
            }
        }
        script.Append("Ext.apply( _OP.params,_T.userparams);\r\n");
        script.Append("}\r\n");
        script.Append(");\r\n");
        script.Append("var ac=new SRFDA.DGACEditor({triggerClass:'sx-pickup-trigger',");
        script.Append("    store: varStore,");
        script.Append("    displayField:'text',");
        script.Append("    minChars:%1$s,", (Object)this.dataGridColumnEditorConfig.GetExtValue("ACMINCHARS", "2"));
        script.Append("    typeAhead: false,");
        script.Append("    loadingText: '\u52a0\u8f7d...',");
        script.Append("    queryParam: 'acquery',");
        int nListWidth = this.dataGridColumnEditorConfig.GetExtValue("ACLISTWIDTH", 0);
        if (nListWidth > 0) {
            script.Append("listWidth: %1$s,", (Object)nListWidth);
        }
        if (this.dataGridColumnEditorConfig.GetExtValue("FORCESELECTION", true)) {
            script.Append("  forceSelection:true,");
        }
        script.Append("hideTrigger:false");
        script.Append("   });");
        script.Append("$P.autocomplete['%1$s']=ac;", (Object)this.getUniqueID());
        script.Append("ac.on('select',function(_1,_2,_3){if(_2){\r\n");
        if (StringHelper.Length((String)strACFillParams) > 0) {
            String[] list = strACFillParams.split("[|]");
            int k = 0;
            while (k < list.length) {
                script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('%1$s'));\r\n", (Object)list[k].toLowerCase(), (Object)this.dataGrid.getUniqueID());
                ++k;
            }
        }
        if (StringHelper.Length((String)strACFillParamsEx) > 0) {
            String[] fillParams = strACFillParamsEx.split("[,]");
            int i4 = 0;
            while (i4 < fillParams.length) {
                String[] fillParamPair;
                String strFillParam = fillParams[i4];
                if (StringHelper.Length((String)strFillParam) != 0 && (fillParamPair = strFillParam.split("[|]")).length != 0) {
                    String strParamName4 = fillParamPair[0];
                    String strValueName4 = fillParamPair[0];
                    if (fillParamPair.length >= 2) {
                        strValueName4 = fillParamPair[1];
                    }
                    script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('%3$s'));\r\n", (Object)strParamName4, (Object)this.dataGrid.getUniqueID(), (Object)strValueName4.toLowerCase());
                }
                ++i4;
            }
        }
        script.Append("var v2=_2.get('text');");
        script.Append("if(_2.get('realtext')!=undefined){v2=_2.get('realtext');}");
        script.Append("v2= v2 +'||SRF||'+_2.get('value');");
        script.Append("_1.setValue(v2);");
        script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',v2);\r\n", (Object)this.dataGridColumnEditorConfig.getID().toLowerCase(), (Object)this.dataGrid.getUniqueID());
        if (!StringHelper.IsNullOrEmpty((String)strValueField)) {
            script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',_2.get('value'));\r\n", (Object)strValueField.toLowerCase(), (Object)this.dataGrid.getUniqueID());
        }
        if (StringHelper.Length((String)(strACAfterSelectCode = this.dataGridColumnEditorConfig.GetExtValue("ACAFTERSELECTCODE", ""))) > 0) {
            script.Append(strACAfterSelectCode);
        }
        script.Append("}});");
        script.Append("ac.on('beforequery',function(_1){$P.autocomplete['%1$s'].lastQuery=null;if(_1.forceAll){_1.query='';}});\r\n", (Object)this.getUniqueID());
        script.Append("ac.on('blur',function(_1){var ac=$P.autocomplete['%1$s'];_2 =_1.getValue();_2=_2.trim();if(_2.length==0){ac.lastvalue='';ac.setValue('');$P.grid['%2$s'].gridmgr.AR.set('%3$s','');}else{if(_2!=ac.lastvalue){$P.grid['%2$s'].gridmgr.AR.set('%3$s',ac.lastvalue);}}});", (Object)this.getUniqueID(), (Object)this.dataGrid.getUniqueID(), (Object)this.dataGridColumnEditorConfig.getID().toLowerCase());
        script.Append("$P.picker['%1$s']=ac;\r\n", (Object)this.getUniqueID());
        script.Append("ac.onTriggerClick=function(){\r\n");
        String strAppendFormParams = this.dataGridColumnEditorConfig.GetExtValue("APPENDFORMPARAMS", "");
        String strUpdateFormParams = this.dataGridColumnEditorConfig.GetExtValue("UPDATEFORMPARAMS", "");
        String strAppendParams = this.dataGridColumnEditorConfig.GetExtValue("APPENDPARAMS", "");
        String strDialogURL = this.dataGridColumnEditorConfig.GetExtValue("DIALOGURL", "");
        int nDialogWidth = this.dataGridColumnEditorConfig.GetExtValue("DIALOGWIDTH", 800);
        int nDialogHeight = this.dataGridColumnEditorConfig.GetExtValue("DIALOGHEIGHT", 600);
        String strDialogResizable = this.dataGridColumnEditorConfig.GetExtValue("DIALOGRESIZABLE", "");
        String strDialogScroll = this.dataGridColumnEditorConfig.GetExtValue("DIALOGSCROLL", "");
        String strDialogStatus = this.dataGridColumnEditorConfig.GetExtValue("DIALOGSTATUS", "");
        String strAppendURLParams = this.dataGridColumnEditorConfig.GetExtValue("APPENDURLPARAMS", "");
        strAppendParams = this.getWebContext().GetParamsString(strAppendParams);
        if (StringHelper.Length((String)strAppendParams) > 0) {
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = String.valueOf(strDialogURL) + strAppendParams;
        }
        if (!StringHelper.IsNullOrEmpty((String)strAppendURLParams)) {
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
        }
        strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
        script.Append("var _URL='%1$s';", (Object)strDialogURL);
        script.Append("var _PARAMS={};");
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
                    script.Append("_PARAMS['%1$s']=$V($P.grid['%2$s'].gridmgr.AR.get('%3$s'),'');", (Object)strParamName, (Object)this.dataGrid.getUniqueID(), (Object)strValueName.toLowerCase());
                }
                ++i;
            }
        }
        script.Append("_URL+=Ext.urlEncode(_PARAMS);");
        script.Append(BrowserJSHelper.getShowDialogScriptEx(null, (String)"_URL", (String)"", (int)nDialogWidth, (int)nDialogHeight, (String)strDialogResizable, (String)strDialogScroll, (String)strDialogStatus));
        script.Append("var _ret = 'cancel';\r\n");
        script.Append("if(_DIALOGRESULT!=null && _DIALOGRESULT!= undefined && _DIALOGRESULT.ret != undefined)\r\n ");
        script.Append("_ret =_DIALOGRESULT.ret; \r\n");
        script.Append("if(_ret=='ok'){");
        script.Append("var _text=$V(_DIALOGRESULT.text,'');");
        script.Append("var _value=$V(_DIALOGRESULT.value,'');");
        script.Append("var v2= _text +'||SRF||'+_value;");
        script.Append("$P.picker['%1$s'].setValue( v2);", (Object)this.getUniqueID());
        script.Append("$P.grid['%2$s'].gridmgr.AR.set('%1$s',v2);\r\n", (Object)this.dataGridColumnEditorConfig.getID().toLowerCase(), (Object)this.dataGrid.getUniqueID());
        if (StringHelper.Length((String)strValueField) != 0) {
            script.Append("$P.grid['%1$s'].gridmgr.AR.set('%2$s',_value);\r\n", (Object)this.dataGrid.getUniqueID(), (Object)strValueField.toLowerCase());
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
                    script.Append("var _%1$s = $V(_DIALOGRESULT.%2$s,'');", (Object)strParamName.toLowerCase(), (Object)strValueName.toLowerCase());
                    script.Append("$P.grid['%1$s'].gridmgr.AR.set('%2$s',_%2$s);", (Object)this.dataGrid.getUniqueID(), (Object)strParamName.toLowerCase());
                }
                ++i;
            }
        }
        String strOKJSCode = this.dataGridColumnEditorConfig.GetExtValue("OKJSCODE", "");
        String strCANCELJSCode = this.dataGridColumnEditorConfig.GetExtValue("CANCELJSCODE", "");
        if (StringHelper.Length((String)strOKJSCode) > 0) {
            script.Append(strOKJSCode);
        }
        script.Append("$P.grid['%1$s'].stopEditing(false);", (Object)this.dataGrid.getUniqueID());
        script.Append("}else{");
        if (StringHelper.Length((String)strCANCELJSCode) > 0) {
            script.Append(strCANCELJSCode);
        }
        script.Append("$P.grid['%1$s'].stopEditing(true);", (Object)this.dataGrid.getUniqueID());
        script.Append("}");
        script.Append("};");
        script.Append("%1$s=ac;\r\n", (Object)"_GRIDEDITOR");
        return script.toString();
    }
}

