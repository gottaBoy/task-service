/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.ISRFExFormItem2;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.ListBoxPickupConfig;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExListBoxPickup
extends SRFExListControl
implements ISRFExFormItem2 {
    protected ListBoxPickupConfig listBoxPickupConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";
    public static int IMAGE_WIDTH = 20;

    @Override
    protected XMLConfig CreateConfig() {
        return new ListBoxPickupConfig();
    }

    public ListBoxPickupConfig getListBoxPickupConfig() {
        return this.listBoxPickupConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.listBoxPickupConfig = null;
        if (this.config != null && this.config instanceof ListBoxPickupConfig) {
            this.listBoxPickupConfig = (ListBoxPickupConfig)this.config;
        }
    }

    @Override
    public void setForm(SRFExBaseForm form) {
        super.setForm(form);
        if (form != null && this.listBoxPickupConfig != null && !(form instanceof SRFExSearchForm)) {
            this.getForm().UpdateFormItem(this.listBoxPickupConfig.getID());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            PickerDialogConfig pickerDialogConfig;
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.picker['%1$s'].pickup();", (Object)this.getUniqueID());
            int nWidth = this.getBaseControlConfig().getWidth();
            int nListBoxWidth = 0;
            if (nWidth != 0 && nWidth > IMAGE_WIDTH) {
                nListBoxWidth = nWidth - IMAGE_WIDTH;
            }
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table border='0' cellspacing='0' cellpadding='0' style='width:%1$s;table-layout:fixed;'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write(StringHelper.Format((String)"<tr><td ID='C%1$s' >", (Object)this.getUniqueID()));
            writer.write(this.OutputItem());
            writer.write("</td>");
            writer.write(StringHelper.Format((String)"<td width='2'></td><td ID='%2$s_CTRLTD' width='%1$s' valign='top' align='center' style='padding-top:4px;'>", (Object)IMAGE_WIDTH, (Object)this.getUniqueID()));
            if (this.getListBoxPickupConfig().isAddButton()) {
                writer.write(String.format("<A href='#' title='%2$s' onclick=\"javascript:%1$s\"><IMG id='IMG_ADD_%3$s' src='../sasrfex/images/default/icon_pickup.png' align=\"absMiddle\" border=\"0\" alt=\"%2$s\"></A><BR><BR>", strScript, this.getListBoxPickupConfig().getTipMessage(), this.getUniqueID()));
                writer.write("<SPAN style='height:4px;' ></SPAN>");
            }
            if (this.getListBoxPickupConfig().isRemoveButton()) {
                strScript = StringHelper.Format((String)"SRFForm.removeListBoxValue('%1$s')", (Object)this.getUniqueID());
                writer.write(String.format("<A  href='#' title='%2$s' onclick=\"javascript:%1$s\"><IMG id='IMG_REMOVE_%3$s' src='../sasrfex/images/default/icon_remove.png' align=\"absMiddle\" border=\"0\" alt=\"%2$s\"></A>", strScript, "\u70b9\u51fb\u5220\u9664\u9009\u4e2d\u6570\u636e", this.getUniqueID()));
            }
            writer.write("</td></tr>");
            writer.write("</table>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.picker['%1$s']={};", this.getUniqueID());
            script.Append("$P.picker['%1$s'].pickup=function(){", this.getUniqueID());
            String strAppendFormParams = this.getListBoxPickupConfig().getAppendFormParams();
            String strAppendParams = this.getListBoxPickupConfig().getAppendParams();
            String strDialogURL = this.getListBoxPickupConfig().getDialogURL();
            int nDialogWidth = this.getListBoxPickupConfig().getDialogWidth();
            int nDialogHeight = this.getListBoxPickupConfig().getDialogHeight();
            String strDialogResizable = this.getListBoxPickupConfig().getDialogResizable();
            String strDialogScroll = this.getListBoxPickupConfig().getDialogScroll();
            String strDialogStatus = this.getListBoxPickupConfig().getDialogStatus();
            if (StringHelper.Length((String)this.getListBoxPickupConfig().getPickerDialogId()) > 0 && (pickerDialogConfig = this.getWebContext().getPickerDialogMgr().Get(this.getListBoxPickupConfig().getPickerDialogId())) != null) {
                if (StringHelper.Length((String)strAppendParams) == 0) {
                    strAppendParams = pickerDialogConfig.getAppendParams();
                }
                if (StringHelper.Length((String)strDialogURL) == 0) {
                    strDialogURL = pickerDialogConfig.getDialogURL();
                }
                if (StringHelper.Length((String)strAppendFormParams) == 0) {
                    strAppendFormParams = pickerDialogConfig.getAppendFormParams();
                }
                nDialogWidth = pickerDialogConfig.getDialogWidth();
                nDialogHeight = pickerDialogConfig.getDialogHeight();
                strDialogResizable = pickerDialogConfig.getDialogResizable();
                strDialogScroll = pickerDialogConfig.getDialogScroll();
                strDialogStatus = pickerDialogConfig.getDialogStatus();
            }
            if (StringHelper.Length((String)(strAppendParams = this.getPage().getWebContext().GetParamsString(strAppendParams))) > 0) {
                strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                strDialogURL = String.valueOf(strDialogURL) + strAppendParams;
            }
            strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
            script.Append("var _URL='%1$s';", strDialogURL);
            script.Append("var _PARAMS = {};");
            if (this.getForm() != null && StringHelper.Length((String)strAppendFormParams) > 0) {
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
                            script.Append("_PARAMS['%1$s']=$P.form['%2$s']._FORM.G('%3$s');", strParamName, this.getForm().getFormId(), control.getUniqueID());
                        }
                    }
                    ++i;
                }
            }
            script.Append("_URL+=Ext.urlEncode(_PARAMS);");
            script.Append(BrowserJSHelper.getShowDialogScriptEx(null, "_URL", "", nDialogWidth, nDialogHeight, strDialogResizable, strDialogScroll, strDialogStatus));
            script.Append("var _ret='cancel';\r\n");
            script.Append("if(_DIALOGRESULT&&_DIALOGRESULT.ret!=undefined)\r\n ");
            script.Append("_ret =_DIALOGRESULT.ret; \r\n");
            script.Append("if(_ret=='ok'){");
            script.Append("var _text = $V(_DIALOGRESULT.text,'');");
            script.Append("var _value = $V(_DIALOGRESULT.value,'');\r\n");
            script.Append("var _arrText=_text.split(\"|\");");
            script.Append("var _arrValue=_value.split(\"|\");\r\n");
            script.Append("for(var i=0; i< _arrValue.length; i++){\r\n");
            script.Append("if(_arrValue[i]=='')continue;\r\n");
            script.Append("SRFForm.addListBoxValue('%1$s',_arrText[i],_arrValue[i]);\r\n", this.getUniqueID());
            script.Append("}");
            if (StringHelper.Length((String)this.getListBoxPickupConfig().getOKJSCode()) > 0) {
                script.Append(this.getListBoxPickupConfig().getOKJSCode());
            }
            script.Append("}else{");
            if (StringHelper.Length((String)this.getListBoxPickupConfig().getCANCELJSCode()) > 0) {
                script.Append(this.getListBoxPickupConfig().getCANCELJSCode());
            }
            script.Append("}");
            script.Append("};");
            this.getPage().RegisterOnReadyScript(3, script.toString());
            script.Reset();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getListBoxPickupConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getListBoxPickupConfig().getSelectedValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getListBoxPickupConfig().setSelectedValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getListBoxPickupConfig().getSelectedValue());
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
            this.getListBoxPickupConfig().setSelectedValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (this.getListBoxPickupConfig().isValueAsXML()) {
            if (bGetMode) {
                return StringHelper.Format((String)"_V = SRFForm.getListBoxPickupValue(_ID,'%1$s') ;", (Object)this.getListBoxPickupConfig().getSeparator());
            }
            return StringHelper.Format((String)"SRFForm.setListBoxPickupValue(_ID, _V,'%1$s');", (Object)this.getListBoxPickupConfig().getSeparator());
        }
        if (bGetMode) {
            return StringHelper.Format((String)"_V = SRFForm.getListBoxValue2(_ID,'%1$s') ;", (Object)this.getListBoxPickupConfig().getSeparator());
        }
        return StringHelper.Format((String)"SRFForm.setListBoxValue(_ID, _V,'%1$s');", (Object)this.getListBoxPickupConfig().getSeparator());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$FEI3(_ID,_V);$FEI2('%1$s_CTRLTD',_V);", (Object)this.getUniqueID());
    }

    @Override
    public boolean UpdateItem(Vector vector) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)StringHelper.Format((String)"C%1$s", (Object)this.getUniqueID()));
        obj.put("html", (Object)this.OutputItem());
        vector.add(obj);
        return true;
    }

    private String OutputItem() {
        StringBuilderEx writer = new StringBuilderEx();
        int nWidth = this.getBaseControlConfig().getWidth();
        int nListBoxWidth = 0;
        if (nWidth != 0 && nWidth > IMAGE_WIDTH) {
            nListBoxWidth = nWidth - IMAGE_WIDTH;
        }
        int nHeight = this.getBaseControlConfig().getHeight();
        writer.Append("<select ");
        this.OutputID(writer.getWriter());
        this.OutputName(writer.getWriter());
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getListBoxPickupConfig().getExtAttributes(), true);
        this.FillAttributeBuilder(attributesBuilder);
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$s", (Object)"100%"));
        if (nHeight > 0) {
            styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)nHeight));
        }
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getListBoxPickupConfig().getExtStyle());
        attributesBuilder.Set("size", Integer.toString(this.getListBoxPickupConfig().getRowCount()));
        attributesBuilder.Set("multiple", "multiple");
        writer.Append(attributesBuilder.ToOutputString());
        writer.Append(">");
        writer.Append("</select>");
        return writer.toString();
    }
}

