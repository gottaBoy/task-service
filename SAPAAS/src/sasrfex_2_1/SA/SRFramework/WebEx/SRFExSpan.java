/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.FormImageLinkBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.SpanConfig;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExSpan
extends SRFExFormItem {
    protected SpanConfig spanConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new SpanConfig();
    }

    public SpanConfig getSpanConfig() {
        return this.spanConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.spanConfig = null;
        if (this.config != null && this.config instanceof SpanConfig) {
            this.spanConfig = (SpanConfig)this.config;
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
        if (this.spanConfig.getContainer()) {
            writer.write(StringHelper.Format((String)"<table width=\"100%\">"));
            writer.write("<tr><td ");
            AttributeBuilder attributesBuilder2 = new AttributeBuilder();
            this.FillAttributeBuilder(attributesBuilder2);
            this.OutputID(writer);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            styleBuilder.AddStyle("padding-top", "3px");
            attributesBuilder2.Set("style", String.valueOf(styleBuilder.ToStyleList()) + ";" + this.getSpanConfig().getExtStyle());
            writer.write(attributesBuilder2.ToOutputString());
            writer.write(">");
            writer.write(this.getRealText());
            if (this.getSpanConfig().getFormImageLinkConfig() != null) {
                writer.write("&nbsp;");
                writer.write(FormImageLinkBuilder.GetLinkText(this, this.getSpanConfig().getFormImageLinkConfig()));
            }
            writer.write("</td><td width='5'>&nbsp;</td></tr></table>");
        } else {
            writer.write("<SPAN ");
            this.OutputID(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getSpanConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getSpanConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write(">");
            writer.write(this.getRealText());
            if (this.getSpanConfig().getFormImageLinkConfig() != null) {
                writer.write("&nbsp;");
                writer.write(FormImageLinkBuilder.GetLinkText(this, this.getSpanConfig().getFormImageLinkConfig()));
            }
            writer.write("</SPAN>");
        }
        if (this.getSpanConfig().getFormImageLinkConfig() != null) {
            FormImageLinkBuilder.RenderScript(writer, this, this.getSpanConfig().getFormImageLinkConfig());
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getSpanConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public void setValue(String strValue) {
        this.getSpanConfig().setText(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        String strRealText = this.getRealText();
        if (this.getSpanConfig().getFormImageLinkConfig() != null) {
            strRealText = String.valueOf(strRealText) + "&nbsp;";
            strRealText = String.valueOf(strRealText) + FormImageLinkBuilder.GetLinkText(this, this.getSpanConfig().getFormImageLinkConfig());
        }
        obj.put("value", (Object)strRealText);
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

    @Override
    public boolean IsSupportModify() {
        return false;
    }

    protected String getRealText() {
        if (StringHelper.Length((String)this.getSpanConfig().getCodeList()) > 0) {
            CodeListConfig codeListConfig = this.getPage().getWebContext().getCodeListMgr().GetCodeListConfig(this.getSpanConfig().getCodeList(), this.getWebContext().getLocalization());
            if (codeListConfig != null) {
                return codeListConfig.GetCodeListValue(this.getSpanConfig().getText(), true);
            }
            return "";
        }
        if (this.getPage().getFrontUIStyle() == 1) {
            return WebUtility.TextToHTML((String)this.getSpanConfig().getText());
        }
        return this.getSpanConfig().getText();
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
    }
}

