/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSExtJSTemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSExtJS5CtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSExtJSTemplHelper.fillParams(params);
    }
}

