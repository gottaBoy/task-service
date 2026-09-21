/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 */
package SA.TM.Web;

import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.TM.Web.ViewModel.TMToolViewModel;

public class TMToolPage
extends BaseMainPage {
    protected TMToolViewModel tmToolViewModel = null;

    protected PageModel CreatePageModel() {
        return new TMToolViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.tmToolViewModel = (TMToolViewModel)this.pageModel;
    }

    protected String OnGetPageCaption() {
        return "\u8d44\u6e90\u6392\u7a0b\u5de5\u5177\u89c6\u56fe";
    }

    protected String OnGetPageTitle() {
        return "\u8d44\u6e90\u6392\u7a0b\u5de5\u5177\u89c6\u56fe";
    }
}

