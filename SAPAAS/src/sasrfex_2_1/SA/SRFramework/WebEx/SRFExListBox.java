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
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.ListBoxConfig;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExListBox
extends SRFExListControl {
    protected ListBoxConfig listBoxConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";

    @Override
    protected XMLConfig CreateConfig() {
        return new ListBoxConfig();
    }

    public ListBoxConfig getListBoxConfig() {
        return this.listBoxConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.listBoxConfig = null;
        if (this.config != null && this.config instanceof ListBoxConfig) {
            this.listBoxConfig = (ListBoxConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<select ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getListBoxConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getListBoxConfig().getExtStyle());
            attributesBuilder.Set("size", Integer.toString(this.getListBoxConfig().getRowCount()));
            if (this.getListBoxConfig().getMultiple()) {
                attributesBuilder.Set("multiple", "multiple");
            }
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            ArrayList selectedValues = this.getListBoxConfig().getSelectedValues();
            int nListCount = this.getListItems().size();
            int i = 0;
            while (i < nListCount) {
                ListItem tempItem = this.getListItems().Get(i);
                writer.write(String.format("<option %3$s value=\"%1$s\"  >%2$s</option>\r\n", tempItem.getValue(), tempItem.getText(), selectedValues.contains(tempItem.getValue()) ? strSelectedText : ""));
                ++i;
            }
            writer.write("</select>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getListBoxConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getListBoxConfig().getSelectedValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getListBoxConfig().setSelectedValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getListBoxConfig().getSelectedValue());
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
            this.getListBoxConfig().setSelectedValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (this.getListBoxConfig().getMultiple()) {
            if (bGetMode) {
                return StringHelper.Format((String)"_V=SRFForm.getListBoxValue(_ID,'%1$s') ;", (Object)this.getListBoxConfig().getSeparator());
            }
            return StringHelper.Format((String)"SRFForm.setListBoxValue(_ID,_V,'%1$s');", (Object)this.getListBoxConfig().getSeparator());
        }
        return super.getItemValueJSCall(bGetMode);
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$FEI3(_ID,_V);");
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC2('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }

    @Override
    public String getFireFIUpdateCode(String strCode) {
        return StringHelper.Format((String)"$FVC2('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }
}

