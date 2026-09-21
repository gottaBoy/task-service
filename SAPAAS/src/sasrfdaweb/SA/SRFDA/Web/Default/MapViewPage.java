/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.MapViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;

public class MapViewPage
extends BaseMainPage {
    protected MapViewModel mapViewModel = null;

    @Override
    protected PageModel CreatePageModel() {
        return new MapViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.mapViewModel = (MapViewModel)this.pageModel;
    }
}

