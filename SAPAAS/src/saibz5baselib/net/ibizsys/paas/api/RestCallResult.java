/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.api;

import java.util.ArrayList;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RestCallResult {
    public static final String ATTR_RET = "ret";
    public static final String ATTR_ERROR = "error";
    public static final String ATTR_ITEM = "item";
    public static final String ATTR_ITEMS = "items";
    public static final String ATTR_TOTAL = "total";
    public static final String ATTR_TAG = "tag";
    private int nRetCode = 0;
    private JSONObject item = null;
    protected String strErrorInfo = null;
    protected ArrayList<JSONObject> items = null;
    private int nTotalRow = -1;
    private JSONObject tag = null;

    public JSONObject getItem(boolean bCreateIfNull) {
        if (this.item == null && bCreateIfNull) {
            this.item = new JSONObject();
        }
        return this.item;
    }

    public ArrayList<JSONObject> getItems(boolean bCreateIfNull) {
        if (this.items == null && bCreateIfNull) {
            this.items = new ArrayList();
        }
        return this.items;
    }

    public JSONObject getTag(boolean bCreateIfNull) {
        if (this.tag == null && bCreateIfNull) {
            this.tag = new JSONObject();
        }
        return this.tag;
    }

    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetCode(int value) {
        this.nRetCode = value;
        if (this.nRetCode == -1) {
            this.nRetCode = 1;
        }
    }

    public String getErrorInfo(boolean bAutoConvert) {
        if (this.nRetCode == 0) {
            return null;
        }
        if (StringHelper.length(this.strErrorInfo) == 0 && bAutoConvert) {
            return Errors.getErrorInfo(this.nRetCode, null);
        }
        return this.strErrorInfo;
    }

    public void setErrorInfo(String value) {
        this.strErrorInfo = value;
    }

    public boolean isError() {
        return this.nRetCode != 0;
    }

    public boolean isOk() {
        return this.nRetCode == 0;
    }

    public JSONObject toJSONObject(JSONObject objJSON) {
        if (objJSON == null) {
            objJSON = new JSONObject();
        }
        this.fillJSONObject(objJSON);
        return objJSON;
    }

    protected void fillJSONObject(JSONObject objJSON) {
        JSONObject tag;
        ArrayList<JSONObject> items;
        JSONObject item;
        objJSON.put(ATTR_RET, this.nRetCode);
        String strErrorInfo = this.getErrorInfo(false);
        if (!StringHelper.isNullOrEmpty(strErrorInfo)) {
            objJSON.put(ATTR_ERROR, JSONObjectHelper.stripQuotes(strErrorInfo, true));
        }
        if ((item = this.getItem(false)) != null) {
            objJSON.put(ATTR_ITEM, (Object)item);
        }
        if ((items = this.getItems(false)) != null) {
            objJSON.put(ATTR_ITEMS, (Object)JSONArray.fromCollection(items));
        }
        if ((tag = this.getTag(false)) != null) {
            objJSON.put(ATTR_TAG, (Object)tag);
        }
        if (this.getTotalRow() >= 0) {
            objJSON.put(ATTR_TOTAL, this.getTotalRow());
        }
    }

    public void fromJSONObject(JSONObject objJSON) {
        this.nRetCode = objJSON.optInt(ATTR_RET, this.nRetCode);
        this.strErrorInfo = objJSON.optString(ATTR_ERROR, this.strErrorInfo);
        this.item = objJSON.optJSONObject(ATTR_ITEM);
        this.tag = objJSON.optJSONObject(ATTR_TAG);
        this.nTotalRow = objJSON.optInt(ATTR_TOTAL, -1);
        JSONArray ja = objJSON.optJSONArray(ATTR_ITEMS);
        if (ja != null) {
            int nLength = ja.length();
            int i = 0;
            while (i < nLength) {
                JSONObject jo = ja.getJSONObject(i);
                this.getItems(true).add(jo);
                ++i;
            }
        }
    }

    public static void fromException(RestCallResult restCallResult, Exception exception) {
        if (exception instanceof EntityException) {
            EntityException entityException = (EntityException)exception;
            if (entityException.getErrorCode() != 0) {
                restCallResult.setRetCode(entityException.getErrorCode());
            } else {
                restCallResult.setRetCode(5);
            }
            restCallResult.setErrorInfo(entityException.getMessage());
            return;
        }
        if (exception instanceof ErrorException) {
            ErrorException errorException = (ErrorException)exception;
            restCallResult.setRetCode(errorException.getErrorCode());
            restCallResult.setErrorInfo(errorException.getMessage());
            return;
        }
        restCallResult.setRetCode(1);
        restCallResult.setErrorInfo(exception.getMessage());
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }
}

