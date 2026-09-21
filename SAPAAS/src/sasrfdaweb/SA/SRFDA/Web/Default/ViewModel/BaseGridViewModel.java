/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.DGModel;

public class BaseGridViewModel
extends MainViewModel {
    protected DGModel dgModel = new DGModel();

    public BaseGridViewModel() {
        this.RegisterCtrlModel("datagrid", this.dgModel);
    }

    public DGModel getDGModel() {
        return this.dgModel;
    }
}

