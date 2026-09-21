/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 */
package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.api.WXBaseApi;

public class WXEntJsTicketApi
extends WXBaseApi {
    private static final String ApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";

    public static CallResult call(String accessToken) {
        return WXEntJsTicketApi.get(String.format("%1$s?access_token=%2$s", ApiUrl, accessToken), null);
    }
}

