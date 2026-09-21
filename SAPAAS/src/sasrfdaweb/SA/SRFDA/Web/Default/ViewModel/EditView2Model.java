/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.FormViewModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;

public class EditView2Model
extends FormViewModel {
    protected TabViewModel tabViewModel = new TabViewModel();

    public EditView2Model() {
        this.RegisterCtrlModel("tabview", this.tabViewModel);
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }
}

