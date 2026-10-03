package net.ibizsys.paas.control.form;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 表单项错误信息
 * 
 * @author liuzhi
 *
 */
public class FormItemError {

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

	protected String strFormItemId = "";
	protected String strFormErrorId = "";
	protected int nErrorType = ERROR_OK;
	protected String strErrorInfo = "";

	public FormItemError() {

	}

	/**
	 * 获取表单项编号
	 * 
	 * @return
	 */
	public String getFormItemId() {
		return this.strFormItemId;
	}

	/**
	 * 设置表单项编号
	 * 
	 * @param strFormItemId
	 */
	public void setFormItemId(String strFormItemId) {
		this.strFormItemId = strFormItemId;
	}

	/**
	 * 获取表单错误编号
	 * 
	 * @return
	 */
	public String getFormErrorId() {
		return this.strFormErrorId;
	}

	/**
	 * 设置表单错误编号
	 * 
	 * @param strFormErrorId
	 */
	public void setFormErrorId(String strFormErrorId) {
		this.strFormErrorId = strFormErrorId;
	}

	/**
	 * 获取表单项错误信息
	 * 
	 * @return
	 */
	public String getErrorInfo() {
		return this.strErrorInfo;
	}

	/**
	 * 设置表单项错误信息
	 * 
	 * @param strErrorInfo
	 */
	public void setErrorInfo(String strErrorInfo) {
		this.strErrorInfo = strErrorInfo;
	}

	/**
	 * 获取表单项错误类型
	 * 
	 * @return
	 */
	public int getErrorType() {
		return this.nErrorType;
	}

	/**
	 * 设置表单项错误类型
	 * 
	 * @param nErrorType
	 */
	public void setErrorType(int nErrorType) {
		this.nErrorType = nErrorType;
	}

	/**
	 * 导出到Json对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONObject toJSONObject() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id", JSONObjectHelper.stripQuotes(strFormItemId,true));
		obj.put("errid", JSONObjectHelper.stripQuotes(strFormErrorId,true));
		obj.put("type", nErrorType);
		obj.put("info", JSONObjectHelper.stripQuotes(strErrorInfo,true));
		return obj;
	}
}
