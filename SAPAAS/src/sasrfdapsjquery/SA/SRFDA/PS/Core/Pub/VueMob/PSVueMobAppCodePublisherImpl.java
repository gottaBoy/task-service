/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.VueMob;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.VueMob.PSVueMobFileNameMethod;
import java.util.ArrayList;
import java.util.HashMap;

public class PSVueMobAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSVueMobFileNameMethod psFileNameMethod = new PSVueMobFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSFR7TemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("classname", psFileNameMethod);
    }
}

