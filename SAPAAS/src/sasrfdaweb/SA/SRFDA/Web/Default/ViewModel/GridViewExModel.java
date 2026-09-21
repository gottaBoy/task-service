/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.BaseGridViewExModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFDA.Web.ViewModel.SearchFormModel;
import net.sf.json.JSONObject;

public class GridViewExModel
extends BaseGridViewExModel {
    protected SPExModel spExModel = new SPExModel();
    protected SearchFormModel searchFormModel = new SearchFormModel();
    protected String strGridViewExId = "";
    protected boolean bSPExpand = false;
    protected boolean bDGAutoLoad = true;

    public GridViewExModel() {
        this.RegisterCtrlModel("spex", this.spExModel);
        this.RegisterCtrlModel("searchform", this.searchFormModel);
    }

    public SPExModel getSPExModel() {
        return this.spExModel;
    }

    public SearchFormModel getSearchFormModel() {
        return this.searchFormModel;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("gridviewexid", (Object)this.getGridViewExId());
        jo.put("spautoexpand", this.getSPExpand());
        jo.put("dgautoload", this.getDGAutoLoad());
    }

    public String getGridViewExId() {
        return this.strGridViewExId;
    }

    public void setGridViewExId(String strGridViewExId) {
        this.strGridViewExId = strGridViewExId;
    }

    public boolean getSPExpand() {
        return this.bSPExpand;
    }

    public void setSPExpand(boolean bSPExpand) {
        this.bSPExpand = bSPExpand;
    }

    public boolean getDGAutoLoad() {
        return this.bDGAutoLoad;
    }

    public void setDGAutoLoad(boolean bDGAutoLoad) {
        this.bDGAutoLoad = bDGAutoLoad;
    }
}

