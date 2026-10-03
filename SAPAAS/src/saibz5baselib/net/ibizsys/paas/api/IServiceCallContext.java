package net.ibizsys.paas.api;

import net.sf.json.JSONObject;

/**
 * 服务调用上下文对象接口
 * @author Administrator
 *
 */
public interface IServiceCallContext {

	/**
	 * 获取直接的返回内容
	 * @return
	 */
	String getResultRaw();
	
	
	/**
	 * 获取返回的JSON对象
	 * @return
	 */
	JSONObject getResultJO();
	
	
	/**
	 * 设置结果字符串
	 * @param strResultRaw
	 */
	void setResultRaw(String strResultRaw);
	
	
	/**
	 * 设置结果JSONObject
	 * @param resultJO
	 */
	void setResultJO(JSONObject resultJO);
}
