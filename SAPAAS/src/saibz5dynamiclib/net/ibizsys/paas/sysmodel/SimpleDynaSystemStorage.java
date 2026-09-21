/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaView
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.entity.UrlEncodedFormEntity
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.message.BasicNameValuePair
 *  org.apache.http.util.EntityUtils
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.sysmodel.DynaSystemStorageBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SimpleDynaSystemStorage
extends DynaSystemStorageBase {
    private String strDynaStudioApiUrl = null;
    private String strDynaUser = null;
    private String strDynaPassword = null;
    private String strDynaInstId = null;
    public static final String ATTR_DYNASYSAPI = "DYNASYSAPI";
    public static final String ATTR_DYNASYSUSER = "DYNASYSUSER";
    public static final String ATTR_DYNASYSPASSWORD = "DYNASYSPASSWORD";
    public static final String ATTR_DYNASYSINSTID = "DYNASYSINSTID";
    private String strLoginKey = null;
    private long nLastLoginTime = 0L;

    protected void onInit() throws Exception {
        super.onInit();
    }

    protected String getLoginKey() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.strDynaStudioApiUrl)) {
            this.strDynaStudioApiUrl = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSAPI, this.strDynaStudioApiUrl);
            this.strDynaUser = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSUSER, this.strDynaUser);
            this.strDynaPassword = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSPASSWORD, this.strDynaPassword);
            this.strDynaInstId = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSINSTID, this.strDynaInstId);
        }
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfaction", "LOGIN");
        postDataMap.put("loginname", this.strDynaUser);
        postDataMap.put("pwd", this.strDynaPassword);
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u6ca1\u6709\u8fd4\u56de\u767b\u5f55\u6210\u529f");
        }
        this.strLoginKey = joRet.getJSONObject("data").optString("loginkey", "");
        this.nLastLoginTime = System.currentTimeMillis();
        return this.strLoginKey;
    }

    @Override
    protected ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("srfaction", "LISTDYNAVIEWINST");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        ArrayList<DSDynaViewInst> dsDynaViewInstList = new ArrayList<DSDynaViewInst>();
        JSONArray ja = (JSONArray)joRet.get("items");
        int i = 0;
        while (i < ja.length()) {
            JSONObject devSlnJO = ja.getJSONObject(i);
            DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
            DataObject.fromJSONObject((IDataObject)dsDynaViewInst, (JSONObject)devSlnJO);
            dsDynaViewInst.setDSDynaViewId(DataObject.getStringValue((Object)dsDynaViewInst.get("dynaviewid")));
            dsDynaViewInst.setDSDynaViewInstId(DataObject.getStringValue((Object)dsDynaViewInst.get("dynaviewinstid")));
            dsDynaViewInst.setDSDynaViewInstName(DataObject.getStringValue((Object)dsDynaViewInst.get("dynaviewinstname")));
            dsDynaViewInstList.add(dsDynaViewInst);
            ++i;
        }
        return dsDynaViewInstList;
    }

    @Override
    protected DSDynaView getDynaView(String strDynaViewId) throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("dynaappviewid", strDynaViewId);
        postDataMap.put("srfaction", "GETDYNAVIEW");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        DSDynaView dsDynaView = new DSDynaView();
        JSONObject data = joRet.optJSONObject("data");
        DataObject.fromJSONObject((IDataObject)dsDynaView, (JSONObject)data);
        dsDynaView.setDSDynaViewId(data.optString("dynaviewid"));
        dsDynaView.setDSDynaViewName(data.optString("dynaviewname"));
        dsDynaView.setViewType(data.optString("viewtype"));
        return dsDynaView;
    }

    @Override
    protected DSDynaViewInst getDynaViewInst(String strDynaViewInstId) throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("dynaappviewinstid", strDynaViewInstId);
        postDataMap.put("srfaction", "GETDYNAVIEWINST");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        JSONObject data = joRet.optJSONObject("data");
        DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
        DataObject.fromJSONObject((IDataObject)dsDynaViewInst, (JSONObject)data);
        dsDynaViewInst.setDSDynaViewInstId(data.optString("dynaviewinstid"));
        dsDynaViewInst.setDSDynaViewInstName(data.optString("dynaviewinstname"));
        dsDynaViewInst.setDSDynaViewId(data.optString("dynaviewid"));
        dsDynaViewInst.setViewType(data.optString("viewtype"));
        dsDynaViewInst.setDynaModel(data.optString("dynamodel"));
        return dsDynaViewInst;
    }

    @Override
    protected ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("srfaction", "LISTDYNAWFVER");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>();
        JSONArray ja = (JSONArray)joRet.get("items");
        int i = 0;
        while (i < ja.length()) {
            JSONObject devSlnJO = ja.getJSONObject(i);
            DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
            DataObject.fromJSONObject((IDataObject)dsDynaWFVer, (JSONObject)devSlnJO);
            dsDynaWFVer.setDSDynaWFId(DataObject.getStringValue((Object)dsDynaWFVer.get("dynawfid")));
            dsDynaWFVer.setDSDynaWFVerId(DataObject.getStringValue((Object)dsDynaWFVer.get("dynawfverid")));
            dsDynaWFVer.setDSDynaWFVerName(DataObject.getStringValue((Object)dsDynaWFVer.get("dynawfvername")));
            dsDynaWFVerList.add(dsDynaWFVer);
            ++i;
        }
        return dsDynaWFVerList;
    }

    @Override
    protected DSDynaWF getDynaWF(String strDynaWFId) throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("dynawfid", strDynaWFId);
        postDataMap.put("srfaction", "GETDYNAWF");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        DSDynaWF dsDynaWF = new DSDynaWF();
        JSONObject data = joRet.optJSONObject("data");
        DataObject.fromJSONObject((IDataObject)dsDynaWF, (JSONObject)data);
        dsDynaWF.setDSDynaWFId(data.optString("dynawfid"));
        dsDynaWF.setDSDynaWFName(data.optString("dynawfname"));
        dsDynaWF.setWFWorkflowId(data.optString("wfid"));
        dsDynaWF.setWFWorkflowName(data.optString("wfname"));
        return dsDynaWF;
    }

    @Override
    protected DSDynaWFVer getDynaWFVer(String strDynaWFVerId) throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("dynawfverid", strDynaWFVerId);
        postDataMap.put("srfaction", "GETDYNAWFVER");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        JSONObject data = joRet.optJSONObject("data");
        DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
        DataObject.fromJSONObject((IDataObject)dsDynaWFVer, (JSONObject)data);
        dsDynaWFVer.setDSDynaWFVerId(data.optString("dynawfverid"));
        dsDynaWFVer.setDSDynaWFVerName(data.optString("dynawfvername"));
        dsDynaWFVer.setDSDynaWFId(data.optString("dynawfid"));
        dsDynaWFVer.setDSDynaWFName(data.optString("dynawfname"));
        dsDynaWFVer.setDynaModel(data.optString("dynamodel"));
        return dsDynaWFVer;
    }

    @Override
    protected ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("srfaction", "LISTDYNACODELIST");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>();
        JSONArray ja = (JSONArray)joRet.get("items");
        int i = 0;
        while (i < ja.length()) {
            JSONObject devSlnJO = ja.getJSONObject(i);
            DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
            DataObject.fromJSONObject((IDataObject)dsDynaCodeList, (JSONObject)devSlnJO);
            dsDynaCodeList.setCodeListId(DataObject.getStringValue((Object)dsDynaCodeList.get("codelistid")));
            dsDynaCodeList.setDSDynaCodeListId(DataObject.getStringValue((Object)dsDynaCodeList.get("dynacodelistid")));
            dsDynaCodeList.setDSDynaCodeListName(DataObject.getStringValue((Object)dsDynaCodeList.get("dynacodelistname")));
            dsDynaCodeListList.add(dsDynaCodeList);
            ++i;
        }
        return dsDynaCodeListList;
    }

    @Override
    protected DSDynaCodeList getDynaCodeList(String strDynaCodeListId) throws Exception {
        String strLoginKey = this.getLoginKey();
        HashMap<String, String> postDataMap = new HashMap<String, String>();
        postDataMap.put("srfloginkey", strLoginKey);
        postDataMap.put("dynainstid", this.strDynaInstId);
        postDataMap.put("dynacodelistid", strDynaCodeListId);
        postDataMap.put("srfaction", "GETDYNACODELIST");
        JSONObject joRet = SimpleDynaSystemStorage.httpPost(this.strDynaStudioApiUrl, postDataMap);
        if (joRet == null) {
            throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
        }
        if (joRet.optInt("ret", 1) != 0) {
            throw new Exception("\u83b7\u53d6\u5931\u8d25");
        }
        JSONObject data = joRet.optJSONObject("data");
        DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
        DataObject.fromJSONObject((IDataObject)dsDynaCodeList, (JSONObject)data);
        dsDynaCodeList.setDSDynaCodeListId(data.optString("dynacodelistid"));
        dsDynaCodeList.setDSDynaCodeListName(data.optString("dynacodelistname"));
        dsDynaCodeList.setCodeListId(data.optString("codelistid"));
        dsDynaCodeList.setDynaModel(data.optString("dynamodel"));
        return dsDynaCodeList;
    }

    public static String httpPost2(String url, Map<String, String> params) throws Exception {
        System.out.print(StringHelper.format((String)"\u8bf7\u6c42[%1$s?%2$s]\r\n", (Object)url, (Object)""));
        if (params != null) {
            for (String strKey : params.keySet()) {
                System.out.print(StringHelper.format((String)"%1$s:%2$s\r\n", (Object)strKey, (Object)params.get(strKey)));
            }
        }
        HttpPost httpPost = new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        ArrayList<BasicNameValuePair> valuePairs = new ArrayList<BasicNameValuePair>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            BasicNameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
            valuePairs.add(nameValuePair);
        }
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, "UTF-8");
        httpPost.setEntity((HttpEntity)formEntity);
        HttpResponse resp = client.execute((HttpUriRequest)httpPost);
        HttpEntity entity = resp.getEntity();
        String respContent = EntityUtils.toString((HttpEntity)entity, (String)"UTF-8").trim();
        httpPost.abort();
        client.getConnectionManager().shutdown();
        System.out.print(StringHelper.format((String)"\u53cd\u9988\r\n%1$s", (Object)respContent));
        return respContent;
    }

    public static JSONObject httpPost(String url, Map<String, String> params) throws Exception {
        String strContent = SimpleDynaSystemStorage.httpPost2(url, params);
        return JSONObject.fromString((String)strContent);
    }
}

