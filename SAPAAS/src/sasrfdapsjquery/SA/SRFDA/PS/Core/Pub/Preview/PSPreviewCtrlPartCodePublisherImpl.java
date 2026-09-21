/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewLogicMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewLogicNodeMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewPanelItemLogicMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewTemplHelper;
import java.util.HashMap;

public class PSPreviewCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    private static PSPreviewLogicMethod psPreviewLogicMethod = new PSPreviewLogicMethod();
    private static PSPreviewLogicNodeMethod psPreviewLogicNodeMethod = new PSPreviewLogicNodeMethod();
    private static PSPreviewPanelItemLogicMethod psPreviewPanelItemLogicMethod = new PSPreviewPanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        params.put("srfpanellogic", psPreviewLogicMethod);
        params.put("srflogicnode", psPreviewLogicNodeMethod);
        params.put("srfpanelitemlogic", psPreviewPanelItemLogicMethod);
        PSPreviewTemplHelper.fillParams(params);
    }
}

