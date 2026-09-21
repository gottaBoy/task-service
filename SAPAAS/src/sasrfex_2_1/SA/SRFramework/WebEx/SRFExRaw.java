/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.RawConfig;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExRaw
extends SRFExFormItem {
    protected RawConfig rawConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new RawConfig();
    }

    public RawConfig getRawConfig() {
        return this.rawConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.rawConfig = null;
        if (this.config != null && this.config instanceof RawConfig) {
            this.rawConfig = (RawConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.RenderSpan(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderSpan(Writer writer) throws IOException {
        if (this.getRawConfig().getDiv()) {
            writer.write("<DIV ");
        } else {
            writer.write("<SPAN ");
        }
        this.OutputID(writer);
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getRawConfig().getExtAttributes(), true);
        this.FillAttributeBuilder(attributesBuilder);
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.AddStyle("padding-top", "5px");
        if (this.getRawConfig().getDiv()) {
            styleBuilder.AddStyle("float", "left");
            styleBuilder.AddStyle("overflow", "auto");
        }
        this.FillStyleBuilder(styleBuilder);
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getRawConfig().getExtStyle());
        writer.write(attributesBuilder.ToOutputString());
        writer.write(">");
        writer.write(this.getRealText());
        if (this.getRawConfig().getDiv()) {
            writer.write("</DIV>");
        } else {
            writer.write("</SPAN>");
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getRawConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public void setValue(String strValue) {
        this.getRawConfig().setText(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getRealText());
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V=$FGV2(_ID);";
        }
        return "$FSV2(_ID,_V);";
    }

    protected String getRealText() {
        return this.getRawConfig().getText();
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
    }
}

