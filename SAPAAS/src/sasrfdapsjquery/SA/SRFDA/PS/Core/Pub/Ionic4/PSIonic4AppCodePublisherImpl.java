/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIonic4AppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSIonic4TemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
    }
}

