/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.methods.GetMethod
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class IMStatusDataCtrl
extends IMDEDataCtrl {
    public CallResult Get(BaseDataEntity dataEntity) {
        CallResult callResult = super.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strMsg = IMStatusDataCtrl.getMessage("http://10.15.2.96:9090/SAIMCatalogServer/im/catalog");
            dataEntity.SetParamValue("STATUSINFO", (Object)strMsg);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected static String getMessage(String serverUrl) throws Exception {
        HttpClient client = null;
        GetMethod getMethod = null;
        JSONObject result = null;
        try {
            client = new HttpClient();
            client.getParams().setParameter("http.protocol.content-charset", (Object)"utf-8");
            getMethod = new GetMethod(serverUrl);
            getMethod.setQueryString("IMACTION=GETSERVERSTATUS");
            int statusCode = client.executeMethod((HttpMethod)getMethod);
            if (statusCode != 200) throw new Exception("\u8fdc\u7a0b\u8c03\u7528\u53d1\u751f\u9519\u8bef," + Integer.toString(statusCode));
            IMMessagePackage iMMessagePackage = new IMMessagePackage();
            String response = getMethod.getResponseBodyAsString();
            result = JSONObject.fromString((String)response);
            if (iMMessagePackage.FromJSONObject(result)) {
                String string = iMMessagePackage.getExtInfo("info", "");
                return string;
            }
            try {
                throw new Exception("\u89e3\u6790\u8fd4\u7ed3\u679c\u9519\u8bef");
            }
            catch (Exception ex) {
                throw new Exception(ex);
            }
        }
        finally {
            if (client != null) {
                client = null;
            }
            if (getMethod != null) {
                getMethod = null;
            }
        }
    }
}

