/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.TextBoxConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTextBox
extends SRFExFormItem {
    protected TextBoxConfig textBoxConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTextBox.class);
    private static String strSelectedText = "selected=\"selected\" ";

    @Override
    protected XMLConfig CreateConfig() {
        return new TextBoxConfig();
    }

    public TextBoxConfig getTextBoxConfig() {
        if (this.textBoxConfig == null) {
            this.InitConfig();
        }
        return this.textBoxConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.textBoxConfig = null;
        if (this.config != null && this.config instanceof TextBoxConfig) {
            this.textBoxConfig = (TextBoxConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            switch (this.getTextBoxConfig().getTextMode()) {
                case 2: {
                    this.RenderSingleLine(writer, true);
                    break;
                }
                case 1: {
                    this.RenderMultiLine(writer);
                    break;
                }
                case 4: {
                    this.RenderCaretMultiLine(writer);
                    break;
                }
                default: {
                    this.RenderSingleLine(writer, false);
                    break;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderSingleLine(Writer writer, boolean bPassword) throws IOException {
        writer.write("<INPUT ");
        this.OutputID(writer);
        this.OutputName(writer);
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getTextBoxConfig().getExtAttributes(), true);
        if (bPassword) {
            attributesBuilder.Set("type", "password");
        } else {
            attributesBuilder.Set("type", "text");
        }
        this.FillAttributeBuilder(attributesBuilder);
        if (StringHelper.StringLength((String)this.getTextBoxConfig().getText()) != 0) {
            attributesBuilder.Set("value", this.getTextBoxConfig().getText());
        }
        if (this.getTextBoxConfig().getReadOnly()) {
            attributesBuilder.Set("readonly", "readonly");
        }
        if (!this.getEnabled()) {
            attributesBuilder.Set("disabled", "true");
        }
        if (this.getTextBoxConfig().getMaxLength() > 0) {
            attributesBuilder.Set("maxlength", StringHelper.Format((String)"%1$s", (Object)this.getTextBoxConfig().getMaxLength()));
        }
        StyleBuilder styleBuilder = new StyleBuilder();
        this.FillStyleBuilder(styleBuilder);
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACMode()) && this.getTextBoxConfig().isACWidthMode() && this.getTextBoxConfig().getWidth() <= 1) {
            styleBuilder.RemoveStyle("WIDTH");
            styleBuilder.AddStyle("WIDTH", "200");
        }
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getTextBoxConfig().getExtStyle());
        writer.write(attributesBuilder.ToOutputString());
        writer.write(">");
        if (!bPassword && StringHelper.Length((String)this.getTextBoxConfig().getACMode()) > 0) {
            SRFExControl control2;
            String[] list;
            SRFExBaseForm baseForm;
            String strFormId;
            StringBuilderEx script = new StringBuilderEx();
            String strACDataURL = this.getTextBoxConfig().getACDataURL();
            if (StringHelper.Length((String)strACDataURL) == 0) {
                strACDataURL = this.getWebContext().getWebConfig().GetExtValue("AUTOCOMPLETE", "");
            }
            if (StringHelper.Length((String)strACDataURL) == 0) {
                log.error((Object)StringHelper.Format((String)"\u6587\u672c\u5bf9\u8c61[%1$s]\u5b9a\u4e49\u4e86\u81ea\u52a8\u5b8c\u6210\u6a21\u5f0f\uff0c\u7f3a\u4e4f\u6570\u636e\u6e90\u8def\u5f84", (Object)this.getTextBoxConfig().getID()));
                return;
            }
            strACDataURL = URLHelper.AppendURLSeperator(strACDataURL);
            strACDataURL = String.valueOf(strACDataURL) + this.getPage().getWebContext().GetParamsString(this.textBoxConfig.getACAppendParams());
            if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACAppendURLParams())) {
                strACDataURL = URLHelper.AppendURLSeperator(strACDataURL);
                strACDataURL = String.valueOf(strACDataURL) + this.getTextBoxConfig().getACAppendURLParams();
            }
            script.Append(this.GetCaretModeScript());
            script.Append("var _H=new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:30000,url:'%1$s'}));\r\n", strACDataURL);
            if (this.getFormItemConfig() != null) {
                String strACFillParamsEx;
                String[] arrACCaretFormParam;
                int n;
                String strACCaretFormParamS;
                strFormId = this.getFormItemConfig().getFormId();
                if (StringHelper.Length((String)strFormId) == 0) {
                    strFormId = this.getPage().getDefaultFormId();
                }
                script.Append("var _R=Ext.data.Record.create([{name:'text'},{name:'value'},{name:'realtext'}");
                String strACFillParams = this.getTextBoxConfig().getACFillParams();
                if (StringHelper.Length((String)strACFillParams) > 0 && (baseForm = this.getPage().getForms().FindForm(strFormId)) != null && StringHelper.Length((String)strACFillParams) > 0) {
                    list = strACFillParams.split("[|]");
                    int k = 0;
                    while (k < list.length) {
                        control2 = baseForm.FindControl(list[k]);
                        if (control2 != null) {
                            script.Append(",{name:'%1$s'}", list[k].toLowerCase());
                        }
                        ++k;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)(strACCaretFormParamS = this.getTextBoxConfig().GetExtValue("ACCARETFORMPARAMS", "")))) {
                    String[] arrACCaretFormParamS;
                    String[] stringArray = arrACCaretFormParamS = strACCaretFormParamS.split("[,]");
                    n = arrACCaretFormParamS.length;
                    int caretParamIndex = 0;
                    while (caretParamIndex < n) {
                        String strACCaretFormParam = stringArray[caretParamIndex];
                        arrACCaretFormParam = strACCaretFormParam.split("[|]");
                        if (arrACCaretFormParam.length == 2) {
                            script.Append(",{name:'%1$s'}", arrACCaretFormParam[1].toLowerCase());
                        }
                        ++caretParamIndex;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)(strACFillParamsEx = this.getTextBoxConfig().getACFillParamsEx()))) {
                    String[] acFillParamsEx;
                    arrACCaretFormParam = acFillParamsEx = strACFillParamsEx.split("[,]");
                    int n2 = acFillParamsEx.length;
                    n = 0;
                    while (n < n2) {
                        String strACFillParamEx = arrACCaretFormParam[n];
                        String[] arrACCaretFormParam2 = strACFillParamEx.split("[|]");
                        script.Append(",{name:'%1$s'}", arrACCaretFormParam2[0].toLowerCase());
                        ++n;
                    }
                }
                script.Append("]);\r\n");
            } else {
                script.Append("var _R=Ext.data.Record.create([{name:'text'},{name:'value'},{name:'realtext'}]);\r\n");
            }
            script.Append("var _J=new Ext.data.JsonReader({root:\"items\"},_R);\r\n");
            script.Append("var _S=new Ext.data.Store({proxy:_H,reader:_J});\r\n");
            script.Append("_S.userparams={%1$s};\r\n", this.textBoxConfig.getACUserParams());
            script.Append("_S.on('beforeload',function(_T,_OP){\r\n");
            script.Append("Ext.apply(_OP.params,{acmode:'%1$s',action:'fetch',actiontype:'autocompleteaction'});", this.getTextBoxConfig().getACMode());
            if (this.getFormItemConfig() != null) {
                String strAppendFormParams;
                String strACParams;
                strFormId = this.getFormItemConfig().getFormId();
                if (StringHelper.Length((String)strFormId) == 0) {
                    strFormId = this.getPage().getDefaultFormId();
                }
                if (StringHelper.Length((String)(strACParams = this.getTextBoxConfig().getACParams())) > 0 && (baseForm = this.getPage().getForms().FindForm(strFormId)) != null) {
                    list = strACParams.split("[|]");
                    int k = 0;
                    while (k < list.length) {
                        control2 = baseForm.FindControl(list[k]);
                        if (control2 != null) {
                            script.Append("_OP.params['%1$s']=%2$s.G('%3$s');", list[k].toLowerCase(), strFormId, control2.getUniqueID());
                        }
                        ++k;
                    }
                }
                if (StringHelper.Length((String)(strAppendFormParams = this.getTextBoxConfig().getACAppendFormParams())) > 0) {
                    String[] formParams = strAppendFormParams.split("[,]");
                    int i = 0;
                    while (i < formParams.length) {
                        String[] formParamPair;
                        String strFormParam = formParams[i];
                        if (StringHelper.Length((String)strFormParam) != 0 && (formParamPair = strFormParam.split("[|]")).length != 0) {
                            SRFExControl control3;
                            String strParamName = formParamPair[0];
                            String strValueName = formParamPair[0];
                            if (formParamPair.length >= 2) {
                                strValueName = formParamPair[1];
                            }
                            if ((control3 = this.getForm().FindControl(strValueName)) != null) {
                                script.Append("_OP.params['%1$s']=%2$s.G('%3$s');", strParamName.toLowerCase(), this.getForm().getFormId(), control3.getUniqueID());
                            }
                        }
                        ++i;
                    }
                }
            }
            script.Append("Ext.apply(_OP.params,_T.userparams);");
            script.Append("}");
            script.Append(");\r\n");
            String strACTPL = this.getTextBoxConfig().getACTPL();
            if (!StringHelper.IsNullOrEmpty((String)strACTPL)) {
                script.Append("var actpl =new Ext.XTemplate('%1$s');", strACTPL);
            }
            script.Append("var ac=new Ext.form.ComboBox({");
            script.Append("store:_S,");
            script.Append("displayField:'text',");
            script.Append("minChars:%1$s,", this.getTextBoxConfig().getACMinChars());
            script.Append("typeAhead:false,");
            script.Append("loadingText:'\u52a0\u8f7d...',");
            script.Append("queryParam:'acquery',");
            if (this.getTextBoxConfig().getWidthEx() == 1.0) {
                if (this.getTextBoxConfig().getACHideTrigger()) {
                    script.Append("autoWidth:true,style:'width:100%;',");
                } else {
                    script.Append("autoWidth:true,style:'width:200px',");
                }
            } else if (this.getTextBoxConfig().getWidthEx() > 1.0) {
                script.Append("width:%1$s,", this.getTextBoxConfig().getWidth());
            } else {
                script.Append("style:'width:%1$s',", this.getTextBoxConfig().getWidthString());
            }
            if (this.getTextBoxConfig().getACListWidth() > 0) {
                script.Append("listWidth:%1$s,", this.getTextBoxConfig().getACListWidth());
            } else {
                int nDefaultListWidth = this.getTextBoxConfig().getWidth();
                if (nDefaultListWidth <= 1) {
                    nDefaultListWidth = 200;
                }
                script.Append("listWidth:%1$s,", nDefaultListWidth);
            }
            if (this.getTextBoxConfig().getACForceSelection()) {
                script.Append("forceSelection:true,");
            }
            script.Append("applyTo:'%1$s',", this.getUniqueID());
            if (this.getTextBoxConfig().getACHideTrigger()) {
                script.Append("hideTrigger:true");
            } else {
                script.Append("hideTrigger:false");
                if (this.getTextBoxConfig().isACTriggerAsAll()) {
                    script.Append(",triggerAction:'all'");
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strACTPL)) {
                script.Append(",tpl:'actpl'");
            }
            script.Append("});");
            boolean bOutputSelectCode = false;
            String strACAfterSelectCode = this.getTextBoxConfig().getACAfterSelectCode();
            if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACFillParams()) || !StringHelper.IsNullOrEmpty((String)strACAfterSelectCode) || !StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACFillParamsEx()) || this.getTextBoxConfig().isACRealText()) {
                bOutputSelectCode = true;
            }
            script.Append("SRFForm.acadjust(ac,'%1$s',%2$s,%3$s,'%4$s');", this.getUniqueID(), this.getTextBoxConfig().getWidthEx() <= 1.0, !bOutputSelectCode, this.getTextBoxConfig().getWidthString());
            if (bOutputSelectCode) {
                script.Append("ac.on('select',function(_1,_2,_3){if(_2){");
                if (this.getFormItemConfig() != null) {
                    SRFExBaseForm baseForm2;
                    String strFormId2 = this.getFormItemConfig().getFormId();
                    if (StringHelper.Length((String)strFormId2) == 0) {
                        strFormId2 = this.getPage().getDefaultFormId();
                    }
                    if ((baseForm2 = this.getPage().getForms().FindForm(strFormId2)) != null) {
                        String strACFillParamsEx;
                        String strACFillParams = this.getTextBoxConfig().getACFillParams();
                        if (StringHelper.Length((String)strACFillParams) > 0) {
                            String[] list2 = strACFillParams.split("[|]");
                            int k = 0;
                            while (k < list2.length) {
                                SRFExControl control4 = baseForm2.FindControl(list2[k]);
                                if (control4 != null) {
                                    script.Append("%1$s.S('%2$s',_2.get('%3$s'));", strFormId2, control4.getUniqueID(), list2[k].toLowerCase());
                                }
                                ++k;
                            }
                        }
                        if (StringHelper.Length((String)(strACFillParamsEx = this.getTextBoxConfig().getACFillParamsEx())) > 0) {
                            String[] list3 = strACFillParamsEx.split("[,]");
                            int k = 0;
                            while (k < list3.length) {
                                String[] parts = list3[k].split("[|]");
                                SRFExControl control5 = baseForm2.FindControl(parts.length == 1 ? parts[0] : parts[1]);
                                if (control5 != null) {
                                    script.Append("%1$s.S('%2$s',_2.get('%3$s'));", strFormId2, control5.getUniqueID(), parts[0].toLowerCase());
                                }
                                ++k;
                            }
                        }
                    }
                }
                script.Append("if(_2.get('realtext')!=undefined){_1.setValue(_2.get('realtext'));}");
                script.Append("_1.lastvalue=_1.getValue();");
                if (StringHelper.Length((String)strACAfterSelectCode) > 0) {
                    script.Append(strACAfterSelectCode);
                }
                script.Append("}});");
            }
            this.getPage().RegisterOnReadyScript(2, script.toString());
        }
    }

    protected void RenderCaretTemplateLine(Writer writer) throws IOException {
        writer.write("<INPUT ");
        String strCaretTemplateId = String.valueOf(this.getUniqueID().replace(':', '_')) + "_CARET";
        String strCaretTemplateName = String.valueOf(this.getName()) + "_CARET";
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        SRFExTextBox.OutputAttribute(writer, "id", strCaretTemplateId);
        SRFExTextBox.OutputAttribute(writer, "name", strCaretTemplateName);
        attributesBuilder.Set("type", "text");
        this.FillAttributeBuilder(attributesBuilder);
        if (this.getTextBoxConfig().getReadOnly()) {
            attributesBuilder.Set("readonly", "readonly");
        }
        if (!this.getEnabled()) {
            attributesBuilder.Set("disabled", "true");
        }
        writer.write(attributesBuilder.ToOutputString());
        writer.write(StringHelper.Format((String)" style='width:%1$spx;'>", (Object)this.getTextBoxConfig().getCaretInputWidth()));
        StringBuilderEx script = new StringBuilderEx();
        String strACDataURL = this.getTextBoxConfig().getACDataURL();
        if (StringHelper.Length((String)strACDataURL) == 0) {
            strACDataURL = this.getWebContext().getWebConfig().GetExtValue("AUTOCOMPLETE", "");
        }
        if (StringHelper.Length((String)strACDataURL) == 0) {
            log.error((Object)StringHelper.Format((String)"\u6587\u672c\u5bf9\u8c61[%1$s]\u5b9a\u4e49\u4e86\u81ea\u52a8\u5b8c\u6210\u6a21\u5f0f\uff0c\u7f3a\u4e4f\u6570\u636e\u6e90\u8def\u5f84", (Object)this.getTextBoxConfig().getID()));
            return;
        }
        if (StringHelper.Length((String)strACDataURL) > 0) {
            int nPos = strACDataURL.indexOf("?");
            if (nPos == -1) {
                strACDataURL = String.valueOf(strACDataURL) + "?";
            } else if (nPos != strACDataURL.length() - 1) {
                strACDataURL = String.valueOf(strACDataURL) + "&";
            }
            strACDataURL = String.valueOf(strACDataURL) + this.getPage().getWebContext().GetParamsString(this.textBoxConfig.getACAppendParams());
        }
        script.Append(this.GetCaretModeScript());
        script.Append("var _H=new Ext.data.HttpProxy(new Ext.data.Connection({method:'post',timeout:30000,url:'%1$s'}));\r\n", strACDataURL);
        if (this.getFormItemConfig() != null) {
            String strACCaretFormParamS;
            String strFormId = this.getFormItemConfig().getFormId();
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = this.getPage().getDefaultFormId();
            }
            script.Append("var _R=Ext.data.Record.create([{name: 'text'},{name:'value'},{name:'realtext'}");
            if (this.getTextBoxConfig().isCaretDesc()) {
                script.Append(",{name:'caretdesc'}");
            }
            if (!StringHelper.IsNullOrEmpty((String)(strACCaretFormParamS = this.getTextBoxConfig().GetExtValue("ACCARETFORMPARAMS", "")))) {
                String[] arrACCaretFormParamS;
                String[] stringArray = arrACCaretFormParamS = strACCaretFormParamS.split("[,]");
                int n = arrACCaretFormParamS.length;
                int n2 = 0;
                while (n2 < n) {
                    String strACCaretFormParam = stringArray[n2];
                    String[] arrACCaretFormParam = strACCaretFormParam.split("[|]");
                    if (arrACCaretFormParam.length == 2) {
                        script.Append(",{name: '%1$s'}", arrACCaretFormParam[1].toLowerCase());
                    }
                    ++n2;
                }
            }
            script.Append("]);\r\n");
        }
        script.Append("var _J=new Ext.data.JsonReader({root:\"items\"},_R);\r\n");
        script.Append("var _S=new Ext.data.Store({proxy:_H,reader:_J});\r\n");
        script.Append("_S.userparams={%1$s};\r\n", this.textBoxConfig.getACUserParams());
        script.Append("_S.on('beforeload',function(_T,_OP){\r\n");
        String strACMode = this.getTextBoxConfig().getACMode();
        if (StringHelper.IsNullOrEmpty((String)strACMode)) {
            strACMode = "SRFDAAC";
        }
        script.Append("Ext.apply(_OP.params,{acmode:'%1$s',action:'fetch',actiontype:'autocompleteaction'});", strACMode);
        if (this.getFormItemConfig() != null) {
            String strAppendFormParams;
            SRFExBaseForm baseForm;
            String strACParams;
            String strFormId = this.getFormItemConfig().getFormId();
            if (StringHelper.Length((String)strFormId) == 0) {
                strFormId = this.getPage().getDefaultFormId();
            }
            if (StringHelper.Length((String)(strACParams = this.getTextBoxConfig().getACParams())) > 0 && (baseForm = this.getPage().getForms().FindForm(strFormId)) != null) {
                String[] list = strACParams.split("[|]");
                int k = 0;
                while (k < list.length) {
                    SRFExControl control = baseForm.FindControl(list[k]);
                    if (control != null) {
                        script.Append("_OP.params['%1$s']=%2$s.G('%3$s');\r\n", list[k].toLowerCase(), strFormId, control.getUniqueID());
                    }
                    ++k;
                }
            }
            if (StringHelper.Length((String)(strAppendFormParams = this.getTextBoxConfig().getACAppendFormParams())) > 0) {
                String[] formParams = strAppendFormParams.split("[,]");
                int i = 0;
                while (i < formParams.length) {
                    String[] formParamPair;
                    String strFormParam = formParams[i];
                    if (StringHelper.Length((String)strFormParam) != 0 && (formParamPair = strFormParam.split("[|]")).length != 0) {
                        SRFExControl control;
                        String strParamName = formParamPair[0];
                        String strValueName = formParamPair[0];
                        if (formParamPair.length >= 2) {
                            strValueName = formParamPair[1];
                        }
                        if ((control = this.getForm().FindControl(strValueName)) != null) {
                            script.Append("_OP.params['%1$s']=%2$s.G('%3$s');\r\n", strParamName.toLowerCase(), this.getForm().getFormId(), control.getUniqueID());
                        }
                    }
                    ++i;
                }
            }
        }
        script.Append("Ext.apply( _OP.params,_T.userparams);\r\n");
        script.Append("}\r\n");
        script.Append("); _S.on('load',function(_1,_2,_3){ ", this.getUniqueID());
        script.Append("var element=Ext.getDom('%1$s');while(element.options.length>0){element.remove(0);} for(var i=0; i< _1.getTotalCount();i++){var _record =_1.getAt(i); ", String.valueOf(this.getUniqueID()) + "_LB");
        script.Append("SRFForm.addListBoxValue('%1$s',_record.get('realtext'),_record.get('caretword'));", String.valueOf(this.getUniqueID()) + "_LB");
        script.Append("}});");
        script.Append("$P.store['%1$s']=_S;", this.getUniqueID());
        this.getPage().RegisterOnReadyScript(2, script.toString());
        script.Reset();
        script.Append("$P.object['%1$s'].fetch=function(){", this.getUniqueID());
        script.Append("var A=$P.store['%1$s'];A.userparams.acquery=Ext.getDom('%1$s_CARET').value;", this.getUniqueID());
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getCaretGroup()) && !StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getCaretGroupParam())) {
            script.Append("A.userparams.%2$s=$FGV('%1$s_CG');", this.getUniqueID(), this.getTextBoxConfig().getCaretGroupParam().toLowerCase());
        }
        if (this.getTextBoxConfig().isCaretDesc()) {
            script.Append("$FSV('%1$s_CD','');", this.getUniqueID());
        }
        script.Append("A.load();};");
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getCaretGroup())) {
            script.Append("$FVC2('%1$s_CG',function(){$P.object['%1$s'].fetch();});", this.getUniqueID());
        }
        script.Append("document.getElementById('%1$s_CARET').onkeyup=function(){$P.object['%1$s'].fetch();};", this.getUniqueID());
        String strCaretFunc = "";
        strCaretFunc = this.getTextBoxConfig().isCaretReturn() ? StringHelper.Format((String)"$P.object['%1$s'].insertAtCaret('%1$s',SRFForm.getListBoxValue('%1$s_LB','')+'\\r\\n');", (Object)this.getUniqueID()) : StringHelper.Format((String)"$P.object['%1$s'].insertAtCaret('%1$s',SRFForm.getListBoxValue('%1$s_LB',''));", (Object)this.getUniqueID());
        if (this.getTextBoxConfig().isCaretDesc()) {
            script.Append("document.getElementById('%1$s_LB').onclick=function(){var A=Ext.getDom('%1$s_LB').selectedIndex;if(A!=-1){var B=$P.store['%1$s'].getAt(A);var C=B.get('caretdesc');$FSV('%1$s_CD',C);}};", this.getUniqueID());
            script.Append("document.getElementById('%1$s_LB').ondblclick=function(){%2$s};", this.getUniqueID(), strCaretFunc);
        } else {
            script.Append("document.getElementById('%1$s_LB').onclick=function(){%2$s};", this.getUniqueID(), strCaretFunc);
        }
        script.Append("$P.object['%1$s'].fetch();", this.getUniqueID());
        this.getPage().RegisterOnReadyScript(5, script.toString());
    }

    protected void RenderCaretMultiLine(Writer writer) throws IOException {
        writer.write(StringHelper.Format((String)"<table  cellspacing='0' cellpadding='0' border='0' style=\"border-spacing:0px;width:%1$s;align:left;\" >", (Object)this.getTextBoxConfig().getWidthString()));
        writer.write("<tr  valign='top'><td>");
        this.RenderMultiLine(writer);
        writer.write("</td>");
        writer.write("<td width='3'></td>");
        writer.write(StringHelper.Format((String)"<td align='left' width='%1$s' valign='top'>", (Object)this.getTextBoxConfig().getCaretInputWidth()));
        writer.write(StringHelper.Format((String)"<table  cellspacing='0' cellpadding='0' border='0'  style=\"border-spacing:0px;width:%1$spx;align:left;\" >", (Object)this.getTextBoxConfig().getCaretInputWidth()));
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getCaretGroup())) {
            writer.write("<tr height='20'><td>");
            this.RenderCaretGroupDropDownList(writer);
            writer.write("</td></tr>");
        }
        writer.write("<tr height='20'><td>");
        this.RenderCaretTemplateLine(writer);
        writer.write("</td></tr><tr height='2'><td></td></tr><tr><td>");
        this.RenderListBox(writer);
        writer.write("</td></tr></table></td>");
        if (this.getTextBoxConfig().isCaretDesc()) {
            writer.write("<td width='3'></td>");
            writer.write(StringHelper.Format((String)"<td  width='%1$s' valign='top'>", (Object)this.getTextBoxConfig().getCaretDescWidth()));
            this.RenderCaretDesc(writer);
            writer.write("</td>");
        }
        writer.write("</tr></table>");
        this.getTextBoxConfig().RemoveExtAttribute("ACCARETFORMPARAMS");
        this.getTextBoxConfig().RemoveExtAttribute("ACUSERMODE");
        this.getTextBoxConfig().RemoveExtAttribute("SRFDEID");
    }

    protected void RenderListBox(Writer writer) {
        try {
            writer.write("<select multiple=\"multiple\" class=\"sx-listbox\" ");
            this.OutputID(writer, "_LB");
            this.OutputName(writer, "_LB");
            writer.write(StringHelper.Format((String)" style='width:%1$spx;border-spacing:0px;height:", (Object)this.getTextBoxConfig().getCaretInputWidth()));
            if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getCaretGroup())) {
                writer.write(String.valueOf(this.getTextBoxConfig().getHeight() - 42) + "px;' ");
            } else {
                writer.write(String.valueOf(this.getTextBoxConfig().getHeight() - 22) + "px;' ");
            }
            writer.write(">");
            writer.write("</select>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderCaretGroupDropDownList(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer, "_CG");
            this.OutputName(writer, "_CG");
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)this.getTextBoxConfig().getCaretInputWidth()));
            attributesBuilder.Set("style", styleBuilder.ToStyleList());
            attributesBuilder.Set("class", "sx-select");
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            String strCaretGroup = this.getTextBoxConfig().getCaretGroup();
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCaretGroup, this.getWebContext().getLocalization());
            if (codeListConfig != null && codeListConfig.getCodeItems() != null) {
                int nListCount = codeListConfig.getCodeItems().size();
                int i = 0;
                while (i < nListCount) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)codeListConfig.getCodeItems().get(i));
                    writer.write(StringHelper.Format((String)"<option %3$s value=\"%1$s\">%2$s</option>", (Object)codeItemConfig.getValue(), (Object)codeItemConfig.getText(), (Object)(i == 0 ? strSelectedText : "")));
                    ++i;
                }
            }
            writer.write("</select>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderCaretDesc(Writer writer) throws IOException {
        writer.write("<textarea ");
        this.OutputID(writer, "_CD");
        this.OutputName(writer, "_CD");
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.Set("readonly", "readonly");
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)this.getTextBoxConfig().getCaretDescWidth()));
        styleBuilder.AddStyle("height", this.getTextBoxConfig().getHeightString());
        attributesBuilder.Set("style", styleBuilder.ToStyleList());
        attributesBuilder.Set("class", this.getTextBoxConfig().getCssClass());
        attributesBuilder.Set("rows", Integer.toString(this.getTextBoxConfig().getRows()));
        writer.write(attributesBuilder.ToOutputString());
        writer.write(">");
        writer.write("</textarea>");
    }

    protected void RenderMultiLine(Writer writer) throws IOException {
        writer.write("<textarea ");
        this.OutputID(writer);
        this.OutputName(writer);
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getTextBoxConfig().getExtAttributes(), true);
        this.FillAttributeBuilder(attributesBuilder);
        if (this.getTextBoxConfig().getReadOnly()) {
            attributesBuilder.Set("readonly", "readonly");
        }
        StyleBuilder styleBuilder = new StyleBuilder();
        this.FillStyleBuilder(styleBuilder);
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getTextBoxConfig().getExtStyle());
        attributesBuilder.Set("rows", Integer.toString(this.getTextBoxConfig().getRows()));
        writer.write(attributesBuilder.ToOutputString());
        writer.write(">");
        if (StringHelper.StringLength((String)this.getTextBoxConfig().getText()) != 0) {
            writer.write(this.getTextBoxConfig().getText());
        }
        writer.write("</textarea>");
        String strSyntaxHighlight = this.getTextBoxConfig().getSyntaxHighlight();
        if (!StringHelper.IsNullOrEmpty((String)strSyntaxHighlight)) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("editAreaLoader.init({id:'%1$s',start_highlight:true", this.getUniqueID());
            script.Append(",allow_resize:'both',allow_toggle:true,start_highlight:false");
            script.Append(",language:'en'");
            script.Append(",syntax:'%1$s'", strSyntaxHighlight.toLowerCase());
            script.Append("});");
            script.Append("Ext.EventManager.on(window,'unload',function() {editAreaLoader.delete_instance('%1$s');});", this.getUniqueID());
            this.getPage().RegisterOnReadyScript(2, script.toString());
        }
    }

    @Override
    protected void FillStyleBuilder(StyleBuilder styleBuilder) {
        super.FillStyleBuilder(styleBuilder);
        switch (this.getTextBoxConfig().getTextMode()) {
            case 4: {
                styleBuilder.AddStyle("width", "100%");
            }
        }
    }

    public String GetCaretModeScript() {
        String[] arrACCaretFormParamS;
        String strACCaretFormParamS = this.getTextBoxConfig().GetExtValue("ACCARETFORMPARAMS", "");
        if (StringHelper.IsNullOrEmpty((String)strACCaretFormParamS)) {
            return "";
        }
        StringBuilderEx sbEx = new StringBuilderEx();
        String[] stringArray = arrACCaretFormParamS = strACCaretFormParamS.split("[,]");
        int n = arrACCaretFormParamS.length;
        int n2 = 0;
        while (n2 < n) {
            String strACCaretFormParam = stringArray[n2];
            String[] arrACCaretFormParam = strACCaretFormParam.split("[|]");
            String strFormParam = "";
            String strACParam = "";
            switch (arrACCaretFormParam.length) {
                case 0: {
                    break;
                }
                case 1: {
                    strFormParam = arrACCaretFormParam[0];
                    strACParam = "realtext";
                    break;
                }
                case 2: {
                    strFormParam = arrACCaretFormParam[0];
                    strACParam = arrACCaretFormParam[1];
                    break;
                }
            }
            SRFExControl srfexCtrl = this.getForm().FindControl(strFormParam);
            SRFExTextBox srfTextArea = null;
            if (srfexCtrl instanceof SRFExTextBox) {
                srfTextArea = (SRFExTextBox)srfexCtrl;
            }
            if (srfTextArea == null) {
                log.error((Object)StringHelper.Format((String)"\u8868\u5355\u9879[%1$s]\u4e0d\u5b58\u5728", (Object)strFormParam));
            } else if (srfTextArea.getTextBoxConfig().getTextMode() != 1 && srfTextArea.getTextBoxConfig().getTextMode() != 4) {
                log.error((Object)StringHelper.Format((String)"\u8868\u5355\u9879[%1$s]\u4e3a\u975e\u591a\u884c\u6587\u672c\u6216\u8005\u8865\u5b57\u6a21\u5f0f", (Object)strFormParam));
            } else {
                sbEx.Append("$P.object['%1$s']=new SRFCaret({caretObjId:'%1$s'});", srfTextArea.getUniqueID());
            }
            ++n2;
        }
        this.getPage().RegisterScript(3, sbEx.toString());
        sbEx.Reset();
        return "";
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getTextBoxConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getTextBoxConfig().getText();
    }

    @Override
    public void setValue(String strValue) {
        this.getTextBoxConfig().setText(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)WebUtility.GetJSONText((String)this.getTextBoxConfig().getText()));
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    @Override
    public void OnInitFormPostData() {
        try {
            String strValue = null;
            strValue = this.getPage().isControlValueFromUniqueId() ? this.getPage().getRequest().getParameter(this.getUniqueID()) : this.getPage().getRequest().getParameter(this.getID().toLowerCase());
            if (strValue == null) {
                return;
            }
            this.getTextBoxConfig().setText(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$FEI(_ID,_V);");
        if (this.getTextBoxConfig().getTextMode() == 4) {
            script.Append("$FEI(_ID+'_LB',_V);");
            script.Append("$FEI(_ID+'_CARET',_V);");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACMode())) {
            script.Append("$P.AC[_ID].setDisabled(!_V);");
        }
        if (!(this.getTextBoxConfig().getTextMode() != 1 && this.getTextBoxConfig().getTextMode() != 4 || StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getSyntaxHighlight()))) {
            script.Append("try{editAreaLoader.execCommand(_ID,'set_editable',_V);}catch(e){}");
        }
        return script.toString();
    }

    @Override
    public boolean getEnabled() {
        return super.getEnabled();
    }

    @Override
    public String getItemValueJSCall(boolean getMode) {
        if (getMode) {
            if (!(this.getTextBoxConfig().getTextMode() != 1 && this.getTextBoxConfig().getTextMode() != 4 || StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getSyntaxHighlight()))) {
                return "_V=editAreaLoader.getValue(_ID);";
            }
            return "_V=$FGV(_ID);";
        }
        StringBuilderEx script = new StringBuilderEx();
        if (this.getTextBoxConfig().getTextMode() == 1 || this.getTextBoxConfig().getTextMode() == 4) {
            if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getSyntaxHighlight())) {
                script.Append("if(editAreaLoader.getValue(_ID)!=_V){editAreaLoader.setValue(_ID,_V);}");
            } else {
                script.Append("$FSV(_ID,_V);");
            }
        } else {
            script.Append("$FSV(_ID,_V);");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACMode()) && this.getTextBoxConfig().getTextMode() != 4) {
            script.Append("$P.AC['%1$s'].setValue(_V);", this.getUniqueID());
        }
        return script.toString();
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        switch (this.getTextBoxConfig().getTextMode()) {
            case 1: 
            case 4: {
                vector.add(StringHelper.Format((String)"%1$s:STOP", (Object)this.getUniqueID()));
                break;
            }
            default: {
                super.GetFocusItemIds(vector);
            }
        }
    }

    @Override
    public String getFireFIUpdateCode(String strCode) {
        if (this.getTextBoxConfig().getTextMode() == 3 && StringHelper.IsNullOrEmpty((String)this.getTextBoxConfig().getACMode())) {
            return StringHelper.Format((String)"Ext.get('%1$s').on('blur',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
        }
        return "";
    }
}
