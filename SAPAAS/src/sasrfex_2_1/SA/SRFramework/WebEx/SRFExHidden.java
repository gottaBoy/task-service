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
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExHidden
extends SRFExFormItem {
    protected HiddenConfig hiddenConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new HiddenConfig();
    }

    public HiddenConfig getHiddenConfig() {
        return this.hiddenConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.hiddenConfig = null;
        if (this.config != null && this.config instanceof HiddenConfig) {
            this.hiddenConfig = (HiddenConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write("<INPUT ");
            this.OutputID(writer);
            this.OutputName(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getHiddenConfig().getExtAttributes(), true);
            attributesBuilder.Set("type", "hidden");
            attributesBuilder.Set("value", this.getHiddenConfig().getValue());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            this.getPage().RegisterScript(2, StringHelper.Format((String)"$P.formitem['%1$s']=new SRFFormItem({formitemid:'%1$s'});", (Object)this.getUniqueID()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.hiddenConfig.getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getHiddenConfig().getValue();
    }

    @Override
    public void setValue(String strValue) {
        this.getHiddenConfig().setValue(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getHiddenConfig().getValue());
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
            this.getHiddenConfig().setValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getHookValueChangedCode(String strCode) {
        return StringHelper.Format((String)"$FVC('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }

    @Override
    public String getFireFIUpdateCode(String strCode) {
        return StringHelper.Format((String)"$FVC('%1$s',function(){%2$s});", (Object)this.getUniqueID(), (Object)strCode);
    }
}

