package net.ibizsys.paas.xml;

import java.util.Stack;

import net.ibizsys.paas.util.StringHelper;

/**
 * XML 编写器
 * 
 * @author Administrator
 *
 */
public class SimpleXmlWriter implements ISimpleXmlWriter {
	private Stack childElements = new Stack();
	private StringBuilder internalBuilder = null;
	private int nCurChildCount = 0;
	private String strCurElementName = "";

	/*
	 * 子节点层次
	 */
	private int nCurChildLevel = -1;

	public SimpleXmlWriter(StringBuilder sb) {
		internalBuilder = sb;
	}
	
	/**
	 * 写入直接内容
	 * 
	 * @param strRawText
	 */
	public void writeRaw(String strRawText) {
		internalBuilder.append(strRawText);
	}

	/**
	 * 开始写入元素
	 * 
	 * @param strElement
	 */
	public void writeStartElement(String strElement) {
		nCurChildLevel++;
		// 写入一个元素，需要将上次的元素封闭
		if (StringHelper.length(strCurElementName) > 0) {
			// 放入堆栈中
			childElements.push(strCurElementName);
			// 封闭当前节点
			appendElementEndTag(true);

		}
		strCurElementName = strElement;
		appendElementStartTag();
	}

	/**
	 * 写入注释
	 * 
	 * @param strComment
	 */
	public void writeComment(String strComment) {
		// 写入一个元素，需要将上次的元素封闭
		if (StringHelper.length(strCurElementName) > 0) {
			// 放入堆栈中
			childElements.push(strCurElementName);
			// 封闭当前节点
			appendElementEndTag(true);
			strCurElementName = "";
		}
		nCurChildLevel++;
		appendIndent();
		writeRaw("<!-- ");
		writeRaw(strComment);
		writeRaw(" -->\r\n");
		nCurChildLevel--;
	}

	/**
	 * 写入CDATA分区
	 * 
	 * @param strContent
	 */
	public void writeCDATA(String strContent) {
		nCurChildLevel++;
		// 写入一个元素，需要将上次的元素封闭
		if (StringHelper.length(strCurElementName) > 0) {
			// 放入堆栈中
			childElements.push(strCurElementName);
			// 封闭当前节点
			appendElementEndTag(true);

		}

		strCurElementName = "";

		appendIndent();
		writeRaw("<![CDATA[");
		writeRaw(strContent);
		writeRaw("]]>\r\n");

		nCurChildLevel--;
	}

	/**
	 * 写入节点值
	 * 
	 * @param strContent
	 */
	public void writeValue(String strContent) {
		// nCurChildLevel ++;
		// 写入一个元素，需要将上次的元素封闭
		if (StringHelper.length(strCurElementName) > 0) {
			// 放入堆栈中
			childElements.push(strCurElementName);
			// 封闭当前节点
			appendElementEndTag(true, false);

		}

		strCurElementName = "";
		// appendIndent();
		writeRaw(formatXMLContent(strContent, true));
		// nCurChildLevel --;

	}

	/**
	 * 写入属性
	 *
	 * @param strName String
	 * @param strValue String
	 */
	public void writeAttributeString(String strName, String strValue) {
		internalBuilder.append(" ");
		internalBuilder.append(formatXMLContent(strName, false));
		internalBuilder.append("=\"");
		internalBuilder.append(formatXMLContent(strValue, true));
		internalBuilder.append("\"");
	}

	/**
	 * 写入结束符号
	 */
	public void writeEndElement() {
		writeEndElement(true);
	}

	/**
	 * 写入结束符号
	 */
	public void writeEndElement(boolean bIndent) {
		if (StringHelper.length(strCurElementName) > 0) {
			internalBuilder.append("/>\r\n");
			strCurElementName = "";
		} else {
			if (childElements.size() > 0) {
				String strTemp = (String) childElements.pop();
				if (bIndent) {
					appendIndent();
				}
				internalBuilder.append("</" + strTemp + ">\r\n");
			}
		}
		nCurChildLevel--;
	}

	/**
	 * 写入元素结束符号
	 * 
	 * @param bFirstPart
	 */
	private void appendElementEndTag(boolean bFirstPart) {
		appendElementEndTag(bFirstPart, true);
	}

	/**
	 * 写入元素结束符号
	 * 
	 * @param bFirstPart
	 * @param bReturn 回车
	 */
	private void appendElementEndTag(boolean bFirstPart, boolean bReturn) {
		if (bFirstPart) {
			internalBuilder.append(">");
			if (bReturn) {
				internalBuilder.append("\r\n");
			}
		} else {

		}
	}

	/**
	 * 写入元素开始符号
	 */
	private void appendElementStartTag() {
		appendIndent();
		internalBuilder.append("<");
		internalBuilder.append(formatXMLContent(strCurElementName, false));
		internalBuilder.append(" ");
	}

	/**
	 * 写入间隔
	 */
	private void appendIndent() {
		for (int i = 0; i < nCurChildLevel; i++) {
			internalBuilder.append("    ");
		}
	}

	/**
	 * 分别用 &amp;、&lt; 和 &gt; 替换字符 &、< 和 >。 用数字字符实体（&#0; 到 &#0x1F）替换范围 0x-0x1F 中（不包括空白字符 0x9、0x10 和 0x13）的字符值。 如果在属性值的上下文中调用 writeString，则分别用 &quot; 和 &apos; 替换双引号和单引号。
	 * 
	 * @param strOrigin String
	 * @param bProperty boolean
	 * @return String
	 */
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
