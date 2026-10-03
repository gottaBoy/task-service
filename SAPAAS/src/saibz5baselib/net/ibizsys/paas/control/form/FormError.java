package net.ibizsys.paas.control.form;

import java.util.ArrayList;
import java.util.Vector;

import net.ibizsys.paas.util.StringBuilderEx;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 表单错误对象
 * 
 * @author lionlau
 *
 */
public class FormError {
	private ArrayList<FormItemError> formItemErrorList = new ArrayList<FormItemError>();
	private String strErrorInfo = "";

	/**
	 * 注册错误信息
	 * 
	 * @param strFormItemId 表单项标识
	 * @param strCaption 标题
	 * @param strCapLanId 标题多语言标识<保留参数，暂时无效>
	 * @param nErrorType 错误类型
	 * @param strErrorInfo 错误信息
	 */
	public void register(String strFormItemId, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
		FormItemError formItemError = new FormItemError();
		formItemError.setFormItemId(strFormItemId);
		formItemError.setErrorType(nErrorType);
		formItemError.setErrorInfo(strErrorInfo);
		formItemErrorList.add(formItemError);
	}

	/**
	 * 获取表单项错误清单
	 * 
	 * @return
	 */
	public ArrayList<FormItemError> getFormItemErrorList() {
		return this.formItemErrorList;
	}

	/**
	 * 表单是否有错误
	 * 
	 * @return
	 */
	public boolean hasError() {
		return this.formItemErrorList.size() > 0;
	}

	/**
	 * 导出到JSON对象
	 * 
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public JSONObject toJSONObject(JSONObject jsonObject) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();
		Vector<JSONObject> arr = new Vector<JSONObject>();
		for (FormItemError formItemError : formItemErrorList) {
			arr.add(formItemError.toJSONObject());
		}

		jsonObject.put("items", JSONArray.fromArray(arr.toArray()));
		return jsonObject;
	}

	/**
	 * 获取表单错误信息
	 * 
	 * @return
	 */
	public String getErrorInfo() {
		return strErrorInfo;
	}

	/**
	 * 设置表单错误信息
	 * 
	 * @param strErrorInfo
	 */
	public void setErrorInfo(String strErrorInfo) {
		this.strErrorInfo = strErrorInfo;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilderEx sb = new StringBuilderEx();
		boolean bFirst = true;
		for (FormItemError formItemError : formItemErrorList) {
			if (bFirst) {
				bFirst = false;
			} else {
				sb.append("\r\n");
			}
			sb.append(formItemError.getErrorInfo());
		}
		return sb.toString();
	}

}
