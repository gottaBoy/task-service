/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pswx.api;

import java.net.URLEncoder;
import net.ibizsys.paas.util.StringHelper;

public class WXEntAuthApi {
    private static final String BaseApi = "https://open.weixin.qq.com/connect/oauth2/authorize";

    public static String createAuthUrl(String corpId, int agentId, String redirectUrl, String scope, String state) throws Exception {
        redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
        if (StringHelper.isNullOrEmpty((String)scope)) {
            scope = "snsapi_base";
        }
        return String.format("%1$s?appid=%2$s&redirect_uri=%3$s&agentid=%4$s&response_type=code&scope=%5$s&state=%6$s#wechat_redirect", BaseApi, corpId, redirectUrl, agentId, scope, state);
    }
}

