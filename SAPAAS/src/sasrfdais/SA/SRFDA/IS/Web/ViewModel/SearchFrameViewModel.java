/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFDA.Web.ViewModel.SearchFormModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.IS.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFDA.Web.ViewModel.SearchFormModel;
import net.sf.json.JSONObject;

public class SearchFrameViewModel
extends MainViewModel {
    protected SearchFormModel searchFormModel = new SearchFormModel();
    protected SPExModel spExModel = new SPExModel();

    public SearchFrameViewModel() {
        this.RegisterCtrlModel("spex", (ControlModel)this.spExModel);
        this.RegisterCtrlModel("searchform", (ControlModel)this.searchFormModel);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
    }

    public SPExModel getSPExModel() {
        return this.spExModel;
    }

    public SearchFormModel getSearchFormModel() {
        return this.searchFormModel;
    }
}

