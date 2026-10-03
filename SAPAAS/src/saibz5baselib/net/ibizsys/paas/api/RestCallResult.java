package net.ibizsys.paas.api;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Rest 调用结果对象
 * @author Administrator
 *
 */
public class RestCallResult {
	
	
	/**
	 * 返回值
	 */
	public static final String ATTR_RET = "ret";
	
	/**
	 * 错误信息
	 */
	public static final String ATTR_ERROR = "error";
	
	/**
	 * 数据项
	 */
	public static final String ATTR_ITEM = "item";
	
	
	/**
	 * 数据项集合
	 */
	public static final String ATTR_ITEMS = "items";
	
	
	/**
	 * 全部行记录
	 */
	public static final String ATTR_TOTAL = "total";
	
	
	/**
	 * 用户自定义数据
	 */
	public static final String ATTR_TAG = "tag";
	
	
	/**
	 * 错误代码
	 */
	private int nRetCode = Errors.OK;
	
	private JSONObject item = null;
	/**
	 * 错误信息
	 */
	protected String strErrorInfo = null;
	
	
	protected ArrayList<JSONObject> items = null;
	
	
	private int nTotalRow = -1; 
	
	private JSONObject tag = null;
	
	/**
	 * 获取单项数据
	 * @param bCreateIfNull
	 * @return
	 */
	public JSONObject getItem(boolean bCreateIfNull){
		if(item == null && bCreateIfNull){
			item = new JSONObject();
		}
		return item;
	}
	
	
	/**
	 * 获取项目集合
	 * @param bCreateIfNull
	 * @return
	 */
	public ArrayList<JSONObject> getItems(boolean bCreateIfNull){
		if(items == null && bCreateIfNull){
			items = new ArrayList<JSONObject>();
		}
		return items;
	}
	
	/**
	 * 获取用户标记数据
	 * @param bCreateIfNull
	 * @return
	 */
	public JSONObject getTag(boolean bCreateIfNull){
		if(tag == null && bCreateIfNull){
			tag = new JSONObject();
		}
		return tag;
	}
	
	
	/**
	 * 获取返回值
	 * 
	 * @return
	 */
	public int getRetCode() {
		return nRetCode;
	}

	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setRetCode(int value) {
		nRetCode = value;
		if (nRetCode == -1) {
			nRetCode = Errors.INTERNALERROR;
		}
	}

	/**
	 * 获取错误信息
	 * @return
	 */
	public String getErrorInfo(boolean bAutoConvert) {
		if (nRetCode == Errors.OK) return null;
		if (StringHelper.length(strErrorInfo) == 0){
			if(bAutoConvert){
				return Errors.getErrorInfo(nRetCode,null);
			}
		}
		return strErrorInfo;
	}
	
	
	
	/**
	 * 设置错误信息
	 * 
	 * @param value
	 */
	public void setErrorInfo(String value) {
		strErrorInfo = value;
	}
	
	
	/**
	 * 判断结果是否为错误
	 * 
	 * @return
	 */
	public boolean isError() {
		return nRetCode != Errors.OK;
	}

	/**
	 * 判断结果是否为正确
	 * 
	 * @return
	 */
	public boolean isOk() {
		return nRetCode == Errors.OK;
	}
	
	/**
	 * 导出JSON对象
	 * 
	 * @return
	 */
	public JSONObject toJSONObject(JSONObject objJSON) {
		if(objJSON == null){
			 objJSON = new JSONObject();
		}
		fillJSONObject(objJSON);
		return objJSON;
	}

	/**
	 * 填充JSON对象
	 * 
	 * @param objJSON
	 */
	protected void fillJSONObject(JSONObject objJSON) {
		objJSON.put(ATTR_RET, this.nRetCode);
		String strErrorInfo = getErrorInfo(false);
		if(!StringHelper.isNullOrEmpty(strErrorInfo)){
			objJSON.put(ATTR_ERROR, JSONObjectHelper.stripQuotes(strErrorInfo,true));
		}
		JSONObject item = this.getItem(false);
		if(item!=null){
			objJSON.put(ATTR_ITEM, item);
		}
		
		ArrayList<JSONObject> items = this.getItems(false);
		if(items!=null){
			objJSON.put(ATTR_ITEMS, JSONArray.fromCollection(items));
		}
		
		JSONObject tag = this.getTag(false);
		if(tag!=null){
			objJSON.put(ATTR_TAG, tag);
		}
		
		if(this.getTotalRow()>=0){
			objJSON.put(ATTR_TOTAL, this.getTotalRow());
		}
	}
	
	/**
	 * 从结果对象进行填充
	 * @param objJSON
	 */
	public void fromJSONObject(JSONObject objJSON){
		this.nRetCode = objJSON.optInt(ATTR_RET,this.nRetCode);
		this.strErrorInfo = objJSON.optString(ATTR_ERROR,this.strErrorInfo);
		this.item = objJSON.optJSONObject(ATTR_ITEM);
		this.tag = objJSON.optJSONObject(ATTR_TAG);
		this.nTotalRow = objJSON.optInt(ATTR_TOTAL,-1);
		JSONArray ja = objJSON.optJSONArray(ATTR_ITEMS);
		if(ja!=null){
			int nLength = ja.length();
			for(int i = 0;i<nLength;i++){
				JSONObject jo = ja.getJSONObject(i);
				this.getItems(true).add(jo);
			}
		}
	}

	
	
	/**
	 * 从异常中填充
	 * @param restCallResult
	 * @param exception
	 */
	public static void fromException(RestCallResult restCallResult,Exception exception){
		
		if(exception instanceof EntityException){
			EntityException entityException = (EntityException)exception;
			if(entityException.getErrorCode()!=Errors.OK){
				restCallResult.setRetCode(entityException.getErrorCode());
			}
			else{
				restCallResult.setRetCode(Errors.INPUTERROR);
			}
			restCallResult.setErrorInfo(entityException.getMessage());
			return;
		}
		
		if(exception instanceof ErrorException){
			ErrorException errorException = (ErrorException)exception;
			restCallResult.setRetCode(errorException.getErrorCode());
			restCallResult.setErrorInfo(errorException.getMessage());
			return;
		}
		
		
		restCallResult.setRetCode(Errors.INTERNALERROR);
		restCallResult.setErrorInfo(exception.getMessage());
	}
	
	/**
	 * 获取全部行数
	 * @return
	 */
	public int getTotalRow(){
		return this.nTotalRow;
	}
	
	
	/**
	 * 设置全部行数
	 * @param nTotalRow
	 */
	public void setTotalRow(int nTotalRow){
		this.nTotalRow = nTotalRow;
	}
}
