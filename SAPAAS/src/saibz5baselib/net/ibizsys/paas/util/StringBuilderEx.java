package net.ibizsys.paas.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 字符串构建器
 * 
 * @author liuzhi
 *
 */

public class StringBuilderEx {
	protected Writer writer = null;

	public StringBuilderEx() {
		reset();
	}

	public StringBuilderEx(Writer writer) {
		if (this.writer != null) this.writer = null;
		this.writer = writer;
	}

	/**
	 * 重置
	 */
	public void reset() {
		if (writer != null) writer = null;
		writer = new StringWriter();
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat 内容不做格式化处理，不须做字符转义。
	 */
	public void append(String strFormat) {
		try {
			writer.write(strFormat);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat 内容做格式化处理，需要做字符转义。
	 */
	public void appendEx(String strFormat) {
		try {
			writer.write(String.format(strFormat, ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 */
	public void append(String strFormat, Object obj1) {
		try {
			writer.write(String.format(strFormat, obj1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 */
	public void append(String strFormat, Object obj1, Object obj2) {
		try {
			writer.write(String.format(strFormat, obj1, obj2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 * @param obj10
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 * @param obj10
	 * @param obj11
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param obj1
	 * @param obj2
	 * @param obj3
	 * @param obj4
	 * @param obj5
	 * @param obj6
	 * @param obj7
	 * @param obj8
	 * @param obj9
	 * @param obj10
	 * @param obj11
	 * @param obj12
	 */
	public void append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
		try {
			writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 附加一段文本
	 * 
	 * @param strFormat
	 * @param arrList
	 */
	public void append(String strFormat, Object[] arrList) {
		try {
			int nArrCount = arrList.length;

			switch (nArrCount) {
			case 0:
				writer.write(strFormat);
				break;
			case 1:
				writer.write(String.format(strFormat, arrList[0]));
				break;
			case 2:
				writer.write(String.format(strFormat, arrList[0], arrList[1]));
				break;
			case 3:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2]));
				break;
			case 4:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3]));
				break;
			case 5:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4]));
				break;
			case 6:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5]));
				break;
			case 7:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6]));
				break;
			case 8:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7]));
				break;
			case 9:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8]));
				break;
			case 10:
				writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8], arrList[9]));
				break;
			default:
				writer.write(strFormat);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return writer.toString();
	}

	/**
	 * 获取Writer对象
	 * 
	 * @return
	 */
	public Writer getWriter() {
		return this.writer;
	}

}
