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

public class WXEntAccountApi
extends WXBaseApi {
    private static final String GetApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/get";
    private static final String SetApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/set";
    private static final String ListApi = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";

    public static CallResult getApp(String accessToken, String agentid) {
        return WXEntAccountApi.get(String.format("%1$s?access_token=%2$s&agentid=%3$s", GetApi, accessToken, agentid), null);
    }

    public static CallResult setApp(String accessToken, JSONObject params) {
        return WXEntAccountApi.post(String.format("%1$s?access_token=%2$s", SetApi, accessToken), params);
    }

    public static CallResult listApp(String accessToken) {
        return WXEntAccountApi.get(String.format("%1$s?access_token=%2$s", ListApi, accessToken), null);
    }
}

