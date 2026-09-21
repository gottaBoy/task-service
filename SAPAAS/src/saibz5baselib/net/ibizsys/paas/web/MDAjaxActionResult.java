/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web;

import java.util.ArrayList;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MDAjaxActionResult
extends SDAjaxActionResult {
    protected ArrayList items = new ArrayList();
    protected ArrayList columns = new ArrayList();
    protected int nTotalRow = 0;
    protected String strSearchCondition = "";
    protected String strSummaryInfo = "";
    private int nStartRow = 0;
    private int nPageSize = -1;
    private boolean bArrayMode = false;
    private JSONObject summaryItem = null;

    public ArrayList getRows() {
        return this.items;
    }

    public ArrayList getColumns() {
        return this.columns;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    @Override
    public String toJSONString() {
        if (this.isArrayMode()) {
            return JSONArray.fromArray((Object[])this.items.toArray()).toString();
        }
        return super.toJSONString();
    }

    @Override
    protected void fillJSONObject(JSONObject objJSON) {
        super.fillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            objJSON.put("totalrow", this.nTotalRow);
            objJSON.put("items", (Object)new JSONArray());
            return;
        }
        objJSON.put("totalrow", this.nTotalRow);
        objJSON.put("startrow", this.nStartRow);
        if (this.nPageSize > 0) {
            objJSON.put("limit", this.nPageSize);
        }
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
        if (this.columns.size() > 0) {
            objJSON.put("columns", (Object)JSONArray.fromArray((Object[])this.columns.toArray()));
        }
        objJSON.put("summaryinfo", (Object)this.strSummaryInfo);
        if (this.getSummaryItem() != null) {
            objJSON.put("summaryitem", (Object)this.getSummaryItem());
        }
    }

    public String getSummaryInfo() {
        return this.strSummaryInfo;
    }

    public void setSummaryInfo(String strSummaryInfo) {
        this.strSummaryInfo = strSummaryInfo;
    }

    public JSONObject getSummaryItem(boolean bCreateIf) {
        if (this.summaryItem == null && bCreateIf) {
            this.summaryItem = new JSONObject();
        }
        return this.summaryItem;
    }

    public JSONObject getSummaryItem() {
        return this.summaryItem;
    }

    public void setSummaryItem(JSONObject summaryItem) {
        this.summaryItem = summaryItem;
    }

    public int getStartRow() {
        return this.nStartRow;
    }

    public void setStartRow(int nStartRow) {
        this.nStartRow = nStartRow;
    }

    public int getPageSize() {
        return this.nPageSize;
    }

    public void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    public void setArrayMode(boolean bArrayMode) {
        this.bArrayMode = bArrayMode;
    }

    public boolean isArrayMode() {
        return this.bArrayMode;
    }

    @Override
    public void fromJSONObject(JSONObject jo) throws Exception {
        int i;
        this.nTotalRow = jo.optInt("totalrow", 0);
        JSONObjectHelper.remove(jo, "totalrow");
        JSONArray ja = jo.optJSONArray("items");
        this.items.clear();
        if (ja != null) {
            i = 0;
            while (i < ja.length()) {
                this.items.add(ja.get(i));
                ++i;
            }
        }
        JSONObjectHelper.remove(jo, "items");
        this.nStartRow = jo.optInt("startrow", -1);
        JSONObjectHelper.remove(jo, "startrow");
        this.nPageSize = jo.optInt("limit", 0);
        JSONObjectHelper.remove(jo, "limit");
        this.strSummaryInfo = jo.optString("summaryinfo", null);
        JSONObjectHelper.remove(jo, "summaryinfo");
        this.summaryItem = jo.optJSONObject("summaryitem");
        JSONObjectHelper.remove(jo, "summaryitem");
        ja = jo.optJSONArray("columns");
        this.columns.clear();
        if (ja != null) {
            i = 0;
            while (i < ja.length()) {
                this.columns.add(ja.get(i));
                ++i;
            }
        }
        JSONObjectHelper.remove(jo, "columns");
        super.fromJSONObject(jo);
    }
}

