/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.entity.UrlEncodedFormEntity
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.message.BasicNameValuePair
 *  org.apache.http.util.EntityUtils
 */
package net.ibizsys.paas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class RemoteService {
    private String strRemoteCallUrl = "";
    private String strDEId = "";
    private String strCurPersonId = "";
    private String strCurPersonName = "";
    private String strCurLoginName = "";
    private String strRealIp = "";
    private static final Log log = LogFactory.getLog(RemoteService.class);

    public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId) {
        this.strRemoteCallUrl = strRemoteCallUrl;
        this.strDEId = strDEId;
        this.strCurPersonId = strCurPersonId;
    }

    public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId, String strRealIp) {
        this.strRemoteCallUrl = strRemoteCallUrl;
        this.strDEId = strDEId;
        this.strCurPersonId = strCurPersonId;
        this.strRealIp = strRealIp;
    }

    public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId, String strRealIp, String strCurPersonName) {
        this.strRemoteCallUrl = strRemoteCallUrl;
        this.strDEId = strDEId;
        this.strCurPersonId = strCurPersonId;
        this.strRealIp = strRealIp;
        this.strCurPersonName = strCurPersonName;
    }

    public RemoteCallResult executeAction(String strAction, IEntity et) throws Exception {
        return this.executeAction(strAction, et, "UTF-8");
    }

    public RemoteCallResult executeAction(String strAction, IEntity et, String strEncode) throws Exception {
        JSONObject joRet;
        if (!et.contains("SRF_PERSONID")) {
            et.set("SRF_PERSONID", this.strCurPersonId);
        }
        if (!et.contains("SRF_LOGINNAME")) {
            et.set("SRF_LOGINNAME", this.strCurLoginName);
        }
        if (!et.contains("SRF_PERSONNAME")) {
            et.set("SRF_PERSONNAME", this.strCurPersonName);
        }
        String strParamString = StringHelper.format("SRFDEID=%1$s&SRFCALL=CUSTOMCALL", this.strDEId);
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfarg", strAction);
        postDataMap.put("srfarg2", DataObject.toJSONString(et, true));
        HashMap<String, String> headerMap = null;
        if (!StringHelper.isNullOrEmpty(this.strRealIp)) {
            headerMap = new HashMap<String, String>();
            headerMap.put("X-Real-IP", this.strRealIp);
        }
        if ((joRet = RemoteService.postMessage(this.strRemoteCallUrl, strParamString, postDataMap, headerMap, strEncode)) == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        RemoteCallResult remoteCallResult = new RemoteCallResult();
        remoteCallResult.from(joRet);
        return remoteCallResult;
    }

    public static String postMessage2(String url, String strParamString, Map<String, String> params, String strEncode) throws Exception {
        return RemoteService.postMessage2(url, strParamString, params, null, strEncode);
    }

    public static String postMessage2(String url, String strParamString, Map<String, String> params, Map<String, String> headers, String strEncode) throws Exception {
        if (!StringHelper.isNullOrEmpty(strParamString)) {
            url = url.indexOf("?") == -1 ? String.valueOf(url) + "?" : String.valueOf(url) + "&";
            url = String.valueOf(url) + strParamString;
        }
        HttpPost httpPost = new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        ArrayList<BasicNameValuePair> valuePairs = new ArrayList<BasicNameValuePair>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            BasicNameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
            valuePairs.add(nameValuePair);
        }
        if (headers != null) {
            for (String strKey : headers.keySet()) {
                httpPost.setHeader(strKey, headers.get(strKey));
            }
        }
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, strEncode);
        httpPost.setEntity((HttpEntity)formEntity);
        HttpResponse resp = client.execute((HttpUriRequest)httpPost);
        HttpEntity entity = resp.getEntity();
        String respContent = EntityUtils.toString((HttpEntity)entity, (String)strEncode).trim();
        httpPost.abort();
        client.getConnectionManager().shutdown();
        return respContent;
    }

    public static JSONObject postMessage(String url, String strParamString, Map<String, String> params, String strEncode) throws Exception {
        String strContent = RemoteService.postMessage2(url, strParamString, params, strEncode);
        if (StringHelper.isNullOrEmpty(strContent)) {
            return null;
        }
        return JSONObjectHelper.fromString(strContent);
    }

    public static JSONObject postMessage(String url, String strParamString, Map<String, String> params, Map<String, String> headers, String strEncode) throws Exception {
        String strContent = RemoteService.postMessage2(url, strParamString, params, headers, strEncode);
        if (StringHelper.isNullOrEmpty(strContent)) {
            return null;
        }
        return JSONObjectHelper.fromString(strContent);
    }
}

