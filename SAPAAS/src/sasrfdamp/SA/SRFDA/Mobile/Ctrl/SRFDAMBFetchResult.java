/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SRFDAMBFetchResult
extends SRFExAjaxActionResult {
    protected Vector items = new Vector();
    protected int nTotalRow = 0;
    protected String strSummaryInfo = "";

    public Vector getItems() {
        return this.items;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int nTotalRow) {
        this.nTotalRow = nTotalRow;
    }

    protected void FillJSONObject(JSONObject objJSON) {
        super.FillJSONObject(objJSON);
        if (this.getRetCode() != 0) {
            objJSON.put("totalrow", this.nTotalRow);
            objJSON.put("items", (Object)new JSONArray());
            return;
        }
        objJSON.put("totalrow", this.nTotalRow);
        objJSON.put("items", (Object)JSONArray.fromArray((Object[])this.items.toArray()));
        objJSON.put("summaryinfo", (Object)this.strSummaryInfo);
    }

    public String getSummaryInfo() {
        return this.strSummaryInfo;
    }

    public void setSummaryInfo(String strSummaryInfo) {
        this.strSummaryInfo = strSummaryInfo;
    }
}

