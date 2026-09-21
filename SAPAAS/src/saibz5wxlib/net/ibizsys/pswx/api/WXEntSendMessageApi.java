/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.api;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.pswx.api.WXBaseApi;
import net.sf.json.JSONObject;

public class WXEntSendMessageApi
extends WXBaseApi {
    private static final String SendApi = "https://qyapi.weixin.qq.com/cgi-bin/message/send";

    public static CallResult send(String accessToken, JSONObject params) {
        return WXEntSendMessageApi.post(String.format("%1$s?access_token=%2$s", SendApi, accessToken), params);
    }
}

