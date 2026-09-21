/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.VueMob;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSVueMobCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSFR7TemplHelper.fillParams(params);
    }
}

