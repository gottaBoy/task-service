/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class CodeItemConfig
extends XMLConfig {
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

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEXT, (boolean)true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.strValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CSSCLASS, (boolean)true) == 0) {
            this.strCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COLOR, (boolean)true) == 0) {
            this.strColor = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICON, (boolean)true) == 0) {
            this.strIcon = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BIGICON, (boolean)true) == 0) {
            this.strBigIcon = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ICONCLS, (boolean)true) == 0) {
            this.strIconCls = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BIGICONCLS, (boolean)true) == 0) {
            this.strBigIconCls = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLED, (boolean)true) == 0) {
            this.setDisabled(CodeItemConfig.GetValue((String)strValue, (boolean)this.getDisabled()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_CODEITEM, (boolean)true) == 0) {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            if (codeItemConfig.LoadConfig(xmlNode)) {
                this.AddCodeItemConfig(codeItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getCodeItems() {
        return this.childList;
    }

    public void ResetCodeItems() {
        this.childList = null;
    }

    public void AddCodeItemConfig(CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            this.childList = new ArrayList();
        }
        this.childList.add(codeItemConfig);
    }

    public void InsertCodeItemConfig(int nIndex, CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            this.childList = new ArrayList();
        }
        this.childList.add(nIndex, codeItemConfig);
    }

    public void RemoveCodeItemConfig(CodeItemConfig codeItemConfig) {
        if (this.childList == null) {
            return;
        }
        this.childList.remove((Object)codeItemConfig);
    }

    public String getText() {
        return this.strText;
    }

    public String getTextWithStyle() {
        String strOutput = "";
        if (!StringHelper.IsNullOrEmpty((String)this.strIcon)) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<IMG src=\"%1$s\" align=\"absmiddle\">&nbsp;", (Object)this.strIcon);
        }
        if (StringHelper.Length((String)this.getCssClass()) > 0) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<span class=\"%1$s\">%2$s</span>", (Object)this.getCssClass(), (Object)this.strText);
        }
        strOutput = StringHelper.Length((String)this.getColor()) > 0 ? String.valueOf(strOutput) + StringHelper.Format((String)"<span style=\"color:%1$s\">%2$s</span>", (Object)this.getColor(), (Object)this.strText) : String.valueOf(strOutput) + this.strText;
        return strOutput;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public CodeItemConfig FindCodeItemConfigByValue(String strValue, boolean bRecursion) {
        if (this.childList == null) {
            return null;
        }
        int nCount = this.childList.size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig temp;
            CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)this.childList.get(i));
            if (StringHelper.Compare((String)codeItemConfig.getValue(), (String)strValue, (boolean)false) == 0) {
                return codeItemConfig;
            }
            if (bRecursion && (temp = codeItemConfig.FindCodeItemConfigByValue(strValue, bRecursion)) != null) {
                return temp;
            }
            ++i;
        }
        return null;
    }

    public CodeItemConfig FindCodeItemConfigByText(String strText, boolean bRecursion) {
        if (this.childList == null) {
            return null;
        }
        int nCount = this.childList.size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig temp;
            CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)this.childList.get(i));
            if (StringHelper.Compare((String)codeItemConfig.getText(), (String)strText, (boolean)false) == 0) {
                return codeItemConfig;
            }
            if (bRecursion && (temp = codeItemConfig.FindCodeItemConfigByText(strText, bRecursion)) != null) {
                return temp;
            }
            ++i;
        }
        return null;
    }

    public String GetCodeItemValueByText(String strText, boolean bRecursion) {
        CodeItemConfig codeItemConfig = this.FindCodeItemConfigByText(strText, bRecursion);
        if (codeItemConfig == null) {
            return "";
        }
        return codeItemConfig.getValue();
    }

    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    public String getColor() {
        return this.strColor;
    }

    public void setColor(String strColor) {
        this.strColor = strColor;
    }

    public String getBigIcon() {
        return this.strBigIcon;
    }

    public void setBigIcon(String strBigIcon) {
        this.strBigIcon = strBigIcon;
    }

    protected boolean SaveChildNodes(SimpleXMLWriter xmlWriter) {
        if (this.childList != null) {
            for (Object objCodeItem : this.childList) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)objCodeItem);
                codeItemConfig.Save(xmlWriter, TAG_CODEITEM, true);
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

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public void setBigIconCls(String strBigIconCls) {
        this.strBigIconCls = strBigIconCls;
    }

    protected boolean SavePropertys(SimpleXMLWriter xmlWriter) {
        xmlWriter.WriteAttributeString(TAG_TEXT, this.strText);
        xmlWriter.WriteAttributeString(TAG_VALUE, this.strValue);
        xmlWriter.WriteAttributeString(TAG_CSSCLASS, this.strCssClass);
        xmlWriter.WriteAttributeString(TAG_ICON, this.strIcon);
        xmlWriter.WriteAttributeString(TAG_COLOR, this.strColor);
        xmlWriter.WriteAttributeString(TAG_BIGICON, this.strBigIcon);
        xmlWriter.WriteAttributeString(TAG_ICONCLS, this.strIconCls);
        xmlWriter.WriteAttributeString(TAG_BIGICONCLS, this.strBigIconCls);
        xmlWriter.WriteAttributeString(TAG_DISABLED, this.getDisabled() ? "TRUE" : "FALSE");
        return super.SavePropertys(xmlWriter);
    }

    public boolean getDisabled() {
        return this.bDisabled;
    }

    public void setDisabled(boolean bDisabled) {
        this.bDisabled = bDisabled;
    }
}

