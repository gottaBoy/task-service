/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.XML;

import SA.SRFramework.Utility.StringHelper;
import java.util.Stack;

public class SimpleXMLWriter {
    private Stack childElements = new Stack();
    private StringBuilder internalBuilder = null;
    private int nCurChildCount = 0;
    private String strCurElementName = "";
    private int nCurChildLevel = -1;

    public SimpleXMLWriter(StringBuilder sb) {
        this.internalBuilder = sb;
    }

    public void WriteRaw(String strRawText) {
        this.internalBuilder.append(strRawText);
    }

    public void WriteStartElement(String strElement) {
        ++this.nCurChildLevel;
        if (StringHelper.Length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = strElement;
        this.appendElementStartTag();
    }

    public void WriteComment(String strComment) {
        if (StringHelper.Length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
            this.strCurElementName = "";
        }
        ++this.nCurChildLevel;
        this.appendIndent();
        this.WriteRaw("<!-- ");
        this.WriteRaw(strComment);
        this.WriteRaw(" -->\r\n");
        --this.nCurChildLevel;
    }

    public void WriteCDATA(String strContent) {
        ++this.nCurChildLevel;
        if (StringHelper.Length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = "";
        this.appendIndent();
        this.WriteRaw("<![CDATA[");
        this.WriteRaw(strContent);
        this.WriteRaw("]]>\r\n");
        --this.nCurChildLevel;
    }

    public void WriteValue(String strContent) {
        if (StringHelper.Length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = "";
        this.WriteRaw(strContent);
    }

    public void WriteAttributeString(String strName, String strValue) {
        this.internalBuilder.append(" ");
        this.internalBuilder.append(SimpleXMLWriter.formatXMLContent(strName, false));
        this.internalBuilder.append("=\"");
        this.internalBuilder.append(SimpleXMLWriter.formatXMLContent(strValue, true));
        this.internalBuilder.append("\"");
    }

    public void WriteEndElement() {
        if (StringHelper.Length(this.strCurElementName) > 0) {
            this.internalBuilder.append("/>\r\n");
            this.strCurElementName = "";
        } else if (this.childElements.size() > 0) {
            String strTemp = (String)this.childElements.pop();
            this.appendIndent();
            this.internalBuilder.append("</" + strTemp + ">\r\n");
        }
        --this.nCurChildLevel;
    }

    private void appendElementEndTag(boolean bFirstPart) {
        if (bFirstPart) {
            this.internalBuilder.append(">\r\n");
        }
    }

    private void appendElementStartTag() {
        this.appendIndent();
        this.internalBuilder.append("<");
        this.internalBuilder.append(SimpleXMLWriter.formatXMLContent(this.strCurElementName, false));
        this.internalBuilder.append(" ");
    }

    private void appendIndent() {
        int i = 0;
        while (i < this.nCurChildLevel) {
            this.internalBuilder.append("    ");
            ++i;
        }
    }

    private static String formatXMLContent(String strOrigin, boolean bProperty) {
        strOrigin = strOrigin.replace("&", "&amp;");
        strOrigin = strOrigin.replace("<", "&lt;");
        strOrigin = strOrigin.replace(">", "&gt;");
        if (bProperty) {
            strOrigin = strOrigin.replace("\n", "&#xA;");
            strOrigin = strOrigin.replace("\r", "&#xD;");
            strOrigin = strOrigin.replace("\"", "&quot;");
            strOrigin = strOrigin.replace("'", "&apos;");
        }
        return strOrigin;
    }
}

