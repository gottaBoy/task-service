/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package net.ibizsys.paas.xml;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XmlNode
extends SimpleXmlNode {
    private static final Log log = LogFactory.getLog(XmlNode.class);
    protected ArrayList<XmlNode> childNodes = null;
    protected XmlNode parentNode = null;
    protected String strXmlNodeId = "";
    protected String strPXmlNodeId = null;
    protected int nOrderFlag = 1000;
    protected String strConfigId = "";

    public XmlNode() {
        this.strId = "";
        this.parentNode = null;
    }

    public XmlNode(XmlNode parentNode) {
        this.strId = "";
        this.parentNode = parentNode;
    }

    public XmlNode getParentNode() {
        return this.parentNode;
    }

    public void setParentNode(XmlNode parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public void onLoadNode(String strName, Node xmlNode) {
        XmlNode node;
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        if ((node = new XmlNode(this)).loadConfig(xmlNode)) {
            node.setParentNode(this);
            this.childNodes.add(node);
        }
    }

    public void addNode(XmlNode node) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        node.setParentNode(this);
        this.childNodes.add(node);
    }

    public void removeNode(XmlNode node) {
        if (this.childNodes == null) {
            return;
        }
        this.childNodes.remove(node);
    }

    public void addNode(int nPos, XmlNode node) {
        if (this.childNodes == null) {
            this.childNodes = new ArrayList();
        }
        node.setParentNode(this);
        this.childNodes.add(nPos, node);
    }

    public int indexOf(XmlNode node) {
        if (this.childNodes == null) {
            return -1;
        }
        return this.childNodes.indexOf(node);
    }

    public String getXmlNodeId() {
        return this.strXmlNodeId;
    }

    public void getXmlNodeId(String strXmlNodeId) {
        this.strXmlNodeId = strXmlNodeId;
    }

    public String getPXmlNodeId() {
        return this.strPXmlNodeId;
    }

    public void setPXmlNodeId(String strPXmlNodeId) {
        this.strPXmlNodeId = strPXmlNodeId;
    }

    public String getConfigId() {
        return this.strConfigId;
    }

    public void setConfigId(String strConfigId) {
        this.strConfigId = strConfigId;
    }

    public Iterator<XmlNode> getChildNodes() {
        if (this.childNodes == null || this.childNodes.size() == 0) {
            return null;
        }
        return this.childNodes.iterator();
    }

    public boolean saveCurNode(SimpleXmlWriter xmlWriter, boolean bSaveChild) {
        if (StringHelper.length(this.strNodeName) != 0) {
            xmlWriter.writeStartElement(this.strNodeName);
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

    @Override
    protected boolean saveChildNodes(SimpleXmlWriter xmlWriter) {
        if (this.childNodes == null) {
            return true;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XmlNode childNode = this.childNodes.get(i);
            childNode.save(xmlWriter);
            ++i;
        }
        return super.saveChildNodes(xmlWriter);
    }

    public void getAllNodesByNodeName(String strNodeName, ArrayList<XmlNode> list) {
        if (StringHelper.compare(this.getNodeName(), strNodeName, true) == 0) {
            list.add(this);
        }
        if (this.childNodes == null) {
            return;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XmlNode childNode = this.childNodes.get(i);
            childNode.getAllNodesByNodeName(strNodeName, list);
            ++i;
        }
    }

    public XmlNode getChildNodeByNodeName(String strNodeName) {
        if (this.childNodes == null) {
            return null;
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XmlNode childNode = this.childNodes.get(i);
            if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0) {
                return childNode;
            }
            ++i;
        }
        return null;
    }

    public ArrayList<XmlNode> getChildNodesByNodeName(String strNodeName, ArrayList<XmlNode> list) {
        if (this.childNodes == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList();
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XmlNode childNode = this.childNodes.get(i);
            if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0) {
                list.add(childNode);
            }
            ++i;
        }
        return list;
    }

    public ArrayList<XmlNode> getChildNodesByNodeNameAndId(String strNodeName, String strId, ArrayList<XmlNode> list) {
        if (this.childNodes == null) {
            return list;
        }
        if (list == null) {
            list = new ArrayList();
        }
        int nCount = this.childNodes.size();
        int i = 0;
        while (i < nCount) {
            XmlNode childNode = this.childNodes.get(i);
            if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0 && StringHelper.compare(childNode.getId(), strId, true) == 0) {
                list.add(childNode);
            }
            ++i;
        }
        return list;
    }

    public static XmlNode load(String strPath) throws Exception {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(strPath);
            Document doc = parser.getDocument();
            XmlNode xmlNode = new XmlNode(null);
            xmlNode.loadConfig(doc.getDocumentElement());
            return xmlNode;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format("\u52a0\u8f7dXML\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
        }
    }

    public static XmlNode loadFromXML(String strXML) throws Exception {
        block3: {
            try {
                if (!StringHelper.isNullOrEmpty(strXML)) break block3;
                return null;
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format("\u52a0\u8f7dXML\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            }
        }
        InputSource is = new InputSource(new StringReader(strXML));
        DOMParser parser = new DOMParser();
        parser.parse(is);
        Document doc = parser.getDocument();
        XmlNode xmlNode = new XmlNode(null);
        xmlNode.loadConfig(doc.getDocumentElement());
        return xmlNode;
    }

    public static boolean writeToFile(XmlNode rootNode, String strConfigPath) {
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXmlWriter writer = new SimpleXmlWriter(sb);
            writer.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.save(writer);
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

    public static String export(XmlNode rootNode) throws Exception {
        StringBuilder sb = new StringBuilder();
        SimpleXmlWriter writer = new SimpleXmlWriter(sb);
        writer.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
        rootNode.save(writer);
        return sb.toString();
    }

    @Override
    public void reset() {
        super.reset();
        this.childNodes = null;
    }

    public void resetChildNodes() {
        this.childNodes = null;
    }
}

