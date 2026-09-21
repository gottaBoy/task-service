/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Base;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLConfig
implements Cloneable {
    private static final Log log = LogFactory.getLog(XMLConfig.class);
    public static final String XMLHEADER = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
    protected String strId = "";
    protected String strNodeName = "";
    protected String strNodeValue = "";
    protected Hashtable extAttrList = null;

    public boolean LoadConfig(Node xmlNode) {
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
            String strValue = (String)attrMap.remove("ID");
            if (strValue != null) {
                this.setID(strValue);
            }
            if (attrMap.size() > 0) {
                this.OnSetPropertyEx(attrMap);
                for (String strKey : attrMap.keySet()) {
                    this.OnSetProperty(strKey, attrMap.get(strKey));
                }
            }
        }
        if ((nodes = xmlNode.getChildNodes()) != null) {
            int i = 0;
            while (i < nodes.getLength()) {
                Node childNode = nodes.item(i);
                if (childNode != null) {
                    String strNodeName = childNode.getNodeName().toUpperCase();
                    if (StringHelper.Compare(strNodeName, "#TEXT", true) == 0) {
                        this.strNodeValue = String.valueOf(this.strNodeValue) + childNode.getNodeValue();
                    } else if (StringHelper.Compare(strNodeName, "#CDATA-SECTION", true) == 0) {
                        this.strNodeValue = String.valueOf(this.strNodeValue) + childNode.getNodeValue();
                    } else if (strNodeName.indexOf("#") != 0) {
                        this.OnLoadNode(strNodeName, childNode);
                    }
                }
                ++i;
            }
        }
        return this.OnLoadConfig();
    }

    protected void OnLoadNode(String strName, Node xmlNode) {
    }

    protected boolean OnLoadConfig() {
        return true;
    }

    public final void SetProperty(String strName, String strValue) {
        HashMap<String, String> attrMap = new HashMap<String, String>();
        attrMap.put(strName.toUpperCase(), strValue);
        if (attrMap.size() > 0) {
            this.OnSetPropertyEx(attrMap);
            for (String strKey : attrMap.keySet()) {
                this.OnSetProperty(strKey, attrMap.get(strKey));
            }
        }
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase("ID") == 0) {
            this.strId = strValue;
            return;
        }
        if (this.extAttrList == null) {
            this.extAttrList = new Hashtable();
        }
        this.extAttrList.put(strName.toUpperCase(), strValue);
    }

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
    }

    public final String getID() {
        return this.strId;
    }

    public final void setID(String value) {
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

    public final boolean IsContainsKey(String strKey) {
        strKey = strKey.toUpperCase();
        if (this.extAttrList != null) {
            return this.extAttrList.containsKey(strKey);
        }
        return false;
    }

    public final String GetExtValue(String strKey, String strDefault) {
        Object objValue;
        strKey = strKey.toUpperCase();
        if (this.extAttrList != null && (objValue = this.extAttrList.get(strKey)) != null) {
            return (String)objValue;
        }
        return strDefault;
    }

    public final int GetExtValue(String strKey, int nDefault) {
        try {
            Integer tempValue = new Integer(nDefault);
            return Integer.parseInt(this.GetExtValue(strKey, tempValue.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final long GetExtValue(String strKey, long nDefault) {
        try {
            Long nTempValue = new Long(nDefault);
            return Long.parseLong(this.GetExtValue(strKey, nTempValue.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final boolean GetExtValue(String strKey, boolean bDefault) {
        try {
            return XMLConfig.GetValue(this.GetExtValue(strKey, ""), bDefault);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public final void SetExtValue(String strKey, String strValue) {
        if (this.extAttrList == null) {
            this.extAttrList = new Hashtable();
        }
        this.extAttrList.put(strKey.toUpperCase(), strValue);
    }

    public final void RemoveExtValue(String strKey) {
        if (this.extAttrList == null) {
            return;
        }
        this.extAttrList.remove(strKey.toUpperCase());
    }

    public static final boolean GetValue(String strValue, boolean bDefault) {
        try {
            if (StringHelper.IsNullOrEmpty(strValue)) {
                return bDefault;
            }
            return StringHelper.Compare(strValue, "TRUE", true) == 0;
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public static final double GetValue(String strValue, double fDefault) {
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

    public static final float GetValue(String strValue, float fDefault) {
        try {
            return Float.parseFloat(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public static final int GetValue(String strValue, int nDefault) {
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final void SetValue(String strName, String strValue) {
        strName = strName.toUpperCase();
        if (StringHelper.Length(strValue) != 0) {
            if (this.extAttrList == null) {
                this.extAttrList = new Hashtable();
            }
            this.extAttrList.put(strName, strValue);
        } else if (this.extAttrList != null) {
            this.extAttrList.remove(strName);
        }
    }

    public boolean Save(SimpleXMLWriter xmlWriter, boolean bSaveChild) {
        return this.Save(xmlWriter, this.strNodeName, bSaveChild);
    }

    public boolean Save(SimpleXMLWriter xmlWriter, String strNodeName, boolean bSaveChild) {
        if (StringHelper.Length(strNodeName) != 0) {
            xmlWriter.WriteStartElement(strNodeName);
            if (!this.SavePropertys(xmlWriter)) {
                return false;
            }
            if (bSaveChild && !this.SaveChildNodes(xmlWriter)) {
                return false;
            }
            xmlWriter.WriteEndElement();
        }
        return true;
    }

    public boolean Save(SimpleXMLWriter xmlWriter) {
        return this.Save(xmlWriter, true);
    }

    protected boolean SaveChildNodes(SimpleXMLWriter xmlWriter) {
        return true;
    }

    protected boolean SavePropertys(SimpleXMLWriter xmlWriter) {
        return XMLConfig.SavePropertys(xmlWriter, this);
    }

    private static boolean SavePropertys(SimpleXMLWriter xmlWriter, XMLConfig xmlNode) {
        if (StringHelper.Length(xmlNode.getID()) != 0) {
            xmlWriter.WriteAttributeString("ID", xmlNode.getID());
        }
        if (xmlNode.extAttrList != null) {
            Enumeration enumeration = xmlNode.extAttrList.keys();
            while (enumeration.hasMoreElements()) {
                String strKey = (String)enumeration.nextElement();
                String strValue = (String)xmlNode.extAttrList.get(strKey);
                if (StringHelper.IsNullOrEmpty(strValue)) continue;
                xmlWriter.WriteAttributeString(strKey, strValue);
            }
        }
        if (!StringHelper.IsNullOrEmpty(xmlNode.getNodeValue())) {
            String strTemp = xmlNode.getNodeValue().replace("\r", "");
            strTemp = strTemp.replace("\n", "");
            strTemp = strTemp.replace("&#xD;", "");
            strTemp = strTemp.replace("&#xA;", "");
            strTemp = strTemp.replace("\t", "");
            if (!StringHelper.IsNullOrEmpty(strTemp = strTemp.replace(" ", ""))) {
                xmlWriter.WriteCDATA(strTemp);
            }
        }
        return true;
    }

    public Hashtable getExtAttrs() {
        return this.extAttrList;
    }

    public boolean LoadXML(String strXML) {
        return XMLConfig.LoadFromXML(strXML, this);
    }

    public static boolean LoadFromXML(String strXML, XMLConfig xmlConfig) {
        try {
            InputSource is = new InputSource(new StringReader(strXML));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            return xmlConfig.LoadConfig(doc.getDocumentElement());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("\u52a0\u8f7dXML\u914d\u7f6e\u53d1\u751f\u9519\u8bef"), (Throwable)ex);
            return false;
        }
    }

    public static boolean LoadFromFile(String strConfigPath, XMLConfig xmlConfig) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(strConfigPath);
            Document doc = parser.getDocument();
            return xmlConfig.LoadConfig(doc.getDocumentElement());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("\u52a0\u8f7dXML\u914d\u7f6e\u53d1\u751f\u9519\u8bef"), (Throwable)ex);
            return false;
        }
    }

    public Object clone() {
        Object obj = this.CreateCloneObject();
        if (obj == null) {
            return null;
        }
        this.CloneCopy(obj);
        return obj;
    }

    protected Object CreateCloneObject() {
        return new XMLConfig();
    }

    protected void CloneCopy(Object dst) {
        XMLConfig obj = (XMLConfig)dst;
        obj.setID(this.getID());
        obj.setNodeName(this.getNodeName());
        obj.setNodeValue(this.getNodeValue());
        if (this.extAttrList != null) {
            Enumeration enumeration = this.extAttrList.keys();
            while (enumeration.hasMoreElements()) {
                String strKey = (String)enumeration.nextElement();
                String strValue = (String)this.extAttrList.get(strKey);
                obj.SetExtValue(strKey, strValue);
            }
        }
    }

    public void Reset() {
        this.extAttrList = null;
        this.strId = "";
        this.strNodeName = "";
        this.strNodeValue = "";
    }
}

