/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.grid;

import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.control.grid.GridEditItemError;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GridRowError {
    private ArrayList<GridEditItemError> gridEditItemErrorList = new ArrayList();
    private String strErrorInfo = "";

    public void register(String strGridEditItemId, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
        GridEditItemError gridEditItemError = new GridEditItemError();
        gridEditItemError.setGridEditItemId(strGridEditItemId);
        gridEditItemError.setErrorType(nErrorType);
        gridEditItemError.setErrorInfo(strErrorInfo);
        this.gridEditItemErrorList.add(gridEditItemError);
    }

    public ArrayList<GridEditItemError> getGridEditItemErrorList() {
        return this.gridEditItemErrorList;
    }

    public boolean hasError() {
        return this.gridEditItemErrorList.size() > 0;
    }

    public JSONObject toJSONObject(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        Vector<JSONObject> arr = new Vector<JSONObject>();
        for (GridEditItemError gridEditItemError : this.gridEditItemErrorList) {
            arr.add(gridEditItemError.toJSONObject());
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
}

