package net.ibizsys.paas.control.grid;

import java.util.ArrayList;
import java.util.Vector;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 表格行错误对象
 * 
 * @author lionlau
 *
 */
public class GridRowError {
	private ArrayList<GridEditItemError> gridEditItemErrorList = new ArrayList<GridEditItemError>();
	private String strErrorInfo = "";

	/**
	 * 注册错误信息
	 * 
	 * @param strGridEditItemId 表格行项标识
	 * @param strCaption 标题
	 * @param strCapLanId 标题多语言标识<保留参数，暂时无效>
	 * @param nErrorType 错误类型
	 * @param strErrorInfo 错误信息
	 */
	public void register(String strGridEditItemId, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
		GridEditItemError gridEditItemError = new GridEditItemError();
		gridEditItemError.setGridEditItemId(strGridEditItemId);
		gridEditItemError.setErrorType(nErrorType);
		gridEditItemError.setErrorInfo(strErrorInfo);
		gridEditItemErrorList.add(gridEditItemError);
	}

	/**
	 * 获取表格行项错误清单
	 * 
	 * @return
	 */
	public ArrayList<GridEditItemError> getGridEditItemErrorList() {
		return this.gridEditItemErrorList;
	}

	/**
	 * 表格行是否有错误
	 * 
	 * @return
	 */
	public boolean hasError() {
		return this.gridEditItemErrorList.size() > 0;
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
		for (GridEditItemError gridEditItemError : gridEditItemErrorList) {
			arr.add(gridEditItemError.toJSONObject());
		}

		jsonObject.put("items", JSONArray.fromArray(arr.toArray()));
		return jsonObject;
	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getErrorInfo() {
		return strErrorInfo;
	}

	/**
	 * 设置错误信息
	 * 
	 * @param strErrorInfo
	 */
	public void setErrorInfo(String strErrorInfo) {
		this.strErrorInfo = strErrorInfo;
	}

}
