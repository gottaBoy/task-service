/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.MultiPickerConfig;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;
import java.util.Vector;

public class SRFExMultiPicker
extends SRFExHidden {
    protected SRFExTextBox textBox = new SRFExTextBox();
    protected MultiPickerConfig multiPickupExConfig = null;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.AddControl(this.textBox);
    }

    @Override
    protected XMLConfig CreateConfig() {
        return new MultiPickerConfig();
    }

    public MultiPickerConfig getMultiPickerConfig() {
        return this.multiPickupExConfig;
    }

    public SRFExTextBox getTextBox() {
        return this.textBox;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.multiPickupExConfig = null;
        if (this.config != null && this.config instanceof MultiPickerConfig) {
            this.multiPickupExConfig = (MultiPickerConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        if (this.multiPickupExConfig != null) {
            this.textBox.setConfig(this.multiPickupExConfig.getTextBoxConfig());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.picker['%1$s'].pickup();", (Object)this.getUniqueID());
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.picker['%1$s']={};$P.picker['%1$s'].enable=true;", this.getUniqueID());
            this.textBox.getTextBoxConfig().SetExtAttribute("readonly", "readonly");
            if (this.getMultiPickerConfig().isShowButton()) {
                this.textBox.getTextBoxConfig().setWidthEx(1.0);
            } else if (this.textBox.getTextBoxConfig().getWidthEx() > 1.0) {
                this.textBox.getTextBoxConfig().setWidthEx(this.textBox.getTextBoxConfig().getWidthEx());
            } else {
                this.textBox.getTextBoxConfig().setWidthEx(200.0);
            }
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write("<tr><td>");
            this.textBox.Render(writer);
            if (this.getMultiPickerConfig().isShowButton()) {
                writer.write("</td><td width='20'>");
                writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", strScript, this.getMultiPickerConfig().getImage(), this.getMultiPickerConfig().getTipMessage(), this.getUniqueID()));
                if (this.getMultiPickerConfig().getResetEnable()) {
                    strScript = StringHelper.Format((String)"$P.picker['%1$s'].reset();", (Object)this.getUniqueID());
                    writer.write("</td><td width='20'>");
                    writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG2_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", strScript, this.getMultiPickerConfig().getResetImage(), this.getMultiPickerConfig().getResetTipMessage(), this.getUniqueID()));
                }
            }
            if (this.getMultiPickerConfig().isCompatible()) {
                writer.write("</td><td width='8'>&nbsp;");
            }
            writer.write("</td></tr></table>");
            if (this.getMultiPickerConfig().isShowButton()) {
                SRFExControl control;
                String strValueName;
                String strParamName;
                String[] formParamPair;
                String strFormParam;
                int i;
                String[] formParams;
                PickerDialogConfig pickerDialogConfig;
                if (this.getMultiPickerConfig().getResetEnable()) {
                    script.Append("$P.picker['%1$s'].reset=function(){", this.getUniqueID());
                    script.Append("if(!$P.picker['%1$s'].enable)return;", this.getUniqueID());
                    script.Append("var _F=$P.form['%1$s']._FORM;", this.getForm().getFormId());
                    script.Append("_F.S('%1$s','');", this.textBox.getUniqueID());
                    script.Append("_F.S('%1$s','');", this.getUniqueID());
                    script.Append("};");
                }
                script.Append("$P.picker['%1$s'].pickup=function(){", this.getUniqueID());
                script.Append("if(!$P.picker['%1$s'].enable)return;", this.getUniqueID());
                String strAppendFormParams = this.getMultiPickerConfig().getAppendFormParams();
                String strUpdateFormParams = this.getMultiPickerConfig().getUpdateFormParams();
                String strAppendParams = this.getMultiPickerConfig().getAppendParams();
                String strDialogURL = this.getMultiPickerConfig().getDialogURL();
                int nDialogWidth = this.getMultiPickerConfig().getDialogWidth();
                int nDialogHeight = this.getMultiPickerConfig().getDialogHeight();
                String strDialogResizable = this.getMultiPickerConfig().getDialogResizable();
                String strDialogScroll = this.getMultiPickerConfig().getDialogScroll();
                String strDialogStatus = this.getMultiPickerConfig().getDialogStatus();
                String strAppendURLParams = this.getMultiPickerConfig().getAppendURLParams();
                if (StringHelper.Length((String)this.getMultiPickerConfig().getPickerDialogId()) > 0 && (pickerDialogConfig = this.getWebContext().getPickerDialogMgr().Get(this.getMultiPickerConfig().getPickerDialogId())) != null) {
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
                if (StringHelper.Length((String)(strAppendParams = this.getPage().getWebContext().GetParamsString(strAppendParams))) > 0) {
                    strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                    strDialogURL = String.valueOf(strDialogURL) + strAppendParams;
                }
                if (!StringHelper.IsNullOrEmpty((String)strAppendURLParams)) {
                    strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                    strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
                }
                strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                script.Append("if(Ext.getDom('IMG_%1$s').style.visibility=='hidden') return;", this.getUniqueID());
                script.Append("var _URL='%1$s';", strDialogURL);
                script.Append("var _PARAMS={};");
                if (this.getForm() != null) {
                    script.Append("var _F=$P.form['%1$s']._FORM;", this.getForm().getFormId());
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
                                if ((control = this.getForm().FindControl(strValueName)) != null) {
                                    script.Append("_PARAMS['%1$s']=_F.G('%2$s');", strParamName, control.getUniqueID());
                                }
                            }
                            ++i;
                        }
                    }
                    script.Append("_PARAMS['%1$s']=_F.G('%2$s');", "PICKUPTEXT", this.getTextBox().getUniqueID());
                    script.Append("_PARAMS['%1$s']=_F.G('%2$s');", "PICKUPVALUE", this.getUniqueID());
                }
                script.Append("_URL+=Ext.urlEncode(_PARAMS);");
                script.Append(BrowserJSHelper.getShowDialogScriptEx(null, "_URL", "", nDialogWidth, nDialogHeight, strDialogResizable, strDialogScroll, strDialogStatus));
                script.Append("var _DR=_DIALOGRESULT;");
                script.Append("var _ret='';");
                script.Append("if(_DR&&_DR.ret!=undefined)");
                script.Append("_ret=_DR.ret;\r\n");
                script.Append("if(_ret=='ok'){");
                script.Append("var _text=$V(_DR.text,'');");
                script.Append("var _value=$V(_DR.value,'');");
                if (this.getForm() != null) {
                    script.Append("_F.S('%1$s',_text);", this.textBox.getUniqueID());
                    script.Append("_F.S('%1$s',_value);", this.getUniqueID());
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
                                if ((control = this.getForm().FindControl(strValueName)) != null) {
                                    script.Append("_F.S('%1$s',$V(_DR.%2$s,''));", control.getUniqueID(), strParamName.toLowerCase());
                                }
                            }
                            ++i;
                        }
                    }
                } else {
                    script.Append("Ext.getDom('%1$s').value=_text;", this.textBox.getUniqueID());
                    script.Append("Ext.getDom('%1$s').value=_value;", this.getUniqueID());
                }
                if (StringHelper.Length((String)this.getMultiPickerConfig().getOKJSCode()) > 0) {
                    script.Append(this.getMultiPickerConfig().getOKJSCode());
                }
                script.Append("}else{");
                if (StringHelper.Length((String)this.getMultiPickerConfig().getCANCELJSCode()) > 0) {
                    script.Append(this.getMultiPickerConfig().getCANCELJSCode());
                }
                script.Append("}");
                script.Append("};");
                this.getPage().RegisterOnReadyScript(3, script.toString());
                script.Reset();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if($P.picker['%1$s']){$P.picker['%1$s'].enable =_V;}", this.getUniqueID());
        if (this.getMultiPickerConfig().isShowButton()) {
            script.Append("Ext.getDom('IMG_%1$s').src=_V?'%2$s':'%3$s';", this.getUniqueID(), this.getMultiPickerConfig().getImage(), this.getMultiPickerConfig().getDisableImage());
        }
        return script.toString();
    }

    @Override
    public void setEnabled(boolean bEnabled) {
        this.getTextBox().setEnabled(bEnabled);
        super.setEnabled(bEnabled);
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V=$FGV(_ID);";
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$FSV('%1$s','');", this.getTextBox().getUniqueID());
        return StringHelper.Format((String)"$FSV(_ID,_V);if(_V==''){%1$s}", (Object)script.toString());
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
    }
}

