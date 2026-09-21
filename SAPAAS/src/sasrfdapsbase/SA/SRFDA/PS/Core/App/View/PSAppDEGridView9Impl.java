/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEGridViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGRIDVIEW9"})
public class PSAppDEGridView9Impl
extends PSAppDEGridViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableQuickSearchDefault(false);
        super.onInit();
    }
}

