/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4LogicMethod;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4LogicNodeMethod;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4PanelItemLogicMethod;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;
import java.util.HashMap;

public class PSIonic4CtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    private static PSIonic4LogicMethod psIonic4LogicMethod = new PSIonic4LogicMethod();
    private static PSIonic4LogicNodeMethod psIonic4LogicNodeMethod = new PSIonic4LogicNodeMethod();
    private static PSIonic4PanelItemLogicMethod psIonic4PanelItemLogicMethod = new PSIonic4PanelItemLogicMethod();

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        params.put("srfpanellogic", psIonic4LogicMethod);
        params.put("srflogicnode", psIonic4LogicNodeMethod);
        params.put("srfpanelitemlogic", psIonic4PanelItemLogicMethod);
        PSIonic4TemplHelper.fillParams(params);
    }
}

