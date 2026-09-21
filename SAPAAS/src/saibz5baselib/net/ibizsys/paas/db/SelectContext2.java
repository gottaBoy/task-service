/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.ISelectContext2;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

public class SelectContext2
extends SelectContext
implements ISelectContext2 {
    public static final String ATTR_PAGING = "paging";
    public static final String ATTR_START = "start";
    public static final String ATTR_SIZE = "size";
    private int nStartRow = 0;
    private int nPageSize = -1;
    private boolean bPaging = false;
    private int nDefaultPageSize = 25;

    public static JSONObject toJSONObject(ISelectContext2 iSelectContext2, JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        if (iSelectContext2.isPaging()) {
            JSONObjectHelper.put(jsonObject, ATTR_PAGING, iSelectContext2.isPaging());
            if (iSelectContext2.getStartRow() >= 0) {
                JSONObjectHelper.put(jsonObject, ATTR_START, iSelectContext2.getStartRow());
            }
            if (iSelectContext2.getPageSize() > 0) {
                JSONObjectHelper.put(jsonObject, ATTR_SIZE, iSelectContext2.getPageSize());
            }
        }
        return SelectContext.toJSONObject(iSelectContext2, jsonObject);
    }

    public static ISelectContext2 fromJSONObject(JSONObject jsonObject) throws Exception {
        SelectContext2 selectContext2 = new SelectContext2();
        SelectContext2.fromJSONObject(jsonObject, selectContext2);
        return selectContext2;
    }

    public static ISelectContext2 fromJSONObject(JSONObject jsonObject, SelectContext2 selectContext2) throws Exception {
        selectContext2.setPaging(jsonObject.optBoolean(ATTR_PAGING, false));
        if (selectContext2.isPaging()) {
            int nPageSize;
            int nStartRow = jsonObject.optInt(ATTR_START, -1);
            if (nStartRow >= 0) {
                selectContext2.setStartRow(nStartRow);
            }
            if ((nPageSize = jsonObject.optInt(ATTR_SIZE, -1)) > 0) {
                selectContext2.setPageSize(nPageSize);
            }
        }
        SelectContext.fromJSONObject(jsonObject, selectContext2);
        return selectContext2;
    }

    @Override
    public int getStartRow() {
        return this.nStartRow;
    }

    @Override
    public int getPageSize() {
        if (this.nPageSize <= 0) {
            return this.getDefaultPageSize();
        }
        return this.nPageSize;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public void setDefaultPageSize(int nDefaultPageSize) {
        this.nDefaultPageSize = nDefaultPageSize;
    }

    public int getDefaultPageSize() {
        return this.nDefaultPageSize;
    }

    @Override
    public boolean isPaging() {
        return this.bPaging && !this.isFetchFirst();
    }

    public void setPaging(boolean bPaging) {
        this.bPaging = bPaging;
    }
}

