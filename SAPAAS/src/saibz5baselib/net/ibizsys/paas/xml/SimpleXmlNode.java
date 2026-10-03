package net.ibizsys.paas.xml;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.ibizsys.paas.util.StringHelper;

/**
 * XML 基本配置对象
 * 
 * @author LionLau
 * 
 */
public class SimpleXmlNode implements Cloneable {
	private static final Log log = LogFactory.getLog(SimpleXmlNode.class);

	public final static String DOCHEADER = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
	public final static String PROPERTY_ID = "ID";

	public SimpleXmlNode() {
	}

	protected String strId = ""; // 节点ID

	protected String strNodeName = "";

	protected String strNodeValue = "";

	protected HashMap<String, String> extAttrList = null;// new Hashtable();

	/**
	 * 从Xml节点中加载
	 * 
	 * @param xmlNode
	 * @return
	 */
	public boolean loadConfig(Node xmlNode) {
		// 枚举节点自身属性
		if (true) {
			strNodeName = xmlNode.getNodeName();
			strNodeValue = xmlNode.getNodeValue();
			if (strNodeValue == null) strNodeValue = "";
		}

		// 枚举所有的属性
		if (true) {
			NamedNodeMap attrs = xmlNode.getAttributes();
			if (attrs != null && attrs.getLength() > 0) {
				HashMap<String, String> attrMap = new HashMap<String, String>();
				for (int i = 0; i < attrs.getLength(); i++) {
					Node attrNode = attrs.item(i);
					if (attrNode != null) {
						attrMap.put(attrNode.getNodeName().toUpperCase(), attrNode.getNodeValue());

					}
				}

				String strValue = attrMap.remove("ID");
				if (strValue != null) {
					this.setId(strValue);
				}
				if (attrMap.size() > 0) {
					onSetAttributeEx(attrMap);

					for (String strKey : attrMap.keySet()) {
						onSetAttribute(strKey, attrMap.get(strKey));
					}
				}
			}

		}
		// 枚举所有的子结点
		if (true) {
			NodeList nodes = xmlNode.getChildNodes();
			if (nodes != null) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node childNode = nodes.item(i);
					if (childNode != null) {
						String strNodeName = childNode.getNodeName().toUpperCase();
						if (StringHelper.compare(strNodeName, "#TEXT", true) == 0) {
							strNodeValue += childNode.getNodeValue();
							continue;
						}

						if (StringHelper.compare(strNodeName, "#CDATA-SECTION", true) == 0) {
							strNodeValue += childNode.getNodeValue();
							continue;
						}

						if (strNodeName.indexOf("#") == 0) {
							continue;
						}

						onLoadNode(strNodeName, childNode);
					}
				}
			}

		}

		return onLoadConfig();
	}

	/**
	 * 加载XML节点触发
	 * 
	 * @param strName
	 * @param xmlNode
	 */
	protected void onLoadNode(String strName, Node xmlNode) {
	}

	/**
	 * 配置加载完毕后触发
	 * 
	 * @return
	 */
	protected boolean onLoadConfig() {
		return true;
	}

	/**
	 * 设置节点属性
	 * 
	 * @param strName
	 * @param strValue
	 */
	final public void setAttribute(String strName, String strValue) {
		if (strValue == null) strValue = "";

		HashMap<String, String> attrMap = new HashMap<String, String>();
		attrMap.put(strName.toUpperCase(), strValue);

		if (attrMap.size() > 0) {
			onSetAttributeEx(attrMap);

			for (String strKey : attrMap.keySet()) {
				onSetAttribute(strKey, attrMap.get(strKey));
			}
		}
	}

	/**
	 * 设置节点属性触发
	 * 
	 * @param strName
	 * @param strValue
	 */
	protected void onSetAttribute(String strName, String strValue) {
		if (strName.compareToIgnoreCase(PROPERTY_ID) == 0) {
			strId = strValue;
		}

		// 不明属性
		if (extAttrList == null) extAttrList = new HashMap<String, String>();
		extAttrList.put(strName.toUpperCase(), strValue);
	}

	/**
	 * 设置属性，如果属性被使用，则删除此属性
	 * 
	 * @param attrMap
	 */
	protected void onSetAttributeEx(HashMap<String, String> attrMap) {

	}

	/**
	 * 获取节点编号
	 * 
	 * @return
	 */
	final public String getId() {
		return strId;
	}

	/**
	 * 设置节点编号
	 * 
	 * @param value
	 */
	final public void setId(String value) {
		strId = value;
	}

	/**
	 * 获取节点名称
	 * 
	 * @return
	 */
	final public String getNodeName() {
		return strNodeName;
	}

	/**
	 * 设置节点名称
	 * 
	 * @param value
	 */
	final public void setNodeName(String value) {
		strNodeName = value;
	}

	/**
	 * 获取节点值
	 * 
	 * @return
	 */
	final public String getNodeValue() {
		return strNodeValue;
	}

	/**
	 * 设置节点值
	 * 
	 * @param value
	 */
	final public void setNodeValue(String value) {
		strNodeValue = value;
	}

	/**
	 * 判断是否存在指定键值
	 * 
	 * @param strKey
	 * @return
	 */
	final public boolean isContainsKey(String strKey) {
		strKey = strKey.toUpperCase();
		if (extAttrList != null) {
			return extAttrList.containsKey(strKey);
		}
		return false;
	}

	/**
	 * 获取节点属性（String）
	 * 
	 * @param strKey
	 * @param strDefault
	 * @return
	 */
	final public String getAttribute(String strKey, String strDefault) {
		strKey = strKey.toUpperCase();
		if (extAttrList != null) {
			Object objValue = extAttrList.get(strKey);
			if (objValue != null) {
				return (String) objValue;
			}
		}
		return strDefault;
	}

	/**
	 * 获取节点属性（Int）
	 * 
	 * @param strKey
	 * @param nDefault
	 * @return
	 */
	final public int getAttribute(String strKey, int nDefault) {
		try {
			Integer tempValue = new Integer(nDefault);
			return Integer.parseInt(getAttribute(strKey, tempValue.toString()));
		} catch (Exception ex) {
			return nDefault;
		}
	}

	/**
	 * 获取节点属性（Long）
	 * 
	 * @param strKey
	 * @param nDefault
	 * @return
	 */
	final public long getAttribute(String strKey, long nDefault) {
		try {
			Long nTempValue = new Long(nDefault);
			return Long.parseLong(getAttribute(strKey, nTempValue.toString()));
		} catch (Exception ex) {
			return nDefault;
		}

	}

	/**
	 * 获取节点属性（Boolean）
	 * 
	 * @param strKey
	 * @param bDefault
	 * @return
	 */
	final public boolean getAttribute(String strKey, boolean bDefault) {
		try {
			return getValue(getAttribute(strKey, ""), bDefault);
		} catch (Exception ex) {
			return bDefault;
		}
	}

	/**
	 * 转换字符串到Boolean
	 * 
	 * @param strValue
	 * @param bDefault
	 * @return
	 */
	final public static boolean getValue(String strValue, boolean bDefault) {
		try {
			if (StringHelper.isNullOrEmpty(strValue)) return bDefault;
			return StringHelper.compare(strValue, "TRUE", true) == 0;
		} catch (Exception ex) {
			return bDefault;
		}

	}

	/**
	 * 转换字符串到Double
	 * 
	 * @param strValue
	 * @param fDefault
	 * @return
	 */
	final public static double getValue(String strValue, double fDefault) {
		try {
			if (strValue.indexOf("%") == (strValue.length() - 1)) {
				strValue = strValue.replaceAll("%", "");
				return Double.parseDouble(strValue) / 100;
			} else
				return Double.parseDouble(strValue);
		} catch (Exception ex) {
			return fDefault;
		}
	}

	/**
	 * 转换字符串到Float
	 * 
	 * @param strValue
	 * @param fDefault
	 * @return
	 */
	final public static float getValue(String strValue, float fDefault) {
		try {
			return Float.parseFloat(strValue);
		} catch (Exception ex) {
			return fDefault;
		}
	}

	/**
	 * 转换字符串到Int
	 * 
	 * @param strValue
	 * @param nDefault
	 * @return
	 */
	final public static int getValue(String strValue, int nDefault) {
		try {
			return Integer.parseInt(strValue);
		} catch (Exception ex) {
			return nDefault;
		}
	}

	/**
	 * 直接设置属性及值
	 * 
	 * @param strName
	 * @param strValue
	 */
	final public void setValue(String strName, String strValue) {
		if (strValue == null) strValue = "";

		strName = strName.toUpperCase();
		if (StringHelper.length(strValue) != 0) {
			if (extAttrList == null) extAttrList = new HashMap<String, String>();
			extAttrList.put(strName, strValue);
		} else {
			if (extAttrList != null) {
				extAttrList.remove(strName);
			}
		}
	}

	/**
	 * 保存节点数据
	 * 
	 * @param xmlWriter
	 * @param bSaveChild 是否包括子节点
	 * @return boolean
	 */
	public boolean save(SimpleXmlWriter xmlWriter, boolean bSaveChild) {
		return save(xmlWriter, strNodeName, bSaveChild);
	}

	/**
	 * 保存节点数据
	 * 
	 * @param xmlWriter
	 * @param strNodeName 节点名称
	 * @param bSaveChild 是否包括子节点
	 * @return
	 */
	public boolean save(SimpleXmlWriter xmlWriter, String strNodeName, boolean bSaveChild) {
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

	/**
	 * 保存节点数据，同时保存子节点
	 * 
	 * @param xmlWriter
	 * @return
	 */
	public boolean save(SimpleXmlWriter xmlWriter) {
		return save(xmlWriter, true);
	}

	/**
	 * 保存子节点数据
	 * 
	 * @param xmlWriter SimpleXMLWriter
	 * @return boolean
	 */
	protected boolean saveChildNodes(SimpleXmlWriter xmlWriter) {
		return true;
	}

	/**
	 * 保存节点的属性
	 * 
	 * @param xmlWriter SimpleXMLWriter
	 * @return boolean
	 */
	protected boolean saveAttributes(SimpleXmlWriter xmlWriter) {
		return saveAttributes(xmlWriter, this);
	}

	/**
	 * 保存节点属性
	 * 
	 * @param xmlWriter
	 * @param xmlNode
	 * @return
	 */
	private static boolean saveAttributes(SimpleXmlWriter xmlWriter, SimpleXmlNode xmlNode) {
		if (StringHelper.length(xmlNode.getId()) != 0) {
			xmlWriter.writeAttributeString(PROPERTY_ID, xmlNode.getId());
		}

		if (xmlNode.extAttrList != null) {
			for (String strKey : xmlNode.extAttrList.keySet()) {
				String strValue = (String) xmlNode.extAttrList.get(strKey);
				if (!StringHelper.isNullOrEmpty(strValue)) xmlWriter.writeAttributeString(strKey, strValue);
			}
		}

		if (!StringHelper.isNullOrEmpty(xmlNode.getNodeValue())) {
			String strTemp = xmlNode.getNodeValue().replace("\r", "");
			strTemp = strTemp.replace("\n", "");
			strTemp = strTemp.replace("&#xD;", "");
			strTemp = strTemp.replace("&#xA;", "");
			strTemp = strTemp.replace("\t", "");
			strTemp = strTemp.replace(" ", "");
			if (!StringHelper.isNullOrEmpty(strTemp)) xmlWriter.writeCDATA(strTemp);
		}

		return true;
	}

	/**
	 * 获取所有的属性
	 * 
	 * @return
	 */
	public java.util.Iterator<String> getAttributes() {
		if (this.extAttrList == null) return null;
		return this.extAttrList.keySet().iterator();
	}

	/**
	 * 节点加载XML文本
	 * 
	 * @param strXML
	 * @return
	 */
	public boolean loadXML(String strXML) {
		return SimpleXmlNode.loadFromXML(strXML, this);
	}

	/**
	 * 加载配置
	 * 
	 * @param strXML
	 * @param xmlConfig
	 * @return
	 */
	public static boolean loadFromXML(String strXML, SimpleXmlNode xmlConfig) {
		try {
			InputSource is = new InputSource(new java.io.StringReader(strXML));
			DOMParser parser = new DOMParser();
			parser.parse(is);
			Document doc = parser.getDocument();

			return xmlConfig.loadConfig(doc.getDocumentElement());
		} catch (Exception ex) {
			log.error(StringHelper.format("加载XML配置发生错误"), ex);
			return false;
		}
	}

	/**
	 * 从文件中加载XML节点
	 * 
	 * @param strConfigPath
	 * @param xmlConfig
	 * @return
	 */
	public static boolean loadFromFile(String strConfigPath, SimpleXmlNode xmlConfig) {
		try {
			DOMParser parser = new DOMParser();
			parser.parse(strConfigPath);
			Document doc = parser.getDocument();
			return xmlConfig.loadConfig(doc.getDocumentElement());
		} catch (Exception ex) {
			log.error(StringHelper.format("加载XML配置发生错误"), ex);
			return false;
		}
	}

	/**
	 * 重置
	 */
	public void reset() {
		resetAttributes();
		this.strNodeName = "";

	}

	/**
	 * 重置全部属性
	 */
	public void resetAttributes() {
		this.extAttrList = null;
		this.strId = "";
		this.strNodeValue = "";
	}
}
