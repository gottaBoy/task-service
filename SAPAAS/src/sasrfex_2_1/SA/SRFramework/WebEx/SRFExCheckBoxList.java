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
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExCheckBox;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExRepeatListControl;
import SA.SRFramework.WebEx.UI.CheckBoxListConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.PanelConfig;
import java.io.Writer;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExCheckBoxList
extends SRFExRepeatListControl {
    protected CheckBoxListConfig checkBoxListConfig = null;
    protected TreeMap<String, SRFExControl> valuePanelMap = new TreeMap();

    @Override
    protected XMLConfig CreateConfig() {
        return new CheckBoxListConfig();
    }

    public CheckBoxListConfig getCheckBoxListConfig() {
        return this.checkBoxListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.checkBoxListConfig = null;
        if (this.config != null && this.config instanceof CheckBoxListConfig) {
            this.checkBoxListConfig = (CheckBoxListConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.valuePanelMap.clear();
        this.RemoveControls();
        if (this.checkBoxListConfig != null) {
            String strControlParamList = "";
            if (this.checkBoxListConfig.getEnableCheckAll()) {
                String strCheckBoxId = StringHelper.Format((String)"DDL_ALL");
                SRFExDropDownList list = new SRFExDropDownList();
                list.InitConfig();
                list.setID(strCheckBoxId);
                list.setName(this.getUniqueID());
                list.getDropDownListConfig().setWidth(70);
                list.getDropDownListConfig().setCssClass(this.getCheckBoxListConfig().getItemCssClass());
                list.getDropDownListConfig().getListItems().Add(new ListItem("\u9009\u62e9", ""));
                list.getDropDownListConfig().getListItems().Add(new ListItem("\u5168\u90e8\u9009\u4e2d", "1"));
                list.getDropDownListConfig().getListItems().Add(new ListItem("\u5168\u90e8\u53d6\u6d88", "2"));
                list.getDropDownListConfig().getListItems().Add(new ListItem("\u53cd\u5411\u9009\u62e9", "3"));
                this.AddControl(list);
            }
            int nSize = this.checkBoxListConfig.getListItems().size();
            int i = 0;
            while (i < nSize) {
                ListItem listItem = this.checkBoxListConfig.getListItems().Get(i);
                if (!StringHelper.IsNullOrEmpty((String)listItem.getValue())) {
                    String strCheckBoxId = StringHelper.Format((String)"CB_%1$s", (Object)i);
                    SRFExCheckBox checkBox = new SRFExCheckBox();
                    checkBox.InitConfig();
                    checkBox.setID(strCheckBoxId);
                    checkBox.setName(this.getUniqueID());
                    checkBox.getCheckBoxConfig().setValue(listItem.getValue());
                    checkBox.getCheckBoxConfig().setCssClass(this.getCheckBoxListConfig().getItemCssClass());
                    checkBox.getCheckBoxConfig().setChecked(false);
                    this.AddControl(checkBox);
                    if (StringHelper.Length((String)strControlParamList) > 0) {
                        strControlParamList = String.valueOf(strControlParamList) + ",";
                    }
                    strControlParamList = String.valueOf(strControlParamList) + StringHelper.Format((String)"'%1$s'", (Object)checkBox.getUniqueID());
                }
                ++i;
            }
            if (this.checkBoxListConfig.getValuePanelConfigs() != null) {
                for (PanelConfig panelConfig : this.checkBoxListConfig.getValuePanelConfigs()) {
                    SRFExControl panel = SRFExBasePanel.CreatePanel((Object)panelConfig);
                    panel.setConfig(panelConfig);
                    this.AddControl(panel);
                    this.valuePanelMap.put(panelConfig.GetExtValue("VALUE", ""), panel);
                }
            }
            if (this.getForm() != null) {
                this.getForm().SetParam(StringHelper.Format((String)"%1$s_checklist", (Object)this.getID()), StringHelper.Format((String)"[%1$s]", (Object)strControlParamList));
            }
        }
    }

    public SRFExCheckBox FindCheckBoxByValue(String strValue) {
        for (Object control : this.GetControls()) {
            SRFExCheckBox checkBox;
            if (!(control instanceof SRFExCheckBox) || StringHelper.Compare((String)(checkBox = (SRFExCheckBox)control).getCheckBoxConfig().getValue(), (String)strValue, (boolean)true) != 0) continue;
            return checkBox;
        }
        return null;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", this.checkBoxListConfig.getWidthString());
            styleBuilder.AddStyle("height", this.checkBoxListConfig.getHeightString());
            String strClass = "sx-panel";
            if (StringHelper.Length((String)this.checkBoxListConfig.getCssClass()) > 0) {
                strClass = this.checkBoxListConfig.getCssClass();
            }
            writer.write(StringHelper.Format((String)"<DIV ID='C%1$s' ", (Object)this.getUniqueID()));
            SRFExCheckBoxList.OutputAttribute(writer, "class", strClass);
            SRFExCheckBoxList.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.checkBoxListConfig.getExtStyle());
            writer.write(" >");
            styleBuilder.RemoveAllStyle();
            if (this.checkBoxListConfig.getItemWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)this.checkBoxListConfig.getItemWidth()));
            }
            if (this.checkBoxListConfig.getItemHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)this.checkBoxListConfig.getItemHeight()));
            }
            if (!this.checkBoxListConfig.getFlowLeft()) {
                styleBuilder.AddStyle("float", "none");
            }
            TreeMap<String, Boolean> valuePanelRenderMap = new TreeMap<String, Boolean>();
            String strCaptionCssClass = this.checkBoxListConfig.getCaptionCssClass();
            if (this.checkBoxListConfig.getEnableCheckAll()) {
                writer.write("<table><tr><td valign='top' style='padding:2px'>");
                String strCheckBoxId = StringHelper.Format((String)"DDL_ALL");
                SRFExControl control = this.FindControl(strCheckBoxId);
                if (control == null) {
                    return;
                }
                writer.write("<DIV>");
                SRFExDropDownList list = (SRFExDropDownList)control;
                writer.write("<DIV ");
                SRFExCheckBoxList.OutputAttribute(writer, "class", "sx-ctrlpanel");
                SRFExCheckBoxList.OutputAttribute(writer, "style", styleBuilder.ToStyleList());
                writer.write(" >");
                list.Render(writer);
                writer.write("</DIV>");
                writer.write("</td><td valign='top' style='padding:2px'>");
                StringBuilderEx script = new StringBuilderEx();
                script.Append("var A=Ext.getDom('%1$s').value;", control.getUniqueID());
                script.Append("SRFForm.setCheckListValue3(%1$s.%2$s_checklist, A);", this.getForm().getFormId(), this.getID());
                script.Append("Ext.getDom('%1$s').value='';", control.getUniqueID());
                this.getPage().RegisterScript(3, StringHelper.Format((String)"$FVC2('%1$s',function(){%2$s});", (Object)control.getUniqueID(), (Object)script.toString()));
            }
            int nSize = this.checkBoxListConfig.getListItems().size();
            int i = 0;
            while (i < nSize) {
                String strCheckBoxId;
                SRFExControl control;
                ListItem listItem = this.checkBoxListConfig.getListItems().Get(i);
                if (listItem != null && !StringHelper.IsNullOrEmpty((String)listItem.getValue()) && (control = this.FindControl(strCheckBoxId = StringHelper.Format((String)"CB_%1$s", (Object)i))) != null) {
                    SRFExControl panel = this.valuePanelMap.get(listItem.getValue());
                    if (panel != null) {
                        int nTotalWidth = this.checkBoxListConfig.getItemWidth();
                        writer.write("<DIV ");
                        SRFExCheckBoxList.OutputAttribute(writer, "class", "sx-panel");
                        SRFExCheckBoxList.OutputAttribute(writer, "style", StringHelper.Format((String)"padding:2px;width:%1$spx", (Object)(nTotalWidth += panel.getBaseControlConfig().getWidth())));
                        writer.write(" >");
                    }
                    SRFExCheckBox checkBox = (SRFExCheckBox)control;
                    writer.write("<DIV ");
                    SRFExCheckBoxList.OutputAttribute(writer, "class", "sx-ctrlpanel");
                    SRFExCheckBoxList.OutputAttribute(writer, "style", styleBuilder.ToStyleList());
                    writer.write(" >");
                    checkBox.getCheckBoxConfig().setReadOnly(this.checkBoxListConfig.getReadOnly());
                    checkBox.Render(writer);
                    writer.write("<SPAN ");
                    if (StringHelper.Length((String)strCaptionCssClass) > 0) {
                        SRFExCheckBoxList.OutputAttribute(writer, "class", strCaptionCssClass);
                    }
                    writer.write(">");
                    writer.write(listItem.getText());
                    writer.write("</SPAN>");
                    writer.write("</DIV>");
                    if (panel != null) {
                        panel.Render(writer);
                        valuePanelRenderMap.put(listItem.getValue(), true);
                        writer.write("</DIV>");
                    }
                }
                ++i;
            }
            for (String strValue : this.valuePanelMap.keySet()) {
                if (valuePanelRenderMap.containsKey(strValue)) continue;
                this.valuePanelMap.get(strValue).Render(writer);
            }
            if (this.checkBoxListConfig.getEnableCheckAll()) {
                writer.write("</td></tr></table>");
            }
            writer.write("</DIV>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getCheckBoxListConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getCheckBoxListConfig().getSelectedValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getCheckBoxListConfig().setSelectedValue(strValue);
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
            this.getCheckBoxListConfig().setSelectedValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (this.getCheckBoxListConfig().getNumberOrMode()) {
            if (bGetMode) {
                return StringHelper.Format((String)"_V=SRFForm.getCheckListValue2(%1$s.%2$s_checklist) ;", (Object)this.getForm().getFormId(), (Object)this.getID());
            }
            return StringHelper.Format((String)"SRFForm.setCheckListValue2(%1$s.%2$s_checklist, _V);", (Object)this.getForm().getFormId(), (Object)this.getID());
        }
        if (bGetMode) {
            return StringHelper.Format((String)"_V=SRFForm.getCheckListValue(%1$s.%2$s_checklist,'%3$s') ;", (Object)this.getForm().getFormId(), (Object)this.getID(), (Object)this.getCheckBoxListConfig().getSeparator());
        }
        return StringHelper.Format((String)"SRFForm.setCheckListValue(%1$s.%2$s_checklist, _V,'%3$s');", (Object)this.getForm().getFormId(), (Object)this.getID(), (Object)this.getCheckBoxListConfig().getSeparator());
    }

    @Override
    public String getItemEnableStateJSCall() {
        if (this.checkBoxListConfig.getEnableCheckAll()) {
            String strCheckBoxId = StringHelper.Format((String)"DDL_ALL");
            SRFExControl control = this.FindControl(strCheckBoxId);
            if (control == null) {
                return "";
            }
            return StringHelper.Format((String)"{$FEI4(%1$s.%2$s_checklist, _V);$FEI3('%3$s', _V);}", (Object)this.getForm().getFormId(), (Object)this.getID(), (Object)control.getUniqueID());
        }
        return StringHelper.Format((String)"$FEI4(%1$s.%2$s_checklist, _V);", (Object)this.getForm().getFormId(), (Object)this.getID());
    }

    public boolean UpdateCodeList(Vector vector, String strCodeListId) {
        CodeListConfig codeListConfig = this.getPage().getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getWebContext().getLocalization());
        if (codeListConfig != null) {
            StringBuilderEx stringBuilder = new StringBuilderEx();
            ArrayList list = codeListConfig.getCodeItems();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.RemoveAllStyle();
            if (this.checkBoxListConfig.getItemWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)this.checkBoxListConfig.getItemWidth()));
            }
            if (!this.checkBoxListConfig.getFlowLeft()) {
                styleBuilder.AddStyle("float", "none");
            }
            String strCaptionCssClass = this.checkBoxListConfig.getCaptionCssClass();
            int nSize = list.size();
            int i = 0;
            while (i < nSize) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)list.get(i));
                String strCheckBoxId = StringHelper.Format((String)"CB_%1$s", (Object)i);
                SRFExControl control = this.FindControl(strCheckBoxId);
                if (control != null) {
                    SRFExCheckBox checkBox = (SRFExCheckBox)control;
                    checkBox.getCheckBoxConfig().setValue(codeItemConfig.getValue());
                    checkBox.getCheckBoxConfig().setChecked(false);
                    stringBuilder.Append("<DIV ");
                    SRFExCheckBoxList.OutputAttribute(stringBuilder.getWriter(), "class", "sx-ctrlpanel");
                    SRFExCheckBoxList.OutputAttribute(stringBuilder.getWriter(), "style", styleBuilder.ToStyleList());
                    stringBuilder.Append(" >");
                    checkBox.getCheckBoxConfig().setReadOnly(this.checkBoxListConfig.getReadOnly());
                    checkBox.Render(stringBuilder.getWriter());
                    stringBuilder.Append("<SPAN ");
                    if (StringHelper.Length((String)strCaptionCssClass) > 0) {
                        SRFExCheckBoxList.OutputAttribute(stringBuilder.getWriter(), "class", strCaptionCssClass);
                    }
                    stringBuilder.Append(">");
                    stringBuilder.Append(codeItemConfig.getText());
                    stringBuilder.Append("</SPAN>");
                    stringBuilder.Append("</DIV>");
                }
                ++i;
            }
            JSONObject obj = new JSONObject();
            obj.put("id", (Object)StringHelper.Format((String)"C%1$s", (Object)this.getUniqueID()));
            obj.put("html", (Object)stringBuilder.toString());
            vector.add(obj);
            return true;
        }
        return false;
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        int nSize = this.checkBoxListConfig.getListItems().size();
        int i = 0;
        while (i < nSize) {
            String strCheckBoxId;
            SRFExControl control;
            ListItem listItem = this.checkBoxListConfig.getListItems().Get(i);
            if (listItem != null && !StringHelper.IsNullOrEmpty((String)listItem.getValue()) && (control = this.FindControl(strCheckBoxId = StringHelper.Format((String)"CB_%1$s", (Object)i))) != null) {
                vector.add(control.getUniqueID());
            }
            ++i;
        }
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC3(%1$s.%2$s_checklist, function(){%3$s});", (Object)this.getForm().getFormId(), (Object)this.getID(), (Object)strCode);
    }
}

