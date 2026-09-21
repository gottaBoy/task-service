/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEReportView;
import SA.SRFDA.PS.Core.App.View.PSAppDESearchViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEREPORTVIEW"})
public class PSAppDEReportViewImpl
extends PSAppDESearchViewImpl
implements IPSAppDEReportView {
    @Override
    protected void onInit() throws Exception {
        this.setExpandSearchFormDefault(true);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

