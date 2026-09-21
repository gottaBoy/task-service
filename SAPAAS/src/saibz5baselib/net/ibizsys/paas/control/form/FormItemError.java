/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.form;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class FormItemError {
    public static final int ERROR_OK = 0;
    public static final int ERROR_EMPTY = 1;
    public static final int ERROR_DATATYPE = 2;
    public static final int ERROR_VALUERULE = 3;
    protected String strFormItemId = "";
    protected String strFormErrorId = "";
    protected int nErrorType = 0;
    protected String strErrorInfo = "";

    public String getFormItemId() {
        return this.strFormItemId;
    }

    public void setFormItemId(String strFormItemId) {
        this.strFormItemId = strFormItemId;
    }

    public String getFormErrorId() {
        return this.strFormErrorId;
    }

    public void setFormErrorId(String strFormErrorId) {
        this.strFormErrorId = strFormErrorId;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setErrorInfo(String strErrorInfo) {
        this.strErrorInfo = strErrorInfo;
    }

    public int getErrorType() {
        return this.nErrorType;
    }

    public void setErrorType(int nErrorType) {
        this.nErrorType = nErrorType;
    }

    public JSONObject toJSONObject() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("id", JSONObjectHelper.stripQuotes(this.strFormItemId, true));
        obj.put("errid", JSONObjectHelper.stripQuotes(this.strFormErrorId, true));
        obj.put("type", this.nErrorType);
        obj.put("info", JSONObjectHelper.stripQuotes(this.strErrorInfo, true));
        return obj;
    }
}

