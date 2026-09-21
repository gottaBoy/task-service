/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppErrorView;
import SA.SRFDA.PS.Core.App.View.PSAppUtilViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppUtilView", typevalues={"APPERRORVIEW"})
public class PSAppErrorViewImpl
extends PSAppUtilViewImpl
implements IPSAppErrorView {
    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u9519\u8bef\u4ee3\u7801", fields={"ERRCODE"})
    public String getErrorCode() {
        return this.psAppUtilView.getERRCODE();
    }
}

