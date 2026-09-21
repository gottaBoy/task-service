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

public class WXEntMenuApi
extends WXBaseApi {
    private static final String CreatApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/create";
    private static final String DeleteApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/delete";
    private static final String GetApi = "https://qyapi.weixin.qq.com/cgi-bin/menu/get";

    public static CallResult createMenu(String accessToken, int agentid, JSONObject params) {
        return WXEntMenuApi.post(String.format("%1$s?access_token=%2$s&agentid=%3$s", CreatApi, accessToken, agentid), params);
    }

    public static CallResult deleteMenu(String accessToken, int agentid) {
        return WXEntMenuApi.get(String.format("%1$s?access_token=%2$s&agentid=%3$s", DeleteApi, accessToken, agentid), null);
    }

    public static CallResult getMenu(String accessToken, int agentid) {
        return WXEntMenuApi.get(String.format("%1$s?access_token=%2$s&agentid=%3$s", GetApi, accessToken, agentid), null);
    }
}

