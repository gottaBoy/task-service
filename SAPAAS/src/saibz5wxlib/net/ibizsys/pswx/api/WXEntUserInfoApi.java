package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;

/**
 * 
 * @author Enmaai
 */
public class WXEntUserInfoApi extends WXBaseApi {

	private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken 企业号票据
	 * @param code 查询码
	 * @return
	 */
	public static CallResult call(String accessToken, String code) {

		return get(String.format("%1$s?access_token=%2$s&code=%3$s", ApiUrl, accessToken, code), null);
	}
}
