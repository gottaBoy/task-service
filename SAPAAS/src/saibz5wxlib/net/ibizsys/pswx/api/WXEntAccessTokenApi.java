/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 */
package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.api.WXBaseApi;

public class WXEntAccessTokenApi
extends WXBaseApi {
    private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    public static CallResult call(String corpid, String corpsecret) {
        return WXEntAccessTokenApi.get(String.format("%1$s?corpid=%2$s&corpsecret=%3$s", ApiUrl, corpid, corpsecret), null);
    }
}

