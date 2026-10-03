package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.sf.json.JSONObject;

/**
 * 管理企业号应用接口
 * 
 * @author Enmaai
 */
public class WXEntAccountApi extends WXBaseApi {
	/**
	 * Https请求方式: GET
	 */
	private static final String GetApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/get";

	/**
	 * Https请求方式: POST
	 */
	private static final String SetApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/set";
	/**
	 * Https请求方式: GET
	 */
	private static final String ListApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";

	/**
	 * 获取应用信息
	 * 
	 * @param accessToken 企业号票据
	 * @param agentid 应用标识
	 * @return
	 */
	public static CallResult getApp(String accessToken, String agentid) {
		return get(String.format("%1$s?access_token=%2$s&agentid=%3$s", GetApi, accessToken, agentid), null);
	}

	/**
	 * 设置应用信息
	 * 
	 * @param accessToken 企业号票据
	 * @param params
	 * @return
	 */
	public static CallResult setApp(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", SetApi, accessToken), params);
	}

	/**
	 * 获取应用列表
	 * 
	 * @param accessToken 企业号票据
	 * @return
	 */
	public static CallResult listApp(String accessToken) {
		return get(String.format("%1$s?access_token=%2$s", ListApi, accessToken), null);
	}
}
