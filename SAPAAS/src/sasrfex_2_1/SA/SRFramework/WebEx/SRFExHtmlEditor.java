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
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorConfig;
import java.io.Writer;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExHtmlEditor
extends SRFExFormItem {
    protected HtmlEditorConfig htmlEditorConfig = null;
    private static final Log log = LogFactory.getLog(SRFExHtmlEditor.class);

    @Override
    protected XMLConfig CreateConfig() {
        return new HtmlEditorConfig();
    }

    public HtmlEditorConfig getHtmlEditorConfig() {
        if (this.htmlEditorConfig == null) {
            this.InitConfig();
        }
        return this.htmlEditorConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.htmlEditorConfig = null;
        if (this.config != null && this.config instanceof HtmlEditorConfig) {
            this.htmlEditorConfig = (HtmlEditorConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", this.getBaseControlConfig().getWidthString());
            styleBuilder.AddStyle("height", this.getBaseControlConfig().getHeightString());
            writer.write("<DIV ");
            this.OutputID(writer);
            SRFExHtmlEditor.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.getHtmlEditorConfig().getExtStyle());
            writer.write(" >");
            writer.write("</DIV>");
            String strScript = "";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _E=new Ext.form.HtmlEditor({renderTo:'%1$s',fontFamilies:['Arial','Courier New','Tahoma','Times New Roman','Verdana','\u5b8b\u4f53','\u6977\u4f53','\u96b6\u4e66'],defaultFont:'\u5b8b\u4f53'\r\n", (Object)this.getUniqueID());
            strScript = this.getHtmlEditorConfig().getWidth() > 1 ? String.valueOf(strScript) + StringHelper.Format((String)",width:%1$s", (Object)this.getHtmlEditorConfig().getWidth()) : String.valueOf(strScript) + StringHelper.Format((String)",width:%1$s", (Object)300);
            if (this.getHtmlEditorConfig().getHeight() > 1) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)",height:%1$s", (Object)this.getHtmlEditorConfig().getHeight());
            }
            strScript = String.valueOf(strScript) + "});\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.htmleditor['%1$s']=_E;", (Object)this.getUniqueID());
            strScript = String.valueOf(strScript) + "_E.getToolbar().addButton({iconCls:'sx-tb-img',scope :_E,handler:function(){var url = prompt('\u8bf7\u6307\u5b9a\u56fe\u7247\u8def\u5f84', this.defaultLinkValue);if(url && url !='http:/'+'/'){this.relayCmd('InsertImage', url);}}});";
            this.getPage().RegisterOnReadyScript(2, strScript);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getHtmlEditorConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getHtmlEditorConfig().getText();
    }

    @Override
    public void setValue(String strValue) {
        this.getHtmlEditorConfig().setText(strValue);
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)WebUtility.GetJSONText((String)this.getHtmlEditorConfig().getText()));
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
            this.getHtmlEditorConfig().setText(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V = $P.htmleditor['%1$s'].getValue();", (Object)this.getUniqueID());
        }
        return StringHelper.Format((String)"$P.htmleditor['%1$s'].setValue( _V);", (Object)this.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$P.htmleditor['%1$s'].getDoc().designMode = _V?\"on\":\"off\";", (Object)this.getUniqueID());
    }

    @Override
    public boolean getEnabled() {
        if (this.getHtmlEditorConfig().getReadOnly()) {
            return false;
        }
        return super.getEnabled();
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        vector.add(StringHelper.Format((String)"%1$s:STOP", (Object)this.getUniqueID()));
    }
}

