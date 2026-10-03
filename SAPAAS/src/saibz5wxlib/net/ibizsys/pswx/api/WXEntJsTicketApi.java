package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;

/**
 *
 * 企业号获取js票据接口
 * 
 * @author Enmaai
 */
public class WXEntJsTicketApi extends WXBaseApi {

	private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";

	/**
	 * 获取js票据
	 * 
	 * @param accessToken 企业号票据
	 * @return
	 */
	public static CallResult call(String accessToken) {
		return get(String.format("%1$s?access_token=%2$s", ApiUrl, accessToken), null);
	}
}
