/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AjaxActionResult
extends CallResult {
    public static final int NOTLOGIN_COMMON = 0;
    public static final int NOTLOGIN_PASSWORDEXPIRED = 1;
    public static final String ATTR_CLOSEPOPUPVIEW = "closepopupview";
    protected String strGotoPath = "";
    protected String strJSCode = "";
    protected String strJSBeforeCode = "";
    protected String strContent = "";
    protected String strDownloadPath = "";
    protected JSONObject extInfo = null;
    protected String strAjaxAction = "";
    protected ICtrlRender iCtrlRender = null;
    protected JSONObject attributes = null;
    private boolean bCache = false;
    private boolean bNotLogin = false;
    private int nNotLoginReason = 0;
    private String strConfirmKey = null;
    private String strConfirmMsg = null;
    private String strConfirmTitle = null;
    private ArrayList confirmOptions = null;
    private JSONObject confirmActionParam = null;

    public void setGotoPath(String strGotoPath) {
        this.strGotoPath = strGotoPath;
    }

    public String getGotoPath() {
        return this.strGotoPath;
    }

    public void setDownloadPath(String strDownloadPath) {
        this.strDownloadPath = strDownloadPath;
    }

    public String getDownloadPath() {
        return this.strDownloadPath;
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }

    public String toJSONString() {
        JSONObject objJSON = this.toJSONObject();
        return objJSON.toString();
    }

    public JSONObject toJSONObject() {
        JSONObject objJSON = new JSONObject();
        this.fillJSONObject(objJSON);
        if (this.getCtrlRender() != null) {
            this.getCtrlRender().filteAjaxActionResult(this, objJSON);
        }
        return objJSON;
    }

    protected void fillJSONObject(JSONObject objJSON) {
        objJSON.put("ret", this.nRetCode);
        objJSON.put("info", JSONObjectHelper.stripQuotes(this.strErrorInfo, true));
        objJSON.put("url", JSONObjectHelper.stripQuotes(this.strGotoPath, true));
        if (!StringHelper.isNullOrEmpty(this.strDownloadPath)) {
            objJSON.put("downloadurl", JSONObjectHelper.stripQuotes(this.strDownloadPath, true));
        }
        objJSON.put("code", JSONObjectHelper.stripQuotes(this.strJSCode, true));
        objJSON.put("bcode", JSONObjectHelper.stripQuotes(this.strJSBeforeCode, true));
        objJSON.put("content", JSONObjectHelper.stripQuotes(this.strContent, true));
        if (this.getRetCode() != 0) {
            objJSON.put("success", false);
            objJSON.put("errorMessage", JSONObjectHelper.stripQuotes(this.getErrorInfo(), true));
        } else {
            objJSON.put("success", true);
        }
        if (this.strConfirmKey != null) {
            objJSON.put("confirmkey", JSONObjectHelper.stripQuotes(this.strConfirmKey, true));
            if (this.strConfirmMsg != null) {
                objJSON.put("confirmmsg", JSONObjectHelper.stripQuotes(this.strConfirmMsg, true));
            }
            if (this.strConfirmTitle != null) {
                objJSON.put("confirmtitle", JSONObjectHelper.stripQuotes(this.strConfirmTitle, true));
            }
            if (this.confirmOptions != null) {
                objJSON.put("confirmoptions", (Object)JSONArray.fromArray((Object[])this.confirmOptions.toArray()));
            }
            if (this.confirmActionParam != null) {
                objJSON.put("confirmactionparam", (Object)this.confirmActionParam);
            }
        }
        if (this.isNotLogin()) {
            objJSON.put("notlogin", true);
            objJSON.put("notloginreason", this.getNotLoginReason());
        }
        if (this.extInfo != null) {
            Iterator keys = this.extInfo.keys();
            while (keys.hasNext()) {
                String strKey = (String)keys.next();
                if (objJSON.has(strKey)) continue;
                objJSON.put(strKey, JSONObjectHelper.stripQuotes(this.extInfo.get(strKey)));
            }
        }
    }

    public void appendJSCode(String strJSCode) {
        this.strJSCode = String.valueOf(this.strJSCode) + strJSCode;
    }

    public void appendJSBeforeCode(String strJSBeforeCode) {
        this.strJSBeforeCode = String.valueOf(this.strJSBeforeCode) + strJSBeforeCode;
    }

    public String getJSBeforeCode() {
        return this.strJSBeforeCode;
    }

    public void setJSBeforeCode(String strJSBeforeCode) {
        this.strJSBeforeCode = strJSBeforeCode;
    }

    public void setExtAttr(String strKey, Object objValue) {
        if (this.extInfo == null) {
            this.extInfo = new JSONObject();
        }
        if (this.extInfo.has(strKey)) {
            this.extInfo.remove(strKey);
        }
        this.extInfo.put(strKey, JSONObjectHelper.stripQuotes(objValue));
    }

    public void removeExtAttr(String strKey) {
        if (this.extInfo == null) {
            return;
        }
        if (this.extInfo.has(strKey)) {
            this.extInfo.remove(strKey);
        }
    }

    public String getAjaxAction() {
        return this.strAjaxAction;
    }

    public void setAjaxAction(String strAjaxAction) {
        this.strAjaxAction = strAjaxAction;
    }

    public ICtrlRender getCtrlRender() {
        return this.iCtrlRender;
    }

    public void setCtrlRender(ICtrlRender iCtrlRender) {
        this.iCtrlRender = iCtrlRender;
    }

    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public void fromJSONObject(JSONObject jo) throws Exception {
        this.nRetCode = jo.optInt("ret", 0);
        this.strErrorInfo = jo.optString("info", null);
        this.strGotoPath = jo.optString("url", null);
        this.strDownloadPath = jo.optString("downloadurl", null);
        this.strJSCode = jo.optString("code", null);
        this.strJSBeforeCode = jo.optString("bcode", null);
        this.strContent = jo.optString("content", null);
        this.strConfirmKey = jo.optString("confirmkey", null);
        this.strConfirmMsg = jo.optString("confirmmsg", null);
        this.strConfirmTitle = jo.optString("confirmtitle", null);
        this.confirmActionParam = jo.optJSONObject("confirmactionparam");
        JSONArray ja = jo.optJSONArray("confirmoptions");
        if (ja != null) {
            if (this.confirmOptions == null) {
                this.confirmOptions = new ArrayList();
            } else {
                this.confirmOptions.clear();
            }
            int i = 0;
            while (i < ja.length()) {
                this.confirmOptions.add(ja.get(i));
                ++i;
            }
        } else {
            this.confirmOptions = null;
        }
        JSONObjectHelper.remove(jo, "ret");
        JSONObjectHelper.remove(jo, "info");
        JSONObjectHelper.remove(jo, "url");
        JSONObjectHelper.remove(jo, "downloadurl");
        JSONObjectHelper.remove(jo, "code");
        JSONObjectHelper.remove(jo, "bcode");
        JSONObjectHelper.remove(jo, "content");
        JSONObjectHelper.remove(jo, "confirmkey");
        JSONObjectHelper.remove(jo, "confirmmsg");
        JSONObjectHelper.remove(jo, "confirmtitle");
        JSONObjectHelper.remove(jo, "confirmactionparam");
        JSONObjectHelper.remove(jo, "confirmoptions");
        if (this.getRetCode() != 0 && StringHelper.isNullOrEmpty(this.strErrorInfo)) {
            this.strErrorInfo = jo.optString("errorMessage", null);
        }
        JSONObjectHelper.remove(jo, "errorMessage");
        this.extInfo = null;
        Iterator keys = jo.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                if (this.extInfo == null) {
                    this.extInfo = new JSONObject();
                }
                Object objkey = keys.next();
                Object objValue = jo.get((String)objkey);
                this.extInfo.put((String)objkey, JSONObjectHelper.stripQuotes(objValue, true));
            }
        }
    }

    public boolean isCache() {
        return this.bCache;
    }

    public void setCache(boolean bCache) {
        this.bCache = bCache;
    }

    public String getConfirmKey() {
        return this.strConfirmKey;
    }

    public void setConfirmKey(String strConfirmKey) {
        this.strConfirmKey = strConfirmKey;
    }

    public String getConfirmMsg() {
        return this.strConfirmMsg;
    }

    public void setConfirmMsg(String strConfirmMsg) {
        this.strConfirmMsg = strConfirmMsg;
    }

    public ArrayList getConfirmOptions(boolean bCreateIfNull) {
        if (this.confirmOptions == null && bCreateIfNull) {
            this.confirmOptions = new ArrayList();
        }
        return this.confirmOptions;
    }

    public void setConfirmOptions(ArrayList confirmOptions) {
        this.confirmOptions = confirmOptions;
    }

    public JSONObject getConfirmActionParam() {
        return this.confirmActionParam;
    }

    public void setConfirmActionParam(JSONObject confirmActionParam) {
        this.confirmActionParam = confirmActionParam;
    }

    public String getConfirmTitle() {
        return this.strConfirmTitle;
    }

    public void setConfirmTitle(String strConfirmTitle) {
        this.strConfirmTitle = strConfirmTitle;
    }

    public boolean isNotLogin() {
        return this.bNotLogin;
    }

    public void setNotLogin(boolean bNotLogin) {
        this.bNotLogin = bNotLogin;
    }

    public int getNotLoginReason() {
        return this.nNotLoginReason;
    }

    public void setNotLoginReason(int nNotLoginReason) {
        this.nNotLoginReason = nNotLoginReason;
    }
}

