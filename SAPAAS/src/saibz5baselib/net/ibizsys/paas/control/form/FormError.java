/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.form;

import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.control.form.FormItemError;
import net.ibizsys.paas.util.StringBuilderEx;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FormError {
    private ArrayList<FormItemError> formItemErrorList = new ArrayList();
    private String strErrorInfo = "";

    public void register(String strFormItemId, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
        FormItemError formItemError = new FormItemError();
        formItemError.setFormItemId(strFormItemId);
        formItemError.setErrorType(nErrorType);
        formItemError.setErrorInfo(strErrorInfo);
        this.formItemErrorList.add(formItemError);
    }

    public ArrayList<FormItemError> getFormItemErrorList() {
        return this.formItemErrorList;
    }

    public boolean hasError() {
        return this.formItemErrorList.size() > 0;
    }

    public JSONObject toJSONObject(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        Vector<JSONObject> arr = new Vector<JSONObject>();
        for (FormItemError formItemError : this.formItemErrorList) {
            arr.add(formItemError.toJSONObject());
        }
        jsonObject.put("items", (Object)JSONArray.fromArray((Object[])arr.toArray()));
        return jsonObject;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setErrorInfo(String strErrorInfo) {
        this.strErrorInfo = strErrorInfo;
    }

    public String toString() {
        StringBuilderEx sb = new StringBuilderEx();
        boolean bFirst = true;
        for (FormItemError formItemError : this.formItemErrorList) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.append("\r\n");
            }
            sb.append(formItemError.getErrorInfo());
        }
        return sb.toString();
    }
}

