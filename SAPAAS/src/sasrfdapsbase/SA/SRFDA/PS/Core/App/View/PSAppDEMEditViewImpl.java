/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMEditView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMEDITVIEW9"})
public class PSAppDEMEditViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDEMEditView {
    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
    }

    @Override
    protected boolean isIgnoreMDViewCheck() {
        return true;
    }
}

