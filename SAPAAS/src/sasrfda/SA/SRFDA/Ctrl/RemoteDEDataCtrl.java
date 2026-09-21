/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.NameValuePair
 *  org.apache.commons.httpclient.methods.PostMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RemoteDEDataCtrl {
    private String strRemoteCallUrl = "";
    private String strDEId = "";
    private String strCurPersonId = "";
    private static final Log log = LogFactory.getLog(RemoteDEDataCtrl.class);

    public void Init(String strRemoteCallUrl, String strDEId, String strCurPersonId) {
        this.strRemoteCallUrl = strRemoteCallUrl;
        this.strDEId = strDEId;
        this.strCurPersonId = strCurPersonId;
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!dataEntity.ContainesParam("SRF_PERSONID")) {
                dataEntity.SetParamValue("SRF_PERSONID", (Object)this.strCurPersonId);
            }
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=GETDEFAULT", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            dataEntity.Reset();
            if (ajaxListResult.getItems().size() > 0) {
                BaseDataEntity.FromString((BaseDataEntity)dataEntity, (String)((String)ajaxListResult.getItems().get(0)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Get(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!dataEntity.ContainesParam("SRF_PERSONID")) {
                dataEntity.SetParamValue("SRF_PERSONID", (Object)this.strCurPersonId);
            }
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=GET", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            dataEntity.Reset();
            if (ajaxListResult.getItems().size() > 0) {
                BaseDataEntity.FromString((BaseDataEntity)dataEntity, (String)((String)ajaxListResult.getItems().get(0)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Select(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SELECT1", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            dataEntity.Reset();
            if (ajaxListResult.getItems().size() > 0) {
                BaseDataEntity.FromString((BaseDataEntity)dataEntity, (String)((String)ajaxListResult.getItems().get(0)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Select(BaseDataEntity dataEntity, Vector<BaseDataEntity> list) {
        CallResult callResult = new CallResult();
        try {
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SELECT", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            for (Object item : ajaxListResult.getItems()) {
                list.add(BaseDataEntity.FromString((String)((String)item)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Select(String strActionMode, BaseDataEntity dataEntity, Vector<BaseDataEntity> list) {
        CallResult callResult = new CallResult();
        try {
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SELECTEX", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", strActionMode);
            postDataMap.put("srfarg2", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            for (Object item : ajaxListResult.getItems()) {
                list.add(BaseDataEntity.FromString((String)((String)item)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Select(BaseDataEntity dataEntity, Vector list, String strObject) {
        CallResult callResult = new CallResult();
        try {
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SELECT", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            for (Object item : ajaxListResult.getItems()) {
                BaseDataEntity baseDataEntity = (BaseDataEntity)ObjectHelper.Create((String)strObject);
                BaseDataEntity.FromString((BaseDataEntity)baseDataEntity, (String)((String)item));
                list.add(baseDataEntity);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Select(BaseDataEntity dataEntity, Vector list, String strObject, String strOrderInfo) {
        return null;
    }

    public CallResult Select(String strActionMode, BaseDataEntity dataEntity, Vector list, String strObject) {
        CallResult callResult = new CallResult();
        try {
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SELECTEX", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", strActionMode);
            postDataMap.put("srfarg2", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            for (Object item : ajaxListResult.getItems()) {
                BaseDataEntity baseDataEntity = (BaseDataEntity)ObjectHelper.Create((String)strObject);
                BaseDataEntity.FromString((BaseDataEntity)baseDataEntity, (String)((String)item));
                list.add(baseDataEntity);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Save(boolean bInsert, BaseDataEntity dataEntity) {
        return this.Save(bInsert, "DEFAULT", dataEntity);
    }

    public CallResult Save(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!dataEntity.ContainesParam("SRF_PERSONID")) {
                dataEntity.SetParamValue("SRF_PERSONID", (Object)this.strCurPersonId);
            }
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=SAVE", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", bInsert ? "true" : "false");
            postDataMap.put("srfarg2", strActionMode);
            postDataMap.put("srfarg3", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            dataEntity.Reset();
            if (ajaxListResult.getItems().size() > 0) {
                BaseDataEntity.FromString((BaseDataEntity)dataEntity, (String)((String)ajaxListResult.getItems().get(0)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult Remove(BaseDataEntity dataEntity) {
        return this.Remove("DEFAULT", dataEntity);
    }

    public CallResult Remove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!dataEntity.ContainesParam("SRF_PERSONID")) {
                dataEntity.SetParamValue("SRF_PERSONID", (Object)this.strCurPersonId);
            }
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=REMOVE", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", strActionMode);
            postDataMap.put("srfarg2", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult CustomCall(String strCallName, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (!dataEntity.ContainesParam("SRF_PERSONID")) {
                dataEntity.SetParamValue("SRF_PERSONID", (Object)this.strCurPersonId);
            }
            String strParamString = StringHelper.Format((String)"SRFDEID=%1$s&SRFCALL=CUSTOMCALL", (Object)this.strDEId);
            Hashtable<String, String> postDataMap = new Hashtable<String, String>();
            postDataMap.put("srfarg", strCallName);
            postDataMap.put("srfarg2", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)true));
            JSONObject joRet = this.PostMessage(this.strRemoteCallUrl, strParamString, this.getPostData(postDataMap));
            if (joRet == null) {
                throw new Exception("\u8fd4\u56de\u7a7a\u5185\u5bb9");
            }
            SRFExAjaxListResult ajaxListResult = this.ParseResult(joRet);
            callResult.From((CallResult)ajaxListResult);
            dataEntity.Reset();
            if (ajaxListResult.getItems().size() > 0) {
                BaseDataEntity.FromString((BaseDataEntity)dataEntity, (String)((String)ajaxListResult.getItems().get(0)));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    private JSONObject PostMessage(String serverUrl, String strParamString, NameValuePair[] postDatas) throws Exception {
        JSONObject result;
        block12: {
            HttpClient client = null;
            PostMethod postMethod = null;
            result = null;
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
                    postMethod.setRequestBody(postDatas);
                    int statusCode = client.executeMethod((HttpMethod)postMethod);
                    if (statusCode == 200) {
                        String response = postMethod.getResponseBodyAsString();
                        result = JSONObject.fromString((String)response);
                        break block12;
                    }
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef," + Integer.toString(statusCode)));
                }
                catch (Exception e) {
                    log.error((Object)("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u5f02\u5e38," + e.getMessage()));
                    if (client != null) {
                        client = null;
                    }
                    if (postMethod != null) {
                        postMethod = null;
                    }
                }
            }
            finally {
                if (client != null) {
                    client = null;
                }
                if (postMethod != null) {
                    postMethod = null;
                }
            }
        }
        return result;
    }

    protected SRFExAjaxListResult ParseResult(JSONObject joRet) {
        SRFExAjaxListResult ajaxListResult = new SRFExAjaxListResult();
        if (joRet.has("ret")) {
            ajaxListResult.setRetCode(joRet.getInt("ret"));
        } else if (joRet.has("retcode")) {
            ajaxListResult.setRetCode(joRet.getInt("retcode"));
        }
        if (joRet.has("retinfo")) {
            ajaxListResult.setErrorInfo(joRet.getString("retinfo"));
        }
        if (joRet.has("items")) {
            JSONArray arr = joRet.getJSONArray("items");
            int i = 0;
            while (i < arr.length()) {
                ajaxListResult.getItems().add(arr.get(i));
                ++i;
            }
        }
        return ajaxListResult;
    }

    protected NameValuePair[] getPostData(Hashtable<String, String> postDataMap) {
        ArrayList<NameValuePair> postDataList = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> item : postDataMap.entrySet()) {
            String strValue;
            String strName = item.getKey();
            if (StringHelper.Length((String)strName) == 0 || StringHelper.Length((String)(strValue = item.getValue())) == 0) continue;
            NameValuePair pair = new NameValuePair();
            pair.setName(strName);
            pair.setValue(strValue);
            postDataList.add(pair);
        }
        NameValuePair[] list = new NameValuePair[postDataList.size()];
        return postDataList.toArray(list);
    }
}

