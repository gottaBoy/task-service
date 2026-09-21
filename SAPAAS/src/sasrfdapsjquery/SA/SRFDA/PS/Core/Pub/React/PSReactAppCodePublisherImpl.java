/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.React;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.React.PSReactTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSReactAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSReactTemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
    }
}

