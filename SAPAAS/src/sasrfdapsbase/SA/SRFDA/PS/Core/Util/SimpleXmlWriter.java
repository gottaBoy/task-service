/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import java.io.FileWriter;
import java.util.Stack;
import net.ibizsys.paas.util.StringHelper;

public class SimpleXmlWriter {
    private Stack childElements = new Stack();
    private FileWriter internalBuilder = null;
    private int nCurChildCount = 0;
    private String strCurElementName = "";
    private int nCurChildLevel = -1;

    public SimpleXmlWriter(FileWriter sb) {
        this.internalBuilder = sb;
    }

    public void writeRaw(String strRawText) throws Exception {
        this.internalBuilder.append(strRawText);
    }

    public void writeStartElement(String strElement) throws Exception {
        ++this.nCurChildLevel;
        if (StringHelper.length((String)this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true);
        }
        this.strCurElementName = strElement;
        this.appendElementStartTag();
    }

    public void writeComment(String strComment) throws Exception {
        if (StringHelper.length((String)this.strCurElementName) > 0) {
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

    public void writeCDATA(String strContent) throws Exception {
        ++this.nCurChildLevel;
        if (StringHelper.length((String)this.strCurElementName) > 0) {
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

    public void writeValue(String strContent) throws Exception {
        if (StringHelper.length((String)this.strCurElementName) > 0) {
            this.childElements.push(this.strCurElementName);
            this.appendElementEndTag(true, false);
        }
        this.strCurElementName = "";
        this.writeRaw(SimpleXmlWriter.formatXMLContent(strContent, true));
    }

    public void writeAttributeString(String strName, String strValue) throws Exception {
        this.internalBuilder.append(" ");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(strName, false));
        this.internalBuilder.append("=\"");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(strValue, true));
        this.internalBuilder.append("\"");
    }

    public void writeEndElement() throws Exception {
        this.writeEndElement(true);
    }

    public void writeEndElement(boolean bIndent) throws Exception {
        if (StringHelper.length((String)this.strCurElementName) > 0) {
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

    private void appendElementEndTag(boolean bFirstPart) throws Exception {
        this.appendElementEndTag(bFirstPart, true);
    }

    private void appendElementEndTag(boolean bFirstPart, boolean bReturn) throws Exception {
        if (bFirstPart) {
            this.internalBuilder.append(">");
            if (bReturn) {
                this.internalBuilder.append("\r\n");
            }
        }
    }

    private void appendElementStartTag() throws Exception {
        this.appendIndent();
        this.internalBuilder.append("<");
        this.internalBuilder.append(SimpleXmlWriter.formatXMLContent(this.strCurElementName, false));
        this.internalBuilder.append(" ");
    }

    private void appendIndent() throws Exception {
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

