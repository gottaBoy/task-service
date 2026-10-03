package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.sf.json.JSONObject;

/**
 * 企业号自定义菜单接口
 * 
 * @author Enmaai
 */
public class WXEntMenuApi extends WXBaseApi {
	/**
	 * Https请求方式: POST
	 */
	private static final String CreatApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/create";

	/**
	 * Https请求方式：GET
	 */
	private static final String DeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/delete";
	/**
	 * Https请求方式: GET
	 */
	private static final String GetApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/get";

	/**
	 * 创建应用菜单
	 * 
	 * @param accessToken 企业号票据
	 * @param agentid 应用标识
	 * @param params 菜单内容
	 * @return
	 */
	public static CallResult createMenu(String accessToken, int agentid, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s&agentid=%3$s", CreatApi, accessToken, agentid), params);
	}

	/**
	 * 删除应用菜单
	 * 
	 * @param accessToken 企业号票据
	 * @param accessToken 应用标识
	 * @return
	 */
	public static CallResult deleteMenu(String accessToken, int agentid){
		return get(String.format("%1$s?access_token=%2$s&agentid=%3$s", DeleteApi, accessToken, agentid), null);
	}

	/**
	 * 获取应用菜单
	 * 
	 * @param accessToken 企业号票据
	 * @param accessToken 应用标识
	 * @return
	 */
	public static CallResult getMenu(String accessToken, int agentid) {
		return get(String.format("%1$s?access_token=%2$s&agentid=%3$s", GetApi, accessToken, agentid), null);
	}
}
