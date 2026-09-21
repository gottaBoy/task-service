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
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.ISRFExFormItem2;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.UI.DropDownListConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExDropDownList
extends SRFExListControl
implements ISRFExFormItem2 {
    protected DropDownListConfig dropDownListConfig = null;
    private static String strSelectedText = "selected=\"selected\" ";
    private static String strDisableText = "disabled=\"disabled\" ";

    @Override
    protected XMLConfig CreateConfig() {
        return new DropDownListConfig();
    }

    public DropDownListConfig getDropDownListConfig() {
        return this.dropDownListConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dropDownListConfig = null;
        if (this.config != null && this.config instanceof DropDownListConfig) {
            this.dropDownListConfig = (DropDownListConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            if (StringHelper.Length((String)this.getDropDownListConfig().getSelectChangedJSCode()) > 0) {
                writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
                writer.write(StringHelper.Format((String)"$P.func['%1$s']=function(){%2$s};", (Object)this.getUniqueID(), (Object)this.getDropDownListConfig().getSelectChangedJSCode()));
                writer.write("</SCRIPT>");
            }
            if (this.getDropDownListConfig().isContainer()) {
                writer.write(StringHelper.Format((String)"<DIV id='C%1$s'>", (Object)this.getUniqueID()));
            }
            writer.write(this.OutputItem());
            if (this.getDropDownListConfig().isContainer()) {
                writer.write("</DIV>");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getDropDownListConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getDropDownListConfig().getSelectedValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getDropDownListConfig().setSelectedValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getDropDownListConfig().getSelectedValue());
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    @Override
    public boolean UpdateItem(Vector vector) {
        if (this.getDropDownListConfig().isContainer()) {
            JSONObject obj = new JSONObject();
            obj.put("id", (Object)StringHelper.Format((String)"C%1$s", (Object)this.getUniqueID()));
            obj.put("html", (Object)this.OutputItem());
            vector.add(obj);
        }
        return true;
    }

    private String OutputItem() {
        StringBuilderEx writer = new StringBuilderEx();
        writer.Append("<select ");
        this.OutputID(writer.getWriter());
        this.OutputName(writer.getWriter());
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getDropDownListConfig().getExtAttributes(), true);
        this.FillAttributeBuilder(attributesBuilder);
        StyleBuilder styleBuilder = new StyleBuilder();
        this.FillStyleBuilder(styleBuilder);
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getDropDownListConfig().getExtStyle());
        writer.Append(attributesBuilder.ToOutputString());
        writer.Append(">");
        int nListCount = this.getListItems().size();
        int i = 0;
        while (i < nListCount) {
            ListItem tempItem = this.getListItems().Get(i);
            writer.Append("<option %3$s%4$svalue=\"%1$s\">%2$s</option>", tempItem.getValue(), tempItem.getText(), StringHelper.Compare((String)tempItem.getValue(), (String)this.getListControlConfig().getSelectedValue(), (boolean)true) == 0 ? strSelectedText : "", tempItem.getDisabled() ? strDisableText : "");
            ++i;
        }
        writer.Append("</select>");
        if (StringHelper.Length((String)this.getDropDownListConfig().getSelectChangedJSCode()) > 0) {
            this.getPage().RegisterScript(2, StringHelper.Format((String)"$FVC2('%1$s',$P.func['%1$s']);", (Object)this.getUniqueID()));
        }
        return writer.toString();
    }

    @Override
    public void OnInitFormPostData() {
        try {
            String strValue = null;
            strValue = this.getPage().isControlValueFromUniqueId() ? this.getPage().getRequest().getParameter(this.getUniqueID()) : this.getPage().getRequest().getParameter(this.getID().toLowerCase());
            if (strValue == null) {
                return;
            }
            this.getDropDownListConfig().setSelectedValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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

