/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewFileNameMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewPanelItemLogicMethod;
import java.util.HashMap;

public class PSPreviewPFEditorCodePublisherImpl
extends PSPFEditorCodePublisherImpl {
    private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();
    private static PSPreviewPanelItemLogicMethod psPreviewPanelItemLogicMethod = new PSPreviewPanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        params.put("filename", psPreViewPCFileNameMethod);
        params.put("srfpanelitemlogic", psPreviewPanelItemLogicMethod);
    }
}

