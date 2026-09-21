/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectCond
extends EntityBase
implements ISelectCond {
    public static final String ATTR_CONDS = "conds";
    public static final String ATTR_NULLCONDS = "nullconds";
    public static final String ATTR_ORDER = "order";
    public static final String ATTR_FETCHFIRST = "fetchfirst";
    public static final String ATTR_MAXROW = "maxrow";
    public static final String ATTR_COND_NAME = "name";
    public static final String ATTR_COND_VALUE = "value";
    private String strOrderInfo = null;
    private boolean bFetchFirst = false;
    private int nMaxRowCount = -1;
    private ISelectFilter iSelectFilter = null;
    public static final Object ISNULL = new Object();
    public static final Object ISNOTNULL = new Object();

    public void setConditon(String strCond, Object objValue) throws Exception {
        this.set(strCond, objValue);
    }

    @Override
    public String getOrderInfo() {
        return this.strOrderInfo;
    }

    public void setOrderInfo(String strOrderInfo) {
        this.strOrderInfo = strOrderInfo;
    }

    @Override
    public boolean isFetchFirst() {
        return this.bFetchFirst;
    }

    public void setFetchFirst(boolean bFetchFirst) {
        this.bFetchFirst = bFetchFirst;
        if (this.bFetchFirst) {
            this.nMaxRowCount = 1;
        }
    }

    @Override
    protected void onReset() {
        this.strOrderInfo = null;
        this.bFetchFirst = false;
        this.nMaxRowCount = -1;
        this.iSelectFilter = null;
        super.onReset();
    }

    @Override
    public int getMaxRowCount() {
        return this.nMaxRowCount;
    }

    public void setMaxRowCount(int nMaxRowCount) {
        this.nMaxRowCount = nMaxRowCount;
    }

    @Override
    public ISelectFilter getSelectFilter() {
        return this.iSelectFilter;
    }

    public void setSelectFilter(ISelectFilter iSelectFilter) {
        this.iSelectFilter = iSelectFilter;
    }

    public static JSONObject toJSONObject(ISelectCond iSelectCond, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        ArrayList<JSONObject> valueJOList = new ArrayList<JSONObject>();
        ArrayList<JSONObject> nullJOList = new ArrayList<JSONObject>();
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        iSelectCond.fillMap(paramMap);
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            JSONObject jo;
            if (entry.getValue() == ISNULL) {
                jo = new JSONObject();
                jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(), true));
                jo.put(ATTR_COND_VALUE, 1);
                nullJOList.add(jo);
                continue;
            }
            if (entry.getValue() == ISNOTNULL) {
                jo = new JSONObject();
                jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(), true));
                jo.put(ATTR_COND_VALUE, 0);
                nullJOList.add(jo);
                continue;
            }
            jo = new JSONObject();
            jo.put(ATTR_COND_NAME, JSONObjectHelper.stripQuotes(entry.getKey(), true));
            jo.put(ATTR_COND_VALUE, JSONObjectHelper.stripQuotes(entry.getValue(), true));
            valueJOList.add(jo);
        }
        if (nullJOList.size() > 0) {
            jsonObject.put(ATTR_NULLCONDS, (Object)JSONArray.fromCollection(nullJOList));
        }
        if (valueJOList.size() > 0) {
            jsonObject.put(ATTR_CONDS, (Object)JSONArray.fromCollection(valueJOList));
        }
        if (iSelectCond.getOrderInfo() != null) {
            JSONObjectHelper.put(jsonObject, ATTR_ORDER, iSelectCond.getOrderInfo());
        }
        JSONObjectHelper.put(jsonObject, ATTR_FETCHFIRST, iSelectCond.isFetchFirst());
        if (iSelectCond.getMaxRowCount() > 0) {
            JSONObjectHelper.put(jsonObject, ATTR_MAXROW, iSelectCond.getMaxRowCount());
        }
        return jsonObject;
    }

    public static ISelectCond fromJSONObject(JSONObject jsonObject) throws Exception {
        return SelectCond.fromJSONObject(jsonObject, new SelectCond());
    }

    protected static ISelectCond fromJSONObject(JSONObject jsonObject, SelectCond selectCond) throws Exception {
        int nMaxRow;
        boolean bFirst;
        String strOrderInfo;
        JSONArray nullJA;
        JSONArray valueJA = jsonObject.optJSONArray(ATTR_CONDS);
        if (valueJA != null) {
            int i = 0;
            while (i < valueJA.length()) {
                JSONObject jo = valueJA.getJSONObject(i);
                String strName = jo.getString(ATTR_COND_NAME);
                String objValue = jo.getString(ATTR_COND_VALUE);
                selectCond.setConditon(strName, objValue);
                ++i;
            }
        }
        if ((nullJA = jsonObject.optJSONArray(ATTR_NULLCONDS)) != null) {
            int i = 0;
            while (i < nullJA.length()) {
                JSONObject jo = nullJA.getJSONObject(i);
                String strName = jo.getString(ATTR_COND_NAME);
                int nValue = jo.optInt(ATTR_COND_VALUE, 1);
                if (nValue == 1) {
                    selectCond.setConditon(strName, ISNULL);
                } else {
                    selectCond.setConditon(strName, ISNOTNULL);
                }
                ++i;
            }
        }
        if ((strOrderInfo = jsonObject.optString(ATTR_ORDER)) != null) {
            selectCond.setOrderInfo(strOrderInfo);
        }
        if (bFirst = jsonObject.optBoolean(ATTR_FETCHFIRST, false)) {
            selectCond.setFetchFirst(bFirst);
        }
        if ((nMaxRow = jsonObject.optInt(ATTR_MAXROW, -1)) > 0) {
            selectCond.setMaxRowCount(nMaxRow);
        }
        return selectCond;
    }

    public void setIsNull(String strFieldName) throws Exception {
        this.set(strFieldName, ISNULL);
    }

    public void setIsNotNull(String strFieldName) throws Exception {
        this.set(strFieldName, ISNOTNULL);
    }
}

