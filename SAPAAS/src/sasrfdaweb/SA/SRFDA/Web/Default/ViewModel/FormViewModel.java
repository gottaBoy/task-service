/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.BaseEditViewModel;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;

public class FormViewModel
extends BaseEditViewModel {
    protected DPExModel dpExModel = new DPExModel();
    protected FormModel formModel = null;

    public FormViewModel() {
        this.RegisterCtrlModel("dpex", this.dpExModel);
        this.formModel = new FormModel();
        this.RegisterCtrlModel("form", this.formModel);
    }

    public DPExModel getDPExModel() {
        return this.dpExModel;
    }

    public FormModel getFormModel() {
        return this.formModel;
    }
}

