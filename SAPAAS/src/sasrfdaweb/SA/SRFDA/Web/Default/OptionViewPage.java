/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.EditViewPage2;
import SA.SRFDA.Web.Default.ViewModel.OptionViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;

public class OptionViewPage
extends EditViewPage2 {
    protected OptionViewModel optionViewModel = null;

    @Override
    protected PageModel CreatePageModel() {
        return new OptionViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.optionViewModel = (OptionViewModel)this.pageModel;
    }
}

