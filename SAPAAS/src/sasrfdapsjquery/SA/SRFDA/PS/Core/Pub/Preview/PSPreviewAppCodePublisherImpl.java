/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewFileNameMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewTemplHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSPreviewAppCodePublisherImpl
extends PSPFAppCodePublisherImpl {
    private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSPreviewTemplHelper.fillParams(params);
        HashMap requireClassMap = new HashMap();
        ArrayList requireClasses = new ArrayList();
        requireClasses.addAll(requireClassMap.keySet());
        params.put("requires", requireClasses);
        params.put("filename", psPreViewPCFileNameMethod);
    }
}

