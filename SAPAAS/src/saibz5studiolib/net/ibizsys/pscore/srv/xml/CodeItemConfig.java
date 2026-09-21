/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.SimpleXmlNode
 *  net.ibizsys.paas.xml.SimpleXmlWriter
 */
package net.ibizsys.pscore.srv.xml;

import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import org.w3c.dom.Node;

public class CodeItemConfig
extends SimpleXmlNode {
    public static final String TAG_CODEITEM = "SRFEXCODEITEM";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_ICON = "ICON";
    public static final String TAG_BIGICON = "BIGICON";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_BIGICONCLS = "BIGICONCLS";
    public static final String TAG_DISABLED = "DISABLED";
    public static final String TAG_COLOR = "COLOR";
    protected String strText = "";
    protected String strValue = "";
    protected String strCssClass = "";
    protected ArrayList childList = null;
    protected String strIcon = "";
    protected String strBigIcon = "";
    protected String strIconCls = "";
    protected String strBigIconCls = "";
    protected String strColor = "";
    protected boolean bDisabled = false;

    protected void onSetAttribute(String string, String string2) {
        if (StringHelper.compare((String)string, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_VALUE, (boolean)true) == 0) {
            this.strValue = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_CSSCLASS, (boolean)true) == 0) {
            this.strCssClass = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_COLOR, (boolean)true) == 0) {
            this.strColor = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_ICON, (boolean)true) == 0) {
            this.strIcon = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_BIGICON, (boolean)true) == 0) {
            this.strBigIcon = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_ICONCLS, (boolean)true) == 0) {
            this.strIconCls = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_BIGICONCLS, (boolean)true) == 0) {
            this.strBigIconCls = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_DISABLED, (boolean)true) == 0) {
            this.setDisabled(CodeItemConfig.getValue((String)string2, (boolean)this.getDisabled()));
            return;
        }
        super.onSetAttribute(string, string2);
    }

    public void onLoadNode(String string, Node node) {
        if (StringHelper.compare((String)string, (String)TAG_CODEITEM, (boolean)true) == 0) {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            if (codeItemConfig.loadConfig(node)) {
                this.addCodeItemConfig(codeItemConfig);
            }
            return;
        }
        super.onLoadNode(string, node);
    }

    public ArrayList getCodeItems() {
        return this.childList;
    }

    public void resetCodeItems() {
        this.childList = null;
    }

    public void addCodeItemConfig(CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            this.childList = new ArrayList();
        }
        this.childList.add(codeItemConfig);
    }

    public void insertCodeItemConfig(int n, CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            this.childList = new ArrayList();
        }
        this.childList.add(n, codeItemConfig);
    }

    public void removeCodeItemConfig(CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            return;
        }
        this.childList.remove((Object)codeItemConfig);
    }

    public String getText() {
        return this.strText;
    }

    public String getTextWithStyle() {
        String string = "";
        if (!StringHelper.isNullOrEmpty((String)this.strIcon)) {
            string = string + StringHelper.format((String)"<IMG src=\"%1$s\" align=\"absmiddle\">&nbsp;", (Object)this.strIcon);
        }
        if (StringHelper.length((String)this.getCssClass()) > 0) {
            string = string + StringHelper.format((String)"<span class=\"%1$s\">%2$s</span>", (Object)this.getCssClass(), (Object)this.strText);
        }
        string = StringHelper.length((String)this.getColor()) > 0 ? string + StringHelper.format((String)"<span style=\"color:%1$s\">%2$s</span>", (Object)this.getColor(), (Object)this.strText) : string + this.strText;
        return string;
    }

    public void setText(String string) {
        this.strText = string;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String string) {
        this.strValue = string;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String string) {
        this.strCssClass = string;
    }

    public CodeItemConfig findCodeItemConfigByValue(String string, boolean bl) {
        if (this.childList == null) {
            return null;
        }
        int n = this.childList.size();
        for (int i = 0; i < n; ++i) {
            CodeItemConfig codeItemConfig;
            CodeItemConfig codeItemConfig2 = (CodeItemConfig)((Object)this.childList.get(i));
            if (StringHelper.compare((String)codeItemConfig2.getValue(), (String)string, (boolean)false) == 0) {
                return codeItemConfig2;
            }
            if (!bl || (codeItemConfig = codeItemConfig2.findCodeItemConfigByValue(string, bl)) == null) continue;
            return codeItemConfig;
        }
        return null;
    }

    public CodeItemConfig findCodeItemConfigByText(String string, boolean bl) {
        if (this.childList == null) {
            return null;
        }
        int n = this.childList.size();
        for (int i = 0; i < n; ++i) {
            CodeItemConfig codeItemConfig;
            CodeItemConfig codeItemConfig2 = (CodeItemConfig)((Object)this.childList.get(i));
            if (StringHelper.compare((String)codeItemConfig2.getText(), (String)string, (boolean)false) == 0) {
                return codeItemConfig2;
            }
            if (!bl || (codeItemConfig = codeItemConfig2.findCodeItemConfigByText(string, bl)) == null) continue;
            return codeItemConfig;
        }
        return null;
    }

    public String getCodeItemValueByText(String string, boolean bl) {
        CodeItemConfig codeItemConfig = this.findCodeItemConfigByText(string, bl);
        if (codeItemConfig == null) {
            return "";
        }
        return codeItemConfig.getValue();
    }

    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String string) {
        this.strIcon = string;
    }

    public String getColor() {
        return this.strColor;
    }

    public void setColor(String string) {
        this.strColor = string;
    }

    public String getBigIcon() {
        return this.strBigIcon;
    }

    public void setBigIcon(String string) {
        this.strBigIcon = string;
    }

    protected boolean saveChildNodes(SimpleXmlWriter simpleXmlWriter) {
        if (this.childList != null) {
            for (Object e : this.childList) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)e);
                codeItemConfig.save(simpleXmlWriter, TAG_CODEITEM, true);
            }
        }
        return true;
    }

    public String getIconCls() {
        return this.strIconCls;
    }

    public String getBigIconCls() {
        return this.strBigIconCls;
    }

    public void setIconCls(String string) {
        this.strIconCls = string;
    }

    public void setBigIconCls(String string) {
        this.strBigIconCls = string;
    }

    protected boolean saveAttributes(SimpleXmlWriter simpleXmlWriter) {
        simpleXmlWriter.writeAttributeString(TAG_TEXT, this.strText);
        simpleXmlWriter.writeAttributeString(TAG_VALUE, this.strValue);
        simpleXmlWriter.writeAttributeString(TAG_CSSCLASS, this.strCssClass);
        simpleXmlWriter.writeAttributeString(TAG_ICON, this.strIcon);
        simpleXmlWriter.writeAttributeString(TAG_COLOR, this.strColor);
        simpleXmlWriter.writeAttributeString(TAG_BIGICON, this.strBigIcon);
        simpleXmlWriter.writeAttributeString(TAG_ICONCLS, this.strIconCls);
        simpleXmlWriter.writeAttributeString(TAG_BIGICONCLS, this.strBigIconCls);
        simpleXmlWriter.writeAttributeString(TAG_DISABLED, this.getDisabled() ? "TRUE" : "FALSE");
        return super.saveAttributes(simpleXmlWriter);
    }

    public boolean getDisabled() {
        return this.bDisabled;
    }

    public void setDisabled(boolean bl) {
        this.bDisabled = bl;
    }
}

