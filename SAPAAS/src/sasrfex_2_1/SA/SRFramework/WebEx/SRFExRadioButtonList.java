/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ListItem
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExRadioButton;
import SA.SRFramework.WebEx.SRFExRepeatListControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.RadioButtonListConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExRadioButtonList
extends SRFExRepeatListControl {
    protected RadioButtonListConfig radioButtonListConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new RadioButtonListConfig();
    }

    public RadioButtonListConfig getRadioButtonListConfig() {
        return this.radioButtonListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.radioButtonListConfig = null;
        if (this.config != null && this.config instanceof RadioButtonListConfig) {
            this.radioButtonListConfig = (RadioButtonListConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.radioButtonListConfig != null) {
            String strControlParamList = "";
            int nSize = this.radioButtonListConfig.getListItems().size();
            int i = 0;
            while (i < nSize) {
                ListItem listItem = this.radioButtonListConfig.getListItems().Get(i);
                String strRadioButtonId = StringHelper.Format((String)"RADIO_%1$s", (Object)i);
                SRFExRadioButton radioButton = new SRFExRadioButton();
                radioButton.InitConfig();
                radioButton.setID(strRadioButtonId);
                radioButton.setName(this.getUniqueID());
                radioButton.setValue(listItem.getValue());
                radioButton.getRadioButtonConfig().setCssClass(this.getRadioButtonListConfig().getItemCssClass());
                this.AddControl(radioButton);
                if (StringHelper.Length((String)strControlParamList) > 0) {
                    strControlParamList = String.valueOf(strControlParamList) + ",";
                }
                strControlParamList = String.valueOf(strControlParamList) + StringHelper.Format((String)"'%1$s'", (Object)radioButton.getUniqueID());
                ++i;
            }
            if (this.getForm() != null) {
                this.getForm().SetParam(StringHelper.Format((String)"%1$s_radiolist", (Object)this.getID()), StringHelper.Format((String)"[%1$s]", (Object)strControlParamList));
            }
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExRadioButton radioButton;
            String strRadioButtonId;
            SRFExControl control;
            ListItem listItem;
            if (StringHelper.Length((String)this.getRadioButtonListConfig().getSelectChangedJSCode()) > 0) {
                writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
                writer.write(StringHelper.Format((String)"$P.func['%1$s'] = function(){%2$s};", (Object)this.getUniqueID(), (Object)this.getRadioButtonListConfig().getSelectChangedJSCode()));
                writer.write("</SCRIPT>");
            }
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", this.radioButtonListConfig.getWidthString());
            styleBuilder.AddStyle("height", this.radioButtonListConfig.getHeightString());
            String strClass = "sx-panel";
            if (StringHelper.Length((String)this.radioButtonListConfig.getCssClass()) > 0) {
                strClass = this.radioButtonListConfig.getCssClass();
            }
            writer.write("<DIV ");
            SRFExRadioButtonList.OutputAttribute(writer, "class", strClass);
            SRFExRadioButtonList.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.radioButtonListConfig.getExtStyle());
            writer.write(" >");
            styleBuilder.RemoveAllStyle();
            if (this.radioButtonListConfig.getItemWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)this.radioButtonListConfig.getItemWidth()));
            }
            if (this.radioButtonListConfig.getItemHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)this.radioButtonListConfig.getItemHeight()));
            }
            if (!this.radioButtonListConfig.getFlowLeft()) {
                styleBuilder.AddStyle("float", "none");
            }
            String strCaptionCssClass = this.radioButtonListConfig.getCaptionCssClass();
            int nSize = this.radioButtonListConfig.getListItems().size();
            int i = 0;
            while (i < nSize) {
                listItem = this.radioButtonListConfig.getListItems().Get(i);
                if (listItem != null && (control = this.FindControl(strRadioButtonId = StringHelper.Format((String)"RADIO_%1$s", (Object)i))) != null) {
                    radioButton = (SRFExRadioButton)control;
                    if (StringHelper.Compare((String)radioButton.getRadioButtonConfig().getValue(), (String)this.radioButtonListConfig.getSelectedValue(), (boolean)false) == 0) {
                        radioButton.getRadioButtonConfig().setChecked(true);
                    }
                    writer.write("<DIV ");
                    SRFExRadioButtonList.OutputAttribute(writer, "class", "sx-ctrlpanel");
                    SRFExRadioButtonList.OutputAttribute(writer, "style", styleBuilder.ToStyleList());
                    writer.write(" >");
                    radioButton.getRadioButtonConfig().setReadOnly(this.radioButtonListConfig.getReadOnly());
                    radioButton.Render(writer);
                    writer.write("<SPAN ");
                    if (StringHelper.Length((String)strCaptionCssClass) > 0) {
                        SRFExRadioButtonList.OutputAttribute(writer, "class", strCaptionCssClass);
                    }
                    writer.write(">");
                    writer.write(listItem.getText());
                    writer.write("</SPAN>");
                    writer.write("</DIV>");
                }
                ++i;
            }
            writer.write("</DIV>");
            if (StringHelper.Length((String)this.getRadioButtonListConfig().getSelectChangedJSCode()) > 0) {
                writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
                i = 0;
                while (i < nSize) {
                    listItem = this.radioButtonListConfig.getListItems().Get(i);
                    if (listItem != null && (control = this.FindControl(strRadioButtonId = StringHelper.Format((String)"RADIO_%1$s", (Object)i))) != null) {
                        radioButton = (SRFExRadioButton)control;
                        writer.write(StringHelper.Format((String)"Ext.get('%1$s').on('click',$P.func['%2$s']);", (Object)radioButton.getUniqueID(), (Object)this.getUniqueID()));
                    }
                    ++i;
                }
                writer.write("</SCRIPT>");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getRadioButtonListConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getRadioButtonListConfig().getSelectedValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getRadioButtonListConfig().setSelectedValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getValue());
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
            this.getRadioButtonListConfig().setSelectedValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V=SRFForm.getRadioListValue(%1$s.%2$s_radiolist) ;", (Object)this.getForm().getFormId(), (Object)this.getID());
        }
        return StringHelper.Format((String)"SRFForm.setRadioListValue(%1$s.%2$s_radiolist, _V);", (Object)this.getForm().getFormId(), (Object)this.getID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$FEI4(%1$s.%2$s_radiolist,_V);", (Object)this.getForm().getFormId(), (Object)this.getID());
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        int nSize = this.radioButtonListConfig.getListItems().size();
        int i = 0;
        while (i < nSize) {
            String strRadioButtonId;
            SRFExControl control;
            ListItem listItem = this.radioButtonListConfig.getListItems().Get(i);
            if (listItem != null && (control = this.FindControl(strRadioButtonId = StringHelper.Format((String)"RADIO_%1$s", (Object)i))) != null) {
                vector.add(control.getUniqueID());
            }
            ++i;
        }
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC3(%1$s.%2$s_radiolist, function(){%3$s});", (Object)this.getForm().getFormId(), (Object)this.getID(), (Object)strCode);
    }
}

