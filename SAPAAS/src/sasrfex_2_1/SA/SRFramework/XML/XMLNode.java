/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.XML;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XMLNode
extends XMLConfig {
    protected ArrayList<XMLNode> childNodes = null;
    protected XMLNode parentNode = null;
    protected String strXMLNodeId = "";
    protected String strPXMLNodeId = null;
    protected int nOrderFlag = 1000;
    protected String strConfigId = "";

    public XMLNode() {
        this.strId = "";
        this.parentNode = null;
    }

    public XMLNode(XMLNode parentNode) {
        this.strId = "";
        this.parentNode = parentNode;
    }

    public XMLNode getParentNode() {
        return this.parentNode;
    }

    public void setParentNode(XMLNode parentNode) {
        this.parentNode = parentNode;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLNode node;
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        if ((node = new XMLNode(this)).LoadConfig(xmlNode)) {
            node.setParentNode(this);
            this.childNodes.add(node);
        }
    }

    public void AddNode(XMLNode node) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        node.setParentNode(this);
        this.childNodes.add(node);
    }

    public void RemoveNode(XMLNode node) {
        if (this.childNodes == null) {
            return;
        }
        this.childNodes.remove((Object)node);
    }

    public void AddNode(int nPos, XMLNode node) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        node.setParentNode(this);
        this.childNodes.add(nPos, node);
    }

    public int IndexOf(XMLNode node) {
        if (this.childNodes == null) {
            return -1;
        }
        return this.childNodes.indexOf((Object)node);
    }

    public String getXMLNodeId() {
        return this.strXMLNodeId;
    }

    public void getXMLNodeId(String strXMLNodeId) {
        this.strXMLNodeId = strXMLNodeId;
    }

    public String getPXMLNodeId() {
        return this.strPXMLNodeId;
    }

    public void setPXMLNodeId(String strPXMLNodeId) {
        this.strPXMLNodeId = strPXMLNodeId;
    }

    public String getConfigId() {
        return this.strConfigId;
    }

    public void setConfigId(String strConfigId) {
        this.strConfigId = strConfigId;
    }

    public ArrayList<XMLNode> getChildNodes() {
        return this.childNodes;
    }

    public boolean SaveCurNode(SimpleXMLWriter xmlWriter, boolean bSaveChild) {
        if (StringHelper.Length((String)this.strNodeName) != 0) {
            xmlWriter.WriteStartElement(this.strNodeName);
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

    protected boolean SaveChildNodes(SimpleXMLWriter xmlWriter) {
        if (this.childNodes == null) {
            return true;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode childNode = this.childNodes.get(i);
            childNode.Save(xmlWriter);
            ++i;
        }
        return super.SaveChildNodes(xmlWriter);
    }

    public void GetAllNodeByNodeName(String strNodeName, ArrayList<XMLNode> list) {
        if (StringHelper.Compare((String)this.getNodeName(), (String)strNodeName, (boolean)true) == 0) {
            list.add(this);
        }
        if (this.childNodes == null) {
            return;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode childNode = this.childNodes.get(i);
            childNode.GetAllNodeByNodeName(strNodeName, list);
            ++i;
        }
    }

    public XMLNode GetChildNodeByNodeName(String strNodeName) {
        if (this.childNodes == null) {
            return null;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode childNode = this.childNodes.get(i);
            if (StringHelper.Compare((String)childNode.getNodeName(), (String)strNodeName, (boolean)true) == 0) {
                return childNode;
            }
            ++i;
        }
        return null;
    }

    public void GetChildNodeByNodeName(String strNodeName, ArrayList<XMLNode> list) {
        if (this.childNodes == null) {
            return;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode childNode = this.childNodes.get(i);
            if (StringHelper.Compare((String)childNode.getNodeName(), (String)strNodeName, (boolean)true) == 0) {
                list.add(childNode);
            }
            ++i;
        }
    }

    public void GetChildNodeByNodeNameAndId(String strNodeName, String strId, ArrayList<XMLNode> list) {
        if (this.childNodes == null) {
            return;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XMLNode childNode = this.childNodes.get(i);
            if (StringHelper.Compare((String)childNode.getNodeName(), (String)strNodeName, (boolean)true) == 0 && StringHelper.Compare((String)childNode.getID(), (String)strId, (boolean)true) == 0) {
                list.add(childNode);
            }
            ++i;
        }
    }

    public static XMLNode Load(String strPath) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(strPath);
            Document doc = parser.getDocument();
            XMLNode xmlNode = new XMLNode(null);
            xmlNode.LoadConfig(doc.getDocumentElement());
            return xmlNode;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static XMLNode LoadFromXML(String strXML) {
        try {
            InputSource is = new InputSource(new StringReader(strXML));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            XMLNode xmlNode = new XMLNode(null);
            xmlNode.LoadConfig(doc.getDocumentElement());
            return xmlNode;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static boolean WriteToFile(XMLNode rootNode, String strConfigPath) {
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath), "UTF-8");
            out.write(sb.toString());
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static String Export(XMLNode rootNode) {
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            return sb.toString();
        }
        catch (Exception ex) {
            return "";
        }
    }

    public void Reset() {
        super.Reset();
        this.childNodes = null;
    }
}

