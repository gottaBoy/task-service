/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.NameValuePair
 *  org.apache.commons.httpclient.methods.PostMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMServer;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMServerInstance;
import SA.IM.Ctrl.IIMServerStub;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMObjectBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class IMServerStub
extends IMObjectBase
implements IIMServerStub {
    protected IMServer imServer = null;
    protected boolean bLocalMode = false;
    protected boolean bShuttingdown = false;
    private static final Log log = LogFactory.getLog(IMServerStub.class);

    @Override
    public void Init(ISRFDAGlobalHelper iSRFDAGlobalHelper, String strServerId) throws Exception {
        this.setGlobalHelper(iSRFDAGlobalHelper);
        IMServer imServer = new IMServer();
        CallResult callResult = this.getIMModelHelper().GetIMServer(strServerId, imServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strServerId, (Object)callResult.getErrorInfo()));
        }
        this.imServer = imServer;
        this.OnInit();
    }

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IMServer imServer) throws Exception {
        this.setGlobalHelper(iDAGlobalHelper);
        this.imServer = imServer;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return this.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERSHUTTINGDOWN", (boolean)true) == 0) {
            return this.OnServerShuttingDown(iIMRemoteActionContext);
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8fdc\u7a0b\u8bf7\u6c42[%1$s]", (Object)iIMRemoteActionContext.getAction()));
    }

    protected IMMessagePackage OnServerShuttingDown(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        log.debug((Object)StringHelper.Format((String)"\u670d\u52a1\u5668[%1$s]\u6b63\u5728\u5173\u95ed"));
        this.setShuttingDown(true);
        return new IMMessagePackage();
    }

    @Override
    public IMMessagePackage SendRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return this.OnSendRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnSendRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (this.isLocalMode()) {
            return this.getLocalServerInstance().ProcessRemoteAction(iIMRemoteActionContext);
        }
        String strServerPath = this.imServer.getSERVERPATH();
        String strParamString = iIMRemoteActionContext.getParamString();
        Hashtable<String, String> postDataMap = new Hashtable<String, String>();
        postDataMap.put("content", iIMRemoteActionContext.getContent());
        JSONObject jo = this.PostMessage(strServerPath, strParamString, this.getPostData(postDataMap));
        if (jo != null) {
            IMMessagePackage imMsgPackage = new IMMessagePackage();
            imMsgPackage.FromJSONObject(jo);
            return imMsgPackage;
        }
        IMMessagePackage imMsgPackage = new IMMessagePackage();
        imMsgPackage.setRetCode(5);
        imMsgPackage.setRetInfo("\u672a\u77e5\u9519\u8bef");
        return imMsgPackage;
    }

    private JSONObject PostMessage(String serverUrl, String strParamString, NameValuePair[] postDatas) throws Exception {
        JSONObject result;
        block11: {
            HttpClient client = null;
            PostMethod postMethod = null;
            result = null;
            try {
                try {
                    int statusCode;
                    client = new HttpClient();
                    client.getParams().setParameter("http.protocol.content-charset", (Object)"UTF-8");
                    postMethod = new PostMethod(serverUrl);
                    postMethod.setQueryString(strParamString);
                    if (postDatas.length > 0) {
                        postMethod.setRequestBody(postDatas);
                    }
                    if ((statusCode = client.executeMethod((HttpMethod)postMethod)) == 200) {
                        String response = postMethod.getResponseBodyAsString();
                        result = JSONObject.fromString((String)response);
                        break block11;
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

    @Override
    public String getServerId() {
        return this.imServer.getIMSERVERID();
    }

    @Override
    public String getServerType() {
        return this.imServer.getIMSERVERTYPE();
    }

    @Override
    public boolean isLocalMode() {
        return this.bLocalMode;
    }

    @Override
    public void setLocalMode(boolean bLocalMode) {
        this.bLocalMode = bLocalMode;
    }

    protected abstract IIMServerInstance getLocalServerInstance() throws Exception;

    @Override
    public String getServerPath() {
        return this.imServer.getSERVERPATH();
    }

    @Override
    public String getServerCometPath() {
        return this.imServer.getSERVERCOMETPATH();
    }

    @Override
    public boolean isShuttingDown() {
        return this.bShuttingdown;
    }

    protected void setShuttingDown(boolean bShuttingdown) {
        this.bShuttingdown = bShuttingdown;
    }

    @Override
    public String getServerStatus() {
        return "";
    }
}

