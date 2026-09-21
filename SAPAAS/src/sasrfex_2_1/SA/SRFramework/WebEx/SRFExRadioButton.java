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
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.RadioButtonConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExRadioButton
extends SRFExFormItem {
    protected RadioButtonConfig radioButtonConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new RadioButtonConfig();
    }

    public RadioButtonConfig getRadioButtonConfig() {
        return this.radioButtonConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.radioButtonConfig = null;
        if (this.config != null && this.config instanceof RadioButtonConfig) {
            this.radioButtonConfig = (RadioButtonConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<INPUT ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getRadioButtonConfig().getExtAttributes(), true);
            attributesBuilder.Set("type", "radio");
            this.FillAttributeBuilder(attributesBuilder);
            attributesBuilder.Set("value", this.getRadioButtonConfig().getValue(), true);
            if (this.getRadioButtonConfig().getChecked()) {
                attributesBuilder.Set("checked", "checked");
            }
            if (this.getRadioButtonConfig().getReadOnly()) {
                attributesBuilder.Set("disabled", "true");
            }
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getRadioButtonConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getRadioButtonConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getRadioButtonConfig().getValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getRadioButtonConfig().setValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getRadioButtonConfig().getValue());
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
            this.getRadioButtonConfig().setValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$FEI3(_ID, _V);");
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC4('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }
}

