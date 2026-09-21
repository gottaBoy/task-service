/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.RestCallException
 *  net.ibizsys.paas.api.RestCallResult
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.client.ResponseHandler
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.StringEntity
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.util.EntityUtils
 */
package net.ibizsys.pscore.srv.util;

import java.io.IOException;
import java.util.Date;
import net.ibizsys.paas.api.RestCallException;
import net.ibizsys.paas.api.RestCallResult;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PSStudioConsoleHelper {
    private static final Log log = LogFactory.getLog(PSStudioConsoleHelper.class);
    private String strServiceUrl = null;
    private String strClientId = null;
    public static final String MSGTYPE_COMMAND = "COMMAND";
    public static final String MSGTYPE_CONSOLE = "CONSOLE";
    public static final String MSG_COMMAND_OBJECTCREATED = "OBJECTCREATED";
    public static final String MSG_COMMAND_OBJECTUPDATED = "OBJECTUPDATED";
    public static final String MSG_COMMAND_OBJECTREMOVED = "OBJECTREMOVED";
    private static PSStudioConsoleHelper current = null;

    public static PSStudioConsoleHelper getCurrent() {
        return current;
    }

    public static void setCurrent(PSStudioConsoleHelper pSStudioConsoleHelper) {
        current = pSStudioConsoleHelper;
    }

    public PSStudioConsoleHelper(String string, String string2) {
        this.strServiceUrl = string2;
        this.strClientId = string;
    }

    public void sendConsole(String string, String string2) {
        this.sendConsole(string, string2, null, true);
    }

    public void sendConsole(String string, String string2, String string3) {
        this.sendConsole(string, string2, string3, true);
    }

    public void sendConsole(String string, String string2, String string3, boolean bl) {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (bl) {
            stringBuilderEx.append("%1$tm-%1$td %1$tH:%1$tM:%1$tS ", (Object)new Date());
        }
        stringBuilderEx.append(string2);
        this.publishToTopic(string, MSGTYPE_CONSOLE, string3, stringBuilderEx.toString());
    }

    public void sendConsole(String string, String string2, String string3, String string4, boolean bl) {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (bl) {
            stringBuilderEx.append("%1$tm-%1$td %1$tH:%1$tM:%1$tS ", (Object)new Date());
        }
        stringBuilderEx.append(string2);
        this.publishToTopic(string, MSGTYPE_CONSOLE, string3, stringBuilderEx.toString(), string4);
    }

    public void sendCommand(String string, String string2) {
        this.publishToTopic(string, MSGTYPE_COMMAND, null, string2);
    }

    public void sendCommand(String string, String string2, String string3) {
        this.publishToTopic(string, MSGTYPE_COMMAND, string2, string3);
    }

    public void publishToTopic(String string, String string2, String string3, String string4) {
        this.publishToTopic(string, string2, string3, string4, null);
    }

    public void publishToTopic(String string, String string2, String string3, String string4, String string5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object)string2);
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                jSONObject.put("subtype", (Object)string3);
            }
            jSONObject.put("content", (Object)string4);
            if (!StringHelper.isNullOrEmpty((String)string5)) {
                jSONObject.put("data", (Object)string5);
            }
            this.publishToTopic(string, "\"" + jSONObject.toString() + "\"");
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }

    public RestCallResult publishToTopic(String string, String string2) throws Exception {
        String string3 = this.strServiceUrl;
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(string3);
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientid", (Object)this.strClientId);
        jSONObject.put("topic", (Object)string);
        jSONObject.put("content", (Object)string2);
        StringEntity stringEntity = new StringEntity(new String(jSONObject.toString().getBytes("UTF-8")), "UTF-8");
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity((HttpEntity)stringEntity);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>(){

            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int n = httpResponse.getStatusLine().getStatusCode();
                if (n != 200) {
                    throw new ClientProtocolException((Throwable)new RestCallException(n));
                }
                HttpEntity httpEntity = httpResponse.getEntity();
                if (null != httpEntity) {
                    String string = EntityUtils.toString((HttpEntity)httpResponse.getEntity(), (String)"UTF-8");
                    return string;
                }
                return null;
            }
        };
        RestCallResult restCallResult = new RestCallResult();
        String string4 = null;
        try {
            string4 = (String)closeableHttpClient.execute((HttpUriRequest)httpPost, (ResponseHandler)responseHandler);
        }
        catch (ClientProtocolException clientProtocolException) {
            log.error((Object)clientProtocolException);
            throw clientProtocolException;
        }
        catch (IOException iOException) {
            log.error((Object)iOException);
            throw iOException;
        }
        return restCallResult;
    }

    public static String getContent(String string, int n) {
        return PSStudioConsoleHelper.getContent(string, n, -1);
    }

    public static String getContent(String string, int n, int n2) {
        return PSStudioConsoleHelper.getContent(string, n, n2, -1);
    }

    public static String getContent(String string, int n, int n2, int n3) {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("\u001b[");
        if (n3 >= 0) {
            stringBuilderEx.append("%1$s", (Object)n3);
        }
        if (n > 0) {
            if (n3 >= 0) {
                stringBuilderEx.append(";");
            }
            stringBuilderEx.append("%1$s", (Object)n);
        }
        if (n2 > 0) {
            if (n3 >= 0 || n > 0) {
                stringBuilderEx.append(";");
            }
            stringBuilderEx.append("%1$s", (Object)n2);
        }
        stringBuilderEx.append("m", (Object)n2);
        stringBuilderEx.append(string);
        stringBuilderEx.append("\u001b[0m");
        return stringBuilderEx.toString();
    }

    public void sendErrorInfo(String string, String string2) {
        this.sendErrorInfo(string, string2, null);
    }

    public void sendErrorInfo(String string, String string2, String string3) {
        this.sendConsole(string, PSStudioConsoleHelper.getContent(string2, 31, -1, 0), string3);
    }

    public void sendWarnInfo(String string, String string2) {
        this.sendWarnInfo(string, string2, null);
    }

    public void sendWarnInfo(String string, String string2, String string3) {
        this.sendConsole(string, PSStudioConsoleHelper.getContent(string2, 33, -1, 0), string3);
    }
}

