/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.BaseEditViewModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;

public class EditViewModel
extends BaseEditViewModel {
    protected TabViewModel tabViewModel = new TabViewModel();

    public EditViewModel() {
        this.RegisterCtrlModel("tabview", this.tabViewModel);
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }
}

