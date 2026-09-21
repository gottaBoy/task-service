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
import SA.SRFramework.WebEx.SRFExPickerTextBox;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.DataLinkConfig;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import SA.SRFramework.WebEx.UI.PickerExConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;
import java.util.Iterator;
import java.util.Vector;

public class SRFExPickerEx
extends SRFExHidden {
    protected SRFExPickerTextBox textBox = new SRFExPickerTextBox(this);
    protected PickerExConfig pickupExConfig = null;
    public static final String TAG_TEXTBOXWIDTH = "TEXTBOXWIDTH";

    @Override
    protected void OnInit() {
        super.OnInit();
        this.AddControl(this.textBox);
    }

    @Override
    protected XMLConfig CreateConfig() {
        return new PickerExConfig();
    }

    public PickerExConfig getPickerExConfig() {
        return this.pickupExConfig;
    }

    public SRFExTextBox getTextBox() {
        return this.textBox;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.pickupExConfig = null;
        if (this.config != null && this.config instanceof PickerExConfig) {
            this.pickupExConfig = (PickerExConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        if (this.pickupExConfig != null) {
            this.textBox.setConfig(this.pickupExConfig.getTextBoxConfig());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.picker['%1$s'].pickup();", (Object)this.getUniqueID());
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.picker['%1$s']=new SRFPicker();$P.picker['%1$s'].enable=true;", this.getUniqueID());
            this.textBox.getTextBoxConfig().setTextMode(3);
            if (StringHelper.Length((String)this.textBox.getTextBoxConfig().getACMode()) > 0) {
                this.textBox.getTextBoxConfig().setReadOnly(false);
                if (this.getPickerExConfig().isShowButton()) {
                    this.textBox.getTextBoxConfig().setACHideTrigger(true);
                    this.textBox.getTextBoxConfig().setACTriggerAsAll(true);
                } else {
                    this.textBox.getTextBoxConfig().setACTriggerAsAll(true);
                }
            } else {
                this.textBox.getTextBoxConfig().setReadOnly(this.getPickerExConfig().getPickOnly());
            }
            if (this.getPickerExConfig().isShowButton()) {
                double fWidth = this.textBox.getTextBoxConfig().GetExtValue(TAG_TEXTBOXWIDTH, 1);
                this.textBox.getTextBoxConfig().setWidthEx(fWidth);
            } else if (this.textBox.getTextBoxConfig().getWidthEx() > 1.0) {
                if (this.textBox.getTextBoxConfig().getACHideTrigger()) {
                    this.textBox.getTextBoxConfig().setWidthEx(this.textBox.getTextBoxConfig().getWidthEx());
                } else {
                    this.textBox.getTextBoxConfig().setWidthEx(this.textBox.getTextBoxConfig().getWidthEx() - 15.0);
                }
            } else if (this.textBox.getTextBoxConfig().getACHideTrigger()) {
                this.textBox.getTextBoxConfig().setWidthEx(1.0);
            } else if (this.getBaseControlConfig().getWidth() > 1) {
                this.textBox.getTextBoxConfig().setWidth(this.getBaseControlConfig().getWidth());
            } else {
                this.textBox.getTextBoxConfig().setWidth(200);
            }
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write("<tr><td>");
            this.textBox.Render(writer);
            if (this.getPickerExConfig().isShowButton()) {
                writer.write("</td><td width='20'>");
                writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", strScript, this.getPickerExConfig().getImage(), this.getPickerExConfig().getTipMessage(), this.getUniqueID()));
                if (!StringHelper.IsNullOrEmpty((String)this.getPickerExConfig().getDataLinkJSCode())) {
                    script.Append("$P.picker['%1$s'].datalink=function(){", this.getUniqueID());
                    script.Append("var _V=Ext.getDom('%1$s').value;", this.getUniqueID());
                    script.Append("if(_V=='')return;");
                    script.Append("%1$s", this.getPickerExConfig().getDataLinkJSCode());
                    script.Append("};");
                    writer.write("</td><td width='20'>");
                    writer.write(String.format("<A onclick=\"javascript:$P.picker['%4$s'].datalink();\" title=\"%3$s\" href='#'><IMG id='IMGLINK_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", "", this.getPickerExConfig().getDataLinkImage(), this.getPickerExConfig().getDataLinkTipMessage(), this.getUniqueID()));
                }
                if (this.getPickerExConfig().getDataLinksConfig() != null) {
                    int nLinkIndex = 0;
                    Iterator iterator = this.getPickerExConfig().getDataLinksConfig().iterator();
                    while (iterator.hasNext()) {
                        DataLinkConfig dataLinkConfig = (DataLinkConfig)((Object)iterator.next());
                        script.Append("$P.picker['%1$s'].datalink%2$s=function(){", this.getUniqueID(), ++nLinkIndex);
                        script.Append("var _V=Ext.getDom('%1$s').value;", this.getUniqueID());
                        script.Append("if(_V=='')return;");
                        script.Append("%1$s", dataLinkConfig.getDataLinkJSCode());
                        script.Append("};");
                        writer.write("</td><td width='20'>");
                        writer.write(String.format("<A onclick=\"javascript:$P.picker['%4$s'].datalink%5$s();\" title=\"%3$s\" href='#'><IMG id='IMGLINK%5$s_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", "", dataLinkConfig.getDataLinkImage(), dataLinkConfig.getDataLinkTipMessage(), this.getUniqueID(), nLinkIndex));
                    }
                }
                if (this.getPickerExConfig().getResetEnable()) {
                    strScript = StringHelper.Format((String)"$P.picker['%1$s'].reset();", (Object)this.getUniqueID());
                    writer.write("</td><td width='20'>");
                    writer.write(String.format("<A onclick=\"javascript:%1$s\" title=\"%3$s\" href='#'><IMG id='IMG2_%4$s' src=\"%2$s\" border=\"0\" alt=\"%3$s\"></A>", strScript, this.getPickerExConfig().getResetImage(), this.getPickerExConfig().getResetTipMessage(), this.getUniqueID()));
                }
            }
            if (this.getPickerExConfig().isCompatible()) {
                writer.write("</td><td width='8'>&nbsp;");
            }
            writer.write("</td></tr></table>");
            if (this.getPickerExConfig().isShowButton()) {
                SRFExControl control;
                String strValueName;
                String strParamName;
                String[] formParamPair;
                String strFormParam;
                int i;
                String[] formParams;
                PickerDialogConfig pickerDialogConfig;
                if (this.getPickerExConfig().getResetEnable()) {
                    script.Append("$P.picker['%1$s'].reset=function(){", this.getUniqueID());
                    script.Append("if(!$P.picker['%1$s'].enable)return;", this.getUniqueID());
                    script.Append("var _F=$P.form['%1$s']._FORM;", this.getForm().getFormId());
                    script.Append("_F.S('%1$s','');", this.textBox.getUniqueID());
                    script.Append("_F.S('%1$s','');", this.getUniqueID());
                    script.Append("};");
                }
                script.Append("$P.picker['%1$s'].pickup=function(){", this.getUniqueID());
                script.Append("if(!$P.picker['%1$s'].enable)return;", this.getUniqueID());
                String strAppendFormParams = this.getPickerExConfig().getAppendFormParams();
                String strUpdateFormParams = this.getPickerExConfig().getUpdateFormParams();
                String strAppendParams = this.getPickerExConfig().getAppendParams();
                String strDialogURL = this.getPickerExConfig().getDialogURL();
                int nDialogWidth = this.getPickerExConfig().getDialogWidth();
                int nDialogHeight = this.getPickerExConfig().getDialogHeight();
                String strDialogResizable = this.getPickerExConfig().getDialogResizable();
                String strDialogScroll = this.getPickerExConfig().getDialogScroll();
                String strDialogStatus = this.getPickerExConfig().getDialogStatus();
                String strAppendURLParams = this.getPickerExConfig().getAppendURLParams();
                if (StringHelper.Length((String)this.getPickerExConfig().getPickerDialogId()) > 0 && (pickerDialogConfig = this.getWebContext().getPickerDialogMgr().Get(this.getPickerExConfig().getPickerDialogId())) != null) {
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
                script.Append("if(_DR&&_DR.ret !=undefined)");
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
                    script.Append("$P.formitem['%1$s'].setvalue(_value);", this.getUniqueID());
                }
                if (StringHelper.Length((String)this.getPickerExConfig().getOKJSCode()) > 0) {
                    script.Append(this.getPickerExConfig().getOKJSCode());
                }
                script.Append("$P.picker['%1$s'].fireselectchanged();", this.getUniqueID());
                script.Append("}else{");
                if (StringHelper.Length((String)this.getPickerExConfig().getCANCELJSCode()) > 0) {
                    script.Append(this.getPickerExConfig().getCANCELJSCode());
                }
                script.Append("}");
                script.Append("};");
            }
            this.getPage().RegisterOnReadyScript(2, script.toString());
            script.Reset();
            if (StringHelper.Length((String)this.textBox.getTextBoxConfig().getACMode()) > 0) {
                script.Reset();
                if (this.getPickerExConfig().getPickOnly()) {
                    script.Append("if($P.AC['%1$s']){", this.textBox.getUniqueID());
                    script.Append("$P.AC['%1$s'].on('select',function(_1,_2,_3){if(_2){$P.formitem['%2$s'].setvalue(_2.get('value'));$P.picker['%2$s'].fireselectchanged();}});", this.textBox.getUniqueID(), this.getUniqueID());
                    script.Append("$P.AC['%1$s'].on('blur',function(_1){var _2=_1.getValue();_2=_2.trim();if(_2.length==0){_1.lastvalue='';$P.formitem['%2$s'].setvalue('');}else{if(_2!=_1.lastvalue){_1.setValue(_1.lastvalue);$P.picker['%2$s'].fireselectchanged();}}});", this.textBox.getUniqueID(), this.getUniqueID());
                    script.Append("}");
                }
                this.getPage().RegisterOnReadyScript(2, script.toString());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPickerExConfig().getTooltipURL())) {
                script.Reset();
                script.Append(this.getHookValueChangedCode(StringHelper.Format((String)"if($P.tooltip['%1$s']){$P.tooltip['%1$s'].destroy();$P.tooltip['%1$s']=null;}if($FGV('%3$s')=='')return;$P.tooltip['%1$s']=new Ext.ToolTip({target:'%1$s',autoLoad:{url:'%2$s'+$FGV('%3$s')}});", (Object)this.textBox.getUniqueID(), (Object)this.getPickerExConfig().getTooltipURL(), (Object)this.getUniqueID())));
                this.getPage().RegisterOnReadyScript(3, script.toString());
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
        if (this.getPickerExConfig().isShowButton()) {
            script.Append("Ext.getDom('IMG_%1$s').src=_V?'%2$s':'%3$s';", this.getUniqueID(), this.getPickerExConfig().getImage(), this.getPickerExConfig().getDisableImage());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPickerExConfig().getTextBoxConfig().getACMode())) {
            script.Append("$FEI('%1$s',_V);$P.AC['%1$s'].setDisabled(!_V);", this.getTextBox().getUniqueID());
        } else if (this.getPickerExConfig().getPickOnly()) {
            script.Append("$FEI('%1$s',false);", this.getTextBox().getUniqueID());
        } else {
            script.Append("$FEI('%1$s',_V);", this.getTextBox().getUniqueID());
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
        if (!StringHelper.IsNullOrEmpty((String)this.getTextBox().getTextBoxConfig().getACMode())) {
            script.Append("$P.AC['%1$s'].setValue('');", this.getTextBox().getUniqueID());
        }
        return StringHelper.Format((String)"$FSV(_ID,_V);if(_V==''){%1$s}", (Object)script.toString());
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        vector.add(this.textBox.getUniqueID());
    }

    @Override
    public String getFireFIUpdateCode(String strCode) {
        return StringHelper.Format((String)"$P.picker['%1$s'].on('selectchanged',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }
}

