/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Web.WebUtility;
import net.sf.json.JSONObject;

public class SRFExAjaxActionResult
extends CallResult {
    protected static final int RET_UNKNOWNCMD = 200;
    protected String strGotoPath = "";
    protected String strJSCode = "";
    protected String strJSBeforeCode = "";
    protected JSONObject extInfo = null;

    public void setGotoPath(String strGotoPath) {
        this.strGotoPath = strGotoPath;
    }

    public String getGotoPath() {
        return this.strGotoPath;
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }

    public String toJSONString() {
        return this.ToJSONString();
    }

    @Deprecated
    public String ToJSONString() {
        JSONObject objJSON = new JSONObject();
        this.fillJSONObject(objJSON);
        return objJSON.toString();
    }

    protected void fillJSONObject(JSONObject objJSON) {
        this.FillJSONObject(objJSON);
    }

    @Deprecated
    protected void FillJSONObject(JSONObject objJSON) {
        objJSON.put("ret", this.nRetCode);
        objJSON.put("info", (Object)this.strErrorInfo);
        objJSON.put("url", (Object)this.strGotoPath);
        objJSON.put("code", (Object)this.strJSCode);
        objJSON.put("bcode", (Object)this.strJSBeforeCode);
        if (this.extInfo != null) {
            objJSON.put("extinfo", (Object)this.extInfo);
        }
    }

    public void AppendJSCode(String strJSCode) {
        this.strJSCode = String.valueOf(this.strJSCode) + strJSCode;
    }

    public void AppendJSBeforeCode(String strJSBeforeCode) {
        this.strJSBeforeCode = String.valueOf(this.strJSBeforeCode) + strJSBeforeCode;
    }

    public String getJSBeforeCode() {
        return this.strJSBeforeCode;
    }

    public void setJSBeforeCode(String strJSBeforeCode) {
        this.strJSBeforeCode = strJSBeforeCode;
    }

    public void setExtInfo(String strKey, String strInfo) {
        if (this.extInfo == null) {
            this.extInfo = new JSONObject();
        }
        if (this.extInfo.has(strKey)) {
            this.extInfo.remove(strKey);
        }
        this.extInfo.put(strKey, (Object)WebUtility.GetJSONText((String)strInfo));
    }

    public void removeExtInfo(String strKey) {
        this.RemoveExtInfo(strKey);
    }

    @Deprecated
    public void RemoveExtInfo(String strKey) {
        if (this.extInfo == null) {
            return;
        }
        if (this.extInfo.has(strKey)) {
            this.extInfo.remove(strKey);
        }
    }
}

