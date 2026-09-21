/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue.PSVueFileNameMethod;
import SA.SRFDA.PS.Core.Pub.Vue.PSVueTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSVueAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSVueFileNameMethod psIonicFileNameMethod = new PSVueFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSVueTemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("vfilename", psIonicFileNameMethod);
    }
}

