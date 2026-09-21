/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Ionic;

import SA.SRFDA.PS.Core.Pub.Ionic.PSIonicFileNameMethod;
import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIonicAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSIonicFileNameMethod psIonicFileNameMethod = new PSIonicFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSFR7TemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("ionicclassname", psIonicFileNameMethod);
    }
}

