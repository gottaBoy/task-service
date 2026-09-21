/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.ReactMob;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.ReactMob.PSReactMobTemplHelper;
import java.util.HashMap;

public class PSReactMobCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSReactMobTemplHelper.fillParams(params);
    }
}

