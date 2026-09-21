/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.ReactMob;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.ReactMob.PSReactMobFileNameMethod;
import SA.SRFDA.PS.Core.Pub.ReactMob.PSReactMobTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSReactMobAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSReactMobFileNameMethod psIonicFileNameMethod = new PSReactMobFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSReactMobTemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("filename", psIonicFileNameMethod);
    }
}

