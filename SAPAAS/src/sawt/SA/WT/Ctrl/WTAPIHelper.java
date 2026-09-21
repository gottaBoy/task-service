/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.methods.GetMethod
 *  org.apache.commons.httpclient.methods.PostMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTAPIHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.WTCallResult;
import SA.WT.Data.WTUser;
import SA.WT.Data.WTUserGroup;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTAPIHelper
implements IWTAPIHelper {
    private static final Log log = LogFactory.getLog(WTAPIHelper.class);
    private ISRFDAGlobalHelper iDAGlobalHelper;
    private IWTAccountHelper iWTAccountHelper;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWTAccountHelper iWTAccountHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iWTAccountHelper = iWTAccountHelper;
    }

    @Override
    public WTCallResult getAccessToken() {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            String strResponse = this.SendMessage("https://api.weixin.qq.com/cgi-bin/token", StringHelper.Format((String)"grant_type=client_credential&appid=%1$s&secret=%2$s", (Object)this.iWTAccountHelper.getAPIAppId(), (Object)this.iWTAccountHelper.getAPIAppSecret()));
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult PublishMenu(JSONObject joMenu) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            String strResponse = this.PostMessage(" https://api.weixin.qq.com/cgi-bin/menu/create", StringHelper.Format((String)"access_token=%1$s", (Object)this.iWTAccountHelper.getAPIAccessToken()), joMenu.toString());
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult ListUserGroup(Vector<WTUserGroup> wtUserGroupList) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            String strResponse = this.SendMessage(" https://api.weixin.qq.com/cgi-bin/groups/get", StringHelper.Format((String)"access_token=%1$s", (Object)this.iWTAccountHelper.getAPIAccessToken()));
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            if (!wtCallResult.IsError()) {
                JSONArray arr = wtCallResult.getRawObject().getJSONArray("groups");
                int i = 0;
                while (i < arr.length()) {
                    WTUserGroup wtUserGroup = new WTUserGroup();
                    JSONObject item = arr.getJSONObject(i);
                    wtUserGroup.setWTACCOUNTID(this.iWTAccountHelper.getId());
                    wtUserGroup.setWTUSERGROUPNAME(item.get("name").toString());
                    wtUserGroup.setWTUSEROBJECTNO(item.get("id").toString());
                    wtUserGroup.setUSERCOUNT(item.getInt("count"));
                    wtUserGroupList.add(wtUserGroup);
                    ++i;
                }
            }
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult CreateUserGroup(WTUserGroup wtUserGroup) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            JSONObject userGroup = new JSONObject();
            userGroup.put("name", (Object)wtUserGroup.getWTUSERGROUPNAME());
            JSONObject sendItem = new JSONObject();
            sendItem.put("group", (Object)userGroup);
            String strResponse = this.PostMessage(" https://api.weixin.qq.com/cgi-bin/groups/create", StringHelper.Format((String)"access_token=%1$s", (Object)this.iWTAccountHelper.getAPIAccessToken()), sendItem.toString());
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            if (!wtCallResult.IsError()) {
                userGroup = wtCallResult.getRawObject().getJSONObject("group");
                wtUserGroup.setWTUSEROBJECTNO(userGroup.get("id").toString());
                wtUserGroup.setWTUSERGROUPNAME(userGroup.get("name").toString());
            }
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult UpdateUserGroup(WTUserGroup wtUserGroup) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            JSONObject userGroup = new JSONObject();
            userGroup.put("id", Integer.parseInt(wtUserGroup.getWTUSEROBJECTNO()));
            userGroup.put("name", (Object)wtUserGroup.getWTUSERGROUPNAME());
            JSONObject sendItem = new JSONObject();
            sendItem.put("group", (Object)userGroup);
            String strResponse = this.PostMessage(" https://api.weixin.qq.com/cgi-bin/groups/update", StringHelper.Format((String)"access_token=%1$s", (Object)this.iWTAccountHelper.getAPIAccessToken()), userGroup.toString());
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            if (!wtCallResult.IsError()) {
                userGroup = wtCallResult.getRawObject().getJSONObject("group");
                wtUserGroup.setWTUSEROBJECTNO(userGroup.get("id").toString());
                wtUserGroup.setWTUSERGROUPNAME(userGroup.get("name").toString());
            }
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult ListUser(ArrayList<String> openIdList) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            String strNextOpendId = "";
            while (true) {
                String strResponse = this.SendMessage(" https://api.weixin.qq.com/cgi-bin/user/get", StringHelper.Format((String)"access_token=%1$s&next_openid=%2$s", (Object)this.iWTAccountHelper.getAPIAccessToken(), (Object)strNextOpendId));
                JSONObject jo = JSONObject.fromString((String)strResponse);
                wtCallResult.FromJSONObject(jo);
                if (wtCallResult.IsError()) continue;
                int nCount = wtCallResult.getRawObject().getInt("count");
                if (nCount == 0) break;
                JSONObject dataObject = wtCallResult.getRawObject().getJSONObject("data");
                JSONArray arr = dataObject.getJSONArray("openid");
                int i = 0;
                while (i < arr.length()) {
                    String strOpenId = arr.getString(i);
                    openIdList.add(strOpenId);
                    ++i;
                }
                strNextOpendId = wtCallResult.getRawObject().getString("next_openid");
                if (StringHelper.IsNullOrEmpty((String)strNextOpendId)) break;
            }
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    @Override
    public WTCallResult GetUser(WTUser wtUser) {
        WTCallResult wtCallResult = new WTCallResult();
        try {
            String strResponse = this.SendMessage(" https://api.weixin.qq.com/cgi-bin/user/info", StringHelper.Format((String)"access_token=%1$s&openid=%2$s&lang=zh_CN", (Object)this.iWTAccountHelper.getAPIAccessToken(), (Object)wtUser.getWTUSERID()));
            JSONObject jo = JSONObject.fromString((String)strResponse);
            wtCallResult.FromJSONObject(jo);
            if (!wtCallResult.IsError()) {
                wtUser.setSUBSCRIBEFLAG(wtCallResult.getRawObject().getInt("subscribe") == 1);
                if (wtUser.getSUBSCRIBEFLAG()) {
                    wtUser.setWTUSERID(wtCallResult.getRawObject().getString("openid"));
                    wtUser.setWTUSERNAME(wtCallResult.getRawObject().getString("nickname"));
                    wtUser.setSEX(wtCallResult.getRawObject().getInt("sex"));
                    wtUser.setLANGUAGE(wtCallResult.getRawObject().getString("language"));
                    wtUser.setCITY(wtCallResult.getRawObject().getString("city"));
                    wtUser.setPROVINCE(wtCallResult.getRawObject().getString("province"));
                    wtUser.setCOUNTRY(wtCallResult.getRawObject().getString("country"));
                    wtUser.setHEADIMGURL(wtCallResult.getRawObject().getString("headimgurl"));
                    long nTime = wtCallResult.getRawObject().getLong("subscribe_time");
                    wtUser.setSUBSCRIBETIME(new Timestamp(nTime * 1000L));
                }
            }
            return wtCallResult;
        }
        catch (Exception ex) {
            wtCallResult.setRetCode(1);
            wtCallResult.setErrorInfo(ex.getMessage());
            return wtCallResult;
        }
    }

    protected String PostMessage(String serverUrl, String strParamString, String strPostData) throws Exception {
        String strErrorInfo;
        String response;
        block16: {
            HttpClient client = null;
            PostMethod postMethod = null;
            response = null;
            strErrorInfo = "";
            try {
                try {
                    client = new HttpClient();
                    client.getParams().setParameter("http.protocol.content-charset", (Object)"utf-8");
                    String[] parts = serverUrl.split("[?]");
                    if (parts.length == 1) {
                        postMethod = new PostMethod(serverUrl);
                        postMethod.setQueryString(strParamString);
                    } else {
                        postMethod = new PostMethod(parts[0]);
                        postMethod.setQueryString(String.valueOf(strParamString) + "&" + parts[1]);
                    }
                    ByteArrayInputStream in = new ByteArrayInputStream(strPostData.getBytes("UTF8"));
                    postMethod.setRequestBody((InputStream)in);
                    int statusCode = client.executeMethod((HttpMethod)postMethod);
                    if (statusCode == 200) {
                        response = postMethod.getResponseBodyAsString();
                    } else {
                        log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef," + Integer.toString(statusCode)));
                        strErrorInfo = StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)statusCode);
                    }
                }
                catch (Exception e) {
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u5f02\u5e38," + e.getMessage()), (Throwable)e);
                    strErrorInfo = e.getMessage();
                    if (client != null) {
                        client = null;
                    }
                    if (postMethod != null) {
                        postMethod = null;
                    }
                    break block16;
                }
            }
            catch (Throwable throwable) {
                if (client != null) {
                    client = null;
                }
                if (postMethod != null) {
                    postMethod = null;
                }
                throw throwable;
            }
            if (client != null) {
                client = null;
            }
            if (postMethod != null) {
                postMethod = null;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            throw new Exception(strErrorInfo);
        }
        return response;
    }

    protected String SendMessage(String serverUrl, String strParamString) throws Exception {
        String strErrorInfo;
        String response;
        block16: {
            HttpClient client = null;
            GetMethod getMethod = null;
            response = null;
            strErrorInfo = "";
            try {
                try {
                    client = new HttpClient();
                    client.getParams().setParameter("http.protocol.content-charset", (Object)"utf-8");
                    String[] parts = serverUrl.split("[?]");
                    if (parts.length == 1) {
                        getMethod = new GetMethod(serverUrl);
                        getMethod.setQueryString(strParamString);
                    } else {
                        getMethod = new GetMethod(parts[0]);
                        getMethod.setQueryString(String.valueOf(strParamString) + "&" + parts[1]);
                    }
                    int statusCode = client.executeMethod((HttpMethod)getMethod);
                    if (statusCode == 200) {
                        response = getMethod.getResponseBodyAsString();
                    } else {
                        log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef," + Integer.toString(statusCode)));
                        strErrorInfo = StringHelper.Format((String)"\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)statusCode);
                    }
                }
                catch (Exception e) {
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u5f02\u5e38," + e.getMessage()), (Throwable)e);
                    strErrorInfo = e.getMessage();
                    if (client != null) {
                        client = null;
                    }
                    if (getMethod != null) {
                        getMethod = null;
                    }
                    break block16;
                }
            }
            catch (Throwable throwable) {
                if (client != null) {
                    client = null;
                }
                if (getMethod != null) {
                    getMethod = null;
                }
                throw throwable;
            }
            if (client != null) {
                client = null;
            }
            if (getMethod != null) {
                getMethod = null;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            throw new Exception(strErrorInfo);
        }
        return response;
    }
}

