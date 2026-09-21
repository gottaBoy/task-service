/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorExConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExHtmlEditorEx
extends SRFExFormItem {
    protected HtmlEditorExConfig htmlEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExHtmlEditorEx.class);

    @Override
    protected XMLConfig CreateConfig() {
        return new HtmlEditorExConfig();
    }

    public HtmlEditorExConfig getHtmlEditorExConfig() {
        if (this.htmlEditorConfig == null) {
            this.InitConfig();
        }
        return this.htmlEditorConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.htmlEditorConfig = null;
        if (this.config != null && this.config instanceof HtmlEditorExConfig) {
            this.htmlEditorConfig = (HtmlEditorExConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", this.getBaseControlConfig().getWidthString());
            writer.write("<DIV ");
            writer.write(StringHelper.Format((String)" id='%1$s_P'", (Object)this.getUniqueID()));
            SRFExHtmlEditorEx.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.getHtmlEditorExConfig().getExtStyle());
            writer.write(" >");
            writer.write("</DIV>");
            styleBuilder.AddStyle("height", this.getBaseControlConfig().getHeightString());
            styleBuilder.AddStyle("overflow", "scroll");
            styleBuilder.AddStyle("border", "1px solid #000");
            styleBuilder.AddStyle("padding", "3px");
            writer.write("<DIV ");
            this.OutputID(writer);
            SRFExHtmlEditorEx.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.getHtmlEditorExConfig().getExtStyle());
            writer.write(" >");
            writer.write("</DIV>");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var editor = new nicEditor();", this.getUniqueID());
            script.Append("editor.setPanel('%1$s_P');", this.getUniqueID());
            script.Append("editor.addInstance('%1$s');", this.getUniqueID());
            script.Append("$P.htmleditor['%1$s']=editor;\r\n", this.getUniqueID());
            this.getPage().RegisterOnReadyScript(2, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getHtmlEditorExConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getHtmlEditorExConfig().getText();
    }

    @Override
    public void setValue(String strValue) {
        this.getHtmlEditorExConfig().setText(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)WebUtility.GetJSONText((String)this.getHtmlEditorExConfig().getText()));
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
            this.getHtmlEditorExConfig().setText(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V=$P.htmleditor['%1$s'].instanceById('%1$s').getContent();", (Object)this.getUniqueID());
        }
        return StringHelper.Format((String)"$P.htmleditor['%1$s'].instanceById('%1$s').setContent(_V);", (Object)this.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"_V?$P.htmleditor['%1$s'].instanceById('%1$s').enable():$P.htmleditor['%1$s'].instanceById('%1$s').disable();", (Object)this.getUniqueID());
    }

    @Override
    public boolean getEnabled() {
        if (this.getHtmlEditorExConfig().getReadOnly()) {
            return false;
        }
        return super.getEnabled();
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        vector.add(StringHelper.Format((String)"%1$s:STOP", (Object)this.getUniqueID()));
    }
}

