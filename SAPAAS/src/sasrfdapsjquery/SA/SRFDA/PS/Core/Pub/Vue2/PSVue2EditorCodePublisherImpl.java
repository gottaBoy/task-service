/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import java.util.HashMap;

public class PSVue2EditorCodePublisherImpl
extends PSPFEditorCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        PSVue2TemplHelper.fillParams(params);
        super.onFillGenerateCodeParams(params);
    }
}

