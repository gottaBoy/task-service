/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.xml;

import java.util.Stack;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.ISimpleXmlWriter;

public class SimpleXmlWriter
implements ISimpleXmlWriter {
    private Stack childElements = new Stack();
    private StringBuilder internalBuilder = null;
    private int nCurChildCount = 0;
    private String strCurElementName = "";
    private int nCurChildLevel = -1;

    public SimpleXmlWriter(StringBuilder sb) {
        this.internalBuilder = sb;
    }

    @Override
    public void writeRaw(String strRawText) {
        this.internalBuilder.append(strRawText);
    }

    @Override
    public void writeStartElement(String strElement) {
        ++this.nCurChildLevel;
        if (StringHelper.length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = strElement;
        this.appendElementStartTag();
    }

    @Override
    public void writeComment(String strComment) {
        if (StringHelper.length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
            this.strCurElementName = "";
        }
        ++this.nCurChildLevel;
        this.appendIndent();
        this.writeRaw("<!-- ");
        this.writeRaw(strComment);
        this.writeRaw(" -->\r\n");
        --this.nCurChildLevel;
    }

    @Override
    public void writeCDATA(String strContent) {
        ++this.nCurChildLevel;
        if (StringHelper.length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = "";
        this.appendIndent();
        this.writeRaw("<![CDATA[");
        this.writeRaw(strContent);
        this.writeRaw("]]>\r\n");
        --this.nCurChildLevel;
    }

    @Override
    public void writeValue(String strContent) {
        if (StringHelper.length(this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true, false);
        }
        this.strCurElementName = "";
        this.writeRaw(SimpleXmlWriter.formatXMLContent(strContent, true));
    }

    @Override
    public void writeAttributeString(String strName, String strValue) {
        this.internalBuilder.append(" ");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(strName, false));
        this.internalBuilder.append("=\"");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(strValue, true));
        this.internalBuilder.append("\"");
    }

    @Override
    public void writeEndElement() {
        this.writeEndElement(true);
    }

    public void writeEndElement(boolean bIndent) {
        if (StringHelper.length(this.strCurElementName) > 0) {
            this.internalBuilder.append("/>\r\n");
            this.strCurElementName = "";
        } else if (this.childElements.size() > 0) {
            String strTemp = (String)this.childElements.pop();
            if (bIndent) {
                this.appendIndent();
            }
            this.internalBuilder.append("</" + strTemp + ">\r\n");
        }
        --this.nCurChildLevel;
    }

    private void appendElementEndTag(boolean bFirstPart) {
        this.appendElementEndTag(bFirstPart, true);
    }

    private void appendElementEndTag(boolean bFirstPart, boolean bReturn) {
        if (bFirstPart) {
            this.internalBuilder.append(">");
            if (bReturn) {
                this.internalBuilder.append("\r\n");
            }
        }
    }

    private void appendElementStartTag() {
        this.appendIndent();
        this.internalBuilder.append("<");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(this.strCurElementName, false));
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

