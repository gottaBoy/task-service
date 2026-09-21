/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 */
package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.api.WXBaseApi;

public class WXEntUserInfoApi
extends WXBaseApi {
    private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";

    public static CallResult call(String accessToken, String code) {
        return WXEntUserInfoApi.get(String.format("%1$s?access_token=%2$s&code=%3$s", ApiUrl, accessToken, code), null);
    }
}

