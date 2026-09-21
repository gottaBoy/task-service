/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEDashboardView;
import SA.SRFDA.PS.Core.App.View.PSAppDESearchViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEPORTALVIEW", "DEPORTALVIEW9"})
public class PSAppDEDashboardViewImpl
extends PSAppDESearchViewImpl
implements IPSAppDEDashboardView {
    protected boolean bShowDataInfoBar = true;

    @Override
    protected void onInit() throws Exception {
        this.setEnableQuickSearchDefault(false);
        this.setExpandSearchFormDefault(true);
        this.bShowDataInfoBar = !this.psViewBase.isVIEWPARAM6Null() ? this.psViewBase.getVIEWPARAM6() : this.isShowDataInfoBarDefault();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4fe1\u606f\u680f")
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    protected boolean isShowDataInfoBarDefault() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

