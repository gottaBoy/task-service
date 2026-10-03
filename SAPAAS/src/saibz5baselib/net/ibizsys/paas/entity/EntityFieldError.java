package net.ibizsys.paas.entity;

import net.ibizsys.paas.util.StringHelper;

/**
 * 数据对象属性错误信息
 * 
 * @author liuzhi
 *
 */
public class EntityFieldError {

	public final static int ERROR_OK = 0;

	/**
	 * 数据输入为空错误
	 */
	public final static int ERROR_EMPTY = 1;

	/**
	 * 数据类型不正确错误
	 */
	public final static int ERROR_DATATYPE = 2;

	/**
	 * 值规则错误
	 */
	public final static int ERROR_VALUERULE = 3;

	private String strFieldLogicName = "";
	private String strFieldName = "";
	private String strFieldErrorId = "";
	private int nErrorType = ERROR_OK;
	private String strErrorInfo = "";
	private Object objFieldValue = null;

	public EntityFieldError() {

	}

	/**
	 * 获取属性名称
	 * 
	 * @return
	 */
	public String getFieldName() {
		return this.strFieldName;
	}

	/**
	 * 设置属性名称
	 * 
	 * @param strFieldName
	 */
	public void setFieldName(String strFieldName) {
		this.strFieldName = strFieldName;
	}

	/**
	 * 获取属性值
	 * 
	 * @return
	 */
	public Object getFieldValue() {
		return this.objFieldValue;
	}

	/**
	 * 设置属性值
	 * 
	 * @param strFieldValue
	 */
	public void setFieldValue(Object objFieldValue) {
		this.objFieldValue = objFieldValue;
	}

	/**
	 * 获取属性逻辑名称
	 * 
	 * @return
	 */
	public String getFieldLogicName() {
		return this.strFieldLogicName;
	}

	/**
	 * 设置属性逻辑名称
	 * 
	 * @param strFieldLogicName
	 */
	public void setFieldLogicName(String strFieldLogicName) {
		this.strFieldLogicName = strFieldLogicName;
	}

	/**
	 * 获取表单错误编号
	 * 
	 * @return
	 */
	public String getFieldErrorId() {
		return this.strFieldErrorId;
	}

	/**
	 * 设置表单错误编号
	 * 
	 * @param strFieldErrorId
	 */
	public void setFieldErrorId(String strFieldErrorId) {
		this.strFieldErrorId = strFieldErrorId;
	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getErrorInfo() {
		return this.strErrorInfo;
	}

	/**
	 * 设置属性名称错误信息
	 * 
	 * @param strErrorInfo
	 */
	public void setErrorInfo(String strErrorInfo) {
		this.strErrorInfo = strErrorInfo;
	}

	/**
	 * 获取错误类型
	 * 
	 * @return
	 */
	public int getErrorType() {
		return this.nErrorType;
	}

	/**
	 * 设置错误类型
	 * 
	 * @param nErrorType
	 */
	public void setErrorType(int nErrorType) {
		this.nErrorType = nErrorType;
	}

	@Override
	public String toString() {
		if (StringHelper.isNullOrEmpty(this.getFieldLogicName())) {
			return StringHelper.format("%1$s[%2$s], %3$s", this.getFieldName(), getErrorTypeString(this.getErrorType()), this.getErrorInfo());
		} else {
			return StringHelper.format("%1$s[%2$s], %3$s", this.getFieldLogicName(), getErrorTypeString(this.getErrorType()), this.getErrorInfo());
		}

	}

	/**
	 * 转换错误类型代码
	 * 
	 * @param nErrorType
	 * @return
	 */
	public static String getErrorTypeString(int nErrorType) {
		switch (nErrorType) {
		case ERROR_EMPTY:
			return "数据输入为空错误";
		case ERROR_DATATYPE:
			return "数据类型不正确错误";
		case ERROR_VALUERULE:
			return "值规则错误";
		default:
			return "未知错误";
		}

	}

}
