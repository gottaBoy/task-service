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
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.CheckBoxConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExCheckBox
extends SRFExFormItem {
    protected CheckBoxConfig checkBoxConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new CheckBoxConfig();
    }

    public CheckBoxConfig getCheckBoxConfig() {
        return this.checkBoxConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.checkBoxConfig = null;
        if (this.config != null && this.config instanceof CheckBoxConfig) {
            this.checkBoxConfig = (CheckBoxConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<INPUT ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getCheckBoxConfig().getExtAttributes(), true);
            attributesBuilder.Set("type", "checkbox");
            this.FillAttributeBuilder(attributesBuilder);
            attributesBuilder.Set("value", this.getCheckBoxConfig().getValue(), true);
            if (this.getCheckBoxConfig().getChecked()) {
                attributesBuilder.Set("checked", "checked");
            }
            if (this.getCheckBoxConfig().getReadOnly()) {
                attributesBuilder.Set("disabled", "true");
            }
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getCheckBoxConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getCheckBoxConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getCheckBoxConfig().getChecked() ? this.getCheckBoxConfig().getValue() : this.getCheckBoxConfig().getUncheckValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getCheckBoxConfig().setChecked(StringHelper.Compare((String)strValue, (String)this.getCheckBoxConfig().getValue(), (boolean)false) == 0);
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
            if (StringHelper.Length((String)strValue) == 0) {
                this.getCheckBoxConfig().setChecked(false);
            } else {
                this.setValue(strValue);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V=$FGV3(_ID);";
        }
        return "$FSV3(_ID,_V);";
    }

    @Override
    public String getItemEnableStateJSCall() {
        return "$FEI3(_ID, _V);";
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC4('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }
}

