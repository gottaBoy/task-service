/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRBar;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSJQCtrlCodePublisherImpl;
import java.util.HashMap;

public class PSJQDRBarViewCodePublisherImpl
extends PSJQCtrlCodePublisherImpl {
    protected IPSDRBar iPSDRBar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDRBar = (IPSDRBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        this.iPSDRBar = null;
        super.onClose();
    }
}

