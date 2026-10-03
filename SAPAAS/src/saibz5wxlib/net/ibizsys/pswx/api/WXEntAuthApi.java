package net.ibizsys.pswx.api;

import java.net.URLEncoder;

import net.ibizsys.paas.util.StringHelper;

public class WXEntAuthApi {

	private static final String BaseApi = "https://open.weixin.qq.com/connect/oauth2/authorize";

	/**
	 * 创建OAuth认证地址
	 * 
	 * @param corpId 企业号标识
	 * @param agentId 应用标识
	 * @param redirectUrl 回调地址
	 * @param scope 作用域
	 * @param state 自定义参数值
	 * @return
	 * @throws Exception
	 */
	public static String createAuthUrl(String corpId, int agentId, String redirectUrl, String scope, String state) throws Exception {

		redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");

		if (StringHelper.isNullOrEmpty(scope)) {
			scope = "snsapi_base";
		}
		return String.format("%1$s?appid=%2$s&redirect_uri=%3$s&agentid=%4$s&response_type=code&scope=%5$s&state=%6$s#wechat_redirect", BaseApi, corpId, redirectUrl, agentId, scope, state);
	}
}
