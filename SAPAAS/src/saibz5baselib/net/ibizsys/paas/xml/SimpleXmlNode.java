/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package net.ibizsys.paas.xml;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SimpleXmlNode
implements Cloneable {
    private static final Log log = LogFactory.getLog(SimpleXmlNode.class);
    public static final String DOCHEADER = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
    public static final String PROPERTY_ID = "ID";
    protected String strId = "";
    protected String strNodeName = "";
    protected String strNodeValue = "";
    protected HashMap<String, String> extAttrList = null;

    public boolean loadConfig(Node xmlNode) {
        NodeList nodes;
        NamedNodeMap attrs;
        this.strNodeName = xmlNode.getNodeName();
        this.strNodeValue = xmlNode.getNodeValue();
        if (this.strNodeValue == null) {
            this.strNodeValue = "";
        }
        if ((attrs = xmlNode.getAttributes()) != null && attrs.getLength() > 0) {
            HashMap<String, String> attrMap = new HashMap<String, String>();
            int i = 0;
            while (i < attrs.getLength()) {
                Node attrNode = attrs.item(i);
                if (attrNode != null) {
                    attrMap.put(attrNode.getNodeName().toUpperCase(), attrNode.getNodeValue());
                }
                ++i;
            }
            String strValue = (String)attrMap.remove(PROPERTY_ID);
            if (strValue != null) {
                this.setId(strValue);
            }
            if (attrMap.size() > 0) {
                this.onSetAttributeEx(attrMap);
                for (String strKey : attrMap.keySet()) {
                    this.onSetAttribute(strKey, attrMap.get(strKey));
                }
            }
        }
        if ((nodes = xmlNode.getChildNodes()) != null) {
            int i = 0;
            while (i < nodes.getLength()) {
                Node childNode = nodes.item(i);
                if (childNode != null) {
                    String strNodeName = childNode.getNodeName().toUpperCase();
                    if (StringHelper.compare(strNodeName, "#TEXT", true) == 0) {
                        this.strNodeValue = String.valueOf(this.strNodeValue) + childNode.getNodeValue();
                    } else if (StringHelper.compare(strNodeName, "#CDATA-SECTION", true) == 0) {
                        this.strNodeValue = String.valueOf(this.strNodeValue) + childNode.getNodeValue();
                    } else if (strNodeName.indexOf("#") != 0) {
                        this.onLoadNode(strNodeName, childNode);
                    }
                }
                ++i;
            }
        }
        return this.onLoadConfig();
    }

    protected void onLoadNode(String strName, Node xmlNode) {
    }

    protected boolean onLoadConfig() {
        return true;
    }

    public final void setAttribute(String strName, String strValue) {
        if (strValue == null) {
            strValue = "";
        }
        HashMap<String, String> attrMap = new HashMap<String, String>();
        attrMap.put(strName.toUpperCase(), strValue);
        if (attrMap.size() > 0) {
            this.onSetAttributeEx(attrMap);
            for (String strKey : attrMap.keySet()) {
                this.onSetAttribute(strKey, attrMap.get(strKey));
            }
        }
    }

    protected void onSetAttribute(String strName, String strValue) {
        if (strName.compareToIgnoreCase(PROPERTY_ID) == 0) {
            this.strId = strValue;
        }
        if (this.extAttrList == null) {
            this.extAttrList = new HashMap();
        }
        this.extAttrList.put(strName.toUpperCase(), strValue);
    }

    protected void onSetAttributeEx(HashMap<String, String> attrMap) {
    }

    public final String getId() {
        return this.strId;
    }

    public final void setId(String value) {
        this.strId = value;
    }

    public final String getNodeName() {
        return this.strNodeName;
    }

    public final void setNodeName(String value) {
        this.strNodeName = value;
    }

    public final String getNodeValue() {
        return this.strNodeValue;
    }

    public final void setNodeValue(String value) {
        this.strNodeValue = value;
    }

    public final boolean isContainsKey(String strKey) {
        strKey = strKey.toUpperCase();
        if (this.extAttrList != null) {
            return this.extAttrList.containsKey(strKey);
        }
        return false;
    }

    public final String getAttribute(String strKey, String strDefault) {
        String objValue;
        strKey = strKey.toUpperCase();
        if (this.extAttrList != null && (objValue = this.extAttrList.get(strKey)) != null) {
            return objValue;
        }
        return strDefault;
    }

    public final int getAttribute(String strKey, int nDefault) {
        try {
            Integer tempValue = new Integer(nDefault);
            return Integer.parseInt(this.getAttribute(strKey, tempValue.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final long getAttribute(String strKey, long nDefault) {
        try {
            Long nTempValue = new Long(nDefault);
            return Long.parseLong(this.getAttribute(strKey, nTempValue.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final boolean getAttribute(String strKey, boolean bDefault) {
        try {
            return SimpleXmlNode.getValue(this.getAttribute(strKey, ""), bDefault);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public static final boolean getValue(String strValue, boolean bDefault) {
        try {
            if (StringHelper.isNullOrEmpty(strValue)) {
                return bDefault;
            }
            return StringHelper.compare(strValue, "TRUE", true) == 0;
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public static final double getValue(String strValue, double fDefault) {
        try {
            if (strValue.indexOf("%") == strValue.length() - 1) {
                strValue = strValue.replaceAll("%", "");
                return Double.parseDouble(strValue) / 100.0;
            }
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public static final float getValue(String strValue, float fDefault) {
        try {
            return Float.parseFloat(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public static final int getValue(String strValue, int nDefault) {
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final void setValue(String strName, String strValue) {
        if (strValue == null) {
            strValue = "";
        }
        strName = strName.toUpperCase();
        if (StringHelper.length(strValue) != 0) {
            if (this.extAttrList == null) {
                this.extAttrList = new HashMap();
            }
            this.extAttrList.put(strName, strValue);
        } else if (this.extAttrList != null) {
            this.extAttrList.remove(strName);
        }
    }

    public boolean save(SimpleXmlWriter xmlWriter, boolean bSaveChild) {
        return this.save(xmlWriter, this.strNodeName, bSaveChild);
    }

    public boolean save(SimpleXmlWriter xmlWriter, String strNodeName, boolean bSaveChild) {
        if (StringHelper.length(strNodeName) != 0) {
            xmlWriter.writeStartElement(strNodeName);
            if (!this.saveAttributes(xmlWriter)) {
                return false;
            }
            if (bSaveChild && !this.saveChildNodes(xmlWriter)) {
                return false;
            }
            xmlWriter.writeEndElement();
        }
        return true;
    }

    public boolean save(SimpleXmlWriter xmlWriter) {
        return this.save(xmlWriter, true);
    }

    protected boolean saveChildNodes(SimpleXmlWriter xmlWriter) {
        return true;
    }

    protected boolean saveAttributes(SimpleXmlWriter xmlWriter) {
        return SimpleXmlNode.saveAttributes(xmlWriter, this);
    }

    private static boolean saveAttributes(SimpleXmlWriter xmlWriter, SimpleXmlNode xmlNode) {
        if (StringHelper.length(xmlNode.getId()) != 0) {
            xmlWriter.writeAttributeString(PROPERTY_ID, xmlNode.getId());
        }
        if (xmlNode.extAttrList != null) {
            for (String strKey : xmlNode.extAttrList.keySet()) {
                String strValue = xmlNode.extAttrList.get(strKey);
                if (StringHelper.isNullOrEmpty(strValue)) continue;
                xmlWriter.writeAttributeString(strKey, strValue);
            }
        }
        if (!StringHelper.isNullOrEmpty(xmlNode.getNodeValue())) {
            String strTemp = xmlNode.getNodeValue().replace("\r", "");
            strTemp = strTemp.replace("\n", "");
            strTemp = strTemp.replace("&#xD;", "");
            strTemp = strTemp.replace("&#xA;", "");
            strTemp = strTemp.replace("\t", "");
            if (!StringHelper.isNullOrEmpty(strTemp = strTemp.replace(" ", ""))) {
                xmlWriter.writeCDATA(strTemp);
            }
        }
        return true;
    }

    public Iterator<String> getAttributes() {
        if (this.extAttrList == null) {
            return null;
        }
        return this.extAttrList.keySet().iterator();
    }

    public boolean loadXML(String strXML) {
        return SimpleXmlNode.loadFromXML(strXML, this);
    }

    public static boolean loadFromXML(String strXML, SimpleXmlNode xmlConfig) {
        try {
            InputSource is = new InputSource(new StringReader(strXML));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            return xmlConfig.loadConfig(doc.getDocumentElement());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u52a0\u8f7dXML\u914d\u7f6e\u53d1\u751f\u9519\u8bef"), (Throwable)ex);
            return false;
        }
    }

    public static boolean loadFromFile(String strConfigPath, SimpleXmlNode xmlConfig) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(strConfigPath);
            Document doc = parser.getDocument();
            return xmlConfig.loadConfig(doc.getDocumentElement());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u52a0\u8f7dXML\u914d\u7f6e\u53d1\u751f\u9519\u8bef"), (Throwable)ex);
            return false;
        }
    }

    public void reset() {
        this.resetAttributes();
        this.strNodeName = "";
    }

    public void resetAttributes() {
        this.extAttrList = null;
        this.strId = "";
        this.strNodeValue = "";
    }
}

