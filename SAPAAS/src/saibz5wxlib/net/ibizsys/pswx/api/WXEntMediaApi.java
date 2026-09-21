/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.api;

import java.io.File;
import net.ibizsys.pswx.api.WXBaseApi;
import net.sf.json.JSONObject;

public class WXEntMediaApi
extends WXBaseApi {
    private static final String DownloadApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/get";
    private static final String UploadApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/upload";

    public static boolean downloadMedia(String accessToken, String mediaId, File target) throws Exception {
        return WXEntMediaApi.download(String.format("%1$s?access_token=%2$s&media_id=%3$s", DownloadApiUrl, accessToken, mediaId), null, target);
    }

    public static JSONObject uploadImage(String accessToken, String type, File file) throws Exception {
        return WXEntMediaApi.upload(String.format("%1$s?access_token=%2$s&type=%3$s", UploadApiUrl, accessToken, type), file);
    }
}

