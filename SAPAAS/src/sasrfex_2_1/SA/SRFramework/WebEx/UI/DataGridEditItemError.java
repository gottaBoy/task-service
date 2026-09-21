/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.UI;

import java.util.Vector;
import net.sf.json.JSONObject;

public class DataGridEditItemError {
    public static final int ERROR_OK = 0;
    public static final int ERROR_EMPTY = 1;
    public static final int ERROR_DATATYPE = 2;
    public static final int ERROR_VALUERULE = 3;
    protected String strDGEditItemId = "";
    protected int nErrorType = 0;
    protected String strErrorInfo = "";
    protected String strName = "";

    public String getDGEditItemId() {
        return this.strDGEditItemId;
    }

    public void setDGEditItemId(String strDGEditItemId) {
        this.strDGEditItemId = strDGEditItemId;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
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
        obj.put("id", (Object)this.strDGEditItemId);
        obj.put("name", (Object)this.strName);
        obj.put("type", this.nErrorType);
        obj.put("info", (Object)this.strErrorInfo);
        vector.add(obj);
        return true;
    }
}

