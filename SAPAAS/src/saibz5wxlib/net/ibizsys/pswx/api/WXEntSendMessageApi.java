package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.sf.json.JSONObject;

/**
 * 企业号发送消息接口
 * <p>
 * 消息接口格式
 * ：http://qydev.weixin.qq.com/wiki/index.php?title=%E6%B6%88%E6%81%AF%E7%B1%BB%E5%9E%8B%E5%8F%8A%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F
 * 
 * @author Enmaai
 */
public class WXEntSendMessageApi extends WXBaseApi {

	/**
	 * 发送消息
	 * <p>
	 * Https请求方式: POST
	 */
	private static final String SendApi = "https://qyapi.weixin.qq.com/cgi-bin/message/send";

	/**
	 * 发送消息
	 * 
	 * @param accessToken 企业号票据
	 * @param params 消息
	 * @return
	 */
	public static CallResult send(String accessToken, JSONObject params) {
		return post(String.format("%1$s?access_token=%2$s", SendApi, accessToken), params);
	}
}
