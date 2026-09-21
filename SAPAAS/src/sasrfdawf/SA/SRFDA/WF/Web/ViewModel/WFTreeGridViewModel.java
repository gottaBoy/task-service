/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.TabViewModel
 */
package SA.SRFDA.WF.Web.ViewModel;

import SA.SRFDA.WF.Web.ViewModel.WFBaseTreeGridViewModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;

public class WFTreeGridViewModel
extends WFBaseTreeGridViewModel {
    protected TabViewModel tabViewModel = new TabViewModel();

    public WFTreeGridViewModel() {
        this.RegisterCtrlModel("tabview", (ControlModel)this.tabViewModel);
    }

    public TabViewModel getTabViewModel() {
        return this.tabViewModel;
    }
}

