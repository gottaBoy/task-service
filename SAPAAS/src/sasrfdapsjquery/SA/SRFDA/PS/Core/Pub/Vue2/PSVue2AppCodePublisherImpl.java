/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2FileNameMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSVue2AppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSVue2FileNameMethod psPreViewPCFileNameMethod = new PSVue2FileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSVue2TemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("filename", psPreViewPCFileNameMethod);
    }
}

