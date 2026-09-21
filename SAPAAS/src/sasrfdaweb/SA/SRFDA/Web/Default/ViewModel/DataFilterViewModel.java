/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.DataFilterModel;

public class DataFilterViewModel
extends MainViewModel {
    protected DataFilterModel dataFilterModel = new DataFilterModel();

    public DataFilterViewModel() {
        this.RegisterCtrlModel("datafilter", this.dataFilterModel);
    }

    public DataFilterModel getDataFilterModel() {
        return this.dataFilterModel;
    }
}

