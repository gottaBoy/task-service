/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2LogicMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2LogicNodeMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2PanelItemLogicMethod;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import java.util.HashMap;

public class PSVue2CtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    private static PSVue2LogicMethod psVue2LogicMethod = new PSVue2LogicMethod();
    private static PSVue2LogicNodeMethod psVue2LogicNodeMethod = new PSVue2LogicNodeMethod();
    private static PSVue2PanelItemLogicMethod psVue2PanelItemLogicMethod = new PSVue2PanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        params.put("srfpanellogic", psVue2LogicMethod);
        params.put("srflogicnode", psVue2LogicNodeMethod);
        params.put("srfpanelitemlogic", psVue2PanelItemLogicMethod);
        PSVue2TemplHelper.fillParams(params);
    }
}

