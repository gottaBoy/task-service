/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.TreePageModel
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.TabViewModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.TreePageModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import net.sf.json.JSONObject;

public class NDMainViewModel
extends TreePageModel {
    protected TabViewModel tabViewModel = new TabViewModel();

    public NDMainViewModel() {
        this.RegisterCtrlModel("tabview", (ControlModel)this.tabViewModel);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }
}

