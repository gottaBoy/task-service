/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.IS.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import net.sf.json.JSONObject;

public class SearchResultViewModel
extends MainViewModel {
    private JSONObject jsonResult = new JSONObject();

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        JSONObject js = (JSONObject)jo.get("ctrls");
        js.put("searchresult", (Object)this.jsonResult);
    }

    public JSONObject getJsonResult() {
        return this.jsonResult;
    }

    public void setJsonResult(JSONObject jsonResult) {
        this.jsonResult = jsonResult;
    }
}

