/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2FileNameMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2PanelItemLogicMethod;
import java.util.HashMap;

public class PSVue2PFEditorCodePublisherImpl
extends PSPFEditorCodePublisherImpl {
    private static PSVue2FileNameMethod psVue2PCFileNameMethod = new PSVue2FileNameMethod();
    private static PSVue2PanelItemLogicMethod psVue2PanelItemLogicMethod = new PSVue2PanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        params.put("filename", psVue2PCFileNameMethod);
        params.put("srfpanelitemlogic", psVue2PanelItemLogicMethod);
    }
}

