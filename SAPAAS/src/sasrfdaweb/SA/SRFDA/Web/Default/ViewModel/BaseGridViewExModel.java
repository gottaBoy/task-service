/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.DGExModel;

public class BaseGridViewExModel
extends MainViewModel {
    protected DGExModel dgExModel = new DGExModel();

    public BaseGridViewExModel() {
        this.RegisterCtrlModel("datagridex", this.dgExModel);
    }

    public DGExModel getDGExModel() {
        return this.dgExModel;
    }
}

