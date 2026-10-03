package net.ibizsys.paas.xml;

/**
 * XML编写器接口
 * 
 * @author Administrator
 *
 */
public interface ISimpleXmlWriter {

	/**
	 * 写入直接内容
	 * 
	 * @param strRawText
	 */
	void writeRaw(String strRawText);

	/**
	 * 开始写入元素
	 * 
	 * @param strElement
	 */
	void writeStartElement(String strElement);

	/**
	 * 写入注释
	 * 
	 * @param strComment
	 */
	void writeComment(String strComment);

	/**
	 * 写入CDATA分区
	 * 
	 * @param strContent
	 */
	void writeCDATA(String strContent);

	/**
	 * 写入节点值
	 * 
	 * @param strContent
	 */
	void writeValue(String strContent);

	/**
	 * 写入属性
	 *
	 * @param strName String
	 * @param strValue String
	 */
	void writeAttributeString(String strName, String strValue);

	/**
	 * 写入结束符号
	 */
	void writeEndElement();

}
