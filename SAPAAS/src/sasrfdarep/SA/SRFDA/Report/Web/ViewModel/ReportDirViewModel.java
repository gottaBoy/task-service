/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.TreePageModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import net.sf.json.JSONObject;

public class ReportDirViewModel
extends TreePageModel {
    private int nLeftDockWidth = 0;

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("leftdockwidth", this.nLeftDockWidth);
    }

    public int getLeftDockWidth() {
        return this.nLeftDockWidth;
    }

    public void setLeftDockWidth(int nLeftDockWidth) {
        this.nLeftDockWidth = nLeftDockWidth;
    }
}

