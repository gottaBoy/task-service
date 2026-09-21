/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExFormItemError {
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

    public boolean FillJSONs(Vector vector) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)this.strFormItemId);
        obj.put("errid", (Object)this.strFormErrorId);
        obj.put("type", this.nErrorType);
        obj.put("info", (Object)this.strErrorInfo);
        vector.add(obj);
        return true;
    }
}

