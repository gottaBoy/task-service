package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;

/**
 * 企业号票据接口
 * <p>
 * Https请求方式：GET
 * <p>
 * https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
 * 
 * @author Enmaai
 */
public class WXEntAccessTokenApi extends WXBaseApi {
	private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

	/**
	 * 获取票据
	 * 
	 * @param corpid 企业号标识
	 * @param corpsecret 企业号密钥
	 * @return
	 * @throws Exception
	 */
	public static CallResult call(String corpid, String corpsecret) {
		return get(String.format("%1$s?corpid=%2$s&corpsecret=%3$s", ApiUrl, corpid, corpsecret), null);
	}
}
