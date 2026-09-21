/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FormControlConfig;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import org.w3c.dom.Node;

public class SpanConfig
extends FormControlConfig {
    public static final String TAG_SPAN = "SRFEXSPAN";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_VALUETRANSFORM = "VALUETRANSFORM";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_TEXT2HTML = "TEXT2HTML";
    protected String strText = "";
    protected boolean bContainer = false;
    protected String strValueTransform = "";
    protected String strCodeList = "";
    protected boolean bText2Html = true;
    protected FormImageLinkConfig formImageLinkConfig = null;

    public SpanConfig() {
        this.strCssClass = "sx-span";
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMIMAGELINK", (boolean)true) == 0) {
            if (this.formImageLinkConfig != null) {
                this.formImageLinkConfig = null;
            }
            this.formImageLinkConfig = new FormImageLinkConfig();
            if (!this.formImageLinkConfig.LoadConfig(xmlNode)) {
                this.formImageLinkConfig = null;
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUETRANSFORM, (boolean)true) == 0) {
            this.strValueTransform = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT2HTML, (boolean)true) == 0) {
            this.bText2Html = StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getContainer() {
        return this.bContainer;
    }

    public void setContainer(boolean bContainer) {
        this.bContainer = bContainer;
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String value) {
        this.strText = value;
    }

    public String getValueTransform() {
        return this.strValueTransform;
    }

    public void setValueTransform(String value) {
        this.strValueTransform = value;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public FormImageLinkConfig getFormImageLinkConfig() {
        return this.formImageLinkConfig;
    }

    public void setFormImageLinkConfig(FormImageLinkConfig formImageLinkConfig) {
        this.formImageLinkConfig = formImageLinkConfig;
    }
}

