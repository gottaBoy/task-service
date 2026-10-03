package net.ibizsys.paas.xml;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import net.ibizsys.paas.util.StringHelper;

/**
 * XML 节点，主要用于配置文件的设计及发布。
 * 
 * @author LionLau
 * 
 */
public class XmlNode extends SimpleXmlNode {
	private static final Log log = LogFactory.getLog(XmlNode.class);

	protected ArrayList<XmlNode> childNodes = null;

	protected XmlNode parentNode = null;

	protected String strXmlNodeId = "";

	protected String strPXmlNodeId = null;

	protected int nOrderFlag = 1000;

	protected String strConfigId = "";

	public XmlNode() {
		strId = "";
		this.parentNode = null;
	}

	public XmlNode(XmlNode parentNode) {
		strId = "";
		this.parentNode = parentNode;
	}

	/**
	 * 获取父节点
	 * 
	 * @return
	 */
	public XmlNode getParentNode() {
		return this.parentNode;
	}

	/**
	 * 设置父节点
	 * 
	 * @param parentNode
	 */
	public void setParentNode(XmlNode parentNode) {
		this.parentNode = parentNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.xml.SimpleXmlNode#onLoadNode(java.lang.String, org.w3c.dom.Node)
	 */
	@Override
	public void onLoadNode(String strName, Node xmlNode) {
		if (childNodes == null) {
			childNodes = new ArrayList<XmlNode>();
		}
		XmlNode node = new XmlNode(this);
		if (node.loadConfig(xmlNode)) {
			node.setParentNode(this);
			childNodes.add(node);
		}

	}

	/**
	 * 增加子节点
	 * 
	 * @param node
	 */
	public void addNode(XmlNode node) {
		if (childNodes == null) {
			childNodes = new ArrayList<XmlNode>();
		}
		node.setParentNode(this);
		childNodes.add(node);
	}

	/**
	 * 删除指定子节点
	 * 
	 * @param node
	 */
	public void removeNode(XmlNode node) {
		if (childNodes == null) {
			return;
		}

		childNodes.remove(node);
	}

	/**
	 * 按照指定位置增加节点
	 * 
	 * @param nPos
	 * @param node
	 */
	public void addNode(int nPos, XmlNode node) {
		if (childNodes == null) {
			childNodes = new ArrayList<XmlNode>();
		}
		node.setParentNode(this);
		childNodes.add(nPos, node);
	}

	/**
	 * 获取子节点的位置
	 * 
	 * @param node
	 * @return
	 */
	public int indexOf(XmlNode node) {
		if (childNodes == null) return -1;

		return childNodes.indexOf(node);
	}

	/**
	 * 获取Xml节点标识
	 * 
	 * @return
	 */
	public String getXmlNodeId() {
		return this.strXmlNodeId;
	}

	/**
	 * 设置Xml节点标识
	 * 
	 * @param strXmlNodeId
	 */
	public void getXmlNodeId(String strXmlNodeId) {
		this.strXmlNodeId = strXmlNodeId;
	}

	/**
	 * 获取父Xml节点标识
	 * 
	 * @return
	 */
	public String getPXmlNodeId() {
		return this.strPXmlNodeId;
	}

	/**
	 * 设置父Xml节点标识
	 * 
	 * @param strPXmlNodeId
	 */
	public void setPXmlNodeId(String strPXmlNodeId) {
		this.strPXmlNodeId = strPXmlNodeId;
	}

	/**
	 * 获取Xml配置标识
	 * 
	 * @return
	 */
	public String getConfigId() {
		return this.strConfigId;
	}

	/**
	 * 设置Xml配置标识
	 * 
	 * @param strConfigId
	 */
	public void setConfigId(String strConfigId) {
		this.strConfigId = strConfigId;
	}

	/**
	 * 获取子节点集合，没有返回空
	 * 
	 * @return
	 */
	public java.util.Iterator<XmlNode> getChildNodes() {
		if (childNodes == null || childNodes.size() == 0) return null;
		return childNodes.iterator();
	}

	/**
	 * 保存节点的信息
	 *
	 * @param xmlWriter SimpleXMLWriter
	 * @return boolean 是否保存子节点
	 */
	public boolean saveCurNode(SimpleXmlWriter xmlWriter, boolean bSaveChild) {
		if (StringHelper.length(strNodeName) != 0) {
			xmlWriter.writeStartElement(strNodeName);
			// 保存当前属性
			if (!saveAttributes(xmlWriter)) return false;

			// 保存子节点信息
			if (bSaveChild) {
				if (!saveChildNodes(xmlWriter)) return false;
			}
			xmlWriter.writeEndElement();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.xml.SimpleXmlNode#saveChildNodes(net.ibizsys.paas.xml.SimpleXmlWriter)
	 */
	@Override
	protected boolean saveChildNodes(SimpleXmlWriter xmlWriter) {
		if (childNodes == null) return true;

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			XmlNode childNode = childNodes.get(i);
			childNode.save(xmlWriter);
		}

		return super.saveChildNodes(xmlWriter);
	}

	/**
	 * 通过节点名称获取所有的节点（含当前节点）
	 * 
	 * @param strNodeName
	 * @param list
	 */
	public void getAllNodesByNodeName(String strNodeName, ArrayList<XmlNode> list) {
		if (StringHelper.compare(this.getNodeName(), strNodeName, true) == 0) list.add(this);

		if (childNodes == null) return;

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			XmlNode childNode = childNodes.get(i);
			childNode.getAllNodesByNodeName(strNodeName, list);
		}
	}

	/**
	 * 通过节点名称获取子节点
	 * 
	 * @param strNodeName
	 * @return
	 */
	public XmlNode getChildNodeByNodeName(String strNodeName) {
		if (childNodes == null) return null;

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			XmlNode childNode = childNodes.get(i);
			if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0) return childNode;
		}
		return null;
	}

	/**
	 * 通过节点名称获取子节点
	 * 
	 * @param strNodeName
	 * @param list
	 * @return
	 */
	public ArrayList<XmlNode> getChildNodesByNodeName(String strNodeName, ArrayList<XmlNode> list) {
		if (childNodes == null) return list;

		if (list == null) list = new ArrayList<XmlNode>();

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			XmlNode childNode = childNodes.get(i);
			if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0) list.add(childNode);
		}
		return list;
	}

	/**
	 * 通过节点名称或标识获取子节点
	 * 
	 * @param strNodeName
	 * @param strId
	 * @param list
	 * @return
	 */
	public ArrayList<XmlNode> getChildNodesByNodeNameAndId(String strNodeName, String strId, ArrayList<XmlNode> list) {
		if (childNodes == null) return list;

		if (list == null) list = new ArrayList<XmlNode>();

		int nCount = childNodes.size();
		for (int i = 0; i < nCount; i++) {
			XmlNode childNode = childNodes.get(i);
			if (StringHelper.compare(childNode.getNodeName(), strNodeName, true) == 0) {
				if (StringHelper.compare(childNode.getId(), strId, true) == 0) list.add(childNode);
			}
		}

		return list;
	}

	/**
	 * 从Xml文件中加载Xml对象
	 * 
	 * @param strPath
	 * @return
	 * @throws Exception
	 */
	public static XmlNode load(String strPath) throws Exception {
		try {
			DOMParser parser = new DOMParser();
			parser.parse(strPath);
			Document doc = parser.getDocument();

			XmlNode xmlNode = new XmlNode(null);
			xmlNode.loadConfig(doc.getDocumentElement());
			return xmlNode;

		} catch (Exception ex) {
			throw new Exception(StringHelper.format("加载XML文件发生异常，%1$s", ex.getMessage()));
		}
	}

	/**
	 * 从XML文本中加载
	 * 
	 * @param strXML
	 * @return
	 */
	public static XmlNode loadFromXML(String strXML) throws Exception {
		try {
			if (StringHelper.isNullOrEmpty(strXML)) return null;

			InputSource is = new InputSource(new java.io.StringReader(strXML));
			DOMParser parser = new DOMParser();
			parser.parse(is);
			Document doc = parser.getDocument();

			XmlNode xmlNode = new XmlNode(null);
			xmlNode.loadConfig(doc.getDocumentElement());
			return xmlNode;

		} catch (Exception ex) {
			throw new Exception(StringHelper.format("加载XML发生异常，%1$s", ex.getMessage()));
		}
	}

	/**
	 * 写入配置文件
	 * 
	 * @param rootNode
	 * @param strConfigPath
	 * @return
	 */
	public static boolean writeToFile(XmlNode rootNode, String strConfigPath) {
		try {
			StringBuilder sb = new StringBuilder();
			SimpleXmlWriter writer = new SimpleXmlWriter(sb);
			writer.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
			rootNode.save(writer);

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(strConfigPath), "UTF-8");
			out.write(sb.toString());
			out.flush();
			out.close();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/**
	 * 将XML节点导出为字符串
	 * 
	 * @param rootNode
	 * @return
	 */
	public static String export(XmlNode rootNode) throws Exception {
		StringBuilder sb = new StringBuilder();
		SimpleXmlWriter writer = new SimpleXmlWriter(sb);
		writer.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
		rootNode.save(writer);

		return sb.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.xml.SimpleXmlNode#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		childNodes = null;
	}

	/**
	 * 重置子节点
	 */
	public void resetChildNodes() {
		childNodes = null;
	}

}
