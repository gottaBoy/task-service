/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFExGridFetchResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();
    protected Vector columns = new Vector();
    protected int nTotalRow = 0;
    protected String strSearchCondition = "";
    protected String strSummaryInfo = "";

    public Vector getItems() {
        return this.items;
    }

    public Vector getColumns() {
        return this.columns;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    public void setSearchCondition(String strSearchCondition) {
        this.strSearchCondition = strSearchCondition;
    }

    public String getSearchCondition() {
        return this.strSearchCondition;
    }

    @Override
    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            objJSON.put("totalrow", this.nTotalRow);
            objJSON.put("items", (Object)new JSONArray());
            return;
        }
        objJSON.put("totalrow", this.nTotalRow);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
        if (this.columns.size() > 0) {
            objJSON.put("columns", (Object)JSONArray.fromArray((Object[])this.columns.toArray()));
        }
        objJSON.put("summaryinfo", (Object)this.strSummaryInfo);
    }

    public String getSummaryInfo() {
        return this.strSummaryInfo;
    }

    public void setSummaryInfo(String strSummaryInfo) {
        this.strSummaryInfo = strSummaryInfo;
    }
}

